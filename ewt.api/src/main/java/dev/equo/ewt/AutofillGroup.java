package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AutofillGroupObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AutofillGroup extends StatefulWidget implements AutofillGroupI {
  private MemorySegment st;
  protected AutofillGroup() {}
  AutofillGroup(MemorySegment st) {
    this.id = AutofillGroupObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AutofillGroup");
    System.out.println("New AutofillGroup id:"+id);
  }
  AutofillGroup(int id) { this.id = id; }
  @Builder.Factory
  static AutofillGroup autofillGroupAutofillGroup(@Builder.Parameter WidgetI child, Optional<AutofillContextAction> onDisposeAction) {
    var st = factories.autofillGroupAutofillGroup(child.build(),
      onDisposeAction);
    if (st == null) throw new RuntimeException("Failed to created widget AutofillGroup");
    return new AutofillGroup(st);
  }
  public static AutofillGroupAutofillGroupBuilder autofillGroup(WidgetI child) {
    return AutofillGroupAutofillGroupBuilder.autofillGroupAutofillGroup(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("autofillGroupChild not supported on web");
    return new Widget(AutofillGroupObjSt.child(st)) {};
  }
  public AutofillContextAction onDisposeAction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("autofillGroupOnDisposeAction not supported on web");
    return AutofillContextAction.values()[AutofillGroupObjSt.onDisposeAction(st)];
  }
  @Override
  public AutofillGroup build() {
    return this;
  }
}
