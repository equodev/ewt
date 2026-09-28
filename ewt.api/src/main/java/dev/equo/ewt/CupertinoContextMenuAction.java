package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoContextMenuAction extends StatefulWidget implements CupertinoContextMenuActionI {
  protected CupertinoContextMenuAction() {}
  CupertinoContextMenuAction(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoContextMenuAction");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoContextMenuAction cupertinoContextMenuActionCupertinoContextMenuAction(@Builder.Parameter WidgetI child, Optional<Boolean> isDefaultAction, Optional<Boolean> isDestructiveAction, Optional<Runnable> onPressed, Optional<IconDataI> trailingIcon) {
    int id = factories.cupertinoContextMenuActionCupertinoContextMenuAction(child.build(),
      isDefaultAction,
      isDestructiveAction,
      onPressed,
      trailingIcon.map(IconDataI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoContextMenuAction");
    return new CupertinoContextMenuAction(id);
  }
  public static CupertinoContextMenuActionCupertinoContextMenuActionBuilder cupertinoContextMenuAction(WidgetI child) {
    return CupertinoContextMenuActionCupertinoContextMenuActionBuilder.cupertinoContextMenuActionCupertinoContextMenuAction(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoContextMenuActionChild not supported on web");
    return factories.CupertinoContextMenuAction_readBack_child(nativeStruct);
  }
  public boolean isDefaultAction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoContextMenuActionIsDefaultAction not supported on web");
    return factories.CupertinoContextMenuAction_readBack_isDefaultAction(nativeStruct);
  }
  public boolean isDestructiveAction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoContextMenuActionIsDestructiveAction not supported on web");
    return factories.CupertinoContextMenuAction_readBack_isDestructiveAction(nativeStruct);
  }
  public IconData trailingIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoContextMenuActionTrailingIcon", getId());
      return new IconData(__nid);
    }
    return factories.CupertinoContextMenuAction_readBack_trailingIcon(nativeStruct);
  }
  @Override
  public CupertinoContextMenuAction build() {
    return this;
  }
}
