package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class YearPicker extends StatefulWidget implements YearPickerI {
  protected YearPicker() {}
  YearPicker(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget YearPicker");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static YearPicker yearPickerYearPicker(Optional<DateTimeI> currentDate, DateTimeI firstDate, DateTimeI lastDate, Optional<DateTimeI> initialDate, Optional<DateTimeI> selectedDate, Consumer<DateTime> onChanged, Optional<DragStartBehavior> dragStartBehavior) {
    int id = factories.yearPickerYearPicker(currentDate.map(DateTimeI::build),
      firstDate.build(),
      lastDate.build(),
      initialDate.map(DateTimeI::build),
      selectedDate.map(DateTimeI::build),
      onChanged,
      dragStartBehavior);
    if (id <= 0) throw new RuntimeException("Failed to created widget YearPicker");
    return new YearPicker(id);
  }
  public static YearPickerYearPickerBuilder yearPicker() {
    return YearPickerYearPickerBuilder.yearPickerYearPicker();
  }
  public DateTime currentDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("yearPickerCurrentDate", getId());
      return new DateTime(__nid);
    }
    return factories.YearPicker_readBack_currentDate(nativeStruct);
  }
  public DateTime firstDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("yearPickerFirstDate", getId());
      return new DateTime(__nid);
    }
    return factories.YearPicker_readBack_firstDate(nativeStruct);
  }
  public DateTime lastDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("yearPickerLastDate", getId());
      return new DateTime(__nid);
    }
    return factories.YearPicker_readBack_lastDate(nativeStruct);
  }
  public DateTime selectedDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("yearPickerSelectedDate", getId());
      return new DateTime(__nid);
    }
    return factories.YearPicker_readBack_selectedDate(nativeStruct);
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("yearPickerDragStartBehavior not supported on web");
    return factories.YearPicker_readBack_dragStartBehavior(nativeStruct);
  }
  @Override
  public YearPicker build() {
    return this;
  }
}
