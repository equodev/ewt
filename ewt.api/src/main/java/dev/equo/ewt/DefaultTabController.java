package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DefaultTabControllerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DefaultTabController extends StatefulWidget implements DefaultTabControllerI {
  private MemorySegment st;
  protected DefaultTabController() {}
  DefaultTabController(MemorySegment st) {
    this.id = DefaultTabControllerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DefaultTabController");
    System.out.println("New DefaultTabController id:"+id);
  }
  @Builder.Factory
  static DefaultTabController defaultTabControllerDefaultTabController(@Builder.Parameter int length, OptionalInt initialIndex, WidgetI child, Optional<DurationI> animationDuration) {
    var st = factories.defaultTabControllerDefaultTabController(length,
      initialIndex,
      child.build(),
      animationDuration.map(DurationI::build));
    if (st == null) throw new RuntimeException("Failed to created widget DefaultTabController");
    return new DefaultTabController(st);
  }
  public static DefaultTabControllerDefaultTabControllerBuilder defaultTabController(int length) {
    return DefaultTabControllerDefaultTabControllerBuilder.defaultTabControllerDefaultTabController(length);
  }
  public int length() {
    return DefaultTabControllerObjSt.length(st);
  }
  public int initialIndex() {
    return DefaultTabControllerObjSt.initialIndex(st);
  }
  public Duration animationDuration() {
    return new Duration(DefaultTabControllerObjSt.animationDuration(st));
  }
  public Widget child() {
    return new Widget(DefaultTabControllerObjSt.child(st)) {};
  }
  @Override
  public DefaultTabController build() {
    return this;
  }
}
