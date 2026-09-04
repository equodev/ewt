package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FormObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Form extends StatefulWidget implements FormI {
  private MemorySegment st;
  protected Form() {}
  Form(MemorySegment st) {
    this.id = FormObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Form");
    System.out.println("New Form id:"+id);
  }
  Form(int id) { this.id = id; }
  @Builder.Factory
  static Form formForm(@Builder.Parameter WidgetI child, Optional<Boolean> canPop, Optional<Consumer<Boolean>> onPopInvoked, Optional<BiConsumer<Boolean, NativeObj>> onPopInvokedWithResult, Optional<Supplier<Future>> onWillPop, Optional<Runnable> onChanged, Optional<AutovalidateMode> autovalidateMode) {
    var st = factories.formForm(child.build(),
      canPop,
      onPopInvoked,
      onPopInvokedWithResult,
      onWillPop,
      onChanged,
      autovalidateMode);
    if (st == null) throw new RuntimeException("Failed to created widget Form");
    return new Form(st);
  }
  public static FormFormBuilder form(WidgetI child) {
    return FormFormBuilder.formForm(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("formChild not supported on web");
    return new Widget(FormObjSt.child(st)) {};
  }
  public boolean canPop() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("formCanPop not supported on web");
    return intToBool(FormObjSt.canPop(st));
  }
  public AutovalidateMode autovalidateMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("formAutovalidateMode not supported on web");
    return AutovalidateMode.values()[FormObjSt.autovalidateMode(st)];
  }
  @Override
  public Form build() {
    return this;
  }
}
