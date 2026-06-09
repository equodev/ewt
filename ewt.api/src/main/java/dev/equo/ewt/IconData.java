package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.IconDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class IconData extends NativeObj.Base implements IconDataI {
  private MemorySegment st;
  protected IconData() {}
  IconData(MemorySegment st) {
    this.id = IconDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget IconData");
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
    return IconDataObjSt.codePoint(st);
  }
  public String fontFamily() {
    return IconDataObjSt.fontFamily(st).getString(0);
  }
  public String fontPackage() {
    return IconDataObjSt.fontPackage(st).getString(0);
  }
  public boolean matchTextDirection() {
    return intToBool(IconDataObjSt.matchTextDirection(st));
  }
  @Override
  public IconData build() {
    return this;
  }
}
