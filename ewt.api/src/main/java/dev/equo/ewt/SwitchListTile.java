package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SwitchListTileObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SwitchListTile extends StatelessWidget implements SwitchListTileI {
  private MemorySegment st;
  protected SwitchListTile() {}
  SwitchListTile(MemorySegment st) {
    this.id = SwitchListTileObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SwitchListTile");
    System.out.println("New SwitchListTile id:"+id);
  }
  SwitchListTile(int id) { this.id = id; }
  @Builder.Factory
  static SwitchListTile switchListTileSwitchListTile(@Builder.Parameter boolean value, @Builder.Parameter Consumer<Boolean> onChanged, Optional<ColorI> activeColor, Optional<ColorI> activeThumbColor, Optional<ColorI> activeTrackColor, Optional<ColorI> inactiveThumbColor, Optional<ColorI> inactiveTrackColor, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<DragStartBehavior> dragStartBehavior, OptionalDouble splashRadius, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<ColorI> tileColor, Optional<WidgetI> title, Optional<WidgetI> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<EdgeInsetsGeometryI> contentPadding, Optional<WidgetI> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<ShapeBorderI> shape, Optional<ColorI> selectedTileColor, Optional<VisualDensityI> visualDensity, Optional<Boolean> enableFeedback, Optional<ColorI> hoverColor, Optional<Boolean> internalAddSemanticForOnTap) {
    var st = factories.switchListTileSwitchListTile(value,
      onChanged,
      activeColor.map(ColorI::build),
      activeThumbColor.map(ColorI::build),
      activeTrackColor.map(ColorI::build),
      inactiveThumbColor.map(ColorI::build),
      inactiveTrackColor.map(ColorI::build),
      materialTapTargetSize,
      dragStartBehavior,
      splashRadius,
      onFocusChange,
      autofocus,
      tileColor.map(ColorI::build),
      title.map(WidgetI::build),
      subtitle.map(WidgetI::build),
      isThreeLine,
      dense,
      contentPadding.map(EdgeInsetsGeometryI::build),
      secondary.map(WidgetI::build),
      selected,
      controlAffinity,
      shape.map(ShapeBorderI::build),
      selectedTileColor.map(ColorI::build),
      visualDensity.map(VisualDensityI::build),
      enableFeedback,
      hoverColor.map(ColorI::build),
      internalAddSemanticForOnTap);
    if (st == null) throw new RuntimeException("Failed to created widget SwitchListTile");
    return new SwitchListTile(st);
  }
  public static SwitchListTileSwitchListTileBuilder switchListTile(boolean value, Consumer<Boolean> onChanged) {
    return SwitchListTileSwitchListTileBuilder.switchListTileSwitchListTile(value, onChanged);
  }
  @Builder.Factory
  static SwitchListTile switchListTileAdaptive(@Builder.Parameter boolean value, @Builder.Parameter Consumer<Boolean> onChanged, Optional<ColorI> activeColor, Optional<ColorI> activeThumbColor, Optional<ColorI> activeTrackColor, Optional<ColorI> inactiveThumbColor, Optional<ColorI> inactiveTrackColor, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<DragStartBehavior> dragStartBehavior, OptionalDouble splashRadius, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Boolean> applyCupertinoTheme, Optional<ColorI> tileColor, Optional<WidgetI> title, Optional<WidgetI> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<EdgeInsetsGeometryI> contentPadding, Optional<WidgetI> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<ShapeBorderI> shape, Optional<ColorI> selectedTileColor, Optional<VisualDensityI> visualDensity, Optional<Boolean> enableFeedback, Optional<ColorI> hoverColor, Optional<Boolean> internalAddSemanticForOnTap) {
    var st = factories.switchListTileAdaptive(value,
      onChanged,
      activeColor.map(ColorI::build),
      activeThumbColor.map(ColorI::build),
      activeTrackColor.map(ColorI::build),
      inactiveThumbColor.map(ColorI::build),
      inactiveTrackColor.map(ColorI::build),
      materialTapTargetSize,
      dragStartBehavior,
      splashRadius,
      onFocusChange,
      autofocus,
      applyCupertinoTheme,
      tileColor.map(ColorI::build),
      title.map(WidgetI::build),
      subtitle.map(WidgetI::build),
      isThreeLine,
      dense,
      contentPadding.map(EdgeInsetsGeometryI::build),
      secondary.map(WidgetI::build),
      selected,
      controlAffinity,
      shape.map(ShapeBorderI::build),
      selectedTileColor.map(ColorI::build),
      visualDensity.map(VisualDensityI::build),
      enableFeedback,
      hoverColor.map(ColorI::build),
      internalAddSemanticForOnTap);
    if (st == null) throw new RuntimeException("Failed to created widget SwitchListTile");
    return new SwitchListTile(st);
  }
  public static SwitchListTileAdaptiveBuilder adaptive(boolean value, Consumer<Boolean> onChanged) {
    return SwitchListTileAdaptiveBuilder.switchListTileAdaptive(value, onChanged);
  }
  public boolean value() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileValue not supported on web");
    return intToBool(SwitchListTileObjSt.value(st));
  }
  public Color activeColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switchListTileActiveColor", getId());
      return new Color(__nid);
    }
    return new Color(SwitchListTileObjSt.activeColor(st));
  }
  public Color activeThumbColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switchListTileActiveThumbColor", getId());
      return new Color(__nid);
    }
    return new Color(SwitchListTileObjSt.activeThumbColor(st));
  }
  public Color activeTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switchListTileActiveTrackColor", getId());
      return new Color(__nid);
    }
    return new Color(SwitchListTileObjSt.activeTrackColor(st));
  }
  public Color inactiveThumbColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switchListTileInactiveThumbColor", getId());
      return new Color(__nid);
    }
    return new Color(SwitchListTileObjSt.inactiveThumbColor(st));
  }
  public Color inactiveTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switchListTileInactiveTrackColor", getId());
      return new Color(__nid);
    }
    return new Color(SwitchListTileObjSt.inactiveTrackColor(st));
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileMaterialTapTargetSize not supported on web");
    return MaterialTapTargetSize.values()[SwitchListTileObjSt.materialTapTargetSize(st)];
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileDragStartBehavior not supported on web");
    return DragStartBehavior.values()[SwitchListTileObjSt.dragStartBehavior(st)];
  }
  public double splashRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileSplashRadius not supported on web");
    return SwitchListTileObjSt.splashRadius(st);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileAutofocus not supported on web");
    return intToBool(SwitchListTileObjSt.autofocus(st));
  }
  public Color tileColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switchListTileTileColor", getId());
      return new Color(__nid);
    }
    return new Color(SwitchListTileObjSt.tileColor(st));
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileTitle not supported on web");
    return new Widget(SwitchListTileObjSt.title(st)) {};
  }
  public Widget subtitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileSubtitle not supported on web");
    return new Widget(SwitchListTileObjSt.subtitle(st)) {};
  }
  public Widget secondary() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileSecondary not supported on web");
    return new Widget(SwitchListTileObjSt.secondary(st)) {};
  }
  public boolean isThreeLine() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileIsThreeLine not supported on web");
    return intToBool(SwitchListTileObjSt.isThreeLine(st));
  }
  public boolean dense() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileDense not supported on web");
    return intToBool(SwitchListTileObjSt.dense(st));
  }
  public EdgeInsetsGeometry contentPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileContentPadding not supported on web");
    return new EdgeInsetsGeometry(SwitchListTileObjSt.contentPadding(st)) {};
  }
  public boolean selected() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileSelected not supported on web");
    return intToBool(SwitchListTileObjSt.selected(st));
  }
  public ListTileControlAffinity controlAffinity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileControlAffinity not supported on web");
    return ListTileControlAffinity.values()[SwitchListTileObjSt.controlAffinity(st)];
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileShape not supported on web");
    return new ShapeBorder(SwitchListTileObjSt.shape(st)) {};
  }
  public Color selectedTileColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switchListTileSelectedTileColor", getId());
      return new Color(__nid);
    }
    return new Color(SwitchListTileObjSt.selectedTileColor(st));
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switchListTileVisualDensity", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.VisualDensityObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.VisualDensityObjSt.id(__st, __nid);
      return new VisualDensity(__st);
    }
    return new VisualDensity(SwitchListTileObjSt.visualDensity(st));
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileEnableFeedback not supported on web");
    return intToBool(SwitchListTileObjSt.enableFeedback(st));
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switchListTileHoverColor", getId());
      return new Color(__nid);
    }
    return new Color(SwitchListTileObjSt.hoverColor(st));
  }
  public boolean applyCupertinoTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileApplyCupertinoTheme not supported on web");
    return intToBool(SwitchListTileObjSt.applyCupertinoTheme(st));
  }
  public boolean internalAddSemanticForOnTap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("switchListTileInternalAddSemanticForOnTap not supported on web");
    return intToBool(SwitchListTileObjSt.internalAddSemanticForOnTap(st));
  }
  @Override
  public SwitchListTile build() {
    return this;
  }
}
