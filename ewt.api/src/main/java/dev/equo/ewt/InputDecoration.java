package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.InputDecorationObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class InputDecoration extends NativeObj.Base implements InputDecorationI {
  private MemorySegment st;
  protected InputDecoration() {}
  InputDecoration(MemorySegment st) {
    this.id = InputDecorationObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget InputDecoration");
    System.out.println("New InputDecoration id:"+id);
  }
  @Builder.Factory
  static InputDecoration inputDecorationInputDecoration(Optional<WidgetI> icon, Optional<ColorI> iconColor, Optional<WidgetI> label, Optional<String> labelText, Optional<TextStyleI> labelStyle, Optional<TextStyleI> floatingLabelStyle, Optional<WidgetI> helper, Optional<String> helperText, Optional<TextStyleI> helperStyle, OptionalInt helperMaxLines, Optional<String> hintText, Optional<WidgetI> hint, Optional<TextStyleI> hintStyle, Optional<TextDirection> hintTextDirection, OptionalInt hintMaxLines, Optional<DurationI> hintFadeDuration, Optional<Boolean> maintainHintHeight, Optional<Boolean> maintainHintSize, Optional<WidgetI> error, Optional<String> errorText, Optional<TextStyleI> errorStyle, OptionalInt errorMaxLines, Optional<FloatingLabelBehavior> floatingLabelBehavior, Optional<Boolean> isCollapsed, Optional<Boolean> isDense, Optional<EdgeInsetsGeometryI> contentPadding, Optional<WidgetI> prefixIcon, Optional<BoxConstraintsI> prefixIconConstraints, Optional<WidgetI> prefix, Optional<String> prefixText, Optional<TextStyleI> prefixStyle, Optional<ColorI> prefixIconColor, Optional<WidgetI> suffixIcon, Optional<WidgetI> suffix, Optional<String> suffixText, Optional<TextStyleI> suffixStyle, Optional<ColorI> suffixIconColor, Optional<BoxConstraintsI> suffixIconConstraints, Optional<WidgetI> counter, Optional<String> counterText, Optional<TextStyleI> counterStyle, Optional<Boolean> filled, Optional<ColorI> fillColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<InputBorderI> errorBorder, Optional<InputBorderI> focusedBorder, Optional<InputBorderI> focusedErrorBorder, Optional<InputBorderI> disabledBorder, Optional<InputBorderI> enabledBorder, Optional<InputBorderI> border, Optional<Boolean> enabled, Optional<String> semanticCounterText, Optional<Boolean> alignLabelWithHint, Optional<BoxConstraintsI> constraints, Optional<VisualDensityI> visualDensity) {
    var st = factories.inputDecorationInputDecoration(icon.map(WidgetI::build),
      iconColor.map(ColorI::build),
      label.map(WidgetI::build),
      labelText,
      labelStyle.map(TextStyleI::build),
      floatingLabelStyle.map(TextStyleI::build),
      helper.map(WidgetI::build),
      helperText,
      helperStyle.map(TextStyleI::build),
      helperMaxLines,
      hintText,
      hint.map(WidgetI::build),
      hintStyle.map(TextStyleI::build),
      hintTextDirection,
      hintMaxLines,
      hintFadeDuration.map(DurationI::build),
      maintainHintHeight,
      maintainHintSize,
      error.map(WidgetI::build),
      errorText,
      errorStyle.map(TextStyleI::build),
      errorMaxLines,
      floatingLabelBehavior,
      isCollapsed,
      isDense,
      contentPadding.map(EdgeInsetsGeometryI::build),
      prefixIcon.map(WidgetI::build),
      prefixIconConstraints.map(BoxConstraintsI::build),
      prefix.map(WidgetI::build),
      prefixText,
      prefixStyle.map(TextStyleI::build),
      prefixIconColor.map(ColorI::build),
      suffixIcon.map(WidgetI::build),
      suffix.map(WidgetI::build),
      suffixText,
      suffixStyle.map(TextStyleI::build),
      suffixIconColor.map(ColorI::build),
      suffixIconConstraints.map(BoxConstraintsI::build),
      counter.map(WidgetI::build),
      counterText,
      counterStyle.map(TextStyleI::build),
      filled,
      fillColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      errorBorder.map(InputBorderI::build),
      focusedBorder.map(InputBorderI::build),
      focusedErrorBorder.map(InputBorderI::build),
      disabledBorder.map(InputBorderI::build),
      enabledBorder.map(InputBorderI::build),
      border.map(InputBorderI::build),
      enabled,
      semanticCounterText,
      alignLabelWithHint,
      constraints.map(BoxConstraintsI::build),
      visualDensity.map(VisualDensityI::build));
    if (st == null) throw new RuntimeException("Failed to created widget InputDecoration");
    return new InputDecoration(st);
  }
  public static InputDecorationInputDecorationBuilder inputDecoration() {
    return InputDecorationInputDecorationBuilder.inputDecorationInputDecoration();
  }
  @Builder.Factory
  static InputDecoration inputDecorationCollapsed(@Builder.Parameter String hintText, Optional<FloatingLabelBehavior> floatingLabelBehavior, Optional<TextStyleI> hintStyle, Optional<WidgetI> hint, Optional<TextDirection> hintTextDirection, OptionalInt hintMaxLines, Optional<DurationI> hintFadeDuration, Optional<Boolean> maintainHintHeight, Optional<Boolean> maintainHintSize, Optional<Boolean> filled, Optional<ColorI> fillColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<InputBorderI> border, Optional<Boolean> enabled, Optional<BoxConstraintsI> constraints) {
    var st = factories.inputDecorationCollapsed(hintText,
      floatingLabelBehavior,
      hintStyle.map(TextStyleI::build),
      hint.map(WidgetI::build),
      hintTextDirection,
      hintMaxLines,
      hintFadeDuration.map(DurationI::build),
      maintainHintHeight,
      maintainHintSize,
      filled,
      fillColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      border.map(InputBorderI::build),
      enabled,
      constraints.map(BoxConstraintsI::build));
    if (st == null) throw new RuntimeException("Failed to created widget InputDecoration");
    return new InputDecoration(st);
  }
  public static InputDecorationCollapsedBuilder collapsed(String hintText) {
    return InputDecorationCollapsedBuilder.inputDecorationCollapsed(hintText);
  }
  public Widget icon() {
    return new Widget(InputDecorationObjSt.icon(st)) {};
  }
  public Color iconColor() {
    return new Color(InputDecorationObjSt.iconColor(st));
  }
  public Widget label() {
    return new Widget(InputDecorationObjSt.label(st)) {};
  }
  public String labelText() {
    return InputDecorationObjSt.labelText(st).getString(0);
  }
  public TextStyle labelStyle() {
    return new TextStyle(InputDecorationObjSt.labelStyle(st));
  }
  public TextStyle floatingLabelStyle() {
    return new TextStyle(InputDecorationObjSt.floatingLabelStyle(st));
  }
  public Widget helper() {
    return new Widget(InputDecorationObjSt.helper(st)) {};
  }
  public String helperText() {
    return InputDecorationObjSt.helperText(st).getString(0);
  }
  public TextStyle helperStyle() {
    return new TextStyle(InputDecorationObjSt.helperStyle(st));
  }
  public int helperMaxLines() {
    return InputDecorationObjSt.helperMaxLines(st);
  }
  public String hintText() {
    return InputDecorationObjSt.hintText(st).getString(0);
  }
  public Widget hint() {
    return new Widget(InputDecorationObjSt.hint(st)) {};
  }
  public TextStyle hintStyle() {
    return new TextStyle(InputDecorationObjSt.hintStyle(st));
  }
  public TextDirection hintTextDirection() {
    return TextDirection.values()[InputDecorationObjSt.hintTextDirection(st)];
  }
  public int hintMaxLines() {
    return InputDecorationObjSt.hintMaxLines(st);
  }
  public Duration hintFadeDuration() {
    return new Duration(InputDecorationObjSt.hintFadeDuration(st));
  }
  public boolean maintainHintHeight() {
    return intToBool(InputDecorationObjSt.maintainHintHeight(st));
  }
  public boolean maintainHintSize() {
    return intToBool(InputDecorationObjSt.maintainHintSize(st));
  }
  public Widget error() {
    return new Widget(InputDecorationObjSt.error(st)) {};
  }
  public String errorText() {
    return InputDecorationObjSt.errorText(st).getString(0);
  }
  public TextStyle errorStyle() {
    return new TextStyle(InputDecorationObjSt.errorStyle(st));
  }
  public int errorMaxLines() {
    return InputDecorationObjSt.errorMaxLines(st);
  }
  public FloatingLabelBehavior floatingLabelBehavior() {
    return FloatingLabelBehavior.values()[InputDecorationObjSt.floatingLabelBehavior(st)];
  }
  public boolean isDense() {
    return intToBool(InputDecorationObjSt.isDense(st));
  }
  public EdgeInsetsGeometry contentPadding() {
    return new EdgeInsetsGeometry(InputDecorationObjSt.contentPadding(st)) {};
  }
  public boolean isCollapsed() {
    return intToBool(InputDecorationObjSt.isCollapsed(st));
  }
  public Widget prefixIcon() {
    return new Widget(InputDecorationObjSt.prefixIcon(st)) {};
  }
  public BoxConstraints prefixIconConstraints() {
    return new BoxConstraints(InputDecorationObjSt.prefixIconConstraints(st));
  }
  public Widget prefix() {
    return new Widget(InputDecorationObjSt.prefix(st)) {};
  }
  public String prefixText() {
    return InputDecorationObjSt.prefixText(st).getString(0);
  }
  public TextStyle prefixStyle() {
    return new TextStyle(InputDecorationObjSt.prefixStyle(st));
  }
  public Color prefixIconColor() {
    return new Color(InputDecorationObjSt.prefixIconColor(st));
  }
  public Widget suffixIcon() {
    return new Widget(InputDecorationObjSt.suffixIcon(st)) {};
  }
  public Widget suffix() {
    return new Widget(InputDecorationObjSt.suffix(st)) {};
  }
  public String suffixText() {
    return InputDecorationObjSt.suffixText(st).getString(0);
  }
  public TextStyle suffixStyle() {
    return new TextStyle(InputDecorationObjSt.suffixStyle(st));
  }
  public Color suffixIconColor() {
    return new Color(InputDecorationObjSt.suffixIconColor(st));
  }
  public BoxConstraints suffixIconConstraints() {
    return new BoxConstraints(InputDecorationObjSt.suffixIconConstraints(st));
  }
  public String counterText() {
    return InputDecorationObjSt.counterText(st).getString(0);
  }
  public Widget counter() {
    return new Widget(InputDecorationObjSt.counter(st)) {};
  }
  public TextStyle counterStyle() {
    return new TextStyle(InputDecorationObjSt.counterStyle(st));
  }
  public boolean filled() {
    return intToBool(InputDecorationObjSt.filled(st));
  }
  public Color fillColor() {
    return new Color(InputDecorationObjSt.fillColor(st));
  }
  public Color focusColor() {
    return new Color(InputDecorationObjSt.focusColor(st));
  }
  public Color hoverColor() {
    return new Color(InputDecorationObjSt.hoverColor(st));
  }
  public InputBorder errorBorder() {
    return new InputBorder(InputDecorationObjSt.errorBorder(st)) {};
  }
  public InputBorder focusedBorder() {
    return new InputBorder(InputDecorationObjSt.focusedBorder(st)) {};
  }
  public InputBorder focusedErrorBorder() {
    return new InputBorder(InputDecorationObjSt.focusedErrorBorder(st)) {};
  }
  public InputBorder disabledBorder() {
    return new InputBorder(InputDecorationObjSt.disabledBorder(st)) {};
  }
  public InputBorder enabledBorder() {
    return new InputBorder(InputDecorationObjSt.enabledBorder(st)) {};
  }
  public InputBorder border() {
    return new InputBorder(InputDecorationObjSt.border(st)) {};
  }
  public boolean enabled() {
    return intToBool(InputDecorationObjSt.enabled(st));
  }
  public String semanticCounterText() {
    return InputDecorationObjSt.semanticCounterText(st).getString(0);
  }
  public boolean alignLabelWithHint() {
    return intToBool(InputDecorationObjSt.alignLabelWithHint(st));
  }
  public BoxConstraints constraints() {
    return new BoxConstraints(InputDecorationObjSt.constraints(st));
  }
  public VisualDensity visualDensity() {
    return new VisualDensity(InputDecorationObjSt.visualDensity(st));
  }
  @Override
  public InputDecoration build() {
    return this;
  }
}
