package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DateRangePickerDialogObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DateRangePickerDialog extends StatefulWidget implements DateRangePickerDialogI {
  private MemorySegment st;
  protected DateRangePickerDialog() {}
  DateRangePickerDialog(MemorySegment st) {
    this.id = DateRangePickerDialogObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DateRangePickerDialog");
    System.out.println("New DateRangePickerDialog id:"+id);
  }
  DateRangePickerDialog(int id) { this.id = id; }
  @Builder.Factory
  static DateRangePickerDialog dateRangePickerDialogDateRangePickerDialog(@Builder.Parameter DateTimeI firstDate, @Builder.Parameter DateTimeI lastDate, Optional<DateTimeI> currentDate, Optional<DatePickerEntryMode> initialEntryMode, Optional<String> helpText, Optional<String> cancelText, Optional<String> confirmText, Optional<String> saveText, Optional<String> errorInvalidRangeText, Optional<String> errorFormatText, Optional<String> errorInvalidText, Optional<String> fieldStartHintText, Optional<String> fieldEndHintText, Optional<String> fieldStartLabelText, Optional<String> fieldEndLabelText, Optional<String> restorationId, Optional<IconI> switchToInputEntryModeIcon, Optional<IconI> switchToCalendarEntryModeIcon, Optional<TriFunction<DateTime, DateTime, DateTime, Boolean>> selectableDayPredicate) {
    var st = factories.dateRangePickerDialogDateRangePickerDialog(firstDate.build(),
      lastDate.build(),
      currentDate.map(DateTimeI::build),
      initialEntryMode,
      helpText,
      cancelText,
      confirmText,
      saveText,
      errorInvalidRangeText,
      errorFormatText,
      errorInvalidText,
      fieldStartHintText,
      fieldEndHintText,
      fieldStartLabelText,
      fieldEndLabelText,
      restorationId,
      switchToInputEntryModeIcon.map(IconI::build),
      switchToCalendarEntryModeIcon.map(IconI::build),
      selectableDayPredicate);
    if (st == null) throw new RuntimeException("Failed to created widget DateRangePickerDialog");
    return new DateRangePickerDialog(st);
  }
  public static DateRangePickerDialogDateRangePickerDialogBuilder dateRangePickerDialog(DateTimeI firstDate, DateTimeI lastDate) {
    return DateRangePickerDialogDateRangePickerDialogBuilder.dateRangePickerDialogDateRangePickerDialog(firstDate, lastDate);
  }
  public DateTime firstDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dateRangePickerDialogFirstDate", getId());
      return new DateTime(__nid);
    }
    return new DateTime(DateRangePickerDialogObjSt.firstDate(st));
  }
  public DateTime lastDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dateRangePickerDialogLastDate", getId());
      return new DateTime(__nid);
    }
    return new DateTime(DateRangePickerDialogObjSt.lastDate(st));
  }
  public DateTime currentDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dateRangePickerDialogCurrentDate", getId());
      return new DateTime(__nid);
    }
    return new DateTime(DateRangePickerDialogObjSt.currentDate(st));
  }
  public DatePickerEntryMode initialEntryMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogInitialEntryMode not supported on web");
    return DatePickerEntryMode.values()[DateRangePickerDialogObjSt.initialEntryMode(st)];
  }
  public String cancelText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogCancelText not supported on web");
    return DateRangePickerDialogObjSt.cancelText(st).getString(0);
  }
  public String confirmText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogConfirmText not supported on web");
    return DateRangePickerDialogObjSt.confirmText(st).getString(0);
  }
  public String saveText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogSaveText not supported on web");
    return DateRangePickerDialogObjSt.saveText(st).getString(0);
  }
  public String helpText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogHelpText not supported on web");
    return DateRangePickerDialogObjSt.helpText(st).getString(0);
  }
  public String errorInvalidRangeText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogErrorInvalidRangeText not supported on web");
    return DateRangePickerDialogObjSt.errorInvalidRangeText(st).getString(0);
  }
  public String errorFormatText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogErrorFormatText not supported on web");
    return DateRangePickerDialogObjSt.errorFormatText(st).getString(0);
  }
  public String errorInvalidText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogErrorInvalidText not supported on web");
    return DateRangePickerDialogObjSt.errorInvalidText(st).getString(0);
  }
  public String fieldStartHintText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogFieldStartHintText not supported on web");
    return DateRangePickerDialogObjSt.fieldStartHintText(st).getString(0);
  }
  public String fieldEndHintText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogFieldEndHintText not supported on web");
    return DateRangePickerDialogObjSt.fieldEndHintText(st).getString(0);
  }
  public String fieldStartLabelText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogFieldStartLabelText not supported on web");
    return DateRangePickerDialogObjSt.fieldStartLabelText(st).getString(0);
  }
  public String fieldEndLabelText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogFieldEndLabelText not supported on web");
    return DateRangePickerDialogObjSt.fieldEndLabelText(st).getString(0);
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogRestorationId not supported on web");
    return DateRangePickerDialogObjSt.restorationId(st).getString(0);
  }
  public Icon switchToInputEntryModeIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dateRangePickerDialogSwitchToInputEntryModeIcon", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconObjSt.id(__st, __nid);
      return new Icon(__st);
    }
    return new Icon(DateRangePickerDialogObjSt.switchToInputEntryModeIcon(st));
  }
  public Icon switchToCalendarEntryModeIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dateRangePickerDialogSwitchToCalendarEntryModeIcon", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconObjSt.id(__st, __nid);
      return new Icon(__st);
    }
    return new Icon(DateRangePickerDialogObjSt.switchToCalendarEntryModeIcon(st));
  }
  @Override
  public DateRangePickerDialog build() {
    return this;
  }
}
