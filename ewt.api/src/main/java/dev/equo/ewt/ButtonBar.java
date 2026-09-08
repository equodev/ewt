package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ButtonBarObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ButtonBar extends StatelessWidget implements ButtonBarI {
  private MemorySegment st;
  protected ButtonBar() {}
  ButtonBar(MemorySegment st) {
    this.id = ButtonBarObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ButtonBar");
    System.out.println("New ButtonBar id:"+id);
  }
  ButtonBar(int id) { this.id = id; }
  @Builder.Factory
  static ButtonBar buttonBarButtonBar(Optional<MainAxisAlignment> alignment, Optional<MainAxisSize> mainAxisSize, Optional<ButtonTextTheme> buttonTextTheme, OptionalDouble buttonMinWidth, OptionalDouble buttonHeight, Optional<EdgeInsetsGeometryI> buttonPadding, Optional<Boolean> buttonAlignedDropdown, Optional<ButtonBarLayoutBehavior> layoutBehavior, Optional<VerticalDirection> overflowDirection, OptionalDouble overflowButtonSpacing, Optional<List<WidgetI>> children) {
    var st = factories.buttonBarButtonBar(alignment,
      mainAxisSize,
      buttonTextTheme,
      buttonMinWidth,
      buttonHeight,
      buttonPadding.map(EdgeInsetsGeometryI::build),
      buttonAlignedDropdown,
      layoutBehavior,
      overflowDirection,
      overflowButtonSpacing,
      children.map(i -> i.stream().map(WidgetI::build).toList()));
    if (st == null) throw new RuntimeException("Failed to created widget ButtonBar");
    return new ButtonBar(st);
  }
  public static ButtonBarButtonBarBuilder buttonBar() {
    return ButtonBarButtonBarBuilder.buttonBarButtonBar();
  }
  public MainAxisAlignment alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonBarAlignment not supported on web");
    return MainAxisAlignment.values()[ButtonBarObjSt.alignment(st)];
  }
  public MainAxisSize mainAxisSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonBarMainAxisSize not supported on web");
    return MainAxisSize.values()[ButtonBarObjSt.mainAxisSize(st)];
  }
  public ButtonTextTheme buttonTextTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonBarButtonTextTheme not supported on web");
    return ButtonTextTheme.values()[ButtonBarObjSt.buttonTextTheme(st)];
  }
  public double buttonMinWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonBarButtonMinWidth not supported on web");
    return ButtonBarObjSt.buttonMinWidth(st);
  }
  public double buttonHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonBarButtonHeight not supported on web");
    return ButtonBarObjSt.buttonHeight(st);
  }
  public EdgeInsetsGeometry buttonPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonBarButtonPadding not supported on web");
    return new EdgeInsetsGeometry(ButtonBarObjSt.buttonPadding(st)) {};
  }
  public boolean buttonAlignedDropdown() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonBarButtonAlignedDropdown not supported on web");
    return intToBool(ButtonBarObjSt.buttonAlignedDropdown(st));
  }
  public ButtonBarLayoutBehavior layoutBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonBarLayoutBehavior not supported on web");
    return ButtonBarLayoutBehavior.values()[ButtonBarObjSt.layoutBehavior(st)];
  }
  public VerticalDirection overflowDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonBarOverflowDirection not supported on web");
    return VerticalDirection.values()[ButtonBarObjSt.overflowDirection(st)];
  }
  public double overflowButtonSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonBarOverflowButtonSpacing not supported on web");
    return ButtonBarObjSt.overflowButtonSpacing(st);
  }
  @Override
  public ButtonBar build() {
    return this;
  }
}
