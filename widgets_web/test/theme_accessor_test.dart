// widgets_web/test/theme_accessor_test.dart
import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:widgets_web/widgets_web.dart';

void main() {
  tearDown(() => ewtActiveBuildContext = null);

  testWidgets('colorScheme.inversePrimary accessor chain decodes to the ambient theme color', (tester) async {
    Color? seen;
    const scheme = ColorScheme.light(inversePrimary: Color(0xFF445566));
    await tester.pumpWidget(MaterialApp(
      theme: ThemeData(colorScheme: scheme),
      home: Builder(builder: (context) {
        ewtActiveBuildContext = context;
        final node = {
          't': 'colorSchemeInversePrimary', 'id': 3, 'p': {'receiver': {
            't': 'themeDataColorScheme', 'id': 2, 'p': {'receiver': {
              't': 'themeOf', 'id': 1, 'p': {}}}}}};
        seen = decodeEwtNode(node) as Color;
        return const SizedBox();
      }),
    ));
    expect(seen, const Color(0xFF445566));
  });
}
