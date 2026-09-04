package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MergeableMaterialObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MergeableMaterial extends StatefulWidget implements MergeableMaterialI {
  private MemorySegment st;
  protected MergeableMaterial() {}
  MergeableMaterial(MemorySegment st) {
    this.id = MergeableMaterialObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MergeableMaterial");
    System.out.println("New MergeableMaterial id:"+id);
  }
  MergeableMaterial(int id) { this.id = id; }
  @Builder.Factory
  static MergeableMaterial mergeableMaterialMergeableMaterial(Optional<Axis> mainAxis, OptionalDouble elevation, Optional<Boolean> hasDividers, Optional<List<MergeableMaterialItemI>> children, Optional<ColorI> dividerColor) {
    var st = factories.mergeableMaterialMergeableMaterial(mainAxis,
      elevation,
      hasDividers,
      children.map(i -> i.stream().map(MergeableMaterialItemI::build).toList()),
      dividerColor.map(ColorI::build));
    if (st == null) throw new RuntimeException("Failed to created widget MergeableMaterial");
    return new MergeableMaterial(st);
  }
  public static MergeableMaterialMergeableMaterialBuilder mergeableMaterial() {
    return MergeableMaterialMergeableMaterialBuilder.mergeableMaterialMergeableMaterial();
  }
  public Axis mainAxis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("mergeableMaterialMainAxis not supported on web");
    return Axis.values()[MergeableMaterialObjSt.mainAxis(st)];
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("mergeableMaterialElevation not supported on web");
    return MergeableMaterialObjSt.elevation(st);
  }
  public boolean hasDividers() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("mergeableMaterialHasDividers not supported on web");
    return intToBool(MergeableMaterialObjSt.hasDividers(st));
  }
  public Color dividerColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("mergeableMaterialDividerColor", getId());
      return new Color(__nid);
    }
    return new Color(MergeableMaterialObjSt.dividerColor(st));
  }
  @Override
  public MergeableMaterial build() {
    return this;
  }
}
