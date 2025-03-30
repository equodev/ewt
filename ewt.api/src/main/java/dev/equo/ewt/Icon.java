package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
public class Icon extends StatelessWidget implements IconI {
  @Override
  public Icon build() {
    return this;
  }
  Icon() {}
  Icon(int id) {
    this.id = id;
  }
  @Builder.Factory
  static Icon iconIcon(@Builder.Parameter IconDataI icon, OptionalDouble size, OptionalDouble fill, OptionalDouble weight, OptionalDouble grade, OptionalDouble opticalSize, Optional<ColorI> color, Optional<String> semanticLabel, Optional<TextDirection> textDirection, Optional<Boolean> applyTextScaling, Optional<BlendMode> blendMode) {
    int id = factories.iconIcon(icon.build(),
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
    if (id == -1) throw new RuntimeException("Failed to created widget Icon");
    System.out.println("New Icon id:"+id);
    return new Icon(id);
  }
  public static IconIconBuilder icon(IconDataI icon) {
    return IconIconBuilder.iconIcon(icon);
  }
}
