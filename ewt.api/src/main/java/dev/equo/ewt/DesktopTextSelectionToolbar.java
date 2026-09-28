package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DesktopTextSelectionToolbar extends StatelessWidget implements DesktopTextSelectionToolbarI {
  protected DesktopTextSelectionToolbar() {}
  DesktopTextSelectionToolbar(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DesktopTextSelectionToolbar");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DesktopTextSelectionToolbar desktopTextSelectionToolbarDesktopTextSelectionToolbar(@Builder.Parameter OffsetI anchor, @Builder.Parameter List<WidgetI> children) {
    int id = factories.desktopTextSelectionToolbarDesktopTextSelectionToolbar(anchor.build(),
      children.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()));
    if (id <= 0) throw new RuntimeException("Failed to created widget DesktopTextSelectionToolbar");
    return new DesktopTextSelectionToolbar(id);
  }
  public static DesktopTextSelectionToolbarDesktopTextSelectionToolbarBuilder desktopTextSelectionToolbar(OffsetI anchor, List<WidgetI> children) {
    return DesktopTextSelectionToolbarDesktopTextSelectionToolbarBuilder.desktopTextSelectionToolbarDesktopTextSelectionToolbar(anchor, children);
  }
  public Offset anchor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("desktopTextSelectionToolbarAnchor", getId());
      return new Offset(__nid);
    }
    return factories.DesktopTextSelectionToolbar_readBack_anchor(nativeStruct);
  }
  @Override
  public DesktopTextSelectionToolbar build() {
    return this;
  }
}
