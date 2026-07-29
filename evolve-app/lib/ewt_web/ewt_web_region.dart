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

class _EwtWebRegionState extends State<EwtWebRegion>
    with TickerProviderStateMixin {
  Map<String, dynamic>? _root;
  late final String _subtreeChannel = 'EwtWidget/${widget.id}/subtree';
  late final String _animChannel = 'EwtWidget/${widget.id}/anim';

  /// Persists across rebuilds: maps Java ctrlId → live Dart AnimationController.
  final Map<int, AnimationController> _controllers = {};

  @override
  void initState() {
    super.initState();
    EquoCommService.onBytes(_subtreeChannel, _onSubtree);
    EquoCommService.onBytes(_animChannel, _onAnimCommand);
    // Ask the Java side to (re)send this region's subtree now that our handler is registered,
    // so a first frame flushed from the comm buffer before we subscribed is not lost.
    EquoCommService.send('$_subtreeChannel/request');
  }

  void _onSubtree(Uint8List bytes) {
    try {
      final env = json.decode(utf8.decode(bytes)) as Map<String, dynamic>;
      final outcome = applyEnvelope(_root, env);
      if (outcome.requestFull) {
        EquoCommService.send('$_subtreeChannel/request');
        return;
      }
      setState(() => _root = outcome.root);
    } catch (e, st) {
      debugPrint('EWT web region ${widget.id} subtree failed: $e\n$st');
      EquoCommService.send('$_subtreeChannel/request');
    }
  }

  void _onAnimCommand(Uint8List bytes) {
    try {
      final cmd = json.decode(utf8.decode(bytes)) as Map<String, dynamic>;
      final ctrlId = cmd['ctrlId'] as int;
      final action = cmd['action'] as String;
      final ctrl = _controllers[ctrlId];
      if (ctrl == null) {
        debugPrint('EWT web anim: unknown ctrlId=$ctrlId action=$action');
        return;
      }
      if (action.startsWith('setDuration:')) {
        final ms = int.parse(action.substring('setDuration:'.length));
        ctrl.duration = Duration(milliseconds: ms);
      } else if (action.startsWith('setReverseDuration:')) {
        final ms = int.parse(action.substring('setReverseDuration:'.length));
        ctrl.reverseDuration = Duration(milliseconds: ms);
      } else switch (action) {
        case 'forward': ctrl.forward();
        case 'reverse': ctrl.reverse();
        case 'repeat':         ctrl.repeat();
        case 'repeat:reverse': ctrl.repeat(reverse: true);
        case 'stop':           ctrl.stop();
        case 'reset':   ctrl.reset();
        default: debugPrint('EWT web anim: unknown action=$action');
      }
    } catch (e, st) {
      debugPrint('EWT web region ${widget.id} anim command failed: $e\n$st');
    }
  }

  @override
  void dispose() {
    EquoCommService.remove(_subtreeChannel);
    EquoCommService.remove(_animChannel);
    for (final c in _controllers.values) {
      c.dispose();
    }
    _controllers.clear();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final root = _root;
    if (root == null) return const SizedBox.shrink();
    // Bind region globals for the synchronous decode: callback sink, build context,
    // and the animated-state ticker/registry so controller factories can wire up.
    ewtActiveBuildContext = context;
    ewtActiveCallbackSink = (cid, args) =>
        EquoCommService.sendPayload('EwtWidget/${widget.id}/callback', [cid, ...args]);
    ewtActiveTickerProvider = this;
    ewtActiveControllerRegistry = _controllers;
    final Widget decoded;
    try {
      decoded = decodeEwtWidget(root);
    } finally {
      ewtActiveCallbackSink = null;
      ewtActiveBuildContext = null;
      ewtActiveTickerProvider = null;
      ewtActiveControllerRegistry = null;
    }
    return ClipRect(child: decoded);
  }
}
