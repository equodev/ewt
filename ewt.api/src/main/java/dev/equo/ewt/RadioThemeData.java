package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RadioThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class RadioThemeData extends NativeObj.Base implements RadioThemeDataI {
  private MemorySegment st;
  protected RadioThemeData() {}
  RadioThemeData(MemorySegment st) {
    this.id = RadioThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget RadioThemeData");
    System.out.println("New RadioThemeData id:"+id);
  }
  RadioThemeData(int id) { this.id = id; }
  @Builder.Factory
  static RadioThemeData radioThemeDataRadioThemeData(Optional<ColorI> fillColor, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensityI> visualDensity, Optional<ColorI> backgroundColor) {
    var st = factories.radioThemeDataRadioThemeData(fillColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      splashRadius,
      materialTapTargetSize,
      visualDensity.map(VisualDensityI::build),
      backgroundColor.map(ColorI::build));
    if (st == null) throw new RuntimeException("Failed to created widget RadioThemeData");
    return new RadioThemeData(st);
  }
  public static RadioThemeDataRadioThemeDataBuilder radioThemeData() {
    return RadioThemeDataRadioThemeDataBuilder.radioThemeDataRadioThemeData();
  }
  public static RadioThemeData lerp(RadioThemeDataI a, RadioThemeDataI b, double t) {
    var st = factories.radioThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget RadioThemeData");
    return new RadioThemeData(st);
  }
  public double splashRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioThemeDataSplashRadius not supported on web");
    return RadioThemeDataObjSt.splashRadius(st);
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioThemeDataMaterialTapTargetSize not supported on web");
    return MaterialTapTargetSize.values()[RadioThemeDataObjSt.materialTapTargetSize(st)];
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioThemeDataVisualDensity", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.VisualDensityObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.VisualDensityObjSt.id(__st, __nid);
      return new VisualDensity(__st);
    }
    return new VisualDensity(RadioThemeDataObjSt.visualDensity(st));
  }
  @Override
  public RadioThemeData build() {
    return this;
  }
}
