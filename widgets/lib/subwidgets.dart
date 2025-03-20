import 'package:flutter/widgets.dart';
// import 'package:ffi/ffi.dart';
import 'dart:ffi' as ffi;
class SubState<T extends StatefulWidget> extends State {
  final Widget Function() buildFn;
  SubState({required this.buildFn}) {

  }
  @override
  Widget build(BuildContext context) => buildFn();

  @override
  void setState(VoidCallback fn) {
    // TODO: implement setState
    print('setState1');
    super.setState(fn);
    print('setState2');
  }

  void ffiSetState(ffi.Pointer<ffi.NativeFunction<ffi.Void Function()>> cb) {
    // setState(() {
      print('ffiSetState1');
    // };
    setState(cb.asFunction());
      print('ffiSetState2');
  }

  @override
  void dispose() {
    // TODO: implement dispose
    super.dispose();
  }

}

class SubStatefulWidget extends StatefulWidget {
  final State<StatefulWidget> Function() createStateFn;
  SubStatefulWidget({super.key, required this.createStateFn});
  @override
  State<StatefulWidget> createState() => createStateFn();
}

