package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoActionSheetAction extends StatefulWidget implements CupertinoActionSheetActionI {
  protected CupertinoActionSheetAction() {}
  CupertinoActionSheetAction(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoActionSheetAction");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoActionSheetAction cupertinoActionSheetActionCupertinoActionSheetAction(@Builder.Parameter Runnable onPressed, Optional<Boolean> isDefaultAction, Optional<Boolean> isDestructiveAction, Optional<ColorI> focusColor, WidgetI child) {
    int id = factories.cupertinoActionSheetActionCupertinoActionSheetAction(onPressed,
      isDefaultAction,
      isDestructiveAction,
      focusColor.map(ColorI::build),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoActionSheetAction");
    return new CupertinoActionSheetAction(id);
  }
  public static CupertinoActionSheetActionCupertinoActionSheetActionBuilder cupertinoActionSheetAction(Runnable onPressed) {
    return CupertinoActionSheetActionCupertinoActionSheetActionBuilder.cupertinoActionSheetActionCupertinoActionSheetAction(onPressed);
  }
  public boolean isDefaultAction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoActionSheetActionIsDefaultAction not supported on web");
    return factories.CupertinoActionSheetAction_readBack_isDefaultAction(nativeStruct);
  }
  public boolean isDestructiveAction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoActionSheetActionIsDestructiveAction not supported on web");
    return factories.CupertinoActionSheetAction_readBack_isDestructiveAction(nativeStruct);
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoActionSheetActionFocusColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoActionSheetAction_readBack_focusColor(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoActionSheetActionChild not supported on web");
    return factories.CupertinoActionSheetAction_readBack_child(nativeStruct);
  }
  @Override
  public CupertinoActionSheetAction build() {
    return this;
  }
}
