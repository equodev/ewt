package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DefaultTabController extends StatefulWidget implements DefaultTabControllerI {
  protected DefaultTabController() {}
  DefaultTabController(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DefaultTabController");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DefaultTabController defaultTabControllerDefaultTabController(@Builder.Parameter int length, OptionalInt initialIndex, WidgetI child, Optional<DurationI> animationDuration) {
    int id = factories.defaultTabControllerDefaultTabController(length,
      initialIndex,
      child.build(),
      animationDuration.map(DurationI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget DefaultTabController");
    return new DefaultTabController(id);
  }
  public static DefaultTabControllerDefaultTabControllerBuilder defaultTabController(int length) {
    return DefaultTabControllerDefaultTabControllerBuilder.defaultTabControllerDefaultTabController(length);
  }
  public int length() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("defaultTabControllerLength not supported on web");
    return factories.DefaultTabController_readBack_length(nativeStruct);
  }
  public int initialIndex() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("defaultTabControllerInitialIndex not supported on web");
    return factories.DefaultTabController_readBack_initialIndex(nativeStruct);
  }
  public Duration animationDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("defaultTabControllerAnimationDuration", getId());
      return new Duration(__nid);
    }
    return factories.DefaultTabController_readBack_animationDuration(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("defaultTabControllerChild not supported on web");
    return factories.DefaultTabController_readBack_child(nativeStruct);
  }
  @Override
  public DefaultTabController build() {
    return this;
  }
}
