package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class RotatedBox extends SingleChildRenderObjectWidget implements RotatedBoxI {
  protected RotatedBox() {}
  RotatedBox(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget RotatedBox");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static RotatedBox rotatedBoxRotatedBox(@Builder.Parameter int quarterTurns, Optional<WidgetI> child) {
    int id = factories.rotatedBoxRotatedBox(quarterTurns,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget RotatedBox");
    return new RotatedBox(id);
  }
  public static RotatedBoxRotatedBoxBuilder rotatedBox(int quarterTurns) {
    return RotatedBoxRotatedBoxBuilder.rotatedBoxRotatedBox(quarterTurns);
  }
  public int quarterTurns() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rotatedBoxQuarterTurns not supported on web");
    return factories.RotatedBox_readBack_quarterTurns(nativeStruct);
  }
  @Override
  public RotatedBox build() {
    return this;
  }
}
