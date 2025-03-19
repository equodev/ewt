import 'package:flutter/widgets.dart';
class SubState<T extends StatefulWidget> extends State {
  final Widget Function() buildFn;
  SubState({required this.buildFn});
  @override
  Widget build(BuildContext context) {
    print("SubState build");
    var widget = buildFn();
    print("SubState build2");
    return widget;
  }
}

class SubStatefulWidget extends StatefulWidget {
  final VoidCallback createStateFn;
  SubStatefulWidget({super.key, required this.createStateFn});
  @override
  State<StatefulWidget> createState() {
    print("SubStatefulWidget createState");
    createStateFn();
    print("SubStatefulWidget createState2");
    return MyState();
  }
}

class MyState extends State {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Text("lala");
  }
}

