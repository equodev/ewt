package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PopupMenuItemObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class PopupMenuItem<T> extends PopupMenuEntry<T> implements PopupMenuItemI {
  private MemorySegment st;
  protected PopupMenuItem() {}
  PopupMenuItem(MemorySegment st) {
    this.id = PopupMenuItemObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget PopupMenuItem");
    System.out.println("New PopupMenuItem id:"+id);
  }
  PopupMenuItem(int id) { this.id = id; }
  @Builder.Factory
  static <T extends NativeObj> PopupMenuItem<T> popupMenuItemPopupMenuItem(Optional<NativeObj> value, Optional<Runnable> onTap, Optional<Boolean> enabled, OptionalDouble height, Optional<EdgeInsetsI> padding, Optional<TextStyleI> textStyle, Optional<TextStyleI> labelTextStyle, WidgetI child) {
    var st = factories.popupMenuItemPopupMenuItem(value,
      onTap,
      enabled,
      height,
      padding.map(EdgeInsetsI::build),
      textStyle.map(TextStyleI::build),
      labelTextStyle.map(TextStyleI::build),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget PopupMenuItem");
    return new PopupMenuItem(st);
  }
  public static <T extends NativeObj> PopupMenuItemPopupMenuItemBuilder<T> popupMenuItem() {
    return PopupMenuItemPopupMenuItemBuilder.popupMenuItemPopupMenuItem();
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuItemEnabled not supported on web");
    return intToBool(PopupMenuItemObjSt.enabled(st));
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuItemHeight not supported on web");
    return PopupMenuItemObjSt.height(st);
  }
  public EdgeInsets padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuItemPadding", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.EdgeInsetsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.EdgeInsetsObjSt.id(__st, __nid);
      return new EdgeInsets(__st);
    }
    return new EdgeInsets(PopupMenuItemObjSt.padding(st));
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuItemTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(PopupMenuItemObjSt.textStyle(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuItemChild not supported on web");
    return new Widget(PopupMenuItemObjSt.child(st)) {};
  }
  @Override
  public PopupMenuItem build() {
    return this;
  }
}
