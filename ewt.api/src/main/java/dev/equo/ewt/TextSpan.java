package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
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
    System.out.println("New TextSpan id:"+id);
  }
  @Builder.Factory
  static TextSpan textSpanTextSpan(Optional<String> text, Optional<List<InlineSpanI>> children, Optional<TextStyleI> style, Optional<String> semanticsLabel, Optional<Boolean> spellOut) {
    var st = factories.textSpanTextSpan(text,
      children.map(i -> i.stream().map(InlineSpanI::build).toList()),
      style.map(TextStyleI::build),
      semanticsLabel,
      spellOut);
    if (st == null) throw new RuntimeException("Failed to created widget TextSpan");
    return new TextSpan(st);
  }
  public static TextSpanTextSpanBuilder textSpan() {
    return TextSpanTextSpanBuilder.textSpanTextSpan();
  }
  public String text() {
    return TextSpanObjSt.text(st).getString(0);
  }
  public String semanticsLabel() {
    return TextSpanObjSt.semanticsLabel(st).getString(0);
  }
  public boolean spellOut() {
    return intToBool(TextSpanObjSt.spellOut(st));
  }
  @Override
  public TextSpan build() {
    return this;
  }
}
