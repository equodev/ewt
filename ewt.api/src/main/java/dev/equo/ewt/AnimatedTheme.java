package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AnimatedThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AnimatedTheme extends ImplicitlyAnimatedWidget implements AnimatedThemeI {
  private MemorySegment st;
  protected AnimatedTheme() {}
  AnimatedTheme(MemorySegment st) {
    this.id = AnimatedThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedTheme");
    System.out.println("New AnimatedTheme id:"+id);
  }
  AnimatedTheme(int id) { this.id = id; }
  @Builder.Factory
  static AnimatedTheme animatedThemeAnimatedTheme(@Builder.Parameter ThemeDataI data, Optional<CurveI> curve, Optional<DurationI> duration, Optional<Runnable> onEnd, WidgetI child) {
    var st = factories.animatedThemeAnimatedTheme(data.build(),
      curve.map(CurveI::build),
      duration.map(DurationI::build),
      onEnd,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget AnimatedTheme");
    return new AnimatedTheme(st);
  }
  public static AnimatedThemeAnimatedThemeBuilder animatedTheme(ThemeDataI data) {
    return AnimatedThemeAnimatedThemeBuilder.animatedThemeAnimatedTheme(data);
  }
  public ThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.ThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.ThemeDataObjSt.id(__st, __nid);
      return new ThemeData(__st);
    }
    return new ThemeData(AnimatedThemeObjSt.data(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedThemeChild not supported on web");
    return new Widget(AnimatedThemeObjSt.child(st)) {};
  }
  @Override
  public AnimatedTheme build() {
    return this;
  }
}
