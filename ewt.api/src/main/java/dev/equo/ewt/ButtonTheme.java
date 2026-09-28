package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ButtonTheme extends InheritedTheme implements ButtonThemeI {
  protected ButtonTheme() {}
  ButtonTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ButtonTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ButtonTheme buttonThemeButtonTheme(Optional<ButtonTextTheme> textTheme, Optional<ButtonBarLayoutBehavior> layoutBehavior, OptionalDouble minWidth, OptionalDouble height, Optional<EdgeInsetsGeometryI> padding, Optional<ShapeBorderI> shape, Optional<Boolean> alignedDropdown, Optional<ColorI> buttonColor, Optional<ColorI> disabledColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> splashColor, Optional<ColorSchemeI> colorScheme, Optional<MaterialTapTargetSize> materialTapTargetSize, WidgetI child) {
    int id = factories.buttonThemeButtonTheme(textTheme,
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
    if (id <= 0) throw new RuntimeException("Failed to created widget ButtonTheme");
    return new ButtonTheme(id);
  }
  public static ButtonThemeButtonThemeBuilder buttonTheme() {
    return ButtonThemeButtonThemeBuilder.buttonThemeButtonTheme();
  }
  @Builder.Factory
  static ButtonTheme buttonThemeFromButtonThemeData(@Builder.Parameter ButtonThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.buttonThemeFromButtonThemeData(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ButtonTheme");
    return new ButtonTheme(id);
  }
  public static ButtonThemeFromButtonThemeDataBuilder fromButtonThemeData(ButtonThemeDataI data, WidgetI child) {
    return ButtonThemeFromButtonThemeDataBuilder.buttonThemeFromButtonThemeData(data, child);
  }
  public static ButtonThemeData of(BuildContextI context) {
    int id = factories.buttonThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ButtonThemeData");
    return new ButtonThemeData(id);
  }
  public ButtonThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("buttonThemeData", getId());
      return new ButtonThemeData(__nid);
    }
    return factories.ButtonTheme_readBack_data(nativeStruct);
  }
  @Override
  public ButtonTheme build() {
    return this;
  }
}
