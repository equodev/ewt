package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoTabView extends StatefulWidget implements CupertinoTabViewI {
  protected CupertinoTabView() {}
  CupertinoTabView(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoTabView");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoTabView cupertinoTabViewCupertinoTabView(Optional<Function<BuildContext, Widget>> builder, Optional<String> defaultTitle, Optional<String> restorationScopeId) {
    int id = factories.cupertinoTabViewCupertinoTabView(builder,
      defaultTitle,
      restorationScopeId);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoTabView");
    return new CupertinoTabView(id);
  }
  public static CupertinoTabViewCupertinoTabViewBuilder cupertinoTabView() {
    return CupertinoTabViewCupertinoTabViewBuilder.cupertinoTabViewCupertinoTabView();
  }
  public String defaultTitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTabViewDefaultTitle not supported on web");
    return factories.CupertinoTabView_readBack_defaultTitle(nativeStruct);
  }
  public String restorationScopeId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoTabViewRestorationScopeId not supported on web");
    return factories.CupertinoTabView_readBack_restorationScopeId(nativeStruct);
  }
  @Override
  public CupertinoTabView build() {
    return this;
  }
}
