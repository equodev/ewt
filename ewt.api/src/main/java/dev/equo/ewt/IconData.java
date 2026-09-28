package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class IconData extends NativeObj.Base implements IconDataI {
  protected IconData() {}
  IconData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget IconData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static IconData iconDataIconData(@Builder.Parameter int codePoint, Optional<String> fontFamily, Optional<String> fontPackage, Optional<Boolean> matchTextDirection, Optional<List<String>> fontFamilyFallback) {
    int id = factories.iconDataIconData(codePoint,
      fontFamily,
      fontPackage,
      matchTextDirection,
      fontFamilyFallback);
    if (id <= 0) throw new RuntimeException("Failed to created widget IconData");
    return new IconData(id);
  }
  public static IconDataIconDataBuilder iconData(int codePoint) {
    return IconDataIconDataBuilder.iconDataIconData(codePoint);
  }
  public int codePoint() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconDataCodePoint not supported on web");
    return factories.IconData_readBack_codePoint(nativeStruct);
  }
  public String fontFamily() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconDataFontFamily not supported on web");
    return factories.IconData_readBack_fontFamily(nativeStruct);
  }
  public String fontPackage() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconDataFontPackage not supported on web");
    return factories.IconData_readBack_fontPackage(nativeStruct);
  }
  public boolean matchTextDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("iconDataMatchTextDirection not supported on web");
    return factories.IconData_readBack_matchTextDirection(nativeStruct);
  }
  @Override
  public IconData build() {
    return this;
  }
}
