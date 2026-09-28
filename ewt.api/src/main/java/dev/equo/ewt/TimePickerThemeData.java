package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TimePickerThemeData extends NativeObj.Base implements TimePickerThemeDataI {
  protected TimePickerThemeData() {}
  TimePickerThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TimePickerThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TimePickerThemeData timePickerThemeDataTimePickerThemeData(Optional<ColorI> backgroundColor, Optional<BorderSideI> dayPeriodBorderSide, Optional<ColorI> dayPeriodColor, Optional<OutlinedBorderI> dayPeriodShape, Optional<ColorI> dayPeriodTextColor, Optional<TextStyleI> dayPeriodTextStyle, Optional<ColorI> dialBackgroundColor, Optional<ColorI> dialHandColor, Optional<ColorI> dialTextColor, Optional<TextStyleI> dialTextStyle, OptionalDouble elevation, Optional<ColorI> entryModeIconColor, Optional<TextStyleI> helpTextStyle, Optional<ColorI> hourMinuteColor, Optional<ShapeBorderI> hourMinuteShape, Optional<ColorI> hourMinuteTextColor, Optional<TextStyleI> hourMinuteTextStyle, Optional<NativeObj.I> inputDecorationTheme, Optional<EdgeInsetsGeometryI> padding, Optional<ShapeBorderI> shape, Optional<ColorI> timeSelectorSeparatorColor, Optional<TextStyleI> timeSelectorSeparatorTextStyle) {
    int id = factories.timePickerThemeDataTimePickerThemeData(backgroundColor.map(ColorI::build),
      dayPeriodBorderSide.map(BorderSideI::build),
      dayPeriodColor.map(ColorI::build),
      dayPeriodShape.map(OutlinedBorderI::build),
      dayPeriodTextColor.map(ColorI::build),
      dayPeriodTextStyle.map(TextStyleI::build),
      dialBackgroundColor.map(ColorI::build),
      dialHandColor.map(ColorI::build),
      dialTextColor.map(ColorI::build),
      dialTextStyle.map(TextStyleI::build),
      elevation,
      entryModeIconColor.map(ColorI::build),
      helpTextStyle.map(TextStyleI::build),
      hourMinuteColor.map(ColorI::build),
      hourMinuteShape.map(ShapeBorderI::build),
      hourMinuteTextColor.map(ColorI::build),
      hourMinuteTextStyle.map(TextStyleI::build),
      inputDecorationTheme.map(NativeObj.I::build),
      padding.map(EdgeInsetsGeometryI::build),
      shape.map(ShapeBorderI::build),
      timeSelectorSeparatorColor.map(ColorI::build),
      timeSelectorSeparatorTextStyle.map(TextStyleI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget TimePickerThemeData");
    return new TimePickerThemeData(id);
  }
  public static TimePickerThemeDataTimePickerThemeDataBuilder timePickerThemeData() {
    return TimePickerThemeDataTimePickerThemeDataBuilder.timePickerThemeDataTimePickerThemeData();
  }
  public static TimePickerThemeData lerp(TimePickerThemeDataI a, TimePickerThemeDataI b, double t) {
    int id = factories.timePickerThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget TimePickerThemeData");
    return new TimePickerThemeData(id);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.TimePickerThemeData_readBack_backgroundColor(nativeStruct);
  }
  public BorderSide dayPeriodBorderSide() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataDayPeriodBorderSide", getId());
      return new BorderSide(__nid);
    }
    return factories.TimePickerThemeData_readBack_dayPeriodBorderSide(nativeStruct);
  }
  public OutlinedBorder dayPeriodShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerThemeDataDayPeriodShape not supported on web");
    return factories.TimePickerThemeData_readBack_dayPeriodShape(nativeStruct);
  }
  public Color dayPeriodTextColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataDayPeriodTextColor", getId());
      return new Color(__nid);
    }
    return factories.TimePickerThemeData_readBack_dayPeriodTextColor(nativeStruct);
  }
  public TextStyle dayPeriodTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataDayPeriodTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.TimePickerThemeData_readBack_dayPeriodTextStyle(nativeStruct);
  }
  public Color dialBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataDialBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.TimePickerThemeData_readBack_dialBackgroundColor(nativeStruct);
  }
  public Color dialHandColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataDialHandColor", getId());
      return new Color(__nid);
    }
    return factories.TimePickerThemeData_readBack_dialHandColor(nativeStruct);
  }
  public Color dialTextColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataDialTextColor", getId());
      return new Color(__nid);
    }
    return factories.TimePickerThemeData_readBack_dialTextColor(nativeStruct);
  }
  public TextStyle dialTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataDialTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.TimePickerThemeData_readBack_dialTextStyle(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerThemeDataElevation not supported on web");
    return factories.TimePickerThemeData_readBack_elevation(nativeStruct);
  }
  public Color entryModeIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataEntryModeIconColor", getId());
      return new Color(__nid);
    }
    return factories.TimePickerThemeData_readBack_entryModeIconColor(nativeStruct);
  }
  public TextStyle helpTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataHelpTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.TimePickerThemeData_readBack_helpTextStyle(nativeStruct);
  }
  public Color hourMinuteColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataHourMinuteColor", getId());
      return new Color(__nid);
    }
    return factories.TimePickerThemeData_readBack_hourMinuteColor(nativeStruct);
  }
  public ShapeBorder hourMinuteShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerThemeDataHourMinuteShape not supported on web");
    return factories.TimePickerThemeData_readBack_hourMinuteShape(nativeStruct);
  }
  public Color hourMinuteTextColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataHourMinuteTextColor", getId());
      return new Color(__nid);
    }
    return factories.TimePickerThemeData_readBack_hourMinuteTextColor(nativeStruct);
  }
  public TextStyle hourMinuteTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataHourMinuteTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.TimePickerThemeData_readBack_hourMinuteTextStyle(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerThemeDataPadding not supported on web");
    return factories.TimePickerThemeData_readBack_padding(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerThemeDataShape not supported on web");
    return factories.TimePickerThemeData_readBack_shape(nativeStruct);
  }
  public Color dayPeriodColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataDayPeriodColor", getId());
      return new Color(__nid);
    }
    return factories.TimePickerThemeData_readBack_dayPeriodColor(nativeStruct);
  }
  @Override
  public TimePickerThemeData build() {
    return this;
  }
}
