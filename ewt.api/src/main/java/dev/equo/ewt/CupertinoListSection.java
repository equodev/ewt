package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoListSectionObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoListSection extends StatelessWidget implements CupertinoListSectionI {
  private MemorySegment st;
  protected CupertinoListSection() {}
  CupertinoListSection(MemorySegment st) {
    this.id = CupertinoListSectionObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoListSection");
    System.out.println("New CupertinoListSection id:"+id);
  }
  CupertinoListSection(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoListSection cupertinoListSectionCupertinoListSection(Optional<List<WidgetI>> children, Optional<WidgetI> header, Optional<WidgetI> footer, Optional<EdgeInsetsGeometryI> margin, Optional<ColorI> backgroundColor, Optional<BoxDecorationI> decoration, Optional<Clip> clipBehavior, OptionalDouble dividerMargin, OptionalDouble additionalDividerMargin, OptionalDouble topMargin, Optional<Boolean> hasLeading, Optional<ColorI> separatorColor) {
    var st = factories.cupertinoListSectionCupertinoListSection(children.map(i -> i.stream().map(WidgetI::build).toList()),
      header.map(WidgetI::build),
      footer.map(WidgetI::build),
      margin.map(EdgeInsetsGeometryI::build),
      backgroundColor.map(ColorI::build),
      decoration.map(BoxDecorationI::build),
      clipBehavior,
      dividerMargin,
      additionalDividerMargin,
      topMargin,
      hasLeading,
      separatorColor.map(ColorI::build));
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoListSection");
    return new CupertinoListSection(st);
  }
  public static CupertinoListSectionCupertinoListSectionBuilder cupertinoListSection() {
    return CupertinoListSectionCupertinoListSectionBuilder.cupertinoListSectionCupertinoListSection();
  }
  @Builder.Factory
  static CupertinoListSection cupertinoListSectionInsetGrouped(Optional<List<WidgetI>> children, Optional<WidgetI> header, Optional<WidgetI> footer, Optional<EdgeInsetsGeometryI> margin, Optional<ColorI> backgroundColor, Optional<BoxDecorationI> decoration, Optional<Clip> clipBehavior, OptionalDouble dividerMargin, OptionalDouble additionalDividerMargin, OptionalDouble topMargin, Optional<Boolean> hasLeading, Optional<ColorI> separatorColor) {
    var st = factories.cupertinoListSectionInsetGrouped(children.map(i -> i.stream().map(WidgetI::build).toList()),
      header.map(WidgetI::build),
      footer.map(WidgetI::build),
      margin.map(EdgeInsetsGeometryI::build),
      backgroundColor.map(ColorI::build),
      decoration.map(BoxDecorationI::build),
      clipBehavior,
      dividerMargin,
      additionalDividerMargin,
      topMargin,
      hasLeading,
      separatorColor.map(ColorI::build));
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoListSection");
    return new CupertinoListSection(st);
  }
  public static CupertinoListSectionInsetGroupedBuilder insetGrouped() {
    return CupertinoListSectionInsetGroupedBuilder.cupertinoListSectionInsetGrouped();
  }
  public CupertinoListSectionType type() {
    return CupertinoListSectionType.values()[CupertinoListSectionObjSt.type(st)];
  }
  public Widget header() {
    return new Widget(CupertinoListSectionObjSt.header(st)) {};
  }
  public Widget footer() {
    return new Widget(CupertinoListSectionObjSt.footer(st)) {};
  }
  public EdgeInsetsGeometry margin() {
    return new EdgeInsetsGeometry(CupertinoListSectionObjSt.margin(st)) {};
  }
  public BoxDecoration decoration() {
    return new BoxDecoration(CupertinoListSectionObjSt.decoration(st));
  }
  public Color backgroundColor() {
    return new Color(CupertinoListSectionObjSt.backgroundColor(st));
  }
  public Clip clipBehavior() {
    return Clip.values()[CupertinoListSectionObjSt.clipBehavior(st)];
  }
  public double dividerMargin() {
    return CupertinoListSectionObjSt.dividerMargin(st);
  }
  public double additionalDividerMargin() {
    return CupertinoListSectionObjSt.additionalDividerMargin(st);
  }
  public double topMargin() {
    return CupertinoListSectionObjSt.topMargin(st);
  }
  public Color separatorColor() {
    return new Color(CupertinoListSectionObjSt.separatorColor(st));
  }
  @Override
  public CupertinoListSection build() {
    return this;
  }
}
