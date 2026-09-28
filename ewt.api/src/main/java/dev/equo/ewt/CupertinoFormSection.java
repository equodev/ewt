package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoFormSection extends StatelessWidget implements CupertinoFormSectionI {
  protected CupertinoFormSection() {}
  CupertinoFormSection(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoFormSection");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoFormSection cupertinoFormSectionCupertinoFormSection(@Builder.Parameter List<WidgetI> children, Optional<WidgetI> header, Optional<WidgetI> footer, Optional<EdgeInsetsGeometryI> margin, Optional<ColorI> backgroundColor, Optional<BoxDecorationI> decoration, Optional<Clip> clipBehavior) {
    int id = factories.cupertinoFormSectionCupertinoFormSection(children.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()),
      header.map(WidgetI::build),
      footer.map(WidgetI::build),
      margin.map(EdgeInsetsGeometryI::build),
      backgroundColor.map(ColorI::build),
      decoration.map(BoxDecorationI::build),
      clipBehavior);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoFormSection");
    return new CupertinoFormSection(id);
  }
  public static CupertinoFormSectionCupertinoFormSectionBuilder cupertinoFormSection(List<WidgetI> children) {
    return CupertinoFormSectionCupertinoFormSectionBuilder.cupertinoFormSectionCupertinoFormSection(children);
  }
  @Builder.Factory
  static CupertinoFormSection cupertinoFormSectionInsetGrouped(@Builder.Parameter List<WidgetI> children, Optional<WidgetI> header, Optional<WidgetI> footer, Optional<EdgeInsetsGeometryI> margin, Optional<ColorI> backgroundColor, Optional<BoxDecorationI> decoration, Optional<Clip> clipBehavior) {
    int id = factories.cupertinoFormSectionInsetGrouped(children.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()),
      header.map(WidgetI::build),
      footer.map(WidgetI::build),
      margin.map(EdgeInsetsGeometryI::build),
      backgroundColor.map(ColorI::build),
      decoration.map(BoxDecorationI::build),
      clipBehavior);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoFormSection");
    return new CupertinoFormSection(id);
  }
  public static CupertinoFormSectionInsetGroupedBuilder insetGrouped(List<WidgetI> children) {
    return CupertinoFormSectionInsetGroupedBuilder.cupertinoFormSectionInsetGrouped(children);
  }
  public Widget header() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoFormSectionHeader not supported on web");
    return factories.CupertinoFormSection_readBack_header(nativeStruct);
  }
  public Widget footer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoFormSectionFooter not supported on web");
    return factories.CupertinoFormSection_readBack_footer(nativeStruct);
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoFormSectionMargin not supported on web");
    return factories.CupertinoFormSection_readBack_margin(nativeStruct);
  }
  public BoxDecoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoFormSectionDecoration", getId());
      return new BoxDecoration(__nid);
    }
    return factories.CupertinoFormSection_readBack_decoration(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoFormSectionBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoFormSection_readBack_backgroundColor(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoFormSectionClipBehavior not supported on web");
    return factories.CupertinoFormSection_readBack_clipBehavior(nativeStruct);
  }
  @Override
  public CupertinoFormSection build() {
    return this;
  }
}
