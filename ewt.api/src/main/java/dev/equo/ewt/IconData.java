package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
public class IconData extends NativeObj.Base {
  IconData() {}
  IconData(int id) {
    this.id = id;
  }
  @Builder.Factory
  static IconData iconDataIconData(@Builder.Parameter int codePoint, Optional<String> fontFamily, Optional<String> fontPackage, Optional<Boolean> matchTextDirection, Optional<List<String>> fontFamilyFallback) {
    int id = factories.iconDataIconData(codePoint,
      fontFamily,
      fontPackage,
      matchTextDirection,
      fontFamilyFallback);
    if (id == -1) throw new RuntimeException("Failed to created widget IconData");
    System.out.println("New IconData id:"+id);
    return new IconData(id);
  }
  public static IconDataIconDataBuilder iconData(int codePoint) {
    return IconDataIconDataBuilder.iconDataIconData(codePoint);
  }
}
