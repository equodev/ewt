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
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoFormSectionHeader not supported on web");
    return new Widget(CupertinoFormSectionObjSt.header(st)) {};
  }
  public Widget footer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoFormSectionFooter not supported on web");
    return new Widget(CupertinoFormSectionObjSt.footer(st)) {};
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoFormSectionMargin not supported on web");
    return new EdgeInsetsGeometry(CupertinoFormSectionObjSt.margin(st)) {};
  }
  public BoxDecoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoFormSectionDecoration", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxDecorationObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxDecorationObjSt.id(__st, __nid);
      return new BoxDecoration(__st);
    }
    return new BoxDecoration(CupertinoFormSectionObjSt.decoration(st));
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoFormSectionBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoFormSectionObjSt.backgroundColor(st));
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoFormSectionClipBehavior not supported on web");
    return Clip.values()[CupertinoFormSectionObjSt.clipBehavior(st)];
  }
  @Override
  public CupertinoFormSection build() {
    return this;
  }
}
