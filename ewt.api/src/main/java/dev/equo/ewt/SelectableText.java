package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SelectableText extends StatefulWidget implements SelectableTextI {
  protected SelectableText() {}
  SelectableText(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SelectableText");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SelectableText selectableTextSelectableText(@Builder.Parameter String data, Optional<TextStyleI> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, OptionalDouble textScaleFactor, Optional<Boolean> showCursor, Optional<Boolean> autofocus, OptionalInt minLines, OptionalInt maxLines, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<RadiusI> cursorRadius, Optional<ColorI> cursorColor, Optional<ColorI> selectionColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Runnable> onTap, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis) {
    int id = factories.selectableTextSelectableText(data,
      style.map(TextStyleI::build),
      textAlign,
      textDirection,
      textScaleFactor,
      showCursor,
      autofocus,
      minLines,
      maxLines,
      cursorWidth,
      cursorHeight,
      cursorRadius.map(RadiusI::build),
      cursorColor.map(ColorI::build),
      selectionColor.map(ColorI::build),
      selectionHeightStyle,
      selectionWidthStyle,
      dragStartBehavior,
      enableInteractiveSelection,
      onTap,
      semanticsLabel,
      textWidthBasis);
    if (id <= 0) throw new RuntimeException("Failed to created widget SelectableText");
    return new SelectableText(id);
  }
  public static SelectableTextSelectableTextBuilder selectableText(String data) {
    return SelectableTextSelectableTextBuilder.selectableTextSelectableText(data);
  }
  @Builder.Factory
  static SelectableText selectableTextRich(@Builder.Parameter TextSpanI textSpan, Optional<TextStyleI> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, OptionalDouble textScaleFactor, Optional<Boolean> showCursor, Optional<Boolean> autofocus, OptionalInt minLines, OptionalInt maxLines, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<RadiusI> cursorRadius, Optional<ColorI> cursorColor, Optional<ColorI> selectionColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Runnable> onTap, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis) {
    int id = factories.selectableTextRich(textSpan.build(),
      style.map(TextStyleI::build),
      textAlign,
      textDirection,
      textScaleFactor,
      showCursor,
      autofocus,
      minLines,
      maxLines,
      cursorWidth,
      cursorHeight,
      cursorRadius.map(RadiusI::build),
      cursorColor.map(ColorI::build),
      selectionColor.map(ColorI::build),
      selectionHeightStyle,
      selectionWidthStyle,
      dragStartBehavior,
      enableInteractiveSelection,
      onTap,
      semanticsLabel,
      textWidthBasis);
    if (id <= 0) throw new RuntimeException("Failed to created widget SelectableText");
    return new SelectableText(id);
  }
  public static SelectableTextRichBuilder rich(TextSpanI textSpan) {
    return SelectableTextRichBuilder.selectableTextRich(textSpan);
  }
  public String data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextData not supported on web");
    return factories.SelectableText_readBack_data(nativeStruct);
  }
  public TextSpan textSpan() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("selectableTextTextSpan", getId());
      return new TextSpan(__nid);
    }
    return factories.SelectableText_readBack_textSpan(nativeStruct);
  }
  public TextStyle style() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("selectableTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.SelectableText_readBack_style(nativeStruct);
  }
  public TextAlign textAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextTextAlign not supported on web");
    return factories.SelectableText_readBack_textAlign(nativeStruct);
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextTextDirection not supported on web");
    return factories.SelectableText_readBack_textDirection(nativeStruct);
  }
  public double textScaleFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextTextScaleFactor not supported on web");
    return factories.SelectableText_readBack_textScaleFactor(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextAutofocus not supported on web");
    return factories.SelectableText_readBack_autofocus(nativeStruct);
  }
  public int minLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextMinLines not supported on web");
    return factories.SelectableText_readBack_minLines(nativeStruct);
  }
  public int maxLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextMaxLines not supported on web");
    return factories.SelectableText_readBack_maxLines(nativeStruct);
  }
  public boolean showCursor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextShowCursor not supported on web");
    return factories.SelectableText_readBack_showCursor(nativeStruct);
  }
  public double cursorWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextCursorWidth not supported on web");
    return factories.SelectableText_readBack_cursorWidth(nativeStruct);
  }
  public double cursorHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextCursorHeight not supported on web");
    return factories.SelectableText_readBack_cursorHeight(nativeStruct);
  }
  public Radius cursorRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("selectableTextCursorRadius", getId());
      return new Radius(__nid);
    }
    return factories.SelectableText_readBack_cursorRadius(nativeStruct);
  }
  public Color cursorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("selectableTextCursorColor", getId());
      return new Color(__nid);
    }
    return factories.SelectableText_readBack_cursorColor(nativeStruct);
  }
  public Color selectionColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("selectableTextSelectionColor", getId());
      return new Color(__nid);
    }
    return factories.SelectableText_readBack_selectionColor(nativeStruct);
  }
  public BoxHeightStyle selectionHeightStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextSelectionHeightStyle not supported on web");
    return factories.SelectableText_readBack_selectionHeightStyle(nativeStruct);
  }
  public BoxWidthStyle selectionWidthStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextSelectionWidthStyle not supported on web");
    return factories.SelectableText_readBack_selectionWidthStyle(nativeStruct);
  }
  public boolean enableInteractiveSelection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextEnableInteractiveSelection not supported on web");
    return factories.SelectableText_readBack_enableInteractiveSelection(nativeStruct);
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextDragStartBehavior not supported on web");
    return factories.SelectableText_readBack_dragStartBehavior(nativeStruct);
  }
  public String semanticsLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextSemanticsLabel not supported on web");
    return factories.SelectableText_readBack_semanticsLabel(nativeStruct);
  }
  public TextWidthBasis textWidthBasis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextTextWidthBasis not supported on web");
    return factories.SelectableText_readBack_textWidthBasis(nativeStruct);
  }
  public boolean selectionEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextSelectionEnabled not supported on web");
    return factories.SelectableText_readBack_selectionEnabled(nativeStruct);
  }
  @Override
  public SelectableText build() {
    return this;
  }
}
