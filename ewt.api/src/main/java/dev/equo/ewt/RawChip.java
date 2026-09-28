package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class RawChip extends StatefulWidget implements RawChipI {
  protected RawChip() {}
  RawChip(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget RawChip");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static RawChip rawChipRawChip(Optional<ChipThemeDataI> defaultProperties, Optional<WidgetI> avatar, WidgetI label, Optional<TextStyleI> labelStyle, Optional<EdgeInsetsGeometryI> padding, Optional<VisualDensityI> visualDensity, Optional<EdgeInsetsGeometryI> labelPadding, Optional<WidgetI> deleteIcon, Optional<Runnable> onDeleted, Optional<ColorI> deleteIconColor, Optional<String> deleteButtonTooltipMessage, Optional<Runnable> onPressed, Optional<Consumer<Boolean>> onSelected, OptionalDouble pressElevation, Optional<Boolean> tapEnabled, Optional<Boolean> selected, Optional<Boolean> isEnabled, Optional<ColorI> disabledColor, Optional<ColorI> selectedColor, Optional<String> tooltip, Optional<BorderSideI> side, Optional<OutlinedBorderI> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<ColorI> color, Optional<ColorI> backgroundColor, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<IconThemeDataI> iconTheme, Optional<ColorI> selectedShadowColor, Optional<Boolean> showCheckmark, Optional<ColorI> checkmarkColor, Optional<ShapeBorderI> avatarBorder, Optional<BoxConstraintsI> avatarBoxConstraints, Optional<BoxConstraintsI> deleteIconBoxConstraints) {
    int id = factories.rawChipRawChip(defaultProperties.map(ChipThemeDataI::build),
      avatar.map(WidgetI::build),
      label.build(),
      labelStyle.map(TextStyleI::build),
      padding.map(EdgeInsetsGeometryI::build),
      visualDensity.map(VisualDensityI::build),
      labelPadding.map(EdgeInsetsGeometryI::build),
      deleteIcon.map(WidgetI::build),
      onDeleted,
      deleteIconColor.map(ColorI::build),
      deleteButtonTooltipMessage,
      onPressed,
      onSelected,
      pressElevation,
      tapEnabled,
      selected,
      isEnabled,
      disabledColor.map(ColorI::build),
      selectedColor.map(ColorI::build),
      tooltip,
      side.map(BorderSideI::build),
      shape.map(OutlinedBorderI::build),
      clipBehavior,
      autofocus,
      color.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      materialTapTargetSize,
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      iconTheme.map(IconThemeDataI::build),
      selectedShadowColor.map(ColorI::build),
      showCheckmark,
      checkmarkColor.map(ColorI::build),
      avatarBorder.map(ShapeBorderI::build),
      avatarBoxConstraints.map(BoxConstraintsI::build),
      deleteIconBoxConstraints.map(BoxConstraintsI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget RawChip");
    return new RawChip(id);
  }
  public static RawChipRawChipBuilder rawChip() {
    return RawChipRawChipBuilder.rawChipRawChip();
  }
  public ChipThemeData defaultProperties() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipDefaultProperties", getId());
      return new ChipThemeData(__nid);
    }
    return factories.RawChip_readBack_defaultProperties(nativeStruct);
  }
  public Widget avatar() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipAvatar not supported on web");
    return factories.RawChip_readBack_avatar(nativeStruct);
  }
  public Widget label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipLabel not supported on web");
    return factories.RawChip_readBack_label(nativeStruct);
  }
  public TextStyle labelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipLabelStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.RawChip_readBack_labelStyle(nativeStruct);
  }
  public EdgeInsetsGeometry labelPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipLabelPadding not supported on web");
    return factories.RawChip_readBack_labelPadding(nativeStruct);
  }
  public Widget deleteIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipDeleteIcon not supported on web");
    return factories.RawChip_readBack_deleteIcon(nativeStruct);
  }
  public Color deleteIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipDeleteIconColor", getId());
      return new Color(__nid);
    }
    return factories.RawChip_readBack_deleteIconColor(nativeStruct);
  }
  public String deleteButtonTooltipMessage() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipDeleteButtonTooltipMessage not supported on web");
    return factories.RawChip_readBack_deleteButtonTooltipMessage(nativeStruct);
  }
  public double pressElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipPressElevation not supported on web");
    return factories.RawChip_readBack_pressElevation(nativeStruct);
  }
  public boolean selected() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipSelected not supported on web");
    return factories.RawChip_readBack_selected(nativeStruct);
  }
  public boolean isEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipIsEnabled not supported on web");
    return factories.RawChip_readBack_isEnabled(nativeStruct);
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipDisabledColor", getId());
      return new Color(__nid);
    }
    return factories.RawChip_readBack_disabledColor(nativeStruct);
  }
  public Color selectedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipSelectedColor", getId());
      return new Color(__nid);
    }
    return factories.RawChip_readBack_selectedColor(nativeStruct);
  }
  public String tooltip() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipTooltip not supported on web");
    return factories.RawChip_readBack_tooltip(nativeStruct);
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipSide", getId());
      return new BorderSide(__nid);
    }
    return factories.RawChip_readBack_side(nativeStruct);
  }
  public OutlinedBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipShape not supported on web");
    return factories.RawChip_readBack_shape(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipClipBehavior not supported on web");
    return factories.RawChip_readBack_clipBehavior(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipAutofocus not supported on web");
    return factories.RawChip_readBack_autofocus(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.RawChip_readBack_backgroundColor(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipPadding not supported on web");
    return factories.RawChip_readBack_padding(nativeStruct);
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipVisualDensity", getId());
      return new VisualDensity(__nid);
    }
    return factories.RawChip_readBack_visualDensity(nativeStruct);
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipMaterialTapTargetSize not supported on web");
    return factories.RawChip_readBack_materialTapTargetSize(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipElevation not supported on web");
    return factories.RawChip_readBack_elevation(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipShadowColor", getId());
      return new Color(__nid);
    }
    return factories.RawChip_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.RawChip_readBack_surfaceTintColor(nativeStruct);
  }
  public IconThemeData iconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipIconTheme", getId());
      return new IconThemeData(__nid);
    }
    return factories.RawChip_readBack_iconTheme(nativeStruct);
  }
  public Color selectedShadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipSelectedShadowColor", getId());
      return new Color(__nid);
    }
    return factories.RawChip_readBack_selectedShadowColor(nativeStruct);
  }
  public boolean showCheckmark() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipShowCheckmark not supported on web");
    return factories.RawChip_readBack_showCheckmark(nativeStruct);
  }
  public Color checkmarkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipCheckmarkColor", getId());
      return new Color(__nid);
    }
    return factories.RawChip_readBack_checkmarkColor(nativeStruct);
  }
  public ShapeBorder avatarBorder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipAvatarBorder not supported on web");
    return factories.RawChip_readBack_avatarBorder(nativeStruct);
  }
  public BoxConstraints avatarBoxConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipAvatarBoxConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.RawChip_readBack_avatarBoxConstraints(nativeStruct);
  }
  public BoxConstraints deleteIconBoxConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipDeleteIconBoxConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.RawChip_readBack_deleteIconBoxConstraints(nativeStruct);
  }
  public boolean tapEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipTapEnabled not supported on web");
    return factories.RawChip_readBack_tapEnabled(nativeStruct);
  }
  @Override
  public RawChip build() {
    return this;
  }
}
