part of 'gen.dart';

class Generation {
  Set<Element> processed = {};
  Set<Element> classesWithSetup = {};
  Set<ClassElement> droppedWidgets = {};
  StringBuffer headerFile = StringBuffer();
  StringBuffer objectsHFile = StringBuffer();
  StringBuffer typedefFile = StringBuffer();
  StringBuffer dartFactories = StringBuffer();
  StringBuffer javaFactories = StringBuffer();
  StringBuffer javaSerializer = StringBuffer();
  StringBuffer dartWebDecoders = StringBuffer();
  StringBuffer javaStatics = StringBuffer();

  List<ClassElement> widgets;
  Iterable<PrefixedIdentifier> topFunctions;
  Types types;
  Map<String, ClassElement> methodsCompanions = {};

  Generation(Iterable<ClassElement> widgets, Iterable<PrefixedIdentifier> this.topFunctions) :
        widgets = widgets.skip(1).toList(),
        types = Types(widgets) {
    for (final w in this.widgets.where((w) => w.name.endsWith('Methods'))) {
      final target = w.name.substring(0, w.name.length - 'Methods'.length);
      methodsCompanions[target] = w;
    }
    // Companions are processed indirectly via their target — drop them from the
    // main list so processWidget doesn't try to emit a standalone Java class.
    this.widgets.removeWhere((w) => w.name.endsWith('Methods'));
  }

  void gen() {
    // headerFile.writeln('typedef int DartObj;');
    headerFile.writeln('typedef struct {');
    dartFactories
        .writeln("part of 'factories.dart';");
    //   ..writeln('WidgetFactories _setupFactories() {')
    //   ..writeln('  final WidgetFactories f = ffi.Struct.create();');
    //
    // for (var dartClass in widgets) {
    //   dartFactories.writeln('  _setup${dartClass.name}(f);');
    // }
    // dartFactories.writeln('  return f;');
    // dartFactories.writeln('}');

    javaFactories
      ..writeln('package dev.equo.ewt;')
      ..writeln('import dev.equo.ewt.ffm.*;')
      ..writeln('import dev.equo.ewt.util.*;')
      ..writeln('import java.util.List;')
      ..writeln('import java.util.Map;')
      ..writeln('import java.util.Optional;')
      ..writeln('import java.util.OptionalInt;')
      ..writeln('import java.util.OptionalDouble;')
      ..writeln('import java.lang.foreign.*;')
      ..writeln('import java.util.function.*;')
      ..writeln('class WidgetConstructors extends WidgetConstructorsBase {');
    // ..writeln('  static WidgetConstructorsGen instance = new WidgetConstructors();')
    // ..writeln('  private MemorySegment factories;')
    // ..writeln('  private Arena arena = Arena.ofAuto();')
    // ..writeln('  public void set(MemorySegment factories) {')
    // ..writeln('    this.factories = factories;')
    // ..writeln('  }');
    javaStatics
      ..writeln('package dev.equo.ewt;')
      ..writeln('import java.util.*;')
      ..writeln('import java.util.function.*;')
      ..writeln('import dev.equo.ewt.util.*;')
      ..writeln('public class EWT {');

    dartFactories.writeln('void _setupTopFunctions(WidgetFactories f) {');
    for (final top in topFunctions) {
      var node = top.element as TopLevelFunctionElement;
      var gen = types.getGen(node.returnType.element!);
      String factory = node.name3!;
      String factoryName = '${path.basenameWithoutExtension(node.library2.identifier)}${factory.firstUpper()}';
      dartFactories
          .writeln(
          '  f.$factory = ffi.Pointer.fromFunction($factoryName${gen.objType().endsWith('ObjSt') ? '' : ', exception'});');
    }
    dartFactories.writeln('}');
    for (final top in topFunctions) {
      // LibraryElementImpl library = LibraryElementImpl(types.widgetElement!.context,
      //   types.widgetElement!.session! as AnalysisSessionImpl,
      //   'synthetic_library',
      //   0,
      //   0,
      //   FeatureSet.latestLanguageVersion()
      // );
      var elem = top.element as TopLevelFunctionElement;
      // var synteticlazz = ClassElementImpl(path.withoutExtension(staticElement!.librarySource!.shortName).firstUpper(), 0);
      // var synteticlazz = ClassElementImpl(path.basenameWithoutExtension(elem.library2.identifier).firstUpper(), 0);
      // synteticlazz.enclosingElement3 = library;
      // MethodElementImpl value = MethodElementImpl(top.name, 0);
      // value.setModifier(Modifier.STATIC, true);
      // value.returnType = elem.returnType;
      // value.parameters = elem.formalParameters;
      // synteticlazz.methods = [value];
      // widgets.insert(0, synteticlazz);
      // synteticlazz.methods.add(value);
      writeTopLevelFunction(elem);
    }

    for (var dartClass in widgets) {
      processWidget(dartClass);
    }

    dartFactories
    // ..writeln("part of 'factories.dart';")
      ..writeln('ffi.Pointer<WidgetFactories> _setupFactories() {')
    // ..writeln('  final WidgetFactories f = ffi.Struct.create();');
      ..writeln('  final ffi.Pointer<WidgetFactories> fp = calloc<WidgetFactories>();')
      ..writeln('  final f = fp.ref;');
    dartFactories.writeln('  _setupTopFunctions(f);');
    // Abstract classes that emit setup functions (e.g. ImageFilter with its
    // factory ctors) still need to be wired up — otherwise the C function
    // pointers are NULL and calling e.g. ImageFilter.blur throws at runtime.
    for (var dartClass in widgets.where((t) => classesWithSetup.contains(t.thisType.element))) {
      dartFactories.writeln('  _setup${dartClass.name}(f);');
    }
    for (var dartClass in types.requiredTypes.map((t) => t.element).whereType<ClassElement>().where((t) => !widgets.contains(t)).where((t) => classesWithSetup.contains(t.thisType.element))) {
      dartFactories.writeln('  _setup${dartClass.name}(f);');
    }
    types.requiredTypes.clear();

    dartFactories.writeln('  return fp;');
    dartFactories.writeln('}');

    headerFile.writeln('} WidgetFactories;');

    // OffsetTween is web-only (Animation<T> params cannot be auto-generated).
    javaStatics
      ..writeln('  /** Creates an {@code Animation<Offset>} that interpolates from {@code begin} to {@code end}')
      ..writeln('   *  driven by {@code parent}. Web-only; see {@link OffsetAnimation}. */')
      ..writeln('  public static OffsetAnimation OffsetTween(OffsetI begin, OffsetI end, AnimationI parent) {')
      ..writeln('    return OffsetAnimation.create(begin.build(), end.build(), parent.build());')
      ..writeln('  }');
    javaStatics.writeln('}');

    // offsetTween is web-only (Animation<T> params cannot be auto-generated); native stub throws.
    javaFactories.writeln('  int offsetTween(Offset begin, Offset end, Animation parent) {');
    javaFactories.writeln('    throw new UnsupportedOperationException("offsetTween is web-only; use OffsetAnimation.create() or EWT.OffsetTween() in web mode");');
    javaFactories.writeln('  }');

    addTypeDefs();
    javaFactories.writeln('}');
  }

  void addTypeDefs() {
    for (var td in types.typeDefs) {
      var fnType = td.element.aliasedType;
      var aliasName = td.element.name;
      var ourName = '${aliasName}FFI';
      if (fnType is FunctionType) {
        final h = types.getHandler(fnType) as FunctionHandler;
        var aliasName = h.getInstantiatedAliasName(td);
        var ourName = h.getInstantiatedAliasName(td, withSuffix: true);
        var boundPositionalParams = bindTypeParameters(fnType.parameters.where((p) => p.isPositional).toList(), td.typeArguments);
        var boundNamedParams = bindTypeParameters(fnType.parameters.where((p) => p.isNamed).toList(), td.typeArguments);
        var allParams = boundPositionalParams+boundNamedParams;
        typedefFile.writeln('typedef ${CLang(types).field(ourName, types.type4C(fnType.returnType), params: allParams)}');
        // if (!aliasedType.boundParams.any((p) => p.type.isDartCoreBool || !isPrimitive(p.type))) { // we need to wrap from int to bool
        // Collect type parameters recursively so `List<T>`, `Map<K,V>`, and
        // nested function types all contribute their `T` to the extension's
        // generic prefix.
        final _seenTp = <Element>{};
        final _tpList = <DartType>[];
        void _collectTp(DartType t) {
          if (t is TypeParameterType) {
            if (_seenTp.add(t.element)) _tpList.add(t);
          } else if (t is InterfaceType) {
            for (final ta in t.typeArguments) _collectTp(ta);
          } else if (t is FunctionType) {
            for (final pp in t.parameters) _collectTp(pp.type);
            _collectTp(t.returnType);
          }
        }
        for (final p in allParams) _collectTp(p.type);
        _collectTp(fnType.returnType);
        var tp = _tpList.map((t) => t.getDisplayString(withNullability: false)).join(', ');
        var rtp = td.typeArguments.isEmpty ? '' : '<${td.typeArguments.join(', ')}>';
        tp = tp.isEmpty ? '' : '<$tp>';
          var isFlutterAlias = td.element.aliasedElement != null;
          var retType = (isFlutterAlias) ? '${td.element.name}$rtp' : fnType; // custom aliases
          // Callbacks that build widget sub-trees must be wrapped in _runBuildScope so that
          // every intermediate widget ID added during the Java→Dart call is removed from
          // _widgetsMap once the callback returns and Flutter holds the tree directly.
          final needsScope = fnType.returnType is! VoidType && !isPrimitive(fnType.returnType);
          dartFactories.writeln(
                  'extension on $ourName {\n'
                  '  $retType to${aliasName}Fn$tp() {\n'
                  // '    return (${fnType}) {\n'
                  // '    return (${boundParams.map((p) => '${p.type} ${ensureName(p)}').join(', ')}) {\n'
                  '    return (${boundPositionalParams.map((p) => '${_dartTypeStr(p.type)} ${ensureName(p)}').join(', ')}${boundNamedParams.isNotEmpty ?', {${boundNamedParams.map((p) => '${p.isRequiredNamed ? 'required ' : ''}${_dartTypeStr(p.type)} ${ensureName(p)}').join(', ')}}' : ''}) ${needsScope ? '=> _runBuildScope(() ' : ''}{\n'
                  '      Dart${aliasName}FFIFunction dFn = asFunction();\n'
                  '      ${fnType.returnType is! VoidType ? 'final dFnRet = ' : ''}dFn(${allParams.map((p) => Params.paramValueDtoC(types, p, fromCallback: true)).join(', ')});');
          if (fnType.returnType is! VoidType) {
            dartFactories.writeln(
                  '      return ${Params.paramValue4D(types, paramElement('dFnRet', fnType.returnType))};');
          }
          dartFactories.writeln(
                  '    }${needsScope ? ')' : ''};\n'
                  '  }\n'
                  '}\n'
                  'extension on ffi.Pointer<$ourName> {\n'
                  '  $retType? to${aliasName}Fn$tp() => (this != ffi.nullptr) ? this.value.to${aliasName}Fn() : null;\n'
                  '}\n'
          );
        // }
        // Always emit `<T…>` when the signature carries type parameters —
        // Flutter-aliased typedefs (e.g. `DragTargetBuilder<T>`) still need
        // them at the Java method level for T inside `Function<T, …>`.
        String jtp = JLang().methodTypeParameters(fnType);
        javaFactories.writeln('${jtp}MemorySegment ptr${aliasName}Fn(${h.type4J(fnType, td.typeArguments)} jFn) {\n'
            '  return $ourName.allocate((${allParams.map((p) => ensureName(p)).join(', ')}) -> {\n'
            '    ${fnType.returnType is! VoidType ? 'final var jFnRet = ' : ''}jFn.${h.functionMethod(fnType)}(${allParams.map((p) => types.paramValueFFMtoJ(types, p, fromCallback: true)).join(', ')});');
        if (fnType.returnType is! VoidType) {
          javaFactories.writeln(
            '    return ${types.paramValue4FFM(types, paramElement('jFnRet', fnType.returnType, ParameterKind.REQUIRED))};');
        }
        javaFactories.writeln(
            '  }, arena);\n'
            '}');
      } else {
        typedefFile.writeln('typedef $fnType $ourName');
      }
    }
  }

  void processWidget(ClassElement dartClass) {
    if (processed.contains(dartClass)) {
      return;
    }
    processed.add(dartClass.thisType.element);
    var widGen = (types.getGen(dartClass) as WidgetGen);
    widGen.methodsCompanion = methodsCompanions[dartClass.name];
    widGen
      ..gen()
      ..genJavaClass()..write();
    CoverageReport.recordWidget(dartClass, hasMembers: widGen.hasMembers);
    if (widGen.hasMembers) {
      classesWithSetup.add(dartClass.thisType.element);
    } else if (!dartClass.isAbstract) {
      droppedWidgets.add(dartClass);
    }
    if (widGen.ctx.headerFile.isNotEmpty) {
      headerFile.writeln(widGen.ctx.headerFile);
    }
    if (widGen.ctx.objectsHFile.isNotEmpty) {
      objectsHFile.writeln(widGen.ctx.objectsHFile);
    }
    if (widGen.genDartFactories().isNotEmpty) {
      dartFactories.writeln(widGen.genDartFactories());
    }
    if (widGen.ctx.javaFactories.isNotEmpty) {
      javaFactories.writeln(widGen.ctx.javaFactories);
    }
    if (widGen.ctx.javaSerializer.isNotEmpty) {
      javaSerializer.writeln(widGen.ctx.javaSerializer);
    }
    if (widGen.ctx.dartWebDecoders.isNotEmpty) {
      dartWebDecoders.writeln(widGen.ctx.dartWebDecoders);
    }
    if (widGen.ctx.javaStatics.isNotEmpty) {
      javaStatics.writeln(widGen.ctx.javaStatics);
    }

    for (DartType requiredType in types.requiredTypes.toSet()) {
      if (!processed.contains(requiredType.element)) {
        // requiredTypes.remove(requiredType);
        processDependency(this, requiredType);
      }
    }
  }

  Future<void> processDependency(Generation generation, DartType requiredType) async {
    if (requiredType.element is EnumElement) {
      processEnum(requiredType.element as EnumElement);
    }
    else if (requiredType.element is ClassElement) {
      processWidget(requiredType.element as ClassElement);
    }
  }

  /// objects.h emits struct definitions in widget-discovery order, which is
  /// not topological — a struct field of type `FooObjSt` can precede
  /// `} FooObjSt;` by hundreds of lines. Since C requires a complete type for
  /// by-value struct fields, reorder the definitions so each struct is
  /// preceded by every struct it depends on.
  String _prependForwardDecls(String body) {
    final defRe = RegExp(r'typedef struct \{([\s\S]*?)\}\s+([A-Za-z_][A-Za-z0-9_]*ObjSt)\s*;');
    final defs = <String, String>{}; // name -> full definition text
    final deps = <String, Set<String>>{}; // name -> set of ObjSt names it embeds
    for (final m in defRe.allMatches(body)) {
      final name = m.group(2)!;
      final block = m.group(0)!;
      final fieldsBody = m.group(1)!;
      defs[name] = block;
      final embedded = <String>{};
      for (final f in RegExp(r'\b([A-Za-z_][A-Za-z0-9_]*ObjSt)\b').allMatches(fieldsBody)) {
        final n = f.group(1)!;
        if (n != name) embedded.add(n);
      }
      deps[name] = embedded;
    }
    if (defs.isEmpty) return body;
    final order = <String>[];
    final seen = <String>{};
    void visit(String n) {
      if (seen.contains(n)) return;
      seen.add(n);
      for (final d in deps[n] ?? const <String>{}) {
        if (defs.containsKey(d)) visit(d);
      }
      order.add(n);
    }
    for (final n in defs.keys) visit(n);
    final buf = StringBuffer();
    for (final n in order) {
      buf.writeln(defs[n]);
    }
    // Preserve any non-struct content (there shouldn't be much, but keep it safe).
    final withoutDefs = body.replaceAll(defRe, '');
    if (withoutDefs.trim().isNotEmpty) {
      buf.writeln();
      buf.write(withoutDefs);
    }
    return buf.toString();
  }

  void processEnum(EnumElement dartClass) {
    processed.add(dartClass);
    EnumGen(types, dartClass)
      ..genJavaClass()..write();
  }

  void write() {
    _writeC('factories.h', headerFile.toString());
    _writeC('objects.h', _prependForwardDecls(objectsHFile.toString()));
    _writeC('typedefs.h', typedefFile.toString());
    _writeD('factories_gen.dart', dartFactories.toString());
    _writeJ('WidgetConstructors', javaFactories.toString());
    _writeJ('EWT', javaStatics.toString());
    _writeJ('SerializingWidgetConstructors', _buildSerializingClass(javaSerializer.toString()));
    _writeWW('factories_web_gen.dart', _buildWebDecoders(dartWebDecoders.toString()));
    CoverageReport.write();

    for (var t in types.unsupportedTypes) {
      warn('unsupported type: $t');
    }
    for (var w in droppedWidgets) {
      warn('${w.name}: no factory emitted (all constructors have unsupported required params) — only Java class generated (used as parent type)');
    }
  }

  /// Wraps the accumulated per-factory override snippets in the
  /// SerializingWidgetConstructors class shell (package, imports, core fields).
  String _buildSerializingClass(String overrides) {
    return '''package dev.equo.ewt;
import dev.equo.ewt.ffm.*;
import dev.equo.ewt.util.*;
import dev.equo.ewt.web.EwtNode;
import java.lang.foreign.MemorySegment;
import java.util.*;
import java.util.function.*;
public class SerializingWidgetConstructors extends WidgetConstructors {
  private int nextId = 1;
  private int nextCallbackId = 1;
  private final Map<Integer, EwtNode> byId = new HashMap<>();
  public Map<Integer, EwtNode> nodes() { return byId; }
  private final Map<Integer, Object> callbacks = new HashMap<>();
  public Map<Integer, Object> callbacks() { return callbacks; }
  public EwtNode rootNode(int rootWidgetId) { EwtNode n = byId.get(rootWidgetId);
    if (n == null) throw new IllegalStateException("No recorded node for id " + rootWidgetId); return n; }
  private void record(int id, String type, Map<String,Object> p) { byId.put(id, new EwtNode(id, type, p, java.util.List.of())); }
  public int recordAccessor(String type, int receiverId) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    EwtNode recv = byId.get(receiverId);
    if (recv != null) p.put("receiver", recv);
    record(id, type, p);
    return id;
  }
$overrides
  // Animation<T> params cannot be auto-generated (parameterised type); hand-maintained in gen.dart.
  @Override
  int subAnimatedStateAnimationController(SubAnimatedState self, Duration duration) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("ctrlId", id);
    p.put("self", byId.get(self.getId()));
    p.put("duration", byId.get(duration.getId()));
    record(id, "subAnimatedStateAnimationController", p);
    return id;
  }
  // Animation<Offset> — serializes begin/end offsets + parent for Tween<Offset>.animate() on the Dart side.
  int offsetTween(Offset begin, Offset end, Animation parent) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("begin", byId.get(begin.getId()));
    p.put("end", byId.get(end.getId()));
    p.put("parent", byId.get(parent.getId()));
    record(id, "offsetTween", p);
    return id;
  }
}
''';
  }

  /// Wraps the accumulated per-factory decoder entries in the generated web-factories map. Pure
  /// Dart (no dart:ffi). Circular import with decode.dart (for decodeEwtNode) is fine for libraries.
  String _buildWebDecoders(String entries) {
    return '''// GENERATED by generator/lib/gen.dart. Do not edit by hand.
import 'package:flutter/material.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/rendering.dart';
import 'package:flutter/services.dart';
import 'dart:ui' show ColorSpace, ImageFilter;
import 'decode.dart';
import 'callbacks.dart';

final Map<String, Object? Function(Map<String, dynamic> p)> webFactories = {
$entries
  // Animation<T> params cannot be auto-generated (parameterised type); hand-maintained in gen.dart.
  'subAnimatedStateAnimationController': (p) {
    final ctrlId = p['ctrlId'] as int;
    final registry = ewtActiveControllerRegistry;
    final vsync = ewtActiveTickerProvider;
    if (registry == null || vsync == null) {
      debugPrint('EWT: subAnimatedStateAnimationController outside animated region (ctrlId=\$ctrlId)');
      return null;
    }
    final duration = decodeEwtNode(p['duration'] as Map<String, dynamic>) as Duration;
    return registry.putIfAbsent(ctrlId, () => AnimationController(vsync: vsync, duration: duration));
  },
  'curvedAnimationCurvedAnimation': (p) => CurvedAnimation(
      parent: decodeEwtNode(p['parent'] as Map<String, dynamic>) as Animation<double>,
      curve: decodeEwtNode(p['curve'] as Map<String, dynamic>) as Curve,
      reverseCurve: p['reverseCurve'] == null ? null : decodeEwtNode(p['reverseCurve'] as Map<String, dynamic>) as Curve),
  'scaleTransitionScaleTransition': (p) => ScaleTransition(
      scale: decodeEwtNode(p['scale'] as Map<String, dynamic>) as Animation<double>,
      alignment: p['alignment'] == null ? Alignment.center : decodeEwtNode(p['alignment'] as Map<String, dynamic>) as Alignment,
      filterQuality: p['filterQuality'] == null ? null : FilterQuality.values[p['filterQuality'] as int],
      child: p['child'] == null ? null : decodeEwtWidget(p['child'] as Map<String, dynamic>)),
  'fadeTransitionFadeTransition': (p) => FadeTransition(
      opacity: decodeEwtNode(p['opacity'] as Map<String, dynamic>) as Animation<double>,
      alwaysIncludeSemantics: (p['alwaysIncludeSemantics'] as bool?) ?? false,
      child: p['child'] == null ? null : decodeEwtWidget(p['child'] as Map<String, dynamic>)),
  'rotationTransitionRotationTransition': (p) => RotationTransition(
      turns: decodeEwtNode(p['turns'] as Map<String, dynamic>) as Animation<double>,
      alignment: p['alignment'] == null ? Alignment.center : decodeEwtNode(p['alignment'] as Map<String, dynamic>) as Alignment,
      filterQuality: p['filterQuality'] == null ? null : FilterQuality.values[p['filterQuality'] as int],
      child: p['child'] == null ? null : decodeEwtWidget(p['child'] as Map<String, dynamic>)),
  'sizeTransitionSizeTransition': (p) => SizeTransition(
      sizeFactor: decodeEwtNode(p['sizeFactor'] as Map<String, dynamic>) as Animation<double>,
      axis: p['axis'] == null ? Axis.vertical : Axis.values[p['axis'] as int],
      axisAlignment: ((p['axisAlignment'] as num?)?.toDouble()) ?? 0.0,
      fixedCrossAxisSizeFactor: (p['fixedCrossAxisSizeFactor'] as num?)?.toDouble(),
      child: p['child'] == null ? null : decodeEwtWidget(p['child'] as Map<String, dynamic>)),
  // Animation<Offset> — wraps a parent Animation<double> with begin/end offsets via Tween<Offset>.
  'offsetTween': (p) => Tween<Offset>(
      begin: p['begin'] == null ? null : decodeEwtNode(p['begin'] as Map<String, dynamic>) as Offset,
      end: p['end'] == null ? null : decodeEwtNode(p['end'] as Map<String, dynamic>) as Offset,
    ).animate(decodeEwtNode(p['parent'] as Map<String, dynamic>) as Animation<double>),
  'slideTransitionSlideTransition': (p) => SlideTransition(
      position: decodeEwtNode(p['position'] as Map<String, dynamic>) as Animation<Offset>,
      transformHitTests: (p['transformHitTests'] as bool?) ?? true,
      textDirection: p['textDirection'] == null ? null : TextDirection.values[p['textDirection'] as int],
      child: p['child'] == null ? null : decodeEwtWidget(p['child'] as Map<String, dynamic>)),
};

final Set<String> unsupportedFactories = {};
''';
  }

  String genCFactories() {
    return headerFile.toString();
  }

  String genDartFactories() {
    return dartFactories.toString();
  }

  String genJavaFactories() {
    return javaFactories.toString();
  }

  String genJavaStatics() {
    return javaStatics.toString();
  }

  void writeTopLevelFunction(TopLevelFunctionElement elem) {
    writeTopLevelFactory(elem);
  }

  void writeTopLevelFactory(TopLevelFunctionElement node) {
    if (node.formalParameters.any((p) => p.isRequired && !types.supportedType(p.type)) || !types.supportedType(node.returnType)) {
      return;
    }
    String factory = node.name3!;
    String factoryName = '${path.basenameWithoutExtension(node.library2.identifier)}${factory.firstUpper()}';
    // String builderClass = '$widgetClass${factory.firstUpper()}Builder';
    // writeJavaFactoryForStatic(node, factoryName, factory);
    // writeCFactory(factory, node, 'int');
    headerFile.writeln('  ${CLang(types).field(factory, types.getGen(node.returnType.element!).objType(), params: sortParameters(node))}');
    writeDFactory(factory, factoryName, node);
    writeJavaFactoryForStatic(node, factoryName, factory);
  }

  void writeDFactory(String factory, String factoryName, TopLevelFunctionElement node) {
    var gen = types.getGen(node.returnType.element!);
    // dartFactories
    //     .writeln('  f.$factory = ffi.Pointer.fromFunction($factoryName${gen.objType().endsWith('ObjSt') ? '' : ', exception'});');
    final dartParams = Params(types, sortParameters(node), Params.paramDef4D, paramValue: Params.paramValue4D);
    var nullabilitySuffix = node.returnType.nullabilitySuffix == NullabilitySuffix.question ? '?' : '' ;
    dartFactories
      ..writeln('${gen.objType() == 'DartObj' ? 'int' : '${gen.objType()}$nullabilitySuffix'} $factoryName(${dartParams.decl}) {')
      ..writeln('  final w = $factory(${dartParams.names});');
    if (gen.objType().endsWith('ObjSt')) {
      if (node.returnType.nullabilitySuffix == NullabilitySuffix.question) {
        dartFactories.writeln('  return w != null ? _create${gen.objType()}(w) : null;');
      } else {
        dartFactories.writeln('  return _create${gen.objType()}(w);');
      }
    }
    else {
      dartFactories.writeln('  return ${node.returnType.element is EnumElement ? 'w.index' : '_addWidget(w)'};');
    }
    dartFactories.writeln('}');
  }

  void writeJavaFactoryForStatic(TopLevelFunctionElement node, String factoryName, String factory) {
    List<ParameterElement> allParams = sortParameters(node);
    var params = allParams.where((p) => !p.isOptional).toList();
    final jParams = Params(types, allParams, Params.paramDef4J, paramValue: Params.escape4J, escape: Params.escape4J);
    final jParamsDecl = Params(types, params, Params.paramDef4JBuilder, paramValue: Params.paramValue4JBuilder, escape: Params.escape4J);
    final jParamsValuesOpt = Params(types, allParams, Params.paramDef4JBuilder, paramValue: Params.paramValue4JOptional, escape: Params.escape4J);
    final jParamsFFM = Params(types, allParams, Params.paramDef4J, paramValue: types.paramValue4FFM, escape: Params.escape4J);
    javaStatics
        .writeln('  public static ${types.type4J(node.returnType)} $factory(${jParamsDecl.decl}) {');
    // var gen = types.getGen(node.returnType.element!);
    // if (gen is WidgetGen) {
      // gen.writeJavaInstanceBody(factoryName, jParamsValuesOpt, node);
      // javaFile.write(gen.javaFile);
    // } else {
      writeJavaInstanceBody(factoryName, jParamsValuesOpt, node);
    // }
    javaStatics
        .writeln('  }');
    writeJavaFactoryMethod(factoryName, jParams, factory, jParamsFFM, node);
  }

  List<ParameterElement> sortParameters(TopLevelFunctionElement node) {
    var allParams = node.type.parameters;
    allParams.sort((e1, e2) => node.formalParameters.indexOf(e1.element).compareTo(node.formalParameters.indexOf(e2.element)));
    return allParams;
  }

  void writeJavaFactoryMethod(String factoryName, Params jParams, String factory, Params jParamsFFM, TopLevelFunctionElement node) {
    var gen = types.getGen(node.returnType.element!);
    javaFactories
      ..writeln('  ${JLang().methodTypeParameters(node.type)}${gen.objType().endsWith('ObjSt') ? 'MemorySegment' : 'int'} $factoryName(${jParams.decl}) {')
      // ..writeln('    var st = WidgetFactories.$widgetField(factories);')
      ..writeln('    var fn = WidgetFactories.$factory(factories);')
      ..writeln('    return WidgetFactories.$factory.invoke(${['fn${gen.objType().endsWith('ObjSt') ? ', arena' : ''}', jParamsFFM.names.nullIfEmpty].nonNulls.join(', ')});')
      ..writeln('  }');
  }

  void writeJavaInstanceBody(String factoryName, Params jParams, TopLevelFunctionElement node) {
    javaStatics
      ..writeln('    int id = WidgetConstructors.instance.$factoryName(${jParams.names});')
      ..writeln('    if (id <= 0) throw new RuntimeException("Failed to created widget ${node.returnType}");')
      ..writeln('    System.out.println("New ${node.returnType} id:"+id);')
      ..writeln('    return ${types.paramValueFFMtoJ(types, paramElement('id', node.returnType))};');
  }

}
