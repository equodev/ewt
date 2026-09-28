package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class BackdropFilter extends SingleChildRenderObjectWidget implements BackdropFilterI {
  protected BackdropFilter() {}
  BackdropFilter(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget BackdropFilter");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static BackdropFilter backdropFilterBackdropFilter(Optional<ImageFilterI> filter, Optional<WidgetI> child, Optional<BlendMode> blendMode, Optional<Boolean> enabled) {
    int id = factories.backdropFilterBackdropFilter(filter.map(ImageFilterI::build),
      child.map(WidgetI::build),
      blendMode,
      enabled);
    if (id <= 0) throw new RuntimeException("Failed to created widget BackdropFilter");
    return new BackdropFilter(id);
  }
  public static BackdropFilterBackdropFilterBuilder backdropFilter() {
    return BackdropFilterBackdropFilterBuilder.backdropFilterBackdropFilter();
  }
  @Builder.Factory
  static BackdropFilter backdropFilterGrouped(Optional<ImageFilterI> filter, Optional<WidgetI> child, Optional<BlendMode> blendMode, Optional<Boolean> enabled) {
    int id = factories.backdropFilterGrouped(filter.map(ImageFilterI::build),
      child.map(WidgetI::build),
      blendMode,
      enabled);
    if (id <= 0) throw new RuntimeException("Failed to created widget BackdropFilter");
    return new BackdropFilter(id);
  }
  public static BackdropFilterGroupedBuilder grouped() {
    return BackdropFilterGroupedBuilder.backdropFilterGrouped();
  }
  public ImageFilter filter() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("backdropFilterFilter not supported on web");
    return factories.BackdropFilter_readBack_filter(nativeStruct);
  }
  public BlendMode blendMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("backdropFilterBlendMode not supported on web");
    return factories.BackdropFilter_readBack_blendMode(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("backdropFilterEnabled not supported on web");
    return factories.BackdropFilter_readBack_enabled(nativeStruct);
  }
  @Override
  public BackdropFilter build() {
    return this;
  }
}
