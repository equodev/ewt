// widgets_web/test/scaffold_decode_test.dart
import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:widgets_web/widgets_web.dart';

void main() {
  test('scaffoldScaffold decodes to a Flutter Scaffold with appBar + body', () async {
    final node = {
      't': 'scaffoldScaffold',
      'id': 1,
      'p': {
        'appBar': {
          't': 'appBarAppBar',
          'id': 2,
          'p': {'title': {'t': 'textText', 'id': 3, 'p': {'data': 'Hi'}}},
        },
        'body': {'t': 'textText', 'id': 4, 'p': {'data': 'Body'}},
      },
    };
    final w = decodeEwtNode(node);
    expect(w, isA<Scaffold>());
    final s = w as Scaffold;
    expect(s.appBar, isA<AppBar>());
    expect(s.body, isA<Text>());
  });
}
