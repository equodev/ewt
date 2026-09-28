package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoActivityIndicator extends StatefulWidget implements CupertinoActivityIndicatorI {
  protected CupertinoActivityIndicator() {}
  CupertinoActivityIndicator(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoActivityIndicator");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoActivityIndicator cupertinoActivityIndicatorCupertinoActivityIndicator(Optional<ColorI> color, Optional<Boolean> animating, OptionalDouble radius) {
    int id = factories.cupertinoActivityIndicatorCupertinoActivityIndicator(color.map(ColorI::build),
      animating,
      radius);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoActivityIndicator");
    return new CupertinoActivityIndicator(id);
  }
  public static CupertinoActivityIndicatorCupertinoActivityIndicatorBuilder cupertinoActivityIndicator() {
    return CupertinoActivityIndicatorCupertinoActivityIndicatorBuilder.cupertinoActivityIndicatorCupertinoActivityIndicator();
  }
  @Builder.Factory
  static CupertinoActivityIndicator cupertinoActivityIndicatorPartiallyRevealed(Optional<ColorI> color, OptionalDouble radius, OptionalDouble progress) {
    int id = factories.cupertinoActivityIndicatorPartiallyRevealed(color.map(ColorI::build),
      radius,
      progress);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoActivityIndicator");
    return new CupertinoActivityIndicator(id);
  }
  public static CupertinoActivityIndicatorPartiallyRevealedBuilder partiallyRevealed() {
    return CupertinoActivityIndicatorPartiallyRevealedBuilder.cupertinoActivityIndicatorPartiallyRevealed();
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoActivityIndicatorColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoActivityIndicator_readBack_color(nativeStruct);
  }
  public boolean animating() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoActivityIndicatorAnimating not supported on web");
    return factories.CupertinoActivityIndicator_readBack_animating(nativeStruct);
  }
  public double radius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoActivityIndicatorRadius not supported on web");
    return factories.CupertinoActivityIndicator_readBack_radius(nativeStruct);
  }
  public double progress() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoActivityIndicatorProgress not supported on web");
    return factories.CupertinoActivityIndicator_readBack_progress(nativeStruct);
  }
  @Override
  public CupertinoActivityIndicator build() {
    return this;
  }
}
