import 'package:flutter/widgets.dart';

typedef WidgetCallback = Widget Function();

class AnimatedWrapper extends StatefulWidget {
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
  State<AnimatedWrapper> createState() => throw UnimplementedError();
}
