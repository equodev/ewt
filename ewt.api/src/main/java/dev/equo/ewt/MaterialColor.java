package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MaterialColorObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MaterialColor extends ColorSwatch<Integer> implements MaterialColorI {
  private MemorySegment st;
  protected MaterialColor() {}
  MaterialColor(MemorySegment st) {
    this.id = MaterialColorObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MaterialColor");
    System.out.println("New MaterialColor id:"+id);
  }
  @Builder.Factory
  static MaterialColor materialColorMaterialColor(@Builder.Parameter int primary, @Builder.Parameter Map<Integer, Color> swatch) {
    var st = factories.materialColorMaterialColor(primary,
      swatch);
    if (st == null) throw new RuntimeException("Failed to created widget MaterialColor");
    return new MaterialColor(st);
  }
  public static MaterialColorMaterialColorBuilder materialColor(int primary, Map<Integer, Color> swatch) {
    return MaterialColorMaterialColorBuilder.materialColorMaterialColor(primary, swatch);
  }
  public Color shade50() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialColorShade50", getId());
      return new Color(__nid);
    }
    return new Color(MaterialColorObjSt.shade50(st));
  }
  public Color shade100() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialColorShade100", getId());
      return new Color(__nid);
    }
    return new Color(MaterialColorObjSt.shade100(st));
  }
  public Color shade200() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialColorShade200", getId());
      return new Color(__nid);
    }
    return new Color(MaterialColorObjSt.shade200(st));
  }
  public Color shade300() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialColorShade300", getId());
      return new Color(__nid);
    }
    return new Color(MaterialColorObjSt.shade300(st));
  }
  public Color shade400() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialColorShade400", getId());
      return new Color(__nid);
    }
    return new Color(MaterialColorObjSt.shade400(st));
  }
  public Color shade500() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialColorShade500", getId());
      return new Color(__nid);
    }
    return new Color(MaterialColorObjSt.shade500(st));
  }
  public Color shade600() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialColorShade600", getId());
      return new Color(__nid);
    }
    return new Color(MaterialColorObjSt.shade600(st));
  }
  public Color shade700() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialColorShade700", getId());
      return new Color(__nid);
    }
    return new Color(MaterialColorObjSt.shade700(st));
  }
  public Color shade800() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialColorShade800", getId());
      return new Color(__nid);
    }
    return new Color(MaterialColorObjSt.shade800(st));
  }
  public Color shade900() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialColorShade900", getId());
      return new Color(__nid);
    }
    return new Color(MaterialColorObjSt.shade900(st));
  }
  @Override
  public MaterialColor build() {
    return this;
  }
}
