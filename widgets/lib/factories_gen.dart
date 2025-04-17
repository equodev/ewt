part of 'factories.dart';
void _setupTextStyle(WidgetFactories f) {
  f.textStyle.textStyle = ffi.Pointer.fromFunction(textStyleTextStyle);
  f.textStyle.lerp = ffi.Pointer.fromFunction(textStyleLerp);
}
TextStyleObjSt textStyleTextStyle(ffi.Pointer<ffi.Int> inherit, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Double> fontSize, ffi.Pointer<ffi.Int> fontStyle, ffi.Pointer<ffi.Double> letterSpacing, ffi.Pointer<ffi.Double> wordSpacing, ffi.Pointer<ffi.Int> textBaseline, ffi.Pointer<ffi.Double> height, ffi.Pointer<ffi.Int> leadingDistribution, ffi.Pointer<ArrayC> shadows, ffi.Pointer<DartObj> decorationColor, ffi.Pointer<ffi.Int> decorationStyle, ffi.Pointer<ffi.Double> decorationThickness, ffi.Pointer<ffi.Char> debugLabel, ffi.Pointer<ffi.Char> fontFamily, ffi.Pointer<ffi.Pointer<ffi.Pointer<ffi.Char>>> fontFamilyFallback, ffi.Pointer<ffi.Char> package, ffi.Pointer<ffi.Int> overflow) {
  final w = TextStyle(inherit: inherit.boolOr(true),
      color: color.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      fontSize: fontSize.doubleOrNul(),
      fontStyle: fontStyle.enumOrNul(FontStyle.values),
      letterSpacing: letterSpacing.doubleOrNul(),
      wordSpacing: wordSpacing.doubleOrNul(),
      textBaseline: textBaseline.enumOrNul(TextBaseline.values),
      height: height.doubleOrNul(),
      leadingDistribution: leadingDistribution.enumOrNul(TextLeadingDistribution.values),
      shadows: shadows.orEmpty(),
      decorationColor: decorationColor.objOrNul(),
      decorationStyle: decorationStyle.enumOrNul(TextDecorationStyle.values),
      decorationThickness: decorationThickness.doubleOrNul(),
      debugLabel: debugLabel.strOrNul(),
      fontFamily: fontFamily.strOrNul(),
      fontFamilyFallback: fontFamilyFallback.orEmpty(),
      package: package.strOrNul(),
      overflow: overflow.enumOrNul(TextOverflow.values));
  return _createTextStyleObjSt(w);
}
TextStyleObjSt? textStyleLerp(DartDartObj a, DartDartObj b, double t) {
  final w = TextStyle.lerp(_widgetsMap[a]! as TextStyle?,
      _widgetsMap[b]! as TextStyle?,
      t);
  return w != null ? _createTextStyleObjSt(w) : null;
}
TextStyleObjSt _createTextStyleObjSt(TextStyle? w) {
  final TextStyleObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.inherit = w.inherit.toInt();
  stObj.color = _addWidget(w.color);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.fontFamily = (w.fontFamily != null) ? w.fontFamily!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.fontSize = (w.fontSize != null) ? w.fontSize! : 0;
  stObj.fontStyle = (w.fontStyle != null) ? w.fontStyle!.index : 0;
  stObj.letterSpacing = (w.letterSpacing != null) ? w.letterSpacing! : 0;
  stObj.wordSpacing = (w.wordSpacing != null) ? w.wordSpacing! : 0;
  stObj.textBaseline = (w.textBaseline != null) ? w.textBaseline!.index : 0;
  stObj.height = (w.height != null) ? w.height! : 0;
  stObj.leadingDistribution = (w.leadingDistribution != null) ? w.leadingDistribution!.index : 0;
  stObj.decorationColor = _addWidget(w.decorationColor);
  stObj.decorationStyle = (w.decorationStyle != null) ? w.decorationStyle!.index : 0;
  stObj.decorationThickness = (w.decorationThickness != null) ? w.decorationThickness! : 0;
  stObj.debugLabel = (w.debugLabel != null) ? w.debugLabel!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.overflow = (w.overflow != null) ? w.overflow!.index : 0;
  return stObj;
}

void _setupColor(WidgetFactories f) {
  f.color.color = ffi.Pointer.fromFunction(colorColor, exception);
  f.color.from = ffi.Pointer.fromFunction(colorFrom, exception);
  f.color.fromARGB = ffi.Pointer.fromFunction(colorFromARGB, exception);
  f.color.fromRGBO = ffi.Pointer.fromFunction(colorFromRGBO, exception);
  f.color.lerp = ffi.Pointer.fromFunction(colorLerp, exception);
  f.color.alphaBlend = ffi.Pointer.fromFunction(colorAlphaBlend, exception);
}
int colorColor(int value) {
  final w = Color(value);
  return _addWidget(w);
}
int colorFrom(double alpha, double red, double green, double blue, ffi.Pointer<ffi.Int> colorSpace) {
  final w = Color.from(alpha: alpha,
      red: red,
      green: green,
      blue: blue,
      colorSpace: colorSpace.enumOr(ColorSpace.values, ColorSpace.sRGB));
  return _addWidget(w);
}
int colorFromARGB(int a, int r, int g, int b) {
  final w = Color.fromARGB(a,
      r,
      g,
      b);
  return _addWidget(w);
}
int colorFromRGBO(int r, int g, int b, double opacity) {
  final w = Color.fromRGBO(r,
      g,
      b,
      opacity);
  return _addWidget(w);
}
int colorLerp(DartDartObj x, DartDartObj y, double t) {
  final w = Color.lerp(_widgetsMap[x]! as Color?,
      _widgetsMap[y]! as Color?,
      t);
  return _addWidget(w);
}
int colorAlphaBlend(DartDartObj foreground, DartDartObj background) {
  final w = Color.alphaBlend(_widgetsMap[foreground]! as Color,
      _widgetsMap[background]! as Color);
  return _addWidget(w);
}

void _setupText(WidgetFactories f) {
  f.text.text = ffi.Pointer.fromFunction(textText);
  f.text.rich = ffi.Pointer.fromFunction(textRich);
}
TextObjSt textText(ffi.Pointer<ffi.Char> data, ffi.Pointer<DartObj> style, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> softWrap, ffi.Pointer<ffi.Int> overflow, ffi.Pointer<ffi.Double> textScaleFactor, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Char> semanticsLabel, ffi.Pointer<ffi.Int> textWidthBasis, ffi.Pointer<DartObj> selectionColor) {
  final w = Text(data.cast<Utf8>().toDartString(),
      style: style.objOrNul(),
      textAlign: textAlign.enumOrNul(TextAlign.values),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      softWrap: softWrap.boolOrNul(),
      overflow: overflow.enumOrNul(TextOverflow.values),
      textScaleFactor: textScaleFactor.doubleOrNul(),
      maxLines: maxLines.intOrNul(),
      semanticsLabel: semanticsLabel.strOrNul(),
      textWidthBasis: textWidthBasis.enumOrNul(TextWidthBasis.values),
      selectionColor: selectionColor.objOrNul());
  return _createTextObjSt(w);
}
TextObjSt textRich(DartDartObj textSpan, ffi.Pointer<DartObj> style, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> softWrap, ffi.Pointer<ffi.Int> overflow, ffi.Pointer<ffi.Double> textScaleFactor, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Char> semanticsLabel, ffi.Pointer<ffi.Int> textWidthBasis, ffi.Pointer<DartObj> selectionColor) {
  final w = Text.rich(_widgetsMap[textSpan]! as InlineSpan,
      style: style.objOrNul(),
      textAlign: textAlign.enumOrNul(TextAlign.values),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      softWrap: softWrap.boolOrNul(),
      overflow: overflow.enumOrNul(TextOverflow.values),
      textScaleFactor: textScaleFactor.doubleOrNul(),
      maxLines: maxLines.intOrNul(),
      semanticsLabel: semanticsLabel.strOrNul(),
      textWidthBasis: textWidthBasis.enumOrNul(TextWidthBasis.values),
      selectionColor: selectionColor.objOrNul());
  return _createTextObjSt(w);
}
TextObjSt _createTextObjSt(Text? w) {
  final TextObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.data = (w.data != null) ? w.data!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.textSpan = _addWidget(w.textSpan);
  stObj.style = _createTextStyleObjSt(w.style);
  stObj.textAlign = (w.textAlign != null) ? w.textAlign!.index : 0;
  stObj.textDirection = (w.textDirection != null) ? w.textDirection!.index : 0;
  stObj.softWrap = (w.softWrap != null) ? w.softWrap!.toInt() : 0;
  stObj.overflow = (w.overflow != null) ? w.overflow!.index : 0;
  stObj.textScaleFactor = (w.textScaleFactor != null) ? w.textScaleFactor! : 0;
  stObj.maxLines = (w.maxLines != null) ? w.maxLines! : 0;
  stObj.semanticsLabel = (w.semanticsLabel != null) ? w.semanticsLabel!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.textWidthBasis = (w.textWidthBasis != null) ? w.textWidthBasis!.index : 0;
  stObj.selectionColor = _addWidget(w.selectionColor);
  return stObj;
}

void _setupCenter(WidgetFactories f) {
  f.center.center = ffi.Pointer.fromFunction(centerCenter);
}
CenterObjSt centerCenter(ffi.Pointer<ffi.Double> widthFactor, ffi.Pointer<ffi.Double> heightFactor, ffi.Pointer<DartObj> child) {
  final w = Center(widthFactor: widthFactor.doubleOrNul(),
      heightFactor: heightFactor.doubleOrNul(),
      child: child.objOrNul());
  return _createCenterObjSt(w);
}
CenterObjSt _createCenterObjSt(Center? w) {
  final CenterObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupAlign(WidgetFactories f) {
  f.align.align = ffi.Pointer.fromFunction(alignAlign);
}
AlignObjSt alignAlign(ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Double> widthFactor, ffi.Pointer<ffi.Double> heightFactor, ffi.Pointer<DartObj> child) {
  final w = Align(alignment: alignment.objOrNul(),
      widthFactor: widthFactor.doubleOrNul(),
      heightFactor: heightFactor.doubleOrNul(),
      child: child.objOrNul());
  return _createAlignObjSt(w);
}
AlignObjSt _createAlignObjSt(Align? w) {
  final AlignObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.alignment = _addWidget(w.alignment);
  stObj.widthFactor = (w.widthFactor != null) ? w.widthFactor! : 0;
  stObj.heightFactor = (w.heightFactor != null) ? w.heightFactor! : 0;
  return stObj;
}

void _setupColumn(WidgetFactories f) {
  f.column.column = ffi.Pointer.fromFunction(columnColumn);
}
ColumnObjSt columnColumn(ffi.Pointer<ffi.Int> mainAxisAlignment, ffi.Pointer<ffi.Int> mainAxisSize, ffi.Pointer<ffi.Int> crossAxisAlignment, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> verticalDirection, ffi.Pointer<ffi.Int> textBaseline, ffi.Pointer<ffi.Double> spacing, ffi.Pointer<ArrayC> children) {
  final w = Column(mainAxisAlignment: mainAxisAlignment.enumOr(MainAxisAlignment.values, MainAxisAlignment.start),
      mainAxisSize: mainAxisSize.enumOr(MainAxisSize.values, MainAxisSize.max),
      crossAxisAlignment: crossAxisAlignment.enumOr(CrossAxisAlignment.values, CrossAxisAlignment.center),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      verticalDirection: verticalDirection.enumOr(VerticalDirection.values, VerticalDirection.down),
      textBaseline: textBaseline.enumOrNul(TextBaseline.values),
      spacing: spacing.doubleOr(0.0),
      children: children.orEmpty());
  return _createColumnObjSt(w);
}
ColumnObjSt _createColumnObjSt(Column? w) {
  final ColumnObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupFlex(WidgetFactories f) {
  f.flex.flex = ffi.Pointer.fromFunction(flexFlex);
}
FlexObjSt flexFlex(int direction, ffi.Pointer<ffi.Int> mainAxisAlignment, ffi.Pointer<ffi.Int> mainAxisSize, ffi.Pointer<ffi.Int> crossAxisAlignment, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> verticalDirection, ffi.Pointer<ffi.Int> textBaseline, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Double> spacing, ffi.Pointer<ArrayC> children) {
  final w = Flex(direction: _widgetsMap[direction]! as Axis,
      mainAxisAlignment: mainAxisAlignment.enumOr(MainAxisAlignment.values, MainAxisAlignment.start),
      mainAxisSize: mainAxisSize.enumOr(MainAxisSize.values, MainAxisSize.max),
      crossAxisAlignment: crossAxisAlignment.enumOr(CrossAxisAlignment.values, CrossAxisAlignment.center),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      verticalDirection: verticalDirection.enumOr(VerticalDirection.values, VerticalDirection.down),
      textBaseline: textBaseline.enumOrNul(TextBaseline.values),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      spacing: spacing.doubleOr(0.0),
      children: children.orEmpty());
  return _createFlexObjSt(w);
}
FlexObjSt _createFlexObjSt(Flex? w) {
  final FlexObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.direction = w.direction.index;
  stObj.mainAxisAlignment = w.mainAxisAlignment.index;
  stObj.mainAxisSize = w.mainAxisSize.index;
  stObj.crossAxisAlignment = w.crossAxisAlignment.index;
  stObj.textDirection = (w.textDirection != null) ? w.textDirection!.index : 0;
  stObj.verticalDirection = w.verticalDirection.index;
  stObj.textBaseline = (w.textBaseline != null) ? w.textBaseline!.index : 0;
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.spacing = w.spacing;
  return stObj;
}

void _setupRow(WidgetFactories f) {
  f.row.row = ffi.Pointer.fromFunction(rowRow);
}
RowObjSt rowRow(ffi.Pointer<ffi.Int> mainAxisAlignment, ffi.Pointer<ffi.Int> mainAxisSize, ffi.Pointer<ffi.Int> crossAxisAlignment, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> verticalDirection, ffi.Pointer<ffi.Int> textBaseline, ffi.Pointer<ffi.Double> spacing, ffi.Pointer<ArrayC> children) {
  final w = Row(mainAxisAlignment: mainAxisAlignment.enumOr(MainAxisAlignment.values, MainAxisAlignment.start),
      mainAxisSize: mainAxisSize.enumOr(MainAxisSize.values, MainAxisSize.max),
      crossAxisAlignment: crossAxisAlignment.enumOr(CrossAxisAlignment.values, CrossAxisAlignment.center),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      verticalDirection: verticalDirection.enumOr(VerticalDirection.values, VerticalDirection.down),
      textBaseline: textBaseline.enumOrNul(TextBaseline.values),
      spacing: spacing.doubleOr(0.0),
      children: children.orEmpty());
  return _createRowObjSt(w);
}
RowObjSt _createRowObjSt(Row? w) {
  final RowObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupIconData(WidgetFactories f) {
  f.iconData.iconData = ffi.Pointer.fromFunction(iconDataIconData);
}
IconDataObjSt iconDataIconData(int codePoint, ffi.Pointer<ffi.Char> fontFamily, ffi.Pointer<ffi.Char> fontPackage, ffi.Pointer<ffi.Int> matchTextDirection, ffi.Pointer<ffi.Pointer<ffi.Pointer<ffi.Char>>> fontFamilyFallback) {
  final w = IconData(codePoint,
      fontFamily: fontFamily.strOrNul(),
      fontPackage: fontPackage.strOrNul(),
      matchTextDirection: matchTextDirection.boolOr(false),
      fontFamilyFallback: fontFamilyFallback.orEmpty());
  return _createIconDataObjSt(w);
}
IconDataObjSt _createIconDataObjSt(IconData? w) {
  final IconDataObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.codePoint = w.codePoint;
  stObj.fontFamily = (w.fontFamily != null) ? w.fontFamily!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.fontPackage = (w.fontPackage != null) ? w.fontPackage!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.matchTextDirection = w.matchTextDirection.toInt();
  return stObj;
}

void _setupIcon(WidgetFactories f) {
  f.icon.icon = ffi.Pointer.fromFunction(iconIcon);
}
IconObjSt iconIcon(DartDartObj icon, ffi.Pointer<ffi.Double> size, ffi.Pointer<ffi.Double> fill, ffi.Pointer<ffi.Double> weight, ffi.Pointer<ffi.Double> grade, ffi.Pointer<ffi.Double> opticalSize, ffi.Pointer<DartObj> color, ffi.Pointer<ArrayC> shadows, ffi.Pointer<ffi.Char> semanticLabel, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> applyTextScaling, ffi.Pointer<ffi.Int> blendMode) {
  final w = Icon(_widgetsMap[icon]! as IconData?,
      size: size.doubleOrNul(),
      fill: fill.doubleOrNul(),
      weight: weight.doubleOrNul(),
      grade: grade.doubleOrNul(),
      opticalSize: opticalSize.doubleOrNul(),
      color: color.objOrNul(),
      shadows: shadows.orEmpty(),
      semanticLabel: semanticLabel.strOrNul(),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      applyTextScaling: applyTextScaling.boolOrNul(),
      blendMode: blendMode.enumOrNul(BlendMode.values));
  return _createIconObjSt(w);
}
IconObjSt _createIconObjSt(Icon? w) {
  final IconObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.icon = _createIconDataObjSt(w.icon);
  stObj.size = (w.size != null) ? w.size! : 0;
  stObj.fill = (w.fill != null) ? w.fill! : 0;
  stObj.weight = (w.weight != null) ? w.weight! : 0;
  stObj.grade = (w.grade != null) ? w.grade! : 0;
  stObj.opticalSize = (w.opticalSize != null) ? w.opticalSize! : 0;
  stObj.color = _addWidget(w.color);
  stObj.semanticLabel = (w.semanticLabel != null) ? w.semanticLabel!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.textDirection = (w.textDirection != null) ? w.textDirection!.index : 0;
  stObj.applyTextScaling = (w.applyTextScaling != null) ? w.applyTextScaling!.toInt() : 0;
  stObj.blendMode = (w.blendMode != null) ? w.blendMode!.index : 0;
  return stObj;
}

void _setupTransform(WidgetFactories f) {
  f.transform.rotate = ffi.Pointer.fromFunction(transformRotate);
  f.transform.translate = ffi.Pointer.fromFunction(transformTranslate);
  f.transform.scale = ffi.Pointer.fromFunction(transformScale);
  f.transform.flip = ffi.Pointer.fromFunction(transformFlip);
}
TransformObjSt transformRotate(double angle, ffi.Pointer<DartObj> origin, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Int> transformHitTests, ffi.Pointer<ffi.Int> filterQuality, ffi.Pointer<DartObj> child) {
  final w = Transform.rotate(angle: angle,
      origin: origin.objOrNul(),
      alignment: alignment.objOrNul(),
      transformHitTests: transformHitTests.boolOr(true),
      filterQuality: filterQuality.enumOrNul(FilterQuality.values),
      child: child.objOrNul());
  return _createTransformObjSt(w);
}
TransformObjSt transformTranslate(DartDartObj offset, ffi.Pointer<ffi.Int> transformHitTests, ffi.Pointer<ffi.Int> filterQuality, ffi.Pointer<DartObj> child) {
  final w = Transform.translate(offset: _widgetsMap[offset]! as Offset,
      transformHitTests: transformHitTests.boolOr(true),
      filterQuality: filterQuality.enumOrNul(FilterQuality.values),
      child: child.objOrNul());
  return _createTransformObjSt(w);
}
TransformObjSt transformScale(ffi.Pointer<ffi.Double> scale, ffi.Pointer<ffi.Double> scaleX, ffi.Pointer<ffi.Double> scaleY, ffi.Pointer<DartObj> origin, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Int> transformHitTests, ffi.Pointer<ffi.Int> filterQuality, ffi.Pointer<DartObj> child) {
  final w = Transform.scale(scale: scale.doubleOrNul(),
      scaleX: scaleX.doubleOrNul(),
      scaleY: scaleY.doubleOrNul(),
      origin: origin.objOrNul(),
      alignment: alignment.objOrNul(),
      transformHitTests: transformHitTests.boolOr(true),
      filterQuality: filterQuality.enumOrNul(FilterQuality.values),
      child: child.objOrNul());
  return _createTransformObjSt(w);
}
TransformObjSt transformFlip(ffi.Pointer<ffi.Int> flipX, ffi.Pointer<ffi.Int> flipY, ffi.Pointer<DartObj> origin, ffi.Pointer<ffi.Int> transformHitTests, ffi.Pointer<ffi.Int> filterQuality, ffi.Pointer<DartObj> child) {
  final w = Transform.flip(flipX: flipX.boolOr(false),
      flipY: flipY.boolOr(false),
      origin: origin.objOrNul(),
      transformHitTests: transformHitTests.boolOr(true),
      filterQuality: filterQuality.enumOrNul(FilterQuality.values),
      child: child.objOrNul());
  return _createTransformObjSt(w);
}
TransformObjSt _createTransformObjSt(Transform? w) {
  final TransformObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.origin = _addWidget(w.origin);
  stObj.alignment = _addWidget(w.alignment);
  stObj.transformHitTests = w.transformHitTests.toInt();
  stObj.filterQuality = (w.filterQuality != null) ? w.filterQuality!.index : 0;
  return stObj;
}

void _setupOffset(WidgetFactories f) {
  f.offset.offset = ffi.Pointer.fromFunction(offsetOffset, exception);
  f.offset.fromDirection = ffi.Pointer.fromFunction(offsetFromDirection, exception);
  f.offset.lerp = ffi.Pointer.fromFunction(offsetLerp, exception);
}
int offsetOffset(double dx, double dy) {
  final w = Offset(dx,
      dy);
  return _addWidget(w);
}
int offsetFromDirection(double direction, ffi.Pointer<ffi.Double> distance) {
  final w = Offset.fromDirection(direction,
      distance.doubleOr(1.0));
  return _addWidget(w);
}
int offsetLerp(DartDartObj a, DartDartObj b, double t) {
  final w = Offset.lerp(_widgetsMap[a]! as Offset?,
      _widgetsMap[b]! as Offset?,
      t);
  return _addWidget(w);
}

void _setupOpacity(WidgetFactories f) {
  f.opacity.opacity = ffi.Pointer.fromFunction(opacityOpacity);
}
OpacityObjSt opacityOpacity(double opacity, ffi.Pointer<ffi.Int> alwaysIncludeSemantics, ffi.Pointer<DartObj> child) {
  final w = Opacity(opacity: opacity,
      alwaysIncludeSemantics: alwaysIncludeSemantics.boolOr(false),
      child: child.objOrNul());
  return _createOpacityObjSt(w);
}
OpacityObjSt _createOpacityObjSt(Opacity? w) {
  final OpacityObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.opacity = w.opacity;
  stObj.alwaysIncludeSemantics = w.alwaysIncludeSemantics.toInt();
  return stObj;
}

void _setupStack(WidgetFactories f) {
  f.stack.stack = ffi.Pointer.fromFunction(stackStack);
}
StackObjSt stackStack(ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> fit, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ArrayC> children) {
  final w = Stack(alignment: alignment.objOrNul(),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      fit: fit.enumOr(StackFit.values, StackFit.loose),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      children: children.orEmpty());
  return _createStackObjSt(w);
}
StackObjSt _createStackObjSt(Stack? w) {
  final StackObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.alignment = _addWidget(w.alignment);
  stObj.textDirection = (w.textDirection != null) ? w.textDirection!.index : 0;
  stObj.fit = w.fit.index;
  stObj.clipBehavior = w.clipBehavior.index;
  return stObj;
}

void _setupBoxConstraints(WidgetFactories f) {
  f.boxConstraints.boxConstraints = ffi.Pointer.fromFunction(boxConstraintsBoxConstraints);
  f.boxConstraints.tightFor = ffi.Pointer.fromFunction(boxConstraintsTightFor);
  f.boxConstraints.tightForFinite = ffi.Pointer.fromFunction(boxConstraintsTightForFinite);
  f.boxConstraints.expand = ffi.Pointer.fromFunction(boxConstraintsExpand);
  f.boxConstraints.lerp = ffi.Pointer.fromFunction(boxConstraintsLerp);
}
BoxConstraintsObjSt boxConstraintsBoxConstraints(ffi.Pointer<ffi.Double> minWidth, ffi.Pointer<ffi.Double> maxWidth, ffi.Pointer<ffi.Double> minHeight, ffi.Pointer<ffi.Double> maxHeight) {
  final w = BoxConstraints(minWidth: minWidth.doubleOr(0.0),
      maxWidth: maxWidth.doubleOr(double.infinity),
      minHeight: minHeight.doubleOr(0.0),
      maxHeight: maxHeight.doubleOr(double.infinity));
  return _createBoxConstraintsObjSt(w);
}
BoxConstraintsObjSt boxConstraintsTightFor(ffi.Pointer<ffi.Double> width, ffi.Pointer<ffi.Double> height) {
  final w = BoxConstraints.tightFor(width: width.doubleOrNul(),
      height: height.doubleOrNul());
  return _createBoxConstraintsObjSt(w);
}
BoxConstraintsObjSt boxConstraintsTightForFinite(ffi.Pointer<ffi.Double> width, ffi.Pointer<ffi.Double> height) {
  final w = BoxConstraints.tightForFinite(width: width.doubleOr(double.infinity),
      height: height.doubleOr(double.infinity));
  return _createBoxConstraintsObjSt(w);
}
BoxConstraintsObjSt boxConstraintsExpand(ffi.Pointer<ffi.Double> width, ffi.Pointer<ffi.Double> height) {
  final w = BoxConstraints.expand(width: width.doubleOrNul(),
      height: height.doubleOrNul());
  return _createBoxConstraintsObjSt(w);
}
BoxConstraintsObjSt? boxConstraintsLerp(DartDartObj a, DartDartObj b, double t) {
  final w = BoxConstraints.lerp(_widgetsMap[a]! as BoxConstraints?,
      _widgetsMap[b]! as BoxConstraints?,
      t);
  return w != null ? _createBoxConstraintsObjSt(w) : null;
}
BoxConstraintsObjSt _createBoxConstraintsObjSt(BoxConstraints? w) {
  final BoxConstraintsObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.minWidth = w.minWidth;
  stObj.maxWidth = w.maxWidth;
  stObj.minHeight = w.minHeight;
  stObj.maxHeight = w.maxHeight;
  stObj.hasTightWidth = w.hasTightWidth.toInt();
  stObj.hasTightHeight = w.hasTightHeight.toInt();
  stObj.hasBoundedWidth = w.hasBoundedWidth.toInt();
  stObj.hasBoundedHeight = w.hasBoundedHeight.toInt();
  stObj.hasInfiniteWidth = w.hasInfiniteWidth.toInt();
  stObj.hasInfiniteHeight = w.hasInfiniteHeight.toInt();
  return stObj;
}

void _setupContainer(WidgetFactories f) {
  f.container.container = ffi.Pointer.fromFunction(containerContainer);
}
ContainerObjSt containerContainer(ffi.Pointer<DartObj> alignment, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> decoration, ffi.Pointer<DartObj> foregroundDecoration, ffi.Pointer<ffi.Double> width, ffi.Pointer<ffi.Double> height, ffi.Pointer<DartObj> constraints, ffi.Pointer<DartObj> margin, ffi.Pointer<DartObj> transformAlignment, ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Int> clipBehavior) {
  final w = Container(alignment: alignment.objOrNul(),
      padding: padding.objOrNul(),
      color: color.objOrNul(),
      decoration: decoration.objOrNul(),
      foregroundDecoration: foregroundDecoration.objOrNul(),
      width: width.doubleOrNul(),
      height: height.doubleOrNul(),
      constraints: constraints.objOrNul(),
      margin: margin.objOrNul(),
      transformAlignment: transformAlignment.objOrNul(),
      child: child.objOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none));
  return _createContainerObjSt(w);
}
ContainerObjSt _createContainerObjSt(Container? w) {
  final ContainerObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.alignment = _addWidget(w.alignment);
  stObj.padding = _addWidget(w.padding);
  stObj.color = _addWidget(w.color);
  stObj.decoration = _addWidget(w.decoration);
  stObj.foregroundDecoration = _addWidget(w.foregroundDecoration);
  stObj.constraints = _createBoxConstraintsObjSt(w.constraints);
  stObj.margin = _addWidget(w.margin);
  stObj.transformAlignment = _addWidget(w.transformAlignment);
  stObj.clipBehavior = w.clipBehavior.index;
  return stObj;
}

void _setupStackParentData(WidgetFactories f) {
  f.stackParentData.stackParentData = ffi.Pointer.fromFunction(stackParentDataStackParentData, exception);
}
int stackParentDataStackParentData() {
  final w = StackParentData();
  return _addWidget(w);
}

void _setupBoxParentData(WidgetFactories f) {
  f.boxParentData.boxParentData = ffi.Pointer.fromFunction(boxParentDataBoxParentData, exception);
}
int boxParentDataBoxParentData() {
  final w = BoxParentData();
  return _addWidget(w);
}

void _setupParentData(WidgetFactories f) {
  f.parentData.parentData = ffi.Pointer.fromFunction(parentDataParentData, exception);
}
int parentDataParentData() {
  final w = ParentData();
  return _addWidget(w);
}

void _setupPositioned(WidgetFactories f) {
  f.positioned.positioned = ffi.Pointer.fromFunction(positionedPositioned);
  f.positioned.fill = ffi.Pointer.fromFunction(positionedFill);
  f.positioned.directional = ffi.Pointer.fromFunction(positionedDirectional);
}
PositionedObjSt positionedPositioned(ffi.Pointer<ffi.Double> left, ffi.Pointer<ffi.Double> top, ffi.Pointer<ffi.Double> right, ffi.Pointer<ffi.Double> bottom, ffi.Pointer<ffi.Double> width, ffi.Pointer<ffi.Double> height, DartDartObj child) {
  final w = Positioned(left: left.doubleOrNul(),
      top: top.doubleOrNul(),
      right: right.doubleOrNul(),
      bottom: bottom.doubleOrNul(),
      width: width.doubleOrNul(),
      height: height.doubleOrNul(),
      child: _widgetsMap[child]! as Widget);
  return _createPositionedObjSt(w);
}
PositionedObjSt positionedFill(ffi.Pointer<ffi.Double> left, ffi.Pointer<ffi.Double> top, ffi.Pointer<ffi.Double> right, ffi.Pointer<ffi.Double> bottom, DartDartObj child) {
  final w = Positioned.fill(left: left.doubleOrNul(),
      top: top.doubleOrNul(),
      right: right.doubleOrNul(),
      bottom: bottom.doubleOrNul(),
      child: _widgetsMap[child]! as Widget);
  return _createPositionedObjSt(w);
}
PositionedObjSt positionedDirectional(int textDirection, ffi.Pointer<ffi.Double> start, ffi.Pointer<ffi.Double> top, ffi.Pointer<ffi.Double> end, ffi.Pointer<ffi.Double> bottom, ffi.Pointer<ffi.Double> width, ffi.Pointer<ffi.Double> height, DartDartObj child) {
  final w = Positioned.directional(textDirection: _widgetsMap[textDirection]! as TextDirection,
      start: start.doubleOrNul(),
      top: top.doubleOrNul(),
      end: end.doubleOrNul(),
      bottom: bottom.doubleOrNul(),
      width: width.doubleOrNul(),
      height: height.doubleOrNul(),
      child: _widgetsMap[child]! as Widget);
  return _createPositionedObjSt(w);
}
PositionedObjSt _createPositionedObjSt(Positioned? w) {
  final PositionedObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.left = (w.left != null) ? w.left! : 0;
  stObj.top = (w.top != null) ? w.top! : 0;
  stObj.right = (w.right != null) ? w.right! : 0;
  stObj.bottom = (w.bottom != null) ? w.bottom! : 0;
  stObj.width = (w.width != null) ? w.width! : 0;
  stObj.height = (w.height != null) ? w.height! : 0;
  return stObj;
}

void _setupBoxDecoration(WidgetFactories f) {
  f.boxDecoration.boxDecoration = ffi.Pointer.fromFunction(boxDecorationBoxDecoration);
  f.boxDecoration.lerp = ffi.Pointer.fromFunction(boxDecorationLerp);
}
BoxDecorationObjSt boxDecorationBoxDecoration(ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> border, ffi.Pointer<DartObj> borderRadius, ffi.Pointer<ArrayC> boxShadow, ffi.Pointer<ffi.Int> backgroundBlendMode, ffi.Pointer<ffi.Int> shape) {
  final w = BoxDecoration(color: color.objOrNul(),
      border: border.objOrNul(),
      borderRadius: borderRadius.objOrNul(),
      boxShadow: boxShadow.orEmpty(),
      backgroundBlendMode: backgroundBlendMode.enumOrNul(BlendMode.values),
      shape: shape.enumOr(BoxShape.values, BoxShape.rectangle));
  return _createBoxDecorationObjSt(w);
}
BoxDecorationObjSt? boxDecorationLerp(DartDartObj a, DartDartObj b, double t) {
  final w = BoxDecoration.lerp(_widgetsMap[a]! as BoxDecoration?,
      _widgetsMap[b]! as BoxDecoration?,
      t);
  return w != null ? _createBoxDecorationObjSt(w) : null;
}
BoxDecorationObjSt _createBoxDecorationObjSt(BoxDecoration? w) {
  final BoxDecorationObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.color = _addWidget(w.color);
  stObj.border = _addWidget(w.border);
  stObj.borderRadius = _addWidget(w.borderRadius);
  stObj.backgroundBlendMode = (w.backgroundBlendMode != null) ? w.backgroundBlendMode!.index : 0;
  stObj.shape = w.shape.index;
  return stObj;
}

void _setupRadius(WidgetFactories f) {
  f.radius.circular = ffi.Pointer.fromFunction(radiusCircular, exception);
  f.radius.elliptical = ffi.Pointer.fromFunction(radiusElliptical, exception);
  f.radius.lerp = ffi.Pointer.fromFunction(radiusLerp, exception);
}
int radiusCircular(double radius) {
  final w = Radius.circular(radius);
  return _addWidget(w);
}
int radiusElliptical(double x, double y) {
  final w = Radius.elliptical(x,
      y);
  return _addWidget(w);
}
int radiusLerp(DartDartObj a, DartDartObj b, double t) {
  final w = Radius.lerp(_widgetsMap[a]! as Radius?,
      _widgetsMap[b]! as Radius?,
      t);
  return _addWidget(w);
}

void _setupBorderRadius(WidgetFactories f) {
  f.borderRadius.all = ffi.Pointer.fromFunction(borderRadiusAll);
  f.borderRadius.circular = ffi.Pointer.fromFunction(borderRadiusCircular);
  f.borderRadius.vertical = ffi.Pointer.fromFunction(borderRadiusVertical);
  f.borderRadius.horizontal = ffi.Pointer.fromFunction(borderRadiusHorizontal);
  f.borderRadius.only = ffi.Pointer.fromFunction(borderRadiusOnly);
  f.borderRadius.lerp = ffi.Pointer.fromFunction(borderRadiusLerp);
}
BorderRadiusObjSt borderRadiusAll(DartDartObj radius) {
  final w = BorderRadius.all(_widgetsMap[radius]! as Radius);
  return _createBorderRadiusObjSt(w);
}
BorderRadiusObjSt borderRadiusCircular(double radius) {
  final w = BorderRadius.circular(radius);
  return _createBorderRadiusObjSt(w);
}
BorderRadiusObjSt borderRadiusVertical(ffi.Pointer<DartObj> top, ffi.Pointer<DartObj> bottom) {
  final w = BorderRadius.vertical(top: top.objOrNul(),
      bottom: bottom.objOrNul());
  return _createBorderRadiusObjSt(w);
}
BorderRadiusObjSt borderRadiusHorizontal(ffi.Pointer<DartObj> left, ffi.Pointer<DartObj> right) {
  final w = BorderRadius.horizontal(left: left.objOrNul(),
      right: right.objOrNul());
  return _createBorderRadiusObjSt(w);
}
BorderRadiusObjSt borderRadiusOnly(ffi.Pointer<DartObj> topLeft, ffi.Pointer<DartObj> topRight, ffi.Pointer<DartObj> bottomLeft, ffi.Pointer<DartObj> bottomRight) {
  final w = BorderRadius.only(topLeft: topLeft.objOrNul(),
      topRight: topRight.objOrNul(),
      bottomLeft: bottomLeft.objOrNul(),
      bottomRight: bottomRight.objOrNul());
  return _createBorderRadiusObjSt(w);
}
BorderRadiusObjSt? borderRadiusLerp(DartDartObj a, DartDartObj b, double t) {
  final w = BorderRadius.lerp(_widgetsMap[a]! as BorderRadius?,
      _widgetsMap[b]! as BorderRadius?,
      t);
  return w != null ? _createBorderRadiusObjSt(w) : null;
}
BorderRadiusObjSt _createBorderRadiusObjSt(BorderRadius? w) {
  final BorderRadiusObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.topLeft = _addWidget(w.topLeft);
  stObj.topRight = _addWidget(w.topRight);
  stObj.bottomLeft = _addWidget(w.bottomLeft);
  stObj.bottomRight = _addWidget(w.bottomRight);
  return stObj;
}

void _setupBoxShadow(WidgetFactories f) {
  f.boxShadow.boxShadow = ffi.Pointer.fromFunction(boxShadowBoxShadow);
  f.boxShadow.lerp = ffi.Pointer.fromFunction(boxShadowLerp);
}
BoxShadowObjSt boxShadowBoxShadow(ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> offset, ffi.Pointer<ffi.Double> blurRadius, ffi.Pointer<ffi.Double> spreadRadius, ffi.Pointer<ffi.Int> blurStyle) {
  final w = BoxShadow(color: color.objOrNul(),
      offset: offset.objOrNul(),
      blurRadius: blurRadius.doubleOr(0.0),
      spreadRadius: spreadRadius.doubleOr(0.0),
      blurStyle: blurStyle.enumOr(BlurStyle.values, BlurStyle.normal));
  return _createBoxShadowObjSt(w);
}
BoxShadowObjSt? boxShadowLerp(DartDartObj a, DartDartObj b, double t) {
  final w = BoxShadow.lerp(_widgetsMap[a]! as BoxShadow?,
      _widgetsMap[b]! as BoxShadow?,
      t);
  return w != null ? _createBoxShadowObjSt(w) : null;
}
BoxShadowObjSt _createBoxShadowObjSt(BoxShadow? w) {
  final BoxShadowObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.spreadRadius = w.spreadRadius;
  stObj.blurStyle = w.blurStyle.index;
  return stObj;
}

void _setupShadow(WidgetFactories f) {
  f.shadow.shadow = ffi.Pointer.fromFunction(shadowShadow, exception);
  f.shadow.lerp = ffi.Pointer.fromFunction(shadowLerp, exception);
}
int shadowShadow(ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> offset, ffi.Pointer<ffi.Double> blurRadius) {
  final w = Shadow(color: color.objOrNul(),
      offset: offset.objOrNul(),
      blurRadius: blurRadius.doubleOr(0.0));
  return _addWidget(w);
}
int shadowLerp(DartDartObj a, DartDartObj b, double t) {
  final w = Shadow.lerp(_widgetsMap[a]! as Shadow?,
      _widgetsMap[b]! as Shadow?,
      t);
  return _addWidget(w);
}

void _setupPadding(WidgetFactories f) {
  f.padding.padding = ffi.Pointer.fromFunction(paddingPadding);
}
PaddingObjSt paddingPadding(DartDartObj padding, ffi.Pointer<DartObj> child) {
  final w = Padding(padding: _widgetsMap[padding]! as EdgeInsetsGeometry,
      child: child.objOrNul());
  return _createPaddingObjSt(w);
}
PaddingObjSt _createPaddingObjSt(Padding? w) {
  final PaddingObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.padding = _addWidget(w.padding);
  return stObj;
}

void _setupEdgeInsets(WidgetFactories f) {
  f.edgeInsets.fromLTRB = ffi.Pointer.fromFunction(edgeInsetsFromLTRB);
  f.edgeInsets.all = ffi.Pointer.fromFunction(edgeInsetsAll);
  f.edgeInsets.only = ffi.Pointer.fromFunction(edgeInsetsOnly);
  f.edgeInsets.symmetric = ffi.Pointer.fromFunction(edgeInsetsSymmetric);
  f.edgeInsets.lerp = ffi.Pointer.fromFunction(edgeInsetsLerp);
}
EdgeInsetsObjSt edgeInsetsFromLTRB(double left, double top, double right, double bottom) {
  final w = EdgeInsets.fromLTRB(left,
      top,
      right,
      bottom);
  return _createEdgeInsetsObjSt(w);
}
EdgeInsetsObjSt edgeInsetsAll(double value) {
  final w = EdgeInsets.all(value);
  return _createEdgeInsetsObjSt(w);
}
EdgeInsetsObjSt edgeInsetsOnly(ffi.Pointer<ffi.Double> left, ffi.Pointer<ffi.Double> top, ffi.Pointer<ffi.Double> right, ffi.Pointer<ffi.Double> bottom) {
  final w = EdgeInsets.only(left: left.doubleOr(0.0),
      top: top.doubleOr(0.0),
      right: right.doubleOr(0.0),
      bottom: bottom.doubleOr(0.0));
  return _createEdgeInsetsObjSt(w);
}
EdgeInsetsObjSt edgeInsetsSymmetric(ffi.Pointer<ffi.Double> vertical, ffi.Pointer<ffi.Double> horizontal) {
  final w = EdgeInsets.symmetric(vertical: vertical.doubleOr(0.0),
      horizontal: horizontal.doubleOr(0.0));
  return _createEdgeInsetsObjSt(w);
}
EdgeInsetsObjSt? edgeInsetsLerp(DartDartObj a, DartDartObj b, double t) {
  final w = EdgeInsets.lerp(_widgetsMap[a]! as EdgeInsets?,
      _widgetsMap[b]! as EdgeInsets?,
      t);
  return w != null ? _createEdgeInsetsObjSt(w) : null;
}
EdgeInsetsObjSt _createEdgeInsetsObjSt(EdgeInsets? w) {
  final EdgeInsetsObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.left = w.left;
  stObj.top = w.top;
  stObj.right = w.right;
  stObj.bottom = w.bottom;
  stObj.topLeft = _addWidget(w.topLeft);
  stObj.topRight = _addWidget(w.topRight);
  stObj.bottomLeft = _addWidget(w.bottomLeft);
  stObj.bottomRight = _addWidget(w.bottomRight);
  return stObj;
}

void _setupBorderSide(WidgetFactories f) {
  f.borderSide.borderSide = ffi.Pointer.fromFunction(borderSideBorderSide);
  f.borderSide.merge = ffi.Pointer.fromFunction(borderSideMerge);
  f.borderSide.lerp = ffi.Pointer.fromFunction(borderSideLerp);
}
BorderSideObjSt borderSideBorderSide(ffi.Pointer<DartObj> color, ffi.Pointer<ffi.Double> width, ffi.Pointer<ffi.Int> style, ffi.Pointer<ffi.Double> strokeAlign) {
  final w = BorderSide(color: color.objOrNul(),
      width: width.doubleOr(1.0),
      style: style.enumOr(BorderStyle.values, BorderStyle.solid),
      strokeAlign: strokeAlign.doubleOr(BorderSide.strokeAlignInside));
  return _createBorderSideObjSt(w);
}
BorderSideObjSt borderSideMerge(DartDartObj a, DartDartObj b) {
  final w = BorderSide.merge(_widgetsMap[a]! as BorderSide,
      _widgetsMap[b]! as BorderSide);
  return _createBorderSideObjSt(w);
}
BorderSideObjSt borderSideLerp(DartDartObj a, DartDartObj b, double t) {
  final w = BorderSide.lerp(_widgetsMap[a]! as BorderSide,
      _widgetsMap[b]! as BorderSide,
      t);
  return _createBorderSideObjSt(w);
}
BorderSideObjSt _createBorderSideObjSt(BorderSide? w) {
  final BorderSideObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.color = _addWidget(w.color);
  stObj.width = w.width;
  stObj.style = w.style.index;
  stObj.strokeAlign = w.strokeAlign;
  stObj.strokeInset = w.strokeInset;
  stObj.strokeOutset = w.strokeOutset;
  stObj.strokeOffset = w.strokeOffset;
  return stObj;
}

void _setupBorder(WidgetFactories f) {
  f.border.border = ffi.Pointer.fromFunction(borderBorder);
  f.border.fromBorderSide = ffi.Pointer.fromFunction(borderFromBorderSide);
  f.border.symmetric = ffi.Pointer.fromFunction(borderSymmetric);
  f.border.all = ffi.Pointer.fromFunction(borderAll);
  f.border.merge = ffi.Pointer.fromFunction(borderMerge);
  f.border.lerp = ffi.Pointer.fromFunction(borderLerp);
}
BorderObjSt borderBorder(ffi.Pointer<DartObj> top, ffi.Pointer<DartObj> right, ffi.Pointer<DartObj> bottom, ffi.Pointer<DartObj> left) {
  final w = Border(top: top.objOrNul(),
      right: right.objOrNul(),
      bottom: bottom.objOrNul(),
      left: left.objOrNul());
  return _createBorderObjSt(w);
}
BorderObjSt borderFromBorderSide(DartDartObj side) {
  final w = Border.fromBorderSide(_widgetsMap[side]! as BorderSide);
  return _createBorderObjSt(w);
}
BorderObjSt borderSymmetric(ffi.Pointer<DartObj> vertical, ffi.Pointer<DartObj> horizontal) {
  final w = Border.symmetric(vertical: vertical.objOrNul(),
      horizontal: horizontal.objOrNul());
  return _createBorderObjSt(w);
}
BorderObjSt borderAll(ffi.Pointer<DartObj> color, ffi.Pointer<ffi.Double> width, ffi.Pointer<ffi.Int> style, ffi.Pointer<ffi.Double> strokeAlign) {
  final w = Border.all(color: color.objOrNul(),
      width: width.doubleOr(1.0),
      style: style.enumOr(BorderStyle.values, BorderStyle.solid),
      strokeAlign: strokeAlign.doubleOr(BorderSide.strokeAlignInside));
  return _createBorderObjSt(w);
}
BorderObjSt borderMerge(DartDartObj a, DartDartObj b) {
  final w = Border.merge(_widgetsMap[a]! as Border,
      _widgetsMap[b]! as Border);
  return _createBorderObjSt(w);
}
BorderObjSt? borderLerp(DartDartObj a, DartDartObj b, double t) {
  final w = Border.lerp(_widgetsMap[a]! as Border?,
      _widgetsMap[b]! as Border?,
      t);
  return w != null ? _createBorderObjSt(w) : null;
}
BorderObjSt _createBorderObjSt(Border? w) {
  final BorderObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.top = _createBorderSideObjSt(w.top);
  stObj.right = _createBorderSideObjSt(w.right);
  stObj.bottom = _createBorderSideObjSt(w.bottom);
  stObj.left = _createBorderSideObjSt(w.left);
  return stObj;
}

void _setupRoundedRectangleBorder(WidgetFactories f) {
  f.roundedRectangleBorder.roundedRectangleBorder = ffi.Pointer.fromFunction(roundedRectangleBorderRoundedRectangleBorder);
}
RoundedRectangleBorderObjSt roundedRectangleBorderRoundedRectangleBorder(ffi.Pointer<DartObj> side, ffi.Pointer<DartObj> borderRadius) {
  final w = RoundedRectangleBorder(side: side.objOrNul(),
      borderRadius: borderRadius.objOrNul());
  return _createRoundedRectangleBorderObjSt(w);
}
RoundedRectangleBorderObjSt _createRoundedRectangleBorderObjSt(RoundedRectangleBorder? w) {
  final RoundedRectangleBorderObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.borderRadius = _addWidget(w.borderRadius);
  return stObj;
}

void _setupAnimationController(WidgetFactories f) {
  f.animationController.animationController = ffi.Pointer.fromFunction(animationControllerAnimationController, exception);
  f.animationController.unbounded = ffi.Pointer.fromFunction(animationControllerUnbounded, exception);
}
int animationControllerAnimationController(ffi.Pointer<ffi.Double> value, ffi.Pointer<ffi.Char> debugLabel, ffi.Pointer<ffi.Double> lowerBound, ffi.Pointer<ffi.Double> upperBound, ffi.Pointer<ffi.Int> animationBehavior, DartDartObj vsync) {
  final w = AnimationController(value: value.doubleOrNul(),
      debugLabel: debugLabel.strOrNul(),
      lowerBound: lowerBound.doubleOr(0.0),
      upperBound: upperBound.doubleOr(1.0),
      animationBehavior: animationBehavior.enumOr(AnimationBehavior.values, AnimationBehavior.normal),
      vsync: _widgetsMap[vsync]! as TickerProvider);
  return _addWidget(w);
}
int animationControllerUnbounded(ffi.Pointer<ffi.Double> value, ffi.Pointer<ffi.Char> debugLabel, DartDartObj vsync, ffi.Pointer<ffi.Int> animationBehavior) {
  final w = AnimationController.unbounded(value: value.doubleOr(0.0),
      debugLabel: debugLabel.strOrNul(),
      vsync: _widgetsMap[vsync]! as TickerProvider,
      animationBehavior: animationBehavior.enumOr(AnimationBehavior.values, AnimationBehavior.preserve));
  return _addWidget(w);
}

void _setupAnimatedBuilder(WidgetFactories f) {
  f.animatedBuilder.animatedBuilder = ffi.Pointer.fromFunction(animatedBuilderAnimatedBuilder);
}
AnimatedBuilderObjSt animatedBuilderAnimatedBuilder(DartDartObj animation, TransitionBuilderFFI builder, ffi.Pointer<DartObj> child) {
  final w = AnimatedBuilder(animation: _widgetsMap[animation]! as Listenable,
      builder: builder.toTransitionBuilderFn(),
      child: child.objOrNul());
  return _createAnimatedBuilderObjSt(w);
}
AnimatedBuilderObjSt _createAnimatedBuilderObjSt(AnimatedBuilder? w) {
  final AnimatedBuilderObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupListenableBuilder(WidgetFactories f) {
  f.listenableBuilder.listenableBuilder = ffi.Pointer.fromFunction(listenableBuilderListenableBuilder);
}
ListenableBuilderObjSt listenableBuilderListenableBuilder(DartDartObj listenable, TransitionBuilderFFI builder, ffi.Pointer<DartObj> child) {
  final w = ListenableBuilder(listenable: _widgetsMap[listenable]! as Listenable,
      builder: builder.toTransitionBuilderFn(),
      child: child.objOrNul());
  return _createListenableBuilderObjSt(w);
}
ListenableBuilderObjSt _createListenableBuilderObjSt(ListenableBuilder? w) {
  final ListenableBuilderObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  return stObj;
}

void _setupCubic(WidgetFactories f) {
  f.cubic.cubic = ffi.Pointer.fromFunction(cubicCubic);
}
CubicObjSt cubicCubic(double a, double b, double c, double d) {
  final w = Cubic(a,
      b,
      c,
      d);
  return _createCubicObjSt(w);
}
CubicObjSt _createCubicObjSt(Cubic? w) {
  final CubicObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.a = w.a;
  stObj.b = w.b;
  stObj.c = w.c;
  stObj.d = w.d;
  return stObj;
}

void _setupThreePointCubic(WidgetFactories f) {
  f.threePointCubic.threePointCubic = ffi.Pointer.fromFunction(threePointCubicThreePointCubic);
}
ThreePointCubicObjSt threePointCubicThreePointCubic(DartDartObj a1, DartDartObj b1, DartDartObj midpoint, DartDartObj a2, DartDartObj b2) {
  final w = ThreePointCubic(_widgetsMap[a1]! as Offset,
      _widgetsMap[b1]! as Offset,
      _widgetsMap[midpoint]! as Offset,
      _widgetsMap[a2]! as Offset,
      _widgetsMap[b2]! as Offset);
  return _createThreePointCubicObjSt(w);
}
ThreePointCubicObjSt _createThreePointCubicObjSt(ThreePointCubic? w) {
  final ThreePointCubicObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.a1 = _addWidget(w.a1);
  stObj.b1 = _addWidget(w.b1);
  stObj.midpoint = _addWidget(w.midpoint);
  stObj.a2 = _addWidget(w.a2);
  stObj.b2 = _addWidget(w.b2);
  return stObj;
}

void _setupElasticOutCurve(WidgetFactories f) {
  f.elasticOutCurve.elasticOutCurve = ffi.Pointer.fromFunction(elasticOutCurveElasticOutCurve);
}
ElasticOutCurveObjSt elasticOutCurveElasticOutCurve(ffi.Pointer<ffi.Double> period) {
  final w = ElasticOutCurve(period.doubleOr(0.4));
  return _createElasticOutCurveObjSt(w);
}
ElasticOutCurveObjSt _createElasticOutCurveObjSt(ElasticOutCurve? w) {
  final ElasticOutCurveObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.period = w.period;
  return stObj;
}

void _setupElasticInCurve(WidgetFactories f) {
  f.elasticInCurve.elasticInCurve = ffi.Pointer.fromFunction(elasticInCurveElasticInCurve);
}
ElasticInCurveObjSt elasticInCurveElasticInCurve(ffi.Pointer<ffi.Double> period) {
  final w = ElasticInCurve(period.doubleOr(0.4));
  return _createElasticInCurveObjSt(w);
}
ElasticInCurveObjSt _createElasticInCurveObjSt(ElasticInCurve? w) {
  final ElasticInCurveObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.period = w.period;
  return stObj;
}

void _setupElasticInOutCurve(WidgetFactories f) {
  f.elasticInOutCurve.elasticInOutCurve = ffi.Pointer.fromFunction(elasticInOutCurveElasticInOutCurve);
}
ElasticInOutCurveObjSt elasticInOutCurveElasticInOutCurve(ffi.Pointer<ffi.Double> period) {
  final w = ElasticInOutCurve(period.doubleOr(0.4));
  return _createElasticInOutCurveObjSt(w);
}
ElasticInOutCurveObjSt _createElasticInOutCurveObjSt(ElasticInOutCurve? w) {
  final ElasticInOutCurveObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.period = w.period;
  return stObj;
}

void _setupCurvedAnimation(WidgetFactories f) {
  f.curvedAnimation.curvedAnimation = ffi.Pointer.fromFunction(curvedAnimationCurvedAnimation, exception);
}
int curvedAnimationCurvedAnimation(DartDartObj parent, DartDartObj curve, ffi.Pointer<DartObj> reverseCurve) {
  final w = CurvedAnimation(parent: _widgetsMap[parent]! as Animation<double>,
      curve: _widgetsMap[curve]! as Curve,
      reverseCurve: reverseCurve.objOrNul());
  return _addWidget(w);
}

void _setupSizedBox(WidgetFactories f) {
  f.sizedBox.sizedBox = ffi.Pointer.fromFunction(sizedBoxSizedBox);
  f.sizedBox.expand = ffi.Pointer.fromFunction(sizedBoxExpand);
  f.sizedBox.shrink = ffi.Pointer.fromFunction(sizedBoxShrink);
  f.sizedBox.fromSize = ffi.Pointer.fromFunction(sizedBoxFromSize);
  f.sizedBox.square = ffi.Pointer.fromFunction(sizedBoxSquare);
}
SizedBoxObjSt sizedBoxSizedBox(ffi.Pointer<ffi.Double> width, ffi.Pointer<ffi.Double> height, ffi.Pointer<DartObj> child) {
  final w = SizedBox(width: width.doubleOrNul(),
      height: height.doubleOrNul(),
      child: child.objOrNul());
  return _createSizedBoxObjSt(w);
}
SizedBoxObjSt sizedBoxExpand(ffi.Pointer<DartObj> child) {
  final w = SizedBox.expand(child: child.objOrNul());
  return _createSizedBoxObjSt(w);
}
SizedBoxObjSt sizedBoxShrink(ffi.Pointer<DartObj> child) {
  final w = SizedBox.shrink(child: child.objOrNul());
  return _createSizedBoxObjSt(w);
}
SizedBoxObjSt sizedBoxFromSize(ffi.Pointer<DartObj> child) {
  final w = SizedBox.fromSize(child: child.objOrNul());
  return _createSizedBoxObjSt(w);
}
SizedBoxObjSt sizedBoxSquare(ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Double> dimension) {
  final w = SizedBox.square(child: child.objOrNul(),
      dimension: dimension.doubleOrNul());
  return _createSizedBoxObjSt(w);
}
SizedBoxObjSt _createSizedBoxObjSt(SizedBox? w) {
  final SizedBoxObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.width = (w.width != null) ? w.width! : 0;
  stObj.height = (w.height != null) ? w.height! : 0;
  return stObj;
}

void _setupAlignment(WidgetFactories f) {
  f.alignment.alignment = ffi.Pointer.fromFunction(alignmentAlignment);
  f.alignment.lerp = ffi.Pointer.fromFunction(alignmentLerp);
}
AlignmentObjSt alignmentAlignment(double x, double y) {
  final w = Alignment(x,
      y);
  return _createAlignmentObjSt(w);
}
AlignmentObjSt? alignmentLerp(DartDartObj a, DartDartObj b, double t) {
  final w = Alignment.lerp(_widgetsMap[a]! as Alignment?,
      _widgetsMap[b]! as Alignment?,
      t);
  return w != null ? _createAlignmentObjSt(w) : null;
}
AlignmentObjSt _createAlignmentObjSt(Alignment? w) {
  final AlignmentObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.x = w.x;
  stObj.y = w.y;
  return stObj;
}

void _setupColorScheme(WidgetFactories f) {
  f.colorScheme.colorScheme = ffi.Pointer.fromFunction(colorSchemeColorScheme);
  f.colorScheme.fromSeed = ffi.Pointer.fromFunction(colorSchemeFromSeed);
  f.colorScheme.light = ffi.Pointer.fromFunction(colorSchemeLight);
  f.colorScheme.dark = ffi.Pointer.fromFunction(colorSchemeDark);
  f.colorScheme.highContrastLight = ffi.Pointer.fromFunction(colorSchemeHighContrastLight);
  f.colorScheme.highContrastDark = ffi.Pointer.fromFunction(colorSchemeHighContrastDark);
  f.colorScheme.fromSwatch = ffi.Pointer.fromFunction(colorSchemeFromSwatch);
  f.colorScheme.lerp = ffi.Pointer.fromFunction(colorSchemeLerp);
  f.colorScheme.of = ffi.Pointer.fromFunction(colorSchemeOf);
}
ColorSchemeObjSt colorSchemeColorScheme(int brightness, DartDartObj primary, DartDartObj onPrimary, ffi.Pointer<DartObj> primaryContainer, ffi.Pointer<DartObj> onPrimaryContainer, ffi.Pointer<DartObj> primaryFixed, ffi.Pointer<DartObj> primaryFixedDim, ffi.Pointer<DartObj> onPrimaryFixed, ffi.Pointer<DartObj> onPrimaryFixedVariant, DartDartObj secondary, DartDartObj onSecondary, ffi.Pointer<DartObj> secondaryContainer, ffi.Pointer<DartObj> onSecondaryContainer, ffi.Pointer<DartObj> secondaryFixed, ffi.Pointer<DartObj> secondaryFixedDim, ffi.Pointer<DartObj> onSecondaryFixed, ffi.Pointer<DartObj> onSecondaryFixedVariant, ffi.Pointer<DartObj> tertiary, ffi.Pointer<DartObj> onTertiary, ffi.Pointer<DartObj> tertiaryContainer, ffi.Pointer<DartObj> onTertiaryContainer, ffi.Pointer<DartObj> tertiaryFixed, ffi.Pointer<DartObj> tertiaryFixedDim, ffi.Pointer<DartObj> onTertiaryFixed, ffi.Pointer<DartObj> onTertiaryFixedVariant, DartDartObj error, DartDartObj onError, ffi.Pointer<DartObj> errorContainer, ffi.Pointer<DartObj> onErrorContainer, DartDartObj surface, DartDartObj onSurface, ffi.Pointer<DartObj> surfaceDim, ffi.Pointer<DartObj> surfaceBright, ffi.Pointer<DartObj> surfaceContainerLowest, ffi.Pointer<DartObj> surfaceContainerLow, ffi.Pointer<DartObj> surfaceContainer, ffi.Pointer<DartObj> surfaceContainerHigh, ffi.Pointer<DartObj> surfaceContainerHighest, ffi.Pointer<DartObj> onSurfaceVariant, ffi.Pointer<DartObj> outline, ffi.Pointer<DartObj> outlineVariant, ffi.Pointer<DartObj> shadow, ffi.Pointer<DartObj> scrim, ffi.Pointer<DartObj> inverseSurface, ffi.Pointer<DartObj> onInverseSurface, ffi.Pointer<DartObj> inversePrimary, ffi.Pointer<DartObj> surfaceTint, ffi.Pointer<DartObj> background, ffi.Pointer<DartObj> onBackground, ffi.Pointer<DartObj> surfaceVariant) {
  final w = ColorScheme(brightness: _widgetsMap[brightness]! as Brightness,
      primary: _widgetsMap[primary]! as Color,
      onPrimary: _widgetsMap[onPrimary]! as Color,
      primaryContainer: primaryContainer.objOrNul(),
      onPrimaryContainer: onPrimaryContainer.objOrNul(),
      primaryFixed: primaryFixed.objOrNul(),
      primaryFixedDim: primaryFixedDim.objOrNul(),
      onPrimaryFixed: onPrimaryFixed.objOrNul(),
      onPrimaryFixedVariant: onPrimaryFixedVariant.objOrNul(),
      secondary: _widgetsMap[secondary]! as Color,
      onSecondary: _widgetsMap[onSecondary]! as Color,
      secondaryContainer: secondaryContainer.objOrNul(),
      onSecondaryContainer: onSecondaryContainer.objOrNul(),
      secondaryFixed: secondaryFixed.objOrNul(),
      secondaryFixedDim: secondaryFixedDim.objOrNul(),
      onSecondaryFixed: onSecondaryFixed.objOrNul(),
      onSecondaryFixedVariant: onSecondaryFixedVariant.objOrNul(),
      tertiary: tertiary.objOrNul(),
      onTertiary: onTertiary.objOrNul(),
      tertiaryContainer: tertiaryContainer.objOrNul(),
      onTertiaryContainer: onTertiaryContainer.objOrNul(),
      tertiaryFixed: tertiaryFixed.objOrNul(),
      tertiaryFixedDim: tertiaryFixedDim.objOrNul(),
      onTertiaryFixed: onTertiaryFixed.objOrNul(),
      onTertiaryFixedVariant: onTertiaryFixedVariant.objOrNul(),
      error: _widgetsMap[error]! as Color,
      onError: _widgetsMap[onError]! as Color,
      errorContainer: errorContainer.objOrNul(),
      onErrorContainer: onErrorContainer.objOrNul(),
      surface: _widgetsMap[surface]! as Color,
      onSurface: _widgetsMap[onSurface]! as Color,
      surfaceDim: surfaceDim.objOrNul(),
      surfaceBright: surfaceBright.objOrNul(),
      surfaceContainerLowest: surfaceContainerLowest.objOrNul(),
      surfaceContainerLow: surfaceContainerLow.objOrNul(),
      surfaceContainer: surfaceContainer.objOrNul(),
      surfaceContainerHigh: surfaceContainerHigh.objOrNul(),
      surfaceContainerHighest: surfaceContainerHighest.objOrNul(),
      onSurfaceVariant: onSurfaceVariant.objOrNul(),
      outline: outline.objOrNul(),
      outlineVariant: outlineVariant.objOrNul(),
      shadow: shadow.objOrNul(),
      scrim: scrim.objOrNul(),
      inverseSurface: inverseSurface.objOrNul(),
      onInverseSurface: onInverseSurface.objOrNul(),
      inversePrimary: inversePrimary.objOrNul(),
      surfaceTint: surfaceTint.objOrNul(),
      background: background.objOrNul(),
      onBackground: onBackground.objOrNul(),
      surfaceVariant: surfaceVariant.objOrNul());
  return _createColorSchemeObjSt(w);
}
ColorSchemeObjSt colorSchemeFromSeed(DartDartObj seedColor, ffi.Pointer<ffi.Int> brightness, ffi.Pointer<ffi.Int> dynamicSchemeVariant, ffi.Pointer<ffi.Double> contrastLevel, ffi.Pointer<DartObj> primary, ffi.Pointer<DartObj> onPrimary, ffi.Pointer<DartObj> primaryContainer, ffi.Pointer<DartObj> onPrimaryContainer, ffi.Pointer<DartObj> primaryFixed, ffi.Pointer<DartObj> primaryFixedDim, ffi.Pointer<DartObj> onPrimaryFixed, ffi.Pointer<DartObj> onPrimaryFixedVariant, ffi.Pointer<DartObj> secondary, ffi.Pointer<DartObj> onSecondary, ffi.Pointer<DartObj> secondaryContainer, ffi.Pointer<DartObj> onSecondaryContainer, ffi.Pointer<DartObj> secondaryFixed, ffi.Pointer<DartObj> secondaryFixedDim, ffi.Pointer<DartObj> onSecondaryFixed, ffi.Pointer<DartObj> onSecondaryFixedVariant, ffi.Pointer<DartObj> tertiary, ffi.Pointer<DartObj> onTertiary, ffi.Pointer<DartObj> tertiaryContainer, ffi.Pointer<DartObj> onTertiaryContainer, ffi.Pointer<DartObj> tertiaryFixed, ffi.Pointer<DartObj> tertiaryFixedDim, ffi.Pointer<DartObj> onTertiaryFixed, ffi.Pointer<DartObj> onTertiaryFixedVariant, ffi.Pointer<DartObj> error, ffi.Pointer<DartObj> onError, ffi.Pointer<DartObj> errorContainer, ffi.Pointer<DartObj> onErrorContainer, ffi.Pointer<DartObj> outline, ffi.Pointer<DartObj> outlineVariant, ffi.Pointer<DartObj> surface, ffi.Pointer<DartObj> onSurface, ffi.Pointer<DartObj> surfaceDim, ffi.Pointer<DartObj> surfaceBright, ffi.Pointer<DartObj> surfaceContainerLowest, ffi.Pointer<DartObj> surfaceContainerLow, ffi.Pointer<DartObj> surfaceContainer, ffi.Pointer<DartObj> surfaceContainerHigh, ffi.Pointer<DartObj> surfaceContainerHighest, ffi.Pointer<DartObj> onSurfaceVariant, ffi.Pointer<DartObj> inverseSurface, ffi.Pointer<DartObj> onInverseSurface, ffi.Pointer<DartObj> inversePrimary, ffi.Pointer<DartObj> shadow, ffi.Pointer<DartObj> scrim, ffi.Pointer<DartObj> surfaceTint, ffi.Pointer<DartObj> background, ffi.Pointer<DartObj> onBackground, ffi.Pointer<DartObj> surfaceVariant) {
  final w = ColorScheme.fromSeed(seedColor: _widgetsMap[seedColor]! as Color,
      brightness: brightness.enumOr(Brightness.values, Brightness.light),
      dynamicSchemeVariant: dynamicSchemeVariant.enumOr(DynamicSchemeVariant.values, DynamicSchemeVariant.tonalSpot),
      contrastLevel: contrastLevel.doubleOr(0.0),
      primary: primary.objOrNul(),
      onPrimary: onPrimary.objOrNul(),
      primaryContainer: primaryContainer.objOrNul(),
      onPrimaryContainer: onPrimaryContainer.objOrNul(),
      primaryFixed: primaryFixed.objOrNul(),
      primaryFixedDim: primaryFixedDim.objOrNul(),
      onPrimaryFixed: onPrimaryFixed.objOrNul(),
      onPrimaryFixedVariant: onPrimaryFixedVariant.objOrNul(),
      secondary: secondary.objOrNul(),
      onSecondary: onSecondary.objOrNul(),
      secondaryContainer: secondaryContainer.objOrNul(),
      onSecondaryContainer: onSecondaryContainer.objOrNul(),
      secondaryFixed: secondaryFixed.objOrNul(),
      secondaryFixedDim: secondaryFixedDim.objOrNul(),
      onSecondaryFixed: onSecondaryFixed.objOrNul(),
      onSecondaryFixedVariant: onSecondaryFixedVariant.objOrNul(),
      tertiary: tertiary.objOrNul(),
      onTertiary: onTertiary.objOrNul(),
      tertiaryContainer: tertiaryContainer.objOrNul(),
      onTertiaryContainer: onTertiaryContainer.objOrNul(),
      tertiaryFixed: tertiaryFixed.objOrNul(),
      tertiaryFixedDim: tertiaryFixedDim.objOrNul(),
      onTertiaryFixed: onTertiaryFixed.objOrNul(),
      onTertiaryFixedVariant: onTertiaryFixedVariant.objOrNul(),
      error: error.objOrNul(),
      onError: onError.objOrNul(),
      errorContainer: errorContainer.objOrNul(),
      onErrorContainer: onErrorContainer.objOrNul(),
      outline: outline.objOrNul(),
      outlineVariant: outlineVariant.objOrNul(),
      surface: surface.objOrNul(),
      onSurface: onSurface.objOrNul(),
      surfaceDim: surfaceDim.objOrNul(),
      surfaceBright: surfaceBright.objOrNul(),
      surfaceContainerLowest: surfaceContainerLowest.objOrNul(),
      surfaceContainerLow: surfaceContainerLow.objOrNul(),
      surfaceContainer: surfaceContainer.objOrNul(),
      surfaceContainerHigh: surfaceContainerHigh.objOrNul(),
      surfaceContainerHighest: surfaceContainerHighest.objOrNul(),
      onSurfaceVariant: onSurfaceVariant.objOrNul(),
      inverseSurface: inverseSurface.objOrNul(),
      onInverseSurface: onInverseSurface.objOrNul(),
      inversePrimary: inversePrimary.objOrNul(),
      shadow: shadow.objOrNul(),
      scrim: scrim.objOrNul(),
      surfaceTint: surfaceTint.objOrNul(),
      background: background.objOrNul(),
      onBackground: onBackground.objOrNul(),
      surfaceVariant: surfaceVariant.objOrNul());
  return _createColorSchemeObjSt(w);
}
ColorSchemeObjSt colorSchemeLight(ffi.Pointer<ffi.Int> brightness, ffi.Pointer<DartObj> primary, ffi.Pointer<DartObj> onPrimary, ffi.Pointer<DartObj> primaryContainer, ffi.Pointer<DartObj> onPrimaryContainer, ffi.Pointer<DartObj> primaryFixed, ffi.Pointer<DartObj> primaryFixedDim, ffi.Pointer<DartObj> onPrimaryFixed, ffi.Pointer<DartObj> onPrimaryFixedVariant, ffi.Pointer<DartObj> secondary, ffi.Pointer<DartObj> onSecondary, ffi.Pointer<DartObj> secondaryContainer, ffi.Pointer<DartObj> onSecondaryContainer, ffi.Pointer<DartObj> secondaryFixed, ffi.Pointer<DartObj> secondaryFixedDim, ffi.Pointer<DartObj> onSecondaryFixed, ffi.Pointer<DartObj> onSecondaryFixedVariant, ffi.Pointer<DartObj> tertiary, ffi.Pointer<DartObj> onTertiary, ffi.Pointer<DartObj> tertiaryContainer, ffi.Pointer<DartObj> onTertiaryContainer, ffi.Pointer<DartObj> tertiaryFixed, ffi.Pointer<DartObj> tertiaryFixedDim, ffi.Pointer<DartObj> onTertiaryFixed, ffi.Pointer<DartObj> onTertiaryFixedVariant, ffi.Pointer<DartObj> error, ffi.Pointer<DartObj> onError, ffi.Pointer<DartObj> errorContainer, ffi.Pointer<DartObj> onErrorContainer, ffi.Pointer<DartObj> surface, ffi.Pointer<DartObj> onSurface, ffi.Pointer<DartObj> surfaceDim, ffi.Pointer<DartObj> surfaceBright, ffi.Pointer<DartObj> surfaceContainerLowest, ffi.Pointer<DartObj> surfaceContainerLow, ffi.Pointer<DartObj> surfaceContainer, ffi.Pointer<DartObj> surfaceContainerHigh, ffi.Pointer<DartObj> surfaceContainerHighest, ffi.Pointer<DartObj> onSurfaceVariant, ffi.Pointer<DartObj> outline, ffi.Pointer<DartObj> outlineVariant, ffi.Pointer<DartObj> shadow, ffi.Pointer<DartObj> scrim, ffi.Pointer<DartObj> inverseSurface, ffi.Pointer<DartObj> onInverseSurface, ffi.Pointer<DartObj> inversePrimary, ffi.Pointer<DartObj> surfaceTint, ffi.Pointer<DartObj> background, ffi.Pointer<DartObj> onBackground, ffi.Pointer<DartObj> surfaceVariant) {
  final w = ColorScheme.light(brightness: brightness.enumOr(Brightness.values, Brightness.light),
      primary: primary.objOrNul(),
      onPrimary: onPrimary.objOrNul(),
      primaryContainer: primaryContainer.objOrNul(),
      onPrimaryContainer: onPrimaryContainer.objOrNul(),
      primaryFixed: primaryFixed.objOrNul(),
      primaryFixedDim: primaryFixedDim.objOrNul(),
      onPrimaryFixed: onPrimaryFixed.objOrNul(),
      onPrimaryFixedVariant: onPrimaryFixedVariant.objOrNul(),
      secondary: secondary.objOrNul(),
      onSecondary: onSecondary.objOrNul(),
      secondaryContainer: secondaryContainer.objOrNul(),
      onSecondaryContainer: onSecondaryContainer.objOrNul(),
      secondaryFixed: secondaryFixed.objOrNul(),
      secondaryFixedDim: secondaryFixedDim.objOrNul(),
      onSecondaryFixed: onSecondaryFixed.objOrNul(),
      onSecondaryFixedVariant: onSecondaryFixedVariant.objOrNul(),
      tertiary: tertiary.objOrNul(),
      onTertiary: onTertiary.objOrNul(),
      tertiaryContainer: tertiaryContainer.objOrNul(),
      onTertiaryContainer: onTertiaryContainer.objOrNul(),
      tertiaryFixed: tertiaryFixed.objOrNul(),
      tertiaryFixedDim: tertiaryFixedDim.objOrNul(),
      onTertiaryFixed: onTertiaryFixed.objOrNul(),
      onTertiaryFixedVariant: onTertiaryFixedVariant.objOrNul(),
      error: error.objOrNul(),
      onError: onError.objOrNul(),
      errorContainer: errorContainer.objOrNul(),
      onErrorContainer: onErrorContainer.objOrNul(),
      surface: surface.objOrNul(),
      onSurface: onSurface.objOrNul(),
      surfaceDim: surfaceDim.objOrNul(),
      surfaceBright: surfaceBright.objOrNul(),
      surfaceContainerLowest: surfaceContainerLowest.objOrNul(),
      surfaceContainerLow: surfaceContainerLow.objOrNul(),
      surfaceContainer: surfaceContainer.objOrNul(),
      surfaceContainerHigh: surfaceContainerHigh.objOrNul(),
      surfaceContainerHighest: surfaceContainerHighest.objOrNul(),
      onSurfaceVariant: onSurfaceVariant.objOrNul(),
      outline: outline.objOrNul(),
      outlineVariant: outlineVariant.objOrNul(),
      shadow: shadow.objOrNul(),
      scrim: scrim.objOrNul(),
      inverseSurface: inverseSurface.objOrNul(),
      onInverseSurface: onInverseSurface.objOrNul(),
      inversePrimary: inversePrimary.objOrNul(),
      surfaceTint: surfaceTint.objOrNul(),
      background: background.objOrNul(),
      onBackground: onBackground.objOrNul(),
      surfaceVariant: surfaceVariant.objOrNul());
  return _createColorSchemeObjSt(w);
}
ColorSchemeObjSt colorSchemeDark(ffi.Pointer<ffi.Int> brightness, ffi.Pointer<DartObj> primary, ffi.Pointer<DartObj> onPrimary, ffi.Pointer<DartObj> primaryContainer, ffi.Pointer<DartObj> onPrimaryContainer, ffi.Pointer<DartObj> primaryFixed, ffi.Pointer<DartObj> primaryFixedDim, ffi.Pointer<DartObj> onPrimaryFixed, ffi.Pointer<DartObj> onPrimaryFixedVariant, ffi.Pointer<DartObj> secondary, ffi.Pointer<DartObj> onSecondary, ffi.Pointer<DartObj> secondaryContainer, ffi.Pointer<DartObj> onSecondaryContainer, ffi.Pointer<DartObj> secondaryFixed, ffi.Pointer<DartObj> secondaryFixedDim, ffi.Pointer<DartObj> onSecondaryFixed, ffi.Pointer<DartObj> onSecondaryFixedVariant, ffi.Pointer<DartObj> tertiary, ffi.Pointer<DartObj> onTertiary, ffi.Pointer<DartObj> tertiaryContainer, ffi.Pointer<DartObj> onTertiaryContainer, ffi.Pointer<DartObj> tertiaryFixed, ffi.Pointer<DartObj> tertiaryFixedDim, ffi.Pointer<DartObj> onTertiaryFixed, ffi.Pointer<DartObj> onTertiaryFixedVariant, ffi.Pointer<DartObj> error, ffi.Pointer<DartObj> onError, ffi.Pointer<DartObj> errorContainer, ffi.Pointer<DartObj> onErrorContainer, ffi.Pointer<DartObj> surface, ffi.Pointer<DartObj> onSurface, ffi.Pointer<DartObj> surfaceDim, ffi.Pointer<DartObj> surfaceBright, ffi.Pointer<DartObj> surfaceContainerLowest, ffi.Pointer<DartObj> surfaceContainerLow, ffi.Pointer<DartObj> surfaceContainer, ffi.Pointer<DartObj> surfaceContainerHigh, ffi.Pointer<DartObj> surfaceContainerHighest, ffi.Pointer<DartObj> onSurfaceVariant, ffi.Pointer<DartObj> outline, ffi.Pointer<DartObj> outlineVariant, ffi.Pointer<DartObj> shadow, ffi.Pointer<DartObj> scrim, ffi.Pointer<DartObj> inverseSurface, ffi.Pointer<DartObj> onInverseSurface, ffi.Pointer<DartObj> inversePrimary, ffi.Pointer<DartObj> surfaceTint, ffi.Pointer<DartObj> background, ffi.Pointer<DartObj> onBackground, ffi.Pointer<DartObj> surfaceVariant) {
  final w = ColorScheme.dark(brightness: brightness.enumOr(Brightness.values, Brightness.dark),
      primary: primary.objOrNul(),
      onPrimary: onPrimary.objOrNul(),
      primaryContainer: primaryContainer.objOrNul(),
      onPrimaryContainer: onPrimaryContainer.objOrNul(),
      primaryFixed: primaryFixed.objOrNul(),
      primaryFixedDim: primaryFixedDim.objOrNul(),
      onPrimaryFixed: onPrimaryFixed.objOrNul(),
      onPrimaryFixedVariant: onPrimaryFixedVariant.objOrNul(),
      secondary: secondary.objOrNul(),
      onSecondary: onSecondary.objOrNul(),
      secondaryContainer: secondaryContainer.objOrNul(),
      onSecondaryContainer: onSecondaryContainer.objOrNul(),
      secondaryFixed: secondaryFixed.objOrNul(),
      secondaryFixedDim: secondaryFixedDim.objOrNul(),
      onSecondaryFixed: onSecondaryFixed.objOrNul(),
      onSecondaryFixedVariant: onSecondaryFixedVariant.objOrNul(),
      tertiary: tertiary.objOrNul(),
      onTertiary: onTertiary.objOrNul(),
      tertiaryContainer: tertiaryContainer.objOrNul(),
      onTertiaryContainer: onTertiaryContainer.objOrNul(),
      tertiaryFixed: tertiaryFixed.objOrNul(),
      tertiaryFixedDim: tertiaryFixedDim.objOrNul(),
      onTertiaryFixed: onTertiaryFixed.objOrNul(),
      onTertiaryFixedVariant: onTertiaryFixedVariant.objOrNul(),
      error: error.objOrNul(),
      onError: onError.objOrNul(),
      errorContainer: errorContainer.objOrNul(),
      onErrorContainer: onErrorContainer.objOrNul(),
      surface: surface.objOrNul(),
      onSurface: onSurface.objOrNul(),
      surfaceDim: surfaceDim.objOrNul(),
      surfaceBright: surfaceBright.objOrNul(),
      surfaceContainerLowest: surfaceContainerLowest.objOrNul(),
      surfaceContainerLow: surfaceContainerLow.objOrNul(),
      surfaceContainer: surfaceContainer.objOrNul(),
      surfaceContainerHigh: surfaceContainerHigh.objOrNul(),
      surfaceContainerHighest: surfaceContainerHighest.objOrNul(),
      onSurfaceVariant: onSurfaceVariant.objOrNul(),
      outline: outline.objOrNul(),
      outlineVariant: outlineVariant.objOrNul(),
      shadow: shadow.objOrNul(),
      scrim: scrim.objOrNul(),
      inverseSurface: inverseSurface.objOrNul(),
      onInverseSurface: onInverseSurface.objOrNul(),
      inversePrimary: inversePrimary.objOrNul(),
      surfaceTint: surfaceTint.objOrNul(),
      background: background.objOrNul(),
      onBackground: onBackground.objOrNul(),
      surfaceVariant: surfaceVariant.objOrNul());
  return _createColorSchemeObjSt(w);
}
ColorSchemeObjSt colorSchemeHighContrastLight(ffi.Pointer<ffi.Int> brightness, ffi.Pointer<DartObj> primary, ffi.Pointer<DartObj> onPrimary, ffi.Pointer<DartObj> primaryContainer, ffi.Pointer<DartObj> onPrimaryContainer, ffi.Pointer<DartObj> primaryFixed, ffi.Pointer<DartObj> primaryFixedDim, ffi.Pointer<DartObj> onPrimaryFixed, ffi.Pointer<DartObj> onPrimaryFixedVariant, ffi.Pointer<DartObj> secondary, ffi.Pointer<DartObj> onSecondary, ffi.Pointer<DartObj> secondaryContainer, ffi.Pointer<DartObj> onSecondaryContainer, ffi.Pointer<DartObj> secondaryFixed, ffi.Pointer<DartObj> secondaryFixedDim, ffi.Pointer<DartObj> onSecondaryFixed, ffi.Pointer<DartObj> onSecondaryFixedVariant, ffi.Pointer<DartObj> tertiary, ffi.Pointer<DartObj> onTertiary, ffi.Pointer<DartObj> tertiaryContainer, ffi.Pointer<DartObj> onTertiaryContainer, ffi.Pointer<DartObj> tertiaryFixed, ffi.Pointer<DartObj> tertiaryFixedDim, ffi.Pointer<DartObj> onTertiaryFixed, ffi.Pointer<DartObj> onTertiaryFixedVariant, ffi.Pointer<DartObj> error, ffi.Pointer<DartObj> onError, ffi.Pointer<DartObj> errorContainer, ffi.Pointer<DartObj> onErrorContainer, ffi.Pointer<DartObj> surface, ffi.Pointer<DartObj> onSurface, ffi.Pointer<DartObj> surfaceDim, ffi.Pointer<DartObj> surfaceBright, ffi.Pointer<DartObj> surfaceContainerLowest, ffi.Pointer<DartObj> surfaceContainerLow, ffi.Pointer<DartObj> surfaceContainer, ffi.Pointer<DartObj> surfaceContainerHigh, ffi.Pointer<DartObj> surfaceContainerHighest, ffi.Pointer<DartObj> onSurfaceVariant, ffi.Pointer<DartObj> outline, ffi.Pointer<DartObj> outlineVariant, ffi.Pointer<DartObj> shadow, ffi.Pointer<DartObj> scrim, ffi.Pointer<DartObj> inverseSurface, ffi.Pointer<DartObj> onInverseSurface, ffi.Pointer<DartObj> inversePrimary, ffi.Pointer<DartObj> surfaceTint, ffi.Pointer<DartObj> background, ffi.Pointer<DartObj> onBackground, ffi.Pointer<DartObj> surfaceVariant) {
  final w = ColorScheme.highContrastLight(brightness: brightness.enumOr(Brightness.values, Brightness.light),
      primary: primary.objOrNul(),
      onPrimary: onPrimary.objOrNul(),
      primaryContainer: primaryContainer.objOrNul(),
      onPrimaryContainer: onPrimaryContainer.objOrNul(),
      primaryFixed: primaryFixed.objOrNul(),
      primaryFixedDim: primaryFixedDim.objOrNul(),
      onPrimaryFixed: onPrimaryFixed.objOrNul(),
      onPrimaryFixedVariant: onPrimaryFixedVariant.objOrNul(),
      secondary: secondary.objOrNul(),
      onSecondary: onSecondary.objOrNul(),
      secondaryContainer: secondaryContainer.objOrNul(),
      onSecondaryContainer: onSecondaryContainer.objOrNul(),
      secondaryFixed: secondaryFixed.objOrNul(),
      secondaryFixedDim: secondaryFixedDim.objOrNul(),
      onSecondaryFixed: onSecondaryFixed.objOrNul(),
      onSecondaryFixedVariant: onSecondaryFixedVariant.objOrNul(),
      tertiary: tertiary.objOrNul(),
      onTertiary: onTertiary.objOrNul(),
      tertiaryContainer: tertiaryContainer.objOrNul(),
      onTertiaryContainer: onTertiaryContainer.objOrNul(),
      tertiaryFixed: tertiaryFixed.objOrNul(),
      tertiaryFixedDim: tertiaryFixedDim.objOrNul(),
      onTertiaryFixed: onTertiaryFixed.objOrNul(),
      onTertiaryFixedVariant: onTertiaryFixedVariant.objOrNul(),
      error: error.objOrNul(),
      onError: onError.objOrNul(),
      errorContainer: errorContainer.objOrNul(),
      onErrorContainer: onErrorContainer.objOrNul(),
      surface: surface.objOrNul(),
      onSurface: onSurface.objOrNul(),
      surfaceDim: surfaceDim.objOrNul(),
      surfaceBright: surfaceBright.objOrNul(),
      surfaceContainerLowest: surfaceContainerLowest.objOrNul(),
      surfaceContainerLow: surfaceContainerLow.objOrNul(),
      surfaceContainer: surfaceContainer.objOrNul(),
      surfaceContainerHigh: surfaceContainerHigh.objOrNul(),
      surfaceContainerHighest: surfaceContainerHighest.objOrNul(),
      onSurfaceVariant: onSurfaceVariant.objOrNul(),
      outline: outline.objOrNul(),
      outlineVariant: outlineVariant.objOrNul(),
      shadow: shadow.objOrNul(),
      scrim: scrim.objOrNul(),
      inverseSurface: inverseSurface.objOrNul(),
      onInverseSurface: onInverseSurface.objOrNul(),
      inversePrimary: inversePrimary.objOrNul(),
      surfaceTint: surfaceTint.objOrNul(),
      background: background.objOrNul(),
      onBackground: onBackground.objOrNul(),
      surfaceVariant: surfaceVariant.objOrNul());
  return _createColorSchemeObjSt(w);
}
ColorSchemeObjSt colorSchemeHighContrastDark(ffi.Pointer<ffi.Int> brightness, ffi.Pointer<DartObj> primary, ffi.Pointer<DartObj> onPrimary, ffi.Pointer<DartObj> primaryContainer, ffi.Pointer<DartObj> onPrimaryContainer, ffi.Pointer<DartObj> primaryFixed, ffi.Pointer<DartObj> primaryFixedDim, ffi.Pointer<DartObj> onPrimaryFixed, ffi.Pointer<DartObj> onPrimaryFixedVariant, ffi.Pointer<DartObj> secondary, ffi.Pointer<DartObj> onSecondary, ffi.Pointer<DartObj> secondaryContainer, ffi.Pointer<DartObj> onSecondaryContainer, ffi.Pointer<DartObj> secondaryFixed, ffi.Pointer<DartObj> secondaryFixedDim, ffi.Pointer<DartObj> onSecondaryFixed, ffi.Pointer<DartObj> onSecondaryFixedVariant, ffi.Pointer<DartObj> tertiary, ffi.Pointer<DartObj> onTertiary, ffi.Pointer<DartObj> tertiaryContainer, ffi.Pointer<DartObj> onTertiaryContainer, ffi.Pointer<DartObj> tertiaryFixed, ffi.Pointer<DartObj> tertiaryFixedDim, ffi.Pointer<DartObj> onTertiaryFixed, ffi.Pointer<DartObj> onTertiaryFixedVariant, ffi.Pointer<DartObj> error, ffi.Pointer<DartObj> onError, ffi.Pointer<DartObj> errorContainer, ffi.Pointer<DartObj> onErrorContainer, ffi.Pointer<DartObj> surface, ffi.Pointer<DartObj> onSurface, ffi.Pointer<DartObj> surfaceDim, ffi.Pointer<DartObj> surfaceBright, ffi.Pointer<DartObj> surfaceContainerLowest, ffi.Pointer<DartObj> surfaceContainerLow, ffi.Pointer<DartObj> surfaceContainer, ffi.Pointer<DartObj> surfaceContainerHigh, ffi.Pointer<DartObj> surfaceContainerHighest, ffi.Pointer<DartObj> onSurfaceVariant, ffi.Pointer<DartObj> outline, ffi.Pointer<DartObj> outlineVariant, ffi.Pointer<DartObj> shadow, ffi.Pointer<DartObj> scrim, ffi.Pointer<DartObj> inverseSurface, ffi.Pointer<DartObj> onInverseSurface, ffi.Pointer<DartObj> inversePrimary, ffi.Pointer<DartObj> surfaceTint, ffi.Pointer<DartObj> background, ffi.Pointer<DartObj> onBackground, ffi.Pointer<DartObj> surfaceVariant) {
  final w = ColorScheme.highContrastDark(brightness: brightness.enumOr(Brightness.values, Brightness.dark),
      primary: primary.objOrNul(),
      onPrimary: onPrimary.objOrNul(),
      primaryContainer: primaryContainer.objOrNul(),
      onPrimaryContainer: onPrimaryContainer.objOrNul(),
      primaryFixed: primaryFixed.objOrNul(),
      primaryFixedDim: primaryFixedDim.objOrNul(),
      onPrimaryFixed: onPrimaryFixed.objOrNul(),
      onPrimaryFixedVariant: onPrimaryFixedVariant.objOrNul(),
      secondary: secondary.objOrNul(),
      onSecondary: onSecondary.objOrNul(),
      secondaryContainer: secondaryContainer.objOrNul(),
      onSecondaryContainer: onSecondaryContainer.objOrNul(),
      secondaryFixed: secondaryFixed.objOrNul(),
      secondaryFixedDim: secondaryFixedDim.objOrNul(),
      onSecondaryFixed: onSecondaryFixed.objOrNul(),
      onSecondaryFixedVariant: onSecondaryFixedVariant.objOrNul(),
      tertiary: tertiary.objOrNul(),
      onTertiary: onTertiary.objOrNul(),
      tertiaryContainer: tertiaryContainer.objOrNul(),
      onTertiaryContainer: onTertiaryContainer.objOrNul(),
      tertiaryFixed: tertiaryFixed.objOrNul(),
      tertiaryFixedDim: tertiaryFixedDim.objOrNul(),
      onTertiaryFixed: onTertiaryFixed.objOrNul(),
      onTertiaryFixedVariant: onTertiaryFixedVariant.objOrNul(),
      error: error.objOrNul(),
      onError: onError.objOrNul(),
      errorContainer: errorContainer.objOrNul(),
      onErrorContainer: onErrorContainer.objOrNul(),
      surface: surface.objOrNul(),
      onSurface: onSurface.objOrNul(),
      surfaceDim: surfaceDim.objOrNul(),
      surfaceBright: surfaceBright.objOrNul(),
      surfaceContainerLowest: surfaceContainerLowest.objOrNul(),
      surfaceContainerLow: surfaceContainerLow.objOrNul(),
      surfaceContainer: surfaceContainer.objOrNul(),
      surfaceContainerHigh: surfaceContainerHigh.objOrNul(),
      surfaceContainerHighest: surfaceContainerHighest.objOrNul(),
      onSurfaceVariant: onSurfaceVariant.objOrNul(),
      outline: outline.objOrNul(),
      outlineVariant: outlineVariant.objOrNul(),
      shadow: shadow.objOrNul(),
      scrim: scrim.objOrNul(),
      inverseSurface: inverseSurface.objOrNul(),
      onInverseSurface: onInverseSurface.objOrNul(),
      inversePrimary: inversePrimary.objOrNul(),
      surfaceTint: surfaceTint.objOrNul(),
      background: background.objOrNul(),
      onBackground: onBackground.objOrNul(),
      surfaceVariant: surfaceVariant.objOrNul());
  return _createColorSchemeObjSt(w);
}
ColorSchemeObjSt colorSchemeFromSwatch(ffi.Pointer<DartObj> primarySwatch, ffi.Pointer<DartObj> accentColor, ffi.Pointer<DartObj> cardColor, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> errorColor, ffi.Pointer<ffi.Int> brightness) {
  final w = ColorScheme.fromSwatch(primarySwatch: primarySwatch.objOrNul(),
      accentColor: accentColor.objOrNul(),
      cardColor: cardColor.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      errorColor: errorColor.objOrNul(),
      brightness: brightness.enumOr(Brightness.values, Brightness.light));
  return _createColorSchemeObjSt(w);
}
ColorSchemeObjSt colorSchemeLerp(DartDartObj a, DartDartObj b, double t) {
  final w = ColorScheme.lerp(_widgetsMap[a]! as ColorScheme,
      _widgetsMap[b]! as ColorScheme,
      t);
  return _createColorSchemeObjSt(w);
}
ColorSchemeObjSt colorSchemeOf(DartDartObj context) {
  final w = ColorScheme.of(_widgetsMap[context]! as BuildContext);
  return _createColorSchemeObjSt(w);
}
ColorSchemeObjSt _createColorSchemeObjSt(ColorScheme? w) {
  final ColorSchemeObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.brightness = w.brightness.index;
  stObj.primary = _addWidget(w.primary);
  stObj.onPrimary = _addWidget(w.onPrimary);
  stObj.secondary = _addWidget(w.secondary);
  stObj.onSecondary = _addWidget(w.onSecondary);
  stObj.error = _addWidget(w.error);
  stObj.onError = _addWidget(w.onError);
  stObj.surface = _addWidget(w.surface);
  stObj.onSurface = _addWidget(w.onSurface);
  stObj.primaryContainer = _addWidget(w.primaryContainer);
  stObj.onPrimaryContainer = _addWidget(w.onPrimaryContainer);
  stObj.primaryFixed = _addWidget(w.primaryFixed);
  stObj.primaryFixedDim = _addWidget(w.primaryFixedDim);
  stObj.onPrimaryFixed = _addWidget(w.onPrimaryFixed);
  stObj.onPrimaryFixedVariant = _addWidget(w.onPrimaryFixedVariant);
  stObj.secondaryContainer = _addWidget(w.secondaryContainer);
  stObj.onSecondaryContainer = _addWidget(w.onSecondaryContainer);
  stObj.secondaryFixed = _addWidget(w.secondaryFixed);
  stObj.secondaryFixedDim = _addWidget(w.secondaryFixedDim);
  stObj.onSecondaryFixed = _addWidget(w.onSecondaryFixed);
  stObj.onSecondaryFixedVariant = _addWidget(w.onSecondaryFixedVariant);
  stObj.tertiary = _addWidget(w.tertiary);
  stObj.onTertiary = _addWidget(w.onTertiary);
  stObj.tertiaryContainer = _addWidget(w.tertiaryContainer);
  stObj.onTertiaryContainer = _addWidget(w.onTertiaryContainer);
  stObj.tertiaryFixed = _addWidget(w.tertiaryFixed);
  stObj.tertiaryFixedDim = _addWidget(w.tertiaryFixedDim);
  stObj.onTertiaryFixed = _addWidget(w.onTertiaryFixed);
  stObj.onTertiaryFixedVariant = _addWidget(w.onTertiaryFixedVariant);
  stObj.errorContainer = _addWidget(w.errorContainer);
  stObj.onErrorContainer = _addWidget(w.onErrorContainer);
  stObj.surfaceVariant = _addWidget(w.surfaceVariant);
  stObj.surfaceDim = _addWidget(w.surfaceDim);
  stObj.surfaceBright = _addWidget(w.surfaceBright);
  stObj.surfaceContainerLowest = _addWidget(w.surfaceContainerLowest);
  stObj.surfaceContainerLow = _addWidget(w.surfaceContainerLow);
  stObj.surfaceContainer = _addWidget(w.surfaceContainer);
  stObj.surfaceContainerHigh = _addWidget(w.surfaceContainerHigh);
  stObj.surfaceContainerHighest = _addWidget(w.surfaceContainerHighest);
  stObj.onSurfaceVariant = _addWidget(w.onSurfaceVariant);
  stObj.outline = _addWidget(w.outline);
  stObj.outlineVariant = _addWidget(w.outlineVariant);
  stObj.shadow = _addWidget(w.shadow);
  stObj.scrim = _addWidget(w.scrim);
  stObj.inverseSurface = _addWidget(w.inverseSurface);
  stObj.onInverseSurface = _addWidget(w.onInverseSurface);
  stObj.inversePrimary = _addWidget(w.inversePrimary);
  stObj.surfaceTint = _addWidget(w.surfaceTint);
  stObj.background = _addWidget(w.background);
  stObj.onBackground = _addWidget(w.onBackground);
  return stObj;
}

void _setupMaterialColor(WidgetFactories f) {
  f.materialColor.materialColor = ffi.Pointer.fromFunction(materialColorMaterialColor);
}
MaterialColorObjSt materialColorMaterialColor(int primary, MapC swatch) {
  final w = MaterialColor(primary,
      swatch.toMap());
  return _createMaterialColorObjSt(w);
}
MaterialColorObjSt _createMaterialColorObjSt(MaterialColor? w) {
  final MaterialColorObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.shade50 = _addWidget(w.shade50);
  stObj.shade100 = _addWidget(w.shade100);
  stObj.shade200 = _addWidget(w.shade200);
  stObj.shade300 = _addWidget(w.shade300);
  stObj.shade400 = _addWidget(w.shade400);
  stObj.shade500 = _addWidget(w.shade500);
  stObj.shade600 = _addWidget(w.shade600);
  stObj.shade700 = _addWidget(w.shade700);
  stObj.shade800 = _addWidget(w.shade800);
  stObj.shade900 = _addWidget(w.shade900);
  return stObj;
}

void _setupColorSwatch(WidgetFactories f) {
  f.colorSwatch.lerp = ffi.Pointer.fromFunction(colorSwatchLerp);
}
ColorSwatchObjSt? colorSwatchLerp(DartDartObj a, DartDartObj b, double t) {
  final w = ColorSwatch.lerp(_widgetsMap[a]! as ColorSwatch,
      _widgetsMap[b]! as ColorSwatch,
      t);
  return w != null ? _createColorSwatchObjSt(w) : null;
}
ColorSwatchObjSt _createColorSwatchObjSt(ColorSwatch? w) {
  final ColorSwatchObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupTextTheme(WidgetFactories f) {
  f.textTheme.textTheme = ffi.Pointer.fromFunction(textThemeTextTheme);
  f.textTheme.lerp = ffi.Pointer.fromFunction(textThemeLerp);
  f.textTheme.of = ffi.Pointer.fromFunction(textThemeOf);
  f.textTheme.primaryOf = ffi.Pointer.fromFunction(textThemePrimaryOf);
}
TextThemeObjSt textThemeTextTheme(ffi.Pointer<DartObj> displayLarge, ffi.Pointer<DartObj> displayMedium, ffi.Pointer<DartObj> displaySmall, ffi.Pointer<DartObj> headlineLarge, ffi.Pointer<DartObj> headlineMedium, ffi.Pointer<DartObj> headlineSmall, ffi.Pointer<DartObj> titleLarge, ffi.Pointer<DartObj> titleMedium, ffi.Pointer<DartObj> titleSmall, ffi.Pointer<DartObj> bodyLarge, ffi.Pointer<DartObj> bodyMedium, ffi.Pointer<DartObj> bodySmall, ffi.Pointer<DartObj> labelLarge, ffi.Pointer<DartObj> labelMedium, ffi.Pointer<DartObj> labelSmall) {
  final w = TextTheme(displayLarge: displayLarge.objOrNul(),
      displayMedium: displayMedium.objOrNul(),
      displaySmall: displaySmall.objOrNul(),
      headlineLarge: headlineLarge.objOrNul(),
      headlineMedium: headlineMedium.objOrNul(),
      headlineSmall: headlineSmall.objOrNul(),
      titleLarge: titleLarge.objOrNul(),
      titleMedium: titleMedium.objOrNul(),
      titleSmall: titleSmall.objOrNul(),
      bodyLarge: bodyLarge.objOrNul(),
      bodyMedium: bodyMedium.objOrNul(),
      bodySmall: bodySmall.objOrNul(),
      labelLarge: labelLarge.objOrNul(),
      labelMedium: labelMedium.objOrNul(),
      labelSmall: labelSmall.objOrNul());
  return _createTextThemeObjSt(w);
}
TextThemeObjSt textThemeLerp(DartDartObj a, DartDartObj b, double t) {
  final w = TextTheme.lerp(_widgetsMap[a]! as TextTheme?,
      _widgetsMap[b]! as TextTheme?,
      t);
  return _createTextThemeObjSt(w);
}
TextThemeObjSt textThemeOf(DartDartObj context) {
  final w = TextTheme.of(_widgetsMap[context]! as BuildContext);
  return _createTextThemeObjSt(w);
}
TextThemeObjSt textThemePrimaryOf(DartDartObj context) {
  final w = TextTheme.primaryOf(_widgetsMap[context]! as BuildContext);
  return _createTextThemeObjSt(w);
}
TextThemeObjSt _createTextThemeObjSt(TextTheme? w) {
  final TextThemeObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.displayLarge = _createTextStyleObjSt(w.displayLarge);
  stObj.displayMedium = _createTextStyleObjSt(w.displayMedium);
  stObj.displaySmall = _createTextStyleObjSt(w.displaySmall);
  stObj.headlineLarge = _createTextStyleObjSt(w.headlineLarge);
  stObj.headlineMedium = _createTextStyleObjSt(w.headlineMedium);
  stObj.headlineSmall = _createTextStyleObjSt(w.headlineSmall);
  stObj.titleLarge = _createTextStyleObjSt(w.titleLarge);
  stObj.titleMedium = _createTextStyleObjSt(w.titleMedium);
  stObj.titleSmall = _createTextStyleObjSt(w.titleSmall);
  stObj.bodyLarge = _createTextStyleObjSt(w.bodyLarge);
  stObj.bodyMedium = _createTextStyleObjSt(w.bodyMedium);
  stObj.bodySmall = _createTextStyleObjSt(w.bodySmall);
  stObj.labelLarge = _createTextStyleObjSt(w.labelLarge);
  stObj.labelMedium = _createTextStyleObjSt(w.labelMedium);
  stObj.labelSmall = _createTextStyleObjSt(w.labelSmall);
  return stObj;
}

void _setupThemeData(WidgetFactories f) {
  f.themeData.themeData = ffi.Pointer.fromFunction(themeDataThemeData);
  f.themeData.from = ffi.Pointer.fromFunction(themeDataFrom);
  f.themeData.light = ffi.Pointer.fromFunction(themeDataLight);
  f.themeData.dark = ffi.Pointer.fromFunction(themeDataDark);
  f.themeData.fallback = ffi.Pointer.fromFunction(themeDataFallback);
  f.themeData.localize = ffi.Pointer.fromFunction(themeDataLocalize);
  f.themeData.estimateBrightnessForColor = ffi.Pointer.fromFunction(themeDataEstimateBrightnessForColor, exception);
  f.themeData.lerp = ffi.Pointer.fromFunction(themeDataLerp);
}
ThemeDataObjSt themeDataThemeData(ffi.Pointer<ffi.Int> applyElevationOverlayColor, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<ffi.Int> platform, ffi.Pointer<ffi.Int> useMaterial3, ffi.Pointer<DartObj> colorScheme, ffi.Pointer<ffi.Int> brightness, ffi.Pointer<DartObj> colorSchemeSeed, ffi.Pointer<DartObj> canvasColor, ffi.Pointer<DartObj> cardColor, ffi.Pointer<DartObj> disabledColor, ffi.Pointer<DartObj> dividerColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> highlightColor, ffi.Pointer<DartObj> hintColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> indicatorColor, ffi.Pointer<DartObj> primaryColor, ffi.Pointer<DartObj> primaryColorDark, ffi.Pointer<DartObj> primaryColorLight, ffi.Pointer<DartObj> primarySwatch, ffi.Pointer<DartObj> scaffoldBackgroundColor, ffi.Pointer<DartObj> secondaryHeaderColor, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> unselectedWidgetColor, ffi.Pointer<ffi.Char> fontFamily, ffi.Pointer<ffi.Pointer<ffi.Pointer<ffi.Char>>> fontFamilyFallback, ffi.Pointer<ffi.Char> package, ffi.Pointer<DartObj> primaryTextTheme, ffi.Pointer<DartObj> textTheme, ffi.Pointer<DartObj> cardTheme, ffi.Pointer<DartObj> dialogTheme, ffi.Pointer<DartObj> tabBarTheme, ffi.Pointer<DartObj> dialogBackgroundColor) {
  final w = ThemeData(applyElevationOverlayColor: applyElevationOverlayColor.boolOrNul(),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      platform: platform.enumOrNul(TargetPlatform.values),
      useMaterial3: useMaterial3.boolOrNul(),
      colorScheme: colorScheme.objOrNul(),
      brightness: brightness.enumOrNul(Brightness.values),
      colorSchemeSeed: colorSchemeSeed.objOrNul(),
      canvasColor: canvasColor.objOrNul(),
      cardColor: cardColor.objOrNul(),
      disabledColor: disabledColor.objOrNul(),
      dividerColor: dividerColor.objOrNul(),
      focusColor: focusColor.objOrNul(),
      highlightColor: highlightColor.objOrNul(),
      hintColor: hintColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      indicatorColor: indicatorColor.objOrNul(),
      primaryColor: primaryColor.objOrNul(),
      primaryColorDark: primaryColorDark.objOrNul(),
      primaryColorLight: primaryColorLight.objOrNul(),
      primarySwatch: primarySwatch.objOrNul(),
      scaffoldBackgroundColor: scaffoldBackgroundColor.objOrNul(),
      secondaryHeaderColor: secondaryHeaderColor.objOrNul(),
      shadowColor: shadowColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      unselectedWidgetColor: unselectedWidgetColor.objOrNul(),
      fontFamily: fontFamily.strOrNul(),
      fontFamilyFallback: fontFamilyFallback.orEmpty(),
      package: package.strOrNul(),
      primaryTextTheme: primaryTextTheme.objOrNul(),
      textTheme: textTheme.objOrNul(),
      cardTheme: cardTheme.objOrNul(),
      dialogTheme: dialogTheme.objOrNul(),
      tabBarTheme: tabBarTheme.objOrNul(),
      dialogBackgroundColor: dialogBackgroundColor.objOrNul());
  return _createThemeDataObjSt(w);
}
ThemeDataObjSt themeDataFrom(DartDartObj colorScheme, ffi.Pointer<DartObj> textTheme, ffi.Pointer<ffi.Int> useMaterial3) {
  final w = ThemeData.from(colorScheme: _widgetsMap[colorScheme]! as ColorScheme,
      textTheme: textTheme.objOrNul(),
      useMaterial3: useMaterial3.boolOrNul());
  return _createThemeDataObjSt(w);
}
ThemeDataObjSt themeDataLight(ffi.Pointer<ffi.Int> useMaterial3) {
  final w = ThemeData.light(useMaterial3: useMaterial3.boolOrNul());
  return _createThemeDataObjSt(w);
}
ThemeDataObjSt themeDataDark(ffi.Pointer<ffi.Int> useMaterial3) {
  final w = ThemeData.dark(useMaterial3: useMaterial3.boolOrNul());
  return _createThemeDataObjSt(w);
}
ThemeDataObjSt themeDataFallback(ffi.Pointer<ffi.Int> useMaterial3) {
  final w = ThemeData.fallback(useMaterial3: useMaterial3.boolOrNul());
  return _createThemeDataObjSt(w);
}
ThemeDataObjSt themeDataLocalize(DartDartObj baseTheme, DartDartObj localTextGeometry) {
  final w = ThemeData.localize(_widgetsMap[baseTheme]! as ThemeData,
      _widgetsMap[localTextGeometry]! as TextTheme);
  return _createThemeDataObjSt(w);
}
int themeDataEstimateBrightnessForColor(DartDartObj color) {
  final w = ThemeData.estimateBrightnessForColor(_widgetsMap[color]! as Color);
  return w.index;
}
ThemeDataObjSt themeDataLerp(DartDartObj a, DartDartObj b, double t) {
  final w = ThemeData.lerp(_widgetsMap[a]! as ThemeData,
      _widgetsMap[b]! as ThemeData,
      t);
  return _createThemeDataObjSt(w);
}
ThemeDataObjSt _createThemeDataObjSt(ThemeData? w) {
  final ThemeDataObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.applyElevationOverlayColor = w.applyElevationOverlayColor.toInt();
  stObj.materialTapTargetSize = w.materialTapTargetSize.index;
  stObj.platform = w.platform.index;
  stObj.useMaterial3 = w.useMaterial3.toInt();
  stObj.canvasColor = _addWidget(w.canvasColor);
  stObj.cardColor = _addWidget(w.cardColor);
  stObj.colorScheme = _createColorSchemeObjSt(w.colorScheme);
  stObj.disabledColor = _addWidget(w.disabledColor);
  stObj.dividerColor = _addWidget(w.dividerColor);
  stObj.focusColor = _addWidget(w.focusColor);
  stObj.highlightColor = _addWidget(w.highlightColor);
  stObj.hintColor = _addWidget(w.hintColor);
  stObj.hoverColor = _addWidget(w.hoverColor);
  stObj.indicatorColor = _addWidget(w.indicatorColor);
  stObj.primaryColor = _addWidget(w.primaryColor);
  stObj.primaryColorDark = _addWidget(w.primaryColorDark);
  stObj.primaryColorLight = _addWidget(w.primaryColorLight);
  stObj.scaffoldBackgroundColor = _addWidget(w.scaffoldBackgroundColor);
  stObj.secondaryHeaderColor = _addWidget(w.secondaryHeaderColor);
  stObj.shadowColor = _addWidget(w.shadowColor);
  stObj.splashColor = _addWidget(w.splashColor);
  stObj.unselectedWidgetColor = _addWidget(w.unselectedWidgetColor);
  stObj.primaryTextTheme = _createTextThemeObjSt(w.primaryTextTheme);
  stObj.textTheme = _createTextThemeObjSt(w.textTheme);
  stObj.dialogBackgroundColor = _addWidget(w.dialogBackgroundColor);
  stObj.brightness = w.brightness.index;
  return stObj;
}

void _setupMaterialAccentColor(WidgetFactories f) {
  f.materialAccentColor.materialAccentColor = ffi.Pointer.fromFunction(materialAccentColorMaterialAccentColor);
}
MaterialAccentColorObjSt materialAccentColorMaterialAccentColor(int primary, MapC swatch) {
  final w = MaterialAccentColor(primary,
      swatch.toMap());
  return _createMaterialAccentColorObjSt(w);
}
MaterialAccentColorObjSt _createMaterialAccentColorObjSt(MaterialAccentColor? w) {
  final MaterialAccentColorObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.shade100 = _addWidget(w.shade100);
  stObj.shade200 = _addWidget(w.shade200);
  stObj.shade400 = _addWidget(w.shade400);
  stObj.shade700 = _addWidget(w.shade700);
  return stObj;
}

void _setupMaterial(WidgetFactories f) {
  f.material.material = ffi.Pointer.fromFunction(materialMaterial);
}
MaterialObjSt materialMaterial(ffi.Pointer<ffi.Int> type, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<DartObj> textStyle, ffi.Pointer<DartObj> borderRadius, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> borderOnForeground, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> child) {
  final w = Material(type: type.enumOr(MaterialType.values, MaterialType.canvas),
      elevation: elevation.doubleOr(0.0),
      color: color.objOrNul(),
      shadowColor: shadowColor.objOrNul(),
      surfaceTintColor: surfaceTintColor.objOrNul(),
      textStyle: textStyle.objOrNul(),
      borderRadius: borderRadius.objOrNul(),
      shape: shape.objOrNul(),
      borderOnForeground: borderOnForeground.boolOr(true),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      child: child.objOrNul());
  return _createMaterialObjSt(w);
}
MaterialObjSt _createMaterialObjSt(Material? w) {
  final MaterialObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.type = w.type.index;
  stObj.elevation = w.elevation;
  stObj.color = _addWidget(w.color);
  stObj.shadowColor = _addWidget(w.shadowColor);
  stObj.surfaceTintColor = _addWidget(w.surfaceTintColor);
  stObj.textStyle = _createTextStyleObjSt(w.textStyle);
  stObj.shape = _addWidget(w.shape);
  stObj.borderOnForeground = w.borderOnForeground.toInt();
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.borderRadius = _addWidget(w.borderRadius);
  return stObj;
}

void _setupIconButton(WidgetFactories f) {
  f.iconButton.iconButton = ffi.Pointer.fromFunction(iconButtonIconButton);
  f.iconButton.filled = ffi.Pointer.fromFunction(iconButtonFilled);
  f.iconButton.filledTonal = ffi.Pointer.fromFunction(iconButtonFilledTonal);
  f.iconButton.outlined = ffi.Pointer.fromFunction(iconButtonOutlined);
}
IconButtonObjSt iconButtonIconButton(ffi.Pointer<ffi.Double> iconSize, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> highlightColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> disabledColor, VoidCallbackFFI onPressed, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<DartObj> constraints, ffi.Pointer<ffi.Int> isSelected, ffi.Pointer<DartObj> selectedIcon, DartDartObj icon) {
  final w = IconButton(iconSize: iconSize.doubleOrNul(),
      padding: padding.objOrNul(),
      alignment: alignment.objOrNul(),
      splashRadius: splashRadius.doubleOrNul(),
      color: color.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      highlightColor: highlightColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      disabledColor: disabledColor.objOrNul(),
      onPressed: onPressed.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      autofocus: autofocus.boolOr(false),
      tooltip: tooltip.strOrNul(),
      enableFeedback: enableFeedback.boolOrNul(),
      constraints: constraints.objOrNul(),
      isSelected: isSelected.boolOrNul(),
      selectedIcon: selectedIcon.objOrNul(),
      icon: _widgetsMap[icon]! as Widget);
  return _createIconButtonObjSt(w);
}
IconButtonObjSt iconButtonFilled(ffi.Pointer<ffi.Double> iconSize, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> highlightColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> disabledColor, VoidCallbackFFI onPressed, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<DartObj> constraints, ffi.Pointer<ffi.Int> isSelected, ffi.Pointer<DartObj> selectedIcon, DartDartObj icon) {
  final w = IconButton.filled(iconSize: iconSize.doubleOrNul(),
      padding: padding.objOrNul(),
      alignment: alignment.objOrNul(),
      splashRadius: splashRadius.doubleOrNul(),
      color: color.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      highlightColor: highlightColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      disabledColor: disabledColor.objOrNul(),
      onPressed: onPressed.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      autofocus: autofocus.boolOr(false),
      tooltip: tooltip.strOrNul(),
      enableFeedback: enableFeedback.boolOrNul(),
      constraints: constraints.objOrNul(),
      isSelected: isSelected.boolOrNul(),
      selectedIcon: selectedIcon.objOrNul(),
      icon: _widgetsMap[icon]! as Widget);
  return _createIconButtonObjSt(w);
}
IconButtonObjSt iconButtonFilledTonal(ffi.Pointer<ffi.Double> iconSize, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> highlightColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> disabledColor, VoidCallbackFFI onPressed, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<DartObj> constraints, ffi.Pointer<ffi.Int> isSelected, ffi.Pointer<DartObj> selectedIcon, DartDartObj icon) {
  final w = IconButton.filledTonal(iconSize: iconSize.doubleOrNul(),
      padding: padding.objOrNul(),
      alignment: alignment.objOrNul(),
      splashRadius: splashRadius.doubleOrNul(),
      color: color.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      highlightColor: highlightColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      disabledColor: disabledColor.objOrNul(),
      onPressed: onPressed.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      autofocus: autofocus.boolOr(false),
      tooltip: tooltip.strOrNul(),
      enableFeedback: enableFeedback.boolOrNul(),
      constraints: constraints.objOrNul(),
      isSelected: isSelected.boolOrNul(),
      selectedIcon: selectedIcon.objOrNul(),
      icon: _widgetsMap[icon]! as Widget);
  return _createIconButtonObjSt(w);
}
IconButtonObjSt iconButtonOutlined(ffi.Pointer<ffi.Double> iconSize, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> highlightColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> disabledColor, VoidCallbackFFI onPressed, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<DartObj> constraints, ffi.Pointer<ffi.Int> isSelected, ffi.Pointer<DartObj> selectedIcon, DartDartObj icon) {
  final w = IconButton.outlined(iconSize: iconSize.doubleOrNul(),
      padding: padding.objOrNul(),
      alignment: alignment.objOrNul(),
      splashRadius: splashRadius.doubleOrNul(),
      color: color.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      highlightColor: highlightColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      disabledColor: disabledColor.objOrNul(),
      onPressed: onPressed.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      autofocus: autofocus.boolOr(false),
      tooltip: tooltip.strOrNul(),
      enableFeedback: enableFeedback.boolOrNul(),
      constraints: constraints.objOrNul(),
      isSelected: isSelected.boolOrNul(),
      selectedIcon: selectedIcon.objOrNul(),
      icon: _widgetsMap[icon]! as Widget);
  return _createIconButtonObjSt(w);
}
IconButtonObjSt _createIconButtonObjSt(IconButton? w) {
  final IconButtonObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.iconSize = (w.iconSize != null) ? w.iconSize! : 0;
  stObj.padding = _addWidget(w.padding);
  stObj.alignment = _addWidget(w.alignment);
  stObj.splashRadius = (w.splashRadius != null) ? w.splashRadius! : 0;
  stObj.icon = _addWidget(w.icon);
  stObj.focusColor = _addWidget(w.focusColor);
  stObj.hoverColor = _addWidget(w.hoverColor);
  stObj.color = _addWidget(w.color);
  stObj.splashColor = _addWidget(w.splashColor);
  stObj.highlightColor = _addWidget(w.highlightColor);
  stObj.disabledColor = _addWidget(w.disabledColor);
  stObj.autofocus = w.autofocus.toInt();
  stObj.tooltip = (w.tooltip != null) ? w.tooltip!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.enableFeedback = (w.enableFeedback != null) ? w.enableFeedback!.toInt() : 0;
  stObj.constraints = _createBoxConstraintsObjSt(w.constraints);
  stObj.isSelected = (w.isSelected != null) ? w.isSelected!.toInt() : 0;
  stObj.selectedIcon = _addWidget(w.selectedIcon);
  return stObj;
}

void _setupAppBar(WidgetFactories f) {
  f.appBar.appBar = ffi.Pointer.fromFunction(appBarAppBar);
}
AppBarObjSt appBarAppBar(ffi.Pointer<DartObj> leading, ffi.Pointer<ffi.Int> automaticallyImplyLeading, ffi.Pointer<DartObj> title, ffi.Pointer<ArrayC> actions, ffi.Pointer<DartObj> flexibleSpace, ffi.Pointer<DartObj> bottom, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<ffi.Double> scrolledUnderElevation, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<DartObj> shape, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> foregroundColor, ffi.Pointer<ffi.Int> primary, ffi.Pointer<ffi.Int> centerTitle, ffi.Pointer<ffi.Int> excludeHeaderSemantics, ffi.Pointer<ffi.Double> titleSpacing, ffi.Pointer<ffi.Double> toolbarOpacity, ffi.Pointer<ffi.Double> bottomOpacity, ffi.Pointer<ffi.Double> toolbarHeight, ffi.Pointer<ffi.Double> leadingWidth, ffi.Pointer<DartObj> toolbarTextStyle, ffi.Pointer<DartObj> titleTextStyle, ffi.Pointer<ffi.Int> forceMaterialTransparency, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> actionsPadding) {
  final w = AppBar(leading: leading.objOrNul(),
      automaticallyImplyLeading: automaticallyImplyLeading.boolOr(true),
      title: title.objOrNul(),
      actions: actions.orEmpty(),
      flexibleSpace: flexibleSpace.objOrNul(),
      bottom: bottom.objOrNul(),
      elevation: elevation.doubleOrNul(),
      scrolledUnderElevation: scrolledUnderElevation.doubleOrNul(),
      shadowColor: shadowColor.objOrNul(),
      surfaceTintColor: surfaceTintColor.objOrNul(),
      shape: shape.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      foregroundColor: foregroundColor.objOrNul(),
      primary: primary.boolOr(true),
      centerTitle: centerTitle.boolOrNul(),
      excludeHeaderSemantics: excludeHeaderSemantics.boolOr(false),
      titleSpacing: titleSpacing.doubleOrNul(),
      toolbarOpacity: toolbarOpacity.doubleOr(1.0),
      bottomOpacity: bottomOpacity.doubleOr(1.0),
      toolbarHeight: toolbarHeight.doubleOrNul(),
      leadingWidth: leadingWidth.doubleOrNul(),
      toolbarTextStyle: toolbarTextStyle.objOrNul(),
      titleTextStyle: titleTextStyle.objOrNul(),
      forceMaterialTransparency: forceMaterialTransparency.boolOr(false),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      actionsPadding: actionsPadding.objOrNul());
  return _createAppBarObjSt(w);
}
AppBarObjSt _createAppBarObjSt(AppBar? w) {
  final AppBarObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.leading = _addWidget(w.leading);
  stObj.automaticallyImplyLeading = w.automaticallyImplyLeading.toInt();
  stObj.title = _addWidget(w.title);
  stObj.flexibleSpace = _addWidget(w.flexibleSpace);
  stObj.elevation = (w.elevation != null) ? w.elevation! : 0;
  stObj.scrolledUnderElevation = (w.scrolledUnderElevation != null) ? w.scrolledUnderElevation! : 0;
  stObj.shadowColor = _addWidget(w.shadowColor);
  stObj.surfaceTintColor = _addWidget(w.surfaceTintColor);
  stObj.shape = _addWidget(w.shape);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.foregroundColor = _addWidget(w.foregroundColor);
  stObj.primary = w.primary.toInt();
  stObj.centerTitle = (w.centerTitle != null) ? w.centerTitle!.toInt() : 0;
  stObj.excludeHeaderSemantics = w.excludeHeaderSemantics.toInt();
  stObj.titleSpacing = (w.titleSpacing != null) ? w.titleSpacing! : 0;
  stObj.toolbarOpacity = w.toolbarOpacity;
  stObj.bottomOpacity = w.bottomOpacity;
  stObj.toolbarHeight = (w.toolbarHeight != null) ? w.toolbarHeight! : 0;
  stObj.leadingWidth = (w.leadingWidth != null) ? w.leadingWidth! : 0;
  stObj.toolbarTextStyle = _createTextStyleObjSt(w.toolbarTextStyle);
  stObj.titleTextStyle = _createTextStyleObjSt(w.titleTextStyle);
  stObj.forceMaterialTransparency = w.forceMaterialTransparency.toInt();
  stObj.clipBehavior = (w.clipBehavior != null) ? w.clipBehavior!.index : 0;
  stObj.actionsPadding = _addWidget(w.actionsPadding);
  return stObj;
}

void _setupScaffold(WidgetFactories f) {
  f.scaffold.scaffold = ffi.Pointer.fromFunction(scaffoldScaffold);
  f.scaffold.geometryOf = ffi.Pointer.fromFunction(scaffoldGeometryOf, exception);
}
ScaffoldObjSt scaffoldScaffold(ffi.Pointer<DartObj> appBar, ffi.Pointer<DartObj> body, ffi.Pointer<DartObj> floatingActionButton, ffi.Pointer<ArrayC> persistentFooterButtons, ffi.Pointer<DartObj> drawer, ffi.Pointer<DrawerCallbackFFI> onDrawerChanged, ffi.Pointer<DartObj> endDrawer, ffi.Pointer<DrawerCallbackFFI> onEndDrawerChanged, ffi.Pointer<DartObj> bottomNavigationBar, ffi.Pointer<DartObj> bottomSheet, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Int> resizeToAvoidBottomInset, ffi.Pointer<ffi.Int> primary, ffi.Pointer<ffi.Int> drawerDragStartBehavior, ffi.Pointer<ffi.Int> extendBody, ffi.Pointer<ffi.Int> extendBodyBehindAppBar, ffi.Pointer<DartObj> drawerScrimColor, ffi.Pointer<ffi.Double> drawerEdgeDragWidth, ffi.Pointer<ffi.Int> drawerEnableOpenDragGesture, ffi.Pointer<ffi.Int> endDrawerEnableOpenDragGesture, ffi.Pointer<ffi.Char> restorationId) {
  final w = Scaffold(appBar: appBar.objOrNul(),
      body: body.objOrNul(),
      floatingActionButton: floatingActionButton.objOrNul(),
      persistentFooterButtons: persistentFooterButtons.orEmpty(),
      drawer: drawer.objOrNul(),
      onDrawerChanged: onDrawerChanged.toDrawerCallbackFn(),
      endDrawer: endDrawer.objOrNul(),
      onEndDrawerChanged: onEndDrawerChanged.toDrawerCallbackFn(),
      bottomNavigationBar: bottomNavigationBar.objOrNul(),
      bottomSheet: bottomSheet.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      resizeToAvoidBottomInset: resizeToAvoidBottomInset.boolOrNul(),
      primary: primary.boolOr(true),
      drawerDragStartBehavior: drawerDragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      extendBody: extendBody.boolOr(false),
      extendBodyBehindAppBar: extendBodyBehindAppBar.boolOr(false),
      drawerScrimColor: drawerScrimColor.objOrNul(),
      drawerEdgeDragWidth: drawerEdgeDragWidth.doubleOrNul(),
      drawerEnableOpenDragGesture: drawerEnableOpenDragGesture.boolOr(true),
      endDrawerEnableOpenDragGesture: endDrawerEnableOpenDragGesture.boolOr(true),
      restorationId: restorationId.strOrNul());
  return _createScaffoldObjSt(w);
}
int scaffoldGeometryOf(DartDartObj context) {
  final w = Scaffold.geometryOf(_widgetsMap[context]! as BuildContext);
  return _addWidget(w);
}
ScaffoldObjSt _createScaffoldObjSt(Scaffold? w) {
  final ScaffoldObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.extendBody = w.extendBody.toInt();
  stObj.extendBodyBehindAppBar = w.extendBodyBehindAppBar.toInt();
  stObj.body = _addWidget(w.body);
  stObj.floatingActionButton = _addWidget(w.floatingActionButton);
  stObj.drawer = _addWidget(w.drawer);
  stObj.endDrawer = _addWidget(w.endDrawer);
  stObj.drawerScrimColor = _addWidget(w.drawerScrimColor);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.bottomNavigationBar = _addWidget(w.bottomNavigationBar);
  stObj.bottomSheet = _addWidget(w.bottomSheet);
  stObj.resizeToAvoidBottomInset = (w.resizeToAvoidBottomInset != null) ? w.resizeToAvoidBottomInset!.toInt() : 0;
  stObj.primary = w.primary.toInt();
  stObj.drawerDragStartBehavior = w.drawerDragStartBehavior.index;
  stObj.drawerEdgeDragWidth = (w.drawerEdgeDragWidth != null) ? w.drawerEdgeDragWidth! : 0;
  stObj.drawerEnableOpenDragGesture = w.drawerEnableOpenDragGesture.toInt();
  stObj.endDrawerEnableOpenDragGesture = w.endDrawerEnableOpenDragGesture.toInt();
  stObj.restorationId = (w.restorationId != null) ? w.restorationId!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  return stObj;
}

void _setupMaterialApp(WidgetFactories f) {
  f.materialApp.materialApp = ffi.Pointer.fromFunction(materialAppMaterialApp);
  f.materialApp.router = ffi.Pointer.fromFunction(materialAppRouter);
}
MaterialAppObjSt materialAppMaterialApp(ffi.Pointer<DartObj> home, ffi.Pointer<ffi.Char> initialRoute, ffi.Pointer<TransitionBuilderFFI> builder, ffi.Pointer<ffi.Char> title, ffi.Pointer<GenerateAppTitleFFI> onGenerateTitle, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> theme, ffi.Pointer<DartObj> darkTheme, ffi.Pointer<DartObj> highContrastTheme, ffi.Pointer<DartObj> highContrastDarkTheme, ffi.Pointer<ffi.Int> themeMode, ffi.Pointer<DartObj> themeAnimationCurve, ffi.Pointer<ffi.Int> debugShowMaterialGrid, ffi.Pointer<ffi.Int> showPerformanceOverlay, ffi.Pointer<ffi.Int> checkerboardRasterCacheImages, ffi.Pointer<ffi.Int> checkerboardOffscreenLayers, ffi.Pointer<ffi.Int> showSemanticsDebugger, ffi.Pointer<ffi.Int> debugShowCheckedModeBanner, ffi.Pointer<ffi.Char> restorationScopeId, ffi.Pointer<ffi.Int> useInheritedMediaQuery) {
  final w = MaterialApp(home: home.objOrNul(),
      initialRoute: initialRoute.strOrNul(),
      builder: builder.toTransitionBuilderFn(),
      title: title.strOrNul(),
      onGenerateTitle: onGenerateTitle.toGenerateAppTitleFn(),
      color: color.objOrNul(),
      theme: theme.objOrNul(),
      darkTheme: darkTheme.objOrNul(),
      highContrastTheme: highContrastTheme.objOrNul(),
      highContrastDarkTheme: highContrastDarkTheme.objOrNul(),
      themeMode: themeMode.enumOrNul(ThemeMode.values),
      themeAnimationCurve: themeAnimationCurve.objOrNul(),
      debugShowMaterialGrid: debugShowMaterialGrid.boolOr(false),
      showPerformanceOverlay: showPerformanceOverlay.boolOr(false),
      checkerboardRasterCacheImages: checkerboardRasterCacheImages.boolOr(false),
      checkerboardOffscreenLayers: checkerboardOffscreenLayers.boolOr(false),
      showSemanticsDebugger: showSemanticsDebugger.boolOr(false),
      debugShowCheckedModeBanner: debugShowCheckedModeBanner.boolOr(true),
      restorationScopeId: restorationScopeId.strOrNul(),
      useInheritedMediaQuery: useInheritedMediaQuery.boolOr(false));
  return _createMaterialAppObjSt(w);
}
MaterialAppObjSt materialAppRouter(ffi.Pointer<TransitionBuilderFFI> builder, ffi.Pointer<ffi.Char> title, ffi.Pointer<GenerateAppTitleFFI> onGenerateTitle, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> theme, ffi.Pointer<DartObj> darkTheme, ffi.Pointer<DartObj> highContrastTheme, ffi.Pointer<DartObj> highContrastDarkTheme, ffi.Pointer<ffi.Int> themeMode, ffi.Pointer<DartObj> themeAnimationCurve, ffi.Pointer<ffi.Int> debugShowMaterialGrid, ffi.Pointer<ffi.Int> showPerformanceOverlay, ffi.Pointer<ffi.Int> checkerboardRasterCacheImages, ffi.Pointer<ffi.Int> checkerboardOffscreenLayers, ffi.Pointer<ffi.Int> showSemanticsDebugger, ffi.Pointer<ffi.Int> debugShowCheckedModeBanner, ffi.Pointer<ffi.Char> restorationScopeId, ffi.Pointer<ffi.Int> useInheritedMediaQuery) {
  final w = MaterialApp.router(builder: builder.toTransitionBuilderFn(),
      title: title.strOrNul(),
      onGenerateTitle: onGenerateTitle.toGenerateAppTitleFn(),
      color: color.objOrNul(),
      theme: theme.objOrNul(),
      darkTheme: darkTheme.objOrNul(),
      highContrastTheme: highContrastTheme.objOrNul(),
      highContrastDarkTheme: highContrastDarkTheme.objOrNul(),
      themeMode: themeMode.enumOrNul(ThemeMode.values),
      themeAnimationCurve: themeAnimationCurve.objOrNul(),
      debugShowMaterialGrid: debugShowMaterialGrid.boolOr(false),
      showPerformanceOverlay: showPerformanceOverlay.boolOr(false),
      checkerboardRasterCacheImages: checkerboardRasterCacheImages.boolOr(false),
      checkerboardOffscreenLayers: checkerboardOffscreenLayers.boolOr(false),
      showSemanticsDebugger: showSemanticsDebugger.boolOr(false),
      debugShowCheckedModeBanner: debugShowCheckedModeBanner.boolOr(true),
      restorationScopeId: restorationScopeId.strOrNul(),
      useInheritedMediaQuery: useInheritedMediaQuery.boolOr(false));
  return _createMaterialAppObjSt(w);
}
MaterialAppObjSt _createMaterialAppObjSt(MaterialApp? w) {
  final MaterialAppObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.home = _addWidget(w.home);
  stObj.initialRoute = (w.initialRoute != null) ? w.initialRoute!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.title = (w.title != null) ? w.title!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.theme = _createThemeDataObjSt(w.theme);
  stObj.darkTheme = _createThemeDataObjSt(w.darkTheme);
  stObj.highContrastTheme = _createThemeDataObjSt(w.highContrastTheme);
  stObj.highContrastDarkTheme = _createThemeDataObjSt(w.highContrastDarkTheme);
  stObj.themeMode = (w.themeMode != null) ? w.themeMode!.index : 0;
  stObj.themeAnimationCurve = _addWidget(w.themeAnimationCurve);
  stObj.color = _addWidget(w.color);
  stObj.showPerformanceOverlay = w.showPerformanceOverlay.toInt();
  stObj.checkerboardRasterCacheImages = w.checkerboardRasterCacheImages.toInt();
  stObj.checkerboardOffscreenLayers = w.checkerboardOffscreenLayers.toInt();
  stObj.showSemanticsDebugger = w.showSemanticsDebugger.toInt();
  stObj.debugShowCheckedModeBanner = w.debugShowCheckedModeBanner.toInt();
  stObj.restorationScopeId = (w.restorationScopeId != null) ? w.restorationScopeId!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.debugShowMaterialGrid = w.debugShowMaterialGrid.toInt();
  stObj.useInheritedMediaQuery = w.useInheritedMediaQuery.toInt();
  return stObj;
}

void _setupFloatingActionButton(WidgetFactories f) {
  f.floatingActionButton.floatingActionButton = ffi.Pointer.fromFunction(floatingActionButtonFloatingActionButton);
  f.floatingActionButton.small = ffi.Pointer.fromFunction(floatingActionButtonSmall);
  f.floatingActionButton.large = ffi.Pointer.fromFunction(floatingActionButtonLarge);
  f.floatingActionButton.extended = ffi.Pointer.fromFunction(floatingActionButtonExtended);
}
FloatingActionButtonObjSt floatingActionButtonFloatingActionButton(ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<DartObj> foregroundColor, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> heroTag, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<ffi.Double> focusElevation, ffi.Pointer<ffi.Double> hoverElevation, ffi.Pointer<ffi.Double> highlightElevation, ffi.Pointer<ffi.Double> disabledElevation, VoidCallbackFFI onPressed, ffi.Pointer<ffi.Int> mini, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<ffi.Int> isExtended, ffi.Pointer<ffi.Int> enableFeedback) {
  final w = FloatingActionButton(child: child.objOrNul(),
      tooltip: tooltip.strOrNul(),
      foregroundColor: foregroundColor.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      heroTag: heroTag.objOrNul(),
      elevation: elevation.doubleOrNul(),
      focusElevation: focusElevation.doubleOrNul(),
      hoverElevation: hoverElevation.doubleOrNul(),
      highlightElevation: highlightElevation.doubleOrNul(),
      disabledElevation: disabledElevation.doubleOrNul(),
      onPressed: onPressed.toVoidCallbackFn(),
      mini: mini.boolOr(false),
      shape: shape.objOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      autofocus: autofocus.boolOr(false),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      isExtended: isExtended.boolOr(false),
      enableFeedback: enableFeedback.boolOrNul());
  return _createFloatingActionButtonObjSt(w);
}
FloatingActionButtonObjSt floatingActionButtonSmall(ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<DartObj> foregroundColor, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> heroTag, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<ffi.Double> focusElevation, ffi.Pointer<ffi.Double> hoverElevation, ffi.Pointer<ffi.Double> highlightElevation, ffi.Pointer<ffi.Double> disabledElevation, VoidCallbackFFI onPressed, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<ffi.Int> enableFeedback) {
  final w = FloatingActionButton.small(child: child.objOrNul(),
      tooltip: tooltip.strOrNul(),
      foregroundColor: foregroundColor.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      heroTag: heroTag.objOrNul(),
      elevation: elevation.doubleOrNul(),
      focusElevation: focusElevation.doubleOrNul(),
      hoverElevation: hoverElevation.doubleOrNul(),
      highlightElevation: highlightElevation.doubleOrNul(),
      disabledElevation: disabledElevation.doubleOrNul(),
      onPressed: onPressed.toVoidCallbackFn(),
      shape: shape.objOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      autofocus: autofocus.boolOr(false),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      enableFeedback: enableFeedback.boolOrNul());
  return _createFloatingActionButtonObjSt(w);
}
FloatingActionButtonObjSt floatingActionButtonLarge(ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<DartObj> foregroundColor, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> heroTag, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<ffi.Double> focusElevation, ffi.Pointer<ffi.Double> hoverElevation, ffi.Pointer<ffi.Double> highlightElevation, ffi.Pointer<ffi.Double> disabledElevation, VoidCallbackFFI onPressed, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<ffi.Int> enableFeedback) {
  final w = FloatingActionButton.large(child: child.objOrNul(),
      tooltip: tooltip.strOrNul(),
      foregroundColor: foregroundColor.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      heroTag: heroTag.objOrNul(),
      elevation: elevation.doubleOrNul(),
      focusElevation: focusElevation.doubleOrNul(),
      hoverElevation: hoverElevation.doubleOrNul(),
      highlightElevation: highlightElevation.doubleOrNul(),
      disabledElevation: disabledElevation.doubleOrNul(),
      onPressed: onPressed.toVoidCallbackFn(),
      shape: shape.objOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      autofocus: autofocus.boolOr(false),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      enableFeedback: enableFeedback.boolOrNul());
  return _createFloatingActionButtonObjSt(w);
}
FloatingActionButtonObjSt floatingActionButtonExtended(ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<DartObj> foregroundColor, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> heroTag, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<ffi.Double> focusElevation, ffi.Pointer<ffi.Double> hoverElevation, ffi.Pointer<DartObj> splashColor, ffi.Pointer<ffi.Double> highlightElevation, ffi.Pointer<ffi.Double> disabledElevation, VoidCallbackFFI onPressed, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> isExtended, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Double> extendedIconLabelSpacing, ffi.Pointer<DartObj> extendedPadding, ffi.Pointer<DartObj> extendedTextStyle, ffi.Pointer<DartObj> icon, DartDartObj label, ffi.Pointer<ffi.Int> enableFeedback) {
  final w = FloatingActionButton.extended(tooltip: tooltip.strOrNul(),
      foregroundColor: foregroundColor.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      heroTag: heroTag.objOrNul(),
      elevation: elevation.doubleOrNul(),
      focusElevation: focusElevation.doubleOrNul(),
      hoverElevation: hoverElevation.doubleOrNul(),
      splashColor: splashColor.objOrNul(),
      highlightElevation: highlightElevation.doubleOrNul(),
      disabledElevation: disabledElevation.doubleOrNul(),
      onPressed: onPressed.toVoidCallbackFn(),
      shape: shape.objOrNul(),
      isExtended: isExtended.boolOr(true),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      autofocus: autofocus.boolOr(false),
      extendedIconLabelSpacing: extendedIconLabelSpacing.doubleOrNul(),
      extendedPadding: extendedPadding.objOrNul(),
      extendedTextStyle: extendedTextStyle.objOrNul(),
      icon: icon.objOrNul(),
      label: _widgetsMap[label]! as Widget,
      enableFeedback: enableFeedback.boolOrNul());
  return _createFloatingActionButtonObjSt(w);
}
FloatingActionButtonObjSt _createFloatingActionButtonObjSt(FloatingActionButton? w) {
  final FloatingActionButtonObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.tooltip = (w.tooltip != null) ? w.tooltip!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.foregroundColor = _addWidget(w.foregroundColor);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.focusColor = _addWidget(w.focusColor);
  stObj.hoverColor = _addWidget(w.hoverColor);
  stObj.splashColor = _addWidget(w.splashColor);
  stObj.elevation = (w.elevation != null) ? w.elevation! : 0;
  stObj.focusElevation = (w.focusElevation != null) ? w.focusElevation! : 0;
  stObj.hoverElevation = (w.hoverElevation != null) ? w.hoverElevation! : 0;
  stObj.highlightElevation = (w.highlightElevation != null) ? w.highlightElevation! : 0;
  stObj.disabledElevation = (w.disabledElevation != null) ? w.disabledElevation! : 0;
  stObj.mini = w.mini.toInt();
  stObj.shape = _addWidget(w.shape);
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.isExtended = w.isExtended.toInt();
  stObj.autofocus = w.autofocus.toInt();
  stObj.materialTapTargetSize = (w.materialTapTargetSize != null) ? w.materialTapTargetSize!.index : 0;
  stObj.enableFeedback = (w.enableFeedback != null) ? w.enableFeedback!.toInt() : 0;
  stObj.extendedIconLabelSpacing = (w.extendedIconLabelSpacing != null) ? w.extendedIconLabelSpacing! : 0;
  stObj.extendedPadding = _addWidget(w.extendedPadding);
  stObj.extendedTextStyle = _createTextStyleObjSt(w.extendedTextStyle);
  return stObj;
}

void _setupTheme(WidgetFactories f) {
  f.theme.theme = ffi.Pointer.fromFunction(themeTheme);
  f.theme.of = ffi.Pointer.fromFunction(themeOf);
}
ThemeObjSt themeTheme(DartDartObj data, DartDartObj child) {
  final w = Theme(data: _widgetsMap[data]! as ThemeData,
      child: _widgetsMap[child]! as Widget);
  return _createThemeObjSt(w);
}
ThemeDataObjSt themeOf(DartDartObj context) {
  final w = Theme.of(_widgetsMap[context]! as BuildContext);
  return _createThemeDataObjSt(w);
}
ThemeObjSt _createThemeObjSt(Theme? w) {
  final ThemeObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.data = _createThemeDataObjSt(w.data);
  stObj.child = _addWidget(w.child);
  return stObj;
}

void _setupElevatedButton(WidgetFactories f) {
  f.elevatedButton.elevatedButton = ffi.Pointer.fromFunction(elevatedButtonElevatedButton);
  f.elevatedButton.icon = ffi.Pointer.fromFunction(elevatedButtonIcon);
}
ElevatedButtonObjSt elevatedButtonElevatedButton(VoidCallbackFFI onPressed, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> clipBehavior, DartDartObj child) {
  final w = ElevatedButton(onPressed: onPressed.toVoidCallbackFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      child: _widgetsMap[child]! as Widget?);
  return _createElevatedButtonObjSt(w);
}
ElevatedButtonObjSt elevatedButtonIcon(VoidCallbackFFI onPressed, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> icon, DartDartObj label, ffi.Pointer<ffi.Int> iconAlignment) {
  final w = ElevatedButton.icon(onPressed: onPressed.toVoidCallbackFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOrNul(),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      icon: icon.objOrNul(),
      label: _widgetsMap[label]! as Widget,
      iconAlignment: iconAlignment.enumOrNul(IconAlignment.values));
  return _createElevatedButtonObjSt(w);
}
ElevatedButtonObjSt _createElevatedButtonObjSt(ElevatedButton? w) {
  final ElevatedButtonObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupOutlinedButton(WidgetFactories f) {
  f.outlinedButton.outlinedButton = ffi.Pointer.fromFunction(outlinedButtonOutlinedButton);
  f.outlinedButton.icon = ffi.Pointer.fromFunction(outlinedButtonIcon);
}
OutlinedButtonObjSt outlinedButtonOutlinedButton(VoidCallbackFFI onPressed, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> clipBehavior, DartDartObj child) {
  final w = OutlinedButton(onPressed: onPressed.toVoidCallbackFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      child: _widgetsMap[child]! as Widget?);
  return _createOutlinedButtonObjSt(w);
}
OutlinedButtonObjSt outlinedButtonIcon(VoidCallbackFFI onPressed, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> icon, DartDartObj label, ffi.Pointer<ffi.Int> iconAlignment) {
  final w = OutlinedButton.icon(onPressed: onPressed.toVoidCallbackFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOrNul(),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      icon: icon.objOrNul(),
      label: _widgetsMap[label]! as Widget,
      iconAlignment: iconAlignment.enumOrNul(IconAlignment.values));
  return _createOutlinedButtonObjSt(w);
}
OutlinedButtonObjSt _createOutlinedButtonObjSt(OutlinedButton? w) {
  final OutlinedButtonObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupSubState(WidgetFactories f) {
  f.subState.subState = ffi.Pointer.fromFunction(subStateSubState);
}
SubStateObjSt subStateSubState(VoidCallbackFFI initStateFn, VoidCallbackDartObjFFI didUpdateWidgetFn, VoidCallbackFFI reassembleFn, VoidCallbackFFI deactivateFn, VoidCallbackFFI activateFn, VoidCallbackFFI disposeFn, DartObjCallbackDartObjFFI buildFn, VoidCallbackFFI didChangeDependenciesFn) {
  final w = SubState(initStateFn: initStateFn.toVoidCallbackFn(),
      didUpdateWidgetFn: didUpdateWidgetFn.toVoidCallbackDartObjFn(),
      reassembleFn: reassembleFn.toVoidCallbackFn(),
      deactivateFn: deactivateFn.toVoidCallbackFn(),
      activateFn: activateFn.toVoidCallbackFn(),
      disposeFn: disposeFn.toVoidCallbackFn(),
      buildFn: buildFn.toDartObjCallbackDartObjFn(),
      didChangeDependenciesFn: didChangeDependenciesFn.toVoidCallbackFn());
  final SubStateObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  final setStateFn = ffi.NativeCallable<ffi.Void Function(ffi.Pointer<ffi.NativeFunction<ffi.Void Function()>>)>.isolateLocal((ffi.Pointer<ffi.NativeFunction<ffi.Void Function()>> cb) => w.setState(cb.asFunction()));
  stObj.setState = setStateFn.nativeFunction;
  final widgetFn = ffi.NativeCallable<DartObj Function()>.isolateLocal(() => _addWidget(w.widget), exceptionalReturn: exception);
  stObj.widget = widgetFn.nativeFunction;
  final mountedFn = ffi.NativeCallable<ffi.Int Function()>.isolateLocal(() => w.mounted.toInt(), exceptionalReturn: exception);
  stObj.mounted = mountedFn.nativeFunction;
  return stObj;
}

void _setupSubStatefulWidget(WidgetFactories f) {
  f.subStatefulWidget.subStatefulWidget = ffi.Pointer.fromFunction(subStatefulWidgetSubStatefulWidget);
}
SubStatefulWidgetObjSt subStatefulWidgetSubStatefulWidget(DartObjCallbackFFI createStateFn) {
  final w = SubStatefulWidget(createStateFn: createStateFn.toDartObjCallbackFn());
  final SubStatefulWidgetObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  return stObj;
}

void _setupSubStatelessWidget(WidgetFactories f) {
  f.subStatelessWidget.subStatelessWidget = ffi.Pointer.fromFunction(subStatelessWidgetSubStatelessWidget);
}
SubStatelessWidgetObjSt subStatelessWidgetSubStatelessWidget(DartObjCallbackDartObjFFI buildFn) {
  final w = SubStatelessWidget(buildFn: buildFn.toDartObjCallbackDartObjFn());
  final SubStatelessWidgetObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  return stObj;
}

ffi.Pointer<WidgetFactories> _setupFactories() {
  final ffi.Pointer<WidgetFactories> fp = calloc<WidgetFactories>();
  final f = fp.ref;
  _setupTextStyle(f);
  _setupText(f);
  _setupCenter(f);
  _setupColumn(f);
  _setupRow(f);
  _setupIconData(f);
  _setupIcon(f);
  _setupColor(f);
  _setupTransform(f);
  _setupOpacity(f);
  _setupStack(f);
  _setupBoxConstraints(f);
  _setupContainer(f);
  _setupStackParentData(f);
  _setupPositioned(f);
  _setupBoxDecoration(f);
  _setupRadius(f);
  _setupBorderRadius(f);
  _setupBoxShadow(f);
  _setupPadding(f);
  _setupEdgeInsets(f);
  _setupBorderSide(f);
  _setupBorder(f);
  _setupRoundedRectangleBorder(f);
  _setupAnimationController(f);
  _setupAnimatedBuilder(f);
  _setupOffset(f);
  _setupCubic(f);
  _setupThreePointCubic(f);
  _setupElasticOutCurve(f);
  _setupElasticInCurve(f);
  _setupElasticInOutCurve(f);
  _setupCurvedAnimation(f);
  _setupSizedBox(f);
  _setupAlignment(f);
  _setupColorScheme(f);
  _setupTextTheme(f);
  _setupThemeData(f);
  _setupMaterialAccentColor(f);
  _setupMaterialColor(f);
  _setupMaterial(f);
  _setupIconButton(f);
  _setupAppBar(f);
  _setupScaffold(f);
  _setupMaterialApp(f);
  _setupFloatingActionButton(f);
  _setupTheme(f);
  _setupElevatedButton(f);
  _setupOutlinedButton(f);
  _setupSubState(f);
  _setupSubStatefulWidget(f);
  _setupSubStatelessWidget(f);
  _setupAlign(f);
  _setupFlex(f);
  _setupBoxParentData(f);
  _setupParentData(f);
  _setupShadow(f);
  _setupShadow(f);
  _setupListenableBuilder(f);
  _setupColorSwatch(f);
  _setupColorSwatch(f);
  return fp;
}
extension on TransitionBuilderFFI {
  TransitionBuilder toTransitionBuilderFn() {
    return (BuildContext context, Widget? child) {
      DartTransitionBuilderFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(context), _addWidget(child));
      return _widgetsMap[dFnRet]! as Widget;
    };
  }
}
extension on ffi.Pointer<TransitionBuilderFFI> {
  TransitionBuilder? toTransitionBuilderFn() => (this != ffi.nullptr) ? this.value.toTransitionBuilderFn() : null;
}

extension on VoidCallbackFFI {
  VoidCallback toVoidCallbackFn() {
    return () {
      DartVoidCallbackFFIFunction dFn = asFunction();
      dFn();
    };
  }
}
extension on ffi.Pointer<VoidCallbackFFI> {
  VoidCallback? toVoidCallbackFn() => (this != ffi.nullptr) ? this.value.toVoidCallbackFn() : null;
}

extension on ValueChangedForBoolFFI {
  ValueChanged<bool> toValueChangedForBoolFn() {
    return (bool value) {
      DartValueChangedForBoolFFIFunction dFn = asFunction();
      dFn(value.toInt());
    };
  }
}
extension on ffi.Pointer<ValueChangedForBoolFFI> {
  ValueChanged<bool>? toValueChangedForBoolFn() => (this != ffi.nullptr) ? this.value.toValueChangedForBoolFn() : null;
}

extension on DrawerCallbackFFI {
  DrawerCallback toDrawerCallbackFn() {
    return (bool isOpened) {
      DartDrawerCallbackFFIFunction dFn = asFunction();
      dFn(isOpened.toInt());
    };
  }
}
extension on ffi.Pointer<DrawerCallbackFFI> {
  DrawerCallback? toDrawerCallbackFn() => (this != ffi.nullptr) ? this.value.toDrawerCallbackFn() : null;
}

extension on GenerateAppTitleFFI {
  GenerateAppTitle toGenerateAppTitleFn() {
    return (BuildContext context) {
      DartGenerateAppTitleFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(context));
      return dFnRet.cast<Utf8>().toDartString();
    };
  }
}
extension on ffi.Pointer<GenerateAppTitleFFI> {
  GenerateAppTitle? toGenerateAppTitleFn() => (this != ffi.nullptr) ? this.value.toGenerateAppTitleFn() : null;
}

extension on VoidCallbackDartObjFFI {
  void Function(T) toVoidCallbackDartObjFn<T>() {
    return (T t) {
      DartVoidCallbackDartObjFFIFunction dFn = asFunction();
      dFn(_addWidget(t));
    };
  }
}
extension on ffi.Pointer<VoidCallbackDartObjFFI> {
  void Function(T)? toVoidCallbackDartObjFn<T>() => (this != ffi.nullptr) ? this.value.toVoidCallbackDartObjFn() : null;
}

extension on DartObjCallbackDartObjFFI {
  Widget Function(BuildContext) toDartObjCallbackDartObjFn() {
    return (BuildContext b) {
      DartDartObjCallbackDartObjFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(b));
      return _widgetsMap[dFnRet]! as Widget;
    };
  }
}
extension on ffi.Pointer<DartObjCallbackDartObjFFI> {
  Widget Function(BuildContext)? toDartObjCallbackDartObjFn() => (this != ffi.nullptr) ? this.value.toDartObjCallbackDartObjFn() : null;
}

extension on DartObjCallbackFFI {
  State<StatefulWidget> Function() toDartObjCallbackFn() {
    return () {
      DartDartObjCallbackFFIFunction dFn = asFunction();
      final dFnRet = dFn();
      return _widgetsMap[dFnRet]! as State<StatefulWidget>;
    };
  }
}
extension on ffi.Pointer<DartObjCallbackFFI> {
  State<StatefulWidget> Function()? toDartObjCallbackFn() => (this != ffi.nullptr) ? this.value.toDartObjCallbackFn() : null;
}

