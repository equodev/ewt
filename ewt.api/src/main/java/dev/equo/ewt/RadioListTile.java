package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RadioListTileObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class RadioListTile<T> extends StatefulWidget implements RadioListTileI {
  private MemorySegment st;
  protected RadioListTile() {}
  RadioListTile(MemorySegment st) {
    this.id = RadioListTileObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget RadioListTile");
    System.out.println("New RadioListTile id:"+id);
  }
  RadioListTile(int id) { this.id = id; }
  @Builder.Factory
  static <T extends NativeObj> RadioListTile<T> radioListTileRadioListTile(@Builder.Parameter NativeObj value, Optional<NativeObj> groupValue, Optional<Consumer<NativeObj>> onChanged, Optional<Boolean> toggleable, Optional<ColorI> activeColor, Optional<ColorI> fillColor, Optional<ColorI> hoverColor, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<WidgetI> title, Optional<WidgetI> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<WidgetI> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<Boolean> autofocus, Optional<EdgeInsetsGeometryI> contentPadding, Optional<ShapeBorderI> shape, Optional<ColorI> tileColor, Optional<ColorI> selectedTileColor, Optional<VisualDensityI> visualDensity, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> enableFeedback, OptionalDouble radioScaleFactor, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> enabled, Optional<Boolean> internalAddSemanticForOnTap, Optional<ColorI> radioBackgroundColor, Optional<BorderSideI> radioSide) {
    var st = factories.radioListTileRadioListTile(value,
      groupValue,
      onChanged,
      toggleable,
      activeColor.map(ColorI::build),
      fillColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      splashRadius,
      materialTapTargetSize,
      title.map(WidgetI::build),
      subtitle.map(WidgetI::build),
      isThreeLine,
      dense,
      secondary.map(WidgetI::build),
      selected,
      controlAffinity,
      autofocus,
      contentPadding.map(EdgeInsetsGeometryI::build),
      shape.map(ShapeBorderI::build),
      tileColor.map(ColorI::build),
      selectedTileColor.map(ColorI::build),
      visualDensity.map(VisualDensityI::build),
      onFocusChange,
      enableFeedback,
      radioScaleFactor,
      titleAlignment,
      enabled,
      internalAddSemanticForOnTap,
      radioBackgroundColor.map(ColorI::build),
      radioSide.map(BorderSideI::build));
    if (st == null) throw new RuntimeException("Failed to created widget RadioListTile");
    return new RadioListTile(st);
  }
  public static <T extends NativeObj> RadioListTileRadioListTileBuilder<T> radioListTile(NativeObj value) {
    return RadioListTileRadioListTileBuilder.radioListTileRadioListTile(value);
  }
  @Builder.Factory
  static <T extends NativeObj> RadioListTile<T> radioListTileAdaptive(@Builder.Parameter NativeObj value, Optional<NativeObj> groupValue, Optional<Consumer<NativeObj>> onChanged, Optional<Boolean> toggleable, Optional<ColorI> activeColor, Optional<ColorI> fillColor, Optional<ColorI> hoverColor, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<WidgetI> title, Optional<WidgetI> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<WidgetI> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<Boolean> autofocus, Optional<EdgeInsetsGeometryI> contentPadding, Optional<ShapeBorderI> shape, Optional<ColorI> tileColor, Optional<ColorI> selectedTileColor, Optional<VisualDensityI> visualDensity, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> enableFeedback, OptionalDouble radioScaleFactor, Optional<Boolean> enabled, Optional<Boolean> useCupertinoCheckmarkStyle, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> internalAddSemanticForOnTap, Optional<ColorI> radioBackgroundColor, Optional<BorderSideI> radioSide) {
    var st = factories.radioListTileAdaptive(value,
      groupValue,
      onChanged,
      toggleable,
      activeColor.map(ColorI::build),
      fillColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      splashRadius,
      materialTapTargetSize,
      title.map(WidgetI::build),
      subtitle.map(WidgetI::build),
      isThreeLine,
      dense,
      secondary.map(WidgetI::build),
      selected,
      controlAffinity,
      autofocus,
      contentPadding.map(EdgeInsetsGeometryI::build),
      shape.map(ShapeBorderI::build),
      tileColor.map(ColorI::build),
      selectedTileColor.map(ColorI::build),
      visualDensity.map(VisualDensityI::build),
      onFocusChange,
      enableFeedback,
      radioScaleFactor,
      enabled,
      useCupertinoCheckmarkStyle,
      titleAlignment,
      internalAddSemanticForOnTap,
      radioBackgroundColor.map(ColorI::build),
      radioSide.map(BorderSideI::build));
    if (st == null) throw new RuntimeException("Failed to created widget RadioListTile");
    return new RadioListTile(st);
  }
  public static <T extends NativeObj> RadioListTileAdaptiveBuilder<T> adaptive(NativeObj value) {
    return RadioListTileAdaptiveBuilder.radioListTileAdaptive(value);
  }
  public boolean toggleable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileToggleable not supported on web");
    return intToBool(RadioListTileObjSt.toggleable(st));
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioListTileActiveColor", getId());
      return new Color(__nid);
    }
    return new Color(RadioListTileObjSt.activeColor(st));
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileMaterialTapTargetSize not supported on web");
    return MaterialTapTargetSize.values()[RadioListTileObjSt.materialTapTargetSize(st)];
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioListTileHoverColor", getId());
      return new Color(__nid);
    }
    return new Color(RadioListTileObjSt.hoverColor(st));
  }
  public double splashRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileSplashRadius not supported on web");
    return RadioListTileObjSt.splashRadius(st);
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileTitle not supported on web");
    return new Widget(RadioListTileObjSt.title(st)) {};
  }
  public Widget subtitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileSubtitle not supported on web");
    return new Widget(RadioListTileObjSt.subtitle(st)) {};
  }
  public Widget secondary() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileSecondary not supported on web");
    return new Widget(RadioListTileObjSt.secondary(st)) {};
  }
  public boolean isThreeLine() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileIsThreeLine not supported on web");
    return intToBool(RadioListTileObjSt.isThreeLine(st));
  }
  public boolean dense() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileDense not supported on web");
    return intToBool(RadioListTileObjSt.dense(st));
  }
  public boolean selected() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileSelected not supported on web");
    return intToBool(RadioListTileObjSt.selected(st));
  }
  public ListTileControlAffinity controlAffinity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileControlAffinity not supported on web");
    return ListTileControlAffinity.values()[RadioListTileObjSt.controlAffinity(st)];
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileAutofocus not supported on web");
    return intToBool(RadioListTileObjSt.autofocus(st));
  }
  public EdgeInsetsGeometry contentPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileContentPadding not supported on web");
    return new EdgeInsetsGeometry(RadioListTileObjSt.contentPadding(st)) {};
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileShape not supported on web");
    return new ShapeBorder(RadioListTileObjSt.shape(st)) {};
  }
  public Color tileColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioListTileTileColor", getId());
      return new Color(__nid);
    }
    return new Color(RadioListTileObjSt.tileColor(st));
  }
  public Color selectedTileColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioListTileSelectedTileColor", getId());
      return new Color(__nid);
    }
    return new Color(RadioListTileObjSt.selectedTileColor(st));
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioListTileVisualDensity", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.VisualDensityObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.VisualDensityObjSt.id(__st, __nid);
      return new VisualDensity(__st);
    }
    return new VisualDensity(RadioListTileObjSt.visualDensity(st));
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileEnableFeedback not supported on web");
    return intToBool(RadioListTileObjSt.enableFeedback(st));
  }
  public ListTileTitleAlignment titleAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileTitleAlignment not supported on web");
    return ListTileTitleAlignment.values()[RadioListTileObjSt.titleAlignment(st)];
  }
  public boolean internalAddSemanticForOnTap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileInternalAddSemanticForOnTap not supported on web");
    return intToBool(RadioListTileObjSt.internalAddSemanticForOnTap(st));
  }
  public boolean useCupertinoCheckmarkStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileUseCupertinoCheckmarkStyle not supported on web");
    return intToBool(RadioListTileObjSt.useCupertinoCheckmarkStyle(st));
  }
  public double radioScaleFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileRadioScaleFactor not supported on web");
    return RadioListTileObjSt.radioScaleFactor(st);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileEnabled not supported on web");
    return intToBool(RadioListTileObjSt.enabled(st));
  }
  public BorderSide radioSide() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioListTileRadioSide", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderSideObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderSideObjSt.id(__st, __nid);
      return new BorderSide(__st);
    }
    return new BorderSide(RadioListTileObjSt.radioSide(st));
  }
  public boolean checked() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("radioListTileChecked not supported on web");
    return intToBool(RadioListTileObjSt.checked(st));
  }
  @Override
  public RadioListTile build() {
    return this;
  }
}
