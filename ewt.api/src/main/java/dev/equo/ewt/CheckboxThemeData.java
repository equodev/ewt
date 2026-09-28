package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CheckboxThemeData extends NativeObj.Base implements CheckboxThemeDataI {
  protected CheckboxThemeData() {}
  CheckboxThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CheckboxThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CheckboxThemeData checkboxThemeDataCheckboxThemeData(Optional<ColorI> fillColor, Optional<ColorI> checkColor, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensityI> visualDensity, Optional<OutlinedBorderI> shape, Optional<BorderSideI> side) {
    int id = factories.checkboxThemeDataCheckboxThemeData(fillColor.map(ColorI::build),
      checkColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      splashRadius,
      materialTapTargetSize,
      visualDensity.map(VisualDensityI::build),
      shape.map(OutlinedBorderI::build),
      side.map(BorderSideI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget CheckboxThemeData");
    return new CheckboxThemeData(id);
  }
  public static CheckboxThemeDataCheckboxThemeDataBuilder checkboxThemeData() {
    return CheckboxThemeDataCheckboxThemeDataBuilder.checkboxThemeDataCheckboxThemeData();
  }
  public static CheckboxThemeData lerp(CheckboxThemeDataI a, CheckboxThemeDataI b, double t) {
    int id = factories.checkboxThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget CheckboxThemeData");
    return new CheckboxThemeData(id);
  }
  public double splashRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxThemeDataSplashRadius not supported on web");
    return factories.CheckboxThemeData_readBack_splashRadius(nativeStruct);
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxThemeDataMaterialTapTargetSize not supported on web");
    return factories.CheckboxThemeData_readBack_materialTapTargetSize(nativeStruct);
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxThemeDataVisualDensity", getId());
      return new VisualDensity(__nid);
    }
    return factories.CheckboxThemeData_readBack_visualDensity(nativeStruct);
  }
  public OutlinedBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxThemeDataShape not supported on web");
    return factories.CheckboxThemeData_readBack_shape(nativeStruct);
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxThemeDataSide", getId());
      return new BorderSide(__nid);
    }
    return factories.CheckboxThemeData_readBack_side(nativeStruct);
  }
  @Override
  public CheckboxThemeData build() {
    return this;
  }
}
