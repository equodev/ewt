package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AnimatedTheme extends ImplicitlyAnimatedWidget implements AnimatedThemeI {
  protected AnimatedTheme() {}
  AnimatedTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AnimatedTheme animatedThemeAnimatedTheme(@Builder.Parameter ThemeDataI data, Optional<CurveI> curve, Optional<DurationI> duration, Optional<Runnable> onEnd, WidgetI child) {
    int id = factories.animatedThemeAnimatedTheme(data.build(),
      curve.map(CurveI::build),
      duration.map(DurationI::build),
      onEnd,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedTheme");
    return new AnimatedTheme(id);
  }
  public static AnimatedThemeAnimatedThemeBuilder animatedTheme(ThemeDataI data) {
    return AnimatedThemeAnimatedThemeBuilder.animatedThemeAnimatedTheme(data);
  }
  public ThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedThemeData", getId());
      return new ThemeData(__nid);
    }
    return factories.AnimatedTheme_readBack_data(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedThemeChild not supported on web");
    return factories.AnimatedTheme_readBack_child(nativeStruct);
  }
  @Override
  public AnimatedTheme build() {
    return this;
  }
}
