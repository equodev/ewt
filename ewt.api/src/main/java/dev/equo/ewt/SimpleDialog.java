package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SimpleDialog extends StatelessWidget implements SimpleDialogI {
  protected SimpleDialog() {}
  SimpleDialog(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SimpleDialog");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SimpleDialog simpleDialogSimpleDialog(Optional<WidgetI> title, Optional<EdgeInsetsGeometryI> titlePadding, Optional<TextStyleI> titleTextStyle, Optional<List<WidgetI>> children, Optional<EdgeInsetsGeometryI> contentPadding, Optional<TextStyleI> contentTextStyle, Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<String> semanticLabel, Optional<EdgeInsetsI> insetPadding, Optional<Clip> clipBehavior, Optional<ShapeBorderI> shape, Optional<AlignmentGeometryI> alignment, Optional<BoxConstraintsI> constraints) {
    int id = factories.simpleDialogSimpleDialog(title.map(WidgetI::build),
      titlePadding.map(EdgeInsetsGeometryI::build),
      titleTextStyle.map(TextStyleI::build),
      children.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())),
      contentPadding.map(EdgeInsetsGeometryI::build),
      contentTextStyle.map(TextStyleI::build),
      backgroundColor.map(ColorI::build),
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      semanticLabel,
      insetPadding.map(EdgeInsetsI::build),
      clipBehavior,
      shape.map(ShapeBorderI::build),
      alignment.map(AlignmentGeometryI::build),
      constraints.map(BoxConstraintsI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SimpleDialog");
    return new SimpleDialog(id);
  }
  public static SimpleDialogSimpleDialogBuilder simpleDialog() {
    return SimpleDialogSimpleDialogBuilder.simpleDialogSimpleDialog();
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("simpleDialogTitle not supported on web");
    return factories.SimpleDialog_readBack_title(nativeStruct);
  }
  public EdgeInsetsGeometry titlePadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("simpleDialogTitlePadding not supported on web");
    return factories.SimpleDialog_readBack_titlePadding(nativeStruct);
  }
  public TextStyle titleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("simpleDialogTitleTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.SimpleDialog_readBack_titleTextStyle(nativeStruct);
  }
  public EdgeInsetsGeometry contentPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("simpleDialogContentPadding not supported on web");
    return factories.SimpleDialog_readBack_contentPadding(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("simpleDialogBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.SimpleDialog_readBack_backgroundColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("simpleDialogElevation not supported on web");
    return factories.SimpleDialog_readBack_elevation(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("simpleDialogShadowColor", getId());
      return new Color(__nid);
    }
    return factories.SimpleDialog_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("simpleDialogSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.SimpleDialog_readBack_surfaceTintColor(nativeStruct);
  }
  public TextStyle contentTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("simpleDialogContentTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.SimpleDialog_readBack_contentTextStyle(nativeStruct);
  }
  public String semanticLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("simpleDialogSemanticLabel not supported on web");
    return factories.SimpleDialog_readBack_semanticLabel(nativeStruct);
  }
  public EdgeInsets insetPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("simpleDialogInsetPadding", getId());
      return new EdgeInsets(__nid);
    }
    return factories.SimpleDialog_readBack_insetPadding(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("simpleDialogClipBehavior not supported on web");
    return factories.SimpleDialog_readBack_clipBehavior(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("simpleDialogShape not supported on web");
    return factories.SimpleDialog_readBack_shape(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("simpleDialogAlignment not supported on web");
    return factories.SimpleDialog_readBack_alignment(nativeStruct);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("simpleDialogConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.SimpleDialog_readBack_constraints(nativeStruct);
  }
  @Override
  public SimpleDialog build() {
    return this;
  }
}
