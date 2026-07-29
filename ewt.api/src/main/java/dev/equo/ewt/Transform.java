package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
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
    if (id <= 0) throw new RuntimeException("Failed to created widget Transform");
    System.out.println("New Transform id:"+id);
  }
  Transform(int id) { this.id = id; }
  @Builder.Factory
  static Transform transformRotate(@Builder.Parameter double angle, Optional<OffsetI> origin, Optional<AlignmentGeometryI> alignment, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<WidgetI> child) {
    var st = factories.transformRotate(angle,
      origin.map(OffsetI::build),
      alignment.map(AlignmentGeometryI::build),
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
  static Transform transformScale(OptionalDouble scale, OptionalDouble scaleX, OptionalDouble scaleY, Optional<OffsetI> origin, Optional<AlignmentGeometryI> alignment, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<WidgetI> child) {
    var st = factories.transformScale(scale,
      scaleX,
      scaleY,
      origin.map(OffsetI::build),
      alignment.map(AlignmentGeometryI::build),
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
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("transformOrigin", getId());
      return new Offset(__nid);
    }
    return new Offset(TransformObjSt.origin(st));
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("transformAlignment not supported on web");
    return new AlignmentGeometry(TransformObjSt.alignment(st)) {};
  }
  public boolean transformHitTests() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("transformTransformHitTests not supported on web");
    return intToBool(TransformObjSt.transformHitTests(st));
  }
  public FilterQuality filterQuality() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("transformFilterQuality not supported on web");
    return FilterQuality.values()[TransformObjSt.filterQuality(st)];
  }
  @Override
  public Transform build() {
    return this;
  }
}
