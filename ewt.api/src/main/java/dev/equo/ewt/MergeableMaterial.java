package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class MergeableMaterial extends StatefulWidget implements MergeableMaterialI {
  protected MergeableMaterial() {}
  MergeableMaterial(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget MergeableMaterial");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static MergeableMaterial mergeableMaterialMergeableMaterial(Optional<Axis> mainAxis, OptionalDouble elevation, Optional<Boolean> hasDividers, Optional<List<MergeableMaterialItemI>> children, Optional<ColorI> dividerColor) {
    int id = factories.mergeableMaterialMergeableMaterial(mainAxis,
      elevation,
      hasDividers,
      children.map(i -> i.stream().map(MergeableMaterialItemI::build).collect(java.util.stream.Collectors.toList())),
      dividerColor.map(ColorI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget MergeableMaterial");
    return new MergeableMaterial(id);
  }
  public static MergeableMaterialMergeableMaterialBuilder mergeableMaterial() {
    return MergeableMaterialMergeableMaterialBuilder.mergeableMaterialMergeableMaterial();
  }
  public Axis mainAxis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("mergeableMaterialMainAxis not supported on web");
    return factories.MergeableMaterial_readBack_mainAxis(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("mergeableMaterialElevation not supported on web");
    return factories.MergeableMaterial_readBack_elevation(nativeStruct);
  }
  public boolean hasDividers() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("mergeableMaterialHasDividers not supported on web");
    return factories.MergeableMaterial_readBack_hasDividers(nativeStruct);
  }
  public Color dividerColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("mergeableMaterialDividerColor", getId());
      return new Color(__nid);
    }
    return factories.MergeableMaterial_readBack_dividerColor(nativeStruct);
  }
  @Override
  public MergeableMaterial build() {
    return this;
  }
}
