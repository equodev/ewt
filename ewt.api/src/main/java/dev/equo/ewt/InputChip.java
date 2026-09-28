package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class InputChip extends StatelessWidget implements InputChipI {
  protected InputChip() {}
  InputChip(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget InputChip");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static InputChip inputChipInputChip(Optional<WidgetI> avatar, WidgetI label, Optional<TextStyleI> labelStyle, Optional<EdgeInsetsGeometryI> labelPadding, Optional<Boolean> selected, Optional<Boolean> isEnabled, Optional<Consumer<Boolean>> onSelected, Optional<WidgetI> deleteIcon, Optional<Runnable> onDeleted, Optional<ColorI> deleteIconColor, Optional<String> deleteButtonTooltipMessage, Optional<Runnable> onPressed, OptionalDouble pressElevation, Optional<ColorI> disabledColor, Optional<ColorI> selectedColor, Optional<String> tooltip, Optional<BorderSideI> side, Optional<OutlinedBorderI> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<ColorI> color, Optional<ColorI> backgroundColor, Optional<EdgeInsetsGeometryI> padding, Optional<VisualDensityI> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<IconThemeDataI> iconTheme, Optional<ColorI> selectedShadowColor, Optional<Boolean> showCheckmark, Optional<ColorI> checkmarkColor, Optional<ShapeBorderI> avatarBorder, Optional<BoxConstraintsI> avatarBoxConstraints, Optional<BoxConstraintsI> deleteIconBoxConstraints) {
    int id = factories.inputChipInputChip(avatar.map(WidgetI::build),
      label.build(),
      labelStyle.map(TextStyleI::build),
      labelPadding.map(EdgeInsetsGeometryI::build),
      selected,
      isEnabled,
      onSelected,
      deleteIcon.map(WidgetI::build),
      onDeleted,
      deleteIconColor.map(ColorI::build),
      deleteButtonTooltipMessage,
      onPressed,
      pressElevation,
      disabledColor.map(ColorI::build),
      selectedColor.map(ColorI::build),
      tooltip,
      side.map(BorderSideI::build),
      shape.map(OutlinedBorderI::build),
      clipBehavior,
      autofocus,
      color.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      padding.map(EdgeInsetsGeometryI::build),
      visualDensity.map(VisualDensityI::build),
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
    if (id <= 0) throw new RuntimeException("Failed to created widget InputChip");
    return new InputChip(id);
  }
  public static InputChipInputChipBuilder inputChip() {
    return InputChipInputChipBuilder.inputChipInputChip();
  }
  public Widget avatar() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipAvatar not supported on web");
    return factories.InputChip_readBack_avatar(nativeStruct);
  }
  public Widget label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipLabel not supported on web");
    return factories.InputChip_readBack_label(nativeStruct);
  }
  public TextStyle labelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipLabelStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.InputChip_readBack_labelStyle(nativeStruct);
  }
  public EdgeInsetsGeometry labelPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipLabelPadding not supported on web");
    return factories.InputChip_readBack_labelPadding(nativeStruct);
  }
  public boolean selected() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipSelected not supported on web");
    return factories.InputChip_readBack_selected(nativeStruct);
  }
  public boolean isEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipIsEnabled not supported on web");
    return factories.InputChip_readBack_isEnabled(nativeStruct);
  }
  public Widget deleteIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipDeleteIcon not supported on web");
    return factories.InputChip_readBack_deleteIcon(nativeStruct);
  }
  public Color deleteIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipDeleteIconColor", getId());
      return new Color(__nid);
    }
    return factories.InputChip_readBack_deleteIconColor(nativeStruct);
  }
  public String deleteButtonTooltipMessage() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipDeleteButtonTooltipMessage not supported on web");
    return factories.InputChip_readBack_deleteButtonTooltipMessage(nativeStruct);
  }
  public double pressElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipPressElevation not supported on web");
    return factories.InputChip_readBack_pressElevation(nativeStruct);
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipDisabledColor", getId());
      return new Color(__nid);
    }
    return factories.InputChip_readBack_disabledColor(nativeStruct);
  }
  public Color selectedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipSelectedColor", getId());
      return new Color(__nid);
    }
    return factories.InputChip_readBack_selectedColor(nativeStruct);
  }
  public String tooltip() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipTooltip not supported on web");
    return factories.InputChip_readBack_tooltip(nativeStruct);
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipSide", getId());
      return new BorderSide(__nid);
    }
    return factories.InputChip_readBack_side(nativeStruct);
  }
  public OutlinedBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipShape not supported on web");
    return factories.InputChip_readBack_shape(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipClipBehavior not supported on web");
    return factories.InputChip_readBack_clipBehavior(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipAutofocus not supported on web");
    return factories.InputChip_readBack_autofocus(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.InputChip_readBack_backgroundColor(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipPadding not supported on web");
    return factories.InputChip_readBack_padding(nativeStruct);
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipVisualDensity", getId());
      return new VisualDensity(__nid);
    }
    return factories.InputChip_readBack_visualDensity(nativeStruct);
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipMaterialTapTargetSize not supported on web");
    return factories.InputChip_readBack_materialTapTargetSize(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipElevation not supported on web");
    return factories.InputChip_readBack_elevation(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipShadowColor", getId());
      return new Color(__nid);
    }
    return factories.InputChip_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.InputChip_readBack_surfaceTintColor(nativeStruct);
  }
  public Color selectedShadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipSelectedShadowColor", getId());
      return new Color(__nid);
    }
    return factories.InputChip_readBack_selectedShadowColor(nativeStruct);
  }
  public boolean showCheckmark() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipShowCheckmark not supported on web");
    return factories.InputChip_readBack_showCheckmark(nativeStruct);
  }
  public Color checkmarkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipCheckmarkColor", getId());
      return new Color(__nid);
    }
    return factories.InputChip_readBack_checkmarkColor(nativeStruct);
  }
  public ShapeBorder avatarBorder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipAvatarBorder not supported on web");
    return factories.InputChip_readBack_avatarBorder(nativeStruct);
  }
  public IconThemeData iconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipIconTheme", getId());
      return new IconThemeData(__nid);
    }
    return factories.InputChip_readBack_iconTheme(nativeStruct);
  }
  public BoxConstraints avatarBoxConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipAvatarBoxConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.InputChip_readBack_avatarBoxConstraints(nativeStruct);
  }
  public BoxConstraints deleteIconBoxConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipDeleteIconBoxConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.InputChip_readBack_deleteIconBoxConstraints(nativeStruct);
  }
  @Override
  public InputChip build() {
    return this;
  }
}
