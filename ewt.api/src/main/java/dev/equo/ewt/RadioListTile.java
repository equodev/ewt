package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class RadioListTile<T> extends StatefulWidget implements RadioListTileI {
  protected RadioListTile() {}
  RadioListTile(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget RadioListTile");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static <T extends NativeObj> RadioListTile<T> radioListTileRadioListTile(@Builder.Parameter NativeObj value, Optional<NativeObj> groupValue, Optional<Consumer<NativeObj>> onChanged, Optional<Boolean> toggleable, Optional<ColorI> activeColor, Optional<ColorI> fillColor, Optional<ColorI> hoverColor, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<WidgetI> title, Optional<WidgetI> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<WidgetI> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<Boolean> autofocus, Optional<EdgeInsetsGeometryI> contentPadding, Optional<ShapeBorderI> shape, Optional<ColorI> tileColor, Optional<ColorI> selectedTileColor, Optional<VisualDensityI> visualDensity, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> enableFeedback, OptionalDouble horizontalTitleGap, OptionalDouble minVerticalPadding, OptionalDouble minLeadingWidth, OptionalDouble minTileHeight, OptionalDouble radioScaleFactor, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> enabled, Optional<Boolean> internalAddSemanticForOnTap, Optional<ColorI> radioBackgroundColor, Optional<BorderSideI> radioSide, OptionalDouble radioInnerRadius) {
    int id = factories.radioListTileRadioListTile(value,
      groupValue,
      onChanged,
      toggleable,
      activeColor.map(ColorI::build),
      fillColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      splashRadius,
      materialTapTargetSize,
      title.map(WidgetI::build),
      subtitle.map(WidgetI::build),
      isThreeLine,
      dense,
      secondary.map(WidgetI::build),
      selected,
      controlAffinity,
      autofocus,
      contentPadding.map(EdgeInsetsGeometryI::build),
      shape.map(ShapeBorderI::build),
      tileColor.map(ColorI::build),
      selectedTileColor.map(ColorI::build),
      visualDensity.map(VisualDensityI::build),
      onFocusChange,
      enableFeedback,
      horizontalTitleGap,
      minVerticalPadding,
      minLeadingWidth,
      minTileHeight,
      radioScaleFactor,
      titleAlignment,
      enabled,
      internalAddSemanticForOnTap,
      radioBackgroundColor.map(ColorI::build),
      radioSide.map(BorderSideI::build),
      radioInnerRadius);
    if (id <= 0) throw new RuntimeException("Failed to created widget RadioListTile");
    return new RadioListTile(id);
  }
  public static <T extends NativeObj> RadioListTileRadioListTileBuilder<T> radioListTile(NativeObj value) {
    return RadioListTileRadioListTileBuilder.radioListTileRadioListTile(value);
  }
  @Builder.Factory
  static <T extends NativeObj> RadioListTile<T> radioListTileAdaptive(@Builder.Parameter NativeObj value, Optional<NativeObj> groupValue, Optional<Consumer<NativeObj>> onChanged, Optional<Boolean> toggleable, Optional<ColorI> activeColor, Optional<ColorI> fillColor, Optional<ColorI> hoverColor, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<WidgetI> title, Optional<WidgetI> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<WidgetI> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<Boolean> autofocus, Optional<EdgeInsetsGeometryI> contentPadding, Optional<ShapeBorderI> shape, Optional<ColorI> tileColor, Optional<ColorI> selectedTileColor, Optional<VisualDensityI> visualDensity, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> enableFeedback, OptionalDouble horizontalTitleGap, OptionalDouble minVerticalPadding, OptionalDouble minLeadingWidth, OptionalDouble minTileHeight, OptionalDouble radioScaleFactor, Optional<Boolean> enabled, Optional<Boolean> useCupertinoCheckmarkStyle, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> internalAddSemanticForOnTap, Optional<ColorI> radioBackgroundColor, Optional<BorderSideI> radioSide, OptionalDouble radioInnerRadius) {
    int id = factories.radioListTileAdaptive(value,
      groupValue,
      onChanged,
      toggleable,
      activeColor.map(ColorI::build),
      fillColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      splashRadius,
      materialTapTargetSize,
      title.map(WidgetI::build),
      subtitle.map(WidgetI::build),
      isThreeLine,
      dense,
      secondary.map(WidgetI::build),
      selected,
      controlAffinity,
      autofocus,
      contentPadding.map(EdgeInsetsGeometryI::build),
      shape.map(ShapeBorderI::build),
      tileColor.map(ColorI::build),
      selectedTileColor.map(ColorI::build),
      visualDensity.map(VisualDensityI::build),
      onFocusChange,
      enableFeedback,
      horizontalTitleGap,
      minVerticalPadding,
      minLeadingWidth,
      minTileHeight,
      radioScaleFactor,
      enabled,
      useCupertinoCheckmarkStyle,
      titleAlignment,
      internalAddSemanticForOnTap,
      radioBackgroundColor.map(ColorI::build),
      radioSide.map(BorderSideI::build),
      radioInnerRadius);
    if (id <= 0) throw new RuntimeException("Failed to created widget RadioListTile");
    return new RadioListTile(id);
  }
  public static <T extends NativeObj> RadioListTileAdaptiveBuilder<T> adaptive(NativeObj value) {
    return RadioListTileAdaptiveBuilder.radioListTileAdaptive(value);
  }
  public boolean toggleable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileToggleable not supported on web");
    return factories.RadioListTile_readBack_toggleable(nativeStruct);
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioListTileActiveColor", getId());
      return new Color(__nid);
    }
    return factories.RadioListTile_readBack_activeColor(nativeStruct);
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileMaterialTapTargetSize not supported on web");
    return factories.RadioListTile_readBack_materialTapTargetSize(nativeStruct);
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioListTileHoverColor", getId());
      return new Color(__nid);
    }
    return factories.RadioListTile_readBack_hoverColor(nativeStruct);
  }
  public double splashRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileSplashRadius not supported on web");
    return factories.RadioListTile_readBack_splashRadius(nativeStruct);
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileTitle not supported on web");
    return factories.RadioListTile_readBack_title(nativeStruct);
  }
  public Widget subtitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileSubtitle not supported on web");
    return factories.RadioListTile_readBack_subtitle(nativeStruct);
  }
  public Widget secondary() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileSecondary not supported on web");
    return factories.RadioListTile_readBack_secondary(nativeStruct);
  }
  public boolean isThreeLine() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileIsThreeLine not supported on web");
    return factories.RadioListTile_readBack_isThreeLine(nativeStruct);
  }
  public boolean dense() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileDense not supported on web");
    return factories.RadioListTile_readBack_dense(nativeStruct);
  }
  public boolean selected() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileSelected not supported on web");
    return factories.RadioListTile_readBack_selected(nativeStruct);
  }
  public ListTileControlAffinity controlAffinity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileControlAffinity not supported on web");
    return factories.RadioListTile_readBack_controlAffinity(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileAutofocus not supported on web");
    return factories.RadioListTile_readBack_autofocus(nativeStruct);
  }
  public EdgeInsetsGeometry contentPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileContentPadding not supported on web");
    return factories.RadioListTile_readBack_contentPadding(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileShape not supported on web");
    return factories.RadioListTile_readBack_shape(nativeStruct);
  }
  public Color tileColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioListTileTileColor", getId());
      return new Color(__nid);
    }
    return factories.RadioListTile_readBack_tileColor(nativeStruct);
  }
  public Color selectedTileColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioListTileSelectedTileColor", getId());
      return new Color(__nid);
    }
    return factories.RadioListTile_readBack_selectedTileColor(nativeStruct);
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioListTileVisualDensity", getId());
      return new VisualDensity(__nid);
    }
    return factories.RadioListTile_readBack_visualDensity(nativeStruct);
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileEnableFeedback not supported on web");
    return factories.RadioListTile_readBack_enableFeedback(nativeStruct);
  }
  public double horizontalTitleGap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileHorizontalTitleGap not supported on web");
    return factories.RadioListTile_readBack_horizontalTitleGap(nativeStruct);
  }
  public double minVerticalPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileMinVerticalPadding not supported on web");
    return factories.RadioListTile_readBack_minVerticalPadding(nativeStruct);
  }
  public double minLeadingWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileMinLeadingWidth not supported on web");
    return factories.RadioListTile_readBack_minLeadingWidth(nativeStruct);
  }
  public double minTileHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileMinTileHeight not supported on web");
    return factories.RadioListTile_readBack_minTileHeight(nativeStruct);
  }
  public ListTileTitleAlignment titleAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileTitleAlignment not supported on web");
    return factories.RadioListTile_readBack_titleAlignment(nativeStruct);
  }
  public boolean internalAddSemanticForOnTap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileInternalAddSemanticForOnTap not supported on web");
    return factories.RadioListTile_readBack_internalAddSemanticForOnTap(nativeStruct);
  }
  public boolean useCupertinoCheckmarkStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileUseCupertinoCheckmarkStyle not supported on web");
    return factories.RadioListTile_readBack_useCupertinoCheckmarkStyle(nativeStruct);
  }
  public double radioScaleFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileRadioScaleFactor not supported on web");
    return factories.RadioListTile_readBack_radioScaleFactor(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileEnabled not supported on web");
    return factories.RadioListTile_readBack_enabled(nativeStruct);
  }
  public BorderSide radioSide() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioListTileRadioSide", getId());
      return new BorderSide(__nid);
    }
    return factories.RadioListTile_readBack_radioSide(nativeStruct);
  }
  public boolean checked() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileChecked not supported on web");
    return factories.RadioListTile_readBack_checked(nativeStruct);
  }
  @Override
  public RadioListTile build() {
    return this;
  }
}
