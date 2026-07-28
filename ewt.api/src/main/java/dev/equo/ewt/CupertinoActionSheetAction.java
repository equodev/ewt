package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoActionSheetActionObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoActionSheetAction extends StatefulWidget implements CupertinoActionSheetActionI {
  private MemorySegment st;
  protected CupertinoActionSheetAction() {}
  CupertinoActionSheetAction(MemorySegment st) {
    this.id = CupertinoActionSheetActionObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoActionSheetAction");
    System.out.println("New CupertinoActionSheetAction id:"+id);
  }
  CupertinoActionSheetAction(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoActionSheetAction cupertinoActionSheetActionCupertinoActionSheetAction(@Builder.Parameter Runnable onPressed, Optional<Boolean> isDefaultAction, Optional<Boolean> isDestructiveAction, WidgetI child) {
    var st = factories.cupertinoActionSheetActionCupertinoActionSheetAction(onPressed,
      isDefaultAction,
      isDestructiveAction,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoActionSheetAction");
    return new CupertinoActionSheetAction(st);
  }
  public static CupertinoActionSheetActionCupertinoActionSheetActionBuilder cupertinoActionSheetAction(Runnable onPressed) {
    return CupertinoActionSheetActionCupertinoActionSheetActionBuilder.cupertinoActionSheetActionCupertinoActionSheetAction(onPressed);
  }
  public boolean isDefaultAction() {
    return intToBool(CupertinoActionSheetActionObjSt.isDefaultAction(st));
  }
  public boolean isDestructiveAction() {
    return intToBool(CupertinoActionSheetActionObjSt.isDestructiveAction(st));
  }
  public Widget child() {
    return new Widget(CupertinoActionSheetActionObjSt.child(st)) {};
  }
  @Override
  public CupertinoActionSheetAction build() {
    return this;
  }
}
