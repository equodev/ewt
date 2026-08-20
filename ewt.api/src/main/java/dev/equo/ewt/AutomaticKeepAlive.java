package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AutomaticKeepAliveObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AutomaticKeepAlive extends StatefulWidget implements AutomaticKeepAliveI {
  private MemorySegment st;
  protected AutomaticKeepAlive() {}
  AutomaticKeepAlive(MemorySegment st) {
    this.id = AutomaticKeepAliveObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AutomaticKeepAlive");
    System.out.println("New AutomaticKeepAlive id:"+id);
  }
  AutomaticKeepAlive(int id) { this.id = id; }
  @Builder.Factory
  static AutomaticKeepAlive automaticKeepAliveAutomaticKeepAlive(@Builder.Parameter WidgetI child) {
    var st = factories.automaticKeepAliveAutomaticKeepAlive(child.build());
    if (st == null) throw new RuntimeException("Failed to created widget AutomaticKeepAlive");
    return new AutomaticKeepAlive(st);
  }
  public static AutomaticKeepAliveAutomaticKeepAliveBuilder automaticKeepAlive(WidgetI child) {
    return AutomaticKeepAliveAutomaticKeepAliveBuilder.automaticKeepAliveAutomaticKeepAlive(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("automaticKeepAliveChild not supported on web");
    return new Widget(AutomaticKeepAliveObjSt.child(st)) {};
  }
  @Override
  public AutomaticKeepAlive build() {
    return this;
  }
}
