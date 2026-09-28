package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class InkResponse extends StatelessWidget implements InkResponseI {
  protected InkResponse() {}
  InkResponse(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget InkResponse");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static InkResponse inkResponseInkResponse(Optional<WidgetI> child, Optional<Runnable> onTap, Optional<Consumer<TapDownDetails>> onTapDown, Optional<Consumer<TapUpDetails>> onTapUp, Optional<Runnable> onTapCancel, Optional<Runnable> onDoubleTap, Optional<Runnable> onLongPress, Optional<Runnable> onLongPressUp, Optional<Runnable> onSecondaryTap, Optional<Consumer<TapUpDetails>> onSecondaryTapUp, Optional<Consumer<TapDownDetails>> onSecondaryTapDown, Optional<Runnable> onSecondaryTapCancel, Optional<Consumer<Boolean>> onHighlightChanged, Optional<Consumer<Boolean>> onHover, Optional<Boolean> containedInkWell, Optional<BoxShape> highlightShape, OptionalDouble radius, Optional<BorderRadiusI> borderRadius, Optional<ShapeBorderI> customBorder, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> overlayColor, Optional<ColorI> splashColor, Optional<Boolean> enableFeedback, Optional<Boolean> excludeFromSemantics, Optional<Boolean> canRequestFocus, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<DurationI> hoverDuration) {
    int id = factories.inkResponseInkResponse(child.map(WidgetI::build),
      onTap,
      onTapDown,
      onTapUp,
      onTapCancel,
      onDoubleTap,
      onLongPress,
      onLongPressUp,
      onSecondaryTap,
      onSecondaryTapUp,
      onSecondaryTapDown,
      onSecondaryTapCancel,
      onHighlightChanged,
      onHover,
      containedInkWell,
      highlightShape,
      radius,
      borderRadius.map(BorderRadiusI::build),
      customBorder.map(ShapeBorderI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      highlightColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      enableFeedback,
      excludeFromSemantics,
      canRequestFocus,
      onFocusChange,
      autofocus,
      hoverDuration.map(DurationI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget InkResponse");
    return new InkResponse(id);
  }
  public static InkResponseInkResponseBuilder inkResponse() {
    return InkResponseInkResponseBuilder.inkResponseInkResponse();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkResponseChild not supported on web");
    return factories.InkResponse_readBack_child(nativeStruct);
  }
  public boolean containedInkWell() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkResponseContainedInkWell not supported on web");
    return factories.InkResponse_readBack_containedInkWell(nativeStruct);
  }
  public BoxShape highlightShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkResponseHighlightShape not supported on web");
    return factories.InkResponse_readBack_highlightShape(nativeStruct);
  }
  public double radius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkResponseRadius not supported on web");
    return factories.InkResponse_readBack_radius(nativeStruct);
  }
  public BorderRadius borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inkResponseBorderRadius", getId());
      return new BorderRadius(__nid);
    }
    return factories.InkResponse_readBack_borderRadius(nativeStruct);
  }
  public ShapeBorder customBorder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkResponseCustomBorder not supported on web");
    return factories.InkResponse_readBack_customBorder(nativeStruct);
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inkResponseFocusColor", getId());
      return new Color(__nid);
    }
    return factories.InkResponse_readBack_focusColor(nativeStruct);
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inkResponseHoverColor", getId());
      return new Color(__nid);
    }
    return factories.InkResponse_readBack_hoverColor(nativeStruct);
  }
  public Color highlightColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inkResponseHighlightColor", getId());
      return new Color(__nid);
    }
    return factories.InkResponse_readBack_highlightColor(nativeStruct);
  }
  public Color splashColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inkResponseSplashColor", getId());
      return new Color(__nid);
    }
    return factories.InkResponse_readBack_splashColor(nativeStruct);
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkResponseEnableFeedback not supported on web");
    return factories.InkResponse_readBack_enableFeedback(nativeStruct);
  }
  public boolean excludeFromSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkResponseExcludeFromSemantics not supported on web");
    return factories.InkResponse_readBack_excludeFromSemantics(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkResponseAutofocus not supported on web");
    return factories.InkResponse_readBack_autofocus(nativeStruct);
  }
  public boolean canRequestFocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkResponseCanRequestFocus not supported on web");
    return factories.InkResponse_readBack_canRequestFocus(nativeStruct);
  }
  public Duration hoverDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inkResponseHoverDuration", getId());
      return new Duration(__nid);
    }
    return factories.InkResponse_readBack_hoverDuration(nativeStruct);
  }
  @Override
  public InkResponse build() {
    return this;
  }
}
