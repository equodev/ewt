package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.UnconstrainedBoxObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class UnconstrainedBox extends StatelessWidget implements UnconstrainedBoxI {
  private MemorySegment st;
  protected UnconstrainedBox() {}
  UnconstrainedBox(MemorySegment st) {
    this.id = UnconstrainedBoxObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget UnconstrainedBox");
    System.out.println("New UnconstrainedBox id:"+id);
  }
  UnconstrainedBox(int id) { this.id = id; }
  @Builder.Factory
  static UnconstrainedBox unconstrainedBoxUnconstrainedBox(Optional<WidgetI> child, Optional<TextDirection> textDirection, Optional<AlignmentGeometryI> alignment, Optional<Axis> constrainedAxis, Optional<Clip> clipBehavior) {
    var st = factories.unconstrainedBoxUnconstrainedBox(child.map(WidgetI::build),
      textDirection,
      alignment.map(AlignmentGeometryI::build),
      constrainedAxis,
      clipBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget UnconstrainedBox");
    return new UnconstrainedBox(st);
  }
  public static UnconstrainedBoxUnconstrainedBoxBuilder unconstrainedBox() {
    return UnconstrainedBoxUnconstrainedBoxBuilder.unconstrainedBoxUnconstrainedBox();
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("unconstrainedBoxTextDirection not supported on web");
    return TextDirection.values()[UnconstrainedBoxObjSt.textDirection(st)];
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("unconstrainedBoxAlignment not supported on web");
    return new AlignmentGeometry(UnconstrainedBoxObjSt.alignment(st)) {};
  }
  public Axis constrainedAxis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("unconstrainedBoxConstrainedAxis not supported on web");
    return Axis.values()[UnconstrainedBoxObjSt.constrainedAxis(st)];
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("unconstrainedBoxClipBehavior not supported on web");
    return Clip.values()[UnconstrainedBoxObjSt.clipBehavior(st)];
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("unconstrainedBoxChild not supported on web");
    return new Widget(UnconstrainedBoxObjSt.child(st)) {};
  }
  @Override
  public UnconstrainedBox build() {
    return this;
  }
}
