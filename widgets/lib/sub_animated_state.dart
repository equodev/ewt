part of 'factories.dart';

/// Runtime counterpart of the generator spec `SubAnimatedState`. Provides the
/// vsync (via `TickerProviderStateMixin`) needed to construct `AnimationController`s
/// and tracks them for automatic disposal when the State unmounts.
class SubAnimatedState<T extends StatefulWidget> extends SubState<T>
    with TickerProviderStateMixin {
  final List<AnimationController> _controllers = [];

  SubAnimatedState({
    required super.initStateFn,
    required super.didUpdateWidgetFn,
    required super.reassembleFn,
    required super.deactivateFn,
    required super.activateFn,
    required super.disposeFn,
    required super.buildFn,
    required super.didChangeDependenciesFn,
  });

  AnimationController animationController(Duration duration) {
    final c = AnimationController(vsync: this, duration: duration);
    _controllers.add(c);
    return c;
  }

  @override
  void dispose() {
    for (final c in _controllers) {
      c.dispose();
    }
    _controllers.clear();
    super.dispose();
  }
}
