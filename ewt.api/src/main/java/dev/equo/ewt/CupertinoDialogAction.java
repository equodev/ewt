package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoDialogActionObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoDialogAction extends StatefulWidget implements CupertinoDialogActionI {
  private MemorySegment st;
  protected CupertinoDialogAction() {}
  CupertinoDialogAction(MemorySegment st) {
    this.id = CupertinoDialogActionObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoDialogAction");
    System.out.println("New CupertinoDialogAction id:"+id);
  }
  CupertinoDialogAction(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoDialogAction cupertinoDialogActionCupertinoDialogAction(Optional<Runnable> onPressed, Optional<Boolean> isDefaultAction, Optional<Boolean> isDestructiveAction, Optional<TextStyleI> textStyle, WidgetI child) {
    var st = factories.cupertinoDialogActionCupertinoDialogAction(onPressed,
      isDefaultAction,
      isDestructiveAction,
      textStyle.map(TextStyleI::build),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoDialogAction");
    return new CupertinoDialogAction(st);
  }
  public static CupertinoDialogActionCupertinoDialogActionBuilder cupertinoDialogAction() {
    return CupertinoDialogActionCupertinoDialogActionBuilder.cupertinoDialogActionCupertinoDialogAction();
  }
  public boolean isDefaultAction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoDialogActionIsDefaultAction not supported on web");
    return intToBool(CupertinoDialogActionObjSt.isDefaultAction(st));
  }
  public boolean isDestructiveAction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoDialogActionIsDestructiveAction not supported on web");
    return intToBool(CupertinoDialogActionObjSt.isDestructiveAction(st));
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoDialogActionTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(CupertinoDialogActionObjSt.textStyle(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoDialogActionChild not supported on web");
    return new Widget(CupertinoDialogActionObjSt.child(st)) {};
  }
  @Override
  public CupertinoDialogAction build() {
    return this;
  }
}
