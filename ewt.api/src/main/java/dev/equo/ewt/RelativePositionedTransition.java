package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RelativePositionedTransitionObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class RelativePositionedTransition extends AnimatedWidget implements RelativePositionedTransitionI {
  private MemorySegment st;
  protected RelativePositionedTransition() {}
  RelativePositionedTransition(MemorySegment st) {
    this.id = RelativePositionedTransitionObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget RelativePositionedTransition");
    System.out.println("New RelativePositionedTransition id:"+id);
  }
  RelativePositionedTransition(int id) { this.id = id; }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("relativePositionedTransitionChild not supported on web");
    return new Widget(RelativePositionedTransitionObjSt.child(st)) {};
  }
  public Animation rect() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("relativePositionedTransitionRect not supported on web");
    return new Animation() { public int getId() { return RelativePositionedTransitionObjSt.rect(st); } };
  }
  @Override
  public RelativePositionedTransition build() {
    return this;
  }
}
