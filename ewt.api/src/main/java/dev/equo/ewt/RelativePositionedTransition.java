package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class RelativePositionedTransition extends AnimatedWidget implements RelativePositionedTransitionI {
  protected RelativePositionedTransition() {}
  RelativePositionedTransition(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget RelativePositionedTransition");
    this.nativeStruct = factories.takeLastStruct();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("relativePositionedTransitionChild not supported on web");
    return factories.RelativePositionedTransition_readBack_child(nativeStruct);
  }
  public Animation rect() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("relativePositionedTransitionRect not supported on web");
    return factories.RelativePositionedTransition_readBack_rect(nativeStruct);
  }
  @Override
  public RelativePositionedTransition build() {
    return this;
  }
}
