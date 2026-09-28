package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class BoxShadow extends Shadow implements BoxShadowI {
  protected BoxShadow() {}
  BoxShadow(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget BoxShadow");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static BoxShadow boxShadowBoxShadow(Optional<ColorI> color, Optional<OffsetI> offset, OptionalDouble blurRadius, OptionalDouble spreadRadius, Optional<BlurStyle> blurStyle) {
    int id = factories.boxShadowBoxShadow(color.map(ColorI::build),
      offset.map(OffsetI::build),
      blurRadius,
      spreadRadius,
      blurStyle);
    if (id <= 0) throw new RuntimeException("Failed to created widget BoxShadow");
    return new BoxShadow(id);
  }
  public static BoxShadowBoxShadowBuilder boxShadow() {
    return BoxShadowBoxShadowBuilder.boxShadowBoxShadow();
  }
  public static BoxShadow lerp(BoxShadowI a, BoxShadowI b, double t) {
    int id = factories.boxShadowLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget BoxShadow");
    return new BoxShadow(id);
  }
  public double spreadRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxShadowSpreadRadius not supported on web");
    return factories.BoxShadow_readBack_spreadRadius(nativeStruct);
  }
  public BlurStyle blurStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxShadowBlurStyle not supported on web");
    return factories.BoxShadow_readBack_blurStyle(nativeStruct);
  }
  @Override
  public BoxShadow build() {
    return this;
  }
}
