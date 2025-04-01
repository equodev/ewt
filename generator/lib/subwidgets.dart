import 'package:flutter/widgets.dart';
class SubState<T extends StatefulWidget> extends State<T> {
  final Widget Function(BuildContext) buildFn;
  SubState({required this.buildFn});
  @override
  Widget build(BuildContext context) => buildFn(context);
}

class SubStatefulWidget extends StatefulWidget {
  final State<StatefulWidget> Function() createStateFn;
  SubStatefulWidget({super.key, required this.createStateFn});
  @override
  State<StatefulWidget> createState() => createStateFn();
}

class SubStatelessWidget extends StatelessWidget {
  final Widget Function(BuildContext) buildFn;
  SubStatelessWidget({super.key, required this.buildFn});
  @override
  Widget build(BuildContext context) => buildFn(context);
}

