part of '../../gen.dart';

/// Emitter for Flutter controllers with imperative void methods that
/// must route to a web-mode side-channel when running off-native.
///
/// Currently used for `AnimationController` (see [forAnimationController]),
/// but the shape is generic enough to cover any controller that:
///   * needs a small block of extra Java members appended before `build()`
///     (typically a webCommand infrastructure + one or two overloads);
///   * has void methods that in web mode should short-circuit into a
///     `webCommand("$factory")` call rather than the FFM path;
///   * optionally has one or two "special" void methods whose argument
///     needs marshalling (AnimationController's `setDuration` marshals a
///     Duration to milliseconds before routing).
///
/// To add another controller (e.g. `ScrollController`, `TabController`,
/// `PageController`), give it its own factory constructor on this class
/// or route to a new instance from [Types.getGen] with the specific
/// [extraJavaBody] and [durationMarshalMethods]. No further subclass
/// needed.
class ImperativeControllerGen extends WidgetGen {
  /// Java lines emitted verbatim between the ctors and `build()`.
  /// Each entry is one line (no trailing newline).
  final List<String> extraJavaBody;

  /// Void-method factory names whose single argument is a Duration and
  /// should be marshalled to milliseconds before routing to `webCommand`.
  /// All other void methods route as plain `webCommand("$factory")`.
  final Set<String> durationMarshalMethods;

  ImperativeControllerGen(
    super.types,
    super.dartClass, {
    required this.extraJavaBody,
    this.durationMarshalMethods = const {},
  });

  /// Configured for Flutter's [AnimationController] — its
  /// `setDuration` / `setReverseDuration` marshal a Duration to ms, all
  /// other void methods (stop, forward, reverse, reset, dispose, …)
  /// route via plain webCommand. The extra body wires the
  /// `SubAnimatedState`-owner side channel and the `repeat(boolean)`
  /// overload that the FFI factory doesn't emit itself.
  factory ImperativeControllerGen.forAnimationController(Types types, ClassElement dartClass) {
    return ImperativeControllerGen(
      types,
      dartClass,
      durationMarshalMethods: const {'setDuration', 'setReverseDuration'},
      extraJavaBody: const [
        '  /** Set in web mode by SubAnimatedState.animationController() so commands can route back. */',
        '  private SubAnimatedState<?> webOwner;',
        '  void setWebOwner(SubAnimatedState<?> owner) { this.webOwner = owner; }',
        '  private void webCommand(String action) {',
        '    if (webOwner != null) webOwner.sendAnimCommand(this.id, action);',
        '    else System.out.println("EWT web: AnimationController " + id + " has no owner for action=" + action);',
        '  }',
        '  public void repeat(boolean reverse) {',
        '    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) { webCommand(reverse ? "repeat:reverse" : "repeat"); return; }',
        '    if (reverse) throw new UnsupportedOperationException(',
        '        "repeat(reverse=true) is not yet supported on the native path; call repeat() instead");',
        '    factories.animationControllerRepeat(this);',
        '  }',
      ],
    );
  }

  @override
  void writeExtraJavaClassBody() {
    for (final line in extraJavaBody) {
      ctx.javaFile.writeln(line);
    }
  }

  @override
  void writeVoidMethodWebPrelude(String factory) {
    if (durationMarshalMethods.contains(factory)) {
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
