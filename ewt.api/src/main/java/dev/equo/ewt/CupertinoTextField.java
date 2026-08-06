package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoTextFieldObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoTextField extends StatefulWidget implements CupertinoTextFieldI {
  private MemorySegment st;
  protected CupertinoTextField() {}
  CupertinoTextField(MemorySegment st) {
    this.id = CupertinoTextFieldObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoTextField");
    System.out.println("New CupertinoTextField id:"+id);
  }
  CupertinoTextField(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoTextField cupertinoTextFieldCupertinoTextField(Optional<NativeObj.I> groupId, Optional<BoxDecorationI> decoration, Optional<EdgeInsetsGeometryI> padding, Optional<String> placeholder, Optional<TextStyleI> placeholderStyle, Optional<WidgetI> prefix, Optional<OverlayVisibilityMode> prefixMode, Optional<WidgetI> suffix, Optional<OverlayVisibilityMode> suffixMode, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<OverlayVisibilityMode> clearButtonMode, Optional<String> clearButtonSemanticLabel, Optional<TextInputAction> textInputAction, Optional<TextCapitalization> textCapitalization, Optional<TextStyleI> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> readOnly, Optional<Boolean> showCursor, Optional<Boolean> autofocus, Optional<String> obscuringCharacter, Optional<Boolean> obscureText, Optional<Boolean> autocorrect, Optional<SmartDashesType> smartDashesType, Optional<SmartQuotesType> smartQuotesType, Optional<Boolean> enableSuggestions, OptionalInt maxLines, OptionalInt minLines, Optional<Boolean> expands, OptionalInt maxLength, Optional<MaxLengthEnforcement> maxLengthEnforcement, Optional<Consumer<String>> onChanged, Optional<Runnable> onEditingComplete, Optional<Consumer<String>> onSubmitted, Optional<Boolean> enabled, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<RadiusI> cursorRadius, Optional<Boolean> cursorOpacityAnimates, Optional<ColorI> cursorColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<Brightness> keyboardAppearance, Optional<EdgeInsetsI> scrollPadding, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Boolean> selectAllOnFocus, Optional<Runnable> onTap, Optional<Clip> clipBehavior, Optional<String> restorationId, Optional<Boolean> scribbleEnabled, Optional<Boolean> stylusHandwritingEnabled, Optional<Boolean> enableIMEPersonalizedLearning) {
    var st = factories.cupertinoTextFieldCupertinoTextField(groupId.map(NativeObj.I::build),
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
      clipBehavior,
      restorationId,
      scribbleEnabled,
      stylusHandwritingEnabled,
      enableIMEPersonalizedLearning);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoTextField");
    return new CupertinoTextField(st);
  }
  public static CupertinoTextFieldCupertinoTextFieldBuilder cupertinoTextField() {
    return CupertinoTextFieldCupertinoTextFieldBuilder.cupertinoTextFieldCupertinoTextField();
  }
  @Builder.Factory
  static CupertinoTextField cupertinoTextFieldBorderless(Optional<NativeObj.I> groupId, Optional<BoxDecorationI> decoration, Optional<EdgeInsetsGeometryI> padding, Optional<String> placeholder, Optional<TextStyleI> placeholderStyle, Optional<WidgetI> prefix, Optional<OverlayVisibilityMode> prefixMode, Optional<WidgetI> suffix, Optional<OverlayVisibilityMode> suffixMode, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<OverlayVisibilityMode> clearButtonMode, Optional<String> clearButtonSemanticLabel, Optional<TextInputAction> textInputAction, Optional<TextCapitalization> textCapitalization, Optional<TextStyleI> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> readOnly, Optional<Boolean> showCursor, Optional<Boolean> autofocus, Optional<String> obscuringCharacter, Optional<Boolean> obscureText, Optional<Boolean> autocorrect, Optional<SmartDashesType> smartDashesType, Optional<SmartQuotesType> smartQuotesType, Optional<Boolean> enableSuggestions, OptionalInt maxLines, OptionalInt minLines, Optional<Boolean> expands, OptionalInt maxLength, Optional<MaxLengthEnforcement> maxLengthEnforcement, Optional<Consumer<String>> onChanged, Optional<Runnable> onEditingComplete, Optional<Consumer<String>> onSubmitted, Optional<Boolean> enabled, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<RadiusI> cursorRadius, Optional<Boolean> cursorOpacityAnimates, Optional<ColorI> cursorColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<Brightness> keyboardAppearance, Optional<EdgeInsetsI> scrollPadding, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Boolean> selectAllOnFocus, Optional<Runnable> onTap, Optional<Clip> clipBehavior, Optional<String> restorationId, Optional<Boolean> scribbleEnabled, Optional<Boolean> stylusHandwritingEnabled, Optional<Boolean> enableIMEPersonalizedLearning) {
    var st = factories.cupertinoTextFieldBorderless(groupId.map(NativeObj.I::build),
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
      clipBehavior,
      restorationId,
      scribbleEnabled,
      stylusHandwritingEnabled,
      enableIMEPersonalizedLearning);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoTextField");
    return new CupertinoTextField(st);
  }
  public static CupertinoTextFieldBorderlessBuilder borderless() {
    return CupertinoTextFieldBorderlessBuilder.cupertinoTextFieldBorderless();
  }
  public BoxDecoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextFieldDecoration", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxDecorationObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxDecorationObjSt.id(__st, __nid);
      return new BoxDecoration(__st);
    }
    return new BoxDecoration(CupertinoTextFieldObjSt.decoration(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldPadding not supported on web");
    return new EdgeInsetsGeometry(CupertinoTextFieldObjSt.padding(st)) {};
  }
  public String placeholder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldPlaceholder not supported on web");
    return CupertinoTextFieldObjSt.placeholder(st).getString(0);
  }
  public TextStyle placeholderStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextFieldPlaceholderStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(CupertinoTextFieldObjSt.placeholderStyle(st));
  }
  public Widget prefix() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldPrefix not supported on web");
    return new Widget(CupertinoTextFieldObjSt.prefix(st)) {};
  }
  public OverlayVisibilityMode prefixMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldPrefixMode not supported on web");
    return OverlayVisibilityMode.values()[CupertinoTextFieldObjSt.prefixMode(st)];
  }
  public Widget suffix() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldSuffix not supported on web");
    return new Widget(CupertinoTextFieldObjSt.suffix(st)) {};
  }
  public OverlayVisibilityMode suffixMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldSuffixMode not supported on web");
    return OverlayVisibilityMode.values()[CupertinoTextFieldObjSt.suffixMode(st)];
  }
  public CrossAxisAlignment crossAxisAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldCrossAxisAlignment not supported on web");
    return CrossAxisAlignment.values()[CupertinoTextFieldObjSt.crossAxisAlignment(st)];
  }
  public OverlayVisibilityMode clearButtonMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldClearButtonMode not supported on web");
    return OverlayVisibilityMode.values()[CupertinoTextFieldObjSt.clearButtonMode(st)];
  }
  public String clearButtonSemanticLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldClearButtonSemanticLabel not supported on web");
    return CupertinoTextFieldObjSt.clearButtonSemanticLabel(st).getString(0);
  }
  public TextInputAction textInputAction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldTextInputAction not supported on web");
    return TextInputAction.values()[CupertinoTextFieldObjSt.textInputAction(st)];
  }
  public TextCapitalization textCapitalization() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldTextCapitalization not supported on web");
    return TextCapitalization.values()[CupertinoTextFieldObjSt.textCapitalization(st)];
  }
  public TextStyle style() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextFieldStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(CupertinoTextFieldObjSt.style(st));
  }
  public TextAlign textAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldTextAlign not supported on web");
    return TextAlign.values()[CupertinoTextFieldObjSt.textAlign(st)];
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldTextDirection not supported on web");
    return TextDirection.values()[CupertinoTextFieldObjSt.textDirection(st)];
  }
  public boolean readOnly() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldReadOnly not supported on web");
    return intToBool(CupertinoTextFieldObjSt.readOnly(st));
  }
  public boolean showCursor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldShowCursor not supported on web");
    return intToBool(CupertinoTextFieldObjSt.showCursor(st));
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldAutofocus not supported on web");
    return intToBool(CupertinoTextFieldObjSt.autofocus(st));
  }
  public String obscuringCharacter() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldObscuringCharacter not supported on web");
    return CupertinoTextFieldObjSt.obscuringCharacter(st).getString(0);
  }
  public boolean obscureText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldObscureText not supported on web");
    return intToBool(CupertinoTextFieldObjSt.obscureText(st));
  }
  public boolean autocorrect() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldAutocorrect not supported on web");
    return intToBool(CupertinoTextFieldObjSt.autocorrect(st));
  }
  public SmartDashesType smartDashesType() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldSmartDashesType not supported on web");
    return SmartDashesType.values()[CupertinoTextFieldObjSt.smartDashesType(st)];
  }
  public SmartQuotesType smartQuotesType() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldSmartQuotesType not supported on web");
    return SmartQuotesType.values()[CupertinoTextFieldObjSt.smartQuotesType(st)];
  }
  public boolean enableSuggestions() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldEnableSuggestions not supported on web");
    return intToBool(CupertinoTextFieldObjSt.enableSuggestions(st));
  }
  public int maxLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldMaxLines not supported on web");
    return CupertinoTextFieldObjSt.maxLines(st);
  }
  public int minLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldMinLines not supported on web");
    return CupertinoTextFieldObjSt.minLines(st);
  }
  public boolean expands() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldExpands not supported on web");
    return intToBool(CupertinoTextFieldObjSt.expands(st));
  }
  public int maxLength() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldMaxLength not supported on web");
    return CupertinoTextFieldObjSt.maxLength(st);
  }
  public MaxLengthEnforcement maxLengthEnforcement() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldMaxLengthEnforcement not supported on web");
    return MaxLengthEnforcement.values()[CupertinoTextFieldObjSt.maxLengthEnforcement(st)];
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldEnabled not supported on web");
    return intToBool(CupertinoTextFieldObjSt.enabled(st));
  }
  public double cursorWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldCursorWidth not supported on web");
    return CupertinoTextFieldObjSt.cursorWidth(st);
  }
  public double cursorHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldCursorHeight not supported on web");
    return CupertinoTextFieldObjSt.cursorHeight(st);
  }
  public Radius cursorRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextFieldCursorRadius", getId());
      return new Radius(__nid);
    }
    return new Radius(CupertinoTextFieldObjSt.cursorRadius(st));
  }
  public boolean cursorOpacityAnimates() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldCursorOpacityAnimates not supported on web");
    return intToBool(CupertinoTextFieldObjSt.cursorOpacityAnimates(st));
  }
  public Color cursorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextFieldCursorColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoTextFieldObjSt.cursorColor(st));
  }
  public BoxHeightStyle selectionHeightStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldSelectionHeightStyle not supported on web");
    return BoxHeightStyle.values()[CupertinoTextFieldObjSt.selectionHeightStyle(st)];
  }
  public BoxWidthStyle selectionWidthStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldSelectionWidthStyle not supported on web");
    return BoxWidthStyle.values()[CupertinoTextFieldObjSt.selectionWidthStyle(st)];
  }
  public Brightness keyboardAppearance() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldKeyboardAppearance not supported on web");
    return Brightness.values()[CupertinoTextFieldObjSt.keyboardAppearance(st)];
  }
  public EdgeInsets scrollPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextFieldScrollPadding", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.EdgeInsetsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.EdgeInsetsObjSt.id(__st, __nid);
      return new EdgeInsets(__st);
    }
    return new EdgeInsets(CupertinoTextFieldObjSt.scrollPadding(st));
  }
  public boolean enableInteractiveSelection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldEnableInteractiveSelection not supported on web");
    return intToBool(CupertinoTextFieldObjSt.enableInteractiveSelection(st));
  }
  public boolean selectAllOnFocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldSelectAllOnFocus not supported on web");
    return intToBool(CupertinoTextFieldObjSt.selectAllOnFocus(st));
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldDragStartBehavior not supported on web");
    return DragStartBehavior.values()[CupertinoTextFieldObjSt.dragStartBehavior(st)];
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldClipBehavior not supported on web");
    return Clip.values()[CupertinoTextFieldObjSt.clipBehavior(st)];
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldRestorationId not supported on web");
    return CupertinoTextFieldObjSt.restorationId(st).getString(0);
  }
  public boolean scribbleEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldScribbleEnabled not supported on web");
    return intToBool(CupertinoTextFieldObjSt.scribbleEnabled(st));
  }
  public boolean stylusHandwritingEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldStylusHandwritingEnabled not supported on web");
    return intToBool(CupertinoTextFieldObjSt.stylusHandwritingEnabled(st));
  }
  public boolean enableIMEPersonalizedLearning() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldEnableIMEPersonalizedLearning not supported on web");
    return intToBool(CupertinoTextFieldObjSt.enableIMEPersonalizedLearning(st));
  }
  public boolean selectionEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFieldSelectionEnabled not supported on web");
    return intToBool(CupertinoTextFieldObjSt.selectionEnabled(st));
  }
  public static TextStyle cupertinoMisspelledTextStyle() {
    return TextStyle.textStyle().decoration(TextDecoration.underline()).decorationColor(CupertinoColors.systemRed()).decorationStyle(TextDecorationStyle.dotted).build();
  }
  public static Color kMisspelledSelectionColor() {
    return Color.color(0x62ff9699).build();
  }
  @Override
  public CupertinoTextField build() {
    return this;
  }
}
