package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DesktopTextSelectionToolbarObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DesktopTextSelectionToolbar extends StatelessWidget implements DesktopTextSelectionToolbarI {
  private MemorySegment st;
  protected DesktopTextSelectionToolbar() {}
  DesktopTextSelectionToolbar(MemorySegment st) {
    this.id = DesktopTextSelectionToolbarObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DesktopTextSelectionToolbar");
    System.out.println("New DesktopTextSelectionToolbar id:"+id);
  }
  DesktopTextSelectionToolbar(int id) { this.id = id; }
  @Builder.Factory
  static DesktopTextSelectionToolbar desktopTextSelectionToolbarDesktopTextSelectionToolbar(@Builder.Parameter OffsetI anchor, @Builder.Parameter List<WidgetI> children) {
    var st = factories.desktopTextSelectionToolbarDesktopTextSelectionToolbar(anchor.build(),
      children.stream().map(WidgetI::build).toList());
    if (st == null) throw new RuntimeException("Failed to created widget DesktopTextSelectionToolbar");
    return new DesktopTextSelectionToolbar(st);
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
    return new Offset(DesktopTextSelectionToolbarObjSt.anchor(st));
  }
  @Override
  public DesktopTextSelectionToolbar build() {
    return this;
  }
}
