package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RadioMenuButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class RadioMenuButton<T> extends StatelessWidget implements RadioMenuButtonI {
  private MemorySegment st;
  protected RadioMenuButton() {}
  RadioMenuButton(MemorySegment st) {
    this.id = RadioMenuButtonObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget RadioMenuButton");
    System.out.println("New RadioMenuButton id:"+id);
  }
  RadioMenuButton(int id) { this.id = id; }
  @Builder.Factory
  static <T extends NativeObj> RadioMenuButton<T> radioMenuButtonRadioMenuButton(@Builder.Parameter NativeObj value, @Builder.Parameter NativeObj groupValue, @Builder.Parameter Consumer<NativeObj> onChanged, Optional<Boolean> toggleable, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Clip> clipBehavior, Optional<WidgetI> trailingIcon, Optional<Boolean> closeOnActivate, WidgetI child) {
    var st = factories.radioMenuButtonRadioMenuButton(value,
      groupValue,
      onChanged,
      toggleable,
      onHover,
      onFocusChange,
      clipBehavior,
      trailingIcon.map(WidgetI::build),
      closeOnActivate,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget RadioMenuButton");
    return new RadioMenuButton(st);
  }
  public static <T extends NativeObj> RadioMenuButtonRadioMenuButtonBuilder<T> radioMenuButton(NativeObj value, NativeObj groupValue, Consumer<NativeObj> onChanged) {
    return RadioMenuButtonRadioMenuButtonBuilder.radioMenuButtonRadioMenuButton(value, groupValue, onChanged);
  }
  public boolean toggleable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioMenuButtonToggleable not supported on web");
    return intToBool(RadioMenuButtonObjSt.toggleable(st));
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioMenuButtonClipBehavior not supported on web");
    return Clip.values()[RadioMenuButtonObjSt.clipBehavior(st)];
  }
  public Widget trailingIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioMenuButtonTrailingIcon not supported on web");
    return new Widget(RadioMenuButtonObjSt.trailingIcon(st)) {};
  }
  public boolean closeOnActivate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioMenuButtonCloseOnActivate not supported on web");
    return intToBool(RadioMenuButtonObjSt.closeOnActivate(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioMenuButtonChild not supported on web");
    return new Widget(RadioMenuButtonObjSt.child(st)) {};
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioMenuButtonEnabled not supported on web");
    return intToBool(RadioMenuButtonObjSt.enabled(st));
  }
  @Override
  public RadioMenuButton build() {
    return this;
  }
}
