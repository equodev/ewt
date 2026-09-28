package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class PositionedDirectional extends StatelessWidget implements PositionedDirectionalI {
  protected PositionedDirectional() {}
  PositionedDirectional(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget PositionedDirectional");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static PositionedDirectional positionedDirectionalPositionedDirectional(OptionalDouble start, OptionalDouble top, OptionalDouble end, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, WidgetI child) {
    int id = factories.positionedDirectionalPositionedDirectional(start,
      top,
      end,
      bottom,
      width,
      height,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget PositionedDirectional");
    return new PositionedDirectional(id);
  }
  public static PositionedDirectionalPositionedDirectionalBuilder positionedDirectional() {
    return PositionedDirectionalPositionedDirectionalBuilder.positionedDirectionalPositionedDirectional();
  }
  public double start() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedDirectionalStart not supported on web");
    return factories.PositionedDirectional_readBack_start(nativeStruct);
  }
  public double top() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedDirectionalTop not supported on web");
    return factories.PositionedDirectional_readBack_top(nativeStruct);
  }
  public double end() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedDirectionalEnd not supported on web");
    return factories.PositionedDirectional_readBack_end(nativeStruct);
  }
  public double bottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedDirectionalBottom not supported on web");
    return factories.PositionedDirectional_readBack_bottom(nativeStruct);
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedDirectionalWidth not supported on web");
    return factories.PositionedDirectional_readBack_width(nativeStruct);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedDirectionalHeight not supported on web");
    return factories.PositionedDirectional_readBack_height(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedDirectionalChild not supported on web");
    return factories.PositionedDirectional_readBack_child(nativeStruct);
  }
  @Override
  public PositionedDirectional build() {
    return this;
  }
}
