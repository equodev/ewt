package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class RawMagnifier extends StatelessWidget implements RawMagnifierI {
  protected RawMagnifier() {}
  RawMagnifier(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget RawMagnifier");
    this.nativeStruct = factories.takeLastStruct();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMagnifierChild not supported on web");
    return factories.RawMagnifier_readBack_child(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMagnifierClipBehavior not supported on web");
    return factories.RawMagnifier_readBack_clipBehavior(nativeStruct);
  }
  public Offset focalPointOffset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawMagnifierFocalPointOffset", getId());
      return new Offset(__nid);
    }
    return factories.RawMagnifier_readBack_focalPointOffset(nativeStruct);
  }
  public double magnificationScale() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMagnifierMagnificationScale not supported on web");
    return factories.RawMagnifier_readBack_magnificationScale(nativeStruct);
  }
  @Override
  public RawMagnifier build() {
    return this;
  }
}
