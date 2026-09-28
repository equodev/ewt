package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class IgnorePointer extends SingleChildRenderObjectWidget implements IgnorePointerI {
  protected IgnorePointer() {}
  IgnorePointer(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget IgnorePointer");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static IgnorePointer ignorePointerIgnorePointer(Optional<Boolean> ignoring, Optional<Boolean> ignoringSemantics, Optional<WidgetI> child) {
    int id = factories.ignorePointerIgnorePointer(ignoring,
      ignoringSemantics,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget IgnorePointer");
    return new IgnorePointer(id);
  }
  public static IgnorePointerIgnorePointerBuilder ignorePointer() {
    return IgnorePointerIgnorePointerBuilder.ignorePointerIgnorePointer();
  }
  public boolean ignoring() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("ignorePointerIgnoring not supported on web");
    return factories.IgnorePointer_readBack_ignoring(nativeStruct);
  }
  public boolean ignoringSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("ignorePointerIgnoringSemantics not supported on web");
    return factories.IgnorePointer_readBack_ignoringSemantics(nativeStruct);
  }
  @Override
  public IgnorePointer build() {
    return this;
  }
}
