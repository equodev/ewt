package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TextButtonThemeData extends NativeObj.Base implements TextButtonThemeDataI {
  protected TextButtonThemeData() {}
  TextButtonThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TextButtonThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TextButtonThemeData textButtonThemeDataTextButtonThemeData() {
    int id = factories.textButtonThemeDataTextButtonThemeData();
    if (id <= 0) throw new RuntimeException("Failed to created widget TextButtonThemeData");
    return new TextButtonThemeData(id);
  }
  public static TextButtonThemeDataTextButtonThemeDataBuilder textButtonThemeData() {
    return TextButtonThemeDataTextButtonThemeDataBuilder.textButtonThemeDataTextButtonThemeData();
  }
  public static TextButtonThemeData lerp(TextButtonThemeDataI a, TextButtonThemeDataI b, double t) {
    int id = factories.textButtonThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget TextButtonThemeData");
    return new TextButtonThemeData(id);
  }
  @Override
  public TextButtonThemeData build() {
    return this;
  }
}
