package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Border extends BoxBorder implements BorderI {
  protected Border() {}
  Border(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Border");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Border borderBorder(Optional<BorderSideI> top, Optional<BorderSideI> right, Optional<BorderSideI> bottom, Optional<BorderSideI> left) {
    int id = factories.borderBorder(top.map(BorderSideI::build),
      right.map(BorderSideI::build),
      bottom.map(BorderSideI::build),
      left.map(BorderSideI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Border");
    return new Border(id);
  }
  public static BorderBorderBuilder border() {
    return BorderBorderBuilder.borderBorder();
  }
  @Builder.Factory
  static Border borderFromBorderSide(@Builder.Parameter BorderSideI side) {
    int id = factories.borderFromBorderSide(side.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Border");
    return new Border(id);
  }
  public static BorderFromBorderSideBuilder fromBorderSide(BorderSideI side) {
    return BorderFromBorderSideBuilder.borderFromBorderSide(side);
  }
  @Builder.Factory
  static Border borderSymmetric(Optional<BorderSideI> vertical, Optional<BorderSideI> horizontal) {
    int id = factories.borderSymmetric(vertical.map(BorderSideI::build),
      horizontal.map(BorderSideI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Border");
    return new Border(id);
  }
  public static BorderSymmetricBuilder symmetric() {
    return BorderSymmetricBuilder.borderSymmetric();
  }
  @Builder.Factory
  static Border borderAll(Optional<ColorI> color, OptionalDouble width, Optional<BorderStyle> style, OptionalDouble strokeAlign) {
    int id = factories.borderAll(color.map(ColorI::build),
      width,
      style,
      strokeAlign);
    if (id <= 0) throw new RuntimeException("Failed to created widget Border");
    return new Border(id);
  }
  public static BorderAllBuilder all() {
    return BorderAllBuilder.borderAll();
  }
  public static Border merge(BorderI a, BorderI b) {
    int id = factories.borderMerge(a.build(),
      b.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Border");
    return new Border(id);
  }
  public static Border lerp(BorderI a, BorderI b, double t) {
    int id = factories.borderLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget Border");
    return new Border(id);
  }
  public BorderSide top() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("borderTop", getId());
      return new BorderSide(__nid);
    }
    return factories.Border_readBack_top(nativeStruct);
  }
  public BorderSide right() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("borderRight", getId());
      return new BorderSide(__nid);
    }
    return factories.Border_readBack_right(nativeStruct);
  }
  public BorderSide bottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("borderBottom", getId());
      return new BorderSide(__nid);
    }
    return factories.Border_readBack_bottom(nativeStruct);
  }
  public BorderSide left() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("borderLeft", getId());
      return new BorderSide(__nid);
    }
    return factories.Border_readBack_left(nativeStruct);
  }
  @Override
  public Border build() {
    return this;
  }
}
