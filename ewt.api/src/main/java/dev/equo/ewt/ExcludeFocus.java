package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ExcludeFocusObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ExcludeFocus extends StatelessWidget implements ExcludeFocusI {
  private MemorySegment st;
  protected ExcludeFocus() {}
  ExcludeFocus(MemorySegment st) {
    this.id = ExcludeFocusObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ExcludeFocus");
    System.out.println("New ExcludeFocus id:"+id);
  }
  ExcludeFocus(int id) { this.id = id; }
  @Builder.Factory
  static ExcludeFocus excludeFocusExcludeFocus(Optional<Boolean> excluding, WidgetI child) {
    var st = factories.excludeFocusExcludeFocus(excluding,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget ExcludeFocus");
    return new ExcludeFocus(st);
  }
  public static ExcludeFocusExcludeFocusBuilder excludeFocus() {
    return ExcludeFocusExcludeFocusBuilder.excludeFocusExcludeFocus();
  }
  public boolean excluding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("excludeFocusExcluding not supported on web");
    return intToBool(ExcludeFocusObjSt.excluding(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("excludeFocusChild not supported on web");
    return new Widget(ExcludeFocusObjSt.child(st)) {};
  }
  @Override
  public ExcludeFocus build() {
    return this;
  }
}
