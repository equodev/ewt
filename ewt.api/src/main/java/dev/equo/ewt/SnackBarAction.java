package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SnackBarActionObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SnackBarAction extends StatefulWidget implements SnackBarActionI {
  private MemorySegment st;
  protected SnackBarAction() {}
  SnackBarAction(MemorySegment st) {
    this.id = SnackBarActionObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SnackBarAction");
    System.out.println("New SnackBarAction id:"+id);
  }
  SnackBarAction(int id) { this.id = id; }
  @Builder.Factory
  static SnackBarAction snackBarActionSnackBarAction(Optional<ColorI> textColor, Optional<ColorI> disabledTextColor, Optional<ColorI> backgroundColor, Optional<ColorI> disabledBackgroundColor, String label, Runnable onPressed) {
    var st = factories.snackBarActionSnackBarAction(textColor.map(ColorI::build),
      disabledTextColor.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      disabledBackgroundColor.map(ColorI::build),
      label,
      onPressed);
    if (st == null) throw new RuntimeException("Failed to created widget SnackBarAction");
    return new SnackBarAction(st);
  }
  public static SnackBarActionSnackBarActionBuilder snackBarAction() {
    return SnackBarActionSnackBarActionBuilder.snackBarActionSnackBarAction();
  }
  public Color textColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarActionTextColor", getId());
      return new Color(__nid);
    }
    return new Color(SnackBarActionObjSt.textColor(st));
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarActionBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(SnackBarActionObjSt.backgroundColor(st));
  }
  public Color disabledTextColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarActionDisabledTextColor", getId());
      return new Color(__nid);
    }
    return new Color(SnackBarActionObjSt.disabledTextColor(st));
  }
  public Color disabledBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarActionDisabledBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(SnackBarActionObjSt.disabledBackgroundColor(st));
  }
  public String label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarActionLabel not supported on web");
    return SnackBarActionObjSt.label(st).getString(0);
  }
  @Override
  public SnackBarAction build() {
    return this;
  }
}
