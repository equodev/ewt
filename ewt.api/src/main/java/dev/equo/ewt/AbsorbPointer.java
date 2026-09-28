package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AbsorbPointer extends SingleChildRenderObjectWidget implements AbsorbPointerI {
  protected AbsorbPointer() {}
  AbsorbPointer(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AbsorbPointer");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AbsorbPointer absorbPointerAbsorbPointer(Optional<Boolean> absorbing, Optional<Boolean> ignoringSemantics, Optional<WidgetI> child) {
    int id = factories.absorbPointerAbsorbPointer(absorbing,
      ignoringSemantics,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget AbsorbPointer");
    return new AbsorbPointer(id);
  }
  public static AbsorbPointerAbsorbPointerBuilder absorbPointer() {
    return AbsorbPointerAbsorbPointerBuilder.absorbPointerAbsorbPointer();
  }
  public boolean absorbing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("absorbPointerAbsorbing not supported on web");
    return factories.AbsorbPointer_readBack_absorbing(nativeStruct);
  }
  public boolean ignoringSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("absorbPointerIgnoringSemantics not supported on web");
    return factories.AbsorbPointer_readBack_ignoringSemantics(nativeStruct);
  }
  @Override
  public AbsorbPointer build() {
    return this;
  }
}
