package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Visibility extends StatelessWidget implements VisibilityI {
  protected Visibility() {}
  Visibility(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Visibility");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Visibility visibilityVisibility(@Builder.Parameter WidgetI child, Optional<WidgetI> replacement, Optional<Boolean> visible, Optional<Boolean> maintainState, Optional<Boolean> maintainAnimation, Optional<Boolean> maintainSize, Optional<Boolean> maintainSemantics, Optional<Boolean> maintainInteractivity, Optional<Boolean> maintainFocusability) {
    int id = factories.visibilityVisibility(child.build(),
      replacement.map(WidgetI::build),
      visible,
      maintainState,
      maintainAnimation,
      maintainSize,
      maintainSemantics,
      maintainInteractivity,
      maintainFocusability);
    if (id <= 0) throw new RuntimeException("Failed to created widget Visibility");
    return new Visibility(id);
  }
  public static VisibilityVisibilityBuilder visibility(WidgetI child) {
    return VisibilityVisibilityBuilder.visibilityVisibility(child);
  }
  @Builder.Factory
  static Visibility visibilityMaintain(@Builder.Parameter WidgetI child, Optional<Boolean> visible) {
    int id = factories.visibilityMaintain(child.build(),
      visible);
    if (id <= 0) throw new RuntimeException("Failed to created widget Visibility");
    return new Visibility(id);
  }
  public static VisibilityMaintainBuilder maintain(WidgetI child) {
    return VisibilityMaintainBuilder.visibilityMaintain(child);
  }
  public static boolean of(BuildContextI context) {
    var id = factories.visibilityOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    System.out.println("New bool id:"+id);
    return intToBool(id);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("visibilityChild not supported on web");
    return factories.Visibility_readBack_child(nativeStruct);
  }
  public Widget replacement() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("visibilityReplacement not supported on web");
    return factories.Visibility_readBack_replacement(nativeStruct);
  }
  public boolean visible() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("visibilityVisible not supported on web");
    return factories.Visibility_readBack_visible(nativeStruct);
  }
  public boolean maintainState() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("visibilityMaintainState not supported on web");
    return factories.Visibility_readBack_maintainState(nativeStruct);
  }
  public boolean maintainAnimation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("visibilityMaintainAnimation not supported on web");
    return factories.Visibility_readBack_maintainAnimation(nativeStruct);
  }
  public boolean maintainSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("visibilityMaintainSize not supported on web");
    return factories.Visibility_readBack_maintainSize(nativeStruct);
  }
  public boolean maintainSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("visibilityMaintainSemantics not supported on web");
    return factories.Visibility_readBack_maintainSemantics(nativeStruct);
  }
  public boolean maintainInteractivity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("visibilityMaintainInteractivity not supported on web");
    return factories.Visibility_readBack_maintainInteractivity(nativeStruct);
  }
  public boolean maintainFocusability() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("visibilityMaintainFocusability not supported on web");
    return factories.Visibility_readBack_maintainFocusability(nativeStruct);
  }
  @Override
  public Visibility build() {
    return this;
  }
}
