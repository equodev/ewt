package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ActionIconThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ActionIconThemeData extends NativeObj.Base implements ActionIconThemeDataI {
  private MemorySegment st;
  protected ActionIconThemeData() {}
  ActionIconThemeData(MemorySegment st) {
    this.id = ActionIconThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ActionIconThemeData");
    System.out.println("New ActionIconThemeData id:"+id);
  }
  ActionIconThemeData(int id) { this.id = id; }
  @Builder.Factory
  static ActionIconThemeData actionIconThemeDataActionIconThemeData(Optional<Function<BuildContext, Widget>> backButtonIconBuilder, Optional<Function<BuildContext, Widget>> closeButtonIconBuilder, Optional<Function<BuildContext, Widget>> drawerButtonIconBuilder, Optional<Function<BuildContext, Widget>> endDrawerButtonIconBuilder) {
    var st = factories.actionIconThemeDataActionIconThemeData(backButtonIconBuilder,
      closeButtonIconBuilder,
      drawerButtonIconBuilder,
      endDrawerButtonIconBuilder);
    if (st == null) throw new RuntimeException("Failed to created widget ActionIconThemeData");
    return new ActionIconThemeData(st);
  }
  public static ActionIconThemeDataActionIconThemeDataBuilder actionIconThemeData() {
    return ActionIconThemeDataActionIconThemeDataBuilder.actionIconThemeDataActionIconThemeData();
  }
  public static ActionIconThemeData lerp(ActionIconThemeDataI a, ActionIconThemeDataI b, double t) {
    var st = factories.actionIconThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget ActionIconThemeData");
    return new ActionIconThemeData(st);
  }
  @Override
  public ActionIconThemeData build() {
    return this;
  }
}
