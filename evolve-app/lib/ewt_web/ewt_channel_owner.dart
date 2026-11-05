import 'dart:async';
import 'dart:typed_data';

import 'package:swtflutter/src/comm/comm.dart';
import 'package:swtflutter/src/gen/widgets.dart' show wireChannelNames, wireTypeNames;

typedef BytesHandler = FutureOr<void> Function(Uint8List bytes);

/// EWT addresses its per-region channels by name (`EwtWidget/<id>/<name>`), which is Evolve's
/// `Type/id/name` wire addressing. Evolve's numeric comm needs the numbers the wire carries, so
/// these reverse the generated tables: the channel name's number, and the `EwtWidget` type's.
/// Both are generated together with Evolve's comm, so an EWT name that has no number is a build
/// mistake (the channel was not registered in the generator) and throws here, not silently drops.
final Map<String, int> _channelNumber = {
  for (final e in wireChannelNames.entries) e.value: e.key,
};
final int _ewtType = {
  for (final e in wireTypeNames.entries) e.value: e.key,
}['EwtWidget']!;

/// A parsed `EwtWidget/<id>/<name>` address, as the numbers Evolve's comm carries. The channel
/// name — the part after the id — may itself contain a slash (`subtree/request`).
class EwtAddr {
  final int type;
  final int id;
  final int channel;
  const EwtAddr(this.type, this.id, this.channel);

  factory EwtAddr.of(String event) {
    final first = event.indexOf('/');
    final second = event.indexOf('/', first + 1);
    final id = int.parse(event.substring(first + 1, second));
    final channel = _channelNumber[event.substring(second + 1)]!;
    return EwtAddr(_ewtType, id, channel);
  }
}

/// Sends on an EWT channel named `EwtWidget/<id>/<name>`, the String ergonomics the region code
/// keeps, over Evolve's numeric comm. A null payload is a bare signal (e.g. a resend request).
void ewtSend(String channel, [Object? payload]) {
  final a = EwtAddr.of(channel);
  EquoCommService.sendTo(a.type, a.id, a.channel, payload);
}

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
  (channel, handler) {
    final a = EwtAddr.of(channel);
    EquoCommService.onBytes(a.type, a.id, a.channel, handler);
  },
  (channel) {
    final a = EwtAddr.of(channel);
    EquoCommService.remove(a.type, a.id, a.channel);
  },
);
