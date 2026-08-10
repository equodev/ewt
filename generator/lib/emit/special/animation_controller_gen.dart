part of '../../gen.dart';

/// Emitter for Flutter's `AnimationController`.
///
/// Diverges from a stock widget in two spots — both used to be handled with
/// scattered `widgetClass == 'AnimationController'` branches:
///
/// 1. **Extra Java class body**: the web-mode plumbing (`webOwner`,
///    `webCommand`, and the `repeat(boolean)` overload) is emitted inside
///    the generated Java class, appended before the synthetic `build()`
///    method.
/// 2. **Void-method web prelude**: imperative setters like `stop()` /
///    `forward()` short-circuit in web mode by calling `webCommand("$factory")`.
///    `setDuration` / `setReverseDuration` additionally marshal their
///    Duration argument to milliseconds before dispatching.
class AnimationControllerGen extends WidgetGen {
  AnimationControllerGen(super.types, super.dartClass);

  @override
  void writeExtraJavaClassBody() {
    ctx.javaFile
      ..writeln('  /** Set in web mode by SubAnimatedState.animationController() so commands can route back. */')
      ..writeln('  private SubAnimatedState<?> webOwner;')
      ..writeln('  void setWebOwner(SubAnimatedState<?> owner) { this.webOwner = owner; }')
      ..writeln('  private void webCommand(String action) {')
      ..writeln('    if (webOwner != null) webOwner.sendAnimCommand(this.id, action);')
      ..writeln('    else System.out.println("EWT web: AnimationController " + id + " has no owner for action=" + action);')
      ..writeln('  }')
      ..writeln('  public void repeat(boolean reverse) {')
      ..writeln('    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) { webCommand(reverse ? "repeat:reverse" : "repeat"); return; }')
      ..writeln('    if (reverse) throw new UnsupportedOperationException(')
      ..writeln('        "repeat(reverse=true) is not yet supported on the native path; call repeat() instead");')
      ..writeln('    factories.animationControllerRepeat(this);')
      ..writeln('  }');
  }

  @override
  void writeVoidMethodWebPrelude(String factory) {
    if (factory == 'setDuration' || factory == 'setReverseDuration') {
      ctx.javaFile
        ..writeln('    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {')
        ..writeln('      long ms = EwtWebCapture.buildDurationMillis(d);')
        ..writeln('      if (ms >= 0) webCommand("$factory:" + ms);')
        ..writeln('      return;')
        ..writeln('    }');
    } else {
      ctx.javaFile.writeln('    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) { webCommand("$factory"); return; }');
    }
  }
}
