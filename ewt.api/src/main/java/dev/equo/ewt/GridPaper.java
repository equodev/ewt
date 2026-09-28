package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class GridPaper extends StatelessWidget implements GridPaperI {
  protected GridPaper() {}
  GridPaper(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget GridPaper");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static GridPaper gridPaperGridPaper(Optional<ColorI> color, OptionalDouble interval, OptionalInt divisions, OptionalInt subdivisions, Optional<WidgetI> child) {
    int id = factories.gridPaperGridPaper(color.map(ColorI::build),
      interval,
      divisions,
      subdivisions,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget GridPaper");
    return new GridPaper(id);
  }
  public static GridPaperGridPaperBuilder gridPaper() {
    return GridPaperGridPaperBuilder.gridPaperGridPaper();
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("gridPaperColor", getId());
      return new Color(__nid);
    }
    return factories.GridPaper_readBack_color(nativeStruct);
  }
  public double interval() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gridPaperInterval not supported on web");
    return factories.GridPaper_readBack_interval(nativeStruct);
  }
  public int divisions() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gridPaperDivisions not supported on web");
    return factories.GridPaper_readBack_divisions(nativeStruct);
  }
  public int subdivisions() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gridPaperSubdivisions not supported on web");
    return factories.GridPaper_readBack_subdivisions(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gridPaperChild not supported on web");
    return factories.GridPaper_readBack_child(nativeStruct);
  }
  @Override
  public GridPaper build() {
    return this;
  }
}
