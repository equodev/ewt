package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ModalBarrier extends StatelessWidget implements ModalBarrierI {
  protected ModalBarrier() {}
  ModalBarrier(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ModalBarrier");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ModalBarrier modalBarrierModalBarrier(Optional<ColorI> color, Optional<Boolean> dismissible, Optional<Runnable> onDismiss, Optional<String> semanticsLabel, Optional<Boolean> barrierSemanticsDismissible, Optional<String> semanticsOnTapHint) {
    int id = factories.modalBarrierModalBarrier(color.map(ColorI::build),
      dismissible,
      onDismiss,
      semanticsLabel,
      barrierSemanticsDismissible,
      semanticsOnTapHint);
    if (id <= 0) throw new RuntimeException("Failed to created widget ModalBarrier");
    return new ModalBarrier(id);
  }
  public static ModalBarrierModalBarrierBuilder modalBarrier() {
    return ModalBarrierModalBarrierBuilder.modalBarrierModalBarrier();
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("modalBarrierColor", getId());
      return new Color(__nid);
    }
    return factories.ModalBarrier_readBack_color(nativeStruct);
  }
  public boolean dismissible() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("modalBarrierDismissible not supported on web");
    return factories.ModalBarrier_readBack_dismissible(nativeStruct);
  }
  public boolean barrierSemanticsDismissible() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("modalBarrierBarrierSemanticsDismissible not supported on web");
    return factories.ModalBarrier_readBack_barrierSemanticsDismissible(nativeStruct);
  }
  public String semanticsLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("modalBarrierSemanticsLabel not supported on web");
    return factories.ModalBarrier_readBack_semanticsLabel(nativeStruct);
  }
  public String semanticsOnTapHint() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("modalBarrierSemanticsOnTapHint not supported on web");
    return factories.ModalBarrier_readBack_semanticsOnTapHint(nativeStruct);
  }
  @Override
  public ModalBarrier build() {
    return this;
  }
}
