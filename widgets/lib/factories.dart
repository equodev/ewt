import 'package:flutter/widgets.dart';
import 'package:widgets/widgets_bindings_generated.dart';
import 'package:ffi/ffi.dart';
import 'dart:ffi' as ffi;
final WidgetFactories factories = _setupFactories();
const exception = -1;
Map<int, Widget> _widgetsMap = {};
WidgetFactories _setupFactories() {
  final WidgetFactories f = ffi.Struct.create();
  _setupText(f);
  return f;
}
void _setupText(WidgetFactories f) {
  f.text.of = ffi.Pointer.fromFunction(textOf, exception);
  f.text.rich = ffi.Pointer.fromFunction(textRich, exception);
}

int textOf(ffi.Pointer<ffi.Char> data, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> softWrap, ffi.Pointer<ffi.Int> overflow, ffi.Pointer<ffi.Double> textScaleFactor, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Pointer<ffi.Char>> semanticsLabel, ffi.Pointer<ffi.Int> textWidthBasis) {
  final w = Text(data.cast<Utf8>().toDartString(), textAlign: textAlign.enumOrNul(TextAlign.values), textDirection: textDirection.enumOrNul(TextDirection.values), softWrap: softWrap.boolOrNul(), overflow: overflow.enumOrNul(TextOverflow.values), textScaleFactor: textScaleFactor.doubleOrNul(), maxLines: maxLines.intOrNul(), semanticsLabel: semanticsLabel.strOrNul(), textWidthBasis: textWidthBasis.enumOrNul(TextWidthBasis.values));
  return _addWidget(w);
}
int textRich(int textSpan, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> softWrap, ffi.Pointer<ffi.Int> overflow, ffi.Pointer<ffi.Double> textScaleFactor, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Pointer<ffi.Char>> semanticsLabel, ffi.Pointer<ffi.Int> textWidthBasis) {
  final w = Text.rich(_widgetsMap[textSpan]! as InlineSpan, textAlign: textAlign.enumOrNul(TextAlign.values), textDirection: textDirection.enumOrNul(TextDirection.values), softWrap: softWrap.boolOrNul(), overflow: overflow.enumOrNul(TextOverflow.values), textScaleFactor: textScaleFactor.doubleOrNul(), maxLines: maxLines.intOrNul(), semanticsLabel: semanticsLabel.strOrNul(), textWidthBasis: textWidthBasis.enumOrNul(TextWidthBasis.values));
  return _addWidget(w);
}

  
Widget getWidget(int id) => _widgetsMap[id]!;
int _addWidget(Widget w) {
  final id = w.hashCode;
  _widgetsMap[id] = w;
  print('Added widget id: $id');
  return id;
}
extension on ffi.Pointer<ffi.Int> { int? intOrNul() => this == ffi.nullptr ? null : value; }
extension on ffi.Pointer<ffi.Double> { double? doubleOrNul() => this == ffi.nullptr ? null : value; }
extension on ffi.Pointer<ffi.Int> { bool? boolOrNul() => this == ffi.nullptr ? null : value == 1 ? true : false; }
extension on ffi.Pointer<ffi.Pointer<ffi.Char>> { String? strOrNul() => this == ffi.nullptr ? null : value.cast<Utf8>().toDartString(); }
extension EnumPtr<T> on ffi.Pointer<ffi.Int> { T? enumOrNul(List<T> values) => this == ffi.nullptr ? null : values[value]; }
extension ObjPtr<T> on ffi.Pointer<ffi.Int> { T? objOrNul() => this == ffi.nullptr ? null : _widgetsMap[value]! as T; }
