package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SegmentedButtonThemeData extends NativeObj.Base implements SegmentedButtonThemeDataI {
  protected SegmentedButtonThemeData() {}
  SegmentedButtonThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SegmentedButtonThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SegmentedButtonThemeData segmentedButtonThemeDataSegmentedButtonThemeData(Optional<WidgetI> selectedIcon) {
    int id = factories.segmentedButtonThemeDataSegmentedButtonThemeData(selectedIcon.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SegmentedButtonThemeData");
    return new SegmentedButtonThemeData(id);
  }
  public static SegmentedButtonThemeDataSegmentedButtonThemeDataBuilder segmentedButtonThemeData() {
    return SegmentedButtonThemeDataSegmentedButtonThemeDataBuilder.segmentedButtonThemeDataSegmentedButtonThemeData();
  }
  public static SegmentedButtonThemeData lerp(SegmentedButtonThemeDataI a, SegmentedButtonThemeDataI b, double t) {
    int id = factories.segmentedButtonThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget SegmentedButtonThemeData");
    return new SegmentedButtonThemeData(id);
  }
  public Widget selectedIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("segmentedButtonThemeDataSelectedIcon not supported on web");
    return factories.SegmentedButtonThemeData_readBack_selectedIcon(nativeStruct);
  }
  @Override
  public SegmentedButtonThemeData build() {
    return this;
  }
}
