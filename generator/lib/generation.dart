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
  StringBuffer javaInterface = StringBuffer(); // java-11 split: foreign-free WidgetConstructors interface
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
      ..writeln('import static dev.equo.ewt.NativeObj.Base.intToBool;')
      ..writeln('class FfmWidgetConstructors extends WidgetConstructorsBase implements WidgetConstructors {')
      // State read-back (setState/widget) needs the native struct, which the foreign-free state no
      // longer holds. States are few and long-lived, so the FFM impl keeps an id->struct map (recorded
      // when a state factory runs) and exposes the read-back ops the core state delegates to.
      ..writeln('  private final java.util.Map<Integer, MemorySegment> handles = new java.util.concurrent.ConcurrentHashMap<>();')
      ..writeln('  public void subStateSetState(int id, Runnable fn) {')
      ..writeln('    SubStateObjSt.setState.invoke(SubStateObjSt.setState(handles.get(id)), ptrVoidCallbackFn(fn));')
      ..writeln('  }')
      ..writeln('  public int subStateWidget(int id) {')
      ..writeln('    return SubStateObjSt.widget.invoke(SubStateObjSt.widget(handles.get(id)));')
      ..writeln('  }')
      ..writeln('  public void subAnimatedStateSetState(int id, Runnable fn) {')
      ..writeln('    SubAnimatedStateObjSt.setState.invoke(SubAnimatedStateObjSt.setState(handles.get(id)), ptrVoidCallbackFn(fn));')
      ..writeln('  }')
      ..writeln('  public int subAnimatedStateWidget(int id) {')
      ..writeln('    return SubAnimatedStateObjSt.widget.invoke(SubAnimatedStateObjSt.widget(handles.get(id)));')
      ..writeln('  }');
    // java-11 split: WidgetConstructors is a foreign-free interface (int-id factory signatures).
    // FfmWidgetConstructors (above, ffm layer) and SerializingWidgetConstructors (comm, core) implement it.
    javaInterface
      ..writeln('package dev.equo.ewt;')
      ..writeln('import dev.equo.ewt.util.*;')
      ..writeln('import java.util.List;')
      ..writeln('import java.util.Map;')
      ..writeln('import java.util.Optional;')
      ..writeln('import java.util.OptionalInt;')
      ..writeln('import java.util.OptionalDouble;')
      ..writeln('import java.util.function.*;')
      ..writeln('public interface WidgetConstructors {')
      // java-11 split: FFM read-back plumbing. The FFM impl overrides this to hand a freshly built
      // widget its native struct; the comm impl keeps the null default (its widgets carry no struct).
      ..writeln('  default Object takeLastStruct() { return null; }');
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
      // java-11 split: EWT statics are foreign-free (int-id/String handles), so no java.lang.foreign import.
      ..writeln('import dev.equo.ewt.util.*;')
      ..writeln('public class EWT {');

    dartFactories.writeln('void _setupTopFunctions(WidgetFactories f) {');
    for (final top in topFunctions) {
      var node = top.element as TopLevelFunctionElement;
      var gen = types.getGen(node.returnType.element!);
      String factory = node.name3!;
      String factoryName = '${path.basenameWithoutExtension(node.library2.identifier)}${factory.firstUpper()}';
      // `Pointer.fromFunction` requires an exceptional-return sentinel for
      // scalar returns (int/double/bool) but rejects it for Pointer/struct
      // returns. Suppress the sentinel for ObjSt (struct) and String
      // (Pointer<Char>) returns.
      final skipException = gen.objType().endsWith('ObjSt') ||
          node.returnType.isDartCoreString;
      dartFactories
          .writeln(
          '  f.$factory = ffi.Pointer.fromFunction($factoryName${skipException ? '' : ', exception'});');
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
    javaFactories.writeln('  public int offsetTween(Offset begin, Offset end, Animation parent) {');
    javaFactories.writeln('    throw new UnsupportedOperationException("offsetTween is web-only; use OffsetAnimation.create() or EWT.OffsetTween() in web mode");');
    javaFactories.writeln('  }');
    javaInterface.writeln('  default int offsetTween(Offset begin, Offset end, Animation parent) {');
    javaInterface.writeln('    throw new UnsupportedOperationException("offsetTween has no default (FFM/comm impl required)");');
    javaInterface.writeln('  }');
    // State read-back ops: the FFM impl reads the native struct; the comm impl reroutes through
    // EwtWebState (setState) or the captured widget, so these defaults are only hit if neither runs.
    for (final sig in const [
      'void subStateSetState(int id, Runnable fn)',
      'int subStateWidget(int id)',
      'void subAnimatedStateSetState(int id, Runnable fn)',
      'int subAnimatedStateWidget(int id)',
    ]) {
      javaInterface.writeln('  default $sig {');
      javaInterface.writeln('    throw new UnsupportedOperationException("state read-back requires FFM (java22)");');
      javaInterface.writeln('  }');
    }

    addTypeDefs();
    javaFactories.writeln('}');
    javaInterface.writeln('}');
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
        // Callback typedef processing keeps the analyzer's isOptional/nullable
        // distinction verbatim — relaxing `{required T?}` here would turn e.g.
        // `InputCounterWidgetBuilder`'s `maxLength` (required-named-nullable
        // `int?`) into a nullable C pointer with no matching pointer-marshaller
        // on either side (see the pre-existing bool-only fromCallback handling
        // in DartToC.apply / paramValueFFMtoJ). Widget-factory params relax by
        // default (issue #44); typedef params opt out.
        typedefFile.writeln('typedef ${CLang(types).field(ourName, types.type4C(fnType.returnType), params: allParams, relaxOnSurface: false)}');
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
          // ffigen emits a `Dart<Alias>FFIFunction` type only when the Dart
          // callable form differs from the native form — that's when ANY
          // slot is `ffi.Void` / `ffi.Int` / `ffi.Double` / `ffi.Bool` (Dart
          // versions drop the `ffi.` prefix). If every slot stays
          // pointer-shaped (String → `Pointer<Char>`, ObjSt → struct), the
          // plain `<Alias>FFIFunction` IS the Dart callable and ffigen
          // skips the `Dart` variant — so emitting `Dart<Alias>FFIFunction`
          // in that case fails to compile (see FormFieldValidator<String>).
          DartType _substTypeParam(DartType t) {
            if (t is TypeParameterType && td.typeArguments.isNotEmpty) {
              final idx = td.element.typeParameters
                  .indexWhere((p) => p == t.element);
              if (idx >= 0 && idx < td.typeArguments.length) {
                return td.typeArguments[idx];
              }
            }
            return t;
          }
          bool _isPointerShaped(DartType t) =>
              _substTypeParam(t).isDartCoreString; // char* → Pointer<Char> —
                                                   // only known collapse today.
          final _allSlotsPointerShaped =
              _isPointerShaped(fnType.returnType) &&
              fnType.parameters.every((p) => _isPointerShaped(p.type));
          final _dartFnTypeName = _allSlotsPointerShaped
              ? '${aliasName}FFIFunction'
              : 'Dart${aliasName}FFIFunction';
          dartFactories.writeln(
                  'extension on $ourName {\n'
                  '  $retType to${aliasName}Fn$tp() {\n'
                  // '    return (${fnType}) {\n'
                  // '    return (${boundParams.map((p) => '${p.type} ${ensureName(p)}').join(', ')}) {\n'
                  '    return (${boundPositionalParams.map((p) => '${_dartTypeStr(p.type)} ${ensureName(p)}').join(', ')}${boundNamedParams.isNotEmpty ?', {${boundNamedParams.map((p) => '${p.isRequiredNamed ? 'required ' : ''}${_dartTypeStr(p.type)} ${ensureName(p)}').join(', ')}}' : ''}) ${needsScope ? '=> _runBuildScope(() ' : ''}{\n'
                  '      $_dartFnTypeName dFn = asFunction();\n'
                  '      ${fnType.returnType is! VoidType ? 'final dFnRet = ' : ''}dFn(${allParams.map((p) => Params.paramValueDtoC(types, p, fromCallback: true)).join(', ')});');
          if (fnType.returnType is! VoidType) {
            // Bind `T` in the return type against the alias's type arguments
            // so `ValueGetter<Future<bool>>`'s return marshals via
            // `_widgetsMap[dFnRet]! as Future<bool>` (the concrete Future path)
            // instead of `return dFnRet` — which pushes an int through a
            // `Future<bool>` return slot.
            final boundReturn = _substTypeParam(fnType.returnType);
            dartFactories.writeln(
                  '      return ${Params.paramValue4D(types, paramElement('dFnRet', boundReturn))};');
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
    if (widGen.ctx.javaInterface.isNotEmpty) {
      javaInterface.writeln(widGen.ctx.javaInterface);
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
    _writeJ('WidgetConstructors', javaInterface.toString());
    _writeJ('FfmWidgetConstructors', javaFactories.toString());
    _writeJ('EWT', javaStatics.toString());
    _writeJ('SerializingWidgetConstructors', _buildSerializingClass(javaSerializer.toString()));
    _writeWW('factories_web_gen.dart', _buildWebDecoders(dartWebDecoders.toString()));

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
import dev.equo.ewt.util.*;
import dev.equo.ewt.web.EwtNode;
import java.util.*;
import java.util.function.*;
public class SerializingWidgetConstructors implements WidgetConstructors {
  private int nextId = 1;
  private int nextCallbackId = 1;
  private final Map<Integer, EwtNode> byId = new HashMap<>();
  public Map<Integer, EwtNode> nodes() { return byId; }
  private final Map<Integer, Object> callbacks = new HashMap<>();
  public Map<Integer, Object> callbacks() { return callbacks; }
  final Map<Integer, Function<BuildContext, Widget>> deferredStateless = new java.util.LinkedHashMap<>();
  final Map<Integer, Supplier<State>> deferredStateful = new java.util.LinkedHashMap<>();
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
  // java-11 split: no arena to release (foreign-free serializer); no-op close for AutoCloseable callers.
  public void close() {}
$overrides
  /** Called by rebuildAnimated to claim an AnimationController id in this serializer so SubStateless
   *  placeholder ids cannot collide with it. The stub carries only ctrlId; the Dart side matches
   *  the existing controller by ctrlId and reuses it, so duration/self are not needed on rebuild. */
  void preregisterAnimationController(int ctrlId) {
    if (nextId <= ctrlId) nextId = ctrlId + 1;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("ctrlId", ctrlId);
    record(ctrlId, "subAnimatedStateAnimationController", p);
  }
  // Animation<T> params cannot be auto-generated (parameterised type); hand-maintained in gen.dart.
  @Override
  public int subAnimatedStateAnimationController(SubAnimatedState self, Duration duration) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("ctrlId", id);
    p.put("self", byId.get(self.getId()));
    p.put("duration", byId.get(duration.getId()));
    record(id, "subAnimatedStateAnimationController", p);
    return id;
  }
  @SuppressWarnings("unchecked")
  public void resolveDeferred(BuildContext ctx, java.util.List<Object> nestedStatesOut) {
    resolveDeferred(ctx, nestedStatesOut, null);
  }
  /** Web-mode overload: {@code animSink} is set on each nested SubAnimatedState BEFORE its
   *  initState runs, so controller commands issued there (e.g. forward()) route out the same
   *  way the root's do — buffered-then-replayed by the region. Without it a nested controller
   *  has no sink registered and every command is dropped. */
  @SuppressWarnings("unchecked")
  public void resolveDeferred(BuildContext ctx, java.util.List<Object> nestedStatesOut, java.util.function.Consumer<String> animSink) {
    while (!deferredStateless.isEmpty() || !deferredStateful.isEmpty()) {
      var ssSnap = new java.util.LinkedHashMap<>(deferredStateless);
      var sfSnap  = new java.util.LinkedHashMap<>(deferredStateful);
      deferredStateless.clear();
      deferredStateful.clear();
      for (var e : ssSnap.entrySet()) {
        int pid = e.getKey();
        Widget built = ((Function<BuildContext, Widget>) e.getValue()).apply(ctx);
        EwtNode resolved = byId.get(built.getId());
        byId.put(pid, resolved);
        replaceInAll(pid, resolved);
      }
      for (var e : sfSnap.entrySet()) {
        int pid = e.getKey();
        SubStatefulWidget ownerWidget = SubclassedInJava.getSubNatObj(pid);
        if (ownerWidget == null) continue;
        Object stateObj = ownerWidget.createStateFn();
        EwtNode resolved;
        if (stateObj instanceof SubState<?>) {
          SubState<?> ss = (SubState<?>) stateObj;
          ss.setWebWidget(ownerWidget);
          ss.initStateFn();
          Widget built = ss.buildFn(ctx);
          resolved = byId.get(built.getId());
          nestedStatesOut.add(ss);
        } else if (stateObj instanceof SubAnimatedState<?>) {
          SubAnimatedState<?> as = (SubAnimatedState<?>) stateObj;
          as.setWebWidget(ownerWidget);
          if (animSink != null) as.setWebAnimCommandSink(animSink);
          as.initStateFn();
          Widget built = as.buildFn(ctx);
          resolved = byId.get(built.getId());
          nestedStatesOut.add(as);
        } else { continue; }
        byId.put(pid, resolved);
        replaceInAll(pid, resolved);
      }
    }
  }
  private void replaceInAll(int oldId, EwtNode replacement) {
    for (EwtNode node : byId.values())
      replaceInParams(node.params(), oldId, replacement);
  }
  @SuppressWarnings("unchecked")
  private void replaceInParams(java.util.Map<String, Object> params, int oldId, EwtNode replacement) {
    for (var e : params.entrySet()) {
      Object v = e.getValue();
      if (v instanceof EwtNode && ((EwtNode) v).id() == oldId) e.setValue(replacement);
      else if (v instanceof java.util.List<?>) replaceInList((java.util.List<Object>) v, oldId, replacement);
    }
  }
  @SuppressWarnings("unchecked")
  private void replaceInList(java.util.List<Object> list, int oldId, EwtNode replacement) {
    for (int i = 0; i < list.size(); i++) {
      Object v = list.get(i);
      if (v instanceof EwtNode && ((EwtNode) v).id() == oldId) list.set(i, replacement);
      else if (v instanceof java.util.List<?>) replaceInList((java.util.List<Object>) v, oldId, replacement);
    }
  }
  // Animation<Offset> — serializes begin/end offsets + parent for Tween<Offset>.animate() on the Dart side.
  @Override
  public int offsetTween(Offset begin, Offset end, Animation parent) {
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
// `SemanticsInputType` / `SemanticsValidationResult` / `SemanticsHitTestBehavior`
// are exposed from `dart:ui`, not from any Flutter facade — SliverSemantics
// decoders reference them by bare name so add them to the ui import.
import 'dart:ui' show ColorSpace, ImageFilter, SemanticsHitTestBehavior, SemanticsInputType, SemanticsValidationResult;
import 'decode.dart';
import 'callbacks.dart';

WidgetStateProperty<T>? _wspNul<T>(T? v) =>
    v == null ? null : WidgetStatePropertyAll<T>(v);

final Map<String, Object? Function(Map<String, dynamic> p)> webFactories = {
$entries
  // SubmenuButton and PopupMenuButton are excluded from auto web decoding
  // (MenuController + itemBuilder returns a value); hand-maintained here.
  'submenuButtonSubmenuButton': (p) => SubmenuButton(
      onHover: ewtWireValueCallback(p['onHover']),
      onFocusChange: ewtWireValueCallback(p['onFocusChange']),
      onOpen: ewtWireCallback(p['onOpen']),
      onClose: ewtWireCallback(p['onClose']),
      alignmentOffset: p['alignmentOffset'] == null ? null : decodeEwtNode(p['alignmentOffset'] as Map<String,dynamic>) as Offset,
      clipBehavior: p['clipBehavior'] == null ? Clip.none : Clip.values[p['clipBehavior'] as int],
      leadingIcon: p['leadingIcon'] == null ? null : decodeEwtWidget(p['leadingIcon'] as Map<String,dynamic>),
      trailingIcon: p['trailingIcon'] == null ? null : decodeEwtWidget(p['trailingIcon'] as Map<String,dynamic>),
      useRootOverlay: (p['useRootOverlay'] as bool?) ?? false,
      menuChildren: ((p['menuChildren'] as List?) ?? const []).map((e) => decodeEwtWidget(e as Map<String,dynamic>)).toList(),
      child: decodeEwtWidget(p['child'] as Map<String,dynamic>)),
  'popupMenuButtonPopupMenuButton': (p) => PopupMenuButton(
      itemBuilder: (context) => [],
      onOpened: ewtWireCallback(p['onOpened']),
      onCanceled: ewtWireCallback(p['onCanceled']),
      tooltip: p['tooltip'] as String?,
      elevation: (p['elevation'] as num?)?.toDouble(),
      shadowColor: p['shadowColor'] == null ? null : decodeEwtNode(p['shadowColor'] as Map<String,dynamic>) as Color,
      surfaceTintColor: p['surfaceTintColor'] == null ? null : decodeEwtNode(p['surfaceTintColor'] as Map<String,dynamic>) as Color,
      padding: p['padding'] == null ? const EdgeInsets.all(8.0) : decodeEwtNode(p['padding'] as Map<String,dynamic>) as EdgeInsets,
      clipBehavior: p['clipBehavior'] == null ? Clip.none : Clip.values[p['clipBehavior'] as int],
      enabled: (p['enabled'] as bool?) ?? true,
      icon: p['icon'] == null ? null : decodeEwtWidget(p['icon'] as Map<String,dynamic>),
      iconSize: (p['iconSize'] as num?)?.toDouble(),
      offset: p['offset'] == null ? Offset.zero : decodeEwtNode(p['offset'] as Map<String,dynamic>) as Offset,
      color: p['color'] == null ? null : decodeEwtNode(p['color'] as Map<String,dynamic>) as Color,
      iconColor: p['iconColor'] == null ? null : decodeEwtNode(p['iconColor'] as Map<String,dynamic>) as Color,
      enableFeedback: p['enableFeedback'] as bool?,
      useRootNavigator: (p['useRootNavigator'] as bool?) ?? false,
      child: p['child'] == null ? null : decodeEwtWidget(p['child'] as Map<String,dynamic>)),
  // Animation<T> params cannot be auto-generated (parameterised type); hand-maintained in gen.dart.
  'subAnimatedStateAnimationController': (p) {
    final ctrlId = p['ctrlId'] as int;
    final registry = ewtActiveControllerRegistry;
    final vsync = ewtActiveTickerProvider;
    if (registry == null || vsync == null) {
      debugPrint('EWT: subAnimatedStateAnimationController outside animated region (ctrlId=\$ctrlId)');
      return null;
    }
    // duration is only needed when creating a new controller; on rebuild the stub omits it.
    return registry.putIfAbsent(ctrlId, () {
      final duration = decodeEwtNode(p['duration'] as Map<String, dynamic>) as Duration;
      return AnimationController(vsync: vsync, duration: duration);
    });
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
    // For non-widget primitive returns (String / int / bool / double / enum),
    // the C typedef must use the primitive's C type (e.g. `char*` for String)
    // rather than DartObj — otherwise the value would be treated as a widget
    // id and neither side would know how to unmarshal it. `type4C` resolves
    // primitives correctly; widget/ObjSt returns still route through
    // `getGen().objType()`.
    final cRet = _isPrimitiveReturn(node.returnType)
        ? types.type4C(node.returnType)
        : types.getGen(node.returnType.element!).objType();
    headerFile.writeln('  ${CLang(types).field(factory, cRet, params: sortParameters(node))}');
    writeDFactory(factory, factoryName, node);
    writeJavaFactoryForStatic(node, factoryName, factory);
  }

  bool _isPrimitiveReturn(DartType t) =>
      isPrimitive(t) || t.element is EnumElement;

  void writeDFactory(String factory, String factoryName, TopLevelFunctionElement node) {
    var gen = types.getGen(node.returnType.element!);
    final ret = node.returnType;
    final dartParams = Params(types, sortParameters(node), Params.paramDef4D, paramValue: Params.paramValue4D);
    var nullabilitySuffix = ret.nullabilitySuffix == NullabilitySuffix.question ? '?' : '' ;

    // Pick the Dart-side return type + body based on what the C typedef will
    // carry (see `_isPrimitiveReturn` in writeTopLevelFactory). ObjSt returns
    // wrap through `_create<X>ObjSt`; primitives cross as their raw FFI type;
    // widget/opaque returns cross as a widget id via `_addWidget`.
    final String dartRetType;
    final String dartRetBody;
    if (gen.objType().endsWith('ObjSt')) {
      dartRetType = '${gen.objType()}$nullabilitySuffix';
      dartRetBody = ret.nullabilitySuffix == NullabilitySuffix.question
          ? '  return w != null ? _create${gen.objType()}(w) : null;'
          : '  return _create${gen.objType()}(w);';
    } else if (ret.element is EnumElement) {
      dartRetType = 'int';
      dartRetBody = '  return w.index;';
    } else if (ret.isDartCoreString) {
      // Allocate a C string owned by the caller. C typedef says `char*`
      // (Dart FFI's `Pointer<Char>`), so cast from the utf8 variant.
      // Java receives a MemorySegment and reads via .getString(0).
      dartRetType = 'ffi.Pointer<ffi.Char>';
      dartRetBody = ret.nullabilitySuffix == NullabilitySuffix.question
          ? '  return w == null ? ffi.nullptr : w.toNativeUtf8().cast<ffi.Char>();'
          : '  return w.toNativeUtf8().cast<ffi.Char>();';
    } else if (ret.isDartCoreBool) {
      dartRetType = 'int';
      dartRetBody = '  return w ? 1 : 0;';
    } else if (isPrimitive(ret)) {
      dartRetType = types.type4DRet(ret);
      dartRetBody = '  return w;';
    } else {
      dartRetType = 'int';
      dartRetBody = '  return _addWidget(w);';
    }

    dartFactories
      ..writeln('$dartRetType $factoryName(${dartParams.decl}) {')
      ..writeln('  final w = $factory(${dartParams.names});')
      ..writeln(dartRetBody)
      ..writeln('}');
  }

  void writeJavaFactoryForStatic(TopLevelFunctionElement node, String factoryName, String factory) {
    List<ParameterElement> allParams = sortParameters(node);
    var params = allParams.where((p) => !p.isOptionalOnSurface).toList();
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
    var isObjSt = gen.objType().endsWith('ObjSt');
    var invoke = 'WidgetFactories.$factory.invoke(${['fn${isObjSt ? ', arena' : ''}', jParamsFFM.names.nullIfEmpty].nonNulls.join(', ')})';
    var tp = JLang().methodTypeParameters(node.type);
    // java-11 split: the core/comm surface can't expose FFM types. Widget/value-object returns marshal
    // as a foreign-free int id (read off the ObjSt struct); String helpers (char*) convert to a Java
    // String inside the FFM impl; primitives pass through. The interface default + comm impl throw.
    String surface;
    String retExpr;
    if (isObjSt) {
      surface = 'int';
      // java-11 split: retain(...) stashes the built struct for read-back, returns the foreign-free id.
      retExpr = 'retain($invoke, ${gen.objType()}::id)';
    } else if (node.returnType.isDartCoreString) {
      surface = 'String';
      retExpr = '$invoke.getString(0)';
    } else {
      surface = types.type4FFMRet(node.returnType);
      retExpr = invoke;
    }
    javaFactories
      ..writeln('  public ${tp}$surface $factoryName(${jParams.decl}) {')
      ..writeln('    var fn = WidgetFactories.$factory(factories);')
      ..writeln('    return $retExpr;')
      ..writeln('  }');
    javaInterface
      ..writeln('  default ${tp}$surface $factoryName(${jParams.decl}) {')
      ..writeln('    throw new UnsupportedOperationException("$factoryName has no default (FFM/comm impl required)");')
      ..writeln('  }');
  }

  void writeJavaInstanceBody(String factoryName, Params jParams, TopLevelFunctionElement node) {
    // Local named `_ret` (not `id`): some top funcs take an `id` param, e.g. widgetTypeOf(int id).
    if (node.returnType.isDartCoreString) {
      // java-11 split: String helpers (type registry) — the resolved impl returns the Java String directly.
      javaStatics.writeln('    return NativeObj.Base.factories.$factoryName(${jParams.names});');
      return;
    }
    javaStatics
      // java-11 split: call the resolved impl (FFM on 22+, comm below) via NativeObj.Base.factories,
      // which returns a foreign-free int id. Keeps EWT statics free of any direct FFM reference.
      ..writeln('    int _ret = NativeObj.Base.factories.$factoryName(${jParams.names});')
      ..writeln('    if (_ret <= 0) throw new RuntimeException("Failed to created widget ${node.returnType}");')
      ..writeln('    return ${types.paramValueFFMtoJ(types, paramElement('_ret', node.returnType))};');
  }

}
