import 'dart:async';
import 'dart:typed_data';

import 'package:swtflutter/src/comm/comm.dart';

typedef BytesHandler = FutureOr<void> Function(Uint8List bytes);

/// Per-channel subscriptions that only their current owner can drop.
///
/// Evolve's comm keeps one raw handler per channel and `remove` drops whichever is registered.
/// When Flutter re-mounts a region (the new State subscribes before the old one is disposed), the
/// old State's `dispose` would unsubscribe the new one, and every later frame on that channel would
/// go unheard: the region stays empty with no error. Only the State that subscribed last unsubscribes.
class ChannelOwners {
  final void Function(String channel, BytesHandler handler) _subscribe;
  final void Function(String channel) _unsubscribe;
  final Map<String, Object> _owners = {};

  ChannelOwners(this._subscribe, this._unsubscribe);

  void subscribe(String channel, Object owner, BytesHandler handler) {
    _owners[channel] = owner;
    _subscribe(channel, handler);
  }

  void unsubscribe(String channel, Object owner) {
    if (!identical(_owners[channel], owner)) return;
    _owners.remove(channel);
    _unsubscribe(channel);
  }
}

final ChannelOwners ewtChannels = ChannelOwners(
  (channel, handler) => EquoCommService.onBytes(channel, handler),
  (channel) => EquoCommService.remove(channel),
);
