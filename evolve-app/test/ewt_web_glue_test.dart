import 'dart:io';
import 'package:flutter_test/flutter_test.dart';

void main() {
  test('web region path does not import dart:ffi or package:widgets', () {
    for (final path in [
      'lib/ewt_region_web.dart',
      'lib/ewt_web/ewt_web_region.dart',
    ]) {
      // Check for actual import directives, not mere mentions in comments.
      final imports = File(path)
          .readAsLinesSync()
          .where((l) => l.trimLeft().startsWith('import '))
          .join('\n');
      expect(imports.contains('dart:ffi'), isFalse, reason: '$path imports dart:ffi');
      // Match 'package:widgets/' to avoid false-positive on 'package:widgets_web'.
      expect(imports.contains('package:widgets/'), isFalse, reason: '$path imports package:widgets');
    }
  });
}
