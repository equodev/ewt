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
    return new ImageFilter(BackdropFilterObjSt.filter(st)) {};
  }
  public BlendMode blendMode() {
    return BlendMode.values()[BackdropFilterObjSt.blendMode(st)];
  }
  public boolean enabled() {
    return intToBool(BackdropFilterObjSt.enabled(st));
  }
  @Override
  public BackdropFilter build() {
    return this;
  }
}
