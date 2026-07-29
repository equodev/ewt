// Applies a param-only patch to a retained EWT node tree. Pure Dart, comm-free: the region
// keeps the last decoded node map and mutates only the nodes named by each op's structural path.
// A path step is a String (a key into the current node's 'p') or an int (an index into a
// list-valued param). Throws if a path fails to resolve, so the region can request a full resend.
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
    final node = _resolve(copy, op['path'] as List<dynamic>);
    final params = (node['p'] as Map).cast<String, dynamic>();
    (op['set'] as Map).cast<String, dynamic>().forEach((k, v) => params[k] = v);
  }
  return copy;
}

Map<String, dynamic> _resolve(Map<String, dynamic> root, List<dynamic> path) {
  dynamic cur = root;
  for (final step in path) {
    if (step is String) {
      cur = (cur as Map)['p'][step];
    } else {
      cur = (cur as List)[step as int];
    }
    if (cur == null) throw StateError('EWT patch: unresolved path $path');
  }
  return (cur as Map).cast<String, dynamic>();
}
