package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DateRangePickerDialog extends StatefulWidget implements DateRangePickerDialogI {
  protected DateRangePickerDialog() {}
  DateRangePickerDialog(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DateRangePickerDialog");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DateRangePickerDialog dateRangePickerDialogDateRangePickerDialog(@Builder.Parameter DateTimeI firstDate, @Builder.Parameter DateTimeI lastDate, Optional<DateTimeI> currentDate, Optional<DatePickerEntryMode> initialEntryMode, Optional<String> helpText, Optional<String> cancelText, Optional<String> confirmText, Optional<String> saveText, Optional<String> errorInvalidRangeText, Optional<String> errorFormatText, Optional<String> errorInvalidText, Optional<String> fieldStartHintText, Optional<String> fieldEndHintText, Optional<String> fieldStartLabelText, Optional<String> fieldEndLabelText, Optional<String> restorationId, Optional<IconI> switchToInputEntryModeIcon, Optional<IconI> switchToCalendarEntryModeIcon, Optional<TriFunction<DateTime, DateTime, DateTime, Boolean>> selectableDayPredicate) {
    int id = factories.dateRangePickerDialogDateRangePickerDialog(firstDate.build(),
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
    if (id <= 0) throw new RuntimeException("Failed to created widget DateRangePickerDialog");
    return new DateRangePickerDialog(id);
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
    return factories.DateRangePickerDialog_readBack_firstDate(nativeStruct);
  }
  public DateTime lastDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dateRangePickerDialogLastDate", getId());
      return new DateTime(__nid);
    }
    return factories.DateRangePickerDialog_readBack_lastDate(nativeStruct);
  }
  public DatePickerEntryMode initialEntryMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogInitialEntryMode not supported on web");
    return factories.DateRangePickerDialog_readBack_initialEntryMode(nativeStruct);
  }
  public String cancelText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogCancelText not supported on web");
    return factories.DateRangePickerDialog_readBack_cancelText(nativeStruct);
  }
  public String confirmText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogConfirmText not supported on web");
    return factories.DateRangePickerDialog_readBack_confirmText(nativeStruct);
  }
  public String saveText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogSaveText not supported on web");
    return factories.DateRangePickerDialog_readBack_saveText(nativeStruct);
  }
  public String helpText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogHelpText not supported on web");
    return factories.DateRangePickerDialog_readBack_helpText(nativeStruct);
  }
  public String errorInvalidRangeText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogErrorInvalidRangeText not supported on web");
    return factories.DateRangePickerDialog_readBack_errorInvalidRangeText(nativeStruct);
  }
  public String errorFormatText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogErrorFormatText not supported on web");
    return factories.DateRangePickerDialog_readBack_errorFormatText(nativeStruct);
  }
  public String errorInvalidText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogErrorInvalidText not supported on web");
    return factories.DateRangePickerDialog_readBack_errorInvalidText(nativeStruct);
  }
  public String fieldStartHintText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogFieldStartHintText not supported on web");
    return factories.DateRangePickerDialog_readBack_fieldStartHintText(nativeStruct);
  }
  public String fieldEndHintText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogFieldEndHintText not supported on web");
    return factories.DateRangePickerDialog_readBack_fieldEndHintText(nativeStruct);
  }
  public String fieldStartLabelText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogFieldStartLabelText not supported on web");
    return factories.DateRangePickerDialog_readBack_fieldStartLabelText(nativeStruct);
  }
  public String fieldEndLabelText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogFieldEndLabelText not supported on web");
    return factories.DateRangePickerDialog_readBack_fieldEndLabelText(nativeStruct);
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dateRangePickerDialogRestorationId not supported on web");
    return factories.DateRangePickerDialog_readBack_restorationId(nativeStruct);
  }
  public Icon switchToInputEntryModeIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dateRangePickerDialogSwitchToInputEntryModeIcon", getId());
      return new Icon(__nid);
    }
    return factories.DateRangePickerDialog_readBack_switchToInputEntryModeIcon(nativeStruct);
  }
  public Icon switchToCalendarEntryModeIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dateRangePickerDialogSwitchToCalendarEntryModeIcon", getId());
      return new Icon(__nid);
    }
    return factories.DateRangePickerDialog_readBack_switchToCalendarEntryModeIcon(nativeStruct);
  }
  public DateTime currentDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dateRangePickerDialogCurrentDate", getId());
      return new DateTime(__nid);
    }
    return factories.DateRangePickerDialog_readBack_currentDate(nativeStruct);
  }
  @Override
  public DateRangePickerDialog build() {
    return this;
  }
}
