package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FloatingActionButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class FloatingActionButton extends StatelessWidget implements FloatingActionButtonI {
  private MemorySegment st;
  protected FloatingActionButton() {}
  FloatingActionButton(MemorySegment st) {
    this.id = FloatingActionButtonObjSt.id(st);
    this.st = st;
    System.out.println("New FloatingActionButton id:"+id);
  }
  @Builder.Factory
  static FloatingActionButton floatingActionButtonFloatingActionButton(Optional<WidgetI> child, Optional<String> tooltip, Optional<ColorI> foregroundColor, Optional<ColorI> backgroundColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> splashColor, Optional<NativeObj.I> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<Boolean> mini, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> isExtended, Optional<Boolean> enableFeedback) {
    var st = factories.floatingActionButtonFloatingActionButton(child.map(WidgetI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget FloatingActionButton");
    return new FloatingActionButton(st);
  }
  public static FloatingActionButtonFloatingActionButtonBuilder floatingActionButton() {
    return FloatingActionButtonFloatingActionButtonBuilder.floatingActionButtonFloatingActionButton();
  }
  @Builder.Factory
  static FloatingActionButton floatingActionButtonSmall(Optional<WidgetI> child, Optional<String> tooltip, Optional<ColorI> foregroundColor, Optional<ColorI> backgroundColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> splashColor, Optional<NativeObj.I> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> enableFeedback) {
    var st = factories.floatingActionButtonSmall(child.map(WidgetI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget FloatingActionButton");
    return new FloatingActionButton(st);
  }
  public static FloatingActionButtonSmallBuilder small() {
    return FloatingActionButtonSmallBuilder.floatingActionButtonSmall();
  }
  @Builder.Factory
  static FloatingActionButton floatingActionButtonLarge(Optional<WidgetI> child, Optional<String> tooltip, Optional<ColorI> foregroundColor, Optional<ColorI> backgroundColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> splashColor, Optional<NativeObj.I> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> enableFeedback) {
    var st = factories.floatingActionButtonLarge(child.map(WidgetI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget FloatingActionButton");
    return new FloatingActionButton(st);
  }
  public static FloatingActionButtonLargeBuilder large() {
    return FloatingActionButtonLargeBuilder.floatingActionButtonLarge();
  }
  @Builder.Factory
  static FloatingActionButton floatingActionButtonExtended(Optional<String> tooltip, Optional<ColorI> foregroundColor, Optional<ColorI> backgroundColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<NativeObj.I> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, Optional<ColorI> splashColor, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Runnable onPressed, Optional<Boolean> isExtended, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, OptionalDouble extendedIconLabelSpacing, Optional<EdgeInsetsGeometryI> extendedPadding, Optional<TextStyleI> extendedTextStyle, Optional<WidgetI> icon, WidgetI label, Optional<Boolean> enableFeedback) {
    var st = factories.floatingActionButtonExtended(tooltip,
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
      extendedPadding.map(EdgeInsetsGeometryI::build),
      extendedTextStyle.map(TextStyleI::build),
      icon.map(WidgetI::build),
      label.build(),
      enableFeedback);
    if (st == null) throw new RuntimeException("Failed to created widget FloatingActionButton");
    return new FloatingActionButton(st);
  }
  public static FloatingActionButtonExtendedBuilder extended() {
    return FloatingActionButtonExtendedBuilder.floatingActionButtonExtended();
  }
  public Widget child() {
    return new Widget(FloatingActionButtonObjSt.child(st)) {};
  }
  public String tooltip() {
    return FloatingActionButtonObjSt.tooltip(st).getString(0);
  }
  public Color foregroundColor() {
    return new Color(FloatingActionButtonObjSt.foregroundColor(st));
  }
  public Color backgroundColor() {
    return new Color(FloatingActionButtonObjSt.backgroundColor(st));
  }
  public Color focusColor() {
    return new Color(FloatingActionButtonObjSt.focusColor(st));
  }
  public Color hoverColor() {
    return new Color(FloatingActionButtonObjSt.hoverColor(st));
  }
  public Color splashColor() {
    return new Color(FloatingActionButtonObjSt.splashColor(st));
  }
  public double elevation() {
    return FloatingActionButtonObjSt.elevation(st);
  }
  public double focusElevation() {
    return FloatingActionButtonObjSt.focusElevation(st);
  }
  public double hoverElevation() {
    return FloatingActionButtonObjSt.hoverElevation(st);
  }
  public double highlightElevation() {
    return FloatingActionButtonObjSt.highlightElevation(st);
  }
  public double disabledElevation() {
    return FloatingActionButtonObjSt.disabledElevation(st);
  }
  public boolean mini() {
    return intToBool(FloatingActionButtonObjSt.mini(st));
  }
  public Clip clipBehavior() {
    return Clip.values()[FloatingActionButtonObjSt.clipBehavior(st)];
  }
  public boolean isExtended() {
    return intToBool(FloatingActionButtonObjSt.isExtended(st));
  }
  public boolean autofocus() {
    return intToBool(FloatingActionButtonObjSt.autofocus(st));
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    return MaterialTapTargetSize.values()[FloatingActionButtonObjSt.materialTapTargetSize(st)];
  }
  public boolean enableFeedback() {
    return intToBool(FloatingActionButtonObjSt.enableFeedback(st));
  }
  public double extendedIconLabelSpacing() {
    return FloatingActionButtonObjSt.extendedIconLabelSpacing(st);
  }
  public EdgeInsetsGeometry extendedPadding() {
    return new EdgeInsetsGeometry(FloatingActionButtonObjSt.extendedPadding(st)) {};
  }
  public TextStyle extendedTextStyle() {
    return new TextStyle(FloatingActionButtonObjSt.extendedTextStyle(st));
  }
  @Override
  public FloatingActionButton build() {
    return this;
  }
}
