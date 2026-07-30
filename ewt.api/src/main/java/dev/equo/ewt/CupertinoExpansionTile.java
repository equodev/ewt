package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoExpansionTileObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoExpansionTile extends StatefulWidget implements CupertinoExpansionTileI {
  private MemorySegment st;
  protected CupertinoExpansionTile() {}
  CupertinoExpansionTile(MemorySegment st) {
    this.id = CupertinoExpansionTileObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoExpansionTile");
    System.out.println("New CupertinoExpansionTile id:"+id);
  }
  CupertinoExpansionTile(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoExpansionTile cupertinoExpansionTileCupertinoExpansionTile(@Builder.Parameter WidgetI title, @Builder.Parameter WidgetI child, Optional<ExpansionTileTransitionMode> transitionMode) {
    var st = factories.cupertinoExpansionTileCupertinoExpansionTile(title.build(),
      child.build(),
      transitionMode);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoExpansionTile");
    return new CupertinoExpansionTile(st);
  }
  public static CupertinoExpansionTileCupertinoExpansionTileBuilder cupertinoExpansionTile(WidgetI title, WidgetI child) {
    return CupertinoExpansionTileCupertinoExpansionTileBuilder.cupertinoExpansionTileCupertinoExpansionTile(title, child);
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoExpansionTileTitle not supported on web");
    return new Widget(CupertinoExpansionTileObjSt.title(st)) {};
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoExpansionTileChild not supported on web");
    return new Widget(CupertinoExpansionTileObjSt.child(st)) {};
  }
  public ExpansionTileTransitionMode transitionMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoExpansionTileTransitionMode not supported on web");
    return ExpansionTileTransitionMode.values()[CupertinoExpansionTileObjSt.transitionMode(st)];
  }
  @Override
  public CupertinoExpansionTile build() {
    return this;
  }
}
