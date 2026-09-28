package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoListSection extends StatelessWidget implements CupertinoListSectionI {
  protected CupertinoListSection() {}
  CupertinoListSection(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoListSection");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoListSection cupertinoListSectionCupertinoListSection(Optional<List<WidgetI>> children, Optional<WidgetI> header, Optional<WidgetI> footer, Optional<EdgeInsetsGeometryI> margin, Optional<ColorI> backgroundColor, Optional<BoxDecorationI> decoration, Optional<Clip> clipBehavior, OptionalDouble dividerMargin, OptionalDouble additionalDividerMargin, OptionalDouble topMargin, Optional<Boolean> hasLeading, Optional<ColorI> separatorColor) {
    int id = factories.cupertinoListSectionCupertinoListSection(children.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())),
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
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoListSection");
    return new CupertinoListSection(id);
  }
  public static CupertinoListSectionCupertinoListSectionBuilder cupertinoListSection() {
    return CupertinoListSectionCupertinoListSectionBuilder.cupertinoListSectionCupertinoListSection();
  }
  @Builder.Factory
  static CupertinoListSection cupertinoListSectionInsetGrouped(Optional<List<WidgetI>> children, Optional<WidgetI> header, Optional<WidgetI> footer, Optional<EdgeInsetsGeometryI> margin, Optional<ColorI> backgroundColor, Optional<BoxDecorationI> decoration, Optional<Clip> clipBehavior, OptionalDouble dividerMargin, OptionalDouble additionalDividerMargin, OptionalDouble topMargin, Optional<Boolean> hasLeading, Optional<ColorI> separatorColor) {
    int id = factories.cupertinoListSectionInsetGrouped(children.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())),
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
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoListSection");
    return new CupertinoListSection(id);
  }
  public static CupertinoListSectionInsetGroupedBuilder insetGrouped() {
    return CupertinoListSectionInsetGroupedBuilder.cupertinoListSectionInsetGrouped();
  }
  public CupertinoListSectionType type() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoListSectionType not supported on web");
    return factories.CupertinoListSection_readBack_type(nativeStruct);
  }
  public Widget header() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoListSectionHeader not supported on web");
    return factories.CupertinoListSection_readBack_header(nativeStruct);
  }
  public Widget footer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoListSectionFooter not supported on web");
    return factories.CupertinoListSection_readBack_footer(nativeStruct);
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoListSectionMargin not supported on web");
    return factories.CupertinoListSection_readBack_margin(nativeStruct);
  }
  public BoxDecoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoListSectionDecoration", getId());
      return new BoxDecoration(__nid);
    }
    return factories.CupertinoListSection_readBack_decoration(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoListSectionBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoListSection_readBack_backgroundColor(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoListSectionClipBehavior not supported on web");
    return factories.CupertinoListSection_readBack_clipBehavior(nativeStruct);
  }
  public double dividerMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoListSectionDividerMargin not supported on web");
    return factories.CupertinoListSection_readBack_dividerMargin(nativeStruct);
  }
  public double additionalDividerMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoListSectionAdditionalDividerMargin not supported on web");
    return factories.CupertinoListSection_readBack_additionalDividerMargin(nativeStruct);
  }
  public double topMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoListSectionTopMargin not supported on web");
    return factories.CupertinoListSection_readBack_topMargin(nativeStruct);
  }
  public Color separatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoListSectionSeparatorColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoListSection_readBack_separatorColor(nativeStruct);
  }
  @Override
  public CupertinoListSection build() {
    return this;
  }
}
