package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoDialogAction extends StatefulWidget implements CupertinoDialogActionI {
  protected CupertinoDialogAction() {}
  CupertinoDialogAction(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoDialogAction");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoDialogAction cupertinoDialogActionCupertinoDialogAction(Optional<Runnable> onPressed, Optional<Boolean> isDefaultAction, Optional<Boolean> isDestructiveAction, Optional<TextStyleI> textStyle, WidgetI child) {
    int id = factories.cupertinoDialogActionCupertinoDialogAction(onPressed,
      isDefaultAction,
      isDestructiveAction,
      textStyle.map(TextStyleI::build),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoDialogAction");
    return new CupertinoDialogAction(id);
  }
  public static CupertinoDialogActionCupertinoDialogActionBuilder cupertinoDialogAction() {
    return CupertinoDialogActionCupertinoDialogActionBuilder.cupertinoDialogActionCupertinoDialogAction();
  }
  public boolean isDefaultAction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoDialogActionIsDefaultAction not supported on web");
    return factories.CupertinoDialogAction_readBack_isDefaultAction(nativeStruct);
  }
  public boolean isDestructiveAction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoDialogActionIsDestructiveAction not supported on web");
    return factories.CupertinoDialogAction_readBack_isDestructiveAction(nativeStruct);
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoDialogActionTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.CupertinoDialogAction_readBack_textStyle(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoDialogActionChild not supported on web");
    return factories.CupertinoDialogAction_readBack_child(nativeStruct);
  }
  @Override
  public CupertinoDialogAction build() {
    return this;
  }
}
