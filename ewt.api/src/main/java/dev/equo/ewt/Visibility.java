package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.VisibilityObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Visibility extends StatelessWidget implements VisibilityI {
  private MemorySegment st;
  protected Visibility() {}
  Visibility(MemorySegment st) {
    this.id = VisibilityObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Visibility");
    System.out.println("New Visibility id:"+id);
  }
  @Builder.Factory
  static Visibility visibilityVisibility(@Builder.Parameter WidgetI child, Optional<WidgetI> replacement, Optional<Boolean> visible, Optional<Boolean> maintainState, Optional<Boolean> maintainAnimation, Optional<Boolean> maintainSize, Optional<Boolean> maintainSemantics, Optional<Boolean> maintainInteractivity, Optional<Boolean> maintainFocusability) {
    var st = factories.visibilityVisibility(child.build(),
      replacement.map(WidgetI::build),
      visible,
      maintainState,
      maintainAnimation,
      maintainSize,
      maintainSemantics,
      maintainInteractivity,
      maintainFocusability);
    if (st == null) throw new RuntimeException("Failed to created widget Visibility");
    return new Visibility(st);
  }
  public static VisibilityVisibilityBuilder visibility(WidgetI child) {
    return VisibilityVisibilityBuilder.visibilityVisibility(child);
  }
  @Builder.Factory
  static Visibility visibilityMaintain(@Builder.Parameter WidgetI child, Optional<Boolean> visible) {
    var st = factories.visibilityMaintain(child.build(),
      visible);
    if (st == null) throw new RuntimeException("Failed to created widget Visibility");
    return new Visibility(st);
  }
  public static VisibilityMaintainBuilder maintain(WidgetI child) {
    return VisibilityMaintainBuilder.visibilityMaintain(child);
  }
  public static boolean of(BuildContextI context) {
    int id = factories.visibilityOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    System.out.println("New bool id:"+id);
    return intToBool(id);
  }
  public Widget child() {
    return new Widget(VisibilityObjSt.child(st)) {};
  }
  public Widget replacement() {
    return new Widget(VisibilityObjSt.replacement(st)) {};
  }
  public boolean visible() {
    return intToBool(VisibilityObjSt.visible(st));
  }
  public boolean maintainState() {
    return intToBool(VisibilityObjSt.maintainState(st));
  }
  public boolean maintainAnimation() {
    return intToBool(VisibilityObjSt.maintainAnimation(st));
  }
  public boolean maintainSize() {
    return intToBool(VisibilityObjSt.maintainSize(st));
  }
  public boolean maintainSemantics() {
    return intToBool(VisibilityObjSt.maintainSemantics(st));
  }
  public boolean maintainInteractivity() {
    return intToBool(VisibilityObjSt.maintainInteractivity(st));
  }
  public boolean maintainFocusability() {
    return intToBool(VisibilityObjSt.maintainFocusability(st));
  }
  @Override
  public Visibility build() {
    return this;
  }
}
