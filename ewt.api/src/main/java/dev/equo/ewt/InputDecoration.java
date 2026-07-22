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
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationIcon not supported on web");
    return new Widget(InputDecorationObjSt.icon(st)) {};
  }
  public Color iconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationIconColor", getId());
      return new Color(__nid);
    }
    return new Color(InputDecorationObjSt.iconColor(st));
  }
  public Widget label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationLabel not supported on web");
    return new Widget(InputDecorationObjSt.label(st)) {};
  }
  public String labelText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationLabelText not supported on web");
    return InputDecorationObjSt.labelText(st).getString(0);
  }
  public TextStyle labelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationLabelStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(InputDecorationObjSt.labelStyle(st));
  }
  public TextStyle floatingLabelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationFloatingLabelStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(InputDecorationObjSt.floatingLabelStyle(st));
  }
  public Widget helper() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationHelper not supported on web");
    return new Widget(InputDecorationObjSt.helper(st)) {};
  }
  public String helperText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationHelperText not supported on web");
    return InputDecorationObjSt.helperText(st).getString(0);
  }
  public TextStyle helperStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationHelperStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(InputDecorationObjSt.helperStyle(st));
  }
  public int helperMaxLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationHelperMaxLines not supported on web");
    return InputDecorationObjSt.helperMaxLines(st);
  }
  public String hintText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationHintText not supported on web");
    return InputDecorationObjSt.hintText(st).getString(0);
  }
  public Widget hint() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationHint not supported on web");
    return new Widget(InputDecorationObjSt.hint(st)) {};
  }
  public TextStyle hintStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationHintStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(InputDecorationObjSt.hintStyle(st));
  }
  public TextDirection hintTextDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationHintTextDirection not supported on web");
    return TextDirection.values()[InputDecorationObjSt.hintTextDirection(st)];
  }
  public int hintMaxLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationHintMaxLines not supported on web");
    return InputDecorationObjSt.hintMaxLines(st);
  }
  public Duration hintFadeDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationHintFadeDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(InputDecorationObjSt.hintFadeDuration(st));
  }
  public boolean maintainHintHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationMaintainHintHeight not supported on web");
    return intToBool(InputDecorationObjSt.maintainHintHeight(st));
  }
  public boolean maintainHintSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationMaintainHintSize not supported on web");
    return intToBool(InputDecorationObjSt.maintainHintSize(st));
  }
  public Widget error() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationError not supported on web");
    return new Widget(InputDecorationObjSt.error(st)) {};
  }
  public String errorText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationErrorText not supported on web");
    return InputDecorationObjSt.errorText(st).getString(0);
  }
  public TextStyle errorStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationErrorStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(InputDecorationObjSt.errorStyle(st));
  }
  public int errorMaxLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationErrorMaxLines not supported on web");
    return InputDecorationObjSt.errorMaxLines(st);
  }
  public FloatingLabelBehavior floatingLabelBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationFloatingLabelBehavior not supported on web");
    return FloatingLabelBehavior.values()[InputDecorationObjSt.floatingLabelBehavior(st)];
  }
  public boolean isDense() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationIsDense not supported on web");
    return intToBool(InputDecorationObjSt.isDense(st));
  }
  public EdgeInsetsGeometry contentPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationContentPadding not supported on web");
    return new EdgeInsetsGeometry(InputDecorationObjSt.contentPadding(st)) {};
  }
  public boolean isCollapsed() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationIsCollapsed not supported on web");
    return intToBool(InputDecorationObjSt.isCollapsed(st));
  }
  public Widget prefixIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationPrefixIcon not supported on web");
    return new Widget(InputDecorationObjSt.prefixIcon(st)) {};
  }
  public BoxConstraints prefixIconConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationPrefixIconConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(InputDecorationObjSt.prefixIconConstraints(st));
  }
  public Widget prefix() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationPrefix not supported on web");
    return new Widget(InputDecorationObjSt.prefix(st)) {};
  }
  public String prefixText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationPrefixText not supported on web");
    return InputDecorationObjSt.prefixText(st).getString(0);
  }
  public TextStyle prefixStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationPrefixStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(InputDecorationObjSt.prefixStyle(st));
  }
  public Color prefixIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationPrefixIconColor", getId());
      return new Color(__nid);
    }
    return new Color(InputDecorationObjSt.prefixIconColor(st));
  }
  public Widget suffixIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationSuffixIcon not supported on web");
    return new Widget(InputDecorationObjSt.suffixIcon(st)) {};
  }
  public Widget suffix() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationSuffix not supported on web");
    return new Widget(InputDecorationObjSt.suffix(st)) {};
  }
  public String suffixText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationSuffixText not supported on web");
    return InputDecorationObjSt.suffixText(st).getString(0);
  }
  public TextStyle suffixStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationSuffixStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(InputDecorationObjSt.suffixStyle(st));
  }
  public Color suffixIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationSuffixIconColor", getId());
      return new Color(__nid);
    }
    return new Color(InputDecorationObjSt.suffixIconColor(st));
  }
  public BoxConstraints suffixIconConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationSuffixIconConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(InputDecorationObjSt.suffixIconConstraints(st));
  }
  public String counterText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationCounterText not supported on web");
    return InputDecorationObjSt.counterText(st).getString(0);
  }
  public Widget counter() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationCounter not supported on web");
    return new Widget(InputDecorationObjSt.counter(st)) {};
  }
  public TextStyle counterStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationCounterStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(InputDecorationObjSt.counterStyle(st));
  }
  public boolean filled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationFilled not supported on web");
    return intToBool(InputDecorationObjSt.filled(st));
  }
  public Color fillColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationFillColor", getId());
      return new Color(__nid);
    }
    return new Color(InputDecorationObjSt.fillColor(st));
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationFocusColor", getId());
      return new Color(__nid);
    }
    return new Color(InputDecorationObjSt.focusColor(st));
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationHoverColor", getId());
      return new Color(__nid);
    }
    return new Color(InputDecorationObjSt.hoverColor(st));
  }
  public InputBorder errorBorder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationErrorBorder not supported on web");
    return new InputBorder(InputDecorationObjSt.errorBorder(st)) {};
  }
  public InputBorder focusedBorder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationFocusedBorder not supported on web");
    return new InputBorder(InputDecorationObjSt.focusedBorder(st)) {};
  }
  public InputBorder focusedErrorBorder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationFocusedErrorBorder not supported on web");
    return new InputBorder(InputDecorationObjSt.focusedErrorBorder(st)) {};
  }
  public InputBorder disabledBorder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationDisabledBorder not supported on web");
    return new InputBorder(InputDecorationObjSt.disabledBorder(st)) {};
  }
  public InputBorder enabledBorder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationEnabledBorder not supported on web");
    return new InputBorder(InputDecorationObjSt.enabledBorder(st)) {};
  }
  public InputBorder border() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationBorder not supported on web");
    return new InputBorder(InputDecorationObjSt.border(st)) {};
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationEnabled not supported on web");
    return intToBool(InputDecorationObjSt.enabled(st));
  }
  public String semanticCounterText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationSemanticCounterText not supported on web");
    return InputDecorationObjSt.semanticCounterText(st).getString(0);
  }
  public boolean alignLabelWithHint() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationAlignLabelWithHint not supported on web");
    return intToBool(InputDecorationObjSt.alignLabelWithHint(st));
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(InputDecorationObjSt.constraints(st));
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationVisualDensity", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.VisualDensityObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.VisualDensityObjSt.id(__st, __nid);
      return new VisualDensity(__st);
    }
    return new VisualDensity(InputDecorationObjSt.visualDensity(st));
  }
  @Override
  public InputDecoration build() {
    return this;
  }
}
