import 'package:flutter/widgets.dart';

class SubAnimatedState<T extends StatefulWidget> extends State<T> {
  final void Function() initStateFn;
  final void Function(T) didUpdateWidgetFn;
  final void Function() reassembleFn;
  final void Function() deactivateFn;
  final void Function() activateFn;
  final void Function() disposeFn;
  final Widget Function(BuildContext) buildFn;
  final void Function() didChangeDependenciesFn;
  SubAnimatedState({required this.initStateFn, required this.didUpdateWidgetFn, required this.reassembleFn, required this.deactivateFn, required this.activateFn, required this.disposeFn, required this.buildFn, required this.didChangeDependenciesFn});
  @override
  void initState() {
    super.initState();
    initStateFn();
  }
  @override
  void didUpdateWidget(T oldWidget) {
    super.didUpdateWidget(oldWidget);
    didUpdateWidgetFn(oldWidget);
  }
  @override
  void reassemble() {
    super.reassemble();
    reassembleFn();
  }
  @override
  void deactivate() {
    super.deactivate();
    deactivateFn();
  }
  @override
  void activate() {
    super.activate();
    activateFn();
  }
  @override
  void dispose() {
    super.dispose();
    disposeFn();
  }
  @override
  Widget build(BuildContext context) {
    return buildFn(context);
  }
  @override
  void didChangeDependencies() {
    super.didChangeDependencies();
    didChangeDependenciesFn();
  }
}
