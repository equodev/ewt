package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CompositedTransformFollowerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CompositedTransformFollower extends SingleChildRenderObjectWidget implements CompositedTransformFollowerI {
  private MemorySegment st;
  protected CompositedTransformFollower() {}
  CompositedTransformFollower(MemorySegment st) {
    this.id = CompositedTransformFollowerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CompositedTransformFollower");
    System.out.println("New CompositedTransformFollower id:"+id);
  }
  CompositedTransformFollower(int id) { this.id = id; }
  public boolean showWhenUnlinked() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("compositedTransformFollowerShowWhenUnlinked not supported on web");
    return intToBool(CompositedTransformFollowerObjSt.showWhenUnlinked(st));
  }
  public Alignment targetAnchor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("compositedTransformFollowerTargetAnchor", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.AlignmentObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.AlignmentObjSt.id(__st, __nid);
      return new Alignment(__st);
    }
    return new Alignment(CompositedTransformFollowerObjSt.targetAnchor(st));
  }
  public Alignment followerAnchor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("compositedTransformFollowerFollowerAnchor", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.AlignmentObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.AlignmentObjSt.id(__st, __nid);
      return new Alignment(__st);
    }
    return new Alignment(CompositedTransformFollowerObjSt.followerAnchor(st));
  }
  public Offset offset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("compositedTransformFollowerOffset", getId());
      return new Offset(__nid);
    }
    return new Offset(CompositedTransformFollowerObjSt.offset(st));
  }
  @Override
  public CompositedTransformFollower build() {
    return this;
  }
}
