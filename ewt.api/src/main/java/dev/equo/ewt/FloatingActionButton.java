package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
public class FloatingActionButton extends StatelessWidget implements FloatingActionButtonI {
  @Override
  public FloatingActionButton build() {
    return this;
  }
  FloatingActionButton() {}
  FloatingActionButton(int id) {
    this.id = id;
  }
  @Builder.Factory
  static FloatingActionButton floatingActionButtonFloatingActionButton(Optional<WidgetI> child, Optional<String> tooltip, Optional<ColorI> foregroundColor, Optional<ColorI> backgroundColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> splashColor, Optional<NativeObj.I> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<Boolean> mini, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> isExtended, Optional<Boolean> enableFeedback) {
    int id = factories.floatingActionButtonFloatingActionButton(child.map(WidgetI::build),
      tooltip,
      foregroundColor.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      heroTag.map(NativeObj.I::build),
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
  static FloatingActionButton floatingActionButtonSmall(Optional<WidgetI> child, Optional<String> tooltip, Optional<ColorI> foregroundColor, Optional<ColorI> backgroundColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> splashColor, Optional<NativeObj.I> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> enableFeedback) {
    int id = factories.floatingActionButtonSmall(child.map(WidgetI::build),
      tooltip,
      foregroundColor.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      heroTag.map(NativeObj.I::build),
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
  static FloatingActionButton floatingActionButtonLarge(Optional<WidgetI> child, Optional<String> tooltip, Optional<ColorI> foregroundColor, Optional<ColorI> backgroundColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> splashColor, Optional<NativeObj.I> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> enableFeedback) {
    int id = factories.floatingActionButtonLarge(child.map(WidgetI::build),
      tooltip,
      foregroundColor.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      heroTag.map(NativeObj.I::build),
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
  static FloatingActionButton floatingActionButtonExtended(Optional<String> tooltip, Optional<ColorI> foregroundColor, Optional<ColorI> backgroundColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<NativeObj.I> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, Optional<ColorI> splashColor, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<Boolean> isExtended, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, OptionalDouble extendedIconLabelSpacing, Optional<TextStyleI> extendedTextStyle, Optional<WidgetI> icon, WidgetI label, Optional<Boolean> enableFeedback) {
    int id = factories.floatingActionButtonExtended(tooltip,
      foregroundColor.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      heroTag.map(NativeObj.I::build),
      elevation,
      focusElevation,
      hoverElevation,
      splashColor.map(ColorI::build),
      highlightElevation,
      disabledElevation,
      onPressed,
      isExtended,
      materialTapTargetSize,
      clipBehavior,
      autofocus,
      extendedIconLabelSpacing,
      extendedTextStyle.map(TextStyleI::build),
      icon.map(WidgetI::build),
      label.build(),
      enableFeedback);
    if (id == -1) throw new RuntimeException("Failed to created widget FloatingActionButton");
    System.out.println("New FloatingActionButton id:"+id);
    return new FloatingActionButton(id);
  }
  public static FloatingActionButtonExtendedBuilder extended() {
    return FloatingActionButtonExtendedBuilder.floatingActionButtonExtended();
  }
}
