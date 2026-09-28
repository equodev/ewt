package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class FractionalTranslation extends SingleChildRenderObjectWidget implements FractionalTranslationI {
  protected FractionalTranslation() {}
  FractionalTranslation(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget FractionalTranslation");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static FractionalTranslation fractionalTranslationFractionalTranslation(@Builder.Parameter OffsetI translation, Optional<Boolean> transformHitTests, Optional<WidgetI> child) {
    int id = factories.fractionalTranslationFractionalTranslation(translation.build(),
      transformHitTests,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget FractionalTranslation");
    return new FractionalTranslation(id);
  }
  public static FractionalTranslationFractionalTranslationBuilder fractionalTranslation(OffsetI translation) {
    return FractionalTranslationFractionalTranslationBuilder.fractionalTranslationFractionalTranslation(translation);
  }
  public Offset translation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("fractionalTranslationTranslation", getId());
      return new Offset(__nid);
    }
    return factories.FractionalTranslation_readBack_translation(nativeStruct);
  }
  public boolean transformHitTests() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fractionalTranslationTransformHitTests not supported on web");
    return factories.FractionalTranslation_readBack_transformHitTests(nativeStruct);
  }
  @Override
  public FractionalTranslation build() {
    return this;
  }
}
