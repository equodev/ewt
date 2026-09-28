package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SizedOverflowBox extends SingleChildRenderObjectWidget implements SizedOverflowBoxI {
  protected SizedOverflowBox() {}
  SizedOverflowBox(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SizedOverflowBox");
    this.nativeStruct = factories.takeLastStruct();
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sizedOverflowBoxAlignment not supported on web");
    return factories.SizedOverflowBox_readBack_alignment(nativeStruct);
  }
  @Override
  public SizedOverflowBox build() {
    return this;
  }
}
