// generator/lib/emit/variants_gen.dart
//
// Emits per-widget variant catalogs into the test source tree so the native
// render test suite can consume them via WidgetVariantsRegistry.allVariants().
//
// For each widget in generation_index.dart the emitter writes:
//   ewt.api/src/test/java/dev/equo/ewt/support/variants/<Widget>Variants.java
//
// It also writes:
//   ewt.api/src/test/java/dev/equo/ewt/support/variants/WidgetVariantsRegistry.java
//
// This file is a standalone library (not a `part of gen.dart`) so that it can
// import type_samples.dart without pulling in all of gen.dart.

import 'dart:io';
import 'package:analyzer/dart/element/element.dart';
import 'package:analyzer/dart/element/type.dart';
import 'package:generator/gen.dart';

import '../contextual_scaffolds.dart';
import '../type_samples.dart';

// ---------------------------------------------------------------------------
// Deny-list (Task 4.4 will remove this; see issue #43)
// ---------------------------------------------------------------------------
const _deferred = {'SubmenuButton', 'PopupMenuButton', 'DragTarget'};

// ---------------------------------------------------------------------------
// Non-widget and helper classes that should not get variant files
// ---------------------------------------------------------------------------
const _nonWidgetClasses = {
  // gesture / event detail classes (not renderable)
  'TapDownDetails', 'TapUpDetails', 'TapMoveDetails', 'LongPressDownDetails',
  'LongPressStartDetails', 'LongPressMoveUpdateDetails', 'LongPressEndDetails',
  'DragDownDetails', 'DragStartDetails', 'DragUpdateDetails', 'DragEndDetails',
  'ScaleStartDetails', 'ScaleUpdateDetails', 'ScaleEndDetails',
  'ForcePressDetails', 'DraggableDetails', 'DragTargetDetails',
  'PointerDownEvent', 'PointerUpEvent', 'PointerEnterEvent', 'PointerExitEvent',
  'PointerHoverEvent',
  // abstract/infrastructure
  'Widget', 'BuildContext', 'RenderObject', 'RenderBox',
  'StackParentData', 'FlexParentData',
  'TickerProvider', 'NavigatorState',
  // User-subclassable bases emitted by SubclassGen – not concrete widgets
  'SubState', 'SubStatefulWidget', 'SubStatelessWidget', 'SubAnimatedState',
  // companion-only classes
  'AnimationControllerMethods', 'SubAnimatedStateMethods',
  'TapDownDetailsMethods', 'TapUpDetailsMethods', 'TapMoveDetailsMethods',
  'LongPressDownDetailsMethods', 'LongPressStartDetailsMethods',
  'LongPressMoveUpdateDetailsMethods', 'LongPressEndDetailsMethods',
  'DragDownDetailsMethods', 'DragStartDetailsMethods', 'DragUpdateDetailsMethods',
  'DragEndDetailsMethods', 'ScaleStartDetailsMethods', 'ScaleUpdateDetailsMethods',
  'ScaleEndDetailsMethods', 'ForcePressDetailsMethods', 'DraggableDetailsMethods',
  'PointerEventMethods', 'OffsetMethods',
  // abstract type hierarchies that have no concrete factory
  'Curve', 'Animation', 'Animatable', 'Listenable',
  'InlineSpan',
  // misc value objects
  'Velocity', 'Offset', 'Color', 'EdgeInsets', 'BorderRadius', 'Border',
  'BorderSide', 'BoxShadow', 'BoxConstraints', 'BoxDecoration', 'Radius',
  'Alignment', 'AlignmentDirectional', 'TextStyle', 'TextSpan', 'Duration',
  'IconData', 'FontWeight', 'TextDecoration', 'Curves',
  // date/time value objects
  'DateTime', 'TimeOfDay',
  // colors
  'Colors', 'MaterialColor', 'MaterialAccentColor',
  // theme value objects
  'ThemeData', 'ColorScheme', 'TextTheme', 'VisualDensity', 'Durations',
  // FFI infrastructure
  'ImageFilter', 'ColorFilter',
  // math/utility
  'Cubic', 'ThreePointCubic', 'ElasticOutCurve', 'ElasticInCurve',
  'ElasticInOutCurve', 'CurvedAnimation', 'AnimatedBuilder',
  // icons constant classes
  'Icons', 'CupertinoIcons',
  // non-renderable data classes
  'InputDecoration', 'OutlineInputBorder', 'RoundedRectangleBorder',
  'BottomNavigationBarItem', 'DataColumn', 'DataRow', 'DataCell',
  'NavigationRailDestination', 'ExpansionPanel', 'ExpansionPanelRadio',
  'DropdownMenuEntry',
  // abstract / mixin
  'AnimationController',
};

// ---------------------------------------------------------------------------
// Local sample overrides — correct the committed type_samples.dart values that
// produce invalid Java, and add explicit null-skips for types not in EWT.
// A value of null means "no sample available for this type".
// ---------------------------------------------------------------------------
const _sampleOverrides = <String, String?>{
  // Widget → EWT.SizedBox() via static import
  'Widget': 'SizedBox().build()',

  // Icon.builder() does not exist; use the real factory
  'Icon': 'Icon.icon(IconData(0xe000).build()).build()',

  // TextStyle.builder() does not exist; use real factory
  'TextStyle': 'TextStyle.textStyle().build()',

  // TextSpan.builder() does not exist; use real factory
  'TextSpan': 'TextSpan.textSpan().build()',

  // Duration.milliseconds() does not exist as a static; use the builder
  'Duration': 'Duration.duration().milliseconds(200).build()',

  // BoxDecoration.builder() does not exist
  'BoxDecoration': 'BoxDecoration.boxDecoration().build()',
  'Decoration': 'BoxDecoration.boxDecoration().build()',

  // BoxConstraints.builder() does not exist
  'BoxConstraints': 'BoxConstraints.boxConstraints().build()',

  // Alignment.center is a method call, not a field
  'AlignmentGeometry': 'Alignment.center()',
  'Alignment': 'Alignment.center()',

  // Curves.linear is a method call, not a field
  'Curve': 'Curves.linear()',

  // ValueKey does not exist in EWT; Key params just get skipped
  'Key': null,

  // Size, Rect, AssetImage, TextInputType, ImageProvider do not exist in EWT
  'Size': null,
  'Rect': null,
  'AssetImage': null,
  'ImageProvider': null,
  'TextInputType': null,

  // ShapeBorder/OutlinedBorder — correct to real factory
  'ShapeBorder': 'RoundedRectangleBorder.roundedRectangleBorder().build()',
  'OutlinedBorder': 'RoundedRectangleBorder.roundedRectangleBorder().build()',

  // These types do not exist in EWT — no sample
  'ScrollPhysics': null,
  'ScrollController': null,
  'TextEditingController': null,
  'FocusNode': null,
  'ButtonStyle': null,
  'Animation': null,

  // InputDecoration.builder() doesn't exist; use real factory
  'InputDecoration': 'InputDecoration.inputDecoration().build()',
};

const _boundaryOverrides = <String, String?>{
  // Widget boundary — use same override as sample
  'Widget': 'SizedBox().build()',
  'Icon': 'Icon.icon(IconData(0xe000).build()).build()',
  'TextStyle': 'TextStyle.textStyle().build()',
  'TextSpan': 'TextSpan.textSpan().build()',
  'Duration': 'Duration.duration().build()',
  'BoxDecoration': 'BoxDecoration.boxDecoration().build()',
  'Decoration': 'BoxDecoration.boxDecoration().build()',
  'BoxConstraints': 'BoxConstraints.boxConstraints().build()',
  'AlignmentGeometry': 'Alignment.center()',
  'Alignment': 'Alignment.center()',
  'Curve': 'Curves.linear()',
  'Key': null,
  'Size': null,
  'Rect': null,
  'AssetImage': null,
  'ImageProvider': null,
  'TextInputType': null,
  'ShapeBorder': 'RoundedRectangleBorder.roundedRectangleBorder().build()',
  'OutlinedBorder': 'RoundedRectangleBorder.roundedRectangleBorder().build()',
  'ScrollPhysics': null,
  'ScrollController': null,
  'TextEditingController': null,
  'FocusNode': null,
  'ButtonStyle': null,
  'Animation': null,
  'InputDecoration': 'InputDecoration.inputDecoration().build()',
};

// ---------------------------------------------------------------------------
// Main emitter class
// ---------------------------------------------------------------------------
class VariantsEmitter {
  final TypeSamples _samples = TypeSamples();

  // Accumulates entries for WidgetVariantsRegistry
  final List<_RegistryEntry> _registryEntries = [];

  // Target directory (relative to generator/ working dir)
  static const _outDir =
      '../ewt.api/src/test/java/dev/equo/ewt/support/variants';

  // ---------------------------------------------------------------------------
  // Entry points
  // ---------------------------------------------------------------------------

  /// Emit a `<Widget>Variants.java` for the given widget class. Skips:
  ///   - non-widget / infrastructure classes
  ///   - deferred widgets (deny-list)
  ///   - widgets whose required params have no sample value
  void emitForWidget(ClassElement dartClass) {
    final name = dartClass.name;

    // Skip non-widget infrastructure
    if (_nonWidgetClasses.contains(name)) return;

    // Skip deferred widgets
    if (_deferred.contains(name)) {
      stderr.writeln('variants: deferred $name — see issue #43');
      return;
    }

    // Abstract classes without factory constructors won't have emittable factories
    // (except abstract factory hosts like ImageFilter/ColorFilter — skip those too
    // since they're value objects, not widgets).
    if (dartClass.isAbstract) return;

    // Collect all constructors (same filter as WidgetGen.gen)
    final constructors = dartClass.constructors
        .where((c) => c.isPublic && !c.parameters.any((p) => p.isRequired && !_isSupported(p.type)))
        .where((c) => c.isFactory || !dartClass.isAbstract)
        .toList();

    // Also collect public static methods that return the widget type (static factory alternates)
    final staticMethods = dartClass.methods
        .where((m) =>
            m.isStatic &&
            m.isPublic &&
            m.returnType.element == dartClass &&
            !m.parameters.any((p) => p.isRequired && !_isSupported(p.type)))
        .toList();

    final allFactories = [...constructors.cast<FunctionTypedElement>(), ...staticMethods.cast<FunctionTypedElement>()];
    if (allFactories.isEmpty) return;

    // widgetField: escaped camelCase widget name (matches WidgetGen's pattern)
    final widgetField = escapeReserved(
        '${name[0].toLowerCase()}${name.substring(1)}');

    final buf = StringBuffer();
    final variantMethods = <_VariantMethod>[];

    // Process each factory
    for (final node in allFactories) {
      final factoryLabel =
          (node.name == null || node.name!.isEmpty) ? widgetField : node.name!;
      // factoryName is widgetField + _firstUpper(factory) — matches WidgetGen
      // (kept for reference; publicFactory is what we use in Java calls)
      // ignore: unused_local_variable
      final factoryName = '$widgetField${_firstUpper(factoryLabel)}';
      // The public static factory method name on the widget class (= factory in WidgetGen)
      final publicFactory = factoryLabel;

      // Check: every truly-required param must have a sample.
      // We check ALL required params first (before filtering for private defaults),
      // so non-void FunctionType required params skip the whole widget.
      final allRequiredRaw = node.parameters.takeWhile((p) => p.isRequired).toList();
      String? requiredSkipReason;
      for (final p in allRequiredRaw) {
        if (_sampleCode(p.type) == null) {
          requiredSkipReason = p.type.element?.name ?? p.type.toString();
          break;
        }
      }
      if (requiredSkipReason != null) {
        stderr.writeln('variants: skipping $name ($factoryLabel) — no sample for $requiredSkipReason');
        continue;
      }

      // Separate required vs optional params (same filter as Params constructor)
      final supportedParams = node.parameters
          .where((p) => _isSupported(p.type))
          .where((p) => !hasPrivateDefault(p))
          .toList();
      final requiredParams = supportedParams.takeWhile((p) => p.isRequired).toList();
      final optionalParams = supportedParams.skip(requiredParams.length).toList();

      // Build the required-args call expression
      final reqArgs =
          requiredParams.map((p) => _sampleCode(p.type)!).join(', ');
      final baseCall = '$name.$publicFactory($reqArgs)';

      // Collect optional params with samples (forOptionalChain=true to skip List<T>)
      final optsWithSamples = optionalParams
          .map((p) => (p, _sampleCode(p.type, forOptionalChain: true)))
          .where((t) => t.$2 != null)
          .toList();
      final optsWithBoundaries = optionalParams
          .map((p) => (p, _boundaryCode(p.type)))
          .where((t) => t.$2 != null)
          .toList();
      final callbackOpts = optionalParams
          .where((p) => p.type is FunctionType &&
              _sampleCode(p.type, forOptionalChain: true) != null)
          .toList();

      // ── _required ──────────────────────────────────────────────────────
      {
        final expr = _wrap(name, '$baseCall.build()');
        final label = '${factoryLabel}_required';
        variantMethods.add(_VariantMethod(label, expr));
        _registryEntries.add(_RegistryEntry(name, label, '${name}Variants::$label', null));
      }

      // ── _allSet ──────────────────────────────────────────────────────
      if (optsWithSamples.isNotEmpty) {
        final chain = optsWithSamples.map((t) {
          final (p, sample) = t;
          final pName = _escapedName(p);
          return '.$pName($sample)';
        }).join('');
        final expr = _wrap(name, '$baseCall$chain.build()');
        final label = '${factoryLabel}_allSet';
        final expectations = _buildExpectations(optsWithSamples);
        variantMethods.add(_VariantMethod(label, expr));
        _registryEntries
            .add(_RegistryEntry(name, label, '${name}Variants::$label', expectations));
      }

      // ── _boundary ────────────────────────────────────────────────────
      if (optsWithBoundaries.isNotEmpty) {
        final chain = optsWithBoundaries.map((t) {
          final (p, boundary) = t;
          final pName = _escapedName(p);
          return '.$pName($boundary)';
        }).join('');
        final expr = _wrap(name, '$baseCall$chain.build()');
        final label = '${factoryLabel}_boundary';
        final expectations = _buildExpectations(optsWithBoundaries);
        variantMethods.add(_VariantMethod(label, expr));
        _registryEntries
            .add(_RegistryEntry(name, label, '${name}Variants::$label', expectations));
      }

      // ── _nullExplicit ────────────────────────────────────────────────
      // Deliberately NOT emitted.  The intent was a variant that passes
      // Optional.empty() explicitly to every optional setter — proving the
      // setter accepts an absent value rather than only tolerating a skipped
      // call.  But the EWT Java surface is not consistently Optional-wrapped:
      // for many widgets (Cupertino* callbacks, most `Widget?` params, some
      // primitive params with a hardcoded default in the @Builder.Factory
      // source), the emitted setter takes a raw value not an Optional<T>, and
      // `.setter(Optional.empty())` fails to compile.  Without a second
      // compilation pass to introspect actual setter signatures, we cannot
      // reliably tell at emit time which is which.  Skipped for now; tracked
      // together with the analogous 156/877 gap in the ledger's parked list.

      // ── _callbackWired ───────────────────────────────────────────────
      if (callbackOpts.isNotEmpty) {
        final chain = callbackOpts.map((p) {
          final sample = _sampleCode(p.type)!;
          final pName = _escapedName(p);
          return '.$pName($sample)';
        }).join('');
        final expr = _wrap(name, '$baseCall$chain.build()');
        final label = '${factoryLabel}_callbackWired';
        variantMethods.add(_VariantMethod(label, expr));
        _registryEntries
            .add(_RegistryEntry(name, label, '${name}Variants::$label', null));
      }
    }

    if (variantMethods.isEmpty) return;

    // ── Collect all EXPECTATIONS entries ────────────────────────────────
    final allExpectationsEntries = _registryEntries
        .where((e) => e.widgetName == name && e.expectations != null)
        .map((e) => '"${e.variantLabel}", List.of(${e.expectations})')
        .toList();

    // ── Write file ───────────────────────────────────────────────────────
    buf.writeln('package dev.equo.ewt.support.variants;');
    buf.writeln();
    buf.writeln('import dev.equo.ewt.*;');
    buf.writeln('import dev.equo.ewt.Stack;'); // disambiguate from java.util.Stack
    buf.writeln('import java.util.*;');
    buf.writeln('import static dev.equo.ewt.EWT.*;');
    buf.writeln();
    buf.writeln('/** Generated by :generator:generator — do not edit by hand. */');
    buf.writeln('public final class ${name}Variants {');
    buf.writeln();
    buf.writeln('  private ${name}Variants() {}');
    buf.writeln();

    // Emit EXPECTATIONS map
    if (allExpectationsEntries.isNotEmpty) {
      buf.writeln('  public static final Map<String, List<PropExpectation>> EXPECTATIONS =');
      if (allExpectationsEntries.length == 1) {
        buf.writeln('      Map.of(${allExpectationsEntries[0]});');
      } else {
        buf.writeln('      Map.ofEntries(');
        for (var i = 0; i < allExpectationsEntries.length; i++) {
          final comma = i < allExpectationsEntries.length - 1 ? ',' : '';
          buf.writeln('          Map.entry(${allExpectationsEntries[i]})$comma');
        }
        buf.writeln('      );');
      }
      buf.writeln();
    }

    // Emit variant methods
    for (final m in variantMethods) {
      buf.writeln('  public static Widget ${m.label}() {');
      buf.writeln('    return ${m.expr};');
      buf.writeln('  }');
      buf.writeln();
    }

    buf.writeln('}');

    _writeVariant('${name}Variants', buf.toString());
  }

  /// Emit the monolithic WidgetVariantsRegistry.java
  void emitRegistry() {
    if (_registryEntries.isEmpty) return;

    final buf = StringBuffer();
    buf.writeln('package dev.equo.ewt.support.variants;');
    buf.writeln();
    buf.writeln('import dev.equo.ewt.Widget;');
    buf.writeln('import java.util.*;');
    buf.writeln('import java.util.concurrent.Callable;');
    buf.writeln('import java.util.stream.Stream;');
    buf.writeln('import org.junit.jupiter.params.provider.Arguments;');
    buf.writeln();
    buf.writeln('/** Generated by :generator:generator — do not edit by hand. */');
    buf.writeln('public final class WidgetVariantsRegistry {');
    buf.writeln();
    buf.writeln('  private WidgetVariantsRegistry() {}');
    buf.writeln();
    buf.writeln('  /**');
    buf.writeln('   * Returns a stream of (widgetName, variantLabel, Callable<Widget>,');
    buf.writeln('   * List<PropExpectation>) arguments for use in \\@ParameterizedTest.');
    buf.writeln('   * The fourth column is null when no EXPECTATIONS entry exists.');
    buf.writeln('   */');
    buf.writeln('  public static Stream<Arguments> allVariants() {');
    buf.writeln('    return Stream.of(');

    for (var i = 0; i < _registryEntries.length; i++) {
      final e = _registryEntries[i];
      final comma = i < _registryEntries.length - 1 ? ',' : '';
      final expArg = e.expectations != null
          ? '${e.widgetName}Variants.EXPECTATIONS.get("${e.variantLabel}")'
          : 'null';
      buf.writeln(
          '        Arguments.of("${e.widgetName}", "${e.variantLabel}", (Callable<Widget>) ${e.methodRef}, $expArg)$comma');
    }

    buf.writeln('    );');
    buf.writeln('  }');
    buf.writeln('}');

    _writeVariant('WidgetVariantsRegistry', buf.toString());
  }

  // ---------------------------------------------------------------------------
  // Private helpers
  // ---------------------------------------------------------------------------

  /// Apply contextual scaffold if needed.
  String _wrap(String widgetName, String inner) {
    final scaffold = scaffoldFor(widgetName);
    if (scaffold == null) return inner;
    return scaffold.replaceAll('{inner}', inner);
  }

  /// Returns the sample Java expression for type [t], applying local overrides.
  ///
  /// [forOptionalChain] — when true, the sample is used in a `.setter(value)`
  /// optional chain; List<T> params are skipped here because the Immutables
  /// builder API for optional lists vs required lists differs in ways that
  /// cannot be determined at codegen time without parsing the Java output.
  String? _sampleCode(DartType t, {bool forOptionalChain = false}) {
    // List<T>: skip in optional chains (Immutables uses addAll vs direct setter
    // depending on whether the Dart param was required or optional, and that
    // distinction is lost by the time we see ParameterElement.isOptional).
    if (t is InterfaceType && t.isDartCoreList) {
      if (forOptionalChain) return null;
      // For required args: build a typed list expression
      if (t.typeArguments.isNotEmpty) {
        final inner = t.typeArguments.first;
        final innerSample = _sampleCode(inner);
        if (innerSample == null) return null;
        final innerName = inner.element?.name ?? 'Widget';
        // Use the I-interface variant for the explicit type
        return 'List.<${innerName}I>of($innerSample)';
      }
      return 'List.of()';
    }

    // Function types: only synthesize a lambda for void-returning callbacks
    // whose parameter types all map to safe Java types. Non-void callbacks
    // (dragAnchorStrategy, builder, etc.) require typed returns that the void
    // lambda `() -> {}` / `(_a0) -> {}` cannot satisfy. Callbacks with
    // unsupported param types (StackTrace, Route, Map<String,dynamic>, etc.)
    // are excluded from the Java builder entirely and must be skipped here too.
    if (t is FunctionType) {
      if (t.returnType is VoidType && _callbackParamsSafe(t)) {
        return _samples.sampleCodeFor(t);
      }
      return null;
    }
    // Also handle typedef aliases resolving to non-void function types.
    if (t.alias != null) {
      final aliased = t.alias!.element.aliasedType;
      if (aliased is FunctionType) {
        if (aliased.returnType is! VoidType || !_callbackParamsSafe(aliased)) return null;
      }
    }
    final n = t.element?.name;
    if (n != null && _sampleOverrides.containsKey(n)) {
      return _sampleOverrides[n]; // may be null (skip)
    }
    return _samples.sampleCodeFor(t);
  }

  /// Returns the boundary Java expression for type [t], applying local overrides.
  String? _boundaryCode(DartType t) {
    // For List<T> in optional chains: skip (same reason as _sampleCode)
    if (t is InterfaceType && t.isDartCoreList) return null;
    final n = t.element?.name;
    if (n != null && _boundaryOverrides.containsKey(n)) {
      return _boundaryOverrides[n];
    }
    return _samples.boundaryCodeFor(t);
  }

  /// Returns true if the type has any representation (required OR optional chain).
  /// We include a param if it can appear in either context.
  bool _isSupported(DartType t) {
    // A type is "supported" if it has a non-null sample for required-args context.
    // Optional chain will further filter with forOptionalChain=true.
    return _sampleCode(t) != null;
  }

  /// Escaped parameter name (matching Java identifier rules).
  String _escapedName(ParameterElement p) {
    final name = p.name;
    // Java reserved word escaping
    if (name == 'class') return 'class_';
    if (name == 'default') return 'default_';
    if (name == 'package') return '_package';
    // Also escape Dart reserved words that WidgetGen escapes
    return escapeReserved(name);
  }

  /// Build a PropExpectation list string for the given (param, sampleCode) pairs.
  /// Function-type params are skipped (lambdas can't be equality-checked).
  /// Complex types use `notNull`; primitives / strings / enums use `equalTo`.
  String _buildExpectations(List<(ParameterElement, String?)> opts) {
    final parts = <String>[];
    for (final (p, sample) in opts) {
      if (sample == null) continue;
      // Skip function-type params — lambdas can't be checked for equality
      if (p.type is FunctionType) continue;
      final name = p.name;
      final t = p.type;
      if (_isPrimitiveOrEnum(t)) {
        parts.add('PropExpectation.equalTo("$name", $sample)');
      } else {
        parts.add('PropExpectation.notNull("$name")');
      }
    }
    if (parts.isEmpty) return '';
    return parts.join(', ');
  }

  bool _isPrimitiveOrEnum(DartType t) {
    if (t.isDartCoreString || t.isDartCoreBool || t.isDartCoreDouble || t.isDartCoreInt) {
      return true;
    }
    if (t is InterfaceType && t.element is EnumElement) return true;
    return false;
  }

  static void _writeVariant(String className, String content) {
    print('Generating variants/$className.java');
    final dir = Directory(_outDir);
    if (!dir.existsSync()) dir.createSync(recursive: true);
    File('$_outDir/$className.java').writeAsStringSync(content);
  }
}

// ---------------------------------------------------------------------------
// Internal data classes
// ---------------------------------------------------------------------------

class _VariantMethod {
  final String label;
  final String expr;
  _VariantMethod(this.label, this.expr);
}

class _RegistryEntry {
  final String widgetName;
  final String variantLabel;
  final String methodRef;
  final String? expectations; // Java expression or null

  _RegistryEntry(this.widgetName, this.variantLabel, this.methodRef, String? exp)
      : expectations = (exp != null && exp.isNotEmpty) ? exp : null;
}

// ---------------------------------------------------------------------------
// String helpers — avoid re-declaring the extension that gen.dart already has.
// ---------------------------------------------------------------------------
String _firstUpper(String s) => s.isEmpty ? '' : s[0].toUpperCase() + s.substring(1);

// ---------------------------------------------------------------------------
// Callback safety check
//
// Returns true iff every parameter type of [ft] can be represented in Java
// as a Consumer<T>/BiConsumer/Runnable lambda. The main generator only wires
// callbacks whose parameter types are supported by its Types engine. We
// replicate a conservative subset of that check so the variants emitter
// doesn't emit `.setter((_a0, _a1) -> {})` for parameters that don't exist
// on the Java builder (e.g. ImageErrorListener, AppPrivateCommandCallback,
// onDidRemovePage, onSelectionChanged).
//
// Safe parameter types are: void, bool, int, double, String, enums, and
// widget subtypes (anything whose element name ends in a known widget token).
// Everything else (StackTrace, Route<T>, Map<K,V>, TextSelection, Page, …)
// is NOT safe.
// ---------------------------------------------------------------------------
bool _callbackParamsSafe(FunctionType ft) {
  for (final p in ft.parameters) {
    if (!_isCallbackParamSafe(p.type)) return false;
  }
  return true;
}

bool _isCallbackParamSafe(DartType t) {
  if (t is VoidType) return true;
  if (t is DynamicType) return true;
  if (t.isDartCoreBool || t.isDartCoreDouble || t.isDartCoreInt || t.isDartCoreString) return true;
  // Enums are safe
  if (t.element is EnumElement) return true;
  // TypeParameterType (e.g. T?) — allow; the lambda will be un-typed
  if (t is TypeParameterType) return true;
  // Widget types — anything that has "Widget" in its name or is a subtype
  final name = t.element?.name;
  if (name == null) return false;
  // Known widget/EWT types that appear as callback parameters
  if (name == 'Widget' || name.endsWith('Widget')) return true;
  if (name == 'BuildContext') return true;
  if (name == 'PointerDownEvent' || name == 'PointerUpEvent' ||
      name == 'PointerEvent') return true;
  if (name == 'DragDownDetails' || name == 'DragStartDetails' ||
      name == 'DragUpdateDetails' || name == 'DragEndDetails') return true;
  if (name == 'TapDownDetails' || name == 'TapUpDetails') return true;
  if (name == 'DraggableDetails' || name == 'DragTargetDetails') return true;
  if (name == 'LongPressDownDetails' || name == 'LongPressStartDetails' ||
      name == 'LongPressMoveUpdateDetails' || name == 'LongPressEndDetails') return true;
  if (name == 'ScaleStartDetails' || name == 'ScaleUpdateDetails' ||
      name == 'ScaleEndDetails') return true;
  if (name == 'ForcePressDetails') return true;
  if (name == 'AxisDirection' || name == 'ScrollDirection') return true;
  // Allow generic Object — maps to NativeObj in EWT
  if (name == 'Object') return true;
  // Everything else (StackTrace, Route, Map, TextSelection, Page, etc.) is unsafe
  return false;
}
