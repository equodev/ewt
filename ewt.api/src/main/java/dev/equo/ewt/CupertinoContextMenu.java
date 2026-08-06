package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoContextMenuObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoContextMenu extends StatefulWidget implements CupertinoContextMenuI {
  private MemorySegment st;
  protected CupertinoContextMenu() {}
  CupertinoContextMenu(MemorySegment st) {
    this.id = CupertinoContextMenuObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoContextMenu");
    System.out.println("New CupertinoContextMenu id:"+id);
  }
  CupertinoContextMenu(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoContextMenu cupertinoContextMenuCupertinoContextMenu(@Builder.Parameter List<WidgetI> actions, @Builder.Parameter WidgetI child, Optional<Boolean> enableHapticFeedback) {
    var st = factories.cupertinoContextMenuCupertinoContextMenu(actions.stream().map(WidgetI::build).toList(),
      child.build(),
      enableHapticFeedback);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoContextMenu");
    return new CupertinoContextMenu(st);
  }
  public static CupertinoContextMenuCupertinoContextMenuBuilder cupertinoContextMenu(List<WidgetI> actions, WidgetI child) {
    return CupertinoContextMenuCupertinoContextMenuBuilder.cupertinoContextMenuCupertinoContextMenu(actions, child);
  }
  @Builder.Factory
  static CupertinoContextMenu cupertinoContextMenuBuilder(@Builder.Parameter List<WidgetI> actions, @Builder.Parameter BiFunction<BuildContext, Animation, Widget> builder, Optional<Boolean> enableHapticFeedback) {
    var st = factories.cupertinoContextMenuBuilder(actions.stream().map(WidgetI::build).toList(),
      builder,
      enableHapticFeedback);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoContextMenu");
    return new CupertinoContextMenu(st);
  }
  public static CupertinoContextMenuBuilderBuilder builder(List<WidgetI> actions, BiFunction<BuildContext, Animation, Widget> builder) {
    return CupertinoContextMenuBuilderBuilder.cupertinoContextMenuBuilder(actions, builder);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoContextMenuChild not supported on web");
    return new Widget(CupertinoContextMenuObjSt.child(st)) {};
  }
  public boolean enableHapticFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoContextMenuEnableHapticFeedback not supported on web");
    return intToBool(CupertinoContextMenuObjSt.enableHapticFeedback(st));
  }
  public static double kOpenBorderRadius() {
    return 12.0;
  }
  @Override
  public CupertinoContextMenu build() {
    return this;
  }
}
