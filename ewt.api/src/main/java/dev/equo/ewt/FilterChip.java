package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FilterChipObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class FilterChip extends StatelessWidget implements FilterChipI {
  private MemorySegment st;
  protected FilterChip() {}
  FilterChip(MemorySegment st) {
    this.id = FilterChipObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget FilterChip");
    System.out.println("New FilterChip id:"+id);
  }
  FilterChip(int id) { this.id = id; }
  @Builder.Factory
  static FilterChip filterChipFilterChip(Optional<WidgetI> avatar, WidgetI label, Optional<TextStyleI> labelStyle, Optional<EdgeInsetsGeometryI> labelPadding, Optional<Boolean> selected, Optional<Consumer<Boolean>> onSelected, Optional<WidgetI> deleteIcon, Optional<Runnable> onDeleted, Optional<ColorI> deleteIconColor, Optional<String> deleteButtonTooltipMessage, OptionalDouble pressElevation, Optional<ColorI> disabledColor, Optional<ColorI> selectedColor, Optional<String> tooltip, Optional<BorderSideI> side, Optional<OutlinedBorderI> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<ColorI> color, Optional<ColorI> backgroundColor, Optional<EdgeInsetsGeometryI> padding, Optional<VisualDensityI> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ColorI> selectedShadowColor, Optional<Boolean> showCheckmark, Optional<ColorI> checkmarkColor, Optional<ShapeBorderI> avatarBorder, Optional<BoxConstraintsI> avatarBoxConstraints, Optional<BoxConstraintsI> deleteIconBoxConstraints) {
    var st = factories.filterChipFilterChip(avatar.map(WidgetI::build),
      label.build(),
      labelStyle.map(TextStyleI::build),
      labelPadding.map(EdgeInsetsGeometryI::build),
      selected,
      onSelected,
      deleteIcon.map(WidgetI::build),
      onDeleted,
      deleteIconColor.map(ColorI::build),
      deleteButtonTooltipMessage,
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
    if (st == null) throw new RuntimeException("Failed to created widget FilterChip");
    return new FilterChip(st);
  }
  public static FilterChipFilterChipBuilder filterChip() {
    return FilterChipFilterChipBuilder.filterChipFilterChip();
  }
  @Builder.Factory
  static FilterChip filterChipElevated(Optional<WidgetI> avatar, WidgetI label, Optional<TextStyleI> labelStyle, Optional<EdgeInsetsGeometryI> labelPadding, Optional<Boolean> selected, Optional<Consumer<Boolean>> onSelected, Optional<WidgetI> deleteIcon, Optional<Runnable> onDeleted, Optional<ColorI> deleteIconColor, Optional<String> deleteButtonTooltipMessage, OptionalDouble pressElevation, Optional<ColorI> disabledColor, Optional<ColorI> selectedColor, Optional<String> tooltip, Optional<BorderSideI> side, Optional<OutlinedBorderI> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<ColorI> color, Optional<ColorI> backgroundColor, Optional<EdgeInsetsGeometryI> padding, Optional<VisualDensityI> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ColorI> selectedShadowColor, Optional<Boolean> showCheckmark, Optional<ColorI> checkmarkColor, Optional<ShapeBorderI> avatarBorder, Optional<BoxConstraintsI> avatarBoxConstraints, Optional<BoxConstraintsI> deleteIconBoxConstraints) {
    var st = factories.filterChipElevated(avatar.map(WidgetI::build),
      label.build(),
      labelStyle.map(TextStyleI::build),
      labelPadding.map(EdgeInsetsGeometryI::build),
      selected,
      onSelected,
      deleteIcon.map(WidgetI::build),
      onDeleted,
      deleteIconColor.map(ColorI::build),
      deleteButtonTooltipMessage,
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
    if (st == null) throw new RuntimeException("Failed to created widget FilterChip");
    return new FilterChip(st);
  }
  public static FilterChipElevatedBuilder elevated() {
    return FilterChipElevatedBuilder.filterChipElevated();
  }
  public Widget avatar() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("filterChipAvatar not supported on web");
    return new Widget(FilterChipObjSt.avatar(st)) {};
  }
  public Widget label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("filterChipLabel not supported on web");
    return new Widget(FilterChipObjSt.label(st)) {};
  }
  public TextStyle labelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("filterChipLabelStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(FilterChipObjSt.labelStyle(st));
  }
  public EdgeInsetsGeometry labelPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("filterChipLabelPadding not supported on web");
    return new EdgeInsetsGeometry(FilterChipObjSt.labelPadding(st)) {};
  }
  public boolean selected() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("filterChipSelected not supported on web");
    return intToBool(FilterChipObjSt.selected(st));
  }
  public Widget deleteIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("filterChipDeleteIcon not supported on web");
    return new Widget(FilterChipObjSt.deleteIcon(st)) {};
  }
  public Color deleteIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("filterChipDeleteIconColor", getId());
      return new Color(__nid);
    }
    return new Color(FilterChipObjSt.deleteIconColor(st));
  }
  public String deleteButtonTooltipMessage() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("filterChipDeleteButtonTooltipMessage not supported on web");
    return FilterChipObjSt.deleteButtonTooltipMessage(st).getString(0);
  }
  public double pressElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("filterChipPressElevation not supported on web");
    return FilterChipObjSt.pressElevation(st);
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("filterChipDisabledColor", getId());
      return new Color(__nid);
    }
    return new Color(FilterChipObjSt.disabledColor(st));
  }
  public Color selectedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("filterChipSelectedColor", getId());
      return new Color(__nid);
    }
    return new Color(FilterChipObjSt.selectedColor(st));
  }
  public String tooltip() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("filterChipTooltip not supported on web");
    return FilterChipObjSt.tooltip(st).getString(0);
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("filterChipSide", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderSideObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderSideObjSt.id(__st, __nid);
      return new BorderSide(__st);
    }
    return new BorderSide(FilterChipObjSt.side(st));
  }
  public OutlinedBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("filterChipShape not supported on web");
    return new OutlinedBorder(FilterChipObjSt.shape(st)) {};
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("filterChipClipBehavior not supported on web");
    return Clip.values()[FilterChipObjSt.clipBehavior(st)];
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("filterChipAutofocus not supported on web");
    return intToBool(FilterChipObjSt.autofocus(st));
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("filterChipBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(FilterChipObjSt.backgroundColor(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("filterChipPadding not supported on web");
    return new EdgeInsetsGeometry(FilterChipObjSt.padding(st)) {};
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("filterChipVisualDensity", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.VisualDensityObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.VisualDensityObjSt.id(__st, __nid);
      return new VisualDensity(__st);
    }
    return new VisualDensity(FilterChipObjSt.visualDensity(st));
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("filterChipMaterialTapTargetSize not supported on web");
    return MaterialTapTargetSize.values()[FilterChipObjSt.materialTapTargetSize(st)];
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("filterChipElevation not supported on web");
    return FilterChipObjSt.elevation(st);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("filterChipShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(FilterChipObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("filterChipSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(FilterChipObjSt.surfaceTintColor(st));
  }
  public Color selectedShadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("filterChipSelectedShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(FilterChipObjSt.selectedShadowColor(st));
  }
  public boolean showCheckmark() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("filterChipShowCheckmark not supported on web");
    return intToBool(FilterChipObjSt.showCheckmark(st));
  }
  public Color checkmarkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("filterChipCheckmarkColor", getId());
      return new Color(__nid);
    }
    return new Color(FilterChipObjSt.checkmarkColor(st));
  }
  public ShapeBorder avatarBorder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("filterChipAvatarBorder not supported on web");
    return new ShapeBorder(FilterChipObjSt.avatarBorder(st)) {};
  }
  public BoxConstraints avatarBoxConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("filterChipAvatarBoxConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(FilterChipObjSt.avatarBoxConstraints(st));
  }
  public BoxConstraints deleteIconBoxConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("filterChipDeleteIconBoxConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(FilterChipObjSt.deleteIconBoxConstraints(st));
  }
  @Override
  public FilterChip build() {
    return this;
  }
}
