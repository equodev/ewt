import 'dart:io';
import 'package:flutter/widgets.dart';

/// TCP port on which Dart listens for hot-reload signals from the JDI client.
const int _hotReloadPort = 5006;

ServerSocket? _server;

/// Starts the TCP listener for hot-reload signals. Idempotent: the first call
/// binds the socket, subsequent calls are no-ops.
///
/// Must be called after WidgetsBinding is initialized. Fails silently if the
/// port is already in use (e.g. another instance of the app is running) — the
/// app still starts, but hot-reload will not fire.
Future<void> initHotReloadServer() async {
  if (_server != null) return;
  try {
    _server = await ServerSocket.bind(
      InternetAddress.loopbackIPv4,
      _hotReloadPort,
      shared: false,
    );
  } on SocketException catch (e) {
    print('[EWT] Hot-reload server could not bind port $_hotReloadPort: $e');
    return;
  }
  print('[EWT] Hot-reload server listening on localhost:$_hotReloadPort');
  _server!.listen((client) {
    client.destroy();
    final binding = WidgetsBinding.instance;
    // reassembleApplication schedules a frame and fires reassemble on the
    // entire State tree — including our HotReloadRoot.
    binding.reassembleApplication();
  });
}
