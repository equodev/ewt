package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.InkObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Ink extends StatefulWidget implements InkI {
  private MemorySegment st;
  protected Ink() {}
  Ink(MemorySegment st) {
    this.id = InkObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Ink");
    System.out.println("New Ink id:"+id);
  }
  Ink(int id) { this.id = id; }
  @Builder.Factory
  static Ink inkInk(Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> color, Optional<DecorationI> decoration, OptionalDouble width, OptionalDouble height, Optional<WidgetI> child) {
    var st = factories.inkInk(padding.map(EdgeInsetsGeometryI::build),
      color.map(ColorI::build),
      decoration.map(DecorationI::build),
      width,
      height,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Ink");
    return new Ink(st);
  }
  public static InkInkBuilder ink() {
    return InkInkBuilder.inkInk();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkChild not supported on web");
    return new Widget(InkObjSt.child(st)) {};
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkPadding not supported on web");
    return new EdgeInsetsGeometry(InkObjSt.padding(st)) {};
  }
  public Decoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkDecoration not supported on web");
    return new Decoration(InkObjSt.decoration(st)) {};
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkWidth not supported on web");
    return InkObjSt.width(st);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inkHeight not supported on web");
    return InkObjSt.height(st);
  }
  @Override
  public Ink build() {
    return this;
  }
}
