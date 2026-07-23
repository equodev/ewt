package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AnimatedSizeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AnimatedSize extends StatefulWidget implements AnimatedSizeI {
  private MemorySegment st;
  protected AnimatedSize() {}
  AnimatedSize(MemorySegment st) {
    this.id = AnimatedSizeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedSize");
    System.out.println("New AnimatedSize id:"+id);
  }
  @Builder.Factory
  static AnimatedSize animatedSizeAnimatedSize(Optional<WidgetI> child, Optional<AlignmentGeometryI> alignment, Optional<CurveI> curve, DurationI duration, Optional<DurationI> reverseDuration, Optional<Clip> clipBehavior, Optional<Runnable> onEnd) {
    var st = factories.animatedSizeAnimatedSize(child.map(WidgetI::build),
      alignment.map(AlignmentGeometryI::build),
      curve.map(CurveI::build),
      duration.build(),
      reverseDuration.map(DurationI::build),
      clipBehavior,
      onEnd);
    if (st == null) throw new RuntimeException("Failed to created widget AnimatedSize");
    return new AnimatedSize(st);
  }
  public static AnimatedSizeAnimatedSizeBuilder animatedSize() {
    return AnimatedSizeAnimatedSizeBuilder.animatedSizeAnimatedSize();
  }
  public Widget child() {
    return new Widget(AnimatedSizeObjSt.child(st)) {};
  }
  public AlignmentGeometry alignment() {
    return new AlignmentGeometry(AnimatedSizeObjSt.alignment(st)) {};
  }
  public Curve curve() {
    return new Curve(AnimatedSizeObjSt.curve(st)) {};
  }
  public Duration duration() {
    return new Duration(AnimatedSizeObjSt.duration(st));
  }
  public Duration reverseDuration() {
    return new Duration(AnimatedSizeObjSt.reverseDuration(st));
  }
  public Clip clipBehavior() {
    return Clip.values()[AnimatedSizeObjSt.clipBehavior(st)];
  }
  @Override
  public AnimatedSize build() {
    return this;
  }
}
