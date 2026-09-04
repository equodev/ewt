package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SwitchThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SwitchThemeData extends NativeObj.Base implements SwitchThemeDataI {
  private MemorySegment st;
  protected SwitchThemeData() {}
  SwitchThemeData(MemorySegment st) {
    this.id = SwitchThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SwitchThemeData");
    System.out.println("New SwitchThemeData id:"+id);
  }
  SwitchThemeData(int id) { this.id = id; }
  @Builder.Factory
  static SwitchThemeData switchThemeDataSwitchThemeData(Optional<ColorI> thumbColor, Optional<ColorI> trackColor, Optional<ColorI> trackOutlineColor, OptionalDouble trackOutlineWidth, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<IconI> thumbIcon, Optional<EdgeInsetsGeometryI> padding) {
    var st = factories.switchThemeDataSwitchThemeData(thumbColor.map(ColorI::build),
      trackColor.map(ColorI::build),
      trackOutlineColor.map(ColorI::build),
      trackOutlineWidth,
      materialTapTargetSize,
      overlayColor.map(ColorI::build),
      splashRadius,
      thumbIcon.map(IconI::build),
      padding.map(EdgeInsetsGeometryI::build));
    if (st == null) throw new RuntimeException("Failed to created widget SwitchThemeData");
    return new SwitchThemeData(st);
  }
  public static SwitchThemeDataSwitchThemeDataBuilder switchThemeData() {
    return SwitchThemeDataSwitchThemeDataBuilder.switchThemeDataSwitchThemeData();
  }
  public static SwitchThemeData lerp(SwitchThemeDataI a, SwitchThemeDataI b, double t) {
    var st = factories.switchThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget SwitchThemeData");
    return new SwitchThemeData(st);
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchThemeDataMaterialTapTargetSize not supported on web");
    return MaterialTapTargetSize.values()[SwitchThemeDataObjSt.materialTapTargetSize(st)];
  }
  public double splashRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchThemeDataSplashRadius not supported on web");
    return SwitchThemeDataObjSt.splashRadius(st);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchThemeDataPadding not supported on web");
    return new EdgeInsetsGeometry(SwitchThemeDataObjSt.padding(st)) {};
  }
  @Override
  public SwitchThemeData build() {
    return this;
  }
}
