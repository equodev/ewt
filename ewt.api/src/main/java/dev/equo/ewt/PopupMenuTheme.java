package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PopupMenuThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class PopupMenuTheme extends InheritedTheme implements PopupMenuThemeI {
  private MemorySegment st;
  protected PopupMenuTheme() {}
  PopupMenuTheme(MemorySegment st) {
    this.id = PopupMenuThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget PopupMenuTheme");
    System.out.println("New PopupMenuTheme id:"+id);
  }
  PopupMenuTheme(int id) { this.id = id; }
  @Builder.Factory
  static PopupMenuTheme popupMenuThemePopupMenuTheme(@Builder.Parameter PopupMenuThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.popupMenuThemePopupMenuTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget PopupMenuTheme");
    return new PopupMenuTheme(st);
  }
  public static PopupMenuThemePopupMenuThemeBuilder popupMenuTheme(PopupMenuThemeDataI data, WidgetI child) {
    return PopupMenuThemePopupMenuThemeBuilder.popupMenuThemePopupMenuTheme(data, child);
  }
  public static PopupMenuThemeData of(BuildContextI context) {
    var st = factories.popupMenuThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget PopupMenuThemeData");
    return new PopupMenuThemeData(st);
  }
  public PopupMenuThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.PopupMenuThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.PopupMenuThemeDataObjSt.id(__st, __nid);
      return new PopupMenuThemeData(__st);
    }
    return new PopupMenuThemeData(PopupMenuThemeObjSt.data(st));
  }
  @Override
  public PopupMenuTheme build() {
    return this;
  }
}
