package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ChipThemeData extends NativeObj.Base implements ChipThemeDataI {
  protected ChipThemeData() {}
  ChipThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ChipThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ChipThemeData chipThemeDataChipThemeData(Optional<ColorI> color, Optional<ColorI> backgroundColor, Optional<ColorI> deleteIconColor, Optional<ColorI> disabledColor, Optional<ColorI> selectedColor, Optional<ColorI> secondarySelectedColor, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ColorI> selectedShadowColor, Optional<Boolean> showCheckmark, Optional<ColorI> checkmarkColor, Optional<EdgeInsetsGeometryI> labelPadding, Optional<EdgeInsetsGeometryI> padding, Optional<BorderSideI> side, Optional<OutlinedBorderI> shape, Optional<TextStyleI> labelStyle, Optional<TextStyleI> secondaryLabelStyle, Optional<Brightness> brightness, OptionalDouble elevation, OptionalDouble pressElevation, Optional<IconThemeDataI> iconTheme, Optional<BoxConstraintsI> avatarBoxConstraints, Optional<BoxConstraintsI> deleteIconBoxConstraints) {
    int id = factories.chipThemeDataChipThemeData(color.map(ColorI::build),
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
    if (id <= 0) throw new RuntimeException("Failed to created widget ChipThemeData");
    return new ChipThemeData(id);
  }
  public static ChipThemeDataChipThemeDataBuilder chipThemeData() {
    return ChipThemeDataChipThemeDataBuilder.chipThemeDataChipThemeData();
  }
  @Builder.Factory
  static ChipThemeData chipThemeDataFromDefaults(Optional<Brightness> brightness, Optional<ColorI> primaryColor, ColorI secondaryColor, TextStyleI labelStyle) {
    int id = factories.chipThemeDataFromDefaults(brightness,
      primaryColor.map(ColorI::build),
      secondaryColor.build(),
      labelStyle.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ChipThemeData");
    return new ChipThemeData(id);
  }
  public static ChipThemeDataFromDefaultsBuilder fromDefaults() {
    return ChipThemeDataFromDefaultsBuilder.chipThemeDataFromDefaults();
  }
  public static ChipThemeData lerp(ChipThemeDataI a, ChipThemeDataI b, double t) {
    int id = factories.chipThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget ChipThemeData");
    return new ChipThemeData(id);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.ChipThemeData_readBack_backgroundColor(nativeStruct);
  }
  public Color deleteIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataDeleteIconColor", getId());
      return new Color(__nid);
    }
    return factories.ChipThemeData_readBack_deleteIconColor(nativeStruct);
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataDisabledColor", getId());
      return new Color(__nid);
    }
    return factories.ChipThemeData_readBack_disabledColor(nativeStruct);
  }
  public Color selectedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataSelectedColor", getId());
      return new Color(__nid);
    }
    return factories.ChipThemeData_readBack_selectedColor(nativeStruct);
  }
  public Color secondarySelectedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataSecondarySelectedColor", getId());
      return new Color(__nid);
    }
    return factories.ChipThemeData_readBack_secondarySelectedColor(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataShadowColor", getId());
      return new Color(__nid);
    }
    return factories.ChipThemeData_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.ChipThemeData_readBack_surfaceTintColor(nativeStruct);
  }
  public Color selectedShadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataSelectedShadowColor", getId());
      return new Color(__nid);
    }
    return factories.ChipThemeData_readBack_selectedShadowColor(nativeStruct);
  }
  public boolean showCheckmark() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("chipThemeDataShowCheckmark not supported on web");
    return factories.ChipThemeData_readBack_showCheckmark(nativeStruct);
  }
  public Color checkmarkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataCheckmarkColor", getId());
      return new Color(__nid);
    }
    return factories.ChipThemeData_readBack_checkmarkColor(nativeStruct);
  }
  public EdgeInsetsGeometry labelPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("chipThemeDataLabelPadding not supported on web");
    return factories.ChipThemeData_readBack_labelPadding(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("chipThemeDataPadding not supported on web");
    return factories.ChipThemeData_readBack_padding(nativeStruct);
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataSide", getId());
      return new BorderSide(__nid);
    }
    return factories.ChipThemeData_readBack_side(nativeStruct);
  }
  public OutlinedBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("chipThemeDataShape not supported on web");
    return factories.ChipThemeData_readBack_shape(nativeStruct);
  }
  public TextStyle labelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataLabelStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.ChipThemeData_readBack_labelStyle(nativeStruct);
  }
  public TextStyle secondaryLabelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataSecondaryLabelStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.ChipThemeData_readBack_secondaryLabelStyle(nativeStruct);
  }
  public Brightness brightness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("chipThemeDataBrightness not supported on web");
    return factories.ChipThemeData_readBack_brightness(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("chipThemeDataElevation not supported on web");
    return factories.ChipThemeData_readBack_elevation(nativeStruct);
  }
  public double pressElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("chipThemeDataPressElevation not supported on web");
    return factories.ChipThemeData_readBack_pressElevation(nativeStruct);
  }
  public IconThemeData iconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataIconTheme", getId());
      return new IconThemeData(__nid);
    }
    return factories.ChipThemeData_readBack_iconTheme(nativeStruct);
  }
  public BoxConstraints avatarBoxConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataAvatarBoxConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.ChipThemeData_readBack_avatarBoxConstraints(nativeStruct);
  }
  public BoxConstraints deleteIconBoxConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("chipThemeDataDeleteIconBoxConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.ChipThemeData_readBack_deleteIconBoxConstraints(nativeStruct);
  }
  @Override
  public ChipThemeData build() {
    return this;
  }
}
