part of '../../gen.dart';

/// Emitter for `SubAnimatedState<T>` — a SubState variant that also holds
/// an AnimationController. Overrides three [SubclassGen] hooks plus two
/// WidgetGen-level hooks that specifically handle its `animationController`
/// accessor.
class SubAnimatedStateGen extends SubclassGen {
  SubAnimatedStateGen(super.types, super.dartClass);

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
    // SubAnimatedState's widget() throws on web (the SubStatefulWidget
    // wrapper for animated states isn't synthesized by EwtWebCapture yet);
    // still emits the accessor + struct field for consistent shape.
    ctx.objectsHFile.writeln('  DartObj (*widget)(void);');
    ctx.javaFile
      ..writeln('  @SuppressWarnings("unchecked")')
      ..writeln('  public T widget() {')
      ..writeln('    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("subAnimatedStateWidget not supported on web");')
      ..writeln('    MemorySegment funcPtr = $widgetSt.widget(st);')
      ..writeln('    return (T) (NativeObj) new NativeObj.Base() {{ this.id = $widgetSt.widget.invoke(funcPtr); }};')
      ..writeln('  }');
  }

  @override
  void emitExtraStateJavaMembers() {
    ctx.javaFile
      ..writeln('  private SubStatefulWidget webWidget;')
      ..writeln('  void setWebWidget(SubStatefulWidget w) { this.webWidget = w; }')
      ..writeln('  private java.util.function.Consumer<String> webAnimCommandSink;')
      ..writeln('  public void setWebAnimCommandSink(java.util.function.Consumer<String> sink) { this.webAnimCommandSink = sink; }')
      ..writeln('  void sendAnimCommand(int ctrlId, String action) {')
      ..writeln('    if (webAnimCommandSink != null) webAnimCommandSink.accept("{\\"ctrlId\\":" + ctrlId + ",\\"action\\":\\"" + action + "\\"}");')
      ..writeln('    else System.out.println("EWT web: no anim sink on state for ctrl=" + ctrlId + " action=" + action);')
      ..writeln('  }')
      // Tracked controllers so rebuildAnimated can pre-seed their ids into a
      // fresh serializer, preventing SubStateless placeholder ids from
      // colliding with live AnimationController ids (see commit 132df17).
      ..writeln('  private final java.util.List<AnimationController> controllers = new java.util.ArrayList<>();')
      ..writeln('  /** Pre-registers stub AnimationController nodes in a fresh serializer to prevent id collisions')
      ..writeln('   *  during rebuildAnimated: each controller keeps its original id so the Dart side can match/reuse. */')
      ..writeln('  void preregisterControllers(SerializingWidgetConstructors ser) {')
      ..writeln('    for (AnimationController c : controllers) ser.preregisterAnimationController(c.getId());')
      ..writeln('  }');
  }

  /// `animationController` returns a controller wired to route web commands
  /// back to this state (`ctrl.setWebOwner(this)`), rather than the generic
  /// FFM unwrap. The returned controller is also tracked so
  /// [EwtWebCapture.rebuildAnimated] can pre-register its id and avoid
  /// collisions when re-serializing this state.
  @override
  bool tryWriteCustomInstanceMethodReturn(String factory, DartType returnType) {
    if (factory != 'animationController') return false;
    ctx.javaFile
      ..writeln('    AnimationController ctrl = new AnimationController(id);')
      ..writeln('    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) ctrl.setWebOwner(this);')
      ..writeln('    controllers.add(ctrl);')
      ..writeln('    return ctrl;');
    return true;
  }

  /// The `animationController` serializer is hand-maintained in gen.dart
  /// (via ctrlId tracking); skip the auto-generated @Override to avoid a
  /// duplicate declaration.
  @override
  bool skipJavaSerializer(String factory) => factory == 'animationController';
}
