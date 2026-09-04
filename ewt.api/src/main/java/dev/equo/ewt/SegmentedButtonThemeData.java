package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SegmentedButtonThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SegmentedButtonThemeData extends NativeObj.Base implements SegmentedButtonThemeDataI {
  private MemorySegment st;
  protected SegmentedButtonThemeData() {}
  SegmentedButtonThemeData(MemorySegment st) {
    this.id = SegmentedButtonThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SegmentedButtonThemeData");
    System.out.println("New SegmentedButtonThemeData id:"+id);
  }
  SegmentedButtonThemeData(int id) { this.id = id; }
  @Builder.Factory
  static SegmentedButtonThemeData segmentedButtonThemeDataSegmentedButtonThemeData(Optional<WidgetI> selectedIcon) {
    var st = factories.segmentedButtonThemeDataSegmentedButtonThemeData(selectedIcon.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget SegmentedButtonThemeData");
    return new SegmentedButtonThemeData(st);
  }
  public static SegmentedButtonThemeDataSegmentedButtonThemeDataBuilder segmentedButtonThemeData() {
    return SegmentedButtonThemeDataSegmentedButtonThemeDataBuilder.segmentedButtonThemeDataSegmentedButtonThemeData();
  }
  public static SegmentedButtonThemeData lerp(SegmentedButtonThemeDataI a, SegmentedButtonThemeDataI b, double t) {
    var st = factories.segmentedButtonThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget SegmentedButtonThemeData");
    return new SegmentedButtonThemeData(st);
  }
  public Widget selectedIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("segmentedButtonThemeDataSelectedIcon not supported on web");
    return new Widget(SegmentedButtonThemeDataObjSt.selectedIcon(st)) {};
  }
  @Override
  public SegmentedButtonThemeData build() {
    return this;
  }
}
