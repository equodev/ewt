package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AnimatedDefaultTextStyle extends ImplicitlyAnimatedWidget implements AnimatedDefaultTextStyleI {
  protected AnimatedDefaultTextStyle() {}
  AnimatedDefaultTextStyle(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedDefaultTextStyle");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AnimatedDefaultTextStyle animatedDefaultTextStyleAnimatedDefaultTextStyle(@Builder.Parameter WidgetI child, @Builder.Parameter TextStyleI style, Optional<TextAlign> textAlign, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalInt maxLines, Optional<TextWidthBasis> textWidthBasis, Optional<CurveI> curve, DurationI duration, Optional<Runnable> onEnd) {
    int id = factories.animatedDefaultTextStyleAnimatedDefaultTextStyle(child.build(),
      style.build(),
      textAlign,
      softWrap,
      overflow,
      maxLines,
      textWidthBasis,
      curve.map(CurveI::build),
      duration.build(),
      onEnd);
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedDefaultTextStyle");
    return new AnimatedDefaultTextStyle(id);
  }
  public static AnimatedDefaultTextStyleAnimatedDefaultTextStyleBuilder animatedDefaultTextStyle(WidgetI child, TextStyleI style) {
    return AnimatedDefaultTextStyleAnimatedDefaultTextStyleBuilder.animatedDefaultTextStyleAnimatedDefaultTextStyle(child, style);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedDefaultTextStyleChild not supported on web");
    return factories.AnimatedDefaultTextStyle_readBack_child(nativeStruct);
  }
  public TextStyle style() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("animatedDefaultTextStyleStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.AnimatedDefaultTextStyle_readBack_style(nativeStruct);
  }
  public TextAlign textAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedDefaultTextStyleTextAlign not supported on web");
    return factories.AnimatedDefaultTextStyle_readBack_textAlign(nativeStruct);
  }
  public boolean softWrap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedDefaultTextStyleSoftWrap not supported on web");
    return factories.AnimatedDefaultTextStyle_readBack_softWrap(nativeStruct);
  }
  public TextOverflow overflow() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedDefaultTextStyleOverflow not supported on web");
    return factories.AnimatedDefaultTextStyle_readBack_overflow(nativeStruct);
  }
  public int maxLines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedDefaultTextStyleMaxLines not supported on web");
    return factories.AnimatedDefaultTextStyle_readBack_maxLines(nativeStruct);
  }
  public TextWidthBasis textWidthBasis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedDefaultTextStyleTextWidthBasis not supported on web");
    return factories.AnimatedDefaultTextStyle_readBack_textWidthBasis(nativeStruct);
  }
  @Override
  public AnimatedDefaultTextStyle build() {
    return this;
  }
}
