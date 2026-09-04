package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DatePickerThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DatePickerThemeData extends NativeObj.Base implements DatePickerThemeDataI {
  private MemorySegment st;
  protected DatePickerThemeData() {}
  DatePickerThemeData(MemorySegment st) {
    this.id = DatePickerThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DatePickerThemeData");
    System.out.println("New DatePickerThemeData id:"+id);
  }
  DatePickerThemeData(int id) { this.id = id; }
  @Builder.Factory
  static DatePickerThemeData datePickerThemeDataDatePickerThemeData(Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ShapeBorderI> shape, Optional<ColorI> headerBackgroundColor, Optional<ColorI> headerForegroundColor, Optional<TextStyleI> headerHeadlineStyle, Optional<TextStyleI> headerHelpStyle, Optional<TextStyleI> weekdayStyle, Optional<TextStyleI> dayStyle, Optional<ColorI> dayForegroundColor, Optional<ColorI> dayBackgroundColor, Optional<ColorI> dayOverlayColor, Optional<OutlinedBorderI> dayShape, Optional<ColorI> todayForegroundColor, Optional<ColorI> todayBackgroundColor, Optional<BorderSideI> todayBorder, Optional<TextStyleI> yearStyle, Optional<ColorI> yearForegroundColor, Optional<ColorI> yearBackgroundColor, Optional<ColorI> yearOverlayColor, Optional<OutlinedBorderI> yearShape, Optional<ColorI> rangePickerBackgroundColor, OptionalDouble rangePickerElevation, Optional<ColorI> rangePickerShadowColor, Optional<ColorI> rangePickerSurfaceTintColor, Optional<ShapeBorderI> rangePickerShape, Optional<ColorI> rangePickerHeaderBackgroundColor, Optional<ColorI> rangePickerHeaderForegroundColor, Optional<TextStyleI> rangePickerHeaderHeadlineStyle, Optional<TextStyleI> rangePickerHeaderHelpStyle, Optional<ColorI> rangeSelectionBackgroundColor, Optional<ColorI> rangeSelectionOverlayColor, Optional<ColorI> dividerColor, Optional<NativeObj.I> inputDecorationTheme, Optional<TextStyleI> toggleButtonTextStyle, Optional<ColorI> subHeaderForegroundColor) {
    var st = factories.datePickerThemeDataDatePickerThemeData(backgroundColor.map(ColorI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget DatePickerThemeData");
    return new DatePickerThemeData(st);
  }
  public static DatePickerThemeDataDatePickerThemeDataBuilder datePickerThemeData() {
    return DatePickerThemeDataDatePickerThemeDataBuilder.datePickerThemeDataDatePickerThemeData();
  }
  public static DatePickerThemeData lerp(DatePickerThemeDataI a, DatePickerThemeDataI b, double t) {
    var st = factories.datePickerThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget DatePickerThemeData");
    return new DatePickerThemeData(st);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(DatePickerThemeDataObjSt.backgroundColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerThemeDataElevation not supported on web");
    return DatePickerThemeDataObjSt.elevation(st);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(DatePickerThemeDataObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(DatePickerThemeDataObjSt.surfaceTintColor(st));
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerThemeDataShape not supported on web");
    return new ShapeBorder(DatePickerThemeDataObjSt.shape(st)) {};
  }
  public Color headerBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataHeaderBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(DatePickerThemeDataObjSt.headerBackgroundColor(st));
  }
  public Color headerForegroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataHeaderForegroundColor", getId());
      return new Color(__nid);
    }
    return new Color(DatePickerThemeDataObjSt.headerForegroundColor(st));
  }
  public TextStyle headerHeadlineStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataHeaderHeadlineStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(DatePickerThemeDataObjSt.headerHeadlineStyle(st));
  }
  public TextStyle headerHelpStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataHeaderHelpStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(DatePickerThemeDataObjSt.headerHelpStyle(st));
  }
  public TextStyle weekdayStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataWeekdayStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(DatePickerThemeDataObjSt.weekdayStyle(st));
  }
  public TextStyle dayStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataDayStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(DatePickerThemeDataObjSt.dayStyle(st));
  }
  public BorderSide todayBorder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataTodayBorder", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderSideObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderSideObjSt.id(__st, __nid);
      return new BorderSide(__st);
    }
    return new BorderSide(DatePickerThemeDataObjSt.todayBorder(st));
  }
  public TextStyle yearStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataYearStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(DatePickerThemeDataObjSt.yearStyle(st));
  }
  public Color rangePickerBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataRangePickerBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(DatePickerThemeDataObjSt.rangePickerBackgroundColor(st));
  }
  public double rangePickerElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerThemeDataRangePickerElevation not supported on web");
    return DatePickerThemeDataObjSt.rangePickerElevation(st);
  }
  public Color rangePickerShadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataRangePickerShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(DatePickerThemeDataObjSt.rangePickerShadowColor(st));
  }
  public Color rangePickerSurfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataRangePickerSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(DatePickerThemeDataObjSt.rangePickerSurfaceTintColor(st));
  }
  public ShapeBorder rangePickerShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerThemeDataRangePickerShape not supported on web");
    return new ShapeBorder(DatePickerThemeDataObjSt.rangePickerShape(st)) {};
  }
  public Color rangePickerHeaderBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataRangePickerHeaderBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(DatePickerThemeDataObjSt.rangePickerHeaderBackgroundColor(st));
  }
  public Color rangePickerHeaderForegroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataRangePickerHeaderForegroundColor", getId());
      return new Color(__nid);
    }
    return new Color(DatePickerThemeDataObjSt.rangePickerHeaderForegroundColor(st));
  }
  public TextStyle rangePickerHeaderHeadlineStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataRangePickerHeaderHeadlineStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(DatePickerThemeDataObjSt.rangePickerHeaderHeadlineStyle(st));
  }
  public TextStyle rangePickerHeaderHelpStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataRangePickerHeaderHelpStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(DatePickerThemeDataObjSt.rangePickerHeaderHelpStyle(st));
  }
  public Color rangeSelectionBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataRangeSelectionBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(DatePickerThemeDataObjSt.rangeSelectionBackgroundColor(st));
  }
  public Color dividerColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataDividerColor", getId());
      return new Color(__nid);
    }
    return new Color(DatePickerThemeDataObjSt.dividerColor(st));
  }
  public TextStyle toggleButtonTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataToggleButtonTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(DatePickerThemeDataObjSt.toggleButtonTextStyle(st));
  }
  public Color subHeaderForegroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerThemeDataSubHeaderForegroundColor", getId());
      return new Color(__nid);
    }
    return new Color(DatePickerThemeDataObjSt.subHeaderForegroundColor(st));
  }
  @Override
  public DatePickerThemeData build() {
    return this;
  }
}
