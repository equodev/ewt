part of 'factories.dart';
void _setupTopFunctions(WidgetFactories f) {
  f.showDialog = ffi.Pointer.fromFunction(dialogShowDialog, exception);
}
int dialogShowDialog(DartDartObj context, WidgetBuilderFFI builder, ffi.Pointer<ffi.Int> barrierDismissible, ffi.Pointer<DartObj> barrierColor, ffi.Pointer<ffi.Char> barrierLabel, ffi.Pointer<ffi.Int> useSafeArea, ffi.Pointer<ffi.Int> useRootNavigator, ffi.Pointer<DartObj> anchorPoint, ffi.Pointer<ffi.Int> traversalEdgeBehavior, ffi.Pointer<ffi.Int> fullscreenDialog, ffi.Pointer<ffi.Int> requestFocus) {
  final w = showDialog(context: _widgetsMap[context]! as BuildContext,
      builder: builder.toWidgetBuilderFn(),
      barrierDismissible: barrierDismissible.boolOr(true),
      barrierColor: barrierColor.objOrNul(),
      barrierLabel: barrierLabel.strOrNul(),
      useSafeArea: useSafeArea.boolOr(true),
      useRootNavigator: useRootNavigator.boolOr(true),
      anchorPoint: anchorPoint.objOrNul(),
      traversalEdgeBehavior: traversalEdgeBehavior.enumOrNul(TraversalEdgeBehavior.values),
      fullscreenDialog: fullscreenDialog.boolOr(false),
      requestFocus: requestFocus.boolOrNul());
  return _addWidget(w);
}
void _setupTextStyle(WidgetFactories f) {
  f.textStyle.textStyle = ffi.Pointer.fromFunction(textStyleTextStyle);
  f.textStyle.lerp = ffi.Pointer.fromFunction(textStyleLerp);
}
TextStyleObjSt textStyleTextStyle(ffi.Pointer<ffi.Int> inherit, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Double> fontSize, ffi.Pointer<DartObj> fontWeight, ffi.Pointer<ffi.Int> fontStyle, ffi.Pointer<ffi.Double> letterSpacing, ffi.Pointer<ffi.Double> wordSpacing, ffi.Pointer<ffi.Int> textBaseline, ffi.Pointer<ffi.Double> height, ffi.Pointer<ffi.Int> leadingDistribution, ffi.Pointer<ArrayC> shadows, ffi.Pointer<DartObj> decoration, ffi.Pointer<DartObj> decorationColor, ffi.Pointer<ffi.Int> decorationStyle, ffi.Pointer<ffi.Double> decorationThickness, ffi.Pointer<ffi.Char> debugLabel, ffi.Pointer<ffi.Char> fontFamily, ffi.Pointer<ffi.Pointer<ffi.Pointer<ffi.Char>>> fontFamilyFallback, ffi.Pointer<ffi.Char> package, ffi.Pointer<ffi.Int> overflow) {
  final w = TextStyle(inherit: inherit.boolOr(true),
      color: color.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      fontSize: fontSize.doubleOrNul(),
      fontWeight: fontWeight.objOrNul(),
      fontStyle: fontStyle.enumOrNul(FontStyle.values),
      letterSpacing: letterSpacing.doubleOrNul(),
      wordSpacing: wordSpacing.doubleOrNul(),
      textBaseline: textBaseline.enumOrNul(TextBaseline.values),
      height: height.doubleOrNul(),
      leadingDistribution: leadingDistribution.enumOrNul(TextLeadingDistribution.values),
      shadows: shadows.listOrNul(),
      decoration: decoration.objOrNul(),
      decorationColor: decorationColor.objOrNul(),
      decorationStyle: decorationStyle.enumOrNul(TextDecorationStyle.values),
      decorationThickness: decorationThickness.doubleOrNul(),
      debugLabel: debugLabel.strOrNul(),
      fontFamily: fontFamily.strOrNul(),
      fontFamilyFallback: fontFamilyFallback.listOrNul(),
      package: package.strOrNul(),
      overflow: overflow.enumOrNul(TextOverflow.values));
  return _createTextStyleObjSt(w);
}
TextStyleObjSt textStyleLerp(DartDartObj a, DartDartObj b, double t) {
  final w = TextStyle.lerp(_widgetsMap[a]! as TextStyle?,
      _widgetsMap[b]! as TextStyle?,
      t);
  return _createTextStyleObjSt(w);
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
  stObj.fontWeight = _addWidget(w.fontWeight);
  stObj.fontStyle = (w.fontStyle != null) ? w.fontStyle!.index : 0;
  stObj.letterSpacing = (w.letterSpacing != null) ? w.letterSpacing! : 0;
  stObj.wordSpacing = (w.wordSpacing != null) ? w.wordSpacing! : 0;
  stObj.textBaseline = (w.textBaseline != null) ? w.textBaseline!.index : 0;
  stObj.height = (w.height != null) ? w.height! : 0;
  stObj.leadingDistribution = (w.leadingDistribution != null) ? w.leadingDistribution!.index : 0;
  stObj.decoration = _addWidget(w.decoration);
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
  f.color.getAlphaFromOpacity = ffi.Pointer.fromFunction(colorGetAlphaFromOpacity, exception);
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
int colorGetAlphaFromOpacity(double opacity) {
  final w = Color.getAlphaFromOpacity(opacity);
  return w;
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

void _setupFontWeight(WidgetFactories f) {
  f.fontWeight.fontWeight = ffi.Pointer.fromFunction(fontWeightFontWeight, exception);
  f.fontWeight.lerp = ffi.Pointer.fromFunction(fontWeightLerp, exception);
}
int fontWeightFontWeight(int value) {
  final w = FontWeight(value);
  return _addWidget(w);
}
int fontWeightLerp(DartDartObj a, DartDartObj b, double t) {
  final w = FontWeight.lerp(_widgetsMap[a]! as FontWeight?,
      _widgetsMap[b]! as FontWeight?,
      t);
  return _addWidget(w);
}

void _setupTextDecoration(WidgetFactories f) {
  f.textDecoration.combine = ffi.Pointer.fromFunction(textDecorationCombine, exception);
  f.textDecoration.none = _addWidget(TextDecoration.none);
  f.textDecoration.underline = _addWidget(TextDecoration.underline);
  f.textDecoration.overline = _addWidget(TextDecoration.overline);
  f.textDecoration.lineThrough = _addWidget(TextDecoration.lineThrough);
}
int textDecorationCombine(ArrayC decorations) {
  final w = TextDecoration.combine(decorations.listOrEmpty());
  return _addWidget(w);
}

void _setupText(WidgetFactories f) {
  f.text.text = ffi.Pointer.fromFunction(textText);
  f.text.rich = ffi.Pointer.fromFunction(textRich);
}
TextObjSt textText(ffi.Pointer<ffi.Char> data, ffi.Pointer<DartObj> style, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> softWrap, ffi.Pointer<ffi.Int> overflow, ffi.Pointer<ffi.Double> textScaleFactor, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Char> semanticsLabel, ffi.Pointer<ffi.Char> semanticsIdentifier, ffi.Pointer<ffi.Int> textWidthBasis, ffi.Pointer<DartObj> selectionColor) {
  final w = Text(data.cast<Utf8>().toDartString(),
      style: style.objOrNul(),
      textAlign: textAlign.enumOrNul(TextAlign.values),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      softWrap: softWrap.boolOrNul(),
      overflow: overflow.enumOrNul(TextOverflow.values),
      textScaleFactor: textScaleFactor.doubleOrNul(),
      maxLines: maxLines.intOrNul(),
      semanticsLabel: semanticsLabel.strOrNul(),
      semanticsIdentifier: semanticsIdentifier.strOrNul(),
      textWidthBasis: textWidthBasis.enumOrNul(TextWidthBasis.values),
      selectionColor: selectionColor.objOrNul());
  return _createTextObjSt(w);
}
TextObjSt textRich(DartDartObj textSpan, ffi.Pointer<DartObj> style, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> softWrap, ffi.Pointer<ffi.Int> overflow, ffi.Pointer<ffi.Double> textScaleFactor, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Char> semanticsLabel, ffi.Pointer<ffi.Char> semanticsIdentifier, ffi.Pointer<ffi.Int> textWidthBasis, ffi.Pointer<DartObj> selectionColor) {
  final w = Text.rich(_widgetsMap[textSpan]! as InlineSpan,
      style: style.objOrNul(),
      textAlign: textAlign.enumOrNul(TextAlign.values),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      softWrap: softWrap.boolOrNul(),
      overflow: overflow.enumOrNul(TextOverflow.values),
      textScaleFactor: textScaleFactor.doubleOrNul(),
      maxLines: maxLines.intOrNul(),
      semanticsLabel: semanticsLabel.strOrNul(),
      semanticsIdentifier: semanticsIdentifier.strOrNul(),
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
  stObj.semanticsIdentifier = (w.semanticsIdentifier != null) ? w.semanticsIdentifier!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.textWidthBasis = (w.textWidthBasis != null) ? w.textWidthBasis!.index : 0;
  stObj.selectionColor = _addWidget(w.selectionColor);
  return stObj;
}

void _setupTextSpan(WidgetFactories f) {
  f.textSpan.textSpan = ffi.Pointer.fromFunction(textSpanTextSpan);
}
TextSpanObjSt textSpanTextSpan(ffi.Pointer<ffi.Char> text, ffi.Pointer<ArrayC> children, ffi.Pointer<DartObj> style, ffi.Pointer<ffi.Char> semanticsLabel, ffi.Pointer<ffi.Char> semanticsIdentifier, ffi.Pointer<ffi.Int> spellOut) {
  final w = TextSpan(text: text.strOrNul(),
      children: children.listOrNul(),
      style: style.objOrNul(),
      semanticsLabel: semanticsLabel.strOrNul(),
      semanticsIdentifier: semanticsIdentifier.strOrNul(),
      spellOut: spellOut.boolOrNul());
  return _createTextSpanObjSt(w);
}
TextSpanObjSt _createTextSpanObjSt(TextSpan? w) {
  final TextSpanObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.text = (w.text != null) ? w.text!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.semanticsLabel = (w.semanticsLabel != null) ? w.semanticsLabel!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.semanticsIdentifier = (w.semanticsIdentifier != null) ? w.semanticsIdentifier!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.spellOut = (w.spellOut != null) ? w.spellOut!.toInt() : 0;
  return stObj;
}

void _setupRichText(WidgetFactories f) {
  f.richText.richText = ffi.Pointer.fromFunction(richTextRichText);
}
RichTextObjSt richTextRichText(DartDartObj text, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> softWrap, ffi.Pointer<ffi.Int> overflow, ffi.Pointer<ffi.Double> textScaleFactor, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Int> textWidthBasis, ffi.Pointer<DartObj> selectionColor) {
  final w = RichText(text: _widgetsMap[text]! as InlineSpan,
      textAlign: textAlign.enumOr(TextAlign.values, TextAlign.start),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      softWrap: softWrap.boolOr(true),
      overflow: overflow.enumOr(TextOverflow.values, TextOverflow.clip),
      textScaleFactor: textScaleFactor.doubleOr(1.0),
      maxLines: maxLines.intOrNul(),
      textWidthBasis: textWidthBasis.enumOr(TextWidthBasis.values, TextWidthBasis.parent),
      selectionColor: selectionColor.objOrNul());
  return _createRichTextObjSt(w);
}
RichTextObjSt _createRichTextObjSt(RichText? w) {
  final RichTextObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.text = _addWidget(w.text);
  stObj.textAlign = w.textAlign.index;
  stObj.textDirection = (w.textDirection != null) ? w.textDirection!.index : 0;
  stObj.softWrap = w.softWrap.toInt();
  stObj.overflow = w.overflow.index;
  stObj.maxLines = (w.maxLines != null) ? w.maxLines! : 0;
  stObj.textWidthBasis = w.textWidthBasis.index;
  stObj.selectionColor = _addWidget(w.selectionColor);
  stObj.textScaleFactor = w.textScaleFactor;
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
  final w = Align(alignment: alignment.objOr(Alignment.center),
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
      children: children.listOrEmpty());
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
      children: children.listOrEmpty());
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
      children: children.listOrEmpty());
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
      fontFamilyFallback: fontFamilyFallback.listOrNul());
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
IconObjSt iconIcon(DartDartObj icon, ffi.Pointer<ffi.Double> size, ffi.Pointer<ffi.Double> fill, ffi.Pointer<ffi.Double> weight, ffi.Pointer<ffi.Double> grade, ffi.Pointer<ffi.Double> opticalSize, ffi.Pointer<DartObj> color, ffi.Pointer<ArrayC> shadows, ffi.Pointer<ffi.Char> semanticLabel, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> applyTextScaling, ffi.Pointer<ffi.Int> blendMode, ffi.Pointer<DartObj> fontWeight) {
  final w = Icon(_widgetsMap[icon]! as IconData?,
      size: size.doubleOrNul(),
      fill: fill.doubleOrNul(),
      weight: weight.doubleOrNul(),
      grade: grade.doubleOrNul(),
      opticalSize: opticalSize.doubleOrNul(),
      color: color.objOrNul(),
      shadows: shadows.listOrNul(),
      semanticLabel: semanticLabel.strOrNul(),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      applyTextScaling: applyTextScaling.boolOrNul(),
      blendMode: blendMode.enumOrNul(BlendMode.values),
      fontWeight: fontWeight.objOrNul());
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
  stObj.fontWeight = _addWidget(w.fontWeight);
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
  final w = Stack(alignment: alignment.objOr(AlignmentDirectional.topStart),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      fit: fit.enumOr(StackFit.values, StackFit.loose),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      children: children.listOrEmpty());
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
BoxConstraintsObjSt boxConstraintsLerp(DartDartObj a, DartDartObj b, double t) {
  final w = BoxConstraints.lerp(_widgetsMap[a]! as BoxConstraints?,
      _widgetsMap[b]! as BoxConstraints?,
      t);
  return _createBoxConstraintsObjSt(w);
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
ContainerObjSt containerContainer(ffi.Pointer<DartObj> alignment, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> color, ffi.Pointer<ffi.Int> isAntiAlias, ffi.Pointer<DartObj> decoration, ffi.Pointer<DartObj> foregroundDecoration, ffi.Pointer<ffi.Double> width, ffi.Pointer<ffi.Double> height, ffi.Pointer<DartObj> constraints, ffi.Pointer<DartObj> margin, ffi.Pointer<DartObj> transformAlignment, ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Int> clipBehavior) {
  final w = Container(alignment: alignment.objOrNul(),
      padding: padding.objOrNul(),
      color: color.objOrNul(),
      isAntiAlias: isAntiAlias.boolOr(true),
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
  stObj.isAntiAlias = w.isAntiAlias.toInt();
  stObj.decoration = _addWidget(w.decoration);
  stObj.foregroundDecoration = _addWidget(w.foregroundDecoration);
  stObj.constraints = _createBoxConstraintsObjSt(w.constraints);
  stObj.margin = _addWidget(w.margin);
  stObj.transformAlignment = _addWidget(w.transformAlignment);
  stObj.clipBehavior = w.clipBehavior.index;
  return stObj;
}

void _setupEdgeInsetsGeometry(WidgetFactories f) {
  f.edgeInsetsGeometry.infinity = _addWidget(EdgeInsetsGeometry.infinity);
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

void _setupFlexParentData(WidgetFactories f) {
  f.flexParentData.flexParentData = ffi.Pointer.fromFunction(flexParentDataFlexParentData, exception);
}
int flexParentDataFlexParentData() {
  final w = FlexParentData();
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
      boxShadow: boxShadow.listOrNul(),
      backgroundBlendMode: backgroundBlendMode.enumOrNul(BlendMode.values),
      shape: shape.enumOr(BoxShape.values, BoxShape.rectangle));
  return _createBoxDecorationObjSt(w);
}
BoxDecorationObjSt boxDecorationLerp(DartDartObj a, DartDartObj b, double t) {
  final w = BoxDecoration.lerp(_widgetsMap[a]! as BoxDecoration?,
      _widgetsMap[b]! as BoxDecoration?,
      t);
  return _createBoxDecorationObjSt(w);
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
  final w = BorderRadius.vertical(top: top.objOr(Radius.zero),
      bottom: bottom.objOr(Radius.zero));
  return _createBorderRadiusObjSt(w);
}
BorderRadiusObjSt borderRadiusHorizontal(ffi.Pointer<DartObj> left, ffi.Pointer<DartObj> right) {
  final w = BorderRadius.horizontal(left: left.objOr(Radius.zero),
      right: right.objOr(Radius.zero));
  return _createBorderRadiusObjSt(w);
}
BorderRadiusObjSt borderRadiusOnly(ffi.Pointer<DartObj> topLeft, ffi.Pointer<DartObj> topRight, ffi.Pointer<DartObj> bottomLeft, ffi.Pointer<DartObj> bottomRight) {
  final w = BorderRadius.only(topLeft: topLeft.objOr(Radius.zero),
      topRight: topRight.objOr(Radius.zero),
      bottomLeft: bottomLeft.objOr(Radius.zero),
      bottomRight: bottomRight.objOr(Radius.zero));
  return _createBorderRadiusObjSt(w);
}
BorderRadiusObjSt borderRadiusLerp(DartDartObj a, DartDartObj b, double t) {
  final w = BorderRadius.lerp(_widgetsMap[a]! as BorderRadius?,
      _widgetsMap[b]! as BorderRadius?,
      t);
  return _createBorderRadiusObjSt(w);
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
  final w = BoxShadow(color: color.objOr(const Color(0xFF000000)),
      offset: offset.objOr(Offset.zero),
      blurRadius: blurRadius.doubleOr(0.0),
      spreadRadius: spreadRadius.doubleOr(0.0),
      blurStyle: blurStyle.enumOr(BlurStyle.values, BlurStyle.normal));
  return _createBoxShadowObjSt(w);
}
BoxShadowObjSt boxShadowLerp(DartDartObj a, DartDartObj b, double t) {
  final w = BoxShadow.lerp(_widgetsMap[a]! as BoxShadow?,
      _widgetsMap[b]! as BoxShadow?,
      t);
  return _createBoxShadowObjSt(w);
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
  f.shadow.convertRadiusToSigma = ffi.Pointer.fromFunction(shadowConvertRadiusToSigma, exceptionDouble);
  f.shadow.lerp = ffi.Pointer.fromFunction(shadowLerp, exception);
}
int shadowShadow(ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> offset, ffi.Pointer<ffi.Double> blurRadius) {
  final w = Shadow(color: color.objOr(const Color(0xFF000000)),
      offset: offset.objOr(Offset.zero),
      blurRadius: blurRadius.doubleOr(0.0));
  return _addWidget(w);
}
double shadowConvertRadiusToSigma(double radius) {
  final w = Shadow.convertRadiusToSigma(radius);
  return w;
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
EdgeInsetsObjSt edgeInsetsLerp(DartDartObj a, DartDartObj b, double t) {
  final w = EdgeInsets.lerp(_widgetsMap[a]! as EdgeInsets?,
      _widgetsMap[b]! as EdgeInsets?,
      t);
  return _createEdgeInsetsObjSt(w);
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
  f.borderSide.canMerge = ffi.Pointer.fromFunction(borderSideCanMerge, exception);
  f.borderSide.lerp = ffi.Pointer.fromFunction(borderSideLerp);
}
BorderSideObjSt borderSideBorderSide(ffi.Pointer<DartObj> color, ffi.Pointer<ffi.Double> width, ffi.Pointer<ffi.Int> style, ffi.Pointer<ffi.Double> strokeAlign) {
  final w = BorderSide(color: color.objOr(const Color(0xFF000000)),
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
int borderSideCanMerge(DartDartObj a, DartDartObj b) {
  final w = BorderSide.canMerge(_widgetsMap[a]! as BorderSide,
      _widgetsMap[b]! as BorderSide);
  return w.toInt();
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
  final w = Border(top: top.objOr(BorderSide.none),
      right: right.objOr(BorderSide.none),
      bottom: bottom.objOr(BorderSide.none),
      left: left.objOr(BorderSide.none));
  return _createBorderObjSt(w);
}
BorderObjSt borderFromBorderSide(DartDartObj side) {
  final w = Border.fromBorderSide(_widgetsMap[side]! as BorderSide);
  return _createBorderObjSt(w);
}
BorderObjSt borderSymmetric(ffi.Pointer<DartObj> vertical, ffi.Pointer<DartObj> horizontal) {
  final w = Border.symmetric(vertical: vertical.objOr(BorderSide.none),
      horizontal: horizontal.objOr(BorderSide.none));
  return _createBorderObjSt(w);
}
BorderObjSt borderAll(ffi.Pointer<DartObj> color, ffi.Pointer<ffi.Double> width, ffi.Pointer<ffi.Int> style, ffi.Pointer<ffi.Double> strokeAlign) {
  final w = Border.all(color: color.objOr(const Color(0xFF000000)),
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
BorderObjSt borderLerp(DartDartObj a, DartDartObj b, double t) {
  final w = Border.lerp(_widgetsMap[a]! as Border?,
      _widgetsMap[b]! as Border?,
      t);
  return _createBorderObjSt(w);
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
  final w = RoundedRectangleBorder(side: side.objOr(BorderSide.none),
      borderRadius: borderRadius.objOr(BorderRadius.zero));
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
  f.animationController.forward = ffi.Pointer.fromFunction(animationControllerForward);
  f.animationController.reverse = ffi.Pointer.fromFunction(animationControllerReverse);
  f.animationController.stop = ffi.Pointer.fromFunction(animationControllerStop);
  f.animationController.repeat = ffi.Pointer.fromFunction(animationControllerRepeat);
  f.animationController.reset = ffi.Pointer.fromFunction(animationControllerReset);
  f.animationController.setDuration = ffi.Pointer.fromFunction(animationControllerSetDuration);
  f.animationController.setReverseDuration = ffi.Pointer.fromFunction(animationControllerSetReverseDuration);
}
int animationControllerAnimationController(ffi.Pointer<ffi.Double> value, ffi.Pointer<DartObj> duration, ffi.Pointer<DartObj> reverseDuration, ffi.Pointer<ffi.Char> debugLabel, ffi.Pointer<ffi.Double> lowerBound, ffi.Pointer<ffi.Double> upperBound, ffi.Pointer<ffi.Int> animationBehavior, DartDartObj vsync) {
  final w = AnimationController(value: value.doubleOrNul(),
      duration: duration.objOrNul(),
      reverseDuration: reverseDuration.objOrNul(),
      debugLabel: debugLabel.strOrNul(),
      lowerBound: lowerBound.doubleOr(0.0),
      upperBound: upperBound.doubleOr(1.0),
      animationBehavior: animationBehavior.enumOr(AnimationBehavior.values, AnimationBehavior.normal),
      vsync: _widgetsMap[vsync]! as TickerProvider);
  return _addWidget(w);
}
int animationControllerUnbounded(ffi.Pointer<ffi.Double> value, ffi.Pointer<DartObj> duration, ffi.Pointer<DartObj> reverseDuration, ffi.Pointer<ffi.Char> debugLabel, DartDartObj vsync, ffi.Pointer<ffi.Int> animationBehavior) {
  final w = AnimationController.unbounded(value: value.doubleOr(0.0),
      duration: duration.objOrNul(),
      reverseDuration: reverseDuration.objOrNul(),
      debugLabel: debugLabel.strOrNul(),
      vsync: _widgetsMap[vsync]! as TickerProvider,
      animationBehavior: animationBehavior.enumOr(AnimationBehavior.values, AnimationBehavior.preserve));
  return _addWidget(w);
}
void animationControllerForward(DartDartObj self) {
  AnimationControllerMethods.forward(_widgetsMap[self]! as AnimationController);
}
void animationControllerReverse(DartDartObj self) {
  AnimationControllerMethods.reverse(_widgetsMap[self]! as AnimationController);
}
void animationControllerStop(DartDartObj self) {
  AnimationControllerMethods.stop(_widgetsMap[self]! as AnimationController);
}
void animationControllerRepeat(DartDartObj self) {
  AnimationControllerMethods.repeat(_widgetsMap[self]! as AnimationController);
}
void animationControllerReset(DartDartObj self) {
  AnimationControllerMethods.reset(_widgetsMap[self]! as AnimationController);
}
void animationControllerSetDuration(DartDartObj self, DartDartObj d) {
  AnimationControllerMethods.setDuration(_widgetsMap[self]! as AnimationController,
      _widgetsMap[d]! as Duration);
}
void animationControllerSetReverseDuration(DartDartObj self, DartDartObj d) {
  AnimationControllerMethods.setReverseDuration(_widgetsMap[self]! as AnimationController,
      _widgetsMap[d]! as Duration);
}

void _setupDuration(WidgetFactories f) {
  f.duration.duration = ffi.Pointer.fromFunction(durationDuration, exception);
}
int durationDuration(ffi.Pointer<ffi.Int> days, ffi.Pointer<ffi.Int> hours, ffi.Pointer<ffi.Int> minutes, ffi.Pointer<ffi.Int> seconds, ffi.Pointer<ffi.Int> milliseconds, ffi.Pointer<ffi.Int> microseconds) {
  final w = Duration(days: days.intOr(0),
      hours: hours.intOr(0),
      minutes: minutes.intOr(0),
      seconds: seconds.intOr(0),
      milliseconds: milliseconds.intOr(0),
      microseconds: microseconds.intOr(0));
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
  stObj.animation = _addWidget(w.animation);
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

void _setupCurves(WidgetFactories f) {
  f.curves.linear = _addWidget(Curves.linear);
  f.curves.decelerate = _addWidget(Curves.decelerate);
  f.curves.bounceIn = _addWidget(Curves.bounceIn);
  f.curves.bounceOut = _addWidget(Curves.bounceOut);
  f.curves.bounceInOut = _addWidget(Curves.bounceInOut);
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
AlignmentObjSt alignmentLerp(DartDartObj a, DartDartObj b, double t) {
  final w = Alignment.lerp(_widgetsMap[a]! as Alignment?,
      _widgetsMap[b]! as Alignment?,
      t);
  return _createAlignmentObjSt(w);
}
AlignmentObjSt _createAlignmentObjSt(Alignment? w) {
  final AlignmentObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.x = w.x;
  stObj.y = w.y;
  return stObj;
}

void _setupAlignmentDirectional(WidgetFactories f) {
  f.alignmentDirectional.alignmentDirectional = ffi.Pointer.fromFunction(alignmentDirectionalAlignmentDirectional);
  f.alignmentDirectional.lerp = ffi.Pointer.fromFunction(alignmentDirectionalLerp);
}
AlignmentDirectionalObjSt alignmentDirectionalAlignmentDirectional(double start, double y) {
  final w = AlignmentDirectional(start,
      y);
  return _createAlignmentDirectionalObjSt(w);
}
AlignmentDirectionalObjSt alignmentDirectionalLerp(DartDartObj a, DartDartObj b, double t) {
  final w = AlignmentDirectional.lerp(_widgetsMap[a]! as AlignmentDirectional?,
      _widgetsMap[b]! as AlignmentDirectional?,
      t);
  return _createAlignmentDirectionalObjSt(w);
}
AlignmentDirectionalObjSt _createAlignmentDirectionalObjSt(AlignmentDirectional? w) {
  final AlignmentDirectionalObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.start = w.start;
  stObj.y = w.y;
  return stObj;
}

void _setupMouseRegion(WidgetFactories f) {
  f.mouseRegion.mouseRegion = ffi.Pointer.fromFunction(mouseRegionMouseRegion);
}
MouseRegionObjSt mouseRegionMouseRegion(ffi.Pointer<ffi.Int> opaque, ffi.Pointer<ffi.Int> hitTestBehavior, ffi.Pointer<DartObj> child) {
  final w = MouseRegion(opaque: opaque.boolOr(true),
      hitTestBehavior: hitTestBehavior.enumOrNul(HitTestBehavior.values),
      child: child.objOrNul());
  return _createMouseRegionObjSt(w);
}
MouseRegionObjSt _createMouseRegionObjSt(MouseRegion? w) {
  final MouseRegionObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.opaque = w.opaque.toInt();
  stObj.hitTestBehavior = (w.hitTestBehavior != null) ? w.hitTestBehavior!.index : 0;
  return stObj;
}

void _setupExpanded(WidgetFactories f) {
  f.expanded.expanded = ffi.Pointer.fromFunction(expandedExpanded);
}
ExpandedObjSt expandedExpanded(ffi.Pointer<ffi.Int> flex, DartDartObj child) {
  final w = Expanded(flex: flex.intOr(1),
      child: _widgetsMap[child]! as Widget);
  return _createExpandedObjSt(w);
}
ExpandedObjSt _createExpandedObjSt(Expanded? w) {
  final ExpandedObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupFlexible(WidgetFactories f) {
  f.flexible.flexible = ffi.Pointer.fromFunction(flexibleFlexible);
}
FlexibleObjSt flexibleFlexible(ffi.Pointer<ffi.Int> flex, ffi.Pointer<ffi.Int> fit, DartDartObj child) {
  final w = Flexible(flex: flex.intOr(1),
      fit: fit.enumOr(FlexFit.values, FlexFit.loose),
      child: _widgetsMap[child]! as Widget);
  return _createFlexibleObjSt(w);
}
FlexibleObjSt _createFlexibleObjSt(Flexible? w) {
  final FlexibleObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.flex = w.flex;
  stObj.fit = w.fit.index;
  return stObj;
}

void _setupSafeArea(WidgetFactories f) {
  f.safeArea.safeArea = ffi.Pointer.fromFunction(safeAreaSafeArea);
}
SafeAreaObjSt safeAreaSafeArea(ffi.Pointer<ffi.Int> left, ffi.Pointer<ffi.Int> top, ffi.Pointer<ffi.Int> right, ffi.Pointer<ffi.Int> bottom, ffi.Pointer<DartObj> minimum, ffi.Pointer<ffi.Int> maintainBottomViewPadding, DartDartObj child) {
  final w = SafeArea(left: left.boolOr(true),
      top: top.boolOr(true),
      right: right.boolOr(true),
      bottom: bottom.boolOr(true),
      minimum: minimum.objOr(EdgeInsets.zero),
      maintainBottomViewPadding: maintainBottomViewPadding.boolOr(false),
      child: _widgetsMap[child]! as Widget);
  return _createSafeAreaObjSt(w);
}
SafeAreaObjSt _createSafeAreaObjSt(SafeArea? w) {
  final SafeAreaObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.left = w.left.toInt();
  stObj.top = w.top.toInt();
  stObj.right = w.right.toInt();
  stObj.bottom = w.bottom.toInt();
  stObj.minimum = _createEdgeInsetsObjSt(w.minimum);
  stObj.maintainBottomViewPadding = w.maintainBottomViewPadding.toInt();
  stObj.child = _addWidget(w.child);
  return stObj;
}

void _setupRotationTransition(WidgetFactories f) {
  f.rotationTransition.rotationTransition = ffi.Pointer.fromFunction(rotationTransitionRotationTransition);
}
RotationTransitionObjSt rotationTransitionRotationTransition(DartDartObj turns, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Int> filterQuality, ffi.Pointer<DartObj> child) {
  final w = RotationTransition(turns: _widgetsMap[turns]! as Animation<double>,
      alignment: alignment.objOr(Alignment.center),
      filterQuality: filterQuality.enumOrNul(FilterQuality.values),
      child: child.objOrNul());
  return _createRotationTransitionObjSt(w);
}
RotationTransitionObjSt _createRotationTransitionObjSt(RotationTransition? w) {
  final RotationTransitionObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.turns = _addWidget(w.turns);
  return stObj;
}

void _setupFadeTransition(WidgetFactories f) {
  f.fadeTransition.fadeTransition = ffi.Pointer.fromFunction(fadeTransitionFadeTransition);
}
FadeTransitionObjSt fadeTransitionFadeTransition(DartDartObj opacity, ffi.Pointer<ffi.Int> alwaysIncludeSemantics, ffi.Pointer<DartObj> child) {
  final w = FadeTransition(opacity: _widgetsMap[opacity]! as Animation<double>,
      alwaysIncludeSemantics: alwaysIncludeSemantics.boolOr(false),
      child: child.objOrNul());
  return _createFadeTransitionObjSt(w);
}
FadeTransitionObjSt _createFadeTransitionObjSt(FadeTransition? w) {
  final FadeTransitionObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.opacity = _addWidget(w.opacity);
  stObj.alwaysIncludeSemantics = w.alwaysIncludeSemantics.toInt();
  return stObj;
}

void _setupScaleTransition(WidgetFactories f) {
  f.scaleTransition.scaleTransition = ffi.Pointer.fromFunction(scaleTransitionScaleTransition);
}
ScaleTransitionObjSt scaleTransitionScaleTransition(DartDartObj scale, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Int> filterQuality, ffi.Pointer<DartObj> child) {
  final w = ScaleTransition(scale: _widgetsMap[scale]! as Animation<double>,
      alignment: alignment.objOr(Alignment.center),
      filterQuality: filterQuality.enumOrNul(FilterQuality.values),
      child: child.objOrNul());
  return _createScaleTransitionObjSt(w);
}
ScaleTransitionObjSt _createScaleTransitionObjSt(ScaleTransition? w) {
  final ScaleTransitionObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.scale = _addWidget(w.scale);
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
      primary: primary.objOr(const Color(0xff6200ee)),
      onPrimary: onPrimary.objOr(Colors.white),
      primaryContainer: primaryContainer.objOrNul(),
      onPrimaryContainer: onPrimaryContainer.objOrNul(),
      primaryFixed: primaryFixed.objOrNul(),
      primaryFixedDim: primaryFixedDim.objOrNul(),
      onPrimaryFixed: onPrimaryFixed.objOrNul(),
      onPrimaryFixedVariant: onPrimaryFixedVariant.objOrNul(),
      secondary: secondary.objOr(const Color(0xff03dac6)),
      onSecondary: onSecondary.objOr(Colors.black),
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
      error: error.objOr(const Color(0xffb00020)),
      onError: onError.objOr(Colors.white),
      errorContainer: errorContainer.objOrNul(),
      onErrorContainer: onErrorContainer.objOrNul(),
      surface: surface.objOr(Colors.white),
      onSurface: onSurface.objOr(Colors.black),
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
      primary: primary.objOr(const Color(0xffbb86fc)),
      onPrimary: onPrimary.objOr(Colors.black),
      primaryContainer: primaryContainer.objOrNul(),
      onPrimaryContainer: onPrimaryContainer.objOrNul(),
      primaryFixed: primaryFixed.objOrNul(),
      primaryFixedDim: primaryFixedDim.objOrNul(),
      onPrimaryFixed: onPrimaryFixed.objOrNul(),
      onPrimaryFixedVariant: onPrimaryFixedVariant.objOrNul(),
      secondary: secondary.objOr(const Color(0xff03dac6)),
      onSecondary: onSecondary.objOr(Colors.black),
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
      error: error.objOr(const Color(0xffcf6679)),
      onError: onError.objOr(Colors.black),
      errorContainer: errorContainer.objOrNul(),
      onErrorContainer: onErrorContainer.objOrNul(),
      surface: surface.objOr(const Color(0xff121212)),
      onSurface: onSurface.objOr(Colors.white),
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
      primary: primary.objOr(const Color(0xff0000ba)),
      onPrimary: onPrimary.objOr(Colors.white),
      primaryContainer: primaryContainer.objOrNul(),
      onPrimaryContainer: onPrimaryContainer.objOrNul(),
      primaryFixed: primaryFixed.objOrNul(),
      primaryFixedDim: primaryFixedDim.objOrNul(),
      onPrimaryFixed: onPrimaryFixed.objOrNul(),
      onPrimaryFixedVariant: onPrimaryFixedVariant.objOrNul(),
      secondary: secondary.objOr(const Color(0xff66fff9)),
      onSecondary: onSecondary.objOr(Colors.black),
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
      error: error.objOr(const Color(0xff790000)),
      onError: onError.objOr(Colors.white),
      errorContainer: errorContainer.objOrNul(),
      onErrorContainer: onErrorContainer.objOrNul(),
      surface: surface.objOr(Colors.white),
      onSurface: onSurface.objOr(Colors.black),
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
      primary: primary.objOr(const Color(0xffefb7ff)),
      onPrimary: onPrimary.objOr(Colors.black),
      primaryContainer: primaryContainer.objOrNul(),
      onPrimaryContainer: onPrimaryContainer.objOrNul(),
      primaryFixed: primaryFixed.objOrNul(),
      primaryFixedDim: primaryFixedDim.objOrNul(),
      onPrimaryFixed: onPrimaryFixed.objOrNul(),
      onPrimaryFixedVariant: onPrimaryFixedVariant.objOrNul(),
      secondary: secondary.objOr(const Color(0xff66fff9)),
      onSecondary: onSecondary.objOr(Colors.black),
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
      error: error.objOr(const Color(0xff9b374d)),
      onError: onError.objOr(Colors.black),
      errorContainer: errorContainer.objOrNul(),
      onErrorContainer: onErrorContainer.objOrNul(),
      surface: surface.objOr(const Color(0xff121212)),
      onSurface: onSurface.objOr(Colors.white),
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
  final w = ColorScheme.fromSwatch(primarySwatch: primarySwatch.objOr(Colors.blue),
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
ColorSwatchObjSt colorSwatchLerp(DartDartObj a, DartDartObj b, double t) {
  final w = ColorSwatch.lerp(_widgetsMap[a]! as ColorSwatch,
      _widgetsMap[b]! as ColorSwatch,
      t);
  return _createColorSwatchObjSt(w);
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

void _setupVisualDensity(WidgetFactories f) {
  f.visualDensity.visualDensity = ffi.Pointer.fromFunction(visualDensityVisualDensity);
  f.visualDensity.defaultDensityForPlatform = ffi.Pointer.fromFunction(visualDensityDefaultDensityForPlatform);
  f.visualDensity.lerp = ffi.Pointer.fromFunction(visualDensityLerp);
}
VisualDensityObjSt visualDensityVisualDensity(ffi.Pointer<ffi.Double> horizontal, ffi.Pointer<ffi.Double> vertical) {
  final w = VisualDensity(horizontal: horizontal.doubleOr(0.0),
      vertical: vertical.doubleOr(0.0));
  return _createVisualDensityObjSt(w);
}
VisualDensityObjSt visualDensityDefaultDensityForPlatform(int platform) {
  final w = VisualDensity.defaultDensityForPlatform(_widgetsMap[platform]! as TargetPlatform);
  return _createVisualDensityObjSt(w);
}
VisualDensityObjSt visualDensityLerp(DartDartObj a, DartDartObj b, double t) {
  final w = VisualDensity.lerp(_widgetsMap[a]! as VisualDensity,
      _widgetsMap[b]! as VisualDensity,
      t);
  return _createVisualDensityObjSt(w);
}
VisualDensityObjSt _createVisualDensityObjSt(VisualDensity? w) {
  final VisualDensityObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.horizontal = w.horizontal;
  stObj.vertical = w.vertical;
  stObj.baseSizeAdjustment = _addWidget(w.baseSizeAdjustment);
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
ThemeDataObjSt themeDataThemeData(ffi.Pointer<ffi.Int> applyElevationOverlayColor, ffi.Pointer<DartObj> inputDecorationTheme, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<ffi.Int> platform, ffi.Pointer<ffi.Int> useMaterial3, ffi.Pointer<ffi.Int> useSystemColors, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<DartObj> colorScheme, ffi.Pointer<ffi.Int> brightness, ffi.Pointer<DartObj> colorSchemeSeed, ffi.Pointer<DartObj> canvasColor, ffi.Pointer<DartObj> cardColor, ffi.Pointer<DartObj> disabledColor, ffi.Pointer<DartObj> dividerColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> highlightColor, ffi.Pointer<DartObj> hintColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> primaryColor, ffi.Pointer<DartObj> primaryColorDark, ffi.Pointer<DartObj> primaryColorLight, ffi.Pointer<DartObj> primarySwatch, ffi.Pointer<DartObj> scaffoldBackgroundColor, ffi.Pointer<DartObj> secondaryHeaderColor, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> unselectedWidgetColor, ffi.Pointer<ffi.Char> fontFamily, ffi.Pointer<ffi.Pointer<ffi.Pointer<ffi.Char>>> fontFamilyFallback, ffi.Pointer<ffi.Char> package, ffi.Pointer<DartObj> primaryTextTheme, ffi.Pointer<DartObj> textTheme, ffi.Pointer<DartObj> appBarTheme, ffi.Pointer<DartObj> dialogBackgroundColor, ffi.Pointer<DartObj> indicatorColor) {
  final w = ThemeData(applyElevationOverlayColor: applyElevationOverlayColor.boolOrNul(),
      inputDecorationTheme: inputDecorationTheme.objOrNul(),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      platform: platform.enumOrNul(TargetPlatform.values),
      useMaterial3: useMaterial3.boolOrNul(),
      useSystemColors: useSystemColors.boolOrNul(),
      visualDensity: visualDensity.objOrNul(),
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
      fontFamilyFallback: fontFamilyFallback.listOrNul(),
      package: package.strOrNul(),
      primaryTextTheme: primaryTextTheme.objOrNul(),
      textTheme: textTheme.objOrNul(),
      appBarTheme: appBarTheme.objOrNul(),
      dialogBackgroundColor: dialogBackgroundColor.objOrNul(),
      indicatorColor: indicatorColor.objOrNul());
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
  stObj.visualDensity = _createVisualDensityObjSt(w.visualDensity);
  stObj.canvasColor = _addWidget(w.canvasColor);
  stObj.cardColor = _addWidget(w.cardColor);
  stObj.colorScheme = _createColorSchemeObjSt(w.colorScheme);
  stObj.disabledColor = _addWidget(w.disabledColor);
  stObj.dividerColor = _addWidget(w.dividerColor);
  stObj.focusColor = _addWidget(w.focusColor);
  stObj.highlightColor = _addWidget(w.highlightColor);
  stObj.hintColor = _addWidget(w.hintColor);
  stObj.hoverColor = _addWidget(w.hoverColor);
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
  stObj.indicatorColor = _addWidget(w.indicatorColor);
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
MaterialObjSt materialMaterial(ffi.Pointer<ffi.Int> type, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<DartObj> textStyle, ffi.Pointer<DartObj> borderRadius, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> borderOnForeground, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> animationDuration, ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Int> animateColor) {
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
      animationDuration: animationDuration.objOr(kThemeChangeDuration),
      child: child.objOrNul(),
      animateColor: animateColor.boolOr(false));
  return _createMaterialObjSt(w);
}
MaterialObjSt _createMaterialObjSt(Material? w) {
  final MaterialObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.type = w.type.index;
  stObj.animateColor = w.animateColor.toInt();
  stObj.elevation = w.elevation;
  stObj.color = _addWidget(w.color);
  stObj.shadowColor = _addWidget(w.shadowColor);
  stObj.surfaceTintColor = _addWidget(w.surfaceTintColor);
  stObj.textStyle = _createTextStyleObjSt(w.textStyle);
  stObj.shape = _addWidget(w.shape);
  stObj.borderOnForeground = w.borderOnForeground.toInt();
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.animationDuration = _addWidget(w.animationDuration);
  stObj.borderRadius = _addWidget(w.borderRadius);
  return stObj;
}

void _setupIconButton(WidgetFactories f) {
  f.iconButton.iconButton = ffi.Pointer.fromFunction(iconButtonIconButton);
  f.iconButton.filled = ffi.Pointer.fromFunction(iconButtonFilled);
  f.iconButton.filledTonal = ffi.Pointer.fromFunction(iconButtonFilledTonal);
  f.iconButton.outlined = ffi.Pointer.fromFunction(iconButtonOutlined);
}
IconButtonObjSt iconButtonIconButton(ffi.Pointer<ffi.Double> iconSize, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> highlightColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> disabledColor, VoidCallbackFFI onPressed, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<DartObj> constraints, ffi.Pointer<ffi.Int> isSelected, ffi.Pointer<DartObj> selectedIcon, DartDartObj icon) {
  final w = IconButton(iconSize: iconSize.doubleOrNul(),
      visualDensity: visualDensity.objOrNul(),
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
IconButtonObjSt iconButtonFilled(ffi.Pointer<ffi.Double> iconSize, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> highlightColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> disabledColor, VoidCallbackFFI onPressed, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<DartObj> constraints, ffi.Pointer<ffi.Int> isSelected, ffi.Pointer<DartObj> selectedIcon, DartDartObj icon) {
  final w = IconButton.filled(iconSize: iconSize.doubleOrNul(),
      visualDensity: visualDensity.objOrNul(),
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
IconButtonObjSt iconButtonFilledTonal(ffi.Pointer<ffi.Double> iconSize, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> highlightColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> disabledColor, VoidCallbackFFI onPressed, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<DartObj> constraints, ffi.Pointer<ffi.Int> isSelected, ffi.Pointer<DartObj> selectedIcon, DartDartObj icon) {
  final w = IconButton.filledTonal(iconSize: iconSize.doubleOrNul(),
      visualDensity: visualDensity.objOrNul(),
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
IconButtonObjSt iconButtonOutlined(ffi.Pointer<ffi.Double> iconSize, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> highlightColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> disabledColor, VoidCallbackFFI onPressed, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<DartObj> constraints, ffi.Pointer<ffi.Int> isSelected, ffi.Pointer<DartObj> selectedIcon, DartDartObj icon) {
  final w = IconButton.outlined(iconSize: iconSize.doubleOrNul(),
      visualDensity: visualDensity.objOrNul(),
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
  stObj.visualDensity = _createVisualDensityObjSt(w.visualDensity);
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
AppBarObjSt appBarAppBar(ffi.Pointer<DartObj> leading, ffi.Pointer<ffi.Int> automaticallyImplyLeading, ffi.Pointer<DartObj> title, ffi.Pointer<ArrayC> actions, ffi.Pointer<ffi.Int> automaticallyImplyActions, ffi.Pointer<DartObj> flexibleSpace, ffi.Pointer<DartObj> bottom, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<ffi.Double> scrolledUnderElevation, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<DartObj> shape, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> foregroundColor, ffi.Pointer<ffi.Int> primary, ffi.Pointer<ffi.Int> centerTitle, ffi.Pointer<ffi.Int> excludeHeaderSemantics, ffi.Pointer<ffi.Double> titleSpacing, ffi.Pointer<ffi.Double> toolbarOpacity, ffi.Pointer<ffi.Double> bottomOpacity, ffi.Pointer<ffi.Double> toolbarHeight, ffi.Pointer<ffi.Double> leadingWidth, ffi.Pointer<DartObj> toolbarTextStyle, ffi.Pointer<DartObj> titleTextStyle, ffi.Pointer<ffi.Int> forceMaterialTransparency, ffi.Pointer<ffi.Int> useDefaultSemanticsOrder, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> actionsPadding, ffi.Pointer<ffi.Int> animateColor) {
  final w = AppBar(leading: leading.objOrNul(),
      automaticallyImplyLeading: automaticallyImplyLeading.boolOr(true),
      title: title.objOrNul(),
      actions: actions.listOrNul(),
      automaticallyImplyActions: automaticallyImplyActions.boolOr(true),
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
      useDefaultSemanticsOrder: useDefaultSemanticsOrder.boolOr(true),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      actionsPadding: actionsPadding.objOrNul(),
      animateColor: animateColor.boolOr(false));
  return _createAppBarObjSt(w);
}
AppBarObjSt _createAppBarObjSt(AppBar? w) {
  final AppBarObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.leading = _addWidget(w.leading);
  stObj.automaticallyImplyLeading = w.automaticallyImplyLeading.toInt();
  stObj.title = _addWidget(w.title);
  stObj.automaticallyImplyActions = w.automaticallyImplyActions.toInt();
  stObj.flexibleSpace = _addWidget(w.flexibleSpace);
  stObj.bottom = _addWidget(w.bottom);
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
  stObj.useDefaultSemanticsOrder = w.useDefaultSemanticsOrder.toInt();
  stObj.clipBehavior = (w.clipBehavior != null) ? w.clipBehavior!.index : 0;
  stObj.actionsPadding = _addWidget(w.actionsPadding);
  stObj.animateColor = w.animateColor.toInt();
  return stObj;
}

void _setupScaffold(WidgetFactories f) {
  f.scaffold.scaffold = ffi.Pointer.fromFunction(scaffoldScaffold);
  f.scaffold.geometryOf = ffi.Pointer.fromFunction(scaffoldGeometryOf, exception);
  f.scaffold.hasDrawer = ffi.Pointer.fromFunction(scaffoldHasDrawer, exception);
}
ScaffoldObjSt scaffoldScaffold(ffi.Pointer<DartObj> appBar, ffi.Pointer<DartObj> body, ffi.Pointer<DartObj> floatingActionButton, ffi.Pointer<ArrayC> persistentFooterButtons, ffi.Pointer<DartObj> persistentFooterAlignment, ffi.Pointer<DartObj> persistentFooterDecoration, ffi.Pointer<DartObj> drawer, ffi.Pointer<DrawerCallbackFFI> onDrawerChanged, ffi.Pointer<DartObj> endDrawer, ffi.Pointer<DrawerCallbackFFI> onEndDrawerChanged, ffi.Pointer<DartObj> bottomNavigationBar, ffi.Pointer<DartObj> bottomSheet, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Int> resizeToAvoidBottomInset, ffi.Pointer<ffi.Int> primary, ffi.Pointer<ffi.Int> drawerDragStartBehavior, ffi.Pointer<ffi.Int> extendBody, ffi.Pointer<ffi.Int> drawerBarrierDismissible, ffi.Pointer<ffi.Int> extendBodyBehindAppBar, ffi.Pointer<DartObj> drawerScrimColor, ffi.Pointer<DartObjCallbackDartObjDartObjFFI> bottomSheetScrimBuilder, ffi.Pointer<ffi.Double> drawerEdgeDragWidth, ffi.Pointer<ffi.Int> drawerEnableOpenDragGesture, ffi.Pointer<ffi.Int> endDrawerEnableOpenDragGesture, ffi.Pointer<ffi.Char> restorationId) {
  final w = Scaffold(appBar: appBar.objOrNul(),
      body: body.objOrNul(),
      floatingActionButton: floatingActionButton.objOrNul(),
      persistentFooterButtons: persistentFooterButtons.listOrNul(),
      persistentFooterAlignment: persistentFooterAlignment.objOr(AlignmentDirectional.centerEnd),
      persistentFooterDecoration: persistentFooterDecoration.objOrNul(),
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
      drawerBarrierDismissible: drawerBarrierDismissible.boolOr(true),
      extendBodyBehindAppBar: extendBodyBehindAppBar.boolOr(false),
      drawerScrimColor: drawerScrimColor.objOrNul(),
      bottomSheetScrimBuilder: (bottomSheetScrimBuilder.toDartObjCallbackDartObjDartObjFn() ?? (p0, p1) => null),
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
int scaffoldHasDrawer(DartDartObj context, ffi.Pointer<ffi.Int> registerForUpdates) {
  final w = Scaffold.hasDrawer(_widgetsMap[context]! as BuildContext,
      registerForUpdates: registerForUpdates.boolOr(true));
  return w.toInt();
}
ScaffoldObjSt _createScaffoldObjSt(Scaffold? w) {
  final ScaffoldObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.extendBody = w.extendBody.toInt();
  stObj.drawerBarrierDismissible = w.drawerBarrierDismissible.toInt();
  stObj.extendBodyBehindAppBar = w.extendBodyBehindAppBar.toInt();
  stObj.appBar = _addWidget(w.appBar);
  stObj.body = _addWidget(w.body);
  stObj.floatingActionButton = _addWidget(w.floatingActionButton);
  stObj.persistentFooterAlignment = _createAlignmentDirectionalObjSt(w.persistentFooterAlignment);
  stObj.persistentFooterDecoration = _createBoxDecorationObjSt(w.persistentFooterDecoration);
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
MaterialAppObjSt materialAppMaterialApp(ffi.Pointer<DartObj> home, ffi.Pointer<ffi.Char> initialRoute, ffi.Pointer<TransitionBuilderFFI> builder, ffi.Pointer<ffi.Char> title, ffi.Pointer<GenerateAppTitleFFI> onGenerateTitle, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> theme, ffi.Pointer<DartObj> darkTheme, ffi.Pointer<DartObj> highContrastTheme, ffi.Pointer<DartObj> highContrastDarkTheme, ffi.Pointer<ffi.Int> themeMode, ffi.Pointer<DartObj> themeAnimationDuration, ffi.Pointer<DartObj> themeAnimationCurve, ffi.Pointer<ffi.Int> debugShowMaterialGrid, ffi.Pointer<ffi.Int> showPerformanceOverlay, ffi.Pointer<ffi.Int> checkerboardRasterCacheImages, ffi.Pointer<ffi.Int> checkerboardOffscreenLayers, ffi.Pointer<ffi.Int> showSemanticsDebugger, ffi.Pointer<ffi.Int> debugShowCheckedModeBanner, ffi.Pointer<ffi.Char> restorationScopeId, ffi.Pointer<ffi.Int> useInheritedMediaQuery) {
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
      themeAnimationDuration: themeAnimationDuration.objOr(kThemeAnimationDuration),
      themeAnimationCurve: themeAnimationCurve.objOr(Curves.linear),
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
MaterialAppObjSt materialAppRouter(ffi.Pointer<TransitionBuilderFFI> builder, ffi.Pointer<ffi.Char> title, ffi.Pointer<GenerateAppTitleFFI> onGenerateTitle, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> theme, ffi.Pointer<DartObj> darkTheme, ffi.Pointer<DartObj> highContrastTheme, ffi.Pointer<DartObj> highContrastDarkTheme, ffi.Pointer<ffi.Int> themeMode, ffi.Pointer<DartObj> themeAnimationDuration, ffi.Pointer<DartObj> themeAnimationCurve, ffi.Pointer<ffi.Int> debugShowMaterialGrid, ffi.Pointer<ffi.Int> showPerformanceOverlay, ffi.Pointer<ffi.Int> checkerboardRasterCacheImages, ffi.Pointer<ffi.Int> checkerboardOffscreenLayers, ffi.Pointer<ffi.Int> showSemanticsDebugger, ffi.Pointer<ffi.Int> debugShowCheckedModeBanner, ffi.Pointer<ffi.Char> restorationScopeId, ffi.Pointer<ffi.Int> useInheritedMediaQuery) {
  final w = MaterialApp.router(builder: builder.toTransitionBuilderFn(),
      title: title.strOrNul(),
      onGenerateTitle: onGenerateTitle.toGenerateAppTitleFn(),
      color: color.objOrNul(),
      theme: theme.objOrNul(),
      darkTheme: darkTheme.objOrNul(),
      highContrastTheme: highContrastTheme.objOrNul(),
      highContrastDarkTheme: highContrastDarkTheme.objOrNul(),
      themeMode: themeMode.enumOrNul(ThemeMode.values),
      themeAnimationDuration: themeAnimationDuration.objOr(kThemeAnimationDuration),
      themeAnimationCurve: themeAnimationCurve.objOr(Curves.linear),
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
  stObj.themeAnimationDuration = _addWidget(w.themeAnimationDuration);
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
  f.theme.brightnessOf = ffi.Pointer.fromFunction(themeBrightnessOf, exception);
  f.theme.maybeBrightnessOf = ffi.Pointer.fromFunction(themeMaybeBrightnessOf, exception);
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
int themeBrightnessOf(DartDartObj context) {
  final w = Theme.brightnessOf(_widgetsMap[context]! as BuildContext);
  return w.index;
}
int themeMaybeBrightnessOf(DartDartObj context) {
  final w = Theme.maybeBrightnessOf(_widgetsMap[context]! as BuildContext);
  return (w != null) ? w!.index : 0;
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
      autofocus: autofocus.boolOr(false),
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
      autofocus: autofocus.boolOr(false),
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

void _setupTextButton(WidgetFactories f) {
  f.textButton.textButton = ffi.Pointer.fromFunction(textButtonTextButton);
  f.textButton.icon = ffi.Pointer.fromFunction(textButtonIcon);
}
TextButtonObjSt textButtonTextButton(VoidCallbackFFI onPressed, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> isSemanticButton, DartDartObj child) {
  final w = TextButton(onPressed: onPressed.toVoidCallbackFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      isSemanticButton: isSemanticButton.boolOrNul(),
      child: _widgetsMap[child]! as Widget);
  return _createTextButtonObjSt(w);
}
TextButtonObjSt textButtonIcon(VoidCallbackFFI onPressed, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> icon, DartDartObj label, ffi.Pointer<ffi.Int> iconAlignment) {
  final w = TextButton.icon(onPressed: onPressed.toVoidCallbackFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      icon: icon.objOrNul(),
      label: _widgetsMap[label]! as Widget,
      iconAlignment: iconAlignment.enumOrNul(IconAlignment.values));
  return _createTextButtonObjSt(w);
}
TextButtonObjSt _createTextButtonObjSt(TextButton? w) {
  final TextButtonObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupNavigatorState(WidgetFactories f) {
  f.navigatorState.navigatorState = ffi.Pointer.fromFunction(navigatorStateNavigatorState, exception);
}
int navigatorStateNavigatorState() {
  final w = NavigatorState();
  return _addWidget(w);
}

void _setupNavigator(WidgetFactories f) {
  f.navigator.navigator = ffi.Pointer.fromFunction(navigatorNavigator);
  f.navigator.pushNamed = ffi.Pointer.fromFunction(navigatorPushNamed, exception);
  f.navigator.restorablePushNamed = ffi.Pointer.fromFunction(navigatorRestorablePushNamed);
  f.navigator.pushReplacementNamed = ffi.Pointer.fromFunction(navigatorPushReplacementNamed, exception);
  f.navigator.restorablePushReplacementNamed = ffi.Pointer.fromFunction(navigatorRestorablePushReplacementNamed);
  f.navigator.popAndPushNamed = ffi.Pointer.fromFunction(navigatorPopAndPushNamed, exception);
  f.navigator.restorablePopAndPushNamed = ffi.Pointer.fromFunction(navigatorRestorablePopAndPushNamed);
  f.navigator.canPop = ffi.Pointer.fromFunction(navigatorCanPop, exception);
  f.navigator.maybePop = ffi.Pointer.fromFunction(navigatorMaybePop, exception);
  f.navigator.pop = ffi.Pointer.fromFunction(navigatorPop);
  f.navigator.of = ffi.Pointer.fromFunction(navigatorOf, exception);
  f.navigator.maybeOf = ffi.Pointer.fromFunction(navigatorMaybeOf, exception);
}
NavigatorObjSt navigatorNavigator(ffi.Pointer<ffi.Char> initialRoute, ffi.Pointer<ffi.Int> reportsRouteUpdateToEngine, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> requestFocus, ffi.Pointer<ffi.Char> restorationScopeId, ffi.Pointer<ffi.Int> routeTraversalEdgeBehavior, ffi.Pointer<ffi.Int> routeDirectionalTraversalEdgeBehavior) {
  final w = Navigator(initialRoute: initialRoute.strOrNul(),
      reportsRouteUpdateToEngine: reportsRouteUpdateToEngine.boolOr(false),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      requestFocus: requestFocus.boolOr(true),
      restorationScopeId: restorationScopeId.strOrNul(),
      routeTraversalEdgeBehavior: routeTraversalEdgeBehavior.enumOr(TraversalEdgeBehavior.values, kDefaultRouteTraversalEdgeBehavior),
      routeDirectionalTraversalEdgeBehavior: routeDirectionalTraversalEdgeBehavior.enumOr(TraversalEdgeBehavior.values, kDefaultRouteDirectionalTraversalEdgeBehavior));
  return _createNavigatorObjSt(w);
}
int navigatorPushNamed(DartDartObj context, ffi.Pointer<ffi.Char> routeName, ffi.Pointer<DartObj> arguments) {
  final w = Navigator.pushNamed(_widgetsMap[context]! as BuildContext,
      routeName.cast<Utf8>().toDartString(),
      arguments: arguments.objOrNul());
  return _addWidget(w);
}
ffi.Pointer<ffi.Char> navigatorRestorablePushNamed(DartDartObj context, ffi.Pointer<ffi.Char> routeName, ffi.Pointer<DartObj> arguments) {
  final w = Navigator.restorablePushNamed(_widgetsMap[context]! as BuildContext,
      routeName.cast<Utf8>().toDartString(),
      arguments: arguments.objOrNul());
  return w.toNativeUtf8().cast<ffi.Char>();
}
int navigatorPushReplacementNamed(DartDartObj context, ffi.Pointer<ffi.Char> routeName, ffi.Pointer<DartObj> result, ffi.Pointer<DartObj> arguments) {
  final w = Navigator.pushReplacementNamed(_widgetsMap[context]! as BuildContext,
      routeName.cast<Utf8>().toDartString(),
      result: result,
      arguments: arguments.objOrNul());
  return _addWidget(w);
}
ffi.Pointer<ffi.Char> navigatorRestorablePushReplacementNamed(DartDartObj context, ffi.Pointer<ffi.Char> routeName, ffi.Pointer<DartObj> result, ffi.Pointer<DartObj> arguments) {
  final w = Navigator.restorablePushReplacementNamed(_widgetsMap[context]! as BuildContext,
      routeName.cast<Utf8>().toDartString(),
      result: result,
      arguments: arguments.objOrNul());
  return w.toNativeUtf8().cast<ffi.Char>();
}
int navigatorPopAndPushNamed(DartDartObj context, ffi.Pointer<ffi.Char> routeName, ffi.Pointer<DartObj> result, ffi.Pointer<DartObj> arguments) {
  final w = Navigator.popAndPushNamed(_widgetsMap[context]! as BuildContext,
      routeName.cast<Utf8>().toDartString(),
      result: result,
      arguments: arguments.objOrNul());
  return _addWidget(w);
}
ffi.Pointer<ffi.Char> navigatorRestorablePopAndPushNamed(DartDartObj context, ffi.Pointer<ffi.Char> routeName, ffi.Pointer<DartObj> result, ffi.Pointer<DartObj> arguments) {
  final w = Navigator.restorablePopAndPushNamed(_widgetsMap[context]! as BuildContext,
      routeName.cast<Utf8>().toDartString(),
      result: result,
      arguments: arguments.objOrNul());
  return w.toNativeUtf8().cast<ffi.Char>();
}
int navigatorCanPop(DartDartObj context) {
  final w = Navigator.canPop(_widgetsMap[context]! as BuildContext);
  return w.toInt();
}
int navigatorMaybePop(DartDartObj context, ffi.Pointer<DartObj> result) {
  final w = Navigator.maybePop(_widgetsMap[context]! as BuildContext,
      result);
  return _addWidget(w);
}
void navigatorPop(DartDartObj context, ffi.Pointer<DartObj> result) {
  Navigator.pop(_widgetsMap[context]! as BuildContext,
      result);
}
int navigatorOf(DartDartObj context, ffi.Pointer<ffi.Int> rootNavigator) {
  final w = Navigator.of(_widgetsMap[context]! as BuildContext,
      rootNavigator: rootNavigator.boolOr(false));
  return _addWidget(w);
}
int navigatorMaybeOf(DartDartObj context, ffi.Pointer<ffi.Int> rootNavigator) {
  final w = Navigator.maybeOf(_widgetsMap[context]! as BuildContext,
      rootNavigator: rootNavigator.boolOr(false));
  return _addWidget(w);
}
NavigatorObjSt _createNavigatorObjSt(Navigator? w) {
  final NavigatorObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.initialRoute = (w.initialRoute != null) ? w.initialRoute!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.restorationScopeId = (w.restorationScopeId != null) ? w.restorationScopeId!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.routeTraversalEdgeBehavior = w.routeTraversalEdgeBehavior.index;
  stObj.routeDirectionalTraversalEdgeBehavior = w.routeDirectionalTraversalEdgeBehavior.index;
  stObj.reportsRouteUpdateToEngine = w.reportsRouteUpdateToEngine.toInt();
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.requestFocus = w.requestFocus.toInt();
  return stObj;
}

void _setupAlertDialog(WidgetFactories f) {
  f.alertDialog.alertDialog = ffi.Pointer.fromFunction(alertDialogAlertDialog);
  f.alertDialog.adaptive = ffi.Pointer.fromFunction(alertDialogAdaptive);
}
AlertDialogObjSt alertDialogAlertDialog(ffi.Pointer<DartObj> icon, ffi.Pointer<DartObj> iconPadding, ffi.Pointer<DartObj> iconColor, ffi.Pointer<DartObj> title, ffi.Pointer<DartObj> titlePadding, ffi.Pointer<DartObj> titleTextStyle, ffi.Pointer<DartObj> content, ffi.Pointer<DartObj> contentPadding, ffi.Pointer<DartObj> contentTextStyle, ffi.Pointer<ArrayC> actions, ffi.Pointer<DartObj> actionsPadding, ffi.Pointer<ffi.Int> actionsAlignment, ffi.Pointer<ffi.Int> actionsOverflowAlignment, ffi.Pointer<ffi.Int> actionsOverflowDirection, ffi.Pointer<ffi.Double> actionsOverflowButtonSpacing, ffi.Pointer<DartObj> buttonPadding, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<ffi.Char> semanticLabel, ffi.Pointer<DartObj> insetPadding, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> shape, ffi.Pointer<DartObj> alignment, ffi.Pointer<DartObj> constraints, ffi.Pointer<ffi.Int> scrollable) {
  final w = AlertDialog(icon: icon.objOrNul(),
      iconPadding: iconPadding.objOrNul(),
      iconColor: iconColor.objOrNul(),
      title: title.objOrNul(),
      titlePadding: titlePadding.objOrNul(),
      titleTextStyle: titleTextStyle.objOrNul(),
      content: content.objOrNul(),
      contentPadding: contentPadding.objOrNul(),
      contentTextStyle: contentTextStyle.objOrNul(),
      actions: actions.listOrNul(),
      actionsPadding: actionsPadding.objOrNul(),
      actionsAlignment: actionsAlignment.enumOrNul(MainAxisAlignment.values),
      actionsOverflowAlignment: actionsOverflowAlignment.enumOrNul(OverflowBarAlignment.values),
      actionsOverflowDirection: actionsOverflowDirection.enumOrNul(VerticalDirection.values),
      actionsOverflowButtonSpacing: actionsOverflowButtonSpacing.doubleOrNul(),
      buttonPadding: buttonPadding.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      elevation: elevation.doubleOrNul(),
      shadowColor: shadowColor.objOrNul(),
      surfaceTintColor: surfaceTintColor.objOrNul(),
      semanticLabel: semanticLabel.strOrNul(),
      insetPadding: insetPadding.objOrNul(),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      shape: shape.objOrNul(),
      alignment: alignment.objOrNul(),
      constraints: constraints.objOrNul(),
      scrollable: scrollable.boolOr(false));
  return _createAlertDialogObjSt(w);
}
AlertDialogObjSt alertDialogAdaptive(ffi.Pointer<DartObj> icon, ffi.Pointer<DartObj> iconPadding, ffi.Pointer<DartObj> iconColor, ffi.Pointer<DartObj> title, ffi.Pointer<DartObj> titlePadding, ffi.Pointer<DartObj> titleTextStyle, ffi.Pointer<DartObj> content, ffi.Pointer<DartObj> contentPadding, ffi.Pointer<DartObj> contentTextStyle, ffi.Pointer<ArrayC> actions, ffi.Pointer<DartObj> actionsPadding, ffi.Pointer<ffi.Int> actionsAlignment, ffi.Pointer<ffi.Int> actionsOverflowAlignment, ffi.Pointer<ffi.Int> actionsOverflowDirection, ffi.Pointer<ffi.Double> actionsOverflowButtonSpacing, ffi.Pointer<DartObj> buttonPadding, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<ffi.Char> semanticLabel, ffi.Pointer<DartObj> insetPadding, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> shape, ffi.Pointer<DartObj> alignment, ffi.Pointer<DartObj> constraints, ffi.Pointer<ffi.Int> scrollable, ffi.Pointer<DartObj> insetAnimationDuration, ffi.Pointer<DartObj> insetAnimationCurve) {
  final w = AlertDialog.adaptive(icon: icon.objOrNul(),
      iconPadding: iconPadding.objOrNul(),
      iconColor: iconColor.objOrNul(),
      title: title.objOrNul(),
      titlePadding: titlePadding.objOrNul(),
      titleTextStyle: titleTextStyle.objOrNul(),
      content: content.objOrNul(),
      contentPadding: contentPadding.objOrNul(),
      contentTextStyle: contentTextStyle.objOrNul(),
      actions: actions.listOrNul(),
      actionsPadding: actionsPadding.objOrNul(),
      actionsAlignment: actionsAlignment.enumOrNul(MainAxisAlignment.values),
      actionsOverflowAlignment: actionsOverflowAlignment.enumOrNul(OverflowBarAlignment.values),
      actionsOverflowDirection: actionsOverflowDirection.enumOrNul(VerticalDirection.values),
      actionsOverflowButtonSpacing: actionsOverflowButtonSpacing.doubleOrNul(),
      buttonPadding: buttonPadding.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      elevation: elevation.doubleOrNul(),
      shadowColor: shadowColor.objOrNul(),
      surfaceTintColor: surfaceTintColor.objOrNul(),
      semanticLabel: semanticLabel.strOrNul(),
      insetPadding: insetPadding.objOr(null),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      shape: shape.objOrNul(),
      alignment: alignment.objOrNul(),
      constraints: constraints.objOrNul(),
      scrollable: scrollable.boolOr(false),
      insetAnimationDuration: insetAnimationDuration.objOr(null),
      insetAnimationCurve: insetAnimationCurve.objOr(null));
  return _createAlertDialogObjSt(w);
}
AlertDialogObjSt _createAlertDialogObjSt(AlertDialog? w) {
  final AlertDialogObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.icon = _addWidget(w.icon);
  stObj.iconColor = _addWidget(w.iconColor);
  stObj.iconPadding = _addWidget(w.iconPadding);
  stObj.title = _addWidget(w.title);
  stObj.titlePadding = _addWidget(w.titlePadding);
  stObj.titleTextStyle = _createTextStyleObjSt(w.titleTextStyle);
  stObj.content = _addWidget(w.content);
  stObj.contentPadding = _addWidget(w.contentPadding);
  stObj.contentTextStyle = _createTextStyleObjSt(w.contentTextStyle);
  stObj.actionsPadding = _addWidget(w.actionsPadding);
  stObj.actionsAlignment = (w.actionsAlignment != null) ? w.actionsAlignment!.index : 0;
  stObj.actionsOverflowAlignment = (w.actionsOverflowAlignment != null) ? w.actionsOverflowAlignment!.index : 0;
  stObj.actionsOverflowDirection = (w.actionsOverflowDirection != null) ? w.actionsOverflowDirection!.index : 0;
  stObj.actionsOverflowButtonSpacing = (w.actionsOverflowButtonSpacing != null) ? w.actionsOverflowButtonSpacing! : 0;
  stObj.buttonPadding = _addWidget(w.buttonPadding);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.elevation = (w.elevation != null) ? w.elevation! : 0;
  stObj.shadowColor = _addWidget(w.shadowColor);
  stObj.surfaceTintColor = _addWidget(w.surfaceTintColor);
  stObj.semanticLabel = (w.semanticLabel != null) ? w.semanticLabel!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.insetPadding = _createEdgeInsetsObjSt(w.insetPadding);
  stObj.clipBehavior = (w.clipBehavior != null) ? w.clipBehavior!.index : 0;
  stObj.shape = _addWidget(w.shape);
  stObj.alignment = _addWidget(w.alignment);
  stObj.constraints = _createBoxConstraintsObjSt(w.constraints);
  stObj.scrollable = w.scrollable.toInt();
  return stObj;
}

void _setupInputDecoration(WidgetFactories f) {
  f.inputDecoration.inputDecoration = ffi.Pointer.fromFunction(inputDecorationInputDecoration);
  f.inputDecoration.collapsed = ffi.Pointer.fromFunction(inputDecorationCollapsed);
}
InputDecorationObjSt inputDecorationInputDecoration(ffi.Pointer<DartObj> icon, ffi.Pointer<DartObj> iconColor, ffi.Pointer<DartObj> label, ffi.Pointer<ffi.Char> labelText, ffi.Pointer<DartObj> labelStyle, ffi.Pointer<DartObj> floatingLabelStyle, ffi.Pointer<DartObj> helper, ffi.Pointer<ffi.Char> helperText, ffi.Pointer<DartObj> helperStyle, ffi.Pointer<ffi.Int> helperMaxLines, ffi.Pointer<ffi.Char> hintText, ffi.Pointer<DartObj> hint, ffi.Pointer<DartObj> hintStyle, ffi.Pointer<ffi.Int> hintTextDirection, ffi.Pointer<ffi.Int> hintMaxLines, ffi.Pointer<DartObj> hintFadeDuration, ffi.Pointer<ffi.Int> maintainHintHeight, ffi.Pointer<ffi.Int> maintainHintSize, ffi.Pointer<ffi.Int> maintainLabelSize, ffi.Pointer<DartObj> error, ffi.Pointer<ffi.Char> errorText, ffi.Pointer<DartObj> errorStyle, ffi.Pointer<ffi.Int> errorMaxLines, ffi.Pointer<ffi.Int> floatingLabelBehavior, ffi.Pointer<ffi.Int> isCollapsed, ffi.Pointer<ffi.Int> isDense, ffi.Pointer<DartObj> contentPadding, ffi.Pointer<DartObj> prefixIcon, ffi.Pointer<DartObj> prefixIconConstraints, ffi.Pointer<DartObj> prefix, ffi.Pointer<ffi.Char> prefixText, ffi.Pointer<DartObj> prefixStyle, ffi.Pointer<DartObj> prefixIconColor, ffi.Pointer<DartObj> suffixIcon, ffi.Pointer<DartObj> suffix, ffi.Pointer<ffi.Char> suffixText, ffi.Pointer<DartObj> suffixStyle, ffi.Pointer<DartObj> suffixIconColor, ffi.Pointer<DartObj> suffixIconConstraints, ffi.Pointer<DartObj> counter, ffi.Pointer<ffi.Char> counterText, ffi.Pointer<DartObj> counterStyle, ffi.Pointer<ffi.Int> filled, ffi.Pointer<DartObj> fillColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> errorBorder, ffi.Pointer<DartObj> focusedBorder, ffi.Pointer<DartObj> focusedErrorBorder, ffi.Pointer<DartObj> disabledBorder, ffi.Pointer<DartObj> enabledBorder, ffi.Pointer<DartObj> border, ffi.Pointer<ffi.Int> enabled, ffi.Pointer<ffi.Char> semanticCounterText, ffi.Pointer<ffi.Int> alignLabelWithHint, ffi.Pointer<DartObj> constraints, ffi.Pointer<DartObj> visualDensity) {
  final w = InputDecoration(icon: icon.objOrNul(),
      iconColor: iconColor.objOrNul(),
      label: label.objOrNul(),
      labelText: labelText.strOrNul(),
      labelStyle: labelStyle.objOrNul(),
      floatingLabelStyle: floatingLabelStyle.objOrNul(),
      helper: helper.objOrNul(),
      helperText: helperText.strOrNul(),
      helperStyle: helperStyle.objOrNul(),
      helperMaxLines: helperMaxLines.intOrNul(),
      hintText: hintText.strOrNul(),
      hint: hint.objOrNul(),
      hintStyle: hintStyle.objOrNul(),
      hintTextDirection: hintTextDirection.enumOrNul(TextDirection.values),
      hintMaxLines: hintMaxLines.intOrNul(),
      hintFadeDuration: hintFadeDuration.objOrNul(),
      maintainHintHeight: maintainHintHeight.boolOr(true),
      maintainHintSize: maintainHintSize.boolOr(true),
      maintainLabelSize: maintainLabelSize.boolOr(false),
      error: error.objOrNul(),
      errorText: errorText.strOrNul(),
      errorStyle: errorStyle.objOrNul(),
      errorMaxLines: errorMaxLines.intOrNul(),
      floatingLabelBehavior: floatingLabelBehavior.enumOrNul(FloatingLabelBehavior.values),
      isCollapsed: isCollapsed.boolOrNul(),
      isDense: isDense.boolOrNul(),
      contentPadding: contentPadding.objOrNul(),
      prefixIcon: prefixIcon.objOrNul(),
      prefixIconConstraints: prefixIconConstraints.objOrNul(),
      prefix: prefix.objOrNul(),
      prefixText: prefixText.strOrNul(),
      prefixStyle: prefixStyle.objOrNul(),
      prefixIconColor: prefixIconColor.objOrNul(),
      suffixIcon: suffixIcon.objOrNul(),
      suffix: suffix.objOrNul(),
      suffixText: suffixText.strOrNul(),
      suffixStyle: suffixStyle.objOrNul(),
      suffixIconColor: suffixIconColor.objOrNul(),
      suffixIconConstraints: suffixIconConstraints.objOrNul(),
      counter: counter.objOrNul(),
      counterText: counterText.strOrNul(),
      counterStyle: counterStyle.objOrNul(),
      filled: filled.boolOrNul(),
      fillColor: fillColor.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      errorBorder: errorBorder.objOrNul(),
      focusedBorder: focusedBorder.objOrNul(),
      focusedErrorBorder: focusedErrorBorder.objOrNul(),
      disabledBorder: disabledBorder.objOrNul(),
      enabledBorder: enabledBorder.objOrNul(),
      border: border.objOrNul(),
      enabled: enabled.boolOr(true),
      semanticCounterText: semanticCounterText.strOrNul(),
      alignLabelWithHint: alignLabelWithHint.boolOrNul(),
      constraints: constraints.objOrNul(),
      visualDensity: visualDensity.objOrNul());
  return _createInputDecorationObjSt(w);
}
InputDecorationObjSt inputDecorationCollapsed(ffi.Pointer<ffi.Char> hintText, ffi.Pointer<ffi.Int> floatingLabelBehavior, ffi.Pointer<DartObj> hintStyle, ffi.Pointer<DartObj> hint, ffi.Pointer<ffi.Int> hintTextDirection, ffi.Pointer<ffi.Int> hintMaxLines, ffi.Pointer<DartObj> hintFadeDuration, ffi.Pointer<ffi.Int> maintainHintHeight, ffi.Pointer<ffi.Int> maintainHintSize, ffi.Pointer<ffi.Int> maintainLabelSize, ffi.Pointer<ffi.Int> filled, ffi.Pointer<DartObj> fillColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> border, ffi.Pointer<ffi.Int> enabled, ffi.Pointer<DartObj> constraints) {
  final w = InputDecoration.collapsed(hintText: hintText.cast<Utf8>().toDartString(),
      floatingLabelBehavior: floatingLabelBehavior.enumOrNul(FloatingLabelBehavior.values),
      hintStyle: hintStyle.objOrNul(),
      hint: hint.objOrNul(),
      hintTextDirection: hintTextDirection.enumOrNul(TextDirection.values),
      hintMaxLines: hintMaxLines.intOrNul(),
      hintFadeDuration: hintFadeDuration.objOrNul(),
      maintainHintHeight: maintainHintHeight.boolOr(true),
      maintainHintSize: maintainHintSize.boolOr(true),
      maintainLabelSize: maintainLabelSize.boolOr(false),
      filled: filled.boolOrNul(),
      fillColor: fillColor.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      border: border.objOrNul(),
      enabled: enabled.boolOr(true),
      constraints: constraints.objOrNul());
  return _createInputDecorationObjSt(w);
}
InputDecorationObjSt _createInputDecorationObjSt(InputDecoration? w) {
  final InputDecorationObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.icon = _addWidget(w.icon);
  stObj.iconColor = _addWidget(w.iconColor);
  stObj.label = _addWidget(w.label);
  stObj.labelText = (w.labelText != null) ? w.labelText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.labelStyle = _createTextStyleObjSt(w.labelStyle);
  stObj.floatingLabelStyle = _createTextStyleObjSt(w.floatingLabelStyle);
  stObj.helper = _addWidget(w.helper);
  stObj.helperText = (w.helperText != null) ? w.helperText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.helperStyle = _createTextStyleObjSt(w.helperStyle);
  stObj.helperMaxLines = (w.helperMaxLines != null) ? w.helperMaxLines! : 0;
  stObj.hintText = (w.hintText != null) ? w.hintText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.hint = _addWidget(w.hint);
  stObj.hintStyle = _createTextStyleObjSt(w.hintStyle);
  stObj.hintTextDirection = (w.hintTextDirection != null) ? w.hintTextDirection!.index : 0;
  stObj.hintMaxLines = (w.hintMaxLines != null) ? w.hintMaxLines! : 0;
  stObj.hintFadeDuration = _addWidget(w.hintFadeDuration);
  stObj.maintainHintHeight = w.maintainHintHeight.toInt();
  stObj.maintainHintSize = w.maintainHintSize.toInt();
  stObj.maintainLabelSize = w.maintainLabelSize.toInt();
  stObj.error = _addWidget(w.error);
  stObj.errorText = (w.errorText != null) ? w.errorText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.errorStyle = _createTextStyleObjSt(w.errorStyle);
  stObj.errorMaxLines = (w.errorMaxLines != null) ? w.errorMaxLines! : 0;
  stObj.floatingLabelBehavior = (w.floatingLabelBehavior != null) ? w.floatingLabelBehavior!.index : 0;
  stObj.isDense = (w.isDense != null) ? w.isDense!.toInt() : 0;
  stObj.contentPadding = _addWidget(w.contentPadding);
  stObj.isCollapsed = (w.isCollapsed != null) ? w.isCollapsed!.toInt() : 0;
  stObj.prefixIcon = _addWidget(w.prefixIcon);
  stObj.prefixIconConstraints = _createBoxConstraintsObjSt(w.prefixIconConstraints);
  stObj.prefix = _addWidget(w.prefix);
  stObj.prefixText = (w.prefixText != null) ? w.prefixText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.prefixStyle = _createTextStyleObjSt(w.prefixStyle);
  stObj.prefixIconColor = _addWidget(w.prefixIconColor);
  stObj.suffixIcon = _addWidget(w.suffixIcon);
  stObj.suffix = _addWidget(w.suffix);
  stObj.suffixText = (w.suffixText != null) ? w.suffixText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.suffixStyle = _createTextStyleObjSt(w.suffixStyle);
  stObj.suffixIconColor = _addWidget(w.suffixIconColor);
  stObj.suffixIconConstraints = _createBoxConstraintsObjSt(w.suffixIconConstraints);
  stObj.counterText = (w.counterText != null) ? w.counterText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.counter = _addWidget(w.counter);
  stObj.counterStyle = _createTextStyleObjSt(w.counterStyle);
  stObj.filled = (w.filled != null) ? w.filled!.toInt() : 0;
  stObj.fillColor = _addWidget(w.fillColor);
  stObj.focusColor = _addWidget(w.focusColor);
  stObj.hoverColor = _addWidget(w.hoverColor);
  stObj.errorBorder = _addWidget(w.errorBorder);
  stObj.focusedBorder = _addWidget(w.focusedBorder);
  stObj.focusedErrorBorder = _addWidget(w.focusedErrorBorder);
  stObj.disabledBorder = _addWidget(w.disabledBorder);
  stObj.enabledBorder = _addWidget(w.enabledBorder);
  stObj.border = _addWidget(w.border);
  stObj.enabled = w.enabled.toInt();
  stObj.semanticCounterText = (w.semanticCounterText != null) ? w.semanticCounterText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.alignLabelWithHint = (w.alignLabelWithHint != null) ? w.alignLabelWithHint!.toInt() : 0;
  stObj.constraints = _createBoxConstraintsObjSt(w.constraints);
  stObj.visualDensity = _createVisualDensityObjSt(w.visualDensity);
  return stObj;
}

void _setupInputBorder(WidgetFactories f) {
  f.inputBorder.none = _addWidget(InputBorder.none);
}

void _setupTextField(WidgetFactories f) {
  f.textField.textField = ffi.Pointer.fromFunction(textFieldTextField);
}
TextFieldObjSt textFieldTextField(ffi.Pointer<DartObj> groupId, ffi.Pointer<DartObj> decoration, ffi.Pointer<ffi.Int> textInputAction, ffi.Pointer<ffi.Int> textCapitalization, ffi.Pointer<DartObj> style, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> readOnly, ffi.Pointer<ffi.Int> showCursor, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Char> obscuringCharacter, ffi.Pointer<ffi.Int> obscureText, ffi.Pointer<ffi.Int> autocorrect, ffi.Pointer<ffi.Int> smartDashesType, ffi.Pointer<ffi.Int> smartQuotesType, ffi.Pointer<ffi.Int> enableSuggestions, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Int> minLines, ffi.Pointer<ffi.Int> expands, ffi.Pointer<ffi.Int> maxLength, ffi.Pointer<ffi.Int> maxLengthEnforcement, ffi.Pointer<ValueChangedForStringFFI> onChanged, ffi.Pointer<VoidCallbackFFI> onEditingComplete, ffi.Pointer<ValueChangedForStringFFI> onSubmitted, ffi.Pointer<ffi.Int> enabled, ffi.Pointer<ffi.Int> ignorePointers, ffi.Pointer<ffi.Double> cursorWidth, ffi.Pointer<ffi.Double> cursorHeight, ffi.Pointer<DartObj> cursorRadius, ffi.Pointer<ffi.Int> cursorOpacityAnimates, ffi.Pointer<DartObj> cursorColor, ffi.Pointer<DartObj> cursorErrorColor, ffi.Pointer<ffi.Int> selectionHeightStyle, ffi.Pointer<ffi.Int> selectionWidthStyle, ffi.Pointer<ffi.Int> keyboardAppearance, ffi.Pointer<DartObj> scrollPadding, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<ffi.Int> enableInteractiveSelection, ffi.Pointer<ffi.Int> selectAllOnFocus, ffi.Pointer<GestureTapCallbackFFI> onTap, ffi.Pointer<ffi.Int> onTapAlwaysCalled, ffi.Pointer<InputCounterWidgetBuilderFFI> buildCounter, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Char> restorationId, ffi.Pointer<ffi.Int> scribbleEnabled, ffi.Pointer<ffi.Int> stylusHandwritingEnabled, ffi.Pointer<ffi.Int> enableIMEPersonalizedLearning, ffi.Pointer<ffi.Int> enableInlinePrediction, ffi.Pointer<ffi.Int> canRequestFocus) {
  final w = TextField(groupId: groupId.objOr(EditableText),
      decoration: decoration.objOrNul(),
      textInputAction: textInputAction.enumOrNul(TextInputAction.values),
      textCapitalization: textCapitalization.enumOr(TextCapitalization.values, TextCapitalization.none),
      style: style.objOrNul(),
      textAlign: textAlign.enumOr(TextAlign.values, TextAlign.start),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      readOnly: readOnly.boolOr(false),
      showCursor: showCursor.boolOrNul(),
      autofocus: autofocus.boolOr(false),
      obscuringCharacter: obscuringCharacter.strOr('•'),
      obscureText: obscureText.boolOr(false),
      autocorrect: autocorrect.boolOrNul(),
      smartDashesType: smartDashesType.enumOrNul(SmartDashesType.values),
      smartQuotesType: smartQuotesType.enumOrNul(SmartQuotesType.values),
      enableSuggestions: enableSuggestions.boolOr(true),
      maxLines: maxLines.intOrNul(),
      minLines: minLines.intOrNul(),
      expands: expands.boolOr(false),
      maxLength: maxLength.intOrNul(),
      maxLengthEnforcement: maxLengthEnforcement.enumOrNul(MaxLengthEnforcement.values),
      onChanged: onChanged.toValueChangedForStringFn(),
      onEditingComplete: onEditingComplete.toVoidCallbackFn(),
      onSubmitted: onSubmitted.toValueChangedForStringFn(),
      enabled: enabled.boolOrNul(),
      ignorePointers: ignorePointers.boolOrNul(),
      cursorWidth: cursorWidth.doubleOr(2.0),
      cursorHeight: cursorHeight.doubleOrNul(),
      cursorRadius: cursorRadius.objOrNul(),
      cursorOpacityAnimates: cursorOpacityAnimates.boolOrNul(),
      cursorColor: cursorColor.objOrNul(),
      cursorErrorColor: cursorErrorColor.objOrNul(),
      selectionHeightStyle: selectionHeightStyle.enumOrNul(BoxHeightStyle.values),
      selectionWidthStyle: selectionWidthStyle.enumOrNul(BoxWidthStyle.values),
      keyboardAppearance: keyboardAppearance.enumOrNul(Brightness.values),
      scrollPadding: scrollPadding.objOr(const EdgeInsets.all(20.0)),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      enableInteractiveSelection: enableInteractiveSelection.boolOrNul(),
      selectAllOnFocus: selectAllOnFocus.boolOrNul(),
      onTap: onTap.toGestureTapCallbackFn(),
      onTapAlwaysCalled: onTapAlwaysCalled.boolOr(false),
      buildCounter: buildCounter.toInputCounterWidgetBuilderFn(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      restorationId: restorationId.strOrNul(),
      scribbleEnabled: scribbleEnabled.boolOr(true),
      stylusHandwritingEnabled: stylusHandwritingEnabled.boolOr(EditableText.defaultStylusHandwritingEnabled),
      enableIMEPersonalizedLearning: enableIMEPersonalizedLearning.boolOr(true),
      enableInlinePrediction: enableInlinePrediction.boolOrNul(),
      canRequestFocus: canRequestFocus.boolOr(true));
  return _createTextFieldObjSt(w);
}
TextFieldObjSt _createTextFieldObjSt(TextField? w) {
  final TextFieldObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.decoration = _createInputDecorationObjSt(w.decoration);
  stObj.textInputAction = (w.textInputAction != null) ? w.textInputAction!.index : 0;
  stObj.textCapitalization = w.textCapitalization.index;
  stObj.style = _createTextStyleObjSt(w.style);
  stObj.textAlign = w.textAlign.index;
  stObj.textDirection = (w.textDirection != null) ? w.textDirection!.index : 0;
  stObj.autofocus = w.autofocus.toInt();
  stObj.obscuringCharacter = w.obscuringCharacter.toNativeUtf8().cast<ffi.Char>();
  stObj.obscureText = w.obscureText.toInt();
  stObj.autocorrect = (w.autocorrect != null) ? w.autocorrect!.toInt() : 0;
  stObj.smartDashesType = w.smartDashesType.index;
  stObj.smartQuotesType = w.smartQuotesType.index;
  stObj.enableSuggestions = w.enableSuggestions.toInt();
  stObj.maxLines = (w.maxLines != null) ? w.maxLines! : 0;
  stObj.minLines = (w.minLines != null) ? w.minLines! : 0;
  stObj.expands = w.expands.toInt();
  stObj.readOnly = w.readOnly.toInt();
  stObj.showCursor = (w.showCursor != null) ? w.showCursor!.toInt() : 0;
  stObj.maxLength = (w.maxLength != null) ? w.maxLength! : 0;
  stObj.maxLengthEnforcement = (w.maxLengthEnforcement != null) ? w.maxLengthEnforcement!.index : 0;
  stObj.enabled = (w.enabled != null) ? w.enabled!.toInt() : 0;
  stObj.ignorePointers = (w.ignorePointers != null) ? w.ignorePointers!.toInt() : 0;
  stObj.cursorWidth = w.cursorWidth;
  stObj.cursorHeight = (w.cursorHeight != null) ? w.cursorHeight! : 0;
  stObj.cursorRadius = _addWidget(w.cursorRadius);
  stObj.cursorOpacityAnimates = (w.cursorOpacityAnimates != null) ? w.cursorOpacityAnimates!.toInt() : 0;
  stObj.cursorColor = _addWidget(w.cursorColor);
  stObj.cursorErrorColor = _addWidget(w.cursorErrorColor);
  stObj.selectionHeightStyle = (w.selectionHeightStyle != null) ? w.selectionHeightStyle!.index : 0;
  stObj.selectionWidthStyle = (w.selectionWidthStyle != null) ? w.selectionWidthStyle!.index : 0;
  stObj.keyboardAppearance = (w.keyboardAppearance != null) ? w.keyboardAppearance!.index : 0;
  stObj.scrollPadding = _createEdgeInsetsObjSt(w.scrollPadding);
  stObj.enableInteractiveSelection = w.enableInteractiveSelection.toInt();
  stObj.selectAllOnFocus = (w.selectAllOnFocus != null) ? w.selectAllOnFocus!.toInt() : 0;
  stObj.dragStartBehavior = w.dragStartBehavior.index;
  stObj.onTapAlwaysCalled = w.onTapAlwaysCalled.toInt();
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.restorationId = (w.restorationId != null) ? w.restorationId!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.scribbleEnabled = w.scribbleEnabled.toInt();
  stObj.stylusHandwritingEnabled = w.stylusHandwritingEnabled.toInt();
  stObj.enableIMEPersonalizedLearning = w.enableIMEPersonalizedLearning.toInt();
  stObj.enableInlinePrediction = (w.enableInlinePrediction != null) ? w.enableInlinePrediction!.toInt() : 0;
  stObj.canRequestFocus = w.canRequestFocus.toInt();
  stObj.selectionEnabled = w.selectionEnabled.toInt();
  return stObj;
}

void _setupDivider(WidgetFactories f) {
  f.divider.divider = ffi.Pointer.fromFunction(dividerDivider);
  f.divider.createBorderSide = ffi.Pointer.fromFunction(dividerCreateBorderSide);
}
DividerObjSt dividerDivider(ffi.Pointer<ffi.Double> height, ffi.Pointer<ffi.Double> thickness, ffi.Pointer<ffi.Double> indent, ffi.Pointer<ffi.Double> endIndent, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> radius) {
  final w = Divider(height: height.doubleOrNul(),
      thickness: thickness.doubleOrNul(),
      indent: indent.doubleOrNul(),
      endIndent: endIndent.doubleOrNul(),
      color: color.objOrNul(),
      radius: radius.objOrNul());
  return _createDividerObjSt(w);
}
BorderSideObjSt dividerCreateBorderSide(DartDartObj context, ffi.Pointer<DartObj> color, ffi.Pointer<ffi.Double> width) {
  final w = Divider.createBorderSide(_widgetsMap[context]! as BuildContext?,
      color: color.objOrNul(),
      width: width.doubleOrNul());
  return _createBorderSideObjSt(w);
}
DividerObjSt _createDividerObjSt(Divider? w) {
  final DividerObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.height = (w.height != null) ? w.height! : 0;
  stObj.thickness = (w.thickness != null) ? w.thickness! : 0;
  stObj.indent = (w.indent != null) ? w.indent! : 0;
  stObj.endIndent = (w.endIndent != null) ? w.endIndent! : 0;
  stObj.radius = _addWidget(w.radius);
  stObj.color = _addWidget(w.color);
  return stObj;
}

void _setupFilledButton(WidgetFactories f) {
  f.filledButton.filledButton = ffi.Pointer.fromFunction(filledButtonFilledButton);
  f.filledButton.icon = ffi.Pointer.fromFunction(filledButtonIcon);
  f.filledButton.tonal = ffi.Pointer.fromFunction(filledButtonTonal);
  f.filledButton.tonalIcon = ffi.Pointer.fromFunction(filledButtonTonalIcon);
}
FilledButtonObjSt filledButtonFilledButton(VoidCallbackFFI onPressed, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> clipBehavior, DartDartObj child) {
  final w = FilledButton(onPressed: onPressed.toVoidCallbackFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      child: _widgetsMap[child]! as Widget?);
  return _createFilledButtonObjSt(w);
}
FilledButtonObjSt filledButtonIcon(VoidCallbackFFI onPressed, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> icon, DartDartObj label, ffi.Pointer<ffi.Int> iconAlignment) {
  final w = FilledButton.icon(onPressed: onPressed.toVoidCallbackFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      icon: icon.objOrNul(),
      label: _widgetsMap[label]! as Widget,
      iconAlignment: iconAlignment.enumOrNul(IconAlignment.values));
  return _createFilledButtonObjSt(w);
}
FilledButtonObjSt filledButtonTonal(VoidCallbackFFI onPressed, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> clipBehavior, DartDartObj child) {
  final w = FilledButton.tonal(onPressed: onPressed.toVoidCallbackFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      child: _widgetsMap[child]! as Widget?);
  return _createFilledButtonObjSt(w);
}
FilledButtonObjSt filledButtonTonalIcon(VoidCallbackFFI onPressed, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> icon, DartDartObj label, ffi.Pointer<ffi.Int> iconAlignment) {
  final w = FilledButton.tonalIcon(onPressed: onPressed.toVoidCallbackFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      icon: icon.objOrNul(),
      label: _widgetsMap[label]! as Widget,
      iconAlignment: iconAlignment.enumOrNul(IconAlignment.values));
  return _createFilledButtonObjSt(w);
}
FilledButtonObjSt _createFilledButtonObjSt(FilledButton? w) {
  final FilledButtonObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupOutlineInputBorder(WidgetFactories f) {
  f.outlineInputBorder.outlineInputBorder = ffi.Pointer.fromFunction(outlineInputBorderOutlineInputBorder);
}
OutlineInputBorderObjSt outlineInputBorderOutlineInputBorder(ffi.Pointer<DartObj> borderSide, ffi.Pointer<DartObj> borderRadius, ffi.Pointer<ffi.Double> gapPadding) {
  final w = OutlineInputBorder(borderSide: borderSide.objOr(const BorderSide()),
      borderRadius: borderRadius.objOr(const BorderRadius.all(Radius.circular(4.0))),
      gapPadding: gapPadding.doubleOr(4.0));
  return _createOutlineInputBorderObjSt(w);
}
OutlineInputBorderObjSt _createOutlineInputBorderObjSt(OutlineInputBorder? w) {
  final OutlineInputBorderObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.gapPadding = w.gapPadding;
  stObj.borderRadius = _createBorderRadiusObjSt(w.borderRadius);
  return stObj;
}

void _setupSnackBarAction(WidgetFactories f) {
  f.snackBarAction.snackBarAction = ffi.Pointer.fromFunction(snackBarActionSnackBarAction);
}
SnackBarActionObjSt snackBarActionSnackBarAction(ffi.Pointer<DartObj> textColor, ffi.Pointer<DartObj> disabledTextColor, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> disabledBackgroundColor, ffi.Pointer<ffi.Char> label, VoidCallbackFFI onPressed) {
  final w = SnackBarAction(textColor: textColor.objOrNul(),
      disabledTextColor: disabledTextColor.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      disabledBackgroundColor: disabledBackgroundColor.objOrNul(),
      label: label.cast<Utf8>().toDartString(),
      onPressed: onPressed.toVoidCallbackFn());
  return _createSnackBarActionObjSt(w);
}
SnackBarActionObjSt _createSnackBarActionObjSt(SnackBarAction? w) {
  final SnackBarActionObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.textColor = _addWidget(w.textColor);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.disabledTextColor = _addWidget(w.disabledTextColor);
  stObj.disabledBackgroundColor = _addWidget(w.disabledBackgroundColor);
  stObj.label = w.label.toNativeUtf8().cast<ffi.Char>();
  return stObj;
}

void _setupSnackBar(WidgetFactories f) {
  f.snackBar.snackBar = ffi.Pointer.fromFunction(snackBarSnackBar);
  f.snackBar.createAnimationController = ffi.Pointer.fromFunction(snackBarCreateAnimationController, exception);
}
SnackBarObjSt snackBarSnackBar(DartDartObj content, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> margin, ffi.Pointer<DartObj> padding, ffi.Pointer<ffi.Double> width, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> hitTestBehavior, ffi.Pointer<ffi.Int> behavior, ffi.Pointer<DartObj> action, ffi.Pointer<ffi.Double> actionOverflowThreshold, ffi.Pointer<ffi.Int> showCloseIcon, ffi.Pointer<DartObj> closeIconColor, ffi.Pointer<DartObj> duration, ffi.Pointer<ffi.Int> persist, ffi.Pointer<DartObj> animation, ffi.Pointer<VoidCallbackFFI> onVisible, ffi.Pointer<ffi.Int> dismissDirection, ffi.Pointer<ffi.Int> clipBehavior) {
  final w = SnackBar(content: _widgetsMap[content]! as Widget,
      backgroundColor: backgroundColor.objOrNul(),
      elevation: elevation.doubleOrNul(),
      margin: margin.objOrNul(),
      padding: padding.objOrNul(),
      width: width.doubleOrNul(),
      shape: shape.objOrNul(),
      hitTestBehavior: hitTestBehavior.enumOrNul(HitTestBehavior.values),
      behavior: behavior.enumOrNul(SnackBarBehavior.values),
      action: action.objOrNul(),
      actionOverflowThreshold: actionOverflowThreshold.doubleOrNul(),
      showCloseIcon: showCloseIcon.boolOrNul(),
      closeIconColor: closeIconColor.objOrNul(),
      duration: duration.objOr(Duration(milliseconds: 4000)),
      persist: persist.boolOrNul(),
      animation: animation.objOrNul(),
      onVisible: onVisible.toVoidCallbackFn(),
      dismissDirection: dismissDirection.enumOrNul(DismissDirection.values),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge));
  return _createSnackBarObjSt(w);
}
int snackBarCreateAnimationController(DartDartObj vsync, ffi.Pointer<DartObj> duration, ffi.Pointer<DartObj> reverseDuration) {
  final w = SnackBar.createAnimationController(vsync: _widgetsMap[vsync]! as TickerProvider,
      duration: duration.objOrNul(),
      reverseDuration: reverseDuration.objOrNul());
  return _addWidget(w);
}
SnackBarObjSt _createSnackBarObjSt(SnackBar? w) {
  final SnackBarObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.content = _addWidget(w.content);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.elevation = (w.elevation != null) ? w.elevation! : 0;
  stObj.margin = _addWidget(w.margin);
  stObj.padding = _addWidget(w.padding);
  stObj.width = (w.width != null) ? w.width! : 0;
  stObj.shape = _addWidget(w.shape);
  stObj.hitTestBehavior = (w.hitTestBehavior != null) ? w.hitTestBehavior!.index : 0;
  stObj.behavior = (w.behavior != null) ? w.behavior!.index : 0;
  stObj.action = _createSnackBarActionObjSt(w.action);
  stObj.actionOverflowThreshold = (w.actionOverflowThreshold != null) ? w.actionOverflowThreshold! : 0;
  stObj.showCloseIcon = (w.showCloseIcon != null) ? w.showCloseIcon!.toInt() : 0;
  stObj.closeIconColor = _addWidget(w.closeIconColor);
  stObj.duration = _addWidget(w.duration);
  stObj.persist = w.persist.toInt();
  stObj.animation = _addWidget(w.animation);
  stObj.dismissDirection = (w.dismissDirection != null) ? w.dismissDirection!.index : 0;
  stObj.clipBehavior = w.clipBehavior.index;
  return stObj;
}

void _setupScaffoldMessenger(WidgetFactories f) {
  f.scaffoldMessenger.scaffoldMessenger = ffi.Pointer.fromFunction(scaffoldMessengerScaffoldMessenger);
}
ScaffoldMessengerObjSt scaffoldMessengerScaffoldMessenger(DartDartObj child) {
  final w = ScaffoldMessenger(child: _widgetsMap[child]! as Widget);
  return _createScaffoldMessengerObjSt(w);
}
ScaffoldMessengerObjSt _createScaffoldMessengerObjSt(ScaffoldMessenger? w) {
  final ScaffoldMessengerObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  return stObj;
}

void _setupCard(WidgetFactories f) {
  f.card.card = ffi.Pointer.fromFunction(cardCard);
  f.card.filled = ffi.Pointer.fromFunction(cardFilled);
  f.card.outlined = ffi.Pointer.fromFunction(cardOutlined);
}
CardObjSt cardCard(ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> borderOnForeground, ffi.Pointer<DartObj> margin, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Int> semanticContainer) {
  final w = Card(color: color.objOrNul(),
      shadowColor: shadowColor.objOrNul(),
      surfaceTintColor: surfaceTintColor.objOrNul(),
      elevation: elevation.doubleOrNul(),
      shape: shape.objOrNul(),
      borderOnForeground: borderOnForeground.boolOr(true),
      margin: margin.objOrNul(),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      child: child.objOrNul(),
      semanticContainer: semanticContainer.boolOr(true));
  return _createCardObjSt(w);
}
CardObjSt cardFilled(ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> borderOnForeground, ffi.Pointer<DartObj> margin, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Int> semanticContainer) {
  final w = Card.filled(color: color.objOrNul(),
      shadowColor: shadowColor.objOrNul(),
      surfaceTintColor: surfaceTintColor.objOrNul(),
      elevation: elevation.doubleOrNul(),
      shape: shape.objOrNul(),
      borderOnForeground: borderOnForeground.boolOr(true),
      margin: margin.objOrNul(),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      child: child.objOrNul(),
      semanticContainer: semanticContainer.boolOr(true));
  return _createCardObjSt(w);
}
CardObjSt cardOutlined(ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> borderOnForeground, ffi.Pointer<DartObj> margin, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Int> semanticContainer) {
  final w = Card.outlined(color: color.objOrNul(),
      shadowColor: shadowColor.objOrNul(),
      surfaceTintColor: surfaceTintColor.objOrNul(),
      elevation: elevation.doubleOrNul(),
      shape: shape.objOrNul(),
      borderOnForeground: borderOnForeground.boolOr(true),
      margin: margin.objOrNul(),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      child: child.objOrNul(),
      semanticContainer: semanticContainer.boolOr(true));
  return _createCardObjSt(w);
}
CardObjSt _createCardObjSt(Card? w) {
  final CardObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.color = _addWidget(w.color);
  stObj.shadowColor = _addWidget(w.shadowColor);
  stObj.surfaceTintColor = _addWidget(w.surfaceTintColor);
  stObj.elevation = (w.elevation != null) ? w.elevation! : 0;
  stObj.shape = _addWidget(w.shape);
  stObj.borderOnForeground = w.borderOnForeground.toInt();
  stObj.clipBehavior = (w.clipBehavior != null) ? w.clipBehavior!.index : 0;
  stObj.margin = _addWidget(w.margin);
  stObj.semanticContainer = w.semanticContainer.toInt();
  stObj.child = _addWidget(w.child);
  return stObj;
}

void _setupChip(WidgetFactories f) {
  f.chip.chip = ffi.Pointer.fromFunction(chipChip);
}
ChipObjSt chipChip(ffi.Pointer<DartObj> avatar, DartDartObj label, ffi.Pointer<DartObj> labelStyle, ffi.Pointer<DartObj> labelPadding, ffi.Pointer<DartObj> deleteIcon, ffi.Pointer<VoidCallbackFFI> onDeleted, ffi.Pointer<DartObj> deleteIconColor, ffi.Pointer<ffi.Char> deleteButtonTooltipMessage, ffi.Pointer<DartObj> side, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<DartObj> avatarBoxConstraints, ffi.Pointer<DartObj> deleteIconBoxConstraints) {
  final w = Chip(avatar: avatar.objOrNul(),
      label: _widgetsMap[label]! as Widget,
      labelStyle: labelStyle.objOrNul(),
      labelPadding: labelPadding.objOrNul(),
      deleteIcon: deleteIcon.objOrNul(),
      onDeleted: onDeleted.toVoidCallbackFn(),
      deleteIconColor: deleteIconColor.objOrNul(),
      deleteButtonTooltipMessage: deleteButtonTooltipMessage.strOrNul(),
      side: side.objOrNul(),
      shape: shape.objOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      autofocus: autofocus.boolOr(false),
      backgroundColor: backgroundColor.objOrNul(),
      padding: padding.objOrNul(),
      visualDensity: visualDensity.objOrNul(),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      elevation: elevation.doubleOrNul(),
      shadowColor: shadowColor.objOrNul(),
      surfaceTintColor: surfaceTintColor.objOrNul(),
      avatarBoxConstraints: avatarBoxConstraints.objOrNul(),
      deleteIconBoxConstraints: deleteIconBoxConstraints.objOrNul());
  return _createChipObjSt(w);
}
ChipObjSt _createChipObjSt(Chip? w) {
  final ChipObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.avatar = _addWidget(w.avatar);
  stObj.label = _addWidget(w.label);
  stObj.labelStyle = _createTextStyleObjSt(w.labelStyle);
  stObj.labelPadding = _addWidget(w.labelPadding);
  stObj.side = _createBorderSideObjSt(w.side);
  stObj.shape = _addWidget(w.shape);
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.autofocus = w.autofocus.toInt();
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.padding = _addWidget(w.padding);
  stObj.visualDensity = _createVisualDensityObjSt(w.visualDensity);
  stObj.deleteIcon = _addWidget(w.deleteIcon);
  stObj.deleteIconColor = _addWidget(w.deleteIconColor);
  stObj.deleteButtonTooltipMessage = (w.deleteButtonTooltipMessage != null) ? w.deleteButtonTooltipMessage!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.materialTapTargetSize = (w.materialTapTargetSize != null) ? w.materialTapTargetSize!.index : 0;
  stObj.elevation = (w.elevation != null) ? w.elevation! : 0;
  stObj.shadowColor = _addWidget(w.shadowColor);
  stObj.surfaceTintColor = _addWidget(w.surfaceTintColor);
  stObj.avatarBoxConstraints = _createBoxConstraintsObjSt(w.avatarBoxConstraints);
  stObj.deleteIconBoxConstraints = _createBoxConstraintsObjSt(w.deleteIconBoxConstraints);
  return stObj;
}

void _setupGestureDetector(WidgetFactories f) {
  f.gestureDetector.gestureDetector = ffi.Pointer.fromFunction(gestureDetectorGestureDetector);
}
GestureDetectorObjSt gestureDetectorGestureDetector(ffi.Pointer<DartObj> child, ffi.Pointer<GestureTapCallbackFFI> onTap, ffi.Pointer<GestureTapCancelCallbackFFI> onTapCancel, ffi.Pointer<GestureTapCallbackFFI> onSecondaryTap, ffi.Pointer<GestureTapCancelCallbackFFI> onSecondaryTapCancel, ffi.Pointer<GestureTapCancelCallbackFFI> onTertiaryTapCancel, ffi.Pointer<GestureTapCallbackFFI> onDoubleTap, ffi.Pointer<GestureTapCancelCallbackFFI> onDoubleTapCancel, ffi.Pointer<GestureLongPressCancelCallbackFFI> onLongPressCancel, ffi.Pointer<GestureLongPressCallbackFFI> onLongPress, ffi.Pointer<GestureLongPressUpCallbackFFI> onLongPressUp, ffi.Pointer<GestureLongPressCancelCallbackFFI> onSecondaryLongPressCancel, ffi.Pointer<GestureLongPressCallbackFFI> onSecondaryLongPress, ffi.Pointer<GestureLongPressUpCallbackFFI> onSecondaryLongPressUp, ffi.Pointer<GestureLongPressCancelCallbackFFI> onTertiaryLongPressCancel, ffi.Pointer<GestureLongPressCallbackFFI> onTertiaryLongPress, ffi.Pointer<GestureLongPressUpCallbackFFI> onTertiaryLongPressUp, ffi.Pointer<GestureDragCancelCallbackFFI> onVerticalDragCancel, ffi.Pointer<GestureDragCancelCallbackFFI> onHorizontalDragCancel, ffi.Pointer<GestureDragCancelCallbackFFI> onPanCancel, ffi.Pointer<ffi.Int> behavior, ffi.Pointer<ffi.Int> excludeFromSemantics, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<ffi.Int> trackpadScrollCausesScale, ffi.Pointer<DartObj> trackpadScrollToScaleFactor) {
  final w = GestureDetector(child: child.objOrNul(),
      onTap: onTap.toGestureTapCallbackFn(),
      onTapCancel: onTapCancel.toGestureTapCancelCallbackFn(),
      onSecondaryTap: onSecondaryTap.toGestureTapCallbackFn(),
      onSecondaryTapCancel: onSecondaryTapCancel.toGestureTapCancelCallbackFn(),
      onTertiaryTapCancel: onTertiaryTapCancel.toGestureTapCancelCallbackFn(),
      onDoubleTap: onDoubleTap.toGestureTapCallbackFn(),
      onDoubleTapCancel: onDoubleTapCancel.toGestureTapCancelCallbackFn(),
      onLongPressCancel: onLongPressCancel.toGestureLongPressCancelCallbackFn(),
      onLongPress: onLongPress.toGestureLongPressCallbackFn(),
      onLongPressUp: onLongPressUp.toGestureLongPressUpCallbackFn(),
      onSecondaryLongPressCancel: onSecondaryLongPressCancel.toGestureLongPressCancelCallbackFn(),
      onSecondaryLongPress: onSecondaryLongPress.toGestureLongPressCallbackFn(),
      onSecondaryLongPressUp: onSecondaryLongPressUp.toGestureLongPressUpCallbackFn(),
      onTertiaryLongPressCancel: onTertiaryLongPressCancel.toGestureLongPressCancelCallbackFn(),
      onTertiaryLongPress: onTertiaryLongPress.toGestureLongPressCallbackFn(),
      onTertiaryLongPressUp: onTertiaryLongPressUp.toGestureLongPressUpCallbackFn(),
      onVerticalDragCancel: onVerticalDragCancel.toGestureDragCancelCallbackFn(),
      onHorizontalDragCancel: onHorizontalDragCancel.toGestureDragCancelCallbackFn(),
      onPanCancel: onPanCancel.toGestureDragCancelCallbackFn(),
      behavior: behavior.enumOrNul(HitTestBehavior.values),
      excludeFromSemantics: excludeFromSemantics.boolOr(false),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      trackpadScrollCausesScale: trackpadScrollCausesScale.boolOr(false),
      trackpadScrollToScaleFactor: trackpadScrollToScaleFactor.objOr(kDefaultTrackpadScrollToScaleFactor));
  return _createGestureDetectorObjSt(w);
}
GestureDetectorObjSt _createGestureDetectorObjSt(GestureDetector? w) {
  final GestureDetectorObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.behavior = (w.behavior != null) ? w.behavior!.index : 0;
  stObj.excludeFromSemantics = w.excludeFromSemantics.toInt();
  stObj.dragStartBehavior = w.dragStartBehavior.index;
  stObj.trackpadScrollCausesScale = w.trackpadScrollCausesScale.toInt();
  stObj.trackpadScrollToScaleFactor = _addWidget(w.trackpadScrollToScaleFactor);
  return stObj;
}

void _setupListTile(WidgetFactories f) {
  f.listTile.listTile = ffi.Pointer.fromFunction(listTileListTile);
}
ListTileObjSt listTileListTile(ffi.Pointer<DartObj> leading, ffi.Pointer<DartObj> title, ffi.Pointer<DartObj> subtitle, ffi.Pointer<DartObj> trailing, ffi.Pointer<ffi.Int> isThreeLine, ffi.Pointer<ffi.Int> dense, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> style, ffi.Pointer<DartObj> selectedColor, ffi.Pointer<DartObj> iconColor, ffi.Pointer<DartObj> textColor, ffi.Pointer<DartObj> titleTextStyle, ffi.Pointer<DartObj> subtitleTextStyle, ffi.Pointer<DartObj> leadingAndTrailingTextStyle, ffi.Pointer<DartObj> contentPadding, ffi.Pointer<ffi.Int> enabled, ffi.Pointer<GestureTapCallbackFFI> onTap, ffi.Pointer<GestureLongPressCallbackFFI> onLongPress, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> selected, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<DartObj> tileColor, ffi.Pointer<DartObj> selectedTileColor, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<ffi.Double> horizontalTitleGap, ffi.Pointer<ffi.Double> minVerticalPadding, ffi.Pointer<ffi.Double> minLeadingWidth, ffi.Pointer<ffi.Double> minTileHeight, ffi.Pointer<ffi.Int> titleAlignment, ffi.Pointer<ffi.Int> internalAddSemanticForOnTap) {
  final w = ListTile(leading: leading.objOrNul(),
      title: title.objOrNul(),
      subtitle: subtitle.objOrNul(),
      trailing: trailing.objOrNul(),
      isThreeLine: isThreeLine.boolOrNul(),
      dense: dense.boolOrNul(),
      visualDensity: visualDensity.objOrNul(),
      shape: shape.objOrNul(),
      style: style.enumOrNul(ListTileStyle.values),
      selectedColor: selectedColor.objOrNul(),
      iconColor: iconColor.objOrNul(),
      textColor: textColor.objOrNul(),
      titleTextStyle: titleTextStyle.objOrNul(),
      subtitleTextStyle: subtitleTextStyle.objOrNul(),
      leadingAndTrailingTextStyle: leadingAndTrailingTextStyle.objOrNul(),
      contentPadding: contentPadding.objOrNul(),
      enabled: enabled.boolOr(true),
      onTap: onTap.toGestureTapCallbackFn(),
      onLongPress: onLongPress.toGestureLongPressCallbackFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      selected: selected.boolOr(false),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      autofocus: autofocus.boolOr(false),
      tileColor: tileColor.objOrNul(),
      selectedTileColor: selectedTileColor.objOrNul(),
      enableFeedback: enableFeedback.boolOrNul(),
      horizontalTitleGap: horizontalTitleGap.doubleOrNul(),
      minVerticalPadding: minVerticalPadding.doubleOrNul(),
      minLeadingWidth: minLeadingWidth.doubleOrNul(),
      minTileHeight: minTileHeight.doubleOrNul(),
      titleAlignment: titleAlignment.enumOrNul(ListTileTitleAlignment.values),
      internalAddSemanticForOnTap: internalAddSemanticForOnTap.boolOr(true));
  return _createListTileObjSt(w);
}
ListTileObjSt _createListTileObjSt(ListTile? w) {
  final ListTileObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.leading = _addWidget(w.leading);
  stObj.title = _addWidget(w.title);
  stObj.subtitle = _addWidget(w.subtitle);
  stObj.trailing = _addWidget(w.trailing);
  stObj.isThreeLine = (w.isThreeLine != null) ? w.isThreeLine!.toInt() : 0;
  stObj.dense = (w.dense != null) ? w.dense!.toInt() : 0;
  stObj.visualDensity = _createVisualDensityObjSt(w.visualDensity);
  stObj.shape = _addWidget(w.shape);
  stObj.selectedColor = _addWidget(w.selectedColor);
  stObj.iconColor = _addWidget(w.iconColor);
  stObj.textColor = _addWidget(w.textColor);
  stObj.titleTextStyle = _createTextStyleObjSt(w.titleTextStyle);
  stObj.subtitleTextStyle = _createTextStyleObjSt(w.subtitleTextStyle);
  stObj.leadingAndTrailingTextStyle = _createTextStyleObjSt(w.leadingAndTrailingTextStyle);
  stObj.style = (w.style != null) ? w.style!.index : 0;
  stObj.contentPadding = _addWidget(w.contentPadding);
  stObj.enabled = w.enabled.toInt();
  stObj.selected = w.selected.toInt();
  stObj.focusColor = _addWidget(w.focusColor);
  stObj.hoverColor = _addWidget(w.hoverColor);
  stObj.splashColor = _addWidget(w.splashColor);
  stObj.autofocus = w.autofocus.toInt();
  stObj.tileColor = _addWidget(w.tileColor);
  stObj.selectedTileColor = _addWidget(w.selectedTileColor);
  stObj.enableFeedback = (w.enableFeedback != null) ? w.enableFeedback!.toInt() : 0;
  stObj.horizontalTitleGap = (w.horizontalTitleGap != null) ? w.horizontalTitleGap! : 0;
  stObj.minVerticalPadding = (w.minVerticalPadding != null) ? w.minVerticalPadding! : 0;
  stObj.minLeadingWidth = (w.minLeadingWidth != null) ? w.minLeadingWidth! : 0;
  stObj.minTileHeight = (w.minTileHeight != null) ? w.minTileHeight! : 0;
  stObj.titleAlignment = (w.titleAlignment != null) ? w.titleAlignment!.index : 0;
  stObj.internalAddSemanticForOnTap = w.internalAddSemanticForOnTap.toInt();
  return stObj;
}

void _setupWrap(WidgetFactories f) {
  f.wrap.wrap = ffi.Pointer.fromFunction(wrapWrap);
}
WrapObjSt wrapWrap(ffi.Pointer<ffi.Int> direction, ffi.Pointer<ffi.Int> alignment, ffi.Pointer<ffi.Double> spacing, ffi.Pointer<ffi.Int> runAlignment, ffi.Pointer<ffi.Double> runSpacing, ffi.Pointer<ffi.Int> crossAxisAlignment, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> verticalDirection, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ArrayC> children) {
  final w = Wrap(direction: direction.enumOr(Axis.values, Axis.horizontal),
      alignment: alignment.enumOr(WrapAlignment.values, WrapAlignment.start),
      spacing: spacing.doubleOr(0.0),
      runAlignment: runAlignment.enumOr(WrapAlignment.values, WrapAlignment.start),
      runSpacing: runSpacing.doubleOr(0.0),
      crossAxisAlignment: crossAxisAlignment.enumOr(WrapCrossAlignment.values, WrapCrossAlignment.start),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      verticalDirection: verticalDirection.enumOr(VerticalDirection.values, VerticalDirection.down),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      children: children.listOrEmpty());
  return _createWrapObjSt(w);
}
WrapObjSt _createWrapObjSt(Wrap? w) {
  final WrapObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.direction = w.direction.index;
  stObj.alignment = w.alignment.index;
  stObj.spacing = w.spacing;
  stObj.runAlignment = w.runAlignment.index;
  stObj.runSpacing = w.runSpacing;
  stObj.crossAxisAlignment = w.crossAxisAlignment.index;
  stObj.textDirection = (w.textDirection != null) ? w.textDirection!.index : 0;
  stObj.verticalDirection = w.verticalDirection.index;
  stObj.clipBehavior = w.clipBehavior.index;
  return stObj;
}

void _setupSingleChildScrollView(WidgetFactories f) {
  f.singleChildScrollView.singleChildScrollView = ffi.Pointer.fromFunction(singleChildScrollViewSingleChildScrollView);
}
SingleChildScrollViewObjSt singleChildScrollViewSingleChildScrollView(ffi.Pointer<ffi.Int> scrollDirection, ffi.Pointer<ffi.Int> reverse, ffi.Pointer<DartObj> padding, ffi.Pointer<ffi.Int> primary, ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> hitTestBehavior, ffi.Pointer<ffi.Char> restorationId, ffi.Pointer<ffi.Int> keyboardDismissBehavior) {
  final w = SingleChildScrollView(scrollDirection: scrollDirection.enumOr(Axis.values, Axis.vertical),
      reverse: reverse.boolOr(false),
      padding: padding.objOrNul(),
      primary: primary.boolOrNul(),
      child: child.objOrNul(),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      hitTestBehavior: hitTestBehavior.enumOr(HitTestBehavior.values, HitTestBehavior.opaque),
      restorationId: restorationId.strOrNul(),
      keyboardDismissBehavior: keyboardDismissBehavior.enumOrNul(ScrollViewKeyboardDismissBehavior.values));
  return _createSingleChildScrollViewObjSt(w);
}
SingleChildScrollViewObjSt _createSingleChildScrollViewObjSt(SingleChildScrollView? w) {
  final SingleChildScrollViewObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.scrollDirection = w.scrollDirection.index;
  stObj.reverse = w.reverse.toInt();
  stObj.padding = _addWidget(w.padding);
  stObj.primary = (w.primary != null) ? w.primary!.toInt() : 0;
  stObj.child = _addWidget(w.child);
  stObj.dragStartBehavior = w.dragStartBehavior.index;
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.hitTestBehavior = w.hitTestBehavior.index;
  stObj.restorationId = (w.restorationId != null) ? w.restorationId!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.keyboardDismissBehavior = (w.keyboardDismissBehavior != null) ? w.keyboardDismissBehavior!.index : 0;
  return stObj;
}

void _setupCircularProgressIndicator(WidgetFactories f) {
  f.circularProgressIndicator.circularProgressIndicator = ffi.Pointer.fromFunction(circularProgressIndicatorCircularProgressIndicator);
  f.circularProgressIndicator.adaptive = ffi.Pointer.fromFunction(circularProgressIndicatorAdaptive);
}
CircularProgressIndicatorObjSt circularProgressIndicatorCircularProgressIndicator(ffi.Pointer<ffi.Double> value, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> valueColor, ffi.Pointer<ffi.Double> strokeWidth, ffi.Pointer<ffi.Double> strokeAlign, ffi.Pointer<ffi.Char> semanticsLabel, ffi.Pointer<ffi.Char> semanticsValue, ffi.Pointer<ffi.Int> strokeCap, ffi.Pointer<DartObj> constraints, ffi.Pointer<ffi.Double> trackGap, ffi.Pointer<ffi.Int> year2023, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> controller) {
  final w = CircularProgressIndicator(value: value.doubleOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      color: color.objOrNul(),
      valueColor: valueColor.objOrNul(),
      strokeWidth: strokeWidth.doubleOrNul(),
      strokeAlign: strokeAlign.doubleOrNul(),
      semanticsLabel: semanticsLabel.strOrNul(),
      semanticsValue: semanticsValue.strOrNul(),
      strokeCap: strokeCap.enumOrNul(StrokeCap.values),
      constraints: constraints.objOrNul(),
      trackGap: trackGap.doubleOrNul(),
      year2023: year2023.boolOrNul(),
      padding: padding.objOrNul(),
      controller: controller.objOrNul());
  return _createCircularProgressIndicatorObjSt(w);
}
CircularProgressIndicatorObjSt circularProgressIndicatorAdaptive(ffi.Pointer<ffi.Double> value, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> valueColor, ffi.Pointer<ffi.Double> strokeWidth, ffi.Pointer<ffi.Char> semanticsLabel, ffi.Pointer<ffi.Char> semanticsValue, ffi.Pointer<ffi.Int> strokeCap, ffi.Pointer<ffi.Double> strokeAlign, ffi.Pointer<DartObj> constraints, ffi.Pointer<ffi.Double> trackGap, ffi.Pointer<ffi.Int> year2023, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> controller) {
  final w = CircularProgressIndicator.adaptive(value: value.doubleOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      valueColor: valueColor.objOrNul(),
      strokeWidth: strokeWidth.doubleOrNul(),
      semanticsLabel: semanticsLabel.strOrNul(),
      semanticsValue: semanticsValue.strOrNul(),
      strokeCap: strokeCap.enumOrNul(StrokeCap.values),
      strokeAlign: strokeAlign.doubleOrNul(),
      constraints: constraints.objOrNul(),
      trackGap: trackGap.doubleOrNul(),
      year2023: year2023.boolOrNul(),
      padding: padding.objOrNul(),
      controller: controller.objOrNul());
  return _createCircularProgressIndicatorObjSt(w);
}
CircularProgressIndicatorObjSt _createCircularProgressIndicatorObjSt(CircularProgressIndicator? w) {
  final CircularProgressIndicatorObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.strokeWidth = (w.strokeWidth != null) ? w.strokeWidth! : 0;
  stObj.strokeAlign = (w.strokeAlign != null) ? w.strokeAlign! : 0;
  stObj.strokeCap = (w.strokeCap != null) ? w.strokeCap!.index : 0;
  stObj.constraints = _createBoxConstraintsObjSt(w.constraints);
  stObj.trackGap = (w.trackGap != null) ? w.trackGap! : 0;
  stObj.year2023 = (w.year2023 != null) ? w.year2023!.toInt() : 0;
  stObj.padding = _addWidget(w.padding);
  stObj.controller = _addWidget(w.controller);
  return stObj;
}

void _setupLinearProgressIndicator(WidgetFactories f) {
  f.linearProgressIndicator.linearProgressIndicator = ffi.Pointer.fromFunction(linearProgressIndicatorLinearProgressIndicator);
}
LinearProgressIndicatorObjSt linearProgressIndicatorLinearProgressIndicator(ffi.Pointer<ffi.Double> value, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> valueColor, ffi.Pointer<ffi.Double> minHeight, ffi.Pointer<ffi.Char> semanticsLabel, ffi.Pointer<ffi.Char> semanticsValue, ffi.Pointer<DartObj> borderRadius, ffi.Pointer<DartObj> stopIndicatorColor, ffi.Pointer<ffi.Double> stopIndicatorRadius, ffi.Pointer<ffi.Double> trackGap, ffi.Pointer<ffi.Int> year2023, ffi.Pointer<DartObj> controller) {
  final w = LinearProgressIndicator(value: value.doubleOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      color: color.objOrNul(),
      valueColor: valueColor.objOrNul(),
      minHeight: minHeight.doubleOrNul(),
      semanticsLabel: semanticsLabel.strOrNul(),
      semanticsValue: semanticsValue.strOrNul(),
      borderRadius: borderRadius.objOrNul(),
      stopIndicatorColor: stopIndicatorColor.objOrNul(),
      stopIndicatorRadius: stopIndicatorRadius.doubleOrNul(),
      trackGap: trackGap.doubleOrNul(),
      year2023: year2023.boolOrNul(),
      controller: controller.objOrNul());
  return _createLinearProgressIndicatorObjSt(w);
}
LinearProgressIndicatorObjSt _createLinearProgressIndicatorObjSt(LinearProgressIndicator? w) {
  final LinearProgressIndicatorObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.minHeight = (w.minHeight != null) ? w.minHeight! : 0;
  stObj.borderRadius = _addWidget(w.borderRadius);
  stObj.stopIndicatorColor = _addWidget(w.stopIndicatorColor);
  stObj.stopIndicatorRadius = (w.stopIndicatorRadius != null) ? w.stopIndicatorRadius! : 0;
  stObj.trackGap = (w.trackGap != null) ? w.trackGap! : 0;
  stObj.year2023 = (w.year2023 != null) ? w.year2023!.toInt() : 0;
  stObj.controller = _addWidget(w.controller);
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
  final setStateFn = ffi.NativeCallable<ffi.Void Function(ffi.Pointer<ffi.NativeFunction<ffi.Void Function()>>)>.listener((ffi.Pointer<ffi.NativeFunction<ffi.Void Function()>> cb) => w.setState(cb.asFunction()));
  stObj.setState = setStateFn.nativeFunction;
  final widgetFn = ffi.NativeCallable<DartObj Function()>.isolateLocal(() => _addWidget(w.widget), exceptionalReturn: exception);
  stObj.widget = widgetFn.nativeFunction;
  final contextFn = ffi.NativeCallable<DartObj Function()>.isolateLocal(() => _addWidget(w.context), exceptionalReturn: exception);
  stObj.context = contextFn.nativeFunction;
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

void _setupSubAnimatedState(WidgetFactories f) {
  f.subAnimatedState.subAnimatedState = ffi.Pointer.fromFunction(subAnimatedStateSubAnimatedState);
  f.subAnimatedState.animationController = ffi.Pointer.fromFunction(subAnimatedStateAnimationController, exception);
}
SubAnimatedStateObjSt subAnimatedStateSubAnimatedState(VoidCallbackFFI initStateFn, VoidCallbackDartObjFFI didUpdateWidgetFn, VoidCallbackFFI reassembleFn, VoidCallbackFFI deactivateFn, VoidCallbackFFI activateFn, VoidCallbackFFI disposeFn, DartObjCallbackDartObjFFI buildFn, VoidCallbackFFI didChangeDependenciesFn) {
  final w = SubAnimatedState(initStateFn: initStateFn.toVoidCallbackFn(),
      didUpdateWidgetFn: didUpdateWidgetFn.toVoidCallbackDartObjFn(),
      reassembleFn: reassembleFn.toVoidCallbackFn(),
      deactivateFn: deactivateFn.toVoidCallbackFn(),
      activateFn: activateFn.toVoidCallbackFn(),
      disposeFn: disposeFn.toVoidCallbackFn(),
      buildFn: buildFn.toDartObjCallbackDartObjFn(),
      didChangeDependenciesFn: didChangeDependenciesFn.toVoidCallbackFn());
  final SubAnimatedStateObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  final setStateFn = ffi.NativeCallable<ffi.Void Function(ffi.Pointer<ffi.NativeFunction<ffi.Void Function()>>)>.listener((ffi.Pointer<ffi.NativeFunction<ffi.Void Function()>> cb) => w.setState(cb.asFunction()));
  stObj.setState = setStateFn.nativeFunction;
  final widgetFn = ffi.NativeCallable<DartObj Function()>.isolateLocal(() => _addWidget(w.widget), exceptionalReturn: exception);
  stObj.widget = widgetFn.nativeFunction;
  final contextFn = ffi.NativeCallable<DartObj Function()>.isolateLocal(() => _addWidget(w.context), exceptionalReturn: exception);
  stObj.context = contextFn.nativeFunction;
  final mountedFn = ffi.NativeCallable<ffi.Int Function()>.isolateLocal(() => w.mounted.toInt(), exceptionalReturn: exception);
  stObj.mounted = mountedFn.nativeFunction;
  return stObj;
}
int subAnimatedStateAnimationController(DartDartObj self, DartDartObj duration) {
  final w = SubAnimatedStateMethods.animationController(_widgetsMap[self]! as SubAnimatedState<StatefulWidget>,
      _widgetsMap[duration]! as Duration);
  return _addWidget(w);
}

ffi.Pointer<WidgetFactories> _setupFactories() {
  final ffi.Pointer<WidgetFactories> fp = calloc<WidgetFactories>();
  final f = fp.ref;
  _setupTopFunctions(f);
  _setupTextStyle(f);
  _setupText(f);
  _setupTextSpan(f);
  _setupRichText(f);
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
  _setupFlexParentData(f);
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
  _setupAlignmentDirectional(f);
  _setupMouseRegion(f);
  _setupFontWeight(f);
  _setupDuration(f);
  _setupExpanded(f);
  _setupSafeArea(f);
  _setupRotationTransition(f);
  _setupFadeTransition(f);
  _setupScaleTransition(f);
  _setupColorScheme(f);
  _setupTextTheme(f);
  _setupVisualDensity(f);
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
  _setupTextButton(f);
  _setupNavigatorState(f);
  _setupNavigator(f);
  _setupAlertDialog(f);
  _setupInputDecoration(f);
  _setupTextField(f);
  _setupTextDecoration(f);
  _setupDivider(f);
  _setupFilledButton(f);
  _setupOutlineInputBorder(f);
  _setupSnackBarAction(f);
  _setupSnackBar(f);
  _setupScaffoldMessenger(f);
  _setupCard(f);
  _setupChip(f);
  _setupGestureDetector(f);
  _setupListTile(f);
  _setupWrap(f);
  _setupSingleChildScrollView(f);
  _setupCircularProgressIndicator(f);
  _setupLinearProgressIndicator(f);
  _setupSubState(f);
  _setupSubStatefulWidget(f);
  _setupSubStatelessWidget(f);
  _setupSubAnimatedState(f);
  _setupAlign(f);
  _setupFlex(f);
  _setupBoxParentData(f);
  _setupParentData(f);
  _setupShadow(f);
  _setupShadow(f);
  _setupListenableBuilder(f);
  _setupFlexible(f);
  _setupColorSwatch(f);
  _setupColorSwatch(f);
  return fp;
}
extension on WidgetBuilderFFI {
  WidgetBuilder toWidgetBuilderFn() {
    return (BuildContext context) => _runBuildScope(() {
      DartWidgetBuilderFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(context));
      return _widgetsMap[dFnRet]! as Widget;
    });
  }
}
extension on ffi.Pointer<WidgetBuilderFFI> {
  WidgetBuilder? toWidgetBuilderFn() => (this != ffi.nullptr) ? this.value.toWidgetBuilderFn() : null;
}

extension on TransitionBuilderFFI {
  TransitionBuilder toTransitionBuilderFn() {
    return (BuildContext context, Widget? child) => _runBuildScope(() {
      DartTransitionBuilderFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(context), _addWidget(child));
      return _widgetsMap[dFnRet]! as Widget;
    });
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

extension on DartObjCallbackDartObjDartObjFFI {
  Widget? Function(BuildContext, Animation<double>) toDartObjCallbackDartObjDartObjFn() {
    return (BuildContext b, Animation<double> a) => _runBuildScope(() {
      DartDartObjCallbackDartObjDartObjFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(b), _addWidget(a));
      return dFnRet.objOrNul();
    });
  }
}
extension on ffi.Pointer<DartObjCallbackDartObjDartObjFFI> {
  Widget? Function(BuildContext, Animation<double>)? toDartObjCallbackDartObjDartObjFn() => (this != ffi.nullptr) ? this.value.toDartObjCallbackDartObjDartObjFn() : null;
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

extension on ValueChangedForStringFFI {
  ValueChanged<String> toValueChangedForStringFn() {
    return (String value) {
      DartValueChangedForStringFFIFunction dFn = asFunction();
      dFn(value.toNativeUtf8().cast<ffi.Char>());
    };
  }
}
extension on ffi.Pointer<ValueChangedForStringFFI> {
  ValueChanged<String>? toValueChangedForStringFn() => (this != ffi.nullptr) ? this.value.toValueChangedForStringFn() : null;
}

extension on GestureTapCallbackFFI {
  GestureTapCallback toGestureTapCallbackFn() {
    return () {
      DartGestureTapCallbackFFIFunction dFn = asFunction();
      dFn();
    };
  }
}
extension on ffi.Pointer<GestureTapCallbackFFI> {
  GestureTapCallback? toGestureTapCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureTapCallbackFn() : null;
}

extension on InputCounterWidgetBuilderFFI {
  InputCounterWidgetBuilder toInputCounterWidgetBuilderFn() {
    return (BuildContext context, {required int currentLength, required bool isFocused, required int? maxLength}) => _runBuildScope(() {
      DartInputCounterWidgetBuilderFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(context), currentLength, isFocused.toInt(), maxLength!);
      return dFnRet.objOrNul();
    });
  }
}
extension on ffi.Pointer<InputCounterWidgetBuilderFFI> {
  InputCounterWidgetBuilder? toInputCounterWidgetBuilderFn() => (this != ffi.nullptr) ? this.value.toInputCounterWidgetBuilderFn() : null;
}

extension on GestureTapCancelCallbackFFI {
  GestureTapCancelCallback toGestureTapCancelCallbackFn() {
    return () {
      DartGestureTapCancelCallbackFFIFunction dFn = asFunction();
      dFn();
    };
  }
}
extension on ffi.Pointer<GestureTapCancelCallbackFFI> {
  GestureTapCancelCallback? toGestureTapCancelCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureTapCancelCallbackFn() : null;
}

extension on GestureLongPressCancelCallbackFFI {
  GestureLongPressCancelCallback toGestureLongPressCancelCallbackFn() {
    return () {
      DartGestureLongPressCancelCallbackFFIFunction dFn = asFunction();
      dFn();
    };
  }
}
extension on ffi.Pointer<GestureLongPressCancelCallbackFFI> {
  GestureLongPressCancelCallback? toGestureLongPressCancelCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureLongPressCancelCallbackFn() : null;
}

extension on GestureLongPressCallbackFFI {
  GestureLongPressCallback toGestureLongPressCallbackFn() {
    return () {
      DartGestureLongPressCallbackFFIFunction dFn = asFunction();
      dFn();
    };
  }
}
extension on ffi.Pointer<GestureLongPressCallbackFFI> {
  GestureLongPressCallback? toGestureLongPressCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureLongPressCallbackFn() : null;
}

extension on GestureLongPressUpCallbackFFI {
  GestureLongPressUpCallback toGestureLongPressUpCallbackFn() {
    return () {
      DartGestureLongPressUpCallbackFFIFunction dFn = asFunction();
      dFn();
    };
  }
}
extension on ffi.Pointer<GestureLongPressUpCallbackFFI> {
  GestureLongPressUpCallback? toGestureLongPressUpCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureLongPressUpCallbackFn() : null;
}

extension on GestureDragCancelCallbackFFI {
  GestureDragCancelCallback toGestureDragCancelCallbackFn() {
    return () {
      DartGestureDragCancelCallbackFFIFunction dFn = asFunction();
      dFn();
    };
  }
}
extension on ffi.Pointer<GestureDragCancelCallbackFFI> {
  GestureDragCancelCallback? toGestureDragCancelCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureDragCancelCallbackFn() : null;
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
    return (BuildContext b) => _runBuildScope(() {
      DartDartObjCallbackDartObjFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(b));
      return _widgetsMap[dFnRet]! as Widget;
    });
  }
}
extension on ffi.Pointer<DartObjCallbackDartObjFFI> {
  Widget Function(BuildContext)? toDartObjCallbackDartObjFn() => (this != ffi.nullptr) ? this.value.toDartObjCallbackDartObjFn() : null;
}

extension on DartObjCallbackFFI {
  State<StatefulWidget> Function() toDartObjCallbackFn() {
    return () => _runBuildScope(() {
      DartDartObjCallbackFFIFunction dFn = asFunction();
      final dFnRet = dFn();
      return _widgetsMap[dFnRet]! as State<StatefulWidget>;
    });
  }
}
extension on ffi.Pointer<DartObjCallbackFFI> {
  State<StatefulWidget> Function()? toDartObjCallbackFn() => (this != ffi.nullptr) ? this.value.toDartObjCallbackFn() : null;
}

