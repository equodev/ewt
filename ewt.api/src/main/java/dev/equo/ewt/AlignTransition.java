package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AlignTransitionObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AlignTransition extends AnimatedWidget implements AlignTransitionI {
  private MemorySegment st;
  protected AlignTransition() {}
  AlignTransition(MemorySegment st) {
    this.id = AlignTransitionObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AlignTransition");
    System.out.println("New AlignTransition id:"+id);
  }
  AlignTransition(int id) { this.id = id; }
  @Builder.Factory
  static AlignTransition alignTransitionAlignTransition(@Builder.Parameter AnimationI alignment, @Builder.Parameter WidgetI child, OptionalDouble widthFactor, OptionalDouble heightFactor) {
    var st = factories.alignTransitionAlignTransition(alignment.build(),
      child.build(),
      widthFactor,
      heightFactor);
    if (st == null) throw new RuntimeException("Failed to created widget AlignTransition");
    return new AlignTransition(st);
  }
  public static AlignTransitionAlignTransitionBuilder alignTransition(AnimationI alignment, WidgetI child) {
    return AlignTransitionAlignTransitionBuilder.alignTransitionAlignTransition(alignment, child);
  }
  public double widthFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alignTransitionWidthFactor not supported on web");
    return AlignTransitionObjSt.widthFactor(st);
  }
  public double heightFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alignTransitionHeightFactor not supported on web");
    return AlignTransitionObjSt.heightFactor(st);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alignTransitionChild not supported on web");
    return new Widget(AlignTransitionObjSt.child(st)) {};
  }
  public Animation alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alignTransitionAlignment not supported on web");
    return new Animation() { public int getId() { return AlignTransitionObjSt.alignment(st); } };
  }
  @Override
  public AlignTransition build() {
    return this;
  }
}
