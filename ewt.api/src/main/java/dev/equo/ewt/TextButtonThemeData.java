package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TextButtonThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TextButtonThemeData extends NativeObj.Base implements TextButtonThemeDataI {
  private MemorySegment st;
  protected TextButtonThemeData() {}
  TextButtonThemeData(MemorySegment st) {
    this.id = TextButtonThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TextButtonThemeData");
    System.out.println("New TextButtonThemeData id:"+id);
  }
  TextButtonThemeData(int id) { this.id = id; }
  @Builder.Factory
  static TextButtonThemeData textButtonThemeDataTextButtonThemeData() {
    var st = factories.textButtonThemeDataTextButtonThemeData();
    if (st == null) throw new RuntimeException("Failed to created widget TextButtonThemeData");
    return new TextButtonThemeData(st);
  }
  public static TextButtonThemeDataTextButtonThemeDataBuilder textButtonThemeData() {
    return TextButtonThemeDataTextButtonThemeDataBuilder.textButtonThemeDataTextButtonThemeData();
  }
  public static TextButtonThemeData lerp(TextButtonThemeDataI a, TextButtonThemeDataI b, double t) {
    var st = factories.textButtonThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget TextButtonThemeData");
    return new TextButtonThemeData(st);
  }
  @Override
  public TextButtonThemeData build() {
    return this;
  }
}
