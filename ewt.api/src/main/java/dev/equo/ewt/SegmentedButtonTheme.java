package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SegmentedButtonThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SegmentedButtonTheme extends InheritedTheme implements SegmentedButtonThemeI {
  private MemorySegment st;
  protected SegmentedButtonTheme() {}
  SegmentedButtonTheme(MemorySegment st) {
    this.id = SegmentedButtonThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SegmentedButtonTheme");
    System.out.println("New SegmentedButtonTheme id:"+id);
  }
  SegmentedButtonTheme(int id) { this.id = id; }
  @Builder.Factory
  static SegmentedButtonTheme segmentedButtonThemeSegmentedButtonTheme(@Builder.Parameter SegmentedButtonThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.segmentedButtonThemeSegmentedButtonTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget SegmentedButtonTheme");
    return new SegmentedButtonTheme(st);
  }
  public static SegmentedButtonThemeSegmentedButtonThemeBuilder segmentedButtonTheme(SegmentedButtonThemeDataI data, WidgetI child) {
    return SegmentedButtonThemeSegmentedButtonThemeBuilder.segmentedButtonThemeSegmentedButtonTheme(data, child);
  }
  public static SegmentedButtonThemeData of(BuildContextI context) {
    var st = factories.segmentedButtonThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget SegmentedButtonThemeData");
    return new SegmentedButtonThemeData(st);
  }
  public static SegmentedButtonThemeData maybeOf(BuildContextI context) {
    var st = factories.segmentedButtonThemeMaybeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget SegmentedButtonThemeData");
    return new SegmentedButtonThemeData(st);
  }
  public SegmentedButtonThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("segmentedButtonThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.SegmentedButtonThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.SegmentedButtonThemeDataObjSt.id(__st, __nid);
      return new SegmentedButtonThemeData(__st);
    }
    return new SegmentedButtonThemeData(SegmentedButtonThemeObjSt.data(st));
  }
  @Override
  public SegmentedButtonTheme build() {
    return this;
  }
}
