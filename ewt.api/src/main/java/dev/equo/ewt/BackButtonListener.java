package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class BackButtonListener extends StatefulWidget implements BackButtonListenerI {
  protected BackButtonListener() {}
  BackButtonListener(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget BackButtonListener");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static BackButtonListener backButtonListenerBackButtonListener(@Builder.Parameter WidgetI child, @Builder.Parameter Supplier<Future<Boolean>> onBackButtonPressed) {
    int id = factories.backButtonListenerBackButtonListener(child.build(),
      onBackButtonPressed);
    if (id <= 0) throw new RuntimeException("Failed to created widget BackButtonListener");
    return new BackButtonListener(id);
  }
  public static BackButtonListenerBackButtonListenerBuilder backButtonListener(WidgetI child, Supplier<Future<Boolean>> onBackButtonPressed) {
    return BackButtonListenerBackButtonListenerBuilder.backButtonListenerBackButtonListener(child, onBackButtonPressed);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("backButtonListenerChild not supported on web");
    return factories.BackButtonListener_readBack_child(nativeStruct);
  }
  @Override
  public BackButtonListener build() {
    return this;
  }
}
