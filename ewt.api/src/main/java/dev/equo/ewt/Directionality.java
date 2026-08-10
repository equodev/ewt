package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DirectionalityObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Directionality extends _UbiquitousInheritedWidget implements DirectionalityI {
  private MemorySegment st;
  protected Directionality() {}
  Directionality(MemorySegment st) {
    this.id = DirectionalityObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Directionality");
    System.out.println("New Directionality id:"+id);
  }
  Directionality(int id) { this.id = id; }
  @Builder.Factory
  static Directionality directionalityDirectionality(@Builder.Parameter TextDirection textDirection, @Builder.Parameter WidgetI child) {
    var st = factories.directionalityDirectionality(textDirection,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget Directionality");
    return new Directionality(st);
  }
  public static DirectionalityDirectionalityBuilder directionality(TextDirection textDirection, WidgetI child) {
    return DirectionalityDirectionalityBuilder.directionalityDirectionality(textDirection, child);
  }
  public static TextDirection of(BuildContextI context) {
    int id = factories.directionalityOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget TextDirection");
    System.out.println("New TextDirection id:"+id);
    return TextDirection.values()[id];
  }
  public static TextDirection maybeOf(BuildContextI context) {
    int id = factories.directionalityMaybeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget TextDirection?");
    System.out.println("New TextDirection? id:"+id);
    return TextDirection.values()[id];
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("directionalityTextDirection not supported on web");
    return TextDirection.values()[DirectionalityObjSt.textDirection(st)];
  }
  @Override
  public Directionality build() {
    return this;
  }
}
