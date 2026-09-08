package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ActionIconThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ActionIconTheme extends InheritedTheme implements ActionIconThemeI {
  private MemorySegment st;
  protected ActionIconTheme() {}
  ActionIconTheme(MemorySegment st) {
    this.id = ActionIconThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ActionIconTheme");
    System.out.println("New ActionIconTheme id:"+id);
  }
  ActionIconTheme(int id) { this.id = id; }
  @Builder.Factory
  static ActionIconTheme actionIconThemeActionIconTheme(@Builder.Parameter ActionIconThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.actionIconThemeActionIconTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget ActionIconTheme");
    return new ActionIconTheme(st);
  }
  public static ActionIconThemeActionIconThemeBuilder actionIconTheme(ActionIconThemeDataI data, WidgetI child) {
    return ActionIconThemeActionIconThemeBuilder.actionIconThemeActionIconTheme(data, child);
  }
  public static ActionIconThemeData of(BuildContextI context) {
    var st = factories.actionIconThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget ActionIconThemeData");
    return new ActionIconThemeData(st);
  }
  public ActionIconThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("actionIconThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.ActionIconThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.ActionIconThemeDataObjSt.id(__st, __nid);
      return new ActionIconThemeData(__st);
    }
    return new ActionIconThemeData(ActionIconThemeObjSt.data(st));
  }
  @Override
  public ActionIconTheme build() {
    return this;
  }
}
