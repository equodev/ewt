package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SegmentedButton<T> extends StatefulWidget implements SegmentedButtonI {
  protected SegmentedButton() {}
  SegmentedButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SegmentedButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  public Axis direction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("segmentedButtonDirection not supported on web");
    return factories.SegmentedButton_readBack_direction(nativeStruct);
  }
  public boolean multiSelectionEnabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("segmentedButtonMultiSelectionEnabled not supported on web");
    return factories.SegmentedButton_readBack_multiSelectionEnabled(nativeStruct);
  }
  public boolean emptySelectionAllowed() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("segmentedButtonEmptySelectionAllowed not supported on web");
    return factories.SegmentedButton_readBack_emptySelectionAllowed(nativeStruct);
  }
  public EdgeInsets expandedInsets() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("segmentedButtonExpandedInsets", getId());
      return new EdgeInsets(__nid);
    }
    return factories.SegmentedButton_readBack_expandedInsets(nativeStruct);
  }
  public boolean showSelectedIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("segmentedButtonShowSelectedIcon not supported on web");
    return factories.SegmentedButton_readBack_showSelectedIcon(nativeStruct);
  }
  public Widget selectedIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("segmentedButtonSelectedIcon not supported on web");
    return factories.SegmentedButton_readBack_selectedIcon(nativeStruct);
  }
  @Override
  public SegmentedButton build() {
    return this;
  }
}
