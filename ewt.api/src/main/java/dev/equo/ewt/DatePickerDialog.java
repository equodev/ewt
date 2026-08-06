package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DatePickerDialogObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DatePickerDialog extends StatefulWidget implements DatePickerDialogI {
  private MemorySegment st;
  protected DatePickerDialog() {}
  DatePickerDialog(MemorySegment st) {
    this.id = DatePickerDialogObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DatePickerDialog");
    System.out.println("New DatePickerDialog id:"+id);
  }
  DatePickerDialog(int id) { this.id = id; }
  @Builder.Factory
  static DatePickerDialog datePickerDialogDatePickerDialog(Optional<DateTimeI> initialDate, DateTimeI firstDate, DateTimeI lastDate, Optional<DateTimeI> currentDate, Optional<DatePickerEntryMode> initialEntryMode, Optional<Function<DateTime, Boolean>> selectableDayPredicate, Optional<String> cancelText, Optional<String> confirmText, Optional<String> helpText, Optional<DatePickerMode> initialCalendarMode, Optional<String> errorFormatText, Optional<String> errorInvalidText, Optional<String> fieldHintText, Optional<String> fieldLabelText, Optional<String> restorationId, Optional<Consumer<DatePickerEntryMode>> onDatePickerModeChange, Optional<IconI> switchToInputEntryModeIcon, Optional<IconI> switchToCalendarEntryModeIcon, Optional<EdgeInsetsI> insetPadding) {
    var st = factories.datePickerDialogDatePickerDialog(initialDate.map(DateTimeI::build),
      firstDate.build(),
      lastDate.build(),
      currentDate.map(DateTimeI::build),
      initialEntryMode,
      selectableDayPredicate,
      cancelText,
      confirmText,
      helpText,
      initialCalendarMode,
      errorFormatText,
      errorInvalidText,
      fieldHintText,
      fieldLabelText,
      restorationId,
      onDatePickerModeChange,
      switchToInputEntryModeIcon.map(IconI::build),
      switchToCalendarEntryModeIcon.map(IconI::build),
      insetPadding.map(EdgeInsetsI::build));
    if (st == null) throw new RuntimeException("Failed to created widget DatePickerDialog");
    return new DatePickerDialog(st);
  }
  public static DatePickerDialogDatePickerDialogBuilder datePickerDialog() {
    return DatePickerDialogDatePickerDialogBuilder.datePickerDialogDatePickerDialog();
  }
  public DateTime initialDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerDialogInitialDate", getId());
      return new DateTime(__nid);
    }
    return new DateTime(DatePickerDialogObjSt.initialDate(st));
  }
  public DateTime firstDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerDialogFirstDate", getId());
      return new DateTime(__nid);
    }
    return new DateTime(DatePickerDialogObjSt.firstDate(st));
  }
  public DateTime lastDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerDialogLastDate", getId());
      return new DateTime(__nid);
    }
    return new DateTime(DatePickerDialogObjSt.lastDate(st));
  }
  public DateTime currentDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerDialogCurrentDate", getId());
      return new DateTime(__nid);
    }
    return new DateTime(DatePickerDialogObjSt.currentDate(st));
  }
  public DatePickerEntryMode initialEntryMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerDialogInitialEntryMode not supported on web");
    return DatePickerEntryMode.values()[DatePickerDialogObjSt.initialEntryMode(st)];
  }
  public String cancelText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerDialogCancelText not supported on web");
    return DatePickerDialogObjSt.cancelText(st).getString(0);
  }
  public String confirmText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerDialogConfirmText not supported on web");
    return DatePickerDialogObjSt.confirmText(st).getString(0);
  }
  public String helpText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerDialogHelpText not supported on web");
    return DatePickerDialogObjSt.helpText(st).getString(0);
  }
  public DatePickerMode initialCalendarMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerDialogInitialCalendarMode not supported on web");
    return DatePickerMode.values()[DatePickerDialogObjSt.initialCalendarMode(st)];
  }
  public String errorFormatText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerDialogErrorFormatText not supported on web");
    return DatePickerDialogObjSt.errorFormatText(st).getString(0);
  }
  public String errorInvalidText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerDialogErrorInvalidText not supported on web");
    return DatePickerDialogObjSt.errorInvalidText(st).getString(0);
  }
  public String fieldHintText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerDialogFieldHintText not supported on web");
    return DatePickerDialogObjSt.fieldHintText(st).getString(0);
  }
  public String fieldLabelText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerDialogFieldLabelText not supported on web");
    return DatePickerDialogObjSt.fieldLabelText(st).getString(0);
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerDialogRestorationId not supported on web");
    return DatePickerDialogObjSt.restorationId(st).getString(0);
  }
  public Icon switchToInputEntryModeIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerDialogSwitchToInputEntryModeIcon", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconObjSt.id(__st, __nid);
      return new Icon(__st);
    }
    return new Icon(DatePickerDialogObjSt.switchToInputEntryModeIcon(st));
  }
  public Icon switchToCalendarEntryModeIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerDialogSwitchToCalendarEntryModeIcon", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconObjSt.id(__st, __nid);
      return new Icon(__st);
    }
    return new Icon(DatePickerDialogObjSt.switchToCalendarEntryModeIcon(st));
  }
  public EdgeInsets insetPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerDialogInsetPadding", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.EdgeInsetsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.EdgeInsetsObjSt.id(__st, __nid);
      return new EdgeInsets(__st);
    }
    return new EdgeInsets(DatePickerDialogObjSt.insetPadding(st));
  }
  @Override
  public DatePickerDialog build() {
    return this;
  }
}
