package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CheckboxMenuButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CheckboxMenuButton extends StatelessWidget implements CheckboxMenuButtonI {
  private MemorySegment st;
  protected CheckboxMenuButton() {}
  CheckboxMenuButton(MemorySegment st) {
    this.id = CheckboxMenuButtonObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CheckboxMenuButton");
    System.out.println("New CheckboxMenuButton id:"+id);
  }
  CheckboxMenuButton(int id) { this.id = id; }
  @Builder.Factory
  static CheckboxMenuButton checkboxMenuButtonCheckboxMenuButton(Optional<Boolean> value, Optional<Boolean> tristate, Optional<Boolean> isError, Optional<Consumer<Boolean>> onChanged, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Clip> clipBehavior, Optional<WidgetI> trailingIcon, Optional<Boolean> closeOnActivate, Optional<WidgetI> child) {
    var st = factories.checkboxMenuButtonCheckboxMenuButton(value,
      tristate,
      isError,
      onChanged,
      onHover,
      onFocusChange,
      clipBehavior,
      trailingIcon.map(WidgetI::build),
      closeOnActivate,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget CheckboxMenuButton");
    return new CheckboxMenuButton(st);
  }
  public static CheckboxMenuButtonCheckboxMenuButtonBuilder checkboxMenuButton() {
    return CheckboxMenuButtonCheckboxMenuButtonBuilder.checkboxMenuButtonCheckboxMenuButton();
  }
  public boolean value() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxMenuButtonValue not supported on web");
    return intToBool(CheckboxMenuButtonObjSt.value(st));
  }
  public boolean tristate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxMenuButtonTristate not supported on web");
    return intToBool(CheckboxMenuButtonObjSt.tristate(st));
  }
  public boolean isError() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxMenuButtonIsError not supported on web");
    return intToBool(CheckboxMenuButtonObjSt.isError(st));
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxMenuButtonClipBehavior not supported on web");
    return Clip.values()[CheckboxMenuButtonObjSt.clipBehavior(st)];
  }
  public Widget trailingIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxMenuButtonTrailingIcon not supported on web");
    return new Widget(CheckboxMenuButtonObjSt.trailingIcon(st)) {};
  }
  public boolean closeOnActivate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxMenuButtonCloseOnActivate not supported on web");
    return intToBool(CheckboxMenuButtonObjSt.closeOnActivate(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxMenuButtonChild not supported on web");
    return new Widget(CheckboxMenuButtonObjSt.child(st)) {};
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxMenuButtonEnabled not supported on web");
    return intToBool(CheckboxMenuButtonObjSt.enabled(st));
  }
  @Override
  public CheckboxMenuButton build() {
    return this;
  }
}
