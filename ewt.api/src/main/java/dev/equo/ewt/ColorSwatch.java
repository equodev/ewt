package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ColorSwatch<T> extends Color implements ColorSwatchI {
  protected ColorSwatch() {}
  ColorSwatch(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ColorSwatch");
    this.nativeStruct = factories.takeLastStruct();
  }
  public static ColorSwatch lerp(ColorSwatchI a, ColorSwatchI b, double t) {
    int id = factories.colorSwatchLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget ColorSwatch");
    return new ColorSwatch(id);
  }
  @Override
  public ColorSwatch build() {
    return this;
  }
}
