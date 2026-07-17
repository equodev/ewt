// JSON → Flutter widget decoders for the EWT web path. Phase 0 covers Text and SizedBox;
// the construction calls mirror EWT's FFI factory bodies so a later phase can generate them.
import 'package:flutter/material.dart';

Widget decodeEwtNode(Map<String, dynamic> node) {
  final type = node['t'] as String;
  final p = (node['p'] as Map).cast<String, dynamic>();
  final c = (node['c'] as List).cast<Map>().map((m) => m.cast<String, dynamic>()).toList();
  switch (type) {
    case 'Text':
      return Text(p['data'] as String);
    case 'SizedBox':
      return SizedBox(
        width: (p['width'] as num?)?.toDouble(),
        height: (p['height'] as num?)?.toDouble(),
        child: c.isEmpty ? null : decodeEwtNode(c.first),
      );
    default:
      debugPrint('EWT web: unknown node type "$type"');
      return const SizedBox.shrink();
  }
}
