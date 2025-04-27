package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ColorSwatchObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ColorSwatch<T> extends Color implements ColorSwatchI {
  private MemorySegment st;
  protected ColorSwatch() {}
  ColorSwatch(MemorySegment st) {
    this.id = ColorSwatchObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ColorSwatch");
    System.out.println("New ColorSwatch id:"+id);
  }
  public static ColorSwatch lerp(ColorSwatchI a, ColorSwatchI b, double t) {
    var st = factories.colorSwatchLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget ColorSwatch");
    return new ColorSwatch(st);
  }
  @Override
  public ColorSwatch build() {
    return this;
  }
}
