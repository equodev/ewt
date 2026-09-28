package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ElevatedButtonThemeData extends NativeObj.Base implements ElevatedButtonThemeDataI {
  protected ElevatedButtonThemeData() {}
  ElevatedButtonThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ElevatedButtonThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ElevatedButtonThemeData elevatedButtonThemeDataElevatedButtonThemeData() {
    int id = factories.elevatedButtonThemeDataElevatedButtonThemeData();
    if (id <= 0) throw new RuntimeException("Failed to created widget ElevatedButtonThemeData");
    return new ElevatedButtonThemeData(id);
  }
  public static ElevatedButtonThemeDataElevatedButtonThemeDataBuilder elevatedButtonThemeData() {
    return ElevatedButtonThemeDataElevatedButtonThemeDataBuilder.elevatedButtonThemeDataElevatedButtonThemeData();
  }
  public static ElevatedButtonThemeData lerp(ElevatedButtonThemeDataI a, ElevatedButtonThemeDataI b, double t) {
    int id = factories.elevatedButtonThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget ElevatedButtonThemeData");
    return new ElevatedButtonThemeData(id);
  }
  @Override
  public ElevatedButtonThemeData build() {
    return this;
  }
}
