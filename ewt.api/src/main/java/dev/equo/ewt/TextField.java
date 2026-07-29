package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TextFieldObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TextField extends StatefulWidget implements TextFieldI {
  private MemorySegment st;
  protected TextField() {}
  TextField(MemorySegment st) {
    this.id = TextFieldObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TextField");
    System.out.println("New TextField id:"+id);
  }
  TextField(int id) { this.id = id; }
  @Builder.Factory
  static TextField textFieldTextField(Optional<NativeObj.I> groupId, Optional<InputDecorationI> decoration, Optional<TextInputAction> textInputAction, Optional<TextCapitalization> textCapitalization, Optional<TextStyleI> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> readOnly, Optional<Boolean> showCursor, Optional<Boolean> autofocus, Optional<String> obscuringCharacter, Optional<Boolean> obscureText, Optional<Boolean> autocorrect, Optional<SmartDashesType> smartDashesType, Optional<SmartQuotesType> smartQuotesType, Optional<Boolean> enableSuggestions, OptionalInt maxLines, OptionalInt minLines, Optional<Boolean> expands, OptionalInt maxLength, Optional<MaxLengthEnforcement> maxLengthEnforcement, Optional<Consumer<String>> onChanged, Optional<Runnable> onEditingComplete, Optional<Consumer<String>> onSubmitted, Optional<Boolean> enabled, Optional<Boolean> ignorePointers, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<RadiusI> cursorRadius, Optional<Boolean> cursorOpacityAnimates, Optional<ColorI> cursorColor, Optional<ColorI> cursorErrorColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<Brightness> keyboardAppearance, Optional<EdgeInsetsI> scrollPadding, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Boolean> selectAllOnFocus, Optional<Runnable> onTap, Optional<Boolean> onTapAlwaysCalled, Optional<QuadFunction<BuildContext, Integer, Boolean, Integer, Widget>> buildCounter, Optional<Clip> clipBehavior, Optional<String> restorationId, Optional<Boolean> scribbleEnabled, Optional<Boolean> stylusHandwritingEnabled, Optional<Boolean> enableIMEPersonalizedLearning, Optional<Boolean> canRequestFocus) {
    var st = factories.textFieldTextField(groupId.map(NativeObj.I::build),
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
      buildCounter,
      clipBehavior,
      restorationId,
      scribbleEnabled,
      stylusHandwritingEnabled,
      enableIMEPersonalizedLearning,
      canRequestFocus);
    if (st == null) throw new RuntimeException("Failed to created widget TextField");
    return new TextField(st);
  }
  public static TextFieldTextFieldBuilder textField() {
    return TextFieldTextFieldBuilder.textFieldTextField();
  }
  public InputDecoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textFieldDecoration", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.InputDecorationObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.InputDecorationObjSt.id(__st, __nid);
      return new InputDecoration(__st);
    }
    return new InputDecoration(TextFieldObjSt.decoration(st));
  }
  public TextInputAction textInputAction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldTextInputAction not supported on web");
    return TextInputAction.values()[TextFieldObjSt.textInputAction(st)];
  }
  public TextCapitalization textCapitalization() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldTextCapitalization not supported on web");
    return TextCapitalization.values()[TextFieldObjSt.textCapitalization(st)];
  }
  public TextStyle style() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textFieldStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(TextFieldObjSt.style(st));
  }
  public TextAlign textAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldTextAlign not supported on web");
    return TextAlign.values()[TextFieldObjSt.textAlign(st)];
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldTextDirection not supported on web");
    return TextDirection.values()[TextFieldObjSt.textDirection(st)];
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldAutofocus not supported on web");
    return intToBool(TextFieldObjSt.autofocus(st));
  }
  public String obscuringCharacter() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldObscuringCharacter not supported on web");
    return TextFieldObjSt.obscuringCharacter(st).getString(0);
  }
  public boolean obscureText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldObscureText not supported on web");
    return intToBool(TextFieldObjSt.obscureText(st));
  }
  public boolean autocorrect() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldAutocorrect not supported on web");
    return intToBool(TextFieldObjSt.autocorrect(st));
  }
  public SmartDashesType smartDashesType() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldSmartDashesType not supported on web");
    return SmartDashesType.values()[TextFieldObjSt.smartDashesType(st)];
  }
  public SmartQuotesType smartQuotesType() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldSmartQuotesType not supported on web");
    return SmartQuotesType.values()[TextFieldObjSt.smartQuotesType(st)];
  }
  public boolean enableSuggestions() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldEnableSuggestions not supported on web");
    return intToBool(TextFieldObjSt.enableSuggestions(st));
  }
  public int maxLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldMaxLines not supported on web");
    return TextFieldObjSt.maxLines(st);
  }
  public int minLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldMinLines not supported on web");
    return TextFieldObjSt.minLines(st);
  }
  public boolean expands() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldExpands not supported on web");
    return intToBool(TextFieldObjSt.expands(st));
  }
  public boolean readOnly() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldReadOnly not supported on web");
    return intToBool(TextFieldObjSt.readOnly(st));
  }
  public boolean showCursor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldShowCursor not supported on web");
    return intToBool(TextFieldObjSt.showCursor(st));
  }
  public int maxLength() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldMaxLength not supported on web");
    return TextFieldObjSt.maxLength(st);
  }
  public MaxLengthEnforcement maxLengthEnforcement() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldMaxLengthEnforcement not supported on web");
    return MaxLengthEnforcement.values()[TextFieldObjSt.maxLengthEnforcement(st)];
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldEnabled not supported on web");
    return intToBool(TextFieldObjSt.enabled(st));
  }
  public boolean ignorePointers() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldIgnorePointers not supported on web");
    return intToBool(TextFieldObjSt.ignorePointers(st));
  }
  public double cursorWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldCursorWidth not supported on web");
    return TextFieldObjSt.cursorWidth(st);
  }
  public double cursorHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldCursorHeight not supported on web");
    return TextFieldObjSt.cursorHeight(st);
  }
  public Radius cursorRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textFieldCursorRadius", getId());
      return new Radius(__nid);
    }
    return new Radius(TextFieldObjSt.cursorRadius(st));
  }
  public boolean cursorOpacityAnimates() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldCursorOpacityAnimates not supported on web");
    return intToBool(TextFieldObjSt.cursorOpacityAnimates(st));
  }
  public Color cursorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textFieldCursorColor", getId());
      return new Color(__nid);
    }
    return new Color(TextFieldObjSt.cursorColor(st));
  }
  public Color cursorErrorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textFieldCursorErrorColor", getId());
      return new Color(__nid);
    }
    return new Color(TextFieldObjSt.cursorErrorColor(st));
  }
  public BoxHeightStyle selectionHeightStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldSelectionHeightStyle not supported on web");
    return BoxHeightStyle.values()[TextFieldObjSt.selectionHeightStyle(st)];
  }
  public BoxWidthStyle selectionWidthStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldSelectionWidthStyle not supported on web");
    return BoxWidthStyle.values()[TextFieldObjSt.selectionWidthStyle(st)];
  }
  public Brightness keyboardAppearance() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldKeyboardAppearance not supported on web");
    return Brightness.values()[TextFieldObjSt.keyboardAppearance(st)];
  }
  public EdgeInsets scrollPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textFieldScrollPadding", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.EdgeInsetsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.EdgeInsetsObjSt.id(__st, __nid);
      return new EdgeInsets(__st);
    }
    return new EdgeInsets(TextFieldObjSt.scrollPadding(st));
  }
  public boolean enableInteractiveSelection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldEnableInteractiveSelection not supported on web");
    return intToBool(TextFieldObjSt.enableInteractiveSelection(st));
  }
  public boolean selectAllOnFocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldSelectAllOnFocus not supported on web");
    return intToBool(TextFieldObjSt.selectAllOnFocus(st));
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldDragStartBehavior not supported on web");
    return DragStartBehavior.values()[TextFieldObjSt.dragStartBehavior(st)];
  }
  public boolean onTapAlwaysCalled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldOnTapAlwaysCalled not supported on web");
    return intToBool(TextFieldObjSt.onTapAlwaysCalled(st));
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldClipBehavior not supported on web");
    return Clip.values()[TextFieldObjSt.clipBehavior(st)];
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldRestorationId not supported on web");
    return TextFieldObjSt.restorationId(st).getString(0);
  }
  public boolean scribbleEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldScribbleEnabled not supported on web");
    return intToBool(TextFieldObjSt.scribbleEnabled(st));
  }
  public boolean stylusHandwritingEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldStylusHandwritingEnabled not supported on web");
    return intToBool(TextFieldObjSt.stylusHandwritingEnabled(st));
  }
  public boolean enableIMEPersonalizedLearning() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldEnableIMEPersonalizedLearning not supported on web");
    return intToBool(TextFieldObjSt.enableIMEPersonalizedLearning(st));
  }
  public boolean canRequestFocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldCanRequestFocus not supported on web");
    return intToBool(TextFieldObjSt.canRequestFocus(st));
  }
  public boolean selectionEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textFieldSelectionEnabled not supported on web");
    return intToBool(TextFieldObjSt.selectionEnabled(st));
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
