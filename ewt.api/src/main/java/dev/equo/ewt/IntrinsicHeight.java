package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.IntrinsicHeightObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class IntrinsicHeight extends SingleChildRenderObjectWidget implements IntrinsicHeightI {
  private MemorySegment st;
  protected IntrinsicHeight() {}
  IntrinsicHeight(MemorySegment st) {
    this.id = IntrinsicHeightObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget IntrinsicHeight");
    System.out.println("New IntrinsicHeight id:"+id);
  }
  @Builder.Factory
  static IntrinsicHeight intrinsicHeightIntrinsicHeight(Optional<WidgetI> child) {
    var st = factories.intrinsicHeightIntrinsicHeight(child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget IntrinsicHeight");
    return new IntrinsicHeight(st);
  }
  public static IntrinsicHeightIntrinsicHeightBuilder intrinsicHeight() {
    return IntrinsicHeightIntrinsicHeightBuilder.intrinsicHeightIntrinsicHeight();
  }
  @Override
  public IntrinsicHeight build() {
    return this;
  }
}
