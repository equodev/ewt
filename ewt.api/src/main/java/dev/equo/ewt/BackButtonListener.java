package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BackButtonListenerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BackButtonListener extends StatefulWidget implements BackButtonListenerI {
  private MemorySegment st;
  protected BackButtonListener() {}
  BackButtonListener(MemorySegment st) {
    this.id = BackButtonListenerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget BackButtonListener");
    System.out.println("New BackButtonListener id:"+id);
  }
  BackButtonListener(int id) { this.id = id; }
  @Builder.Factory
  static BackButtonListener backButtonListenerBackButtonListener(@Builder.Parameter WidgetI child, @Builder.Parameter Supplier<Future> onBackButtonPressed) {
    var st = factories.backButtonListenerBackButtonListener(child.build(),
      onBackButtonPressed);
    if (st == null) throw new RuntimeException("Failed to created widget BackButtonListener");
    return new BackButtonListener(st);
  }
  public static BackButtonListenerBackButtonListenerBuilder backButtonListener(WidgetI child, Supplier<Future> onBackButtonPressed) {
    return BackButtonListenerBackButtonListenerBuilder.backButtonListenerBackButtonListener(child, onBackButtonPressed);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("backButtonListenerChild not supported on web");
    return new Widget(BackButtonListenerObjSt.child(st)) {};
  }
  @Override
  public BackButtonListener build() {
    return this;
  }
}
