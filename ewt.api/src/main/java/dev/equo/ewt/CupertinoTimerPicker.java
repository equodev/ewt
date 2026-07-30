package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoTimerPickerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoTimerPicker extends StatefulWidget implements CupertinoTimerPickerI {
  private MemorySegment st;
  protected CupertinoTimerPicker() {}
  CupertinoTimerPicker(MemorySegment st) {
    this.id = CupertinoTimerPickerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoTimerPicker");
    System.out.println("New CupertinoTimerPicker id:"+id);
  }
  CupertinoTimerPicker(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoTimerPicker cupertinoTimerPickerCupertinoTimerPicker(Optional<CupertinoTimerPickerMode> mode, Optional<DurationI> initialTimerDuration, OptionalInt minuteInterval, OptionalInt secondInterval, Optional<AlignmentGeometryI> alignment, Optional<ColorI> backgroundColor, OptionalDouble itemExtent, Consumer<Duration> onTimerDurationChanged, Optional<ChangeReportingBehavior> changeReportingBehavior, Optional<TriFunction<BuildContext, Integer, Integer, Widget>> selectionOverlayBuilder) {
    var st = factories.cupertinoTimerPickerCupertinoTimerPicker(mode,
      initialTimerDuration.map(DurationI::build),
      minuteInterval,
      secondInterval,
      alignment.map(AlignmentGeometryI::build),
      backgroundColor.map(ColorI::build),
      itemExtent,
      onTimerDurationChanged,
      changeReportingBehavior,
      selectionOverlayBuilder);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoTimerPicker");
    return new CupertinoTimerPicker(st);
  }
  public static CupertinoTimerPickerCupertinoTimerPickerBuilder cupertinoTimerPicker() {
    return CupertinoTimerPickerCupertinoTimerPickerBuilder.cupertinoTimerPickerCupertinoTimerPicker();
  }
  public CupertinoTimerPickerMode mode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTimerPickerMode not supported on web");
    return CupertinoTimerPickerMode.values()[CupertinoTimerPickerObjSt.mode(st)];
  }
  public Duration initialTimerDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTimerPickerInitialTimerDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(CupertinoTimerPickerObjSt.initialTimerDuration(st));
  }
  public int minuteInterval() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTimerPickerMinuteInterval not supported on web");
    return CupertinoTimerPickerObjSt.minuteInterval(st);
  }
  public int secondInterval() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTimerPickerSecondInterval not supported on web");
    return CupertinoTimerPickerObjSt.secondInterval(st);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTimerPickerAlignment not supported on web");
    return new AlignmentGeometry(CupertinoTimerPickerObjSt.alignment(st)) {};
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTimerPickerBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoTimerPickerObjSt.backgroundColor(st));
  }
  public double itemExtent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTimerPickerItemExtent not supported on web");
    return CupertinoTimerPickerObjSt.itemExtent(st);
  }
  public ChangeReportingBehavior changeReportingBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTimerPickerChangeReportingBehavior not supported on web");
    return ChangeReportingBehavior.values()[CupertinoTimerPickerObjSt.changeReportingBehavior(st)];
  }
  @Override
  public CupertinoTimerPicker build() {
    return this;
  }
}
