package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoFormSectionObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoFormSection extends StatelessWidget implements CupertinoFormSectionI {
  private MemorySegment st;
  protected CupertinoFormSection() {}
  CupertinoFormSection(MemorySegment st) {
    this.id = CupertinoFormSectionObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoFormSection");
    System.out.println("New CupertinoFormSection id:"+id);
  }
  CupertinoFormSection(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoFormSection cupertinoFormSectionCupertinoFormSection(@Builder.Parameter List<WidgetI> children, Optional<WidgetI> header, Optional<WidgetI> footer, Optional<EdgeInsetsGeometryI> margin, Optional<ColorI> backgroundColor, Optional<BoxDecorationI> decoration, Optional<Clip> clipBehavior) {
    var st = factories.cupertinoFormSectionCupertinoFormSection(children.stream().map(WidgetI::build).toList(),
      header.map(WidgetI::build),
      footer.map(WidgetI::build),
      margin.map(EdgeInsetsGeometryI::build),
      backgroundColor.map(ColorI::build),
      decoration.map(BoxDecorationI::build),
      clipBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoFormSection");
    return new CupertinoFormSection(st);
  }
  public static CupertinoFormSectionCupertinoFormSectionBuilder cupertinoFormSection(List<WidgetI> children) {
    return CupertinoFormSectionCupertinoFormSectionBuilder.cupertinoFormSectionCupertinoFormSection(children);
  }
  @Builder.Factory
  static CupertinoFormSection cupertinoFormSectionInsetGrouped(@Builder.Parameter List<WidgetI> children, Optional<WidgetI> header, Optional<WidgetI> footer, Optional<EdgeInsetsGeometryI> margin, Optional<ColorI> backgroundColor, Optional<BoxDecorationI> decoration, Optional<Clip> clipBehavior) {
    var st = factories.cupertinoFormSectionInsetGrouped(children.stream().map(WidgetI::build).toList(),
      header.map(WidgetI::build),
      footer.map(WidgetI::build),
      margin.map(EdgeInsetsGeometryI::build),
      backgroundColor.map(ColorI::build),
      decoration.map(BoxDecorationI::build),
      clipBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoFormSection");
    return new CupertinoFormSection(st);
  }
  public static CupertinoFormSectionInsetGroupedBuilder insetGrouped(List<WidgetI> children) {
    return CupertinoFormSectionInsetGroupedBuilder.cupertinoFormSectionInsetGrouped(children);
  }
  public Widget header() {
    return new Widget(CupertinoFormSectionObjSt.header(st)) {};
  }
  public Widget footer() {
    return new Widget(CupertinoFormSectionObjSt.footer(st)) {};
  }
  public EdgeInsetsGeometry margin() {
    return new EdgeInsetsGeometry(CupertinoFormSectionObjSt.margin(st)) {};
  }
  public BoxDecoration decoration() {
    return new BoxDecoration(CupertinoFormSectionObjSt.decoration(st));
  }
  public Color backgroundColor() {
    return new Color(CupertinoFormSectionObjSt.backgroundColor(st));
  }
  public Clip clipBehavior() {
    return Clip.values()[CupertinoFormSectionObjSt.clipBehavior(st)];
  }
  @Override
  public CupertinoFormSection build() {
    return this;
  }
}
