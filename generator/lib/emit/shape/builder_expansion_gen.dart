part of '../../gen.dart';

/// Emitter for widgets that expose a `.builder` factory constructor
/// (`itemBuilder` + `itemCount`). Its Java serializer eager-expands the
/// builder callback by walking `itemCount` and calling `itemBuilder(ctx, i)`
/// for each index, collecting the resulting child node ids under the
/// `"children"` key of a node record — the browser then decodes the
/// result with the widget's plain (non-`.builder`) constructor decoder,
/// bypassing the builder callback entirely.
///
/// Currently reached by `ListView`; the same shape applies to any Flutter
/// widget with the (`.builder`, `itemBuilder`, `itemCount`) triplet —
/// `GridView.builder`, `PageView.builder`, `SliverList.builder`,
/// `ReorderableListView.builder`, `AnimatedList`, etc. Dispatch happens
/// structurally in [Types.getGen] via [_hasIndexedBuilderFactory] so
/// adding one of those to the index routes here for free.
class BuilderExpansionGen extends ImmutableGen {
  BuilderExpansionGen(super.types, super.dartClass);

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
    // The eager-expanded node uses the plain constructor's factory name,
    // which is `${widgetField}${widgetClass}` — e.g. `listViewListView` for
    // ListView, `gridViewGridView` for GridView.
    final defaultFactoryName = '$widgetField$widgetClass';
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
      ..writeln('    record(id, "$defaultFactoryName", p);')
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
