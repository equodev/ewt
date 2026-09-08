package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.IconButtonThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class IconButtonThemeData extends NativeObj.Base implements IconButtonThemeDataI {
  private MemorySegment st;
  protected IconButtonThemeData() {}
  IconButtonThemeData(MemorySegment st) {
    this.id = IconButtonThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget IconButtonThemeData");
    System.out.println("New IconButtonThemeData id:"+id);
  }
  IconButtonThemeData(int id) { this.id = id; }
  @Builder.Factory
  static IconButtonThemeData iconButtonThemeDataIconButtonThemeData() {
    var st = factories.iconButtonThemeDataIconButtonThemeData();
    if (st == null) throw new RuntimeException("Failed to created widget IconButtonThemeData");
    return new IconButtonThemeData(st);
  }
  public static IconButtonThemeDataIconButtonThemeDataBuilder iconButtonThemeData() {
    return IconButtonThemeDataIconButtonThemeDataBuilder.iconButtonThemeDataIconButtonThemeData();
  }
  public static IconButtonThemeData lerp(IconButtonThemeDataI a, IconButtonThemeDataI b, double t) {
    var st = factories.iconButtonThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget IconButtonThemeData");
    return new IconButtonThemeData(st);
  }
  @Override
  public IconButtonThemeData build() {
    return this;
  }
}
