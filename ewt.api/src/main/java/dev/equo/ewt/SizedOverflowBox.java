package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SizedOverflowBoxObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SizedOverflowBox extends SingleChildRenderObjectWidget implements SizedOverflowBoxI {
  private MemorySegment st;
  protected SizedOverflowBox() {}
  SizedOverflowBox(MemorySegment st) {
    this.id = SizedOverflowBoxObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SizedOverflowBox");
    System.out.println("New SizedOverflowBox id:"+id);
  }
  SizedOverflowBox(int id) { this.id = id; }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sizedOverflowBoxAlignment not supported on web");
    return new AlignmentGeometry(SizedOverflowBoxObjSt.alignment(st)) {};
  }
  @Override
  public SizedOverflowBox build() {
    return this;
  }
}
