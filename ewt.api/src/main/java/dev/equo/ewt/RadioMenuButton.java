package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class RadioMenuButton<T> extends StatelessWidget implements RadioMenuButtonI {
  protected RadioMenuButton() {}
  RadioMenuButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget RadioMenuButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static <T extends NativeObj> RadioMenuButton<T> radioMenuButtonRadioMenuButton(@Builder.Parameter NativeObj value, Optional<NativeObj> groupValue, Optional<Consumer<NativeObj>> onChanged, Optional<Boolean> toggleable, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Clip> clipBehavior, Optional<WidgetI> trailingIcon, Optional<Boolean> closeOnActivate, Optional<WidgetI> child) {
    int id = factories.radioMenuButtonRadioMenuButton(value,
      groupValue,
      onChanged,
      toggleable,
      onHover,
      onFocusChange,
      clipBehavior,
      trailingIcon.map(WidgetI::build),
      closeOnActivate,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget RadioMenuButton");
    return new RadioMenuButton(id);
  }
  public static <T extends NativeObj> RadioMenuButtonRadioMenuButtonBuilder<T> radioMenuButton(NativeObj value) {
    return RadioMenuButtonRadioMenuButtonBuilder.radioMenuButtonRadioMenuButton(value);
  }
  public boolean toggleable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioMenuButtonToggleable not supported on web");
    return factories.RadioMenuButton_readBack_toggleable(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioMenuButtonClipBehavior not supported on web");
    return factories.RadioMenuButton_readBack_clipBehavior(nativeStruct);
  }
  public Widget trailingIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioMenuButtonTrailingIcon not supported on web");
    return factories.RadioMenuButton_readBack_trailingIcon(nativeStruct);
  }
  public boolean closeOnActivate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioMenuButtonCloseOnActivate not supported on web");
    return factories.RadioMenuButton_readBack_closeOnActivate(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioMenuButtonChild not supported on web");
    return factories.RadioMenuButton_readBack_child(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioMenuButtonEnabled not supported on web");
    return factories.RadioMenuButton_readBack_enabled(nativeStruct);
  }
  @Override
  public RadioMenuButton build() {
    return this;
  }
}
