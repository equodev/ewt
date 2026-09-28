package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ButtonBar extends StatelessWidget implements ButtonBarI {
  protected ButtonBar() {}
  ButtonBar(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ButtonBar");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ButtonBar buttonBarButtonBar(Optional<MainAxisAlignment> alignment, Optional<MainAxisSize> mainAxisSize, Optional<ButtonTextTheme> buttonTextTheme, OptionalDouble buttonMinWidth, OptionalDouble buttonHeight, Optional<EdgeInsetsGeometryI> buttonPadding, Optional<Boolean> buttonAlignedDropdown, Optional<ButtonBarLayoutBehavior> layoutBehavior, Optional<VerticalDirection> overflowDirection, OptionalDouble overflowButtonSpacing, Optional<List<WidgetI>> children) {
    int id = factories.buttonBarButtonBar(alignment,
      mainAxisSize,
      buttonTextTheme,
      buttonMinWidth,
      buttonHeight,
      buttonPadding.map(EdgeInsetsGeometryI::build),
      buttonAlignedDropdown,
      layoutBehavior,
      overflowDirection,
      overflowButtonSpacing,
      children.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())));
    if (id <= 0) throw new RuntimeException("Failed to created widget ButtonBar");
    return new ButtonBar(id);
  }
  public static ButtonBarButtonBarBuilder buttonBar() {
    return ButtonBarButtonBarBuilder.buttonBarButtonBar();
  }
  public MainAxisAlignment alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonBarAlignment not supported on web");
    return factories.ButtonBar_readBack_alignment(nativeStruct);
  }
  public MainAxisSize mainAxisSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonBarMainAxisSize not supported on web");
    return factories.ButtonBar_readBack_mainAxisSize(nativeStruct);
  }
  public ButtonTextTheme buttonTextTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonBarButtonTextTheme not supported on web");
    return factories.ButtonBar_readBack_buttonTextTheme(nativeStruct);
  }
  public double buttonMinWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonBarButtonMinWidth not supported on web");
    return factories.ButtonBar_readBack_buttonMinWidth(nativeStruct);
  }
  public double buttonHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonBarButtonHeight not supported on web");
    return factories.ButtonBar_readBack_buttonHeight(nativeStruct);
  }
  public EdgeInsetsGeometry buttonPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonBarButtonPadding not supported on web");
    return factories.ButtonBar_readBack_buttonPadding(nativeStruct);
  }
  public boolean buttonAlignedDropdown() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonBarButtonAlignedDropdown not supported on web");
    return factories.ButtonBar_readBack_buttonAlignedDropdown(nativeStruct);
  }
  public ButtonBarLayoutBehavior layoutBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonBarLayoutBehavior not supported on web");
    return factories.ButtonBar_readBack_layoutBehavior(nativeStruct);
  }
  public VerticalDirection overflowDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonBarOverflowDirection not supported on web");
    return factories.ButtonBar_readBack_overflowDirection(nativeStruct);
  }
  public double overflowButtonSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("buttonBarOverflowButtonSpacing not supported on web");
    return factories.ButtonBar_readBack_overflowButtonSpacing(nativeStruct);
  }
  @Override
  public ButtonBar build() {
    return this;
  }
}
