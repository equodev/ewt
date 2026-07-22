package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BorderSideObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BorderSide extends NativeObj.Base implements BorderSideI {
  private MemorySegment st;
  protected BorderSide() {}
  BorderSide(MemorySegment st) {
    this.id = BorderSideObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget BorderSide");
    System.out.println("New BorderSide id:"+id);
  }
  @Builder.Factory
  static BorderSide borderSideBorderSide(Optional<ColorI> color, OptionalDouble width, Optional<BorderStyle> style, OptionalDouble strokeAlign) {
    var st = factories.borderSideBorderSide(color.map(ColorI::build),
      width,
      style,
      strokeAlign);
    if (st == null) throw new RuntimeException("Failed to created widget BorderSide");
    return new BorderSide(st);
  }
  public static BorderSideBorderSideBuilder borderSide() {
    return BorderSideBorderSideBuilder.borderSideBorderSide();
  }
  public static BorderSide merge(BorderSideI a, BorderSideI b) {
    var st = factories.borderSideMerge(a.build(),
      b.build());
    if (st == null) throw new RuntimeException("Failed to created widget BorderSide");
    return new BorderSide(st);
  }
  public static boolean canMerge(BorderSideI a, BorderSideI b) {
    int id = factories.borderSideCanMerge(a.build(),
      b.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    System.out.println("New bool id:"+id);
    return intToBool(id);
  }
  public static BorderSide lerp(BorderSideI a, BorderSideI b, double t) {
    var st = factories.borderSideLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget BorderSide");
    return new BorderSide(st);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("borderSideColor", getId());
      return new Color(__nid);
    }
    return new Color(BorderSideObjSt.color(st));
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("borderSideWidth not supported on web");
    return BorderSideObjSt.width(st);
  }
  public BorderStyle style() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("borderSideStyle not supported on web");
    return BorderStyle.values()[BorderSideObjSt.style(st)];
  }
  public double strokeAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("borderSideStrokeAlign not supported on web");
    return BorderSideObjSt.strokeAlign(st);
  }
  public double strokeInset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("borderSideStrokeInset not supported on web");
    return BorderSideObjSt.strokeInset(st);
  }
  public double strokeOutset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("borderSideStrokeOutset not supported on web");
    return BorderSideObjSt.strokeOutset(st);
  }
  public double strokeOffset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("borderSideStrokeOffset not supported on web");
    return BorderSideObjSt.strokeOffset(st);
  }
  public static BorderSide none() {
    return BorderSide.borderSide().width(0.0).style(BorderStyle.none).build();
  }
  public static double strokeAlignInside() {
    return -1.0;
  }
  public static double strokeAlignCenter() {
    return 0.0;
  }
  public static double strokeAlignOutside() {
    return 1.0;
  }
  @Override
  public BorderSide build() {
    return this;
  }
}
