package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AnimatedDefaultTextStyleObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AnimatedDefaultTextStyle extends ImplicitlyAnimatedWidget implements AnimatedDefaultTextStyleI {
  private MemorySegment st;
  protected AnimatedDefaultTextStyle() {}
  AnimatedDefaultTextStyle(MemorySegment st) {
    this.id = AnimatedDefaultTextStyleObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedDefaultTextStyle");
    System.out.println("New AnimatedDefaultTextStyle id:"+id);
  }
  AnimatedDefaultTextStyle(int id) { this.id = id; }
  @Builder.Factory
  static AnimatedDefaultTextStyle animatedDefaultTextStyleAnimatedDefaultTextStyle(@Builder.Parameter WidgetI child, @Builder.Parameter TextStyleI style, Optional<TextAlign> textAlign, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalInt maxLines, Optional<TextWidthBasis> textWidthBasis, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd) {
    var st = factories.animatedDefaultTextStyleAnimatedDefaultTextStyle(child.build(),
      style.build(),
      textAlign,
      softWrap,
      overflow,
      maxLines,
      textWidthBasis,
      curve.map(CurveI::build),
      duration.build(),
      onEnd);
    if (st == null) throw new RuntimeException("Failed to created widget AnimatedDefaultTextStyle");
    return new AnimatedDefaultTextStyle(st);
  }
  public static AnimatedDefaultTextStyleAnimatedDefaultTextStyleBuilder animatedDefaultTextStyle(WidgetI child, TextStyleI style) {
    return AnimatedDefaultTextStyleAnimatedDefaultTextStyleBuilder.animatedDefaultTextStyleAnimatedDefaultTextStyle(child, style);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedDefaultTextStyleChild not supported on web");
    return new Widget(AnimatedDefaultTextStyleObjSt.child(st)) {};
  }
  public TextStyle style() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedDefaultTextStyleStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(AnimatedDefaultTextStyleObjSt.style(st));
  }
  public TextAlign textAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedDefaultTextStyleTextAlign not supported on web");
    return TextAlign.values()[AnimatedDefaultTextStyleObjSt.textAlign(st)];
  }
  public boolean softWrap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedDefaultTextStyleSoftWrap not supported on web");
    return intToBool(AnimatedDefaultTextStyleObjSt.softWrap(st));
  }
  public TextOverflow overflow() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedDefaultTextStyleOverflow not supported on web");
    return TextOverflow.values()[AnimatedDefaultTextStyleObjSt.overflow(st)];
  }
  public int maxLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedDefaultTextStyleMaxLines not supported on web");
    return AnimatedDefaultTextStyleObjSt.maxLines(st);
  }
  public TextWidthBasis textWidthBasis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedDefaultTextStyleTextWidthBasis not supported on web");
    return TextWidthBasis.values()[AnimatedDefaultTextStyleObjSt.textWidthBasis(st)];
  }
  @Override
  public AnimatedDefaultTextStyle build() {
    return this;
  }
}
