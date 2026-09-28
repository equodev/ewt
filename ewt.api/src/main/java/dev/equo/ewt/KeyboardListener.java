package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class KeyboardListener extends StatelessWidget implements KeyboardListenerI {
  protected KeyboardListener() {}
  KeyboardListener(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget KeyboardListener");
    this.nativeStruct = factories.takeLastStruct();
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("keyboardListenerAutofocus not supported on web");
    return factories.KeyboardListener_readBack_autofocus(nativeStruct);
  }
  public boolean includeSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("keyboardListenerIncludeSemantics not supported on web");
    return factories.KeyboardListener_readBack_includeSemantics(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("keyboardListenerChild not supported on web");
    return factories.KeyboardListener_readBack_child(nativeStruct);
  }
  @Override
  public KeyboardListener build() {
    return this;
  }
}
