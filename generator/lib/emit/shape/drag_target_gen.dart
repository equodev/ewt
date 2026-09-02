part of '../../gen.dart';

/// Emitter for DragTarget. Its Java serializer eager-expands the `builder`
/// callback with empty candidateData/rejectedData lists to get the static
/// child widget for the non-drag case, storing it as `"child"` in the node
/// params. The Dart web decoder reconstructs a real DragTarget whose builder
/// always returns the pre-built child, so tap callbacks (from the child's
/// GestureDetectors) continue to work.
class DragTargetGen extends ImmutableGen {
  DragTargetGen(super.types, super.dartClass);

  @override
  bool tryEmitCustomJavaSerializer(
    FunctionTypedElement node,
    String factoryName,
    String factory,
    Params jParamsFFM,
    String jtp,
    String? objStClass,
  ) {
    if (factory != widgetField) return false;
    final retType = types.type4FFMRet(node.returnType);
    ctx.javaSerializer
      ..writeln('  @Override')
      ..writeln('  $jtp$retType $factoryName(${jParamsFFM.decl}) {')
      ..writeln('    int id = nextId++;')
      ..writeln('    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();')
      ..writeln('    Widget __child = builder.apply(EwtWebCapture.stubContext(), java.util.List.of(), java.util.List.of());')
      ..writeln('    p.put("child", byId.get(__child.getId()));');
    for (final param in relaxFactoryParams(node.parameters).where((p) => types.supportedType(p.type) && !hasPrivateDefault(p))) {
      if (param.name == 'builder') continue;
      final stmt = Params.paramValueSerialize(types, param);
      if (stmt.isNotEmpty) ctx.javaSerializer.writeln('    $stmt');
    }
    ctx.javaSerializer
      ..writeln('    record(id, "$factoryName", p);')
      ..writeln('    MemorySegment st = ${objStClass!}.allocate(arena);')
      ..writeln('    $objStClass.id(st, id);')
      ..writeln('    return st;')
      ..writeln('  }');
    return true;
  }

  @override
  bool tryEmitCustomWebDecoder(String factory, String factoryName, FunctionTypedElement node) {
    if (factory != widgetField) return false;
    ctx.dartWebDecoders.writeln(
      "  '$factoryName': (p) { final child = decodeEwtWidget(p['child'] as Map<String,dynamic>); return DragTarget(builder: (_, __, ___) => child); },",
    );
    return true;
  }
}
