package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ActionChipObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ActionChip extends StatelessWidget implements ActionChipI {
  private MemorySegment st;
  protected ActionChip() {}
  ActionChip(MemorySegment st) {
    this.id = ActionChipObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ActionChip");
    System.out.println("New ActionChip id:"+id);
  }
  ActionChip(int id) { this.id = id; }
  @Builder.Factory
  static ActionChip actionChipActionChip(Optional<WidgetI> avatar, WidgetI label, Optional<TextStyleI> labelStyle, Optional<EdgeInsetsGeometryI> labelPadding, Optional<Runnable> onPressed, OptionalDouble pressElevation, Optional<String> tooltip, Optional<BorderSideI> side, Optional<OutlinedBorderI> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<ColorI> color, Optional<ColorI> backgroundColor, Optional<ColorI> disabledColor, Optional<EdgeInsetsGeometryI> padding, Optional<VisualDensityI> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<BoxConstraintsI> avatarBoxConstraints) {
    var st = factories.actionChipActionChip(avatar.map(WidgetI::build),
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
      avatarBoxConstraints.map(BoxConstraintsI::build));
    if (st == null) throw new RuntimeException("Failed to created widget ActionChip");
    return new ActionChip(st);
  }
  public static ActionChipActionChipBuilder actionChip() {
    return ActionChipActionChipBuilder.actionChipActionChip();
  }
  @Builder.Factory
  static ActionChip actionChipElevated(Optional<WidgetI> avatar, WidgetI label, Optional<TextStyleI> labelStyle, Optional<EdgeInsetsGeometryI> labelPadding, Optional<Runnable> onPressed, OptionalDouble pressElevation, Optional<String> tooltip, Optional<BorderSideI> side, Optional<OutlinedBorderI> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<ColorI> color, Optional<ColorI> backgroundColor, Optional<ColorI> disabledColor, Optional<EdgeInsetsGeometryI> padding, Optional<VisualDensityI> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<BoxConstraintsI> avatarBoxConstraints) {
    var st = factories.actionChipElevated(avatar.map(WidgetI::build),
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
      avatarBoxConstraints.map(BoxConstraintsI::build));
    if (st == null) throw new RuntimeException("Failed to created widget ActionChip");
    return new ActionChip(st);
  }
  public static ActionChipElevatedBuilder elevated() {
    return ActionChipElevatedBuilder.actionChipElevated();
  }
  public Widget avatar() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("actionChipAvatar not supported on web");
    return new Widget(ActionChipObjSt.avatar(st)) {};
  }
  public Widget label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("actionChipLabel not supported on web");
    return new Widget(ActionChipObjSt.label(st)) {};
  }
  public TextStyle labelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("actionChipLabelStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(ActionChipObjSt.labelStyle(st));
  }
  public EdgeInsetsGeometry labelPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("actionChipLabelPadding not supported on web");
    return new EdgeInsetsGeometry(ActionChipObjSt.labelPadding(st)) {};
  }
  public double pressElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("actionChipPressElevation not supported on web");
    return ActionChipObjSt.pressElevation(st);
  }
  public String tooltip() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("actionChipTooltip not supported on web");
    return ActionChipObjSt.tooltip(st).getString(0);
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("actionChipSide", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderSideObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderSideObjSt.id(__st, __nid);
      return new BorderSide(__st);
    }
    return new BorderSide(ActionChipObjSt.side(st));
  }
  public OutlinedBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("actionChipShape not supported on web");
    return new OutlinedBorder(ActionChipObjSt.shape(st)) {};
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("actionChipClipBehavior not supported on web");
    return Clip.values()[ActionChipObjSt.clipBehavior(st)];
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("actionChipAutofocus not supported on web");
    return intToBool(ActionChipObjSt.autofocus(st));
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("actionChipBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(ActionChipObjSt.backgroundColor(st));
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("actionChipDisabledColor", getId());
      return new Color(__nid);
    }
    return new Color(ActionChipObjSt.disabledColor(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("actionChipPadding not supported on web");
    return new EdgeInsetsGeometry(ActionChipObjSt.padding(st)) {};
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("actionChipVisualDensity", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.VisualDensityObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.VisualDensityObjSt.id(__st, __nid);
      return new VisualDensity(__st);
    }
    return new VisualDensity(ActionChipObjSt.visualDensity(st));
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("actionChipMaterialTapTargetSize not supported on web");
    return MaterialTapTargetSize.values()[ActionChipObjSt.materialTapTargetSize(st)];
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("actionChipElevation not supported on web");
    return ActionChipObjSt.elevation(st);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("actionChipShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(ActionChipObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("actionChipSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(ActionChipObjSt.surfaceTintColor(st));
  }
  public BoxConstraints avatarBoxConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("actionChipAvatarBoxConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(ActionChipObjSt.avatarBoxConstraints(st));
  }
  @Override
  public ActionChip build() {
    return this;
  }
}
