package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.GridPaperObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class GridPaper extends StatelessWidget implements GridPaperI {
  private MemorySegment st;
  protected GridPaper() {}
  GridPaper(MemorySegment st) {
    this.id = GridPaperObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget GridPaper");
    System.out.println("New GridPaper id:"+id);
  }
  GridPaper(int id) { this.id = id; }
  @Builder.Factory
  static GridPaper gridPaperGridPaper(Optional<ColorI> color, OptionalDouble interval, OptionalInt divisions, OptionalInt subdivisions, Optional<WidgetI> child) {
    var st = factories.gridPaperGridPaper(color.map(ColorI::build),
      interval,
      divisions,
      subdivisions,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget GridPaper");
    return new GridPaper(st);
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
    return new Color(GridPaperObjSt.color(st));
  }
  public double interval() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gridPaperInterval not supported on web");
    return GridPaperObjSt.interval(st);
  }
  public int divisions() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gridPaperDivisions not supported on web");
    return GridPaperObjSt.divisions(st);
  }
  public int subdivisions() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gridPaperSubdivisions not supported on web");
    return GridPaperObjSt.subdivisions(st);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gridPaperChild not supported on web");
    return new Widget(GridPaperObjSt.child(st)) {};
  }
  @Override
  public GridPaper build() {
    return this;
  }
}
