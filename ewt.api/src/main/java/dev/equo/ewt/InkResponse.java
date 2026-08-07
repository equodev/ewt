package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.InkResponseObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class InkResponse extends StatelessWidget implements InkResponseI {
  private MemorySegment st;
  protected InkResponse() {}
  InkResponse(MemorySegment st) {
    this.id = InkResponseObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget InkResponse");
    System.out.println("New InkResponse id:"+id);
  }
  InkResponse(int id) { this.id = id; }
  @Builder.Factory
  static InkResponse inkResponseInkResponse(Optional<WidgetI> child, Optional<Runnable> onTap, Optional<Runnable> onTapCancel, Optional<Runnable> onDoubleTap, Optional<Runnable> onLongPress, Optional<Runnable> onSecondaryTap, Optional<Runnable> onSecondaryTapCancel, Optional<Consumer<Boolean>> onHighlightChanged, Optional<Consumer<Boolean>> onHover, Optional<Boolean> containedInkWell, Optional<BoxShape> highlightShape, OptionalDouble radius, Optional<BorderRadiusI> borderRadius, Optional<ShapeBorderI> customBorder, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> splashColor, Optional<Boolean> enableFeedback, Optional<Boolean> excludeFromSemantics, Optional<Boolean> canRequestFocus, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<DurationI> hoverDuration) {
    var st = factories.inkResponseInkResponse(child.map(WidgetI::build),
      onTap,
      onTapCancel,
      onDoubleTap,
      onLongPress,
      onSecondaryTap,
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
      splashColor.map(ColorI::build),
      enableFeedback,
      excludeFromSemantics,
      canRequestFocus,
      onFocusChange,
      autofocus,
      hoverDuration.map(DurationI::build));
    if (st == null) throw new RuntimeException("Failed to created widget InkResponse");
    return new InkResponse(st);
  }
  public static InkResponseInkResponseBuilder inkResponse() {
    return InkResponseInkResponseBuilder.inkResponseInkResponse();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkResponseChild not supported on web");
    return new Widget(InkResponseObjSt.child(st)) {};
  }
  public boolean containedInkWell() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkResponseContainedInkWell not supported on web");
    return intToBool(InkResponseObjSt.containedInkWell(st));
  }
  public BoxShape highlightShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkResponseHighlightShape not supported on web");
    return BoxShape.values()[InkResponseObjSt.highlightShape(st)];
  }
  public double radius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkResponseRadius not supported on web");
    return InkResponseObjSt.radius(st);
  }
  public BorderRadius borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inkResponseBorderRadius", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderRadiusObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderRadiusObjSt.id(__st, __nid);
      return new BorderRadius(__st);
    }
    return new BorderRadius(InkResponseObjSt.borderRadius(st));
  }
  public ShapeBorder customBorder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkResponseCustomBorder not supported on web");
    return new ShapeBorder(InkResponseObjSt.customBorder(st)) {};
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inkResponseFocusColor", getId());
      return new Color(__nid);
    }
    return new Color(InkResponseObjSt.focusColor(st));
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inkResponseHoverColor", getId());
      return new Color(__nid);
    }
    return new Color(InkResponseObjSt.hoverColor(st));
  }
  public Color highlightColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inkResponseHighlightColor", getId());
      return new Color(__nid);
    }
    return new Color(InkResponseObjSt.highlightColor(st));
  }
  public Color splashColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inkResponseSplashColor", getId());
      return new Color(__nid);
    }
    return new Color(InkResponseObjSt.splashColor(st));
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkResponseEnableFeedback not supported on web");
    return intToBool(InkResponseObjSt.enableFeedback(st));
  }
  public boolean excludeFromSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkResponseExcludeFromSemantics not supported on web");
    return intToBool(InkResponseObjSt.excludeFromSemantics(st));
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkResponseAutofocus not supported on web");
    return intToBool(InkResponseObjSt.autofocus(st));
  }
  public boolean canRequestFocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkResponseCanRequestFocus not supported on web");
    return intToBool(InkResponseObjSt.canRequestFocus(st));
  }
  public Duration hoverDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inkResponseHoverDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(InkResponseObjSt.hoverDuration(st));
  }
  @Override
  public InkResponse build() {
    return this;
  }
}
