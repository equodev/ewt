package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DropdownMenuThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DropdownMenuThemeData extends NativeObj.Base implements DropdownMenuThemeDataI {
  private MemorySegment st;
  protected DropdownMenuThemeData() {}
  DropdownMenuThemeData(MemorySegment st) {
    this.id = DropdownMenuThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DropdownMenuThemeData");
    System.out.println("New DropdownMenuThemeData id:"+id);
  }
  DropdownMenuThemeData(int id) { this.id = id; }
  @Builder.Factory
  static DropdownMenuThemeData dropdownMenuThemeDataDropdownMenuThemeData(Optional<TextStyleI> textStyle, Optional<NativeObj.I> inputDecorationTheme, Optional<ColorI> disabledColor) {
    var st = factories.dropdownMenuThemeDataDropdownMenuThemeData(textStyle.map(TextStyleI::build),
      inputDecorationTheme.map(NativeObj.I::build),
      disabledColor.map(ColorI::build));
    if (st == null) throw new RuntimeException("Failed to created widget DropdownMenuThemeData");
    return new DropdownMenuThemeData(st);
  }
  public static DropdownMenuThemeDataDropdownMenuThemeDataBuilder dropdownMenuThemeData() {
    return DropdownMenuThemeDataDropdownMenuThemeDataBuilder.dropdownMenuThemeDataDropdownMenuThemeData();
  }
  public static DropdownMenuThemeData lerp(DropdownMenuThemeDataI a, DropdownMenuThemeDataI b, double t) {
    var st = factories.dropdownMenuThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget DropdownMenuThemeData");
    return new DropdownMenuThemeData(st);
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dropdownMenuThemeDataTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(DropdownMenuThemeDataObjSt.textStyle(st));
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dropdownMenuThemeDataDisabledColor", getId());
      return new Color(__nid);
    }
    return new Color(DropdownMenuThemeDataObjSt.disabledColor(st));
  }
  @Override
  public DropdownMenuThemeData build() {
    return this;
  }
}
