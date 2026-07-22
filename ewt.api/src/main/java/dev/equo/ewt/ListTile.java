package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ListTileObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ListTile extends StatelessWidget implements ListTileI {
  private MemorySegment st;
  protected ListTile() {}
  ListTile(MemorySegment st) {
    this.id = ListTileObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ListTile");
    System.out.println("New ListTile id:"+id);
  }
  @Builder.Factory
  static ListTile listTileListTile(Optional<WidgetI> leading, Optional<WidgetI> title, Optional<WidgetI> subtitle, Optional<WidgetI> trailing, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<VisualDensityI> visualDensity, Optional<ShapeBorderI> shape, Optional<ListTileStyle> style, Optional<ColorI> selectedColor, Optional<ColorI> iconColor, Optional<ColorI> textColor, Optional<TextStyleI> titleTextStyle, Optional<TextStyleI> subtitleTextStyle, Optional<TextStyleI> leadingAndTrailingTextStyle, Optional<EdgeInsetsGeometryI> contentPadding, Optional<Boolean> enabled, Optional<Runnable> onTap, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> selected, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> splashColor, Optional<Boolean> autofocus, Optional<ColorI> tileColor, Optional<ColorI> selectedTileColor, Optional<Boolean> enableFeedback, OptionalDouble horizontalTitleGap, OptionalDouble minVerticalPadding, OptionalDouble minLeadingWidth, OptionalDouble minTileHeight, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> internalAddSemanticForOnTap) {
    var st = factories.listTileListTile(leading.map(WidgetI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget ListTile");
    return new ListTile(st);
  }
  public static ListTileListTileBuilder listTile() {
    return ListTileListTileBuilder.listTileListTile();
  }
  public Widget leading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileLeading not supported on web");
    return new Widget(ListTileObjSt.leading(st)) {};
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileTitle not supported on web");
    return new Widget(ListTileObjSt.title(st)) {};
  }
  public Widget subtitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileSubtitle not supported on web");
    return new Widget(ListTileObjSt.subtitle(st)) {};
  }
  public Widget trailing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileTrailing not supported on web");
    return new Widget(ListTileObjSt.trailing(st)) {};
  }
  public boolean isThreeLine() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileIsThreeLine not supported on web");
    return intToBool(ListTileObjSt.isThreeLine(st));
  }
  public boolean dense() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileDense not supported on web");
    return intToBool(ListTileObjSt.dense(st));
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileVisualDensity", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.VisualDensityObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.VisualDensityObjSt.id(__st, __nid);
      return new VisualDensity(__st);
    }
    return new VisualDensity(ListTileObjSt.visualDensity(st));
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileShape not supported on web");
    return new ShapeBorder(ListTileObjSt.shape(st)) {};
  }
  public Color selectedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileSelectedColor", getId());
      return new Color(__nid);
    }
    return new Color(ListTileObjSt.selectedColor(st));
  }
  public Color iconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileIconColor", getId());
      return new Color(__nid);
    }
    return new Color(ListTileObjSt.iconColor(st));
  }
  public Color textColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileTextColor", getId());
      return new Color(__nid);
    }
    return new Color(ListTileObjSt.textColor(st));
  }
  public TextStyle titleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileTitleTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(ListTileObjSt.titleTextStyle(st));
  }
  public TextStyle subtitleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileSubtitleTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(ListTileObjSt.subtitleTextStyle(st));
  }
  public TextStyle leadingAndTrailingTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileLeadingAndTrailingTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(ListTileObjSt.leadingAndTrailingTextStyle(st));
  }
  public ListTileStyle style() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileStyle not supported on web");
    return ListTileStyle.values()[ListTileObjSt.style(st)];
  }
  public EdgeInsetsGeometry contentPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileContentPadding not supported on web");
    return new EdgeInsetsGeometry(ListTileObjSt.contentPadding(st)) {};
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileEnabled not supported on web");
    return intToBool(ListTileObjSt.enabled(st));
  }
  public boolean selected() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileSelected not supported on web");
    return intToBool(ListTileObjSt.selected(st));
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileFocusColor", getId());
      return new Color(__nid);
    }
    return new Color(ListTileObjSt.focusColor(st));
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileHoverColor", getId());
      return new Color(__nid);
    }
    return new Color(ListTileObjSt.hoverColor(st));
  }
  public Color splashColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileSplashColor", getId());
      return new Color(__nid);
    }
    return new Color(ListTileObjSt.splashColor(st));
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileAutofocus not supported on web");
    return intToBool(ListTileObjSt.autofocus(st));
  }
  public Color tileColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileTileColor", getId());
      return new Color(__nid);
    }
    return new Color(ListTileObjSt.tileColor(st));
  }
  public Color selectedTileColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("listTileSelectedTileColor", getId());
      return new Color(__nid);
    }
    return new Color(ListTileObjSt.selectedTileColor(st));
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileEnableFeedback not supported on web");
    return intToBool(ListTileObjSt.enableFeedback(st));
  }
  public double horizontalTitleGap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileHorizontalTitleGap not supported on web");
    return ListTileObjSt.horizontalTitleGap(st);
  }
  public double minVerticalPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileMinVerticalPadding not supported on web");
    return ListTileObjSt.minVerticalPadding(st);
  }
  public double minLeadingWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileMinLeadingWidth not supported on web");
    return ListTileObjSt.minLeadingWidth(st);
  }
  public double minTileHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileMinTileHeight not supported on web");
    return ListTileObjSt.minTileHeight(st);
  }
  public ListTileTitleAlignment titleAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileTitleAlignment not supported on web");
    return ListTileTitleAlignment.values()[ListTileObjSt.titleAlignment(st)];
  }
  public boolean internalAddSemanticForOnTap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listTileInternalAddSemanticForOnTap not supported on web");
    return intToBool(ListTileObjSt.internalAddSemanticForOnTap(st));
  }
  @Override
  public ListTile build() {
    return this;
  }
}
