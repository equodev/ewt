package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RawChipObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class RawChip extends StatefulWidget implements RawChipI {
  private MemorySegment st;
  protected RawChip() {}
  RawChip(MemorySegment st) {
    this.id = RawChipObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget RawChip");
    System.out.println("New RawChip id:"+id);
  }
  RawChip(int id) { this.id = id; }
  @Builder.Factory
  static RawChip rawChipRawChip(Optional<WidgetI> avatar, WidgetI label, Optional<TextStyleI> labelStyle, Optional<EdgeInsetsGeometryI> padding, Optional<VisualDensityI> visualDensity, Optional<EdgeInsetsGeometryI> labelPadding, Optional<WidgetI> deleteIcon, Optional<Runnable> onDeleted, Optional<ColorI> deleteIconColor, Optional<String> deleteButtonTooltipMessage, Optional<Runnable> onPressed, Optional<Consumer<Boolean>> onSelected, OptionalDouble pressElevation, Optional<Boolean> tapEnabled, Optional<Boolean> selected, Optional<Boolean> isEnabled, Optional<ColorI> disabledColor, Optional<ColorI> selectedColor, Optional<String> tooltip, Optional<BorderSideI> side, Optional<OutlinedBorderI> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<ColorI> color, Optional<ColorI> backgroundColor, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<IconThemeDataI> iconTheme, Optional<ColorI> selectedShadowColor, Optional<Boolean> showCheckmark, Optional<ColorI> checkmarkColor, Optional<ShapeBorderI> avatarBorder, Optional<BoxConstraintsI> avatarBoxConstraints, Optional<BoxConstraintsI> deleteIconBoxConstraints) {
    var st = factories.rawChipRawChip(avatar.map(WidgetI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget RawChip");
    return new RawChip(st);
  }
  public static RawChipRawChipBuilder rawChip() {
    return RawChipRawChipBuilder.rawChipRawChip();
  }
  public Widget avatar() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipAvatar not supported on web");
    return new Widget(RawChipObjSt.avatar(st)) {};
  }
  public Widget label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipLabel not supported on web");
    return new Widget(RawChipObjSt.label(st)) {};
  }
  public TextStyle labelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipLabelStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(RawChipObjSt.labelStyle(st));
  }
  public EdgeInsetsGeometry labelPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipLabelPadding not supported on web");
    return new EdgeInsetsGeometry(RawChipObjSt.labelPadding(st)) {};
  }
  public Widget deleteIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipDeleteIcon not supported on web");
    return new Widget(RawChipObjSt.deleteIcon(st)) {};
  }
  public Color deleteIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipDeleteIconColor", getId());
      return new Color(__nid);
    }
    return new Color(RawChipObjSt.deleteIconColor(st));
  }
  public String deleteButtonTooltipMessage() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipDeleteButtonTooltipMessage not supported on web");
    return RawChipObjSt.deleteButtonTooltipMessage(st).getString(0);
  }
  public double pressElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipPressElevation not supported on web");
    return RawChipObjSt.pressElevation(st);
  }
  public boolean selected() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipSelected not supported on web");
    return intToBool(RawChipObjSt.selected(st));
  }
  public boolean isEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipIsEnabled not supported on web");
    return intToBool(RawChipObjSt.isEnabled(st));
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipDisabledColor", getId());
      return new Color(__nid);
    }
    return new Color(RawChipObjSt.disabledColor(st));
  }
  public Color selectedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipSelectedColor", getId());
      return new Color(__nid);
    }
    return new Color(RawChipObjSt.selectedColor(st));
  }
  public String tooltip() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipTooltip not supported on web");
    return RawChipObjSt.tooltip(st).getString(0);
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipSide", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderSideObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderSideObjSt.id(__st, __nid);
      return new BorderSide(__st);
    }
    return new BorderSide(RawChipObjSt.side(st));
  }
  public OutlinedBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipShape not supported on web");
    return new OutlinedBorder(RawChipObjSt.shape(st)) {};
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipClipBehavior not supported on web");
    return Clip.values()[RawChipObjSt.clipBehavior(st)];
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipAutofocus not supported on web");
    return intToBool(RawChipObjSt.autofocus(st));
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(RawChipObjSt.backgroundColor(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipPadding not supported on web");
    return new EdgeInsetsGeometry(RawChipObjSt.padding(st)) {};
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipVisualDensity", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.VisualDensityObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.VisualDensityObjSt.id(__st, __nid);
      return new VisualDensity(__st);
    }
    return new VisualDensity(RawChipObjSt.visualDensity(st));
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipMaterialTapTargetSize not supported on web");
    return MaterialTapTargetSize.values()[RawChipObjSt.materialTapTargetSize(st)];
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipElevation not supported on web");
    return RawChipObjSt.elevation(st);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(RawChipObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(RawChipObjSt.surfaceTintColor(st));
  }
  public IconThemeData iconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipIconTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconThemeDataObjSt.id(__st, __nid);
      return new IconThemeData(__st);
    }
    return new IconThemeData(RawChipObjSt.iconTheme(st));
  }
  public Color selectedShadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipSelectedShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(RawChipObjSt.selectedShadowColor(st));
  }
  public boolean showCheckmark() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipShowCheckmark not supported on web");
    return intToBool(RawChipObjSt.showCheckmark(st));
  }
  public Color checkmarkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipCheckmarkColor", getId());
      return new Color(__nid);
    }
    return new Color(RawChipObjSt.checkmarkColor(st));
  }
  public ShapeBorder avatarBorder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipAvatarBorder not supported on web");
    return new ShapeBorder(RawChipObjSt.avatarBorder(st)) {};
  }
  public BoxConstraints avatarBoxConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipAvatarBoxConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(RawChipObjSt.avatarBoxConstraints(st));
  }
  public BoxConstraints deleteIconBoxConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawChipDeleteIconBoxConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(RawChipObjSt.deleteIconBoxConstraints(st));
  }
  public boolean tapEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawChipTapEnabled not supported on web");
    return intToBool(RawChipObjSt.tapEnabled(st));
  }
  @Override
  public RawChip build() {
    return this;
  }
}
