package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DividerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Divider extends StatelessWidget implements DividerI {
  private MemorySegment st;
  protected Divider() {}
  Divider(MemorySegment st) {
    this.id = DividerObjSt.id(st);
    this.st = st;
    System.out.println("New Divider id:"+id);
  }
  @Builder.Factory
  static Divider dividerDivider(OptionalDouble height, OptionalDouble thickness, OptionalDouble indent, OptionalDouble endIndent, Optional<ColorI> color) {
    var st = factories.dividerDivider(height,
      thickness,
      indent,
      endIndent,
      color.map(ColorI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Divider");
    return new Divider(st);
  }
  public static DividerDividerBuilder divider() {
    return DividerDividerBuilder.dividerDivider();
  }
  public static BorderSide createBorderSide(BuildContextI context) {
    var st = factories.dividerCreateBorderSide(context.build(),
      Optional.empty(),
      OptionalDouble.empty());
    if (st == null) throw new RuntimeException("Failed to created widget BorderSide");
    return new BorderSide(st);
  }
  public double height() {
    return DividerObjSt.height(st);
  }
  public double thickness() {
    return DividerObjSt.thickness(st);
  }
  public double indent() {
    return DividerObjSt.indent(st);
  }
  public double endIndent() {
    return DividerObjSt.endIndent(st);
  }
  public Color color() {
    return new Color(DividerObjSt.color(st));
  }
  @Override
  public Divider build() {
    return this;
  }
}
