// Applies a param-only patch to a retained EWT node tree. Pure Dart, comm-free: the region
// keeps the last decoded node map and mutates only the nodes named by each op's structural path.
// A path step is a String (a key into the current node's 'p') or an int (an index into a
// list-valued param). Throws if a path fails to resolve, so the region can request a full resend.

Map<String, dynamic> applyPatch(Map<String, dynamic> root, List<dynamic> ops) {
  for (final raw in ops) {
    final op = raw as Map<String, dynamic>;
    final node = _resolve(root, op['path'] as List<dynamic>);
    final params = (node['p'] as Map).cast<String, dynamic>();
    (op['set'] as Map).cast<String, dynamic>().forEach((k, v) => params[k] = v);
  }
  return root;
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
