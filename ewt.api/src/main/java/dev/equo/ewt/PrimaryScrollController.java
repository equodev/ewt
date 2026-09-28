package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class PrimaryScrollController extends InheritedWidget implements PrimaryScrollControllerI {
  protected PrimaryScrollController() {}
  PrimaryScrollController(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget PrimaryScrollController");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static PrimaryScrollController primaryScrollControllerNone(@Builder.Parameter WidgetI child) {
    int id = factories.primaryScrollControllerNone(child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget PrimaryScrollController");
    return new PrimaryScrollController(id);
  }
  public static PrimaryScrollControllerNoneBuilder none(WidgetI child) {
    return PrimaryScrollControllerNoneBuilder.primaryScrollControllerNone(child);
  }
  public static boolean shouldInherit(BuildContextI context, Axis scrollDirection) {
    var id = factories.primaryScrollControllerShouldInherit(context.build(),
      scrollDirection);
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    System.out.println("New bool id:"+id);
    return intToBool(id);
  }
  public Axis scrollDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("primaryScrollControllerScrollDirection not supported on web");
    return factories.PrimaryScrollController_readBack_scrollDirection(nativeStruct);
  }
  @Override
  public PrimaryScrollController build() {
    return this;
  }
}
