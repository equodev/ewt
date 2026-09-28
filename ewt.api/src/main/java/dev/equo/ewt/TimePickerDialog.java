package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TimePickerDialog extends StatefulWidget implements TimePickerDialogI {
  protected TimePickerDialog() {}
  TimePickerDialog(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TimePickerDialog");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TimePickerDialog timePickerDialogTimePickerDialog(@Builder.Parameter TimeOfDayI initialTime, Optional<String> cancelText, Optional<String> confirmText, Optional<String> helpText, Optional<String> errorInvalidText, Optional<String> hourLabelText, Optional<String> minuteLabelText, Optional<String> restorationId, Optional<TimePickerEntryMode> initialEntryMode, Optional<Orientation> orientation, Optional<Consumer<TimePickerEntryMode>> onEntryModeChanged, Optional<IconI> switchToInputEntryModeIcon, Optional<IconI> switchToTimerEntryModeIcon, Optional<Boolean> emptyInitialInput) {
    int id = factories.timePickerDialogTimePickerDialog(initialTime.build(),
      cancelText,
      confirmText,
      helpText,
      errorInvalidText,
      hourLabelText,
      minuteLabelText,
      restorationId,
      initialEntryMode,
      orientation,
      onEntryModeChanged,
      switchToInputEntryModeIcon.map(IconI::build),
      switchToTimerEntryModeIcon.map(IconI::build),
      emptyInitialInput);
    if (id <= 0) throw new RuntimeException("Failed to created widget TimePickerDialog");
    return new TimePickerDialog(id);
  }
  public static TimePickerDialogTimePickerDialogBuilder timePickerDialog(TimeOfDayI initialTime) {
    return TimePickerDialogTimePickerDialogBuilder.timePickerDialogTimePickerDialog(initialTime);
  }
  public TimeOfDay initialTime() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerDialogInitialTime", getId());
      return new TimeOfDay(__nid);
    }
    return factories.TimePickerDialog_readBack_initialTime(nativeStruct);
  }
  public String cancelText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerDialogCancelText not supported on web");
    return factories.TimePickerDialog_readBack_cancelText(nativeStruct);
  }
  public String confirmText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerDialogConfirmText not supported on web");
    return factories.TimePickerDialog_readBack_confirmText(nativeStruct);
  }
  public String helpText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerDialogHelpText not supported on web");
    return factories.TimePickerDialog_readBack_helpText(nativeStruct);
  }
  public String errorInvalidText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerDialogErrorInvalidText not supported on web");
    return factories.TimePickerDialog_readBack_errorInvalidText(nativeStruct);
  }
  public String hourLabelText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerDialogHourLabelText not supported on web");
    return factories.TimePickerDialog_readBack_hourLabelText(nativeStruct);
  }
  public String minuteLabelText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerDialogMinuteLabelText not supported on web");
    return factories.TimePickerDialog_readBack_minuteLabelText(nativeStruct);
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerDialogRestorationId not supported on web");
    return factories.TimePickerDialog_readBack_restorationId(nativeStruct);
  }
  public TimePickerEntryMode initialEntryMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerDialogInitialEntryMode not supported on web");
    return factories.TimePickerDialog_readBack_initialEntryMode(nativeStruct);
  }
  public Orientation orientation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerDialogOrientation not supported on web");
    return factories.TimePickerDialog_readBack_orientation(nativeStruct);
  }
  public Icon switchToInputEntryModeIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerDialogSwitchToInputEntryModeIcon", getId());
      return new Icon(__nid);
    }
    return factories.TimePickerDialog_readBack_switchToInputEntryModeIcon(nativeStruct);
  }
  public Icon switchToTimerEntryModeIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerDialogSwitchToTimerEntryModeIcon", getId());
      return new Icon(__nid);
    }
    return factories.TimePickerDialog_readBack_switchToTimerEntryModeIcon(nativeStruct);
  }
  public boolean emptyInitialInput() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerDialogEmptyInitialInput not supported on web");
    return factories.TimePickerDialog_readBack_emptyInitialInput(nativeStruct);
  }
  @Override
  public TimePickerDialog build() {
    return this;
  }
}
