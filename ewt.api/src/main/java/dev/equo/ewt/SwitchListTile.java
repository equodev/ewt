package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SwitchListTile extends StatelessWidget implements SwitchListTileI {
  protected SwitchListTile() {}
  SwitchListTile(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SwitchListTile");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SwitchListTile switchListTileSwitchListTile(@Builder.Parameter boolean value, Optional<Consumer<Boolean>> onChanged, Optional<ColorI> activeColor, Optional<ColorI> activeThumbColor, Optional<ColorI> activeTrackColor, Optional<ColorI> inactiveThumbColor, Optional<ColorI> inactiveTrackColor, Optional<ColorI> thumbColor, Optional<ColorI> trackColor, Optional<ColorI> trackOutlineColor, Optional<IconI> thumbIcon, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<DragStartBehavior> dragStartBehavior, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<ColorI> tileColor, Optional<WidgetI> title, Optional<WidgetI> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<EdgeInsetsGeometryI> contentPadding, Optional<WidgetI> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<ShapeBorderI> shape, Optional<ColorI> selectedTileColor, Optional<VisualDensityI> visualDensity, Optional<Boolean> enableFeedback, OptionalDouble horizontalTitleGap, OptionalDouble minVerticalPadding, OptionalDouble minLeadingWidth, OptionalDouble minTileHeight, Optional<ColorI> hoverColor, Optional<Boolean> internalAddSemanticForOnTap) {
    int id = factories.switchListTileSwitchListTile(value,
      onChanged,
      activeColor.map(ColorI::build),
      activeThumbColor.map(ColorI::build),
      activeTrackColor.map(ColorI::build),
      inactiveThumbColor.map(ColorI::build),
      inactiveTrackColor.map(ColorI::build),
      thumbColor.map(ColorI::build),
      trackColor.map(ColorI::build),
      trackOutlineColor.map(ColorI::build),
      thumbIcon.map(IconI::build),
      materialTapTargetSize,
      dragStartBehavior,
      overlayColor.map(ColorI::build),
      splashRadius,
      onFocusChange,
      autofocus,
      tileColor.map(ColorI::build),
      title.map(WidgetI::build),
      subtitle.map(WidgetI::build),
      isThreeLine,
      dense,
      contentPadding.map(EdgeInsetsGeometryI::build),
      secondary.map(WidgetI::build),
      selected,
      controlAffinity,
      shape.map(ShapeBorderI::build),
      selectedTileColor.map(ColorI::build),
      visualDensity.map(VisualDensityI::build),
      enableFeedback,
      horizontalTitleGap,
      minVerticalPadding,
      minLeadingWidth,
      minTileHeight,
      hoverColor.map(ColorI::build),
      internalAddSemanticForOnTap);
    if (id <= 0) throw new RuntimeException("Failed to created widget SwitchListTile");
    return new SwitchListTile(id);
  }
  public static SwitchListTileSwitchListTileBuilder switchListTile(boolean value) {
    return SwitchListTileSwitchListTileBuilder.switchListTileSwitchListTile(value);
  }
  @Builder.Factory
  static SwitchListTile switchListTileAdaptive(@Builder.Parameter boolean value, Optional<Consumer<Boolean>> onChanged, Optional<ColorI> activeColor, Optional<ColorI> activeThumbColor, Optional<ColorI> activeTrackColor, Optional<ColorI> inactiveThumbColor, Optional<ColorI> inactiveTrackColor, Optional<ColorI> thumbColor, Optional<ColorI> trackColor, Optional<ColorI> trackOutlineColor, Optional<IconI> thumbIcon, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<DragStartBehavior> dragStartBehavior, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Boolean> applyCupertinoTheme, Optional<ColorI> tileColor, Optional<WidgetI> title, Optional<WidgetI> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<EdgeInsetsGeometryI> contentPadding, Optional<WidgetI> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<ShapeBorderI> shape, Optional<ColorI> selectedTileColor, Optional<VisualDensityI> visualDensity, Optional<Boolean> enableFeedback, OptionalDouble horizontalTitleGap, OptionalDouble minVerticalPadding, OptionalDouble minLeadingWidth, OptionalDouble minTileHeight, Optional<ColorI> hoverColor, Optional<Boolean> internalAddSemanticForOnTap) {
    int id = factories.switchListTileAdaptive(value,
      onChanged,
      activeColor.map(ColorI::build),
      activeThumbColor.map(ColorI::build),
      activeTrackColor.map(ColorI::build),
      inactiveThumbColor.map(ColorI::build),
      inactiveTrackColor.map(ColorI::build),
      thumbColor.map(ColorI::build),
      trackColor.map(ColorI::build),
      trackOutlineColor.map(ColorI::build),
      thumbIcon.map(IconI::build),
      materialTapTargetSize,
      dragStartBehavior,
      overlayColor.map(ColorI::build),
      splashRadius,
      onFocusChange,
      autofocus,
      applyCupertinoTheme,
      tileColor.map(ColorI::build),
      title.map(WidgetI::build),
      subtitle.map(WidgetI::build),
      isThreeLine,
      dense,
      contentPadding.map(EdgeInsetsGeometryI::build),
      secondary.map(WidgetI::build),
      selected,
      controlAffinity,
      shape.map(ShapeBorderI::build),
      selectedTileColor.map(ColorI::build),
      visualDensity.map(VisualDensityI::build),
      enableFeedback,
      horizontalTitleGap,
      minVerticalPadding,
      minLeadingWidth,
      minTileHeight,
      hoverColor.map(ColorI::build),
      internalAddSemanticForOnTap);
    if (id <= 0) throw new RuntimeException("Failed to created widget SwitchListTile");
    return new SwitchListTile(id);
  }
  public static SwitchListTileAdaptiveBuilder adaptive(boolean value) {
    return SwitchListTileAdaptiveBuilder.switchListTileAdaptive(value);
  }
  public boolean value() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileValue not supported on web");
    return factories.SwitchListTile_readBack_value(nativeStruct);
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switchListTileActiveColor", getId());
      return new Color(__nid);
    }
    return factories.SwitchListTile_readBack_activeColor(nativeStruct);
  }
  public Color activeThumbColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switchListTileActiveThumbColor", getId());
      return new Color(__nid);
    }
    return factories.SwitchListTile_readBack_activeThumbColor(nativeStruct);
  }
  public Color activeTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switchListTileActiveTrackColor", getId());
      return new Color(__nid);
    }
    return factories.SwitchListTile_readBack_activeTrackColor(nativeStruct);
  }
  public Color inactiveThumbColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switchListTileInactiveThumbColor", getId());
      return new Color(__nid);
    }
    return factories.SwitchListTile_readBack_inactiveThumbColor(nativeStruct);
  }
  public Color inactiveTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switchListTileInactiveTrackColor", getId());
      return new Color(__nid);
    }
    return factories.SwitchListTile_readBack_inactiveTrackColor(nativeStruct);
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileMaterialTapTargetSize not supported on web");
    return factories.SwitchListTile_readBack_materialTapTargetSize(nativeStruct);
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileDragStartBehavior not supported on web");
    return factories.SwitchListTile_readBack_dragStartBehavior(nativeStruct);
  }
  public double splashRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileSplashRadius not supported on web");
    return factories.SwitchListTile_readBack_splashRadius(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileAutofocus not supported on web");
    return factories.SwitchListTile_readBack_autofocus(nativeStruct);
  }
  public Color tileColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switchListTileTileColor", getId());
      return new Color(__nid);
    }
    return factories.SwitchListTile_readBack_tileColor(nativeStruct);
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileTitle not supported on web");
    return factories.SwitchListTile_readBack_title(nativeStruct);
  }
  public Widget subtitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileSubtitle not supported on web");
    return factories.SwitchListTile_readBack_subtitle(nativeStruct);
  }
  public Widget secondary() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileSecondary not supported on web");
    return factories.SwitchListTile_readBack_secondary(nativeStruct);
  }
  public boolean isThreeLine() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileIsThreeLine not supported on web");
    return factories.SwitchListTile_readBack_isThreeLine(nativeStruct);
  }
  public boolean dense() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileDense not supported on web");
    return factories.SwitchListTile_readBack_dense(nativeStruct);
  }
  public EdgeInsetsGeometry contentPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileContentPadding not supported on web");
    return factories.SwitchListTile_readBack_contentPadding(nativeStruct);
  }
  public boolean selected() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileSelected not supported on web");
    return factories.SwitchListTile_readBack_selected(nativeStruct);
  }
  public ListTileControlAffinity controlAffinity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileControlAffinity not supported on web");
    return factories.SwitchListTile_readBack_controlAffinity(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileShape not supported on web");
    return factories.SwitchListTile_readBack_shape(nativeStruct);
  }
  public Color selectedTileColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switchListTileSelectedTileColor", getId());
      return new Color(__nid);
    }
    return factories.SwitchListTile_readBack_selectedTileColor(nativeStruct);
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switchListTileVisualDensity", getId());
      return new VisualDensity(__nid);
    }
    return factories.SwitchListTile_readBack_visualDensity(nativeStruct);
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileEnableFeedback not supported on web");
    return factories.SwitchListTile_readBack_enableFeedback(nativeStruct);
  }
  public double horizontalTitleGap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileHorizontalTitleGap not supported on web");
    return factories.SwitchListTile_readBack_horizontalTitleGap(nativeStruct);
  }
  public double minVerticalPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileMinVerticalPadding not supported on web");
    return factories.SwitchListTile_readBack_minVerticalPadding(nativeStruct);
  }
  public double minLeadingWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileMinLeadingWidth not supported on web");
    return factories.SwitchListTile_readBack_minLeadingWidth(nativeStruct);
  }
  public double minTileHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileMinTileHeight not supported on web");
    return factories.SwitchListTile_readBack_minTileHeight(nativeStruct);
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switchListTileHoverColor", getId());
      return new Color(__nid);
    }
    return factories.SwitchListTile_readBack_hoverColor(nativeStruct);
  }
  public boolean applyCupertinoTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileApplyCupertinoTheme not supported on web");
    return factories.SwitchListTile_readBack_applyCupertinoTheme(nativeStruct);
  }
  public boolean internalAddSemanticForOnTap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileInternalAddSemanticForOnTap not supported on web");
    return factories.SwitchListTile_readBack_internalAddSemanticForOnTap(nativeStruct);
  }
  @Override
  public SwitchListTile build() {
    return this;
  }
}
