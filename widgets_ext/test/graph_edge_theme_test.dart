// widgets_ext/test/graph_edge_theme_test.dart
//
// Guards that EwtGraphView's edge connectors are chrome that follows Evolve's
// runtime light/dark theme switch, instead of a fixed colour that vanishes on a
// dark surface. The edge painter must resolve its colour from the ambient
// ColorScheme, so the same graph paints different edges under different themes.
import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:widgets_ext/widgets_ext.dart';

/// Reads the colour the graph's edge painter would stroke with under [theme].
///
/// A [ValueKey] on the root tied to the theme's brightness forces a fresh
/// subtree per theme — mirroring production, where a theme switch re-decodes
/// the EWT subtree rather than reconciling the same widgets in place.
Future<Color> _edgeColourUnder(WidgetTester tester, ThemeData theme) async {
  await tester.pumpWidget(MaterialApp(
    key: ValueKey(theme.brightness),
    theme: theme,
    home: Scaffold(
      body: SizedBox(
        width: 300,
        height: 300,
        child: EwtGraphView(
          const [Text('a'), Text('b')],
          edges: '0-1',
          positions: '10,10;120,120',
        ),
      ),
    ),
  ));

  // The only CustomPaint EwtGraphView installs is the edge painter.
  final paint = tester
      .widgetList<CustomPaint>(find.byType(CustomPaint))
      .map((w) => w.painter)
      .firstWhere((p) => p.runtimeType.toString() == '_EdgePainter');
  return (paint as dynamic).color as Color;
}

void main() {
  testWidgets('graph edges follow the ambient theme (light vs dark differ)',
      (tester) async {
    final light = ThemeData.from(colorScheme: const ColorScheme.light());
    final dark = ThemeData.from(colorScheme: const ColorScheme.dark());

    final lightEdge = await _edgeColourUnder(tester, light);
    final darkEdge = await _edgeColourUnder(tester, dark);

    // Each theme's edges use that theme's outline colour...
    expect(lightEdge, light.colorScheme.outline);
    expect(darkEdge, dark.colorScheme.outline);
    // ...so switching the theme actually repaints the edges a different colour.
    expect(lightEdge, isNot(darkEdge));
  });
}
