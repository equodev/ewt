package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BackdropFilterObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BackdropFilter extends SingleChildRenderObjectWidget implements BackdropFilterI {
  private MemorySegment st;
  protected BackdropFilter() {}
  BackdropFilter(MemorySegment st) {
    this.id = BackdropFilterObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget BackdropFilter");
    System.out.println("New BackdropFilter id:"+id);
  }
  BackdropFilter(int id) { this.id = id; }
  @Builder.Factory
  static BackdropFilter backdropFilterBackdropFilter(@Builder.Parameter ImageFilterI filter, Optional<WidgetI> child, Optional<BlendMode> blendMode, Optional<Boolean> enabled) {
    var st = factories.backdropFilterBackdropFilter(filter.build(),
      child.map(WidgetI::build),
      blendMode,
      enabled);
    if (st == null) throw new RuntimeException("Failed to created widget BackdropFilter");
    return new BackdropFilter(st);
  }
  public static BackdropFilterBackdropFilterBuilder backdropFilter(ImageFilterI filter) {
    return BackdropFilterBackdropFilterBuilder.backdropFilterBackdropFilter(filter);
  }
  @Builder.Factory
  static BackdropFilter backdropFilterGrouped(@Builder.Parameter ImageFilterI filter, Optional<WidgetI> child, Optional<BlendMode> blendMode, Optional<Boolean> enabled) {
    var st = factories.backdropFilterGrouped(filter.build(),
      child.map(WidgetI::build),
      blendMode,
      enabled);
    if (st == null) throw new RuntimeException("Failed to created widget BackdropFilter");
    return new BackdropFilter(st);
  }
  public static BackdropFilterGroupedBuilder grouped(ImageFilterI filter) {
    return BackdropFilterGroupedBuilder.backdropFilterGrouped(filter);
  }
  public ImageFilter filter() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("backdropFilterFilter not supported on web");
    return new ImageFilter(BackdropFilterObjSt.filter(st)) {};
  }
  public BlendMode blendMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("backdropFilterBlendMode not supported on web");
    return BlendMode.values()[BackdropFilterObjSt.blendMode(st)];
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("backdropFilterEnabled not supported on web");
    return intToBool(BackdropFilterObjSt.enabled(st));
  }
  @Override
  public BackdropFilter build() {
    return this;
  }
}
