package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class GridTile extends StatelessWidget implements GridTileI {
  protected GridTile() {}
  GridTile(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget GridTile");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static GridTile gridTileGridTile(Optional<WidgetI> header, Optional<WidgetI> footer, WidgetI child) {
    int id = factories.gridTileGridTile(header.map(WidgetI::build),
      footer.map(WidgetI::build),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget GridTile");
    return new GridTile(id);
  }
  public static GridTileGridTileBuilder gridTile() {
    return GridTileGridTileBuilder.gridTileGridTile();
  }
  public Widget header() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gridTileHeader not supported on web");
    return factories.GridTile_readBack_header(nativeStruct);
  }
  public Widget footer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gridTileFooter not supported on web");
    return factories.GridTile_readBack_footer(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gridTileChild not supported on web");
    return factories.GridTile_readBack_child(nativeStruct);
  }
  @Override
  public GridTile build() {
    return this;
  }
}
