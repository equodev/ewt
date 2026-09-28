package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TabPageSelector extends StatefulWidget implements TabPageSelectorI {
  protected TabPageSelector() {}
  TabPageSelector(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TabPageSelector");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TabPageSelector tabPageSelectorTabPageSelector(OptionalDouble indicatorSize, Optional<ColorI> color, Optional<ColorI> selectedColor, Optional<BorderStyle> borderStyle) {
    int id = factories.tabPageSelectorTabPageSelector(indicatorSize,
      color.map(ColorI::build),
      selectedColor.map(ColorI::build),
      borderStyle);
    if (id <= 0) throw new RuntimeException("Failed to created widget TabPageSelector");
    return new TabPageSelector(id);
  }
  public static TabPageSelectorTabPageSelectorBuilder tabPageSelector() {
    return TabPageSelectorTabPageSelectorBuilder.tabPageSelectorTabPageSelector();
  }
  public double indicatorSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabPageSelectorIndicatorSize not supported on web");
    return factories.TabPageSelector_readBack_indicatorSize(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabPageSelectorColor", getId());
      return new Color(__nid);
    }
    return factories.TabPageSelector_readBack_color(nativeStruct);
  }
  public Color selectedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabPageSelectorSelectedColor", getId());
      return new Color(__nid);
    }
    return factories.TabPageSelector_readBack_selectedColor(nativeStruct);
  }
  public BorderStyle borderStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabPageSelectorBorderStyle not supported on web");
    return factories.TabPageSelector_readBack_borderStyle(nativeStruct);
  }
  @Override
  public TabPageSelector build() {
    return this;
  }
}
