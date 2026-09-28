package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class FilledButtonThemeData extends NativeObj.Base implements FilledButtonThemeDataI {
  protected FilledButtonThemeData() {}
  FilledButtonThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget FilledButtonThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static FilledButtonThemeData filledButtonThemeDataFilledButtonThemeData() {
    int id = factories.filledButtonThemeDataFilledButtonThemeData();
    if (id <= 0) throw new RuntimeException("Failed to created widget FilledButtonThemeData");
    return new FilledButtonThemeData(id);
  }
  public static FilledButtonThemeDataFilledButtonThemeDataBuilder filledButtonThemeData() {
    return FilledButtonThemeDataFilledButtonThemeDataBuilder.filledButtonThemeDataFilledButtonThemeData();
  }
  public static FilledButtonThemeData lerp(FilledButtonThemeDataI a, FilledButtonThemeDataI b, double t) {
    int id = factories.filledButtonThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget FilledButtonThemeData");
    return new FilledButtonThemeData(id);
  }
  @Override
  public FilledButtonThemeData build() {
    return this;
  }
}
