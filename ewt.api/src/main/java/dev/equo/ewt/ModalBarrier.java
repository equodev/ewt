package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ModalBarrierObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ModalBarrier extends StatelessWidget implements ModalBarrierI {
  private MemorySegment st;
  protected ModalBarrier() {}
  ModalBarrier(MemorySegment st) {
    this.id = ModalBarrierObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ModalBarrier");
    System.out.println("New ModalBarrier id:"+id);
  }
  ModalBarrier(int id) { this.id = id; }
  @Builder.Factory
  static ModalBarrier modalBarrierModalBarrier(Optional<ColorI> color, Optional<Boolean> dismissible, Optional<Runnable> onDismiss, Optional<String> semanticsLabel, Optional<Boolean> barrierSemanticsDismissible, Optional<String> semanticsOnTapHint) {
    var st = factories.modalBarrierModalBarrier(color.map(ColorI::build),
      dismissible,
      onDismiss,
      semanticsLabel,
      barrierSemanticsDismissible,
      semanticsOnTapHint);
    if (st == null) throw new RuntimeException("Failed to created widget ModalBarrier");
    return new ModalBarrier(st);
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
    return new Color(ModalBarrierObjSt.color(st));
  }
  public boolean dismissible() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("modalBarrierDismissible not supported on web");
    return intToBool(ModalBarrierObjSt.dismissible(st));
  }
  public boolean barrierSemanticsDismissible() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("modalBarrierBarrierSemanticsDismissible not supported on web");
    return intToBool(ModalBarrierObjSt.barrierSemanticsDismissible(st));
  }
  public String semanticsLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("modalBarrierSemanticsLabel not supported on web");
    return ModalBarrierObjSt.semanticsLabel(st).getString(0);
  }
  public String semanticsOnTapHint() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("modalBarrierSemanticsOnTapHint not supported on web");
    return ModalBarrierObjSt.semanticsOnTapHint(st).getString(0);
  }
  @Override
  public ModalBarrier build() {
    return this;
  }
}
