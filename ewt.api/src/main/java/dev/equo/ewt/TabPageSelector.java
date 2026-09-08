package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TabPageSelectorObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TabPageSelector extends StatefulWidget implements TabPageSelectorI {
  private MemorySegment st;
  protected TabPageSelector() {}
  TabPageSelector(MemorySegment st) {
    this.id = TabPageSelectorObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TabPageSelector");
    System.out.println("New TabPageSelector id:"+id);
  }
  TabPageSelector(int id) { this.id = id; }
  @Builder.Factory
  static TabPageSelector tabPageSelectorTabPageSelector(OptionalDouble indicatorSize, Optional<ColorI> color, Optional<ColorI> selectedColor, Optional<BorderStyle> borderStyle) {
    var st = factories.tabPageSelectorTabPageSelector(indicatorSize,
      color.map(ColorI::build),
      selectedColor.map(ColorI::build),
      borderStyle);
    if (st == null) throw new RuntimeException("Failed to created widget TabPageSelector");
    return new TabPageSelector(st);
  }
  public static TabPageSelectorTabPageSelectorBuilder tabPageSelector() {
    return TabPageSelectorTabPageSelectorBuilder.tabPageSelectorTabPageSelector();
  }
  public double indicatorSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabPageSelectorIndicatorSize not supported on web");
    return TabPageSelectorObjSt.indicatorSize(st);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabPageSelectorColor", getId());
      return new Color(__nid);
    }
    return new Color(TabPageSelectorObjSt.color(st));
  }
  public Color selectedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabPageSelectorSelectedColor", getId());
      return new Color(__nid);
    }
    return new Color(TabPageSelectorObjSt.selectedColor(st));
  }
  public BorderStyle borderStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabPageSelectorBorderStyle not supported on web");
    return BorderStyle.values()[TabPageSelectorObjSt.borderStyle(st)];
  }
  @Override
  public TabPageSelector build() {
    return this;
  }
}
