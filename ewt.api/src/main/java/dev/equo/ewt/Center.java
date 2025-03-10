package dev.equo.ewt;
import org.immutables.builder.Builder;
public class Center extends Widget {
  static final WidgetConstructors factories = WidgetConstructors.instance;
  @Builder.Constructor
  Center(java.util.OptionalDouble widthFactor, java.util.OptionalDouble heightFactor, java.util.Optional<Widget> child) {
    id = factories.centerOf(widthFactor, heightFactor, child);
  }
  public static CenterBuilder of() {
    return CenterBuilder.Center();
  }
}
