// widgets_web/test/listview_decode_test.dart
import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:widgets_web/widgets_web.dart';

void main() {
  test('listViewListView decodes to a Flutter ListView with children', () {
    final node = {
      't': 'listViewListView', 'id': 1, 'p': {
        'children': [
          {'t': 'textText', 'id': 2, 'p': {'data': 'a'}},
          {'t': 'textText', 'id': 3, 'p': {'data': 'b'}},
        ],
      },
    };
    final w = decodeEwtNode(node);
    expect(w, isA<ListView>());
  });
}
