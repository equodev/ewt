// Universal decoder for an EWT node tree. Dispatches each node's factory name to its generated
// builder. Pure Dart — no dart:ffi — so the web build never pulls in the FFI plugin.
import 'package:flutter/material.dart';

import 'factories_web_gen.dart';

Object? decodeEwtNode(Map<String, dynamic> node) {
  final t = node['t'] as String;
  final p = (node['p'] as Map?)?.cast<String, dynamic>() ?? const {};
  final builder = webFactories[t];
  if (builder == null) {
    debugPrint('EWT web: no decoder for factory "$t"'
        '${unsupportedFactories.contains(t) ? " (unsupported param type)" : ""}');
    return null;
  }
  return builder(p);
}

Widget decodeEwtWidget(Map<String, dynamic> node) {
  final w = decodeEwtNode(node);
  return w is Widget ? w : const SizedBox.shrink();
}
