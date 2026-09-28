package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ColoredBox extends SingleChildRenderObjectWidget implements ColoredBoxI {
  protected ColoredBox() {}
  ColoredBox(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ColoredBox");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ColoredBox coloredBoxColoredBox(@Builder.Parameter ColorI color, Optional<Boolean> isAntiAlias, Optional<WidgetI> child) {
    int id = factories.coloredBoxColoredBox(color.build(),
      isAntiAlias,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ColoredBox");
    return new ColoredBox(id);
  }
  public static ColoredBoxColoredBoxBuilder coloredBox(ColorI color) {
    return ColoredBoxColoredBoxBuilder.coloredBoxColoredBox(color);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("coloredBoxColor", getId());
      return new Color(__nid);
    }
    return factories.ColoredBox_readBack_color(nativeStruct);
  }
  public boolean isAntiAlias() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("coloredBoxIsAntiAlias not supported on web");
    return factories.ColoredBox_readBack_isAntiAlias(nativeStruct);
  }
  @Override
  public ColoredBox build() {
    return this;
  }
}
