package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TextSpanObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TextSpan extends InlineSpan implements TextSpanI {
  private MemorySegment st;
  protected TextSpan() {}
  TextSpan(MemorySegment st) {
    this.id = TextSpanObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TextSpan");
    System.out.println("New TextSpan id:"+id);
  }
  TextSpan(int id) { this.id = id; }
  @Builder.Factory
  static TextSpan textSpanTextSpan(Optional<String> text, Optional<List<InlineSpanI>> children, Optional<TextStyleI> style, Optional<String> semanticsLabel, Optional<String> semanticsIdentifier, Optional<Boolean> spellOut) {
    var st = factories.textSpanTextSpan(text,
      children.map(i -> i.stream().map(InlineSpanI::build).toList()),
      style.map(TextStyleI::build),
      semanticsLabel,
      semanticsIdentifier,
      spellOut);
    if (st == null) throw new RuntimeException("Failed to created widget TextSpan");
    return new TextSpan(st);
  }
  public static TextSpanTextSpanBuilder textSpan() {
    return TextSpanTextSpanBuilder.textSpanTextSpan();
  }
  public String text() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textSpanText not supported on web");
    return TextSpanObjSt.text(st).getString(0);
  }
  public String semanticsLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textSpanSemanticsLabel not supported on web");
    return TextSpanObjSt.semanticsLabel(st).getString(0);
  }
  public String semanticsIdentifier() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textSpanSemanticsIdentifier not supported on web");
    return TextSpanObjSt.semanticsIdentifier(st).getString(0);
  }
  public boolean spellOut() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textSpanSpellOut not supported on web");
    return intToBool(TextSpanObjSt.spellOut(st));
  }
  @Override
  public TextSpan build() {
    return this;
  }
}
