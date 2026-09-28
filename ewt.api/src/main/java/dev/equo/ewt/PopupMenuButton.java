package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class PopupMenuButton<T> extends StatefulWidget implements PopupMenuButtonI {
  protected PopupMenuButton() {}
  PopupMenuButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget PopupMenuButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static <T extends NativeObj> PopupMenuButton<T> popupMenuButtonPopupMenuButton(@Builder.Parameter Function<BuildContext, List<PopupMenuEntry>> itemBuilder, Optional<NativeObj> initialValue, Optional<Runnable> onOpened, Optional<Consumer<NativeObj>> onSelected, Optional<Runnable> onCanceled, Optional<String> tooltip, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<EdgeInsetsGeometryI> padding, Optional<EdgeInsetsGeometryI> menuPadding, Optional<WidgetI> child, Optional<BorderRadiusI> borderRadius, OptionalDouble splashRadius, Optional<WidgetI> icon, OptionalDouble iconSize, Optional<OffsetI> offset, Optional<Boolean> enabled, Optional<ShapeBorderI> shape, Optional<ColorI> color, Optional<ColorI> iconColor, Optional<Boolean> enableFeedback, Optional<BoxConstraintsI> constraints, Optional<PopupMenuPosition> position, Optional<Clip> clipBehavior, Optional<Boolean> useRootNavigator, Optional<Boolean> requestFocus) {
    int id = factories.popupMenuButtonPopupMenuButton(itemBuilder,
      initialValue,
      onOpened,
      onSelected,
      onCanceled,
      tooltip,
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      padding.map(EdgeInsetsGeometryI::build),
      menuPadding.map(EdgeInsetsGeometryI::build),
      child.map(WidgetI::build),
      borderRadius.map(BorderRadiusI::build),
      splashRadius,
      icon.map(WidgetI::build),
      iconSize,
      offset.map(OffsetI::build),
      enabled,
      shape.map(ShapeBorderI::build),
      color.map(ColorI::build),
      iconColor.map(ColorI::build),
      enableFeedback,
      constraints.map(BoxConstraintsI::build),
      position,
      clipBehavior,
      useRootNavigator,
      requestFocus);
    if (id <= 0) throw new RuntimeException("Failed to created widget PopupMenuButton");
    return new PopupMenuButton(id);
  }
  public static <T extends NativeObj> PopupMenuButtonPopupMenuButtonBuilder<T> popupMenuButton(Function<BuildContext, List<PopupMenuEntry>> itemBuilder) {
    return PopupMenuButtonPopupMenuButtonBuilder.popupMenuButtonPopupMenuButton(itemBuilder);
  }
  public String tooltip() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonTooltip not supported on web");
    return factories.PopupMenuButton_readBack_tooltip(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonElevation not supported on web");
    return factories.PopupMenuButton_readBack_elevation(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuButtonShadowColor", getId());
      return new Color(__nid);
    }
    return factories.PopupMenuButton_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuButtonSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.PopupMenuButton_readBack_surfaceTintColor(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonPadding not supported on web");
    return factories.PopupMenuButton_readBack_padding(nativeStruct);
  }
  public EdgeInsetsGeometry menuPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonMenuPadding not supported on web");
    return factories.PopupMenuButton_readBack_menuPadding(nativeStruct);
  }
  public double splashRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonSplashRadius not supported on web");
    return factories.PopupMenuButton_readBack_splashRadius(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonChild not supported on web");
    return factories.PopupMenuButton_readBack_child(nativeStruct);
  }
  public BorderRadius borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuButtonBorderRadius", getId());
      return new BorderRadius(__nid);
    }
    return factories.PopupMenuButton_readBack_borderRadius(nativeStruct);
  }
  public Widget icon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonIcon not supported on web");
    return factories.PopupMenuButton_readBack_icon(nativeStruct);
  }
  public Offset offset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuButtonOffset", getId());
      return new Offset(__nid);
    }
    return factories.PopupMenuButton_readBack_offset(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonEnabled not supported on web");
    return factories.PopupMenuButton_readBack_enabled(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonShape not supported on web");
    return factories.PopupMenuButton_readBack_shape(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuButtonColor", getId());
      return new Color(__nid);
    }
    return factories.PopupMenuButton_readBack_color(nativeStruct);
  }
  public Color iconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuButtonIconColor", getId());
      return new Color(__nid);
    }
    return factories.PopupMenuButton_readBack_iconColor(nativeStruct);
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonEnableFeedback not supported on web");
    return factories.PopupMenuButton_readBack_enableFeedback(nativeStruct);
  }
  public double iconSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonIconSize not supported on web");
    return factories.PopupMenuButton_readBack_iconSize(nativeStruct);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuButtonConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.PopupMenuButton_readBack_constraints(nativeStruct);
  }
  public PopupMenuPosition position() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonPosition not supported on web");
    return factories.PopupMenuButton_readBack_position(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonClipBehavior not supported on web");
    return factories.PopupMenuButton_readBack_clipBehavior(nativeStruct);
  }
  public boolean useRootNavigator() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonUseRootNavigator not supported on web");
    return factories.PopupMenuButton_readBack_useRootNavigator(nativeStruct);
  }
  public boolean requestFocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonRequestFocus not supported on web");
    return factories.PopupMenuButton_readBack_requestFocus(nativeStruct);
  }
  @Override
  public PopupMenuButton build() {
    return this;
  }
}
