package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.GridTileBarObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class GridTileBar extends StatelessWidget implements GridTileBarI {
  private MemorySegment st;
  protected GridTileBar() {}
  GridTileBar(MemorySegment st) {
    this.id = GridTileBarObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget GridTileBar");
    System.out.println("New GridTileBar id:"+id);
  }
  GridTileBar(int id) { this.id = id; }
  @Builder.Factory
  static GridTileBar gridTileBarGridTileBar(Optional<ColorI> backgroundColor, Optional<WidgetI> leading, Optional<WidgetI> title, Optional<WidgetI> subtitle, Optional<WidgetI> trailing) {
    var st = factories.gridTileBarGridTileBar(backgroundColor.map(ColorI::build),
      leading.map(WidgetI::build),
      title.map(WidgetI::build),
      subtitle.map(WidgetI::build),
      trailing.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget GridTileBar");
    return new GridTileBar(st);
  }
  public static GridTileBarGridTileBarBuilder gridTileBar() {
    return GridTileBarGridTileBarBuilder.gridTileBarGridTileBar();
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("gridTileBarBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(GridTileBarObjSt.backgroundColor(st));
  }
  public Widget leading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gridTileBarLeading not supported on web");
    return new Widget(GridTileBarObjSt.leading(st)) {};
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gridTileBarTitle not supported on web");
    return new Widget(GridTileBarObjSt.title(st)) {};
  }
  public Widget subtitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gridTileBarSubtitle not supported on web");
    return new Widget(GridTileBarObjSt.subtitle(st)) {};
  }
  public Widget trailing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gridTileBarTrailing not supported on web");
    return new Widget(GridTileBarObjSt.trailing(st)) {};
  }
  @Override
  public GridTileBar build() {
    return this;
  }
}
