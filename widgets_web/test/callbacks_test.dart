// ignore_for_file: avoid_print
import 'package:flutter/widgets.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:widgets_web/widgets_web.dart';

void main() {
  tearDown(() => ewtActiveCallbackSink = null);

  test('ewtWireCallback binds the active sink and forwards the id', () {
    final fired = <int>[];
    ewtActiveCallbackSink = fired.add;
    final VoidCallback cb = ewtWireCallback(7);
    cb();
    expect(fired, [7]);
  });

  test('ewtWireCallback captures the sink at wire time, not call time', () {
    final a = <int>[];
    ewtActiveCallbackSink = a.add;
    final VoidCallback cb = ewtWireCallback(3);
    ewtActiveCallbackSink = null; // region finished decoding
    cb();
    expect(a, [3]); // still delivered to the sink captured during decode
  });

  test('non-int id yields an inert no-op (no throw)', () {
    ewtActiveCallbackSink = (_) => fail('must not fire');
    expect(() => ewtWireCallback(null)(), returnsNormally);
  });
}
