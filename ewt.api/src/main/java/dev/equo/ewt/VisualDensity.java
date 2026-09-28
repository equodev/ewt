package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class VisualDensity extends NativeObj.Base implements VisualDensityI {
  protected VisualDensity() {}
  VisualDensity(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget VisualDensity");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static VisualDensity visualDensityVisualDensity(OptionalDouble horizontal, OptionalDouble vertical) {
    int id = factories.visualDensityVisualDensity(horizontal,
      vertical);
    if (id <= 0) throw new RuntimeException("Failed to created widget VisualDensity");
    return new VisualDensity(id);
  }
  public static VisualDensityVisualDensityBuilder visualDensity() {
    return VisualDensityVisualDensityBuilder.visualDensityVisualDensity();
  }
  public static VisualDensity defaultDensityForPlatform(TargetPlatform platform) {
    int id = factories.visualDensityDefaultDensityForPlatform(platform);
    if (id <= 0) throw new RuntimeException("Failed to created widget VisualDensity");
    return new VisualDensity(id);
  }
  public static VisualDensity lerp(VisualDensityI a, VisualDensityI b, double t) {
    int id = factories.visualDensityLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget VisualDensity");
    return new VisualDensity(id);
  }
  public double horizontal() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("visualDensityHorizontal not supported on web");
    return factories.VisualDensity_readBack_horizontal(nativeStruct);
  }
  public double vertical() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("visualDensityVertical not supported on web");
    return factories.VisualDensity_readBack_vertical(nativeStruct);
  }
  public Offset baseSizeAdjustment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("visualDensityBaseSizeAdjustment", getId());
      return new Offset(__nid);
    }
    return factories.VisualDensity_readBack_baseSizeAdjustment(nativeStruct);
  }
  public static double minimumDensity() {
    return -4.0;
  }
  public static double maximumDensity() {
    return 4.0;
  }
  public static VisualDensity standard() {
    return VisualDensity.visualDensity().build();
  }
  public static VisualDensity comfortable() {
    return VisualDensity.visualDensity().horizontal(-1.0).vertical(-1.0).build();
  }
  public static VisualDensity compact() {
    return VisualDensity.visualDensity().horizontal(-2.0).vertical(-2.0).build();
  }
  @Override
  public VisualDensity build() {
    return this;
  }
}
