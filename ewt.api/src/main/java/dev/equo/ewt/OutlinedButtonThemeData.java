package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.OutlinedButtonThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class OutlinedButtonThemeData extends NativeObj.Base implements OutlinedButtonThemeDataI {
  private MemorySegment st;
  protected OutlinedButtonThemeData() {}
  OutlinedButtonThemeData(MemorySegment st) {
    this.id = OutlinedButtonThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget OutlinedButtonThemeData");
    System.out.println("New OutlinedButtonThemeData id:"+id);
  }
  OutlinedButtonThemeData(int id) { this.id = id; }
  @Builder.Factory
  static OutlinedButtonThemeData outlinedButtonThemeDataOutlinedButtonThemeData() {
    var st = factories.outlinedButtonThemeDataOutlinedButtonThemeData();
    if (st == null) throw new RuntimeException("Failed to created widget OutlinedButtonThemeData");
    return new OutlinedButtonThemeData(st);
  }
  public static OutlinedButtonThemeDataOutlinedButtonThemeDataBuilder outlinedButtonThemeData() {
    return OutlinedButtonThemeDataOutlinedButtonThemeDataBuilder.outlinedButtonThemeDataOutlinedButtonThemeData();
  }
  public static OutlinedButtonThemeData lerp(OutlinedButtonThemeDataI a, OutlinedButtonThemeDataI b, double t) {
    var st = factories.outlinedButtonThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget OutlinedButtonThemeData");
    return new OutlinedButtonThemeData(st);
  }
  @Override
  public OutlinedButtonThemeData build() {
    return this;
  }
}
