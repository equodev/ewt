package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MaterialAccentColorObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MaterialAccentColor extends ColorSwatch<Integer> implements MaterialAccentColorI {
  private MemorySegment st;
  protected MaterialAccentColor() {}
  MaterialAccentColor(MemorySegment st) {
    this.id = MaterialAccentColorObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MaterialAccentColor");
    System.out.println("New MaterialAccentColor id:"+id);
  }
  MaterialAccentColor(int id) { this.id = id; }
  @Builder.Factory
  static MaterialAccentColor materialAccentColorMaterialAccentColor(@Builder.Parameter int primary, @Builder.Parameter Map<Integer, Color> swatch) {
    var st = factories.materialAccentColorMaterialAccentColor(primary,
      swatch);
    if (st == null) throw new RuntimeException("Failed to created widget MaterialAccentColor");
    return new MaterialAccentColor(st);
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
    return new Color(MaterialAccentColorObjSt.shade100(st));
  }
  public Color shade200() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialAccentColorShade200", getId());
      return new Color(__nid);
    }
    return new Color(MaterialAccentColorObjSt.shade200(st));
  }
  public Color shade400() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialAccentColorShade400", getId());
      return new Color(__nid);
    }
    return new Color(MaterialAccentColorObjSt.shade400(st));
  }
  public Color shade700() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialAccentColorShade700", getId());
      return new Color(__nid);
    }
    return new Color(MaterialAccentColorObjSt.shade700(st));
  }
  @Override
  public MaterialAccentColor build() {
    return this;
  }
}
