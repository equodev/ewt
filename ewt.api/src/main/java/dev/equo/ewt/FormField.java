package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FormFieldObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class FormField<T> extends StatefulWidget implements FormFieldI {
  private MemorySegment st;
  protected FormField() {}
  FormField(MemorySegment st) {
    this.id = FormFieldObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget FormField");
    System.out.println("New FormField id:"+id);
  }
  FormField(int id) { this.id = id; }
  public String forceErrorText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("formFieldForceErrorText not supported on web");
    return FormFieldObjSt.forceErrorText(st).getString(0);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("formFieldEnabled not supported on web");
    return intToBool(FormFieldObjSt.enabled(st));
  }
  public AutovalidateMode autovalidateMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("formFieldAutovalidateMode not supported on web");
    return AutovalidateMode.values()[FormFieldObjSt.autovalidateMode(st)];
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("formFieldRestorationId not supported on web");
    return FormFieldObjSt.restorationId(st).getString(0);
  }
  @Override
  public FormField build() {
    return this;
  }
}
