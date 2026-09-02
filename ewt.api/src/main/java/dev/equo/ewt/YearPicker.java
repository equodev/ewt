package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.YearPickerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class YearPicker extends StatefulWidget implements YearPickerI {
  private MemorySegment st;
  protected YearPicker() {}
  YearPicker(MemorySegment st) {
    this.id = YearPickerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget YearPicker");
    System.out.println("New YearPicker id:"+id);
  }
  YearPicker(int id) { this.id = id; }
  @Builder.Factory
  static YearPicker yearPickerYearPicker(Optional<DateTimeI> currentDate, DateTimeI firstDate, DateTimeI lastDate, Optional<DateTimeI> initialDate, Optional<DateTimeI> selectedDate, Consumer<DateTime> onChanged, Optional<DragStartBehavior> dragStartBehavior) {
    var st = factories.yearPickerYearPicker(currentDate.map(DateTimeI::build),
      firstDate.build(),
      lastDate.build(),
      initialDate.map(DateTimeI::build),
      selectedDate.map(DateTimeI::build),
      onChanged,
      dragStartBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget YearPicker");
    return new YearPicker(st);
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
    return new DateTime(YearPickerObjSt.currentDate(st));
  }
  public DateTime firstDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("yearPickerFirstDate", getId());
      return new DateTime(__nid);
    }
    return new DateTime(YearPickerObjSt.firstDate(st));
  }
  public DateTime lastDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("yearPickerLastDate", getId());
      return new DateTime(__nid);
    }
    return new DateTime(YearPickerObjSt.lastDate(st));
  }
  public DateTime selectedDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("yearPickerSelectedDate", getId());
      return new DateTime(__nid);
    }
    return new DateTime(YearPickerObjSt.selectedDate(st));
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("yearPickerDragStartBehavior not supported on web");
    return DragStartBehavior.values()[YearPickerObjSt.dragStartBehavior(st)];
  }
  @Override
  public YearPicker build() {
    return this;
  }
}
