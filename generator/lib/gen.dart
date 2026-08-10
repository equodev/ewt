import 'dart:io';

import 'package:_fe_analyzer_shared/src/type_inference/nullability_suffix.dart';
import 'package:analyzer/dart/analysis/features.dart';
import 'package:analyzer/dart/analysis/session.dart';
import 'package:analyzer/dart/element/element2.dart';
import 'package:analyzer/src/dart/element/element.dart';
import 'package:analyzer/src/generated/utilities_dart.dart';
import 'package:analyzer/src/utilities/extensions/string.dart';
import 'package:analyzer/src/dart/analysis/session.dart';
import 'package:analyzer/dart/ast/ast.dart';
import 'package:analyzer/dart/element/nullability_suffix.dart';
import 'package:generator/gen.dart';
import 'package:path/path.dart' as path;
import 'package:analyzer/dart/analysis/analysis_context_collection.dart';
import 'package:analyzer/dart/analysis/results.dart';
import 'package:analyzer/dart/element/element.dart';
import 'package:analyzer/dart/element/type.dart';

import 'emit/emit_context.dart';
import 'lang_writers.dart';
import 'types.dart';

part 'emit/c_emitter.dart';
part 'emit/dart_emitter.dart';
part 'emit/java_emitter.dart';
part 'emit/web_emitter.dart';
part 'emit/serialize/serialize_strategy.dart';
part 'emit/serialize/to_c.dart';
part 'emit/serialize/to_dart.dart';
part 'emit/serialize/to_json.dart';
part 'emit/special/animation_controller_gen.dart';
part 'emit/special/color_filter_gen.dart';
part 'emit/special/dart_sub_stateful_widget_gen.dart';
part 'emit/special/image_filter_gen.dart';
part 'emit/special/list_view_gen.dart';
part 'emit/special/material_color_gen.dart';
part 'emit/special/sub_animated_state_gen.dart';
part 'emit/special/sub_state_gen.dart';
part 'emit/special/sub_stateful_widget_gen.dart';
part 'emit/special/sub_stateless_widget_gen.dart';

mixin AGen {
  String objType();
  void gen();

  String dartToC(String value);
}

class PreGeneration {
  // Set<DartType> requiredTypes = {};
  // Set<Element> processed = {};
  // StringBuffer headerFile = StringBuffer();
  // StringBuffer dartFactories = StringBuffer();
  StringBuffer dartSubclasses = StringBuffer();
  // StringBuffer javaFactories = StringBuffer();
  // StringBuffer javaStatics = StringBuffer();

  Iterable<ClassElement> widgets;

  // ClassElement? widgetElement;


  PreGeneration(this.widgets);

  void gen() {
    dartSubclasses.writeln('import \'package:flutter/widgets.dart\';');
    // dartSubclasses.writeln('typedef CreateStateFn = State<StatefulWidget> Function();');
    for (final widget in widgets) {
      final clazz = DartSubclassGen.forWidget(this, widget)
        ..gen();
      dartSubclasses.writeln(clazz.genDartClass());
    }
  }
  void write() {
    if (dartSubclasses.isNotEmpty) {
      _writeD('subwidgets.dart', dartSubclasses.toString());
      _writeDCopy('subwidgets.dart',
          dartSubclasses.toString()); // this is for the parser/generator
    }
  }

}

class WidgetGen implements AGen {
  Types types;
  ClassElement dartClass;
  String widgetClass;
  String widgetField;
  final EmitContext ctx = EmitContext();

  bool hasMembers = false;

  bool _isInterface = false;

  /// Optional companion class (named `<TargetClass>Methods` in generation_index.dart).
  /// Its public static methods whose first parameter is typed as the target class are
  /// emitted as instance methods on this widget's Java file — first param becomes the
  /// implicit receiver via `this.id`.
  ClassElement? methodsCompanion;

  WidgetGen(this.types, this.dartClass):
        widgetClass = dartClass.name,
        widgetField = escapeReserved('${dartClass.name[0].toLowerCase()}${dartClass.name.substring(1)}');

  String objType() => 'DartObj';

  @override
  String dartToC(String theVar) => '_addWidget($theVar)';

  bool _isSupportedFactory(FunctionTypedElement n) =>
      !n.parameters.any((p) => p.isRequired && !types.supportedType(p.type)) &&
      types.supportedType(n.returnType);

  /// True for abstract *classes* (not interfaces) that expose Dart `factory`
  /// constructors we can generate — currently `ImageFilter` and `ColorFilter`
  /// (see emit/special/image_filter_gen.dart / color_filter_gen.dart).
  ///
  /// Skips (a) abstract classes that Java would emit as interfaces (Animation,
  /// Future, EdgeInsetsGeometry) since interfaces can't hold `static factories`
  /// nor Immutables `@Builder.Factory`; and (b) abstract classes that already
  /// have a concrete subclass in the widget set (e.g. `BorderRadiusGeometry`
  /// has `BorderRadius` — emitting factories on both would produce
  /// Java-illegal covariant static-hiding). The membership decision lives on
  /// each generator subclass via [isAbstractFactoryHost] — no scattered
  /// allowlist to keep in sync.
  bool get _hasAbstractFactoryCtors {
    if (!dartClass.isAbstract) return false;
    if (!isAbstractFactoryHost) return false;
    return dartClass.constructors.where((f) => f.isPublic && f.isFactory)
        .any(_isSupportedFactory);
  }

  /// Java rejects `<T extends Object?>`; strip nullable / Object bounds so
  /// generic widgets (Draggable, TweenAnimationBuilder, etc.) emit valid Java.
  /// Kept naked on the class declaration to preserve compatibility with existing
  /// consumers (e.g. `AnimationController extends Animation<Double>`, which
  /// would not satisfy a `T extends NativeObj` constraint).
  String _sanitizeTypeParam(TypeParameterElement tp) {
    final bound = tp.bound;
    if (bound == null || bound.isDartCoreObject) return tp.name;
    return '${tp.name} extends ${types.type4J(bound)}';
  }

  /// Type-parameter prefix for static factory methods on generic widgets.
  /// Constrains unbounded params to `T extends NativeObj` so marshaling through
  /// `ptrObj(Optional<T>)` compiles at the call site.
  String get _factoryTypeParamPrefix {
    if (dartClass.typeParameters.isEmpty) return '';
    final decl = dartClass.typeParameters.map((tp) {
      final bound = tp.bound;
      if (bound == null || bound.isDartCoreObject) return '${tp.name} extends NativeObj';
      return '${tp.name} extends ${types.type4J(bound)}';
    }).join(', ');
    return '<$decl>';
  }

  /// Naked type parameters (no bound), used when emitting the `<T>` prefix on
  /// static factory methods that must propagate the containing class's generics.
  String get _typeParamPrefix =>
      dartClass.typeParameters.isEmpty ? '' : '<${dartClass.typeParameters.map((t) => t.name).join(', ')}>';

  // ---------- Subclass extension points (see emit/special/*) ----------
  //
  // Widgets whose emitted shape diverges from the default flow subclass
  // WidgetGen (via Types.getGen) and override one of these hooks instead of
  // being handled with `if (widgetClass == 'X')` branches scattered across
  // emitters. Add a hook rather than inlining a check.

  /// Extra Java class body written before the synthetic `build()` method.
  /// Default: no-op. Overridden by widgets that need extra Java members
  /// (e.g. AnimationController's web-command routing infrastructure).
  void writeExtraJavaClassBody() {}

  /// Emitted at the start of the void-return branch in the Java instance
  /// method wrapper, before the FFM call. Lets a widget short-circuit or
  /// preroute the call in web mode. Default: no-op.
  void writeVoidMethodWebPrelude(String factory) {}

  /// Hook for the non-void return branch of the Java instance method wrapper.
  /// Return true to indicate the return statement was emitted by the
  /// override; return false to fall back to the standard
  /// `return types.paramValueFFMtoJ(...)`. Default: false.
  bool tryWriteCustomInstanceMethodReturn(String factory, DartType returnType) => false;

  /// Whether to skip emitting a @Override into javaSerializer for this
  /// factory. Used by widgets whose serializer form is hand-maintained
  /// downstream (e.g. SubAnimatedState.animationController is threaded
  /// through EwtWebCapture). Default: false.
  bool skipJavaSerializer(String factory) => false;

  /// The Dart-side constructor name emitted by writeDFactory for
  /// `new $ctor(...)`. Default: [widgetClass]. Overridden by SubclassGen
  /// (to `node.displayName`) and SubStateful/SubStatelessWidgetGen
  /// (prefix with `_Tracked` — see factories.dart for the tracked variant).
  String dartFactoryCtorClass(FunctionTypedElement node) => widgetClass;

  /// Custom writer for the whole `@Override ... $factoryName(...)` body in
  /// [EmitContext.javaSerializer]. Return true to short-circuit the default
  /// emission. Default: false. Used by widgets whose serializer body is not
  /// a plain node record (e.g. ListView.builder eager-expands children).
  bool tryEmitCustomJavaSerializer(
    FunctionTypedElement node,
    String factoryName,
    String factory,
    Params jParamsFFM,
    String jtp,
    String? objStClass,
  ) => false;

  /// Extra fields written into the just-allocated *ObjSt struct inside the
  /// Java serializer. Called after `$objStClass.id(st, id)` and before
  /// `return st`. Default: no-op. MaterialColorGen uses this to populate
  /// the shadeXXX color-id fields from the swatch.
  void emitExtraJavaSerializerFields(String factoryName, String objStClass) {}

  /// Custom writer for the web decoder entry in
  /// [EmitContext.dartWebDecoders]. Return true to short-circuit the default
  /// emission (either because a bespoke entry was written or because the
  /// factory has no useful web decoder). Default: false.
  bool tryEmitCustomWebDecoder(String factory, String factoryName, FunctionTypedElement node) => false;

  /// Whether to skip the "web mode" branch in [ObjStGen.writeJavaFieldAccessor].
  /// True for widgets whose field accessors are pre-resolved at serialize
  /// time (MaterialColor's shade fields). Default: false.
  bool get skipWebFieldAccessor => false;

  /// Whether this abstract class should emit factory constructors as static
  /// Java factories (see [_hasAbstractFactoryCtors]). Default: false.
  /// ImageFilterGen / ColorFilterGen override to true.
  bool get isAbstractFactoryHost => false;

  @override
  void gen() {
    var constructors = dartClass.constructors.where((f) => f.isPublic);
    var staticMethods = dartClass.methods.where((m) => m.isStatic && m.isPublic && !m.returnType.isDartCoreList);
    var consts = dartClass.fields.where((f) => f.isStatic && f.isConst).whereType<ConstFieldElementImpl>();
    var companionMethods = methodsCompanion?.methods.where((m) => m.isStatic && m.isPublic && _isCompanionInstanceMethod(m)) ?? const <MethodElement>[];
    // Abstract classes can still expose Dart `factory` constructors (e.g.
    // `ImageFilter.blur(...)` is a factory on the abstract `ImageFilter`);
    // treat those as generatable so callers get concrete instances.
    var abstractFactoryConstructors = _hasAbstractFactoryCtors
        ? constructors.where((c) => c.isFactory)
        : const <ConstructorElement>[];
    var hasSupportedFactory = (!dartClass.isAbstract && (constructors.any(_isSupportedFactory) || staticMethods.any(_isSupportedFactory)))
        || abstractFactoryConstructors.any(_isSupportedFactory);
    var hasPrivateConsts = consts.where(isPrivateConst).isNotEmpty;
    var hasCompanionMethods = companionMethods.any(_isSupportedFactory);
    hasMembers = hasSupportedFactory || hasPrivateConsts || hasCompanionMethods;
    writeHeaders(hasMembers);
    if (hasMembers) {
      ctx.dartAssigns.writeln('void _setup$widgetClass(WidgetFactories f) {');
    }
    writeJavaConstructors();
    if (!dartClass.isAbstract) {
      for (var constr in constructors) {
        writeFactory(constr);
      }
      for (var constr in dartClass.methods.where((m) => m.isStatic && m.isPublic && !m.returnType.isDartCoreList /*&& m.returnType == dartClass.thisType*/)) {
        writeFactory(constr);
      }
      for (var method in companionMethods) {
        writeInstanceMethod(method, methodsCompanion!.name);
      }
    } else {
      for (var constr in abstractFactoryConstructors) {
        writeFactory(constr);
      }
    }
    writeMembers();
    if (consts.isNotEmpty) {
      var c=1;
      for (var constr in consts) {
        writeConst(constr, c++);
      }
    }
    if (hasMembers) {
      ctx.dartAssigns.writeln('}');
    }
    writeFooter(hasMembers);
    if (dartClass.supertype != null) {
      types.addRequiredType(dartClass.supertype as DartType);
    }
  }

  void writeJavaConstructors() {
    if (!_isInterface) {
      ctx.javaFile
          .writeln('  protected $widgetClass() {}');
      ctx.javaFile..writeln('  $widgetClass(int id) {')..writeln(
          '    this.id = id;')..writeln('  }');
      if (!dartClass.isAbstract) {
        ctx.javaFile.writeln('  public static $widgetClass byId(int id) { return new $widgetClass(id); }');
      }
    }
  }

  String genJavaClass() {
    return ctx.javaFile.toString();
  }

  String genDartFactories() {
    return '${ctx.dartAssigns}${ctx.dartFns}';
  }

  void write() {
    _writeJ(widgetClass, ctx.javaFile.toString());
    _writeJ('${widgetClass}I', ctx.builderFile.toString());
  }

  void writeHeaders(bool hasMembers) {
    ctx.javaFile
        .writeln('package dev.equo.ewt;');
    _isInterface = isInterface(dartClass);
    // Abstract classes with factory ctors we plan to emit must NOT be Java
    // interfaces (interfaces can't hold @Builder.Factory static methods that
    // reference `factories`). See _hasAbstractFactoryCtors.
    if (_isInterface && _hasAbstractFactoryCtors) _isInterface = false;
    // var extend = dartClass.typeParameters.isNotEmpty ? '<${dartClass.typeParameters.join(', ')}>' : '';
    var extend = dartClass.typeParameters.isNotEmpty ? '<${dartClass.typeParameters.map(_sanitizeTypeParam).join(', ')}>' : '';
    List<String> builderExtend = [];
    List<InterfaceType> trulyInterfaces = [];
    if (dartClass.supertype != null && !dartClass.supertype!.isDartCoreObject) {
      if (!_isInterface && isInterface(dartClass.supertype!.element)) {
        extend += ' extends NativeObj.Base';
        trulyInterfaces = [dartClass.supertype!];
        // builderExtend = ' extends ';
      } else {
        extend += ' extends ${toJavaClass(dartClass.supertype!)}';
        // builderExtend = ' extends ${toJavaClassUngeneric(dartClass.supertype!)}I';
        builderExtend = ['${toJavaClassUngeneric(dartClass.supertype!)}I'];
      }
      // extend += ' extends ${dartClass.supertype!.element.name}${dartClass.supertype!.typeArguments.isNotEmpty ? '<${dartClass.typeParameters.map((p) => p.name).join(', ')}>' : ''}';
      // builderExtend = ' extends ${toJavaClassUngeneric(dartClass.supertype!)}I';
    }
    else {
      extend += ' extends ${!_isInterface ? 'NativeObj.Base' : 'NativeObj, ${widgetClass}I'}';
      builderExtend = ['NativeObj.I'];
    }
    trulyInterfaces += dartClass.interfaces.where((i) =>
        i.interfaces.any((i) => i.element is ClassElement)).toList();
    if (_isInterface) {
      // A Java interface lists every supertype after a single `extends` — it
      // never uses `implements`. Fold the interface list into the extends
      // clause, keeping NativeObj and the `I` marker present exactly once.
      final iName = '${widgetClass}I';
      final supers = <String>[];
      if (!extend.contains(' extends ')) supers.add('NativeObj');
      supers.addAll(trulyInterfaces.map((i) => toJavaClass(i)));
      if (extend.contains(' extends ')) {
        if (supers.isNotEmpty) extend += ', ${supers.join(', ')}';
        if (!RegExp('\\b$iName\\b').hasMatch(extend)) extend += ', $iName';
      } else {
        supers.add(iName);
        extend += ' extends ${supers.join(', ')}';
      }
      builderExtend += trulyInterfaces.map((i) => '${toJavaClassUngeneric(i)}I').toList();
    } else if (trulyInterfaces.isNotEmpty) {
      extend += ' implements ${trulyInterfaces.map((i) => toJavaClass(i)).join(', ')}, ${widgetClass}I';
      builderExtend += trulyInterfaces.map((i) => '${toJavaClassUngeneric(i)}I').toList();
    } else {
      extend += ' implements ${widgetClass}I';
    } if (!dartClass.isAbstract || _hasAbstractFactoryCtors) {
      // Abstract classes that expose Dart `factory` constructors emit Immutables
      // @Builder.Factory methods too, so they need the same imports.
      ctx.javaFile
        ..writeln('import java.util.*;')
        ..writeln('import java.util.function.*;')
        ..writeln('import dev.equo.ewt.util.*;')
        ..writeln('import org.immutables.builder.Builder;');
    } else {
      ctx.javaFile
        .writeln('import java.util.*;');
    }
    writeJavaDecl(extend, _isInterface);
    if (hasMembers) {
      ctx.pendingStructHeader = '  struct ${widgetClass}St {';
    }

    ctx.builderFile
      ..writeln('package dev.equo.ewt;')
      ..writeln('public interface ${widgetClass}I extends ${builderExtend.join(', ')} {\n'
          '  @Override\n'
          '  $widgetClass build();\n'
          '}');
  }

  void writeJavaDecl(String extend, bool isInterface) {
    if (!dartClass.isAbstract) {
      ctx.javaFile
          .writeln('public class $widgetClass$extend {');
      // ..writeln('  static final WidgetConstructors factories = WidgetConstructors.instance;');
    } else {
      ctx.javaFile
          .writeln('public ${isInterface ? 'interface' : 'abstract class'} $widgetClass$extend {');
    }
  }

  void writeFooter(bool hasMembers) {
    writeExtraJavaClassBody();
    // Note: return type is intentionally raw for generic widgets. Parametrizing
    // it (e.g. `State<T> build()`) breaks `SubclassGen`'s hand-emitted
    // `createState(...).build()` chain in `SubStatefulWidget.createStateFn`
    // (S from the enclosing method vs T inferred from State — Java refuses to
    // unify). The raw-type warning on Draggable.build()/DragTarget.build() is
    // the tolerable cost.
    ctx.javaFile.writeln('  @Override\n'
        '  ${_isInterface ? 'default' : 'public'} $widgetClass build() {\n'
        '    return this;\n'
        '  }');
    ctx.javaFile.writeln('}');
    if (hasMembers && ctx.pendingStructHeader == null) {
      ctx.headerFile.writeln('  } $widgetField;');
    }
    ctx.pendingStructHeader = null;
  }

  void writeFactory(FunctionTypedElement node) {
    if (node.parameters.any((p) => p.isRequired && !types.supportedType(p.type)) || !types.supportedType(node.returnType)) {
      return;
    }
    String factory = (node.name!.isEmpty) ? widgetField : node.name!;
    String factoryName = '$widgetField${factory.firstUpper()}';
    // Immutables derives the builder name from the @Builder.Factory method, so
    // it has to be built from factoryName rather than from widgetClass. The two
    // only agree while widgetField.firstUpper() == widgetClass, which stops
    // holding once widgetField is escaped (Switch -> switch_).
    String builderClass = '${factoryName.firstUpper()}Builder';
    if (node is ConstructorElement) {
      writeJavaFactory(node, factoryName, builderClass, factory);
    } else {
      writeJavaFactoryForStatic(node, factoryName, factory);
    }
    writeJavaSerializer(node, factoryName, factory);
    writeWebDecoder(factory, factoryName, node);
    // ctx.headerFile
    // .writeln("    int (*$factory)(${cParams.decl});");
    // CLang(generation).writeField(ctx.headerFile, factory, 'int', params: node.parameters);
    writeCFactory(factory, node, 'int');
    // var gen = generation.getGen(node.returnType.element!);
    // if (gen is WidgetGen) {
    //   gen.writeDFactory(factory, factoryName, node);
    //   ctx.dartAssigns.write(gen.ctx.dartAssigns);
    //   ctx.dartFns.write(gen.ctx.dartFns);
    // } else {
    writeDFactory(factory, factoryName, node);
    // }
  }

  /// A companion method qualifies as an instance method only if its first parameter
  /// is typed exactly as the target class (the receiver).
  bool _isCompanionInstanceMethod(MethodElement m) =>
      m.parameters.isNotEmpty &&
      m.parameters.first.type.element == dartClass.thisType.element;

  /// Emits a static method from the methods-companion as an instance method on the
  /// target class. First parameter (the receiver) is consumed: it does not appear
  /// in the Java signature and is replaced by `this.id` in the FFM call.
  void writeInstanceMethod(FunctionTypedElement node, String companionClassName) {
    if (!_isCompanionInstanceMethod(node as MethodElement)) return;
    if (node.parameters.any((p) => p.isRequired && !types.supportedType(p.type)) || !types.supportedType(node.returnType)) {
      return;
    }
    String factory = node.name!;
    String factoryName = '$widgetField${factory.firstUpper()}';
    writeJavaInstanceMethod(node, factoryName, factory);
    writeJavaSerializer(node, factoryName, factory);
    writeCFactory(factory, node, 'int');
    writeDInstanceMethod(factory, factoryName, node, companionClassName);
    writeWebInstanceDecoder(factory, factoryName, node);
  }


  void writeDFactory(String factory, String factoryName, FunctionTypedElement node) {
    var gen = node.returnType is! VoidType ? types.getGen(node.returnType.element!) : null;
    final dartParams = Params(types, node.parameters, Params.paramDef4D, paramValue: Params.paramValue4D);
    ctx.dartAssigns
        .writeln('  f.$widgetField.$factory = ffi.Pointer.fromFunction($factoryName${gen == null || node.returnType.isDartCoreString || gen.objType().endsWith('ObjSt') ? '' : ', ${exception(node.returnType)}'});');
    // Native callbacks wired through ffi.Pointer.fromFunction must return a
    // NON-nullable type. A nullable factory result (e.g. a static lerp() that
    // returns T?) is absorbed here rather than surfacing as a nullable return:
    // _create*ObjSt(null) yields an empty struct (id 0) and paramValueDtoC
    // falls back to 0 / nullptr for a null value.
    final ctorClass = dartFactoryCtorClass(node);
    ctx.dartFns
      ..writeln('${types.type4DRet(node.returnType)} $factoryName(${dartParams.decl}) {')
      ..writeln('  ${gen == null ? '' : 'final w = '}$ctorClass${node.name!.isEmpty ? '' : '.$factory'}(${dartParams.names});');
    if (gen == null) {
    }
    else if (gen.objType().endsWith('ObjSt')) {
      ctx.dartFns.writeln('  return _create${gen.objType()}(w);');
    }
    else {
      ctx.dartFns.writeln('  return ${Params.paramValueDtoC(types, paramElement('w', node.returnType))};');
    }
    ctx.dartFns .writeln('}');
  }

  void writeJavaFactory(FunctionTypedElement node, String factoryName, String builderClass, String factory) {
    String builderFactory = factoryName;
    final jParams = Params(types, node.parameters, Params.paramDef4J, paramValue: Params.escape4J, escape: Params.escape4J);
    final jParamsDecl = Params(types, node.parameters, Params.paramDef4JBuilder, paramValue: Params.paramValue4JBuilder, escape: Params.escape4J);
    final jParamsFFM = Params(types, node.parameters, Params.paramDef4J, paramValue: types.paramValue4FFM, escape: Params.escape4J);
    final tpp = _factoryTypeParamPrefix.isEmpty ? '' : '${_factoryTypeParamPrefix} ';
    final retTpp = _typeParamPrefix; // <T> for return-type parameterization (raw class name would be a raw type).
    if (node is ConstructorElement) {
      ctx.javaFile
        ..writeln('  @Builder.Factory')
        ..writeln('  static $tpp$widgetClass$retTpp $factoryName(${jParamsDecl.builderDecl}) {');
    }
    var gen = types.getGen(node.returnType.element!);
    if (gen is WidgetGen) {
      gen.writeJavaInstanceBody(factoryName, jParamsDecl, node);
      ctx.javaFile.write(gen.ctx.javaFile);
    } else {
      writeJavaInstanceBody(factoryName, jParamsDecl, node);
    }
    ctx.javaFile
        .writeln('  }');
    if (node is ConstructorElement) {
      ctx.javaFile
        ..writeln('  public static $tpp$builderClass$retTpp $factory(${jParamsDecl.required}) {')
        ..writeln('    return $builderClass.$builderFactory(${jParams.requiredNames});')
        ..writeln('  }');
    }
    writeJavaFactoryMethod(factoryName, jParams, factory, jParamsFFM, node);
    if (node is ConstructorElement) {
      ctx.javaStatics
        ..writeln('  public static $tpp$builderClass$retTpp $widgetClass${node.name.isEmpty ? '' : '_$factory'}(${jParamsDecl.required}) {')
        ..writeln('    return $builderClass.$builderFactory(${jParams.requiredNames});')
        ..writeln('  }');
    }
  }



  void writeJavaInstanceBody(String factoryName, Params jParams, FunctionTypedElement node) {
    final retType = types.type4FFMRet(node.returnType);
    if (node.returnType is VoidType) {
      ctx.javaFile.writeln('    factories.$factoryName(${jParams.names});');
    } else {
      ctx.javaFile.writeln('    $retType id = factories.$factoryName(${jParams.names});');
    }
    if (retType == 'int') {
      ctx.javaFile
        .writeln('    if (id <= 0) throw new RuntimeException("Failed to created widget ${node.returnType}");');
    }
    if (node.returnType is! VoidType) {
      ctx.javaFile
        ..writeln('    System.out.println("New ${node.returnType} id:"+id);')
        ..writeln('    return ${types.paramValueFFMtoJ(types, paramElement('id', node.returnType))};');
    }
  }



  bool isPrivateConst(ConstFieldElementImpl fld) {
    var initializer = fld.constantInitializer;
    if (initializer is InstanceCreationExpression) {
      var creationExpression = initializer as InstanceCreationExpression;
      return (creationExpression.constructorName.staticElement!.isPrivate ||
          creationExpression.staticType!.element!.isPrivate);
    }
    return false;
  }

  void writeConst(ConstFieldElementImpl fld, int constId) {
    String factory = _escape4D(fld.name);
    var initializer = fld.constantInitializer;
    // Dart `int` is unbounded but Java `int` is 32-bit; large numeric consts
    // (e.g. DateTime._maxMillisecondsSinceEpoch = 8640000000000000) overflow
    // as decimal literals. Java hex literals up to 0xFFFFFFFF do fit in int
    // (with sign wrap), so only skip when the Dart source form is decimal
    // (not hex) AND the value can't fit even with unsigned wrap. Skips only
    // private consts so no public API is dropped.
    if (!fld.isPublic && fld.type.isDartCoreInt) {
      final v = fld.computeConstantValue()?.toIntValue();
      final src = fld.constantInitializer?.toString() ?? '';
      final isHex = src.trimLeft().startsWith('0x') || src.trimLeft().startsWith('0X');
      if (v != null && !isHex && (v > 2147483647 || v < -2147483648)) {
        return;
      }
    }
    // Pre-check: SimpleIdentifier → private class-level field that can't be
    // inlined as a primitive. Skip rather than calling a non-existent Java method.
    if (initializer is SimpleIdentifier) {
      final si = initializer as SimpleIdentifier;
      var el = si.staticElement;
      VariableElement? fieldEl;
      if (el is FieldElement) { fieldEl = el; }
      else if (el is PropertyAccessorElement && el.isGetter && el.variable2 is FieldElement) {
        fieldEl = el.variable2 as FieldElement;
      }
      if (fieldEl != null && fieldEl.isConst && fieldEl.isPrivate) {
        var val = fieldEl.computeConstantValue();
        bool canInline = val?.toIntValue() != null || val?.toDoubleValue() != null ||
            val?.toStringValue() != null || val?.getField('value')?.toIntValue() != null;
        if (!canInline) return;
      }
    }

    // For non-private InstanceCreationExpression and scalar else-branch: pre-evaluate
    // body before writing the method header to avoid empty methods on unresolvable values.
    if (initializer is InstanceCreationExpression && !isPrivateConst(fld)) {
      var body = dartExptrToJava(initializer as Expression);
      if (body.contains(_unresolvable)) return;
      ctx.javaFile.writeln('  ${fld.isPublic ? 'public' : 'private'} static ${fld.type} $factory() {');
      ctx.javaFile.writeln('    return $body;');
      ctx.javaFile.writeln('  }');
      return;
    }
    if (initializer != null && initializer is! InstanceCreationExpression && initializer is! ListLiteral) {
      var body = dartExptrToJava(initializer);
      if (body.contains(_unresolvable)) return;
      ctx.javaFile.writeln('  ${fld.isPublic ? 'public' : 'private'} static ${fld.type} $factory() {');
      ctx.javaFile.writeln('    return $body;');
      ctx.javaFile.writeln('  }');
      return;
    }

    ctx.javaFile
        .writeln('  ${fld.isPublic ? 'public' : 'private'} static ${fld.type} $factory() {');
    if (initializer is InstanceCreationExpression) {
      // isPrivateConst must be true here (non-private was handled above)
      String factoryName = '$widgetField${fld.name.firstUpper()}';
      _ensureStructOpened();
      ctx.headerFile.writeln('    ${CLang(types).field(factory, types.getGen(fld.type.element!).objType())}');
      ctx.dartAssigns
          .writeln('  f.$widgetField.$factory = _addWidget($widgetClass.${fld.name});');
      ctx.javaFile
        ..writeln('    int id = factories.$factoryName();')
        ..writeln('    if (id <= 0) throw new RuntimeException("Failed to create const $factory");')
        ..writeln('    System.out.println("Const $factory id:"+id);')
        ..writeln('    return ${types.paramValueFFMtoJ(types, paramElement('id', fld.type))};');
      writeJavaConstMethod(factoryName, factory, fld);
      writeConstSerializerAndDecoder(fld, factoryName);
    }
    else if (initializer is ListLiteral) {
      ctx.javaFile
        .writeln('    return List.of(${(initializer as ListLiteral).elements.map((e) => '$e()').join(', ')});');
    }
    ctx.javaFile
      .writeln('  }');
  }

  void writeMembers() {}

  static const String _unresolvable = '\x00UNRESOLVABLE\x00';

  String dartExptrToJava(Expression e) {
    if (e is InstanceCreationExpression) {
      var nodeList = e.argumentList.arguments;
      var requiredArgs = nodeList
          .where((a) => a.correspondingParameter!.isRequiredPositional)
          .map((a) => a.unParenthesized)
          .map((e) => dartExptrToJava(e))
          .join(', ');
      var otherArgs = nodeList
          .whereType<NamedExpression>()
          .map((a) => '.${a.name.label}(${dartExptrToJava(a.expression)})')
          .join('');

      // var clazz = dartClass != e.constructorName.type.element ? '.${e.constructorName.toString().firstLower()}' : '';
      // var clazz = '.${e.constructorName.toString().firstLower()}';
      var constructorName = e.constructorName.toString();
      if (e.constructorName.name == null) {
        constructorName += '.${e.constructorName.toString().firstLower()}';
      }
      return '$constructorName($requiredArgs)$otherArgs.build()';
    }
    else if (e is SetOrMapLiteral) {
      return 'Map.ofEntries(${e.elements.whereType<MapLiteralEntry>().map((e) => 'Map.entry(${e.key}, ${dartExptrToJava(e.value)})').join(', ')})';
    }
    else if (e is SimpleIdentifier) {
      var el = e.staticElement;
      TopLevelVariableElement? varEl;
      if (el is TopLevelVariableElement) {
        varEl = el;
      } else if (el is PropertyAccessorElement && el.isGetter && el.variable2 is TopLevelVariableElement) {
        varEl = el.variable2 as TopLevelVariableElement;
      }
      if (varEl != null && varEl.isConst && varEl.isPrivate) {
        var val = varEl.computeConstantValue();
        if (val?.toIntValue() != null) return val!.toIntValue().toString();
        if (val?.toDoubleValue() != null) return val!.toDoubleValue().toString();
        if (val?.toStringValue() != null) return '"${val!.toStringValue()}"';
        // Non-primitive private top-level var (e.g. Color in new Flutter API) — skip.
        return _unresolvable;
      }
      // Class-level private const fields (FieldElement): only inline Color via ARGB int.
      // Primitives (int/double/String) are already emitted as private Java methods by
      // writeConst and are correctly called via _fieldName().
      VariableElement? fieldEl;
      if (el is FieldElement) { fieldEl = el; }
      else if (el is PropertyAccessorElement && el.isGetter && el.variable2 is FieldElement) {
        fieldEl = el.variable2 as FieldElement;
      }
      if (fieldEl != null && fieldEl.isConst && fieldEl.isPrivate) {
        var val = fieldEl.computeConstantValue();
        var colorArgb = val?.getField('value')?.toIntValue();
        if (colorArgb != null) {
          return 'Color.color(0x${colorArgb.toRadixString(16).toUpperCase().padLeft(8, '0')}).build()';
        }
        // Complex non-Color type (List, BoxShadow, etc.) — unresolvable.
        if (val?.toIntValue() == null && val?.toDoubleValue() == null && val?.toStringValue() == null) {
          return _unresolvable;
        }
      }
      return '$e()';
    }
    else if (e is PrefixedIdentifier) {
      // For statics on classes not in the generated set, try to inline the const value.
      // Handles CupertinoColors.systemRed and similar cross-class references.
      var prefixEl = e.prefix.staticElement;
      if (prefixEl is ClassElement && types.widgets.every((w) => w.name != prefixEl.name)) {
        var accessorEl = e.identifier.staticElement;
        VariableElement? varEl;
        if (accessorEl is PropertyAccessorElement && accessorEl.isGetter) {
          varEl = accessorEl.variable2;
        } else if (accessorEl is FieldElement) {
          varEl = accessorEl as VariableElement;
        }
        if (varEl != null && varEl.isConst) {
          var val = varEl.computeConstantValue();
          if (val?.toIntValue() != null) return val!.toIntValue().toString();
          if (val?.toDoubleValue() != null) {
            var d = val!.toDoubleValue()!;
            if (d.isInfinite) return d.isNegative ? 'Double.NEGATIVE_INFINITY' : 'Double.POSITIVE_INFINITY';
            if (d.isNaN) return 'Double.NaN';
            return d.toString();
          }
          if (val?.toStringValue() != null) return '"${val!.toStringValue()}"';
          var colorArgb = val?.getField('value')?.toIntValue();
          if (colorArgb != null) {
            return 'Color.color(0x${colorArgb.toRadixString(16).toUpperCase().padLeft(8, '0')}).build()';
          }
          // Value not resolvable (e.g. new-API Color uses r/g/b/a doubles).
          return _unresolvable;
        }
      }
      if (e.staticType != null && !isPrimitive(e.staticType!) && e.staticType!.element is! EnumElement) {
        return '${e.toString()}()';
      }
      return replace(e.toString());
    }
    else if (e is BinaryExpression) {
      return  '${dartExptrToJava(e.leftOperand)} ${e.operator} ${dartExptrToJava(e.rightOperand)}';
    }
    else if (e is DoubleLiteral || e is IntegerLiteral || e is PrefixExpression) {
      return e.toString();
    } else if (e is StringLiteral) {
      return '"${e.stringValue}"';
    }
    return e.toString();
  }

  String toJavaClassUngeneric(InterfaceType interfaceType) => interfaceType.element.name;
  String toJavaClass(DartType dartType) {
    if (dartType.isDartCoreInt) {
      return 'Integer';
    } else if (dartType.isDartCoreDouble) {
      return 'Double';
    } else if (dartType.isDartCoreBool) {
      return 'Boolean';
    }
    else if (dartType is NeverType) {
      // Dart `Never` (bottom type, used e.g. in PopupMenuDivider extends PopupMenuEntry<Never>)
      // has no Java equivalent — use Object as a safe stand-in.
      return 'Object';
    }
    else if (dartType is TypeParameterType) {
      // Unbound type parameter (e.g. T) — use its name directly so generic class
      // declarations like `class Radio<T> extends StatefulWidget` render correctly.
      return dartType.element.name;
    }
    else if (dartType is InterfaceType) {
      var s = dartType.element.name;
      if (dartType.typeArguments.isNotEmpty) {
        s += '<${dartType.typeArguments.map((t) => toJavaClass(t)).join(', ')}>';
      }
      return s;
    }
    var s = dartType.element!.name;
    return s!;
  }

  String replace(String expr) => switch (expr) {
    'double.infinity' => 'Double.POSITIVE_INFINITY',
    _ => expr
  };
}

String exception(DartType returnType) {
  if (returnType.isDartCoreDouble) {
    return 'exceptionDouble';
  }
  return 'exception';
}

abstract class ObjStGen extends WidgetGen {
  String widgetSt;

  ObjStGen(super.types, super.dartClass) :
        widgetSt = '${dartClass.name}ObjSt';

  @override
  String objType() => widgetSt;

  @override
  String dartToC(String theVar) => '_create$widgetSt($theVar)';

  @override
  void writeJavaDecl(String extend, bool isInterface) {
    ctx.javaFile
      ..writeln('import java.lang.foreign.MemorySegment;')
      ..writeln('import dev.equo.ewt.ffm.$widgetSt;')
      ..writeln('import static dev.equo.ewt.WidgetConstructorsBase.*;');
    // Let concrete implementations finish the declaration
  }

  /// True when this class is a pure value-object (not a Flutter Widget subclass).
  /// Widget classes (Icon, Container, …) already have constructor factory decoders in the web
  /// map; emitting accessor decoders for them would create duplicate keys. Value-objects
  /// (ColorScheme, TextStyle, TextTheme, …) have no constructor factory decoder, so accessor
  /// decoders are safe.
  bool get _isValueObject => !dartClass.allSupertypes.any(
      (s) => s.element.name == 'StatelessWidget' || s.element.name == 'StatefulWidget');

  /// Generates a field accessor for java.
  /// On web: ObjSt-backed returns record a {t, receiver} node and return a node-backed value-object;
  /// int-backed concrete (Color) similarly. Enum/primitive/String/abstract accessors throw on web.
  void writeJavaFieldAccessor(FieldElement field, {bool useInvoke = false}) {
    final retJ = types.type4J(field.type);
    final factoryName = '$widgetField${field.name.firstUpper()}';
    final gen = types.getGen(field.type.element!);
    final objType = gen.objType();
    final isObjSt = objType.endsWith('ObjSt');
    // Concrete (non-abstract) DartObj-backed value-objects with a (int id) ctor, e.g. Color.
    final isIntBackedObj = objType == 'DartObj'
        && field.type.element is! EnumElement
        && !isPrimitive(field.type)
        && !field.type.isDartCoreString
        && field.type.element is ClassElement
        && !(field.type.element as ClassElement).isAbstract;

    ctx.javaFile.writeln('  public $retJ ${field.name}() {');

    // MaterialColor shade accessors (shade50..shade900) keep the NATIVE struct read: the
    // materialColorMaterialColor serializer already populates the shade struct fields from the
    // swatch (a family-A special-case), so the native branch works off-native and each shade
    // resolves to its concrete swatch color node. The generic accessor-node web branch would
    // instead decode `.shadeXXX` on a browser MaterialColor with an EMPTY swatch -> null-check
    // crash. So skip the web branch for MaterialColor and let the native read fire.
    final skipWebBranch = skipWebFieldAccessor;

    // Web branch: record the accessor as a node chained off this receiver, return a node-backed value.
    if (!skipWebBranch && (isObjSt || isIntBackedObj)) {
      ctx.javaFile
        ..writeln('    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {')
        ..writeln('      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;')
        ..writeln('      int __nid = __s.recordAccessor("$factoryName", getId());');
      if (isObjSt) {
        // Use fully-qualified ObjSt name: each class only imports its own ObjSt.
        ctx.javaFile
          ..writeln('      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.$objType.allocate(__s.arena);')
          ..writeln('      dev.equo.ewt.ffm.$objType.id(__st, __nid);')
          ..writeln('      return new $retJ(__st);');
      } else {
        ctx.javaFile.writeln('      return new $retJ(__nid);');
      }
      ctx.javaFile.writeln('    }');
      // Web decoder: only for value-objects — widget classes already have constructor factory
      // decoders with the same name, so accessor decoders would create duplicate map keys.
      if (_isValueObject) {
        ctx.dartWebDecoders.writeln("  '$factoryName': (p) => (decodeEwtNode(p['receiver'] as Map<String,dynamic>) as $widgetClass).${field.name},");
      }
    } else if (!skipWebBranch) {
      // Enum/primitive/String/abstract accessor: value is only known to Flutter, not serializable as a node.
      ctx.javaFile.writeln('    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("$factoryName not supported on web");');
    }

    // Native branch (unchanged).
    if (useInvoke) {
      ctx.javaFile
        ..writeln('    MemorySegment funcPtr = $widgetSt.${field.name}(st);')
        ..writeln('    return ${types.paramValueFFMtoJ(types, paramElement('$widgetSt.${field.name}.invoke(funcPtr)', field.type))};');
    } else {
      ctx.javaFile.writeln('    return ${types.paramValueFFMtoJ(types, paramElement('$widgetSt.${field.name}(st)', field.type))};');
    }
    ctx.javaFile.writeln('  }');
  }


  /// Shared callable fields filter logic
  Iterable<FieldElement> getCallableFields(ClassElement sourceClass) =>
      sourceClass.fields.where((f) =>
          !f.getter!.hasOverride && f.isPublic && !f.isStatic
          && f.type is! FunctionType && f.type is! TypeParameterType
          && !f.type.isDartCoreList && !f.type.isDartCoreObject
          /*&& !isInterface(f.type.element)*/ && types.supportedType(f.type) && f.type != sourceClass.thisType);
}

class ImmutableGen extends ObjStGen {
  ImmutableGen(super.types, super.dartClass);

  @override
  void writeJavaDecl(String extend, bool isInterface) {
    // First call the base ObjStGen implementation for common imports
    super.writeJavaDecl(extend, isInterface);
    // Then complete with the class declaration that would normally be done in WidgetGen
    ctx.javaFile.writeln(
        'public ${!dartClass.isAbstract ? 'class' : _isInterface ? 'interface' : 'abstract class'} $widgetClass$extend {');
  }

  @override
  void writeJavaConstructors() {
    if (!_isInterface) {
      ctx.javaFile
          .writeln('  private MemorySegment st;');
      ctx.javaFile
          .writeln('  protected $widgetClass() {}');
      ctx.javaFile
        ..writeln('  $widgetClass(MemorySegment st) {')
        ..writeln('    this.id = $widgetSt.id(st);')
        ..writeln('    this.st = st;')
        ..writeln('    if (id <= 0) throw new RuntimeException("Failed to created widget $widgetClass");')
        ..writeln('    System.out.println("New $widgetClass id:"+id);')
        ..writeln('  }');
      // Shadow int-ctor for the callback path: when this widget appears as a
      // callback parameter, the FFM side only has the id. The struct-backed
      // getters will NPE, but constructing a reference to the widget works.
      ctx.javaFile
        ..writeln('  $widgetClass(int id) { this.id = id; }');
    }
  }

  @override
  void writeJavaInstanceBody(String factoryName, Params jParams, FunctionTypedElement node) {
    if (node.returnType.element is EnumElement) {
      super.writeJavaInstanceBody(factoryName, jParams, node);
      return;
    }
    if (node.returnType is VoidType) {
      ctx.javaFile
        .writeln('    factories.$factoryName(${jParams.names});');
    } else {
      ctx.javaFile
        ..writeln('    var st = factories.$factoryName(${jParams.names});')
        ..writeln(
            '    if (st == null) throw new RuntimeException("Failed to created widget $widgetClass");')
        ..writeln(
            '    return new ${types.type4J(node.returnType)}(st);');
    }
  }

  @override
  void writeMembers() {
    writeStructHeader();
    
    for (final field in callableFields()) {
      ctx.objectsHFile.writeln('  ${CLang(types).field(field.name, types.type4C(field.type))}');
      writeJavaFieldAccessor(field);
    }
    
    writeStructFooter();

    if (!hasMembers) return;

    ctx.dartFns
      ..writeln('$widgetSt _create$widgetSt($widgetClass? w) {');

    writeDartStructCreation('w');
    ctx.dartFns.writeln('  if (w == null) return stObj;');

    for (var m in callableFields()) {
      ctx.dartFns
          .writeln('  stObj.${m.name} = ${Params.paramValueDtoC(types, paramElement('w.${m.name}', m.type))};');
    }

    writeDartStructReturn();
  }

  Iterable<FieldElement> callableFields() => getCallableFields(dartClass);
}

class SubclassGen extends ObjStGen {
  SubclassGen(super.types, super.dartClass);

  @override
  void writeJavaDecl(String extend, bool isInterface) {
    super.writeJavaDecl(extend, isInterface);
    ctx.javaFile.writeln('public abstract class $widgetClass$extend, SubclassedInJava {');
  }

  @override
  void writeJavaConstructors() {
    // Empty implementation as in the original
  }

  // ---------- SubclassGen extension points (see emit/special/sub_*.dart) ----------

  /// Emitted inside the canBeImplInJava method loop when the method is
  /// `setState`. Default: no-op. SubStateGen / SubAnimatedStateGen emit the
  /// EwtWebState web-mode reroute here.
  void emitSetStateWebPrelude() {}

  /// Emitted after the canBeImplInJava method loop and before
  /// [writeStructFooter], to synthesize the `T widget()` accessor and any
  /// matching C struct field. Default: no-op.
  void emitStateWidgetAccessor() {}

  /// Emitted after [writeStructFooter], for extra Java members that hang off
  /// the state (webWidget field, anim command sink, etc.). Default: no-op.
  void emitExtraStateJavaMembers() {}

  @override
  String dartFactoryCtorClass(FunctionTypedElement node) => node.displayName;

  @override
  void writeMembers() {
    for (final method in dartClass.supertype!.element.methods.where(canBeImplInJava)) {
      var returnType = method.returnType;
      var ret = '${method.returnType}';
      // var retBuilder = types.widgets.any((w) => w.name  == 'Sub${returnType.element!.name}') ? ret : '${method.returnType}';
      var retBuilder = ret;
      if (returnType is InterfaceType && returnType.typeArguments.isNotEmpty) {
        ret = '<${returnType.typeArguments.map((p) => '${p.getDisplayString()[0]} extends ${p.getDisplayString()}').join(', ')}> ${returnType.element.name}<${returnType.typeArguments.map((p) => p.element?.name.toString()[0]).join(', ')}>';
        retBuilder = '<${returnType.typeArguments.map((p) => '${p.getDisplayString()[0]} extends ${p.getDisplayString()}').join(', ')}> ${returnType.element.name}<${returnType.typeArguments.map((p) => p.element?.name.toString()[0]).join(', ')}>';
      }
      final jParams = Params(types, method.parameters, Params.paramDef4J, paramValue: Params.paramValue4JBuilder, escape: Params.escape4J);
      // Preserve `T` on the *public* hook so `didUpdateWidget(T oldWidget)` gives user code
      // the concrete widget type (needed for widget().<prop> access). Keep `NativeObj` on the
      // `Fn` shim so its method reference matches the Consumer<NativeObj> parameter that
      // WidgetConstructors emits (type4J widens TypeParameterType → NativeObj globally, and
      // the shim must honor that contract — the cast is unchecked but safe under generic
      // erasure since T extends StatefulWidget and NativeObj carries the id).
      final publicDecl = method.parameters
          .where((p) => types.supportedType(p.type) && !hasPrivateDefault(p))
          .map((p) {
            final typeStr = p.type is TypeParameterType && !p.isOptional
                ? (p.type as TypeParameterType).element.name
                : Params.paramDef4J(types, p, wrap: p.isOptional);
            return '$typeStr ${Params.escape4J(types, p)}';
          }).join(', ');
      final callArgs = method.parameters
          .where((p) => types.supportedType(p.type) && !hasPrivateDefault(p))
          .map((p) => p.type is TypeParameterType && !p.isOptional
              ? '(${(p.type as TypeParameterType).element.name}) ${Params.escape4J(types, p)}'
              : Params.paramValue4JBuilder(types, p))
          .where((v) => v.isNotEmpty)
          .join(', ');
      final hasTpParam = method.parameters.any((p) => p.type is TypeParameterType && !p.isOptional);
      ctx.javaFile.writeln('  protected ${method.isAbstract ? 'abstract ' : ''}$retBuilder ${method.name}($publicDecl)${method.isAbstract ? ';' : ' {}'}');
      if (hasTpParam) {
        ctx.javaFile.writeln('  @SuppressWarnings("unchecked")');
      }
      ctx.javaFile.writeln('  ${ret} ${method.name}Fn(${jParams.decl}) {');
      if (returnType is VoidType) {
        ctx.javaFile.writeln('    ${method.name}($callArgs);');
      } else {
        ctx.javaFile.writeln('    return ${method.name}($callArgs).build();');
      }
      ctx.javaFile.writeln('  }');
    }
    
    writeStructHeader();

    for (final field in callableFields()) {
      ctx.objectsHFile.writeln('  ${CLang(types).field(field.name, types.type4C(field.type), params: [])}');
      writeJavaFieldAccessor(field, useInvoke: true);
    }
    
    for (final method in callableMethods()) {
      ctx.objectsHFile.writeln('  ${CLang(types).field(method.name, '${method.returnType}', params: method.parameters)}');
      final jParams = Params(types, method.parameters, Params.paramDef4J, paramValue: types.paramValue4FFM, escape: Params.escape4J);
      ctx.javaFile
        ..writeln('  protected ${method.returnType} ${method.name}(${jParams.decl}) {');
      if (method.name == 'setState') emitSetStateWebPrelude();
      ctx.javaFile
        ..writeln('    MemorySegment funcPtr = $widgetSt.${method.name}(st);')
        ..writeln('    $widgetSt.${method.name}.invoke(funcPtr, factories.${jParams.names});')
        ..writeln('  }');
    }

    emitStateWidgetAccessor();

    writeStructFooter();

    emitExtraStateJavaMembers();
  }

  Iterable<FieldElement> callableFields() {
    final element = dartClass.supertype!.element;
    return element is ClassElement ? getCallableFields(element) : [];
  }

  Iterable<MethodElement> callableMethods() => dartClass.supertype!.element.methods
      .where((m) => !m.isAbstract && m.hasProtected && !m.hasMustCallSuper);

  @override
  void writeJavaFactory(FunctionTypedElement node, String factoryName, String builderClass, String factory) {
    final fnParams = Params(types, node.parameters, Params.paramDef4J, paramValue: Params.paramValue4JCallback, escape: Params.escape4J);
    final jParams = Params(types, node.parameters, Params.paramDef4J, paramValue: Params.escape4J, escape: Params.escape4J);
    final jParamsFFM = Params(types, node.parameters, Params.paramDef4J, paramValue: types.paramValue4FFM, escape: Params.escape4J);
    ctx.javaFile
      ..writeln('  private final MemorySegment st;')
      ..writeln('  protected $widgetClass() {')
      ..writeln('    st = factories.$factoryName(${fnParams.names});')
      ..writeln('    if (st == null) throw new RuntimeException("Failed to created widget $widgetClass");')
      ..writeln('    id = $widgetSt.id(st);')
      ..writeln('    SubclassedInJava.addSubNatObj(this);')
      ..writeln('    System.out.println("New $widgetClass id:"+id);')
      ..writeln('  }');
    writeJavaFactoryMethod(factoryName, jParams, factory, jParamsFFM, node);
  }

  @override
  void writeDFactory(String factory, String factoryName, FunctionTypedElement node) {
    final dartParams = Params(types, node.parameters, Params.paramDef4D, paramValue: Params.paramValue4D);
    ctx.dartAssigns
        .writeln('  f.$widgetField.$factory = ffi.Pointer.fromFunction($factoryName);');
    final ctorClass = dartFactoryCtorClass(node);
    ctx.dartFns
      ..writeln('$widgetSt $factoryName(${dartParams.decl}) {')
      ..writeln('  final w = $ctorClass(${dartParams.names});');
    
    writeDartStructCreation('w');
    
    for (var m in callableMethods()) {
      ctx.dartFns
        ..writeln('  final ${m.name}Fn = ffi.NativeCallable<ffi.Void Function(ffi.Pointer<ffi.NativeFunction<ffi.Void Function()>>)>.listener((ffi.Pointer<ffi.NativeFunction<ffi.Void Function()>> cb) => w.${m.name}(cb.asFunction()));')
        ..writeln('  stObj.${m.name} = ${m.name}Fn.nativeFunction;');
    }
    
    for (var m in callableFields()) {
      ctx.dartFns
        ..writeln('  final ${m.name}Fn = ffi.NativeCallable<${types.type4D(m.type)} Function()>.isolateLocal(() => ${Params.paramValueDtoC(types, paramElement('w.${m.name}', m.type))}, exceptionalReturn: exception);')
        ..writeln('  stObj.${m.name} = ${m.name}Fn.nativeFunction;');
    }
    
    writeDartStructReturn();
  }
}

class EnumGen implements AGen {
  Types generation;
  EnumElement enumType;
  StringBuffer javaFile = StringBuffer();

  EnumGen(this.generation, this.enumType);

  @override
  String objType() => 'int';

  @override
  String dartToC(String theVar) => '$theVar.index';

  @override
  void gen() {
    genJavaClass();
  }

  String genJavaClass() {
    javaFile
      ..writeln('package dev.equo.ewt;')
      ..writeln('public enum ${enumType.name} {');
    javaFile.writeln(enumType.fields.map((en) => _escape4D(en.name)).where((en) => "values" != en).join(', '));
    javaFile.writeln('}');
    return javaFile.toString();
  }

  void write() {
    _writeJ(enumType.name, javaFile.toString());
  }
}

class DartSubclassGen {
  PreGeneration generation;
  ClassElement dartClass;
  String widgetClass;
  // String widgetField;
  // StringBuffer javaFile = StringBuffer();
  // StringBuffer headerFile = StringBuffer();
  StringBuffer dartSubclass = StringBuffer();
  // StringBuffer dartFns = StringBuffer();
  // StringBuffer javaFactories = StringBuffer();
  // StringBuffer javaStatics = StringBuffer();

  DartSubclassGen(this.generation, this.dartClass):
        widgetClass = 'Sub${dartClass.name}';

  /// Factory: dispatches by the underlying Flutter base class name to the
  /// concrete subclass. Single point of name → generator mapping for the
  /// pregeneration path (mirrors `Types.getGen` for the main generator).
  factory DartSubclassGen.forWidget(PreGeneration g, ClassElement w) {
    if (w.name == 'StatefulWidget') return DartSubStatefulWidgetGen(g, w);
    return DartSubclassGen(g, w);
  }

  /// Extra ctor customization for the emitted Dart subclass. Mutates
  /// [params] in-place if needed and returns the constructor initializer
  /// clause (empty by default). Overridden by DartSubStatefulWidgetGen to
  /// force a UniqueKey default.
  String customizeCtor(List<String> params) => '';

  void gen() {
    final typeParam = dartClass.typeParameters.isNotEmpty ? '<${dartClass.typeParameters.join(', ')}>' : '';
    final superTypeParam = dartClass.typeParameters.isNotEmpty ? '<${dartClass.typeParameters.map((t) => t.name).join(', ')}>' : '';
    dartSubclass
        .writeln('class $widgetClass$typeParam extends ${dartClass.name}$superTypeParam {');
    final methods = dartClass.methods.where(canBeImplInJava);
    for (final method in methods) {
      dartSubclass.writeln('  final ${method.type} ${method.name}Fn;');
    }
    var params = dartClass.constructors.first.parameters.map((p) => '${p is SuperFormalParameterElement ? 'super.' : 'this.'}${p.name}').toList();
    var overrideable = methods.map((m) => 'required this.${m.name}Fn').toList();
    final initializer = customizeCtor(params);
    dartSubclass
        .writeln('  $widgetClass({${(params+overrideable).join(', ')}})$initializer;');
    for (final method in methods) {
      dartSubclass.writeln('  @override');
      dartSubclass.writeln('  $method { ');
      if (method.hasMustCallSuper) {
        dartSubclass.writeln('    super.${method.name}(${method.parameters.map((p) => p.name).join(', ')});');
      }
      dartSubclass.writeln('    ${method.returnType is VoidType ? '' : 'return '}${method.name}Fn(${method.parameters.map((p) => p.name).join(', ')});');
      dartSubclass.writeln('  }');
    }
    dartSubclass
        .writeln('}');
  }

  String genDartClass() {
    return dartSubclass.toString();
  }
}

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

    for (var t in types.unsupportedTypes) {
      print('Unsupported type $t');
    }
    for (var w in droppedWidgets) {
      print('Widget ${w.name}: no factory emitted (all constructors have unsupported required params) — only Java class generated (used as parent type)');
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

class Params {
  Types types;
  List<ParameterElement> parameters;

  late String names = "";
  late String builderDecl = "";
  late String decl = "";
  late String required = "";
  late String requiredNames = "";
  bool allTypes;

  Params(this.types, this.parameters,
      String Function(Types, ParameterElement, {bool annotated, bool wrap}) paramDef,
      {this.allTypes = false, String Function(Types, ParameterElement) paramValue = _paramName, String Function(Types, ParameterElement) escape = _paramName}) {
    var filtered = (allTypes ? parameters : parameters.where((p) => types.supportedType(p.type)))
        .where((p) => !hasPrivateDefault(p));
    // Empty string is the "skip" sentinel (see paramValueJson / _paramValueJsonRaw); filter out
    // so that optional value-returning fn params are omitted from the constructor call entirely.
    names = filtered.map((p) => paramValue(types, p)).where((v) => v.isNotEmpty).join(',\n      ');
    var mandatory = filtered.takeWhile((p) => p.isRequired);
    builderDecl = filtered.map((p) => '${paramDef(types, p, annotated: mandatory.contains(p), wrap: p.isOptional)} ${escape(types, p)}').join(', ');
    decl = filtered.map((p) => '${paramDef(types, p, wrap: p.isOptional)} ${escape(types, p)}').join(', ');
    // var mandatory = filtered.where((p) => p.isRequired);
    required = mandatory.map((p) => '${paramDef(types, p)} ${escape(types, p)}').join(', ');
    requiredNames = mandatory.map((p) => paramValue(types, p)).join(', ');
  }

  static String paramDef4J(Types generation, ParameterElement param, {bool annotated = false, bool wrap = false}) {
    var t ='${annotated ? '@Builder.Parameter ' : ''}${generation.type4J(param.type)}';
    if (wrap) {
      if (param.type.isDartCoreDouble) {
        t = 'OptionalDouble';
      }
      else if (param.type.isDartCoreInt) {
        t = 'OptionalInt';
      }
      else if (param.type.isDartCoreBool) {
        t = 'Optional<Boolean>';
      }
      else {
        t = 'Optional<$t>';
      }
    }
    return t;
  }

  static String paramDef4JBuilder(Types generation, ParameterElement param, {bool annotated = false, bool wrap = false}) {
    // var t ='${annotated ? '@Builder.Parameter ' : ''}${generation.type4J(param.type)}';
    var type = param.type;
    if (type is InterfaceType) {
      // if (namedType.isDartCoreList) {
      //   final arrayType = (namedType).typeArguments[0];
      //   return 'List<$arrayType>';
      // }
      // else if (namedType.isDartCoreObject) {
      //   return 'NativeObj';
      // }
      String? t;
      if (type.isDartCoreObject) {
        t = 'NativeObj.I';
      }
      else if (type.isDartCoreList) {
        final arrayType = type.typeArguments[0];
        if (!isPrimitive(arrayType)) {
          t = 'List<${arrayType.element!.name}I>';
        }
      }
      else if (!isPrimitive(type) && type.element is! EnumElement && !type.isDartCoreMap) {
        //   return '${namedType.element.name}Builder';
        // }
        t = '${type.element.name}I';
      }
      if (t != null) {
        if (wrap) {
          t = 'Optional<$t>';
        }
        if (annotated) {
          t = '@Builder.Parameter $t';
        }
        return t;
      }
    }
    return paramDef4J(generation, param, annotated: annotated, wrap: wrap);
  }

  static String paramDef4C(Types generation, ParameterElement param, {bool annotated = false, bool wrap = false}) {
    var t ='${annotated ? '' : ''}${generation.type4C(param.type)}';
    if (t.endsWith('ObjSt')) {
      t = 'DartObj';
    }
    if (wrap && !param.type.isDartCoreString) {
      t = '$t*';
    }
    return t;
  }

  static String paramDef4D(Types generation, ParameterElement param, {bool annotated = false, bool wrap = false}) {
    var t ='${annotated ? '' : ''}${generation.type4D(param.type)}';
    if (wrap && !param.type.isDartCoreString) {
      if (t.endsWith('ObjSt')) {
        t = 'DartObj';
      }
      t = 'ffi.Pointer<$t>';
    } else {
      if (t == 'ffi.Int' || t == 'ffi.Double') {
        t = t.substring(4).toLowerCase();
      }
      else if (t == 'DartObj' || t.endsWith('ObjSt')) {
        t = 'DartDartObj';
      }
    }
    return t;
  }

  static String _paramName(Types types, ParameterElement param) => param.name;

  static String escape4J(Types types, ParameterElement param) => (param.name == 'package') ? '_package' : ensureName(param);

  /// Dart source expression for a factory param on the Dart side of the
  /// bridge. Body lives in the [FfiToDart] strategy
  /// (emit/serialize/to_dart.dart).
  static String paramValue4D(Types types, ParameterElement param) =>
      const FfiToDart().apply(types, param);

  /// Dart source expression that decodes a param from the JSON node map.
  /// Body lives in the [JsonToDart] strategy (emit/serialize/to_json.dart).
  /// Handles the "skip sentinel" for un-crossable optionals and the
  /// named-param prefix; the strategy's apply() returns the bare expression.
  static String paramValueJson(Types types, ParameterElement param) {
    final value = const JsonToDart().apply(types, param);
    // Empty string is the "skip" sentinel (e.g. optional value-returning fn
    // params) — propagate as-is so Params.names can filter it out; avoid
    // emitting "name: " for skipped params.
    if (value.isEmpty) return '';
    return param.isNamed ? '${param.name}: $value' : value;
  }

  /// Dart source expression that marshals a Dart param INTO C.
  /// Body lives in the [DartToC] strategy (emit/serialize/to_c.dart).
  static String paramValueDtoC(Types ctx, ParameterElement param, {bool fromCallback = false}) =>
      DartToC(fromCallback: fromCallback).apply(ctx, param);


  /// The per-element map expression for a List param being serialized (variable {@code e}).
  /// Scalars/Strings are recorded as-is; enums as their ordinal; object-refs/Widgets via the
  /// recorded-node lookup, matching how single object-ref params are serialized.
  /// Serializes a Map param to a Map with String keys: values follow the same scalar/enum/object
  /// rules as list elements. Used e.g. for MaterialColor's swatch (Map&lt;int, Color&gt;).
  static String _mapSerialize(String varName, InterfaceType mapType) {
    final vt = mapType.typeArguments.length > 1 ? mapType.typeArguments[1] : null;
    String valExpr;
    if (vt is InterfaceType && vt.element is EnumElement) {
      valExpr = 'en.getValue().ordinal()';
    } else if (vt == null || isPrimitive(vt) || (vt is InterfaceType && vt.isDartCoreString)) {
      valExpr = 'en.getValue()';
    } else {
      valExpr = 'byId.get(en.getValue().getId())';
    }
    return '$varName.entrySet().stream().collect(java.util.stream.Collectors.toMap(en -> String.valueOf(en.getKey()), en -> $valExpr))';
  }

  static String _listElemSerialize(InterfaceType listType) {
    final elem = listType.typeArguments.isNotEmpty ? listType.typeArguments.first : null;
    if (elem is InterfaceType && elem.element is EnumElement) return 'e.ordinal()';
    if (elem == null || isPrimitive(elem) || (elem is InterfaceType && elem.isDartCoreString)) return 'e';
    return 'byId.get(e.getId())';
  }

  static String paramValueSerialize(Types types, ParameterElement param) {
    final name = Params.escape4J(types, param);
    final key = param.name;
    final t = param.type;
    final h = types.getHandler(t);

    // Callback: reserve a numeric id and optionally store the Runnable.
    if (h != null) {
      if (_isZeroArgCallback(t)) {
        // Wire zero-arg callbacks: reserve the id, record it in the node, and keep the
        // real Runnable so EwtWidget can fire it when the browser reports a click.
        if (param.isOptional) {
          return 'if ($name.isPresent()) { int __cb_$key = nextCallbackId++; p.put("$key", __cb_$key); callbacks.put(__cb_$key, $name.get()); }';
        }
        return 'int __cb_$key = nextCallbackId++; p.put("$key", __cb_$key); callbacks.put(__cb_$key, $name);';
      }
      final vt = _valueCallbackJavaType(t);
      if (vt != null) {
        // Value callback: store a Consumer<Object> that coerces the JSON arg to the known Java
        // type and calls the real Consumer, so EwtWidget can invoke it with the browser's value.
        final coerce = _valueCallbackCoerce(vt, 'v');
        if (param.isOptional) {
          return 'if ($name.isPresent()) { int __cb_$key = nextCallbackId++; p.put("$key", __cb_$key); java.util.function.Consumer<$vt> __h_$key = $name.get(); callbacks.put(__cb_$key, (java.util.function.Consumer<Object>)(v -> __h_$key.accept($coerce))); }';
        }
        return 'int __cb_$key = nextCallbackId++; p.put("$key", __cb_$key); callbacks.put(__cb_$key, (java.util.function.Consumer<Object>)(v -> $name.accept($coerce)));';
      }
      // Remaining arg-carrying callbacks stay inert: reserve the id only (future phase).
      if (param.isOptional) {
        return 'if ($name != null) { p.put("$key", nextCallbackId++); }';
      }
      return 'p.put("$key", nextCallbackId++);';
    }

    if (t is InterfaceType) {
      if (param.isOptional) {
        if (t.isDartCoreString || t.isDartCoreBool) {
          // Optional<String> / Optional<Boolean> — use ifPresent lambda
          return '$name.ifPresent(v -> p.put("$key", v));';
        } else if (t.isDartCoreInt) {
          // OptionalInt
          return 'if ($name.isPresent()) { p.put("$key", $name.getAsInt()); }';
        } else if (t.isDartCoreDouble) {
          // OptionalDouble
          return 'if ($name.isPresent()) { p.put("$key", $name.getAsDouble()); }';
        } else if (t.isDartCoreList) {
          return '$name.ifPresent(v -> p.put("$key", v.stream().map(e -> ${_listElemSerialize(t)}).collect(java.util.stream.Collectors.toList())));';
        } else if (t.isDartCoreMap) {
          return '$name.ifPresent(v -> p.put("$key", ${_mapSerialize('v', t)}));';
        } else if (t.element is EnumElement) {
          return '$name.ifPresent(v -> p.put("$key", v.ordinal()));';
        } else {
          // Optional<Widget/object>
          return '$name.ifPresent(v -> p.put("$key", byId.get(v.getId())));';
        }
      } else {
        // Required params
        if (t.isDartCoreString || t.isDartCoreBool || t.isDartCoreInt || t.isDartCoreDouble) {
          return 'p.put("$key", $name);';
        } else if (t.isDartCoreList) {
          return 'p.put("$key", $name.stream().map(e -> ${_listElemSerialize(t)}).collect(java.util.stream.Collectors.toList()));';
        } else if (t.isDartCoreMap) {
          return 'p.put("$key", ${_mapSerialize(name, t)});';
        } else if (t.element is EnumElement) {
          return 'p.put("$key", $name.ordinal());';
        } else {
          // Required object/Widget
          return 'p.put("$key", byId.get($name.getId()));';
        }
      }
    }
    // Fallback for primitives / other types: record as-is
    return 'p.put("$key", $name);';
  }

  static String? defaultEnumCode(ParameterElement param) {
    var defaultValue = param.defaultValueCode!;
    return defaultValue.replaceFirst('ui.', '');
  }

  /// Replaces private identifiers (`_kFoo`) in [defaultValue] with the source
  /// text of their initializer. Returns null if any private identifier can't be
  /// resolved to a const value — the caller should fall back to omitting the
  /// default so the param becomes an unset optional at the Java layer.
  static String? _inlinePrivateRefs(ParameterElement param, String defaultValue) {
    if (!defaultValue.contains('_')) return defaultValue;
    var out = defaultValue;
    var targetParam = (param is SuperFormalParameterElement) ? param.superConstructorParameter! : param;
    var owner = targetParam.thisOrAncestorOfType<ClassElement>();
    // Match private identifiers as whole tokens (`\b_` won't help because `_`
    // is a word char, so use a manual boundary via lookahead/behind on
    // non-identifier chars or start/end). We walk matches once and rebuild the
    // string with a StringBuffer so `_k` doesn't corrupt `_kMore`.
    final pattern = RegExp(r'(?<![A-Za-z0-9_])_[A-Za-z0-9_]+');
    final buf = StringBuffer();
    var lastEnd = 0;
    for (final match in pattern.allMatches(defaultValue)) {
      final name = match.group(0)!;
      String? replacement;
      final field = owner?.getField(name);
      if (field is ConstFieldElementImpl && field.constantInitializer != null) {
        replacement = field.constantInitializer.toString();
      } else {
        final top = targetParam.library2?.getTopLevelVariable(name);
        if (top != null && top.firstFragment is ConstTopLevelVariableElementImpl) {
          final init = (top.firstFragment as ConstTopLevelVariableElementImpl).constantInitializer;
          if (init != null) replacement = init.toString();
        }
      }
      if (replacement == null) return null;
      buf.write(defaultValue.substring(lastEnd, match.start));
      buf.write(replacement);
      lastEnd = match.end;
    }
    buf.write(defaultValue.substring(lastEnd));
    out = buf.toString();
    return out;
  }

  static String? defaultDoubleCode(ParameterElement param) {
    if (param.defaultValueCode == null) {
      // No source default — some factory ctors leave optionals bare; caller
      // handles null by leaving the param unset at the Java layer.
      final val = param.computeConstantValue()?.toDoubleValue();
      return val?.toString();
    }
    var defaultValue = param.defaultValueCode!;
    if (double.tryParse(defaultValue) != null) {
      return param.defaultValueCode;
    }
    if (defaultValue.contains('_')) {
      final inlined = _inlinePrivateRefs(param, defaultValue);
      if (inlined != null) return inlined;
      // Private ref we couldn't resolve — fall through the analyzer const
      // evaluator (may still yield a numeric literal). If that also fails,
      // return null so the caller emits an unset optional rather than pasting
      // an unresolved `_foo` into Dart source.
      final val = param.computeConstantValue()?.toDoubleValue();
      return val?.toString();
    }
    // Bare identifier (top-level from another library, class-scope public const,
    // etc.) — try the analyzer's constant evaluator before falling back to a
    // qualified name that may not be reachable from the widgets library.
    if (!defaultValue.contains('.')) {
      final val = param.computeConstantValue()?.toDoubleValue();
      if (val != null) return val.toString();
    }
    if (defaultValue.contains('.')) {
      return defaultValue;
    }
    return '${param.thisOrAncestorOfType<ClassElement>()!.name}.$defaultValue';
  }

  static String? defaultObjCode(ParameterElement param) {
    if (param.defaultValueCode == null) {
      return null;
    }
    var defaultValue = param.defaultValueCode!;
    if (defaultValue.contains('.')) {
      return defaultValue;
    }
    if (defaultValue.contains('_')) {
      final inlined = _inlinePrivateRefs(param, defaultValue);
      if (inlined != null) return inlined;
      // Unresolved private ref — bail rather than paste `_foo` into Dart.
      return null;
    }
    if (!defaultValue.startsWith('const')) {
      // return '${param.thisOrAncestorOfType<ClassElement>()!.name}.$defaultValue';
    }
    return defaultValue;
  }

  static String paramValue4JCallback(Types types, ParameterElement param) {
    final t = param.type;
    var value = escape4J(types, param);
    if (t is FunctionType) {
      return 'this::$value';
    }
    return value;
  }

  static String paramValue4JOptional(Types types, ParameterElement param) {
    if (param.isOptional) {
      var t = '';
      if (param.type.isDartCoreDouble) {
        t = 'OptionalDouble';
      }
      else if (param.type.isDartCoreInt) {
        t = 'OptionalInt';
      } else {
        t = 'Optional';
      }
      return '$t.empty()';
    } else {
      return paramValue4JBuilder(types, param);
    }
  }

  static String paramValue4JBuilder(Types types, ParameterElement param) {
    final t = param.type;
    var value = escape4J(types, param);
    if (t is InterfaceType) {
      // if (namedType.isDartCoreList) {
      //   final arrayType = (namedType).typeArguments[0];
      //   return 'List<$arrayType>';
      // }
      // else if (namedType.isDartCoreObject) {
      //   return 'NativeObj';
      // }
      String? v;
      if (t.isDartCoreObject) {
        if (param.isOptional) {
          v = '$value.map(NativeObj.I::build)';
        } else {
          v = '$value.build()';
        }
      }
      else if (t.isDartCoreList) {
        final arrayType = t.typeArguments[0];
        if (!isPrimitive(arrayType)) {
          if (param.isOptional) {
            v = '$value.map(i -> i.stream().map(${arrayType.element!.name}I::build).toList())';
          } else {
            v = '$value.stream().map(${arrayType.element!.name}I::build).toList()';
          }
        }
      }
      else if (!isPrimitive(t) && !t.isDartCoreList && !t.isDartCoreMap && t.element is! EnumElement) {
        if (param.isOptional) {
          v = '$value.map(${t.element.name}I::build)';
        } else {
          v = '$value.build()';
        }
      }
      if (v != null) {
        return v;
      }
    }
    return value;
  }

}

extension Case on String {
  firstUpper() => isEmpty ? "" : this[0].toUpperCase() + substring(1);
  firstLower() => isEmpty ? "" : this[0].toLowerCase() + substring(1);
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