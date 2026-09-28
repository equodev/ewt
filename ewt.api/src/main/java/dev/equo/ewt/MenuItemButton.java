package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class MenuItemButton extends StatefulWidget implements MenuItemButtonI {
  protected MenuItemButton() {}
  MenuItemButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuItemButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static MenuItemButton menuItemButtonMenuItemButton(Optional<Runnable> onPressed, Optional<Consumer<Boolean>> onHover, Optional<Boolean> requestFocusOnHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<String> semanticsLabel, Optional<Clip> clipBehavior, Optional<WidgetI> leadingIcon, Optional<WidgetI> trailingIcon, Optional<Boolean> closeOnActivate, Optional<Axis> overflowAxis, Optional<WidgetI> child) {
    int id = factories.menuItemButtonMenuItemButton(onPressed,
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
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuItemButton");
    return new MenuItemButton(id);
  }
  public static MenuItemButtonMenuItemButtonBuilder menuItemButton() {
    return MenuItemButtonMenuItemButtonBuilder.menuItemButtonMenuItemButton();
  }
  public boolean requestFocusOnHover() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuItemButtonRequestFocusOnHover not supported on web");
    return factories.MenuItemButton_readBack_requestFocusOnHover(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuItemButtonAutofocus not supported on web");
    return factories.MenuItemButton_readBack_autofocus(nativeStruct);
  }
  public String semanticsLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuItemButtonSemanticsLabel not supported on web");
    return factories.MenuItemButton_readBack_semanticsLabel(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuItemButtonClipBehavior not supported on web");
    return factories.MenuItemButton_readBack_clipBehavior(nativeStruct);
  }
  public Widget leadingIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuItemButtonLeadingIcon not supported on web");
    return factories.MenuItemButton_readBack_leadingIcon(nativeStruct);
  }
  public Widget trailingIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuItemButtonTrailingIcon not supported on web");
    return factories.MenuItemButton_readBack_trailingIcon(nativeStruct);
  }
  public boolean closeOnActivate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuItemButtonCloseOnActivate not supported on web");
    return factories.MenuItemButton_readBack_closeOnActivate(nativeStruct);
  }
  public Axis overflowAxis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuItemButtonOverflowAxis not supported on web");
    return factories.MenuItemButton_readBack_overflowAxis(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuItemButtonChild not supported on web");
    return factories.MenuItemButton_readBack_child(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuItemButtonEnabled not supported on web");
    return factories.MenuItemButton_readBack_enabled(nativeStruct);
  }
  @Override
  public MenuItemButton build() {
    return this;
  }
}
