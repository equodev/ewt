package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DatePickerDialog extends StatefulWidget implements DatePickerDialogI {
  protected DatePickerDialog() {}
  DatePickerDialog(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DatePickerDialog");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DatePickerDialog datePickerDialogDatePickerDialog(Optional<DateTimeI> initialDate, DateTimeI firstDate, DateTimeI lastDate, Optional<DateTimeI> currentDate, Optional<DatePickerEntryMode> initialEntryMode, Optional<Function<DateTime, Boolean>> selectableDayPredicate, Optional<String> cancelText, Optional<String> confirmText, Optional<String> helpText, Optional<DatePickerMode> initialCalendarMode, Optional<String> errorFormatText, Optional<String> errorInvalidText, Optional<String> fieldHintText, Optional<String> fieldLabelText, Optional<String> restorationId, Optional<Consumer<DatePickerEntryMode>> onDatePickerModeChange, Optional<IconI> switchToInputEntryModeIcon, Optional<IconI> switchToCalendarEntryModeIcon, Optional<EdgeInsetsI> insetPadding) {
    int id = factories.datePickerDialogDatePickerDialog(initialDate.map(DateTimeI::build),
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
    if (id <= 0) throw new RuntimeException("Failed to created widget DatePickerDialog");
    return new DatePickerDialog(id);
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
    return factories.DatePickerDialog_readBack_initialDate(nativeStruct);
  }
  public DateTime firstDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerDialogFirstDate", getId());
      return new DateTime(__nid);
    }
    return factories.DatePickerDialog_readBack_firstDate(nativeStruct);
  }
  public DateTime lastDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerDialogLastDate", getId());
      return new DateTime(__nid);
    }
    return factories.DatePickerDialog_readBack_lastDate(nativeStruct);
  }
  public DateTime currentDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerDialogCurrentDate", getId());
      return new DateTime(__nid);
    }
    return factories.DatePickerDialog_readBack_currentDate(nativeStruct);
  }
  public DatePickerEntryMode initialEntryMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerDialogInitialEntryMode not supported on web");
    return factories.DatePickerDialog_readBack_initialEntryMode(nativeStruct);
  }
  public String cancelText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerDialogCancelText not supported on web");
    return factories.DatePickerDialog_readBack_cancelText(nativeStruct);
  }
  public String confirmText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerDialogConfirmText not supported on web");
    return factories.DatePickerDialog_readBack_confirmText(nativeStruct);
  }
  public String helpText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerDialogHelpText not supported on web");
    return factories.DatePickerDialog_readBack_helpText(nativeStruct);
  }
  public DatePickerMode initialCalendarMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerDialogInitialCalendarMode not supported on web");
    return factories.DatePickerDialog_readBack_initialCalendarMode(nativeStruct);
  }
  public String errorFormatText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerDialogErrorFormatText not supported on web");
    return factories.DatePickerDialog_readBack_errorFormatText(nativeStruct);
  }
  public String errorInvalidText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerDialogErrorInvalidText not supported on web");
    return factories.DatePickerDialog_readBack_errorInvalidText(nativeStruct);
  }
  public String fieldHintText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerDialogFieldHintText not supported on web");
    return factories.DatePickerDialog_readBack_fieldHintText(nativeStruct);
  }
  public String fieldLabelText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerDialogFieldLabelText not supported on web");
    return factories.DatePickerDialog_readBack_fieldLabelText(nativeStruct);
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("datePickerDialogRestorationId not supported on web");
    return factories.DatePickerDialog_readBack_restorationId(nativeStruct);
  }
  public Icon switchToInputEntryModeIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerDialogSwitchToInputEntryModeIcon", getId());
      return new Icon(__nid);
    }
    return factories.DatePickerDialog_readBack_switchToInputEntryModeIcon(nativeStruct);
  }
  public Icon switchToCalendarEntryModeIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerDialogSwitchToCalendarEntryModeIcon", getId());
      return new Icon(__nid);
    }
    return factories.DatePickerDialog_readBack_switchToCalendarEntryModeIcon(nativeStruct);
  }
  public EdgeInsets insetPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("datePickerDialogInsetPadding", getId());
      return new EdgeInsets(__nid);
    }
    return factories.DatePickerDialog_readBack_insetPadding(nativeStruct);
  }
  @Override
  public DatePickerDialog build() {
    return this;
  }
}
