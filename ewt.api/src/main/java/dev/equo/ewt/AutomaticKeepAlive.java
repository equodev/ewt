package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AutomaticKeepAlive extends StatefulWidget implements AutomaticKeepAliveI {
  protected AutomaticKeepAlive() {}
  AutomaticKeepAlive(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AutomaticKeepAlive");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AutomaticKeepAlive automaticKeepAliveAutomaticKeepAlive(@Builder.Parameter WidgetI child) {
    int id = factories.automaticKeepAliveAutomaticKeepAlive(child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget AutomaticKeepAlive");
    return new AutomaticKeepAlive(id);
  }
  public static AutomaticKeepAliveAutomaticKeepAliveBuilder automaticKeepAlive(WidgetI child) {
    return AutomaticKeepAliveAutomaticKeepAliveBuilder.automaticKeepAliveAutomaticKeepAlive(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("automaticKeepAliveChild not supported on web");
    return factories.AutomaticKeepAlive_readBack_child(nativeStruct);
  }
  @Override
  public AutomaticKeepAlive build() {
    return this;
  }
}
