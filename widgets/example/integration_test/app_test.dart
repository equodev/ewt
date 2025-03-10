
import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:widgets/widgets.dart' as widgets;
import 'package:widgets_example/main.dart' as app;
import 'util/test_screenshot.dart';
import 'package:integration_test/integration_test.dart';


void main() {
  print("in test main");
  var binding = IntegrationTestWidgetsFlutterBinding.ensureInitialized();

  group('end-to-end test', () {
    testWidgets('tap on the floating action button, verify counter', (
        tester,
    ) async {
      print('dart test before runApp');
      // await binding.traceAction(() async {
      //   app.main();
      // }, reportKey: 'hello_timeline');
      final factories = widgets.factories();
      final widget = widgets.callToBuildWidgetTree(factories);

      // Load app widget.
      await tester.pumpWidget(widgets.widgetsMap[widget]!);
      // runApp(const MyApp());
      print('dart test after runApp');
      // await tester.pumpWidget(Text('hello from dart', textDirection: TextDirection.rtl,));

      // Verify the counter starts at 0.
      await tester.pumpAndSettle();
      expect(find.text('hello from java'), findsOneWidget);
      await tester.takeScreenshot(name: 'apptest');
      // bindi.takeScreenshot("shot");
    });
  });
}