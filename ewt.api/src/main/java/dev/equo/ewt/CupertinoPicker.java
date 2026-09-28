package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoPicker extends StatefulWidget implements CupertinoPickerI {
  protected CupertinoPicker() {}
  CupertinoPicker(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoPicker");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoPicker cupertinoPickerCupertinoPicker(OptionalDouble diameterRatio, Optional<ColorI> backgroundColor, OptionalDouble offAxisFraction, Optional<Boolean> useMagnifier, OptionalDouble magnification, OptionalDouble squeeze, Optional<ChangeReportingBehavior> changeReportingBehavior, double itemExtent, Optional<Consumer<Integer>> onSelectedItemChanged, List<WidgetI> children, Optional<WidgetI> selectionOverlay, Optional<Boolean> looping) {
    int id = factories.cupertinoPickerCupertinoPicker(diameterRatio,
      backgroundColor.map(ColorI::build),
      offAxisFraction,
      useMagnifier,
      magnification,
      squeeze,
      changeReportingBehavior,
      itemExtent,
      onSelectedItemChanged,
      children.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()),
      selectionOverlay.map(WidgetI::build),
      looping);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoPicker");
    return new CupertinoPicker(id);
  }
  public static CupertinoPickerCupertinoPickerBuilder cupertinoPicker() {
    return CupertinoPickerCupertinoPickerBuilder.cupertinoPickerCupertinoPicker();
  }
  @Builder.Factory
  static CupertinoPicker cupertinoPickerBuilder(OptionalDouble diameterRatio, Optional<ColorI> backgroundColor, OptionalDouble offAxisFraction, Optional<Boolean> useMagnifier, OptionalDouble magnification, OptionalDouble squeeze, Optional<ChangeReportingBehavior> changeReportingBehavior, double itemExtent, Optional<Consumer<Integer>> onSelectedItemChanged, BiFunction<BuildContext, Integer, Widget> itemBuilder, OptionalInt childCount, Optional<WidgetI> selectionOverlay) {
    int id = factories.cupertinoPickerBuilder(diameterRatio,
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
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoPicker");
    return new CupertinoPicker(id);
  }
  public static CupertinoPickerBuilderBuilder builder() {
    return CupertinoPickerBuilderBuilder.cupertinoPickerBuilder();
  }
  public double diameterRatio() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoPickerDiameterRatio not supported on web");
    return factories.CupertinoPicker_readBack_diameterRatio(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoPickerBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoPicker_readBack_backgroundColor(nativeStruct);
  }
  public double offAxisFraction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoPickerOffAxisFraction not supported on web");
    return factories.CupertinoPicker_readBack_offAxisFraction(nativeStruct);
  }
  public boolean useMagnifier() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoPickerUseMagnifier not supported on web");
    return factories.CupertinoPicker_readBack_useMagnifier(nativeStruct);
  }
  public double magnification() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoPickerMagnification not supported on web");
    return factories.CupertinoPicker_readBack_magnification(nativeStruct);
  }
  public double itemExtent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoPickerItemExtent not supported on web");
    return factories.CupertinoPicker_readBack_itemExtent(nativeStruct);
  }
  public double squeeze() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoPickerSqueeze not supported on web");
    return factories.CupertinoPicker_readBack_squeeze(nativeStruct);
  }
  public ChangeReportingBehavior changeReportingBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoPickerChangeReportingBehavior not supported on web");
    return factories.CupertinoPicker_readBack_changeReportingBehavior(nativeStruct);
  }
  public Widget selectionOverlay() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoPickerSelectionOverlay not supported on web");
    return factories.CupertinoPicker_readBack_selectionOverlay(nativeStruct);
  }
  @Override
  public CupertinoPicker build() {
    return this;
  }
}
