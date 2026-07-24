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
  static InteractiveViewer interactiveViewerInteractiveViewer(Optional<Clip> clipBehavior, Optional<PanAxis> panAxis, Optional<EdgeInsetsI> boundaryMargin, Optional<Boolean> constrained, OptionalDouble maxScale, OptionalDouble minScale, OptionalDouble interactionEndFrictionCoefficient, Optional<Boolean> panEnabled, Optional<Boolean> scaleEnabled, OptionalDouble scaleFactor, Optional<AlignmentI> alignment, Optional<Boolean> trackpadScrollCausesScale, WidgetI child) {
    var st = factories.interactiveViewerInteractiveViewer(clipBehavior,
      panAxis,
      boundaryMargin.map(EdgeInsetsI::build),
      constrained,
      maxScale,
      minScale,
      interactionEndFrictionCoefficient,
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
    return new Alignment(InteractiveViewerObjSt.alignment(st));
  }
  public Clip clipBehavior() {
    return Clip.values()[InteractiveViewerObjSt.clipBehavior(st)];
  }
  public PanAxis panAxis() {
    return PanAxis.values()[InteractiveViewerObjSt.panAxis(st)];
  }
  public EdgeInsets boundaryMargin() {
    return new EdgeInsets(InteractiveViewerObjSt.boundaryMargin(st));
  }
  public Widget child() {
    return new Widget(InteractiveViewerObjSt.child(st)) {};
  }
  public boolean constrained() {
    return intToBool(InteractiveViewerObjSt.constrained(st));
  }
  public boolean panEnabled() {
    return intToBool(InteractiveViewerObjSt.panEnabled(st));
  }
  public boolean scaleEnabled() {
    return intToBool(InteractiveViewerObjSt.scaleEnabled(st));
  }
  public boolean trackpadScrollCausesScale() {
    return intToBool(InteractiveViewerObjSt.trackpadScrollCausesScale(st));
  }
  public double scaleFactor() {
    return InteractiveViewerObjSt.scaleFactor(st);
  }
  public double maxScale() {
    return InteractiveViewerObjSt.maxScale(st);
  }
  public double minScale() {
    return InteractiveViewerObjSt.minScale(st);
  }
  public double interactionEndFrictionCoefficient() {
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
