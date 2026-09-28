package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class IconButton extends StatelessWidget implements IconButtonI {
  protected IconButton() {}
  IconButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget IconButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static IconButton iconButtonIconButton(OptionalDouble iconSize, Optional<VisualDensityI> visualDensity, Optional<EdgeInsetsGeometryI> padding, Optional<AlignmentGeometryI> alignment, OptionalDouble splashRadius, Optional<ColorI> color, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> splashColor, Optional<ColorI> disabledColor, Optional<Runnable> onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraintsI> constraints, Optional<Boolean> isSelected, Optional<WidgetI> selectedIcon, WidgetI icon) {
    int id = factories.iconButtonIconButton(iconSize,
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
    if (id <= 0) throw new RuntimeException("Failed to created widget IconButton");
    return new IconButton(id);
  }
  public static IconButtonIconButtonBuilder iconButton() {
    return IconButtonIconButtonBuilder.iconButtonIconButton();
  }
  @Builder.Factory
  static IconButton iconButtonFilled(OptionalDouble iconSize, Optional<VisualDensityI> visualDensity, Optional<EdgeInsetsGeometryI> padding, Optional<AlignmentGeometryI> alignment, OptionalDouble splashRadius, Optional<ColorI> color, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> splashColor, Optional<ColorI> disabledColor, Optional<Runnable> onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraintsI> constraints, Optional<Boolean> isSelected, Optional<WidgetI> selectedIcon, WidgetI icon) {
    int id = factories.iconButtonFilled(iconSize,
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
    if (id <= 0) throw new RuntimeException("Failed to created widget IconButton");
    return new IconButton(id);
  }
  public static IconButtonFilledBuilder filled() {
    return IconButtonFilledBuilder.iconButtonFilled();
  }
  @Builder.Factory
  static IconButton iconButtonFilledTonal(OptionalDouble iconSize, Optional<VisualDensityI> visualDensity, Optional<EdgeInsetsGeometryI> padding, Optional<AlignmentGeometryI> alignment, OptionalDouble splashRadius, Optional<ColorI> color, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> splashColor, Optional<ColorI> disabledColor, Optional<Runnable> onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraintsI> constraints, Optional<Boolean> isSelected, Optional<WidgetI> selectedIcon, WidgetI icon) {
    int id = factories.iconButtonFilledTonal(iconSize,
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
    if (id <= 0) throw new RuntimeException("Failed to created widget IconButton");
    return new IconButton(id);
  }
  public static IconButtonFilledTonalBuilder filledTonal() {
    return IconButtonFilledTonalBuilder.iconButtonFilledTonal();
  }
  @Builder.Factory
  static IconButton iconButtonOutlined(OptionalDouble iconSize, Optional<VisualDensityI> visualDensity, Optional<EdgeInsetsGeometryI> padding, Optional<AlignmentGeometryI> alignment, OptionalDouble splashRadius, Optional<ColorI> color, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> splashColor, Optional<ColorI> disabledColor, Optional<Runnable> onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraintsI> constraints, Optional<Boolean> isSelected, Optional<WidgetI> selectedIcon, WidgetI icon) {
    int id = factories.iconButtonOutlined(iconSize,
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
    if (id <= 0) throw new RuntimeException("Failed to created widget IconButton");
    return new IconButton(id);
  }
  public static IconButtonOutlinedBuilder outlined() {
    return IconButtonOutlinedBuilder.iconButtonOutlined();
  }
  public double iconSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconButtonIconSize not supported on web");
    return factories.IconButton_readBack_iconSize(nativeStruct);
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconButtonVisualDensity", getId());
      return new VisualDensity(__nid);
    }
    return factories.IconButton_readBack_visualDensity(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconButtonPadding not supported on web");
    return factories.IconButton_readBack_padding(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconButtonAlignment not supported on web");
    return factories.IconButton_readBack_alignment(nativeStruct);
  }
  public double splashRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconButtonSplashRadius not supported on web");
    return factories.IconButton_readBack_splashRadius(nativeStruct);
  }
  public Widget icon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconButtonIcon not supported on web");
    return factories.IconButton_readBack_icon(nativeStruct);
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconButtonFocusColor", getId());
      return new Color(__nid);
    }
    return factories.IconButton_readBack_focusColor(nativeStruct);
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconButtonHoverColor", getId());
      return new Color(__nid);
    }
    return factories.IconButton_readBack_hoverColor(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconButtonColor", getId());
      return new Color(__nid);
    }
    return factories.IconButton_readBack_color(nativeStruct);
  }
  public Color splashColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconButtonSplashColor", getId());
      return new Color(__nid);
    }
    return factories.IconButton_readBack_splashColor(nativeStruct);
  }
  public Color highlightColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconButtonHighlightColor", getId());
      return new Color(__nid);
    }
    return factories.IconButton_readBack_highlightColor(nativeStruct);
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconButtonDisabledColor", getId());
      return new Color(__nid);
    }
    return factories.IconButton_readBack_disabledColor(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconButtonAutofocus not supported on web");
    return factories.IconButton_readBack_autofocus(nativeStruct);
  }
  public String tooltip() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconButtonTooltip not supported on web");
    return factories.IconButton_readBack_tooltip(nativeStruct);
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconButtonEnableFeedback not supported on web");
    return factories.IconButton_readBack_enableFeedback(nativeStruct);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconButtonConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.IconButton_readBack_constraints(nativeStruct);
  }
  public boolean isSelected() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconButtonIsSelected not supported on web");
    return factories.IconButton_readBack_isSelected(nativeStruct);
  }
  public Widget selectedIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconButtonSelectedIcon not supported on web");
    return factories.IconButton_readBack_selectedIcon(nativeStruct);
  }
  @Override
  public IconButton build() {
    return this;
  }
}
