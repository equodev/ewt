package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;
public class Icon extends StatelessWidget {
  Icon() {}
  Icon(int id) {
    this.id = id;
  }
  @Builder.Factory
  static Icon iconIcon(@Builder.Parameter IconData icon, OptionalDouble size, OptionalDouble fill, OptionalDouble weight, OptionalDouble grade, OptionalDouble opticalSize, Optional<Color> color, Optional<String> semanticLabel, Optional<TextDirection> textDirection, Optional<Boolean> applyTextScaling, Optional<BlendMode> blendMode) {
    int id = factories.iconIcon(icon,
      size,
      fill,
      weight,
      grade,
      opticalSize,
      color,
      semanticLabel,
      textDirection,
      applyTextScaling,
      blendMode);
    if (id == -1) throw new RuntimeException("Failed to created widget Icon");
    System.out.println("New Icon id:"+id);
    return new Icon(id);
  }
  public static IconIconBuilder icon(IconData icon) {
    return IconIconBuilder.iconIcon(icon);
  }
}
