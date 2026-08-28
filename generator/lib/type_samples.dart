// generator/lib/type_samples.dart
//
// Maps analyzer DartType instances to Java literal expressions (sample values
// and boundary values) for use by the variant-catalog emitter (Task 4.3).
//
// This file is intentionally a standalone library — it does NOT use `part of`
// so that Task 4.3 can import it directly without pulling in all of gen.dart.

import 'package:analyzer/dart/element/element.dart';
import 'package:analyzer/dart/element/type.dart';

class TypeSamples {
  /// Returns a representative Java literal expression for [t], or `null` if
  /// the type is not supported (e.g. `Object?` generics).
  ///
  /// Examples:
  ///   String  → `"hello"`
  ///   int     → `1`
  ///   Color   → `Color(0xff0000ff).build()`
  ///   enum    → `MainAxisAlignment.start` (first constant)
  ///   `List<Widget>` → `List.of(...)` (delegates to inner type)
  String? sampleCodeFor(DartType t) {
    // Dart core primitives
    if (t.isDartCoreString) return '"hello"';
    if (t.isDartCoreInt) return '1';
    if (t.isDartCoreDouble) return '1.0';
    if (t.isDartCoreBool) return 'true';

    // Named Flutter / widgets types
    final n = t.element?.name;
    switch (n) {
      case 'Color':
        return 'Color(0xff0000ff).build()';
      case 'EdgeInsets':
        return 'EdgeInsets_all(8.0).build()';
      case 'EdgeInsetsGeometry':
        return 'EdgeInsets_all(8.0).build()';
      case 'TextStyle':
        return 'TextStyle.builder().build()';
      case 'TextSpan':
        return 'TextSpan.builder().text("hello").build()';
      case 'Duration':
        return 'Duration.milliseconds(200).build()';
      case 'Offset':
        return 'Offset.zero()';
      case 'Size':
        return 'Size(100.0, 100.0).build()';
      case 'Rect':
        return 'Rect.fromLTWH(0.0, 0.0, 100.0, 100.0).build()';
      case 'BorderRadius':
        return 'BorderRadius_all(Radius_circular(8.0).build()).build()';
      case 'BorderRadiusGeometry':
        return 'BorderRadius_all(Radius_circular(8.0).build()).build()';
      case 'Radius':
        return 'Radius_circular(8.0).build()';
      case 'BoxDecoration':
        return 'BoxDecoration.builder().build()';
      case 'Decoration':
        return 'BoxDecoration.builder().build()';
      case 'BoxConstraints':
        return 'BoxConstraints.builder().build()';
      case 'AlignmentGeometry':
        return 'Alignment.center';
      case 'Alignment':
        return 'Alignment.center';
      case 'Key':
        return 'ValueKey("key").build()';
      case 'Widget':
        return 'SizedBox.builder().build()';
      case 'Icon':
        return 'Icon.builder().build()';
      case 'ImageProvider':
        return 'AssetImage("assets/image.png").build()';
      case 'Curve':
        return 'Curves.linear';
      case 'ScrollPhysics':
        return 'AlwaysScrollableScrollPhysics.builder().build()';
      case 'ScrollController':
        return 'ScrollController.builder().build()';
      case 'TextEditingController':
        return 'TextEditingController.builder().build()';
      case 'FocusNode':
        return 'FocusNode.builder().build()';
      case 'InputDecoration':
        return 'InputDecoration.builder().build()';
      case 'TextInputType':
        return 'TextInputType.text';
      case 'ShapeBorder':
        return 'RoundedRectangleBorder.builder().build()';
      case 'OutlinedBorder':
        return 'RoundedRectangleBorder.builder().build()';
      case 'ButtonStyle':
        return 'ButtonStyle.builder().build()';
      case 'MaterialStateProperty':
        return null; // Too complex — skip
      case 'WidgetStateProperty':
        return null; // Too complex — skip
      case 'Animation':
        return null; // Requires AnimationController — skip
      case 'Tween':
        return null; // Parameterized — skip
    }

    // Enum: pick first constant
    if (t is InterfaceType && t.element is EnumElement) {
      final vals = (t.element as EnumElement)
          .fields
          .where((f) => f.isEnumConstant)
          .toList();
      if (vals.isNotEmpty) return '${t.element.name}.${vals.first.name}';
    }

    // Function types: synthesize a lambda of matching arity
    if (t is FunctionType) return _lambdaFor(t);

    // List<T>: delegate to inner type
    if (t is InterfaceType && t.isDartCoreList) {
      final inner = t.typeArguments.first;
      final innerSample = sampleCodeFor(inner);
      if (innerSample == null) return null;
      return 'List.of($innerSample)';
    }

    return null;
  }

  /// Returns an "edge / boundary" Java literal expression for [t], suitable for
  /// boundary-value testing (empty string, zero, empty list, etc.).
  ///
  /// Falls back to [sampleCodeFor] for complex types where no simpler boundary
  /// expression exists.
  String? boundaryCodeFor(DartType t) {
    if (t.isDartCoreString) return '""';
    if (t.isDartCoreInt) return '0';
    if (t.isDartCoreDouble) return '0.0';
    if (t.isDartCoreBool) return 'false';
    if (t is InterfaceType && t.isDartCoreList) return 'List.of()';
    // Fall back to sample for complex types (no meaningful boundary).
    return sampleCodeFor(t);
  }

  /// Convenience: true iff [sampleCodeFor] returns a non-null value for [t].
  bool hasSampleFor(DartType t) => sampleCodeFor(t) != null;

  // ---------------------------------------------------------------------------
  // Private helpers
  // ---------------------------------------------------------------------------

  /// Synthesizes a Java lambda with matching parameter arity.
  ///
  ///   0-arg  → `() -> {}`
  ///   1-arg  → `(_a0) -> {}`
  ///   n-arg  → `(_a0, _a1, …) -> {}`
  String _lambdaFor(FunctionType f) {
    final arity = f.parameters.length;
    if (arity == 0) return '() -> {}';
    final args = List.generate(arity, (i) => '_a$i').join(', ');
    return '($args) -> {}';
  }
}
