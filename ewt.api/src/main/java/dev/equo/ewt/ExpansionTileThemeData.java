package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ExpansionTileThemeData extends NativeObj.Base implements ExpansionTileThemeDataI {
  protected ExpansionTileThemeData() {}
  ExpansionTileThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ExpansionTileThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ExpansionTileThemeData expansionTileThemeDataExpansionTileThemeData(Optional<ColorI> backgroundColor, Optional<ColorI> collapsedBackgroundColor, Optional<EdgeInsetsGeometryI> tilePadding, Optional<AlignmentGeometryI> expandedAlignment, Optional<EdgeInsetsGeometryI> childrenPadding, Optional<ColorI> iconColor, Optional<ColorI> collapsedIconColor, Optional<ColorI> textColor, Optional<ColorI> collapsedTextColor, Optional<ShapeBorderI> shape, Optional<ShapeBorderI> collapsedShape, Optional<Clip> clipBehavior) {
    int id = factories.expansionTileThemeDataExpansionTileThemeData(backgroundColor.map(ColorI::build),
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
    if (id <= 0) throw new RuntimeException("Failed to created widget ExpansionTileThemeData");
    return new ExpansionTileThemeData(id);
  }
  public static ExpansionTileThemeDataExpansionTileThemeDataBuilder expansionTileThemeData() {
    return ExpansionTileThemeDataExpansionTileThemeDataBuilder.expansionTileThemeDataExpansionTileThemeData();
  }
  public static ExpansionTileThemeData lerp(ExpansionTileThemeDataI a, ExpansionTileThemeDataI b, double t) {
    int id = factories.expansionTileThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget ExpansionTileThemeData");
    return new ExpansionTileThemeData(id);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.ExpansionTileThemeData_readBack_backgroundColor(nativeStruct);
  }
  public Color collapsedBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileThemeDataCollapsedBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.ExpansionTileThemeData_readBack_collapsedBackgroundColor(nativeStruct);
  }
  public EdgeInsetsGeometry tilePadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileThemeDataTilePadding not supported on web");
    return factories.ExpansionTileThemeData_readBack_tilePadding(nativeStruct);
  }
  public AlignmentGeometry expandedAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileThemeDataExpandedAlignment not supported on web");
    return factories.ExpansionTileThemeData_readBack_expandedAlignment(nativeStruct);
  }
  public EdgeInsetsGeometry childrenPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileThemeDataChildrenPadding not supported on web");
    return factories.ExpansionTileThemeData_readBack_childrenPadding(nativeStruct);
  }
  public Color iconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileThemeDataIconColor", getId());
      return new Color(__nid);
    }
    return factories.ExpansionTileThemeData_readBack_iconColor(nativeStruct);
  }
  public Color collapsedIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileThemeDataCollapsedIconColor", getId());
      return new Color(__nid);
    }
    return factories.ExpansionTileThemeData_readBack_collapsedIconColor(nativeStruct);
  }
  public Color textColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileThemeDataTextColor", getId());
      return new Color(__nid);
    }
    return factories.ExpansionTileThemeData_readBack_textColor(nativeStruct);
  }
  public Color collapsedTextColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileThemeDataCollapsedTextColor", getId());
      return new Color(__nid);
    }
    return factories.ExpansionTileThemeData_readBack_collapsedTextColor(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileThemeDataShape not supported on web");
    return factories.ExpansionTileThemeData_readBack_shape(nativeStruct);
  }
  public ShapeBorder collapsedShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileThemeDataCollapsedShape not supported on web");
    return factories.ExpansionTileThemeData_readBack_collapsedShape(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileThemeDataClipBehavior not supported on web");
    return factories.ExpansionTileThemeData_readBack_clipBehavior(nativeStruct);
  }
  @Override
  public ExpansionTileThemeData build() {
    return this;
  }
}
