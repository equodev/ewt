package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoCheckboxObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoCheckbox extends StatefulWidget implements CupertinoCheckboxI {
  private MemorySegment st;
  protected CupertinoCheckbox() {}
  CupertinoCheckbox(MemorySegment st) {
    this.id = CupertinoCheckboxObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoCheckbox");
    System.out.println("New CupertinoCheckbox id:"+id);
  }
  CupertinoCheckbox(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoCheckbox cupertinoCheckboxCupertinoCheckbox(@Builder.Parameter boolean value, Optional<Boolean> tristate, Consumer<Boolean> onChanged, Optional<ColorI> activeColor, Optional<ColorI> inactiveColor, Optional<ColorI> checkColor, Optional<ColorI> focusColor, Optional<Boolean> autofocus, Optional<BorderSideI> side, Optional<OutlinedBorderI> shape, Optional<String> semanticLabel) {
    var st = factories.cupertinoCheckboxCupertinoCheckbox(value,
      tristate,
      onChanged,
      activeColor.map(ColorI::build),
      inactiveColor.map(ColorI::build),
      checkColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      autofocus,
      side.map(BorderSideI::build),
      shape.map(OutlinedBorderI::build),
      semanticLabel);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoCheckbox");
    return new CupertinoCheckbox(st);
  }
  public static CupertinoCheckboxCupertinoCheckboxBuilder cupertinoCheckbox(boolean value) {
    return CupertinoCheckboxCupertinoCheckboxBuilder.cupertinoCheckboxCupertinoCheckbox(value);
  }
  public boolean value() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoCheckboxValue not supported on web");
    return intToBool(CupertinoCheckboxObjSt.value(st));
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoCheckboxActiveColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoCheckboxObjSt.activeColor(st));
  }
  public Color inactiveColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoCheckboxInactiveColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoCheckboxObjSt.inactiveColor(st));
  }
  public Color checkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoCheckboxCheckColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoCheckboxObjSt.checkColor(st));
  }
  public boolean tristate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoCheckboxTristate not supported on web");
    return intToBool(CupertinoCheckboxObjSt.tristate(st));
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoCheckboxFocusColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoCheckboxObjSt.focusColor(st));
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoCheckboxAutofocus not supported on web");
    return intToBool(CupertinoCheckboxObjSt.autofocus(st));
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoCheckboxSide", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderSideObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderSideObjSt.id(__st, __nid);
      return new BorderSide(__st);
    }
    return new BorderSide(CupertinoCheckboxObjSt.side(st));
  }
  public OutlinedBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoCheckboxShape not supported on web");
    return new OutlinedBorder(CupertinoCheckboxObjSt.shape(st)) {};
  }
  public String semanticLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoCheckboxSemanticLabel not supported on web");
    return CupertinoCheckboxObjSt.semanticLabel(st).getString(0);
  }
  public static double width() {
    return 14.0;
  }
  @Override
  public CupertinoCheckbox build() {
    return this;
  }
}
