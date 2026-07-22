package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.IconObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Icon extends StatelessWidget implements IconI {
  private MemorySegment st;
  protected Icon() {}
  Icon(MemorySegment st) {
    this.id = IconObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Icon");
    System.out.println("New Icon id:"+id);
  }
  @Builder.Factory
  static Icon iconIcon(@Builder.Parameter IconDataI icon, OptionalDouble size, OptionalDouble fill, OptionalDouble weight, OptionalDouble grade, OptionalDouble opticalSize, Optional<ColorI> color, Optional<List<ShadowI>> shadows, Optional<String> semanticLabel, Optional<TextDirection> textDirection, Optional<Boolean> applyTextScaling, Optional<BlendMode> blendMode, Optional<FontWeightI> fontWeight) {
    var st = factories.iconIcon(icon.build(),
      size,
      fill,
      weight,
      grade,
      opticalSize,
      color.map(ColorI::build),
      shadows.map(i -> i.stream().map(ShadowI::build).toList()),
      semanticLabel,
      textDirection,
      applyTextScaling,
      blendMode,
      fontWeight.map(FontWeightI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Icon");
    return new Icon(st);
  }
  public static IconIconBuilder icon(IconDataI icon) {
    return IconIconBuilder.iconIcon(icon);
  }
  public IconData icon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconIcon", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconDataObjSt.id(__st, __nid);
      return new IconData(__st);
    }
    return new IconData(IconObjSt.icon(st));
  }
  public double size() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconSize not supported on web");
    return IconObjSt.size(st);
  }
  public double fill() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconFill not supported on web");
    return IconObjSt.fill(st);
  }
  public double weight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconWeight not supported on web");
    return IconObjSt.weight(st);
  }
  public double grade() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconGrade not supported on web");
    return IconObjSt.grade(st);
  }
  public double opticalSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconOpticalSize not supported on web");
    return IconObjSt.opticalSize(st);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconColor", getId());
      return new Color(__nid);
    }
    return new Color(IconObjSt.color(st));
  }
  public String semanticLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconSemanticLabel not supported on web");
    return IconObjSt.semanticLabel(st).getString(0);
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconTextDirection not supported on web");
    return TextDirection.values()[IconObjSt.textDirection(st)];
  }
  public boolean applyTextScaling() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconApplyTextScaling not supported on web");
    return intToBool(IconObjSt.applyTextScaling(st));
  }
  public BlendMode blendMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconBlendMode not supported on web");
    return BlendMode.values()[IconObjSt.blendMode(st)];
  }
  public FontWeight fontWeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconFontWeight", getId());
      return new FontWeight(__nid);
    }
    return new FontWeight(IconObjSt.fontWeight(st));
  }
  @Override
  public Icon build() {
    return this;
  }
}
