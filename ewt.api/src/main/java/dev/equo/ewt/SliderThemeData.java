package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliderThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliderThemeData extends NativeObj.Base implements SliderThemeDataI {
  private MemorySegment st;
  protected SliderThemeData() {}
  SliderThemeData(MemorySegment st) {
    this.id = SliderThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliderThemeData");
    System.out.println("New SliderThemeData id:"+id);
  }
  SliderThemeData(int id) { this.id = id; }
  @Builder.Factory
  static SliderThemeData sliderThemeDataSliderThemeData(OptionalDouble trackHeight, Optional<ColorI> activeTrackColor, Optional<ColorI> inactiveTrackColor, Optional<ColorI> secondaryActiveTrackColor, Optional<ColorI> disabledActiveTrackColor, Optional<ColorI> disabledInactiveTrackColor, Optional<ColorI> disabledSecondaryActiveTrackColor, Optional<ColorI> activeTickMarkColor, Optional<ColorI> inactiveTickMarkColor, Optional<ColorI> disabledActiveTickMarkColor, Optional<ColorI> disabledInactiveTickMarkColor, Optional<ColorI> thumbColor, Optional<ColorI> overlappingShapeStrokeColor, Optional<ColorI> disabledThumbColor, Optional<ColorI> overlayColor, Optional<ColorI> valueIndicatorColor, Optional<ColorI> valueIndicatorStrokeColor, Optional<SliderComponentShapeI> overlayShape, Optional<SliderComponentShapeI> thumbShape, Optional<SliderComponentShapeI> valueIndicatorShape, Optional<ShowValueIndicator> showValueIndicator, Optional<TextStyleI> valueIndicatorTextStyle, OptionalDouble minThumbSeparation, Optional<SliderInteraction> allowedInteraction, Optional<EdgeInsetsGeometryI> padding, OptionalDouble trackGap, Optional<Boolean> year2023) {
    var st = factories.sliderThemeDataSliderThemeData(trackHeight,
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
    if (st == null) throw new RuntimeException("Failed to created widget SliderThemeData");
    return new SliderThemeData(st);
  }
  public static SliderThemeDataSliderThemeDataBuilder sliderThemeData() {
    return SliderThemeDataSliderThemeDataBuilder.sliderThemeDataSliderThemeData();
  }
  @Builder.Factory
  static SliderThemeData sliderThemeDataFromPrimaryColors(@Builder.Parameter ColorI primaryColor, @Builder.Parameter ColorI primaryColorDark, @Builder.Parameter ColorI primaryColorLight, @Builder.Parameter TextStyleI valueIndicatorTextStyle) {
    var st = factories.sliderThemeDataFromPrimaryColors(primaryColor.build(),
      primaryColorDark.build(),
      primaryColorLight.build(),
      valueIndicatorTextStyle.build());
    if (st == null) throw new RuntimeException("Failed to created widget SliderThemeData");
    return new SliderThemeData(st);
  }
  public static SliderThemeDataFromPrimaryColorsBuilder fromPrimaryColors(ColorI primaryColor, ColorI primaryColorDark, ColorI primaryColorLight, TextStyleI valueIndicatorTextStyle) {
    return SliderThemeDataFromPrimaryColorsBuilder.sliderThemeDataFromPrimaryColors(primaryColor, primaryColorDark, primaryColorLight, valueIndicatorTextStyle);
  }
  public static SliderThemeData lerp(SliderThemeDataI a, SliderThemeDataI b, double t) {
    var st = factories.sliderThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget SliderThemeData");
    return new SliderThemeData(st);
  }
  public double trackHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderThemeDataTrackHeight not supported on web");
    return SliderThemeDataObjSt.trackHeight(st);
  }
  public Color activeTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataActiveTrackColor", getId());
      return new Color(__nid);
    }
    return new Color(SliderThemeDataObjSt.activeTrackColor(st));
  }
  public Color inactiveTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataInactiveTrackColor", getId());
      return new Color(__nid);
    }
    return new Color(SliderThemeDataObjSt.inactiveTrackColor(st));
  }
  public Color secondaryActiveTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataSecondaryActiveTrackColor", getId());
      return new Color(__nid);
    }
    return new Color(SliderThemeDataObjSt.secondaryActiveTrackColor(st));
  }
  public Color disabledActiveTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataDisabledActiveTrackColor", getId());
      return new Color(__nid);
    }
    return new Color(SliderThemeDataObjSt.disabledActiveTrackColor(st));
  }
  public Color disabledSecondaryActiveTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataDisabledSecondaryActiveTrackColor", getId());
      return new Color(__nid);
    }
    return new Color(SliderThemeDataObjSt.disabledSecondaryActiveTrackColor(st));
  }
  public Color disabledInactiveTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataDisabledInactiveTrackColor", getId());
      return new Color(__nid);
    }
    return new Color(SliderThemeDataObjSt.disabledInactiveTrackColor(st));
  }
  public Color activeTickMarkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataActiveTickMarkColor", getId());
      return new Color(__nid);
    }
    return new Color(SliderThemeDataObjSt.activeTickMarkColor(st));
  }
  public Color inactiveTickMarkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataInactiveTickMarkColor", getId());
      return new Color(__nid);
    }
    return new Color(SliderThemeDataObjSt.inactiveTickMarkColor(st));
  }
  public Color disabledActiveTickMarkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataDisabledActiveTickMarkColor", getId());
      return new Color(__nid);
    }
    return new Color(SliderThemeDataObjSt.disabledActiveTickMarkColor(st));
  }
  public Color disabledInactiveTickMarkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataDisabledInactiveTickMarkColor", getId());
      return new Color(__nid);
    }
    return new Color(SliderThemeDataObjSt.disabledInactiveTickMarkColor(st));
  }
  public Color thumbColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataThumbColor", getId());
      return new Color(__nid);
    }
    return new Color(SliderThemeDataObjSt.thumbColor(st));
  }
  public Color overlappingShapeStrokeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataOverlappingShapeStrokeColor", getId());
      return new Color(__nid);
    }
    return new Color(SliderThemeDataObjSt.overlappingShapeStrokeColor(st));
  }
  public Color disabledThumbColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataDisabledThumbColor", getId());
      return new Color(__nid);
    }
    return new Color(SliderThemeDataObjSt.disabledThumbColor(st));
  }
  public Color overlayColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataOverlayColor", getId());
      return new Color(__nid);
    }
    return new Color(SliderThemeDataObjSt.overlayColor(st));
  }
  public Color valueIndicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataValueIndicatorColor", getId());
      return new Color(__nid);
    }
    return new Color(SliderThemeDataObjSt.valueIndicatorColor(st));
  }
  public Color valueIndicatorStrokeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataValueIndicatorStrokeColor", getId());
      return new Color(__nid);
    }
    return new Color(SliderThemeDataObjSt.valueIndicatorStrokeColor(st));
  }
  public SliderComponentShape overlayShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderThemeDataOverlayShape not supported on web");
    return new SliderComponentShape(SliderThemeDataObjSt.overlayShape(st)) {};
  }
  public SliderComponentShape thumbShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderThemeDataThumbShape not supported on web");
    return new SliderComponentShape(SliderThemeDataObjSt.thumbShape(st)) {};
  }
  public SliderComponentShape valueIndicatorShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderThemeDataValueIndicatorShape not supported on web");
    return new SliderComponentShape(SliderThemeDataObjSt.valueIndicatorShape(st)) {};
  }
  public ShowValueIndicator showValueIndicator() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderThemeDataShowValueIndicator not supported on web");
    return ShowValueIndicator.values()[SliderThemeDataObjSt.showValueIndicator(st)];
  }
  public TextStyle valueIndicatorTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeDataValueIndicatorTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(SliderThemeDataObjSt.valueIndicatorTextStyle(st));
  }
  public double minThumbSeparation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderThemeDataMinThumbSeparation not supported on web");
    return SliderThemeDataObjSt.minThumbSeparation(st);
  }
  public SliderInteraction allowedInteraction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderThemeDataAllowedInteraction not supported on web");
    return SliderInteraction.values()[SliderThemeDataObjSt.allowedInteraction(st)];
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderThemeDataPadding not supported on web");
    return new EdgeInsetsGeometry(SliderThemeDataObjSt.padding(st)) {};
  }
  public double trackGap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderThemeDataTrackGap not supported on web");
    return SliderThemeDataObjSt.trackGap(st);
  }
  public boolean year2023() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliderThemeDataYear2023 not supported on web");
    return intToBool(SliderThemeDataObjSt.year2023(st));
  }
  @Override
  public SliderThemeData build() {
    return this;
  }
}
