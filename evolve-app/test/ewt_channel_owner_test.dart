import 'dart:typed_data';

import 'package:ewt_evolve_app/ewt_web/ewt_channel_owner.dart';
import 'package:flutter_test/flutter_test.dart';

/// Like Evolve's comm: one raw handler per channel, and remove drops whichever is registered.
class FakeComm {
  final Map<String, BytesHandler> handlers = {};

  late final ChannelOwners owners = ChannelOwners(
    (channel, handler) => handlers[channel] = handler,
    (channel) => handlers.remove(channel),
  );

  void deliver(String channel) => handlers[channel]?.call(Uint8List(0));
}

void main() {
  const channel = 'EwtWidget/42/subtree';

  test('a re-mounted region keeps hearing its channel after the old one is disposed', () {
    final comm = FakeComm();
    final heard = <String>[];
    final oldRegion = Object(), newRegion = Object();

    comm.owners.subscribe(channel, oldRegion, (_) => heard.add('old'));
    comm.owners.subscribe(channel, newRegion, (_) => heard.add('new'));
    comm.owners.unsubscribe(channel, oldRegion);
    comm.deliver(channel);

    expect(heard, ['new']);
  });

  test('the owner unsubscribing drops the channel', () {
    final comm = FakeComm();
    final region = Object();

    comm.owners.subscribe(channel, region, (_) {});
    comm.owners.unsubscribe(channel, region);

    expect(comm.handlers.containsKey(channel), isFalse);
  });

  test('a region that never subscribed cannot drop another one', () {
    final comm = FakeComm();
    final region = Object();

    comm.owners.subscribe(channel, region, (_) {});
    comm.owners.unsubscribe(channel, Object());

    expect(comm.handlers.containsKey(channel), isTrue);
  });
}
