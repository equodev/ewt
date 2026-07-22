import 'package:flutter/widgets.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:widgets_web/widgets_web.dart';

void main() {
  tearDown(() => ewtActiveCallbackSink = null);

  test('ewtWireCallback sends the id with no args', () {
    final calls = <List<Object?>>[];
    ewtActiveCallbackSink = (id, args) => calls.add([id, args]);
    ewtWireCallback(7)();
    expect(calls, [[7, const []]]);
  });

  test('ewtWireValueCallback sends the id with the value arg', () {
    final calls = <List<Object?>>[];
    ewtActiveCallbackSink = (id, args) => calls.add([id, args]);
    ewtWireValueCallback(3)(true);
    expect(calls, [[3, [true]]]);
  });

  test('helpers capture the sink at wire time, not call time', () {
    final calls = <Object?>[];
    ewtActiveCallbackSink = (id, args) => calls.add(args);
    final z = ewtWireCallback(1);
    final v = ewtWireValueCallback(2);
    ewtActiveCallbackSink = null;
    z();
    v('hi');
    expect(calls, [const [], ['hi']]);
  });

  test('non-int id yields inert no-ops (no throw)', () {
    ewtActiveCallbackSink = (_, __) => fail('must not fire');
    expect(() => ewtWireCallback(null)(), returnsNormally);
    expect(() => ewtWireValueCallback(null)('x'), returnsNormally);
  });
}
