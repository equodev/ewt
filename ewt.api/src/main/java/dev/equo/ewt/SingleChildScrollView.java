package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SingleChildScrollView extends StatelessWidget implements SingleChildScrollViewI {
  protected SingleChildScrollView() {}
  SingleChildScrollView(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SingleChildScrollView");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SingleChildScrollView singleChildScrollViewSingleChildScrollView(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<EdgeInsetsGeometryI> padding, Optional<Boolean> primary, Optional<WidgetI> child, Optional<DragStartBehavior> dragStartBehavior, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior, Optional<String> restorationId, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior) {
    int id = factories.singleChildScrollViewSingleChildScrollView(scrollDirection,
      reverse,
      padding.map(EdgeInsetsGeometryI::build),
      primary,
      child.map(WidgetI::build),
      dragStartBehavior,
      clipBehavior,
      hitTestBehavior,
      restorationId,
      keyboardDismissBehavior);
    if (id <= 0) throw new RuntimeException("Failed to created widget SingleChildScrollView");
    return new SingleChildScrollView(id);
  }
  public static SingleChildScrollViewSingleChildScrollViewBuilder singleChildScrollView() {
    return SingleChildScrollViewSingleChildScrollViewBuilder.singleChildScrollViewSingleChildScrollView();
  }
  public Axis scrollDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("singleChildScrollViewScrollDirection not supported on web");
    return factories.SingleChildScrollView_readBack_scrollDirection(nativeStruct);
  }
  public boolean reverse() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("singleChildScrollViewReverse not supported on web");
    return factories.SingleChildScrollView_readBack_reverse(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("singleChildScrollViewPadding not supported on web");
    return factories.SingleChildScrollView_readBack_padding(nativeStruct);
  }
  public boolean primary() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("singleChildScrollViewPrimary not supported on web");
    return factories.SingleChildScrollView_readBack_primary(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("singleChildScrollViewChild not supported on web");
    return factories.SingleChildScrollView_readBack_child(nativeStruct);
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("singleChildScrollViewDragStartBehavior not supported on web");
    return factories.SingleChildScrollView_readBack_dragStartBehavior(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("singleChildScrollViewClipBehavior not supported on web");
    return factories.SingleChildScrollView_readBack_clipBehavior(nativeStruct);
  }
  public HitTestBehavior hitTestBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("singleChildScrollViewHitTestBehavior not supported on web");
    return factories.SingleChildScrollView_readBack_hitTestBehavior(nativeStruct);
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("singleChildScrollViewRestorationId not supported on web");
    return factories.SingleChildScrollView_readBack_restorationId(nativeStruct);
  }
  public ScrollViewKeyboardDismissBehavior keyboardDismissBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("singleChildScrollViewKeyboardDismissBehavior not supported on web");
    return factories.SingleChildScrollView_readBack_keyboardDismissBehavior(nativeStruct);
  }
  @Override
  public SingleChildScrollView build() {
    return this;
  }
}
