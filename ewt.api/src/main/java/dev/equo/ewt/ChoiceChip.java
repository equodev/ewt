package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ChoiceChipObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ChoiceChip extends StatelessWidget implements ChoiceChipI {
  private MemorySegment st;
  protected ChoiceChip() {}
  ChoiceChip(MemorySegment st) {
    this.id = ChoiceChipObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ChoiceChip");
    System.out.println("New ChoiceChip id:"+id);
  }
  ChoiceChip(int id) { this.id = id; }
  @Builder.Factory
  static ChoiceChip choiceChipChoiceChip(Optional<WidgetI> avatar, WidgetI label, Optional<TextStyleI> labelStyle, Optional<EdgeInsetsGeometryI> labelPadding, Optional<Consumer<Boolean>> onSelected, OptionalDouble pressElevation, boolean selected, Optional<ColorI> selectedColor, Optional<ColorI> disabledColor, Optional<String> tooltip, Optional<BorderSideI> side, Optional<OutlinedBorderI> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<ColorI> color, Optional<ColorI> backgroundColor, Optional<EdgeInsetsGeometryI> padding, Optional<VisualDensityI> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ColorI> selectedShadowColor, Optional<Boolean> showCheckmark, Optional<ColorI> checkmarkColor, Optional<ShapeBorderI> avatarBorder, Optional<BoxConstraintsI> avatarBoxConstraints) {
    var st = factories.choiceChipChoiceChip(avatar.map(WidgetI::build),
      label.build(),
      labelStyle.map(TextStyleI::build),
      labelPadding.map(EdgeInsetsGeometryI::build),
      onSelected,
      pressElevation,
      selected,
      selectedColor.map(ColorI::build),
      disabledColor.map(ColorI::build),
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
      avatarBoxConstraints.map(BoxConstraintsI::build));
    if (st == null) throw new RuntimeException("Failed to created widget ChoiceChip");
    return new ChoiceChip(st);
  }
  public static ChoiceChipChoiceChipBuilder choiceChip() {
    return ChoiceChipChoiceChipBuilder.choiceChipChoiceChip();
  }
  @Builder.Factory
  static ChoiceChip choiceChipElevated(Optional<WidgetI> avatar, WidgetI label, Optional<TextStyleI> labelStyle, Optional<EdgeInsetsGeometryI> labelPadding, Optional<Consumer<Boolean>> onSelected, OptionalDouble pressElevation, boolean selected, Optional<ColorI> selectedColor, Optional<ColorI> disabledColor, Optional<String> tooltip, Optional<BorderSideI> side, Optional<OutlinedBorderI> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<ColorI> color, Optional<ColorI> backgroundColor, Optional<EdgeInsetsGeometryI> padding, Optional<VisualDensityI> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ColorI> selectedShadowColor, Optional<Boolean> showCheckmark, Optional<ColorI> checkmarkColor, Optional<ShapeBorderI> avatarBorder, Optional<BoxConstraintsI> avatarBoxConstraints) {
    var st = factories.choiceChipElevated(avatar.map(WidgetI::build),
      label.build(),
      labelStyle.map(TextStyleI::build),
      labelPadding.map(EdgeInsetsGeometryI::build),
      onSelected,
      pressElevation,
      selected,
      selectedColor.map(ColorI::build),
      disabledColor.map(ColorI::build),
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
      avatarBoxConstraints.map(BoxConstraintsI::build));
    if (st == null) throw new RuntimeException("Failed to created widget ChoiceChip");
    return new ChoiceChip(st);
  }
  public static ChoiceChipElevatedBuilder elevated() {
    return ChoiceChipElevatedBuilder.choiceChipElevated();
  }
  public Widget avatar() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("choiceChipAvatar not supported on web");
    return new Widget(ChoiceChipObjSt.avatar(st)) {};
  }
  public Widget label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("choiceChipLabel not supported on web");
    return new Widget(ChoiceChipObjSt.label(st)) {};
  }
  public TextStyle labelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("choiceChipLabelStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(ChoiceChipObjSt.labelStyle(st));
  }
  public EdgeInsetsGeometry labelPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("choiceChipLabelPadding not supported on web");
    return new EdgeInsetsGeometry(ChoiceChipObjSt.labelPadding(st)) {};
  }
  public double pressElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("choiceChipPressElevation not supported on web");
    return ChoiceChipObjSt.pressElevation(st);
  }
  public boolean selected() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("choiceChipSelected not supported on web");
    return intToBool(ChoiceChipObjSt.selected(st));
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("choiceChipDisabledColor", getId());
      return new Color(__nid);
    }
    return new Color(ChoiceChipObjSt.disabledColor(st));
  }
  public Color selectedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("choiceChipSelectedColor", getId());
      return new Color(__nid);
    }
    return new Color(ChoiceChipObjSt.selectedColor(st));
  }
  public String tooltip() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("choiceChipTooltip not supported on web");
    return ChoiceChipObjSt.tooltip(st).getString(0);
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("choiceChipSide", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderSideObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderSideObjSt.id(__st, __nid);
      return new BorderSide(__st);
    }
    return new BorderSide(ChoiceChipObjSt.side(st));
  }
  public OutlinedBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("choiceChipShape not supported on web");
    return new OutlinedBorder(ChoiceChipObjSt.shape(st)) {};
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("choiceChipClipBehavior not supported on web");
    return Clip.values()[ChoiceChipObjSt.clipBehavior(st)];
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("choiceChipAutofocus not supported on web");
    return intToBool(ChoiceChipObjSt.autofocus(st));
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("choiceChipBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(ChoiceChipObjSt.backgroundColor(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("choiceChipPadding not supported on web");
    return new EdgeInsetsGeometry(ChoiceChipObjSt.padding(st)) {};
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("choiceChipVisualDensity", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.VisualDensityObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.VisualDensityObjSt.id(__st, __nid);
      return new VisualDensity(__st);
    }
    return new VisualDensity(ChoiceChipObjSt.visualDensity(st));
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("choiceChipMaterialTapTargetSize not supported on web");
    return MaterialTapTargetSize.values()[ChoiceChipObjSt.materialTapTargetSize(st)];
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("choiceChipElevation not supported on web");
    return ChoiceChipObjSt.elevation(st);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("choiceChipShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(ChoiceChipObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("choiceChipSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(ChoiceChipObjSt.surfaceTintColor(st));
  }
  public Color selectedShadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("choiceChipSelectedShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(ChoiceChipObjSt.selectedShadowColor(st));
  }
  public boolean showCheckmark() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("choiceChipShowCheckmark not supported on web");
    return intToBool(ChoiceChipObjSt.showCheckmark(st));
  }
  public Color checkmarkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("choiceChipCheckmarkColor", getId());
      return new Color(__nid);
    }
    return new Color(ChoiceChipObjSt.checkmarkColor(st));
  }
  public ShapeBorder avatarBorder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("choiceChipAvatarBorder not supported on web");
    return new ShapeBorder(ChoiceChipObjSt.avatarBorder(st)) {};
  }
  public BoxConstraints avatarBoxConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("choiceChipAvatarBoxConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(ChoiceChipObjSt.avatarBoxConstraints(st));
  }
  @Override
  public ChoiceChip build() {
    return this;
  }
}
