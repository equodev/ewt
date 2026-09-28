package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliderThemeData extends NativeObj.Base implements SliderThemeDataI {
  protected SliderThemeData() {}
  SliderThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliderThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliderThemeData sliderThemeDataSliderThemeData(OptionalDouble trackHeight, Optional<ColorI> activeTrackColor, Optional<ColorI> inactiveTrackColor, Optional<ColorI> secondaryActiveTrackColor, Optional<ColorI> disabledActiveTrackColor, Optional<ColorI> disabledInactiveTrackColor, Optional<ColorI> disabledSecondaryActiveTrackColor, Optional<ColorI> activeTickMarkColor, Optional<ColorI> inactiveTickMarkColor, Optional<ColorI> disabledActiveTickMarkColor, Optional<ColorI> disabledInactiveTickMarkColor, Optional<ColorI> thumbColor, Optional<ColorI> overlappingShapeStrokeColor, Optional<ColorI> disabledThumbColor, Optional<ColorI> overlayColor, Optional<ColorI> valueIndicatorColor, Optional<ColorI> valueIndicatorStrokeColor, Optional<SliderComponentShapeI> overlayShape, Optional<SliderComponentShapeI> thumbShape, Optional<SliderComponentShapeI> valueIndicatorShape, Optional<ShowValueIndicator> showValueIndicator, Optional<TextStyleI> valueIndicatorTextStyle, OptionalDouble minThumbSeparation, Optional<SliderInteraction> allowedInteraction, Optional<EdgeInsetsGeometryI> padding, OptionalDouble trackGap, Optional<Boolean> year2023) {
    int id = factories.sliderThemeDataSliderThemeData(trackHeight,
      activeTrackColor.map(ColorI::build),
      inactiveTrackColor.map(ColorI::build),
      secondaryActiveTrackColor.map(ColorI::build),
      disabledActiveTrackColor.map(ColorI::build),
      disabledInactiveTrackColor.map(ColorI::build),
      disabledSecondaryActiveTrackColor.map(ColorI::build),
      activeTickMarkColor.map(ColorI::build),
      inactiveTickMarkColor.map(ColorI::build),
      disabledActiveTickMarkColor.map(ColorI::build),
      disabledInactiveTickMarkColor.map(ColorI::build),
      thumbColor.map(ColorI::build),
      overlappingShapeStrokeColor.map(ColorI::build),
      disabledThumbColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      valueIndicatorColor.map(ColorI::build),
      valueIndicatorStrokeColor.map(ColorI::build),
      overlayShape.map(SliderComponentShapeI::build),
      thumbShape.map(SliderComponentShapeI::build),
      valueIndicatorShape.map(SliderComponentShapeI::build),
      showValueIndicator,
      valueIndicatorTextStyle.map(TextStyleI::build),
      minThumbSeparation,
      allowedInteraction,
      padding.map(EdgeInsetsGeometryI::build),
      trackGap,
      year2023);
    if (id <= 0) throw new RuntimeException("Failed to created widget SliderThemeData");
    return new SliderThemeData(id);
  }
  public static SliderThemeDataSliderThemeDataBuilder sliderThemeData() {
    return SliderThemeDataSliderThemeDataBuilder.sliderThemeDataSliderThemeData();
  }
  @Builder.Factory
  static SliderThemeData sliderThemeDataFromPrimaryColors(@Builder.Parameter ColorI primaryColor, @Builder.Parameter ColorI primaryColorDark, @Builder.Parameter ColorI primaryColorLight, @Builder.Parameter TextStyleI valueIndicatorTextStyle) {
    int id = factories.sliderThemeDataFromPrimaryColors(primaryColor.build(),
      primaryColorDark.build(),
      primaryColorLight.build(),
      valueIndicatorTextStyle.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget SliderThemeData");
    return new SliderThemeData(id);
  }
  public static SliderThemeDataFromPrimaryColorsBuilder fromPrimaryColors(ColorI primaryColor, ColorI primaryColorDark, ColorI primaryColorLight, TextStyleI valueIndicatorTextStyle) {
    return SliderThemeDataFromPrimaryColorsBuilder.sliderThemeDataFromPrimaryColors(primaryColor, primaryColorDark, primaryColorLight, valueIndicatorTextStyle);
  }
  public static SliderThemeData lerp(SliderThemeDataI a, SliderThemeDataI b, double t) {
    int id = factories.sliderThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget SliderThemeData");
    return new SliderThemeData(id);
  }
  public double trackHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderThemeDataTrackHeight not supported on web");
    return factories.SliderThemeData_readBack_trackHeight(nativeStruct);
  }
  public Color activeTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataActiveTrackColor", getId());
      return new Color(__nid);
    }
    return factories.SliderThemeData_readBack_activeTrackColor(nativeStruct);
  }
  public Color inactiveTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataInactiveTrackColor", getId());
      return new Color(__nid);
    }
    return factories.SliderThemeData_readBack_inactiveTrackColor(nativeStruct);
  }
  public Color secondaryActiveTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataSecondaryActiveTrackColor", getId());
      return new Color(__nid);
    }
    return factories.SliderThemeData_readBack_secondaryActiveTrackColor(nativeStruct);
  }
  public Color disabledActiveTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataDisabledActiveTrackColor", getId());
      return new Color(__nid);
    }
    return factories.SliderThemeData_readBack_disabledActiveTrackColor(nativeStruct);
  }
  public Color disabledSecondaryActiveTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataDisabledSecondaryActiveTrackColor", getId());
      return new Color(__nid);
    }
    return factories.SliderThemeData_readBack_disabledSecondaryActiveTrackColor(nativeStruct);
  }
  public Color disabledInactiveTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataDisabledInactiveTrackColor", getId());
      return new Color(__nid);
    }
    return factories.SliderThemeData_readBack_disabledInactiveTrackColor(nativeStruct);
  }
  public Color activeTickMarkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataActiveTickMarkColor", getId());
      return new Color(__nid);
    }
    return factories.SliderThemeData_readBack_activeTickMarkColor(nativeStruct);
  }
  public Color inactiveTickMarkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataInactiveTickMarkColor", getId());
      return new Color(__nid);
    }
    return factories.SliderThemeData_readBack_inactiveTickMarkColor(nativeStruct);
  }
  public Color disabledActiveTickMarkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataDisabledActiveTickMarkColor", getId());
      return new Color(__nid);
    }
    return factories.SliderThemeData_readBack_disabledActiveTickMarkColor(nativeStruct);
  }
  public Color disabledInactiveTickMarkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataDisabledInactiveTickMarkColor", getId());
      return new Color(__nid);
    }
    return factories.SliderThemeData_readBack_disabledInactiveTickMarkColor(nativeStruct);
  }
  public Color thumbColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataThumbColor", getId());
      return new Color(__nid);
    }
    return factories.SliderThemeData_readBack_thumbColor(nativeStruct);
  }
  public Color overlappingShapeStrokeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataOverlappingShapeStrokeColor", getId());
      return new Color(__nid);
    }
    return factories.SliderThemeData_readBack_overlappingShapeStrokeColor(nativeStruct);
  }
  public Color disabledThumbColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataDisabledThumbColor", getId());
      return new Color(__nid);
    }
    return factories.SliderThemeData_readBack_disabledThumbColor(nativeStruct);
  }
  public Color overlayColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataOverlayColor", getId());
      return new Color(__nid);
    }
    return factories.SliderThemeData_readBack_overlayColor(nativeStruct);
  }
  public Color valueIndicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataValueIndicatorColor", getId());
      return new Color(__nid);
    }
    return factories.SliderThemeData_readBack_valueIndicatorColor(nativeStruct);
  }
  public Color valueIndicatorStrokeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataValueIndicatorStrokeColor", getId());
      return new Color(__nid);
    }
    return factories.SliderThemeData_readBack_valueIndicatorStrokeColor(nativeStruct);
  }
  public SliderComponentShape overlayShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderThemeDataOverlayShape not supported on web");
    return factories.SliderThemeData_readBack_overlayShape(nativeStruct);
  }
  public SliderComponentShape thumbShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderThemeDataThumbShape not supported on web");
    return factories.SliderThemeData_readBack_thumbShape(nativeStruct);
  }
  public SliderComponentShape valueIndicatorShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderThemeDataValueIndicatorShape not supported on web");
    return factories.SliderThemeData_readBack_valueIndicatorShape(nativeStruct);
  }
  public ShowValueIndicator showValueIndicator() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderThemeDataShowValueIndicator not supported on web");
    return factories.SliderThemeData_readBack_showValueIndicator(nativeStruct);
  }
  public TextStyle valueIndicatorTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataValueIndicatorTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.SliderThemeData_readBack_valueIndicatorTextStyle(nativeStruct);
  }
  public double minThumbSeparation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderThemeDataMinThumbSeparation not supported on web");
    return factories.SliderThemeData_readBack_minThumbSeparation(nativeStruct);
  }
  public SliderInteraction allowedInteraction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderThemeDataAllowedInteraction not supported on web");
    return factories.SliderThemeData_readBack_allowedInteraction(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderThemeDataPadding not supported on web");
    return factories.SliderThemeData_readBack_padding(nativeStruct);
  }
  public double trackGap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderThemeDataTrackGap not supported on web");
    return factories.SliderThemeData_readBack_trackGap(nativeStruct);
  }
  public boolean year2023() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderThemeDataYear2023 not supported on web");
    return factories.SliderThemeData_readBack_year2023(nativeStruct);
  }
  @Override
  public SliderThemeData build() {
    return this;
  }
}
