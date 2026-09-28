package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ListWheelScrollView extends StatefulWidget implements ListWheelScrollViewI {
  protected ListWheelScrollView() {}
  ListWheelScrollView(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ListWheelScrollView");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ListWheelScrollView listWheelScrollViewListWheelScrollView(OptionalDouble diameterRatio, OptionalDouble perspective, OptionalDouble offAxisFraction, Optional<Boolean> useMagnifier, OptionalDouble magnification, OptionalDouble overAndUnderCenterOpacity, double itemExtent, OptionalDouble squeeze, Optional<Consumer<Integer>> onSelectedItemChanged, Optional<Boolean> renderChildrenOutsideViewport, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior, Optional<String> restorationId, Optional<DragStartBehavior> dragStartBehavior, Optional<ChangeReportingBehavior> changeReportingBehavior, List<WidgetI> children) {
    int id = factories.listWheelScrollViewListWheelScrollView(diameterRatio,
      perspective,
      offAxisFraction,
      useMagnifier,
      magnification,
      overAndUnderCenterOpacity,
      itemExtent,
      squeeze,
      onSelectedItemChanged,
      renderChildrenOutsideViewport,
      clipBehavior,
      hitTestBehavior,
      restorationId,
      dragStartBehavior,
      changeReportingBehavior,
      children.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()));
    if (id <= 0) throw new RuntimeException("Failed to created widget ListWheelScrollView");
    return new ListWheelScrollView(id);
  }
  public static ListWheelScrollViewListWheelScrollViewBuilder listWheelScrollView() {
    return ListWheelScrollViewListWheelScrollViewBuilder.listWheelScrollViewListWheelScrollView();
  }
  public double diameterRatio() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewDiameterRatio not supported on web");
    return factories.ListWheelScrollView_readBack_diameterRatio(nativeStruct);
  }
  public double perspective() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewPerspective not supported on web");
    return factories.ListWheelScrollView_readBack_perspective(nativeStruct);
  }
  public double offAxisFraction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewOffAxisFraction not supported on web");
    return factories.ListWheelScrollView_readBack_offAxisFraction(nativeStruct);
  }
  public boolean useMagnifier() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewUseMagnifier not supported on web");
    return factories.ListWheelScrollView_readBack_useMagnifier(nativeStruct);
  }
  public double magnification() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewMagnification not supported on web");
    return factories.ListWheelScrollView_readBack_magnification(nativeStruct);
  }
  public double overAndUnderCenterOpacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewOverAndUnderCenterOpacity not supported on web");
    return factories.ListWheelScrollView_readBack_overAndUnderCenterOpacity(nativeStruct);
  }
  public double itemExtent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewItemExtent not supported on web");
    return factories.ListWheelScrollView_readBack_itemExtent(nativeStruct);
  }
  public double squeeze() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewSqueeze not supported on web");
    return factories.ListWheelScrollView_readBack_squeeze(nativeStruct);
  }
  public boolean renderChildrenOutsideViewport() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewRenderChildrenOutsideViewport not supported on web");
    return factories.ListWheelScrollView_readBack_renderChildrenOutsideViewport(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewClipBehavior not supported on web");
    return factories.ListWheelScrollView_readBack_clipBehavior(nativeStruct);
  }
  public HitTestBehavior hitTestBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewHitTestBehavior not supported on web");
    return factories.ListWheelScrollView_readBack_hitTestBehavior(nativeStruct);
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewRestorationId not supported on web");
    return factories.ListWheelScrollView_readBack_restorationId(nativeStruct);
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewDragStartBehavior not supported on web");
    return factories.ListWheelScrollView_readBack_dragStartBehavior(nativeStruct);
  }
  public ChangeReportingBehavior changeReportingBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewChangeReportingBehavior not supported on web");
    return factories.ListWheelScrollView_readBack_changeReportingBehavior(nativeStruct);
  }
  @Override
  public ListWheelScrollView build() {
    return this;
  }
}
