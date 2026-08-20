package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TabPageSelectorIndicatorObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TabPageSelectorIndicator extends StatelessWidget implements TabPageSelectorIndicatorI {
  private MemorySegment st;
  protected TabPageSelectorIndicator() {}
  TabPageSelectorIndicator(MemorySegment st) {
    this.id = TabPageSelectorIndicatorObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TabPageSelectorIndicator");
    System.out.println("New TabPageSelectorIndicator id:"+id);
  }
  TabPageSelectorIndicator(int id) { this.id = id; }
  @Builder.Factory
  static TabPageSelectorIndicator tabPageSelectorIndicatorTabPageSelectorIndicator(@Builder.Parameter ColorI backgroundColor, @Builder.Parameter ColorI borderColor, @Builder.Parameter double size, Optional<BorderStyle> borderStyle) {
    var st = factories.tabPageSelectorIndicatorTabPageSelectorIndicator(backgroundColor.build(),
      borderColor.build(),
      size,
      borderStyle);
    if (st == null) throw new RuntimeException("Failed to created widget TabPageSelectorIndicator");
    return new TabPageSelectorIndicator(st);
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
    return new Color(TabPageSelectorIndicatorObjSt.backgroundColor(st));
  }
  public Color borderColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabPageSelectorIndicatorBorderColor", getId());
      return new Color(__nid);
    }
    return new Color(TabPageSelectorIndicatorObjSt.borderColor(st));
  }
  public double size() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabPageSelectorIndicatorSize not supported on web");
    return TabPageSelectorIndicatorObjSt.size(st);
  }
  public BorderStyle borderStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabPageSelectorIndicatorBorderStyle not supported on web");
    return BorderStyle.values()[TabPageSelectorIndicatorObjSt.borderStyle(st)];
  }
  @Override
  public TabPageSelectorIndicator build() {
    return this;
  }
}
