package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SizeChangedLayoutNotifierObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SizeChangedLayoutNotifier extends SingleChildRenderObjectWidget implements SizeChangedLayoutNotifierI {
  private MemorySegment st;
  protected SizeChangedLayoutNotifier() {}
  SizeChangedLayoutNotifier(MemorySegment st) {
    this.id = SizeChangedLayoutNotifierObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SizeChangedLayoutNotifier");
    System.out.println("New SizeChangedLayoutNotifier id:"+id);
  }
  SizeChangedLayoutNotifier(int id) { this.id = id; }
  @Builder.Factory
  static SizeChangedLayoutNotifier sizeChangedLayoutNotifierSizeChangedLayoutNotifier(Optional<WidgetI> child) {
    var st = factories.sizeChangedLayoutNotifierSizeChangedLayoutNotifier(child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget SizeChangedLayoutNotifier");
    return new SizeChangedLayoutNotifier(st);
  }
  public static SizeChangedLayoutNotifierSizeChangedLayoutNotifierBuilder sizeChangedLayoutNotifier() {
    return SizeChangedLayoutNotifierSizeChangedLayoutNotifierBuilder.sizeChangedLayoutNotifierSizeChangedLayoutNotifier();
  }
  @Override
  public SizeChangedLayoutNotifier build() {
    return this;
  }
}
