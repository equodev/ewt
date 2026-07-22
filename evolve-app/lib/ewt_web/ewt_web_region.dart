// A comm-fed EWT region: subscribes to Evolve's per-region subtree channel and rebuilds
// the EWT subtree from the serialized node tree. Contains failures to this region.
import 'dart:convert';
import 'dart:typed_data';

import 'package:flutter/material.dart';
import 'package:swtflutter/src/comm/comm.dart';
import 'package:widgets_web/widgets_web.dart';

class EwtWebRegion extends StatefulWidget {
  final int id;
  const EwtWebRegion({super.key, required this.id});

  @override
  State<EwtWebRegion> createState() => _EwtWebRegionState();
}

class _EwtWebRegionState extends State<EwtWebRegion> {
  Map<String, dynamic>? _root;
  late final String _channel = 'EwtWidget/${widget.id}/subtree';

  @override
  void initState() {
    super.initState();
    EquoCommService.onBytes(_channel, _onSubtree);
    // Ask the Java side to (re)send this region's subtree now that our handler is registered,
    // so a first frame flushed from the comm buffer before we subscribed is not lost.
    EquoCommService.send('$_channel/request');
  }

  void _onSubtree(Uint8List bytes) {
    try {
      final decoded = json.decode(utf8.decode(bytes)) as Map<String, dynamic>;
      setState(() => _root = decoded);
    } catch (e, st) {
      debugPrint('EWT web region ${widget.id} decode failed: $e\n$st');
    }
  }

  @override
  void dispose() {
    EquoCommService.remove(_channel);
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final root = _root;
    if (root == null) return const SizedBox.shrink();
    // Bind this region's callback sink for the duration of the (synchronous) decode, so every
    // wired closure in the built tree forwards its id to THIS region's channel.
    ewtActiveBuildContext = context;
    ewtActiveCallbackSink = (cid, args) =>
        EquoCommService.sendPayload('EwtWidget/${widget.id}/callback', [cid, ...args]);
    final decoded = decodeEwtWidget(root);
    ewtActiveCallbackSink = null;
    ewtActiveBuildContext = null;
    return ClipRect(child: decoded);
  }
}
