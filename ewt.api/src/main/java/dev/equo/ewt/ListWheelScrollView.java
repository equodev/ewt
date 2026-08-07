package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ListWheelScrollViewObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ListWheelScrollView extends StatefulWidget implements ListWheelScrollViewI {
  private MemorySegment st;
  protected ListWheelScrollView() {}
  ListWheelScrollView(MemorySegment st) {
    this.id = ListWheelScrollViewObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ListWheelScrollView");
    System.out.println("New ListWheelScrollView id:"+id);
  }
  ListWheelScrollView(int id) { this.id = id; }
  @Builder.Factory
  static ListWheelScrollView listWheelScrollViewListWheelScrollView(OptionalDouble diameterRatio, OptionalDouble perspective, OptionalDouble offAxisFraction, Optional<Boolean> useMagnifier, OptionalDouble magnification, OptionalDouble overAndUnderCenterOpacity, double itemExtent, OptionalDouble squeeze, Optional<Consumer<Integer>> onSelectedItemChanged, Optional<Boolean> renderChildrenOutsideViewport, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior, Optional<String> restorationId, Optional<DragStartBehavior> dragStartBehavior, Optional<ChangeReportingBehavior> changeReportingBehavior, List<WidgetI> children) {
    var st = factories.listWheelScrollViewListWheelScrollView(diameterRatio,
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
      children.stream().map(WidgetI::build).toList());
    if (st == null) throw new RuntimeException("Failed to created widget ListWheelScrollView");
    return new ListWheelScrollView(st);
  }
  public static ListWheelScrollViewListWheelScrollViewBuilder listWheelScrollView() {
    return ListWheelScrollViewListWheelScrollViewBuilder.listWheelScrollViewListWheelScrollView();
  }
  public double diameterRatio() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewDiameterRatio not supported on web");
    return ListWheelScrollViewObjSt.diameterRatio(st);
  }
  public double perspective() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewPerspective not supported on web");
    return ListWheelScrollViewObjSt.perspective(st);
  }
  public double offAxisFraction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewOffAxisFraction not supported on web");
    return ListWheelScrollViewObjSt.offAxisFraction(st);
  }
  public boolean useMagnifier() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewUseMagnifier not supported on web");
    return intToBool(ListWheelScrollViewObjSt.useMagnifier(st));
  }
  public double magnification() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewMagnification not supported on web");
    return ListWheelScrollViewObjSt.magnification(st);
  }
  public double overAndUnderCenterOpacity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewOverAndUnderCenterOpacity not supported on web");
    return ListWheelScrollViewObjSt.overAndUnderCenterOpacity(st);
  }
  public double itemExtent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewItemExtent not supported on web");
    return ListWheelScrollViewObjSt.itemExtent(st);
  }
  public double squeeze() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewSqueeze not supported on web");
    return ListWheelScrollViewObjSt.squeeze(st);
  }
  public boolean renderChildrenOutsideViewport() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewRenderChildrenOutsideViewport not supported on web");
    return intToBool(ListWheelScrollViewObjSt.renderChildrenOutsideViewport(st));
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewClipBehavior not supported on web");
    return Clip.values()[ListWheelScrollViewObjSt.clipBehavior(st)];
  }
  public HitTestBehavior hitTestBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewHitTestBehavior not supported on web");
    return HitTestBehavior.values()[ListWheelScrollViewObjSt.hitTestBehavior(st)];
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewRestorationId not supported on web");
    return ListWheelScrollViewObjSt.restorationId(st).getString(0);
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewDragStartBehavior not supported on web");
    return DragStartBehavior.values()[ListWheelScrollViewObjSt.dragStartBehavior(st)];
  }
  public ChangeReportingBehavior changeReportingBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listWheelScrollViewChangeReportingBehavior not supported on web");
    return ChangeReportingBehavior.values()[ListWheelScrollViewObjSt.changeReportingBehavior(st)];
  }
  @Override
  public ListWheelScrollView build() {
    return this;
  }
}
