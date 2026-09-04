package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RawKeyboardListenerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class RawKeyboardListener extends StatefulWidget implements RawKeyboardListenerI {
  private MemorySegment st;
  protected RawKeyboardListener() {}
  RawKeyboardListener(MemorySegment st) {
    this.id = RawKeyboardListenerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget RawKeyboardListener");
    System.out.println("New RawKeyboardListener id:"+id);
  }
  RawKeyboardListener(int id) { this.id = id; }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawKeyboardListenerAutofocus not supported on web");
    return intToBool(RawKeyboardListenerObjSt.autofocus(st));
  }
  public boolean includeSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawKeyboardListenerIncludeSemantics not supported on web");
    return intToBool(RawKeyboardListenerObjSt.includeSemantics(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawKeyboardListenerChild not supported on web");
    return new Widget(RawKeyboardListenerObjSt.child(st)) {};
  }
  @Override
  public RawKeyboardListener build() {
    return this;
  }
}
