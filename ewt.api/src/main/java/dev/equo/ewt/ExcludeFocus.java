package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ExcludeFocus extends StatelessWidget implements ExcludeFocusI {
  protected ExcludeFocus() {}
  ExcludeFocus(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ExcludeFocus");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ExcludeFocus excludeFocusExcludeFocus(Optional<Boolean> excluding, WidgetI child) {
    int id = factories.excludeFocusExcludeFocus(excluding,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ExcludeFocus");
    return new ExcludeFocus(id);
  }
  public static ExcludeFocusExcludeFocusBuilder excludeFocus() {
    return ExcludeFocusExcludeFocusBuilder.excludeFocusExcludeFocus();
  }
  public boolean excluding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("excludeFocusExcluding not supported on web");
    return factories.ExcludeFocus_readBack_excluding(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("excludeFocusChild not supported on web");
    return factories.ExcludeFocus_readBack_child(nativeStruct);
  }
  @Override
  public ExcludeFocus build() {
    return this;
  }
}
