import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:widgets_web/widgets_web.dart';

// A single non-decodable widget anywhere in the tree must NOT take down its parent:
// the parent should still build, with the bad node degraded to an empty placeholder.
// Regression for the "one missing decoder greys the whole region" fault (F1).
void main() {
  test('an undecodable child degrades to a placeholder, parent still builds', () {
    final node = {
      't': 'columnColumn', 'id': 1, 'p': {
        'children': [
          {'t': 'textText', 'id': 2, 'p': {'data': 'ok'}},
          {'t': 'nope', 'id': 3, 'p': {}}, // no decoder -> must not throw
        ],
      },
    };

    final w = decodeEwtNode(node);

    expect(w, isA<Column>());
    expect((w as Column).children.length, 2);
    expect(w.children[1], isA<SizedBox>()); // the bad child, degraded
  });
}
