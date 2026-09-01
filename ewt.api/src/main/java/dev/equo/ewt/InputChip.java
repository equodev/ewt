package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.InputChipObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class InputChip extends StatelessWidget implements InputChipI {
  private MemorySegment st;
  protected InputChip() {}
  InputChip(MemorySegment st) {
    this.id = InputChipObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget InputChip");
    System.out.println("New InputChip id:"+id);
  }
  InputChip(int id) { this.id = id; }
  @Builder.Factory
  static InputChip inputChipInputChip(Optional<WidgetI> avatar, WidgetI label, Optional<TextStyleI> labelStyle, Optional<EdgeInsetsGeometryI> labelPadding, Optional<Boolean> selected, Optional<Boolean> isEnabled, Optional<Consumer<Boolean>> onSelected, Optional<WidgetI> deleteIcon, Optional<Runnable> onDeleted, Optional<ColorI> deleteIconColor, Optional<String> deleteButtonTooltipMessage, Optional<Runnable> onPressed, OptionalDouble pressElevation, Optional<ColorI> disabledColor, Optional<ColorI> selectedColor, Optional<String> tooltip, Optional<BorderSideI> side, Optional<OutlinedBorderI> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<ColorI> color, Optional<ColorI> backgroundColor, Optional<EdgeInsetsGeometryI> padding, Optional<VisualDensityI> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ColorI> selectedShadowColor, Optional<Boolean> showCheckmark, Optional<ColorI> checkmarkColor, Optional<ShapeBorderI> avatarBorder, Optional<BoxConstraintsI> avatarBoxConstraints, Optional<BoxConstraintsI> deleteIconBoxConstraints) {
    var st = factories.inputChipInputChip(avatar.map(WidgetI::build),
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
      selectedShadowColor.map(ColorI::build),
      showCheckmark,
      checkmarkColor.map(ColorI::build),
      avatarBorder.map(ShapeBorderI::build),
      avatarBoxConstraints.map(BoxConstraintsI::build),
      deleteIconBoxConstraints.map(BoxConstraintsI::build));
    if (st == null) throw new RuntimeException("Failed to created widget InputChip");
    return new InputChip(st);
  }
  public static InputChipInputChipBuilder inputChip() {
    return InputChipInputChipBuilder.inputChipInputChip();
  }
  public Widget avatar() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipAvatar not supported on web");
    return new Widget(InputChipObjSt.avatar(st)) {};
  }
  public Widget label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipLabel not supported on web");
    return new Widget(InputChipObjSt.label(st)) {};
  }
  public TextStyle labelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipLabelStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(InputChipObjSt.labelStyle(st));
  }
  public EdgeInsetsGeometry labelPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipLabelPadding not supported on web");
    return new EdgeInsetsGeometry(InputChipObjSt.labelPadding(st)) {};
  }
  public boolean selected() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipSelected not supported on web");
    return intToBool(InputChipObjSt.selected(st));
  }
  public boolean isEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipIsEnabled not supported on web");
    return intToBool(InputChipObjSt.isEnabled(st));
  }
  public Widget deleteIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipDeleteIcon not supported on web");
    return new Widget(InputChipObjSt.deleteIcon(st)) {};
  }
  public Color deleteIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipDeleteIconColor", getId());
      return new Color(__nid);
    }
    return new Color(InputChipObjSt.deleteIconColor(st));
  }
  public String deleteButtonTooltipMessage() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipDeleteButtonTooltipMessage not supported on web");
    return InputChipObjSt.deleteButtonTooltipMessage(st).getString(0);
  }
  public double pressElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipPressElevation not supported on web");
    return InputChipObjSt.pressElevation(st);
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipDisabledColor", getId());
      return new Color(__nid);
    }
    return new Color(InputChipObjSt.disabledColor(st));
  }
  public Color selectedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipSelectedColor", getId());
      return new Color(__nid);
    }
    return new Color(InputChipObjSt.selectedColor(st));
  }
  public String tooltip() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipTooltip not supported on web");
    return InputChipObjSt.tooltip(st).getString(0);
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipSide", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderSideObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderSideObjSt.id(__st, __nid);
      return new BorderSide(__st);
    }
    return new BorderSide(InputChipObjSt.side(st));
  }
  public OutlinedBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipShape not supported on web");
    return new OutlinedBorder(InputChipObjSt.shape(st)) {};
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipClipBehavior not supported on web");
    return Clip.values()[InputChipObjSt.clipBehavior(st)];
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipAutofocus not supported on web");
    return intToBool(InputChipObjSt.autofocus(st));
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(InputChipObjSt.backgroundColor(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipPadding not supported on web");
    return new EdgeInsetsGeometry(InputChipObjSt.padding(st)) {};
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipVisualDensity", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.VisualDensityObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.VisualDensityObjSt.id(__st, __nid);
      return new VisualDensity(__st);
    }
    return new VisualDensity(InputChipObjSt.visualDensity(st));
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipMaterialTapTargetSize not supported on web");
    return MaterialTapTargetSize.values()[InputChipObjSt.materialTapTargetSize(st)];
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipElevation not supported on web");
    return InputChipObjSt.elevation(st);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(InputChipObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(InputChipObjSt.surfaceTintColor(st));
  }
  public Color selectedShadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipSelectedShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(InputChipObjSt.selectedShadowColor(st));
  }
  public boolean showCheckmark() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipShowCheckmark not supported on web");
    return intToBool(InputChipObjSt.showCheckmark(st));
  }
  public Color checkmarkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipCheckmarkColor", getId());
      return new Color(__nid);
    }
    return new Color(InputChipObjSt.checkmarkColor(st));
  }
  public ShapeBorder avatarBorder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputChipAvatarBorder not supported on web");
    return new ShapeBorder(InputChipObjSt.avatarBorder(st)) {};
  }
  public BoxConstraints avatarBoxConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipAvatarBoxConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(InputChipObjSt.avatarBoxConstraints(st));
  }
  public BoxConstraints deleteIconBoxConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputChipDeleteIconBoxConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(InputChipObjSt.deleteIconBoxConstraints(st));
  }
  @Override
  public InputChip build() {
    return this;
  }
}
