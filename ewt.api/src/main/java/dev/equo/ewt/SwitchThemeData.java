package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SwitchThemeData extends NativeObj.Base implements SwitchThemeDataI {
  protected SwitchThemeData() {}
  SwitchThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SwitchThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SwitchThemeData switchThemeDataSwitchThemeData(Optional<ColorI> thumbColor, Optional<ColorI> trackColor, Optional<ColorI> trackOutlineColor, OptionalDouble trackOutlineWidth, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<IconI> thumbIcon, Optional<EdgeInsetsGeometryI> padding) {
    int id = factories.switchThemeDataSwitchThemeData(thumbColor.map(ColorI::build),
      trackColor.map(ColorI::build),
      trackOutlineColor.map(ColorI::build),
      trackOutlineWidth,
      materialTapTargetSize,
      overlayColor.map(ColorI::build),
      splashRadius,
      thumbIcon.map(IconI::build),
      padding.map(EdgeInsetsGeometryI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SwitchThemeData");
    return new SwitchThemeData(id);
  }
  public static SwitchThemeDataSwitchThemeDataBuilder switchThemeData() {
    return SwitchThemeDataSwitchThemeDataBuilder.switchThemeDataSwitchThemeData();
  }
  public static SwitchThemeData lerp(SwitchThemeDataI a, SwitchThemeDataI b, double t) {
    int id = factories.switchThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget SwitchThemeData");
    return new SwitchThemeData(id);
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchThemeDataMaterialTapTargetSize not supported on web");
    return factories.SwitchThemeData_readBack_materialTapTargetSize(nativeStruct);
  }
  public double splashRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchThemeDataSplashRadius not supported on web");
    return factories.SwitchThemeData_readBack_splashRadius(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchThemeDataPadding not supported on web");
    return factories.SwitchThemeData_readBack_padding(nativeStruct);
  }
  @Override
  public SwitchThemeData build() {
    return this;
  }
}
