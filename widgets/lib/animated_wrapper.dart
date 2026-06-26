part of 'factories.dart';

typedef WidgetCallback = Widget Function();

class _AnimationRef {
  AnimationController? controller;
}

class AnimatedWrapper extends StatefulWidget {
  final _AnimationRef _ref = _AnimationRef();
  final void Function(int ctrlId) initAnimationFn;
  final WidgetCallback buildAnimatedFn;
  AnimatedWrapper({required this.initAnimationFn, required this.buildAnimatedFn});

  static void forward(AnimationController ctrl) => ctrl.forward();
  static void reverse(AnimationController ctrl) => ctrl.reverse();
  static void stop(AnimationController ctrl) => ctrl.stop();
  static void repeat(AnimationController ctrl) => ctrl.repeat();
  static void reset(AnimationController ctrl) => ctrl.reset();
  static void setDuration(AnimationController ctrl, Duration d) => ctrl.duration = d;
  static void setReverseDuration(AnimationController ctrl, Duration d) => ctrl.reverseDuration = d;

  @override
  State<AnimatedWrapper> createState() => _SubAnimatedState();
}

class _SubAnimatedState extends State<AnimatedWrapper>
    with SingleTickerProviderStateMixin {
  late final AnimationController _controller;

  @override
  void initState() {
    super.initState();
    _controller = AnimationController(vsync: this);
    widget._ref.controller = _controller;
    final ctrlId = _addWidget(_controller);
    widget.initAnimationFn(ctrlId);
  }

  @override
  Widget build(BuildContext context) => widget.buildAnimatedFn();

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }
}
