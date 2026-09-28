package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoListTile extends StatefulWidget implements CupertinoListTileI {
  protected CupertinoListTile() {}
  CupertinoListTile(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoListTile");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoListTile cupertinoListTileCupertinoListTile(@Builder.Parameter WidgetI title, Optional<WidgetI> subtitle, Optional<WidgetI> additionalInfo, Optional<WidgetI> leading, Optional<WidgetI> trailing, Optional<Runnable> onTap, Optional<ColorI> backgroundColor, Optional<ColorI> backgroundColorActivated, Optional<EdgeInsetsGeometryI> padding, OptionalDouble leadingSize, OptionalDouble leadingToTitle) {
    int id = factories.cupertinoListTileCupertinoListTile(title.build(),
      subtitle.map(WidgetI::build),
      additionalInfo.map(WidgetI::build),
      leading.map(WidgetI::build),
      trailing.map(WidgetI::build),
      onTap,
      backgroundColor.map(ColorI::build),
      backgroundColorActivated.map(ColorI::build),
      padding.map(EdgeInsetsGeometryI::build),
      leadingSize,
      leadingToTitle);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoListTile");
    return new CupertinoListTile(id);
  }
  public static CupertinoListTileCupertinoListTileBuilder cupertinoListTile(WidgetI title) {
    return CupertinoListTileCupertinoListTileBuilder.cupertinoListTileCupertinoListTile(title);
  }
  @Builder.Factory
  static CupertinoListTile cupertinoListTileNotched(@Builder.Parameter WidgetI title, Optional<WidgetI> subtitle, Optional<WidgetI> additionalInfo, Optional<WidgetI> leading, Optional<WidgetI> trailing, Optional<Runnable> onTap, Optional<ColorI> backgroundColor, Optional<ColorI> backgroundColorActivated, Optional<EdgeInsetsGeometryI> padding, OptionalDouble leadingSize, OptionalDouble leadingToTitle) {
    int id = factories.cupertinoListTileNotched(title.build(),
      subtitle.map(WidgetI::build),
      additionalInfo.map(WidgetI::build),
      leading.map(WidgetI::build),
      trailing.map(WidgetI::build),
      onTap,
      backgroundColor.map(ColorI::build),
      backgroundColorActivated.map(ColorI::build),
      padding.map(EdgeInsetsGeometryI::build),
      leadingSize,
      leadingToTitle);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoListTile");
    return new CupertinoListTile(id);
  }
  public static CupertinoListTileNotchedBuilder notched(WidgetI title) {
    return CupertinoListTileNotchedBuilder.cupertinoListTileNotched(title);
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoListTileTitle not supported on web");
    return factories.CupertinoListTile_readBack_title(nativeStruct);
  }
  public Widget subtitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoListTileSubtitle not supported on web");
    return factories.CupertinoListTile_readBack_subtitle(nativeStruct);
  }
  public Widget additionalInfo() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoListTileAdditionalInfo not supported on web");
    return factories.CupertinoListTile_readBack_additionalInfo(nativeStruct);
  }
  public Widget leading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoListTileLeading not supported on web");
    return factories.CupertinoListTile_readBack_leading(nativeStruct);
  }
  public Widget trailing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoListTileTrailing not supported on web");
    return factories.CupertinoListTile_readBack_trailing(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoListTileBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoListTile_readBack_backgroundColor(nativeStruct);
  }
  public Color backgroundColorActivated() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoListTileBackgroundColorActivated", getId());
      return new Color(__nid);
    }
    return factories.CupertinoListTile_readBack_backgroundColorActivated(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoListTilePadding not supported on web");
    return factories.CupertinoListTile_readBack_padding(nativeStruct);
  }
  public double leadingSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoListTileLeadingSize not supported on web");
    return factories.CupertinoListTile_readBack_leadingSize(nativeStruct);
  }
  public double leadingToTitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoListTileLeadingToTitle not supported on web");
    return factories.CupertinoListTile_readBack_leadingToTitle(nativeStruct);
  }
  @Override
  public CupertinoListTile build() {
    return this;
  }
}
