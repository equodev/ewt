package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoTextField extends StatefulWidget implements CupertinoTextFieldI {
  protected CupertinoTextField() {}
  CupertinoTextField(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoTextField");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoTextField cupertinoTextFieldCupertinoTextField(Optional<NativeObj.I> groupId, Optional<BoxDecorationI> decoration, Optional<EdgeInsetsGeometryI> padding, Optional<String> placeholder, Optional<TextStyleI> placeholderStyle, Optional<WidgetI> prefix, Optional<OverlayVisibilityMode> prefixMode, Optional<WidgetI> suffix, Optional<OverlayVisibilityMode> suffixMode, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<OverlayVisibilityMode> clearButtonMode, Optional<String> clearButtonSemanticLabel, Optional<TextInputAction> textInputAction, Optional<TextCapitalization> textCapitalization, Optional<TextStyleI> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> readOnly, Optional<Boolean> showCursor, Optional<Boolean> autofocus, Optional<String> obscuringCharacter, Optional<Boolean> obscureText, Optional<Boolean> autocorrect, Optional<SmartDashesType> smartDashesType, Optional<SmartQuotesType> smartQuotesType, Optional<Boolean> enableSuggestions, OptionalInt maxLines, OptionalInt minLines, Optional<Boolean> expands, OptionalInt maxLength, Optional<MaxLengthEnforcement> maxLengthEnforcement, Optional<Consumer<String>> onChanged, Optional<Runnable> onEditingComplete, Optional<Consumer<String>> onSubmitted, Optional<Consumer<PointerDownEvent>> onTapOutside, Optional<Consumer<PointerDownEvent>> onTapUpOutside, Optional<Boolean> enabled, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<RadiusI> cursorRadius, Optional<Boolean> cursorOpacityAnimates, Optional<ColorI> cursorColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<Brightness> keyboardAppearance, Optional<EdgeInsetsI> scrollPadding, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Boolean> selectAllOnFocus, Optional<Runnable> onTap, Optional<List<String>> autofillHints, Optional<Clip> clipBehavior, Optional<String> restorationId, Optional<Boolean> scribbleEnabled, Optional<Boolean> stylusHandwritingEnabled, Optional<Boolean> enableIMEPersonalizedLearning, Optional<Boolean> enableInlinePrediction) {
    int id = factories.cupertinoTextFieldCupertinoTextField(groupId.map(NativeObj.I::build),
      decoration.map(BoxDecorationI::build),
      padding.map(EdgeInsetsGeometryI::build),
      placeholder,
      placeholderStyle.map(TextStyleI::build),
      prefix.map(WidgetI::build),
      prefixMode,
      suffix.map(WidgetI::build),
      suffixMode,
      crossAxisAlignment,
      clearButtonMode,
      clearButtonSemanticLabel,
      textInputAction,
      textCapitalization,
      style.map(TextStyleI::build),
      textAlign,
      textDirection,
      readOnly,
      showCursor,
      autofocus,
      obscuringCharacter,
      obscureText,
      autocorrect,
      smartDashesType,
      smartQuotesType,
      enableSuggestions,
      maxLines,
      minLines,
      expands,
      maxLength,
      maxLengthEnforcement,
      onChanged,
      onEditingComplete,
      onSubmitted,
      onTapOutside,
      onTapUpOutside,
      enabled,
      cursorWidth,
      cursorHeight,
      cursorRadius.map(RadiusI::build),
      cursorOpacityAnimates,
      cursorColor.map(ColorI::build),
      selectionHeightStyle,
      selectionWidthStyle,
      keyboardAppearance,
      scrollPadding.map(EdgeInsetsI::build),
      dragStartBehavior,
      enableInteractiveSelection,
      selectAllOnFocus,
      onTap,
      autofillHints,
      clipBehavior,
      restorationId,
      scribbleEnabled,
      stylusHandwritingEnabled,
      enableIMEPersonalizedLearning,
      enableInlinePrediction);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoTextField");
    return new CupertinoTextField(id);
  }
  public static CupertinoTextFieldCupertinoTextFieldBuilder cupertinoTextField() {
    return CupertinoTextFieldCupertinoTextFieldBuilder.cupertinoTextFieldCupertinoTextField();
  }
  @Builder.Factory
  static CupertinoTextField cupertinoTextFieldBorderless(Optional<NativeObj.I> groupId, Optional<BoxDecorationI> decoration, Optional<EdgeInsetsGeometryI> padding, Optional<String> placeholder, Optional<TextStyleI> placeholderStyle, Optional<WidgetI> prefix, Optional<OverlayVisibilityMode> prefixMode, Optional<WidgetI> suffix, Optional<OverlayVisibilityMode> suffixMode, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<OverlayVisibilityMode> clearButtonMode, Optional<String> clearButtonSemanticLabel, Optional<TextInputAction> textInputAction, Optional<TextCapitalization> textCapitalization, Optional<TextStyleI> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> readOnly, Optional<Boolean> showCursor, Optional<Boolean> autofocus, Optional<String> obscuringCharacter, Optional<Boolean> obscureText, Optional<Boolean> autocorrect, Optional<SmartDashesType> smartDashesType, Optional<SmartQuotesType> smartQuotesType, Optional<Boolean> enableSuggestions, OptionalInt maxLines, OptionalInt minLines, Optional<Boolean> expands, OptionalInt maxLength, Optional<MaxLengthEnforcement> maxLengthEnforcement, Optional<Consumer<String>> onChanged, Optional<Runnable> onEditingComplete, Optional<Consumer<String>> onSubmitted, Optional<Consumer<PointerDownEvent>> onTapOutside, Optional<Consumer<PointerDownEvent>> onTapUpOutside, Optional<Boolean> enabled, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<RadiusI> cursorRadius, Optional<Boolean> cursorOpacityAnimates, Optional<ColorI> cursorColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<Brightness> keyboardAppearance, Optional<EdgeInsetsI> scrollPadding, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Boolean> selectAllOnFocus, Optional<Runnable> onTap, Optional<List<String>> autofillHints, Optional<Clip> clipBehavior, Optional<String> restorationId, Optional<Boolean> scribbleEnabled, Optional<Boolean> stylusHandwritingEnabled, Optional<Boolean> enableIMEPersonalizedLearning, Optional<Boolean> enableInlinePrediction) {
    int id = factories.cupertinoTextFieldBorderless(groupId.map(NativeObj.I::build),
      decoration.map(BoxDecorationI::build),
      padding.map(EdgeInsetsGeometryI::build),
      placeholder,
      placeholderStyle.map(TextStyleI::build),
      prefix.map(WidgetI::build),
      prefixMode,
      suffix.map(WidgetI::build),
      suffixMode,
      crossAxisAlignment,
      clearButtonMode,
      clearButtonSemanticLabel,
      textInputAction,
      textCapitalization,
      style.map(TextStyleI::build),
      textAlign,
      textDirection,
      readOnly,
      showCursor,
      autofocus,
      obscuringCharacter,
      obscureText,
      autocorrect,
      smartDashesType,
      smartQuotesType,
      enableSuggestions,
      maxLines,
      minLines,
      expands,
      maxLength,
      maxLengthEnforcement,
      onChanged,
      onEditingComplete,
      onSubmitted,
      onTapOutside,
      onTapUpOutside,
      enabled,
      cursorWidth,
      cursorHeight,
      cursorRadius.map(RadiusI::build),
      cursorOpacityAnimates,
      cursorColor.map(ColorI::build),
      selectionHeightStyle,
      selectionWidthStyle,
      keyboardAppearance,
      scrollPadding.map(EdgeInsetsI::build),
      dragStartBehavior,
      enableInteractiveSelection,
      selectAllOnFocus,
      onTap,
      autofillHints,
      clipBehavior,
      restorationId,
      scribbleEnabled,
      stylusHandwritingEnabled,
      enableIMEPersonalizedLearning,
      enableInlinePrediction);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoTextField");
    return new CupertinoTextField(id);
  }
  public static CupertinoTextFieldBorderlessBuilder borderless() {
    return CupertinoTextFieldBorderlessBuilder.cupertinoTextFieldBorderless();
  }
  public BoxDecoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextFieldDecoration", getId());
      return new BoxDecoration(__nid);
    }
    return factories.CupertinoTextField_readBack_decoration(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldPadding not supported on web");
    return factories.CupertinoTextField_readBack_padding(nativeStruct);
  }
  public String placeholder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldPlaceholder not supported on web");
    return factories.CupertinoTextField_readBack_placeholder(nativeStruct);
  }
  public TextStyle placeholderStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextFieldPlaceholderStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.CupertinoTextField_readBack_placeholderStyle(nativeStruct);
  }
  public Widget prefix() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldPrefix not supported on web");
    return factories.CupertinoTextField_readBack_prefix(nativeStruct);
  }
  public OverlayVisibilityMode prefixMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldPrefixMode not supported on web");
    return factories.CupertinoTextField_readBack_prefixMode(nativeStruct);
  }
  public Widget suffix() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldSuffix not supported on web");
    return factories.CupertinoTextField_readBack_suffix(nativeStruct);
  }
  public OverlayVisibilityMode suffixMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldSuffixMode not supported on web");
    return factories.CupertinoTextField_readBack_suffixMode(nativeStruct);
  }
  public CrossAxisAlignment crossAxisAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldCrossAxisAlignment not supported on web");
    return factories.CupertinoTextField_readBack_crossAxisAlignment(nativeStruct);
  }
  public OverlayVisibilityMode clearButtonMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldClearButtonMode not supported on web");
    return factories.CupertinoTextField_readBack_clearButtonMode(nativeStruct);
  }
  public String clearButtonSemanticLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldClearButtonSemanticLabel not supported on web");
    return factories.CupertinoTextField_readBack_clearButtonSemanticLabel(nativeStruct);
  }
  public TextInputAction textInputAction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldTextInputAction not supported on web");
    return factories.CupertinoTextField_readBack_textInputAction(nativeStruct);
  }
  public TextCapitalization textCapitalization() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldTextCapitalization not supported on web");
    return factories.CupertinoTextField_readBack_textCapitalization(nativeStruct);
  }
  public TextStyle style() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextFieldStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.CupertinoTextField_readBack_style(nativeStruct);
  }
  public TextAlign textAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldTextAlign not supported on web");
    return factories.CupertinoTextField_readBack_textAlign(nativeStruct);
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldTextDirection not supported on web");
    return factories.CupertinoTextField_readBack_textDirection(nativeStruct);
  }
  public boolean readOnly() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldReadOnly not supported on web");
    return factories.CupertinoTextField_readBack_readOnly(nativeStruct);
  }
  public boolean showCursor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldShowCursor not supported on web");
    return factories.CupertinoTextField_readBack_showCursor(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldAutofocus not supported on web");
    return factories.CupertinoTextField_readBack_autofocus(nativeStruct);
  }
  public String obscuringCharacter() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldObscuringCharacter not supported on web");
    return factories.CupertinoTextField_readBack_obscuringCharacter(nativeStruct);
  }
  public boolean obscureText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldObscureText not supported on web");
    return factories.CupertinoTextField_readBack_obscureText(nativeStruct);
  }
  public boolean autocorrect() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldAutocorrect not supported on web");
    return factories.CupertinoTextField_readBack_autocorrect(nativeStruct);
  }
  public SmartDashesType smartDashesType() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldSmartDashesType not supported on web");
    return factories.CupertinoTextField_readBack_smartDashesType(nativeStruct);
  }
  public SmartQuotesType smartQuotesType() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldSmartQuotesType not supported on web");
    return factories.CupertinoTextField_readBack_smartQuotesType(nativeStruct);
  }
  public boolean enableSuggestions() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldEnableSuggestions not supported on web");
    return factories.CupertinoTextField_readBack_enableSuggestions(nativeStruct);
  }
  public int maxLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldMaxLines not supported on web");
    return factories.CupertinoTextField_readBack_maxLines(nativeStruct);
  }
  public int minLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldMinLines not supported on web");
    return factories.CupertinoTextField_readBack_minLines(nativeStruct);
  }
  public boolean expands() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldExpands not supported on web");
    return factories.CupertinoTextField_readBack_expands(nativeStruct);
  }
  public int maxLength() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldMaxLength not supported on web");
    return factories.CupertinoTextField_readBack_maxLength(nativeStruct);
  }
  public MaxLengthEnforcement maxLengthEnforcement() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldMaxLengthEnforcement not supported on web");
    return factories.CupertinoTextField_readBack_maxLengthEnforcement(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldEnabled not supported on web");
    return factories.CupertinoTextField_readBack_enabled(nativeStruct);
  }
  public double cursorWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldCursorWidth not supported on web");
    return factories.CupertinoTextField_readBack_cursorWidth(nativeStruct);
  }
  public double cursorHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldCursorHeight not supported on web");
    return factories.CupertinoTextField_readBack_cursorHeight(nativeStruct);
  }
  public Radius cursorRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextFieldCursorRadius", getId());
      return new Radius(__nid);
    }
    return factories.CupertinoTextField_readBack_cursorRadius(nativeStruct);
  }
  public boolean cursorOpacityAnimates() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldCursorOpacityAnimates not supported on web");
    return factories.CupertinoTextField_readBack_cursorOpacityAnimates(nativeStruct);
  }
  public Color cursorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextFieldCursorColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoTextField_readBack_cursorColor(nativeStruct);
  }
  public BoxHeightStyle selectionHeightStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldSelectionHeightStyle not supported on web");
    return factories.CupertinoTextField_readBack_selectionHeightStyle(nativeStruct);
  }
  public BoxWidthStyle selectionWidthStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldSelectionWidthStyle not supported on web");
    return factories.CupertinoTextField_readBack_selectionWidthStyle(nativeStruct);
  }
  public Brightness keyboardAppearance() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldKeyboardAppearance not supported on web");
    return factories.CupertinoTextField_readBack_keyboardAppearance(nativeStruct);
  }
  public EdgeInsets scrollPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextFieldScrollPadding", getId());
      return new EdgeInsets(__nid);
    }
    return factories.CupertinoTextField_readBack_scrollPadding(nativeStruct);
  }
  public boolean enableInteractiveSelection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldEnableInteractiveSelection not supported on web");
    return factories.CupertinoTextField_readBack_enableInteractiveSelection(nativeStruct);
  }
  public boolean selectAllOnFocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldSelectAllOnFocus not supported on web");
    return factories.CupertinoTextField_readBack_selectAllOnFocus(nativeStruct);
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldDragStartBehavior not supported on web");
    return factories.CupertinoTextField_readBack_dragStartBehavior(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldClipBehavior not supported on web");
    return factories.CupertinoTextField_readBack_clipBehavior(nativeStruct);
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldRestorationId not supported on web");
    return factories.CupertinoTextField_readBack_restorationId(nativeStruct);
  }
  public boolean scribbleEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldScribbleEnabled not supported on web");
    return factories.CupertinoTextField_readBack_scribbleEnabled(nativeStruct);
  }
  public boolean stylusHandwritingEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldStylusHandwritingEnabled not supported on web");
    return factories.CupertinoTextField_readBack_stylusHandwritingEnabled(nativeStruct);
  }
  public boolean enableIMEPersonalizedLearning() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldEnableIMEPersonalizedLearning not supported on web");
    return factories.CupertinoTextField_readBack_enableIMEPersonalizedLearning(nativeStruct);
  }
  public boolean enableInlinePrediction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldEnableInlinePrediction not supported on web");
    return factories.CupertinoTextField_readBack_enableInlinePrediction(nativeStruct);
  }
  public boolean selectionEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldSelectionEnabled not supported on web");
    return factories.CupertinoTextField_readBack_selectionEnabled(nativeStruct);
  }
  public static Color kMisspelledSelectionColor() {
    return Color.color(0x62ff9699).build();
  }
  @Override
  public CupertinoTextField build() {
    return this;
  }
}
