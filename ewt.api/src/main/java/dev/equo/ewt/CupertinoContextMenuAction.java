package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoContextMenuActionObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoContextMenuAction extends StatefulWidget implements CupertinoContextMenuActionI {
  private MemorySegment st;
  protected CupertinoContextMenuAction() {}
  CupertinoContextMenuAction(MemorySegment st) {
    this.id = CupertinoContextMenuActionObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoContextMenuAction");
    System.out.println("New CupertinoContextMenuAction id:"+id);
  }
  CupertinoContextMenuAction(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoContextMenuAction cupertinoContextMenuActionCupertinoContextMenuAction(@Builder.Parameter WidgetI child, Optional<Boolean> isDefaultAction, Optional<Boolean> isDestructiveAction, Optional<Runnable> onPressed, Optional<IconDataI> trailingIcon) {
    var st = factories.cupertinoContextMenuActionCupertinoContextMenuAction(child.build(),
      isDefaultAction,
      isDestructiveAction,
      onPressed,
      trailingIcon.map(IconDataI::build));
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoContextMenuAction");
    return new CupertinoContextMenuAction(st);
  }
  public static CupertinoContextMenuActionCupertinoContextMenuActionBuilder cupertinoContextMenuAction(WidgetI child) {
    return CupertinoContextMenuActionCupertinoContextMenuActionBuilder.cupertinoContextMenuActionCupertinoContextMenuAction(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoContextMenuActionChild not supported on web");
    return new Widget(CupertinoContextMenuActionObjSt.child(st)) {};
  }
  public boolean isDefaultAction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoContextMenuActionIsDefaultAction not supported on web");
    return intToBool(CupertinoContextMenuActionObjSt.isDefaultAction(st));
  }
  public boolean isDestructiveAction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoContextMenuActionIsDestructiveAction not supported on web");
    return intToBool(CupertinoContextMenuActionObjSt.isDestructiveAction(st));
  }
  public IconData trailingIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoContextMenuActionTrailingIcon", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconDataObjSt.id(__st, __nid);
      return new IconData(__st);
    }
    return new IconData(CupertinoContextMenuActionObjSt.trailingIcon(st));
  }
  @Override
  public CupertinoContextMenuAction build() {
    return this;
  }
}
