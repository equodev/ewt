package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ScrollbarObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Scrollbar extends StatelessWidget implements ScrollbarI {
  private MemorySegment st;
  protected Scrollbar() {}
  Scrollbar(MemorySegment st) {
    this.id = ScrollbarObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Scrollbar");
    System.out.println("New Scrollbar id:"+id);
  }
  Scrollbar(int id) { this.id = id; }
  @Builder.Factory
  static Scrollbar scrollbarScrollbar(@Builder.Parameter WidgetI child, Optional<Boolean> thumbVisibility, Optional<Boolean> trackVisibility, OptionalDouble thickness, Optional<RadiusI> radius, Optional<Boolean> interactive, Optional<ScrollbarOrientation> scrollbarOrientation) {
    var st = factories.scrollbarScrollbar(child.build(),
      thumbVisibility,
      trackVisibility,
      thickness,
      radius.map(RadiusI::build),
      interactive,
      scrollbarOrientation);
    if (st == null) throw new RuntimeException("Failed to created widget Scrollbar");
    return new Scrollbar(st);
  }
  public static ScrollbarScrollbarBuilder scrollbar(WidgetI child) {
    return ScrollbarScrollbarBuilder.scrollbarScrollbar(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scrollbarChild not supported on web");
    return new Widget(ScrollbarObjSt.child(st)) {};
  }
  public boolean thumbVisibility() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scrollbarThumbVisibility not supported on web");
    return intToBool(ScrollbarObjSt.thumbVisibility(st));
  }
  public boolean trackVisibility() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scrollbarTrackVisibility not supported on web");
    return intToBool(ScrollbarObjSt.trackVisibility(st));
  }
  public double thickness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scrollbarThickness not supported on web");
    return ScrollbarObjSt.thickness(st);
  }
  public Radius radius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("scrollbarRadius", getId());
      return new Radius(__nid);
    }
    return new Radius(ScrollbarObjSt.radius(st));
  }
  public boolean interactive() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scrollbarInteractive not supported on web");
    return intToBool(ScrollbarObjSt.interactive(st));
  }
  public ScrollbarOrientation scrollbarOrientation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scrollbarScrollbarOrientation not supported on web");
    return ScrollbarOrientation.values()[ScrollbarObjSt.scrollbarOrientation(st)];
  }
  @Override
  public Scrollbar build() {
    return this;
  }
}
