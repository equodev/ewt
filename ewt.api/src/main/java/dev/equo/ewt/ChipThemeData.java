package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ChipThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ChipThemeData extends NativeObj.Base implements ChipThemeDataI {
  private MemorySegment st;
  protected ChipThemeData() {}
  ChipThemeData(MemorySegment st) {
    this.id = ChipThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ChipThemeData");
    System.out.println("New ChipThemeData id:"+id);
  }
  ChipThemeData(int id) { this.id = id; }
  @Builder.Factory
  static ChipThemeData chipThemeDataChipThemeData(Optional<ColorI> color, Optional<ColorI> backgroundColor, Optional<ColorI> deleteIconColor, Optional<ColorI> disabledColor, Optional<ColorI> selectedColor, Optional<ColorI> secondarySelectedColor, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ColorI> selectedShadowColor, Optional<Boolean> showCheckmark, Optional<ColorI> checkmarkColor, Optional<EdgeInsetsGeometryI> labelPadding, Optional<EdgeInsetsGeometryI> padding, Optional<BorderSideI> side, Optional<OutlinedBorderI> shape, Optional<TextStyleI> labelStyle, Optional<TextStyleI> secondaryLabelStyle, Optional<Brightness> brightness, OptionalDouble elevation, OptionalDouble pressElevation, Optional<IconThemeDataI> iconTheme, Optional<BoxConstraintsI> avatarBoxConstraints, Optional<BoxConstraintsI> deleteIconBoxConstraints) {
    var st = factories.chipThemeDataChipThemeData(color.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      deleteIconColor.map(ColorI::build),
      disabledColor.map(ColorI::build),
      selectedColor.map(ColorI::build),
      secondarySelectedColor.map(ColorI::build),
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      selectedShadowColor.map(ColorI::build),
      showCheckmark,
      checkmarkColor.map(ColorI::build),
      labelPadding.map(EdgeInsetsGeometryI::build),
      padding.map(EdgeInsetsGeometryI::build),
      side.map(BorderSideI::build),
      shape.map(OutlinedBorderI::build),
      labelStyle.map(TextStyleI::build),
      secondaryLabelStyle.map(TextStyleI::build),
      brightness,
      elevation,
      pressElevation,
      iconTheme.map(IconThemeDataI::build),
      avatarBoxConstraints.map(BoxConstraintsI::build),
      deleteIconBoxConstraints.map(BoxConstraintsI::build));
    if (st == null) throw new RuntimeException("Failed to created widget ChipThemeData");
    return new ChipThemeData(st);
  }
  public static ChipThemeDataChipThemeDataBuilder chipThemeData() {
    return ChipThemeDataChipThemeDataBuilder.chipThemeDataChipThemeData();
  }
  @Builder.Factory
  static ChipThemeData chipThemeDataFromDefaults(Optional<Brightness> brightness, Optional<ColorI> primaryColor, ColorI secondaryColor, TextStyleI labelStyle) {
    var st = factories.chipThemeDataFromDefaults(brightness,
      primaryColor.map(ColorI::build),
      secondaryColor.build(),
      labelStyle.build());
    if (st == null) throw new RuntimeException("Failed to created widget ChipThemeData");
    return new ChipThemeData(st);
  }
  public static ChipThemeDataFromDefaultsBuilder fromDefaults() {
    return ChipThemeDataFromDefaultsBuilder.chipThemeDataFromDefaults();
  }
  public static ChipThemeData lerp(ChipThemeDataI a, ChipThemeDataI b, double t) {
    var st = factories.chipThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget ChipThemeData");
    return new ChipThemeData(st);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(ChipThemeDataObjSt.backgroundColor(st));
  }
  public Color deleteIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataDeleteIconColor", getId());
      return new Color(__nid);
    }
    return new Color(ChipThemeDataObjSt.deleteIconColor(st));
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataDisabledColor", getId());
      return new Color(__nid);
    }
    return new Color(ChipThemeDataObjSt.disabledColor(st));
  }
  public Color selectedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataSelectedColor", getId());
      return new Color(__nid);
    }
    return new Color(ChipThemeDataObjSt.selectedColor(st));
  }
  public Color secondarySelectedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataSecondarySelectedColor", getId());
      return new Color(__nid);
    }
    return new Color(ChipThemeDataObjSt.secondarySelectedColor(st));
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(ChipThemeDataObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(ChipThemeDataObjSt.surfaceTintColor(st));
  }
  public Color selectedShadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataSelectedShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(ChipThemeDataObjSt.selectedShadowColor(st));
  }
  public boolean showCheckmark() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("chipThemeDataShowCheckmark not supported on web");
    return intToBool(ChipThemeDataObjSt.showCheckmark(st));
  }
  public Color checkmarkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataCheckmarkColor", getId());
      return new Color(__nid);
    }
    return new Color(ChipThemeDataObjSt.checkmarkColor(st));
  }
  public EdgeInsetsGeometry labelPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("chipThemeDataLabelPadding not supported on web");
    return new EdgeInsetsGeometry(ChipThemeDataObjSt.labelPadding(st)) {};
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("chipThemeDataPadding not supported on web");
    return new EdgeInsetsGeometry(ChipThemeDataObjSt.padding(st)) {};
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataSide", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderSideObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderSideObjSt.id(__st, __nid);
      return new BorderSide(__st);
    }
    return new BorderSide(ChipThemeDataObjSt.side(st));
  }
  public OutlinedBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("chipThemeDataShape not supported on web");
    return new OutlinedBorder(ChipThemeDataObjSt.shape(st)) {};
  }
  public TextStyle labelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataLabelStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(ChipThemeDataObjSt.labelStyle(st));
  }
  public TextStyle secondaryLabelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataSecondaryLabelStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(ChipThemeDataObjSt.secondaryLabelStyle(st));
  }
  public Brightness brightness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("chipThemeDataBrightness not supported on web");
    return Brightness.values()[ChipThemeDataObjSt.brightness(st)];
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("chipThemeDataElevation not supported on web");
    return ChipThemeDataObjSt.elevation(st);
  }
  public double pressElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("chipThemeDataPressElevation not supported on web");
    return ChipThemeDataObjSt.pressElevation(st);
  }
  public IconThemeData iconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataIconTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconThemeDataObjSt.id(__st, __nid);
      return new IconThemeData(__st);
    }
    return new IconThemeData(ChipThemeDataObjSt.iconTheme(st));
  }
  public BoxConstraints avatarBoxConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataAvatarBoxConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(ChipThemeDataObjSt.avatarBoxConstraints(st));
  }
  public BoxConstraints deleteIconBoxConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataDeleteIconBoxConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(ChipThemeDataObjSt.deleteIconBoxConstraints(st));
  }
  @Override
  public ChipThemeData build() {
    return this;
  }
}
