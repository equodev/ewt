package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoContextMenu extends StatefulWidget implements CupertinoContextMenuI {
  protected CupertinoContextMenu() {}
  CupertinoContextMenu(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoContextMenu");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoContextMenu cupertinoContextMenuCupertinoContextMenu(@Builder.Parameter List<WidgetI> actions, @Builder.Parameter WidgetI child, Optional<Boolean> enableHapticFeedback) {
    int id = factories.cupertinoContextMenuCupertinoContextMenu(actions.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()),
      child.build(),
      enableHapticFeedback);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoContextMenu");
    return new CupertinoContextMenu(id);
  }
  public static CupertinoContextMenuCupertinoContextMenuBuilder cupertinoContextMenu(List<WidgetI> actions, WidgetI child) {
    return CupertinoContextMenuCupertinoContextMenuBuilder.cupertinoContextMenuCupertinoContextMenu(actions, child);
  }
  @Builder.Factory
  static CupertinoContextMenu cupertinoContextMenuBuilder(@Builder.Parameter List<WidgetI> actions, @Builder.Parameter BiFunction<BuildContext, Animation, Widget> builder, Optional<Boolean> enableHapticFeedback) {
    int id = factories.cupertinoContextMenuBuilder(actions.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()),
      builder,
      enableHapticFeedback);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoContextMenu");
    return new CupertinoContextMenu(id);
  }
  public static CupertinoContextMenuBuilderBuilder builder(List<WidgetI> actions, BiFunction<BuildContext, Animation, Widget> builder) {
    return CupertinoContextMenuBuilderBuilder.cupertinoContextMenuBuilder(actions, builder);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoContextMenuChild not supported on web");
    return factories.CupertinoContextMenu_readBack_child(nativeStruct);
  }
  public boolean enableHapticFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoContextMenuEnableHapticFeedback not supported on web");
    return factories.CupertinoContextMenu_readBack_enableHapticFeedback(nativeStruct);
  }
  public static double kOpenBorderRadius() {
    return 12.0;
  }
  @Override
  public CupertinoContextMenu build() {
    return this;
  }
}
