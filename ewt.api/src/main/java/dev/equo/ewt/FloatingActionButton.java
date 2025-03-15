package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;
public class FloatingActionButton extends StatelessWidget {
  static final WidgetConstructors factories = WidgetConstructors.instance;
  FloatingActionButton() {}
  FloatingActionButton(int id) {
    this.id = id;
  }
  @Builder.Factory
  static FloatingActionButton floatingActionButtonFloatingActionButton(Optional<Widget> child, Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> splashColor, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, java.lang.Runnable onPressed, Optional<Boolean> mini, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> isExtended, Optional<Boolean> enableFeedback) {
    int id = factories.floatingActionButtonFloatingActionButton(child,
      tooltip,
      foregroundColor,
      backgroundColor,
      focusColor,
      hoverColor,
      splashColor,
      elevation,
      focusElevation,
      hoverElevation,
      highlightElevation,
      disabledElevation,
      onPressed,
      mini,
      clipBehavior,
      autofocus,
      materialTapTargetSize,
      isExtended,
      enableFeedback);
    if (id == -1) throw new RuntimeException("Failed to created widget FloatingActionButton");
    System.out.println("New FloatingActionButton id:"+id);
    return new FloatingActionButton(id);
  }
  public static FloatingActionButtonFloatingActionButtonBuilder floatingActionButton() {
    return FloatingActionButtonFloatingActionButtonBuilder.floatingActionButtonFloatingActionButton();
  }
  @Builder.Factory
  static FloatingActionButton floatingActionButtonSmall(Optional<Widget> child, Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> splashColor, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, java.lang.Runnable onPressed, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> enableFeedback) {
    int id = factories.floatingActionButtonSmall(child,
      tooltip,
      foregroundColor,
      backgroundColor,
      focusColor,
      hoverColor,
      splashColor,
      elevation,
      focusElevation,
      hoverElevation,
      highlightElevation,
      disabledElevation,
      onPressed,
      clipBehavior,
      autofocus,
      materialTapTargetSize,
      enableFeedback);
    if (id == -1) throw new RuntimeException("Failed to created widget FloatingActionButton");
    System.out.println("New FloatingActionButton id:"+id);
    return new FloatingActionButton(id);
  }
  public static FloatingActionButtonSmallBuilder small() {
    return FloatingActionButtonSmallBuilder.floatingActionButtonSmall();
  }
  @Builder.Factory
  static FloatingActionButton floatingActionButtonLarge(Optional<Widget> child, Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> splashColor, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, java.lang.Runnable onPressed, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> enableFeedback) {
    int id = factories.floatingActionButtonLarge(child,
      tooltip,
      foregroundColor,
      backgroundColor,
      focusColor,
      hoverColor,
      splashColor,
      elevation,
      focusElevation,
      hoverElevation,
      highlightElevation,
      disabledElevation,
      onPressed,
      clipBehavior,
      autofocus,
      materialTapTargetSize,
      enableFeedback);
    if (id == -1) throw new RuntimeException("Failed to created widget FloatingActionButton");
    System.out.println("New FloatingActionButton id:"+id);
    return new FloatingActionButton(id);
  }
  public static FloatingActionButtonLargeBuilder large() {
    return FloatingActionButtonLargeBuilder.floatingActionButtonLarge();
  }
  @Builder.Factory
  static FloatingActionButton floatingActionButtonExtended(Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, Optional<Color> splashColor, OptionalDouble highlightElevation, OptionalDouble disabledElevation, java.lang.Runnable onPressed, Optional<Boolean> isExtended, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, OptionalDouble extendedIconLabelSpacing, Optional<Widget> icon, Widget label, Optional<Boolean> enableFeedback) {
    int id = factories.floatingActionButtonExtended(tooltip,
      foregroundColor,
      backgroundColor,
      focusColor,
      hoverColor,
      elevation,
      focusElevation,
      hoverElevation,
      splashColor,
      highlightElevation,
      disabledElevation,
      onPressed,
      isExtended,
      materialTapTargetSize,
      clipBehavior,
      autofocus,
      extendedIconLabelSpacing,
      icon,
      label,
      enableFeedback);
    if (id == -1) throw new RuntimeException("Failed to created widget FloatingActionButton");
    System.out.println("New FloatingActionButton id:"+id);
    return new FloatingActionButton(id);
  }
  public static FloatingActionButtonExtendedBuilder extended() {
    return FloatingActionButtonExtendedBuilder.floatingActionButtonExtended();
  }
}
