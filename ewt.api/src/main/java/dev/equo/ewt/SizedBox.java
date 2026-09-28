package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SizedBox extends SingleChildRenderObjectWidget implements SizedBoxI {
  protected SizedBox() {}
  SizedBox(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SizedBox");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SizedBox sizedBoxSizedBox(OptionalDouble width, OptionalDouble height, Optional<WidgetI> child) {
    int id = factories.sizedBoxSizedBox(width,
      height,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SizedBox");
    return new SizedBox(id);
  }
  public static SizedBoxSizedBoxBuilder sizedBox() {
    return SizedBoxSizedBoxBuilder.sizedBoxSizedBox();
  }
  @Builder.Factory
  static SizedBox sizedBoxExpand(Optional<WidgetI> child) {
    int id = factories.sizedBoxExpand(child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SizedBox");
    return new SizedBox(id);
  }
  public static SizedBoxExpandBuilder expand() {
    return SizedBoxExpandBuilder.sizedBoxExpand();
  }
  @Builder.Factory
  static SizedBox sizedBoxShrink(Optional<WidgetI> child) {
    int id = factories.sizedBoxShrink(child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SizedBox");
    return new SizedBox(id);
  }
  public static SizedBoxShrinkBuilder shrink() {
    return SizedBoxShrinkBuilder.sizedBoxShrink();
  }
  @Builder.Factory
  static SizedBox sizedBoxFromSize(Optional<WidgetI> child) {
    int id = factories.sizedBoxFromSize(child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SizedBox");
    return new SizedBox(id);
  }
  public static SizedBoxFromSizeBuilder fromSize() {
    return SizedBoxFromSizeBuilder.sizedBoxFromSize();
  }
  @Builder.Factory
  static SizedBox sizedBoxSquare(Optional<WidgetI> child, OptionalDouble dimension) {
    int id = factories.sizedBoxSquare(child.map(WidgetI::build),
      dimension);
    if (id <= 0) throw new RuntimeException("Failed to created widget SizedBox");
    return new SizedBox(id);
  }
  public static SizedBoxSquareBuilder square() {
    return SizedBoxSquareBuilder.sizedBoxSquare();
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sizedBoxWidth not supported on web");
    return factories.SizedBox_readBack_width(nativeStruct);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sizedBoxHeight not supported on web");
    return factories.SizedBox_readBack_height(nativeStruct);
  }
  @Override
  public SizedBox build() {
    return this;
  }
}
