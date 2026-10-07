// Applies a patch to a retained EWT node tree. Pure Dart, comm-free: the region keeps the last
// decoded node map and mutates only the nodes named by each op's structural path. A path step is
// a String (a key into the current node's 'p') or an int (an index into a list-valued param).
// An op carries 'set' (primitive params merged into the node at the path), 'node' (a whole node
// put in place of the one at the path, subtree included) or 'list' (a splice: 'remove' elements
// at 'at' taken out of the list-valued param 'list' of the node at the path, 'insert' put there).
// Ops apply in order, so a later op's indices see what an earlier splice did. Throws if a path
// fails to resolve, so the region can request a full resend.
//
// The root is deep-copied before any mutation so that a partial failure leaves the original tree
// untouched — the caller can then request a full resend instead of diffing against a corrupt tree.

Map<String, dynamic> _deepCopy(Map<String, dynamic> m) => m.map((k, v) {
      if (v is Map<String, dynamic>) return MapEntry(k, _deepCopy(v));
      if (v is List) {
        return MapEntry(
            k,
            v
                .map((e) => e is Map<String, dynamic> ? _deepCopy(e) : e)
                .toList());
      }
      return MapEntry(k, v);
    });

Map<String, dynamic> applyPatch(Map<String, dynamic> root, List<dynamic> ops) {
  final copy = _deepCopy(root);
  for (final raw in ops) {
    final op = raw as Map<String, dynamic>;
    final path = op['path'] as List<dynamic>;
    final replacement = op['node'];
    if (replacement != null) {
      _replace(copy, path, (replacement as Map).cast<String, dynamic>());
      continue;
    }
    final listKey = op['list'];
    if (listKey != null) {
      _splice(copy, path, listKey as String, op['at'] as int, op['remove'] as int,
          (op['insert'] as List).map((e) => (e as Map).cast<String, dynamic>()).toList());
      continue;
    }
    final node = _resolve(copy, path);
    final params = (node['p'] as Map).cast<String, dynamic>();
    (op['set'] as Map).cast<String, dynamic>().forEach((k, v) => params[k] = v);
  }
  return copy;
}

Map<String, dynamic> _resolve(Map<String, dynamic> root, List<dynamic> path) {
  dynamic cur = root;
  for (final step in path) {
    cur = _step(cur, step);
    if (cur == null) throw StateError('EWT patch: unresolved path $path');
  }
  return (cur as Map).cast<String, dynamic>();
}

dynamic _step(dynamic cur, dynamic step) =>
    step is String ? (cur as Map)['p'][step] : (cur as List)[step as int];

/// Takes [remove] elements at [at] out of the list param [key] of the node at [path] and puts
/// [insert] there.
void _splice(Map<String, dynamic> root, List<dynamic> path, String key, int at, int remove,
    List<Map<String, dynamic>> insert) {
  final owner = _resolve(root, path);
  final list = (owner['p'] as Map)[key];
  if (list is! List || at < 0 || remove < 0 || at + remove > list.length) {
    throw StateError('EWT patch: unresolved splice at $path/$key[$at,+$remove]');
  }
  list.replaceRange(at, at + remove, insert);
}

/// Puts [node] where [path] points. The root itself is never replaced this way: a root that
/// changed shape arrives as a full snapshot.
void _replace(Map<String, dynamic> root, List<dynamic> path, Map<String, dynamic> node) {
  if (path.isEmpty) throw StateError('EWT patch: replace at the root');
  final last = path.last;
  if (last is String) {
    // [..., key]: the node is a param of its owner.
    final owner = _resolve(root, path.sublist(0, path.length - 1));
    final params = (owner['p'] as Map).cast<String, dynamic>();
    if (!params.containsKey(last)) throw StateError('EWT patch: unresolved path $path');
    params[last] = node;
    return;
  }
  // [..., key, index]: the node is an element of a list-valued param of its owner.
  if (path.length < 2 || path[path.length - 2] is! String) {
    throw StateError('EWT patch: unresolved path $path');
  }
  final owner = _resolve(root, path.sublist(0, path.length - 2));
  final list = (owner['p'] as Map)[path[path.length - 2]];
  final index = last as int;
  if (list is! List || index < 0 || index >= list.length) {
    throw StateError('EWT patch: unresolved path $path');
  }
  list[index] = node;
}
