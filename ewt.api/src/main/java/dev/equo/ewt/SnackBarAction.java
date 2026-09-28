package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SnackBarAction extends StatefulWidget implements SnackBarActionI {
  protected SnackBarAction() {}
  SnackBarAction(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SnackBarAction");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SnackBarAction snackBarActionSnackBarAction(Optional<ColorI> textColor, Optional<ColorI> disabledTextColor, Optional<ColorI> backgroundColor, Optional<ColorI> disabledBackgroundColor, String label, Runnable onPressed) {
    int id = factories.snackBarActionSnackBarAction(textColor.map(ColorI::build),
      disabledTextColor.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      disabledBackgroundColor.map(ColorI::build),
      label,
      onPressed);
    if (id <= 0) throw new RuntimeException("Failed to created widget SnackBarAction");
    return new SnackBarAction(id);
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
    return factories.SnackBarAction_readBack_textColor(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarActionBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.SnackBarAction_readBack_backgroundColor(nativeStruct);
  }
  public Color disabledTextColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarActionDisabledTextColor", getId());
      return new Color(__nid);
    }
    return factories.SnackBarAction_readBack_disabledTextColor(nativeStruct);
  }
  public Color disabledBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarActionDisabledBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.SnackBarAction_readBack_disabledBackgroundColor(nativeStruct);
  }
  public String label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarActionLabel not supported on web");
    return factories.SnackBarAction_readBack_label(nativeStruct);
  }
  @Override
  public SnackBarAction build() {
    return this;
  }
}
