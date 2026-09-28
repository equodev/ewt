package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class MaterialSlice extends MergeableMaterialItem implements MaterialSliceI {
  protected MaterialSlice() {}
  MaterialSlice(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget MaterialSlice");
    this.nativeStruct = factories.takeLastStruct();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialSliceChild not supported on web");
    return factories.MaterialSlice_readBack_child(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialSliceColor", getId());
      return new Color(__nid);
    }
    return factories.MaterialSlice_readBack_color(nativeStruct);
  }
  @Override
  public MaterialSlice build() {
    return this;
  }
}
