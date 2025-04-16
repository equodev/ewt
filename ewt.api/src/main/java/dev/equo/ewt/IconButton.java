package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.IconButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class IconButton extends StatelessWidget implements IconButtonI {
  private MemorySegment st;
  protected IconButton() {}
  IconButton(MemorySegment st) {
    this.id = IconButtonObjSt.id(st);
    this.st = st;
    System.out.println("New IconButton id:"+id);
  }
  @Builder.Factory
  static IconButton iconButtonIconButton(OptionalDouble iconSize, Optional<EdgeInsetsGeometryI> padding, OptionalDouble splashRadius, Optional<ColorI> color, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> splashColor, Optional<ColorI> disabledColor, Runnable onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraintsI> constraints, Optional<Boolean> isSelected, Optional<WidgetI> selectedIcon, WidgetI icon) {
    var st = factories.iconButtonIconButton(iconSize,
      padding.map(EdgeInsetsGeometryI::build),
      splashRadius,
      color.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      highlightColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      disabledColor.map(ColorI::build),
      onPressed,
      onHover,
      onLongPress,
      autofocus,
      tooltip,
      enableFeedback,
      constraints.map(BoxConstraintsI::build),
      isSelected,
      selectedIcon.map(WidgetI::build),
      icon.build());
    if (st == null) throw new RuntimeException("Failed to created widget IconButton");
    return new IconButton(st);
  }
  public static IconButtonIconButtonBuilder iconButton() {
    return IconButtonIconButtonBuilder.iconButtonIconButton();
  }
  @Builder.Factory
  static IconButton iconButtonFilled(OptionalDouble iconSize, Optional<EdgeInsetsGeometryI> padding, OptionalDouble splashRadius, Optional<ColorI> color, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> splashColor, Optional<ColorI> disabledColor, Runnable onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraintsI> constraints, Optional<Boolean> isSelected, Optional<WidgetI> selectedIcon, WidgetI icon) {
    var st = factories.iconButtonFilled(iconSize,
      padding.map(EdgeInsetsGeometryI::build),
      splashRadius,
      color.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      highlightColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      disabledColor.map(ColorI::build),
      onPressed,
      onHover,
      onLongPress,
      autofocus,
      tooltip,
      enableFeedback,
      constraints.map(BoxConstraintsI::build),
      isSelected,
      selectedIcon.map(WidgetI::build),
      icon.build());
    if (st == null) throw new RuntimeException("Failed to created widget IconButton");
    return new IconButton(st);
  }
  public static IconButtonFilledBuilder filled() {
    return IconButtonFilledBuilder.iconButtonFilled();
  }
  @Builder.Factory
  static IconButton iconButtonFilledTonal(OptionalDouble iconSize, Optional<EdgeInsetsGeometryI> padding, OptionalDouble splashRadius, Optional<ColorI> color, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> splashColor, Optional<ColorI> disabledColor, Runnable onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraintsI> constraints, Optional<Boolean> isSelected, Optional<WidgetI> selectedIcon, WidgetI icon) {
    var st = factories.iconButtonFilledTonal(iconSize,
      padding.map(EdgeInsetsGeometryI::build),
      splashRadius,
      color.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      highlightColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      disabledColor.map(ColorI::build),
      onPressed,
      onHover,
      onLongPress,
      autofocus,
      tooltip,
      enableFeedback,
      constraints.map(BoxConstraintsI::build),
      isSelected,
      selectedIcon.map(WidgetI::build),
      icon.build());
    if (st == null) throw new RuntimeException("Failed to created widget IconButton");
    return new IconButton(st);
  }
  public static IconButtonFilledTonalBuilder filledTonal() {
    return IconButtonFilledTonalBuilder.iconButtonFilledTonal();
  }
  @Builder.Factory
  static IconButton iconButtonOutlined(OptionalDouble iconSize, Optional<EdgeInsetsGeometryI> padding, OptionalDouble splashRadius, Optional<ColorI> color, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> splashColor, Optional<ColorI> disabledColor, Runnable onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraintsI> constraints, Optional<Boolean> isSelected, Optional<WidgetI> selectedIcon, WidgetI icon) {
    var st = factories.iconButtonOutlined(iconSize,
      padding.map(EdgeInsetsGeometryI::build),
      splashRadius,
      color.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      highlightColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      disabledColor.map(ColorI::build),
      onPressed,
      onHover,
      onLongPress,
      autofocus,
      tooltip,
      enableFeedback,
      constraints.map(BoxConstraintsI::build),
      isSelected,
      selectedIcon.map(WidgetI::build),
      icon.build());
    if (st == null) throw new RuntimeException("Failed to created widget IconButton");
    return new IconButton(st);
  }
  public static IconButtonOutlinedBuilder outlined() {
    return IconButtonOutlinedBuilder.iconButtonOutlined();
  }
  public double iconSize() {
    return IconButtonObjSt.iconSize(st);
  }
  public EdgeInsetsGeometry padding() {
    return new EdgeInsetsGeometry(IconButtonObjSt.padding(st)) {};
  }
  public double splashRadius() {
    return IconButtonObjSt.splashRadius(st);
  }
  public Widget icon() {
    return new Widget(IconButtonObjSt.icon(st)) {};
  }
  public Color focusColor() {
    return new Color(IconButtonObjSt.focusColor(st));
  }
  public Color hoverColor() {
    return new Color(IconButtonObjSt.hoverColor(st));
  }
  public Color color() {
    return new Color(IconButtonObjSt.color(st));
  }
  public Color splashColor() {
    return new Color(IconButtonObjSt.splashColor(st));
  }
  public Color highlightColor() {
    return new Color(IconButtonObjSt.highlightColor(st));
  }
  public Color disabledColor() {
    return new Color(IconButtonObjSt.disabledColor(st));
  }
  public boolean autofocus() {
    return intToBool(IconButtonObjSt.autofocus(st));
  }
  public String tooltip() {
    return IconButtonObjSt.tooltip(st).getString(0);
  }
  public boolean enableFeedback() {
    return intToBool(IconButtonObjSt.enableFeedback(st));
  }
  public BoxConstraints constraints() {
    return new BoxConstraints(IconButtonObjSt.constraints(st));
  }
  public boolean isSelected() {
    return intToBool(IconButtonObjSt.isSelected(st));
  }
  public Widget selectedIcon() {
    return new Widget(IconButtonObjSt.selectedIcon(st)) {};
  }
  @Override
  public IconButton build() {
    return this;
  }
}
