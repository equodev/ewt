// Native (desktop) builder for an EWT region — transport-aware.
//
// java-11 split: on a pre-22 JVM EWT has no FFM, so it serializes the subtree over Evolve's comm and
// the desktop engine renders it with the comm-fed EwtWebRegion (widgets_web decoders). On java>=22
// EWT registers an FFM builder instead, and the FFI region (callToBuildWidgetTree) must be used —
// calling into the FFM bridge is only safe there.
//
// The Java side announces the transport per region over the comm Evolve already runs on desktop.
// This region defaults to comm (safe on any JVM — it just waits for a subtree) and switches to the
// FFI region only when Java explicitly announces "ffm". So one native bundle serves both java<22
// (comm) and java>=22 (FFM) desktop without ever calling the FFM bridge on a JVM that lacks it.
import 'dart:convert';
import 'dart:typed_data';

import 'package:flutter/widgets.dart';
import 'package:swtflutter/src/comm/comm.dart';

import 'ewt_web/ewt_channel_owner.dart';
import 'ewt_web/ewt_web_region.dart';
import 'ewt_region_ffi.dart' as ffi;

Widget buildEwtRegion(int id) => _EwtNativeRegion(id: id);

class _EwtNativeRegion extends StatefulWidget {
  final int id;
  const _EwtNativeRegion({required this.id});

  @override
  State<_EwtNativeRegion> createState() => _EwtNativeRegionState();
}

class _EwtNativeRegionState extends State<_EwtNativeRegion> {
  // null = unknown -> render comm (safe on any JVM); "ffm" = java>=22 -> use the FFI region.
  String? _transport;
  late final String _channel = 'EwtWidget/${widget.id}/transport';

  @override
  void initState() {
    super.initState();
    ewtChannels.subscribe(_channel, this, _onTransport);
    // Ask Java to (re)send the transport, in case its first announcement flushed before we subscribed.
    EquoCommService.send('$_channel/request');
  }

  void _onTransport(Uint8List bytes) {
    final t = utf8.decode(bytes);
    if (t != _transport && mounted) setState(() => _transport = t);
  }

  @override
  void dispose() {
    ewtChannels.unsubscribe(_channel, this);
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    if (_transport == 'ffm') return ffi.buildEwtRegion(widget.id);
    return EwtWebRegion(id: widget.id);
  }
}
