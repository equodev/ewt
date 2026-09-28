package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AutofillGroup extends StatefulWidget implements AutofillGroupI {
  protected AutofillGroup() {}
  AutofillGroup(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AutofillGroup");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AutofillGroup autofillGroupAutofillGroup(@Builder.Parameter WidgetI child, Optional<AutofillContextAction> onDisposeAction) {
    int id = factories.autofillGroupAutofillGroup(child.build(),
      onDisposeAction);
    if (id <= 0) throw new RuntimeException("Failed to created widget AutofillGroup");
    return new AutofillGroup(id);
  }
  public static AutofillGroupAutofillGroupBuilder autofillGroup(WidgetI child) {
    return AutofillGroupAutofillGroupBuilder.autofillGroupAutofillGroup(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("autofillGroupChild not supported on web");
    return factories.AutofillGroup_readBack_child(nativeStruct);
  }
  public AutofillContextAction onDisposeAction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("autofillGroupOnDisposeAction not supported on web");
    return factories.AutofillGroup_readBack_onDisposeAction(nativeStruct);
  }
  @Override
  public AutofillGroup build() {
    return this;
  }
}
