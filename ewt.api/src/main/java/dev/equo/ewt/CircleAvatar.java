package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CircleAvatarObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CircleAvatar extends StatelessWidget implements CircleAvatarI {
  private MemorySegment st;
  protected CircleAvatar() {}
  CircleAvatar(MemorySegment st) {
    this.id = CircleAvatarObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CircleAvatar");
    System.out.println("New CircleAvatar id:"+id);
  }
  CircleAvatar(int id) { this.id = id; }
  @Builder.Factory
  static CircleAvatar circleAvatarCircleAvatar(Optional<WidgetI> child, Optional<ColorI> backgroundColor, Optional<ColorI> foregroundColor, OptionalDouble radius, OptionalDouble minRadius, OptionalDouble maxRadius) {
    var st = factories.circleAvatarCircleAvatar(child.map(WidgetI::build),
      backgroundColor.map(ColorI::build),
      foregroundColor.map(ColorI::build),
      radius,
      minRadius,
      maxRadius);
    if (st == null) throw new RuntimeException("Failed to created widget CircleAvatar");
    return new CircleAvatar(st);
  }
  public static CircleAvatarCircleAvatarBuilder circleAvatar() {
    return CircleAvatarCircleAvatarBuilder.circleAvatarCircleAvatar();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("circleAvatarChild not supported on web");
    return new Widget(CircleAvatarObjSt.child(st)) {};
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("circleAvatarBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(CircleAvatarObjSt.backgroundColor(st));
  }
  public Color foregroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("circleAvatarForegroundColor", getId());
      return new Color(__nid);
    }
    return new Color(CircleAvatarObjSt.foregroundColor(st));
  }
  public double radius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("circleAvatarRadius not supported on web");
    return CircleAvatarObjSt.radius(st);
  }
  public double minRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("circleAvatarMinRadius not supported on web");
    return CircleAvatarObjSt.minRadius(st);
  }
  public double maxRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("circleAvatarMaxRadius not supported on web");
    return CircleAvatarObjSt.maxRadius(st);
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
