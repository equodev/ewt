package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DropdownMenuThemeData extends NativeObj.Base implements DropdownMenuThemeDataI {
  protected DropdownMenuThemeData() {}
  DropdownMenuThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DropdownMenuThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DropdownMenuThemeData dropdownMenuThemeDataDropdownMenuThemeData(Optional<TextStyleI> textStyle, Optional<NativeObj.I> inputDecorationTheme, Optional<ColorI> disabledColor) {
    int id = factories.dropdownMenuThemeDataDropdownMenuThemeData(textStyle.map(TextStyleI::build),
      inputDecorationTheme.map(NativeObj.I::build),
      disabledColor.map(ColorI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget DropdownMenuThemeData");
    return new DropdownMenuThemeData(id);
  }
  public static DropdownMenuThemeDataDropdownMenuThemeDataBuilder dropdownMenuThemeData() {
    return DropdownMenuThemeDataDropdownMenuThemeDataBuilder.dropdownMenuThemeDataDropdownMenuThemeData();
  }
  public static DropdownMenuThemeData lerp(DropdownMenuThemeDataI a, DropdownMenuThemeDataI b, double t) {
    int id = factories.dropdownMenuThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget DropdownMenuThemeData");
    return new DropdownMenuThemeData(id);
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dropdownMenuThemeDataTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.DropdownMenuThemeData_readBack_textStyle(nativeStruct);
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dropdownMenuThemeDataDisabledColor", getId());
      return new Color(__nid);
    }
    return factories.DropdownMenuThemeData_readBack_disabledColor(nativeStruct);
  }
  @Override
  public DropdownMenuThemeData build() {
    return this;
  }
}
