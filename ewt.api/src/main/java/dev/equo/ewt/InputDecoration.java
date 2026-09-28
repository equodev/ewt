package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class InputDecoration extends NativeObj.Base implements InputDecorationI {
  protected InputDecoration() {}
  InputDecoration(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget InputDecoration");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static InputDecoration inputDecorationInputDecoration(Optional<WidgetI> icon, Optional<ColorI> iconColor, Optional<WidgetI> label, Optional<String> labelText, Optional<TextStyleI> labelStyle, Optional<TextStyleI> floatingLabelStyle, Optional<WidgetI> helper, Optional<String> helperText, Optional<TextStyleI> helperStyle, OptionalInt helperMaxLines, Optional<String> hintText, Optional<WidgetI> hint, Optional<TextStyleI> hintStyle, Optional<TextDirection> hintTextDirection, OptionalInt hintMaxLines, Optional<DurationI> hintFadeDuration, Optional<Boolean> maintainHintHeight, Optional<Boolean> maintainHintSize, Optional<Boolean> maintainLabelSize, Optional<WidgetI> error, Optional<String> errorText, Optional<TextStyleI> errorStyle, OptionalInt errorMaxLines, Optional<FloatingLabelBehavior> floatingLabelBehavior, Optional<Boolean> isCollapsed, Optional<Boolean> isDense, Optional<EdgeInsetsGeometryI> contentPadding, Optional<WidgetI> prefixIcon, Optional<BoxConstraintsI> prefixIconConstraints, Optional<WidgetI> prefix, Optional<String> prefixText, Optional<TextStyleI> prefixStyle, Optional<ColorI> prefixIconColor, Optional<WidgetI> suffixIcon, Optional<WidgetI> suffix, Optional<String> suffixText, Optional<TextStyleI> suffixStyle, Optional<ColorI> suffixIconColor, Optional<BoxConstraintsI> suffixIconConstraints, Optional<WidgetI> counter, Optional<String> counterText, Optional<TextStyleI> counterStyle, Optional<Boolean> filled, Optional<ColorI> fillColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<InputBorderI> errorBorder, Optional<InputBorderI> focusedBorder, Optional<InputBorderI> focusedErrorBorder, Optional<InputBorderI> disabledBorder, Optional<InputBorderI> enabledBorder, Optional<InputBorderI> border, Optional<Boolean> enabled, Optional<String> semanticCounterText, Optional<Boolean> alignLabelWithHint, Optional<BoxConstraintsI> constraints, Optional<VisualDensityI> visualDensity) {
    int id = factories.inputDecorationInputDecoration(icon.map(WidgetI::build),
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
      maintainLabelSize,
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
    if (id <= 0) throw new RuntimeException("Failed to created widget InputDecoration");
    return new InputDecoration(id);
  }
  public static InputDecorationInputDecorationBuilder inputDecoration() {
    return InputDecorationInputDecorationBuilder.inputDecorationInputDecoration();
  }
  @Builder.Factory
  static InputDecoration inputDecorationCollapsed(Optional<String> hintText, Optional<FloatingLabelBehavior> floatingLabelBehavior, Optional<TextStyleI> hintStyle, Optional<WidgetI> hint, Optional<TextDirection> hintTextDirection, OptionalInt hintMaxLines, Optional<DurationI> hintFadeDuration, Optional<Boolean> maintainHintHeight, Optional<Boolean> maintainHintSize, Optional<Boolean> maintainLabelSize, Optional<Boolean> filled, Optional<ColorI> fillColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<InputBorderI> border, Optional<Boolean> enabled, Optional<BoxConstraintsI> constraints) {
    int id = factories.inputDecorationCollapsed(hintText,
      floatingLabelBehavior,
      hintStyle.map(TextStyleI::build),
      hint.map(WidgetI::build),
      hintTextDirection,
      hintMaxLines,
      hintFadeDuration.map(DurationI::build),
      maintainHintHeight,
      maintainHintSize,
      maintainLabelSize,
      filled,
      fillColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      border.map(InputBorderI::build),
      enabled,
      constraints.map(BoxConstraintsI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget InputDecoration");
    return new InputDecoration(id);
  }
  public static InputDecorationCollapsedBuilder collapsed() {
    return InputDecorationCollapsedBuilder.inputDecorationCollapsed();
  }
  public Widget icon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationIcon not supported on web");
    return factories.InputDecoration_readBack_icon(nativeStruct);
  }
  public Color iconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationIconColor", getId());
      return new Color(__nid);
    }
    return factories.InputDecoration_readBack_iconColor(nativeStruct);
  }
  public Widget label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationLabel not supported on web");
    return factories.InputDecoration_readBack_label(nativeStruct);
  }
  public String labelText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationLabelText not supported on web");
    return factories.InputDecoration_readBack_labelText(nativeStruct);
  }
  public TextStyle labelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationLabelStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.InputDecoration_readBack_labelStyle(nativeStruct);
  }
  public TextStyle floatingLabelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationFloatingLabelStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.InputDecoration_readBack_floatingLabelStyle(nativeStruct);
  }
  public Widget helper() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationHelper not supported on web");
    return factories.InputDecoration_readBack_helper(nativeStruct);
  }
  public String helperText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationHelperText not supported on web");
    return factories.InputDecoration_readBack_helperText(nativeStruct);
  }
  public TextStyle helperStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationHelperStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.InputDecoration_readBack_helperStyle(nativeStruct);
  }
  public int helperMaxLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationHelperMaxLines not supported on web");
    return factories.InputDecoration_readBack_helperMaxLines(nativeStruct);
  }
  public String hintText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationHintText not supported on web");
    return factories.InputDecoration_readBack_hintText(nativeStruct);
  }
  public Widget hint() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationHint not supported on web");
    return factories.InputDecoration_readBack_hint(nativeStruct);
  }
  public TextStyle hintStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationHintStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.InputDecoration_readBack_hintStyle(nativeStruct);
  }
  public TextDirection hintTextDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationHintTextDirection not supported on web");
    return factories.InputDecoration_readBack_hintTextDirection(nativeStruct);
  }
  public int hintMaxLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationHintMaxLines not supported on web");
    return factories.InputDecoration_readBack_hintMaxLines(nativeStruct);
  }
  public Duration hintFadeDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationHintFadeDuration", getId());
      return new Duration(__nid);
    }
    return factories.InputDecoration_readBack_hintFadeDuration(nativeStruct);
  }
  public boolean maintainHintHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationMaintainHintHeight not supported on web");
    return factories.InputDecoration_readBack_maintainHintHeight(nativeStruct);
  }
  public boolean maintainHintSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationMaintainHintSize not supported on web");
    return factories.InputDecoration_readBack_maintainHintSize(nativeStruct);
  }
  public boolean maintainLabelSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationMaintainLabelSize not supported on web");
    return factories.InputDecoration_readBack_maintainLabelSize(nativeStruct);
  }
  public Widget error() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationError not supported on web");
    return factories.InputDecoration_readBack_error(nativeStruct);
  }
  public String errorText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationErrorText not supported on web");
    return factories.InputDecoration_readBack_errorText(nativeStruct);
  }
  public TextStyle errorStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationErrorStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.InputDecoration_readBack_errorStyle(nativeStruct);
  }
  public int errorMaxLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationErrorMaxLines not supported on web");
    return factories.InputDecoration_readBack_errorMaxLines(nativeStruct);
  }
  public FloatingLabelBehavior floatingLabelBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationFloatingLabelBehavior not supported on web");
    return factories.InputDecoration_readBack_floatingLabelBehavior(nativeStruct);
  }
  public boolean isDense() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationIsDense not supported on web");
    return factories.InputDecoration_readBack_isDense(nativeStruct);
  }
  public EdgeInsetsGeometry contentPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationContentPadding not supported on web");
    return factories.InputDecoration_readBack_contentPadding(nativeStruct);
  }
  public boolean isCollapsed() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationIsCollapsed not supported on web");
    return factories.InputDecoration_readBack_isCollapsed(nativeStruct);
  }
  public Widget prefixIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationPrefixIcon not supported on web");
    return factories.InputDecoration_readBack_prefixIcon(nativeStruct);
  }
  public BoxConstraints prefixIconConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationPrefixIconConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.InputDecoration_readBack_prefixIconConstraints(nativeStruct);
  }
  public Widget prefix() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationPrefix not supported on web");
    return factories.InputDecoration_readBack_prefix(nativeStruct);
  }
  public String prefixText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationPrefixText not supported on web");
    return factories.InputDecoration_readBack_prefixText(nativeStruct);
  }
  public TextStyle prefixStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationPrefixStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.InputDecoration_readBack_prefixStyle(nativeStruct);
  }
  public Color prefixIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationPrefixIconColor", getId());
      return new Color(__nid);
    }
    return factories.InputDecoration_readBack_prefixIconColor(nativeStruct);
  }
  public Widget suffixIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationSuffixIcon not supported on web");
    return factories.InputDecoration_readBack_suffixIcon(nativeStruct);
  }
  public Widget suffix() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationSuffix not supported on web");
    return factories.InputDecoration_readBack_suffix(nativeStruct);
  }
  public String suffixText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationSuffixText not supported on web");
    return factories.InputDecoration_readBack_suffixText(nativeStruct);
  }
  public TextStyle suffixStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationSuffixStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.InputDecoration_readBack_suffixStyle(nativeStruct);
  }
  public Color suffixIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationSuffixIconColor", getId());
      return new Color(__nid);
    }
    return factories.InputDecoration_readBack_suffixIconColor(nativeStruct);
  }
  public BoxConstraints suffixIconConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationSuffixIconConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.InputDecoration_readBack_suffixIconConstraints(nativeStruct);
  }
  public String counterText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationCounterText not supported on web");
    return factories.InputDecoration_readBack_counterText(nativeStruct);
  }
  public Widget counter() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationCounter not supported on web");
    return factories.InputDecoration_readBack_counter(nativeStruct);
  }
  public TextStyle counterStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationCounterStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.InputDecoration_readBack_counterStyle(nativeStruct);
  }
  public boolean filled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationFilled not supported on web");
    return factories.InputDecoration_readBack_filled(nativeStruct);
  }
  public Color fillColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationFillColor", getId());
      return new Color(__nid);
    }
    return factories.InputDecoration_readBack_fillColor(nativeStruct);
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationFocusColor", getId());
      return new Color(__nid);
    }
    return factories.InputDecoration_readBack_focusColor(nativeStruct);
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationHoverColor", getId());
      return new Color(__nid);
    }
    return factories.InputDecoration_readBack_hoverColor(nativeStruct);
  }
  public InputBorder errorBorder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationErrorBorder not supported on web");
    return factories.InputDecoration_readBack_errorBorder(nativeStruct);
  }
  public InputBorder focusedBorder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationFocusedBorder not supported on web");
    return factories.InputDecoration_readBack_focusedBorder(nativeStruct);
  }
  public InputBorder focusedErrorBorder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationFocusedErrorBorder not supported on web");
    return factories.InputDecoration_readBack_focusedErrorBorder(nativeStruct);
  }
  public InputBorder disabledBorder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationDisabledBorder not supported on web");
    return factories.InputDecoration_readBack_disabledBorder(nativeStruct);
  }
  public InputBorder enabledBorder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationEnabledBorder not supported on web");
    return factories.InputDecoration_readBack_enabledBorder(nativeStruct);
  }
  public InputBorder border() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationBorder not supported on web");
    return factories.InputDecoration_readBack_border(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationEnabled not supported on web");
    return factories.InputDecoration_readBack_enabled(nativeStruct);
  }
  public String semanticCounterText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationSemanticCounterText not supported on web");
    return factories.InputDecoration_readBack_semanticCounterText(nativeStruct);
  }
  public boolean alignLabelWithHint() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecorationAlignLabelWithHint not supported on web");
    return factories.InputDecoration_readBack_alignLabelWithHint(nativeStruct);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.InputDecoration_readBack_constraints(nativeStruct);
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecorationVisualDensity", getId());
      return new VisualDensity(__nid);
    }
    return factories.InputDecoration_readBack_visualDensity(nativeStruct);
  }
  @Override
  public InputDecoration build() {
    return this;
  }
}
