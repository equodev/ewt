package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CheckboxThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CheckboxThemeData extends NativeObj.Base implements CheckboxThemeDataI {
  private MemorySegment st;
  protected CheckboxThemeData() {}
  CheckboxThemeData(MemorySegment st) {
    this.id = CheckboxThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CheckboxThemeData");
    System.out.println("New CheckboxThemeData id:"+id);
  }
  CheckboxThemeData(int id) { this.id = id; }
  @Builder.Factory
  static CheckboxThemeData checkboxThemeDataCheckboxThemeData(Optional<ColorI> fillColor, Optional<ColorI> checkColor, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensityI> visualDensity, Optional<OutlinedBorderI> shape, Optional<BorderSideI> side) {
    var st = factories.checkboxThemeDataCheckboxThemeData(fillColor.map(ColorI::build),
      checkColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      splashRadius,
      materialTapTargetSize,
      visualDensity.map(VisualDensityI::build),
      shape.map(OutlinedBorderI::build),
      side.map(BorderSideI::build));
    if (st == null) throw new RuntimeException("Failed to created widget CheckboxThemeData");
    return new CheckboxThemeData(st);
  }
  public static CheckboxThemeDataCheckboxThemeDataBuilder checkboxThemeData() {
    return CheckboxThemeDataCheckboxThemeDataBuilder.checkboxThemeDataCheckboxThemeData();
  }
  public static CheckboxThemeData lerp(CheckboxThemeDataI a, CheckboxThemeDataI b, double t) {
    var st = factories.checkboxThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget CheckboxThemeData");
    return new CheckboxThemeData(st);
  }
  public double splashRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxThemeDataSplashRadius not supported on web");
    return CheckboxThemeDataObjSt.splashRadius(st);
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxThemeDataMaterialTapTargetSize not supported on web");
    return MaterialTapTargetSize.values()[CheckboxThemeDataObjSt.materialTapTargetSize(st)];
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxThemeDataVisualDensity", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.VisualDensityObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.VisualDensityObjSt.id(__st, __nid);
      return new VisualDensity(__st);
    }
    return new VisualDensity(CheckboxThemeDataObjSt.visualDensity(st));
  }
  public OutlinedBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxThemeDataShape not supported on web");
    return new OutlinedBorder(CheckboxThemeDataObjSt.shape(st)) {};
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxThemeDataSide", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderSideObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderSideObjSt.id(__st, __nid);
      return new BorderSide(__st);
    }
    return new BorderSide(CheckboxThemeDataObjSt.side(st));
  }
  @Override
  public CheckboxThemeData build() {
    return this;
  }
}
