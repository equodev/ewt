import 'dart:isolate';
import 'dart:ui' hide VoidCallback;

import 'package:flutter/foundation.dart';
import 'package:flutter/rendering.dart';
import 'package:flutter/widgets.dart';
import 'package:flutter/material.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/services.dart';
import 'package:widgets/subwidgets.dart';
import 'package:widgets/widgets_bindings_generated.dart';
import 'package:ffi/ffi.dart';
import 'dart:ffi' as ffi;

part 'factories_gen.dart';
part 'sub_animated_state.dart';
part 'sub_animated_state_methods.dart';
part 'animation_controller_methods.dart';

final ffi.Pointer<WidgetFactories> factories = _setupFactories();
const exception = -1;
const exceptionDouble = -1.0;
Map<int, Object> _widgetsMap = {};
// Identity-keyed reverse map so _addWidget can dedup by reference: the same
// Dart object passed in twice gets the same id, so the Java SubclassedInJava
// registry (keyed on the original construction-time id) keeps resolving.
final Map<Object, int> _widgetIdByRef = Map.identity();
final _buildScopeStack = <Set<int>>[];
var _nextWidgetId = 1;

Object getWidget(int id) => _widgetsMap[id]!;
int _addWidget(Object? w) {
  if (w == null) return 0;
  final existing = _widgetIdByRef[w];
  if (existing != null) return existing;
  final id = _nextWidgetId++;
  _widgetsMap[id] = w;
  _widgetIdByRef[w] = id;
  // BuildContext and State outlive the build scope that created them: BuildContext
  // is captured by button callbacks (e.g. Navigator.pop(ctx)); State is owned by
  // Flutter and may be dispatched back to via id (e.g. animationController() on
  // SubAnimatedState).
  if (_buildScopeStack.isNotEmpty && w is! BuildContext && w is! State) {
    _buildScopeStack.last.add(id);
  }
  print('Added widget $w id: $id');
  return id;
}
T _runBuildScope<T>(T Function() fn) {
  _buildScopeStack.add(<int>{});
  try {
    return fn();
  } finally {
    final scope = _buildScopeStack.removeLast();
    _widgetsMap.removeWhere((k, v) {
      if (!scope.contains(k)) return false;
      _widgetIdByRef.remove(v);
      return true;
    });
  }
}
extension on int {
  bool toBool() => this == 1 ? true : false;
  E toEnum<E extends Enum>(List<E> values) => values[this];
}
extension on bool {
  int toInt() => this == true ? 1 : 0;
}
extension on ffi.Pointer<ffi.Int> {
  int? intOrNul() => this == ffi.nullptr ? null : value;
  int intOr(int def) => this == ffi.nullptr ? def : value;
  bool? boolOrNul() => this == ffi.nullptr ? null : value == 1 ? true : false;
  bool boolOr(bool def) => this == ffi.nullptr ? def : value == 1 ? true : false;
  E? enumOrNul<E extends Enum>(List<E> values) => this == ffi.nullptr ? null : values[value];
  E enumOr<E extends Enum>(List<E> values, E def) => this == ffi.nullptr ? def : values[value];
}
extension on ffi.Pointer<ffi.Double> {
  double? doubleOrNul() => this == ffi.nullptr ? null : value;
  double doubleOr(double def) => this == ffi.nullptr ? def : value;
}
extension on ffi.Pointer<ffi.Char> {
  String? strOrNul() => this == ffi.nullptr ? null : cast<Utf8>().toDartString();
  String strOr(String def) => this == ffi.nullptr ? def : cast<Utf8>().toDartString();
}
extension Obj<T> on int? {
  T? objOrNul() => this == null ? null : _widgetsMap[this]! as T;
}
extension ObjPtr<T> on ffi.Pointer<ffi.Int> {
  T? objOrNul() => this == ffi.nullptr ? null : _widgetsMap[value]! as T;
  T objOr(T def) => this == ffi.nullptr ? def : _widgetsMap[value]! as T;
}
extension on ArrayC {
  List<T> listOrEmpty<T>() {
    final List<T> list = List.empty(growable: true);
    final st = this;
    for (var i = 0; i < st.size; i++) {
      final wId = st.list[i];
      print('Find widget at $i/${st.size} id: $wId');
      final w = getWidget(wId);
      print('Got widget $w ${list.runtimeType}');
      list.add(w as T);
      print('After add to list');
    }
    print('Got list $list');
    return list;
  }
}
extension on ffi.Pointer<ArrayC> {
  List<T>? listOrNul<T>() => this == ffi.nullptr ? null : ref.listOrEmpty();
  List<T> listOrEmpty<T>() => this == ffi.nullptr ? [] : ref.listOrEmpty();
}
extension on MapC {
  Map<int, Color> toMap() {
    final Map<int, Color> map = Map();
    for (var i=0; i<size; i++) {
      final entry = entries[i];
      final wId = entry.value;
      print('Find widget at $i id: $wId');
      final w = getWidget(wId);
      print('Got widget $w');
      map[entry.key] = w as Color;
    }
    return map;
  }
}
extension on ffi.Pointer<ffi.Pointer<ffi.Pointer<ffi.Char>>> {
  List<String>? listOrNul() {
    if (this != ffi.nullptr) {
      final List<String> list = List.empty(growable: true);
      final array = value;
      for (var i=0; ; i++) {
        final strPtr = array[i];
        if (strPtr == ffi.nullptr) {
          return list;
        }
        final str = strPtr.strOrNul();
        list.add(str!);
      }
    }
    return null;
  }
}
extension on List<String> {
  ffi.Pointer<ffi.Pointer<ffi.Char>> strListToC() {
    if (this != null) {
      for (var i=0; i<length; i++) {
        final stri = this[i].toNativeUtf8().cast<ffi.Char>();
        // ffi.Pointer()
        // TODO: allocate array of char*
      }
    }
    return ffi.nullptr;
  }
}
// extension on DrawerCallbackFFI {
//   DrawerCallback toFn() {
//     return (bool b) {
//       DartDrawerCallbackFFIFunction f = asFunction();
//       f(b.toInt());
//     };
//   }
// }
// extension on ffi.Pointer<DrawerCallbackFFI> {
//   DrawerCallback? toFn() {
//     if (this != ffi.nullptr) {
//       return this.value.toFn();
//     }
//     return null;
//   }
// }
// extension on TransitionBuilderFFI {
//   TransitionBuilder toFn() {
//     return (BuildContext context, Widget? w) {
//       DartTransitionBuilderFFIFunction f = asFunction();
//       return getWidget(f(context.hashCode, w.hashCode)) as Widget;
//     };
//   }
// }
// extension on ffi.Pointer<TransitionBuilderFFI> {
//   TransitionBuilder? toFn() {
//     if (this != ffi.nullptr) {
//       return this.value.toFn();
//     }
//     return null;
//   }
// }
//
// extension on GenerateAppTitleFFI {
//   GenerateAppTitle toFn() {
//     return (BuildContext context) {
//       DartGenerateAppTitleFFIFunction f = asFunction();
//       return f(context.hashCode).strOrNul()!;
//     };
//   }
// }
// extension on ffi.Pointer<GenerateAppTitleFFI> {
//   GenerateAppTitle? toFn() {
//     if (this != ffi.nullptr) {
//       return this.value.toFn();
//     }
//     return null;
//   }
// }
// extension on VoidCallback {
//   DartVoidCallbackFunction toFn() {
//     return asFunction();
//   }
// }
// extension on ffi.Pointer<VoidCallback> {
//   DartVoidCallbackFunction? toFn() {
//     if (this != ffi.nullptr) {
//       return this.value.asFunction();
//     }
//     return null;
//   }
// }
// extension on DartObjCallback {
//   T Function() toFn<T>() {
//     return () {
//       DartDartObjCallbackFunction jCb = asFunction();
//       final wId = jCb();
//       return getWidget(wId) as T;
//     };
//   }
// }
// extension on DartObjCallbackDartObj {
//   T Function(BuildContext) toFn<T>() {
//     return (ctx) {
//       DartDartObjCallbackDartObjFunction jCb = asFunction();
//       final wId = jCb(_addWidget(ctx));
//       return getWidget(wId) as T;
//     };
//   }
// }
