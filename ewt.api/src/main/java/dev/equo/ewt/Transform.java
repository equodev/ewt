package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Transform extends SingleChildRenderObjectWidget implements TransformI {
  protected Transform() {}
  Transform(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Transform");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Transform transformRotate(@Builder.Parameter double angle, Optional<OffsetI> origin, Optional<AlignmentGeometryI> alignment, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<WidgetI> child) {
    int id = factories.transformRotate(angle,
      origin.map(OffsetI::build),
      alignment.map(AlignmentGeometryI::build),
      transformHitTests,
      filterQuality,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Transform");
    return new Transform(id);
  }
  public static TransformRotateBuilder rotate(double angle) {
    return TransformRotateBuilder.transformRotate(angle);
  }
  @Builder.Factory
  static Transform transformTranslate(@Builder.Parameter OffsetI offset, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<WidgetI> child) {
    int id = factories.transformTranslate(offset.build(),
      transformHitTests,
      filterQuality,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Transform");
    return new Transform(id);
  }
  public static TransformTranslateBuilder translate(OffsetI offset) {
    return TransformTranslateBuilder.transformTranslate(offset);
  }
  @Builder.Factory
  static Transform transformScale(OptionalDouble scale, OptionalDouble scaleX, OptionalDouble scaleY, Optional<OffsetI> origin, Optional<AlignmentGeometryI> alignment, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<WidgetI> child) {
    int id = factories.transformScale(scale,
      scaleX,
      scaleY,
      origin.map(OffsetI::build),
      alignment.map(AlignmentGeometryI::build),
      transformHitTests,
      filterQuality,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Transform");
    return new Transform(id);
  }
  public static TransformScaleBuilder scale() {
    return TransformScaleBuilder.transformScale();
  }
  @Builder.Factory
  static Transform transformFlip(Optional<Boolean> flipX, Optional<Boolean> flipY, Optional<OffsetI> origin, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<WidgetI> child) {
    int id = factories.transformFlip(flipX,
      flipY,
      origin.map(OffsetI::build),
      transformHitTests,
      filterQuality,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Transform");
    return new Transform(id);
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
    return factories.Transform_readBack_origin(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("transformAlignment not supported on web");
    return factories.Transform_readBack_alignment(nativeStruct);
  }
  public boolean transformHitTests() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("transformTransformHitTests not supported on web");
    return factories.Transform_readBack_transformHitTests(nativeStruct);
  }
  public FilterQuality filterQuality() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("transformFilterQuality not supported on web");
    return factories.Transform_readBack_filterQuality(nativeStruct);
  }
  @Override
  public Transform build() {
    return this;
  }
}
