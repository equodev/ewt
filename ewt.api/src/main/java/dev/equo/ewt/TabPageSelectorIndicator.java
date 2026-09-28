package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TabPageSelectorIndicator extends StatelessWidget implements TabPageSelectorIndicatorI {
  protected TabPageSelectorIndicator() {}
  TabPageSelectorIndicator(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TabPageSelectorIndicator");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TabPageSelectorIndicator tabPageSelectorIndicatorTabPageSelectorIndicator(@Builder.Parameter ColorI backgroundColor, @Builder.Parameter ColorI borderColor, @Builder.Parameter double size, Optional<BorderStyle> borderStyle) {
    int id = factories.tabPageSelectorIndicatorTabPageSelectorIndicator(backgroundColor.build(),
      borderColor.build(),
      size,
      borderStyle);
    if (id <= 0) throw new RuntimeException("Failed to created widget TabPageSelectorIndicator");
    return new TabPageSelectorIndicator(id);
  }
  public static TabPageSelectorIndicatorTabPageSelectorIndicatorBuilder tabPageSelectorIndicator(ColorI backgroundColor, ColorI borderColor, double size) {
    return TabPageSelectorIndicatorTabPageSelectorIndicatorBuilder.tabPageSelectorIndicatorTabPageSelectorIndicator(backgroundColor, borderColor, size);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabPageSelectorIndicatorBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.TabPageSelectorIndicator_readBack_backgroundColor(nativeStruct);
  }
  public Color borderColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabPageSelectorIndicatorBorderColor", getId());
      return new Color(__nid);
    }
    return factories.TabPageSelectorIndicator_readBack_borderColor(nativeStruct);
  }
  public double size() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabPageSelectorIndicatorSize not supported on web");
    return factories.TabPageSelectorIndicator_readBack_size(nativeStruct);
  }
  public BorderStyle borderStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabPageSelectorIndicatorBorderStyle not supported on web");
    return factories.TabPageSelectorIndicator_readBack_borderStyle(nativeStruct);
  }
  @Override
  public TabPageSelectorIndicator build() {
    return this;
  }
}
