package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SimpleDialogObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SimpleDialog extends StatelessWidget implements SimpleDialogI {
  private MemorySegment st;
  protected SimpleDialog() {}
  SimpleDialog(MemorySegment st) {
    this.id = SimpleDialogObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SimpleDialog");
    System.out.println("New SimpleDialog id:"+id);
  }
  SimpleDialog(int id) { this.id = id; }
  @Builder.Factory
  static SimpleDialog simpleDialogSimpleDialog(Optional<WidgetI> title, Optional<EdgeInsetsGeometryI> titlePadding, Optional<TextStyleI> titleTextStyle, Optional<List<WidgetI>> children, Optional<EdgeInsetsGeometryI> contentPadding, Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<String> semanticLabel, Optional<EdgeInsetsI> insetPadding, Optional<Clip> clipBehavior, Optional<ShapeBorderI> shape, Optional<AlignmentGeometryI> alignment, Optional<BoxConstraintsI> constraints) {
    var st = factories.simpleDialogSimpleDialog(title.map(WidgetI::build),
      titlePadding.map(EdgeInsetsGeometryI::build),
      titleTextStyle.map(TextStyleI::build),
      children.map(i -> i.stream().map(WidgetI::build).toList()),
      contentPadding.map(EdgeInsetsGeometryI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget SimpleDialog");
    return new SimpleDialog(st);
  }
  public static SimpleDialogSimpleDialogBuilder simpleDialog() {
    return SimpleDialogSimpleDialogBuilder.simpleDialogSimpleDialog();
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("simpleDialogTitle not supported on web");
    return new Widget(SimpleDialogObjSt.title(st)) {};
  }
  public EdgeInsetsGeometry titlePadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("simpleDialogTitlePadding not supported on web");
    return new EdgeInsetsGeometry(SimpleDialogObjSt.titlePadding(st)) {};
  }
  public TextStyle titleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("simpleDialogTitleTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(SimpleDialogObjSt.titleTextStyle(st));
  }
  public EdgeInsetsGeometry contentPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("simpleDialogContentPadding not supported on web");
    return new EdgeInsetsGeometry(SimpleDialogObjSt.contentPadding(st)) {};
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("simpleDialogBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(SimpleDialogObjSt.backgroundColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("simpleDialogElevation not supported on web");
    return SimpleDialogObjSt.elevation(st);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("simpleDialogShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(SimpleDialogObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("simpleDialogSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(SimpleDialogObjSt.surfaceTintColor(st));
  }
  public String semanticLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("simpleDialogSemanticLabel not supported on web");
    return SimpleDialogObjSt.semanticLabel(st).getString(0);
  }
  public EdgeInsets insetPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("simpleDialogInsetPadding", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.EdgeInsetsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.EdgeInsetsObjSt.id(__st, __nid);
      return new EdgeInsets(__st);
    }
    return new EdgeInsets(SimpleDialogObjSt.insetPadding(st));
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("simpleDialogClipBehavior not supported on web");
    return Clip.values()[SimpleDialogObjSt.clipBehavior(st)];
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("simpleDialogShape not supported on web");
    return new ShapeBorder(SimpleDialogObjSt.shape(st)) {};
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("simpleDialogAlignment not supported on web");
    return new AlignmentGeometry(SimpleDialogObjSt.alignment(st)) {};
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("simpleDialogConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(SimpleDialogObjSt.constraints(st));
  }
  @Override
  public SimpleDialog build() {
    return this;
  }
}
