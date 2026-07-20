import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:widgets_web/widgets_web.dart';

void main() {
  test('unknown type returns null and logs', () {
    expect(decodeEwtNode({'t': 'nope', 'id': 1, 'p': {}}), isNull);
  });

  testWidgets('decodeEwtWidget falls back to shrink for non-widget', (tester) async {
    await tester.pumpWidget(Directionality(
        textDirection: TextDirection.ltr,
        child: decodeEwtWidget({'t': 'nope', 'id': 1, 'p': {}})));
    expect(find.byType(SizedBox), findsWidgets);
  });
}
