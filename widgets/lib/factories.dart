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
  _setupCenter(f);
  _setupColumn(f);
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
int textRich(DartDartObj textSpan, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> softWrap, ffi.Pointer<ffi.Int> overflow, ffi.Pointer<ffi.Double> textScaleFactor, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Pointer<ffi.Char>> semanticsLabel, ffi.Pointer<ffi.Int> textWidthBasis) {
  final w = Text.rich(_widgetsMap[textSpan]! as InlineSpan, textAlign: textAlign.enumOrNul(TextAlign.values), textDirection: textDirection.enumOrNul(TextDirection.values), softWrap: softWrap.boolOrNul(), overflow: overflow.enumOrNul(TextOverflow.values), textScaleFactor: textScaleFactor.doubleOrNul(), maxLines: maxLines.intOrNul(), semanticsLabel: semanticsLabel.strOrNul(), textWidthBasis: textWidthBasis.enumOrNul(TextWidthBasis.values));
  return _addWidget(w);
}

  
void _setupCenter(WidgetFactories f) {
  f.center.of = ffi.Pointer.fromFunction(centerOf, exception);
}

int centerOf(ffi.Pointer<ffi.Double> widthFactor, ffi.Pointer<ffi.Double> heightFactor, ffi.Pointer<DartObj> child) {
  final w = Center(widthFactor: widthFactor.doubleOrNul(), heightFactor: heightFactor.doubleOrNul(), child: child.objOrNul());
  return _addWidget(w);
}

  
void _setupColumn(WidgetFactories f) {
  f.column.of = ffi.Pointer.fromFunction(columnOf, exception);
}

int columnOf(ffi.Pointer<ffi.Int> mainAxisAlignment, ffi.Pointer<ffi.Int> mainAxisSize, ffi.Pointer<ffi.Int> crossAxisAlignment, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> verticalDirection, ffi.Pointer<ffi.Int> textBaseline, ffi.Pointer<ffi.Double> spacing, ffi.Pointer<ArrayC> children) {
  final w = Column(mainAxisAlignment: mainAxisAlignment.enumOr(MainAxisAlignment.values, MainAxisAlignment.start), mainAxisSize: mainAxisSize.enumOr(MainAxisSize.values, MainAxisSize.max), crossAxisAlignment: crossAxisAlignment.enumOr(CrossAxisAlignment.values, CrossAxisAlignment.center), textDirection: textDirection.enumOrNul(TextDirection.values), verticalDirection: verticalDirection.enumOr(VerticalDirection.values, VerticalDirection.down), textBaseline: textBaseline.enumOrNul(TextBaseline.values), spacing: spacing.doubleOr(0.0), children: children.orEmpty());
  return _addWidget(w);
}

  
Widget getWidget(int id) => _widgetsMap[id]!;
int _addWidget(Widget w) {
  final id = w.hashCode;
  _widgetsMap[id] = w;
  print('Added widget $w id: $id');
  return id;
}
extension on ffi.Pointer<ffi.Int> {
  int? intOrNul() => this == ffi.nullptr ? null : value;
  bool? boolOrNul() => this == ffi.nullptr ? null : value == 1 ? true : false;
  E? enumOrNul<E extends Enum>(List<E> values) => this == ffi.nullptr ? null : values[value];
  E enumOr<E extends Enum>(List<E> values, E def) => this == ffi.nullptr ? def : values[value];
}
extension on ffi.Pointer<ffi.Double> {
  double? doubleOrNul() => this == ffi.nullptr ? null : value;
  double doubleOr(double def) => this == ffi.nullptr ? def : value;
}
extension on ffi.Pointer<ffi.Pointer<ffi.Char>> { String? strOrNul() => this == ffi.nullptr ? null : value.cast<Utf8>().toDartString(); }
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
        list.add(w);
        // list[i] = w;
        print('assign widget');
      }
    }
    return list;
  }
}
