package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Placeholder extends StatelessWidget implements PlaceholderI {
  protected Placeholder() {}
  Placeholder(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Placeholder");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Placeholder placeholderPlaceholder(Optional<ColorI> color, OptionalDouble strokeWidth, OptionalDouble fallbackWidth, OptionalDouble fallbackHeight, Optional<WidgetI> child) {
    int id = factories.placeholderPlaceholder(color.map(ColorI::build),
      strokeWidth,
      fallbackWidth,
      fallbackHeight,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Placeholder");
    return new Placeholder(id);
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
    return factories.Placeholder_readBack_color(nativeStruct);
  }
  public double strokeWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("placeholderStrokeWidth not supported on web");
    return factories.Placeholder_readBack_strokeWidth(nativeStruct);
  }
  public double fallbackWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("placeholderFallbackWidth not supported on web");
    return factories.Placeholder_readBack_fallbackWidth(nativeStruct);
  }
  public double fallbackHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("placeholderFallbackHeight not supported on web");
    return factories.Placeholder_readBack_fallbackHeight(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("placeholderChild not supported on web");
    return factories.Placeholder_readBack_child(nativeStruct);
  }
  @Override
  public Placeholder build() {
    return this;
  }
}
