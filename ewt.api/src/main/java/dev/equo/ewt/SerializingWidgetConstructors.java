package dev.equo.ewt;
import dev.equo.ewt.ffm.*;
import dev.equo.ewt.util.*;
import dev.equo.ewt.web.EwtNode;
import java.lang.foreign.MemorySegment;
import java.util.*;
import java.util.function.*;
public class SerializingWidgetConstructors extends WidgetConstructors {
  private int nextId = 1;
  private int nextCallbackId = 1;
  private final Map<Integer, EwtNode> byId = new HashMap<>();
  private final Map<Integer, Object> callbacks = new HashMap<>();
  public Map<Integer, Object> callbacks() { return callbacks; }
  public EwtNode rootNode(int rootWidgetId) { EwtNode n = byId.get(rootWidgetId);
    if (n == null) throw new IllegalStateException("No recorded node for id " + rootWidgetId); return n; }
  private void record(int id, String type, Map<String,Object> p) { byId.put(id, new EwtNode(id, type, p, java.util.List.of())); }
  public int recordAccessor(String type, int receiverId) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    EwtNode recv = byId.get(receiverId);
    if (recv != null) p.put("receiver", recv);
    record(id, type, p);
    return id;
  }
  @Override
  MemorySegment textStyleTextStyle(Optional<Boolean> inherit, Optional<Color> color, Optional<Color> backgroundColor, OptionalDouble fontSize, Optional<FontWeight> fontWeight, Optional<FontStyle> fontStyle, OptionalDouble letterSpacing, OptionalDouble wordSpacing, Optional<TextBaseline> textBaseline, OptionalDouble height, Optional<TextLeadingDistribution> leadingDistribution, Optional<List<Shadow>> shadows, Optional<TextDecoration> decoration, Optional<Color> decorationColor, Optional<TextDecorationStyle> decorationStyle, OptionalDouble decorationThickness, Optional<String> debugLabel, Optional<String> fontFamily, Optional<List<String>> fontFamilyFallback, Optional<String> _package, Optional<TextOverflow> overflow) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    inherit.ifPresent(v -> p.put("inherit", v));
    color.ifPresent(v -> p.put("color", byId.get(v.getId())));
    backgroundColor.ifPresent(v -> p.put("backgroundColor", byId.get(v.getId())));
    if (fontSize.isPresent()) { p.put("fontSize", fontSize.getAsDouble()); }
    fontWeight.ifPresent(v -> p.put("fontWeight", byId.get(v.getId())));
    fontStyle.ifPresent(v -> p.put("fontStyle", v.ordinal()));
    if (letterSpacing.isPresent()) { p.put("letterSpacing", letterSpacing.getAsDouble()); }
    if (wordSpacing.isPresent()) { p.put("wordSpacing", wordSpacing.getAsDouble()); }
    textBaseline.ifPresent(v -> p.put("textBaseline", v.ordinal()));
    if (height.isPresent()) { p.put("height", height.getAsDouble()); }
    leadingDistribution.ifPresent(v -> p.put("leadingDistribution", v.ordinal()));
    shadows.ifPresent(v -> p.put("shadows", v.stream().map(e -> byId.get(e.getId())).collect(java.util.stream.Collectors.toList())));
    decoration.ifPresent(v -> p.put("decoration", byId.get(v.getId())));
    decorationColor.ifPresent(v -> p.put("decorationColor", byId.get(v.getId())));
    decorationStyle.ifPresent(v -> p.put("decorationStyle", v.ordinal()));
    if (decorationThickness.isPresent()) { p.put("decorationThickness", decorationThickness.getAsDouble()); }
    debugLabel.ifPresent(v -> p.put("debugLabel", v));
    fontFamily.ifPresent(v -> p.put("fontFamily", v));
    fontFamilyFallback.ifPresent(v -> p.put("fontFamilyFallback", v.stream().map(e -> e).collect(java.util.stream.Collectors.toList())));
    _package.ifPresent(v -> p.put("package", v));
    overflow.ifPresent(v -> p.put("overflow", v.ordinal()));
    record(id, "textStyleTextStyle", p);
    MemorySegment st = TextStyleObjSt.allocate(arena);
    TextStyleObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment textStyleLerp(TextStyle a, TextStyle b, double t) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", byId.get(a.getId()));
    p.put("b", byId.get(b.getId()));
    p.put("t", t);
    record(id, "textStyleLerp", p);
    MemorySegment st = TextStyleObjSt.allocate(arena);
    TextStyleObjSt.id(st, id);
    return st;
  }

  @Override
  int colorColor(int value) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("value", value);
    record(id, "colorColor", p);
    return id;
  }
  @Override
  int colorFrom(double alpha, double red, double green, double blue, Optional<ColorSpace> colorSpace) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("alpha", alpha);
    p.put("red", red);
    p.put("green", green);
    p.put("blue", blue);
    colorSpace.ifPresent(v -> p.put("colorSpace", v.ordinal()));
    record(id, "colorFrom", p);
    return id;
  }
  @Override
  int colorFromARGB(int a, int r, int g, int b) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", a);
    p.put("r", r);
    p.put("g", g);
    p.put("b", b);
    record(id, "colorFromARGB", p);
    return id;
  }
  @Override
  int colorFromRGBO(int r, int g, int b, double opacity) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("r", r);
    p.put("g", g);
    p.put("b", b);
    p.put("opacity", opacity);
    record(id, "colorFromRGBO", p);
    return id;
  }
  @Override
  int colorLerp(Color x, Color y, double t) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("x", byId.get(x.getId()));
    p.put("y", byId.get(y.getId()));
    p.put("t", t);
    record(id, "colorLerp", p);
    return id;
  }
  @Override
  int colorAlphaBlend(Color foreground, Color background) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("foreground", byId.get(foreground.getId()));
    p.put("background", byId.get(background.getId()));
    record(id, "colorAlphaBlend", p);
    return id;
  }
  @Override
  int colorGetAlphaFromOpacity(double opacity) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("opacity", opacity);
    record(id, "colorGetAlphaFromOpacity", p);
    return id;
  }

  @Override
  int offsetOffset(double dx, double dy) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("dx", dx);
    p.put("dy", dy);
    record(id, "offsetOffset", p);
    return id;
  }
  @Override
  int offsetFromDirection(double direction, OptionalDouble distance) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("direction", direction);
    if (distance.isPresent()) { p.put("distance", distance.getAsDouble()); }
    record(id, "offsetFromDirection", p);
    return id;
  }
  @Override
  int offsetLerp(Offset a, Offset b, double t) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", byId.get(a.getId()));
    p.put("b", byId.get(b.getId()));
    p.put("t", t);
    record(id, "offsetLerp", p);
    return id;
  }

  @Override
  int fontWeightLerp(FontWeight a, FontWeight b, double t) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", byId.get(a.getId()));
    p.put("b", byId.get(b.getId()));
    p.put("t", t);
    record(id, "fontWeightLerp", p);
    return id;
  }
  @Override
  int fontWeightW100() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "fontWeightW100", p);
    return id;
  }
  @Override
  int fontWeightW200() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "fontWeightW200", p);
    return id;
  }
  @Override
  int fontWeightW300() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "fontWeightW300", p);
    return id;
  }
  @Override
  int fontWeightW400() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "fontWeightW400", p);
    return id;
  }
  @Override
  int fontWeightW500() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "fontWeightW500", p);
    return id;
  }
  @Override
  int fontWeightW600() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "fontWeightW600", p);
    return id;
  }
  @Override
  int fontWeightW700() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "fontWeightW700", p);
    return id;
  }
  @Override
  int fontWeightW800() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "fontWeightW800", p);
    return id;
  }
  @Override
  int fontWeightW900() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "fontWeightW900", p);
    return id;
  }

  @Override
  int textDecorationCombine(List<TextDecoration> decorations) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("decorations", decorations.stream().map(e -> byId.get(e.getId())).collect(java.util.stream.Collectors.toList()));
    record(id, "textDecorationCombine", p);
    return id;
  }
  @Override
  int textDecorationNone() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "textDecorationNone", p);
    return id;
  }
  @Override
  int textDecorationUnderline() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "textDecorationUnderline", p);
    return id;
  }
  @Override
  int textDecorationOverline() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "textDecorationOverline", p);
    return id;
  }
  @Override
  int textDecorationLineThrough() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "textDecorationLineThrough", p);
    return id;
  }

  @Override
  MemorySegment textText(String data, Optional<TextStyle> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<String> semanticsIdentifier, Optional<TextWidthBasis> textWidthBasis, Optional<Color> selectionColor) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("data", data);
    style.ifPresent(v -> p.put("style", byId.get(v.getId())));
    textAlign.ifPresent(v -> p.put("textAlign", v.ordinal()));
    textDirection.ifPresent(v -> p.put("textDirection", v.ordinal()));
    softWrap.ifPresent(v -> p.put("softWrap", v));
    overflow.ifPresent(v -> p.put("overflow", v.ordinal()));
    if (textScaleFactor.isPresent()) { p.put("textScaleFactor", textScaleFactor.getAsDouble()); }
    if (maxLines.isPresent()) { p.put("maxLines", maxLines.getAsInt()); }
    semanticsLabel.ifPresent(v -> p.put("semanticsLabel", v));
    semanticsIdentifier.ifPresent(v -> p.put("semanticsIdentifier", v));
    textWidthBasis.ifPresent(v -> p.put("textWidthBasis", v.ordinal()));
    selectionColor.ifPresent(v -> p.put("selectionColor", byId.get(v.getId())));
    record(id, "textText", p);
    MemorySegment st = TextObjSt.allocate(arena);
    TextObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment textRich(InlineSpan textSpan, Optional<TextStyle> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<String> semanticsIdentifier, Optional<TextWidthBasis> textWidthBasis, Optional<Color> selectionColor) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("textSpan", byId.get(textSpan.getId()));
    style.ifPresent(v -> p.put("style", byId.get(v.getId())));
    textAlign.ifPresent(v -> p.put("textAlign", v.ordinal()));
    textDirection.ifPresent(v -> p.put("textDirection", v.ordinal()));
    softWrap.ifPresent(v -> p.put("softWrap", v));
    overflow.ifPresent(v -> p.put("overflow", v.ordinal()));
    if (textScaleFactor.isPresent()) { p.put("textScaleFactor", textScaleFactor.getAsDouble()); }
    if (maxLines.isPresent()) { p.put("maxLines", maxLines.getAsInt()); }
    semanticsLabel.ifPresent(v -> p.put("semanticsLabel", v));
    semanticsIdentifier.ifPresent(v -> p.put("semanticsIdentifier", v));
    textWidthBasis.ifPresent(v -> p.put("textWidthBasis", v.ordinal()));
    selectionColor.ifPresent(v -> p.put("selectionColor", byId.get(v.getId())));
    record(id, "textRich", p);
    MemorySegment st = TextObjSt.allocate(arena);
    TextObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment textSpanTextSpan(Optional<String> text, Optional<List<InlineSpan>> children, Optional<TextStyle> style, Optional<String> semanticsLabel, Optional<String> semanticsIdentifier, Optional<Boolean> spellOut) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    text.ifPresent(v -> p.put("text", v));
    children.ifPresent(v -> p.put("children", v.stream().map(e -> byId.get(e.getId())).collect(java.util.stream.Collectors.toList())));
    style.ifPresent(v -> p.put("style", byId.get(v.getId())));
    semanticsLabel.ifPresent(v -> p.put("semanticsLabel", v));
    semanticsIdentifier.ifPresent(v -> p.put("semanticsIdentifier", v));
    spellOut.ifPresent(v -> p.put("spellOut", v));
    record(id, "textSpanTextSpan", p);
    MemorySegment st = TextSpanObjSt.allocate(arena);
    TextSpanObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment richTextRichText(InlineSpan text, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<TextWidthBasis> textWidthBasis, Optional<Color> selectionColor) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("text", byId.get(text.getId()));
    textAlign.ifPresent(v -> p.put("textAlign", v.ordinal()));
    textDirection.ifPresent(v -> p.put("textDirection", v.ordinal()));
    softWrap.ifPresent(v -> p.put("softWrap", v));
    overflow.ifPresent(v -> p.put("overflow", v.ordinal()));
    if (textScaleFactor.isPresent()) { p.put("textScaleFactor", textScaleFactor.getAsDouble()); }
    if (maxLines.isPresent()) { p.put("maxLines", maxLines.getAsInt()); }
    textWidthBasis.ifPresent(v -> p.put("textWidthBasis", v.ordinal()));
    selectionColor.ifPresent(v -> p.put("selectionColor", byId.get(v.getId())));
    record(id, "richTextRichText", p);
    MemorySegment st = RichTextObjSt.allocate(arena);
    RichTextObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment centerCenter(OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<Widget> child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (widthFactor.isPresent()) { p.put("widthFactor", widthFactor.getAsDouble()); }
    if (heightFactor.isPresent()) { p.put("heightFactor", heightFactor.getAsDouble()); }
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    record(id, "centerCenter", p);
    MemorySegment st = CenterObjSt.allocate(arena);
    CenterObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment alignAlign(Optional<AlignmentGeometry> alignment, OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<Widget> child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    alignment.ifPresent(v -> p.put("alignment", byId.get(v.getId())));
    if (widthFactor.isPresent()) { p.put("widthFactor", widthFactor.getAsDouble()); }
    if (heightFactor.isPresent()) { p.put("heightFactor", heightFactor.getAsDouble()); }
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    record(id, "alignAlign", p);
    MemorySegment st = AlignObjSt.allocate(arena);
    AlignObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment columnColumn(Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, OptionalDouble spacing, Optional<List<Widget>> children) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    mainAxisAlignment.ifPresent(v -> p.put("mainAxisAlignment", v.ordinal()));
    mainAxisSize.ifPresent(v -> p.put("mainAxisSize", v.ordinal()));
    crossAxisAlignment.ifPresent(v -> p.put("crossAxisAlignment", v.ordinal()));
    textDirection.ifPresent(v -> p.put("textDirection", v.ordinal()));
    verticalDirection.ifPresent(v -> p.put("verticalDirection", v.ordinal()));
    textBaseline.ifPresent(v -> p.put("textBaseline", v.ordinal()));
    if (spacing.isPresent()) { p.put("spacing", spacing.getAsDouble()); }
    children.ifPresent(v -> p.put("children", v.stream().map(e -> byId.get(e.getId())).collect(java.util.stream.Collectors.toList())));
    record(id, "columnColumn", p);
    MemorySegment st = ColumnObjSt.allocate(arena);
    ColumnObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment flexFlex(Axis direction, Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, Optional<Clip> clipBehavior, OptionalDouble spacing, Optional<List<Widget>> children) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("direction", direction.ordinal());
    mainAxisAlignment.ifPresent(v -> p.put("mainAxisAlignment", v.ordinal()));
    mainAxisSize.ifPresent(v -> p.put("mainAxisSize", v.ordinal()));
    crossAxisAlignment.ifPresent(v -> p.put("crossAxisAlignment", v.ordinal()));
    textDirection.ifPresent(v -> p.put("textDirection", v.ordinal()));
    verticalDirection.ifPresent(v -> p.put("verticalDirection", v.ordinal()));
    textBaseline.ifPresent(v -> p.put("textBaseline", v.ordinal()));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    if (spacing.isPresent()) { p.put("spacing", spacing.getAsDouble()); }
    children.ifPresent(v -> p.put("children", v.stream().map(e -> byId.get(e.getId())).collect(java.util.stream.Collectors.toList())));
    record(id, "flexFlex", p);
    MemorySegment st = FlexObjSt.allocate(arena);
    FlexObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment rowRow(Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, OptionalDouble spacing, Optional<List<Widget>> children) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    mainAxisAlignment.ifPresent(v -> p.put("mainAxisAlignment", v.ordinal()));
    mainAxisSize.ifPresent(v -> p.put("mainAxisSize", v.ordinal()));
    crossAxisAlignment.ifPresent(v -> p.put("crossAxisAlignment", v.ordinal()));
    textDirection.ifPresent(v -> p.put("textDirection", v.ordinal()));
    verticalDirection.ifPresent(v -> p.put("verticalDirection", v.ordinal()));
    textBaseline.ifPresent(v -> p.put("textBaseline", v.ordinal()));
    if (spacing.isPresent()) { p.put("spacing", spacing.getAsDouble()); }
    children.ifPresent(v -> p.put("children", v.stream().map(e -> byId.get(e.getId())).collect(java.util.stream.Collectors.toList())));
    record(id, "rowRow", p);
    MemorySegment st = RowObjSt.allocate(arena);
    RowObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment iconDataIconData(int codePoint, Optional<String> fontFamily, Optional<String> fontPackage, Optional<Boolean> matchTextDirection, Optional<List<String>> fontFamilyFallback) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("codePoint", codePoint);
    fontFamily.ifPresent(v -> p.put("fontFamily", v));
    fontPackage.ifPresent(v -> p.put("fontPackage", v));
    matchTextDirection.ifPresent(v -> p.put("matchTextDirection", v));
    fontFamilyFallback.ifPresent(v -> p.put("fontFamilyFallback", v.stream().map(e -> e).collect(java.util.stream.Collectors.toList())));
    record(id, "iconDataIconData", p);
    MemorySegment st = IconDataObjSt.allocate(arena);
    IconDataObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment iconIcon(IconData icon, OptionalDouble size, OptionalDouble fill, OptionalDouble weight, OptionalDouble grade, OptionalDouble opticalSize, Optional<Color> color, Optional<List<Shadow>> shadows, Optional<String> semanticLabel, Optional<TextDirection> textDirection, Optional<Boolean> applyTextScaling, Optional<BlendMode> blendMode, Optional<FontWeight> fontWeight) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("icon", byId.get(icon.getId()));
    if (size.isPresent()) { p.put("size", size.getAsDouble()); }
    if (fill.isPresent()) { p.put("fill", fill.getAsDouble()); }
    if (weight.isPresent()) { p.put("weight", weight.getAsDouble()); }
    if (grade.isPresent()) { p.put("grade", grade.getAsDouble()); }
    if (opticalSize.isPresent()) { p.put("opticalSize", opticalSize.getAsDouble()); }
    color.ifPresent(v -> p.put("color", byId.get(v.getId())));
    shadows.ifPresent(v -> p.put("shadows", v.stream().map(e -> byId.get(e.getId())).collect(java.util.stream.Collectors.toList())));
    semanticLabel.ifPresent(v -> p.put("semanticLabel", v));
    textDirection.ifPresent(v -> p.put("textDirection", v.ordinal()));
    applyTextScaling.ifPresent(v -> p.put("applyTextScaling", v));
    blendMode.ifPresent(v -> p.put("blendMode", v.ordinal()));
    fontWeight.ifPresent(v -> p.put("fontWeight", byId.get(v.getId())));
    record(id, "iconIcon", p);
    MemorySegment st = IconObjSt.allocate(arena);
    IconObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment transformRotate(double angle, Optional<Offset> origin, Optional<AlignmentGeometry> alignment, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<Widget> child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("angle", angle);
    origin.ifPresent(v -> p.put("origin", byId.get(v.getId())));
    alignment.ifPresent(v -> p.put("alignment", byId.get(v.getId())));
    transformHitTests.ifPresent(v -> p.put("transformHitTests", v));
    filterQuality.ifPresent(v -> p.put("filterQuality", v.ordinal()));
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    record(id, "transformRotate", p);
    MemorySegment st = TransformObjSt.allocate(arena);
    TransformObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment transformTranslate(Offset offset, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<Widget> child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("offset", byId.get(offset.getId()));
    transformHitTests.ifPresent(v -> p.put("transformHitTests", v));
    filterQuality.ifPresent(v -> p.put("filterQuality", v.ordinal()));
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    record(id, "transformTranslate", p);
    MemorySegment st = TransformObjSt.allocate(arena);
    TransformObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment transformScale(OptionalDouble scale, OptionalDouble scaleX, OptionalDouble scaleY, Optional<Offset> origin, Optional<AlignmentGeometry> alignment, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<Widget> child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (scale.isPresent()) { p.put("scale", scale.getAsDouble()); }
    if (scaleX.isPresent()) { p.put("scaleX", scaleX.getAsDouble()); }
    if (scaleY.isPresent()) { p.put("scaleY", scaleY.getAsDouble()); }
    origin.ifPresent(v -> p.put("origin", byId.get(v.getId())));
    alignment.ifPresent(v -> p.put("alignment", byId.get(v.getId())));
    transformHitTests.ifPresent(v -> p.put("transformHitTests", v));
    filterQuality.ifPresent(v -> p.put("filterQuality", v.ordinal()));
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    record(id, "transformScale", p);
    MemorySegment st = TransformObjSt.allocate(arena);
    TransformObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment transformFlip(Optional<Boolean> flipX, Optional<Boolean> flipY, Optional<Offset> origin, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<Widget> child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    flipX.ifPresent(v -> p.put("flipX", v));
    flipY.ifPresent(v -> p.put("flipY", v));
    origin.ifPresent(v -> p.put("origin", byId.get(v.getId())));
    transformHitTests.ifPresent(v -> p.put("transformHitTests", v));
    filterQuality.ifPresent(v -> p.put("filterQuality", v.ordinal()));
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    record(id, "transformFlip", p);
    MemorySegment st = TransformObjSt.allocate(arena);
    TransformObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment opacityOpacity(double opacity, Optional<Boolean> alwaysIncludeSemantics, Optional<Widget> child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("opacity", opacity);
    alwaysIncludeSemantics.ifPresent(v -> p.put("alwaysIncludeSemantics", v));
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    record(id, "opacityOpacity", p);
    MemorySegment st = OpacityObjSt.allocate(arena);
    OpacityObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment stackStack(Optional<AlignmentGeometry> alignment, Optional<TextDirection> textDirection, Optional<StackFit> fit, Optional<Clip> clipBehavior, Optional<List<Widget>> children) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    alignment.ifPresent(v -> p.put("alignment", byId.get(v.getId())));
    textDirection.ifPresent(v -> p.put("textDirection", v.ordinal()));
    fit.ifPresent(v -> p.put("fit", v.ordinal()));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    children.ifPresent(v -> p.put("children", v.stream().map(e -> byId.get(e.getId())).collect(java.util.stream.Collectors.toList())));
    record(id, "stackStack", p);
    MemorySegment st = StackObjSt.allocate(arena);
    StackObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment boxConstraintsBoxConstraints(OptionalDouble minWidth, OptionalDouble maxWidth, OptionalDouble minHeight, OptionalDouble maxHeight) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (minWidth.isPresent()) { p.put("minWidth", minWidth.getAsDouble()); }
    if (maxWidth.isPresent()) { p.put("maxWidth", maxWidth.getAsDouble()); }
    if (minHeight.isPresent()) { p.put("minHeight", minHeight.getAsDouble()); }
    if (maxHeight.isPresent()) { p.put("maxHeight", maxHeight.getAsDouble()); }
    record(id, "boxConstraintsBoxConstraints", p);
    MemorySegment st = BoxConstraintsObjSt.allocate(arena);
    BoxConstraintsObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment boxConstraintsTightFor(OptionalDouble width, OptionalDouble height) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (width.isPresent()) { p.put("width", width.getAsDouble()); }
    if (height.isPresent()) { p.put("height", height.getAsDouble()); }
    record(id, "boxConstraintsTightFor", p);
    MemorySegment st = BoxConstraintsObjSt.allocate(arena);
    BoxConstraintsObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment boxConstraintsTightForFinite(OptionalDouble width, OptionalDouble height) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (width.isPresent()) { p.put("width", width.getAsDouble()); }
    if (height.isPresent()) { p.put("height", height.getAsDouble()); }
    record(id, "boxConstraintsTightForFinite", p);
    MemorySegment st = BoxConstraintsObjSt.allocate(arena);
    BoxConstraintsObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment boxConstraintsExpand(OptionalDouble width, OptionalDouble height) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (width.isPresent()) { p.put("width", width.getAsDouble()); }
    if (height.isPresent()) { p.put("height", height.getAsDouble()); }
    record(id, "boxConstraintsExpand", p);
    MemorySegment st = BoxConstraintsObjSt.allocate(arena);
    BoxConstraintsObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment boxConstraintsLerp(BoxConstraints a, BoxConstraints b, double t) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", byId.get(a.getId()));
    p.put("b", byId.get(b.getId()));
    p.put("t", t);
    record(id, "boxConstraintsLerp", p);
    MemorySegment st = BoxConstraintsObjSt.allocate(arena);
    BoxConstraintsObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment containerContainer(Optional<AlignmentGeometry> alignment, Optional<EdgeInsetsGeometry> padding, Optional<Color> color, Optional<Decoration> decoration, Optional<Decoration> foregroundDecoration, OptionalDouble width, OptionalDouble height, Optional<BoxConstraints> constraints, Optional<EdgeInsetsGeometry> margin, Optional<AlignmentGeometry> transformAlignment, Optional<Widget> child, Optional<Clip> clipBehavior) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    alignment.ifPresent(v -> p.put("alignment", byId.get(v.getId())));
    padding.ifPresent(v -> p.put("padding", byId.get(v.getId())));
    color.ifPresent(v -> p.put("color", byId.get(v.getId())));
    decoration.ifPresent(v -> p.put("decoration", byId.get(v.getId())));
    foregroundDecoration.ifPresent(v -> p.put("foregroundDecoration", byId.get(v.getId())));
    if (width.isPresent()) { p.put("width", width.getAsDouble()); }
    if (height.isPresent()) { p.put("height", height.getAsDouble()); }
    constraints.ifPresent(v -> p.put("constraints", byId.get(v.getId())));
    margin.ifPresent(v -> p.put("margin", byId.get(v.getId())));
    transformAlignment.ifPresent(v -> p.put("transformAlignment", byId.get(v.getId())));
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    record(id, "containerContainer", p);
    MemorySegment st = ContainerObjSt.allocate(arena);
    ContainerObjSt.id(st, id);
    return st;
  }

  @Override
  int edgeInsetsGeometryInfinity() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "edgeInsetsGeometryInfinity", p);
    return id;
  }

  @Override
  int stackParentDataStackParentData() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "stackParentDataStackParentData", p);
    return id;
  }

  @Override
  int boxParentDataBoxParentData() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "boxParentDataBoxParentData", p);
    return id;
  }

  @Override
  int parentDataParentData() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "parentDataParentData", p);
    return id;
  }

  @Override
  int flexParentDataFlexParentData() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "flexParentDataFlexParentData", p);
    return id;
  }

  @Override
  MemorySegment positionedPositioned(OptionalDouble left, OptionalDouble top, OptionalDouble right, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, Widget child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (left.isPresent()) { p.put("left", left.getAsDouble()); }
    if (top.isPresent()) { p.put("top", top.getAsDouble()); }
    if (right.isPresent()) { p.put("right", right.getAsDouble()); }
    if (bottom.isPresent()) { p.put("bottom", bottom.getAsDouble()); }
    if (width.isPresent()) { p.put("width", width.getAsDouble()); }
    if (height.isPresent()) { p.put("height", height.getAsDouble()); }
    p.put("child", byId.get(child.getId()));
    record(id, "positionedPositioned", p);
    MemorySegment st = PositionedObjSt.allocate(arena);
    PositionedObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment positionedFill(OptionalDouble left, OptionalDouble top, OptionalDouble right, OptionalDouble bottom, Widget child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (left.isPresent()) { p.put("left", left.getAsDouble()); }
    if (top.isPresent()) { p.put("top", top.getAsDouble()); }
    if (right.isPresent()) { p.put("right", right.getAsDouble()); }
    if (bottom.isPresent()) { p.put("bottom", bottom.getAsDouble()); }
    p.put("child", byId.get(child.getId()));
    record(id, "positionedFill", p);
    MemorySegment st = PositionedObjSt.allocate(arena);
    PositionedObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment positionedDirectional(TextDirection textDirection, OptionalDouble start, OptionalDouble top, OptionalDouble end, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, Widget child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("textDirection", textDirection.ordinal());
    if (start.isPresent()) { p.put("start", start.getAsDouble()); }
    if (top.isPresent()) { p.put("top", top.getAsDouble()); }
    if (end.isPresent()) { p.put("end", end.getAsDouble()); }
    if (bottom.isPresent()) { p.put("bottom", bottom.getAsDouble()); }
    if (width.isPresent()) { p.put("width", width.getAsDouble()); }
    if (height.isPresent()) { p.put("height", height.getAsDouble()); }
    p.put("child", byId.get(child.getId()));
    record(id, "positionedDirectional", p);
    MemorySegment st = PositionedObjSt.allocate(arena);
    PositionedObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment boxDecorationBoxDecoration(Optional<Color> color, Optional<BoxBorder> border, Optional<BorderRadiusGeometry> borderRadius, Optional<List<BoxShadow>> boxShadow, Optional<BlendMode> backgroundBlendMode, Optional<BoxShape> shape) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    color.ifPresent(v -> p.put("color", byId.get(v.getId())));
    border.ifPresent(v -> p.put("border", byId.get(v.getId())));
    borderRadius.ifPresent(v -> p.put("borderRadius", byId.get(v.getId())));
    boxShadow.ifPresent(v -> p.put("boxShadow", v.stream().map(e -> byId.get(e.getId())).collect(java.util.stream.Collectors.toList())));
    backgroundBlendMode.ifPresent(v -> p.put("backgroundBlendMode", v.ordinal()));
    shape.ifPresent(v -> p.put("shape", v.ordinal()));
    record(id, "boxDecorationBoxDecoration", p);
    MemorySegment st = BoxDecorationObjSt.allocate(arena);
    BoxDecorationObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment boxDecorationLerp(BoxDecoration a, BoxDecoration b, double t) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", byId.get(a.getId()));
    p.put("b", byId.get(b.getId()));
    p.put("t", t);
    record(id, "boxDecorationLerp", p);
    MemorySegment st = BoxDecorationObjSt.allocate(arena);
    BoxDecorationObjSt.id(st, id);
    return st;
  }

  @Override
  int radiusCircular(double radius) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("radius", radius);
    record(id, "radiusCircular", p);
    return id;
  }
  @Override
  int radiusElliptical(double x, double y) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("x", x);
    p.put("y", y);
    record(id, "radiusElliptical", p);
    return id;
  }
  @Override
  int radiusLerp(Radius a, Radius b, double t) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", byId.get(a.getId()));
    p.put("b", byId.get(b.getId()));
    p.put("t", t);
    record(id, "radiusLerp", p);
    return id;
  }

  @Override
  MemorySegment borderRadiusAll(Radius radius) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("radius", byId.get(radius.getId()));
    record(id, "borderRadiusAll", p);
    MemorySegment st = BorderRadiusObjSt.allocate(arena);
    BorderRadiusObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment borderRadiusCircular(double radius) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("radius", radius);
    record(id, "borderRadiusCircular", p);
    MemorySegment st = BorderRadiusObjSt.allocate(arena);
    BorderRadiusObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment borderRadiusVertical(Optional<Radius> top, Optional<Radius> bottom) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    top.ifPresent(v -> p.put("top", byId.get(v.getId())));
    bottom.ifPresent(v -> p.put("bottom", byId.get(v.getId())));
    record(id, "borderRadiusVertical", p);
    MemorySegment st = BorderRadiusObjSt.allocate(arena);
    BorderRadiusObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment borderRadiusHorizontal(Optional<Radius> left, Optional<Radius> right) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    left.ifPresent(v -> p.put("left", byId.get(v.getId())));
    right.ifPresent(v -> p.put("right", byId.get(v.getId())));
    record(id, "borderRadiusHorizontal", p);
    MemorySegment st = BorderRadiusObjSt.allocate(arena);
    BorderRadiusObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment borderRadiusOnly(Optional<Radius> topLeft, Optional<Radius> topRight, Optional<Radius> bottomLeft, Optional<Radius> bottomRight) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    topLeft.ifPresent(v -> p.put("topLeft", byId.get(v.getId())));
    topRight.ifPresent(v -> p.put("topRight", byId.get(v.getId())));
    bottomLeft.ifPresent(v -> p.put("bottomLeft", byId.get(v.getId())));
    bottomRight.ifPresent(v -> p.put("bottomRight", byId.get(v.getId())));
    record(id, "borderRadiusOnly", p);
    MemorySegment st = BorderRadiusObjSt.allocate(arena);
    BorderRadiusObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment borderRadiusLerp(BorderRadius a, BorderRadius b, double t) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", byId.get(a.getId()));
    p.put("b", byId.get(b.getId()));
    p.put("t", t);
    record(id, "borderRadiusLerp", p);
    MemorySegment st = BorderRadiusObjSt.allocate(arena);
    BorderRadiusObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment boxShadowBoxShadow(Optional<Color> color, Optional<Offset> offset, OptionalDouble blurRadius, OptionalDouble spreadRadius, Optional<BlurStyle> blurStyle) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    color.ifPresent(v -> p.put("color", byId.get(v.getId())));
    offset.ifPresent(v -> p.put("offset", byId.get(v.getId())));
    if (blurRadius.isPresent()) { p.put("blurRadius", blurRadius.getAsDouble()); }
    if (spreadRadius.isPresent()) { p.put("spreadRadius", spreadRadius.getAsDouble()); }
    blurStyle.ifPresent(v -> p.put("blurStyle", v.ordinal()));
    record(id, "boxShadowBoxShadow", p);
    MemorySegment st = BoxShadowObjSt.allocate(arena);
    BoxShadowObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment boxShadowLerp(BoxShadow a, BoxShadow b, double t) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", byId.get(a.getId()));
    p.put("b", byId.get(b.getId()));
    p.put("t", t);
    record(id, "boxShadowLerp", p);
    MemorySegment st = BoxShadowObjSt.allocate(arena);
    BoxShadowObjSt.id(st, id);
    return st;
  }

  @Override
  int shadowShadow(Optional<Color> color, Optional<Offset> offset, OptionalDouble blurRadius) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    color.ifPresent(v -> p.put("color", byId.get(v.getId())));
    offset.ifPresent(v -> p.put("offset", byId.get(v.getId())));
    if (blurRadius.isPresent()) { p.put("blurRadius", blurRadius.getAsDouble()); }
    record(id, "shadowShadow", p);
    return id;
  }
  @Override
  double shadowConvertRadiusToSigma(double radius) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("radius", radius);
    record(id, "shadowConvertRadiusToSigma", p);
    return id;
  }
  @Override
  int shadowLerp(Shadow a, Shadow b, double t) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", byId.get(a.getId()));
    p.put("b", byId.get(b.getId()));
    p.put("t", t);
    record(id, "shadowLerp", p);
    return id;
  }

  @Override
  MemorySegment paddingPadding(EdgeInsetsGeometry padding, Optional<Widget> child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("padding", byId.get(padding.getId()));
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    record(id, "paddingPadding", p);
    MemorySegment st = PaddingObjSt.allocate(arena);
    PaddingObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment edgeInsetsFromLTRB(double left, double top, double right, double bottom) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("left", left);
    p.put("top", top);
    p.put("right", right);
    p.put("bottom", bottom);
    record(id, "edgeInsetsFromLTRB", p);
    MemorySegment st = EdgeInsetsObjSt.allocate(arena);
    EdgeInsetsObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment edgeInsetsAll(double value) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("value", value);
    record(id, "edgeInsetsAll", p);
    MemorySegment st = EdgeInsetsObjSt.allocate(arena);
    EdgeInsetsObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment edgeInsetsOnly(OptionalDouble left, OptionalDouble top, OptionalDouble right, OptionalDouble bottom) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (left.isPresent()) { p.put("left", left.getAsDouble()); }
    if (top.isPresent()) { p.put("top", top.getAsDouble()); }
    if (right.isPresent()) { p.put("right", right.getAsDouble()); }
    if (bottom.isPresent()) { p.put("bottom", bottom.getAsDouble()); }
    record(id, "edgeInsetsOnly", p);
    MemorySegment st = EdgeInsetsObjSt.allocate(arena);
    EdgeInsetsObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment edgeInsetsSymmetric(OptionalDouble vertical, OptionalDouble horizontal) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (vertical.isPresent()) { p.put("vertical", vertical.getAsDouble()); }
    if (horizontal.isPresent()) { p.put("horizontal", horizontal.getAsDouble()); }
    record(id, "edgeInsetsSymmetric", p);
    MemorySegment st = EdgeInsetsObjSt.allocate(arena);
    EdgeInsetsObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment edgeInsetsLerp(EdgeInsets a, EdgeInsets b, double t) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", byId.get(a.getId()));
    p.put("b", byId.get(b.getId()));
    p.put("t", t);
    record(id, "edgeInsetsLerp", p);
    MemorySegment st = EdgeInsetsObjSt.allocate(arena);
    EdgeInsetsObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment borderSideBorderSide(Optional<Color> color, OptionalDouble width, Optional<BorderStyle> style, OptionalDouble strokeAlign) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    color.ifPresent(v -> p.put("color", byId.get(v.getId())));
    if (width.isPresent()) { p.put("width", width.getAsDouble()); }
    style.ifPresent(v -> p.put("style", v.ordinal()));
    if (strokeAlign.isPresent()) { p.put("strokeAlign", strokeAlign.getAsDouble()); }
    record(id, "borderSideBorderSide", p);
    MemorySegment st = BorderSideObjSt.allocate(arena);
    BorderSideObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment borderSideMerge(BorderSide a, BorderSide b) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", byId.get(a.getId()));
    p.put("b", byId.get(b.getId()));
    record(id, "borderSideMerge", p);
    MemorySegment st = BorderSideObjSt.allocate(arena);
    BorderSideObjSt.id(st, id);
    return st;
  }
  @Override
  int borderSideCanMerge(BorderSide a, BorderSide b) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", byId.get(a.getId()));
    p.put("b", byId.get(b.getId()));
    record(id, "borderSideCanMerge", p);
    return id;
  }
  @Override
  MemorySegment borderSideLerp(BorderSide a, BorderSide b, double t) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", byId.get(a.getId()));
    p.put("b", byId.get(b.getId()));
    p.put("t", t);
    record(id, "borderSideLerp", p);
    MemorySegment st = BorderSideObjSt.allocate(arena);
    BorderSideObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment borderBorder(Optional<BorderSide> top, Optional<BorderSide> right, Optional<BorderSide> bottom, Optional<BorderSide> left) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    top.ifPresent(v -> p.put("top", byId.get(v.getId())));
    right.ifPresent(v -> p.put("right", byId.get(v.getId())));
    bottom.ifPresent(v -> p.put("bottom", byId.get(v.getId())));
    left.ifPresent(v -> p.put("left", byId.get(v.getId())));
    record(id, "borderBorder", p);
    MemorySegment st = BorderObjSt.allocate(arena);
    BorderObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment borderFromBorderSide(BorderSide side) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("side", byId.get(side.getId()));
    record(id, "borderFromBorderSide", p);
    MemorySegment st = BorderObjSt.allocate(arena);
    BorderObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment borderSymmetric(Optional<BorderSide> vertical, Optional<BorderSide> horizontal) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    vertical.ifPresent(v -> p.put("vertical", byId.get(v.getId())));
    horizontal.ifPresent(v -> p.put("horizontal", byId.get(v.getId())));
    record(id, "borderSymmetric", p);
    MemorySegment st = BorderObjSt.allocate(arena);
    BorderObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment borderAll(Optional<Color> color, OptionalDouble width, Optional<BorderStyle> style, OptionalDouble strokeAlign) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    color.ifPresent(v -> p.put("color", byId.get(v.getId())));
    if (width.isPresent()) { p.put("width", width.getAsDouble()); }
    style.ifPresent(v -> p.put("style", v.ordinal()));
    if (strokeAlign.isPresent()) { p.put("strokeAlign", strokeAlign.getAsDouble()); }
    record(id, "borderAll", p);
    MemorySegment st = BorderObjSt.allocate(arena);
    BorderObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment borderMerge(Border a, Border b) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", byId.get(a.getId()));
    p.put("b", byId.get(b.getId()));
    record(id, "borderMerge", p);
    MemorySegment st = BorderObjSt.allocate(arena);
    BorderObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment borderLerp(Border a, Border b, double t) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", byId.get(a.getId()));
    p.put("b", byId.get(b.getId()));
    p.put("t", t);
    record(id, "borderLerp", p);
    MemorySegment st = BorderObjSt.allocate(arena);
    BorderObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment roundedRectangleBorderRoundedRectangleBorder(Optional<BorderSide> side, Optional<BorderRadiusGeometry> borderRadius) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    side.ifPresent(v -> p.put("side", byId.get(v.getId())));
    borderRadius.ifPresent(v -> p.put("borderRadius", byId.get(v.getId())));
    record(id, "roundedRectangleBorderRoundedRectangleBorder", p);
    MemorySegment st = RoundedRectangleBorderObjSt.allocate(arena);
    RoundedRectangleBorderObjSt.id(st, id);
    return st;
  }

  @Override
  int animationControllerAnimationController(OptionalDouble value, Optional<Duration> duration, Optional<Duration> reverseDuration, Optional<String> debugLabel, OptionalDouble lowerBound, OptionalDouble upperBound, Optional<AnimationBehavior> animationBehavior, TickerProvider vsync) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (value.isPresent()) { p.put("value", value.getAsDouble()); }
    duration.ifPresent(v -> p.put("duration", byId.get(v.getId())));
    reverseDuration.ifPresent(v -> p.put("reverseDuration", byId.get(v.getId())));
    debugLabel.ifPresent(v -> p.put("debugLabel", v));
    if (lowerBound.isPresent()) { p.put("lowerBound", lowerBound.getAsDouble()); }
    if (upperBound.isPresent()) { p.put("upperBound", upperBound.getAsDouble()); }
    animationBehavior.ifPresent(v -> p.put("animationBehavior", v.ordinal()));
    p.put("vsync", byId.get(vsync.getId()));
    record(id, "animationControllerAnimationController", p);
    return id;
  }
  @Override
  int animationControllerUnbounded(OptionalDouble value, Optional<Duration> duration, Optional<Duration> reverseDuration, Optional<String> debugLabel, TickerProvider vsync, Optional<AnimationBehavior> animationBehavior) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (value.isPresent()) { p.put("value", value.getAsDouble()); }
    duration.ifPresent(v -> p.put("duration", byId.get(v.getId())));
    reverseDuration.ifPresent(v -> p.put("reverseDuration", byId.get(v.getId())));
    debugLabel.ifPresent(v -> p.put("debugLabel", v));
    p.put("vsync", byId.get(vsync.getId()));
    animationBehavior.ifPresent(v -> p.put("animationBehavior", v.ordinal()));
    record(id, "animationControllerUnbounded", p);
    return id;
  }

  @Override
  int durationDuration(OptionalInt days, OptionalInt hours, OptionalInt minutes, OptionalInt seconds, OptionalInt milliseconds, OptionalInt microseconds) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (days.isPresent()) { p.put("days", days.getAsInt()); }
    if (hours.isPresent()) { p.put("hours", hours.getAsInt()); }
    if (minutes.isPresent()) { p.put("minutes", minutes.getAsInt()); }
    if (seconds.isPresent()) { p.put("seconds", seconds.getAsInt()); }
    if (milliseconds.isPresent()) { p.put("milliseconds", milliseconds.getAsInt()); }
    if (microseconds.isPresent()) { p.put("microseconds", microseconds.getAsInt()); }
    record(id, "durationDuration", p);
    return id;
  }

  @Override
  MemorySegment animatedBuilderAnimatedBuilder(Listenable animation, BiFunction<BuildContext, Widget, Widget> builder, Optional<Widget> child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("animation", byId.get(animation.getId()));
    p.put("builder", nextCallbackId++);
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    record(id, "animatedBuilderAnimatedBuilder", p);
    MemorySegment st = AnimatedBuilderObjSt.allocate(arena);
    AnimatedBuilderObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment listenableBuilderListenableBuilder(Listenable listenable, BiFunction<BuildContext, Widget, Widget> builder, Optional<Widget> child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("listenable", byId.get(listenable.getId()));
    p.put("builder", nextCallbackId++);
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    record(id, "listenableBuilderListenableBuilder", p);
    MemorySegment st = ListenableBuilderObjSt.allocate(arena);
    ListenableBuilderObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment cubicCubic(double a, double b, double c, double d) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", a);
    p.put("b", b);
    p.put("c", c);
    p.put("d", d);
    record(id, "cubicCubic", p);
    MemorySegment st = CubicObjSt.allocate(arena);
    CubicObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment threePointCubicThreePointCubic(Offset a1, Offset b1, Offset midpoint, Offset a2, Offset b2) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a1", byId.get(a1.getId()));
    p.put("b1", byId.get(b1.getId()));
    p.put("midpoint", byId.get(midpoint.getId()));
    p.put("a2", byId.get(a2.getId()));
    p.put("b2", byId.get(b2.getId()));
    record(id, "threePointCubicThreePointCubic", p);
    MemorySegment st = ThreePointCubicObjSt.allocate(arena);
    ThreePointCubicObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment elasticOutCurveElasticOutCurve(OptionalDouble period) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (period.isPresent()) { p.put("period", period.getAsDouble()); }
    record(id, "elasticOutCurveElasticOutCurve", p);
    MemorySegment st = ElasticOutCurveObjSt.allocate(arena);
    ElasticOutCurveObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment elasticInCurveElasticInCurve(OptionalDouble period) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (period.isPresent()) { p.put("period", period.getAsDouble()); }
    record(id, "elasticInCurveElasticInCurve", p);
    MemorySegment st = ElasticInCurveObjSt.allocate(arena);
    ElasticInCurveObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment elasticInOutCurveElasticInOutCurve(OptionalDouble period) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (period.isPresent()) { p.put("period", period.getAsDouble()); }
    record(id, "elasticInOutCurveElasticInOutCurve", p);
    MemorySegment st = ElasticInOutCurveObjSt.allocate(arena);
    ElasticInOutCurveObjSt.id(st, id);
    return st;
  }

  @Override
  int curvesLinear() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "curvesLinear", p);
    return id;
  }
  @Override
  int curvesDecelerate() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "curvesDecelerate", p);
    return id;
  }
  @Override
  int curvesBounceIn() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "curvesBounceIn", p);
    return id;
  }
  @Override
  int curvesBounceOut() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "curvesBounceOut", p);
    return id;
  }
  @Override
  int curvesBounceInOut() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "curvesBounceInOut", p);
    return id;
  }

  @Override
  int curvedAnimationCurvedAnimation(Animation parent, Curve curve, Optional<Curve> reverseCurve) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("parent", byId.get(parent.getId()));
    p.put("curve", byId.get(curve.getId()));
    reverseCurve.ifPresent(v -> p.put("reverseCurve", byId.get(v.getId())));
    record(id, "curvedAnimationCurvedAnimation", p);
    return id;
  }

  @Override
  MemorySegment sizedBoxSizedBox(OptionalDouble width, OptionalDouble height, Optional<Widget> child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (width.isPresent()) { p.put("width", width.getAsDouble()); }
    if (height.isPresent()) { p.put("height", height.getAsDouble()); }
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    record(id, "sizedBoxSizedBox", p);
    MemorySegment st = SizedBoxObjSt.allocate(arena);
    SizedBoxObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment sizedBoxExpand(Optional<Widget> child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    record(id, "sizedBoxExpand", p);
    MemorySegment st = SizedBoxObjSt.allocate(arena);
    SizedBoxObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment sizedBoxShrink(Optional<Widget> child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    record(id, "sizedBoxShrink", p);
    MemorySegment st = SizedBoxObjSt.allocate(arena);
    SizedBoxObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment sizedBoxFromSize(Optional<Widget> child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    record(id, "sizedBoxFromSize", p);
    MemorySegment st = SizedBoxObjSt.allocate(arena);
    SizedBoxObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment sizedBoxSquare(Optional<Widget> child, OptionalDouble dimension) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    if (dimension.isPresent()) { p.put("dimension", dimension.getAsDouble()); }
    record(id, "sizedBoxSquare", p);
    MemorySegment st = SizedBoxObjSt.allocate(arena);
    SizedBoxObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment alignmentAlignment(double x, double y) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("x", x);
    p.put("y", y);
    record(id, "alignmentAlignment", p);
    MemorySegment st = AlignmentObjSt.allocate(arena);
    AlignmentObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment alignmentLerp(Alignment a, Alignment b, double t) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", byId.get(a.getId()));
    p.put("b", byId.get(b.getId()));
    p.put("t", t);
    record(id, "alignmentLerp", p);
    MemorySegment st = AlignmentObjSt.allocate(arena);
    AlignmentObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment alignmentDirectionalAlignmentDirectional(double start, double y) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("start", start);
    p.put("y", y);
    record(id, "alignmentDirectionalAlignmentDirectional", p);
    MemorySegment st = AlignmentDirectionalObjSt.allocate(arena);
    AlignmentDirectionalObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment alignmentDirectionalLerp(AlignmentDirectional a, AlignmentDirectional b, double t) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", byId.get(a.getId()));
    p.put("b", byId.get(b.getId()));
    p.put("t", t);
    record(id, "alignmentDirectionalLerp", p);
    MemorySegment st = AlignmentDirectionalObjSt.allocate(arena);
    AlignmentDirectionalObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment mouseRegionMouseRegion(Optional<Boolean> opaque, Optional<HitTestBehavior> hitTestBehavior, Optional<Widget> child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    opaque.ifPresent(v -> p.put("opaque", v));
    hitTestBehavior.ifPresent(v -> p.put("hitTestBehavior", v.ordinal()));
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    record(id, "mouseRegionMouseRegion", p);
    MemorySegment st = MouseRegionObjSt.allocate(arena);
    MouseRegionObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment expandedExpanded(OptionalInt flex, Widget child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (flex.isPresent()) { p.put("flex", flex.getAsInt()); }
    p.put("child", byId.get(child.getId()));
    record(id, "expandedExpanded", p);
    MemorySegment st = ExpandedObjSt.allocate(arena);
    ExpandedObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment flexibleFlexible(OptionalInt flex, Optional<FlexFit> fit, Widget child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (flex.isPresent()) { p.put("flex", flex.getAsInt()); }
    fit.ifPresent(v -> p.put("fit", v.ordinal()));
    p.put("child", byId.get(child.getId()));
    record(id, "flexibleFlexible", p);
    MemorySegment st = FlexibleObjSt.allocate(arena);
    FlexibleObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment safeAreaSafeArea(Optional<Boolean> left, Optional<Boolean> top, Optional<Boolean> right, Optional<Boolean> bottom, Optional<EdgeInsets> minimum, Optional<Boolean> maintainBottomViewPadding, Widget child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    left.ifPresent(v -> p.put("left", v));
    top.ifPresent(v -> p.put("top", v));
    right.ifPresent(v -> p.put("right", v));
    bottom.ifPresent(v -> p.put("bottom", v));
    minimum.ifPresent(v -> p.put("minimum", byId.get(v.getId())));
    maintainBottomViewPadding.ifPresent(v -> p.put("maintainBottomViewPadding", v));
    p.put("child", byId.get(child.getId()));
    record(id, "safeAreaSafeArea", p);
    MemorySegment st = SafeAreaObjSt.allocate(arena);
    SafeAreaObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment rotationTransitionRotationTransition(Animation turns, Optional<Alignment> alignment, Optional<FilterQuality> filterQuality, Optional<Widget> child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("turns", byId.get(turns.getId()));
    alignment.ifPresent(v -> p.put("alignment", byId.get(v.getId())));
    filterQuality.ifPresent(v -> p.put("filterQuality", v.ordinal()));
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    record(id, "rotationTransitionRotationTransition", p);
    MemorySegment st = RotationTransitionObjSt.allocate(arena);
    RotationTransitionObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment fadeTransitionFadeTransition(Animation opacity, Optional<Boolean> alwaysIncludeSemantics, Optional<Widget> child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("opacity", byId.get(opacity.getId()));
    alwaysIncludeSemantics.ifPresent(v -> p.put("alwaysIncludeSemantics", v));
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    record(id, "fadeTransitionFadeTransition", p);
    MemorySegment st = FadeTransitionObjSt.allocate(arena);
    FadeTransitionObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment scaleTransitionScaleTransition(Animation scale, Optional<Alignment> alignment, Optional<FilterQuality> filterQuality, Optional<Widget> child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("scale", byId.get(scale.getId()));
    alignment.ifPresent(v -> p.put("alignment", byId.get(v.getId())));
    filterQuality.ifPresent(v -> p.put("filterQuality", v.ordinal()));
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    record(id, "scaleTransitionScaleTransition", p);
    MemorySegment st = ScaleTransitionObjSt.allocate(arena);
    ScaleTransitionObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment colorSchemeColorScheme(Brightness brightness, Color primary, Color onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Color secondary, Color onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Color error, Color onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Color surface, Color onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("brightness", brightness.ordinal());
    p.put("primary", byId.get(primary.getId()));
    p.put("onPrimary", byId.get(onPrimary.getId()));
    primaryContainer.ifPresent(v -> p.put("primaryContainer", byId.get(v.getId())));
    onPrimaryContainer.ifPresent(v -> p.put("onPrimaryContainer", byId.get(v.getId())));
    primaryFixed.ifPresent(v -> p.put("primaryFixed", byId.get(v.getId())));
    primaryFixedDim.ifPresent(v -> p.put("primaryFixedDim", byId.get(v.getId())));
    onPrimaryFixed.ifPresent(v -> p.put("onPrimaryFixed", byId.get(v.getId())));
    onPrimaryFixedVariant.ifPresent(v -> p.put("onPrimaryFixedVariant", byId.get(v.getId())));
    p.put("secondary", byId.get(secondary.getId()));
    p.put("onSecondary", byId.get(onSecondary.getId()));
    secondaryContainer.ifPresent(v -> p.put("secondaryContainer", byId.get(v.getId())));
    onSecondaryContainer.ifPresent(v -> p.put("onSecondaryContainer", byId.get(v.getId())));
    secondaryFixed.ifPresent(v -> p.put("secondaryFixed", byId.get(v.getId())));
    secondaryFixedDim.ifPresent(v -> p.put("secondaryFixedDim", byId.get(v.getId())));
    onSecondaryFixed.ifPresent(v -> p.put("onSecondaryFixed", byId.get(v.getId())));
    onSecondaryFixedVariant.ifPresent(v -> p.put("onSecondaryFixedVariant", byId.get(v.getId())));
    tertiary.ifPresent(v -> p.put("tertiary", byId.get(v.getId())));
    onTertiary.ifPresent(v -> p.put("onTertiary", byId.get(v.getId())));
    tertiaryContainer.ifPresent(v -> p.put("tertiaryContainer", byId.get(v.getId())));
    onTertiaryContainer.ifPresent(v -> p.put("onTertiaryContainer", byId.get(v.getId())));
    tertiaryFixed.ifPresent(v -> p.put("tertiaryFixed", byId.get(v.getId())));
    tertiaryFixedDim.ifPresent(v -> p.put("tertiaryFixedDim", byId.get(v.getId())));
    onTertiaryFixed.ifPresent(v -> p.put("onTertiaryFixed", byId.get(v.getId())));
    onTertiaryFixedVariant.ifPresent(v -> p.put("onTertiaryFixedVariant", byId.get(v.getId())));
    p.put("error", byId.get(error.getId()));
    p.put("onError", byId.get(onError.getId()));
    errorContainer.ifPresent(v -> p.put("errorContainer", byId.get(v.getId())));
    onErrorContainer.ifPresent(v -> p.put("onErrorContainer", byId.get(v.getId())));
    p.put("surface", byId.get(surface.getId()));
    p.put("onSurface", byId.get(onSurface.getId()));
    surfaceDim.ifPresent(v -> p.put("surfaceDim", byId.get(v.getId())));
    surfaceBright.ifPresent(v -> p.put("surfaceBright", byId.get(v.getId())));
    surfaceContainerLowest.ifPresent(v -> p.put("surfaceContainerLowest", byId.get(v.getId())));
    surfaceContainerLow.ifPresent(v -> p.put("surfaceContainerLow", byId.get(v.getId())));
    surfaceContainer.ifPresent(v -> p.put("surfaceContainer", byId.get(v.getId())));
    surfaceContainerHigh.ifPresent(v -> p.put("surfaceContainerHigh", byId.get(v.getId())));
    surfaceContainerHighest.ifPresent(v -> p.put("surfaceContainerHighest", byId.get(v.getId())));
    onSurfaceVariant.ifPresent(v -> p.put("onSurfaceVariant", byId.get(v.getId())));
    outline.ifPresent(v -> p.put("outline", byId.get(v.getId())));
    outlineVariant.ifPresent(v -> p.put("outlineVariant", byId.get(v.getId())));
    shadow.ifPresent(v -> p.put("shadow", byId.get(v.getId())));
    scrim.ifPresent(v -> p.put("scrim", byId.get(v.getId())));
    inverseSurface.ifPresent(v -> p.put("inverseSurface", byId.get(v.getId())));
    onInverseSurface.ifPresent(v -> p.put("onInverseSurface", byId.get(v.getId())));
    inversePrimary.ifPresent(v -> p.put("inversePrimary", byId.get(v.getId())));
    surfaceTint.ifPresent(v -> p.put("surfaceTint", byId.get(v.getId())));
    background.ifPresent(v -> p.put("background", byId.get(v.getId())));
    onBackground.ifPresent(v -> p.put("onBackground", byId.get(v.getId())));
    surfaceVariant.ifPresent(v -> p.put("surfaceVariant", byId.get(v.getId())));
    record(id, "colorSchemeColorScheme", p);
    MemorySegment st = ColorSchemeObjSt.allocate(arena);
    ColorSchemeObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment colorSchemeFromSeed(Color seedColor, Optional<Brightness> brightness, Optional<DynamicSchemeVariant> dynamicSchemeVariant, OptionalDouble contrastLevel, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("seedColor", byId.get(seedColor.getId()));
    brightness.ifPresent(v -> p.put("brightness", v.ordinal()));
    dynamicSchemeVariant.ifPresent(v -> p.put("dynamicSchemeVariant", v.ordinal()));
    if (contrastLevel.isPresent()) { p.put("contrastLevel", contrastLevel.getAsDouble()); }
    primary.ifPresent(v -> p.put("primary", byId.get(v.getId())));
    onPrimary.ifPresent(v -> p.put("onPrimary", byId.get(v.getId())));
    primaryContainer.ifPresent(v -> p.put("primaryContainer", byId.get(v.getId())));
    onPrimaryContainer.ifPresent(v -> p.put("onPrimaryContainer", byId.get(v.getId())));
    primaryFixed.ifPresent(v -> p.put("primaryFixed", byId.get(v.getId())));
    primaryFixedDim.ifPresent(v -> p.put("primaryFixedDim", byId.get(v.getId())));
    onPrimaryFixed.ifPresent(v -> p.put("onPrimaryFixed", byId.get(v.getId())));
    onPrimaryFixedVariant.ifPresent(v -> p.put("onPrimaryFixedVariant", byId.get(v.getId())));
    secondary.ifPresent(v -> p.put("secondary", byId.get(v.getId())));
    onSecondary.ifPresent(v -> p.put("onSecondary", byId.get(v.getId())));
    secondaryContainer.ifPresent(v -> p.put("secondaryContainer", byId.get(v.getId())));
    onSecondaryContainer.ifPresent(v -> p.put("onSecondaryContainer", byId.get(v.getId())));
    secondaryFixed.ifPresent(v -> p.put("secondaryFixed", byId.get(v.getId())));
    secondaryFixedDim.ifPresent(v -> p.put("secondaryFixedDim", byId.get(v.getId())));
    onSecondaryFixed.ifPresent(v -> p.put("onSecondaryFixed", byId.get(v.getId())));
    onSecondaryFixedVariant.ifPresent(v -> p.put("onSecondaryFixedVariant", byId.get(v.getId())));
    tertiary.ifPresent(v -> p.put("tertiary", byId.get(v.getId())));
    onTertiary.ifPresent(v -> p.put("onTertiary", byId.get(v.getId())));
    tertiaryContainer.ifPresent(v -> p.put("tertiaryContainer", byId.get(v.getId())));
    onTertiaryContainer.ifPresent(v -> p.put("onTertiaryContainer", byId.get(v.getId())));
    tertiaryFixed.ifPresent(v -> p.put("tertiaryFixed", byId.get(v.getId())));
    tertiaryFixedDim.ifPresent(v -> p.put("tertiaryFixedDim", byId.get(v.getId())));
    onTertiaryFixed.ifPresent(v -> p.put("onTertiaryFixed", byId.get(v.getId())));
    onTertiaryFixedVariant.ifPresent(v -> p.put("onTertiaryFixedVariant", byId.get(v.getId())));
    error.ifPresent(v -> p.put("error", byId.get(v.getId())));
    onError.ifPresent(v -> p.put("onError", byId.get(v.getId())));
    errorContainer.ifPresent(v -> p.put("errorContainer", byId.get(v.getId())));
    onErrorContainer.ifPresent(v -> p.put("onErrorContainer", byId.get(v.getId())));
    outline.ifPresent(v -> p.put("outline", byId.get(v.getId())));
    outlineVariant.ifPresent(v -> p.put("outlineVariant", byId.get(v.getId())));
    surface.ifPresent(v -> p.put("surface", byId.get(v.getId())));
    onSurface.ifPresent(v -> p.put("onSurface", byId.get(v.getId())));
    surfaceDim.ifPresent(v -> p.put("surfaceDim", byId.get(v.getId())));
    surfaceBright.ifPresent(v -> p.put("surfaceBright", byId.get(v.getId())));
    surfaceContainerLowest.ifPresent(v -> p.put("surfaceContainerLowest", byId.get(v.getId())));
    surfaceContainerLow.ifPresent(v -> p.put("surfaceContainerLow", byId.get(v.getId())));
    surfaceContainer.ifPresent(v -> p.put("surfaceContainer", byId.get(v.getId())));
    surfaceContainerHigh.ifPresent(v -> p.put("surfaceContainerHigh", byId.get(v.getId())));
    surfaceContainerHighest.ifPresent(v -> p.put("surfaceContainerHighest", byId.get(v.getId())));
    onSurfaceVariant.ifPresent(v -> p.put("onSurfaceVariant", byId.get(v.getId())));
    inverseSurface.ifPresent(v -> p.put("inverseSurface", byId.get(v.getId())));
    onInverseSurface.ifPresent(v -> p.put("onInverseSurface", byId.get(v.getId())));
    inversePrimary.ifPresent(v -> p.put("inversePrimary", byId.get(v.getId())));
    shadow.ifPresent(v -> p.put("shadow", byId.get(v.getId())));
    scrim.ifPresent(v -> p.put("scrim", byId.get(v.getId())));
    surfaceTint.ifPresent(v -> p.put("surfaceTint", byId.get(v.getId())));
    background.ifPresent(v -> p.put("background", byId.get(v.getId())));
    onBackground.ifPresent(v -> p.put("onBackground", byId.get(v.getId())));
    surfaceVariant.ifPresent(v -> p.put("surfaceVariant", byId.get(v.getId())));
    record(id, "colorSchemeFromSeed", p);
    MemorySegment st = ColorSchemeObjSt.allocate(arena);
    ColorSchemeObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment colorSchemeLight(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    brightness.ifPresent(v -> p.put("brightness", v.ordinal()));
    primary.ifPresent(v -> p.put("primary", byId.get(v.getId())));
    onPrimary.ifPresent(v -> p.put("onPrimary", byId.get(v.getId())));
    primaryContainer.ifPresent(v -> p.put("primaryContainer", byId.get(v.getId())));
    onPrimaryContainer.ifPresent(v -> p.put("onPrimaryContainer", byId.get(v.getId())));
    primaryFixed.ifPresent(v -> p.put("primaryFixed", byId.get(v.getId())));
    primaryFixedDim.ifPresent(v -> p.put("primaryFixedDim", byId.get(v.getId())));
    onPrimaryFixed.ifPresent(v -> p.put("onPrimaryFixed", byId.get(v.getId())));
    onPrimaryFixedVariant.ifPresent(v -> p.put("onPrimaryFixedVariant", byId.get(v.getId())));
    secondary.ifPresent(v -> p.put("secondary", byId.get(v.getId())));
    onSecondary.ifPresent(v -> p.put("onSecondary", byId.get(v.getId())));
    secondaryContainer.ifPresent(v -> p.put("secondaryContainer", byId.get(v.getId())));
    onSecondaryContainer.ifPresent(v -> p.put("onSecondaryContainer", byId.get(v.getId())));
    secondaryFixed.ifPresent(v -> p.put("secondaryFixed", byId.get(v.getId())));
    secondaryFixedDim.ifPresent(v -> p.put("secondaryFixedDim", byId.get(v.getId())));
    onSecondaryFixed.ifPresent(v -> p.put("onSecondaryFixed", byId.get(v.getId())));
    onSecondaryFixedVariant.ifPresent(v -> p.put("onSecondaryFixedVariant", byId.get(v.getId())));
    tertiary.ifPresent(v -> p.put("tertiary", byId.get(v.getId())));
    onTertiary.ifPresent(v -> p.put("onTertiary", byId.get(v.getId())));
    tertiaryContainer.ifPresent(v -> p.put("tertiaryContainer", byId.get(v.getId())));
    onTertiaryContainer.ifPresent(v -> p.put("onTertiaryContainer", byId.get(v.getId())));
    tertiaryFixed.ifPresent(v -> p.put("tertiaryFixed", byId.get(v.getId())));
    tertiaryFixedDim.ifPresent(v -> p.put("tertiaryFixedDim", byId.get(v.getId())));
    onTertiaryFixed.ifPresent(v -> p.put("onTertiaryFixed", byId.get(v.getId())));
    onTertiaryFixedVariant.ifPresent(v -> p.put("onTertiaryFixedVariant", byId.get(v.getId())));
    error.ifPresent(v -> p.put("error", byId.get(v.getId())));
    onError.ifPresent(v -> p.put("onError", byId.get(v.getId())));
    errorContainer.ifPresent(v -> p.put("errorContainer", byId.get(v.getId())));
    onErrorContainer.ifPresent(v -> p.put("onErrorContainer", byId.get(v.getId())));
    surface.ifPresent(v -> p.put("surface", byId.get(v.getId())));
    onSurface.ifPresent(v -> p.put("onSurface", byId.get(v.getId())));
    surfaceDim.ifPresent(v -> p.put("surfaceDim", byId.get(v.getId())));
    surfaceBright.ifPresent(v -> p.put("surfaceBright", byId.get(v.getId())));
    surfaceContainerLowest.ifPresent(v -> p.put("surfaceContainerLowest", byId.get(v.getId())));
    surfaceContainerLow.ifPresent(v -> p.put("surfaceContainerLow", byId.get(v.getId())));
    surfaceContainer.ifPresent(v -> p.put("surfaceContainer", byId.get(v.getId())));
    surfaceContainerHigh.ifPresent(v -> p.put("surfaceContainerHigh", byId.get(v.getId())));
    surfaceContainerHighest.ifPresent(v -> p.put("surfaceContainerHighest", byId.get(v.getId())));
    onSurfaceVariant.ifPresent(v -> p.put("onSurfaceVariant", byId.get(v.getId())));
    outline.ifPresent(v -> p.put("outline", byId.get(v.getId())));
    outlineVariant.ifPresent(v -> p.put("outlineVariant", byId.get(v.getId())));
    shadow.ifPresent(v -> p.put("shadow", byId.get(v.getId())));
    scrim.ifPresent(v -> p.put("scrim", byId.get(v.getId())));
    inverseSurface.ifPresent(v -> p.put("inverseSurface", byId.get(v.getId())));
    onInverseSurface.ifPresent(v -> p.put("onInverseSurface", byId.get(v.getId())));
    inversePrimary.ifPresent(v -> p.put("inversePrimary", byId.get(v.getId())));
    surfaceTint.ifPresent(v -> p.put("surfaceTint", byId.get(v.getId())));
    background.ifPresent(v -> p.put("background", byId.get(v.getId())));
    onBackground.ifPresent(v -> p.put("onBackground", byId.get(v.getId())));
    surfaceVariant.ifPresent(v -> p.put("surfaceVariant", byId.get(v.getId())));
    record(id, "colorSchemeLight", p);
    MemorySegment st = ColorSchemeObjSt.allocate(arena);
    ColorSchemeObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment colorSchemeDark(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    brightness.ifPresent(v -> p.put("brightness", v.ordinal()));
    primary.ifPresent(v -> p.put("primary", byId.get(v.getId())));
    onPrimary.ifPresent(v -> p.put("onPrimary", byId.get(v.getId())));
    primaryContainer.ifPresent(v -> p.put("primaryContainer", byId.get(v.getId())));
    onPrimaryContainer.ifPresent(v -> p.put("onPrimaryContainer", byId.get(v.getId())));
    primaryFixed.ifPresent(v -> p.put("primaryFixed", byId.get(v.getId())));
    primaryFixedDim.ifPresent(v -> p.put("primaryFixedDim", byId.get(v.getId())));
    onPrimaryFixed.ifPresent(v -> p.put("onPrimaryFixed", byId.get(v.getId())));
    onPrimaryFixedVariant.ifPresent(v -> p.put("onPrimaryFixedVariant", byId.get(v.getId())));
    secondary.ifPresent(v -> p.put("secondary", byId.get(v.getId())));
    onSecondary.ifPresent(v -> p.put("onSecondary", byId.get(v.getId())));
    secondaryContainer.ifPresent(v -> p.put("secondaryContainer", byId.get(v.getId())));
    onSecondaryContainer.ifPresent(v -> p.put("onSecondaryContainer", byId.get(v.getId())));
    secondaryFixed.ifPresent(v -> p.put("secondaryFixed", byId.get(v.getId())));
    secondaryFixedDim.ifPresent(v -> p.put("secondaryFixedDim", byId.get(v.getId())));
    onSecondaryFixed.ifPresent(v -> p.put("onSecondaryFixed", byId.get(v.getId())));
    onSecondaryFixedVariant.ifPresent(v -> p.put("onSecondaryFixedVariant", byId.get(v.getId())));
    tertiary.ifPresent(v -> p.put("tertiary", byId.get(v.getId())));
    onTertiary.ifPresent(v -> p.put("onTertiary", byId.get(v.getId())));
    tertiaryContainer.ifPresent(v -> p.put("tertiaryContainer", byId.get(v.getId())));
    onTertiaryContainer.ifPresent(v -> p.put("onTertiaryContainer", byId.get(v.getId())));
    tertiaryFixed.ifPresent(v -> p.put("tertiaryFixed", byId.get(v.getId())));
    tertiaryFixedDim.ifPresent(v -> p.put("tertiaryFixedDim", byId.get(v.getId())));
    onTertiaryFixed.ifPresent(v -> p.put("onTertiaryFixed", byId.get(v.getId())));
    onTertiaryFixedVariant.ifPresent(v -> p.put("onTertiaryFixedVariant", byId.get(v.getId())));
    error.ifPresent(v -> p.put("error", byId.get(v.getId())));
    onError.ifPresent(v -> p.put("onError", byId.get(v.getId())));
    errorContainer.ifPresent(v -> p.put("errorContainer", byId.get(v.getId())));
    onErrorContainer.ifPresent(v -> p.put("onErrorContainer", byId.get(v.getId())));
    surface.ifPresent(v -> p.put("surface", byId.get(v.getId())));
    onSurface.ifPresent(v -> p.put("onSurface", byId.get(v.getId())));
    surfaceDim.ifPresent(v -> p.put("surfaceDim", byId.get(v.getId())));
    surfaceBright.ifPresent(v -> p.put("surfaceBright", byId.get(v.getId())));
    surfaceContainerLowest.ifPresent(v -> p.put("surfaceContainerLowest", byId.get(v.getId())));
    surfaceContainerLow.ifPresent(v -> p.put("surfaceContainerLow", byId.get(v.getId())));
    surfaceContainer.ifPresent(v -> p.put("surfaceContainer", byId.get(v.getId())));
    surfaceContainerHigh.ifPresent(v -> p.put("surfaceContainerHigh", byId.get(v.getId())));
    surfaceContainerHighest.ifPresent(v -> p.put("surfaceContainerHighest", byId.get(v.getId())));
    onSurfaceVariant.ifPresent(v -> p.put("onSurfaceVariant", byId.get(v.getId())));
    outline.ifPresent(v -> p.put("outline", byId.get(v.getId())));
    outlineVariant.ifPresent(v -> p.put("outlineVariant", byId.get(v.getId())));
    shadow.ifPresent(v -> p.put("shadow", byId.get(v.getId())));
    scrim.ifPresent(v -> p.put("scrim", byId.get(v.getId())));
    inverseSurface.ifPresent(v -> p.put("inverseSurface", byId.get(v.getId())));
    onInverseSurface.ifPresent(v -> p.put("onInverseSurface", byId.get(v.getId())));
    inversePrimary.ifPresent(v -> p.put("inversePrimary", byId.get(v.getId())));
    surfaceTint.ifPresent(v -> p.put("surfaceTint", byId.get(v.getId())));
    background.ifPresent(v -> p.put("background", byId.get(v.getId())));
    onBackground.ifPresent(v -> p.put("onBackground", byId.get(v.getId())));
    surfaceVariant.ifPresent(v -> p.put("surfaceVariant", byId.get(v.getId())));
    record(id, "colorSchemeDark", p);
    MemorySegment st = ColorSchemeObjSt.allocate(arena);
    ColorSchemeObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment colorSchemeHighContrastLight(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    brightness.ifPresent(v -> p.put("brightness", v.ordinal()));
    primary.ifPresent(v -> p.put("primary", byId.get(v.getId())));
    onPrimary.ifPresent(v -> p.put("onPrimary", byId.get(v.getId())));
    primaryContainer.ifPresent(v -> p.put("primaryContainer", byId.get(v.getId())));
    onPrimaryContainer.ifPresent(v -> p.put("onPrimaryContainer", byId.get(v.getId())));
    primaryFixed.ifPresent(v -> p.put("primaryFixed", byId.get(v.getId())));
    primaryFixedDim.ifPresent(v -> p.put("primaryFixedDim", byId.get(v.getId())));
    onPrimaryFixed.ifPresent(v -> p.put("onPrimaryFixed", byId.get(v.getId())));
    onPrimaryFixedVariant.ifPresent(v -> p.put("onPrimaryFixedVariant", byId.get(v.getId())));
    secondary.ifPresent(v -> p.put("secondary", byId.get(v.getId())));
    onSecondary.ifPresent(v -> p.put("onSecondary", byId.get(v.getId())));
    secondaryContainer.ifPresent(v -> p.put("secondaryContainer", byId.get(v.getId())));
    onSecondaryContainer.ifPresent(v -> p.put("onSecondaryContainer", byId.get(v.getId())));
    secondaryFixed.ifPresent(v -> p.put("secondaryFixed", byId.get(v.getId())));
    secondaryFixedDim.ifPresent(v -> p.put("secondaryFixedDim", byId.get(v.getId())));
    onSecondaryFixed.ifPresent(v -> p.put("onSecondaryFixed", byId.get(v.getId())));
    onSecondaryFixedVariant.ifPresent(v -> p.put("onSecondaryFixedVariant", byId.get(v.getId())));
    tertiary.ifPresent(v -> p.put("tertiary", byId.get(v.getId())));
    onTertiary.ifPresent(v -> p.put("onTertiary", byId.get(v.getId())));
    tertiaryContainer.ifPresent(v -> p.put("tertiaryContainer", byId.get(v.getId())));
    onTertiaryContainer.ifPresent(v -> p.put("onTertiaryContainer", byId.get(v.getId())));
    tertiaryFixed.ifPresent(v -> p.put("tertiaryFixed", byId.get(v.getId())));
    tertiaryFixedDim.ifPresent(v -> p.put("tertiaryFixedDim", byId.get(v.getId())));
    onTertiaryFixed.ifPresent(v -> p.put("onTertiaryFixed", byId.get(v.getId())));
    onTertiaryFixedVariant.ifPresent(v -> p.put("onTertiaryFixedVariant", byId.get(v.getId())));
    error.ifPresent(v -> p.put("error", byId.get(v.getId())));
    onError.ifPresent(v -> p.put("onError", byId.get(v.getId())));
    errorContainer.ifPresent(v -> p.put("errorContainer", byId.get(v.getId())));
    onErrorContainer.ifPresent(v -> p.put("onErrorContainer", byId.get(v.getId())));
    surface.ifPresent(v -> p.put("surface", byId.get(v.getId())));
    onSurface.ifPresent(v -> p.put("onSurface", byId.get(v.getId())));
    surfaceDim.ifPresent(v -> p.put("surfaceDim", byId.get(v.getId())));
    surfaceBright.ifPresent(v -> p.put("surfaceBright", byId.get(v.getId())));
    surfaceContainerLowest.ifPresent(v -> p.put("surfaceContainerLowest", byId.get(v.getId())));
    surfaceContainerLow.ifPresent(v -> p.put("surfaceContainerLow", byId.get(v.getId())));
    surfaceContainer.ifPresent(v -> p.put("surfaceContainer", byId.get(v.getId())));
    surfaceContainerHigh.ifPresent(v -> p.put("surfaceContainerHigh", byId.get(v.getId())));
    surfaceContainerHighest.ifPresent(v -> p.put("surfaceContainerHighest", byId.get(v.getId())));
    onSurfaceVariant.ifPresent(v -> p.put("onSurfaceVariant", byId.get(v.getId())));
    outline.ifPresent(v -> p.put("outline", byId.get(v.getId())));
    outlineVariant.ifPresent(v -> p.put("outlineVariant", byId.get(v.getId())));
    shadow.ifPresent(v -> p.put("shadow", byId.get(v.getId())));
    scrim.ifPresent(v -> p.put("scrim", byId.get(v.getId())));
    inverseSurface.ifPresent(v -> p.put("inverseSurface", byId.get(v.getId())));
    onInverseSurface.ifPresent(v -> p.put("onInverseSurface", byId.get(v.getId())));
    inversePrimary.ifPresent(v -> p.put("inversePrimary", byId.get(v.getId())));
    surfaceTint.ifPresent(v -> p.put("surfaceTint", byId.get(v.getId())));
    background.ifPresent(v -> p.put("background", byId.get(v.getId())));
    onBackground.ifPresent(v -> p.put("onBackground", byId.get(v.getId())));
    surfaceVariant.ifPresent(v -> p.put("surfaceVariant", byId.get(v.getId())));
    record(id, "colorSchemeHighContrastLight", p);
    MemorySegment st = ColorSchemeObjSt.allocate(arena);
    ColorSchemeObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment colorSchemeHighContrastDark(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    brightness.ifPresent(v -> p.put("brightness", v.ordinal()));
    primary.ifPresent(v -> p.put("primary", byId.get(v.getId())));
    onPrimary.ifPresent(v -> p.put("onPrimary", byId.get(v.getId())));
    primaryContainer.ifPresent(v -> p.put("primaryContainer", byId.get(v.getId())));
    onPrimaryContainer.ifPresent(v -> p.put("onPrimaryContainer", byId.get(v.getId())));
    primaryFixed.ifPresent(v -> p.put("primaryFixed", byId.get(v.getId())));
    primaryFixedDim.ifPresent(v -> p.put("primaryFixedDim", byId.get(v.getId())));
    onPrimaryFixed.ifPresent(v -> p.put("onPrimaryFixed", byId.get(v.getId())));
    onPrimaryFixedVariant.ifPresent(v -> p.put("onPrimaryFixedVariant", byId.get(v.getId())));
    secondary.ifPresent(v -> p.put("secondary", byId.get(v.getId())));
    onSecondary.ifPresent(v -> p.put("onSecondary", byId.get(v.getId())));
    secondaryContainer.ifPresent(v -> p.put("secondaryContainer", byId.get(v.getId())));
    onSecondaryContainer.ifPresent(v -> p.put("onSecondaryContainer", byId.get(v.getId())));
    secondaryFixed.ifPresent(v -> p.put("secondaryFixed", byId.get(v.getId())));
    secondaryFixedDim.ifPresent(v -> p.put("secondaryFixedDim", byId.get(v.getId())));
    onSecondaryFixed.ifPresent(v -> p.put("onSecondaryFixed", byId.get(v.getId())));
    onSecondaryFixedVariant.ifPresent(v -> p.put("onSecondaryFixedVariant", byId.get(v.getId())));
    tertiary.ifPresent(v -> p.put("tertiary", byId.get(v.getId())));
    onTertiary.ifPresent(v -> p.put("onTertiary", byId.get(v.getId())));
    tertiaryContainer.ifPresent(v -> p.put("tertiaryContainer", byId.get(v.getId())));
    onTertiaryContainer.ifPresent(v -> p.put("onTertiaryContainer", byId.get(v.getId())));
    tertiaryFixed.ifPresent(v -> p.put("tertiaryFixed", byId.get(v.getId())));
    tertiaryFixedDim.ifPresent(v -> p.put("tertiaryFixedDim", byId.get(v.getId())));
    onTertiaryFixed.ifPresent(v -> p.put("onTertiaryFixed", byId.get(v.getId())));
    onTertiaryFixedVariant.ifPresent(v -> p.put("onTertiaryFixedVariant", byId.get(v.getId())));
    error.ifPresent(v -> p.put("error", byId.get(v.getId())));
    onError.ifPresent(v -> p.put("onError", byId.get(v.getId())));
    errorContainer.ifPresent(v -> p.put("errorContainer", byId.get(v.getId())));
    onErrorContainer.ifPresent(v -> p.put("onErrorContainer", byId.get(v.getId())));
    surface.ifPresent(v -> p.put("surface", byId.get(v.getId())));
    onSurface.ifPresent(v -> p.put("onSurface", byId.get(v.getId())));
    surfaceDim.ifPresent(v -> p.put("surfaceDim", byId.get(v.getId())));
    surfaceBright.ifPresent(v -> p.put("surfaceBright", byId.get(v.getId())));
    surfaceContainerLowest.ifPresent(v -> p.put("surfaceContainerLowest", byId.get(v.getId())));
    surfaceContainerLow.ifPresent(v -> p.put("surfaceContainerLow", byId.get(v.getId())));
    surfaceContainer.ifPresent(v -> p.put("surfaceContainer", byId.get(v.getId())));
    surfaceContainerHigh.ifPresent(v -> p.put("surfaceContainerHigh", byId.get(v.getId())));
    surfaceContainerHighest.ifPresent(v -> p.put("surfaceContainerHighest", byId.get(v.getId())));
    onSurfaceVariant.ifPresent(v -> p.put("onSurfaceVariant", byId.get(v.getId())));
    outline.ifPresent(v -> p.put("outline", byId.get(v.getId())));
    outlineVariant.ifPresent(v -> p.put("outlineVariant", byId.get(v.getId())));
    shadow.ifPresent(v -> p.put("shadow", byId.get(v.getId())));
    scrim.ifPresent(v -> p.put("scrim", byId.get(v.getId())));
    inverseSurface.ifPresent(v -> p.put("inverseSurface", byId.get(v.getId())));
    onInverseSurface.ifPresent(v -> p.put("onInverseSurface", byId.get(v.getId())));
    inversePrimary.ifPresent(v -> p.put("inversePrimary", byId.get(v.getId())));
    surfaceTint.ifPresent(v -> p.put("surfaceTint", byId.get(v.getId())));
    background.ifPresent(v -> p.put("background", byId.get(v.getId())));
    onBackground.ifPresent(v -> p.put("onBackground", byId.get(v.getId())));
    surfaceVariant.ifPresent(v -> p.put("surfaceVariant", byId.get(v.getId())));
    record(id, "colorSchemeHighContrastDark", p);
    MemorySegment st = ColorSchemeObjSt.allocate(arena);
    ColorSchemeObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment colorSchemeFromSwatch(Optional<MaterialColor> primarySwatch, Optional<Color> accentColor, Optional<Color> cardColor, Optional<Color> backgroundColor, Optional<Color> errorColor, Optional<Brightness> brightness) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    primarySwatch.ifPresent(v -> p.put("primarySwatch", byId.get(v.getId())));
    accentColor.ifPresent(v -> p.put("accentColor", byId.get(v.getId())));
    cardColor.ifPresent(v -> p.put("cardColor", byId.get(v.getId())));
    backgroundColor.ifPresent(v -> p.put("backgroundColor", byId.get(v.getId())));
    errorColor.ifPresent(v -> p.put("errorColor", byId.get(v.getId())));
    brightness.ifPresent(v -> p.put("brightness", v.ordinal()));
    record(id, "colorSchemeFromSwatch", p);
    MemorySegment st = ColorSchemeObjSt.allocate(arena);
    ColorSchemeObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment colorSchemeLerp(ColorScheme a, ColorScheme b, double t) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", byId.get(a.getId()));
    p.put("b", byId.get(b.getId()));
    p.put("t", t);
    record(id, "colorSchemeLerp", p);
    MemorySegment st = ColorSchemeObjSt.allocate(arena);
    ColorSchemeObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment colorSchemeOf(BuildContext context) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("context", byId.get(context.getId()));
    record(id, "colorSchemeOf", p);
    MemorySegment st = ColorSchemeObjSt.allocate(arena);
    ColorSchemeObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment materialColorMaterialColor(int primary, Map<Integer, Color> swatch) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("primary", primary);
    p.put("swatch", nextCallbackId++);
    record(id, "materialColorMaterialColor", p);
    MemorySegment st = MaterialColorObjSt.allocate(arena);
    MaterialColorObjSt.id(st, id);
    MaterialColorObjSt.shade50(st, swatch.get(50) != null ? swatch.get(50).getId() : 0);
    MaterialColorObjSt.shade100(st, swatch.get(100) != null ? swatch.get(100).getId() : 0);
    MaterialColorObjSt.shade200(st, swatch.get(200) != null ? swatch.get(200).getId() : 0);
    MaterialColorObjSt.shade300(st, swatch.get(300) != null ? swatch.get(300).getId() : 0);
    MaterialColorObjSt.shade400(st, swatch.get(400) != null ? swatch.get(400).getId() : 0);
    MaterialColorObjSt.shade500(st, swatch.get(500) != null ? swatch.get(500).getId() : 0);
    MaterialColorObjSt.shade600(st, swatch.get(600) != null ? swatch.get(600).getId() : 0);
    MaterialColorObjSt.shade700(st, swatch.get(700) != null ? swatch.get(700).getId() : 0);
    MaterialColorObjSt.shade800(st, swatch.get(800) != null ? swatch.get(800).getId() : 0);
    MaterialColorObjSt.shade900(st, swatch.get(900) != null ? swatch.get(900).getId() : 0);
    return st;
  }

  @Override
  MemorySegment colorSwatchLerp(ColorSwatch a, ColorSwatch b, double t) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", byId.get(a.getId()));
    p.put("b", byId.get(b.getId()));
    p.put("t", t);
    record(id, "colorSwatchLerp", p);
    MemorySegment st = ColorSwatchObjSt.allocate(arena);
    ColorSwatchObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment textThemeTextTheme(Optional<TextStyle> displayLarge, Optional<TextStyle> displayMedium, Optional<TextStyle> displaySmall, Optional<TextStyle> headlineLarge, Optional<TextStyle> headlineMedium, Optional<TextStyle> headlineSmall, Optional<TextStyle> titleLarge, Optional<TextStyle> titleMedium, Optional<TextStyle> titleSmall, Optional<TextStyle> bodyLarge, Optional<TextStyle> bodyMedium, Optional<TextStyle> bodySmall, Optional<TextStyle> labelLarge, Optional<TextStyle> labelMedium, Optional<TextStyle> labelSmall) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    displayLarge.ifPresent(v -> p.put("displayLarge", byId.get(v.getId())));
    displayMedium.ifPresent(v -> p.put("displayMedium", byId.get(v.getId())));
    displaySmall.ifPresent(v -> p.put("displaySmall", byId.get(v.getId())));
    headlineLarge.ifPresent(v -> p.put("headlineLarge", byId.get(v.getId())));
    headlineMedium.ifPresent(v -> p.put("headlineMedium", byId.get(v.getId())));
    headlineSmall.ifPresent(v -> p.put("headlineSmall", byId.get(v.getId())));
    titleLarge.ifPresent(v -> p.put("titleLarge", byId.get(v.getId())));
    titleMedium.ifPresent(v -> p.put("titleMedium", byId.get(v.getId())));
    titleSmall.ifPresent(v -> p.put("titleSmall", byId.get(v.getId())));
    bodyLarge.ifPresent(v -> p.put("bodyLarge", byId.get(v.getId())));
    bodyMedium.ifPresent(v -> p.put("bodyMedium", byId.get(v.getId())));
    bodySmall.ifPresent(v -> p.put("bodySmall", byId.get(v.getId())));
    labelLarge.ifPresent(v -> p.put("labelLarge", byId.get(v.getId())));
    labelMedium.ifPresent(v -> p.put("labelMedium", byId.get(v.getId())));
    labelSmall.ifPresent(v -> p.put("labelSmall", byId.get(v.getId())));
    record(id, "textThemeTextTheme", p);
    MemorySegment st = TextThemeObjSt.allocate(arena);
    TextThemeObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment textThemeLerp(TextTheme a, TextTheme b, double t) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", byId.get(a.getId()));
    p.put("b", byId.get(b.getId()));
    p.put("t", t);
    record(id, "textThemeLerp", p);
    MemorySegment st = TextThemeObjSt.allocate(arena);
    TextThemeObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment textThemeOf(BuildContext context) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("context", byId.get(context.getId()));
    record(id, "textThemeOf", p);
    MemorySegment st = TextThemeObjSt.allocate(arena);
    TextThemeObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment textThemePrimaryOf(BuildContext context) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("context", byId.get(context.getId()));
    record(id, "textThemePrimaryOf", p);
    MemorySegment st = TextThemeObjSt.allocate(arena);
    TextThemeObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment visualDensityVisualDensity(OptionalDouble horizontal, OptionalDouble vertical) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (horizontal.isPresent()) { p.put("horizontal", horizontal.getAsDouble()); }
    if (vertical.isPresent()) { p.put("vertical", vertical.getAsDouble()); }
    record(id, "visualDensityVisualDensity", p);
    MemorySegment st = VisualDensityObjSt.allocate(arena);
    VisualDensityObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment visualDensityDefaultDensityForPlatform(TargetPlatform platform) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("platform", platform.ordinal());
    record(id, "visualDensityDefaultDensityForPlatform", p);
    MemorySegment st = VisualDensityObjSt.allocate(arena);
    VisualDensityObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment visualDensityLerp(VisualDensity a, VisualDensity b, double t) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", byId.get(a.getId()));
    p.put("b", byId.get(b.getId()));
    p.put("t", t);
    record(id, "visualDensityLerp", p);
    MemorySegment st = VisualDensityObjSt.allocate(arena);
    VisualDensityObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment themeDataThemeData(Optional<Boolean> applyElevationOverlayColor, Optional<NativeObj> inputDecorationTheme, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<TargetPlatform> platform, Optional<Boolean> useMaterial3, Optional<Boolean> useSystemColors, Optional<VisualDensity> visualDensity, Optional<ColorScheme> colorScheme, Optional<Brightness> brightness, Optional<Color> colorSchemeSeed, Optional<Color> canvasColor, Optional<Color> cardColor, Optional<Color> disabledColor, Optional<Color> dividerColor, Optional<Color> focusColor, Optional<Color> highlightColor, Optional<Color> hintColor, Optional<Color> hoverColor, Optional<Color> primaryColor, Optional<Color> primaryColorDark, Optional<Color> primaryColorLight, Optional<MaterialColor> primarySwatch, Optional<Color> scaffoldBackgroundColor, Optional<Color> secondaryHeaderColor, Optional<Color> shadowColor, Optional<Color> splashColor, Optional<Color> unselectedWidgetColor, Optional<String> fontFamily, Optional<List<String>> fontFamilyFallback, Optional<String> _package, Optional<TextTheme> primaryTextTheme, Optional<TextTheme> textTheme, Optional<NativeObj> appBarTheme, Optional<Color> dialogBackgroundColor, Optional<Color> indicatorColor) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    applyElevationOverlayColor.ifPresent(v -> p.put("applyElevationOverlayColor", v));
    inputDecorationTheme.ifPresent(v -> p.put("inputDecorationTheme", byId.get(v.getId())));
    materialTapTargetSize.ifPresent(v -> p.put("materialTapTargetSize", v.ordinal()));
    platform.ifPresent(v -> p.put("platform", v.ordinal()));
    useMaterial3.ifPresent(v -> p.put("useMaterial3", v));
    useSystemColors.ifPresent(v -> p.put("useSystemColors", v));
    visualDensity.ifPresent(v -> p.put("visualDensity", byId.get(v.getId())));
    colorScheme.ifPresent(v -> p.put("colorScheme", byId.get(v.getId())));
    brightness.ifPresent(v -> p.put("brightness", v.ordinal()));
    colorSchemeSeed.ifPresent(v -> p.put("colorSchemeSeed", byId.get(v.getId())));
    canvasColor.ifPresent(v -> p.put("canvasColor", byId.get(v.getId())));
    cardColor.ifPresent(v -> p.put("cardColor", byId.get(v.getId())));
    disabledColor.ifPresent(v -> p.put("disabledColor", byId.get(v.getId())));
    dividerColor.ifPresent(v -> p.put("dividerColor", byId.get(v.getId())));
    focusColor.ifPresent(v -> p.put("focusColor", byId.get(v.getId())));
    highlightColor.ifPresent(v -> p.put("highlightColor", byId.get(v.getId())));
    hintColor.ifPresent(v -> p.put("hintColor", byId.get(v.getId())));
    hoverColor.ifPresent(v -> p.put("hoverColor", byId.get(v.getId())));
    primaryColor.ifPresent(v -> p.put("primaryColor", byId.get(v.getId())));
    primaryColorDark.ifPresent(v -> p.put("primaryColorDark", byId.get(v.getId())));
    primaryColorLight.ifPresent(v -> p.put("primaryColorLight", byId.get(v.getId())));
    primarySwatch.ifPresent(v -> p.put("primarySwatch", byId.get(v.getId())));
    scaffoldBackgroundColor.ifPresent(v -> p.put("scaffoldBackgroundColor", byId.get(v.getId())));
    secondaryHeaderColor.ifPresent(v -> p.put("secondaryHeaderColor", byId.get(v.getId())));
    shadowColor.ifPresent(v -> p.put("shadowColor", byId.get(v.getId())));
    splashColor.ifPresent(v -> p.put("splashColor", byId.get(v.getId())));
    unselectedWidgetColor.ifPresent(v -> p.put("unselectedWidgetColor", byId.get(v.getId())));
    fontFamily.ifPresent(v -> p.put("fontFamily", v));
    fontFamilyFallback.ifPresent(v -> p.put("fontFamilyFallback", v.stream().map(e -> e).collect(java.util.stream.Collectors.toList())));
    _package.ifPresent(v -> p.put("package", v));
    primaryTextTheme.ifPresent(v -> p.put("primaryTextTheme", byId.get(v.getId())));
    textTheme.ifPresent(v -> p.put("textTheme", byId.get(v.getId())));
    appBarTheme.ifPresent(v -> p.put("appBarTheme", byId.get(v.getId())));
    dialogBackgroundColor.ifPresent(v -> p.put("dialogBackgroundColor", byId.get(v.getId())));
    indicatorColor.ifPresent(v -> p.put("indicatorColor", byId.get(v.getId())));
    record(id, "themeDataThemeData", p);
    MemorySegment st = ThemeDataObjSt.allocate(arena);
    ThemeDataObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment themeDataFrom(ColorScheme colorScheme, Optional<TextTheme> textTheme, Optional<Boolean> useMaterial3) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("colorScheme", byId.get(colorScheme.getId()));
    textTheme.ifPresent(v -> p.put("textTheme", byId.get(v.getId())));
    useMaterial3.ifPresent(v -> p.put("useMaterial3", v));
    record(id, "themeDataFrom", p);
    MemorySegment st = ThemeDataObjSt.allocate(arena);
    ThemeDataObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment themeDataLight(Optional<Boolean> useMaterial3) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    useMaterial3.ifPresent(v -> p.put("useMaterial3", v));
    record(id, "themeDataLight", p);
    MemorySegment st = ThemeDataObjSt.allocate(arena);
    ThemeDataObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment themeDataDark(Optional<Boolean> useMaterial3) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    useMaterial3.ifPresent(v -> p.put("useMaterial3", v));
    record(id, "themeDataDark", p);
    MemorySegment st = ThemeDataObjSt.allocate(arena);
    ThemeDataObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment themeDataFallback(Optional<Boolean> useMaterial3) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    useMaterial3.ifPresent(v -> p.put("useMaterial3", v));
    record(id, "themeDataFallback", p);
    MemorySegment st = ThemeDataObjSt.allocate(arena);
    ThemeDataObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment themeDataLocalize(ThemeData baseTheme, TextTheme localTextGeometry) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("baseTheme", byId.get(baseTheme.getId()));
    p.put("localTextGeometry", byId.get(localTextGeometry.getId()));
    record(id, "themeDataLocalize", p);
    MemorySegment st = ThemeDataObjSt.allocate(arena);
    ThemeDataObjSt.id(st, id);
    return st;
  }
  @Override
  int themeDataEstimateBrightnessForColor(Color color) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("color", byId.get(color.getId()));
    record(id, "themeDataEstimateBrightnessForColor", p);
    return id;
  }
  @Override
  MemorySegment themeDataLerp(ThemeData a, ThemeData b, double t) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("a", byId.get(a.getId()));
    p.put("b", byId.get(b.getId()));
    p.put("t", t);
    record(id, "themeDataLerp", p);
    MemorySegment st = ThemeDataObjSt.allocate(arena);
    ThemeDataObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment materialAccentColorMaterialAccentColor(int primary, Map<Integer, Color> swatch) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("primary", primary);
    p.put("swatch", nextCallbackId++);
    record(id, "materialAccentColorMaterialAccentColor", p);
    MemorySegment st = MaterialAccentColorObjSt.allocate(arena);
    MaterialAccentColorObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment materialMaterial(Optional<MaterialType> type, OptionalDouble elevation, Optional<Color> color, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<TextStyle> textStyle, Optional<BorderRadiusGeometry> borderRadius, Optional<ShapeBorder> shape, Optional<Boolean> borderOnForeground, Optional<Clip> clipBehavior, Optional<Duration> animationDuration, Optional<Widget> child, Optional<Boolean> animateColor) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    type.ifPresent(v -> p.put("type", v.ordinal()));
    if (elevation.isPresent()) { p.put("elevation", elevation.getAsDouble()); }
    color.ifPresent(v -> p.put("color", byId.get(v.getId())));
    shadowColor.ifPresent(v -> p.put("shadowColor", byId.get(v.getId())));
    surfaceTintColor.ifPresent(v -> p.put("surfaceTintColor", byId.get(v.getId())));
    textStyle.ifPresent(v -> p.put("textStyle", byId.get(v.getId())));
    borderRadius.ifPresent(v -> p.put("borderRadius", byId.get(v.getId())));
    shape.ifPresent(v -> p.put("shape", byId.get(v.getId())));
    borderOnForeground.ifPresent(v -> p.put("borderOnForeground", v));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    animationDuration.ifPresent(v -> p.put("animationDuration", byId.get(v.getId())));
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    animateColor.ifPresent(v -> p.put("animateColor", v));
    record(id, "materialMaterial", p);
    MemorySegment st = MaterialObjSt.allocate(arena);
    MaterialObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment iconButtonIconButton(OptionalDouble iconSize, Optional<VisualDensity> visualDensity, Optional<EdgeInsetsGeometry> padding, Optional<AlignmentGeometry> alignment, OptionalDouble splashRadius, Optional<Color> color, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> splashColor, Optional<Color> disabledColor, Runnable onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraints> constraints, Optional<Boolean> isSelected, Optional<Widget> selectedIcon, Widget icon) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (iconSize.isPresent()) { p.put("iconSize", iconSize.getAsDouble()); }
    visualDensity.ifPresent(v -> p.put("visualDensity", byId.get(v.getId())));
    padding.ifPresent(v -> p.put("padding", byId.get(v.getId())));
    alignment.ifPresent(v -> p.put("alignment", byId.get(v.getId())));
    if (splashRadius.isPresent()) { p.put("splashRadius", splashRadius.getAsDouble()); }
    color.ifPresent(v -> p.put("color", byId.get(v.getId())));
    focusColor.ifPresent(v -> p.put("focusColor", byId.get(v.getId())));
    hoverColor.ifPresent(v -> p.put("hoverColor", byId.get(v.getId())));
    highlightColor.ifPresent(v -> p.put("highlightColor", byId.get(v.getId())));
    splashColor.ifPresent(v -> p.put("splashColor", byId.get(v.getId())));
    disabledColor.ifPresent(v -> p.put("disabledColor", byId.get(v.getId())));
    int __cb_onPressed = nextCallbackId++; p.put("onPressed", __cb_onPressed); callbacks.put(__cb_onPressed, onPressed);
    if (onHover.isPresent()) { int __cb_onHover = nextCallbackId++; p.put("onHover", __cb_onHover); java.util.function.Consumer<Boolean> __h_onHover = onHover.get(); callbacks.put(__cb_onHover, (java.util.function.Consumer<Object>)(v -> __h_onHover.accept((Boolean) v))); }
    if (onLongPress.isPresent()) { int __cb_onLongPress = nextCallbackId++; p.put("onLongPress", __cb_onLongPress); callbacks.put(__cb_onLongPress, onLongPress.get()); }
    autofocus.ifPresent(v -> p.put("autofocus", v));
    tooltip.ifPresent(v -> p.put("tooltip", v));
    enableFeedback.ifPresent(v -> p.put("enableFeedback", v));
    constraints.ifPresent(v -> p.put("constraints", byId.get(v.getId())));
    isSelected.ifPresent(v -> p.put("isSelected", v));
    selectedIcon.ifPresent(v -> p.put("selectedIcon", byId.get(v.getId())));
    p.put("icon", byId.get(icon.getId()));
    record(id, "iconButtonIconButton", p);
    MemorySegment st = IconButtonObjSt.allocate(arena);
    IconButtonObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment iconButtonFilled(OptionalDouble iconSize, Optional<VisualDensity> visualDensity, Optional<EdgeInsetsGeometry> padding, Optional<AlignmentGeometry> alignment, OptionalDouble splashRadius, Optional<Color> color, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> splashColor, Optional<Color> disabledColor, Runnable onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraints> constraints, Optional<Boolean> isSelected, Optional<Widget> selectedIcon, Widget icon) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (iconSize.isPresent()) { p.put("iconSize", iconSize.getAsDouble()); }
    visualDensity.ifPresent(v -> p.put("visualDensity", byId.get(v.getId())));
    padding.ifPresent(v -> p.put("padding", byId.get(v.getId())));
    alignment.ifPresent(v -> p.put("alignment", byId.get(v.getId())));
    if (splashRadius.isPresent()) { p.put("splashRadius", splashRadius.getAsDouble()); }
    color.ifPresent(v -> p.put("color", byId.get(v.getId())));
    focusColor.ifPresent(v -> p.put("focusColor", byId.get(v.getId())));
    hoverColor.ifPresent(v -> p.put("hoverColor", byId.get(v.getId())));
    highlightColor.ifPresent(v -> p.put("highlightColor", byId.get(v.getId())));
    splashColor.ifPresent(v -> p.put("splashColor", byId.get(v.getId())));
    disabledColor.ifPresent(v -> p.put("disabledColor", byId.get(v.getId())));
    int __cb_onPressed = nextCallbackId++; p.put("onPressed", __cb_onPressed); callbacks.put(__cb_onPressed, onPressed);
    if (onHover.isPresent()) { int __cb_onHover = nextCallbackId++; p.put("onHover", __cb_onHover); java.util.function.Consumer<Boolean> __h_onHover = onHover.get(); callbacks.put(__cb_onHover, (java.util.function.Consumer<Object>)(v -> __h_onHover.accept((Boolean) v))); }
    if (onLongPress.isPresent()) { int __cb_onLongPress = nextCallbackId++; p.put("onLongPress", __cb_onLongPress); callbacks.put(__cb_onLongPress, onLongPress.get()); }
    autofocus.ifPresent(v -> p.put("autofocus", v));
    tooltip.ifPresent(v -> p.put("tooltip", v));
    enableFeedback.ifPresent(v -> p.put("enableFeedback", v));
    constraints.ifPresent(v -> p.put("constraints", byId.get(v.getId())));
    isSelected.ifPresent(v -> p.put("isSelected", v));
    selectedIcon.ifPresent(v -> p.put("selectedIcon", byId.get(v.getId())));
    p.put("icon", byId.get(icon.getId()));
    record(id, "iconButtonFilled", p);
    MemorySegment st = IconButtonObjSt.allocate(arena);
    IconButtonObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment iconButtonFilledTonal(OptionalDouble iconSize, Optional<VisualDensity> visualDensity, Optional<EdgeInsetsGeometry> padding, Optional<AlignmentGeometry> alignment, OptionalDouble splashRadius, Optional<Color> color, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> splashColor, Optional<Color> disabledColor, Runnable onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraints> constraints, Optional<Boolean> isSelected, Optional<Widget> selectedIcon, Widget icon) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (iconSize.isPresent()) { p.put("iconSize", iconSize.getAsDouble()); }
    visualDensity.ifPresent(v -> p.put("visualDensity", byId.get(v.getId())));
    padding.ifPresent(v -> p.put("padding", byId.get(v.getId())));
    alignment.ifPresent(v -> p.put("alignment", byId.get(v.getId())));
    if (splashRadius.isPresent()) { p.put("splashRadius", splashRadius.getAsDouble()); }
    color.ifPresent(v -> p.put("color", byId.get(v.getId())));
    focusColor.ifPresent(v -> p.put("focusColor", byId.get(v.getId())));
    hoverColor.ifPresent(v -> p.put("hoverColor", byId.get(v.getId())));
    highlightColor.ifPresent(v -> p.put("highlightColor", byId.get(v.getId())));
    splashColor.ifPresent(v -> p.put("splashColor", byId.get(v.getId())));
    disabledColor.ifPresent(v -> p.put("disabledColor", byId.get(v.getId())));
    int __cb_onPressed = nextCallbackId++; p.put("onPressed", __cb_onPressed); callbacks.put(__cb_onPressed, onPressed);
    if (onHover.isPresent()) { int __cb_onHover = nextCallbackId++; p.put("onHover", __cb_onHover); java.util.function.Consumer<Boolean> __h_onHover = onHover.get(); callbacks.put(__cb_onHover, (java.util.function.Consumer<Object>)(v -> __h_onHover.accept((Boolean) v))); }
    if (onLongPress.isPresent()) { int __cb_onLongPress = nextCallbackId++; p.put("onLongPress", __cb_onLongPress); callbacks.put(__cb_onLongPress, onLongPress.get()); }
    autofocus.ifPresent(v -> p.put("autofocus", v));
    tooltip.ifPresent(v -> p.put("tooltip", v));
    enableFeedback.ifPresent(v -> p.put("enableFeedback", v));
    constraints.ifPresent(v -> p.put("constraints", byId.get(v.getId())));
    isSelected.ifPresent(v -> p.put("isSelected", v));
    selectedIcon.ifPresent(v -> p.put("selectedIcon", byId.get(v.getId())));
    p.put("icon", byId.get(icon.getId()));
    record(id, "iconButtonFilledTonal", p);
    MemorySegment st = IconButtonObjSt.allocate(arena);
    IconButtonObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment iconButtonOutlined(OptionalDouble iconSize, Optional<VisualDensity> visualDensity, Optional<EdgeInsetsGeometry> padding, Optional<AlignmentGeometry> alignment, OptionalDouble splashRadius, Optional<Color> color, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> splashColor, Optional<Color> disabledColor, Runnable onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraints> constraints, Optional<Boolean> isSelected, Optional<Widget> selectedIcon, Widget icon) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (iconSize.isPresent()) { p.put("iconSize", iconSize.getAsDouble()); }
    visualDensity.ifPresent(v -> p.put("visualDensity", byId.get(v.getId())));
    padding.ifPresent(v -> p.put("padding", byId.get(v.getId())));
    alignment.ifPresent(v -> p.put("alignment", byId.get(v.getId())));
    if (splashRadius.isPresent()) { p.put("splashRadius", splashRadius.getAsDouble()); }
    color.ifPresent(v -> p.put("color", byId.get(v.getId())));
    focusColor.ifPresent(v -> p.put("focusColor", byId.get(v.getId())));
    hoverColor.ifPresent(v -> p.put("hoverColor", byId.get(v.getId())));
    highlightColor.ifPresent(v -> p.put("highlightColor", byId.get(v.getId())));
    splashColor.ifPresent(v -> p.put("splashColor", byId.get(v.getId())));
    disabledColor.ifPresent(v -> p.put("disabledColor", byId.get(v.getId())));
    int __cb_onPressed = nextCallbackId++; p.put("onPressed", __cb_onPressed); callbacks.put(__cb_onPressed, onPressed);
    if (onHover.isPresent()) { int __cb_onHover = nextCallbackId++; p.put("onHover", __cb_onHover); java.util.function.Consumer<Boolean> __h_onHover = onHover.get(); callbacks.put(__cb_onHover, (java.util.function.Consumer<Object>)(v -> __h_onHover.accept((Boolean) v))); }
    if (onLongPress.isPresent()) { int __cb_onLongPress = nextCallbackId++; p.put("onLongPress", __cb_onLongPress); callbacks.put(__cb_onLongPress, onLongPress.get()); }
    autofocus.ifPresent(v -> p.put("autofocus", v));
    tooltip.ifPresent(v -> p.put("tooltip", v));
    enableFeedback.ifPresent(v -> p.put("enableFeedback", v));
    constraints.ifPresent(v -> p.put("constraints", byId.get(v.getId())));
    isSelected.ifPresent(v -> p.put("isSelected", v));
    selectedIcon.ifPresent(v -> p.put("selectedIcon", byId.get(v.getId())));
    p.put("icon", byId.get(icon.getId()));
    record(id, "iconButtonOutlined", p);
    MemorySegment st = IconButtonObjSt.allocate(arena);
    IconButtonObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment appBarAppBar(Optional<Widget> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Widget> title, Optional<List<Widget>> actions, Optional<Widget> flexibleSpace, Optional<PreferredSizeWidget> bottom, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<ShapeBorder> shape, Optional<Color> backgroundColor, Optional<Color> foregroundColor, Optional<Boolean> primary, Optional<Boolean> centerTitle, Optional<Boolean> excludeHeaderSemantics, OptionalDouble titleSpacing, OptionalDouble toolbarOpacity, OptionalDouble bottomOpacity, OptionalDouble toolbarHeight, OptionalDouble leadingWidth, Optional<TextStyle> toolbarTextStyle, Optional<TextStyle> titleTextStyle, Optional<Boolean> forceMaterialTransparency, Optional<Boolean> useDefaultSemanticsOrder, Optional<Clip> clipBehavior, Optional<EdgeInsetsGeometry> actionsPadding, Optional<Boolean> animateColor) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    leading.ifPresent(v -> p.put("leading", byId.get(v.getId())));
    automaticallyImplyLeading.ifPresent(v -> p.put("automaticallyImplyLeading", v));
    title.ifPresent(v -> p.put("title", byId.get(v.getId())));
    actions.ifPresent(v -> p.put("actions", v.stream().map(e -> byId.get(e.getId())).collect(java.util.stream.Collectors.toList())));
    flexibleSpace.ifPresent(v -> p.put("flexibleSpace", byId.get(v.getId())));
    bottom.ifPresent(v -> p.put("bottom", byId.get(v.getId())));
    if (elevation.isPresent()) { p.put("elevation", elevation.getAsDouble()); }
    if (scrolledUnderElevation.isPresent()) { p.put("scrolledUnderElevation", scrolledUnderElevation.getAsDouble()); }
    shadowColor.ifPresent(v -> p.put("shadowColor", byId.get(v.getId())));
    surfaceTintColor.ifPresent(v -> p.put("surfaceTintColor", byId.get(v.getId())));
    shape.ifPresent(v -> p.put("shape", byId.get(v.getId())));
    backgroundColor.ifPresent(v -> p.put("backgroundColor", byId.get(v.getId())));
    foregroundColor.ifPresent(v -> p.put("foregroundColor", byId.get(v.getId())));
    primary.ifPresent(v -> p.put("primary", v));
    centerTitle.ifPresent(v -> p.put("centerTitle", v));
    excludeHeaderSemantics.ifPresent(v -> p.put("excludeHeaderSemantics", v));
    if (titleSpacing.isPresent()) { p.put("titleSpacing", titleSpacing.getAsDouble()); }
    if (toolbarOpacity.isPresent()) { p.put("toolbarOpacity", toolbarOpacity.getAsDouble()); }
    if (bottomOpacity.isPresent()) { p.put("bottomOpacity", bottomOpacity.getAsDouble()); }
    if (toolbarHeight.isPresent()) { p.put("toolbarHeight", toolbarHeight.getAsDouble()); }
    if (leadingWidth.isPresent()) { p.put("leadingWidth", leadingWidth.getAsDouble()); }
    toolbarTextStyle.ifPresent(v -> p.put("toolbarTextStyle", byId.get(v.getId())));
    titleTextStyle.ifPresent(v -> p.put("titleTextStyle", byId.get(v.getId())));
    forceMaterialTransparency.ifPresent(v -> p.put("forceMaterialTransparency", v));
    useDefaultSemanticsOrder.ifPresent(v -> p.put("useDefaultSemanticsOrder", v));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    actionsPadding.ifPresent(v -> p.put("actionsPadding", byId.get(v.getId())));
    animateColor.ifPresent(v -> p.put("animateColor", v));
    record(id, "appBarAppBar", p);
    MemorySegment st = AppBarObjSt.allocate(arena);
    AppBarObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment scaffoldScaffold(Optional<PreferredSizeWidget> appBar, Optional<Widget> body, Optional<Widget> floatingActionButton, Optional<List<Widget>> persistentFooterButtons, Optional<AlignmentDirectional> persistentFooterAlignment, Optional<BoxDecoration> persistentFooterDecoration, Optional<Widget> drawer, Optional<Consumer<Boolean>> onDrawerChanged, Optional<Widget> endDrawer, Optional<Consumer<Boolean>> onEndDrawerChanged, Optional<Widget> bottomNavigationBar, Optional<Widget> bottomSheet, Optional<Color> backgroundColor, Optional<Boolean> resizeToAvoidBottomInset, Optional<Boolean> primary, Optional<DragStartBehavior> drawerDragStartBehavior, Optional<Boolean> extendBody, Optional<Boolean> drawerBarrierDismissible, Optional<Boolean> extendBodyBehindAppBar, Optional<Color> drawerScrimColor, Optional<BiFunction<BuildContext, Animation, Widget>> bottomSheetScrimBuilder, OptionalDouble drawerEdgeDragWidth, Optional<Boolean> drawerEnableOpenDragGesture, Optional<Boolean> endDrawerEnableOpenDragGesture, Optional<String> restorationId) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    appBar.ifPresent(v -> p.put("appBar", byId.get(v.getId())));
    body.ifPresent(v -> p.put("body", byId.get(v.getId())));
    floatingActionButton.ifPresent(v -> p.put("floatingActionButton", byId.get(v.getId())));
    persistentFooterButtons.ifPresent(v -> p.put("persistentFooterButtons", v.stream().map(e -> byId.get(e.getId())).collect(java.util.stream.Collectors.toList())));
    persistentFooterAlignment.ifPresent(v -> p.put("persistentFooterAlignment", byId.get(v.getId())));
    persistentFooterDecoration.ifPresent(v -> p.put("persistentFooterDecoration", byId.get(v.getId())));
    drawer.ifPresent(v -> p.put("drawer", byId.get(v.getId())));
    if (onDrawerChanged.isPresent()) { int __cb_onDrawerChanged = nextCallbackId++; p.put("onDrawerChanged", __cb_onDrawerChanged); java.util.function.Consumer<Boolean> __h_onDrawerChanged = onDrawerChanged.get(); callbacks.put(__cb_onDrawerChanged, (java.util.function.Consumer<Object>)(v -> __h_onDrawerChanged.accept((Boolean) v))); }
    endDrawer.ifPresent(v -> p.put("endDrawer", byId.get(v.getId())));
    if (onEndDrawerChanged.isPresent()) { int __cb_onEndDrawerChanged = nextCallbackId++; p.put("onEndDrawerChanged", __cb_onEndDrawerChanged); java.util.function.Consumer<Boolean> __h_onEndDrawerChanged = onEndDrawerChanged.get(); callbacks.put(__cb_onEndDrawerChanged, (java.util.function.Consumer<Object>)(v -> __h_onEndDrawerChanged.accept((Boolean) v))); }
    bottomNavigationBar.ifPresent(v -> p.put("bottomNavigationBar", byId.get(v.getId())));
    bottomSheet.ifPresent(v -> p.put("bottomSheet", byId.get(v.getId())));
    backgroundColor.ifPresent(v -> p.put("backgroundColor", byId.get(v.getId())));
    resizeToAvoidBottomInset.ifPresent(v -> p.put("resizeToAvoidBottomInset", v));
    primary.ifPresent(v -> p.put("primary", v));
    drawerDragStartBehavior.ifPresent(v -> p.put("drawerDragStartBehavior", v.ordinal()));
    extendBody.ifPresent(v -> p.put("extendBody", v));
    drawerBarrierDismissible.ifPresent(v -> p.put("drawerBarrierDismissible", v));
    extendBodyBehindAppBar.ifPresent(v -> p.put("extendBodyBehindAppBar", v));
    drawerScrimColor.ifPresent(v -> p.put("drawerScrimColor", byId.get(v.getId())));
    if (bottomSheetScrimBuilder != null) { p.put("bottomSheetScrimBuilder", nextCallbackId++); }
    if (drawerEdgeDragWidth.isPresent()) { p.put("drawerEdgeDragWidth", drawerEdgeDragWidth.getAsDouble()); }
    drawerEnableOpenDragGesture.ifPresent(v -> p.put("drawerEnableOpenDragGesture", v));
    endDrawerEnableOpenDragGesture.ifPresent(v -> p.put("endDrawerEnableOpenDragGesture", v));
    restorationId.ifPresent(v -> p.put("restorationId", v));
    record(id, "scaffoldScaffold", p);
    MemorySegment st = ScaffoldObjSt.allocate(arena);
    ScaffoldObjSt.id(st, id);
    return st;
  }
  @Override
  int scaffoldGeometryOf(BuildContext context) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("context", byId.get(context.getId()));
    record(id, "scaffoldGeometryOf", p);
    return id;
  }
  @Override
  int scaffoldHasDrawer(BuildContext context, Optional<Boolean> registerForUpdates) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("context", byId.get(context.getId()));
    registerForUpdates.ifPresent(v -> p.put("registerForUpdates", v));
    record(id, "scaffoldHasDrawer", p);
    return id;
  }

  @Override
  MemorySegment materialAppMaterialApp(Optional<Widget> home, Optional<String> initialRoute, Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<String> title, Optional<Function<BuildContext, String>> onGenerateTitle, Optional<Color> color, Optional<ThemeData> theme, Optional<ThemeData> darkTheme, Optional<ThemeData> highContrastTheme, Optional<ThemeData> highContrastDarkTheme, Optional<ThemeMode> themeMode, Optional<Duration> themeAnimationDuration, Optional<Curve> themeAnimationCurve, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    home.ifPresent(v -> p.put("home", byId.get(v.getId())));
    initialRoute.ifPresent(v -> p.put("initialRoute", v));
    if (builder != null) { p.put("builder", nextCallbackId++); }
    title.ifPresent(v -> p.put("title", v));
    if (onGenerateTitle != null) { p.put("onGenerateTitle", nextCallbackId++); }
    color.ifPresent(v -> p.put("color", byId.get(v.getId())));
    theme.ifPresent(v -> p.put("theme", byId.get(v.getId())));
    darkTheme.ifPresent(v -> p.put("darkTheme", byId.get(v.getId())));
    highContrastTheme.ifPresent(v -> p.put("highContrastTheme", byId.get(v.getId())));
    highContrastDarkTheme.ifPresent(v -> p.put("highContrastDarkTheme", byId.get(v.getId())));
    themeMode.ifPresent(v -> p.put("themeMode", v.ordinal()));
    themeAnimationDuration.ifPresent(v -> p.put("themeAnimationDuration", byId.get(v.getId())));
    themeAnimationCurve.ifPresent(v -> p.put("themeAnimationCurve", byId.get(v.getId())));
    debugShowMaterialGrid.ifPresent(v -> p.put("debugShowMaterialGrid", v));
    showPerformanceOverlay.ifPresent(v -> p.put("showPerformanceOverlay", v));
    checkerboardRasterCacheImages.ifPresent(v -> p.put("checkerboardRasterCacheImages", v));
    checkerboardOffscreenLayers.ifPresent(v -> p.put("checkerboardOffscreenLayers", v));
    showSemanticsDebugger.ifPresent(v -> p.put("showSemanticsDebugger", v));
    debugShowCheckedModeBanner.ifPresent(v -> p.put("debugShowCheckedModeBanner", v));
    restorationScopeId.ifPresent(v -> p.put("restorationScopeId", v));
    useInheritedMediaQuery.ifPresent(v -> p.put("useInheritedMediaQuery", v));
    record(id, "materialAppMaterialApp", p);
    MemorySegment st = MaterialAppObjSt.allocate(arena);
    MaterialAppObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment materialAppRouter(Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<String> title, Optional<Function<BuildContext, String>> onGenerateTitle, Optional<Color> color, Optional<ThemeData> theme, Optional<ThemeData> darkTheme, Optional<ThemeData> highContrastTheme, Optional<ThemeData> highContrastDarkTheme, Optional<ThemeMode> themeMode, Optional<Duration> themeAnimationDuration, Optional<Curve> themeAnimationCurve, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (builder != null) { p.put("builder", nextCallbackId++); }
    title.ifPresent(v -> p.put("title", v));
    if (onGenerateTitle != null) { p.put("onGenerateTitle", nextCallbackId++); }
    color.ifPresent(v -> p.put("color", byId.get(v.getId())));
    theme.ifPresent(v -> p.put("theme", byId.get(v.getId())));
    darkTheme.ifPresent(v -> p.put("darkTheme", byId.get(v.getId())));
    highContrastTheme.ifPresent(v -> p.put("highContrastTheme", byId.get(v.getId())));
    highContrastDarkTheme.ifPresent(v -> p.put("highContrastDarkTheme", byId.get(v.getId())));
    themeMode.ifPresent(v -> p.put("themeMode", v.ordinal()));
    themeAnimationDuration.ifPresent(v -> p.put("themeAnimationDuration", byId.get(v.getId())));
    themeAnimationCurve.ifPresent(v -> p.put("themeAnimationCurve", byId.get(v.getId())));
    debugShowMaterialGrid.ifPresent(v -> p.put("debugShowMaterialGrid", v));
    showPerformanceOverlay.ifPresent(v -> p.put("showPerformanceOverlay", v));
    checkerboardRasterCacheImages.ifPresent(v -> p.put("checkerboardRasterCacheImages", v));
    checkerboardOffscreenLayers.ifPresent(v -> p.put("checkerboardOffscreenLayers", v));
    showSemanticsDebugger.ifPresent(v -> p.put("showSemanticsDebugger", v));
    debugShowCheckedModeBanner.ifPresent(v -> p.put("debugShowCheckedModeBanner", v));
    restorationScopeId.ifPresent(v -> p.put("restorationScopeId", v));
    useInheritedMediaQuery.ifPresent(v -> p.put("useInheritedMediaQuery", v));
    record(id, "materialAppRouter", p);
    MemorySegment st = MaterialAppObjSt.allocate(arena);
    MaterialAppObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment floatingActionButtonFloatingActionButton(Optional<Widget> child, Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> splashColor, Optional<NativeObj> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<Boolean> mini, Optional<ShapeBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> isExtended, Optional<Boolean> enableFeedback) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    tooltip.ifPresent(v -> p.put("tooltip", v));
    foregroundColor.ifPresent(v -> p.put("foregroundColor", byId.get(v.getId())));
    backgroundColor.ifPresent(v -> p.put("backgroundColor", byId.get(v.getId())));
    focusColor.ifPresent(v -> p.put("focusColor", byId.get(v.getId())));
    hoverColor.ifPresent(v -> p.put("hoverColor", byId.get(v.getId())));
    splashColor.ifPresent(v -> p.put("splashColor", byId.get(v.getId())));
    heroTag.ifPresent(v -> p.put("heroTag", byId.get(v.getId())));
    if (elevation.isPresent()) { p.put("elevation", elevation.getAsDouble()); }
    if (focusElevation.isPresent()) { p.put("focusElevation", focusElevation.getAsDouble()); }
    if (hoverElevation.isPresent()) { p.put("hoverElevation", hoverElevation.getAsDouble()); }
    if (highlightElevation.isPresent()) { p.put("highlightElevation", highlightElevation.getAsDouble()); }
    if (disabledElevation.isPresent()) { p.put("disabledElevation", disabledElevation.getAsDouble()); }
    int __cb_onPressed = nextCallbackId++; p.put("onPressed", __cb_onPressed); callbacks.put(__cb_onPressed, onPressed);
    mini.ifPresent(v -> p.put("mini", v));
    shape.ifPresent(v -> p.put("shape", byId.get(v.getId())));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    autofocus.ifPresent(v -> p.put("autofocus", v));
    materialTapTargetSize.ifPresent(v -> p.put("materialTapTargetSize", v.ordinal()));
    isExtended.ifPresent(v -> p.put("isExtended", v));
    enableFeedback.ifPresent(v -> p.put("enableFeedback", v));
    record(id, "floatingActionButtonFloatingActionButton", p);
    MemorySegment st = FloatingActionButtonObjSt.allocate(arena);
    FloatingActionButtonObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment floatingActionButtonSmall(Optional<Widget> child, Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> splashColor, Optional<NativeObj> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<ShapeBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> enableFeedback) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    tooltip.ifPresent(v -> p.put("tooltip", v));
    foregroundColor.ifPresent(v -> p.put("foregroundColor", byId.get(v.getId())));
    backgroundColor.ifPresent(v -> p.put("backgroundColor", byId.get(v.getId())));
    focusColor.ifPresent(v -> p.put("focusColor", byId.get(v.getId())));
    hoverColor.ifPresent(v -> p.put("hoverColor", byId.get(v.getId())));
    splashColor.ifPresent(v -> p.put("splashColor", byId.get(v.getId())));
    heroTag.ifPresent(v -> p.put("heroTag", byId.get(v.getId())));
    if (elevation.isPresent()) { p.put("elevation", elevation.getAsDouble()); }
    if (focusElevation.isPresent()) { p.put("focusElevation", focusElevation.getAsDouble()); }
    if (hoverElevation.isPresent()) { p.put("hoverElevation", hoverElevation.getAsDouble()); }
    if (highlightElevation.isPresent()) { p.put("highlightElevation", highlightElevation.getAsDouble()); }
    if (disabledElevation.isPresent()) { p.put("disabledElevation", disabledElevation.getAsDouble()); }
    int __cb_onPressed = nextCallbackId++; p.put("onPressed", __cb_onPressed); callbacks.put(__cb_onPressed, onPressed);
    shape.ifPresent(v -> p.put("shape", byId.get(v.getId())));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    autofocus.ifPresent(v -> p.put("autofocus", v));
    materialTapTargetSize.ifPresent(v -> p.put("materialTapTargetSize", v.ordinal()));
    enableFeedback.ifPresent(v -> p.put("enableFeedback", v));
    record(id, "floatingActionButtonSmall", p);
    MemorySegment st = FloatingActionButtonObjSt.allocate(arena);
    FloatingActionButtonObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment floatingActionButtonLarge(Optional<Widget> child, Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> splashColor, Optional<NativeObj> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<ShapeBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> enableFeedback) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    tooltip.ifPresent(v -> p.put("tooltip", v));
    foregroundColor.ifPresent(v -> p.put("foregroundColor", byId.get(v.getId())));
    backgroundColor.ifPresent(v -> p.put("backgroundColor", byId.get(v.getId())));
    focusColor.ifPresent(v -> p.put("focusColor", byId.get(v.getId())));
    hoverColor.ifPresent(v -> p.put("hoverColor", byId.get(v.getId())));
    splashColor.ifPresent(v -> p.put("splashColor", byId.get(v.getId())));
    heroTag.ifPresent(v -> p.put("heroTag", byId.get(v.getId())));
    if (elevation.isPresent()) { p.put("elevation", elevation.getAsDouble()); }
    if (focusElevation.isPresent()) { p.put("focusElevation", focusElevation.getAsDouble()); }
    if (hoverElevation.isPresent()) { p.put("hoverElevation", hoverElevation.getAsDouble()); }
    if (highlightElevation.isPresent()) { p.put("highlightElevation", highlightElevation.getAsDouble()); }
    if (disabledElevation.isPresent()) { p.put("disabledElevation", disabledElevation.getAsDouble()); }
    int __cb_onPressed = nextCallbackId++; p.put("onPressed", __cb_onPressed); callbacks.put(__cb_onPressed, onPressed);
    shape.ifPresent(v -> p.put("shape", byId.get(v.getId())));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    autofocus.ifPresent(v -> p.put("autofocus", v));
    materialTapTargetSize.ifPresent(v -> p.put("materialTapTargetSize", v.ordinal()));
    enableFeedback.ifPresent(v -> p.put("enableFeedback", v));
    record(id, "floatingActionButtonLarge", p);
    MemorySegment st = FloatingActionButtonObjSt.allocate(arena);
    FloatingActionButtonObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment floatingActionButtonExtended(Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<NativeObj> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, Optional<Color> splashColor, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<ShapeBorder> shape, Optional<Boolean> isExtended, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, OptionalDouble extendedIconLabelSpacing, Optional<EdgeInsetsGeometry> extendedPadding, Optional<TextStyle> extendedTextStyle, Optional<Widget> icon, Widget label, Optional<Boolean> enableFeedback) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    tooltip.ifPresent(v -> p.put("tooltip", v));
    foregroundColor.ifPresent(v -> p.put("foregroundColor", byId.get(v.getId())));
    backgroundColor.ifPresent(v -> p.put("backgroundColor", byId.get(v.getId())));
    focusColor.ifPresent(v -> p.put("focusColor", byId.get(v.getId())));
    hoverColor.ifPresent(v -> p.put("hoverColor", byId.get(v.getId())));
    heroTag.ifPresent(v -> p.put("heroTag", byId.get(v.getId())));
    if (elevation.isPresent()) { p.put("elevation", elevation.getAsDouble()); }
    if (focusElevation.isPresent()) { p.put("focusElevation", focusElevation.getAsDouble()); }
    if (hoverElevation.isPresent()) { p.put("hoverElevation", hoverElevation.getAsDouble()); }
    splashColor.ifPresent(v -> p.put("splashColor", byId.get(v.getId())));
    if (highlightElevation.isPresent()) { p.put("highlightElevation", highlightElevation.getAsDouble()); }
    if (disabledElevation.isPresent()) { p.put("disabledElevation", disabledElevation.getAsDouble()); }
    int __cb_onPressed = nextCallbackId++; p.put("onPressed", __cb_onPressed); callbacks.put(__cb_onPressed, onPressed);
    shape.ifPresent(v -> p.put("shape", byId.get(v.getId())));
    isExtended.ifPresent(v -> p.put("isExtended", v));
    materialTapTargetSize.ifPresent(v -> p.put("materialTapTargetSize", v.ordinal()));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    autofocus.ifPresent(v -> p.put("autofocus", v));
    if (extendedIconLabelSpacing.isPresent()) { p.put("extendedIconLabelSpacing", extendedIconLabelSpacing.getAsDouble()); }
    extendedPadding.ifPresent(v -> p.put("extendedPadding", byId.get(v.getId())));
    extendedTextStyle.ifPresent(v -> p.put("extendedTextStyle", byId.get(v.getId())));
    icon.ifPresent(v -> p.put("icon", byId.get(v.getId())));
    p.put("label", byId.get(label.getId()));
    enableFeedback.ifPresent(v -> p.put("enableFeedback", v));
    record(id, "floatingActionButtonExtended", p);
    MemorySegment st = FloatingActionButtonObjSt.allocate(arena);
    FloatingActionButtonObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment themeTheme(ThemeData data, Widget child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("data", byId.get(data.getId()));
    p.put("child", byId.get(child.getId()));
    record(id, "themeTheme", p);
    MemorySegment st = ThemeObjSt.allocate(arena);
    ThemeObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment themeOf(BuildContext context) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("context", byId.get(context.getId()));
    record(id, "themeOf", p);
    MemorySegment st = ThemeDataObjSt.allocate(arena);
    ThemeDataObjSt.id(st, id);
    return st;
  }
  @Override
  int themeBrightnessOf(BuildContext context) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("context", byId.get(context.getId()));
    record(id, "themeBrightnessOf", p);
    return id;
  }
  @Override
  int themeMaybeBrightnessOf(BuildContext context) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("context", byId.get(context.getId()));
    record(id, "themeMaybeBrightnessOf", p);
    return id;
  }

  @Override
  MemorySegment elevatedButtonElevatedButton(Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Widget child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    int __cb_onPressed = nextCallbackId++; p.put("onPressed", __cb_onPressed); callbacks.put(__cb_onPressed, onPressed);
    if (onLongPress.isPresent()) { int __cb_onLongPress = nextCallbackId++; p.put("onLongPress", __cb_onLongPress); callbacks.put(__cb_onLongPress, onLongPress.get()); }
    if (onHover.isPresent()) { int __cb_onHover = nextCallbackId++; p.put("onHover", __cb_onHover); java.util.function.Consumer<Boolean> __h_onHover = onHover.get(); callbacks.put(__cb_onHover, (java.util.function.Consumer<Object>)(v -> __h_onHover.accept((Boolean) v))); }
    if (onFocusChange.isPresent()) { int __cb_onFocusChange = nextCallbackId++; p.put("onFocusChange", __cb_onFocusChange); java.util.function.Consumer<Boolean> __h_onFocusChange = onFocusChange.get(); callbacks.put(__cb_onFocusChange, (java.util.function.Consumer<Object>)(v -> __h_onFocusChange.accept((Boolean) v))); }
    autofocus.ifPresent(v -> p.put("autofocus", v));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    p.put("child", byId.get(child.getId()));
    record(id, "elevatedButtonElevatedButton", p);
    MemorySegment st = ElevatedButtonObjSt.allocate(arena);
    ElevatedButtonObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment elevatedButtonIcon(Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> icon, Widget label, Optional<IconAlignment> iconAlignment) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    int __cb_onPressed = nextCallbackId++; p.put("onPressed", __cb_onPressed); callbacks.put(__cb_onPressed, onPressed);
    if (onLongPress.isPresent()) { int __cb_onLongPress = nextCallbackId++; p.put("onLongPress", __cb_onLongPress); callbacks.put(__cb_onLongPress, onLongPress.get()); }
    if (onHover.isPresent()) { int __cb_onHover = nextCallbackId++; p.put("onHover", __cb_onHover); java.util.function.Consumer<Boolean> __h_onHover = onHover.get(); callbacks.put(__cb_onHover, (java.util.function.Consumer<Object>)(v -> __h_onHover.accept((Boolean) v))); }
    if (onFocusChange.isPresent()) { int __cb_onFocusChange = nextCallbackId++; p.put("onFocusChange", __cb_onFocusChange); java.util.function.Consumer<Boolean> __h_onFocusChange = onFocusChange.get(); callbacks.put(__cb_onFocusChange, (java.util.function.Consumer<Object>)(v -> __h_onFocusChange.accept((Boolean) v))); }
    autofocus.ifPresent(v -> p.put("autofocus", v));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    icon.ifPresent(v -> p.put("icon", byId.get(v.getId())));
    p.put("label", byId.get(label.getId()));
    iconAlignment.ifPresent(v -> p.put("iconAlignment", v.ordinal()));
    record(id, "elevatedButtonIcon", p);
    MemorySegment st = ElevatedButtonObjSt.allocate(arena);
    ElevatedButtonObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment outlinedButtonOutlinedButton(Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Widget child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    int __cb_onPressed = nextCallbackId++; p.put("onPressed", __cb_onPressed); callbacks.put(__cb_onPressed, onPressed);
    if (onLongPress.isPresent()) { int __cb_onLongPress = nextCallbackId++; p.put("onLongPress", __cb_onLongPress); callbacks.put(__cb_onLongPress, onLongPress.get()); }
    if (onHover.isPresent()) { int __cb_onHover = nextCallbackId++; p.put("onHover", __cb_onHover); java.util.function.Consumer<Boolean> __h_onHover = onHover.get(); callbacks.put(__cb_onHover, (java.util.function.Consumer<Object>)(v -> __h_onHover.accept((Boolean) v))); }
    if (onFocusChange.isPresent()) { int __cb_onFocusChange = nextCallbackId++; p.put("onFocusChange", __cb_onFocusChange); java.util.function.Consumer<Boolean> __h_onFocusChange = onFocusChange.get(); callbacks.put(__cb_onFocusChange, (java.util.function.Consumer<Object>)(v -> __h_onFocusChange.accept((Boolean) v))); }
    autofocus.ifPresent(v -> p.put("autofocus", v));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    p.put("child", byId.get(child.getId()));
    record(id, "outlinedButtonOutlinedButton", p);
    MemorySegment st = OutlinedButtonObjSt.allocate(arena);
    OutlinedButtonObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment outlinedButtonIcon(Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> icon, Widget label, Optional<IconAlignment> iconAlignment) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    int __cb_onPressed = nextCallbackId++; p.put("onPressed", __cb_onPressed); callbacks.put(__cb_onPressed, onPressed);
    if (onLongPress.isPresent()) { int __cb_onLongPress = nextCallbackId++; p.put("onLongPress", __cb_onLongPress); callbacks.put(__cb_onLongPress, onLongPress.get()); }
    if (onHover.isPresent()) { int __cb_onHover = nextCallbackId++; p.put("onHover", __cb_onHover); java.util.function.Consumer<Boolean> __h_onHover = onHover.get(); callbacks.put(__cb_onHover, (java.util.function.Consumer<Object>)(v -> __h_onHover.accept((Boolean) v))); }
    if (onFocusChange.isPresent()) { int __cb_onFocusChange = nextCallbackId++; p.put("onFocusChange", __cb_onFocusChange); java.util.function.Consumer<Boolean> __h_onFocusChange = onFocusChange.get(); callbacks.put(__cb_onFocusChange, (java.util.function.Consumer<Object>)(v -> __h_onFocusChange.accept((Boolean) v))); }
    autofocus.ifPresent(v -> p.put("autofocus", v));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    icon.ifPresent(v -> p.put("icon", byId.get(v.getId())));
    p.put("label", byId.get(label.getId()));
    iconAlignment.ifPresent(v -> p.put("iconAlignment", v.ordinal()));
    record(id, "outlinedButtonIcon", p);
    MemorySegment st = OutlinedButtonObjSt.allocate(arena);
    OutlinedButtonObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment textButtonTextButton(Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Boolean> isSemanticButton, Widget child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    int __cb_onPressed = nextCallbackId++; p.put("onPressed", __cb_onPressed); callbacks.put(__cb_onPressed, onPressed);
    if (onLongPress.isPresent()) { int __cb_onLongPress = nextCallbackId++; p.put("onLongPress", __cb_onLongPress); callbacks.put(__cb_onLongPress, onLongPress.get()); }
    if (onHover.isPresent()) { int __cb_onHover = nextCallbackId++; p.put("onHover", __cb_onHover); java.util.function.Consumer<Boolean> __h_onHover = onHover.get(); callbacks.put(__cb_onHover, (java.util.function.Consumer<Object>)(v -> __h_onHover.accept((Boolean) v))); }
    if (onFocusChange.isPresent()) { int __cb_onFocusChange = nextCallbackId++; p.put("onFocusChange", __cb_onFocusChange); java.util.function.Consumer<Boolean> __h_onFocusChange = onFocusChange.get(); callbacks.put(__cb_onFocusChange, (java.util.function.Consumer<Object>)(v -> __h_onFocusChange.accept((Boolean) v))); }
    autofocus.ifPresent(v -> p.put("autofocus", v));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    isSemanticButton.ifPresent(v -> p.put("isSemanticButton", v));
    p.put("child", byId.get(child.getId()));
    record(id, "textButtonTextButton", p);
    MemorySegment st = TextButtonObjSt.allocate(arena);
    TextButtonObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment textButtonIcon(Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> icon, Widget label, Optional<IconAlignment> iconAlignment) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    int __cb_onPressed = nextCallbackId++; p.put("onPressed", __cb_onPressed); callbacks.put(__cb_onPressed, onPressed);
    if (onLongPress.isPresent()) { int __cb_onLongPress = nextCallbackId++; p.put("onLongPress", __cb_onLongPress); callbacks.put(__cb_onLongPress, onLongPress.get()); }
    if (onHover.isPresent()) { int __cb_onHover = nextCallbackId++; p.put("onHover", __cb_onHover); java.util.function.Consumer<Boolean> __h_onHover = onHover.get(); callbacks.put(__cb_onHover, (java.util.function.Consumer<Object>)(v -> __h_onHover.accept((Boolean) v))); }
    if (onFocusChange.isPresent()) { int __cb_onFocusChange = nextCallbackId++; p.put("onFocusChange", __cb_onFocusChange); java.util.function.Consumer<Boolean> __h_onFocusChange = onFocusChange.get(); callbacks.put(__cb_onFocusChange, (java.util.function.Consumer<Object>)(v -> __h_onFocusChange.accept((Boolean) v))); }
    autofocus.ifPresent(v -> p.put("autofocus", v));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    icon.ifPresent(v -> p.put("icon", byId.get(v.getId())));
    p.put("label", byId.get(label.getId()));
    iconAlignment.ifPresent(v -> p.put("iconAlignment", v.ordinal()));
    record(id, "textButtonIcon", p);
    MemorySegment st = TextButtonObjSt.allocate(arena);
    TextButtonObjSt.id(st, id);
    return st;
  }

  @Override
  int navigatorStateNavigatorState() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "navigatorStateNavigatorState", p);
    return id;
  }

  @Override
  MemorySegment navigatorNavigator(Optional<String> initialRoute, Optional<Boolean> reportsRouteUpdateToEngine, Optional<Clip> clipBehavior, Optional<Boolean> requestFocus, Optional<String> restorationScopeId, Optional<TraversalEdgeBehavior> routeTraversalEdgeBehavior, Optional<TraversalEdgeBehavior> routeDirectionalTraversalEdgeBehavior) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    initialRoute.ifPresent(v -> p.put("initialRoute", v));
    reportsRouteUpdateToEngine.ifPresent(v -> p.put("reportsRouteUpdateToEngine", v));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    requestFocus.ifPresent(v -> p.put("requestFocus", v));
    restorationScopeId.ifPresent(v -> p.put("restorationScopeId", v));
    routeTraversalEdgeBehavior.ifPresent(v -> p.put("routeTraversalEdgeBehavior", v.ordinal()));
    routeDirectionalTraversalEdgeBehavior.ifPresent(v -> p.put("routeDirectionalTraversalEdgeBehavior", v.ordinal()));
    record(id, "navigatorNavigator", p);
    MemorySegment st = NavigatorObjSt.allocate(arena);
    NavigatorObjSt.id(st, id);
    return st;
  }
  @Override
  int navigatorPushNamed(BuildContext context, String routeName, Optional<NativeObj> arguments) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("context", byId.get(context.getId()));
    p.put("routeName", routeName);
    arguments.ifPresent(v -> p.put("arguments", byId.get(v.getId())));
    record(id, "navigatorPushNamed", p);
    return id;
  }
  @Override
  <TO extends NativeObj> int navigatorPushReplacementNamed(BuildContext context, String routeName, Optional<TO> result, Optional<NativeObj> arguments) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("context", byId.get(context.getId()));
    p.put("routeName", routeName);
    p.put("result", result);
    arguments.ifPresent(v -> p.put("arguments", byId.get(v.getId())));
    record(id, "navigatorPushReplacementNamed", p);
    return id;
  }
  @Override
  <TO extends NativeObj> int navigatorPopAndPushNamed(BuildContext context, String routeName, Optional<TO> result, Optional<NativeObj> arguments) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("context", byId.get(context.getId()));
    p.put("routeName", routeName);
    p.put("result", result);
    arguments.ifPresent(v -> p.put("arguments", byId.get(v.getId())));
    record(id, "navigatorPopAndPushNamed", p);
    return id;
  }
  @Override
  int navigatorCanPop(BuildContext context) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("context", byId.get(context.getId()));
    record(id, "navigatorCanPop", p);
    return id;
  }
  @Override
  <T extends NativeObj> int navigatorMaybePop(BuildContext context, Optional<T> result) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("context", byId.get(context.getId()));
    p.put("result", result);
    record(id, "navigatorMaybePop", p);
    return id;
  }
  @Override
  int navigatorOf(BuildContext context, Optional<Boolean> rootNavigator) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("context", byId.get(context.getId()));
    rootNavigator.ifPresent(v -> p.put("rootNavigator", v));
    record(id, "navigatorOf", p);
    return id;
  }
  @Override
  int navigatorMaybeOf(BuildContext context, Optional<Boolean> rootNavigator) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("context", byId.get(context.getId()));
    rootNavigator.ifPresent(v -> p.put("rootNavigator", v));
    record(id, "navigatorMaybeOf", p);
    return id;
  }

  @Override
  MemorySegment alertDialogAlertDialog(Optional<Widget> icon, Optional<EdgeInsetsGeometry> iconPadding, Optional<Color> iconColor, Optional<Widget> title, Optional<EdgeInsetsGeometry> titlePadding, Optional<TextStyle> titleTextStyle, Optional<Widget> content, Optional<EdgeInsetsGeometry> contentPadding, Optional<TextStyle> contentTextStyle, Optional<List<Widget>> actions, Optional<EdgeInsetsGeometry> actionsPadding, Optional<MainAxisAlignment> actionsAlignment, Optional<OverflowBarAlignment> actionsOverflowAlignment, Optional<VerticalDirection> actionsOverflowDirection, OptionalDouble actionsOverflowButtonSpacing, Optional<EdgeInsetsGeometry> buttonPadding, Optional<Color> backgroundColor, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<String> semanticLabel, Optional<EdgeInsets> insetPadding, Optional<Clip> clipBehavior, Optional<ShapeBorder> shape, Optional<AlignmentGeometry> alignment, Optional<BoxConstraints> constraints, Optional<Boolean> scrollable) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    icon.ifPresent(v -> p.put("icon", byId.get(v.getId())));
    iconPadding.ifPresent(v -> p.put("iconPadding", byId.get(v.getId())));
    iconColor.ifPresent(v -> p.put("iconColor", byId.get(v.getId())));
    title.ifPresent(v -> p.put("title", byId.get(v.getId())));
    titlePadding.ifPresent(v -> p.put("titlePadding", byId.get(v.getId())));
    titleTextStyle.ifPresent(v -> p.put("titleTextStyle", byId.get(v.getId())));
    content.ifPresent(v -> p.put("content", byId.get(v.getId())));
    contentPadding.ifPresent(v -> p.put("contentPadding", byId.get(v.getId())));
    contentTextStyle.ifPresent(v -> p.put("contentTextStyle", byId.get(v.getId())));
    actions.ifPresent(v -> p.put("actions", v.stream().map(e -> byId.get(e.getId())).collect(java.util.stream.Collectors.toList())));
    actionsPadding.ifPresent(v -> p.put("actionsPadding", byId.get(v.getId())));
    actionsAlignment.ifPresent(v -> p.put("actionsAlignment", v.ordinal()));
    actionsOverflowAlignment.ifPresent(v -> p.put("actionsOverflowAlignment", v.ordinal()));
    actionsOverflowDirection.ifPresent(v -> p.put("actionsOverflowDirection", v.ordinal()));
    if (actionsOverflowButtonSpacing.isPresent()) { p.put("actionsOverflowButtonSpacing", actionsOverflowButtonSpacing.getAsDouble()); }
    buttonPadding.ifPresent(v -> p.put("buttonPadding", byId.get(v.getId())));
    backgroundColor.ifPresent(v -> p.put("backgroundColor", byId.get(v.getId())));
    if (elevation.isPresent()) { p.put("elevation", elevation.getAsDouble()); }
    shadowColor.ifPresent(v -> p.put("shadowColor", byId.get(v.getId())));
    surfaceTintColor.ifPresent(v -> p.put("surfaceTintColor", byId.get(v.getId())));
    semanticLabel.ifPresent(v -> p.put("semanticLabel", v));
    insetPadding.ifPresent(v -> p.put("insetPadding", byId.get(v.getId())));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    shape.ifPresent(v -> p.put("shape", byId.get(v.getId())));
    alignment.ifPresent(v -> p.put("alignment", byId.get(v.getId())));
    constraints.ifPresent(v -> p.put("constraints", byId.get(v.getId())));
    scrollable.ifPresent(v -> p.put("scrollable", v));
    record(id, "alertDialogAlertDialog", p);
    MemorySegment st = AlertDialogObjSt.allocate(arena);
    AlertDialogObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment alertDialogAdaptive(Optional<Widget> icon, Optional<EdgeInsetsGeometry> iconPadding, Optional<Color> iconColor, Optional<Widget> title, Optional<EdgeInsetsGeometry> titlePadding, Optional<TextStyle> titleTextStyle, Optional<Widget> content, Optional<EdgeInsetsGeometry> contentPadding, Optional<TextStyle> contentTextStyle, Optional<List<Widget>> actions, Optional<EdgeInsetsGeometry> actionsPadding, Optional<MainAxisAlignment> actionsAlignment, Optional<OverflowBarAlignment> actionsOverflowAlignment, Optional<VerticalDirection> actionsOverflowDirection, OptionalDouble actionsOverflowButtonSpacing, Optional<EdgeInsetsGeometry> buttonPadding, Optional<Color> backgroundColor, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<String> semanticLabel, Optional<EdgeInsets> insetPadding, Optional<Clip> clipBehavior, Optional<ShapeBorder> shape, Optional<AlignmentGeometry> alignment, Optional<BoxConstraints> constraints, Optional<Boolean> scrollable, Optional<Duration> insetAnimationDuration, Optional<Curve> insetAnimationCurve) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    icon.ifPresent(v -> p.put("icon", byId.get(v.getId())));
    iconPadding.ifPresent(v -> p.put("iconPadding", byId.get(v.getId())));
    iconColor.ifPresent(v -> p.put("iconColor", byId.get(v.getId())));
    title.ifPresent(v -> p.put("title", byId.get(v.getId())));
    titlePadding.ifPresent(v -> p.put("titlePadding", byId.get(v.getId())));
    titleTextStyle.ifPresent(v -> p.put("titleTextStyle", byId.get(v.getId())));
    content.ifPresent(v -> p.put("content", byId.get(v.getId())));
    contentPadding.ifPresent(v -> p.put("contentPadding", byId.get(v.getId())));
    contentTextStyle.ifPresent(v -> p.put("contentTextStyle", byId.get(v.getId())));
    actions.ifPresent(v -> p.put("actions", v.stream().map(e -> byId.get(e.getId())).collect(java.util.stream.Collectors.toList())));
    actionsPadding.ifPresent(v -> p.put("actionsPadding", byId.get(v.getId())));
    actionsAlignment.ifPresent(v -> p.put("actionsAlignment", v.ordinal()));
    actionsOverflowAlignment.ifPresent(v -> p.put("actionsOverflowAlignment", v.ordinal()));
    actionsOverflowDirection.ifPresent(v -> p.put("actionsOverflowDirection", v.ordinal()));
    if (actionsOverflowButtonSpacing.isPresent()) { p.put("actionsOverflowButtonSpacing", actionsOverflowButtonSpacing.getAsDouble()); }
    buttonPadding.ifPresent(v -> p.put("buttonPadding", byId.get(v.getId())));
    backgroundColor.ifPresent(v -> p.put("backgroundColor", byId.get(v.getId())));
    if (elevation.isPresent()) { p.put("elevation", elevation.getAsDouble()); }
    shadowColor.ifPresent(v -> p.put("shadowColor", byId.get(v.getId())));
    surfaceTintColor.ifPresent(v -> p.put("surfaceTintColor", byId.get(v.getId())));
    semanticLabel.ifPresent(v -> p.put("semanticLabel", v));
    insetPadding.ifPresent(v -> p.put("insetPadding", byId.get(v.getId())));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    shape.ifPresent(v -> p.put("shape", byId.get(v.getId())));
    alignment.ifPresent(v -> p.put("alignment", byId.get(v.getId())));
    constraints.ifPresent(v -> p.put("constraints", byId.get(v.getId())));
    scrollable.ifPresent(v -> p.put("scrollable", v));
    insetAnimationDuration.ifPresent(v -> p.put("insetAnimationDuration", byId.get(v.getId())));
    insetAnimationCurve.ifPresent(v -> p.put("insetAnimationCurve", byId.get(v.getId())));
    record(id, "alertDialogAdaptive", p);
    MemorySegment st = AlertDialogObjSt.allocate(arena);
    AlertDialogObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment inputDecorationInputDecoration(Optional<Widget> icon, Optional<Color> iconColor, Optional<Widget> label, Optional<String> labelText, Optional<TextStyle> labelStyle, Optional<TextStyle> floatingLabelStyle, Optional<Widget> helper, Optional<String> helperText, Optional<TextStyle> helperStyle, OptionalInt helperMaxLines, Optional<String> hintText, Optional<Widget> hint, Optional<TextStyle> hintStyle, Optional<TextDirection> hintTextDirection, OptionalInt hintMaxLines, Optional<Duration> hintFadeDuration, Optional<Boolean> maintainHintHeight, Optional<Boolean> maintainHintSize, Optional<Widget> error, Optional<String> errorText, Optional<TextStyle> errorStyle, OptionalInt errorMaxLines, Optional<FloatingLabelBehavior> floatingLabelBehavior, Optional<Boolean> isCollapsed, Optional<Boolean> isDense, Optional<EdgeInsetsGeometry> contentPadding, Optional<Widget> prefixIcon, Optional<BoxConstraints> prefixIconConstraints, Optional<Widget> prefix, Optional<String> prefixText, Optional<TextStyle> prefixStyle, Optional<Color> prefixIconColor, Optional<Widget> suffixIcon, Optional<Widget> suffix, Optional<String> suffixText, Optional<TextStyle> suffixStyle, Optional<Color> suffixIconColor, Optional<BoxConstraints> suffixIconConstraints, Optional<Widget> counter, Optional<String> counterText, Optional<TextStyle> counterStyle, Optional<Boolean> filled, Optional<Color> fillColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<InputBorder> errorBorder, Optional<InputBorder> focusedBorder, Optional<InputBorder> focusedErrorBorder, Optional<InputBorder> disabledBorder, Optional<InputBorder> enabledBorder, Optional<InputBorder> border, Optional<Boolean> enabled, Optional<String> semanticCounterText, Optional<Boolean> alignLabelWithHint, Optional<BoxConstraints> constraints, Optional<VisualDensity> visualDensity) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    icon.ifPresent(v -> p.put("icon", byId.get(v.getId())));
    iconColor.ifPresent(v -> p.put("iconColor", byId.get(v.getId())));
    label.ifPresent(v -> p.put("label", byId.get(v.getId())));
    labelText.ifPresent(v -> p.put("labelText", v));
    labelStyle.ifPresent(v -> p.put("labelStyle", byId.get(v.getId())));
    floatingLabelStyle.ifPresent(v -> p.put("floatingLabelStyle", byId.get(v.getId())));
    helper.ifPresent(v -> p.put("helper", byId.get(v.getId())));
    helperText.ifPresent(v -> p.put("helperText", v));
    helperStyle.ifPresent(v -> p.put("helperStyle", byId.get(v.getId())));
    if (helperMaxLines.isPresent()) { p.put("helperMaxLines", helperMaxLines.getAsInt()); }
    hintText.ifPresent(v -> p.put("hintText", v));
    hint.ifPresent(v -> p.put("hint", byId.get(v.getId())));
    hintStyle.ifPresent(v -> p.put("hintStyle", byId.get(v.getId())));
    hintTextDirection.ifPresent(v -> p.put("hintTextDirection", v.ordinal()));
    if (hintMaxLines.isPresent()) { p.put("hintMaxLines", hintMaxLines.getAsInt()); }
    hintFadeDuration.ifPresent(v -> p.put("hintFadeDuration", byId.get(v.getId())));
    maintainHintHeight.ifPresent(v -> p.put("maintainHintHeight", v));
    maintainHintSize.ifPresent(v -> p.put("maintainHintSize", v));
    error.ifPresent(v -> p.put("error", byId.get(v.getId())));
    errorText.ifPresent(v -> p.put("errorText", v));
    errorStyle.ifPresent(v -> p.put("errorStyle", byId.get(v.getId())));
    if (errorMaxLines.isPresent()) { p.put("errorMaxLines", errorMaxLines.getAsInt()); }
    floatingLabelBehavior.ifPresent(v -> p.put("floatingLabelBehavior", v.ordinal()));
    isCollapsed.ifPresent(v -> p.put("isCollapsed", v));
    isDense.ifPresent(v -> p.put("isDense", v));
    contentPadding.ifPresent(v -> p.put("contentPadding", byId.get(v.getId())));
    prefixIcon.ifPresent(v -> p.put("prefixIcon", byId.get(v.getId())));
    prefixIconConstraints.ifPresent(v -> p.put("prefixIconConstraints", byId.get(v.getId())));
    prefix.ifPresent(v -> p.put("prefix", byId.get(v.getId())));
    prefixText.ifPresent(v -> p.put("prefixText", v));
    prefixStyle.ifPresent(v -> p.put("prefixStyle", byId.get(v.getId())));
    prefixIconColor.ifPresent(v -> p.put("prefixIconColor", byId.get(v.getId())));
    suffixIcon.ifPresent(v -> p.put("suffixIcon", byId.get(v.getId())));
    suffix.ifPresent(v -> p.put("suffix", byId.get(v.getId())));
    suffixText.ifPresent(v -> p.put("suffixText", v));
    suffixStyle.ifPresent(v -> p.put("suffixStyle", byId.get(v.getId())));
    suffixIconColor.ifPresent(v -> p.put("suffixIconColor", byId.get(v.getId())));
    suffixIconConstraints.ifPresent(v -> p.put("suffixIconConstraints", byId.get(v.getId())));
    counter.ifPresent(v -> p.put("counter", byId.get(v.getId())));
    counterText.ifPresent(v -> p.put("counterText", v));
    counterStyle.ifPresent(v -> p.put("counterStyle", byId.get(v.getId())));
    filled.ifPresent(v -> p.put("filled", v));
    fillColor.ifPresent(v -> p.put("fillColor", byId.get(v.getId())));
    focusColor.ifPresent(v -> p.put("focusColor", byId.get(v.getId())));
    hoverColor.ifPresent(v -> p.put("hoverColor", byId.get(v.getId())));
    errorBorder.ifPresent(v -> p.put("errorBorder", byId.get(v.getId())));
    focusedBorder.ifPresent(v -> p.put("focusedBorder", byId.get(v.getId())));
    focusedErrorBorder.ifPresent(v -> p.put("focusedErrorBorder", byId.get(v.getId())));
    disabledBorder.ifPresent(v -> p.put("disabledBorder", byId.get(v.getId())));
    enabledBorder.ifPresent(v -> p.put("enabledBorder", byId.get(v.getId())));
    border.ifPresent(v -> p.put("border", byId.get(v.getId())));
    enabled.ifPresent(v -> p.put("enabled", v));
    semanticCounterText.ifPresent(v -> p.put("semanticCounterText", v));
    alignLabelWithHint.ifPresent(v -> p.put("alignLabelWithHint", v));
    constraints.ifPresent(v -> p.put("constraints", byId.get(v.getId())));
    visualDensity.ifPresent(v -> p.put("visualDensity", byId.get(v.getId())));
    record(id, "inputDecorationInputDecoration", p);
    MemorySegment st = InputDecorationObjSt.allocate(arena);
    InputDecorationObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment inputDecorationCollapsed(String hintText, Optional<FloatingLabelBehavior> floatingLabelBehavior, Optional<TextStyle> hintStyle, Optional<Widget> hint, Optional<TextDirection> hintTextDirection, OptionalInt hintMaxLines, Optional<Duration> hintFadeDuration, Optional<Boolean> maintainHintHeight, Optional<Boolean> maintainHintSize, Optional<Boolean> filled, Optional<Color> fillColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<InputBorder> border, Optional<Boolean> enabled, Optional<BoxConstraints> constraints) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("hintText", hintText);
    floatingLabelBehavior.ifPresent(v -> p.put("floatingLabelBehavior", v.ordinal()));
    hintStyle.ifPresent(v -> p.put("hintStyle", byId.get(v.getId())));
    hint.ifPresent(v -> p.put("hint", byId.get(v.getId())));
    hintTextDirection.ifPresent(v -> p.put("hintTextDirection", v.ordinal()));
    if (hintMaxLines.isPresent()) { p.put("hintMaxLines", hintMaxLines.getAsInt()); }
    hintFadeDuration.ifPresent(v -> p.put("hintFadeDuration", byId.get(v.getId())));
    maintainHintHeight.ifPresent(v -> p.put("maintainHintHeight", v));
    maintainHintSize.ifPresent(v -> p.put("maintainHintSize", v));
    filled.ifPresent(v -> p.put("filled", v));
    fillColor.ifPresent(v -> p.put("fillColor", byId.get(v.getId())));
    focusColor.ifPresent(v -> p.put("focusColor", byId.get(v.getId())));
    hoverColor.ifPresent(v -> p.put("hoverColor", byId.get(v.getId())));
    border.ifPresent(v -> p.put("border", byId.get(v.getId())));
    enabled.ifPresent(v -> p.put("enabled", v));
    constraints.ifPresent(v -> p.put("constraints", byId.get(v.getId())));
    record(id, "inputDecorationCollapsed", p);
    MemorySegment st = InputDecorationObjSt.allocate(arena);
    InputDecorationObjSt.id(st, id);
    return st;
  }

  @Override
  int inputBorderNone() {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    record(id, "inputBorderNone", p);
    return id;
  }

  @Override
  MemorySegment textFieldTextField(Optional<NativeObj> groupId, Optional<InputDecoration> decoration, Optional<TextInputAction> textInputAction, Optional<TextCapitalization> textCapitalization, Optional<TextStyle> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> readOnly, Optional<Boolean> showCursor, Optional<Boolean> autofocus, Optional<String> obscuringCharacter, Optional<Boolean> obscureText, Optional<Boolean> autocorrect, Optional<SmartDashesType> smartDashesType, Optional<SmartQuotesType> smartQuotesType, Optional<Boolean> enableSuggestions, OptionalInt maxLines, OptionalInt minLines, Optional<Boolean> expands, OptionalInt maxLength, Optional<MaxLengthEnforcement> maxLengthEnforcement, Optional<Consumer<String>> onChanged, Optional<Runnable> onEditingComplete, Optional<Consumer<String>> onSubmitted, Optional<Boolean> enabled, Optional<Boolean> ignorePointers, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<Radius> cursorRadius, Optional<Boolean> cursorOpacityAnimates, Optional<Color> cursorColor, Optional<Color> cursorErrorColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<Brightness> keyboardAppearance, Optional<EdgeInsets> scrollPadding, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Boolean> selectAllOnFocus, Optional<Runnable> onTap, Optional<Boolean> onTapAlwaysCalled, Optional<QuadFunction<BuildContext, Integer, Boolean, Integer, Widget>> buildCounter, Optional<Clip> clipBehavior, Optional<String> restorationId, Optional<Boolean> scribbleEnabled, Optional<Boolean> stylusHandwritingEnabled, Optional<Boolean> enableIMEPersonalizedLearning, Optional<Boolean> canRequestFocus) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    groupId.ifPresent(v -> p.put("groupId", byId.get(v.getId())));
    decoration.ifPresent(v -> p.put("decoration", byId.get(v.getId())));
    textInputAction.ifPresent(v -> p.put("textInputAction", v.ordinal()));
    textCapitalization.ifPresent(v -> p.put("textCapitalization", v.ordinal()));
    style.ifPresent(v -> p.put("style", byId.get(v.getId())));
    textAlign.ifPresent(v -> p.put("textAlign", v.ordinal()));
    textDirection.ifPresent(v -> p.put("textDirection", v.ordinal()));
    readOnly.ifPresent(v -> p.put("readOnly", v));
    showCursor.ifPresent(v -> p.put("showCursor", v));
    autofocus.ifPresent(v -> p.put("autofocus", v));
    obscuringCharacter.ifPresent(v -> p.put("obscuringCharacter", v));
    obscureText.ifPresent(v -> p.put("obscureText", v));
    autocorrect.ifPresent(v -> p.put("autocorrect", v));
    smartDashesType.ifPresent(v -> p.put("smartDashesType", v.ordinal()));
    smartQuotesType.ifPresent(v -> p.put("smartQuotesType", v.ordinal()));
    enableSuggestions.ifPresent(v -> p.put("enableSuggestions", v));
    if (maxLines.isPresent()) { p.put("maxLines", maxLines.getAsInt()); }
    if (minLines.isPresent()) { p.put("minLines", minLines.getAsInt()); }
    expands.ifPresent(v -> p.put("expands", v));
    if (maxLength.isPresent()) { p.put("maxLength", maxLength.getAsInt()); }
    maxLengthEnforcement.ifPresent(v -> p.put("maxLengthEnforcement", v.ordinal()));
    if (onChanged.isPresent()) { int __cb_onChanged = nextCallbackId++; p.put("onChanged", __cb_onChanged); java.util.function.Consumer<String> __h_onChanged = onChanged.get(); callbacks.put(__cb_onChanged, (java.util.function.Consumer<Object>)(v -> __h_onChanged.accept((String) v))); }
    if (onEditingComplete.isPresent()) { int __cb_onEditingComplete = nextCallbackId++; p.put("onEditingComplete", __cb_onEditingComplete); callbacks.put(__cb_onEditingComplete, onEditingComplete.get()); }
    if (onSubmitted.isPresent()) { int __cb_onSubmitted = nextCallbackId++; p.put("onSubmitted", __cb_onSubmitted); java.util.function.Consumer<String> __h_onSubmitted = onSubmitted.get(); callbacks.put(__cb_onSubmitted, (java.util.function.Consumer<Object>)(v -> __h_onSubmitted.accept((String) v))); }
    enabled.ifPresent(v -> p.put("enabled", v));
    ignorePointers.ifPresent(v -> p.put("ignorePointers", v));
    if (cursorWidth.isPresent()) { p.put("cursorWidth", cursorWidth.getAsDouble()); }
    if (cursorHeight.isPresent()) { p.put("cursorHeight", cursorHeight.getAsDouble()); }
    cursorRadius.ifPresent(v -> p.put("cursorRadius", byId.get(v.getId())));
    cursorOpacityAnimates.ifPresent(v -> p.put("cursorOpacityAnimates", v));
    cursorColor.ifPresent(v -> p.put("cursorColor", byId.get(v.getId())));
    cursorErrorColor.ifPresent(v -> p.put("cursorErrorColor", byId.get(v.getId())));
    selectionHeightStyle.ifPresent(v -> p.put("selectionHeightStyle", v.ordinal()));
    selectionWidthStyle.ifPresent(v -> p.put("selectionWidthStyle", v.ordinal()));
    keyboardAppearance.ifPresent(v -> p.put("keyboardAppearance", v.ordinal()));
    scrollPadding.ifPresent(v -> p.put("scrollPadding", byId.get(v.getId())));
    dragStartBehavior.ifPresent(v -> p.put("dragStartBehavior", v.ordinal()));
    enableInteractiveSelection.ifPresent(v -> p.put("enableInteractiveSelection", v));
    selectAllOnFocus.ifPresent(v -> p.put("selectAllOnFocus", v));
    if (onTap.isPresent()) { int __cb_onTap = nextCallbackId++; p.put("onTap", __cb_onTap); callbacks.put(__cb_onTap, onTap.get()); }
    onTapAlwaysCalled.ifPresent(v -> p.put("onTapAlwaysCalled", v));
    if (buildCounter != null) { p.put("buildCounter", nextCallbackId++); }
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    restorationId.ifPresent(v -> p.put("restorationId", v));
    scribbleEnabled.ifPresent(v -> p.put("scribbleEnabled", v));
    stylusHandwritingEnabled.ifPresent(v -> p.put("stylusHandwritingEnabled", v));
    enableIMEPersonalizedLearning.ifPresent(v -> p.put("enableIMEPersonalizedLearning", v));
    canRequestFocus.ifPresent(v -> p.put("canRequestFocus", v));
    record(id, "textFieldTextField", p);
    MemorySegment st = TextFieldObjSt.allocate(arena);
    TextFieldObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment dividerDivider(OptionalDouble height, OptionalDouble thickness, OptionalDouble indent, OptionalDouble endIndent, Optional<Color> color, Optional<BorderRadiusGeometry> radius) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (height.isPresent()) { p.put("height", height.getAsDouble()); }
    if (thickness.isPresent()) { p.put("thickness", thickness.getAsDouble()); }
    if (indent.isPresent()) { p.put("indent", indent.getAsDouble()); }
    if (endIndent.isPresent()) { p.put("endIndent", endIndent.getAsDouble()); }
    color.ifPresent(v -> p.put("color", byId.get(v.getId())));
    radius.ifPresent(v -> p.put("radius", byId.get(v.getId())));
    record(id, "dividerDivider", p);
    MemorySegment st = DividerObjSt.allocate(arena);
    DividerObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment dividerCreateBorderSide(BuildContext context, Optional<Color> color, OptionalDouble width) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("context", byId.get(context.getId()));
    color.ifPresent(v -> p.put("color", byId.get(v.getId())));
    if (width.isPresent()) { p.put("width", width.getAsDouble()); }
    record(id, "dividerCreateBorderSide", p);
    MemorySegment st = BorderSideObjSt.allocate(arena);
    BorderSideObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment filledButtonFilledButton(Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Widget child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    int __cb_onPressed = nextCallbackId++; p.put("onPressed", __cb_onPressed); callbacks.put(__cb_onPressed, onPressed);
    if (onLongPress.isPresent()) { int __cb_onLongPress = nextCallbackId++; p.put("onLongPress", __cb_onLongPress); callbacks.put(__cb_onLongPress, onLongPress.get()); }
    if (onHover.isPresent()) { int __cb_onHover = nextCallbackId++; p.put("onHover", __cb_onHover); java.util.function.Consumer<Boolean> __h_onHover = onHover.get(); callbacks.put(__cb_onHover, (java.util.function.Consumer<Object>)(v -> __h_onHover.accept((Boolean) v))); }
    if (onFocusChange.isPresent()) { int __cb_onFocusChange = nextCallbackId++; p.put("onFocusChange", __cb_onFocusChange); java.util.function.Consumer<Boolean> __h_onFocusChange = onFocusChange.get(); callbacks.put(__cb_onFocusChange, (java.util.function.Consumer<Object>)(v -> __h_onFocusChange.accept((Boolean) v))); }
    autofocus.ifPresent(v -> p.put("autofocus", v));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    p.put("child", byId.get(child.getId()));
    record(id, "filledButtonFilledButton", p);
    MemorySegment st = FilledButtonObjSt.allocate(arena);
    FilledButtonObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment filledButtonIcon(Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> icon, Widget label, Optional<IconAlignment> iconAlignment) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    int __cb_onPressed = nextCallbackId++; p.put("onPressed", __cb_onPressed); callbacks.put(__cb_onPressed, onPressed);
    if (onLongPress.isPresent()) { int __cb_onLongPress = nextCallbackId++; p.put("onLongPress", __cb_onLongPress); callbacks.put(__cb_onLongPress, onLongPress.get()); }
    if (onHover.isPresent()) { int __cb_onHover = nextCallbackId++; p.put("onHover", __cb_onHover); java.util.function.Consumer<Boolean> __h_onHover = onHover.get(); callbacks.put(__cb_onHover, (java.util.function.Consumer<Object>)(v -> __h_onHover.accept((Boolean) v))); }
    if (onFocusChange.isPresent()) { int __cb_onFocusChange = nextCallbackId++; p.put("onFocusChange", __cb_onFocusChange); java.util.function.Consumer<Boolean> __h_onFocusChange = onFocusChange.get(); callbacks.put(__cb_onFocusChange, (java.util.function.Consumer<Object>)(v -> __h_onFocusChange.accept((Boolean) v))); }
    autofocus.ifPresent(v -> p.put("autofocus", v));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    icon.ifPresent(v -> p.put("icon", byId.get(v.getId())));
    p.put("label", byId.get(label.getId()));
    iconAlignment.ifPresent(v -> p.put("iconAlignment", v.ordinal()));
    record(id, "filledButtonIcon", p);
    MemorySegment st = FilledButtonObjSt.allocate(arena);
    FilledButtonObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment filledButtonTonal(Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Widget child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    int __cb_onPressed = nextCallbackId++; p.put("onPressed", __cb_onPressed); callbacks.put(__cb_onPressed, onPressed);
    if (onLongPress.isPresent()) { int __cb_onLongPress = nextCallbackId++; p.put("onLongPress", __cb_onLongPress); callbacks.put(__cb_onLongPress, onLongPress.get()); }
    if (onHover.isPresent()) { int __cb_onHover = nextCallbackId++; p.put("onHover", __cb_onHover); java.util.function.Consumer<Boolean> __h_onHover = onHover.get(); callbacks.put(__cb_onHover, (java.util.function.Consumer<Object>)(v -> __h_onHover.accept((Boolean) v))); }
    if (onFocusChange.isPresent()) { int __cb_onFocusChange = nextCallbackId++; p.put("onFocusChange", __cb_onFocusChange); java.util.function.Consumer<Boolean> __h_onFocusChange = onFocusChange.get(); callbacks.put(__cb_onFocusChange, (java.util.function.Consumer<Object>)(v -> __h_onFocusChange.accept((Boolean) v))); }
    autofocus.ifPresent(v -> p.put("autofocus", v));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    p.put("child", byId.get(child.getId()));
    record(id, "filledButtonTonal", p);
    MemorySegment st = FilledButtonObjSt.allocate(arena);
    FilledButtonObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment filledButtonTonalIcon(Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> icon, Widget label, Optional<IconAlignment> iconAlignment) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    int __cb_onPressed = nextCallbackId++; p.put("onPressed", __cb_onPressed); callbacks.put(__cb_onPressed, onPressed);
    if (onLongPress.isPresent()) { int __cb_onLongPress = nextCallbackId++; p.put("onLongPress", __cb_onLongPress); callbacks.put(__cb_onLongPress, onLongPress.get()); }
    if (onHover.isPresent()) { int __cb_onHover = nextCallbackId++; p.put("onHover", __cb_onHover); java.util.function.Consumer<Boolean> __h_onHover = onHover.get(); callbacks.put(__cb_onHover, (java.util.function.Consumer<Object>)(v -> __h_onHover.accept((Boolean) v))); }
    if (onFocusChange.isPresent()) { int __cb_onFocusChange = nextCallbackId++; p.put("onFocusChange", __cb_onFocusChange); java.util.function.Consumer<Boolean> __h_onFocusChange = onFocusChange.get(); callbacks.put(__cb_onFocusChange, (java.util.function.Consumer<Object>)(v -> __h_onFocusChange.accept((Boolean) v))); }
    autofocus.ifPresent(v -> p.put("autofocus", v));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    icon.ifPresent(v -> p.put("icon", byId.get(v.getId())));
    p.put("label", byId.get(label.getId()));
    iconAlignment.ifPresent(v -> p.put("iconAlignment", v.ordinal()));
    record(id, "filledButtonTonalIcon", p);
    MemorySegment st = FilledButtonObjSt.allocate(arena);
    FilledButtonObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment outlineInputBorderOutlineInputBorder(Optional<BorderSide> borderSide, Optional<BorderRadius> borderRadius, OptionalDouble gapPadding) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    borderSide.ifPresent(v -> p.put("borderSide", byId.get(v.getId())));
    borderRadius.ifPresent(v -> p.put("borderRadius", byId.get(v.getId())));
    if (gapPadding.isPresent()) { p.put("gapPadding", gapPadding.getAsDouble()); }
    record(id, "outlineInputBorderOutlineInputBorder", p);
    MemorySegment st = OutlineInputBorderObjSt.allocate(arena);
    OutlineInputBorderObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment snackBarActionSnackBarAction(Optional<Color> textColor, Optional<Color> disabledTextColor, Optional<Color> backgroundColor, Optional<Color> disabledBackgroundColor, String label, Runnable onPressed) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    textColor.ifPresent(v -> p.put("textColor", byId.get(v.getId())));
    disabledTextColor.ifPresent(v -> p.put("disabledTextColor", byId.get(v.getId())));
    backgroundColor.ifPresent(v -> p.put("backgroundColor", byId.get(v.getId())));
    disabledBackgroundColor.ifPresent(v -> p.put("disabledBackgroundColor", byId.get(v.getId())));
    p.put("label", label);
    int __cb_onPressed = nextCallbackId++; p.put("onPressed", __cb_onPressed); callbacks.put(__cb_onPressed, onPressed);
    record(id, "snackBarActionSnackBarAction", p);
    MemorySegment st = SnackBarActionObjSt.allocate(arena);
    SnackBarActionObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment snackBarSnackBar(Widget content, Optional<Color> backgroundColor, OptionalDouble elevation, Optional<EdgeInsetsGeometry> margin, Optional<EdgeInsetsGeometry> padding, OptionalDouble width, Optional<ShapeBorder> shape, Optional<HitTestBehavior> hitTestBehavior, Optional<SnackBarBehavior> behavior, Optional<SnackBarAction> action, OptionalDouble actionOverflowThreshold, Optional<Boolean> showCloseIcon, Optional<Color> closeIconColor, Optional<Duration> duration, Optional<Animation> animation, Optional<Runnable> onVisible, Optional<DismissDirection> dismissDirection, Optional<Clip> clipBehavior) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("content", byId.get(content.getId()));
    backgroundColor.ifPresent(v -> p.put("backgroundColor", byId.get(v.getId())));
    if (elevation.isPresent()) { p.put("elevation", elevation.getAsDouble()); }
    margin.ifPresent(v -> p.put("margin", byId.get(v.getId())));
    padding.ifPresent(v -> p.put("padding", byId.get(v.getId())));
    if (width.isPresent()) { p.put("width", width.getAsDouble()); }
    shape.ifPresent(v -> p.put("shape", byId.get(v.getId())));
    hitTestBehavior.ifPresent(v -> p.put("hitTestBehavior", v.ordinal()));
    behavior.ifPresent(v -> p.put("behavior", v.ordinal()));
    action.ifPresent(v -> p.put("action", byId.get(v.getId())));
    if (actionOverflowThreshold.isPresent()) { p.put("actionOverflowThreshold", actionOverflowThreshold.getAsDouble()); }
    showCloseIcon.ifPresent(v -> p.put("showCloseIcon", v));
    closeIconColor.ifPresent(v -> p.put("closeIconColor", byId.get(v.getId())));
    duration.ifPresent(v -> p.put("duration", byId.get(v.getId())));
    animation.ifPresent(v -> p.put("animation", byId.get(v.getId())));
    if (onVisible.isPresent()) { int __cb_onVisible = nextCallbackId++; p.put("onVisible", __cb_onVisible); callbacks.put(__cb_onVisible, onVisible.get()); }
    dismissDirection.ifPresent(v -> p.put("dismissDirection", v.ordinal()));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    record(id, "snackBarSnackBar", p);
    MemorySegment st = SnackBarObjSt.allocate(arena);
    SnackBarObjSt.id(st, id);
    return st;
  }
  @Override
  int snackBarCreateAnimationController(TickerProvider vsync, Optional<Duration> duration, Optional<Duration> reverseDuration) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("vsync", byId.get(vsync.getId()));
    duration.ifPresent(v -> p.put("duration", byId.get(v.getId())));
    reverseDuration.ifPresent(v -> p.put("reverseDuration", byId.get(v.getId())));
    record(id, "snackBarCreateAnimationController", p);
    return id;
  }

  @Override
  MemorySegment scaffoldMessengerScaffoldMessenger(Widget child) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("child", byId.get(child.getId()));
    record(id, "scaffoldMessengerScaffoldMessenger", p);
    MemorySegment st = ScaffoldMessengerObjSt.allocate(arena);
    ScaffoldMessengerObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment cardCard(Optional<Color> color, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, OptionalDouble elevation, Optional<ShapeBorder> shape, Optional<Boolean> borderOnForeground, Optional<EdgeInsetsGeometry> margin, Optional<Clip> clipBehavior, Optional<Widget> child, Optional<Boolean> semanticContainer) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    color.ifPresent(v -> p.put("color", byId.get(v.getId())));
    shadowColor.ifPresent(v -> p.put("shadowColor", byId.get(v.getId())));
    surfaceTintColor.ifPresent(v -> p.put("surfaceTintColor", byId.get(v.getId())));
    if (elevation.isPresent()) { p.put("elevation", elevation.getAsDouble()); }
    shape.ifPresent(v -> p.put("shape", byId.get(v.getId())));
    borderOnForeground.ifPresent(v -> p.put("borderOnForeground", v));
    margin.ifPresent(v -> p.put("margin", byId.get(v.getId())));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    semanticContainer.ifPresent(v -> p.put("semanticContainer", v));
    record(id, "cardCard", p);
    MemorySegment st = CardObjSt.allocate(arena);
    CardObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment cardFilled(Optional<Color> color, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, OptionalDouble elevation, Optional<ShapeBorder> shape, Optional<Boolean> borderOnForeground, Optional<EdgeInsetsGeometry> margin, Optional<Clip> clipBehavior, Optional<Widget> child, Optional<Boolean> semanticContainer) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    color.ifPresent(v -> p.put("color", byId.get(v.getId())));
    shadowColor.ifPresent(v -> p.put("shadowColor", byId.get(v.getId())));
    surfaceTintColor.ifPresent(v -> p.put("surfaceTintColor", byId.get(v.getId())));
    if (elevation.isPresent()) { p.put("elevation", elevation.getAsDouble()); }
    shape.ifPresent(v -> p.put("shape", byId.get(v.getId())));
    borderOnForeground.ifPresent(v -> p.put("borderOnForeground", v));
    margin.ifPresent(v -> p.put("margin", byId.get(v.getId())));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    semanticContainer.ifPresent(v -> p.put("semanticContainer", v));
    record(id, "cardFilled", p);
    MemorySegment st = CardObjSt.allocate(arena);
    CardObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment cardOutlined(Optional<Color> color, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, OptionalDouble elevation, Optional<ShapeBorder> shape, Optional<Boolean> borderOnForeground, Optional<EdgeInsetsGeometry> margin, Optional<Clip> clipBehavior, Optional<Widget> child, Optional<Boolean> semanticContainer) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    color.ifPresent(v -> p.put("color", byId.get(v.getId())));
    shadowColor.ifPresent(v -> p.put("shadowColor", byId.get(v.getId())));
    surfaceTintColor.ifPresent(v -> p.put("surfaceTintColor", byId.get(v.getId())));
    if (elevation.isPresent()) { p.put("elevation", elevation.getAsDouble()); }
    shape.ifPresent(v -> p.put("shape", byId.get(v.getId())));
    borderOnForeground.ifPresent(v -> p.put("borderOnForeground", v));
    margin.ifPresent(v -> p.put("margin", byId.get(v.getId())));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    semanticContainer.ifPresent(v -> p.put("semanticContainer", v));
    record(id, "cardOutlined", p);
    MemorySegment st = CardObjSt.allocate(arena);
    CardObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment chipChip(Optional<Widget> avatar, Widget label, Optional<TextStyle> labelStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Widget> deleteIcon, Optional<Runnable> onDeleted, Optional<Color> deleteIconColor, Optional<String> deleteButtonTooltipMessage, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<Color> backgroundColor, Optional<EdgeInsetsGeometry> padding, Optional<VisualDensity> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<BoxConstraints> avatarBoxConstraints, Optional<BoxConstraints> deleteIconBoxConstraints) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    avatar.ifPresent(v -> p.put("avatar", byId.get(v.getId())));
    p.put("label", byId.get(label.getId()));
    labelStyle.ifPresent(v -> p.put("labelStyle", byId.get(v.getId())));
    labelPadding.ifPresent(v -> p.put("labelPadding", byId.get(v.getId())));
    deleteIcon.ifPresent(v -> p.put("deleteIcon", byId.get(v.getId())));
    if (onDeleted.isPresent()) { int __cb_onDeleted = nextCallbackId++; p.put("onDeleted", __cb_onDeleted); callbacks.put(__cb_onDeleted, onDeleted.get()); }
    deleteIconColor.ifPresent(v -> p.put("deleteIconColor", byId.get(v.getId())));
    deleteButtonTooltipMessage.ifPresent(v -> p.put("deleteButtonTooltipMessage", v));
    side.ifPresent(v -> p.put("side", byId.get(v.getId())));
    shape.ifPresent(v -> p.put("shape", byId.get(v.getId())));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    autofocus.ifPresent(v -> p.put("autofocus", v));
    backgroundColor.ifPresent(v -> p.put("backgroundColor", byId.get(v.getId())));
    padding.ifPresent(v -> p.put("padding", byId.get(v.getId())));
    visualDensity.ifPresent(v -> p.put("visualDensity", byId.get(v.getId())));
    materialTapTargetSize.ifPresent(v -> p.put("materialTapTargetSize", v.ordinal()));
    if (elevation.isPresent()) { p.put("elevation", elevation.getAsDouble()); }
    shadowColor.ifPresent(v -> p.put("shadowColor", byId.get(v.getId())));
    surfaceTintColor.ifPresent(v -> p.put("surfaceTintColor", byId.get(v.getId())));
    avatarBoxConstraints.ifPresent(v -> p.put("avatarBoxConstraints", byId.get(v.getId())));
    deleteIconBoxConstraints.ifPresent(v -> p.put("deleteIconBoxConstraints", byId.get(v.getId())));
    record(id, "chipChip", p);
    MemorySegment st = ChipObjSt.allocate(arena);
    ChipObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment gestureDetectorGestureDetector(Optional<Widget> child, Optional<Runnable> onTap, Optional<Runnable> onTapCancel, Optional<Runnable> onSecondaryTap, Optional<Runnable> onSecondaryTapCancel, Optional<Runnable> onTertiaryTapCancel, Optional<Runnable> onDoubleTap, Optional<Runnable> onDoubleTapCancel, Optional<Runnable> onLongPressCancel, Optional<Runnable> onLongPress, Optional<Runnable> onLongPressUp, Optional<Runnable> onSecondaryLongPressCancel, Optional<Runnable> onSecondaryLongPress, Optional<Runnable> onSecondaryLongPressUp, Optional<Runnable> onTertiaryLongPressCancel, Optional<Runnable> onTertiaryLongPress, Optional<Runnable> onTertiaryLongPressUp, Optional<Runnable> onVerticalDragCancel, Optional<Runnable> onHorizontalDragCancel, Optional<Runnable> onPanCancel, Optional<HitTestBehavior> behavior, Optional<Boolean> excludeFromSemantics, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> trackpadScrollCausesScale, Optional<Offset> trackpadScrollToScaleFactor) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    if (onTap.isPresent()) { int __cb_onTap = nextCallbackId++; p.put("onTap", __cb_onTap); callbacks.put(__cb_onTap, onTap.get()); }
    if (onTapCancel.isPresent()) { int __cb_onTapCancel = nextCallbackId++; p.put("onTapCancel", __cb_onTapCancel); callbacks.put(__cb_onTapCancel, onTapCancel.get()); }
    if (onSecondaryTap.isPresent()) { int __cb_onSecondaryTap = nextCallbackId++; p.put("onSecondaryTap", __cb_onSecondaryTap); callbacks.put(__cb_onSecondaryTap, onSecondaryTap.get()); }
    if (onSecondaryTapCancel.isPresent()) { int __cb_onSecondaryTapCancel = nextCallbackId++; p.put("onSecondaryTapCancel", __cb_onSecondaryTapCancel); callbacks.put(__cb_onSecondaryTapCancel, onSecondaryTapCancel.get()); }
    if (onTertiaryTapCancel.isPresent()) { int __cb_onTertiaryTapCancel = nextCallbackId++; p.put("onTertiaryTapCancel", __cb_onTertiaryTapCancel); callbacks.put(__cb_onTertiaryTapCancel, onTertiaryTapCancel.get()); }
    if (onDoubleTap.isPresent()) { int __cb_onDoubleTap = nextCallbackId++; p.put("onDoubleTap", __cb_onDoubleTap); callbacks.put(__cb_onDoubleTap, onDoubleTap.get()); }
    if (onDoubleTapCancel.isPresent()) { int __cb_onDoubleTapCancel = nextCallbackId++; p.put("onDoubleTapCancel", __cb_onDoubleTapCancel); callbacks.put(__cb_onDoubleTapCancel, onDoubleTapCancel.get()); }
    if (onLongPressCancel.isPresent()) { int __cb_onLongPressCancel = nextCallbackId++; p.put("onLongPressCancel", __cb_onLongPressCancel); callbacks.put(__cb_onLongPressCancel, onLongPressCancel.get()); }
    if (onLongPress.isPresent()) { int __cb_onLongPress = nextCallbackId++; p.put("onLongPress", __cb_onLongPress); callbacks.put(__cb_onLongPress, onLongPress.get()); }
    if (onLongPressUp.isPresent()) { int __cb_onLongPressUp = nextCallbackId++; p.put("onLongPressUp", __cb_onLongPressUp); callbacks.put(__cb_onLongPressUp, onLongPressUp.get()); }
    if (onSecondaryLongPressCancel.isPresent()) { int __cb_onSecondaryLongPressCancel = nextCallbackId++; p.put("onSecondaryLongPressCancel", __cb_onSecondaryLongPressCancel); callbacks.put(__cb_onSecondaryLongPressCancel, onSecondaryLongPressCancel.get()); }
    if (onSecondaryLongPress.isPresent()) { int __cb_onSecondaryLongPress = nextCallbackId++; p.put("onSecondaryLongPress", __cb_onSecondaryLongPress); callbacks.put(__cb_onSecondaryLongPress, onSecondaryLongPress.get()); }
    if (onSecondaryLongPressUp.isPresent()) { int __cb_onSecondaryLongPressUp = nextCallbackId++; p.put("onSecondaryLongPressUp", __cb_onSecondaryLongPressUp); callbacks.put(__cb_onSecondaryLongPressUp, onSecondaryLongPressUp.get()); }
    if (onTertiaryLongPressCancel.isPresent()) { int __cb_onTertiaryLongPressCancel = nextCallbackId++; p.put("onTertiaryLongPressCancel", __cb_onTertiaryLongPressCancel); callbacks.put(__cb_onTertiaryLongPressCancel, onTertiaryLongPressCancel.get()); }
    if (onTertiaryLongPress.isPresent()) { int __cb_onTertiaryLongPress = nextCallbackId++; p.put("onTertiaryLongPress", __cb_onTertiaryLongPress); callbacks.put(__cb_onTertiaryLongPress, onTertiaryLongPress.get()); }
    if (onTertiaryLongPressUp.isPresent()) { int __cb_onTertiaryLongPressUp = nextCallbackId++; p.put("onTertiaryLongPressUp", __cb_onTertiaryLongPressUp); callbacks.put(__cb_onTertiaryLongPressUp, onTertiaryLongPressUp.get()); }
    if (onVerticalDragCancel.isPresent()) { int __cb_onVerticalDragCancel = nextCallbackId++; p.put("onVerticalDragCancel", __cb_onVerticalDragCancel); callbacks.put(__cb_onVerticalDragCancel, onVerticalDragCancel.get()); }
    if (onHorizontalDragCancel.isPresent()) { int __cb_onHorizontalDragCancel = nextCallbackId++; p.put("onHorizontalDragCancel", __cb_onHorizontalDragCancel); callbacks.put(__cb_onHorizontalDragCancel, onHorizontalDragCancel.get()); }
    if (onPanCancel.isPresent()) { int __cb_onPanCancel = nextCallbackId++; p.put("onPanCancel", __cb_onPanCancel); callbacks.put(__cb_onPanCancel, onPanCancel.get()); }
    behavior.ifPresent(v -> p.put("behavior", v.ordinal()));
    excludeFromSemantics.ifPresent(v -> p.put("excludeFromSemantics", v));
    dragStartBehavior.ifPresent(v -> p.put("dragStartBehavior", v.ordinal()));
    trackpadScrollCausesScale.ifPresent(v -> p.put("trackpadScrollCausesScale", v));
    trackpadScrollToScaleFactor.ifPresent(v -> p.put("trackpadScrollToScaleFactor", byId.get(v.getId())));
    record(id, "gestureDetectorGestureDetector", p);
    MemorySegment st = GestureDetectorObjSt.allocate(arena);
    GestureDetectorObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment listTileListTile(Optional<Widget> leading, Optional<Widget> title, Optional<Widget> subtitle, Optional<Widget> trailing, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<VisualDensity> visualDensity, Optional<ShapeBorder> shape, Optional<ListTileStyle> style, Optional<Color> selectedColor, Optional<Color> iconColor, Optional<Color> textColor, Optional<TextStyle> titleTextStyle, Optional<TextStyle> subtitleTextStyle, Optional<TextStyle> leadingAndTrailingTextStyle, Optional<EdgeInsetsGeometry> contentPadding, Optional<Boolean> enabled, Optional<Runnable> onTap, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> selected, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> splashColor, Optional<Boolean> autofocus, Optional<Color> tileColor, Optional<Color> selectedTileColor, Optional<Boolean> enableFeedback, OptionalDouble horizontalTitleGap, OptionalDouble minVerticalPadding, OptionalDouble minLeadingWidth, OptionalDouble minTileHeight, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> internalAddSemanticForOnTap) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    leading.ifPresent(v -> p.put("leading", byId.get(v.getId())));
    title.ifPresent(v -> p.put("title", byId.get(v.getId())));
    subtitle.ifPresent(v -> p.put("subtitle", byId.get(v.getId())));
    trailing.ifPresent(v -> p.put("trailing", byId.get(v.getId())));
    isThreeLine.ifPresent(v -> p.put("isThreeLine", v));
    dense.ifPresent(v -> p.put("dense", v));
    visualDensity.ifPresent(v -> p.put("visualDensity", byId.get(v.getId())));
    shape.ifPresent(v -> p.put("shape", byId.get(v.getId())));
    style.ifPresent(v -> p.put("style", v.ordinal()));
    selectedColor.ifPresent(v -> p.put("selectedColor", byId.get(v.getId())));
    iconColor.ifPresent(v -> p.put("iconColor", byId.get(v.getId())));
    textColor.ifPresent(v -> p.put("textColor", byId.get(v.getId())));
    titleTextStyle.ifPresent(v -> p.put("titleTextStyle", byId.get(v.getId())));
    subtitleTextStyle.ifPresent(v -> p.put("subtitleTextStyle", byId.get(v.getId())));
    leadingAndTrailingTextStyle.ifPresent(v -> p.put("leadingAndTrailingTextStyle", byId.get(v.getId())));
    contentPadding.ifPresent(v -> p.put("contentPadding", byId.get(v.getId())));
    enabled.ifPresent(v -> p.put("enabled", v));
    if (onTap.isPresent()) { int __cb_onTap = nextCallbackId++; p.put("onTap", __cb_onTap); callbacks.put(__cb_onTap, onTap.get()); }
    if (onLongPress.isPresent()) { int __cb_onLongPress = nextCallbackId++; p.put("onLongPress", __cb_onLongPress); callbacks.put(__cb_onLongPress, onLongPress.get()); }
    if (onFocusChange.isPresent()) { int __cb_onFocusChange = nextCallbackId++; p.put("onFocusChange", __cb_onFocusChange); java.util.function.Consumer<Boolean> __h_onFocusChange = onFocusChange.get(); callbacks.put(__cb_onFocusChange, (java.util.function.Consumer<Object>)(v -> __h_onFocusChange.accept((Boolean) v))); }
    selected.ifPresent(v -> p.put("selected", v));
    focusColor.ifPresent(v -> p.put("focusColor", byId.get(v.getId())));
    hoverColor.ifPresent(v -> p.put("hoverColor", byId.get(v.getId())));
    splashColor.ifPresent(v -> p.put("splashColor", byId.get(v.getId())));
    autofocus.ifPresent(v -> p.put("autofocus", v));
    tileColor.ifPresent(v -> p.put("tileColor", byId.get(v.getId())));
    selectedTileColor.ifPresent(v -> p.put("selectedTileColor", byId.get(v.getId())));
    enableFeedback.ifPresent(v -> p.put("enableFeedback", v));
    if (horizontalTitleGap.isPresent()) { p.put("horizontalTitleGap", horizontalTitleGap.getAsDouble()); }
    if (minVerticalPadding.isPresent()) { p.put("minVerticalPadding", minVerticalPadding.getAsDouble()); }
    if (minLeadingWidth.isPresent()) { p.put("minLeadingWidth", minLeadingWidth.getAsDouble()); }
    if (minTileHeight.isPresent()) { p.put("minTileHeight", minTileHeight.getAsDouble()); }
    titleAlignment.ifPresent(v -> p.put("titleAlignment", v.ordinal()));
    internalAddSemanticForOnTap.ifPresent(v -> p.put("internalAddSemanticForOnTap", v));
    record(id, "listTileListTile", p);
    MemorySegment st = ListTileObjSt.allocate(arena);
    ListTileObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment wrapWrap(Optional<Axis> direction, Optional<WrapAlignment> alignment, OptionalDouble spacing, Optional<WrapAlignment> runAlignment, OptionalDouble runSpacing, Optional<WrapCrossAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<Clip> clipBehavior, Optional<List<Widget>> children) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    direction.ifPresent(v -> p.put("direction", v.ordinal()));
    alignment.ifPresent(v -> p.put("alignment", v.ordinal()));
    if (spacing.isPresent()) { p.put("spacing", spacing.getAsDouble()); }
    runAlignment.ifPresent(v -> p.put("runAlignment", v.ordinal()));
    if (runSpacing.isPresent()) { p.put("runSpacing", runSpacing.getAsDouble()); }
    crossAxisAlignment.ifPresent(v -> p.put("crossAxisAlignment", v.ordinal()));
    textDirection.ifPresent(v -> p.put("textDirection", v.ordinal()));
    verticalDirection.ifPresent(v -> p.put("verticalDirection", v.ordinal()));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    children.ifPresent(v -> p.put("children", v.stream().map(e -> byId.get(e.getId())).collect(java.util.stream.Collectors.toList())));
    record(id, "wrapWrap", p);
    MemorySegment st = WrapObjSt.allocate(arena);
    WrapObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment singleChildScrollViewSingleChildScrollView(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<EdgeInsetsGeometry> padding, Optional<Boolean> primary, Optional<Widget> child, Optional<DragStartBehavior> dragStartBehavior, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior, Optional<String> restorationId, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    scrollDirection.ifPresent(v -> p.put("scrollDirection", v.ordinal()));
    reverse.ifPresent(v -> p.put("reverse", v));
    padding.ifPresent(v -> p.put("padding", byId.get(v.getId())));
    primary.ifPresent(v -> p.put("primary", v));
    child.ifPresent(v -> p.put("child", byId.get(v.getId())));
    dragStartBehavior.ifPresent(v -> p.put("dragStartBehavior", v.ordinal()));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    hitTestBehavior.ifPresent(v -> p.put("hitTestBehavior", v.ordinal()));
    restorationId.ifPresent(v -> p.put("restorationId", v));
    keyboardDismissBehavior.ifPresent(v -> p.put("keyboardDismissBehavior", v.ordinal()));
    record(id, "singleChildScrollViewSingleChildScrollView", p);
    MemorySegment st = SingleChildScrollViewObjSt.allocate(arena);
    SingleChildScrollViewObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment listViewListView(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometry> padding, OptionalDouble itemExtent, Optional<Widget> prototypeItem, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, Optional<List<Widget>> children, OptionalInt semanticChildCount, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    scrollDirection.ifPresent(v -> p.put("scrollDirection", v.ordinal()));
    reverse.ifPresent(v -> p.put("reverse", v));
    primary.ifPresent(v -> p.put("primary", v));
    shrinkWrap.ifPresent(v -> p.put("shrinkWrap", v));
    padding.ifPresent(v -> p.put("padding", byId.get(v.getId())));
    if (itemExtent.isPresent()) { p.put("itemExtent", itemExtent.getAsDouble()); }
    prototypeItem.ifPresent(v -> p.put("prototypeItem", byId.get(v.getId())));
    addAutomaticKeepAlives.ifPresent(v -> p.put("addAutomaticKeepAlives", v));
    addRepaintBoundaries.ifPresent(v -> p.put("addRepaintBoundaries", v));
    addSemanticIndexes.ifPresent(v -> p.put("addSemanticIndexes", v));
    if (cacheExtent.isPresent()) { p.put("cacheExtent", cacheExtent.getAsDouble()); }
    children.ifPresent(v -> p.put("children", v.stream().map(e -> byId.get(e.getId())).collect(java.util.stream.Collectors.toList())));
    if (semanticChildCount.isPresent()) { p.put("semanticChildCount", semanticChildCount.getAsInt()); }
    dragStartBehavior.ifPresent(v -> p.put("dragStartBehavior", v.ordinal()));
    keyboardDismissBehavior.ifPresent(v -> p.put("keyboardDismissBehavior", v.ordinal()));
    restorationId.ifPresent(v -> p.put("restorationId", v));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    hitTestBehavior.ifPresent(v -> p.put("hitTestBehavior", v.ordinal()));
    record(id, "listViewListView", p);
    MemorySegment st = ListViewObjSt.allocate(arena);
    ListViewObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment listViewBuilder(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometry> padding, OptionalDouble itemExtent, Optional<Widget> prototypeItem, BiFunction<BuildContext, Integer, Widget> itemBuilder, OptionalInt itemCount, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, OptionalInt semanticChildCount, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    scrollDirection.ifPresent(v -> p.put("scrollDirection", v.ordinal()));
    reverse.ifPresent(v -> p.put("reverse", v));
    primary.ifPresent(v -> p.put("primary", v));
    shrinkWrap.ifPresent(v -> p.put("shrinkWrap", v));
    padding.ifPresent(v -> p.put("padding", byId.get(v.getId())));
    if (itemExtent.isPresent()) { p.put("itemExtent", itemExtent.getAsDouble()); }
    prototypeItem.ifPresent(v -> p.put("prototypeItem", byId.get(v.getId())));
    p.put("itemBuilder", nextCallbackId++);
    if (itemCount.isPresent()) { p.put("itemCount", itemCount.getAsInt()); }
    addAutomaticKeepAlives.ifPresent(v -> p.put("addAutomaticKeepAlives", v));
    addRepaintBoundaries.ifPresent(v -> p.put("addRepaintBoundaries", v));
    addSemanticIndexes.ifPresent(v -> p.put("addSemanticIndexes", v));
    if (cacheExtent.isPresent()) { p.put("cacheExtent", cacheExtent.getAsDouble()); }
    if (semanticChildCount.isPresent()) { p.put("semanticChildCount", semanticChildCount.getAsInt()); }
    dragStartBehavior.ifPresent(v -> p.put("dragStartBehavior", v.ordinal()));
    keyboardDismissBehavior.ifPresent(v -> p.put("keyboardDismissBehavior", v.ordinal()));
    restorationId.ifPresent(v -> p.put("restorationId", v));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    hitTestBehavior.ifPresent(v -> p.put("hitTestBehavior", v.ordinal()));
    record(id, "listViewBuilder", p);
    MemorySegment st = ListViewObjSt.allocate(arena);
    ListViewObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment listViewSeparated(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometry> padding, BiFunction<BuildContext, Integer, Widget> itemBuilder, BiFunction<BuildContext, Integer, Widget> separatorBuilder, int itemCount, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    scrollDirection.ifPresent(v -> p.put("scrollDirection", v.ordinal()));
    reverse.ifPresent(v -> p.put("reverse", v));
    primary.ifPresent(v -> p.put("primary", v));
    shrinkWrap.ifPresent(v -> p.put("shrinkWrap", v));
    padding.ifPresent(v -> p.put("padding", byId.get(v.getId())));
    p.put("itemBuilder", nextCallbackId++);
    p.put("separatorBuilder", nextCallbackId++);
    p.put("itemCount", itemCount);
    addAutomaticKeepAlives.ifPresent(v -> p.put("addAutomaticKeepAlives", v));
    addRepaintBoundaries.ifPresent(v -> p.put("addRepaintBoundaries", v));
    addSemanticIndexes.ifPresent(v -> p.put("addSemanticIndexes", v));
    if (cacheExtent.isPresent()) { p.put("cacheExtent", cacheExtent.getAsDouble()); }
    dragStartBehavior.ifPresent(v -> p.put("dragStartBehavior", v.ordinal()));
    keyboardDismissBehavior.ifPresent(v -> p.put("keyboardDismissBehavior", v.ordinal()));
    restorationId.ifPresent(v -> p.put("restorationId", v));
    clipBehavior.ifPresent(v -> p.put("clipBehavior", v.ordinal()));
    hitTestBehavior.ifPresent(v -> p.put("hitTestBehavior", v.ordinal()));
    record(id, "listViewSeparated", p);
    MemorySegment st = ListViewObjSt.allocate(arena);
    ListViewObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment circularProgressIndicatorCircularProgressIndicator(OptionalDouble value, Optional<Color> backgroundColor, Optional<Color> color, Optional<Animation> valueColor, OptionalDouble strokeWidth, OptionalDouble strokeAlign, Optional<String> semanticsLabel, Optional<String> semanticsValue, Optional<StrokeCap> strokeCap, Optional<BoxConstraints> constraints, OptionalDouble trackGap, Optional<Boolean> year2023, Optional<EdgeInsetsGeometry> padding) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (value.isPresent()) { p.put("value", value.getAsDouble()); }
    backgroundColor.ifPresent(v -> p.put("backgroundColor", byId.get(v.getId())));
    color.ifPresent(v -> p.put("color", byId.get(v.getId())));
    valueColor.ifPresent(v -> p.put("valueColor", byId.get(v.getId())));
    if (strokeWidth.isPresent()) { p.put("strokeWidth", strokeWidth.getAsDouble()); }
    if (strokeAlign.isPresent()) { p.put("strokeAlign", strokeAlign.getAsDouble()); }
    semanticsLabel.ifPresent(v -> p.put("semanticsLabel", v));
    semanticsValue.ifPresent(v -> p.put("semanticsValue", v));
    strokeCap.ifPresent(v -> p.put("strokeCap", v.ordinal()));
    constraints.ifPresent(v -> p.put("constraints", byId.get(v.getId())));
    if (trackGap.isPresent()) { p.put("trackGap", trackGap.getAsDouble()); }
    year2023.ifPresent(v -> p.put("year2023", v));
    padding.ifPresent(v -> p.put("padding", byId.get(v.getId())));
    record(id, "circularProgressIndicatorCircularProgressIndicator", p);
    MemorySegment st = CircularProgressIndicatorObjSt.allocate(arena);
    CircularProgressIndicatorObjSt.id(st, id);
    return st;
  }
  @Override
  MemorySegment circularProgressIndicatorAdaptive(OptionalDouble value, Optional<Color> backgroundColor, Optional<Animation> valueColor, OptionalDouble strokeWidth, Optional<String> semanticsLabel, Optional<String> semanticsValue, Optional<StrokeCap> strokeCap, OptionalDouble strokeAlign, Optional<BoxConstraints> constraints, OptionalDouble trackGap, Optional<Boolean> year2023, Optional<EdgeInsetsGeometry> padding) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (value.isPresent()) { p.put("value", value.getAsDouble()); }
    backgroundColor.ifPresent(v -> p.put("backgroundColor", byId.get(v.getId())));
    valueColor.ifPresent(v -> p.put("valueColor", byId.get(v.getId())));
    if (strokeWidth.isPresent()) { p.put("strokeWidth", strokeWidth.getAsDouble()); }
    semanticsLabel.ifPresent(v -> p.put("semanticsLabel", v));
    semanticsValue.ifPresent(v -> p.put("semanticsValue", v));
    strokeCap.ifPresent(v -> p.put("strokeCap", v.ordinal()));
    if (strokeAlign.isPresent()) { p.put("strokeAlign", strokeAlign.getAsDouble()); }
    constraints.ifPresent(v -> p.put("constraints", byId.get(v.getId())));
    if (trackGap.isPresent()) { p.put("trackGap", trackGap.getAsDouble()); }
    year2023.ifPresent(v -> p.put("year2023", v));
    padding.ifPresent(v -> p.put("padding", byId.get(v.getId())));
    record(id, "circularProgressIndicatorAdaptive", p);
    MemorySegment st = CircularProgressIndicatorObjSt.allocate(arena);
    CircularProgressIndicatorObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment linearProgressIndicatorLinearProgressIndicator(OptionalDouble value, Optional<Color> backgroundColor, Optional<Color> color, Optional<Animation> valueColor, OptionalDouble minHeight, Optional<String> semanticsLabel, Optional<String> semanticsValue, Optional<BorderRadiusGeometry> borderRadius, Optional<Color> stopIndicatorColor, OptionalDouble stopIndicatorRadius, OptionalDouble trackGap, Optional<Boolean> year2023) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    if (value.isPresent()) { p.put("value", value.getAsDouble()); }
    backgroundColor.ifPresent(v -> p.put("backgroundColor", byId.get(v.getId())));
    color.ifPresent(v -> p.put("color", byId.get(v.getId())));
    valueColor.ifPresent(v -> p.put("valueColor", byId.get(v.getId())));
    if (minHeight.isPresent()) { p.put("minHeight", minHeight.getAsDouble()); }
    semanticsLabel.ifPresent(v -> p.put("semanticsLabel", v));
    semanticsValue.ifPresent(v -> p.put("semanticsValue", v));
    borderRadius.ifPresent(v -> p.put("borderRadius", byId.get(v.getId())));
    stopIndicatorColor.ifPresent(v -> p.put("stopIndicatorColor", byId.get(v.getId())));
    if (stopIndicatorRadius.isPresent()) { p.put("stopIndicatorRadius", stopIndicatorRadius.getAsDouble()); }
    if (trackGap.isPresent()) { p.put("trackGap", trackGap.getAsDouble()); }
    year2023.ifPresent(v -> p.put("year2023", v));
    record(id, "linearProgressIndicatorLinearProgressIndicator", p);
    MemorySegment st = LinearProgressIndicatorObjSt.allocate(arena);
    LinearProgressIndicatorObjSt.id(st, id);
    return st;
  }

  @Override
  <T extends StatefulWidget> MemorySegment subStateSubState(Runnable initStateFn, Consumer<T> didUpdateWidgetFn, Runnable reassembleFn, Runnable deactivateFn, Runnable activateFn, Runnable disposeFn, Function<BuildContext, Widget> buildFn, Runnable didChangeDependenciesFn) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    int __cb_initStateFn = nextCallbackId++; p.put("initStateFn", __cb_initStateFn); callbacks.put(__cb_initStateFn, initStateFn);
    p.put("didUpdateWidgetFn", nextCallbackId++);
    int __cb_reassembleFn = nextCallbackId++; p.put("reassembleFn", __cb_reassembleFn); callbacks.put(__cb_reassembleFn, reassembleFn);
    int __cb_deactivateFn = nextCallbackId++; p.put("deactivateFn", __cb_deactivateFn); callbacks.put(__cb_deactivateFn, deactivateFn);
    int __cb_activateFn = nextCallbackId++; p.put("activateFn", __cb_activateFn); callbacks.put(__cb_activateFn, activateFn);
    int __cb_disposeFn = nextCallbackId++; p.put("disposeFn", __cb_disposeFn); callbacks.put(__cb_disposeFn, disposeFn);
    p.put("buildFn", nextCallbackId++);
    int __cb_didChangeDependenciesFn = nextCallbackId++; p.put("didChangeDependenciesFn", __cb_didChangeDependenciesFn); callbacks.put(__cb_didChangeDependenciesFn, didChangeDependenciesFn);
    record(id, "subStateSubState", p);
    MemorySegment st = SubStateObjSt.allocate(arena);
    SubStateObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment subStatefulWidgetSubStatefulWidget(Supplier<State> createStateFn) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    int __cb_createStateFn = nextCallbackId++; p.put("createStateFn", __cb_createStateFn); callbacks.put(__cb_createStateFn, createStateFn);
    record(id, "subStatefulWidgetSubStatefulWidget", p);
    MemorySegment st = SubStatefulWidgetObjSt.allocate(arena);
    SubStatefulWidgetObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment subStatelessWidgetSubStatelessWidget(Function<BuildContext, Widget> buildFn) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("buildFn", nextCallbackId++);
    record(id, "subStatelessWidgetSubStatelessWidget", p);
    MemorySegment st = SubStatelessWidgetObjSt.allocate(arena);
    SubStatelessWidgetObjSt.id(st, id);
    return st;
  }

  @Override
  <T extends StatefulWidget> MemorySegment subAnimatedStateSubAnimatedState(Runnable initStateFn, Consumer<T> didUpdateWidgetFn, Runnable reassembleFn, Runnable deactivateFn, Runnable activateFn, Runnable disposeFn, Function<BuildContext, Widget> buildFn, Runnable didChangeDependenciesFn) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    int __cb_initStateFn = nextCallbackId++; p.put("initStateFn", __cb_initStateFn); callbacks.put(__cb_initStateFn, initStateFn);
    p.put("didUpdateWidgetFn", nextCallbackId++);
    int __cb_reassembleFn = nextCallbackId++; p.put("reassembleFn", __cb_reassembleFn); callbacks.put(__cb_reassembleFn, reassembleFn);
    int __cb_deactivateFn = nextCallbackId++; p.put("deactivateFn", __cb_deactivateFn); callbacks.put(__cb_deactivateFn, deactivateFn);
    int __cb_activateFn = nextCallbackId++; p.put("activateFn", __cb_activateFn); callbacks.put(__cb_activateFn, activateFn);
    int __cb_disposeFn = nextCallbackId++; p.put("disposeFn", __cb_disposeFn); callbacks.put(__cb_disposeFn, disposeFn);
    p.put("buildFn", nextCallbackId++);
    int __cb_didChangeDependenciesFn = nextCallbackId++; p.put("didChangeDependenciesFn", __cb_didChangeDependenciesFn); callbacks.put(__cb_didChangeDependenciesFn, didChangeDependenciesFn);
    record(id, "subAnimatedStateSubAnimatedState", p);
    MemorySegment st = SubAnimatedStateObjSt.allocate(arena);
    SubAnimatedStateObjSt.id(st, id);
    return st;
  }
  @Override
  int subAnimatedStateAnimationController(SubAnimatedState self, Duration duration) {
    int id = nextId++;
    java.util.Map<String,Object> p = new java.util.LinkedHashMap<>();
    p.put("self", byId.get(self.getId()));
    p.put("duration", byId.get(duration.getId()));
    record(id, "subAnimatedStateAnimationController", p);
    return id;
  }

}
