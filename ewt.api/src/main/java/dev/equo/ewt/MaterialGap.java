package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MaterialGapObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MaterialGap extends MergeableMaterialItem implements MaterialGapI {
  private MemorySegment st;
  protected MaterialGap() {}
  MaterialGap(MemorySegment st) {
    this.id = MaterialGapObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MaterialGap");
    System.out.println("New MaterialGap id:"+id);
  }
  MaterialGap(int id) { this.id = id; }
  public double size() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialGapSize not supported on web");
    return MaterialGapObjSt.size(st);
  }
  @Override
  public MaterialGap build() {
    return this;
  }
}
