package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class FormField<T> extends StatefulWidget implements FormFieldI {
  protected FormField() {}
  FormField(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget FormField");
    this.nativeStruct = factories.takeLastStruct();
  }
  public String forceErrorText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("formFieldForceErrorText not supported on web");
    return factories.FormField_readBack_forceErrorText(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("formFieldEnabled not supported on web");
    return factories.FormField_readBack_enabled(nativeStruct);
  }
  public AutovalidateMode autovalidateMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("formFieldAutovalidateMode not supported on web");
    return factories.FormField_readBack_autovalidateMode(nativeStruct);
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("formFieldRestorationId not supported on web");
    return factories.FormField_readBack_restorationId(nativeStruct);
  }
  @Override
  public FormField build() {
    return this;
  }
}
