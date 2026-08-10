part of '../gen.dart';

/// C-side emitters: struct header/footer (per widget type) and per-factory
/// field lines. The header is written lazily on the first field so widgets
/// with zero C members skip the empty struct entirely.
extension _CEmit on WidgetGen {
  void _ensureStructOpened() {
    if (ctx.pendingStructHeader != null) {
      ctx.headerFile.writeln(ctx.pendingStructHeader);
      ctx.pendingStructHeader = null;
    }
  }

  void writeCFactory(String factory, FunctionTypedElement node, String retType) {
    _ensureStructOpened();
    ctx.headerFile.writeln('    ${CLang(types).field(factory, types.type4C(node.returnType), params: node.parameters)}');
  }
}

/// C emitters specific to ObjStGen — the ObjSt struct declaration in
/// `objects.h` that mirrors a widget's identity table.
extension _ObjStCEmit on ObjStGen {
  /// Writes the structure header and id field to ctx.objectsHFile.
  void writeStructHeader() {
    ctx.objectsHFile.writeln('typedef struct {');
    ctx.objectsHFile.writeln('  ${CLang(types).field('id', 'int')}');
  }

  /// Writes the structure footer to ctx.objectsHFile.
  void writeStructFooter() {
    ctx.objectsHFile.writeln('} $widgetSt;');
  }
}
