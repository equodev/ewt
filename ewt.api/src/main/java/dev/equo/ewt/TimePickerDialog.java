package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TimePickerDialogObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TimePickerDialog extends StatefulWidget implements TimePickerDialogI {
  private MemorySegment st;
  protected TimePickerDialog() {}
  TimePickerDialog(MemorySegment st) {
    this.id = TimePickerDialogObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TimePickerDialog");
    System.out.println("New TimePickerDialog id:"+id);
  }
  TimePickerDialog(int id) { this.id = id; }
  @Builder.Factory
  static TimePickerDialog timePickerDialogTimePickerDialog(@Builder.Parameter TimeOfDayI initialTime, Optional<String> cancelText, Optional<String> confirmText, Optional<String> helpText, Optional<String> errorInvalidText, Optional<String> hourLabelText, Optional<String> minuteLabelText, Optional<String> restorationId, Optional<TimePickerEntryMode> initialEntryMode, Optional<Orientation> orientation, Optional<Consumer<TimePickerEntryMode>> onEntryModeChanged, Optional<IconI> switchToInputEntryModeIcon, Optional<IconI> switchToTimerEntryModeIcon) {
    var st = factories.timePickerDialogTimePickerDialog(initialTime.build(),
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
      switchToTimerEntryModeIcon.map(IconI::build));
    if (st == null) throw new RuntimeException("Failed to created widget TimePickerDialog");
    return new TimePickerDialog(st);
  }
  public static TimePickerDialogTimePickerDialogBuilder timePickerDialog(TimeOfDayI initialTime) {
    return TimePickerDialogTimePickerDialogBuilder.timePickerDialogTimePickerDialog(initialTime);
  }
  public TimeOfDay initialTime() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerDialogInitialTime", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TimeOfDayObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TimeOfDayObjSt.id(__st, __nid);
      return new TimeOfDay(__st);
    }
    return new TimeOfDay(TimePickerDialogObjSt.initialTime(st));
  }
  public String cancelText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerDialogCancelText not supported on web");
    return TimePickerDialogObjSt.cancelText(st).getString(0);
  }
  public String confirmText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerDialogConfirmText not supported on web");
    return TimePickerDialogObjSt.confirmText(st).getString(0);
  }
  public String helpText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerDialogHelpText not supported on web");
    return TimePickerDialogObjSt.helpText(st).getString(0);
  }
  public String errorInvalidText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerDialogErrorInvalidText not supported on web");
    return TimePickerDialogObjSt.errorInvalidText(st).getString(0);
  }
  public String hourLabelText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerDialogHourLabelText not supported on web");
    return TimePickerDialogObjSt.hourLabelText(st).getString(0);
  }
  public String minuteLabelText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerDialogMinuteLabelText not supported on web");
    return TimePickerDialogObjSt.minuteLabelText(st).getString(0);
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerDialogRestorationId not supported on web");
    return TimePickerDialogObjSt.restorationId(st).getString(0);
  }
  public TimePickerEntryMode initialEntryMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerDialogInitialEntryMode not supported on web");
    return TimePickerEntryMode.values()[TimePickerDialogObjSt.initialEntryMode(st)];
  }
  public Orientation orientation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("timePickerDialogOrientation not supported on web");
    return Orientation.values()[TimePickerDialogObjSt.orientation(st)];
  }
  public Icon switchToInputEntryModeIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerDialogSwitchToInputEntryModeIcon", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconObjSt.id(__st, __nid);
      return new Icon(__st);
    }
    return new Icon(TimePickerDialogObjSt.switchToInputEntryModeIcon(st));
  }
  public Icon switchToTimerEntryModeIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("timePickerDialogSwitchToTimerEntryModeIcon", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconObjSt.id(__st, __nid);
      return new Icon(__st);
    }
    return new Icon(TimePickerDialogObjSt.switchToTimerEntryModeIcon(st));
  }
  @Override
  public TimePickerDialog build() {
    return this;
  }
}
