package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoPickerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoPicker extends StatefulWidget implements CupertinoPickerI {
  private MemorySegment st;
  protected CupertinoPicker() {}
  CupertinoPicker(MemorySegment st) {
    this.id = CupertinoPickerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoPicker");
    System.out.println("New CupertinoPicker id:"+id);
  }
  CupertinoPicker(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoPicker cupertinoPickerCupertinoPicker(OptionalDouble diameterRatio, Optional<ColorI> backgroundColor, OptionalDouble offAxisFraction, Optional<Boolean> useMagnifier, OptionalDouble magnification, OptionalDouble squeeze, Optional<ChangeReportingBehavior> changeReportingBehavior, double itemExtent, Consumer<Integer> onSelectedItemChanged, List<WidgetI> children, Optional<WidgetI> selectionOverlay, Optional<Boolean> looping) {
    var st = factories.cupertinoPickerCupertinoPicker(diameterRatio,
      backgroundColor.map(ColorI::build),
      offAxisFraction,
      useMagnifier,
      magnification,
      squeeze,
      changeReportingBehavior,
      itemExtent,
      onSelectedItemChanged,
      children.stream().map(WidgetI::build).toList(),
      selectionOverlay.map(WidgetI::build),
      looping);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoPicker");
    return new CupertinoPicker(st);
  }
  public static CupertinoPickerCupertinoPickerBuilder cupertinoPicker() {
    return CupertinoPickerCupertinoPickerBuilder.cupertinoPickerCupertinoPicker();
  }
  @Builder.Factory
  static CupertinoPicker cupertinoPickerBuilder(OptionalDouble diameterRatio, Optional<ColorI> backgroundColor, OptionalDouble offAxisFraction, Optional<Boolean> useMagnifier, OptionalDouble magnification, OptionalDouble squeeze, Optional<ChangeReportingBehavior> changeReportingBehavior, double itemExtent, Consumer<Integer> onSelectedItemChanged, BiFunction<BuildContext, Integer, Widget> itemBuilder, OptionalInt childCount, Optional<WidgetI> selectionOverlay) {
    var st = factories.cupertinoPickerBuilder(diameterRatio,
      backgroundColor.map(ColorI::build),
      offAxisFraction,
      useMagnifier,
      magnification,
      squeeze,
      changeReportingBehavior,
      itemExtent,
      onSelectedItemChanged,
      itemBuilder,
      childCount,
      selectionOverlay.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoPicker");
    return new CupertinoPicker(st);
  }
  public static CupertinoPickerBuilderBuilder builder() {
    return CupertinoPickerBuilderBuilder.cupertinoPickerBuilder();
  }
  public double diameterRatio() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoPickerDiameterRatio not supported on web");
    return CupertinoPickerObjSt.diameterRatio(st);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoPickerBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoPickerObjSt.backgroundColor(st));
  }
  public double offAxisFraction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoPickerOffAxisFraction not supported on web");
    return CupertinoPickerObjSt.offAxisFraction(st);
  }
  public boolean useMagnifier() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoPickerUseMagnifier not supported on web");
    return intToBool(CupertinoPickerObjSt.useMagnifier(st));
  }
  public double magnification() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoPickerMagnification not supported on web");
    return CupertinoPickerObjSt.magnification(st);
  }
  public double itemExtent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoPickerItemExtent not supported on web");
    return CupertinoPickerObjSt.itemExtent(st);
  }
  public double squeeze() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoPickerSqueeze not supported on web");
    return CupertinoPickerObjSt.squeeze(st);
  }
  public ChangeReportingBehavior changeReportingBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoPickerChangeReportingBehavior not supported on web");
    return ChangeReportingBehavior.values()[CupertinoPickerObjSt.changeReportingBehavior(st)];
  }
  public Widget selectionOverlay() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoPickerSelectionOverlay not supported on web");
    return new Widget(CupertinoPickerObjSt.selectionOverlay(st)) {};
  }
  @Override
  public CupertinoPicker build() {
    return this;
  }
}
