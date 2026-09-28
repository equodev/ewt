package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ActionIconThemeData extends NativeObj.Base implements ActionIconThemeDataI {
  protected ActionIconThemeData() {}
  ActionIconThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ActionIconThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ActionIconThemeData actionIconThemeDataActionIconThemeData(Optional<Function<BuildContext, Widget>> backButtonIconBuilder, Optional<Function<BuildContext, Widget>> closeButtonIconBuilder, Optional<Function<BuildContext, Widget>> drawerButtonIconBuilder, Optional<Function<BuildContext, Widget>> endDrawerButtonIconBuilder) {
    int id = factories.actionIconThemeDataActionIconThemeData(backButtonIconBuilder,
      closeButtonIconBuilder,
      drawerButtonIconBuilder,
      endDrawerButtonIconBuilder);
    if (id <= 0) throw new RuntimeException("Failed to created widget ActionIconThemeData");
    return new ActionIconThemeData(id);
  }
  public static ActionIconThemeDataActionIconThemeDataBuilder actionIconThemeData() {
    return ActionIconThemeDataActionIconThemeDataBuilder.actionIconThemeDataActionIconThemeData();
  }
  public static ActionIconThemeData lerp(ActionIconThemeDataI a, ActionIconThemeDataI b, double t) {
    int id = factories.actionIconThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget ActionIconThemeData");
    return new ActionIconThemeData(id);
  }
  @Override
  public ActionIconThemeData build() {
    return this;
  }
}
