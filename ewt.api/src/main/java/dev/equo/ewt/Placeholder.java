package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PlaceholderObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Placeholder extends StatelessWidget implements PlaceholderI {
  private MemorySegment st;
  protected Placeholder() {}
  Placeholder(MemorySegment st) {
    this.id = PlaceholderObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Placeholder");
    System.out.println("New Placeholder id:"+id);
  }
  @Builder.Factory
  static Placeholder placeholderPlaceholder(Optional<ColorI> color, OptionalDouble strokeWidth, OptionalDouble fallbackWidth, OptionalDouble fallbackHeight, Optional<WidgetI> child) {
    var st = factories.placeholderPlaceholder(color.map(ColorI::build),
      strokeWidth,
      fallbackWidth,
      fallbackHeight,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Placeholder");
    return new Placeholder(st);
  }
  public static PlaceholderPlaceholderBuilder placeholder() {
    return PlaceholderPlaceholderBuilder.placeholderPlaceholder();
  }
  public Color color() {
    return new Color(PlaceholderObjSt.color(st));
  }
  public double strokeWidth() {
    return PlaceholderObjSt.strokeWidth(st);
  }
  public double fallbackWidth() {
    return PlaceholderObjSt.fallbackWidth(st);
  }
  public double fallbackHeight() {
    return PlaceholderObjSt.fallbackHeight(st);
  }
  public Widget child() {
    return new Widget(PlaceholderObjSt.child(st)) {};
  }
  @Override
  public Placeholder build() {
    return this;
  }
}
