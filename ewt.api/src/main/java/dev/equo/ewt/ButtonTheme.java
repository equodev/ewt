package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ButtonThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ButtonTheme extends InheritedTheme implements ButtonThemeI {
  private MemorySegment st;
  protected ButtonTheme() {}
  ButtonTheme(MemorySegment st) {
    this.id = ButtonThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ButtonTheme");
    System.out.println("New ButtonTheme id:"+id);
  }
  ButtonTheme(int id) { this.id = id; }
  @Builder.Factory
  static ButtonTheme buttonThemeButtonTheme(Optional<ButtonTextTheme> textTheme, Optional<ButtonBarLayoutBehavior> layoutBehavior, OptionalDouble minWidth, OptionalDouble height, Optional<EdgeInsetsGeometryI> padding, Optional<ShapeBorderI> shape, Optional<Boolean> alignedDropdown, Optional<ColorI> buttonColor, Optional<ColorI> disabledColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> splashColor, Optional<ColorSchemeI> colorScheme, Optional<MaterialTapTargetSize> materialTapTargetSize, WidgetI child) {
    var st = factories.buttonThemeButtonTheme(textTheme,
      layoutBehavior,
      minWidth,
      height,
      padding.map(EdgeInsetsGeometryI::build),
      shape.map(ShapeBorderI::build),
      alignedDropdown,
      buttonColor.map(ColorI::build),
      disabledColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      highlightColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      colorScheme.map(ColorSchemeI::build),
      materialTapTargetSize,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget ButtonTheme");
    return new ButtonTheme(st);
  }
  public static ButtonThemeButtonThemeBuilder buttonTheme() {
    return ButtonThemeButtonThemeBuilder.buttonThemeButtonTheme();
  }
  @Builder.Factory
  static ButtonTheme buttonThemeFromButtonThemeData(@Builder.Parameter ButtonThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.buttonThemeFromButtonThemeData(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget ButtonTheme");
    return new ButtonTheme(st);
  }
  public static ButtonThemeFromButtonThemeDataBuilder fromButtonThemeData(ButtonThemeDataI data, WidgetI child) {
    return ButtonThemeFromButtonThemeDataBuilder.buttonThemeFromButtonThemeData(data, child);
  }
  public static ButtonThemeData of(BuildContextI context) {
    var st = factories.buttonThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget ButtonThemeData");
    return new ButtonThemeData(st);
  }
  public ButtonThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("buttonThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.ButtonThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.ButtonThemeDataObjSt.id(__st, __nid);
      return new ButtonThemeData(__st);
    }
    return new ButtonThemeData(ButtonThemeObjSt.data(st));
  }
  @Override
  public ButtonTheme build() {
    return this;
  }
}
