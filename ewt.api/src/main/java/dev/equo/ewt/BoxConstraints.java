package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BoxConstraintsObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BoxConstraints extends Constraints implements BoxConstraintsI {
  private MemorySegment st;
  protected BoxConstraints() {}
  BoxConstraints(MemorySegment st) {
    this.id = BoxConstraintsObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget BoxConstraints");
    System.out.println("New BoxConstraints id:"+id);
  }
  BoxConstraints(int id) { this.id = id; }
  @Builder.Factory
  static BoxConstraints boxConstraintsBoxConstraints(OptionalDouble minWidth, OptionalDouble maxWidth, OptionalDouble minHeight, OptionalDouble maxHeight) {
    var st = factories.boxConstraintsBoxConstraints(minWidth,
      maxWidth,
      minHeight,
      maxHeight);
    if (st == null) throw new RuntimeException("Failed to created widget BoxConstraints");
    return new BoxConstraints(st);
  }
  public static BoxConstraintsBoxConstraintsBuilder boxConstraints() {
    return BoxConstraintsBoxConstraintsBuilder.boxConstraintsBoxConstraints();
  }
  @Builder.Factory
  static BoxConstraints boxConstraintsTightFor(OptionalDouble width, OptionalDouble height) {
    var st = factories.boxConstraintsTightFor(width,
      height);
    if (st == null) throw new RuntimeException("Failed to created widget BoxConstraints");
    return new BoxConstraints(st);
  }
  public static BoxConstraintsTightForBuilder tightFor() {
    return BoxConstraintsTightForBuilder.boxConstraintsTightFor();
  }
  @Builder.Factory
  static BoxConstraints boxConstraintsTightForFinite(OptionalDouble width, OptionalDouble height) {
    var st = factories.boxConstraintsTightForFinite(width,
      height);
    if (st == null) throw new RuntimeException("Failed to created widget BoxConstraints");
    return new BoxConstraints(st);
  }
  public static BoxConstraintsTightForFiniteBuilder tightForFinite() {
    return BoxConstraintsTightForFiniteBuilder.boxConstraintsTightForFinite();
  }
  @Builder.Factory
  static BoxConstraints boxConstraintsExpand(OptionalDouble width, OptionalDouble height) {
    var st = factories.boxConstraintsExpand(width,
      height);
    if (st == null) throw new RuntimeException("Failed to created widget BoxConstraints");
    return new BoxConstraints(st);
  }
  public static BoxConstraintsExpandBuilder expand() {
    return BoxConstraintsExpandBuilder.boxConstraintsExpand();
  }
  public static BoxConstraints lerp(BoxConstraintsI a, BoxConstraintsI b, double t) {
    var st = factories.boxConstraintsLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget BoxConstraints");
    return new BoxConstraints(st);
  }
  public double minWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxConstraintsMinWidth not supported on web");
    return BoxConstraintsObjSt.minWidth(st);
  }
  public double maxWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxConstraintsMaxWidth not supported on web");
    return BoxConstraintsObjSt.maxWidth(st);
  }
  public double minHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxConstraintsMinHeight not supported on web");
    return BoxConstraintsObjSt.minHeight(st);
  }
  public double maxHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxConstraintsMaxHeight not supported on web");
    return BoxConstraintsObjSt.maxHeight(st);
  }
  public boolean hasTightWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxConstraintsHasTightWidth not supported on web");
    return intToBool(BoxConstraintsObjSt.hasTightWidth(st));
  }
  public boolean hasTightHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxConstraintsHasTightHeight not supported on web");
    return intToBool(BoxConstraintsObjSt.hasTightHeight(st));
  }
  public boolean hasBoundedWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxConstraintsHasBoundedWidth not supported on web");
    return intToBool(BoxConstraintsObjSt.hasBoundedWidth(st));
  }
  public boolean hasBoundedHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxConstraintsHasBoundedHeight not supported on web");
    return intToBool(BoxConstraintsObjSt.hasBoundedHeight(st));
  }
  public boolean hasInfiniteWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxConstraintsHasInfiniteWidth not supported on web");
    return intToBool(BoxConstraintsObjSt.hasInfiniteWidth(st));
  }
  public boolean hasInfiniteHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxConstraintsHasInfiniteHeight not supported on web");
    return intToBool(BoxConstraintsObjSt.hasInfiniteHeight(st));
  }
  @Override
  public BoxConstraints build() {
    return this;
  }
}
