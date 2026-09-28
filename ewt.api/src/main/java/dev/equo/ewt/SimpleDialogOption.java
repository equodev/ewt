package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SimpleDialogOption extends StatelessWidget implements SimpleDialogOptionI {
  protected SimpleDialogOption() {}
  SimpleDialogOption(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SimpleDialogOption");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SimpleDialogOption simpleDialogOptionSimpleDialogOption(Optional<Runnable> onPressed, Optional<EdgeInsetsI> padding, Optional<WidgetI> child) {
    int id = factories.simpleDialogOptionSimpleDialogOption(onPressed,
      padding.map(EdgeInsetsI::build),
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SimpleDialogOption");
    return new SimpleDialogOption(id);
  }
  public static SimpleDialogOptionSimpleDialogOptionBuilder simpleDialogOption() {
    return SimpleDialogOptionSimpleDialogOptionBuilder.simpleDialogOptionSimpleDialogOption();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("simpleDialogOptionChild not supported on web");
    return factories.SimpleDialogOption_readBack_child(nativeStruct);
  }
  public EdgeInsets padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("simpleDialogOptionPadding", getId());
      return new EdgeInsets(__nid);
    }
    return factories.SimpleDialogOption_readBack_padding(nativeStruct);
  }
  @Override
  public SimpleDialogOption build() {
    return this;
  }
}
