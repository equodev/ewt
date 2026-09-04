package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SegmentedButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SegmentedButton<T> extends StatefulWidget implements SegmentedButtonI {
  private MemorySegment st;
  protected SegmentedButton() {}
  SegmentedButton(MemorySegment st) {
    this.id = SegmentedButtonObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SegmentedButton");
    System.out.println("New SegmentedButton id:"+id);
  }
  SegmentedButton(int id) { this.id = id; }
  public Axis direction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("segmentedButtonDirection not supported on web");
    return Axis.values()[SegmentedButtonObjSt.direction(st)];
  }
  public boolean multiSelectionEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("segmentedButtonMultiSelectionEnabled not supported on web");
    return intToBool(SegmentedButtonObjSt.multiSelectionEnabled(st));
  }
  public boolean emptySelectionAllowed() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("segmentedButtonEmptySelectionAllowed not supported on web");
    return intToBool(SegmentedButtonObjSt.emptySelectionAllowed(st));
  }
  public EdgeInsets expandedInsets() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("segmentedButtonExpandedInsets", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.EdgeInsetsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.EdgeInsetsObjSt.id(__st, __nid);
      return new EdgeInsets(__st);
    }
    return new EdgeInsets(SegmentedButtonObjSt.expandedInsets(st));
  }
  public boolean showSelectedIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("segmentedButtonShowSelectedIcon not supported on web");
    return intToBool(SegmentedButtonObjSt.showSelectedIcon(st));
  }
  public Widget selectedIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("segmentedButtonSelectedIcon not supported on web");
    return new Widget(SegmentedButtonObjSt.selectedIcon(st)) {};
  }
  @Override
  public SegmentedButton build() {
    return this;
  }
}
