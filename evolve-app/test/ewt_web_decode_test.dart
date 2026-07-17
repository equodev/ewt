import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:ewt_evolve_app/ewt_web/ewt_web_decode.dart';

void main() {
  testWidgets('decodes Text leaf', (tester) async {
    final node = {'t': 'Text', 'id': 1, 'p': {'data': 'hola'}, 'c': []};
    await tester.pumpWidget(Directionality(
        textDirection: TextDirection.ltr, child: decodeEwtNode(node)));
    expect(find.text('hola'), findsOneWidget);
  });

  testWidgets('decodes SizedBox with Text child', (tester) async {
    final node = {
      't': 'SizedBox', 'id': 1, 'p': {'width': 30.0, 'height': 20.0},
      'c': [ {'t': 'Text', 'id': 2, 'p': {'data': 'inner'}, 'c': []} ]
    };
    await tester.pumpWidget(Directionality(
        textDirection: TextDirection.ltr, child: decodeEwtNode(node)));
    final box = tester.widget<SizedBox>(find.byType(SizedBox));
    expect(box.width, 30.0);
    expect(find.text('inner'), findsOneWidget);
  });
}
