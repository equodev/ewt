// A comm-fed EWT region: subscribes to Evolve's per-region subtree channel and rebuilds
// the EWT subtree from the serialized node tree. Contains failures to this region.
import 'dart:convert';
import 'dart:typed_data';

import 'package:flutter/material.dart';
import 'package:swtflutter/src/comm/comm.dart';
import 'package:widgets_web/widgets_web.dart';

/// Outcome of applying one transport envelope: the new retained root, and whether the region
/// must ask Java for a full resend (patch arrived with no base, or a path failed to resolve).
class EnvelopeOutcome {
  final Map<String, dynamic>? root;
  final bool requestFull;
  const EnvelopeOutcome(this.root, this.requestFull);
}

EnvelopeOutcome applyEnvelope(
    Map<String, dynamic>? root, Map<String, dynamic> env) {
  final kind = env['kind'];
  if (kind == 'full') {
    return EnvelopeOutcome((env['node'] as Map).cast<String, dynamic>(), false);
  }
  if (kind == 'patch') {
    if (root == null) return EnvelopeOutcome(null, true);
    return EnvelopeOutcome(applyPatch(root, env['ops'] as List<dynamic>), false);
  }
  return EnvelopeOutcome(root, true); // unknown kind -> desync, request a full snapshot
}

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
      final env = json.decode(utf8.decode(bytes)) as Map<String, dynamic>;
      final outcome = applyEnvelope(_root, env);
      if (outcome.requestFull) {
        EquoCommService.send('$_channel/request');
        return;
      }
      setState(() => _root = outcome.root);
    } catch (e, st) {
      debugPrint('EWT web region ${widget.id} subtree failed: $e\n$st');
      EquoCommService.send('$_channel/request'); // desync -> ask for a fresh full snapshot
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
