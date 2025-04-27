package dev.equo.ewt;
import dev.equo.ewt.ffm.*;
import dev.equo.ewt.util.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalDouble;
import java.lang.foreign.*;
import java.util.function.*;
class WidgetConstructors extends WidgetConstructorsBase {
  MemorySegment textStyleTextStyle(Optional<Boolean> inherit, Optional<Color> color, Optional<Color> backgroundColor, OptionalDouble fontSize, Optional<FontWeight> fontWeight, Optional<FontStyle> fontStyle, OptionalDouble letterSpacing, OptionalDouble wordSpacing, Optional<TextBaseline> textBaseline, OptionalDouble height, Optional<TextLeadingDistribution> leadingDistribution, Optional<List<Shadow>> shadows, Optional<TextDecoration> decoration, Optional<Color> decorationColor, Optional<TextDecorationStyle> decorationStyle, OptionalDouble decorationThickness, Optional<String> debugLabel, Optional<String> fontFamily, Optional<List<String>> fontFamilyFallback, Optional<String> _package, Optional<TextOverflow> overflow) {
    var st = WidgetFactories.textStyle(factories);
    var fn = WidgetFactories.TextStyleSt.textStyle(st);
    return WidgetFactories.TextStyleSt.textStyle.invoke(fn, arena, ptrBool(inherit),
      ptrObj(color),
      ptrObj(backgroundColor),
      ptr(fontSize),
      ptrObj(fontWeight),
      ptrEnum(fontStyle),
      ptr(letterSpacing),
      ptr(wordSpacing),
      ptrEnum(textBaseline),
      ptr(height),
      ptrEnum(leadingDistribution),
      ptrList(shadows),
      ptrObj(decoration),
      ptrObj(decorationColor),
      ptrEnum(decorationStyle),
      ptr(decorationThickness),
      ptrStr(debugLabel),
      ptrStr(fontFamily),
      ptrStrList(fontFamilyFallback),
      ptrStr(_package),
      ptrEnum(overflow));
  }
  MemorySegment textStyleLerp(TextStyle a, TextStyle b, double t) {
    var st = WidgetFactories.textStyle(factories);
    var fn = WidgetFactories.TextStyleSt.lerp(st);
    return WidgetFactories.TextStyleSt.lerp.invoke(fn, arena, a != null ? a.getId() : null,
      b != null ? b.getId() : null,
      t);
  }

  int colorColor(int value) {
    var st = WidgetFactories.color(factories);
    var fn = WidgetFactories.ColorSt.color(st);
    return WidgetFactories.ColorSt.color.invoke(fn, value);
  }
  int colorFrom(double alpha, double red, double green, double blue, Optional<ColorSpace> colorSpace) {
    var st = WidgetFactories.color(factories);
    var fn = WidgetFactories.ColorSt.from(st);
    return WidgetFactories.ColorSt.from.invoke(fn, alpha,
      red,
      green,
      blue,
      ptrEnum(colorSpace));
  }
  int colorFromARGB(int a, int r, int g, int b) {
    var st = WidgetFactories.color(factories);
    var fn = WidgetFactories.ColorSt.fromARGB(st);
    return WidgetFactories.ColorSt.fromARGB.invoke(fn, a,
      r,
      g,
      b);
  }
  int colorFromRGBO(int r, int g, int b, double opacity) {
    var st = WidgetFactories.color(factories);
    var fn = WidgetFactories.ColorSt.fromRGBO(st);
    return WidgetFactories.ColorSt.fromRGBO.invoke(fn, r,
      g,
      b,
      opacity);
  }
  int colorLerp(Color x, Color y, double t) {
    var st = WidgetFactories.color(factories);
    var fn = WidgetFactories.ColorSt.lerp(st);
    return WidgetFactories.ColorSt.lerp.invoke(fn, x != null ? x.getId() : null,
      y != null ? y.getId() : null,
      t);
  }
  int colorAlphaBlend(Color foreground, Color background) {
    var st = WidgetFactories.color(factories);
    var fn = WidgetFactories.ColorSt.alphaBlend(st);
    return WidgetFactories.ColorSt.alphaBlend.invoke(fn, foreground.getId(),
      background.getId());
  }

  int fontWeightLerp(FontWeight a, FontWeight b, double t) {
    var st = WidgetFactories.fontWeight(factories);
    var fn = WidgetFactories.FontWeightSt.lerp(st);
    return WidgetFactories.FontWeightSt.lerp.invoke(fn, a != null ? a.getId() : null,
      b != null ? b.getId() : null,
      t);
  }
  int fontWeightW100() {
    var st = WidgetFactories.fontWeight(factories);
    return WidgetFactories.FontWeightSt.w100(st);
  }
  int fontWeightW200() {
    var st = WidgetFactories.fontWeight(factories);
    return WidgetFactories.FontWeightSt.w200(st);
  }
  int fontWeightW300() {
    var st = WidgetFactories.fontWeight(factories);
    return WidgetFactories.FontWeightSt.w300(st);
  }
  int fontWeightW400() {
    var st = WidgetFactories.fontWeight(factories);
    return WidgetFactories.FontWeightSt.w400(st);
  }
  int fontWeightW500() {
    var st = WidgetFactories.fontWeight(factories);
    return WidgetFactories.FontWeightSt.w500(st);
  }
  int fontWeightW600() {
    var st = WidgetFactories.fontWeight(factories);
    return WidgetFactories.FontWeightSt.w600(st);
  }
  int fontWeightW700() {
    var st = WidgetFactories.fontWeight(factories);
    return WidgetFactories.FontWeightSt.w700(st);
  }
  int fontWeightW800() {
    var st = WidgetFactories.fontWeight(factories);
    return WidgetFactories.FontWeightSt.w800(st);
  }
  int fontWeightW900() {
    var st = WidgetFactories.fontWeight(factories);
    return WidgetFactories.FontWeightSt.w900(st);
  }

  int textDecorationCombine(List<TextDecoration> decorations) {
    var st = WidgetFactories.textDecoration(factories);
    var fn = WidgetFactories.TextDecorationSt.combine(st);
    return WidgetFactories.TextDecorationSt.combine.invoke(fn, ptrList(decorations));
  }
  int textDecorationNone() {
    var st = WidgetFactories.textDecoration(factories);
    return WidgetFactories.TextDecorationSt.none(st);
  }
  int textDecorationUnderline() {
    var st = WidgetFactories.textDecoration(factories);
    return WidgetFactories.TextDecorationSt.underline(st);
  }
  int textDecorationOverline() {
    var st = WidgetFactories.textDecoration(factories);
    return WidgetFactories.TextDecorationSt.overline(st);
  }
  int textDecorationLineThrough() {
    var st = WidgetFactories.textDecoration(factories);
    return WidgetFactories.TextDecorationSt.lineThrough(st);
  }

  MemorySegment textText(String data, Optional<TextStyle> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis, Optional<Color> selectionColor) {
    var st = WidgetFactories.text(factories);
    var fn = WidgetFactories.TextSt.text(st);
    return WidgetFactories.TextSt.text.invoke(fn, arena, arena.allocateFrom(data),
      ptrObj(style),
      ptrEnum(textAlign),
      ptrEnum(textDirection),
      ptrBool(softWrap),
      ptrEnum(overflow),
      ptr(textScaleFactor),
      ptr(maxLines),
      ptrStr(semanticsLabel),
      ptrEnum(textWidthBasis),
      ptrObj(selectionColor));
  }
  MemorySegment textRich(InlineSpan textSpan, Optional<TextStyle> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis, Optional<Color> selectionColor) {
    var st = WidgetFactories.text(factories);
    var fn = WidgetFactories.TextSt.rich(st);
    return WidgetFactories.TextSt.rich.invoke(fn, arena, textSpan.getId(),
      ptrObj(style),
      ptrEnum(textAlign),
      ptrEnum(textDirection),
      ptrBool(softWrap),
      ptrEnum(overflow),
      ptr(textScaleFactor),
      ptr(maxLines),
      ptrStr(semanticsLabel),
      ptrEnum(textWidthBasis),
      ptrObj(selectionColor));
  }

  MemorySegment textSpanTextSpan(Optional<String> text, Optional<List<InlineSpan>> children, Optional<TextStyle> style, Optional<String> semanticsLabel, Optional<Boolean> spellOut) {
    var st = WidgetFactories.textSpan(factories);
    var fn = WidgetFactories.TextSpanSt.textSpan(st);
    return WidgetFactories.TextSpanSt.textSpan.invoke(fn, arena, ptrStr(text),
      ptrList(children),
      ptrObj(style),
      ptrStr(semanticsLabel),
      ptrBool(spellOut));
  }

  MemorySegment richTextRichText(InlineSpan text, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<TextWidthBasis> textWidthBasis, Optional<Color> selectionColor) {
    var st = WidgetFactories.richText(factories);
    var fn = WidgetFactories.RichTextSt.richText(st);
    return WidgetFactories.RichTextSt.richText.invoke(fn, arena, text.getId(),
      ptrEnum(textAlign),
      ptrEnum(textDirection),
      ptrBool(softWrap),
      ptrEnum(overflow),
      ptr(textScaleFactor),
      ptr(maxLines),
      ptrEnum(textWidthBasis),
      ptrObj(selectionColor));
  }

  MemorySegment centerCenter(OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<Widget> child) {
    var st = WidgetFactories.center(factories);
    var fn = WidgetFactories.CenterSt.center(st);
    return WidgetFactories.CenterSt.center.invoke(fn, arena, ptr(widthFactor),
      ptr(heightFactor),
      ptrObj(child));
  }

  MemorySegment alignAlign(Optional<AlignmentGeometry> alignment, OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<Widget> child) {
    var st = WidgetFactories.align(factories);
    var fn = WidgetFactories.AlignSt.align(st);
    return WidgetFactories.AlignSt.align.invoke(fn, arena, ptrObj(alignment),
      ptr(widthFactor),
      ptr(heightFactor),
      ptrObj(child));
  }

  MemorySegment columnColumn(Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, OptionalDouble spacing, Optional<List<Widget>> children) {
    var st = WidgetFactories.column(factories);
    var fn = WidgetFactories.ColumnSt.column(st);
    return WidgetFactories.ColumnSt.column.invoke(fn, arena, ptrEnum(mainAxisAlignment),
      ptrEnum(mainAxisSize),
      ptrEnum(crossAxisAlignment),
      ptrEnum(textDirection),
      ptrEnum(verticalDirection),
      ptrEnum(textBaseline),
      ptr(spacing),
      ptrList(children));
  }

  MemorySegment flexFlex(Axis direction, Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, Optional<Clip> clipBehavior, OptionalDouble spacing, Optional<List<Widget>> children) {
    var st = WidgetFactories.flex(factories);
    var fn = WidgetFactories.FlexSt.flex(st);
    return WidgetFactories.FlexSt.flex.invoke(fn, arena, direction.ordinal(),
      ptrEnum(mainAxisAlignment),
      ptrEnum(mainAxisSize),
      ptrEnum(crossAxisAlignment),
      ptrEnum(textDirection),
      ptrEnum(verticalDirection),
      ptrEnum(textBaseline),
      ptrEnum(clipBehavior),
      ptr(spacing),
      ptrList(children));
  }

  MemorySegment rowRow(Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, OptionalDouble spacing, Optional<List<Widget>> children) {
    var st = WidgetFactories.row(factories);
    var fn = WidgetFactories.RowSt.row(st);
    return WidgetFactories.RowSt.row.invoke(fn, arena, ptrEnum(mainAxisAlignment),
      ptrEnum(mainAxisSize),
      ptrEnum(crossAxisAlignment),
      ptrEnum(textDirection),
      ptrEnum(verticalDirection),
      ptrEnum(textBaseline),
      ptr(spacing),
      ptrList(children));
  }

  MemorySegment iconDataIconData(int codePoint, Optional<String> fontFamily, Optional<String> fontPackage, Optional<Boolean> matchTextDirection, Optional<List<String>> fontFamilyFallback) {
    var st = WidgetFactories.iconData(factories);
    var fn = WidgetFactories.IconDataSt.iconData(st);
    return WidgetFactories.IconDataSt.iconData.invoke(fn, arena, codePoint,
      ptrStr(fontFamily),
      ptrStr(fontPackage),
      ptrBool(matchTextDirection),
      ptrStrList(fontFamilyFallback));
  }

  MemorySegment iconIcon(IconData icon, OptionalDouble size, OptionalDouble fill, OptionalDouble weight, OptionalDouble grade, OptionalDouble opticalSize, Optional<Color> color, Optional<List<Shadow>> shadows, Optional<String> semanticLabel, Optional<TextDirection> textDirection, Optional<Boolean> applyTextScaling, Optional<BlendMode> blendMode) {
    var st = WidgetFactories.icon(factories);
    var fn = WidgetFactories.IconSt.icon(st);
    return WidgetFactories.IconSt.icon.invoke(fn, arena, icon != null ? icon.getId() : null,
      ptr(size),
      ptr(fill),
      ptr(weight),
      ptr(grade),
      ptr(opticalSize),
      ptrObj(color),
      ptrList(shadows),
      ptrStr(semanticLabel),
      ptrEnum(textDirection),
      ptrBool(applyTextScaling),
      ptrEnum(blendMode));
  }

  MemorySegment transformRotate(double angle, Optional<Offset> origin, Optional<AlignmentGeometry> alignment, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<Widget> child) {
    var st = WidgetFactories.transform(factories);
    var fn = WidgetFactories.TransformSt.rotate(st);
    return WidgetFactories.TransformSt.rotate.invoke(fn, arena, angle,
      ptrObj(origin),
      ptrObj(alignment),
      ptrBool(transformHitTests),
      ptrEnum(filterQuality),
      ptrObj(child));
  }
  MemorySegment transformTranslate(Offset offset, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<Widget> child) {
    var st = WidgetFactories.transform(factories);
    var fn = WidgetFactories.TransformSt.translate(st);
    return WidgetFactories.TransformSt.translate.invoke(fn, arena, offset.getId(),
      ptrBool(transformHitTests),
      ptrEnum(filterQuality),
      ptrObj(child));
  }
  MemorySegment transformScale(OptionalDouble scale, OptionalDouble scaleX, OptionalDouble scaleY, Optional<Offset> origin, Optional<AlignmentGeometry> alignment, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<Widget> child) {
    var st = WidgetFactories.transform(factories);
    var fn = WidgetFactories.TransformSt.scale(st);
    return WidgetFactories.TransformSt.scale.invoke(fn, arena, ptr(scale),
      ptr(scaleX),
      ptr(scaleY),
      ptrObj(origin),
      ptrObj(alignment),
      ptrBool(transformHitTests),
      ptrEnum(filterQuality),
      ptrObj(child));
  }
  MemorySegment transformFlip(Optional<Boolean> flipX, Optional<Boolean> flipY, Optional<Offset> origin, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<Widget> child) {
    var st = WidgetFactories.transform(factories);
    var fn = WidgetFactories.TransformSt.flip(st);
    return WidgetFactories.TransformSt.flip.invoke(fn, arena, ptrBool(flipX),
      ptrBool(flipY),
      ptrObj(origin),
      ptrBool(transformHitTests),
      ptrEnum(filterQuality),
      ptrObj(child));
  }

  int offsetOffset(double dx, double dy) {
    var st = WidgetFactories.offset(factories);
    var fn = WidgetFactories.OffsetSt.offset(st);
    return WidgetFactories.OffsetSt.offset.invoke(fn, dx,
      dy);
  }
  int offsetFromDirection(double direction, OptionalDouble distance) {
    var st = WidgetFactories.offset(factories);
    var fn = WidgetFactories.OffsetSt.fromDirection(st);
    return WidgetFactories.OffsetSt.fromDirection.invoke(fn, direction,
      ptr(distance));
  }
  int offsetLerp(Offset a, Offset b, double t) {
    var st = WidgetFactories.offset(factories);
    var fn = WidgetFactories.OffsetSt.lerp(st);
    return WidgetFactories.OffsetSt.lerp.invoke(fn, a != null ? a.getId() : null,
      b != null ? b.getId() : null,
      t);
  }

  MemorySegment opacityOpacity(double opacity, Optional<Boolean> alwaysIncludeSemantics, Optional<Widget> child) {
    var st = WidgetFactories.opacity(factories);
    var fn = WidgetFactories.OpacitySt.opacity(st);
    return WidgetFactories.OpacitySt.opacity.invoke(fn, arena, opacity,
      ptrBool(alwaysIncludeSemantics),
      ptrObj(child));
  }

  MemorySegment stackStack(Optional<AlignmentGeometry> alignment, Optional<TextDirection> textDirection, Optional<StackFit> fit, Optional<Clip> clipBehavior, Optional<List<Widget>> children) {
    var st = WidgetFactories.stack(factories);
    var fn = WidgetFactories.StackSt.stack(st);
    return WidgetFactories.StackSt.stack.invoke(fn, arena, ptrObj(alignment),
      ptrEnum(textDirection),
      ptrEnum(fit),
      ptrEnum(clipBehavior),
      ptrList(children));
  }

  MemorySegment boxConstraintsBoxConstraints(OptionalDouble minWidth, OptionalDouble maxWidth, OptionalDouble minHeight, OptionalDouble maxHeight) {
    var st = WidgetFactories.boxConstraints(factories);
    var fn = WidgetFactories.BoxConstraintsSt.boxConstraints(st);
    return WidgetFactories.BoxConstraintsSt.boxConstraints.invoke(fn, arena, ptr(minWidth),
      ptr(maxWidth),
      ptr(minHeight),
      ptr(maxHeight));
  }
  MemorySegment boxConstraintsTightFor(OptionalDouble width, OptionalDouble height) {
    var st = WidgetFactories.boxConstraints(factories);
    var fn = WidgetFactories.BoxConstraintsSt.tightFor(st);
    return WidgetFactories.BoxConstraintsSt.tightFor.invoke(fn, arena, ptr(width),
      ptr(height));
  }
  MemorySegment boxConstraintsTightForFinite(OptionalDouble width, OptionalDouble height) {
    var st = WidgetFactories.boxConstraints(factories);
    var fn = WidgetFactories.BoxConstraintsSt.tightForFinite(st);
    return WidgetFactories.BoxConstraintsSt.tightForFinite.invoke(fn, arena, ptr(width),
      ptr(height));
  }
  MemorySegment boxConstraintsExpand(OptionalDouble width, OptionalDouble height) {
    var st = WidgetFactories.boxConstraints(factories);
    var fn = WidgetFactories.BoxConstraintsSt.expand(st);
    return WidgetFactories.BoxConstraintsSt.expand.invoke(fn, arena, ptr(width),
      ptr(height));
  }
  MemorySegment boxConstraintsLerp(BoxConstraints a, BoxConstraints b, double t) {
    var st = WidgetFactories.boxConstraints(factories);
    var fn = WidgetFactories.BoxConstraintsSt.lerp(st);
    return WidgetFactories.BoxConstraintsSt.lerp.invoke(fn, arena, a != null ? a.getId() : null,
      b != null ? b.getId() : null,
      t);
  }

  MemorySegment containerContainer(Optional<AlignmentGeometry> alignment, Optional<EdgeInsetsGeometry> padding, Optional<Color> color, Optional<Decoration> decoration, Optional<Decoration> foregroundDecoration, OptionalDouble width, OptionalDouble height, Optional<BoxConstraints> constraints, Optional<EdgeInsetsGeometry> margin, Optional<AlignmentGeometry> transformAlignment, Optional<Widget> child, Optional<Clip> clipBehavior) {
    var st = WidgetFactories.container(factories);
    var fn = WidgetFactories.ContainerSt.container(st);
    return WidgetFactories.ContainerSt.container.invoke(fn, arena, ptrObj(alignment),
      ptrObj(padding),
      ptrObj(color),
      ptrObj(decoration),
      ptrObj(foregroundDecoration),
      ptr(width),
      ptr(height),
      ptrObj(constraints),
      ptrObj(margin),
      ptrObj(transformAlignment),
      ptrObj(child),
      ptrEnum(clipBehavior));
  }

  int edgeInsetsGeometryInfinity() {
    var st = WidgetFactories.edgeInsetsGeometry(factories);
    return WidgetFactories.EdgeInsetsGeometrySt.infinity(st);
  }

  int stackParentDataStackParentData() {
    var st = WidgetFactories.stackParentData(factories);
    var fn = WidgetFactories.StackParentDataSt.stackParentData(st);
    return WidgetFactories.StackParentDataSt.stackParentData.invoke(fn);
  }

  int boxParentDataBoxParentData() {
    var st = WidgetFactories.boxParentData(factories);
    var fn = WidgetFactories.BoxParentDataSt.boxParentData(st);
    return WidgetFactories.BoxParentDataSt.boxParentData.invoke(fn);
  }

  int parentDataParentData() {
    var st = WidgetFactories.parentData(factories);
    var fn = WidgetFactories.ParentDataSt.parentData(st);
    return WidgetFactories.ParentDataSt.parentData.invoke(fn);
  }

  int flexParentDataFlexParentData() {
    var st = WidgetFactories.flexParentData(factories);
    var fn = WidgetFactories.FlexParentDataSt.flexParentData(st);
    return WidgetFactories.FlexParentDataSt.flexParentData.invoke(fn);
  }

  MemorySegment positionedPositioned(OptionalDouble left, OptionalDouble top, OptionalDouble right, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, Widget child) {
    var st = WidgetFactories.positioned(factories);
    var fn = WidgetFactories.PositionedSt.positioned(st);
    return WidgetFactories.PositionedSt.positioned.invoke(fn, arena, ptr(left),
      ptr(top),
      ptr(right),
      ptr(bottom),
      ptr(width),
      ptr(height),
      child.getId());
  }
  MemorySegment positionedFill(OptionalDouble left, OptionalDouble top, OptionalDouble right, OptionalDouble bottom, Widget child) {
    var st = WidgetFactories.positioned(factories);
    var fn = WidgetFactories.PositionedSt.fill(st);
    return WidgetFactories.PositionedSt.fill.invoke(fn, arena, ptr(left),
      ptr(top),
      ptr(right),
      ptr(bottom),
      child.getId());
  }
  MemorySegment positionedDirectional(TextDirection textDirection, OptionalDouble start, OptionalDouble top, OptionalDouble end, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, Widget child) {
    var st = WidgetFactories.positioned(factories);
    var fn = WidgetFactories.PositionedSt.directional(st);
    return WidgetFactories.PositionedSt.directional.invoke(fn, arena, textDirection.ordinal(),
      ptr(start),
      ptr(top),
      ptr(end),
      ptr(bottom),
      ptr(width),
      ptr(height),
      child.getId());
  }

  MemorySegment boxDecorationBoxDecoration(Optional<Color> color, Optional<BoxBorder> border, Optional<BorderRadiusGeometry> borderRadius, Optional<List<BoxShadow>> boxShadow, Optional<BlendMode> backgroundBlendMode, Optional<BoxShape> shape) {
    var st = WidgetFactories.boxDecoration(factories);
    var fn = WidgetFactories.BoxDecorationSt.boxDecoration(st);
    return WidgetFactories.BoxDecorationSt.boxDecoration.invoke(fn, arena, ptrObj(color),
      ptrObj(border),
      ptrObj(borderRadius),
      ptrList(boxShadow),
      ptrEnum(backgroundBlendMode),
      ptrEnum(shape));
  }
  MemorySegment boxDecorationLerp(BoxDecoration a, BoxDecoration b, double t) {
    var st = WidgetFactories.boxDecoration(factories);
    var fn = WidgetFactories.BoxDecorationSt.lerp(st);
    return WidgetFactories.BoxDecorationSt.lerp.invoke(fn, arena, a != null ? a.getId() : null,
      b != null ? b.getId() : null,
      t);
  }

  int radiusCircular(double radius) {
    var st = WidgetFactories.radius(factories);
    var fn = WidgetFactories.RadiusSt.circular(st);
    return WidgetFactories.RadiusSt.circular.invoke(fn, radius);
  }
  int radiusElliptical(double x, double y) {
    var st = WidgetFactories.radius(factories);
    var fn = WidgetFactories.RadiusSt.elliptical(st);
    return WidgetFactories.RadiusSt.elliptical.invoke(fn, x,
      y);
  }
  int radiusLerp(Radius a, Radius b, double t) {
    var st = WidgetFactories.radius(factories);
    var fn = WidgetFactories.RadiusSt.lerp(st);
    return WidgetFactories.RadiusSt.lerp.invoke(fn, a != null ? a.getId() : null,
      b != null ? b.getId() : null,
      t);
  }

  MemorySegment borderRadiusAll(Radius radius) {
    var st = WidgetFactories.borderRadius(factories);
    var fn = WidgetFactories.BorderRadiusSt.all(st);
    return WidgetFactories.BorderRadiusSt.all.invoke(fn, arena, radius.getId());
  }
  MemorySegment borderRadiusCircular(double radius) {
    var st = WidgetFactories.borderRadius(factories);
    var fn = WidgetFactories.BorderRadiusSt.circular(st);
    return WidgetFactories.BorderRadiusSt.circular.invoke(fn, arena, radius);
  }
  MemorySegment borderRadiusVertical(Optional<Radius> top, Optional<Radius> bottom) {
    var st = WidgetFactories.borderRadius(factories);
    var fn = WidgetFactories.BorderRadiusSt.vertical(st);
    return WidgetFactories.BorderRadiusSt.vertical.invoke(fn, arena, ptrObj(top),
      ptrObj(bottom));
  }
  MemorySegment borderRadiusHorizontal(Optional<Radius> left, Optional<Radius> right) {
    var st = WidgetFactories.borderRadius(factories);
    var fn = WidgetFactories.BorderRadiusSt.horizontal(st);
    return WidgetFactories.BorderRadiusSt.horizontal.invoke(fn, arena, ptrObj(left),
      ptrObj(right));
  }
  MemorySegment borderRadiusOnly(Optional<Radius> topLeft, Optional<Radius> topRight, Optional<Radius> bottomLeft, Optional<Radius> bottomRight) {
    var st = WidgetFactories.borderRadius(factories);
    var fn = WidgetFactories.BorderRadiusSt.only(st);
    return WidgetFactories.BorderRadiusSt.only.invoke(fn, arena, ptrObj(topLeft),
      ptrObj(topRight),
      ptrObj(bottomLeft),
      ptrObj(bottomRight));
  }
  MemorySegment borderRadiusLerp(BorderRadius a, BorderRadius b, double t) {
    var st = WidgetFactories.borderRadius(factories);
    var fn = WidgetFactories.BorderRadiusSt.lerp(st);
    return WidgetFactories.BorderRadiusSt.lerp.invoke(fn, arena, a != null ? a.getId() : null,
      b != null ? b.getId() : null,
      t);
  }

  MemorySegment boxShadowBoxShadow(Optional<Color> color, Optional<Offset> offset, OptionalDouble blurRadius, OptionalDouble spreadRadius, Optional<BlurStyle> blurStyle) {
    var st = WidgetFactories.boxShadow(factories);
    var fn = WidgetFactories.BoxShadowSt.boxShadow(st);
    return WidgetFactories.BoxShadowSt.boxShadow.invoke(fn, arena, ptrObj(color),
      ptrObj(offset),
      ptr(blurRadius),
      ptr(spreadRadius),
      ptrEnum(blurStyle));
  }
  MemorySegment boxShadowLerp(BoxShadow a, BoxShadow b, double t) {
    var st = WidgetFactories.boxShadow(factories);
    var fn = WidgetFactories.BoxShadowSt.lerp(st);
    return WidgetFactories.BoxShadowSt.lerp.invoke(fn, arena, a != null ? a.getId() : null,
      b != null ? b.getId() : null,
      t);
  }

  int shadowShadow(Optional<Color> color, Optional<Offset> offset, OptionalDouble blurRadius) {
    var st = WidgetFactories.shadow(factories);
    var fn = WidgetFactories.ShadowSt.shadow(st);
    return WidgetFactories.ShadowSt.shadow.invoke(fn, ptrObj(color),
      ptrObj(offset),
      ptr(blurRadius));
  }
  int shadowLerp(Shadow a, Shadow b, double t) {
    var st = WidgetFactories.shadow(factories);
    var fn = WidgetFactories.ShadowSt.lerp(st);
    return WidgetFactories.ShadowSt.lerp.invoke(fn, a != null ? a.getId() : null,
      b != null ? b.getId() : null,
      t);
  }

  MemorySegment paddingPadding(EdgeInsetsGeometry padding, Optional<Widget> child) {
    var st = WidgetFactories.padding(factories);
    var fn = WidgetFactories.PaddingSt.padding(st);
    return WidgetFactories.PaddingSt.padding.invoke(fn, arena, padding.getId(),
      ptrObj(child));
  }

  MemorySegment edgeInsetsFromLTRB(double left, double top, double right, double bottom) {
    var st = WidgetFactories.edgeInsets(factories);
    var fn = WidgetFactories.EdgeInsetsSt.fromLTRB(st);
    return WidgetFactories.EdgeInsetsSt.fromLTRB.invoke(fn, arena, left,
      top,
      right,
      bottom);
  }
  MemorySegment edgeInsetsAll(double value) {
    var st = WidgetFactories.edgeInsets(factories);
    var fn = WidgetFactories.EdgeInsetsSt.all(st);
    return WidgetFactories.EdgeInsetsSt.all.invoke(fn, arena, value);
  }
  MemorySegment edgeInsetsOnly(OptionalDouble left, OptionalDouble top, OptionalDouble right, OptionalDouble bottom) {
    var st = WidgetFactories.edgeInsets(factories);
    var fn = WidgetFactories.EdgeInsetsSt.only(st);
    return WidgetFactories.EdgeInsetsSt.only.invoke(fn, arena, ptr(left),
      ptr(top),
      ptr(right),
      ptr(bottom));
  }
  MemorySegment edgeInsetsSymmetric(OptionalDouble vertical, OptionalDouble horizontal) {
    var st = WidgetFactories.edgeInsets(factories);
    var fn = WidgetFactories.EdgeInsetsSt.symmetric(st);
    return WidgetFactories.EdgeInsetsSt.symmetric.invoke(fn, arena, ptr(vertical),
      ptr(horizontal));
  }
  MemorySegment edgeInsetsLerp(EdgeInsets a, EdgeInsets b, double t) {
    var st = WidgetFactories.edgeInsets(factories);
    var fn = WidgetFactories.EdgeInsetsSt.lerp(st);
    return WidgetFactories.EdgeInsetsSt.lerp.invoke(fn, arena, a != null ? a.getId() : null,
      b != null ? b.getId() : null,
      t);
  }

  MemorySegment borderSideBorderSide(Optional<Color> color, OptionalDouble width, Optional<BorderStyle> style, OptionalDouble strokeAlign) {
    var st = WidgetFactories.borderSide(factories);
    var fn = WidgetFactories.BorderSideSt.borderSide(st);
    return WidgetFactories.BorderSideSt.borderSide.invoke(fn, arena, ptrObj(color),
      ptr(width),
      ptrEnum(style),
      ptr(strokeAlign));
  }
  MemorySegment borderSideMerge(BorderSide a, BorderSide b) {
    var st = WidgetFactories.borderSide(factories);
    var fn = WidgetFactories.BorderSideSt.merge(st);
    return WidgetFactories.BorderSideSt.merge.invoke(fn, arena, a.getId(),
      b.getId());
  }
  MemorySegment borderSideLerp(BorderSide a, BorderSide b, double t) {
    var st = WidgetFactories.borderSide(factories);
    var fn = WidgetFactories.BorderSideSt.lerp(st);
    return WidgetFactories.BorderSideSt.lerp.invoke(fn, arena, a.getId(),
      b.getId(),
      t);
  }

  MemorySegment borderBorder(Optional<BorderSide> top, Optional<BorderSide> right, Optional<BorderSide> bottom, Optional<BorderSide> left) {
    var st = WidgetFactories.border(factories);
    var fn = WidgetFactories.BorderSt.border(st);
    return WidgetFactories.BorderSt.border.invoke(fn, arena, ptrObj(top),
      ptrObj(right),
      ptrObj(bottom),
      ptrObj(left));
  }
  MemorySegment borderFromBorderSide(BorderSide side) {
    var st = WidgetFactories.border(factories);
    var fn = WidgetFactories.BorderSt.fromBorderSide(st);
    return WidgetFactories.BorderSt.fromBorderSide.invoke(fn, arena, side.getId());
  }
  MemorySegment borderSymmetric(Optional<BorderSide> vertical, Optional<BorderSide> horizontal) {
    var st = WidgetFactories.border(factories);
    var fn = WidgetFactories.BorderSt.symmetric(st);
    return WidgetFactories.BorderSt.symmetric.invoke(fn, arena, ptrObj(vertical),
      ptrObj(horizontal));
  }
  MemorySegment borderAll(Optional<Color> color, OptionalDouble width, Optional<BorderStyle> style, OptionalDouble strokeAlign) {
    var st = WidgetFactories.border(factories);
    var fn = WidgetFactories.BorderSt.all(st);
    return WidgetFactories.BorderSt.all.invoke(fn, arena, ptrObj(color),
      ptr(width),
      ptrEnum(style),
      ptr(strokeAlign));
  }
  MemorySegment borderMerge(Border a, Border b) {
    var st = WidgetFactories.border(factories);
    var fn = WidgetFactories.BorderSt.merge(st);
    return WidgetFactories.BorderSt.merge.invoke(fn, arena, a.getId(),
      b.getId());
  }
  MemorySegment borderLerp(Border a, Border b, double t) {
    var st = WidgetFactories.border(factories);
    var fn = WidgetFactories.BorderSt.lerp(st);
    return WidgetFactories.BorderSt.lerp.invoke(fn, arena, a != null ? a.getId() : null,
      b != null ? b.getId() : null,
      t);
  }

  MemorySegment roundedRectangleBorderRoundedRectangleBorder(Optional<BorderSide> side, Optional<BorderRadiusGeometry> borderRadius) {
    var st = WidgetFactories.roundedRectangleBorder(factories);
    var fn = WidgetFactories.RoundedRectangleBorderSt.roundedRectangleBorder(st);
    return WidgetFactories.RoundedRectangleBorderSt.roundedRectangleBorder.invoke(fn, arena, ptrObj(side),
      ptrObj(borderRadius));
  }

  int animationControllerAnimationController(OptionalDouble value, Optional<Duration> duration, Optional<Duration> reverseDuration, Optional<String> debugLabel, OptionalDouble lowerBound, OptionalDouble upperBound, Optional<AnimationBehavior> animationBehavior, TickerProvider vsync) {
    var st = WidgetFactories.animationController(factories);
    var fn = WidgetFactories.AnimationControllerSt.animationController(st);
    return WidgetFactories.AnimationControllerSt.animationController.invoke(fn, ptr(value),
      ptrObj(duration),
      ptrObj(reverseDuration),
      ptrStr(debugLabel),
      ptr(lowerBound),
      ptr(upperBound),
      ptrEnum(animationBehavior),
      vsync.getId());
  }
  int animationControllerUnbounded(OptionalDouble value, Optional<Duration> duration, Optional<Duration> reverseDuration, Optional<String> debugLabel, TickerProvider vsync, Optional<AnimationBehavior> animationBehavior) {
    var st = WidgetFactories.animationController(factories);
    var fn = WidgetFactories.AnimationControllerSt.unbounded(st);
    return WidgetFactories.AnimationControllerSt.unbounded.invoke(fn, ptr(value),
      ptrObj(duration),
      ptrObj(reverseDuration),
      ptrStr(debugLabel),
      vsync.getId(),
      ptrEnum(animationBehavior));
  }

  int durationDuration(OptionalInt days, OptionalInt hours, OptionalInt minutes, OptionalInt seconds, OptionalInt milliseconds, OptionalInt microseconds) {
    var st = WidgetFactories.duration(factories);
    var fn = WidgetFactories.DurationSt.duration(st);
    return WidgetFactories.DurationSt.duration.invoke(fn, ptr(days),
      ptr(hours),
      ptr(minutes),
      ptr(seconds),
      ptr(milliseconds),
      ptr(microseconds));
  }

  MemorySegment animatedBuilderAnimatedBuilder(Listenable animation, BiFunction<BuildContext, Widget, Widget> builder, Optional<Widget> child) {
    var st = WidgetFactories.animatedBuilder(factories);
    var fn = WidgetFactories.AnimatedBuilderSt.animatedBuilder(st);
    return WidgetFactories.AnimatedBuilderSt.animatedBuilder.invoke(fn, arena, animation.getId(),
      ptrTransitionBuilderFn(builder),
      ptrObj(child));
  }

  MemorySegment listenableBuilderListenableBuilder(Listenable listenable, BiFunction<BuildContext, Widget, Widget> builder, Optional<Widget> child) {
    var st = WidgetFactories.listenableBuilder(factories);
    var fn = WidgetFactories.ListenableBuilderSt.listenableBuilder(st);
    return WidgetFactories.ListenableBuilderSt.listenableBuilder.invoke(fn, arena, listenable.getId(),
      ptrTransitionBuilderFn(builder),
      ptrObj(child));
  }

  MemorySegment cubicCubic(double a, double b, double c, double d) {
    var st = WidgetFactories.cubic(factories);
    var fn = WidgetFactories.CubicSt.cubic(st);
    return WidgetFactories.CubicSt.cubic.invoke(fn, arena, a,
      b,
      c,
      d);
  }

  MemorySegment threePointCubicThreePointCubic(Offset a1, Offset b1, Offset midpoint, Offset a2, Offset b2) {
    var st = WidgetFactories.threePointCubic(factories);
    var fn = WidgetFactories.ThreePointCubicSt.threePointCubic(st);
    return WidgetFactories.ThreePointCubicSt.threePointCubic.invoke(fn, arena, a1.getId(),
      b1.getId(),
      midpoint.getId(),
      a2.getId(),
      b2.getId());
  }

  MemorySegment elasticOutCurveElasticOutCurve(OptionalDouble period) {
    var st = WidgetFactories.elasticOutCurve(factories);
    var fn = WidgetFactories.ElasticOutCurveSt.elasticOutCurve(st);
    return WidgetFactories.ElasticOutCurveSt.elasticOutCurve.invoke(fn, arena, ptr(period));
  }

  MemorySegment elasticInCurveElasticInCurve(OptionalDouble period) {
    var st = WidgetFactories.elasticInCurve(factories);
    var fn = WidgetFactories.ElasticInCurveSt.elasticInCurve(st);
    return WidgetFactories.ElasticInCurveSt.elasticInCurve.invoke(fn, arena, ptr(period));
  }

  MemorySegment elasticInOutCurveElasticInOutCurve(OptionalDouble period) {
    var st = WidgetFactories.elasticInOutCurve(factories);
    var fn = WidgetFactories.ElasticInOutCurveSt.elasticInOutCurve(st);
    return WidgetFactories.ElasticInOutCurveSt.elasticInOutCurve.invoke(fn, arena, ptr(period));
  }

  int curvesLinear() {
    var st = WidgetFactories.curves(factories);
    return WidgetFactories.CurvesSt.linear(st);
  }
  int curvesDecelerate() {
    var st = WidgetFactories.curves(factories);
    return WidgetFactories.CurvesSt.decelerate(st);
  }
  int curvesBounceIn() {
    var st = WidgetFactories.curves(factories);
    return WidgetFactories.CurvesSt.bounceIn(st);
  }
  int curvesBounceOut() {
    var st = WidgetFactories.curves(factories);
    return WidgetFactories.CurvesSt.bounceOut(st);
  }
  int curvesBounceInOut() {
    var st = WidgetFactories.curves(factories);
    return WidgetFactories.CurvesSt.bounceInOut(st);
  }

  int curvedAnimationCurvedAnimation(Animation parent, Curve curve, Optional<Curve> reverseCurve) {
    var st = WidgetFactories.curvedAnimation(factories);
    var fn = WidgetFactories.CurvedAnimationSt.curvedAnimation(st);
    return WidgetFactories.CurvedAnimationSt.curvedAnimation.invoke(fn, parent.getId(),
      curve.getId(),
      ptrObj(reverseCurve));
  }

  MemorySegment sizedBoxSizedBox(OptionalDouble width, OptionalDouble height, Optional<Widget> child) {
    var st = WidgetFactories.sizedBox(factories);
    var fn = WidgetFactories.SizedBoxSt.sizedBox(st);
    return WidgetFactories.SizedBoxSt.sizedBox.invoke(fn, arena, ptr(width),
      ptr(height),
      ptrObj(child));
  }
  MemorySegment sizedBoxExpand(Optional<Widget> child) {
    var st = WidgetFactories.sizedBox(factories);
    var fn = WidgetFactories.SizedBoxSt.expand(st);
    return WidgetFactories.SizedBoxSt.expand.invoke(fn, arena, ptrObj(child));
  }
  MemorySegment sizedBoxShrink(Optional<Widget> child) {
    var st = WidgetFactories.sizedBox(factories);
    var fn = WidgetFactories.SizedBoxSt.shrink(st);
    return WidgetFactories.SizedBoxSt.shrink.invoke(fn, arena, ptrObj(child));
  }
  MemorySegment sizedBoxFromSize(Optional<Widget> child) {
    var st = WidgetFactories.sizedBox(factories);
    var fn = WidgetFactories.SizedBoxSt.fromSize(st);
    return WidgetFactories.SizedBoxSt.fromSize.invoke(fn, arena, ptrObj(child));
  }
  MemorySegment sizedBoxSquare(Optional<Widget> child, OptionalDouble dimension) {
    var st = WidgetFactories.sizedBox(factories);
    var fn = WidgetFactories.SizedBoxSt.square(st);
    return WidgetFactories.SizedBoxSt.square.invoke(fn, arena, ptrObj(child),
      ptr(dimension));
  }

  MemorySegment alignmentAlignment(double x, double y) {
    var st = WidgetFactories.alignment(factories);
    var fn = WidgetFactories.AlignmentSt.alignment(st);
    return WidgetFactories.AlignmentSt.alignment.invoke(fn, arena, x,
      y);
  }
  MemorySegment alignmentLerp(Alignment a, Alignment b, double t) {
    var st = WidgetFactories.alignment(factories);
    var fn = WidgetFactories.AlignmentSt.lerp(st);
    return WidgetFactories.AlignmentSt.lerp.invoke(fn, arena, a != null ? a.getId() : null,
      b != null ? b.getId() : null,
      t);
  }

  MemorySegment mouseRegionMouseRegion(Optional<Boolean> opaque, Optional<HitTestBehavior> hitTestBehavior, Optional<Widget> child) {
    var st = WidgetFactories.mouseRegion(factories);
    var fn = WidgetFactories.MouseRegionSt.mouseRegion(st);
    return WidgetFactories.MouseRegionSt.mouseRegion.invoke(fn, arena, ptrBool(opaque),
      ptrEnum(hitTestBehavior),
      ptrObj(child));
  }

  MemorySegment expandedExpanded(OptionalInt flex, Widget child) {
    var st = WidgetFactories.expanded(factories);
    var fn = WidgetFactories.ExpandedSt.expanded(st);
    return WidgetFactories.ExpandedSt.expanded.invoke(fn, arena, ptr(flex),
      child.getId());
  }

  MemorySegment flexibleFlexible(OptionalInt flex, Optional<FlexFit> fit, Widget child) {
    var st = WidgetFactories.flexible(factories);
    var fn = WidgetFactories.FlexibleSt.flexible(st);
    return WidgetFactories.FlexibleSt.flexible.invoke(fn, arena, ptr(flex),
      ptrEnum(fit),
      child.getId());
  }

  MemorySegment safeAreaSafeArea(Optional<Boolean> left, Optional<Boolean> top, Optional<Boolean> right, Optional<Boolean> bottom, Optional<EdgeInsets> minimum, Optional<Boolean> maintainBottomViewPadding, Widget child) {
    var st = WidgetFactories.safeArea(factories);
    var fn = WidgetFactories.SafeAreaSt.safeArea(st);
    return WidgetFactories.SafeAreaSt.safeArea.invoke(fn, arena, ptrBool(left),
      ptrBool(top),
      ptrBool(right),
      ptrBool(bottom),
      ptrObj(minimum),
      ptrBool(maintainBottomViewPadding),
      child.getId());
  }

  MemorySegment colorSchemeColorScheme(Brightness brightness, Color primary, Color onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Color secondary, Color onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Color error, Color onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Color surface, Color onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.colorScheme(st);
    return WidgetFactories.ColorSchemeSt.colorScheme.invoke(fn, arena, brightness.ordinal(),
      primary.getId(),
      onPrimary.getId(),
      ptrObj(primaryContainer),
      ptrObj(onPrimaryContainer),
      ptrObj(primaryFixed),
      ptrObj(primaryFixedDim),
      ptrObj(onPrimaryFixed),
      ptrObj(onPrimaryFixedVariant),
      secondary.getId(),
      onSecondary.getId(),
      ptrObj(secondaryContainer),
      ptrObj(onSecondaryContainer),
      ptrObj(secondaryFixed),
      ptrObj(secondaryFixedDim),
      ptrObj(onSecondaryFixed),
      ptrObj(onSecondaryFixedVariant),
      ptrObj(tertiary),
      ptrObj(onTertiary),
      ptrObj(tertiaryContainer),
      ptrObj(onTertiaryContainer),
      ptrObj(tertiaryFixed),
      ptrObj(tertiaryFixedDim),
      ptrObj(onTertiaryFixed),
      ptrObj(onTertiaryFixedVariant),
      error.getId(),
      onError.getId(),
      ptrObj(errorContainer),
      ptrObj(onErrorContainer),
      surface.getId(),
      onSurface.getId(),
      ptrObj(surfaceDim),
      ptrObj(surfaceBright),
      ptrObj(surfaceContainerLowest),
      ptrObj(surfaceContainerLow),
      ptrObj(surfaceContainer),
      ptrObj(surfaceContainerHigh),
      ptrObj(surfaceContainerHighest),
      ptrObj(onSurfaceVariant),
      ptrObj(outline),
      ptrObj(outlineVariant),
      ptrObj(shadow),
      ptrObj(scrim),
      ptrObj(inverseSurface),
      ptrObj(onInverseSurface),
      ptrObj(inversePrimary),
      ptrObj(surfaceTint),
      ptrObj(background),
      ptrObj(onBackground),
      ptrObj(surfaceVariant));
  }
  MemorySegment colorSchemeFromSeed(Color seedColor, Optional<Brightness> brightness, Optional<DynamicSchemeVariant> dynamicSchemeVariant, OptionalDouble contrastLevel, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.fromSeed(st);
    return WidgetFactories.ColorSchemeSt.fromSeed.invoke(fn, arena, seedColor.getId(),
      ptrEnum(brightness),
      ptrEnum(dynamicSchemeVariant),
      ptr(contrastLevel),
      ptrObj(primary),
      ptrObj(onPrimary),
      ptrObj(primaryContainer),
      ptrObj(onPrimaryContainer),
      ptrObj(primaryFixed),
      ptrObj(primaryFixedDim),
      ptrObj(onPrimaryFixed),
      ptrObj(onPrimaryFixedVariant),
      ptrObj(secondary),
      ptrObj(onSecondary),
      ptrObj(secondaryContainer),
      ptrObj(onSecondaryContainer),
      ptrObj(secondaryFixed),
      ptrObj(secondaryFixedDim),
      ptrObj(onSecondaryFixed),
      ptrObj(onSecondaryFixedVariant),
      ptrObj(tertiary),
      ptrObj(onTertiary),
      ptrObj(tertiaryContainer),
      ptrObj(onTertiaryContainer),
      ptrObj(tertiaryFixed),
      ptrObj(tertiaryFixedDim),
      ptrObj(onTertiaryFixed),
      ptrObj(onTertiaryFixedVariant),
      ptrObj(error),
      ptrObj(onError),
      ptrObj(errorContainer),
      ptrObj(onErrorContainer),
      ptrObj(outline),
      ptrObj(outlineVariant),
      ptrObj(surface),
      ptrObj(onSurface),
      ptrObj(surfaceDim),
      ptrObj(surfaceBright),
      ptrObj(surfaceContainerLowest),
      ptrObj(surfaceContainerLow),
      ptrObj(surfaceContainer),
      ptrObj(surfaceContainerHigh),
      ptrObj(surfaceContainerHighest),
      ptrObj(onSurfaceVariant),
      ptrObj(inverseSurface),
      ptrObj(onInverseSurface),
      ptrObj(inversePrimary),
      ptrObj(shadow),
      ptrObj(scrim),
      ptrObj(surfaceTint),
      ptrObj(background),
      ptrObj(onBackground),
      ptrObj(surfaceVariant));
  }
  MemorySegment colorSchemeLight(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.light(st);
    return WidgetFactories.ColorSchemeSt.light.invoke(fn, arena, ptrEnum(brightness),
      ptrObj(primary),
      ptrObj(onPrimary),
      ptrObj(primaryContainer),
      ptrObj(onPrimaryContainer),
      ptrObj(primaryFixed),
      ptrObj(primaryFixedDim),
      ptrObj(onPrimaryFixed),
      ptrObj(onPrimaryFixedVariant),
      ptrObj(secondary),
      ptrObj(onSecondary),
      ptrObj(secondaryContainer),
      ptrObj(onSecondaryContainer),
      ptrObj(secondaryFixed),
      ptrObj(secondaryFixedDim),
      ptrObj(onSecondaryFixed),
      ptrObj(onSecondaryFixedVariant),
      ptrObj(tertiary),
      ptrObj(onTertiary),
      ptrObj(tertiaryContainer),
      ptrObj(onTertiaryContainer),
      ptrObj(tertiaryFixed),
      ptrObj(tertiaryFixedDim),
      ptrObj(onTertiaryFixed),
      ptrObj(onTertiaryFixedVariant),
      ptrObj(error),
      ptrObj(onError),
      ptrObj(errorContainer),
      ptrObj(onErrorContainer),
      ptrObj(surface),
      ptrObj(onSurface),
      ptrObj(surfaceDim),
      ptrObj(surfaceBright),
      ptrObj(surfaceContainerLowest),
      ptrObj(surfaceContainerLow),
      ptrObj(surfaceContainer),
      ptrObj(surfaceContainerHigh),
      ptrObj(surfaceContainerHighest),
      ptrObj(onSurfaceVariant),
      ptrObj(outline),
      ptrObj(outlineVariant),
      ptrObj(shadow),
      ptrObj(scrim),
      ptrObj(inverseSurface),
      ptrObj(onInverseSurface),
      ptrObj(inversePrimary),
      ptrObj(surfaceTint),
      ptrObj(background),
      ptrObj(onBackground),
      ptrObj(surfaceVariant));
  }
  MemorySegment colorSchemeDark(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.dark(st);
    return WidgetFactories.ColorSchemeSt.dark.invoke(fn, arena, ptrEnum(brightness),
      ptrObj(primary),
      ptrObj(onPrimary),
      ptrObj(primaryContainer),
      ptrObj(onPrimaryContainer),
      ptrObj(primaryFixed),
      ptrObj(primaryFixedDim),
      ptrObj(onPrimaryFixed),
      ptrObj(onPrimaryFixedVariant),
      ptrObj(secondary),
      ptrObj(onSecondary),
      ptrObj(secondaryContainer),
      ptrObj(onSecondaryContainer),
      ptrObj(secondaryFixed),
      ptrObj(secondaryFixedDim),
      ptrObj(onSecondaryFixed),
      ptrObj(onSecondaryFixedVariant),
      ptrObj(tertiary),
      ptrObj(onTertiary),
      ptrObj(tertiaryContainer),
      ptrObj(onTertiaryContainer),
      ptrObj(tertiaryFixed),
      ptrObj(tertiaryFixedDim),
      ptrObj(onTertiaryFixed),
      ptrObj(onTertiaryFixedVariant),
      ptrObj(error),
      ptrObj(onError),
      ptrObj(errorContainer),
      ptrObj(onErrorContainer),
      ptrObj(surface),
      ptrObj(onSurface),
      ptrObj(surfaceDim),
      ptrObj(surfaceBright),
      ptrObj(surfaceContainerLowest),
      ptrObj(surfaceContainerLow),
      ptrObj(surfaceContainer),
      ptrObj(surfaceContainerHigh),
      ptrObj(surfaceContainerHighest),
      ptrObj(onSurfaceVariant),
      ptrObj(outline),
      ptrObj(outlineVariant),
      ptrObj(shadow),
      ptrObj(scrim),
      ptrObj(inverseSurface),
      ptrObj(onInverseSurface),
      ptrObj(inversePrimary),
      ptrObj(surfaceTint),
      ptrObj(background),
      ptrObj(onBackground),
      ptrObj(surfaceVariant));
  }
  MemorySegment colorSchemeHighContrastLight(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.highContrastLight(st);
    return WidgetFactories.ColorSchemeSt.highContrastLight.invoke(fn, arena, ptrEnum(brightness),
      ptrObj(primary),
      ptrObj(onPrimary),
      ptrObj(primaryContainer),
      ptrObj(onPrimaryContainer),
      ptrObj(primaryFixed),
      ptrObj(primaryFixedDim),
      ptrObj(onPrimaryFixed),
      ptrObj(onPrimaryFixedVariant),
      ptrObj(secondary),
      ptrObj(onSecondary),
      ptrObj(secondaryContainer),
      ptrObj(onSecondaryContainer),
      ptrObj(secondaryFixed),
      ptrObj(secondaryFixedDim),
      ptrObj(onSecondaryFixed),
      ptrObj(onSecondaryFixedVariant),
      ptrObj(tertiary),
      ptrObj(onTertiary),
      ptrObj(tertiaryContainer),
      ptrObj(onTertiaryContainer),
      ptrObj(tertiaryFixed),
      ptrObj(tertiaryFixedDim),
      ptrObj(onTertiaryFixed),
      ptrObj(onTertiaryFixedVariant),
      ptrObj(error),
      ptrObj(onError),
      ptrObj(errorContainer),
      ptrObj(onErrorContainer),
      ptrObj(surface),
      ptrObj(onSurface),
      ptrObj(surfaceDim),
      ptrObj(surfaceBright),
      ptrObj(surfaceContainerLowest),
      ptrObj(surfaceContainerLow),
      ptrObj(surfaceContainer),
      ptrObj(surfaceContainerHigh),
      ptrObj(surfaceContainerHighest),
      ptrObj(onSurfaceVariant),
      ptrObj(outline),
      ptrObj(outlineVariant),
      ptrObj(shadow),
      ptrObj(scrim),
      ptrObj(inverseSurface),
      ptrObj(onInverseSurface),
      ptrObj(inversePrimary),
      ptrObj(surfaceTint),
      ptrObj(background),
      ptrObj(onBackground),
      ptrObj(surfaceVariant));
  }
  MemorySegment colorSchemeHighContrastDark(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.highContrastDark(st);
    return WidgetFactories.ColorSchemeSt.highContrastDark.invoke(fn, arena, ptrEnum(brightness),
      ptrObj(primary),
      ptrObj(onPrimary),
      ptrObj(primaryContainer),
      ptrObj(onPrimaryContainer),
      ptrObj(primaryFixed),
      ptrObj(primaryFixedDim),
      ptrObj(onPrimaryFixed),
      ptrObj(onPrimaryFixedVariant),
      ptrObj(secondary),
      ptrObj(onSecondary),
      ptrObj(secondaryContainer),
      ptrObj(onSecondaryContainer),
      ptrObj(secondaryFixed),
      ptrObj(secondaryFixedDim),
      ptrObj(onSecondaryFixed),
      ptrObj(onSecondaryFixedVariant),
      ptrObj(tertiary),
      ptrObj(onTertiary),
      ptrObj(tertiaryContainer),
      ptrObj(onTertiaryContainer),
      ptrObj(tertiaryFixed),
      ptrObj(tertiaryFixedDim),
      ptrObj(onTertiaryFixed),
      ptrObj(onTertiaryFixedVariant),
      ptrObj(error),
      ptrObj(onError),
      ptrObj(errorContainer),
      ptrObj(onErrorContainer),
      ptrObj(surface),
      ptrObj(onSurface),
      ptrObj(surfaceDim),
      ptrObj(surfaceBright),
      ptrObj(surfaceContainerLowest),
      ptrObj(surfaceContainerLow),
      ptrObj(surfaceContainer),
      ptrObj(surfaceContainerHigh),
      ptrObj(surfaceContainerHighest),
      ptrObj(onSurfaceVariant),
      ptrObj(outline),
      ptrObj(outlineVariant),
      ptrObj(shadow),
      ptrObj(scrim),
      ptrObj(inverseSurface),
      ptrObj(onInverseSurface),
      ptrObj(inversePrimary),
      ptrObj(surfaceTint),
      ptrObj(background),
      ptrObj(onBackground),
      ptrObj(surfaceVariant));
  }
  MemorySegment colorSchemeFromSwatch(Optional<MaterialColor> primarySwatch, Optional<Color> accentColor, Optional<Color> cardColor, Optional<Color> backgroundColor, Optional<Color> errorColor, Optional<Brightness> brightness) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.fromSwatch(st);
    return WidgetFactories.ColorSchemeSt.fromSwatch.invoke(fn, arena, ptrObj(primarySwatch),
      ptrObj(accentColor),
      ptrObj(cardColor),
      ptrObj(backgroundColor),
      ptrObj(errorColor),
      ptrEnum(brightness));
  }
  MemorySegment colorSchemeLerp(ColorScheme a, ColorScheme b, double t) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.lerp(st);
    return WidgetFactories.ColorSchemeSt.lerp.invoke(fn, arena, a.getId(),
      b.getId(),
      t);
  }
  MemorySegment colorSchemeOf(BuildContext context) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.of(st);
    return WidgetFactories.ColorSchemeSt.of.invoke(fn, arena, context.getId());
  }

  MemorySegment materialColorMaterialColor(int primary, Map<Integer, Color> swatch) {
    var st = WidgetFactories.materialColor(factories);
    var fn = WidgetFactories.MaterialColorSt.materialColor(st);
    return WidgetFactories.MaterialColorSt.materialColor.invoke(fn, arena, primary,
      ptrMap(swatch));
  }

  MemorySegment colorSwatchLerp(ColorSwatch a, ColorSwatch b, double t) {
    var st = WidgetFactories.colorSwatch(factories);
    var fn = WidgetFactories.ColorSwatchSt.lerp(st);
    return WidgetFactories.ColorSwatchSt.lerp.invoke(fn, arena, a != null ? a.getId() : null,
      b != null ? b.getId() : null,
      t);
  }

  MemorySegment textThemeTextTheme(Optional<TextStyle> displayLarge, Optional<TextStyle> displayMedium, Optional<TextStyle> displaySmall, Optional<TextStyle> headlineLarge, Optional<TextStyle> headlineMedium, Optional<TextStyle> headlineSmall, Optional<TextStyle> titleLarge, Optional<TextStyle> titleMedium, Optional<TextStyle> titleSmall, Optional<TextStyle> bodyLarge, Optional<TextStyle> bodyMedium, Optional<TextStyle> bodySmall, Optional<TextStyle> labelLarge, Optional<TextStyle> labelMedium, Optional<TextStyle> labelSmall) {
    var st = WidgetFactories.textTheme(factories);
    var fn = WidgetFactories.TextThemeSt.textTheme(st);
    return WidgetFactories.TextThemeSt.textTheme.invoke(fn, arena, ptrObj(displayLarge),
      ptrObj(displayMedium),
      ptrObj(displaySmall),
      ptrObj(headlineLarge),
      ptrObj(headlineMedium),
      ptrObj(headlineSmall),
      ptrObj(titleLarge),
      ptrObj(titleMedium),
      ptrObj(titleSmall),
      ptrObj(bodyLarge),
      ptrObj(bodyMedium),
      ptrObj(bodySmall),
      ptrObj(labelLarge),
      ptrObj(labelMedium),
      ptrObj(labelSmall));
  }
  MemorySegment textThemeLerp(TextTheme a, TextTheme b, double t) {
    var st = WidgetFactories.textTheme(factories);
    var fn = WidgetFactories.TextThemeSt.lerp(st);
    return WidgetFactories.TextThemeSt.lerp.invoke(fn, arena, a != null ? a.getId() : null,
      b != null ? b.getId() : null,
      t);
  }
  MemorySegment textThemeOf(BuildContext context) {
    var st = WidgetFactories.textTheme(factories);
    var fn = WidgetFactories.TextThemeSt.of(st);
    return WidgetFactories.TextThemeSt.of.invoke(fn, arena, context.getId());
  }
  MemorySegment textThemePrimaryOf(BuildContext context) {
    var st = WidgetFactories.textTheme(factories);
    var fn = WidgetFactories.TextThemeSt.primaryOf(st);
    return WidgetFactories.TextThemeSt.primaryOf.invoke(fn, arena, context.getId());
  }

  MemorySegment visualDensityVisualDensity(OptionalDouble horizontal, OptionalDouble vertical) {
    var st = WidgetFactories.visualDensity(factories);
    var fn = WidgetFactories.VisualDensitySt.visualDensity(st);
    return WidgetFactories.VisualDensitySt.visualDensity.invoke(fn, arena, ptr(horizontal),
      ptr(vertical));
  }
  MemorySegment visualDensityDefaultDensityForPlatform(TargetPlatform platform) {
    var st = WidgetFactories.visualDensity(factories);
    var fn = WidgetFactories.VisualDensitySt.defaultDensityForPlatform(st);
    return WidgetFactories.VisualDensitySt.defaultDensityForPlatform.invoke(fn, arena, platform.ordinal());
  }
  MemorySegment visualDensityLerp(VisualDensity a, VisualDensity b, double t) {
    var st = WidgetFactories.visualDensity(factories);
    var fn = WidgetFactories.VisualDensitySt.lerp(st);
    return WidgetFactories.VisualDensitySt.lerp.invoke(fn, arena, a.getId(),
      b.getId(),
      t);
  }

  MemorySegment themeDataThemeData(Optional<Boolean> applyElevationOverlayColor, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<TargetPlatform> platform, Optional<Boolean> useMaterial3, Optional<VisualDensity> visualDensity, Optional<ColorScheme> colorScheme, Optional<Brightness> brightness, Optional<Color> colorSchemeSeed, Optional<Color> canvasColor, Optional<Color> cardColor, Optional<Color> disabledColor, Optional<Color> dividerColor, Optional<Color> focusColor, Optional<Color> highlightColor, Optional<Color> hintColor, Optional<Color> hoverColor, Optional<Color> indicatorColor, Optional<Color> primaryColor, Optional<Color> primaryColorDark, Optional<Color> primaryColorLight, Optional<MaterialColor> primarySwatch, Optional<Color> scaffoldBackgroundColor, Optional<Color> secondaryHeaderColor, Optional<Color> shadowColor, Optional<Color> splashColor, Optional<Color> unselectedWidgetColor, Optional<String> fontFamily, Optional<List<String>> fontFamilyFallback, Optional<String> _package, Optional<TextTheme> primaryTextTheme, Optional<TextTheme> textTheme, Optional<NativeObj> cardTheme, Optional<NativeObj> dialogTheme, Optional<NativeObj> tabBarTheme, Optional<Color> dialogBackgroundColor) {
    var st = WidgetFactories.themeData(factories);
    var fn = WidgetFactories.ThemeDataSt.themeData(st);
    return WidgetFactories.ThemeDataSt.themeData.invoke(fn, arena, ptrBool(applyElevationOverlayColor),
      ptrEnum(materialTapTargetSize),
      ptrEnum(platform),
      ptrBool(useMaterial3),
      ptrObj(visualDensity),
      ptrObj(colorScheme),
      ptrEnum(brightness),
      ptrObj(colorSchemeSeed),
      ptrObj(canvasColor),
      ptrObj(cardColor),
      ptrObj(disabledColor),
      ptrObj(dividerColor),
      ptrObj(focusColor),
      ptrObj(highlightColor),
      ptrObj(hintColor),
      ptrObj(hoverColor),
      ptrObj(indicatorColor),
      ptrObj(primaryColor),
      ptrObj(primaryColorDark),
      ptrObj(primaryColorLight),
      ptrObj(primarySwatch),
      ptrObj(scaffoldBackgroundColor),
      ptrObj(secondaryHeaderColor),
      ptrObj(shadowColor),
      ptrObj(splashColor),
      ptrObj(unselectedWidgetColor),
      ptrStr(fontFamily),
      ptrStrList(fontFamilyFallback),
      ptrStr(_package),
      ptrObj(primaryTextTheme),
      ptrObj(textTheme),
      ptrObj(cardTheme),
      ptrObj(dialogTheme),
      ptrObj(tabBarTheme),
      ptrObj(dialogBackgroundColor));
  }
  MemorySegment themeDataFrom(ColorScheme colorScheme, Optional<TextTheme> textTheme, Optional<Boolean> useMaterial3) {
    var st = WidgetFactories.themeData(factories);
    var fn = WidgetFactories.ThemeDataSt.from(st);
    return WidgetFactories.ThemeDataSt.from.invoke(fn, arena, colorScheme.getId(),
      ptrObj(textTheme),
      ptrBool(useMaterial3));
  }
  MemorySegment themeDataLight(Optional<Boolean> useMaterial3) {
    var st = WidgetFactories.themeData(factories);
    var fn = WidgetFactories.ThemeDataSt.light(st);
    return WidgetFactories.ThemeDataSt.light.invoke(fn, arena, ptrBool(useMaterial3));
  }
  MemorySegment themeDataDark(Optional<Boolean> useMaterial3) {
    var st = WidgetFactories.themeData(factories);
    var fn = WidgetFactories.ThemeDataSt.dark(st);
    return WidgetFactories.ThemeDataSt.dark.invoke(fn, arena, ptrBool(useMaterial3));
  }
  MemorySegment themeDataFallback(Optional<Boolean> useMaterial3) {
    var st = WidgetFactories.themeData(factories);
    var fn = WidgetFactories.ThemeDataSt.fallback(st);
    return WidgetFactories.ThemeDataSt.fallback.invoke(fn, arena, ptrBool(useMaterial3));
  }
  MemorySegment themeDataLocalize(ThemeData baseTheme, TextTheme localTextGeometry) {
    var st = WidgetFactories.themeData(factories);
    var fn = WidgetFactories.ThemeDataSt.localize(st);
    return WidgetFactories.ThemeDataSt.localize.invoke(fn, arena, baseTheme.getId(),
      localTextGeometry.getId());
  }
  int themeDataEstimateBrightnessForColor(Color color) {
    var st = WidgetFactories.themeData(factories);
    var fn = WidgetFactories.ThemeDataSt.estimateBrightnessForColor(st);
    return WidgetFactories.ThemeDataSt.estimateBrightnessForColor.invoke(fn, color.getId());
  }
  MemorySegment themeDataLerp(ThemeData a, ThemeData b, double t) {
    var st = WidgetFactories.themeData(factories);
    var fn = WidgetFactories.ThemeDataSt.lerp(st);
    return WidgetFactories.ThemeDataSt.lerp.invoke(fn, arena, a.getId(),
      b.getId(),
      t);
  }

  MemorySegment materialAccentColorMaterialAccentColor(int primary, Map<Integer, Color> swatch) {
    var st = WidgetFactories.materialAccentColor(factories);
    var fn = WidgetFactories.MaterialAccentColorSt.materialAccentColor(st);
    return WidgetFactories.MaterialAccentColorSt.materialAccentColor.invoke(fn, arena, primary,
      ptrMap(swatch));
  }

  MemorySegment materialMaterial(Optional<MaterialType> type, OptionalDouble elevation, Optional<Color> color, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<TextStyle> textStyle, Optional<BorderRadiusGeometry> borderRadius, Optional<ShapeBorder> shape, Optional<Boolean> borderOnForeground, Optional<Clip> clipBehavior, Optional<Duration> animationDuration, Optional<Widget> child) {
    var st = WidgetFactories.material(factories);
    var fn = WidgetFactories.MaterialSt.material(st);
    return WidgetFactories.MaterialSt.material.invoke(fn, arena, ptrEnum(type),
      ptr(elevation),
      ptrObj(color),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrObj(textStyle),
      ptrObj(borderRadius),
      ptrObj(shape),
      ptrBool(borderOnForeground),
      ptrEnum(clipBehavior),
      ptrObj(animationDuration),
      ptrObj(child));
  }

  MemorySegment iconButtonIconButton(OptionalDouble iconSize, Optional<VisualDensity> visualDensity, Optional<EdgeInsetsGeometry> padding, Optional<AlignmentGeometry> alignment, OptionalDouble splashRadius, Optional<Color> color, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> splashColor, Optional<Color> disabledColor, Runnable onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraints> constraints, Optional<Boolean> isSelected, Optional<Widget> selectedIcon, Widget icon) {
    var st = WidgetFactories.iconButton(factories);
    var fn = WidgetFactories.IconButtonSt.iconButton(st);
    return WidgetFactories.IconButtonSt.iconButton.invoke(fn, arena, ptr(iconSize),
      ptrObj(visualDensity),
      ptrObj(padding),
      ptrObj(alignment),
      ptr(splashRadius),
      ptrObj(color),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(highlightColor),
      ptrObj(splashColor),
      ptrObj(disabledColor),
      ptrVoidCallbackFn(onPressed),
      onHover.isPresent() ? ptrValueChangedForBoolFn(onHover.get()) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrVoidCallbackFn(onLongPress.get()) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrStr(tooltip),
      ptrBool(enableFeedback),
      ptrObj(constraints),
      ptrBool(isSelected),
      ptrObj(selectedIcon),
      icon.getId());
  }
  MemorySegment iconButtonFilled(OptionalDouble iconSize, Optional<VisualDensity> visualDensity, Optional<EdgeInsetsGeometry> padding, Optional<AlignmentGeometry> alignment, OptionalDouble splashRadius, Optional<Color> color, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> splashColor, Optional<Color> disabledColor, Runnable onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraints> constraints, Optional<Boolean> isSelected, Optional<Widget> selectedIcon, Widget icon) {
    var st = WidgetFactories.iconButton(factories);
    var fn = WidgetFactories.IconButtonSt.filled(st);
    return WidgetFactories.IconButtonSt.filled.invoke(fn, arena, ptr(iconSize),
      ptrObj(visualDensity),
      ptrObj(padding),
      ptrObj(alignment),
      ptr(splashRadius),
      ptrObj(color),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(highlightColor),
      ptrObj(splashColor),
      ptrObj(disabledColor),
      ptrVoidCallbackFn(onPressed),
      onHover.isPresent() ? ptrValueChangedForBoolFn(onHover.get()) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrVoidCallbackFn(onLongPress.get()) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrStr(tooltip),
      ptrBool(enableFeedback),
      ptrObj(constraints),
      ptrBool(isSelected),
      ptrObj(selectedIcon),
      icon.getId());
  }
  MemorySegment iconButtonFilledTonal(OptionalDouble iconSize, Optional<VisualDensity> visualDensity, Optional<EdgeInsetsGeometry> padding, Optional<AlignmentGeometry> alignment, OptionalDouble splashRadius, Optional<Color> color, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> splashColor, Optional<Color> disabledColor, Runnable onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraints> constraints, Optional<Boolean> isSelected, Optional<Widget> selectedIcon, Widget icon) {
    var st = WidgetFactories.iconButton(factories);
    var fn = WidgetFactories.IconButtonSt.filledTonal(st);
    return WidgetFactories.IconButtonSt.filledTonal.invoke(fn, arena, ptr(iconSize),
      ptrObj(visualDensity),
      ptrObj(padding),
      ptrObj(alignment),
      ptr(splashRadius),
      ptrObj(color),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(highlightColor),
      ptrObj(splashColor),
      ptrObj(disabledColor),
      ptrVoidCallbackFn(onPressed),
      onHover.isPresent() ? ptrValueChangedForBoolFn(onHover.get()) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrVoidCallbackFn(onLongPress.get()) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrStr(tooltip),
      ptrBool(enableFeedback),
      ptrObj(constraints),
      ptrBool(isSelected),
      ptrObj(selectedIcon),
      icon.getId());
  }
  MemorySegment iconButtonOutlined(OptionalDouble iconSize, Optional<VisualDensity> visualDensity, Optional<EdgeInsetsGeometry> padding, Optional<AlignmentGeometry> alignment, OptionalDouble splashRadius, Optional<Color> color, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> splashColor, Optional<Color> disabledColor, Runnable onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraints> constraints, Optional<Boolean> isSelected, Optional<Widget> selectedIcon, Widget icon) {
    var st = WidgetFactories.iconButton(factories);
    var fn = WidgetFactories.IconButtonSt.outlined(st);
    return WidgetFactories.IconButtonSt.outlined.invoke(fn, arena, ptr(iconSize),
      ptrObj(visualDensity),
      ptrObj(padding),
      ptrObj(alignment),
      ptr(splashRadius),
      ptrObj(color),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(highlightColor),
      ptrObj(splashColor),
      ptrObj(disabledColor),
      ptrVoidCallbackFn(onPressed),
      onHover.isPresent() ? ptrValueChangedForBoolFn(onHover.get()) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrVoidCallbackFn(onLongPress.get()) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrStr(tooltip),
      ptrBool(enableFeedback),
      ptrObj(constraints),
      ptrBool(isSelected),
      ptrObj(selectedIcon),
      icon.getId());
  }

  MemorySegment appBarAppBar(Optional<Widget> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Widget> title, Optional<List<Widget>> actions, Optional<Widget> flexibleSpace, Optional<PreferredSizeWidget> bottom, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<ShapeBorder> shape, Optional<Color> backgroundColor, Optional<Color> foregroundColor, Optional<Boolean> primary, Optional<Boolean> centerTitle, Optional<Boolean> excludeHeaderSemantics, OptionalDouble titleSpacing, OptionalDouble toolbarOpacity, OptionalDouble bottomOpacity, OptionalDouble toolbarHeight, OptionalDouble leadingWidth, Optional<TextStyle> toolbarTextStyle, Optional<TextStyle> titleTextStyle, Optional<Boolean> forceMaterialTransparency, Optional<Clip> clipBehavior, Optional<EdgeInsetsGeometry> actionsPadding) {
    var st = WidgetFactories.appBar(factories);
    var fn = WidgetFactories.AppBarSt.appBar(st);
    return WidgetFactories.AppBarSt.appBar.invoke(fn, arena, ptrObj(leading),
      ptrBool(automaticallyImplyLeading),
      ptrObj(title),
      ptrList(actions),
      ptrObj(flexibleSpace),
      ptrObj(bottom),
      ptr(elevation),
      ptr(scrolledUnderElevation),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrObj(shape),
      ptrObj(backgroundColor),
      ptrObj(foregroundColor),
      ptrBool(primary),
      ptrBool(centerTitle),
      ptrBool(excludeHeaderSemantics),
      ptr(titleSpacing),
      ptr(toolbarOpacity),
      ptr(bottomOpacity),
      ptr(toolbarHeight),
      ptr(leadingWidth),
      ptrObj(toolbarTextStyle),
      ptrObj(titleTextStyle),
      ptrBool(forceMaterialTransparency),
      ptrEnum(clipBehavior),
      ptrObj(actionsPadding));
  }

  MemorySegment scaffoldScaffold(Optional<PreferredSizeWidget> appBar, Optional<Widget> body, Optional<Widget> floatingActionButton, Optional<List<Widget>> persistentFooterButtons, Optional<Widget> drawer, Optional<Consumer<Boolean>> onDrawerChanged, Optional<Widget> endDrawer, Optional<Consumer<Boolean>> onEndDrawerChanged, Optional<Widget> bottomNavigationBar, Optional<Widget> bottomSheet, Optional<Color> backgroundColor, Optional<Boolean> resizeToAvoidBottomInset, Optional<Boolean> primary, Optional<DragStartBehavior> drawerDragStartBehavior, Optional<Boolean> extendBody, Optional<Boolean> extendBodyBehindAppBar, Optional<Color> drawerScrimColor, OptionalDouble drawerEdgeDragWidth, Optional<Boolean> drawerEnableOpenDragGesture, Optional<Boolean> endDrawerEnableOpenDragGesture, Optional<String> restorationId) {
    var st = WidgetFactories.scaffold(factories);
    var fn = WidgetFactories.ScaffoldSt.scaffold(st);
    return WidgetFactories.ScaffoldSt.scaffold.invoke(fn, arena, ptrObj(appBar),
      ptrObj(body),
      ptrObj(floatingActionButton),
      ptrList(persistentFooterButtons),
      ptrObj(drawer),
      onDrawerChanged.isPresent() ? ptrDrawerCallbackFn(onDrawerChanged.get()) : MemorySegment.NULL,
      ptrObj(endDrawer),
      onEndDrawerChanged.isPresent() ? ptrDrawerCallbackFn(onEndDrawerChanged.get()) : MemorySegment.NULL,
      ptrObj(bottomNavigationBar),
      ptrObj(bottomSheet),
      ptrObj(backgroundColor),
      ptrBool(resizeToAvoidBottomInset),
      ptrBool(primary),
      ptrEnum(drawerDragStartBehavior),
      ptrBool(extendBody),
      ptrBool(extendBodyBehindAppBar),
      ptrObj(drawerScrimColor),
      ptr(drawerEdgeDragWidth),
      ptrBool(drawerEnableOpenDragGesture),
      ptrBool(endDrawerEnableOpenDragGesture),
      ptrStr(restorationId));
  }
  int scaffoldGeometryOf(BuildContext context) {
    var st = WidgetFactories.scaffold(factories);
    var fn = WidgetFactories.ScaffoldSt.geometryOf(st);
    return WidgetFactories.ScaffoldSt.geometryOf.invoke(fn, context.getId());
  }

  MemorySegment materialAppMaterialApp(Optional<Widget> home, Optional<String> initialRoute, Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<String> title, Optional<Function<BuildContext, String>> onGenerateTitle, Optional<Color> color, Optional<ThemeData> theme, Optional<ThemeData> darkTheme, Optional<ThemeData> highContrastTheme, Optional<ThemeData> highContrastDarkTheme, Optional<ThemeMode> themeMode, Optional<Duration> themeAnimationDuration, Optional<Curve> themeAnimationCurve, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    var st = WidgetFactories.materialApp(factories);
    var fn = WidgetFactories.MaterialAppSt.materialApp(st);
    return WidgetFactories.MaterialAppSt.materialApp.invoke(fn, arena, ptrObj(home),
      ptrStr(initialRoute),
      builder.isPresent() ? ptrTransitionBuilderFn(builder.get()) : MemorySegment.NULL,
      ptrStr(title),
      onGenerateTitle.isPresent() ? ptrGenerateAppTitleFn(onGenerateTitle.get()) : MemorySegment.NULL,
      ptrObj(color),
      ptrObj(theme),
      ptrObj(darkTheme),
      ptrObj(highContrastTheme),
      ptrObj(highContrastDarkTheme),
      ptrEnum(themeMode),
      ptrObj(themeAnimationDuration),
      ptrObj(themeAnimationCurve),
      ptrBool(debugShowMaterialGrid),
      ptrBool(showPerformanceOverlay),
      ptrBool(checkerboardRasterCacheImages),
      ptrBool(checkerboardOffscreenLayers),
      ptrBool(showSemanticsDebugger),
      ptrBool(debugShowCheckedModeBanner),
      ptrStr(restorationScopeId),
      ptrBool(useInheritedMediaQuery));
  }
  MemorySegment materialAppRouter(Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<String> title, Optional<Function<BuildContext, String>> onGenerateTitle, Optional<Color> color, Optional<ThemeData> theme, Optional<ThemeData> darkTheme, Optional<ThemeData> highContrastTheme, Optional<ThemeData> highContrastDarkTheme, Optional<ThemeMode> themeMode, Optional<Duration> themeAnimationDuration, Optional<Curve> themeAnimationCurve, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    var st = WidgetFactories.materialApp(factories);
    var fn = WidgetFactories.MaterialAppSt.router(st);
    return WidgetFactories.MaterialAppSt.router.invoke(fn, arena, builder.isPresent() ? ptrTransitionBuilderFn(builder.get()) : MemorySegment.NULL,
      ptrStr(title),
      onGenerateTitle.isPresent() ? ptrGenerateAppTitleFn(onGenerateTitle.get()) : MemorySegment.NULL,
      ptrObj(color),
      ptrObj(theme),
      ptrObj(darkTheme),
      ptrObj(highContrastTheme),
      ptrObj(highContrastDarkTheme),
      ptrEnum(themeMode),
      ptrObj(themeAnimationDuration),
      ptrObj(themeAnimationCurve),
      ptrBool(debugShowMaterialGrid),
      ptrBool(showPerformanceOverlay),
      ptrBool(checkerboardRasterCacheImages),
      ptrBool(checkerboardOffscreenLayers),
      ptrBool(showSemanticsDebugger),
      ptrBool(debugShowCheckedModeBanner),
      ptrStr(restorationScopeId),
      ptrBool(useInheritedMediaQuery));
  }

  MemorySegment floatingActionButtonFloatingActionButton(Optional<Widget> child, Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> splashColor, Optional<NativeObj> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<Boolean> mini, Optional<ShapeBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> isExtended, Optional<Boolean> enableFeedback) {
    var st = WidgetFactories.floatingActionButton(factories);
    var fn = WidgetFactories.FloatingActionButtonSt.floatingActionButton(st);
    return WidgetFactories.FloatingActionButtonSt.floatingActionButton.invoke(fn, arena, ptrObj(child),
      ptrStr(tooltip),
      ptrObj(foregroundColor),
      ptrObj(backgroundColor),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(splashColor),
      ptrObj(heroTag),
      ptr(elevation),
      ptr(focusElevation),
      ptr(hoverElevation),
      ptr(highlightElevation),
      ptr(disabledElevation),
      ptrVoidCallbackFn(onPressed),
      ptrBool(mini),
      ptrObj(shape),
      ptrEnum(clipBehavior),
      ptrBool(autofocus),
      ptrEnum(materialTapTargetSize),
      ptrBool(isExtended),
      ptrBool(enableFeedback));
  }
  MemorySegment floatingActionButtonSmall(Optional<Widget> child, Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> splashColor, Optional<NativeObj> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<ShapeBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> enableFeedback) {
    var st = WidgetFactories.floatingActionButton(factories);
    var fn = WidgetFactories.FloatingActionButtonSt.small(st);
    return WidgetFactories.FloatingActionButtonSt.small.invoke(fn, arena, ptrObj(child),
      ptrStr(tooltip),
      ptrObj(foregroundColor),
      ptrObj(backgroundColor),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(splashColor),
      ptrObj(heroTag),
      ptr(elevation),
      ptr(focusElevation),
      ptr(hoverElevation),
      ptr(highlightElevation),
      ptr(disabledElevation),
      ptrVoidCallbackFn(onPressed),
      ptrObj(shape),
      ptrEnum(clipBehavior),
      ptrBool(autofocus),
      ptrEnum(materialTapTargetSize),
      ptrBool(enableFeedback));
  }
  MemorySegment floatingActionButtonLarge(Optional<Widget> child, Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> splashColor, Optional<NativeObj> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<ShapeBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> enableFeedback) {
    var st = WidgetFactories.floatingActionButton(factories);
    var fn = WidgetFactories.FloatingActionButtonSt.large(st);
    return WidgetFactories.FloatingActionButtonSt.large.invoke(fn, arena, ptrObj(child),
      ptrStr(tooltip),
      ptrObj(foregroundColor),
      ptrObj(backgroundColor),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(splashColor),
      ptrObj(heroTag),
      ptr(elevation),
      ptr(focusElevation),
      ptr(hoverElevation),
      ptr(highlightElevation),
      ptr(disabledElevation),
      ptrVoidCallbackFn(onPressed),
      ptrObj(shape),
      ptrEnum(clipBehavior),
      ptrBool(autofocus),
      ptrEnum(materialTapTargetSize),
      ptrBool(enableFeedback));
  }
  MemorySegment floatingActionButtonExtended(Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<NativeObj> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, Optional<Color> splashColor, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<ShapeBorder> shape, Optional<Boolean> isExtended, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, OptionalDouble extendedIconLabelSpacing, Optional<EdgeInsetsGeometry> extendedPadding, Optional<TextStyle> extendedTextStyle, Optional<Widget> icon, Widget label, Optional<Boolean> enableFeedback) {
    var st = WidgetFactories.floatingActionButton(factories);
    var fn = WidgetFactories.FloatingActionButtonSt.extended(st);
    return WidgetFactories.FloatingActionButtonSt.extended.invoke(fn, arena, ptrStr(tooltip),
      ptrObj(foregroundColor),
      ptrObj(backgroundColor),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(heroTag),
      ptr(elevation),
      ptr(focusElevation),
      ptr(hoverElevation),
      ptrObj(splashColor),
      ptr(highlightElevation),
      ptr(disabledElevation),
      ptrVoidCallbackFn(onPressed),
      ptrObj(shape),
      ptrBool(isExtended),
      ptrEnum(materialTapTargetSize),
      ptrEnum(clipBehavior),
      ptrBool(autofocus),
      ptr(extendedIconLabelSpacing),
      ptrObj(extendedPadding),
      ptrObj(extendedTextStyle),
      ptrObj(icon),
      label.getId(),
      ptrBool(enableFeedback));
  }

  MemorySegment themeTheme(ThemeData data, Widget child) {
    var st = WidgetFactories.theme(factories);
    var fn = WidgetFactories.ThemeSt.theme(st);
    return WidgetFactories.ThemeSt.theme.invoke(fn, arena, data.getId(),
      child.getId());
  }
  MemorySegment themeOf(BuildContext context) {
    var st = WidgetFactories.theme(factories);
    var fn = WidgetFactories.ThemeSt.of(st);
    return WidgetFactories.ThemeSt.of.invoke(fn, arena, context.getId());
  }

  MemorySegment elevatedButtonElevatedButton(Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Widget child) {
    var st = WidgetFactories.elevatedButton(factories);
    var fn = WidgetFactories.ElevatedButtonSt.elevatedButton(st);
    return WidgetFactories.ElevatedButtonSt.elevatedButton.invoke(fn, arena, ptrVoidCallbackFn(onPressed),
      onLongPress.isPresent() ? ptrVoidCallbackFn(onLongPress.get()) : MemorySegment.NULL,
      onHover.isPresent() ? ptrValueChangedForBoolFn(onHover.get()) : MemorySegment.NULL,
      onFocusChange.isPresent() ? ptrValueChangedForBoolFn(onFocusChange.get()) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrEnum(clipBehavior),
      child != null ? child.getId() : null);
  }
  MemorySegment elevatedButtonIcon(Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> icon, Widget label, Optional<IconAlignment> iconAlignment) {
    var st = WidgetFactories.elevatedButton(factories);
    var fn = WidgetFactories.ElevatedButtonSt.icon(st);
    return WidgetFactories.ElevatedButtonSt.icon.invoke(fn, arena, ptrVoidCallbackFn(onPressed),
      onLongPress.isPresent() ? ptrVoidCallbackFn(onLongPress.get()) : MemorySegment.NULL,
      onHover.isPresent() ? ptrValueChangedForBoolFn(onHover.get()) : MemorySegment.NULL,
      onFocusChange.isPresent() ? ptrValueChangedForBoolFn(onFocusChange.get()) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrEnum(clipBehavior),
      ptrObj(icon),
      label.getId(),
      ptrEnum(iconAlignment));
  }

  MemorySegment outlinedButtonOutlinedButton(Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Widget child) {
    var st = WidgetFactories.outlinedButton(factories);
    var fn = WidgetFactories.OutlinedButtonSt.outlinedButton(st);
    return WidgetFactories.OutlinedButtonSt.outlinedButton.invoke(fn, arena, ptrVoidCallbackFn(onPressed),
      onLongPress.isPresent() ? ptrVoidCallbackFn(onLongPress.get()) : MemorySegment.NULL,
      onHover.isPresent() ? ptrValueChangedForBoolFn(onHover.get()) : MemorySegment.NULL,
      onFocusChange.isPresent() ? ptrValueChangedForBoolFn(onFocusChange.get()) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrEnum(clipBehavior),
      child != null ? child.getId() : null);
  }
  MemorySegment outlinedButtonIcon(Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> icon, Widget label, Optional<IconAlignment> iconAlignment) {
    var st = WidgetFactories.outlinedButton(factories);
    var fn = WidgetFactories.OutlinedButtonSt.icon(st);
    return WidgetFactories.OutlinedButtonSt.icon.invoke(fn, arena, ptrVoidCallbackFn(onPressed),
      onLongPress.isPresent() ? ptrVoidCallbackFn(onLongPress.get()) : MemorySegment.NULL,
      onHover.isPresent() ? ptrValueChangedForBoolFn(onHover.get()) : MemorySegment.NULL,
      onFocusChange.isPresent() ? ptrValueChangedForBoolFn(onFocusChange.get()) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrEnum(clipBehavior),
      ptrObj(icon),
      label.getId(),
      ptrEnum(iconAlignment));
  }

  MemorySegment textButtonTextButton(Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Boolean> isSemanticButton, Widget child) {
    var st = WidgetFactories.textButton(factories);
    var fn = WidgetFactories.TextButtonSt.textButton(st);
    return WidgetFactories.TextButtonSt.textButton.invoke(fn, arena, ptrVoidCallbackFn(onPressed),
      onLongPress.isPresent() ? ptrVoidCallbackFn(onLongPress.get()) : MemorySegment.NULL,
      onHover.isPresent() ? ptrValueChangedForBoolFn(onHover.get()) : MemorySegment.NULL,
      onFocusChange.isPresent() ? ptrValueChangedForBoolFn(onFocusChange.get()) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrEnum(clipBehavior),
      ptrBool(isSemanticButton),
      child.getId());
  }
  MemorySegment textButtonIcon(Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> icon, Widget label, Optional<IconAlignment> iconAlignment) {
    var st = WidgetFactories.textButton(factories);
    var fn = WidgetFactories.TextButtonSt.icon(st);
    return WidgetFactories.TextButtonSt.icon.invoke(fn, arena, ptrVoidCallbackFn(onPressed),
      onLongPress.isPresent() ? ptrVoidCallbackFn(onLongPress.get()) : MemorySegment.NULL,
      onHover.isPresent() ? ptrValueChangedForBoolFn(onHover.get()) : MemorySegment.NULL,
      onFocusChange.isPresent() ? ptrValueChangedForBoolFn(onFocusChange.get()) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrEnum(clipBehavior),
      ptrObj(icon),
      label.getId(),
      ptrEnum(iconAlignment));
  }

  int navigatorStateNavigatorState() {
    var st = WidgetFactories.navigatorState(factories);
    var fn = WidgetFactories.NavigatorStateSt.navigatorState(st);
    return WidgetFactories.NavigatorStateSt.navigatorState.invoke(fn);
  }

  MemorySegment navigatorNavigator(Optional<String> initialRoute, Optional<Boolean> reportsRouteUpdateToEngine, Optional<Clip> clipBehavior, Optional<Boolean> requestFocus, Optional<String> restorationScopeId, Optional<TraversalEdgeBehavior> routeTraversalEdgeBehavior) {
    var st = WidgetFactories.navigator(factories);
    var fn = WidgetFactories.NavigatorSt.navigator(st);
    return WidgetFactories.NavigatorSt.navigator.invoke(fn, arena, ptrStr(initialRoute),
      ptrBool(reportsRouteUpdateToEngine),
      ptrEnum(clipBehavior),
      ptrBool(requestFocus),
      ptrStr(restorationScopeId),
      ptrEnum(routeTraversalEdgeBehavior));
  }
  int navigatorOf(BuildContext context, Optional<Boolean> rootNavigator) {
    var st = WidgetFactories.navigator(factories);
    var fn = WidgetFactories.NavigatorSt.of(st);
    return WidgetFactories.NavigatorSt.of.invoke(fn, context.getId(),
      ptrBool(rootNavigator));
  }
  int navigatorMaybeOf(BuildContext context, Optional<Boolean> rootNavigator) {
    var st = WidgetFactories.navigator(factories);
    var fn = WidgetFactories.NavigatorSt.maybeOf(st);
    return WidgetFactories.NavigatorSt.maybeOf.invoke(fn, context.getId(),
      ptrBool(rootNavigator));
  }

  MemorySegment alertDialogAlertDialog(Optional<Widget> icon, Optional<EdgeInsetsGeometry> iconPadding, Optional<Color> iconColor, Optional<Widget> title, Optional<EdgeInsetsGeometry> titlePadding, Optional<TextStyle> titleTextStyle, Optional<Widget> content, Optional<EdgeInsetsGeometry> contentPadding, Optional<TextStyle> contentTextStyle, Optional<List<Widget>> actions, Optional<EdgeInsetsGeometry> actionsPadding, Optional<MainAxisAlignment> actionsAlignment, Optional<OverflowBarAlignment> actionsOverflowAlignment, Optional<VerticalDirection> actionsOverflowDirection, OptionalDouble actionsOverflowButtonSpacing, Optional<EdgeInsetsGeometry> buttonPadding, Optional<Color> backgroundColor, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<String> semanticLabel, Optional<EdgeInsets> insetPadding, Optional<Clip> clipBehavior, Optional<ShapeBorder> shape, Optional<AlignmentGeometry> alignment, Optional<Boolean> scrollable) {
    var st = WidgetFactories.alertDialog(factories);
    var fn = WidgetFactories.AlertDialogSt.alertDialog(st);
    return WidgetFactories.AlertDialogSt.alertDialog.invoke(fn, arena, ptrObj(icon),
      ptrObj(iconPadding),
      ptrObj(iconColor),
      ptrObj(title),
      ptrObj(titlePadding),
      ptrObj(titleTextStyle),
      ptrObj(content),
      ptrObj(contentPadding),
      ptrObj(contentTextStyle),
      ptrList(actions),
      ptrObj(actionsPadding),
      ptrEnum(actionsAlignment),
      ptrEnum(actionsOverflowAlignment),
      ptrEnum(actionsOverflowDirection),
      ptr(actionsOverflowButtonSpacing),
      ptrObj(buttonPadding),
      ptrObj(backgroundColor),
      ptr(elevation),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrStr(semanticLabel),
      ptrObj(insetPadding),
      ptrEnum(clipBehavior),
      ptrObj(shape),
      ptrObj(alignment),
      ptrBool(scrollable));
  }
  MemorySegment alertDialogAdaptive(Optional<Widget> icon, Optional<EdgeInsetsGeometry> iconPadding, Optional<Color> iconColor, Optional<Widget> title, Optional<EdgeInsetsGeometry> titlePadding, Optional<TextStyle> titleTextStyle, Optional<Widget> content, Optional<EdgeInsetsGeometry> contentPadding, Optional<TextStyle> contentTextStyle, Optional<List<Widget>> actions, Optional<EdgeInsetsGeometry> actionsPadding, Optional<MainAxisAlignment> actionsAlignment, Optional<OverflowBarAlignment> actionsOverflowAlignment, Optional<VerticalDirection> actionsOverflowDirection, OptionalDouble actionsOverflowButtonSpacing, Optional<EdgeInsetsGeometry> buttonPadding, Optional<Color> backgroundColor, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<String> semanticLabel, Optional<EdgeInsets> insetPadding, Optional<Clip> clipBehavior, Optional<ShapeBorder> shape, Optional<AlignmentGeometry> alignment, Optional<Boolean> scrollable, Optional<Duration> insetAnimationDuration, Optional<Curve> insetAnimationCurve) {
    var st = WidgetFactories.alertDialog(factories);
    var fn = WidgetFactories.AlertDialogSt.adaptive(st);
    return WidgetFactories.AlertDialogSt.adaptive.invoke(fn, arena, ptrObj(icon),
      ptrObj(iconPadding),
      ptrObj(iconColor),
      ptrObj(title),
      ptrObj(titlePadding),
      ptrObj(titleTextStyle),
      ptrObj(content),
      ptrObj(contentPadding),
      ptrObj(contentTextStyle),
      ptrList(actions),
      ptrObj(actionsPadding),
      ptrEnum(actionsAlignment),
      ptrEnum(actionsOverflowAlignment),
      ptrEnum(actionsOverflowDirection),
      ptr(actionsOverflowButtonSpacing),
      ptrObj(buttonPadding),
      ptrObj(backgroundColor),
      ptr(elevation),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrStr(semanticLabel),
      ptrObj(insetPadding),
      ptrEnum(clipBehavior),
      ptrObj(shape),
      ptrObj(alignment),
      ptrBool(scrollable),
      ptrObj(insetAnimationDuration),
      ptrObj(insetAnimationCurve));
  }

  MemorySegment textFieldTextField(Optional<NativeObj> groupId, Optional<TextInputAction> textInputAction, Optional<TextCapitalization> textCapitalization, Optional<TextStyle> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> readOnly, Optional<Boolean> showCursor, Optional<Boolean> autofocus, Optional<String> obscuringCharacter, Optional<Boolean> obscureText, Optional<Boolean> autocorrect, Optional<SmartDashesType> smartDashesType, Optional<SmartQuotesType> smartQuotesType, Optional<Boolean> enableSuggestions, OptionalInt maxLines, OptionalInt minLines, Optional<Boolean> expands, OptionalInt maxLength, Optional<MaxLengthEnforcement> maxLengthEnforcement, Optional<Consumer<String>> onChanged, Optional<Runnable> onEditingComplete, Optional<Consumer<String>> onSubmitted, Optional<Boolean> enabled, Optional<Boolean> ignorePointers, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<Radius> cursorRadius, Optional<Boolean> cursorOpacityAnimates, Optional<Color> cursorColor, Optional<Color> cursorErrorColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<Brightness> keyboardAppearance, Optional<EdgeInsets> scrollPadding, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Runnable> onTap, Optional<Boolean> onTapAlwaysCalled, Optional<QuadFunction<BuildContext, Integer, Boolean, Integer, Widget>> buildCounter, Optional<Clip> clipBehavior, Optional<String> restorationId, Optional<Boolean> scribbleEnabled, Optional<Boolean> stylusHandwritingEnabled, Optional<Boolean> enableIMEPersonalizedLearning, Optional<Boolean> canRequestFocus) {
    var st = WidgetFactories.textField(factories);
    var fn = WidgetFactories.TextFieldSt.textField(st);
    return WidgetFactories.TextFieldSt.textField.invoke(fn, arena, ptrObj(groupId),
      ptrEnum(textInputAction),
      ptrEnum(textCapitalization),
      ptrObj(style),
      ptrEnum(textAlign),
      ptrEnum(textDirection),
      ptrBool(readOnly),
      ptrBool(showCursor),
      ptrBool(autofocus),
      ptrStr(obscuringCharacter),
      ptrBool(obscureText),
      ptrBool(autocorrect),
      ptrEnum(smartDashesType),
      ptrEnum(smartQuotesType),
      ptrBool(enableSuggestions),
      ptr(maxLines),
      ptr(minLines),
      ptrBool(expands),
      ptr(maxLength),
      ptrEnum(maxLengthEnforcement),
      onChanged.isPresent() ? ptrValueChangedForStringFn(onChanged.get()) : MemorySegment.NULL,
      onEditingComplete.isPresent() ? ptrVoidCallbackFn(onEditingComplete.get()) : MemorySegment.NULL,
      onSubmitted.isPresent() ? ptrValueChangedForStringFn(onSubmitted.get()) : MemorySegment.NULL,
      ptrBool(enabled),
      ptrBool(ignorePointers),
      ptr(cursorWidth),
      ptr(cursorHeight),
      ptrObj(cursorRadius),
      ptrBool(cursorOpacityAnimates),
      ptrObj(cursorColor),
      ptrObj(cursorErrorColor),
      ptrEnum(selectionHeightStyle),
      ptrEnum(selectionWidthStyle),
      ptrEnum(keyboardAppearance),
      ptrObj(scrollPadding),
      ptrEnum(dragStartBehavior),
      ptrBool(enableInteractiveSelection),
      onTap.isPresent() ? ptrGestureTapCallbackFn(onTap.get()) : MemorySegment.NULL,
      ptrBool(onTapAlwaysCalled),
      buildCounter.isPresent() ? ptrInputCounterWidgetBuilderFn(buildCounter.get()) : MemorySegment.NULL,
      ptrEnum(clipBehavior),
      ptrStr(restorationId),
      ptrBool(scribbleEnabled),
      ptrBool(stylusHandwritingEnabled),
      ptrBool(enableIMEPersonalizedLearning),
      ptrBool(canRequestFocus));
  }

  MemorySegment dividerDivider(OptionalDouble height, OptionalDouble thickness, OptionalDouble indent, OptionalDouble endIndent, Optional<Color> color) {
    var st = WidgetFactories.divider(factories);
    var fn = WidgetFactories.DividerSt.divider(st);
    return WidgetFactories.DividerSt.divider.invoke(fn, arena, ptr(height),
      ptr(thickness),
      ptr(indent),
      ptr(endIndent),
      ptrObj(color));
  }
  MemorySegment dividerCreateBorderSide(BuildContext context, Optional<Color> color, OptionalDouble width) {
    var st = WidgetFactories.divider(factories);
    var fn = WidgetFactories.DividerSt.createBorderSide(st);
    return WidgetFactories.DividerSt.createBorderSide.invoke(fn, arena, context != null ? context.getId() : null,
      ptrObj(color),
      ptr(width));
  }

  <T extends StatefulWidget> MemorySegment subStateSubState(Runnable initStateFn, Consumer<T> didUpdateWidgetFn, Runnable reassembleFn, Runnable deactivateFn, Runnable activateFn, Runnable disposeFn, Function<BuildContext, Widget> buildFn, Runnable didChangeDependenciesFn) {
    var st = WidgetFactories.subState(factories);
    var fn = WidgetFactories.SubStateSt.subState(st);
    return WidgetFactories.SubStateSt.subState.invoke(fn, arena, ptrVoidCallbackFn(initStateFn),
      ptrVoidCallbackDartObjFn(didUpdateWidgetFn),
      ptrVoidCallbackFn(reassembleFn),
      ptrVoidCallbackFn(deactivateFn),
      ptrVoidCallbackFn(activateFn),
      ptrVoidCallbackFn(disposeFn),
      ptrDartObjCallbackDartObjFn(buildFn),
      ptrVoidCallbackFn(didChangeDependenciesFn));
  }

  MemorySegment subStatefulWidgetSubStatefulWidget(Supplier<State> createStateFn) {
    var st = WidgetFactories.subStatefulWidget(factories);
    var fn = WidgetFactories.SubStatefulWidgetSt.subStatefulWidget(st);
    return WidgetFactories.SubStatefulWidgetSt.subStatefulWidget.invoke(fn, arena, ptrDartObjCallbackFn(createStateFn));
  }

  MemorySegment subStatelessWidgetSubStatelessWidget(Function<BuildContext, Widget> buildFn) {
    var st = WidgetFactories.subStatelessWidget(factories);
    var fn = WidgetFactories.SubStatelessWidgetSt.subStatelessWidget(st);
    return WidgetFactories.SubStatelessWidgetSt.subStatelessWidget.invoke(fn, arena, ptrDartObjCallbackDartObjFn(buildFn));
  }

MemorySegment ptrTransitionBuilderFn(BiFunction<BuildContext, Widget, Widget> jFn) {
  return TransitionBuilderFFI.allocate((context, child) -> {
    final var jFnRet = jFn.apply(new BuildContext() { public int getId() { return context; } }, new Widget(child) {});
    return jFnRet.getId();
  }, arena);
}
MemorySegment ptrVoidCallbackFn(Runnable jFn) {
  return VoidCallbackFFI.allocate(() -> {
    jFn.run();
  }, arena);
}
MemorySegment ptrValueChangedForBoolFn(Consumer<Boolean> jFn) {
  return ValueChangedForBoolFFI.allocate((value) -> {
    jFn.accept(intToBool(value));
  }, arena);
}
MemorySegment ptrDrawerCallbackFn(Consumer<Boolean> jFn) {
  return DrawerCallbackFFI.allocate((isOpened) -> {
    jFn.accept(intToBool(isOpened));
  }, arena);
}
MemorySegment ptrGenerateAppTitleFn(Function<BuildContext, String> jFn) {
  return GenerateAppTitleFFI.allocate((context) -> {
    final var jFnRet = jFn.apply(new BuildContext() { public int getId() { return context; } });
    return arena.allocateFrom(jFnRet);
  }, arena);
}
MemorySegment ptrValueChangedForStringFn(Consumer<String> jFn) {
  return ValueChangedForStringFFI.allocate((value) -> {
    jFn.accept(value.getString(0));
  }, arena);
}
MemorySegment ptrGestureTapCallbackFn(Runnable jFn) {
  return GestureTapCallbackFFI.allocate(() -> {
    jFn.run();
  }, arena);
}
MemorySegment ptrInputCounterWidgetBuilderFn(QuadFunction<BuildContext, Integer, Boolean, Integer, Widget> jFn) {
  return InputCounterWidgetBuilderFFI.allocate((context, currentLength, isFocused, maxLength) -> {
    final var jFnRet = jFn.apply(new BuildContext() { public int getId() { return context; } }, currentLength, intToBool(isFocused), maxLength);
    return jFnRet != null ? jFnRet.getId() : null;
  }, arena);
}
<T extends StatefulWidget> MemorySegment ptrVoidCallbackDartObjFn(Consumer<T> jFn) {
  return VoidCallbackDartObjFFI.allocate((t) -> {
    jFn.accept(SubclassedInJava.getSubNatObj(t));
  }, arena);
}
MemorySegment ptrDartObjCallbackDartObjFn(Function<BuildContext, Widget> jFn) {
  return DartObjCallbackDartObjFFI.allocate((b) -> {
    final var jFnRet = jFn.apply(new BuildContext() { public int getId() { return b; } });
    return jFnRet.getId();
  }, arena);
}
MemorySegment ptrDartObjCallbackFn(Supplier<State> jFn) {
  return DartObjCallbackFFI.allocate(() -> {
    final var jFnRet = jFn.get();
    return jFnRet.getId();
  }, arena);
}
}
