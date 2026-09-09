package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoTextFormFieldRowObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoTextFormFieldRow extends FormField<String> implements CupertinoTextFormFieldRowI {
  private MemorySegment st;
  protected CupertinoTextFormFieldRow() {}
  CupertinoTextFormFieldRow(MemorySegment st) {
    this.id = CupertinoTextFormFieldRowObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoTextFormFieldRow");
    System.out.println("New CupertinoTextFormFieldRow id:"+id);
  }
  CupertinoTextFormFieldRow(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoTextFormFieldRow cupertinoTextFormFieldRowCupertinoTextFormFieldRow(Optional<WidgetI> prefix, Optional<EdgeInsetsGeometryI> padding, Optional<String> initialValue, Optional<BoxDecorationI> decoration, Optional<TextCapitalization> textCapitalization, Optional<TextInputAction> textInputAction, Optional<TextStyleI> style, Optional<TextDirection> textDirection, Optional<TextAlign> textAlign, Optional<Boolean> autofocus, Optional<Boolean> readOnly, Optional<Boolean> showCursor, Optional<String> obscuringCharacter, Optional<Boolean> obscureText, Optional<Boolean> autocorrect, Optional<SmartDashesType> smartDashesType, Optional<SmartQuotesType> smartQuotesType, Optional<Boolean> enableSuggestions, OptionalInt maxLines, OptionalInt minLines, Optional<Boolean> expands, OptionalInt maxLength, Optional<Consumer<String>> onChanged, Optional<Runnable> onTap, Optional<Runnable> onEditingComplete, Optional<Consumer<String>> onFieldSubmitted, Optional<Consumer<String>> onSaved, Optional<Function<String, String>> validator, Optional<Boolean> enabled, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<ColorI> cursorColor, Optional<Brightness> keyboardAppearance, Optional<EdgeInsetsI> scrollPadding, Optional<Boolean> enableInteractiveSelection, Optional<List<String>> autofillHints, Optional<AutovalidateMode> autovalidateMode, Optional<String> placeholder, Optional<TextStyleI> placeholderStyle, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<String> restorationId) {
    var st = factories.cupertinoTextFormFieldRowCupertinoTextFormFieldRow(prefix.map(WidgetI::build),
      padding.map(EdgeInsetsGeometryI::build),
      initialValue,
      decoration.map(BoxDecorationI::build),
      textCapitalization,
      textInputAction,
      style.map(TextStyleI::build),
      textDirection,
      textAlign,
      autofocus,
      readOnly,
      showCursor,
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
      onChanged,
      onTap,
      onEditingComplete,
      onFieldSubmitted,
      onSaved,
      validator,
      enabled,
      cursorWidth,
      cursorHeight,
      cursorColor.map(ColorI::build),
      keyboardAppearance,
      scrollPadding.map(EdgeInsetsI::build),
      enableInteractiveSelection,
      autofillHints,
      autovalidateMode,
      placeholder,
      placeholderStyle.map(TextStyleI::build),
      selectionHeightStyle,
      selectionWidthStyle,
      restorationId);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoTextFormFieldRow");
    return new CupertinoTextFormFieldRow(st);
  }
  public static CupertinoTextFormFieldRowCupertinoTextFormFieldRowBuilder cupertinoTextFormFieldRow() {
    return CupertinoTextFormFieldRowCupertinoTextFormFieldRowBuilder.cupertinoTextFormFieldRowCupertinoTextFormFieldRow();
  }
  public Widget prefix() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFormFieldRowPrefix not supported on web");
    return new Widget(CupertinoTextFormFieldRowObjSt.prefix(st)) {};
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTextFormFieldRowPadding not supported on web");
    return new EdgeInsetsGeometry(CupertinoTextFormFieldRowObjSt.padding(st)) {};
  }
  @Override
  public CupertinoTextFormFieldRow build() {
    return this;
  }
}
