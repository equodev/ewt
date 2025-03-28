package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.IconDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class IconData extends NativeObj.Base {
  private MemorySegment st;
  IconData(MemorySegment st) {
    this.id = IconDataObjSt.id(st);
    this.st = st;
    System.out.println("New IconData id:"+id);
  }
  @Builder.Factory
  static IconData iconDataIconData(@Builder.Parameter int codePoint, Optional<String> fontFamily, Optional<String> fontPackage, Optional<Boolean> matchTextDirection, Optional<List<String>> fontFamilyFallback) {
    var st = factories.iconDataIconData(codePoint,
      fontFamily,
      fontPackage,
      matchTextDirection,
      fontFamilyFallback);
    if (st == null) throw new RuntimeException("Failed to created widget IconData");
    return new IconData(st);
  }
  public static IconDataIconDataBuilder iconData(int codePoint) {
    return IconDataIconDataBuilder.iconDataIconData(codePoint);
  }
  public int codePoint() {
    int fld = IconDataObjSt.codePoint(st);
    return fld;
  }
  public String fontFamily() {
    String fld = IconDataObjSt.fontFamily(st).getString(0);
    return fld;
  }
  public String fontPackage() {
    String fld = IconDataObjSt.fontPackage(st).getString(0);
    return fld;
  }
  public boolean matchTextDirection() {
    boolean fld = intToBool(IconDataObjSt.matchTextDirection(st));
    return fld;
  }
  public List<String> fontFamilyFallback() {
    List<String> fld = memToStrList(IconDataObjSt.fontFamilyFallback(st));
    return fld;
  }
}
