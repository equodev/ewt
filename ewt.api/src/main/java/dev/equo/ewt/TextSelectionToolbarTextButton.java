package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TextSelectionToolbarTextButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TextSelectionToolbarTextButton extends StatelessWidget implements TextSelectionToolbarTextButtonI {
  private MemorySegment st;
  protected TextSelectionToolbarTextButton() {}
  TextSelectionToolbarTextButton(MemorySegment st) {
    this.id = TextSelectionToolbarTextButtonObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TextSelectionToolbarTextButton");
    System.out.println("New TextSelectionToolbarTextButton id:"+id);
  }
  TextSelectionToolbarTextButton(int id) { this.id = id; }
  @Builder.Factory
  static TextSelectionToolbarTextButton textSelectionToolbarTextButtonTextSelectionToolbarTextButton(@Builder.Parameter WidgetI child, @Builder.Parameter EdgeInsetsGeometryI padding, Optional<Runnable> onPressed, Optional<AlignmentGeometryI> alignment) {
    var st = factories.textSelectionToolbarTextButtonTextSelectionToolbarTextButton(child.build(),
      padding.build(),
      onPressed,
      alignment.map(AlignmentGeometryI::build));
    if (st == null) throw new RuntimeException("Failed to created widget TextSelectionToolbarTextButton");
    return new TextSelectionToolbarTextButton(st);
  }
  public static TextSelectionToolbarTextButtonTextSelectionToolbarTextButtonBuilder textSelectionToolbarTextButton(WidgetI child, EdgeInsetsGeometryI padding) {
    return TextSelectionToolbarTextButtonTextSelectionToolbarTextButtonBuilder.textSelectionToolbarTextButtonTextSelectionToolbarTextButton(child, padding);
  }
  public static EdgeInsetsGeometry getPadding(int index, int total) {
    int id = factories.textSelectionToolbarTextButtonGetPadding(index,
      total);
    if (id <= 0) throw new RuntimeException("Failed to created widget EdgeInsetsGeometry");
    System.out.println("New EdgeInsetsGeometry id:"+id);
    return new EdgeInsetsGeometry(id) {};
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textSelectionToolbarTextButtonChild not supported on web");
    return new Widget(TextSelectionToolbarTextButtonObjSt.child(st)) {};
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textSelectionToolbarTextButtonPadding not supported on web");
    return new EdgeInsetsGeometry(TextSelectionToolbarTextButtonObjSt.padding(st)) {};
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textSelectionToolbarTextButtonAlignment not supported on web");
    return new AlignmentGeometry(TextSelectionToolbarTextButtonObjSt.alignment(st)) {};
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
