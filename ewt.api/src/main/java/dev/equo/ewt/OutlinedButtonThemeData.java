package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class OutlinedButtonThemeData extends NativeObj.Base implements OutlinedButtonThemeDataI {
  protected OutlinedButtonThemeData() {}
  OutlinedButtonThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget OutlinedButtonThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static OutlinedButtonThemeData outlinedButtonThemeDataOutlinedButtonThemeData() {
    int id = factories.outlinedButtonThemeDataOutlinedButtonThemeData();
    if (id <= 0) throw new RuntimeException("Failed to created widget OutlinedButtonThemeData");
    return new OutlinedButtonThemeData(id);
  }
  public static OutlinedButtonThemeDataOutlinedButtonThemeDataBuilder outlinedButtonThemeData() {
    return OutlinedButtonThemeDataOutlinedButtonThemeDataBuilder.outlinedButtonThemeDataOutlinedButtonThemeData();
  }
  public static OutlinedButtonThemeData lerp(OutlinedButtonThemeDataI a, OutlinedButtonThemeDataI b, double t) {
    int id = factories.outlinedButtonThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget OutlinedButtonThemeData");
    return new OutlinedButtonThemeData(id);
  }
  @Override
  public OutlinedButtonThemeData build() {
    return this;
  }
}
