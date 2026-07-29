import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:widgets_web/widgets_web.dart';

// Uncontrolled TextField: the whole widget was blocked by its optional
// selectionWidthStyle/selectionHeightStyle (BoxWidthStyle/BoxHeightStyle), which are
// not importable in the pure-Dart decoder. The decoder now omits them and the field
// uses its defaults; onChanged/onSubmitted wire to the value-callback sink.
void main() {
  tearDown(() => ewtActiveCallbackSink = null);

  test('TextField decodes (selection*Style omitted) and onChanged wires to the sink', () {
    final calls = <List<Object?>>[];
    ewtActiveCallbackSink = (id, args) => calls.add([id, args]);
    final node = {
      't': 'textFieldTextField', 'id': 1,
      'p': {'onChanged': 7},
    };
    final w = decodeEwtNode(node);
    expect(w, isA<TextField>());
    (w as TextField).onChanged!('hello'); // a keystroke would call this with the buffer
    expect(calls, [
      [7, ['hello']]
    ]);
  });

  test('TextField onSubmitted (Enter) is also a String value callback', () {
    final calls = <List<Object?>>[];
    ewtActiveCallbackSink = (id, args) => calls.add([id, args]);
    final node = {
      't': 'textFieldTextField', 'id': 2,
      'p': {'onSubmitted': 9},
    };
    final w = decodeEwtNode(node) as TextField;
    expect(w.onSubmitted, isNotNull);
    w.onSubmitted!('done');
    expect(calls, [
      [9, ['done']]
    ]);
  });
}
