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
    this.futureAsyncMethods = const {},
    this.durationArgMethods = const {},
  });

  /// Configured for Flutter's [AnimationController] — its
  /// `setDuration` / `setReverseDuration` marshal a Duration to ms, all
  /// other void methods (stop, forward, reverse, reset, dispose, …)
  /// route via plain webCommand. The extra body wires the
  /// `SubAnimatedState`-owner side channel, the `repeat(boolean)` overload
  /// that the FFI factory does not emit itself, and the `webAsyncCommand`
  /// helper that Future-returning methods route through in web mode.
  factory ImperativeControllerGen.forAnimationController(Types types, ClassElement dartClass) {
    return ImperativeControllerGen(
      types,
      dartClass,
      durationMarshalMethods: const {'setDuration', 'setReverseDuration'},
      // Methods whose Dart return is TickerFuture and whose surface is exposed
      // to Java as `Future<Object?>`. Names match the companion static method
      // names — see generator/lib/animation_controller_methods.dart.
      futureAsyncMethods: const {
        'forward', 'reverse', 'repeat', 'toggle', 'fling',
        'animateTo', 'animateBack',
      },
      // Companion methods whose non-primitive arg is a Duration positioned at
      // index 1 (0 is `self`). The web prelude converts each to ms before
      // sending; the web side (evolve-app) rebuilds the Duration on arrival.
      durationArgMethods: const {'animateTo', 'animateBack'},
      extraJavaBody: const [
        '  /** Set in web mode by SubAnimatedState.animationController() so commands can route back. */',
        '  private SubAnimatedState<?> webOwner;',
        '  void setWebOwner(SubAnimatedState<?> owner) { this.webOwner = owner; }',
        '  private void webCommand(String action) {',
        '    if (webOwner != null) webOwner.sendAnimCommand(this.id, action);',
        '    else System.out.println("EWT web: AnimationController " + id + " has no owner for action=" + action);',
        '  }',
        '  /** Async web command: allocates a callback id, registers a CompletableFuture, and ships the',
        '   *  primitive args. Returns an EWT Future whose .then(consumer) fires once the web side echoes',
        '   *  the callback id back — bridging java.util.concurrent.CompletableFuture (broker-side) to the',
        '   *  Future<NativeObj> surface the generator emits (Flutter-side). */',
        '  private Future<NativeObj> webAsyncCommand(String action, java.util.List<Object> args) {',
        '    final java.util.concurrent.CompletableFuture<Object> cf;',
        '    if (webOwner == null) {',
        '      cf = new java.util.concurrent.CompletableFuture<>();',
        '      cf.completeExceptionally(new IllegalStateException("AnimationController " + id + " has no web owner for async action=" + action));',
        '    } else {',
        '      int cbId = dev.equo.ewt.EwtWebState.nextAsyncCallbackId();',
        '      cf = dev.equo.ewt.EwtWebState.registerAsyncCallback(cbId, this.id);',
        '      dev.equo.ewt.EwtWebState.sendAsyncAnimCommand(this.id, action, cbId, args);',
        '    }',
        '    return new Future<NativeObj>() {',
        '      @Override public int getId() { return -1; }',
        '      @Override public Future build() { return this; }',
        '      @Override public void then(java.util.function.Consumer<NativeObj> onValue) {',
        '        cf.whenComplete((v, t) -> {',
        '          if (t == null) onValue.accept(null);',
        '          else System.out.println("EWT web: AnimationController " + id + " async " + action + " failed: " + t);',
        '        });',
        '      }',
        '    };',
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

  /// Companion method names whose return type is a Dart `Future<T>` and whose
  /// Java surface therefore returns `Future<Object?>`. The web branch routes
  /// through `webAsyncCommand` (see [extraJavaBody]).
  final Set<String> futureAsyncMethods;

  /// Companion method names that take a `DurationI` as their second arg (after
  /// the receiver). The web prelude converts it to milliseconds via
  /// `EwtWebCapture.buildDurationMillis` before shipping.
  final Set<String> durationArgMethods;

  @override
  void writeExtraJavaClassBody() {
    for (final line in extraJavaBody) {
      ctx.javaFile.writeln(line);
    }
  }

  /// Async futures route via `EwtWebState.sendAsyncAnimCommand` on the Java
  /// side (see [writeNonVoidMethodWebPrelude]) — the browser dispatches them
  /// out of a dedicated async broker, not the `factories_web_gen.dart`
  /// decoder table. Suppressing the decoder entry avoids emitting dead Dart
  /// that would still have to compile against Flutter's real (named-arg)
  /// signatures.
  @override
  bool shouldEmitWebInstanceDecoder(String factory) =>
      !futureAsyncMethods.contains(factory);

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

  @override
  void writeNonVoidMethodWebPrelude(String factory, DartType returnType, String restParamNames) {
    if (!futureAsyncMethods.contains(factory)) return;

    // Build the JSON-serialisable args list. Each Java arg name is either
    // passed through verbatim (primitive numbers, strings) or wrapped in a
    // millisec conversion when the method takes a Duration in the second
    // position (index 1 among the rest-of-params — index 0 is the receiver).
    final rawNames = restParamNames
        .split(',')
        .map((s) => s.trim())
        .where((s) => s.isNotEmpty)
        .toList();
    final isDurationMethod = durationArgMethods.contains(factory);
    final argExprs = <String>[
      for (var i = 0; i < rawNames.length; i++)
        (isDurationMethod && i == 1)
            ? 'EwtWebCapture.buildDurationMillis(${rawNames[i]})'
            : rawNames[i],
    ];
    final argList = argExprs.isEmpty
        ? 'java.util.Collections.emptyList()'
        : 'java.util.Arrays.<Object>asList(${argExprs.join(', ')})';

    // Emit only the guard — the FFM path emits unconditionally afterwards
    // (unreachable in web mode because of the early return here). Mirrors the
    // shape of writeVoidMethodWebPrelude.
    ctx.javaFile
      ..writeln('    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {')
      ..writeln('      return webAsyncCommand("$factory", $argList);')
      ..writeln('    }');
  }
}
