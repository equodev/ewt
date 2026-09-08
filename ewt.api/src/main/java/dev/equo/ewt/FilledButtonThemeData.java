package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FilledButtonThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class FilledButtonThemeData extends NativeObj.Base implements FilledButtonThemeDataI {
  private MemorySegment st;
  protected FilledButtonThemeData() {}
  FilledButtonThemeData(MemorySegment st) {
    this.id = FilledButtonThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget FilledButtonThemeData");
    System.out.println("New FilledButtonThemeData id:"+id);
  }
  FilledButtonThemeData(int id) { this.id = id; }
  @Builder.Factory
  static FilledButtonThemeData filledButtonThemeDataFilledButtonThemeData() {
    var st = factories.filledButtonThemeDataFilledButtonThemeData();
    if (st == null) throw new RuntimeException("Failed to created widget FilledButtonThemeData");
    return new FilledButtonThemeData(st);
  }
  public static FilledButtonThemeDataFilledButtonThemeDataBuilder filledButtonThemeData() {
    return FilledButtonThemeDataFilledButtonThemeDataBuilder.filledButtonThemeDataFilledButtonThemeData();
  }
  public static FilledButtonThemeData lerp(FilledButtonThemeDataI a, FilledButtonThemeDataI b, double t) {
    var st = factories.filledButtonThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget FilledButtonThemeData");
    return new FilledButtonThemeData(st);
  }
  @Override
  public FilledButtonThemeData build() {
    return this;
  }
}
