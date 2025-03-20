import 'dart:isolate';
import 'dart:ui';

import 'package:flutter/foundation.dart';
import 'package:flutter/widgets.dart';
import 'package:flutter/material.dart';
import 'package:flutter/gestures.dart';
import 'package:widgets/widgets_bindings_generated.dart';
import 'package:ffi/ffi.dart';
import 'dart:ffi' as ffi;

part 'factories_gen.dart';

final ffi.Pointer<WidgetFactories> factories = _setupFactories();
const exception = -1;
Map<int, Object> _widgetsMap = {};

Object getWidget(int id) => _widgetsMap[id]!;
int _addWidget(Object w) {
  final id = w.hashCode;
  _widgetsMap[id] = w;
  print('Added widget $w id: $id');
  return id;
}
extension on int {
  bool toBool() => this == 1 ? true : false;
  E toEnum<E extends Enum>(List<E> values) => values[this];
}
extension on ffi.Pointer<ffi.Int> {
  int? intOrNul() => this == ffi.nullptr ? null : value;
  bool? boolOrNul() => this == ffi.nullptr ? null : value == 1 ? true : false;
  bool boolOr(bool def) => this == ffi.nullptr ? def : value == 1 ? true : false;
  E? enumOrNul<E extends Enum>(List<E> values) => this == ffi.nullptr ? null : values[value];
  E enumOr<E extends Enum>(List<E> values, E def) => this == ffi.nullptr ? def : values[value];
}
extension on ffi.Pointer<ffi.Double> {
  double? doubleOrNul() => this == ffi.nullptr ? null : value;
  double doubleOr(double def) => this == ffi.nullptr ? def : value;
}
extension on ffi.Pointer<ffi.Char> { String? strOrNul() => this == ffi.nullptr ? null : cast<Utf8>().toDartString(); }
extension ObjPtr<T> on ffi.Pointer<ffi.Int> { T? objOrNul() => this == ffi.nullptr ? null : _widgetsMap[value]! as T; }
extension on ffi.Pointer<ArrayC> {
  List<Widget> orEmpty() {
    final List<Widget> list = List.empty(growable: true);
    if (this != ffi.nullptr) {
      final st = ref;
      for (var i=0; i<st.size; i++) {
        final wId = st.list[i];
        print('Find widget at $i id: $wId');
        final w = getWidget(wId);
        print('Got widget $w');
        list.add(w as Widget);
      }
    }
    return list;
  }
}
extension on ffi.Pointer<ffi.Pointer<ffi.Pointer<ffi.Char>>> {
  List<String>? orEmpty() {
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
