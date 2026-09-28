package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class RadioThemeData extends NativeObj.Base implements RadioThemeDataI {
  protected RadioThemeData() {}
  RadioThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget RadioThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static RadioThemeData radioThemeDataRadioThemeData(Optional<ColorI> fillColor, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensityI> visualDensity, Optional<ColorI> backgroundColor, Optional<BorderSideI> side, OptionalDouble innerRadius) {
    int id = factories.radioThemeDataRadioThemeData(fillColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      splashRadius,
      materialTapTargetSize,
      visualDensity.map(VisualDensityI::build),
      backgroundColor.map(ColorI::build),
      side.map(BorderSideI::build),
      innerRadius);
    if (id <= 0) throw new RuntimeException("Failed to created widget RadioThemeData");
    return new RadioThemeData(id);
  }
  public static RadioThemeDataRadioThemeDataBuilder radioThemeData() {
    return RadioThemeDataRadioThemeDataBuilder.radioThemeDataRadioThemeData();
  }
  public static RadioThemeData lerp(RadioThemeDataI a, RadioThemeDataI b, double t) {
    int id = factories.radioThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget RadioThemeData");
    return new RadioThemeData(id);
  }
  public double splashRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioThemeDataSplashRadius not supported on web");
    return factories.RadioThemeData_readBack_splashRadius(nativeStruct);
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioThemeDataMaterialTapTargetSize not supported on web");
    return factories.RadioThemeData_readBack_materialTapTargetSize(nativeStruct);
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioThemeDataVisualDensity", getId());
      return new VisualDensity(__nid);
    }
    return factories.RadioThemeData_readBack_visualDensity(nativeStruct);
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioThemeDataSide", getId());
      return new BorderSide(__nid);
    }
    return factories.RadioThemeData_readBack_side(nativeStruct);
  }
  @Override
  public RadioThemeData build() {
    return this;
  }
}
