package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class MaterialGap extends MergeableMaterialItem implements MaterialGapI {
  protected MaterialGap() {}
  MaterialGap(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget MaterialGap");
    this.nativeStruct = factories.takeLastStruct();
  }
  public double size() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialGapSize not supported on web");
    return factories.MaterialGap_readBack_size(nativeStruct);
  }
  @Override
  public MaterialGap build() {
    return this;
  }
}
