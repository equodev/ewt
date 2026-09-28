package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Flexible extends ParentDataWidget<FlexParentData> implements FlexibleI {
  protected Flexible() {}
  Flexible(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Flexible");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Flexible flexibleFlexible(OptionalInt flex, Optional<FlexFit> fit, WidgetI child) {
    int id = factories.flexibleFlexible(flex,
      fit,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Flexible");
    return new Flexible(id);
  }
  public static FlexibleFlexibleBuilder flexible() {
    return FlexibleFlexibleBuilder.flexibleFlexible();
  }
  public int flex() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flexibleFlex not supported on web");
    return factories.Flexible_readBack_flex(nativeStruct);
  }
  public FlexFit fit() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flexibleFit not supported on web");
    return factories.Flexible_readBack_fit(nativeStruct);
  }
  @Override
  public Flexible build() {
    return this;
  }
}
