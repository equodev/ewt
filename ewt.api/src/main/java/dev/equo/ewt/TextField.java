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
    System.out.println("New TextField id:"+id);
  }
  @Builder.Factory
  static TextField textFieldTextField(Optional<NativeObj.I> groupId, Optional<TextInputAction> textInputAction, Optional<TextCapitalization> textCapitalization, Optional<TextStyleI> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> readOnly, Optional<Boolean> showCursor, Optional<Boolean> autofocus, Optional<String> obscuringCharacter, Optional<Boolean> obscureText, Optional<Boolean> autocorrect, Optional<SmartDashesType> smartDashesType, Optional<SmartQuotesType> smartQuotesType, Optional<Boolean> enableSuggestions, OptionalInt maxLines, OptionalInt minLines, Optional<Boolean> expands, OptionalInt maxLength, Optional<MaxLengthEnforcement> maxLengthEnforcement, Optional<Consumer<String>> onChanged, Optional<Runnable> onEditingComplete, Optional<Consumer<String>> onSubmitted, Optional<Boolean> enabled, Optional<Boolean> ignorePointers, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<RadiusI> cursorRadius, Optional<Boolean> cursorOpacityAnimates, Optional<ColorI> cursorColor, Optional<ColorI> cursorErrorColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<Brightness> keyboardAppearance, Optional<EdgeInsetsI> scrollPadding, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Runnable> onTap, Optional<Boolean> onTapAlwaysCalled, Optional<QuadFunction<BuildContext, Integer, Boolean, Integer, Widget>> buildCounter, Optional<Clip> clipBehavior, Optional<String> restorationId, Optional<Boolean> scribbleEnabled, Optional<Boolean> stylusHandwritingEnabled, Optional<Boolean> enableIMEPersonalizedLearning, Optional<Boolean> canRequestFocus) {
    var st = factories.textFieldTextField(groupId.map(NativeObj.I::build),
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
  public TextInputAction textInputAction() {
    return TextInputAction.values()[TextFieldObjSt.textInputAction(st)];
  }
  public TextCapitalization textCapitalization() {
    return TextCapitalization.values()[TextFieldObjSt.textCapitalization(st)];
  }
  public TextStyle style() {
    return new TextStyle(TextFieldObjSt.style(st));
  }
  public TextAlign textAlign() {
    return TextAlign.values()[TextFieldObjSt.textAlign(st)];
  }
  public TextDirection textDirection() {
    return TextDirection.values()[TextFieldObjSt.textDirection(st)];
  }
  public boolean autofocus() {
    return intToBool(TextFieldObjSt.autofocus(st));
  }
  public String obscuringCharacter() {
    return TextFieldObjSt.obscuringCharacter(st).getString(0);
  }
  public boolean obscureText() {
    return intToBool(TextFieldObjSt.obscureText(st));
  }
  public boolean autocorrect() {
    return intToBool(TextFieldObjSt.autocorrect(st));
  }
  public SmartDashesType smartDashesType() {
    return SmartDashesType.values()[TextFieldObjSt.smartDashesType(st)];
  }
  public SmartQuotesType smartQuotesType() {
    return SmartQuotesType.values()[TextFieldObjSt.smartQuotesType(st)];
  }
  public boolean enableSuggestions() {
    return intToBool(TextFieldObjSt.enableSuggestions(st));
  }
  public int maxLines() {
    return TextFieldObjSt.maxLines(st);
  }
  public int minLines() {
    return TextFieldObjSt.minLines(st);
  }
  public boolean expands() {
    return intToBool(TextFieldObjSt.expands(st));
  }
  public boolean readOnly() {
    return intToBool(TextFieldObjSt.readOnly(st));
  }
  public boolean showCursor() {
    return intToBool(TextFieldObjSt.showCursor(st));
  }
  public int maxLength() {
    return TextFieldObjSt.maxLength(st);
  }
  public MaxLengthEnforcement maxLengthEnforcement() {
    return MaxLengthEnforcement.values()[TextFieldObjSt.maxLengthEnforcement(st)];
  }
  public boolean enabled() {
    return intToBool(TextFieldObjSt.enabled(st));
  }
  public boolean ignorePointers() {
    return intToBool(TextFieldObjSt.ignorePointers(st));
  }
  public double cursorWidth() {
    return TextFieldObjSt.cursorWidth(st);
  }
  public double cursorHeight() {
    return TextFieldObjSt.cursorHeight(st);
  }
  public Radius cursorRadius() {
    return new Radius(TextFieldObjSt.cursorRadius(st));
  }
  public boolean cursorOpacityAnimates() {
    return intToBool(TextFieldObjSt.cursorOpacityAnimates(st));
  }
  public Color cursorColor() {
    return new Color(TextFieldObjSt.cursorColor(st));
  }
  public Color cursorErrorColor() {
    return new Color(TextFieldObjSt.cursorErrorColor(st));
  }
  public BoxHeightStyle selectionHeightStyle() {
    return BoxHeightStyle.values()[TextFieldObjSt.selectionHeightStyle(st)];
  }
  public BoxWidthStyle selectionWidthStyle() {
    return BoxWidthStyle.values()[TextFieldObjSt.selectionWidthStyle(st)];
  }
  public Brightness keyboardAppearance() {
    return Brightness.values()[TextFieldObjSt.keyboardAppearance(st)];
  }
  public EdgeInsets scrollPadding() {
    return new EdgeInsets(TextFieldObjSt.scrollPadding(st));
  }
  public boolean enableInteractiveSelection() {
    return intToBool(TextFieldObjSt.enableInteractiveSelection(st));
  }
  public DragStartBehavior dragStartBehavior() {
    return DragStartBehavior.values()[TextFieldObjSt.dragStartBehavior(st)];
  }
  public boolean onTapAlwaysCalled() {
    return intToBool(TextFieldObjSt.onTapAlwaysCalled(st));
  }
  public Clip clipBehavior() {
    return Clip.values()[TextFieldObjSt.clipBehavior(st)];
  }
  public String restorationId() {
    return TextFieldObjSt.restorationId(st).getString(0);
  }
  public boolean scribbleEnabled() {
    return intToBool(TextFieldObjSt.scribbleEnabled(st));
  }
  public boolean stylusHandwritingEnabled() {
    return intToBool(TextFieldObjSt.stylusHandwritingEnabled(st));
  }
  public boolean enableIMEPersonalizedLearning() {
    return intToBool(TextFieldObjSt.enableIMEPersonalizedLearning(st));
  }
  public boolean canRequestFocus() {
    return intToBool(TextFieldObjSt.canRequestFocus(st));
  }
  public boolean selectionEnabled() {
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
