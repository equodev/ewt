// widgets_web/test/theme_context_test.dart
import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:widgets_web/widgets_web.dart';

void main() {
  tearDown(() => ewtActiveBuildContext = null);

  testWidgets('themeOf decodes to the ambient theme via ewtActiveBuildContext', (tester) async {
    ThemeData? seen;
    await tester.pumpWidget(MaterialApp(
      theme: ThemeData(colorScheme: const ColorScheme.light(primary: Color(0xFF112233))),
      home: Builder(builder: (context) {
        ewtActiveBuildContext = context;
        seen = decodeEwtNode({'t': 'themeOf', 'id': 1, 'p': {}}) as ThemeData;
        return const SizedBox();
      }),
    ));
    expect(seen, isNotNull);
    expect(seen!.colorScheme.primary, const Color(0xFF112233));
  });
}
