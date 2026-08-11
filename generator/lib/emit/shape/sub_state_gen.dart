part of '../../gen.dart';

/// Emitter for the user-subclassable `SubState<T>` base class.
///
/// Overrides three [SubclassGen] hooks:
///   * [emitSetStateWebPrelude] — web-mode setState reroutes through
///     `EwtWebState.requestRebuild(this)` instead of the FFM path.
///   * [emitStateWidgetAccessor] — synthesizes `T widget()` that returns
///     the tracked wrapper in web mode and the FFM-fetched widget natively.
///   * [emitExtraStateJavaMembers] — private `webWidget` field set by
///     EwtWebCapture during the web-mode flatten pass.
class SubStateGen extends SubclassGen {
  SubStateGen(super.types, super.dartClass);

  @override
  void emitSetStateWebPrelude() {
    ctx.javaFile
      ..writeln('    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {')
      ..writeln('      fn.run();')
      ..writeln('      EwtWebState.requestRebuild(this);')
      ..writeln('      return;')
      ..writeln('    }');
  }

  @override
  void emitStateWidgetAccessor() {
    // `State<T>.widget` is a TypeParameterType field, which getCallableFields
    // intentionally filters out (so Radio<T>.value etc. don't blow up
    // ImmutableGen). Emit it here with `T` preserved and add the matching
    // struct field so jextract produces SubStateObjSt.widget.
    ctx.objectsHFile.writeln('  DartObj (*widget)(void);');
    ctx.javaFile
      ..writeln('  @SuppressWarnings("unchecked")')
      ..writeln('  public T widget() {')
      ..writeln('    if (dev.equo.ewt.web.EwtWebTransport.isWebMode() && webWidget != null) {')
      ..writeln('      return (T) webWidget;')
      ..writeln('    }')
      ..writeln('    MemorySegment funcPtr = $widgetSt.widget(st);')
      ..writeln('    return SubclassedInJava.getSubNatObj($widgetSt.widget.invoke(funcPtr));')
      ..writeln('  }');
  }

  @override
  void emitExtraStateJavaMembers() {
    ctx.javaFile
      ..writeln('  private SubStatefulWidget webWidget; // set by EwtWebCapture during web-mode flatten')
      ..writeln('  void setWebWidget(SubStatefulWidget w) { this.webWidget = w; }');
  }
}
