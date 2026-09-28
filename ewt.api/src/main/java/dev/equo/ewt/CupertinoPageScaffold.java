package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoPageScaffold extends StatefulWidget implements CupertinoPageScaffoldI {
  protected CupertinoPageScaffold() {}
  CupertinoPageScaffold(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoPageScaffold");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoPageScaffold cupertinoPageScaffoldCupertinoPageScaffold(Optional<ObstructingPreferredSizeWidgetI> navigationBar, Optional<ColorI> backgroundColor, Optional<Boolean> resizeToAvoidBottomInset, WidgetI child) {
    int id = factories.cupertinoPageScaffoldCupertinoPageScaffold(navigationBar.map(ObstructingPreferredSizeWidgetI::build),
      backgroundColor.map(ColorI::build),
      resizeToAvoidBottomInset,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoPageScaffold");
    return new CupertinoPageScaffold(id);
  }
  public static CupertinoPageScaffoldCupertinoPageScaffoldBuilder cupertinoPageScaffold() {
    return CupertinoPageScaffoldCupertinoPageScaffoldBuilder.cupertinoPageScaffoldCupertinoPageScaffold();
  }
  public ObstructingPreferredSizeWidget navigationBar() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoPageScaffoldNavigationBar not supported on web");
    return factories.CupertinoPageScaffold_readBack_navigationBar(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoPageScaffoldChild not supported on web");
    return factories.CupertinoPageScaffold_readBack_child(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoPageScaffoldBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoPageScaffold_readBack_backgroundColor(nativeStruct);
  }
  public boolean resizeToAvoidBottomInset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoPageScaffoldResizeToAvoidBottomInset not supported on web");
    return factories.CupertinoPageScaffold_readBack_resizeToAvoidBottomInset(nativeStruct);
  }
  @Override
  public CupertinoPageScaffold build() {
    return this;
  }
}
