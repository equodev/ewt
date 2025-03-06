import 'package:flutter_test/flutter_test.dart';
import 'package:widgets/widgets.dart';

import 'generation_test.dart';

void main() {
  test('sum test', () {
    expect(sum(2, 3), equals(5));
  });
}