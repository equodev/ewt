package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Form extends StatefulWidget implements FormI {
  protected Form() {}
  Form(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Form");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Form formForm(@Builder.Parameter WidgetI child, Optional<Boolean> canPop, Optional<Consumer<Boolean>> onPopInvoked, Optional<BiConsumer<Boolean, NativeObj>> onPopInvokedWithResult, Optional<Supplier<Future<Boolean>>> onWillPop, Optional<Runnable> onChanged, Optional<AutovalidateMode> autovalidateMode) {
    int id = factories.formForm(child.build(),
      canPop,
      onPopInvoked,
      onPopInvokedWithResult,
      onWillPop,
      onChanged,
      autovalidateMode);
    if (id <= 0) throw new RuntimeException("Failed to created widget Form");
    return new Form(id);
  }
  public static FormFormBuilder form(WidgetI child) {
    return FormFormBuilder.formForm(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("formChild not supported on web");
    return factories.Form_readBack_child(nativeStruct);
  }
  public boolean canPop() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("formCanPop not supported on web");
    return factories.Form_readBack_canPop(nativeStruct);
  }
  public AutovalidateMode autovalidateMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("formAutovalidateMode not supported on web");
    return factories.Form_readBack_autovalidateMode(nativeStruct);
  }
  @Override
  public Form build() {
    return this;
  }
}
