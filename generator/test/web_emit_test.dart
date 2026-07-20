import 'dart:io';
import 'package:test/test.dart';

// The generator writes SerializingWidgetConstructors.java to the ewt.api tree. This test runs the
// generator (assumed already run by the build) and asserts the emitted recorder shapes.
String _java() => File('../ewt.api/src/main/java/dev/equo/ewt/SerializingWidgetConstructors.java')
    .readAsStringSync();

void main() {
  test('emits a scalar recorder for textText', () {
    final s = _java();
    expect(s, contains('MemorySegment textText('));
    expect(s, contains('p.put("data", data)'));
    expect(s, contains('record(id, "textText", p)'));
  });

  test('emits enum-as-ordinal', () {
    final s = _java();
    expect(s, contains('.ordinal()'));
  });

  test('emits object-ref and list via byId lookup', () {
    final s = _java();
    expect(s, contains('byId.get('));
  });

  test('emits a reserved callback id', () {
    final s = _java();
    expect(s, contains('nextCallbackId'));
  });
}
