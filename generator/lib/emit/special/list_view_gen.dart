part of '../../gen.dart';

/// Emitter for `ListView` — the base class is a stock widget, but the
/// `.builder` named constructor eager-expands its `itemBuilder` into a
/// plain `listViewListView` node at serialize time so the browser can
/// decode it with the standard ListView decoder without ever seeing the
/// builder callback.
///
///   * [tryEmitCustomJavaSerializer] emits a bespoke @Override for
///     `.builder` that iterates itemCount and calls itemBuilder, storing
///     the resulting child ids under the "children" key.
///   * [tryEmitCustomWebDecoder] returns true for `.builder` without
///     writing anything — the eager-expanded node uses the ListView
///     constructor decoder, so no builder-specific decoder is needed.
class ListViewGen extends ImmutableGen {
  ListViewGen(super.types, super.dartClass);

  @override
  bool tryEmitCustomJavaSerializer(
    FunctionTypedElement node,
    String factoryName,
    String factory,
    Params jParamsFFM,
    String jtp,
    String? objStClass,
  ) {
    if (factory != 'builder') return false;
    final retType = types.type4FFMRet(node.returnType);
    ctx.javaSerializer
      ..writeln('  @Override')
      ..writeln('  $jtp$retType $factoryName(${jParamsFFM.decl}) {')
      ..writeln('    int id = nextId++;')
      ..writeln('    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();')
      ..writeln('    if (itemCount.isPresent()) {')
      ..writeln('      java.util.List<Object> __children = new java.util.ArrayList<>();')
      ..writeln('      BuildContext __ctx = EwtWebCapture.stubContext();')
      ..writeln('      for (int __i = 0; __i < itemCount.getAsInt(); __i++) {')
      ..writeln('        Widget __w = itemBuilder.apply(__ctx, __i);')
      ..writeln('        if (__w == null) break;')
      ..writeln('        __children.add(byId.get(__w.getId()));')
      ..writeln('      }')
      ..writeln('      p.put("children", __children);')
      ..writeln('    }');
    for (final param in node.parameters.where((p) => types.supportedType(p.type) && !hasPrivateDefault(p))) {
      if (param.name == 'itemBuilder' || param.name == 'itemCount') continue;
      final stmt = Params.paramValueSerialize(types, param);
      if (stmt.isNotEmpty) ctx.javaSerializer.writeln('    $stmt');
    }
    ctx.javaSerializer
      ..writeln('    record(id, "listViewListView", p);')
      ..writeln('    MemorySegment st = ${objStClass!}.allocate(arena);')
      ..writeln('    $objStClass.id(st, id);')
      ..writeln('    return st;')
      ..writeln('  }');
    return true;
  }

  @override
  bool tryEmitCustomWebDecoder(String factory, String factoryName, FunctionTypedElement node) =>
      factory == 'builder';
}
