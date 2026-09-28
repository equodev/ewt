package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CompositedTransformFollower extends SingleChildRenderObjectWidget implements CompositedTransformFollowerI {
  protected CompositedTransformFollower() {}
  CompositedTransformFollower(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CompositedTransformFollower");
    this.nativeStruct = factories.takeLastStruct();
  }
  public boolean showWhenUnlinked() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("compositedTransformFollowerShowWhenUnlinked not supported on web");
    return factories.CompositedTransformFollower_readBack_showWhenUnlinked(nativeStruct);
  }
  public Alignment targetAnchor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("compositedTransformFollowerTargetAnchor", getId());
      return new Alignment(__nid);
    }
    return factories.CompositedTransformFollower_readBack_targetAnchor(nativeStruct);
  }
  public Alignment followerAnchor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("compositedTransformFollowerFollowerAnchor", getId());
      return new Alignment(__nid);
    }
    return factories.CompositedTransformFollower_readBack_followerAnchor(nativeStruct);
  }
  public Offset offset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("compositedTransformFollowerOffset", getId());
      return new Offset(__nid);
    }
    return factories.CompositedTransformFollower_readBack_offset(nativeStruct);
  }
  @Override
  public CompositedTransformFollower build() {
    return this;
  }
}
