package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DesktopTextSelectionToolbarButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DesktopTextSelectionToolbarButton extends StatelessWidget implements DesktopTextSelectionToolbarButtonI {
  private MemorySegment st;
  protected DesktopTextSelectionToolbarButton() {}
  DesktopTextSelectionToolbarButton(MemorySegment st) {
    this.id = DesktopTextSelectionToolbarButtonObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DesktopTextSelectionToolbarButton");
    System.out.println("New DesktopTextSelectionToolbarButton id:"+id);
  }
  DesktopTextSelectionToolbarButton(int id) { this.id = id; }
  @Builder.Factory
  static DesktopTextSelectionToolbarButton desktopTextSelectionToolbarButtonDesktopTextSelectionToolbarButton(Optional<Runnable> onPressed, WidgetI child) {
    var st = factories.desktopTextSelectionToolbarButtonDesktopTextSelectionToolbarButton(onPressed,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget DesktopTextSelectionToolbarButton");
    return new DesktopTextSelectionToolbarButton(st);
  }
  public static DesktopTextSelectionToolbarButtonDesktopTextSelectionToolbarButtonBuilder desktopTextSelectionToolbarButton() {
    return DesktopTextSelectionToolbarButtonDesktopTextSelectionToolbarButtonBuilder.desktopTextSelectionToolbarButtonDesktopTextSelectionToolbarButton();
  }
  @Builder.Factory
  static DesktopTextSelectionToolbarButton desktopTextSelectionToolbarButtonText(@Builder.Parameter BuildContextI context, Optional<Runnable> onPressed, String text) {
    var st = factories.desktopTextSelectionToolbarButtonText(context.build(),
      onPressed,
      text);
    if (st == null) throw new RuntimeException("Failed to created widget DesktopTextSelectionToolbarButton");
    return new DesktopTextSelectionToolbarButton(st);
  }
  public static DesktopTextSelectionToolbarButtonTextBuilder text(BuildContextI context) {
    return DesktopTextSelectionToolbarButtonTextBuilder.desktopTextSelectionToolbarButtonText(context);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("desktopTextSelectionToolbarButtonChild not supported on web");
    return new Widget(DesktopTextSelectionToolbarButtonObjSt.child(st)) {};
  }
  @Override
  public DesktopTextSelectionToolbarButton build() {
    return this;
  }
}
