package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.KeyboardListenerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class KeyboardListener extends StatelessWidget implements KeyboardListenerI {
  private MemorySegment st;
  protected KeyboardListener() {}
  KeyboardListener(MemorySegment st) {
    this.id = KeyboardListenerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget KeyboardListener");
    System.out.println("New KeyboardListener id:"+id);
  }
  KeyboardListener(int id) { this.id = id; }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("keyboardListenerAutofocus not supported on web");
    return intToBool(KeyboardListenerObjSt.autofocus(st));
  }
  public boolean includeSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("keyboardListenerIncludeSemantics not supported on web");
    return intToBool(KeyboardListenerObjSt.includeSemantics(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("keyboardListenerChild not supported on web");
    return new Widget(KeyboardListenerObjSt.child(st)) {};
  }
  @Override
  public KeyboardListener build() {
    return this;
  }
}
