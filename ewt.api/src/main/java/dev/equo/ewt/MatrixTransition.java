package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class MatrixTransition extends AnimatedWidget implements MatrixTransitionI {
  protected MatrixTransition() {}
  MatrixTransition(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget MatrixTransition");
    this.nativeStruct = factories.takeLastStruct();
  }
  public Alignment alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("matrixTransitionAlignment", getId());
      return new Alignment(__nid);
    }
    return factories.MatrixTransition_readBack_alignment(nativeStruct);
  }
  public FilterQuality filterQuality() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("matrixTransitionFilterQuality not supported on web");
    return factories.MatrixTransition_readBack_filterQuality(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("matrixTransitionChild not supported on web");
    return factories.MatrixTransition_readBack_child(nativeStruct);
  }
  public Animation animation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("matrixTransitionAnimation not supported on web");
    return factories.MatrixTransition_readBack_animation(nativeStruct);
  }
  @Override
  public MatrixTransition build() {
    return this;
  }
}
