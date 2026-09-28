package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TextSpan extends InlineSpan implements TextSpanI {
  protected TextSpan() {}
  TextSpan(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TextSpan");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TextSpan textSpanTextSpan(Optional<String> text, Optional<List<InlineSpanI>> children, Optional<TextStyleI> style, Optional<Consumer<PointerEnterEvent>> onEnter, Optional<Consumer<PointerExitEvent>> onExit, Optional<String> semanticsLabel, Optional<String> semanticsIdentifier, Optional<Boolean> spellOut) {
    int id = factories.textSpanTextSpan(text,
      children.map(i -> i.stream().map(InlineSpanI::build).collect(java.util.stream.Collectors.toList())),
      style.map(TextStyleI::build),
      onEnter,
      onExit,
      semanticsLabel,
      semanticsIdentifier,
      spellOut);
    if (id <= 0) throw new RuntimeException("Failed to created widget TextSpan");
    return new TextSpan(id);
  }
  public static TextSpanTextSpanBuilder textSpan() {
    return TextSpanTextSpanBuilder.textSpanTextSpan();
  }
  public String text() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textSpanText not supported on web");
    return factories.TextSpan_readBack_text(nativeStruct);
  }
  public String semanticsLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textSpanSemanticsLabel not supported on web");
    return factories.TextSpan_readBack_semanticsLabel(nativeStruct);
  }
  public String semanticsIdentifier() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textSpanSemanticsIdentifier not supported on web");
    return factories.TextSpan_readBack_semanticsIdentifier(nativeStruct);
  }
  public boolean spellOut() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textSpanSpellOut not supported on web");
    return factories.TextSpan_readBack_spellOut(nativeStruct);
  }
  @Override
  public TextSpan build() {
    return this;
  }
}
