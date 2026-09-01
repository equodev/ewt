package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BlockSemanticsObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BlockSemantics extends SingleChildRenderObjectWidget implements BlockSemanticsI {
  private MemorySegment st;
  protected BlockSemantics() {}
  BlockSemantics(MemorySegment st) {
    this.id = BlockSemanticsObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget BlockSemantics");
    System.out.println("New BlockSemantics id:"+id);
  }
  BlockSemantics(int id) { this.id = id; }
  @Builder.Factory
  static BlockSemantics blockSemanticsBlockSemantics(Optional<Boolean> blocking, Optional<WidgetI> child) {
    var st = factories.blockSemanticsBlockSemantics(blocking,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget BlockSemantics");
    return new BlockSemantics(st);
  }
  public static BlockSemanticsBlockSemanticsBuilder blockSemantics() {
    return BlockSemanticsBlockSemanticsBuilder.blockSemanticsBlockSemantics();
  }
  public boolean blocking() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("blockSemanticsBlocking not supported on web");
    return intToBool(BlockSemanticsObjSt.blocking(st));
  }
  @Override
  public BlockSemantics build() {
    return this;
  }
}
