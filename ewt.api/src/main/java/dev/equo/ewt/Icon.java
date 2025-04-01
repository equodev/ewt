package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.IconObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Icon extends StatelessWidget implements IconI {
  @Override
  public Icon build() {
    return this;
  }
  private MemorySegment st;
  protected Icon() {}
  Icon(MemorySegment st) {
    this.id = IconObjSt.id(st);
    this.st = st;
    System.out.println("New Icon id:"+id);
  }
  @Builder.Factory
  static Icon iconIcon(@Builder.Parameter IconDataI icon, OptionalDouble size, OptionalDouble fill, OptionalDouble weight, OptionalDouble grade, OptionalDouble opticalSize, Optional<ColorI> color, Optional<String> semanticLabel, Optional<TextDirection> textDirection, Optional<Boolean> applyTextScaling, Optional<BlendMode> blendMode) {
    var st = factories.iconIcon(icon.build(),
      size,
      fill,
      weight,
      grade,
      opticalSize,
      color.map(ColorI::build),
      semanticLabel,
      textDirection,
      applyTextScaling,
      blendMode);
    if (st == null) throw new RuntimeException("Failed to created widget Icon");
    return new Icon(st);
  }
  public static IconIconBuilder icon(IconDataI icon) {
    return IconIconBuilder.iconIcon(icon);
  }
  public IconData icon() {
    return new IconData(IconObjSt.icon(st)) {};
  }
  public double size() {
    return IconObjSt.size(st);
  }
  public double fill() {
    return IconObjSt.fill(st);
  }
  public double weight() {
    return IconObjSt.weight(st);
  }
  public double grade() {
    return IconObjSt.grade(st);
  }
  public double opticalSize() {
    return IconObjSt.opticalSize(st);
  }
  public Color color() {
    return new Color(IconObjSt.color(st)) {};
  }
  public TextDirection textDirection() {
    return TextDirection.values()[IconObjSt.textDirection(st)];
  }
  public boolean applyTextScaling() {
    return intToBool(IconObjSt.applyTextScaling(st));
  }
  public BlendMode blendMode() {
    return BlendMode.values()[IconObjSt.blendMode(st)];
  }
}
