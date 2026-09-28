package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Container extends StatelessWidget implements ContainerI {
  protected Container() {}
  Container(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Container");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Container containerContainer(Optional<AlignmentGeometryI> alignment, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> color, Optional<Boolean> isAntiAlias, Optional<DecorationI> decoration, Optional<DecorationI> foregroundDecoration, OptionalDouble width, OptionalDouble height, Optional<BoxConstraintsI> constraints, Optional<EdgeInsetsGeometryI> margin, Optional<AlignmentGeometryI> transformAlignment, Optional<WidgetI> child, Optional<Clip> clipBehavior) {
    int id = factories.containerContainer(alignment.map(AlignmentGeometryI::build),
      padding.map(EdgeInsetsGeometryI::build),
      color.map(ColorI::build),
      isAntiAlias,
      decoration.map(DecorationI::build),
      foregroundDecoration.map(DecorationI::build),
      width,
      height,
      constraints.map(BoxConstraintsI::build),
      margin.map(EdgeInsetsGeometryI::build),
      transformAlignment.map(AlignmentGeometryI::build),
      child.map(WidgetI::build),
      clipBehavior);
    if (id <= 0) throw new RuntimeException("Failed to created widget Container");
    return new Container(id);
  }
  public static ContainerContainerBuilder container() {
    return ContainerContainerBuilder.containerContainer();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("containerChild not supported on web");
    return factories.Container_readBack_child(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("containerAlignment not supported on web");
    return factories.Container_readBack_alignment(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("containerPadding not supported on web");
    return factories.Container_readBack_padding(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("containerColor", getId());
      return new Color(__nid);
    }
    return factories.Container_readBack_color(nativeStruct);
  }
  public boolean isAntiAlias() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("containerIsAntiAlias not supported on web");
    return factories.Container_readBack_isAntiAlias(nativeStruct);
  }
  public Decoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("containerDecoration not supported on web");
    return factories.Container_readBack_decoration(nativeStruct);
  }
  public Decoration foregroundDecoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("containerForegroundDecoration not supported on web");
    return factories.Container_readBack_foregroundDecoration(nativeStruct);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("containerConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.Container_readBack_constraints(nativeStruct);
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("containerMargin not supported on web");
    return factories.Container_readBack_margin(nativeStruct);
  }
  public AlignmentGeometry transformAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("containerTransformAlignment not supported on web");
    return factories.Container_readBack_transformAlignment(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("containerClipBehavior not supported on web");
    return factories.Container_readBack_clipBehavior(nativeStruct);
  }
  @Override
  public Container build() {
    return this;
  }
}
