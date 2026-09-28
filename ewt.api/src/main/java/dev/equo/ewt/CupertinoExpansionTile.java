package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoExpansionTile extends StatefulWidget implements CupertinoExpansionTileI {
  protected CupertinoExpansionTile() {}
  CupertinoExpansionTile(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoExpansionTile");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoExpansionTile cupertinoExpansionTileCupertinoExpansionTile(@Builder.Parameter WidgetI title, @Builder.Parameter WidgetI child, Optional<ExpansionTileTransitionMode> transitionMode) {
    int id = factories.cupertinoExpansionTileCupertinoExpansionTile(title.build(),
      child.build(),
      transitionMode);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoExpansionTile");
    return new CupertinoExpansionTile(id);
  }
  public static CupertinoExpansionTileCupertinoExpansionTileBuilder cupertinoExpansionTile(WidgetI title, WidgetI child) {
    return CupertinoExpansionTileCupertinoExpansionTileBuilder.cupertinoExpansionTileCupertinoExpansionTile(title, child);
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoExpansionTileTitle not supported on web");
    return factories.CupertinoExpansionTile_readBack_title(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoExpansionTileChild not supported on web");
    return factories.CupertinoExpansionTile_readBack_child(nativeStruct);
  }
  public ExpansionTileTransitionMode transitionMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoExpansionTileTransitionMode not supported on web");
    return factories.CupertinoExpansionTile_readBack_transitionMode(nativeStruct);
  }
  @Override
  public CupertinoExpansionTile build() {
    return this;
  }
}
