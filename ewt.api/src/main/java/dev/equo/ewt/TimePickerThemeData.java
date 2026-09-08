package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TimePickerThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TimePickerThemeData extends NativeObj.Base implements TimePickerThemeDataI {
  private MemorySegment st;
  protected TimePickerThemeData() {}
  TimePickerThemeData(MemorySegment st) {
    this.id = TimePickerThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TimePickerThemeData");
    System.out.println("New TimePickerThemeData id:"+id);
  }
  TimePickerThemeData(int id) { this.id = id; }
  @Builder.Factory
  static TimePickerThemeData timePickerThemeDataTimePickerThemeData(Optional<ColorI> backgroundColor, Optional<BorderSideI> dayPeriodBorderSide, Optional<ColorI> dayPeriodColor, Optional<OutlinedBorderI> dayPeriodShape, Optional<ColorI> dayPeriodTextColor, Optional<TextStyleI> dayPeriodTextStyle, Optional<ColorI> dialBackgroundColor, Optional<ColorI> dialHandColor, Optional<ColorI> dialTextColor, Optional<TextStyleI> dialTextStyle, OptionalDouble elevation, Optional<ColorI> entryModeIconColor, Optional<TextStyleI> helpTextStyle, Optional<ColorI> hourMinuteColor, Optional<ShapeBorderI> hourMinuteShape, Optional<ColorI> hourMinuteTextColor, Optional<TextStyleI> hourMinuteTextStyle, Optional<NativeObj.I> inputDecorationTheme, Optional<EdgeInsetsGeometryI> padding, Optional<ShapeBorderI> shape, Optional<ColorI> timeSelectorSeparatorColor, Optional<TextStyleI> timeSelectorSeparatorTextStyle) {
    var st = factories.timePickerThemeDataTimePickerThemeData(backgroundColor.map(ColorI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget TimePickerThemeData");
    return new TimePickerThemeData(st);
  }
  public static TimePickerThemeDataTimePickerThemeDataBuilder timePickerThemeData() {
    return TimePickerThemeDataTimePickerThemeDataBuilder.timePickerThemeDataTimePickerThemeData();
  }
  public static TimePickerThemeData lerp(TimePickerThemeDataI a, TimePickerThemeDataI b, double t) {
    var st = factories.timePickerThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget TimePickerThemeData");
    return new TimePickerThemeData(st);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(TimePickerThemeDataObjSt.backgroundColor(st));
  }
  public BorderSide dayPeriodBorderSide() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataDayPeriodBorderSide", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderSideObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderSideObjSt.id(__st, __nid);
      return new BorderSide(__st);
    }
    return new BorderSide(TimePickerThemeDataObjSt.dayPeriodBorderSide(st));
  }
  public OutlinedBorder dayPeriodShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerThemeDataDayPeriodShape not supported on web");
    return new OutlinedBorder(TimePickerThemeDataObjSt.dayPeriodShape(st)) {};
  }
  public Color dayPeriodTextColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataDayPeriodTextColor", getId());
      return new Color(__nid);
    }
    return new Color(TimePickerThemeDataObjSt.dayPeriodTextColor(st));
  }
  public TextStyle dayPeriodTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataDayPeriodTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(TimePickerThemeDataObjSt.dayPeriodTextStyle(st));
  }
  public Color dialBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataDialBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(TimePickerThemeDataObjSt.dialBackgroundColor(st));
  }
  public Color dialHandColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataDialHandColor", getId());
      return new Color(__nid);
    }
    return new Color(TimePickerThemeDataObjSt.dialHandColor(st));
  }
  public Color dialTextColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataDialTextColor", getId());
      return new Color(__nid);
    }
    return new Color(TimePickerThemeDataObjSt.dialTextColor(st));
  }
  public TextStyle dialTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataDialTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(TimePickerThemeDataObjSt.dialTextStyle(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerThemeDataElevation not supported on web");
    return TimePickerThemeDataObjSt.elevation(st);
  }
  public Color entryModeIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataEntryModeIconColor", getId());
      return new Color(__nid);
    }
    return new Color(TimePickerThemeDataObjSt.entryModeIconColor(st));
  }
  public TextStyle helpTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataHelpTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(TimePickerThemeDataObjSt.helpTextStyle(st));
  }
  public Color hourMinuteColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataHourMinuteColor", getId());
      return new Color(__nid);
    }
    return new Color(TimePickerThemeDataObjSt.hourMinuteColor(st));
  }
  public ShapeBorder hourMinuteShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerThemeDataHourMinuteShape not supported on web");
    return new ShapeBorder(TimePickerThemeDataObjSt.hourMinuteShape(st)) {};
  }
  public Color hourMinuteTextColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataHourMinuteTextColor", getId());
      return new Color(__nid);
    }
    return new Color(TimePickerThemeDataObjSt.hourMinuteTextColor(st));
  }
  public TextStyle hourMinuteTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataHourMinuteTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(TimePickerThemeDataObjSt.hourMinuteTextStyle(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerThemeDataPadding not supported on web");
    return new EdgeInsetsGeometry(TimePickerThemeDataObjSt.padding(st)) {};
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerThemeDataShape not supported on web");
    return new ShapeBorder(TimePickerThemeDataObjSt.shape(st)) {};
  }
  public Color dayPeriodColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerThemeDataDayPeriodColor", getId());
      return new Color(__nid);
    }
    return new Color(TimePickerThemeDataObjSt.dayPeriodColor(st));
  }
  @Override
  public TimePickerThemeData build() {
    return this;
  }
}
