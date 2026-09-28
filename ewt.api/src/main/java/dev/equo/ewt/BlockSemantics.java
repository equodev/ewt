package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class BlockSemantics extends SingleChildRenderObjectWidget implements BlockSemanticsI {
  protected BlockSemantics() {}
  BlockSemantics(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget BlockSemantics");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static BlockSemantics blockSemanticsBlockSemantics(Optional<Boolean> blocking, Optional<WidgetI> child) {
    int id = factories.blockSemanticsBlockSemantics(blocking,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget BlockSemantics");
    return new BlockSemantics(id);
  }
  public static BlockSemanticsBlockSemanticsBuilder blockSemantics() {
    return BlockSemanticsBlockSemanticsBuilder.blockSemanticsBlockSemantics();
  }
  public boolean blocking() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("blockSemanticsBlocking not supported on web");
    return factories.BlockSemantics_readBack_blocking(nativeStruct);
  }
  @Override
  public BlockSemantics build() {
    return this;
  }
}
