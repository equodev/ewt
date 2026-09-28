package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class BoxConstraints extends Constraints implements BoxConstraintsI {
  protected BoxConstraints() {}
  BoxConstraints(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget BoxConstraints");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static BoxConstraints boxConstraintsBoxConstraints(OptionalDouble minWidth, OptionalDouble maxWidth, OptionalDouble minHeight, OptionalDouble maxHeight) {
    int id = factories.boxConstraintsBoxConstraints(minWidth,
      maxWidth,
      minHeight,
      maxHeight);
    if (id <= 0) throw new RuntimeException("Failed to created widget BoxConstraints");
    return new BoxConstraints(id);
  }
  public static BoxConstraintsBoxConstraintsBuilder boxConstraints() {
    return BoxConstraintsBoxConstraintsBuilder.boxConstraintsBoxConstraints();
  }
  @Builder.Factory
  static BoxConstraints boxConstraintsTightFor(OptionalDouble width, OptionalDouble height) {
    int id = factories.boxConstraintsTightFor(width,
      height);
    if (id <= 0) throw new RuntimeException("Failed to created widget BoxConstraints");
    return new BoxConstraints(id);
  }
  public static BoxConstraintsTightForBuilder tightFor() {
    return BoxConstraintsTightForBuilder.boxConstraintsTightFor();
  }
  @Builder.Factory
  static BoxConstraints boxConstraintsTightForFinite(OptionalDouble width, OptionalDouble height) {
    int id = factories.boxConstraintsTightForFinite(width,
      height);
    if (id <= 0) throw new RuntimeException("Failed to created widget BoxConstraints");
    return new BoxConstraints(id);
  }
  public static BoxConstraintsTightForFiniteBuilder tightForFinite() {
    return BoxConstraintsTightForFiniteBuilder.boxConstraintsTightForFinite();
  }
  @Builder.Factory
  static BoxConstraints boxConstraintsExpand(OptionalDouble width, OptionalDouble height) {
    int id = factories.boxConstraintsExpand(width,
      height);
    if (id <= 0) throw new RuntimeException("Failed to created widget BoxConstraints");
    return new BoxConstraints(id);
  }
  public static BoxConstraintsExpandBuilder expand() {
    return BoxConstraintsExpandBuilder.boxConstraintsExpand();
  }
  public static BoxConstraints lerp(BoxConstraintsI a, BoxConstraintsI b, double t) {
    int id = factories.boxConstraintsLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget BoxConstraints");
    return new BoxConstraints(id);
  }
  public double minWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxConstraintsMinWidth not supported on web");
    return factories.BoxConstraints_readBack_minWidth(nativeStruct);
  }
  public double maxWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxConstraintsMaxWidth not supported on web");
    return factories.BoxConstraints_readBack_maxWidth(nativeStruct);
  }
  public double minHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxConstraintsMinHeight not supported on web");
    return factories.BoxConstraints_readBack_minHeight(nativeStruct);
  }
  public double maxHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxConstraintsMaxHeight not supported on web");
    return factories.BoxConstraints_readBack_maxHeight(nativeStruct);
  }
  public boolean hasTightWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxConstraintsHasTightWidth not supported on web");
    return factories.BoxConstraints_readBack_hasTightWidth(nativeStruct);
  }
  public boolean hasTightHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxConstraintsHasTightHeight not supported on web");
    return factories.BoxConstraints_readBack_hasTightHeight(nativeStruct);
  }
  public boolean hasBoundedWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxConstraintsHasBoundedWidth not supported on web");
    return factories.BoxConstraints_readBack_hasBoundedWidth(nativeStruct);
  }
  public boolean hasBoundedHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxConstraintsHasBoundedHeight not supported on web");
    return factories.BoxConstraints_readBack_hasBoundedHeight(nativeStruct);
  }
  public boolean hasInfiniteWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxConstraintsHasInfiniteWidth not supported on web");
    return factories.BoxConstraints_readBack_hasInfiniteWidth(nativeStruct);
  }
  public boolean hasInfiniteHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxConstraintsHasInfiniteHeight not supported on web");
    return factories.BoxConstraints_readBack_hasInfiniteHeight(nativeStruct);
  }
  @Override
  public BoxConstraints build() {
    return this;
  }
}
