package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ElevatedButtonThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ElevatedButtonThemeData extends NativeObj.Base implements ElevatedButtonThemeDataI {
  private MemorySegment st;
  protected ElevatedButtonThemeData() {}
  ElevatedButtonThemeData(MemorySegment st) {
    this.id = ElevatedButtonThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ElevatedButtonThemeData");
    System.out.println("New ElevatedButtonThemeData id:"+id);
  }
  ElevatedButtonThemeData(int id) { this.id = id; }
  @Builder.Factory
  static ElevatedButtonThemeData elevatedButtonThemeDataElevatedButtonThemeData() {
    var st = factories.elevatedButtonThemeDataElevatedButtonThemeData();
    if (st == null) throw new RuntimeException("Failed to created widget ElevatedButtonThemeData");
    return new ElevatedButtonThemeData(st);
  }
  public static ElevatedButtonThemeDataElevatedButtonThemeDataBuilder elevatedButtonThemeData() {
    return ElevatedButtonThemeDataElevatedButtonThemeDataBuilder.elevatedButtonThemeDataElevatedButtonThemeData();
  }
  public static ElevatedButtonThemeData lerp(ElevatedButtonThemeDataI a, ElevatedButtonThemeDataI b, double t) {
    var st = factories.elevatedButtonThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget ElevatedButtonThemeData");
    return new ElevatedButtonThemeData(st);
  }
  @Override
  public ElevatedButtonThemeData build() {
    return this;
  }
}
