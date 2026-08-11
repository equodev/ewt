part of '../gen.dart';

/// Dart-side emitters: FFI factory registration (writes into
/// [EmitContext.dartAssigns] and [EmitContext.dartFns]) for instance methods
/// on a companion class. Constructor factories (`writeDFactory`) stay in
/// gen.dart because SubclassGen overrides them, and extensions do not
/// participate in virtual dispatch.
extension _DartEmit on WidgetGen {
  void writeDInstanceMethod(String factory, String factoryName, FunctionTypedElement node, String companionClassName) {
    var gen = node.returnType is! VoidType ? types.getGen(node.returnType.element!) : null;
    final dartParams = Params(types, node.parameters, Params.paramDef4D, paramValue: Params.paramValue4D);
    ctx.dartAssigns
        .writeln('  f.$widgetField.$factory = ffi.Pointer.fromFunction($factoryName${gen == null || node.returnType.isDartCoreString || gen.objType().endsWith('ObjSt') ? '' : ', ${exception(node.returnType)}'});');
    ctx.dartFns
      ..writeln('${types.type4DRet(node.returnType)} $factoryName(${dartParams.decl}) {')
      ..writeln('  ${gen == null ? '' : 'final w = '}$companionClassName.$factory(${dartParams.names});');
    if (gen == null) {
    } else if (gen.objType().endsWith('ObjSt')) {
      ctx.dartFns.writeln('  return _create${gen.objType()}(w);');
    } else {
      ctx.dartFns.writeln('  return ${Params.paramValueDtoC(types, paramElement('w', node.returnType))};');
    }
    ctx.dartFns.writeln('}');
  }
}

/// Dart emitters specific to ObjStGen: the two ends of a `_create*ObjSt`
/// function body that materializes an id-only struct.
extension _ObjStDartEmit on ObjStGen {
  /// Emits the head of a _create*ObjSt function body.
  void writeDartStructCreation(String widgetVar) {
    ctx.dartFns
      ..writeln('  final $widgetSt stObj = ffi.Struct.create();')
      ..writeln('  stObj.id = _addWidget($widgetVar);');
  }

  /// Emits the tail (return + closing brace) of a _create*ObjSt function body.
  void writeDartStructReturn() {
    ctx.dartFns
      ..writeln('  return stObj;')
      ..writeln('}');
  }
}
