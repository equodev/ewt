package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class MaterialAccentColor extends ColorSwatch<Integer> implements MaterialAccentColorI {
  protected MaterialAccentColor() {}
  MaterialAccentColor(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget MaterialAccentColor");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static MaterialAccentColor materialAccentColorMaterialAccentColor(@Builder.Parameter int primary, @Builder.Parameter Map<Integer, Color> swatch) {
    int id = factories.materialAccentColorMaterialAccentColor(primary,
      swatch);
    if (id <= 0) throw new RuntimeException("Failed to created widget MaterialAccentColor");
    return new MaterialAccentColor(id);
  }
  public static MaterialAccentColorMaterialAccentColorBuilder materialAccentColor(int primary, Map<Integer, Color> swatch) {
    return MaterialAccentColorMaterialAccentColorBuilder.materialAccentColorMaterialAccentColor(primary, swatch);
  }
  public Color shade100() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialAccentColorShade100", getId());
      return new Color(__nid);
    }
    return factories.MaterialAccentColor_readBack_shade100(nativeStruct);
  }
  public Color shade200() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialAccentColorShade200", getId());
      return new Color(__nid);
    }
    return factories.MaterialAccentColor_readBack_shade200(nativeStruct);
  }
  public Color shade400() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialAccentColorShade400", getId());
      return new Color(__nid);
    }
    return factories.MaterialAccentColor_readBack_shade400(nativeStruct);
  }
  public Color shade700() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialAccentColorShade700", getId());
      return new Color(__nid);
    }
    return factories.MaterialAccentColor_readBack_shade700(nativeStruct);
  }
  @Override
  public MaterialAccentColor build() {
    return this;
  }
}
