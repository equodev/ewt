package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CheckboxListTileObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CheckboxListTile extends StatelessWidget implements CheckboxListTileI {
  private MemorySegment st;
  protected CheckboxListTile() {}
  CheckboxListTile(MemorySegment st) {
    this.id = CheckboxListTileObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CheckboxListTile");
    System.out.println("New CheckboxListTile id:"+id);
  }
  CheckboxListTile(int id) { this.id = id; }
  @Builder.Factory
  static CheckboxListTile checkboxListTileCheckboxListTile(Optional<Boolean> value, Optional<Consumer<Boolean>> onChanged, Optional<ColorI> activeColor, Optional<ColorI> fillColor, Optional<ColorI> checkColor, Optional<ColorI> hoverColor, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensityI> visualDensity, Optional<Boolean> autofocus, Optional<ShapeBorderI> shape, Optional<BorderSideI> side, Optional<Boolean> isError, Optional<Boolean> enabled, Optional<ColorI> tileColor, Optional<WidgetI> title, Optional<WidgetI> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<WidgetI> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<EdgeInsetsGeometryI> contentPadding, Optional<Boolean> tristate, Optional<OutlinedBorderI> checkboxShape, Optional<ColorI> selectedTileColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> enableFeedback, Optional<String> checkboxSemanticLabel, OptionalDouble checkboxScaleFactor, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> internalAddSemanticForOnTap) {
    var st = factories.checkboxListTileCheckboxListTile(value,
      onChanged,
      activeColor.map(ColorI::build),
      fillColor.map(ColorI::build),
      checkColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      splashRadius,
      materialTapTargetSize,
      visualDensity.map(VisualDensityI::build),
      autofocus,
      shape.map(ShapeBorderI::build),
      side.map(BorderSideI::build),
      isError,
      enabled,
      tileColor.map(ColorI::build),
      title.map(WidgetI::build),
      subtitle.map(WidgetI::build),
      isThreeLine,
      dense,
      secondary.map(WidgetI::build),
      selected,
      controlAffinity,
      contentPadding.map(EdgeInsetsGeometryI::build),
      tristate,
      checkboxShape.map(OutlinedBorderI::build),
      selectedTileColor.map(ColorI::build),
      onFocusChange,
      enableFeedback,
      checkboxSemanticLabel,
      checkboxScaleFactor,
      titleAlignment,
      internalAddSemanticForOnTap);
    if (st == null) throw new RuntimeException("Failed to created widget CheckboxListTile");
    return new CheckboxListTile(st);
  }
  public static CheckboxListTileCheckboxListTileBuilder checkboxListTile() {
    return CheckboxListTileCheckboxListTileBuilder.checkboxListTileCheckboxListTile();
  }
  @Builder.Factory
  static CheckboxListTile checkboxListTileAdaptive(Optional<Boolean> value, Optional<Consumer<Boolean>> onChanged, Optional<ColorI> activeColor, Optional<ColorI> fillColor, Optional<ColorI> checkColor, Optional<ColorI> hoverColor, Optional<ColorI> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensityI> visualDensity, Optional<Boolean> autofocus, Optional<ShapeBorderI> shape, Optional<BorderSideI> side, Optional<Boolean> isError, Optional<Boolean> enabled, Optional<ColorI> tileColor, Optional<WidgetI> title, Optional<WidgetI> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<WidgetI> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<EdgeInsetsGeometryI> contentPadding, Optional<Boolean> tristate, Optional<OutlinedBorderI> checkboxShape, Optional<ColorI> selectedTileColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> enableFeedback, Optional<String> checkboxSemanticLabel, OptionalDouble checkboxScaleFactor, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> internalAddSemanticForOnTap) {
    var st = factories.checkboxListTileAdaptive(value,
      onChanged,
      activeColor.map(ColorI::build),
      fillColor.map(ColorI::build),
      checkColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      splashRadius,
      materialTapTargetSize,
      visualDensity.map(VisualDensityI::build),
      autofocus,
      shape.map(ShapeBorderI::build),
      side.map(BorderSideI::build),
      isError,
      enabled,
      tileColor.map(ColorI::build),
      title.map(WidgetI::build),
      subtitle.map(WidgetI::build),
      isThreeLine,
      dense,
      secondary.map(WidgetI::build),
      selected,
      controlAffinity,
      contentPadding.map(EdgeInsetsGeometryI::build),
      tristate,
      checkboxShape.map(OutlinedBorderI::build),
      selectedTileColor.map(ColorI::build),
      onFocusChange,
      enableFeedback,
      checkboxSemanticLabel,
      checkboxScaleFactor,
      titleAlignment,
      internalAddSemanticForOnTap);
    if (st == null) throw new RuntimeException("Failed to created widget CheckboxListTile");
    return new CheckboxListTile(st);
  }
  public static CheckboxListTileAdaptiveBuilder adaptive() {
    return CheckboxListTileAdaptiveBuilder.checkboxListTileAdaptive();
  }
  public boolean value() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileValue not supported on web");
    return intToBool(CheckboxListTileObjSt.value(st));
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxListTileActiveColor", getId());
      return new Color(__nid);
    }
    return new Color(CheckboxListTileObjSt.activeColor(st));
  }
  public Color checkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxListTileCheckColor", getId());
      return new Color(__nid);
    }
    return new Color(CheckboxListTileObjSt.checkColor(st));
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxListTileHoverColor", getId());
      return new Color(__nid);
    }
    return new Color(CheckboxListTileObjSt.hoverColor(st));
  }
  public double splashRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileSplashRadius not supported on web");
    return CheckboxListTileObjSt.splashRadius(st);
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileMaterialTapTargetSize not supported on web");
    return MaterialTapTargetSize.values()[CheckboxListTileObjSt.materialTapTargetSize(st)];
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxListTileVisualDensity", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.VisualDensityObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.VisualDensityObjSt.id(__st, __nid);
      return new VisualDensity(__st);
    }
    return new VisualDensity(CheckboxListTileObjSt.visualDensity(st));
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileAutofocus not supported on web");
    return intToBool(CheckboxListTileObjSt.autofocus(st));
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileShape not supported on web");
    return new ShapeBorder(CheckboxListTileObjSt.shape(st)) {};
  }
  public BorderSide side() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxListTileSide", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderSideObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderSideObjSt.id(__st, __nid);
      return new BorderSide(__st);
    }
    return new BorderSide(CheckboxListTileObjSt.side(st));
  }
  public boolean isError() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileIsError not supported on web");
    return intToBool(CheckboxListTileObjSt.isError(st));
  }
  public Color tileColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxListTileTileColor", getId());
      return new Color(__nid);
    }
    return new Color(CheckboxListTileObjSt.tileColor(st));
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileTitle not supported on web");
    return new Widget(CheckboxListTileObjSt.title(st)) {};
  }
  public Widget subtitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileSubtitle not supported on web");
    return new Widget(CheckboxListTileObjSt.subtitle(st)) {};
  }
  public Widget secondary() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileSecondary not supported on web");
    return new Widget(CheckboxListTileObjSt.secondary(st)) {};
  }
  public boolean isThreeLine() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileIsThreeLine not supported on web");
    return intToBool(CheckboxListTileObjSt.isThreeLine(st));
  }
  public boolean dense() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileDense not supported on web");
    return intToBool(CheckboxListTileObjSt.dense(st));
  }
  public boolean selected() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileSelected not supported on web");
    return intToBool(CheckboxListTileObjSt.selected(st));
  }
  public ListTileControlAffinity controlAffinity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileControlAffinity not supported on web");
    return ListTileControlAffinity.values()[CheckboxListTileObjSt.controlAffinity(st)];
  }
  public EdgeInsetsGeometry contentPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileContentPadding not supported on web");
    return new EdgeInsetsGeometry(CheckboxListTileObjSt.contentPadding(st)) {};
  }
  public boolean tristate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileTristate not supported on web");
    return intToBool(CheckboxListTileObjSt.tristate(st));
  }
  public OutlinedBorder checkboxShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileCheckboxShape not supported on web");
    return new OutlinedBorder(CheckboxListTileObjSt.checkboxShape(st)) {};
  }
  public Color selectedTileColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxListTileSelectedTileColor", getId());
      return new Color(__nid);
    }
    return new Color(CheckboxListTileObjSt.selectedTileColor(st));
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileEnableFeedback not supported on web");
    return intToBool(CheckboxListTileObjSt.enableFeedback(st));
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileEnabled not supported on web");
    return intToBool(CheckboxListTileObjSt.enabled(st));
  }
  public ListTileTitleAlignment titleAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileTitleAlignment not supported on web");
    return ListTileTitleAlignment.values()[CheckboxListTileObjSt.titleAlignment(st)];
  }
  public boolean internalAddSemanticForOnTap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileInternalAddSemanticForOnTap not supported on web");
    return intToBool(CheckboxListTileObjSt.internalAddSemanticForOnTap(st));
  }
  public double checkboxScaleFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileCheckboxScaleFactor not supported on web");
    return CheckboxListTileObjSt.checkboxScaleFactor(st);
  }
  public String checkboxSemanticLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkboxListTileCheckboxSemanticLabel not supported on web");
    return CheckboxListTileObjSt.checkboxSemanticLabel(st).getString(0);
  }
  @Override
  public CheckboxListTile build() {
    return this;
  }
}
