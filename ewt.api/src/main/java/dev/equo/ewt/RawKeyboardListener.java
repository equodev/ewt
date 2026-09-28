package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class RawKeyboardListener extends StatefulWidget implements RawKeyboardListenerI {
  protected RawKeyboardListener() {}
  RawKeyboardListener(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget RawKeyboardListener");
    this.nativeStruct = factories.takeLastStruct();
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawKeyboardListenerAutofocus not supported on web");
    return factories.RawKeyboardListener_readBack_autofocus(nativeStruct);
  }
  public boolean includeSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawKeyboardListenerIncludeSemantics not supported on web");
    return factories.RawKeyboardListener_readBack_includeSemantics(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawKeyboardListenerChild not supported on web");
    return factories.RawKeyboardListener_readBack_child(nativeStruct);
  }
  @Override
  public RawKeyboardListener build() {
    return this;
  }
}
