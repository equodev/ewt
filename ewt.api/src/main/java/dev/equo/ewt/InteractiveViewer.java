package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.InteractiveViewerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class InteractiveViewer extends StatefulWidget implements InteractiveViewerI {
  private MemorySegment st;
  protected InteractiveViewer() {}
  InteractiveViewer(MemorySegment st) {
    this.id = InteractiveViewerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget InteractiveViewer");
    System.out.println("New InteractiveViewer id:"+id);
  }
  InteractiveViewer(int id) { this.id = id; }
  @Builder.Factory
  static InteractiveViewer interactiveViewerInteractiveViewer(Optional<Clip> clipBehavior, Optional<PanAxis> panAxis, Optional<EdgeInsetsI> boundaryMargin, Optional<Boolean> constrained, OptionalDouble maxScale, OptionalDouble minScale, OptionalDouble interactionEndFrictionCoefficient, Optional<Consumer<ScaleEndDetails>> onInteractionEnd, Optional<Consumer<ScaleStartDetails>> onInteractionStart, Optional<Consumer<ScaleUpdateDetails>> onInteractionUpdate, Optional<Boolean> panEnabled, Optional<Boolean> scaleEnabled, OptionalDouble scaleFactor, Optional<AlignmentI> alignment, Optional<Boolean> trackpadScrollCausesScale, WidgetI child) {
    var st = factories.interactiveViewerInteractiveViewer(clipBehavior,
      panAxis,
      boundaryMargin.map(EdgeInsetsI::build),
      constrained,
      maxScale,
      minScale,
      interactionEndFrictionCoefficient,
      onInteractionEnd,
      onInteractionStart,
      onInteractionUpdate,
      panEnabled,
      scaleEnabled,
      scaleFactor,
      alignment.map(AlignmentI::build),
      trackpadScrollCausesScale,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget InteractiveViewer");
    return new InteractiveViewer(st);
  }
  public static InteractiveViewerInteractiveViewerBuilder interactiveViewer() {
    return InteractiveViewerInteractiveViewerBuilder.interactiveViewerInteractiveViewer();
  }
  public Alignment alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("interactiveViewerAlignment", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.AlignmentObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.AlignmentObjSt.id(__st, __nid);
      return new Alignment(__st);
    }
    return new Alignment(InteractiveViewerObjSt.alignment(st));
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("interactiveViewerClipBehavior not supported on web");
    return Clip.values()[InteractiveViewerObjSt.clipBehavior(st)];
  }
  public PanAxis panAxis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("interactiveViewerPanAxis not supported on web");
    return PanAxis.values()[InteractiveViewerObjSt.panAxis(st)];
  }
  public EdgeInsets boundaryMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("interactiveViewerBoundaryMargin", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.EdgeInsetsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.EdgeInsetsObjSt.id(__st, __nid);
      return new EdgeInsets(__st);
    }
    return new EdgeInsets(InteractiveViewerObjSt.boundaryMargin(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("interactiveViewerChild not supported on web");
    return new Widget(InteractiveViewerObjSt.child(st)) {};
  }
  public boolean constrained() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("interactiveViewerConstrained not supported on web");
    return intToBool(InteractiveViewerObjSt.constrained(st));
  }
  public boolean panEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("interactiveViewerPanEnabled not supported on web");
    return intToBool(InteractiveViewerObjSt.panEnabled(st));
  }
  public boolean scaleEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("interactiveViewerScaleEnabled not supported on web");
    return intToBool(InteractiveViewerObjSt.scaleEnabled(st));
  }
  public boolean trackpadScrollCausesScale() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("interactiveViewerTrackpadScrollCausesScale not supported on web");
    return intToBool(InteractiveViewerObjSt.trackpadScrollCausesScale(st));
  }
  public double scaleFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("interactiveViewerScaleFactor not supported on web");
    return InteractiveViewerObjSt.scaleFactor(st);
  }
  public double maxScale() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("interactiveViewerMaxScale not supported on web");
    return InteractiveViewerObjSt.maxScale(st);
  }
  public double minScale() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("interactiveViewerMinScale not supported on web");
    return InteractiveViewerObjSt.minScale(st);
  }
  public double interactionEndFrictionCoefficient() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("interactiveViewerInteractionEndFrictionCoefficient not supported on web");
    return InteractiveViewerObjSt.interactionEndFrictionCoefficient(st);
  }
  private static double _kDrag() {
    return 0.0000135;
  }
  @Override
  public InteractiveViewer build() {
    return this;
  }
}
