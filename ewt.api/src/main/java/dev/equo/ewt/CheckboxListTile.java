package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CheckboxListTile extends StatelessWidget implements CheckboxListTileI {
  protected CheckboxListTile() {}
  CheckboxListTile(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CheckboxListTile");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CheckboxListTile checkboxListTileCheckboxListTile(Optional<Boolean> value, Optional<Consumer<Boolean>> onChanged, Optional<ColorI> activeColor, Optional<ColorI> fillColor, Optional<ColorI> checkColor, Optional<ColorI> hoverColor, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensityI> visualDensity, Optional<Boolean> autofocus, Optional<ShapeBorderI> shape, Optional<BorderSideI> side, Optional<Boolean> isError, Optional<Boolean> enabled, Optional<ColorI> tileColor, Optional<WidgetI> title, Optional<WidgetI> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<WidgetI> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<EdgeInsetsGeometryI> contentPadding, Optional<Boolean> tristate, Optional<OutlinedBorderI> checkboxShape, Optional<ColorI> selectedTileColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> enableFeedback, OptionalDouble horizontalTitleGap, OptionalDouble minVerticalPadding, OptionalDouble minLeadingWidth, OptionalDouble minTileHeight, Optional<String> checkboxSemanticLabel, OptionalDouble checkboxScaleFactor, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> internalAddSemanticForOnTap) {
    int id = factories.checkboxListTileCheckboxListTile(value,
      onChanged,
      activeColor.map(ColorI::build),
      fillColor.map(ColorI::build),
      checkColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      splashRadius,
      materialTapTargetSize,
      visualDensity.map(VisualDensityI::build),
      autofocus,
      shape.map(ShapeBorderI::build),
      side.map(BorderSideI::build),
      isError,
      enabled,
      tileColor.map(ColorI::build),
      title.map(WidgetI::build),
      subtitle.map(WidgetI::build),
      isThreeLine,
      dense,
      secondary.map(WidgetI::build),
      selected,
      controlAffinity,
      contentPadding.map(EdgeInsetsGeometryI::build),
      tristate,
      checkboxShape.map(OutlinedBorderI::build),
      selectedTileColor.map(ColorI::build),
      onFocusChange,
      enableFeedback,
      horizontalTitleGap,
      minVerticalPadding,
      minLeadingWidth,
      minTileHeight,
      checkboxSemanticLabel,
      checkboxScaleFactor,
      titleAlignment,
      internalAddSemanticForOnTap);
    if (id <= 0) throw new RuntimeException("Failed to created widget CheckboxListTile");
    return new CheckboxListTile(id);
  }
  public static CheckboxListTileCheckboxListTileBuilder checkboxListTile() {
    return CheckboxListTileCheckboxListTileBuilder.checkboxListTileCheckboxListTile();
  }
  @Builder.Factory
  static CheckboxListTile checkboxListTileAdaptive(Optional<Boolean> value, Optional<Consumer<Boolean>> onChanged, Optional<ColorI> activeColor, Optional<ColorI> fillColor, Optional<ColorI> checkColor, Optional<ColorI> hoverColor, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensityI> visualDensity, Optional<Boolean> autofocus, Optional<ShapeBorderI> shape, Optional<BorderSideI> side, Optional<Boolean> isError, Optional<Boolean> enabled, Optional<ColorI> tileColor, Optional<WidgetI> title, Optional<WidgetI> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<WidgetI> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<EdgeInsetsGeometryI> contentPadding, Optional<Boolean> tristate, Optional<OutlinedBorderI> checkboxShape, Optional<ColorI> selectedTileColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> enableFeedback, OptionalDouble horizontalTitleGap, OptionalDouble minVerticalPadding, OptionalDouble minLeadingWidth, OptionalDouble minTileHeight, Optional<String> checkboxSemanticLabel, OptionalDouble checkboxScaleFactor, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> internalAddSemanticForOnTap) {
    int id = factories.checkboxListTileAdaptive(value,
      onChanged,
      activeColor.map(ColorI::build),
      fillColor.map(ColorI::build),
      checkColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      splashRadius,
      materialTapTargetSize,
      visualDensity.map(VisualDensityI::build),
      autofocus,
      shape.map(ShapeBorderI::build),
      side.map(BorderSideI::build),
      isError,
      enabled,
      tileColor.map(ColorI::build),
      title.map(WidgetI::build),
      subtitle.map(WidgetI::build),
      isThreeLine,
      dense,
      secondary.map(WidgetI::build),
      selected,
      controlAffinity,
      contentPadding.map(EdgeInsetsGeometryI::build),
      tristate,
      checkboxShape.map(OutlinedBorderI::build),
      selectedTileColor.map(ColorI::build),
      onFocusChange,
      enableFeedback,
      horizontalTitleGap,
      minVerticalPadding,
      minLeadingWidth,
      minTileHeight,
      checkboxSemanticLabel,
      checkboxScaleFactor,
      titleAlignment,
      internalAddSemanticForOnTap);
    if (id <= 0) throw new RuntimeException("Failed to created widget CheckboxListTile");
    return new CheckboxListTile(id);
  }
  public static CheckboxListTileAdaptiveBuilder adaptive() {
    return CheckboxListTileAdaptiveBuilder.checkboxListTileAdaptive();
  }
  public boolean value() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileValue not supported on web");
    return factories.CheckboxListTile_readBack_value(nativeStruct);
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxListTileActiveColor", getId());
      return new Color(__nid);
    }
    return factories.CheckboxListTile_readBack_activeColor(nativeStruct);
  }
  public Color checkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxListTileCheckColor", getId());
      return new Color(__nid);
    }
    return factories.CheckboxListTile_readBack_checkColor(nativeStruct);
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxListTileHoverColor", getId());
      return new Color(__nid);
    }
    return factories.CheckboxListTile_readBack_hoverColor(nativeStruct);
  }
  public double splashRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileSplashRadius not supported on web");
    return factories.CheckboxListTile_readBack_splashRadius(nativeStruct);
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileMaterialTapTargetSize not supported on web");
    return factories.CheckboxListTile_readBack_materialTapTargetSize(nativeStruct);
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxListTileVisualDensity", getId());
      return new VisualDensity(__nid);
    }
    return factories.CheckboxListTile_readBack_visualDensity(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileAutofocus not supported on web");
    return factories.CheckboxListTile_readBack_autofocus(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileShape not supported on web");
    return factories.CheckboxListTile_readBack_shape(nativeStruct);
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxListTileSide", getId());
      return new BorderSide(__nid);
    }
    return factories.CheckboxListTile_readBack_side(nativeStruct);
  }
  public boolean isError() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileIsError not supported on web");
    return factories.CheckboxListTile_readBack_isError(nativeStruct);
  }
  public Color tileColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxListTileTileColor", getId());
      return new Color(__nid);
    }
    return factories.CheckboxListTile_readBack_tileColor(nativeStruct);
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileTitle not supported on web");
    return factories.CheckboxListTile_readBack_title(nativeStruct);
  }
  public Widget subtitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileSubtitle not supported on web");
    return factories.CheckboxListTile_readBack_subtitle(nativeStruct);
  }
  public Widget secondary() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileSecondary not supported on web");
    return factories.CheckboxListTile_readBack_secondary(nativeStruct);
  }
  public boolean isThreeLine() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileIsThreeLine not supported on web");
    return factories.CheckboxListTile_readBack_isThreeLine(nativeStruct);
  }
  public boolean dense() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileDense not supported on web");
    return factories.CheckboxListTile_readBack_dense(nativeStruct);
  }
  public boolean selected() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileSelected not supported on web");
    return factories.CheckboxListTile_readBack_selected(nativeStruct);
  }
  public ListTileControlAffinity controlAffinity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileControlAffinity not supported on web");
    return factories.CheckboxListTile_readBack_controlAffinity(nativeStruct);
  }
  public EdgeInsetsGeometry contentPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileContentPadding not supported on web");
    return factories.CheckboxListTile_readBack_contentPadding(nativeStruct);
  }
  public boolean tristate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileTristate not supported on web");
    return factories.CheckboxListTile_readBack_tristate(nativeStruct);
  }
  public OutlinedBorder checkboxShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileCheckboxShape not supported on web");
    return factories.CheckboxListTile_readBack_checkboxShape(nativeStruct);
  }
  public Color selectedTileColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxListTileSelectedTileColor", getId());
      return new Color(__nid);
    }
    return factories.CheckboxListTile_readBack_selectedTileColor(nativeStruct);
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileEnableFeedback not supported on web");
    return factories.CheckboxListTile_readBack_enableFeedback(nativeStruct);
  }
  public double horizontalTitleGap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileHorizontalTitleGap not supported on web");
    return factories.CheckboxListTile_readBack_horizontalTitleGap(nativeStruct);
  }
  public double minVerticalPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileMinVerticalPadding not supported on web");
    return factories.CheckboxListTile_readBack_minVerticalPadding(nativeStruct);
  }
  public double minLeadingWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileMinLeadingWidth not supported on web");
    return factories.CheckboxListTile_readBack_minLeadingWidth(nativeStruct);
  }
  public double minTileHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileMinTileHeight not supported on web");
    return factories.CheckboxListTile_readBack_minTileHeight(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileEnabled not supported on web");
    return factories.CheckboxListTile_readBack_enabled(nativeStruct);
  }
  public ListTileTitleAlignment titleAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileTitleAlignment not supported on web");
    return factories.CheckboxListTile_readBack_titleAlignment(nativeStruct);
  }
  public boolean internalAddSemanticForOnTap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileInternalAddSemanticForOnTap not supported on web");
    return factories.CheckboxListTile_readBack_internalAddSemanticForOnTap(nativeStruct);
  }
  public double checkboxScaleFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileCheckboxScaleFactor not supported on web");
    return factories.CheckboxListTile_readBack_checkboxScaleFactor(nativeStruct);
  }
  public String checkboxSemanticLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileCheckboxSemanticLabel not supported on web");
    return factories.CheckboxListTile_readBack_checkboxSemanticLabel(nativeStruct);
  }
  @Override
  public CheckboxListTile build() {
    return this;
  }
}
