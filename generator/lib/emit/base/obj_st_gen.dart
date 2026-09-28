part of '../../gen.dart';

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
    // No FFM imports: the builder is foreign-free (int-id handle). `factories` and `intToBool` come
    // inherited from NativeObj.Base, so the class carries no reference to the FFM layer and compiles
    // at a lower release than the FFM impl.
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
      // java-11 split: build the value-object from its foreign-free int id (no ObjSt struct).
      ctx.javaFile.writeln('      return new $retJ(__nid);');
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

    // java-11 split: delegate the FFM read-back to the FFM impl, which owns the foreign struct read.
    // The core getter hands this widget's native struct (an Object) across; on comm the branch above
    // already returned, and the interface default throws on a pre-22 JVM (no FFM).
    //
    // The SPI method name is `<WidgetClass>_readBack_<field>`, NOT the web `factoryName`: the latter
    // concatenates widgetField + Field and can collide across widgets (e.g. tabPageSelector+IndicatorSize
    // == tabPageSelectorIndicator+Size), which is harmless for a message string but not for a method on
    // the shared interface. The `_readBack_` delimiter + the unique class name keep this unambiguous.
    final readSpi = '${widgetClass}_readBack_${field.name}';
    ctx.javaFile.writeln('    return factories.$readSpi(nativeStruct);');
    ctx.javaFile.writeln('  }');

    // FFM impl of the read SPI: cast the struct back and run the native field read (as main did inline).
    // A nested ObjSt field reads as its embedded struct (MemorySegment), not an int id — convert it to
    // an id for the foreign-free wrapper. When that wrapper is built via `new Type(int)` (concrete class),
    // retain() also hands it the nested struct so its own read-back getters work (chain read-back);
    // for the anonymous/subclassed wrappers (no int ctor) just read the id, no struct to adopt.
    final buildsViaIntCtor = !types.hasSubClassInJava(field.type) && !isInterface(field.type.element);
    String readVal(String structAccess) => !isObjSt
        ? structAccess
        : (buildsViaIntCtor ? 'retain($structAccess, $objType::id)' : '$objType.id($structAccess)');
    ctx.javaFactories.writeln('  public $retJ $readSpi(Object __stObj) {');
    ctx.javaFactories.writeln('    java.lang.foreign.MemorySegment st = (java.lang.foreign.MemorySegment) __stObj;');
    if (useInvoke) {
      ctx.javaFactories
        ..writeln('    java.lang.foreign.MemorySegment funcPtr = $widgetSt.${field.name}(st);')
        ..writeln('    return ${types.paramValueFFMtoJ(types, paramElement(readVal('$widgetSt.${field.name}.invoke(funcPtr)'), field.type))};');
    } else {
      ctx.javaFactories.writeln('    return ${types.paramValueFFMtoJ(types, paramElement(readVal('$widgetSt.${field.name}(st)'), field.type))};');
    }
    ctx.javaFactories.writeln('  }');

    // Interface default: the FFM impl always overrides; comm never reaches here (web branch handles it).
    ctx.javaInterface.writeln('  default $retJ $readSpi(Object st) {');
    ctx.javaInterface.writeln('    throw new UnsupportedOperationException("$readSpi read-back requires FFM/java22");');
    ctx.javaInterface.writeln('  }');
  }


  /// Shared callable fields filter logic
  Iterable<FieldElement> getCallableFields(ClassElement sourceClass) =>
      sourceClass.fields.where((f) =>
          !f.getter!.hasOverride && f.isPublic && !f.isStatic
          && f.type is! FunctionType && f.type is! TypeParameterType
          && !f.type.isDartCoreList && !f.type.isDartCoreObject
          /*&& !isInterface(f.type.element)*/ && types.supportedType(f.type) && f.type != sourceClass.thisType
          // Value-handler fields (e.g. WidgetStatePropertyHandler) marshal to the
          // inner type in the *forward* direction (Java-set → Flutter-ctor). The
          // *reverse* direction (Flutter widget instance → ObjSt struct →
          // Java accessor) has no clean shape: the Flutter field holds a WSP
          // wrapper, not the inner T, so it can't populate an inline `IconObjSt`
          // slot or a primitive `double` slot without an additional
          // `.resolve(const {})` unwrap that we don't emit today. Skip.
          && (types.getHandler(f.type)?.unwrapParam(paramElement(f.name, f.type)) == null));
}
