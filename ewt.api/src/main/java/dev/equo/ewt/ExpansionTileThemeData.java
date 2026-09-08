package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ExpansionTileThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ExpansionTileThemeData extends NativeObj.Base implements ExpansionTileThemeDataI {
  private MemorySegment st;
  protected ExpansionTileThemeData() {}
  ExpansionTileThemeData(MemorySegment st) {
    this.id = ExpansionTileThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ExpansionTileThemeData");
    System.out.println("New ExpansionTileThemeData id:"+id);
  }
  ExpansionTileThemeData(int id) { this.id = id; }
  @Builder.Factory
  static ExpansionTileThemeData expansionTileThemeDataExpansionTileThemeData(Optional<ColorI> backgroundColor, Optional<ColorI> collapsedBackgroundColor, Optional<EdgeInsetsGeometryI> tilePadding, Optional<AlignmentGeometryI> expandedAlignment, Optional<EdgeInsetsGeometryI> childrenPadding, Optional<ColorI> iconColor, Optional<ColorI> collapsedIconColor, Optional<ColorI> textColor, Optional<ColorI> collapsedTextColor, Optional<ShapeBorderI> shape, Optional<ShapeBorderI> collapsedShape, Optional<Clip> clipBehavior) {
    var st = factories.expansionTileThemeDataExpansionTileThemeData(backgroundColor.map(ColorI::build),
      collapsedBackgroundColor.map(ColorI::build),
      tilePadding.map(EdgeInsetsGeometryI::build),
      expandedAlignment.map(AlignmentGeometryI::build),
      childrenPadding.map(EdgeInsetsGeometryI::build),
      iconColor.map(ColorI::build),
      collapsedIconColor.map(ColorI::build),
      textColor.map(ColorI::build),
      collapsedTextColor.map(ColorI::build),
      shape.map(ShapeBorderI::build),
      collapsedShape.map(ShapeBorderI::build),
      clipBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget ExpansionTileThemeData");
    return new ExpansionTileThemeData(st);
  }
  public static ExpansionTileThemeDataExpansionTileThemeDataBuilder expansionTileThemeData() {
    return ExpansionTileThemeDataExpansionTileThemeDataBuilder.expansionTileThemeDataExpansionTileThemeData();
  }
  public static ExpansionTileThemeData lerp(ExpansionTileThemeDataI a, ExpansionTileThemeDataI b, double t) {
    var st = factories.expansionTileThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget ExpansionTileThemeData");
    return new ExpansionTileThemeData(st);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(ExpansionTileThemeDataObjSt.backgroundColor(st));
  }
  public Color collapsedBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileThemeDataCollapsedBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(ExpansionTileThemeDataObjSt.collapsedBackgroundColor(st));
  }
  public EdgeInsetsGeometry tilePadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileThemeDataTilePadding not supported on web");
    return new EdgeInsetsGeometry(ExpansionTileThemeDataObjSt.tilePadding(st)) {};
  }
  public AlignmentGeometry expandedAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileThemeDataExpandedAlignment not supported on web");
    return new AlignmentGeometry(ExpansionTileThemeDataObjSt.expandedAlignment(st)) {};
  }
  public EdgeInsetsGeometry childrenPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileThemeDataChildrenPadding not supported on web");
    return new EdgeInsetsGeometry(ExpansionTileThemeDataObjSt.childrenPadding(st)) {};
  }
  public Color iconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileThemeDataIconColor", getId());
      return new Color(__nid);
    }
    return new Color(ExpansionTileThemeDataObjSt.iconColor(st));
  }
  public Color collapsedIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileThemeDataCollapsedIconColor", getId());
      return new Color(__nid);
    }
    return new Color(ExpansionTileThemeDataObjSt.collapsedIconColor(st));
  }
  public Color textColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileThemeDataTextColor", getId());
      return new Color(__nid);
    }
    return new Color(ExpansionTileThemeDataObjSt.textColor(st));
  }
  public Color collapsedTextColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileThemeDataCollapsedTextColor", getId());
      return new Color(__nid);
    }
    return new Color(ExpansionTileThemeDataObjSt.collapsedTextColor(st));
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileThemeDataShape not supported on web");
    return new ShapeBorder(ExpansionTileThemeDataObjSt.shape(st)) {};
  }
  public ShapeBorder collapsedShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileThemeDataCollapsedShape not supported on web");
    return new ShapeBorder(ExpansionTileThemeDataObjSt.collapsedShape(st)) {};
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileThemeDataClipBehavior not supported on web");
    return Clip.values()[ExpansionTileThemeDataObjSt.clipBehavior(st)];
  }
  @Override
  public ExpansionTileThemeData build() {
    return this;
  }
}
