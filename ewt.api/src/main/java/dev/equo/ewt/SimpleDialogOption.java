package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SimpleDialogOptionObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SimpleDialogOption extends StatelessWidget implements SimpleDialogOptionI {
  private MemorySegment st;
  protected SimpleDialogOption() {}
  SimpleDialogOption(MemorySegment st) {
    this.id = SimpleDialogOptionObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SimpleDialogOption");
    System.out.println("New SimpleDialogOption id:"+id);
  }
  SimpleDialogOption(int id) { this.id = id; }
  @Builder.Factory
  static SimpleDialogOption simpleDialogOptionSimpleDialogOption(Optional<Runnable> onPressed, Optional<EdgeInsetsI> padding, Optional<WidgetI> child) {
    var st = factories.simpleDialogOptionSimpleDialogOption(onPressed,
      padding.map(EdgeInsetsI::build),
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget SimpleDialogOption");
    return new SimpleDialogOption(st);
  }
  public static SimpleDialogOptionSimpleDialogOptionBuilder simpleDialogOption() {
    return SimpleDialogOptionSimpleDialogOptionBuilder.simpleDialogOptionSimpleDialogOption();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("simpleDialogOptionChild not supported on web");
    return new Widget(SimpleDialogOptionObjSt.child(st)) {};
  }
  public EdgeInsets padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("simpleDialogOptionPadding", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.EdgeInsetsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.EdgeInsetsObjSt.id(__st, __nid);
      return new EdgeInsets(__st);
    }
    return new EdgeInsets(SimpleDialogOptionObjSt.padding(st));
  }
  @Override
  public SimpleDialogOption build() {
    return this;
  }
}
