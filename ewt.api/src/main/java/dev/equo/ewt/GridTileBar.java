package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class GridTileBar extends StatelessWidget implements GridTileBarI {
  protected GridTileBar() {}
  GridTileBar(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget GridTileBar");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static GridTileBar gridTileBarGridTileBar(Optional<ColorI> backgroundColor, Optional<WidgetI> leading, Optional<WidgetI> title, Optional<WidgetI> subtitle, Optional<WidgetI> trailing) {
    int id = factories.gridTileBarGridTileBar(backgroundColor.map(ColorI::build),
      leading.map(WidgetI::build),
      title.map(WidgetI::build),
      subtitle.map(WidgetI::build),
      trailing.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget GridTileBar");
    return new GridTileBar(id);
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
    return factories.GridTileBar_readBack_backgroundColor(nativeStruct);
  }
  public Widget leading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gridTileBarLeading not supported on web");
    return factories.GridTileBar_readBack_leading(nativeStruct);
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gridTileBarTitle not supported on web");
    return factories.GridTileBar_readBack_title(nativeStruct);
  }
  public Widget subtitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gridTileBarSubtitle not supported on web");
    return factories.GridTileBar_readBack_subtitle(nativeStruct);
  }
  public Widget trailing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gridTileBarTrailing not supported on web");
    return factories.GridTileBar_readBack_trailing(nativeStruct);
  }
  @Override
  public GridTileBar build() {
    return this;
  }
}
