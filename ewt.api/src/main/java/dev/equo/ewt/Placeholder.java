package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PlaceholderObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Placeholder extends StatelessWidget implements PlaceholderI {
  private MemorySegment st;
  protected Placeholder() {}
  Placeholder(MemorySegment st) {
    this.id = PlaceholderObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Placeholder");
    System.out.println("New Placeholder id:"+id);
  }
  Placeholder(int id) { this.id = id; }
  @Builder.Factory
  static Placeholder placeholderPlaceholder(Optional<ColorI> color, OptionalDouble strokeWidth, OptionalDouble fallbackWidth, OptionalDouble fallbackHeight, Optional<WidgetI> child) {
    var st = factories.placeholderPlaceholder(color.map(ColorI::build),
      strokeWidth,
      fallbackWidth,
      fallbackHeight,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Placeholder");
    return new Placeholder(st);
  }
  public static PlaceholderPlaceholderBuilder placeholder() {
    return PlaceholderPlaceholderBuilder.placeholderPlaceholder();
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("placeholderColor", getId());
      return new Color(__nid);
    }
    return new Color(PlaceholderObjSt.color(st));
  }
  public double strokeWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("placeholderStrokeWidth not supported on web");
    return PlaceholderObjSt.strokeWidth(st);
  }
  public double fallbackWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("placeholderFallbackWidth not supported on web");
    return PlaceholderObjSt.fallbackWidth(st);
  }
  public double fallbackHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("placeholderFallbackHeight not supported on web");
    return PlaceholderObjSt.fallbackHeight(st);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("placeholderChild not supported on web");
    return new Widget(PlaceholderObjSt.child(st)) {};
  }
  @Override
  public Placeholder build() {
    return this;
  }
}
