package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class InteractiveViewer extends StatefulWidget implements InteractiveViewerI {
  protected InteractiveViewer() {}
  InteractiveViewer(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget InteractiveViewer");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static InteractiveViewer interactiveViewerInteractiveViewer(Optional<Clip> clipBehavior, Optional<PanAxis> panAxis, Optional<EdgeInsetsI> boundaryMargin, Optional<Boolean> constrained, OptionalDouble maxScale, OptionalDouble minScale, OptionalDouble interactionEndFrictionCoefficient, Optional<Consumer<ScaleEndDetails>> onInteractionEnd, Optional<Consumer<ScaleStartDetails>> onInteractionStart, Optional<Consumer<ScaleUpdateDetails>> onInteractionUpdate, Optional<Boolean> panEnabled, Optional<Boolean> scaleEnabled, OptionalDouble scaleFactor, Optional<AlignmentI> alignment, Optional<Boolean> trackpadScrollCausesScale, WidgetI child) {
    int id = factories.interactiveViewerInteractiveViewer(clipBehavior,
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
    if (id <= 0) throw new RuntimeException("Failed to created widget InteractiveViewer");
    return new InteractiveViewer(id);
  }
  public static InteractiveViewerInteractiveViewerBuilder interactiveViewer() {
    return InteractiveViewerInteractiveViewerBuilder.interactiveViewerInteractiveViewer();
  }
  public Alignment alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("interactiveViewerAlignment", getId());
      return new Alignment(__nid);
    }
    return factories.InteractiveViewer_readBack_alignment(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("interactiveViewerClipBehavior not supported on web");
    return factories.InteractiveViewer_readBack_clipBehavior(nativeStruct);
  }
  public PanAxis panAxis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("interactiveViewerPanAxis not supported on web");
    return factories.InteractiveViewer_readBack_panAxis(nativeStruct);
  }
  public EdgeInsets boundaryMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("interactiveViewerBoundaryMargin", getId());
      return new EdgeInsets(__nid);
    }
    return factories.InteractiveViewer_readBack_boundaryMargin(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("interactiveViewerChild not supported on web");
    return factories.InteractiveViewer_readBack_child(nativeStruct);
  }
  public boolean constrained() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("interactiveViewerConstrained not supported on web");
    return factories.InteractiveViewer_readBack_constrained(nativeStruct);
  }
  public boolean panEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("interactiveViewerPanEnabled not supported on web");
    return factories.InteractiveViewer_readBack_panEnabled(nativeStruct);
  }
  public boolean scaleEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("interactiveViewerScaleEnabled not supported on web");
    return factories.InteractiveViewer_readBack_scaleEnabled(nativeStruct);
  }
  public boolean trackpadScrollCausesScale() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("interactiveViewerTrackpadScrollCausesScale not supported on web");
    return factories.InteractiveViewer_readBack_trackpadScrollCausesScale(nativeStruct);
  }
  public double scaleFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("interactiveViewerScaleFactor not supported on web");
    return factories.InteractiveViewer_readBack_scaleFactor(nativeStruct);
  }
  public double maxScale() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("interactiveViewerMaxScale not supported on web");
    return factories.InteractiveViewer_readBack_maxScale(nativeStruct);
  }
  public double minScale() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("interactiveViewerMinScale not supported on web");
    return factories.InteractiveViewer_readBack_minScale(nativeStruct);
  }
  public double interactionEndFrictionCoefficient() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("interactiveViewerInteractionEndFrictionCoefficient not supported on web");
    return factories.InteractiveViewer_readBack_interactionEndFrictionCoefficient(nativeStruct);
  }
  private static double _kDrag() {
    return 0.0000135;
  }
  @Override
  public InteractiveViewer build() {
    return this;
  }
}
