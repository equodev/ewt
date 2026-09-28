package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TextSelectionToolbarTextButton extends StatelessWidget implements TextSelectionToolbarTextButtonI {
  protected TextSelectionToolbarTextButton() {}
  TextSelectionToolbarTextButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TextSelectionToolbarTextButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TextSelectionToolbarTextButton textSelectionToolbarTextButtonTextSelectionToolbarTextButton(@Builder.Parameter WidgetI child, @Builder.Parameter EdgeInsetsGeometryI padding, Optional<Runnable> onPressed, Optional<AlignmentGeometryI> alignment) {
    int id = factories.textSelectionToolbarTextButtonTextSelectionToolbarTextButton(child.build(),
      padding.build(),
      onPressed,
      alignment.map(AlignmentGeometryI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget TextSelectionToolbarTextButton");
    return new TextSelectionToolbarTextButton(id);
  }
  public static TextSelectionToolbarTextButtonTextSelectionToolbarTextButtonBuilder textSelectionToolbarTextButton(WidgetI child, EdgeInsetsGeometryI padding) {
    return TextSelectionToolbarTextButtonTextSelectionToolbarTextButtonBuilder.textSelectionToolbarTextButtonTextSelectionToolbarTextButton(child, padding);
  }
  public static EdgeInsetsGeometry getPadding(int index, int total) {
    var id = factories.textSelectionToolbarTextButtonGetPadding(index,
      total);
    if (id <= 0) throw new RuntimeException("Failed to created widget EdgeInsetsGeometry");
    System.out.println("New EdgeInsetsGeometry id:"+id);
    return new EdgeInsetsGeometry(id) {};
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textSelectionToolbarTextButtonChild not supported on web");
    return factories.TextSelectionToolbarTextButton_readBack_child(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textSelectionToolbarTextButtonPadding not supported on web");
    return factories.TextSelectionToolbarTextButton_readBack_padding(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textSelectionToolbarTextButtonAlignment not supported on web");
    return factories.TextSelectionToolbarTextButton_readBack_alignment(nativeStruct);
  }
  private static double _kMiddlePadding() {
    return 9.5;
  }
  private static double _kEndPadding() {
    return 14.5;
  }
  private static Color _defaultForegroundColorLight() {
    return Color.color(0xff000000).build();
  }
  private static Color _defaultForegroundColorDark() {
    return Color.color(0xffffffff).build();
  }
  private static Color _defaultBackgroundColorTransparent() {
    return Color.color(0x00000000).build();
  }
  @Override
  public TextSelectionToolbarTextButton build() {
    return this;
  }
}
