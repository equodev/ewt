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
    return intToBool(SwitchListTileObjSt.value(st));
  }
  public Color activeColor() {
    return new Color(SwitchListTileObjSt.activeColor(st));
  }
  public Color activeThumbColor() {
    return new Color(SwitchListTileObjSt.activeThumbColor(st));
  }
  public Color activeTrackColor() {
    return new Color(SwitchListTileObjSt.activeTrackColor(st));
  }
  public Color inactiveThumbColor() {
    return new Color(SwitchListTileObjSt.inactiveThumbColor(st));
  }
  public Color inactiveTrackColor() {
    return new Color(SwitchListTileObjSt.inactiveTrackColor(st));
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    return MaterialTapTargetSize.values()[SwitchListTileObjSt.materialTapTargetSize(st)];
  }
  public DragStartBehavior dragStartBehavior() {
    return DragStartBehavior.values()[SwitchListTileObjSt.dragStartBehavior(st)];
  }
  public double splashRadius() {
    return SwitchListTileObjSt.splashRadius(st);
  }
  public boolean autofocus() {
    return intToBool(SwitchListTileObjSt.autofocus(st));
  }
  public Color tileColor() {
    return new Color(SwitchListTileObjSt.tileColor(st));
  }
  public Widget title() {
    return new Widget(SwitchListTileObjSt.title(st)) {};
  }
  public Widget subtitle() {
    return new Widget(SwitchListTileObjSt.subtitle(st)) {};
  }
  public Widget secondary() {
    return new Widget(SwitchListTileObjSt.secondary(st)) {};
  }
  public boolean isThreeLine() {
    return intToBool(SwitchListTileObjSt.isThreeLine(st));
  }
  public boolean dense() {
    return intToBool(SwitchListTileObjSt.dense(st));
  }
  public EdgeInsetsGeometry contentPadding() {
    return new EdgeInsetsGeometry(SwitchListTileObjSt.contentPadding(st)) {};
  }
  public boolean selected() {
    return intToBool(SwitchListTileObjSt.selected(st));
  }
  public ListTileControlAffinity controlAffinity() {
    return ListTileControlAffinity.values()[SwitchListTileObjSt.controlAffinity(st)];
  }
  public ShapeBorder shape() {
    return new ShapeBorder(SwitchListTileObjSt.shape(st)) {};
  }
  public Color selectedTileColor() {
    return new Color(SwitchListTileObjSt.selectedTileColor(st));
  }
  public VisualDensity visualDensity() {
    return new VisualDensity(SwitchListTileObjSt.visualDensity(st));
  }
  public boolean enableFeedback() {
    return intToBool(SwitchListTileObjSt.enableFeedback(st));
  }
  public Color hoverColor() {
    return new Color(SwitchListTileObjSt.hoverColor(st));
  }
  public boolean applyCupertinoTheme() {
    return intToBool(SwitchListTileObjSt.applyCupertinoTheme(st));
  }
  public boolean internalAddSemanticForOnTap() {
    return intToBool(SwitchListTileObjSt.internalAddSemanticForOnTap(st));
  }
  @Override
  public SwitchListTile build() {
    return this;
  }
}
