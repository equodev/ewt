package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.IconButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class IconButton extends StatelessWidget implements IconButtonI {
  private MemorySegment st;
  protected IconButton() {}
  IconButton(MemorySegment st) {
    this.id = IconButtonObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget IconButton");
    System.out.println("New IconButton id:"+id);
  }
  @Builder.Factory
  static IconButton iconButtonIconButton(OptionalDouble iconSize, Optional<VisualDensityI> visualDensity, Optional<EdgeInsetsGeometryI> padding, Optional<AlignmentGeometryI> alignment, OptionalDouble splashRadius, Optional<ColorI> color, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> splashColor, Optional<ColorI> disabledColor, Runnable onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraintsI> constraints, Optional<Boolean> isSelected, Optional<WidgetI> selectedIcon, WidgetI icon) {
    var st = factories.iconButtonIconButton(iconSize,
      visualDensity.map(VisualDensityI::build),
      padding.map(EdgeInsetsGeometryI::build),
      alignment.map(AlignmentGeometryI::build),
      splashRadius,
      color.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      highlightColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      disabledColor.map(ColorI::build),
      onPressed,
      onHover,
      onLongPress,
      autofocus,
      tooltip,
      enableFeedback,
      constraints.map(BoxConstraintsI::build),
      isSelected,
      selectedIcon.map(WidgetI::build),
      icon.build());
    if (st == null) throw new RuntimeException("Failed to created widget IconButton");
    return new IconButton(st);
  }
  public static IconButtonIconButtonBuilder iconButton() {
    return IconButtonIconButtonBuilder.iconButtonIconButton();
  }
  @Builder.Factory
  static IconButton iconButtonFilled(OptionalDouble iconSize, Optional<VisualDensityI> visualDensity, Optional<EdgeInsetsGeometryI> padding, Optional<AlignmentGeometryI> alignment, OptionalDouble splashRadius, Optional<ColorI> color, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> splashColor, Optional<ColorI> disabledColor, Runnable onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraintsI> constraints, Optional<Boolean> isSelected, Optional<WidgetI> selectedIcon, WidgetI icon) {
    var st = factories.iconButtonFilled(iconSize,
      visualDensity.map(VisualDensityI::build),
      padding.map(EdgeInsetsGeometryI::build),
      alignment.map(AlignmentGeometryI::build),
      splashRadius,
      color.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      highlightColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      disabledColor.map(ColorI::build),
      onPressed,
      onHover,
      onLongPress,
      autofocus,
      tooltip,
      enableFeedback,
      constraints.map(BoxConstraintsI::build),
      isSelected,
      selectedIcon.map(WidgetI::build),
      icon.build());
    if (st == null) throw new RuntimeException("Failed to created widget IconButton");
    return new IconButton(st);
  }
  public static IconButtonFilledBuilder filled() {
    return IconButtonFilledBuilder.iconButtonFilled();
  }
  @Builder.Factory
  static IconButton iconButtonFilledTonal(OptionalDouble iconSize, Optional<VisualDensityI> visualDensity, Optional<EdgeInsetsGeometryI> padding, Optional<AlignmentGeometryI> alignment, OptionalDouble splashRadius, Optional<ColorI> color, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> splashColor, Optional<ColorI> disabledColor, Runnable onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraintsI> constraints, Optional<Boolean> isSelected, Optional<WidgetI> selectedIcon, WidgetI icon) {
    var st = factories.iconButtonFilledTonal(iconSize,
      visualDensity.map(VisualDensityI::build),
      padding.map(EdgeInsetsGeometryI::build),
      alignment.map(AlignmentGeometryI::build),
      splashRadius,
      color.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      highlightColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      disabledColor.map(ColorI::build),
      onPressed,
      onHover,
      onLongPress,
      autofocus,
      tooltip,
      enableFeedback,
      constraints.map(BoxConstraintsI::build),
      isSelected,
      selectedIcon.map(WidgetI::build),
      icon.build());
    if (st == null) throw new RuntimeException("Failed to created widget IconButton");
    return new IconButton(st);
  }
  public static IconButtonFilledTonalBuilder filledTonal() {
    return IconButtonFilledTonalBuilder.iconButtonFilledTonal();
  }
  @Builder.Factory
  static IconButton iconButtonOutlined(OptionalDouble iconSize, Optional<VisualDensityI> visualDensity, Optional<EdgeInsetsGeometryI> padding, Optional<AlignmentGeometryI> alignment, OptionalDouble splashRadius, Optional<ColorI> color, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> splashColor, Optional<ColorI> disabledColor, Runnable onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraintsI> constraints, Optional<Boolean> isSelected, Optional<WidgetI> selectedIcon, WidgetI icon) {
    var st = factories.iconButtonOutlined(iconSize,
      visualDensity.map(VisualDensityI::build),
      padding.map(EdgeInsetsGeometryI::build),
      alignment.map(AlignmentGeometryI::build),
      splashRadius,
      color.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      highlightColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      disabledColor.map(ColorI::build),
      onPressed,
      onHover,
      onLongPress,
      autofocus,
      tooltip,
      enableFeedback,
      constraints.map(BoxConstraintsI::build),
      isSelected,
      selectedIcon.map(WidgetI::build),
      icon.build());
    if (st == null) throw new RuntimeException("Failed to created widget IconButton");
    return new IconButton(st);
  }
  public static IconButtonOutlinedBuilder outlined() {
    return IconButtonOutlinedBuilder.iconButtonOutlined();
  }
  public double iconSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconButtonIconSize not supported on web");
    return IconButtonObjSt.iconSize(st);
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconButtonVisualDensity", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.VisualDensityObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.VisualDensityObjSt.id(__st, __nid);
      return new VisualDensity(__st);
    }
    return new VisualDensity(IconButtonObjSt.visualDensity(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconButtonPadding not supported on web");
    return new EdgeInsetsGeometry(IconButtonObjSt.padding(st)) {};
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconButtonAlignment not supported on web");
    return new AlignmentGeometry(IconButtonObjSt.alignment(st)) {};
  }
  public double splashRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconButtonSplashRadius not supported on web");
    return IconButtonObjSt.splashRadius(st);
  }
  public Widget icon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconButtonIcon not supported on web");
    return new Widget(IconButtonObjSt.icon(st)) {};
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconButtonFocusColor", getId());
      return new Color(__nid);
    }
    return new Color(IconButtonObjSt.focusColor(st));
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconButtonHoverColor", getId());
      return new Color(__nid);
    }
    return new Color(IconButtonObjSt.hoverColor(st));
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconButtonColor", getId());
      return new Color(__nid);
    }
    return new Color(IconButtonObjSt.color(st));
  }
  public Color splashColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconButtonSplashColor", getId());
      return new Color(__nid);
    }
    return new Color(IconButtonObjSt.splashColor(st));
  }
  public Color highlightColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconButtonHighlightColor", getId());
      return new Color(__nid);
    }
    return new Color(IconButtonObjSt.highlightColor(st));
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconButtonDisabledColor", getId());
      return new Color(__nid);
    }
    return new Color(IconButtonObjSt.disabledColor(st));
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconButtonAutofocus not supported on web");
    return intToBool(IconButtonObjSt.autofocus(st));
  }
  public String tooltip() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconButtonTooltip not supported on web");
    return IconButtonObjSt.tooltip(st).getString(0);
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconButtonEnableFeedback not supported on web");
    return intToBool(IconButtonObjSt.enableFeedback(st));
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconButtonConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(IconButtonObjSt.constraints(st));
  }
  public boolean isSelected() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconButtonIsSelected not supported on web");
    return intToBool(IconButtonObjSt.isSelected(st));
  }
  public Widget selectedIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconButtonSelectedIcon not supported on web");
    return new Widget(IconButtonObjSt.selectedIcon(st)) {};
  }
  @Override
  public IconButton build() {
    return this;
  }
}
