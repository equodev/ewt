package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Scrollbar extends StatelessWidget implements ScrollbarI {
  protected Scrollbar() {}
  Scrollbar(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Scrollbar");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Scrollbar scrollbarScrollbar(@Builder.Parameter WidgetI child, Optional<Boolean> thumbVisibility, Optional<Boolean> trackVisibility, OptionalDouble thickness, Optional<RadiusI> radius, Optional<Boolean> interactive, Optional<ScrollbarOrientation> scrollbarOrientation) {
    int id = factories.scrollbarScrollbar(child.build(),
      thumbVisibility,
      trackVisibility,
      thickness,
      radius.map(RadiusI::build),
      interactive,
      scrollbarOrientation);
    if (id <= 0) throw new RuntimeException("Failed to created widget Scrollbar");
    return new Scrollbar(id);
  }
  public static ScrollbarScrollbarBuilder scrollbar(WidgetI child) {
    return ScrollbarScrollbarBuilder.scrollbarScrollbar(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scrollbarChild not supported on web");
    return factories.Scrollbar_readBack_child(nativeStruct);
  }
  public boolean thumbVisibility() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scrollbarThumbVisibility not supported on web");
    return factories.Scrollbar_readBack_thumbVisibility(nativeStruct);
  }
  public boolean trackVisibility() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scrollbarTrackVisibility not supported on web");
    return factories.Scrollbar_readBack_trackVisibility(nativeStruct);
  }
  public double thickness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scrollbarThickness not supported on web");
    return factories.Scrollbar_readBack_thickness(nativeStruct);
  }
  public Radius radius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("scrollbarRadius", getId());
      return new Radius(__nid);
    }
    return factories.Scrollbar_readBack_radius(nativeStruct);
  }
  public boolean interactive() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scrollbarInteractive not supported on web");
    return factories.Scrollbar_readBack_interactive(nativeStruct);
  }
  public ScrollbarOrientation scrollbarOrientation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scrollbarScrollbarOrientation not supported on web");
    return factories.Scrollbar_readBack_scrollbarOrientation(nativeStruct);
  }
  @Override
  public Scrollbar build() {
    return this;
  }
}
