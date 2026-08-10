package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SelectableTextObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SelectableText extends StatefulWidget implements SelectableTextI {
  private MemorySegment st;
  protected SelectableText() {}
  SelectableText(MemorySegment st) {
    this.id = SelectableTextObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SelectableText");
    System.out.println("New SelectableText id:"+id);
  }
  SelectableText(int id) { this.id = id; }
  @Builder.Factory
  static SelectableText selectableTextSelectableText(@Builder.Parameter String data, Optional<TextStyleI> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, OptionalDouble textScaleFactor, Optional<Boolean> showCursor, Optional<Boolean> autofocus, OptionalInt minLines, OptionalInt maxLines, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<RadiusI> cursorRadius, Optional<ColorI> cursorColor, Optional<ColorI> selectionColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Runnable> onTap, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis) {
    var st = factories.selectableTextSelectableText(data,
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
    if (st == null) throw new RuntimeException("Failed to created widget SelectableText");
    return new SelectableText(st);
  }
  public static SelectableTextSelectableTextBuilder selectableText(String data) {
    return SelectableTextSelectableTextBuilder.selectableTextSelectableText(data);
  }
  @Builder.Factory
  static SelectableText selectableTextRich(@Builder.Parameter TextSpanI textSpan, Optional<TextStyleI> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, OptionalDouble textScaleFactor, Optional<Boolean> showCursor, Optional<Boolean> autofocus, OptionalInt minLines, OptionalInt maxLines, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<RadiusI> cursorRadius, Optional<ColorI> cursorColor, Optional<ColorI> selectionColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Runnable> onTap, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis) {
    var st = factories.selectableTextRich(textSpan.build(),
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
    if (st == null) throw new RuntimeException("Failed to created widget SelectableText");
    return new SelectableText(st);
  }
  public static SelectableTextRichBuilder rich(TextSpanI textSpan) {
    return SelectableTextRichBuilder.selectableTextRich(textSpan);
  }
  public String data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextData not supported on web");
    return SelectableTextObjSt.data(st).getString(0);
  }
  public TextSpan textSpan() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("selectableTextTextSpan", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextSpanObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextSpanObjSt.id(__st, __nid);
      return new TextSpan(__st);
    }
    return new TextSpan(SelectableTextObjSt.textSpan(st));
  }
  public TextStyle style() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("selectableTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(SelectableTextObjSt.style(st));
  }
  public TextAlign textAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextTextAlign not supported on web");
    return TextAlign.values()[SelectableTextObjSt.textAlign(st)];
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextTextDirection not supported on web");
    return TextDirection.values()[SelectableTextObjSt.textDirection(st)];
  }
  public double textScaleFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextTextScaleFactor not supported on web");
    return SelectableTextObjSt.textScaleFactor(st);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextAutofocus not supported on web");
    return intToBool(SelectableTextObjSt.autofocus(st));
  }
  public int minLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextMinLines not supported on web");
    return SelectableTextObjSt.minLines(st);
  }
  public int maxLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextMaxLines not supported on web");
    return SelectableTextObjSt.maxLines(st);
  }
  public boolean showCursor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextShowCursor not supported on web");
    return intToBool(SelectableTextObjSt.showCursor(st));
  }
  public double cursorWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextCursorWidth not supported on web");
    return SelectableTextObjSt.cursorWidth(st);
  }
  public double cursorHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextCursorHeight not supported on web");
    return SelectableTextObjSt.cursorHeight(st);
  }
  public Radius cursorRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("selectableTextCursorRadius", getId());
      return new Radius(__nid);
    }
    return new Radius(SelectableTextObjSt.cursorRadius(st));
  }
  public Color cursorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("selectableTextCursorColor", getId());
      return new Color(__nid);
    }
    return new Color(SelectableTextObjSt.cursorColor(st));
  }
  public Color selectionColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("selectableTextSelectionColor", getId());
      return new Color(__nid);
    }
    return new Color(SelectableTextObjSt.selectionColor(st));
  }
  public BoxHeightStyle selectionHeightStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextSelectionHeightStyle not supported on web");
    return BoxHeightStyle.values()[SelectableTextObjSt.selectionHeightStyle(st)];
  }
  public BoxWidthStyle selectionWidthStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextSelectionWidthStyle not supported on web");
    return BoxWidthStyle.values()[SelectableTextObjSt.selectionWidthStyle(st)];
  }
  public boolean enableInteractiveSelection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextEnableInteractiveSelection not supported on web");
    return intToBool(SelectableTextObjSt.enableInteractiveSelection(st));
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextDragStartBehavior not supported on web");
    return DragStartBehavior.values()[SelectableTextObjSt.dragStartBehavior(st)];
  }
  public String semanticsLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextSemanticsLabel not supported on web");
    return SelectableTextObjSt.semanticsLabel(st).getString(0);
  }
  public TextWidthBasis textWidthBasis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextTextWidthBasis not supported on web");
    return TextWidthBasis.values()[SelectableTextObjSt.textWidthBasis(st)];
  }
  public boolean selectionEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectableTextSelectionEnabled not supported on web");
    return intToBool(SelectableTextObjSt.selectionEnabled(st));
  }
  @Override
  public SelectableText build() {
    return this;
  }
}
