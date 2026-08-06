package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PopupMenuButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class PopupMenuButton<T> extends StatefulWidget implements PopupMenuButtonI {
  private MemorySegment st;
  protected PopupMenuButton() {}
  PopupMenuButton(MemorySegment st) {
    this.id = PopupMenuButtonObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget PopupMenuButton");
    System.out.println("New PopupMenuButton id:"+id);
  }
  PopupMenuButton(int id) { this.id = id; }
  @Builder.Factory
  static <T extends NativeObj> PopupMenuButton<T> popupMenuButtonPopupMenuButton(@Builder.Parameter Function<BuildContext, List<PopupMenuEntry>> itemBuilder, Optional<NativeObj> initialValue, Optional<Runnable> onOpened, Optional<Consumer<NativeObj>> onSelected, Optional<Runnable> onCanceled, Optional<String> tooltip, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<EdgeInsetsGeometryI> padding, Optional<EdgeInsetsGeometryI> menuPadding, Optional<WidgetI> child, Optional<BorderRadiusI> borderRadius, OptionalDouble splashRadius, Optional<WidgetI> icon, OptionalDouble iconSize, Optional<OffsetI> offset, Optional<Boolean> enabled, Optional<ShapeBorderI> shape, Optional<ColorI> color, Optional<ColorI> iconColor, Optional<Boolean> enableFeedback, Optional<BoxConstraintsI> constraints, Optional<PopupMenuPosition> position, Optional<Clip> clipBehavior, Optional<Boolean> useRootNavigator, Optional<Boolean> requestFocus) {
    var st = factories.popupMenuButtonPopupMenuButton(itemBuilder,
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
    if (st == null) throw new RuntimeException("Failed to created widget PopupMenuButton");
    return new PopupMenuButton(st);
  }
  public static <T extends NativeObj> PopupMenuButtonPopupMenuButtonBuilder<T> popupMenuButton(Function<BuildContext, List<PopupMenuEntry>> itemBuilder) {
    return PopupMenuButtonPopupMenuButtonBuilder.popupMenuButtonPopupMenuButton(itemBuilder);
  }
  public String tooltip() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonTooltip not supported on web");
    return PopupMenuButtonObjSt.tooltip(st).getString(0);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonElevation not supported on web");
    return PopupMenuButtonObjSt.elevation(st);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuButtonShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(PopupMenuButtonObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuButtonSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(PopupMenuButtonObjSt.surfaceTintColor(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonPadding not supported on web");
    return new EdgeInsetsGeometry(PopupMenuButtonObjSt.padding(st)) {};
  }
  public EdgeInsetsGeometry menuPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonMenuPadding not supported on web");
    return new EdgeInsetsGeometry(PopupMenuButtonObjSt.menuPadding(st)) {};
  }
  public double splashRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonSplashRadius not supported on web");
    return PopupMenuButtonObjSt.splashRadius(st);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonChild not supported on web");
    return new Widget(PopupMenuButtonObjSt.child(st)) {};
  }
  public BorderRadius borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuButtonBorderRadius", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderRadiusObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderRadiusObjSt.id(__st, __nid);
      return new BorderRadius(__st);
    }
    return new BorderRadius(PopupMenuButtonObjSt.borderRadius(st));
  }
  public Widget icon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonIcon not supported on web");
    return new Widget(PopupMenuButtonObjSt.icon(st)) {};
  }
  public Offset offset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuButtonOffset", getId());
      return new Offset(__nid);
    }
    return new Offset(PopupMenuButtonObjSt.offset(st));
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonEnabled not supported on web");
    return intToBool(PopupMenuButtonObjSt.enabled(st));
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonShape not supported on web");
    return new ShapeBorder(PopupMenuButtonObjSt.shape(st)) {};
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuButtonColor", getId());
      return new Color(__nid);
    }
    return new Color(PopupMenuButtonObjSt.color(st));
  }
  public Color iconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuButtonIconColor", getId());
      return new Color(__nid);
    }
    return new Color(PopupMenuButtonObjSt.iconColor(st));
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonEnableFeedback not supported on web");
    return intToBool(PopupMenuButtonObjSt.enableFeedback(st));
  }
  public double iconSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonIconSize not supported on web");
    return PopupMenuButtonObjSt.iconSize(st);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuButtonConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(PopupMenuButtonObjSt.constraints(st));
  }
  public PopupMenuPosition position() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonPosition not supported on web");
    return PopupMenuPosition.values()[PopupMenuButtonObjSt.position(st)];
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonClipBehavior not supported on web");
    return Clip.values()[PopupMenuButtonObjSt.clipBehavior(st)];
  }
  public boolean useRootNavigator() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonUseRootNavigator not supported on web");
    return intToBool(PopupMenuButtonObjSt.useRootNavigator(st));
  }
  public boolean requestFocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuButtonRequestFocus not supported on web");
    return intToBool(PopupMenuButtonObjSt.requestFocus(st));
  }
  @Override
  public PopupMenuButton build() {
    return this;
  }
}
