package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ContainerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Container extends StatelessWidget implements ContainerI {
  private MemorySegment st;
  protected Container() {}
  Container(MemorySegment st) {
    this.id = ContainerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Container");
    System.out.println("New Container id:"+id);
  }
  @Builder.Factory
  static Container containerContainer(Optional<AlignmentGeometryI> alignment, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> color, Optional<DecorationI> decoration, Optional<DecorationI> foregroundDecoration, OptionalDouble width, OptionalDouble height, Optional<BoxConstraintsI> constraints, Optional<EdgeInsetsGeometryI> margin, Optional<AlignmentGeometryI> transformAlignment, Optional<WidgetI> child, Optional<Clip> clipBehavior) {
    var st = factories.containerContainer(alignment.map(AlignmentGeometryI::build),
      padding.map(EdgeInsetsGeometryI::build),
      color.map(ColorI::build),
      decoration.map(DecorationI::build),
      foregroundDecoration.map(DecorationI::build),
      width,
      height,
      constraints.map(BoxConstraintsI::build),
      margin.map(EdgeInsetsGeometryI::build),
      transformAlignment.map(AlignmentGeometryI::build),
      child.map(WidgetI::build),
      clipBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget Container");
    return new Container(st);
  }
  public static ContainerContainerBuilder container() {
    return ContainerContainerBuilder.containerContainer();
  }
  public Widget child() {
    return new Widget(ContainerObjSt.child(st)) {};
  }
  public AlignmentGeometry alignment() {
    return new AlignmentGeometry(ContainerObjSt.alignment(st)) {};
  }
  public EdgeInsetsGeometry padding() {
    return new EdgeInsetsGeometry(ContainerObjSt.padding(st)) {};
  }
  public Color color() {
    return new Color(ContainerObjSt.color(st));
  }
  public Decoration decoration() {
    return new Decoration(ContainerObjSt.decoration(st)) {};
  }
  public Decoration foregroundDecoration() {
    return new Decoration(ContainerObjSt.foregroundDecoration(st)) {};
  }
  public BoxConstraints constraints() {
    return new BoxConstraints(ContainerObjSt.constraints(st));
  }
  public EdgeInsetsGeometry margin() {
    return new EdgeInsetsGeometry(ContainerObjSt.margin(st)) {};
  }
  public AlignmentGeometry transformAlignment() {
    return new AlignmentGeometry(ContainerObjSt.transformAlignment(st)) {};
  }
  public Clip clipBehavior() {
    return Clip.values()[ContainerObjSt.clipBehavior(st)];
  }
  @Override
  public Container build() {
    return this;
  }
}
