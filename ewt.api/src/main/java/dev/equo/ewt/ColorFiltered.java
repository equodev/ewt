package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ColorFilteredObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ColorFiltered extends SingleChildRenderObjectWidget implements ColorFilteredI {
  private MemorySegment st;
  protected ColorFiltered() {}
  ColorFiltered(MemorySegment st) {
    this.id = ColorFilteredObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ColorFiltered");
    System.out.println("New ColorFiltered id:"+id);
  }
  ColorFiltered(int id) { this.id = id; }
  @Builder.Factory
  static ColorFiltered colorFilteredColorFiltered(@Builder.Parameter ColorFilterI colorFilter, Optional<WidgetI> child) {
    var st = factories.colorFilteredColorFiltered(colorFilter.build(),
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget ColorFiltered");
    return new ColorFiltered(st);
  }
  public static ColorFilteredColorFilteredBuilder colorFiltered(ColorFilterI colorFilter) {
    return ColorFilteredColorFilteredBuilder.colorFilteredColorFiltered(colorFilter);
  }
  public ColorFilter colorFilter() {
    return new ColorFilter(ColorFilteredObjSt.colorFilter(st));
  }
  @Override
  public ColorFiltered build() {
    return this;
  }
}
