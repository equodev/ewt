part of 'gen.dart';

/// Identifiers reserved in Java, C or Dart.
///
/// A widget's field name is emitted verbatim into all three layers (Java
/// factory methods, C struct fields, Dart factory lookups), so a clash in any
/// one language has to be escaped in all of them to keep the name identical
/// across the bridge. `Switch` is the case that hits every language at once.
const reservedIdentifiers = {
  // Java
  'abstract', 'assert', 'boolean', 'break', 'byte', 'case', 'catch', 'char',
  'class', 'const', 'continue', 'default', 'do', 'double', 'else', 'enum',
  'extends', 'final', 'finally', 'float', 'for', 'goto', 'if', 'implements',
  'import', 'instanceof', 'int', 'interface', 'long', 'native', 'new',
  'package', 'private', 'protected', 'public', 'return', 'short', 'static',
  'strictfp', 'super', 'switch', 'synchronized', 'this', 'throw', 'throws',
  'transient', 'try', 'void', 'volatile', 'while',
  // C (adds to the Java list)
  'auto', 'extern', 'inline', 'register', 'restrict', 'signed', 'sizeof',
  'struct', 'typedef', 'union', 'unsigned',
  // Dart (adds to the lists above)
  'covariant', 'deferred', 'dynamic', 'export', 'factory', 'in', 'is',
  'library', 'mixin', 'operator', 'part', 'rethrow', 'set', 'var', 'with',
  'yield',
};

/// Suffixes [name] when it would collide with a keyword in any target language.
String escapeReserved(String name) =>
    reservedIdentifiers.contains(name) ? '${name}_' : name;

bool canBeImplInJava(m) => m.isAbstract || (m.hasMustCallSuper && m.hasProtected);

/// A non-nullable optional param whose default is a private symbol we can't
/// inline to a literal (e.g. `const _HeroTag(...)`, a private class) has no
/// value we can emit into Dart — pasting the private name breaks compilation.
/// Such params are dropped from the builder. Resolvable private constants
/// (e.g. `const Color(_kColorDefault)`) are inlined by [Params._inlinePrivateRefs]
/// and stay settable. Common across Cupertino widgets (CupertinoNavigationBar's
/// non-null `heroTag`, etc.).
final _privateSymbol = RegExp(r'(^|[^A-Za-z0-9_])_[A-Za-z0-9_]');
bool hasPrivateDefault(ParameterElement p) {
  final code = p.defaultValueCode;
  if (code == null || !_privateSymbol.hasMatch(code)) return false;
  // Function params are marshalled as function pointers, not value defaults, so
  // a private default is never emitted for them (e.g. Scaffold's non-null
  // bottomSheetScrimBuilder). Keep the param.
  if (p.type is FunctionType) return false;
  // Nullable params marshal null via `.objOrNul()` and let Flutter apply its own
  // default — the default value is never emitted, so a private default there is
  // harmless (e.g. the nullable heroTag on FloatingActionButton). Only
  // non-nullable params emit the default.
  if (p.type.nullabilitySuffix != NullabilitySuffix.none) return false;
  final resolved = Params._inlinePrivateRefs(p, code);
  return resolved == null || _privateSymbol.hasMatch(resolved);
}

// A callback param is "zero-arg" when its function type takes no parameters
// (Runnable / VoidCallback). Such callbacks can be fired from Java with no argument,
// so Phase 2 wires them. Arg-carrying callbacks (Consumer<Boolean>, gesture details)
// return false and stay inert. Resolves through a typedef alias when present.
bool _isZeroArgCallback(DartType t) {
  FunctionType? ft;
  if (t is FunctionType) {
    ft = t;
  } else if (t.alias != null && t.alias!.element.aliasedType is FunctionType) {
    ft = t.alias!.element.aliasedType as FunctionType;
  }
  if (ft == null) return false;
  return ft.parameters.isEmpty;
}

// A value callback carries a single scalar arg the generator can coerce on the Java side.
// Returns the Java boxed type ('Boolean' / 'String') for a one-parameter bool/String callback,
// else null. Resolves through a typedef alias when present.
String? _valueCallbackJavaType(DartType t) {
  FunctionType? ft;
  if (t is FunctionType) {
    ft = t;
  } else if (t.alias != null && t.alias!.element.aliasedType is FunctionType) {
    ft = t.alias!.element.aliasedType as FunctionType;
  }
  // A value callback (ValueChanged<T>) takes one arg and returns void; a value-RETURNING function
  // (e.g. SemanticFormatterCallback = String Function(double)) is not one — it can't be reduced to
  // an id + arg round-trip and must not be wired as a Consumer.
  if (ft == null || ft.parameters.length != 1 || ft.returnType is! VoidType) return null;
  final at = ft.parameters.first.type;
  if (at is InterfaceType) {
    if (at.isDartCoreBool) return 'Boolean';
    if (at.isDartCoreString) return 'String';
    if (at.isDartCoreDouble) return 'Double';
    if (at.isDartCoreInt) return 'Integer';
  }
  return null;
}

/// Coerces the browser-supplied callback arg (an Object read off the JSON payload) to the known
/// Java value type. Bool/String arrive as their boxed type and cast directly; a JSON number can
/// arrive as any Number subtype (Integer, Long, Double, BigDecimal depending on the parser), so
/// numeric callbacks go through Number.xValue() rather than a brittle direct cast.
String _valueCallbackCoerce(String vt, String v) {
  switch (vt) {
    case 'Double':
      return '((Number) $v).doubleValue()';
    case 'Integer':
      return '((Number) $v).intValue()';
    default:
      return '($vt) $v';
  }
}

String ensureName(ParameterElement param) => param.name.isNotEmpty ? param.name : param.type.element!.name![0].toLowerCase();

/// Renders a Dart type preserving nullability. Necessary because
/// `DartType.toString()` and `getDisplayString(withNullability: true)` both
/// occasionally drop the `?` for TypeParameterType (analyzer quirk), which
/// breaks generated lambdas whose param typedefs declare nullable T (e.g.
/// `DragTargetWillAccept<T> = bool Function(T? data)`).
///
/// For TypeParameterType params where the analyzer strips `?`, defensively
/// widen to nullable: DragTarget's onWillAccept/onAccept/onLeave all pass
/// `T?` (Flutter can invoke them with `null` for rejected data), so a
/// nullable declaration is always safe and matches the typedef contract.
String _dartTypeStr(DartType t) {
  final s = t.getDisplayString(withNullability: true);
  if (t is TypeParameterType) {
    if (s.endsWith('?')) return s;
    return '$s?';
  }
  if (t.nullabilitySuffix == NullabilitySuffix.question && !s.endsWith('?')) {
    return '$s?';
  }
  return s;
}

String _escape4D(String id) => switch (id) {
  'extension' => 'extension_',
  'factory' => 'factory_',
  'sync' => 'sync_',
  'package' => 'package_',
  'public' => 'public_',
  'double' => 'double_',
  'build' => 'build_',
  _ => id
};

void _writeJ(String clazz, String javaContent) {
  print('Generating $clazz');
  File('../ewt.api/src/main/java/dev/equo/ewt/$clazz.java').writeAsStringSync(javaContent);
}

void _writeC(String file, String content) {
  print('Generating $file');
  File('../widgets/src/$file').writeAsStringSync(content);
}

void _writeD(String file, String content) {
  print('Generating $file');
  File('../widgets/lib/$file').writeAsStringSync(content);
}

void _writeDCopy(String file, String content) {
  print('Generating $file');
  File('./lib/$file').writeAsStringSync(content);
}

void _writeWW(String file, String content) {
  print('Generating $file');
  File('../widgets_web/lib/$file').writeAsStringSync(content);
}
