package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SemanticsDebuggerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SemanticsDebugger extends StatefulWidget implements SemanticsDebuggerI {
  private MemorySegment st;
  protected SemanticsDebugger() {}
  SemanticsDebugger(MemorySegment st) {
    this.id = SemanticsDebuggerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SemanticsDebugger");
    System.out.println("New SemanticsDebugger id:"+id);
  }
  SemanticsDebugger(int id) { this.id = id; }
  @Builder.Factory
  static SemanticsDebugger semanticsDebuggerSemanticsDebugger(@Builder.Parameter WidgetI child, Optional<TextStyleI> labelStyle) {
    var st = factories.semanticsDebuggerSemanticsDebugger(child.build(),
      labelStyle.map(TextStyleI::build));
    if (st == null) throw new RuntimeException("Failed to created widget SemanticsDebugger");
    return new SemanticsDebugger(st);
  }
  public static SemanticsDebuggerSemanticsDebuggerBuilder semanticsDebugger(WidgetI child) {
    return SemanticsDebuggerSemanticsDebuggerBuilder.semanticsDebuggerSemanticsDebugger(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("semanticsDebuggerChild not supported on web");
    return new Widget(SemanticsDebuggerObjSt.child(st)) {};
  }
  public TextStyle labelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("semanticsDebuggerLabelStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(SemanticsDebuggerObjSt.labelStyle(st));
  }
  @Override
  public SemanticsDebugger build() {
    return this;
  }
}
