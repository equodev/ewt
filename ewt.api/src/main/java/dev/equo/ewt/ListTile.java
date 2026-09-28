package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ListTile extends StatelessWidget implements ListTileI {
  protected ListTile() {}
  ListTile(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ListTile");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ListTile listTileListTile(Optional<WidgetI> leading, Optional<WidgetI> title, Optional<WidgetI> subtitle, Optional<WidgetI> trailing, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<VisualDensityI> visualDensity, Optional<ShapeBorderI> shape, Optional<ListTileStyle> style, Optional<ColorI> selectedColor, Optional<ColorI> iconColor, Optional<ColorI> textColor, Optional<TextStyleI> titleTextStyle, Optional<TextStyleI> subtitleTextStyle, Optional<TextStyleI> leadingAndTrailingTextStyle, Optional<EdgeInsetsGeometryI> contentPadding, Optional<Boolean> enabled, Optional<Runnable> onTap, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> selected, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> splashColor, Optional<Boolean> autofocus, Optional<ColorI> tileColor, Optional<ColorI> selectedTileColor, Optional<Boolean> enableFeedback, OptionalDouble horizontalTitleGap, OptionalDouble minVerticalPadding, OptionalDouble minLeadingWidth, OptionalDouble minTileHeight, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> internalAddSemanticForOnTap) {
    int id = factories.listTileListTile(leading.map(WidgetI::build),
      title.map(WidgetI::build),
      subtitle.map(WidgetI::build),
      trailing.map(WidgetI::build),
      isThreeLine,
      dense,
      visualDensity.map(VisualDensityI::build),
      shape.map(ShapeBorderI::build),
      style,
      selectedColor.map(ColorI::build),
      iconColor.map(ColorI::build),
      textColor.map(ColorI::build),
      titleTextStyle.map(TextStyleI::build),
      subtitleTextStyle.map(TextStyleI::build),
      leadingAndTrailingTextStyle.map(TextStyleI::build),
      contentPadding.map(EdgeInsetsGeometryI::build),
      enabled,
      onTap,
      onLongPress,
      onFocusChange,
      selected,
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      autofocus,
      tileColor.map(ColorI::build),
      selectedTileColor.map(ColorI::build),
      enableFeedback,
      horizontalTitleGap,
      minVerticalPadding,
      minLeadingWidth,
      minTileHeight,
      titleAlignment,
      internalAddSemanticForOnTap);
    if (id <= 0) throw new RuntimeException("Failed to created widget ListTile");
    return new ListTile(id);
  }
  public static ListTileListTileBuilder listTile() {
    return ListTileListTileBuilder.listTileListTile();
  }
  public Widget leading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileLeading not supported on web");
    return factories.ListTile_readBack_leading(nativeStruct);
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileTitle not supported on web");
    return factories.ListTile_readBack_title(nativeStruct);
  }
  public Widget subtitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileSubtitle not supported on web");
    return factories.ListTile_readBack_subtitle(nativeStruct);
  }
  public Widget trailing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileTrailing not supported on web");
    return factories.ListTile_readBack_trailing(nativeStruct);
  }
  public boolean isThreeLine() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileIsThreeLine not supported on web");
    return factories.ListTile_readBack_isThreeLine(nativeStruct);
  }
  public boolean dense() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileDense not supported on web");
    return factories.ListTile_readBack_dense(nativeStruct);
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileVisualDensity", getId());
      return new VisualDensity(__nid);
    }
    return factories.ListTile_readBack_visualDensity(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileShape not supported on web");
    return factories.ListTile_readBack_shape(nativeStruct);
  }
  public Color selectedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileSelectedColor", getId());
      return new Color(__nid);
    }
    return factories.ListTile_readBack_selectedColor(nativeStruct);
  }
  public Color iconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileIconColor", getId());
      return new Color(__nid);
    }
    return factories.ListTile_readBack_iconColor(nativeStruct);
  }
  public Color textColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileTextColor", getId());
      return new Color(__nid);
    }
    return factories.ListTile_readBack_textColor(nativeStruct);
  }
  public TextStyle titleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileTitleTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.ListTile_readBack_titleTextStyle(nativeStruct);
  }
  public TextStyle subtitleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileSubtitleTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.ListTile_readBack_subtitleTextStyle(nativeStruct);
  }
  public TextStyle leadingAndTrailingTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileLeadingAndTrailingTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.ListTile_readBack_leadingAndTrailingTextStyle(nativeStruct);
  }
  public ListTileStyle style() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileStyle not supported on web");
    return factories.ListTile_readBack_style(nativeStruct);
  }
  public EdgeInsetsGeometry contentPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileContentPadding not supported on web");
    return factories.ListTile_readBack_contentPadding(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileEnabled not supported on web");
    return factories.ListTile_readBack_enabled(nativeStruct);
  }
  public boolean selected() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileSelected not supported on web");
    return factories.ListTile_readBack_selected(nativeStruct);
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileFocusColor", getId());
      return new Color(__nid);
    }
    return factories.ListTile_readBack_focusColor(nativeStruct);
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileHoverColor", getId());
      return new Color(__nid);
    }
    return factories.ListTile_readBack_hoverColor(nativeStruct);
  }
  public Color splashColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileSplashColor", getId());
      return new Color(__nid);
    }
    return factories.ListTile_readBack_splashColor(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileAutofocus not supported on web");
    return factories.ListTile_readBack_autofocus(nativeStruct);
  }
  public Color tileColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileTileColor", getId());
      return new Color(__nid);
    }
    return factories.ListTile_readBack_tileColor(nativeStruct);
  }
  public Color selectedTileColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileSelectedTileColor", getId());
      return new Color(__nid);
    }
    return factories.ListTile_readBack_selectedTileColor(nativeStruct);
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileEnableFeedback not supported on web");
    return factories.ListTile_readBack_enableFeedback(nativeStruct);
  }
  public double horizontalTitleGap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileHorizontalTitleGap not supported on web");
    return factories.ListTile_readBack_horizontalTitleGap(nativeStruct);
  }
  public double minVerticalPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileMinVerticalPadding not supported on web");
    return factories.ListTile_readBack_minVerticalPadding(nativeStruct);
  }
  public double minLeadingWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileMinLeadingWidth not supported on web");
    return factories.ListTile_readBack_minLeadingWidth(nativeStruct);
  }
  public double minTileHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileMinTileHeight not supported on web");
    return factories.ListTile_readBack_minTileHeight(nativeStruct);
  }
  public ListTileTitleAlignment titleAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileTitleAlignment not supported on web");
    return factories.ListTile_readBack_titleAlignment(nativeStruct);
  }
  public boolean internalAddSemanticForOnTap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileInternalAddSemanticForOnTap not supported on web");
    return factories.ListTile_readBack_internalAddSemanticForOnTap(nativeStruct);
  }
  @Override
  public ListTile build() {
    return this;
  }
}
