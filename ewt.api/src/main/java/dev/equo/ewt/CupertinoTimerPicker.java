package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoTimerPicker extends StatefulWidget implements CupertinoTimerPickerI {
  protected CupertinoTimerPicker() {}
  CupertinoTimerPicker(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoTimerPicker");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoTimerPicker cupertinoTimerPickerCupertinoTimerPicker(Optional<CupertinoTimerPickerMode> mode, Optional<DurationI> initialTimerDuration, OptionalInt minuteInterval, OptionalInt secondInterval, Optional<AlignmentGeometryI> alignment, Optional<ColorI> backgroundColor, OptionalDouble itemExtent, Consumer<Duration> onTimerDurationChanged, Optional<ChangeReportingBehavior> changeReportingBehavior, Optional<TriFunction<BuildContext, Integer, Integer, Widget>> selectionOverlayBuilder) {
    int id = factories.cupertinoTimerPickerCupertinoTimerPicker(mode,
      initialTimerDuration.map(DurationI::build),
      minuteInterval,
      secondInterval,
      alignment.map(AlignmentGeometryI::build),
      backgroundColor.map(ColorI::build),
      itemExtent,
      onTimerDurationChanged,
      changeReportingBehavior,
      selectionOverlayBuilder);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoTimerPicker");
    return new CupertinoTimerPicker(id);
  }
  public static CupertinoTimerPickerCupertinoTimerPickerBuilder cupertinoTimerPicker() {
    return CupertinoTimerPickerCupertinoTimerPickerBuilder.cupertinoTimerPickerCupertinoTimerPicker();
  }
  public CupertinoTimerPickerMode mode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTimerPickerMode not supported on web");
    return factories.CupertinoTimerPicker_readBack_mode(nativeStruct);
  }
  public Duration initialTimerDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTimerPickerInitialTimerDuration", getId());
      return new Duration(__nid);
    }
    return factories.CupertinoTimerPicker_readBack_initialTimerDuration(nativeStruct);
  }
  public int minuteInterval() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTimerPickerMinuteInterval not supported on web");
    return factories.CupertinoTimerPicker_readBack_minuteInterval(nativeStruct);
  }
  public int secondInterval() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTimerPickerSecondInterval not supported on web");
    return factories.CupertinoTimerPicker_readBack_secondInterval(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTimerPickerAlignment not supported on web");
    return factories.CupertinoTimerPicker_readBack_alignment(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTimerPickerBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoTimerPicker_readBack_backgroundColor(nativeStruct);
  }
  public double itemExtent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTimerPickerItemExtent not supported on web");
    return factories.CupertinoTimerPicker_readBack_itemExtent(nativeStruct);
  }
  public ChangeReportingBehavior changeReportingBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTimerPickerChangeReportingBehavior not supported on web");
    return factories.CupertinoTimerPicker_readBack_changeReportingBehavior(nativeStruct);
  }
  @Override
  public CupertinoTimerPicker build() {
    return this;
  }
}
