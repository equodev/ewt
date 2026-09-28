package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TextField extends StatefulWidget implements TextFieldI {
  protected TextField() {}
  TextField(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TextField");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TextField textFieldTextField(Optional<NativeObj.I> groupId, Optional<InputDecorationI> decoration, Optional<TextInputAction> textInputAction, Optional<TextCapitalization> textCapitalization, Optional<TextStyleI> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> readOnly, Optional<Boolean> showCursor, Optional<Boolean> autofocus, Optional<String> obscuringCharacter, Optional<Boolean> obscureText, Optional<Boolean> autocorrect, Optional<SmartDashesType> smartDashesType, Optional<SmartQuotesType> smartQuotesType, Optional<Boolean> enableSuggestions, OptionalInt maxLines, OptionalInt minLines, Optional<Boolean> expands, OptionalInt maxLength, Optional<MaxLengthEnforcement> maxLengthEnforcement, Optional<Consumer<String>> onChanged, Optional<Runnable> onEditingComplete, Optional<Consumer<String>> onSubmitted, Optional<Boolean> enabled, Optional<Boolean> ignorePointers, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<RadiusI> cursorRadius, Optional<Boolean> cursorOpacityAnimates, Optional<ColorI> cursorColor, Optional<ColorI> cursorErrorColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<Brightness> keyboardAppearance, Optional<EdgeInsetsI> scrollPadding, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Boolean> selectAllOnFocus, Optional<Runnable> onTap, Optional<Boolean> onTapAlwaysCalled, Optional<Consumer<PointerDownEvent>> onTapOutside, Optional<Consumer<PointerUpEvent>> onTapUpOutside, Optional<QuadFunction<BuildContext, Integer, Boolean, Integer, Widget>> buildCounter, Optional<List<String>> autofillHints, Optional<Clip> clipBehavior, Optional<String> restorationId, Optional<Boolean> scribbleEnabled, Optional<Boolean> stylusHandwritingEnabled, Optional<Boolean> enableIMEPersonalizedLearning, Optional<Boolean> enableInlinePrediction, Optional<Boolean> canRequestFocus) {
    int id = factories.textFieldTextField(groupId.map(NativeObj.I::build),
      decoration.map(InputDecorationI::build),
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
      enabled,
      ignorePointers,
      cursorWidth,
      cursorHeight,
      cursorRadius.map(RadiusI::build),
      cursorOpacityAnimates,
      cursorColor.map(ColorI::build),
      cursorErrorColor.map(ColorI::build),
      selectionHeightStyle,
      selectionWidthStyle,
      keyboardAppearance,
      scrollPadding.map(EdgeInsetsI::build),
      dragStartBehavior,
      enableInteractiveSelection,
      selectAllOnFocus,
      onTap,
      onTapAlwaysCalled,
      onTapOutside,
      onTapUpOutside,
      buildCounter,
      autofillHints,
      clipBehavior,
      restorationId,
      scribbleEnabled,
      stylusHandwritingEnabled,
      enableIMEPersonalizedLearning,
      enableInlinePrediction,
      canRequestFocus);
    if (id <= 0) throw new RuntimeException("Failed to created widget TextField");
    return new TextField(id);
  }
  public static TextFieldTextFieldBuilder textField() {
    return TextFieldTextFieldBuilder.textFieldTextField();
  }
  public InputDecoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textFieldDecoration", getId());
      return new InputDecoration(__nid);
    }
    return factories.TextField_readBack_decoration(nativeStruct);
  }
  public TextInputAction textInputAction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldTextInputAction not supported on web");
    return factories.TextField_readBack_textInputAction(nativeStruct);
  }
  public TextCapitalization textCapitalization() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldTextCapitalization not supported on web");
    return factories.TextField_readBack_textCapitalization(nativeStruct);
  }
  public TextStyle style() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textFieldStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.TextField_readBack_style(nativeStruct);
  }
  public TextAlign textAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldTextAlign not supported on web");
    return factories.TextField_readBack_textAlign(nativeStruct);
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldTextDirection not supported on web");
    return factories.TextField_readBack_textDirection(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldAutofocus not supported on web");
    return factories.TextField_readBack_autofocus(nativeStruct);
  }
  public String obscuringCharacter() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldObscuringCharacter not supported on web");
    return factories.TextField_readBack_obscuringCharacter(nativeStruct);
  }
  public boolean obscureText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldObscureText not supported on web");
    return factories.TextField_readBack_obscureText(nativeStruct);
  }
  public boolean autocorrect() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldAutocorrect not supported on web");
    return factories.TextField_readBack_autocorrect(nativeStruct);
  }
  public SmartDashesType smartDashesType() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldSmartDashesType not supported on web");
    return factories.TextField_readBack_smartDashesType(nativeStruct);
  }
  public SmartQuotesType smartQuotesType() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldSmartQuotesType not supported on web");
    return factories.TextField_readBack_smartQuotesType(nativeStruct);
  }
  public boolean enableSuggestions() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldEnableSuggestions not supported on web");
    return factories.TextField_readBack_enableSuggestions(nativeStruct);
  }
  public int maxLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldMaxLines not supported on web");
    return factories.TextField_readBack_maxLines(nativeStruct);
  }
  public int minLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldMinLines not supported on web");
    return factories.TextField_readBack_minLines(nativeStruct);
  }
  public boolean expands() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldExpands not supported on web");
    return factories.TextField_readBack_expands(nativeStruct);
  }
  public boolean readOnly() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldReadOnly not supported on web");
    return factories.TextField_readBack_readOnly(nativeStruct);
  }
  public boolean showCursor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldShowCursor not supported on web");
    return factories.TextField_readBack_showCursor(nativeStruct);
  }
  public int maxLength() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldMaxLength not supported on web");
    return factories.TextField_readBack_maxLength(nativeStruct);
  }
  public MaxLengthEnforcement maxLengthEnforcement() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldMaxLengthEnforcement not supported on web");
    return factories.TextField_readBack_maxLengthEnforcement(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldEnabled not supported on web");
    return factories.TextField_readBack_enabled(nativeStruct);
  }
  public boolean ignorePointers() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldIgnorePointers not supported on web");
    return factories.TextField_readBack_ignorePointers(nativeStruct);
  }
  public double cursorWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldCursorWidth not supported on web");
    return factories.TextField_readBack_cursorWidth(nativeStruct);
  }
  public double cursorHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldCursorHeight not supported on web");
    return factories.TextField_readBack_cursorHeight(nativeStruct);
  }
  public Radius cursorRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textFieldCursorRadius", getId());
      return new Radius(__nid);
    }
    return factories.TextField_readBack_cursorRadius(nativeStruct);
  }
  public boolean cursorOpacityAnimates() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldCursorOpacityAnimates not supported on web");
    return factories.TextField_readBack_cursorOpacityAnimates(nativeStruct);
  }
  public Color cursorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textFieldCursorColor", getId());
      return new Color(__nid);
    }
    return factories.TextField_readBack_cursorColor(nativeStruct);
  }
  public Color cursorErrorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textFieldCursorErrorColor", getId());
      return new Color(__nid);
    }
    return factories.TextField_readBack_cursorErrorColor(nativeStruct);
  }
  public BoxHeightStyle selectionHeightStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldSelectionHeightStyle not supported on web");
    return factories.TextField_readBack_selectionHeightStyle(nativeStruct);
  }
  public BoxWidthStyle selectionWidthStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldSelectionWidthStyle not supported on web");
    return factories.TextField_readBack_selectionWidthStyle(nativeStruct);
  }
  public Brightness keyboardAppearance() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldKeyboardAppearance not supported on web");
    return factories.TextField_readBack_keyboardAppearance(nativeStruct);
  }
  public EdgeInsets scrollPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textFieldScrollPadding", getId());
      return new EdgeInsets(__nid);
    }
    return factories.TextField_readBack_scrollPadding(nativeStruct);
  }
  public boolean enableInteractiveSelection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldEnableInteractiveSelection not supported on web");
    return factories.TextField_readBack_enableInteractiveSelection(nativeStruct);
  }
  public boolean selectAllOnFocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldSelectAllOnFocus not supported on web");
    return factories.TextField_readBack_selectAllOnFocus(nativeStruct);
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldDragStartBehavior not supported on web");
    return factories.TextField_readBack_dragStartBehavior(nativeStruct);
  }
  public boolean onTapAlwaysCalled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldOnTapAlwaysCalled not supported on web");
    return factories.TextField_readBack_onTapAlwaysCalled(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldClipBehavior not supported on web");
    return factories.TextField_readBack_clipBehavior(nativeStruct);
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldRestorationId not supported on web");
    return factories.TextField_readBack_restorationId(nativeStruct);
  }
  public boolean scribbleEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldScribbleEnabled not supported on web");
    return factories.TextField_readBack_scribbleEnabled(nativeStruct);
  }
  public boolean stylusHandwritingEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldStylusHandwritingEnabled not supported on web");
    return factories.TextField_readBack_stylusHandwritingEnabled(nativeStruct);
  }
  public boolean enableIMEPersonalizedLearning() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldEnableIMEPersonalizedLearning not supported on web");
    return factories.TextField_readBack_enableIMEPersonalizedLearning(nativeStruct);
  }
  public boolean enableInlinePrediction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldEnableInlinePrediction not supported on web");
    return factories.TextField_readBack_enableInlinePrediction(nativeStruct);
  }
  public boolean canRequestFocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldCanRequestFocus not supported on web");
    return factories.TextField_readBack_canRequestFocus(nativeStruct);
  }
  public boolean selectionEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldSelectionEnabled not supported on web");
    return factories.TextField_readBack_selectionEnabled(nativeStruct);
  }
  public static int noMaxLength() {
    return -1;
  }
  public static TextStyle materialMisspelledTextStyle() {
    return TextStyle.textStyle().decoration(TextDecoration.underline()).decorationColor(Colors.red()).decorationStyle(TextDecorationStyle.wavy).build();
  }
  @Override
  public TextField build() {
    return this;
  }
}
