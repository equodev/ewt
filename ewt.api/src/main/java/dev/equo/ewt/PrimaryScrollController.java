package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PrimaryScrollControllerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class PrimaryScrollController extends InheritedWidget implements PrimaryScrollControllerI {
  private MemorySegment st;
  protected PrimaryScrollController() {}
  PrimaryScrollController(MemorySegment st) {
    this.id = PrimaryScrollControllerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget PrimaryScrollController");
    System.out.println("New PrimaryScrollController id:"+id);
  }
  PrimaryScrollController(int id) { this.id = id; }
  @Builder.Factory
  static PrimaryScrollController primaryScrollControllerNone(@Builder.Parameter WidgetI child) {
    var st = factories.primaryScrollControllerNone(child.build());
    if (st == null) throw new RuntimeException("Failed to created widget PrimaryScrollController");
    return new PrimaryScrollController(st);
  }
  public static PrimaryScrollControllerNoneBuilder none(WidgetI child) {
    return PrimaryScrollControllerNoneBuilder.primaryScrollControllerNone(child);
  }
  public static boolean shouldInherit(BuildContextI context, Axis scrollDirection) {
    int id = factories.primaryScrollControllerShouldInherit(context.build(),
      scrollDirection);
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    System.out.println("New bool id:"+id);
    return intToBool(id);
  }
  public Axis scrollDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("primaryScrollControllerScrollDirection not supported on web");
    return Axis.values()[PrimaryScrollControllerObjSt.scrollDirection(st)];
  }
  @Override
  public PrimaryScrollController build() {
    return this;
  }
}
