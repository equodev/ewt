import 'package:flutter/widgets.dart';
import 'package:flutter/material.dart';
import 'package:flutter/gestures.dart';
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
  _setupAppBar(f);
  _setupScaffold(f);
  _setupMaterialApp(f);
  return f;
}
void _setupText(WidgetFactories f) {
  f.text.text = ffi.Pointer.fromFunction(textText, exception);
  f.text.rich = ffi.Pointer.fromFunction(textRich, exception);
}

int textText(ffi.Pointer<ffi.Char> data, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> softWrap, ffi.Pointer<ffi.Int> overflow, ffi.Pointer<ffi.Double> textScaleFactor, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Char> semanticsLabel, ffi.Pointer<ffi.Int> textWidthBasis) {
  final w = Text(data.cast<Utf8>().toDartString(), textAlign: textAlign.enumOrNul(TextAlign.values), textDirection: textDirection.enumOrNul(TextDirection.values), softWrap: softWrap.boolOrNul(), overflow: overflow.enumOrNul(TextOverflow.values), textScaleFactor: textScaleFactor.doubleOrNul(), maxLines: maxLines.intOrNul(), semanticsLabel: semanticsLabel.strOrNul(), textWidthBasis: textWidthBasis.enumOrNul(TextWidthBasis.values));
  return _addWidget(w);
}
int textRich(DartDartObj textSpan, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> softWrap, ffi.Pointer<ffi.Int> overflow, ffi.Pointer<ffi.Double> textScaleFactor, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Char> semanticsLabel, ffi.Pointer<ffi.Int> textWidthBasis) {
  final w = Text.rich(_widgetsMap[textSpan]! as InlineSpan, textAlign: textAlign.enumOrNul(TextAlign.values), textDirection: textDirection.enumOrNul(TextDirection.values), softWrap: softWrap.boolOrNul(), overflow: overflow.enumOrNul(TextOverflow.values), textScaleFactor: textScaleFactor.doubleOrNul(), maxLines: maxLines.intOrNul(), semanticsLabel: semanticsLabel.strOrNul(), textWidthBasis: textWidthBasis.enumOrNul(TextWidthBasis.values));
  return _addWidget(w);
}









  
void _setupCenter(WidgetFactories f) {
  f.center.center = ffi.Pointer.fromFunction(centerCenter, exception);
}

int centerCenter(ffi.Pointer<ffi.Double> widthFactor, ffi.Pointer<ffi.Double> heightFactor, ffi.Pointer<DartObj> child) {
  final w = Center(widthFactor: widthFactor.doubleOrNul(), heightFactor: heightFactor.doubleOrNul(), child: child.objOrNul());
  return _addWidget(w);
}

void _setupAlign(WidgetFactories f) {
  f.align.align = ffi.Pointer.fromFunction(alignAlign, exception);
}

int alignAlign(ffi.Pointer<ffi.Double> widthFactor, ffi.Pointer<ffi.Double> heightFactor, ffi.Pointer<DartObj> child) {
  final w = Align(widthFactor: widthFactor.doubleOrNul(), heightFactor: heightFactor.doubleOrNul(), child: child.objOrNul());
  return _addWidget(w);
}





  
void _setupColumn(WidgetFactories f) {
  f.column.column = ffi.Pointer.fromFunction(columnColumn, exception);
}

int columnColumn(ffi.Pointer<ffi.Int> mainAxisAlignment, ffi.Pointer<ffi.Int> mainAxisSize, ffi.Pointer<ffi.Int> crossAxisAlignment, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> verticalDirection, ffi.Pointer<ffi.Int> textBaseline, ffi.Pointer<ffi.Double> spacing, ffi.Pointer<ArrayC> children) {
  final w = Column(mainAxisAlignment: mainAxisAlignment.enumOr(MainAxisAlignment.values, MainAxisAlignment.start), mainAxisSize: mainAxisSize.enumOr(MainAxisSize.values, MainAxisSize.max), crossAxisAlignment: crossAxisAlignment.enumOr(CrossAxisAlignment.values, CrossAxisAlignment.center), textDirection: textDirection.enumOrNul(TextDirection.values), verticalDirection: verticalDirection.enumOr(VerticalDirection.values, VerticalDirection.down), textBaseline: textBaseline.enumOrNul(TextBaseline.values), spacing: spacing.doubleOr(0.0), children: children.orEmpty());
  return _addWidget(w);
}

void _setupFlex(WidgetFactories f) {
  f.flex.flex = ffi.Pointer.fromFunction(flexFlex, exception);
}

int flexFlex(int direction, ffi.Pointer<ffi.Int> mainAxisAlignment, ffi.Pointer<ffi.Int> mainAxisSize, ffi.Pointer<ffi.Int> crossAxisAlignment, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> verticalDirection, ffi.Pointer<ffi.Int> textBaseline, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Double> spacing, ffi.Pointer<ArrayC> children) {
  final w = Flex(direction: _widgetsMap[direction]! as Axis, mainAxisAlignment: mainAxisAlignment.enumOr(MainAxisAlignment.values, MainAxisAlignment.start), mainAxisSize: mainAxisSize.enumOr(MainAxisSize.values, MainAxisSize.max), crossAxisAlignment: crossAxisAlignment.enumOr(CrossAxisAlignment.values, CrossAxisAlignment.center), textDirection: textDirection.enumOrNul(TextDirection.values), verticalDirection: verticalDirection.enumOr(VerticalDirection.values, VerticalDirection.down), textBaseline: textBaseline.enumOrNul(TextBaseline.values), clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none), spacing: spacing.doubleOr(0.0), children: children.orEmpty());
  return _addWidget(w);
}



  
void _setupAppBar(WidgetFactories f) {
  f.appBar.appBar = ffi.Pointer.fromFunction(appBarAppBar, exception);
}

int appBarAppBar(ffi.Pointer<DartObj> leading, ffi.Pointer<ffi.Int> automaticallyImplyLeading, ffi.Pointer<DartObj> title, ffi.Pointer<ArrayC> actions, ffi.Pointer<DartObj> flexibleSpace, ffi.Pointer<DartObj> bottom, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<ffi.Double> scrolledUnderElevation, ffi.Pointer<ffi.Int> primary, ffi.Pointer<ffi.Int> centerTitle, ffi.Pointer<ffi.Int> excludeHeaderSemantics, ffi.Pointer<ffi.Double> titleSpacing, ffi.Pointer<ffi.Double> toolbarOpacity, ffi.Pointer<ffi.Double> bottomOpacity, ffi.Pointer<ffi.Double> toolbarHeight, ffi.Pointer<ffi.Double> leadingWidth, ffi.Pointer<ffi.Int> forceMaterialTransparency, ffi.Pointer<ffi.Int> clipBehavior) {
  final w = AppBar(leading: leading.objOrNul(), automaticallyImplyLeading: automaticallyImplyLeading.boolOr(true), title: title.objOrNul(), actions: actions.orEmpty(), flexibleSpace: flexibleSpace.objOrNul(), bottom: bottom.objOrNul(), elevation: elevation.doubleOrNul(), scrolledUnderElevation: scrolledUnderElevation.doubleOrNul(), primary: primary.boolOr(true), centerTitle: centerTitle.boolOrNul(), excludeHeaderSemantics: excludeHeaderSemantics.boolOr(false), titleSpacing: titleSpacing.doubleOrNul(), toolbarOpacity: toolbarOpacity.doubleOr(1.0), bottomOpacity: bottomOpacity.doubleOr(1.0), toolbarHeight: toolbarHeight.doubleOrNul(), leadingWidth: leadingWidth.doubleOrNul(), forceMaterialTransparency: forceMaterialTransparency.boolOr(false), clipBehavior: clipBehavior.enumOrNul(Clip.values));
  return _addWidget(w);
}





  
void _setupScaffold(WidgetFactories f) {
  f.scaffold.scaffold = ffi.Pointer.fromFunction(scaffoldScaffold, exception);
}

int scaffoldScaffold(ffi.Pointer<DartObj> appBar, ffi.Pointer<DartObj> body, ffi.Pointer<DartObj> floatingActionButton, ffi.Pointer<ArrayC> persistentFooterButtons, ffi.Pointer<DartObj> drawer, ffi.Pointer<DartObj> endDrawer, ffi.Pointer<DartObj> bottomNavigationBar, ffi.Pointer<DartObj> bottomSheet, ffi.Pointer<ffi.Int> resizeToAvoidBottomInset, ffi.Pointer<ffi.Int> primary, ffi.Pointer<ffi.Int> drawerDragStartBehavior, ffi.Pointer<ffi.Int> extendBody, ffi.Pointer<ffi.Int> extendBodyBehindAppBar, ffi.Pointer<ffi.Double> drawerEdgeDragWidth, ffi.Pointer<ffi.Int> drawerEnableOpenDragGesture, ffi.Pointer<ffi.Int> endDrawerEnableOpenDragGesture, ffi.Pointer<ffi.Char> restorationId) {
  final w = Scaffold(appBar: appBar.objOrNul(), body: body.objOrNul(), floatingActionButton: floatingActionButton.objOrNul(), persistentFooterButtons: persistentFooterButtons.orEmpty(), drawer: drawer.objOrNul(), endDrawer: endDrawer.objOrNul(), bottomNavigationBar: bottomNavigationBar.objOrNul(), bottomSheet: bottomSheet.objOrNul(), resizeToAvoidBottomInset: resizeToAvoidBottomInset.boolOrNul(), primary: primary.boolOr(true), drawerDragStartBehavior: drawerDragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start), extendBody: extendBody.boolOr(false), extendBodyBehindAppBar: extendBodyBehindAppBar.boolOr(false), drawerEdgeDragWidth: drawerEdgeDragWidth.doubleOrNul(), drawerEnableOpenDragGesture: drawerEnableOpenDragGesture.boolOr(true), endDrawerEnableOpenDragGesture: endDrawerEnableOpenDragGesture.boolOr(true), restorationId: restorationId.strOrNul());
  return _addWidget(w);
}

  
void _setupMaterialApp(WidgetFactories f) {
  f.materialApp.materialApp = ffi.Pointer.fromFunction(materialAppMaterialApp, exception);
  f.materialApp.router = ffi.Pointer.fromFunction(materialAppRouter, exception);
}

int materialAppMaterialApp(ffi.Pointer<DartObj> home, ffi.Pointer<ffi.Char> initialRoute, ffi.Pointer<ffi.Char> title, ffi.Pointer<ffi.Int> themeMode, ffi.Pointer<ffi.Int> debugShowMaterialGrid, ffi.Pointer<ffi.Int> showPerformanceOverlay, ffi.Pointer<ffi.Int> checkerboardRasterCacheImages, ffi.Pointer<ffi.Int> checkerboardOffscreenLayers, ffi.Pointer<ffi.Int> showSemanticsDebugger, ffi.Pointer<ffi.Int> debugShowCheckedModeBanner, ffi.Pointer<ffi.Char> restorationScopeId, ffi.Pointer<ffi.Int> useInheritedMediaQuery) {
  final w = MaterialApp(home: home.objOrNul(), initialRoute: initialRoute.strOrNul(), title: title.strOrNul(), themeMode: themeMode.enumOrNul(ThemeMode.values), debugShowMaterialGrid: debugShowMaterialGrid.boolOr(false), showPerformanceOverlay: showPerformanceOverlay.boolOr(false), checkerboardRasterCacheImages: checkerboardRasterCacheImages.boolOr(false), checkerboardOffscreenLayers: checkerboardOffscreenLayers.boolOr(false), showSemanticsDebugger: showSemanticsDebugger.boolOr(false), debugShowCheckedModeBanner: debugShowCheckedModeBanner.boolOr(true), restorationScopeId: restorationScopeId.strOrNul(), useInheritedMediaQuery: useInheritedMediaQuery.boolOr(false));
  return _addWidget(w);
}
int materialAppRouter(ffi.Pointer<ffi.Char> title, ffi.Pointer<ffi.Int> themeMode, ffi.Pointer<ffi.Int> debugShowMaterialGrid, ffi.Pointer<ffi.Int> showPerformanceOverlay, ffi.Pointer<ffi.Int> checkerboardRasterCacheImages, ffi.Pointer<ffi.Int> checkerboardOffscreenLayers, ffi.Pointer<ffi.Int> showSemanticsDebugger, ffi.Pointer<ffi.Int> debugShowCheckedModeBanner, ffi.Pointer<ffi.Char> restorationScopeId, ffi.Pointer<ffi.Int> useInheritedMediaQuery) {
  final w = MaterialApp.router(title: title.strOrNul(), themeMode: themeMode.enumOrNul(ThemeMode.values), debugShowMaterialGrid: debugShowMaterialGrid.boolOr(false), showPerformanceOverlay: showPerformanceOverlay.boolOr(false), checkerboardRasterCacheImages: checkerboardRasterCacheImages.boolOr(false), checkerboardOffscreenLayers: checkerboardOffscreenLayers.boolOr(false), showSemanticsDebugger: showSemanticsDebugger.boolOr(false), debugShowCheckedModeBanner: debugShowCheckedModeBanner.boolOr(true), restorationScopeId: restorationScopeId.strOrNul(), useInheritedMediaQuery: useInheritedMediaQuery.boolOr(false));
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
        list.add(w);
      }
    }
    return list;
  }
}
