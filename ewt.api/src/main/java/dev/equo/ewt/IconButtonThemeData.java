package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class IconButtonThemeData extends NativeObj.Base implements IconButtonThemeDataI {
  protected IconButtonThemeData() {}
  IconButtonThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget IconButtonThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static IconButtonThemeData iconButtonThemeDataIconButtonThemeData() {
    int id = factories.iconButtonThemeDataIconButtonThemeData();
    if (id <= 0) throw new RuntimeException("Failed to created widget IconButtonThemeData");
    return new IconButtonThemeData(id);
  }
  public static IconButtonThemeDataIconButtonThemeDataBuilder iconButtonThemeData() {
    return IconButtonThemeDataIconButtonThemeDataBuilder.iconButtonThemeDataIconButtonThemeData();
  }
  public static IconButtonThemeData lerp(IconButtonThemeDataI a, IconButtonThemeDataI b, double t) {
    int id = factories.iconButtonThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget IconButtonThemeData");
    return new IconButtonThemeData(id);
  }
  @Override
  public IconButtonThemeData build() {
    return this;
  }
}
