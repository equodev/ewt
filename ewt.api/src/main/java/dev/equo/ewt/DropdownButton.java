package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DropdownButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DropdownButton<T> extends StatefulWidget implements DropdownButtonI {
  private MemorySegment st;
  protected DropdownButton() {}
  DropdownButton(MemorySegment st) {
    this.id = DropdownButtonObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DropdownButton");
    System.out.println("New DropdownButton id:"+id);
  }
  DropdownButton(int id) { this.id = id; }
  @Builder.Factory
  static <T extends NativeObj> DropdownButton<T> dropdownButtonDropdownButton(Optional<List<DropdownMenuItemI>> items, Optional<Function<BuildContext, List<Widget>>> selectedItemBuilder, Optional<NativeObj> value, Optional<WidgetI> hint, Optional<WidgetI> disabledHint, Optional<Consumer<NativeObj>> onChanged, Optional<Runnable> onTap, OptionalInt elevation, Optional<TextStyleI> style, Optional<WidgetI> underline, Optional<WidgetI> icon, Optional<ColorI> iconDisabledColor, Optional<ColorI> iconEnabledColor, OptionalDouble iconSize, Optional<Boolean> isDense, Optional<Boolean> isExpanded, OptionalDouble itemHeight, OptionalDouble menuWidth, Optional<ColorI> focusColor, Optional<Boolean> autofocus, Optional<ColorI> dropdownColor, OptionalDouble menuMaxHeight, Optional<Boolean> enableFeedback, Optional<AlignmentGeometryI> alignment, Optional<BorderRadiusI> borderRadius, Optional<EdgeInsetsGeometryI> padding, Optional<Boolean> barrierDismissible) {
    var st = factories.dropdownButtonDropdownButton(items.map(i -> i.stream().map(DropdownMenuItemI::build).toList()),
      selectedItemBuilder,
      value,
      hint.map(WidgetI::build),
      disabledHint.map(WidgetI::build),
      onChanged,
      onTap,
      elevation,
      style.map(TextStyleI::build),
      underline.map(WidgetI::build),
      icon.map(WidgetI::build),
      iconDisabledColor.map(ColorI::build),
      iconEnabledColor.map(ColorI::build),
      iconSize,
      isDense,
      isExpanded,
      itemHeight,
      menuWidth,
      focusColor.map(ColorI::build),
      autofocus,
      dropdownColor.map(ColorI::build),
      menuMaxHeight,
      enableFeedback,
      alignment.map(AlignmentGeometryI::build),
      borderRadius.map(BorderRadiusI::build),
      padding.map(EdgeInsetsGeometryI::build),
      barrierDismissible);
    if (st == null) throw new RuntimeException("Failed to created widget DropdownButton");
    return new DropdownButton(st);
  }
  public static <T extends NativeObj> DropdownButtonDropdownButtonBuilder<T> dropdownButton() {
    return DropdownButtonDropdownButtonBuilder.dropdownButtonDropdownButton();
  }
  public Widget hint() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonHint not supported on web");
    return new Widget(DropdownButtonObjSt.hint(st)) {};
  }
  public Widget disabledHint() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonDisabledHint not supported on web");
    return new Widget(DropdownButtonObjSt.disabledHint(st)) {};
  }
  public int elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonElevation not supported on web");
    return DropdownButtonObjSt.elevation(st);
  }
  public TextStyle style() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dropdownButtonStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(DropdownButtonObjSt.style(st));
  }
  public Widget underline() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonUnderline not supported on web");
    return new Widget(DropdownButtonObjSt.underline(st)) {};
  }
  public Widget icon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonIcon not supported on web");
    return new Widget(DropdownButtonObjSt.icon(st)) {};
  }
  public Color iconDisabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dropdownButtonIconDisabledColor", getId());
      return new Color(__nid);
    }
    return new Color(DropdownButtonObjSt.iconDisabledColor(st));
  }
  public Color iconEnabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dropdownButtonIconEnabledColor", getId());
      return new Color(__nid);
    }
    return new Color(DropdownButtonObjSt.iconEnabledColor(st));
  }
  public double iconSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonIconSize not supported on web");
    return DropdownButtonObjSt.iconSize(st);
  }
  public boolean isDense() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonIsDense not supported on web");
    return intToBool(DropdownButtonObjSt.isDense(st));
  }
  public boolean isExpanded() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonIsExpanded not supported on web");
    return intToBool(DropdownButtonObjSt.isExpanded(st));
  }
  public double itemHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonItemHeight not supported on web");
    return DropdownButtonObjSt.itemHeight(st);
  }
  public double menuWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonMenuWidth not supported on web");
    return DropdownButtonObjSt.menuWidth(st);
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dropdownButtonFocusColor", getId());
      return new Color(__nid);
    }
    return new Color(DropdownButtonObjSt.focusColor(st));
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonAutofocus not supported on web");
    return intToBool(DropdownButtonObjSt.autofocus(st));
  }
  public Color dropdownColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dropdownButtonDropdownColor", getId());
      return new Color(__nid);
    }
    return new Color(DropdownButtonObjSt.dropdownColor(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonPadding not supported on web");
    return new EdgeInsetsGeometry(DropdownButtonObjSt.padding(st)) {};
  }
  public double menuMaxHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonMenuMaxHeight not supported on web");
    return DropdownButtonObjSt.menuMaxHeight(st);
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonEnableFeedback not supported on web");
    return intToBool(DropdownButtonObjSt.enableFeedback(st));
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonAlignment not supported on web");
    return new AlignmentGeometry(DropdownButtonObjSt.alignment(st)) {};
  }
  public BorderRadius borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dropdownButtonBorderRadius", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderRadiusObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderRadiusObjSt.id(__st, __nid);
      return new BorderRadius(__st);
    }
    return new BorderRadius(DropdownButtonObjSt.borderRadius(st));
  }
  public boolean barrierDismissible() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonBarrierDismissible not supported on web");
    return intToBool(DropdownButtonObjSt.barrierDismissible(st));
  }
  @Override
  public DropdownButton build() {
    return this;
  }
}
