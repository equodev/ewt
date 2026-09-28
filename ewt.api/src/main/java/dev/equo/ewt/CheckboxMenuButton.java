package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CheckboxMenuButton extends StatelessWidget implements CheckboxMenuButtonI {
  protected CheckboxMenuButton() {}
  CheckboxMenuButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CheckboxMenuButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CheckboxMenuButton checkboxMenuButtonCheckboxMenuButton(Optional<Boolean> value, Optional<Boolean> tristate, Optional<Boolean> isError, Optional<Consumer<Boolean>> onChanged, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Clip> clipBehavior, Optional<WidgetI> trailingIcon, Optional<Boolean> closeOnActivate, Optional<WidgetI> child) {
    int id = factories.checkboxMenuButtonCheckboxMenuButton(value,
      tristate,
      isError,
      onChanged,
      onHover,
      onFocusChange,
      clipBehavior,
      trailingIcon.map(WidgetI::build),
      closeOnActivate,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget CheckboxMenuButton");
    return new CheckboxMenuButton(id);
  }
  public static CheckboxMenuButtonCheckboxMenuButtonBuilder checkboxMenuButton() {
    return CheckboxMenuButtonCheckboxMenuButtonBuilder.checkboxMenuButtonCheckboxMenuButton();
  }
  public boolean value() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxMenuButtonValue not supported on web");
    return factories.CheckboxMenuButton_readBack_value(nativeStruct);
  }
  public boolean tristate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxMenuButtonTristate not supported on web");
    return factories.CheckboxMenuButton_readBack_tristate(nativeStruct);
  }
  public boolean isError() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxMenuButtonIsError not supported on web");
    return factories.CheckboxMenuButton_readBack_isError(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxMenuButtonClipBehavior not supported on web");
    return factories.CheckboxMenuButton_readBack_clipBehavior(nativeStruct);
  }
  public Widget trailingIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxMenuButtonTrailingIcon not supported on web");
    return factories.CheckboxMenuButton_readBack_trailingIcon(nativeStruct);
  }
  public boolean closeOnActivate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxMenuButtonCloseOnActivate not supported on web");
    return factories.CheckboxMenuButton_readBack_closeOnActivate(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxMenuButtonChild not supported on web");
    return factories.CheckboxMenuButton_readBack_child(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxMenuButtonEnabled not supported on web");
    return factories.CheckboxMenuButton_readBack_enabled(nativeStruct);
  }
  @Override
  public CheckboxMenuButton build() {
    return this;
  }
}
