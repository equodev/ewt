package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DatePickerThemeData extends NativeObj.Base implements DatePickerThemeDataI {
  protected DatePickerThemeData() {}
  DatePickerThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DatePickerThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DatePickerThemeData datePickerThemeDataDatePickerThemeData(Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ShapeBorderI> shape, Optional<ColorI> headerBackgroundColor, Optional<ColorI> headerForegroundColor, Optional<TextStyleI> headerHeadlineStyle, Optional<TextStyleI> headerHelpStyle, Optional<TextStyleI> weekdayStyle, Optional<TextStyleI> dayStyle, Optional<ColorI> dayForegroundColor, Optional<ColorI> dayBackgroundColor, Optional<ColorI> dayOverlayColor, Optional<OutlinedBorderI> dayShape, Optional<ColorI> todayForegroundColor, Optional<ColorI> todayBackgroundColor, Optional<BorderSideI> todayBorder, Optional<TextStyleI> yearStyle, Optional<ColorI> yearForegroundColor, Optional<ColorI> yearBackgroundColor, Optional<ColorI> yearOverlayColor, Optional<OutlinedBorderI> yearShape, Optional<ColorI> rangePickerBackgroundColor, OptionalDouble rangePickerElevation, Optional<ColorI> rangePickerShadowColor, Optional<ColorI> rangePickerSurfaceTintColor, Optional<ShapeBorderI> rangePickerShape, Optional<ColorI> rangePickerHeaderBackgroundColor, Optional<ColorI> rangePickerHeaderForegroundColor, Optional<TextStyleI> rangePickerHeaderHeadlineStyle, Optional<TextStyleI> rangePickerHeaderHelpStyle, Optional<ColorI> rangeSelectionBackgroundColor, Optional<ColorI> rangeSelectionOverlayColor, Optional<ColorI> dividerColor, Optional<NativeObj.I> inputDecorationTheme, Optional<TextStyleI> toggleButtonTextStyle, Optional<ColorI> subHeaderForegroundColor) {
    int id = factories.datePickerThemeDataDatePickerThemeData(backgroundColor.map(ColorI::build),
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      shape.map(ShapeBorderI::build),
      headerBackgroundColor.map(ColorI::build),
      headerForegroundColor.map(ColorI::build),
      headerHeadlineStyle.map(TextStyleI::build),
      headerHelpStyle.map(TextStyleI::build),
      weekdayStyle.map(TextStyleI::build),
      dayStyle.map(TextStyleI::build),
      dayForegroundColor.map(ColorI::build),
      dayBackgroundColor.map(ColorI::build),
      dayOverlayColor.map(ColorI::build),
      dayShape.map(OutlinedBorderI::build),
      todayForegroundColor.map(ColorI::build),
      todayBackgroundColor.map(ColorI::build),
      todayBorder.map(BorderSideI::build),
      yearStyle.map(TextStyleI::build),
      yearForegroundColor.map(ColorI::build),
      yearBackgroundColor.map(ColorI::build),
      yearOverlayColor.map(ColorI::build),
      yearShape.map(OutlinedBorderI::build),
      rangePickerBackgroundColor.map(ColorI::build),
      rangePickerElevation,
      rangePickerShadowColor.map(ColorI::build),
      rangePickerSurfaceTintColor.map(ColorI::build),
      rangePickerShape.map(ShapeBorderI::build),
      rangePickerHeaderBackgroundColor.map(ColorI::build),
      rangePickerHeaderForegroundColor.map(ColorI::build),
      rangePickerHeaderHeadlineStyle.map(TextStyleI::build),
      rangePickerHeaderHelpStyle.map(TextStyleI::build),
      rangeSelectionBackgroundColor.map(ColorI::build),
      rangeSelectionOverlayColor.map(ColorI::build),
      dividerColor.map(ColorI::build),
      inputDecorationTheme.map(NativeObj.I::build),
      toggleButtonTextStyle.map(TextStyleI::build),
      subHeaderForegroundColor.map(ColorI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget DatePickerThemeData");
    return new DatePickerThemeData(id);
  }
  public static DatePickerThemeDataDatePickerThemeDataBuilder datePickerThemeData() {
    return DatePickerThemeDataDatePickerThemeDataBuilder.datePickerThemeDataDatePickerThemeData();
  }
  public static DatePickerThemeData lerp(DatePickerThemeDataI a, DatePickerThemeDataI b, double t) {
    int id = factories.datePickerThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget DatePickerThemeData");
    return new DatePickerThemeData(id);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.DatePickerThemeData_readBack_backgroundColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerThemeDataElevation not supported on web");
    return factories.DatePickerThemeData_readBack_elevation(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataShadowColor", getId());
      return new Color(__nid);
    }
    return factories.DatePickerThemeData_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.DatePickerThemeData_readBack_surfaceTintColor(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerThemeDataShape not supported on web");
    return factories.DatePickerThemeData_readBack_shape(nativeStruct);
  }
  public Color headerBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataHeaderBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.DatePickerThemeData_readBack_headerBackgroundColor(nativeStruct);
  }
  public Color headerForegroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataHeaderForegroundColor", getId());
      return new Color(__nid);
    }
    return factories.DatePickerThemeData_readBack_headerForegroundColor(nativeStruct);
  }
  public TextStyle headerHeadlineStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataHeaderHeadlineStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.DatePickerThemeData_readBack_headerHeadlineStyle(nativeStruct);
  }
  public TextStyle headerHelpStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataHeaderHelpStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.DatePickerThemeData_readBack_headerHelpStyle(nativeStruct);
  }
  public TextStyle weekdayStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataWeekdayStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.DatePickerThemeData_readBack_weekdayStyle(nativeStruct);
  }
  public TextStyle dayStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataDayStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.DatePickerThemeData_readBack_dayStyle(nativeStruct);
  }
  public BorderSide todayBorder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataTodayBorder", getId());
      return new BorderSide(__nid);
    }
    return factories.DatePickerThemeData_readBack_todayBorder(nativeStruct);
  }
  public TextStyle yearStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataYearStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.DatePickerThemeData_readBack_yearStyle(nativeStruct);
  }
  public Color rangePickerBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataRangePickerBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.DatePickerThemeData_readBack_rangePickerBackgroundColor(nativeStruct);
  }
  public double rangePickerElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerThemeDataRangePickerElevation not supported on web");
    return factories.DatePickerThemeData_readBack_rangePickerElevation(nativeStruct);
  }
  public Color rangePickerShadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataRangePickerShadowColor", getId());
      return new Color(__nid);
    }
    return factories.DatePickerThemeData_readBack_rangePickerShadowColor(nativeStruct);
  }
  public Color rangePickerSurfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataRangePickerSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.DatePickerThemeData_readBack_rangePickerSurfaceTintColor(nativeStruct);
  }
  public ShapeBorder rangePickerShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerThemeDataRangePickerShape not supported on web");
    return factories.DatePickerThemeData_readBack_rangePickerShape(nativeStruct);
  }
  public Color rangePickerHeaderBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataRangePickerHeaderBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.DatePickerThemeData_readBack_rangePickerHeaderBackgroundColor(nativeStruct);
  }
  public Color rangePickerHeaderForegroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataRangePickerHeaderForegroundColor", getId());
      return new Color(__nid);
    }
    return factories.DatePickerThemeData_readBack_rangePickerHeaderForegroundColor(nativeStruct);
  }
  public TextStyle rangePickerHeaderHeadlineStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataRangePickerHeaderHeadlineStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.DatePickerThemeData_readBack_rangePickerHeaderHeadlineStyle(nativeStruct);
  }
  public TextStyle rangePickerHeaderHelpStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataRangePickerHeaderHelpStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.DatePickerThemeData_readBack_rangePickerHeaderHelpStyle(nativeStruct);
  }
  public Color rangeSelectionBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataRangeSelectionBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.DatePickerThemeData_readBack_rangeSelectionBackgroundColor(nativeStruct);
  }
  public Color dividerColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataDividerColor", getId());
      return new Color(__nid);
    }
    return factories.DatePickerThemeData_readBack_dividerColor(nativeStruct);
  }
  public TextStyle toggleButtonTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataToggleButtonTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.DatePickerThemeData_readBack_toggleButtonTextStyle(nativeStruct);
  }
  public Color subHeaderForegroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataSubHeaderForegroundColor", getId());
      return new Color(__nid);
    }
    return factories.DatePickerThemeData_readBack_subHeaderForegroundColor(nativeStruct);
  }
  @Override
  public DatePickerThemeData build() {
    return this;
  }
}
