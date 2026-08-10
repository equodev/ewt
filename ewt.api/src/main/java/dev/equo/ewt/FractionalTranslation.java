package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FractionalTranslationObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class FractionalTranslation extends SingleChildRenderObjectWidget implements FractionalTranslationI {
  private MemorySegment st;
  protected FractionalTranslation() {}
  FractionalTranslation(MemorySegment st) {
    this.id = FractionalTranslationObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget FractionalTranslation");
    System.out.println("New FractionalTranslation id:"+id);
  }
  FractionalTranslation(int id) { this.id = id; }
  @Builder.Factory
  static FractionalTranslation fractionalTranslationFractionalTranslation(@Builder.Parameter OffsetI translation, Optional<Boolean> transformHitTests, Optional<WidgetI> child) {
    var st = factories.fractionalTranslationFractionalTranslation(translation.build(),
      transformHitTests,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget FractionalTranslation");
    return new FractionalTranslation(st);
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
    return new Offset(FractionalTranslationObjSt.translation(st));
  }
  public boolean transformHitTests() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("fractionalTranslationTransformHitTests not supported on web");
    return intToBool(FractionalTranslationObjSt.transformHitTests(st));
  }
  @Override
  public FractionalTranslation build() {
    return this;
  }
}
