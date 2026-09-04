package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MaterialSliceObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MaterialSlice extends MergeableMaterialItem implements MaterialSliceI {
  private MemorySegment st;
  protected MaterialSlice() {}
  MaterialSlice(MemorySegment st) {
    this.id = MaterialSliceObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MaterialSlice");
    System.out.println("New MaterialSlice id:"+id);
  }
  MaterialSlice(int id) { this.id = id; }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialSliceChild not supported on web");
    return new Widget(MaterialSliceObjSt.child(st)) {};
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialSliceColor", getId());
      return new Color(__nid);
    }
    return new Color(MaterialSliceObjSt.color(st));
  }
  @Override
  public MaterialSlice build() {
    return this;
  }
}
