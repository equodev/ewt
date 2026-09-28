package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DesktopTextSelectionToolbarButton extends StatelessWidget implements DesktopTextSelectionToolbarButtonI {
  protected DesktopTextSelectionToolbarButton() {}
  DesktopTextSelectionToolbarButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DesktopTextSelectionToolbarButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DesktopTextSelectionToolbarButton desktopTextSelectionToolbarButtonDesktopTextSelectionToolbarButton(Optional<Runnable> onPressed, WidgetI child) {
    int id = factories.desktopTextSelectionToolbarButtonDesktopTextSelectionToolbarButton(onPressed,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DesktopTextSelectionToolbarButton");
    return new DesktopTextSelectionToolbarButton(id);
  }
  public static DesktopTextSelectionToolbarButtonDesktopTextSelectionToolbarButtonBuilder desktopTextSelectionToolbarButton() {
    return DesktopTextSelectionToolbarButtonDesktopTextSelectionToolbarButtonBuilder.desktopTextSelectionToolbarButtonDesktopTextSelectionToolbarButton();
  }
  @Builder.Factory
  static DesktopTextSelectionToolbarButton desktopTextSelectionToolbarButtonText(@Builder.Parameter BuildContextI context, Optional<Runnable> onPressed, String text) {
    int id = factories.desktopTextSelectionToolbarButtonText(context.build(),
      onPressed,
      text);
    if (id <= 0) throw new RuntimeException("Failed to created widget DesktopTextSelectionToolbarButton");
    return new DesktopTextSelectionToolbarButton(id);
  }
  public static DesktopTextSelectionToolbarButtonTextBuilder text(BuildContextI context) {
    return DesktopTextSelectionToolbarButtonTextBuilder.desktopTextSelectionToolbarButtonText(context);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("desktopTextSelectionToolbarButtonChild not supported on web");
    return factories.DesktopTextSelectionToolbarButton_readBack_child(nativeStruct);
  }
  @Override
  public DesktopTextSelectionToolbarButton build() {
    return this;
  }
}
