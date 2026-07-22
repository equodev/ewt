package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DrawerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Drawer extends StatelessWidget implements DrawerI {
  private MemorySegment st;
  protected Drawer() {}
  Drawer(MemorySegment st) {
    this.id = DrawerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Drawer");
    System.out.println("New Drawer id:"+id);
  }
  @Builder.Factory
  static Drawer drawerDrawer(Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ShapeBorderI> shape, OptionalDouble width, Optional<WidgetI> child, Optional<String> semanticLabel, Optional<Clip> clipBehavior) {
    var st = factories.drawerDrawer(backgroundColor.map(ColorI::build),
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      shape.map(ShapeBorderI::build),
      width,
      child.map(WidgetI::build),
      semanticLabel,
      clipBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget Drawer");
    return new Drawer(st);
  }
  public static DrawerDrawerBuilder drawer() {
    return DrawerDrawerBuilder.drawerDrawer();
  }
  public Color backgroundColor() {
    return new Color(DrawerObjSt.backgroundColor(st));
  }
  public double elevation() {
    return DrawerObjSt.elevation(st);
  }
  public Color shadowColor() {
    return new Color(DrawerObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    return new Color(DrawerObjSt.surfaceTintColor(st));
  }
  public ShapeBorder shape() {
    return new ShapeBorder(DrawerObjSt.shape(st)) {};
  }
  public double width() {
    return DrawerObjSt.width(st);
  }
  public Widget child() {
    return new Widget(DrawerObjSt.child(st)) {};
  }
  public String semanticLabel() {
    return DrawerObjSt.semanticLabel(st).getString(0);
  }
  public Clip clipBehavior() {
    return Clip.values()[DrawerObjSt.clipBehavior(st)];
  }
  @Override
  public Drawer build() {
    return this;
  }
}
