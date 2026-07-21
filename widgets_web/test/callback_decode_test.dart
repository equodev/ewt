import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:widgets_web/widgets_web.dart';

void main() {
  tearDown(() => ewtActiveCallbackSink = null);

  test('FilledButton onPressed decodes to a wired closure that sends [id]', () {
    final calls = <List<Object?>>[];
    ewtActiveCallbackSink = (id, args) => calls.add([id, args]);
    final node = {
      't': 'filledButtonFilledButton',
      'id': 1,
      'p': {
        'onPressed': 5,
        'child': {'t': 'textText', 'id': 2, 'p': {'data': 'Follow'}},
      },
    };
    final w = decodeEwtNode(node) as FilledButton;
    expect(w.onPressed, isNotNull);
    w.onPressed!();
    expect(calls, [[5, const []]]);
  });
}
