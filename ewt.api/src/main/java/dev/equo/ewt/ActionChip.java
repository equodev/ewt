package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ActionChip extends StatelessWidget implements ActionChipI {
  protected ActionChip() {}
  ActionChip(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ActionChip");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ActionChip actionChipActionChip(Optional<WidgetI> avatar, WidgetI label, Optional<TextStyleI> labelStyle, Optional<EdgeInsetsGeometryI> labelPadding, Optional<Runnable> onPressed, OptionalDouble pressElevation, Optional<String> tooltip, Optional<BorderSideI> side, Optional<OutlinedBorderI> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<ColorI> color, Optional<ColorI> backgroundColor, Optional<ColorI> disabledColor, Optional<EdgeInsetsGeometryI> padding, Optional<VisualDensityI> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<IconThemeDataI> iconTheme, Optional<BoxConstraintsI> avatarBoxConstraints) {
    int id = factories.actionChipActionChip(avatar.map(WidgetI::build),
      label.build(),
      labelStyle.map(TextStyleI::build),
      labelPadding.map(EdgeInsetsGeometryI::build),
      onPressed,
      pressElevation,
      tooltip,
      side.map(BorderSideI::build),
      shape.map(OutlinedBorderI::build),
      clipBehavior,
      autofocus,
      color.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      disabledColor.map(ColorI::build),
      padding.map(EdgeInsetsGeometryI::build),
      visualDensity.map(VisualDensityI::build),
      materialTapTargetSize,
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      iconTheme.map(IconThemeDataI::build),
      avatarBoxConstraints.map(BoxConstraintsI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ActionChip");
    return new ActionChip(id);
  }
  public static ActionChipActionChipBuilder actionChip() {
    return ActionChipActionChipBuilder.actionChipActionChip();
  }
  @Builder.Factory
  static ActionChip actionChipElevated(Optional<WidgetI> avatar, WidgetI label, Optional<TextStyleI> labelStyle, Optional<EdgeInsetsGeometryI> labelPadding, Optional<Runnable> onPressed, OptionalDouble pressElevation, Optional<String> tooltip, Optional<BorderSideI> side, Optional<OutlinedBorderI> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<ColorI> color, Optional<ColorI> backgroundColor, Optional<ColorI> disabledColor, Optional<EdgeInsetsGeometryI> padding, Optional<VisualDensityI> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<IconThemeDataI> iconTheme, Optional<BoxConstraintsI> avatarBoxConstraints) {
    int id = factories.actionChipElevated(avatar.map(WidgetI::build),
      label.build(),
      labelStyle.map(TextStyleI::build),
      labelPadding.map(EdgeInsetsGeometryI::build),
      onPressed,
      pressElevation,
      tooltip,
      side.map(BorderSideI::build),
      shape.map(OutlinedBorderI::build),
      clipBehavior,
      autofocus,
      color.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      disabledColor.map(ColorI::build),
      padding.map(EdgeInsetsGeometryI::build),
      visualDensity.map(VisualDensityI::build),
      materialTapTargetSize,
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      iconTheme.map(IconThemeDataI::build),
      avatarBoxConstraints.map(BoxConstraintsI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ActionChip");
    return new ActionChip(id);
  }
  public static ActionChipElevatedBuilder elevated() {
    return ActionChipElevatedBuilder.actionChipElevated();
  }
  public Widget avatar() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("actionChipAvatar not supported on web");
    return factories.ActionChip_readBack_avatar(nativeStruct);
  }
  public Widget label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("actionChipLabel not supported on web");
    return factories.ActionChip_readBack_label(nativeStruct);
  }
  public TextStyle labelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("actionChipLabelStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.ActionChip_readBack_labelStyle(nativeStruct);
  }
  public EdgeInsetsGeometry labelPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("actionChipLabelPadding not supported on web");
    return factories.ActionChip_readBack_labelPadding(nativeStruct);
  }
  public double pressElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("actionChipPressElevation not supported on web");
    return factories.ActionChip_readBack_pressElevation(nativeStruct);
  }
  public String tooltip() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("actionChipTooltip not supported on web");
    return factories.ActionChip_readBack_tooltip(nativeStruct);
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("actionChipSide", getId());
      return new BorderSide(__nid);
    }
    return factories.ActionChip_readBack_side(nativeStruct);
  }
  public OutlinedBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("actionChipShape not supported on web");
    return factories.ActionChip_readBack_shape(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("actionChipClipBehavior not supported on web");
    return factories.ActionChip_readBack_clipBehavior(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("actionChipAutofocus not supported on web");
    return factories.ActionChip_readBack_autofocus(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("actionChipBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.ActionChip_readBack_backgroundColor(nativeStruct);
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("actionChipDisabledColor", getId());
      return new Color(__nid);
    }
    return factories.ActionChip_readBack_disabledColor(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("actionChipPadding not supported on web");
    return factories.ActionChip_readBack_padding(nativeStruct);
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("actionChipVisualDensity", getId());
      return new VisualDensity(__nid);
    }
    return factories.ActionChip_readBack_visualDensity(nativeStruct);
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("actionChipMaterialTapTargetSize not supported on web");
    return factories.ActionChip_readBack_materialTapTargetSize(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("actionChipElevation not supported on web");
    return factories.ActionChip_readBack_elevation(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("actionChipShadowColor", getId());
      return new Color(__nid);
    }
    return factories.ActionChip_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("actionChipSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.ActionChip_readBack_surfaceTintColor(nativeStruct);
  }
  public IconThemeData iconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("actionChipIconTheme", getId());
      return new IconThemeData(__nid);
    }
    return factories.ActionChip_readBack_iconTheme(nativeStruct);
  }
  public BoxConstraints avatarBoxConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("actionChipAvatarBoxConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.ActionChip_readBack_avatarBoxConstraints(nativeStruct);
  }
  @Override
  public ActionChip build() {
    return this;
  }
}
