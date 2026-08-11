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
