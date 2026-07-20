package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ColoredBoxObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ColoredBox extends SingleChildRenderObjectWidget implements ColoredBoxI {
  private MemorySegment st;
  protected ColoredBox() {}
  ColoredBox(MemorySegment st) {
    this.id = ColoredBoxObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ColoredBox");
    System.out.println("New ColoredBox id:"+id);
  }
  @Builder.Factory
  static ColoredBox coloredBoxColoredBox(@Builder.Parameter ColorI color, Optional<WidgetI> child) {
    var st = factories.coloredBoxColoredBox(color.build(),
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget ColoredBox");
    return new ColoredBox(st);
  }
  public static ColoredBoxColoredBoxBuilder coloredBox(ColorI color) {
    return ColoredBoxColoredBoxBuilder.coloredBoxColoredBox(color);
  }
  public Color color() {
    return new Color(ColoredBoxObjSt.color(st));
  }
  @Override
  public ColoredBox build() {
    return this;
  }
}
