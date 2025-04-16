package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TransformObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Transform extends SingleChildRenderObjectWidget implements TransformI {
  private MemorySegment st;
  protected Transform() {}
  Transform(MemorySegment st) {
    this.id = TransformObjSt.id(st);
    this.st = st;
    System.out.println("New Transform id:"+id);
  }
  @Builder.Factory
  static Transform transformRotate(@Builder.Parameter double angle, Optional<OffsetI> origin, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<WidgetI> child) {
    var st = factories.transformRotate(angle,
      origin.map(OffsetI::build),
      transformHitTests,
      filterQuality,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Transform");
    return new Transform(st);
  }
  public static TransformRotateBuilder rotate(double angle) {
    return TransformRotateBuilder.transformRotate(angle);
  }
  @Builder.Factory
  static Transform transformTranslate(@Builder.Parameter OffsetI offset, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<WidgetI> child) {
    var st = factories.transformTranslate(offset.build(),
      transformHitTests,
      filterQuality,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Transform");
    return new Transform(st);
  }
  public static TransformTranslateBuilder translate(OffsetI offset) {
    return TransformTranslateBuilder.transformTranslate(offset);
  }
  @Builder.Factory
  static Transform transformScale(OptionalDouble scale, OptionalDouble scaleX, OptionalDouble scaleY, Optional<OffsetI> origin, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<WidgetI> child) {
    var st = factories.transformScale(scale,
      scaleX,
      scaleY,
      origin.map(OffsetI::build),
      transformHitTests,
      filterQuality,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Transform");
    return new Transform(st);
  }
  public static TransformScaleBuilder scale() {
    return TransformScaleBuilder.transformScale();
  }
  @Builder.Factory
  static Transform transformFlip(Optional<Boolean> flipX, Optional<Boolean> flipY, Optional<OffsetI> origin, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<WidgetI> child) {
    var st = factories.transformFlip(flipX,
      flipY,
      origin.map(OffsetI::build),
      transformHitTests,
      filterQuality,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Transform");
    return new Transform(st);
  }
  public static TransformFlipBuilder flip() {
    return TransformFlipBuilder.transformFlip();
  }
  public Offset origin() {
    return new Offset(TransformObjSt.origin(st));
  }
  public boolean transformHitTests() {
    return intToBool(TransformObjSt.transformHitTests(st));
  }
  public FilterQuality filterQuality() {
    return FilterQuality.values()[TransformObjSt.filterQuality(st)];
  }
  @Override
  public Transform build() {
    return this;
  }
}
