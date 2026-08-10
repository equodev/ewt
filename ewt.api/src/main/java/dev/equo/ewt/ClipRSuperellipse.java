package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ClipRSuperellipseObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ClipRSuperellipse extends SingleChildRenderObjectWidget implements ClipRSuperellipseI {
  private MemorySegment st;
  protected ClipRSuperellipse() {}
  ClipRSuperellipse(MemorySegment st) {
    this.id = ClipRSuperellipseObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ClipRSuperellipse");
    System.out.println("New ClipRSuperellipse id:"+id);
  }
  ClipRSuperellipse(int id) { this.id = id; }
  @Builder.Factory
  static ClipRSuperellipse clipRSuperellipseClipRSuperellipse(Optional<BorderRadiusGeometryI> borderRadius, Optional<Clip> clipBehavior, Optional<WidgetI> child) {
    var st = factories.clipRSuperellipseClipRSuperellipse(borderRadius.map(BorderRadiusGeometryI::build),
      clipBehavior,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget ClipRSuperellipse");
    return new ClipRSuperellipse(st);
  }
  public static ClipRSuperellipseClipRSuperellipseBuilder clipRSuperellipse() {
    return ClipRSuperellipseClipRSuperellipseBuilder.clipRSuperellipseClipRSuperellipse();
  }
  public BorderRadiusGeometry borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("clipRSuperellipseBorderRadius not supported on web");
    return new BorderRadiusGeometry(ClipRSuperellipseObjSt.borderRadius(st)) {};
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("clipRSuperellipseClipBehavior not supported on web");
    return Clip.values()[ClipRSuperellipseObjSt.clipBehavior(st)];
  }
  @Override
  public ClipRSuperellipse build() {
    return this;
  }
}
