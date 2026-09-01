package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.GridTileObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class GridTile extends StatelessWidget implements GridTileI {
  private MemorySegment st;
  protected GridTile() {}
  GridTile(MemorySegment st) {
    this.id = GridTileObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget GridTile");
    System.out.println("New GridTile id:"+id);
  }
  GridTile(int id) { this.id = id; }
  @Builder.Factory
  static GridTile gridTileGridTile(Optional<WidgetI> header, Optional<WidgetI> footer, WidgetI child) {
    var st = factories.gridTileGridTile(header.map(WidgetI::build),
      footer.map(WidgetI::build),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget GridTile");
    return new GridTile(st);
  }
  public static GridTileGridTileBuilder gridTile() {
    return GridTileGridTileBuilder.gridTileGridTile();
  }
  public Widget header() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gridTileHeader not supported on web");
    return new Widget(GridTileObjSt.header(st)) {};
  }
  public Widget footer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gridTileFooter not supported on web");
    return new Widget(GridTileObjSt.footer(st)) {};
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gridTileChild not supported on web");
    return new Widget(GridTileObjSt.child(st)) {};
  }
  @Override
  public GridTile build() {
    return this;
  }
}
