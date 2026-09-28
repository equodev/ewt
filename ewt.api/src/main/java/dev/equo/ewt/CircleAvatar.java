package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CircleAvatar extends StatelessWidget implements CircleAvatarI {
  protected CircleAvatar() {}
  CircleAvatar(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CircleAvatar");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CircleAvatar circleAvatarCircleAvatar(Optional<WidgetI> child, Optional<ColorI> backgroundColor, Optional<ColorI> foregroundColor, OptionalDouble radius, OptionalDouble minRadius, OptionalDouble maxRadius) {
    int id = factories.circleAvatarCircleAvatar(child.map(WidgetI::build),
      backgroundColor.map(ColorI::build),
      foregroundColor.map(ColorI::build),
      radius,
      minRadius,
      maxRadius);
    if (id <= 0) throw new RuntimeException("Failed to created widget CircleAvatar");
    return new CircleAvatar(id);
  }
  public static CircleAvatarCircleAvatarBuilder circleAvatar() {
    return CircleAvatarCircleAvatarBuilder.circleAvatarCircleAvatar();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("circleAvatarChild not supported on web");
    return factories.CircleAvatar_readBack_child(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("circleAvatarBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.CircleAvatar_readBack_backgroundColor(nativeStruct);
  }
  public Color foregroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("circleAvatarForegroundColor", getId());
      return new Color(__nid);
    }
    return factories.CircleAvatar_readBack_foregroundColor(nativeStruct);
  }
  public double radius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("circleAvatarRadius not supported on web");
    return factories.CircleAvatar_readBack_radius(nativeStruct);
  }
  public double minRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("circleAvatarMinRadius not supported on web");
    return factories.CircleAvatar_readBack_minRadius(nativeStruct);
  }
  public double maxRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("circleAvatarMaxRadius not supported on web");
    return factories.CircleAvatar_readBack_maxRadius(nativeStruct);
  }
  private static double _defaultRadius() {
    return 20.0;
  }
  private static double _defaultMinRadius() {
    return 0.0;
  }
  private static double _defaultMaxRadius() {
    return Double.POSITIVE_INFINITY;
  }
  @Override
  public CircleAvatar build() {
    return this;
  }
}
