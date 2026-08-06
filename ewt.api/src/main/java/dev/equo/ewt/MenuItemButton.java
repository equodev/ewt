package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MenuItemButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MenuItemButton extends StatefulWidget implements MenuItemButtonI {
  private MemorySegment st;
  protected MenuItemButton() {}
  MenuItemButton(MemorySegment st) {
    this.id = MenuItemButtonObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuItemButton");
    System.out.println("New MenuItemButton id:"+id);
  }
  MenuItemButton(int id) { this.id = id; }
  @Builder.Factory
  static MenuItemButton menuItemButtonMenuItemButton(Optional<Runnable> onPressed, Optional<Consumer<Boolean>> onHover, Optional<Boolean> requestFocusOnHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<String> semanticsLabel, Optional<Clip> clipBehavior, Optional<WidgetI> leadingIcon, Optional<WidgetI> trailingIcon, Optional<Boolean> closeOnActivate, Optional<Axis> overflowAxis, Optional<WidgetI> child) {
    var st = factories.menuItemButtonMenuItemButton(onPressed,
      onHover,
      requestFocusOnHover,
      onFocusChange,
      autofocus,
      semanticsLabel,
      clipBehavior,
      leadingIcon.map(WidgetI::build),
      trailingIcon.map(WidgetI::build),
      closeOnActivate,
      overflowAxis,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget MenuItemButton");
    return new MenuItemButton(st);
  }
  public static MenuItemButtonMenuItemButtonBuilder menuItemButton() {
    return MenuItemButtonMenuItemButtonBuilder.menuItemButtonMenuItemButton();
  }
  public boolean requestFocusOnHover() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuItemButtonRequestFocusOnHover not supported on web");
    return intToBool(MenuItemButtonObjSt.requestFocusOnHover(st));
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuItemButtonAutofocus not supported on web");
    return intToBool(MenuItemButtonObjSt.autofocus(st));
  }
  public String semanticsLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuItemButtonSemanticsLabel not supported on web");
    return MenuItemButtonObjSt.semanticsLabel(st).getString(0);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuItemButtonClipBehavior not supported on web");
    return Clip.values()[MenuItemButtonObjSt.clipBehavior(st)];
  }
  public Widget leadingIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuItemButtonLeadingIcon not supported on web");
    return new Widget(MenuItemButtonObjSt.leadingIcon(st)) {};
  }
  public Widget trailingIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuItemButtonTrailingIcon not supported on web");
    return new Widget(MenuItemButtonObjSt.trailingIcon(st)) {};
  }
  public boolean closeOnActivate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuItemButtonCloseOnActivate not supported on web");
    return intToBool(MenuItemButtonObjSt.closeOnActivate(st));
  }
  public Axis overflowAxis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuItemButtonOverflowAxis not supported on web");
    return Axis.values()[MenuItemButtonObjSt.overflowAxis(st)];
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuItemButtonChild not supported on web");
    return new Widget(MenuItemButtonObjSt.child(st)) {};
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuItemButtonEnabled not supported on web");
    return intToBool(MenuItemButtonObjSt.enabled(st));
  }
  @Override
  public MenuItemButton build() {
    return this;
  }
}
