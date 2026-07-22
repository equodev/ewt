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
  @Builder.Factory
  static CheckboxListTile checkboxListTileCheckboxListTile(@Builder.Parameter boolean value, @Builder.Parameter Consumer<Boolean> onChanged, Optional<ColorI> activeColor, Optional<ColorI> checkColor, Optional<ColorI> hoverColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensityI> visualDensity, Optional<Boolean> autofocus, Optional<ShapeBorderI> shape, Optional<BorderSideI> side, Optional<Boolean> isError, Optional<Boolean> enabled, Optional<ColorI> tileColor, Optional<WidgetI> title, Optional<WidgetI> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<WidgetI> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<EdgeInsetsGeometryI> contentPadding, Optional<Boolean> tristate, Optional<OutlinedBorderI> checkboxShape, Optional<ColorI> selectedTileColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> enableFeedback, Optional<String> checkboxSemanticLabel, OptionalDouble checkboxScaleFactor, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> internalAddSemanticForOnTap) {
    var st = factories.checkboxListTileCheckboxListTile(value,
      onChanged,
      activeColor.map(ColorI::build),
      checkColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
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
  public static CheckboxListTileCheckboxListTileBuilder checkboxListTile(boolean value, Consumer<Boolean> onChanged) {
    return CheckboxListTileCheckboxListTileBuilder.checkboxListTileCheckboxListTile(value, onChanged);
  }
  @Builder.Factory
  static CheckboxListTile checkboxListTileAdaptive(@Builder.Parameter boolean value, @Builder.Parameter Consumer<Boolean> onChanged, Optional<ColorI> activeColor, Optional<ColorI> checkColor, Optional<ColorI> hoverColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensityI> visualDensity, Optional<Boolean> autofocus, Optional<ShapeBorderI> shape, Optional<BorderSideI> side, Optional<Boolean> isError, Optional<Boolean> enabled, Optional<ColorI> tileColor, Optional<WidgetI> title, Optional<WidgetI> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<WidgetI> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<EdgeInsetsGeometryI> contentPadding, Optional<Boolean> tristate, Optional<OutlinedBorderI> checkboxShape, Optional<ColorI> selectedTileColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> enableFeedback, Optional<String> checkboxSemanticLabel, OptionalDouble checkboxScaleFactor, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> internalAddSemanticForOnTap) {
    var st = factories.checkboxListTileAdaptive(value,
      onChanged,
      activeColor.map(ColorI::build),
      checkColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
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
  public static CheckboxListTileAdaptiveBuilder adaptive(boolean value, Consumer<Boolean> onChanged) {
    return CheckboxListTileAdaptiveBuilder.checkboxListTileAdaptive(value, onChanged);
  }
  public boolean value() {
    return intToBool(CheckboxListTileObjSt.value(st));
  }
  public Color activeColor() {
    return new Color(CheckboxListTileObjSt.activeColor(st));
  }
  public Color checkColor() {
    return new Color(CheckboxListTileObjSt.checkColor(st));
  }
  public Color hoverColor() {
    return new Color(CheckboxListTileObjSt.hoverColor(st));
  }
  public double splashRadius() {
    return CheckboxListTileObjSt.splashRadius(st);
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    return MaterialTapTargetSize.values()[CheckboxListTileObjSt.materialTapTargetSize(st)];
  }
  public VisualDensity visualDensity() {
    return new VisualDensity(CheckboxListTileObjSt.visualDensity(st));
  }
  public boolean autofocus() {
    return intToBool(CheckboxListTileObjSt.autofocus(st));
  }
  public ShapeBorder shape() {
    return new ShapeBorder(CheckboxListTileObjSt.shape(st)) {};
  }
  public BorderSide side() {
    return new BorderSide(CheckboxListTileObjSt.side(st));
  }
  public boolean isError() {
    return intToBool(CheckboxListTileObjSt.isError(st));
  }
  public Color tileColor() {
    return new Color(CheckboxListTileObjSt.tileColor(st));
  }
  public Widget title() {
    return new Widget(CheckboxListTileObjSt.title(st)) {};
  }
  public Widget subtitle() {
    return new Widget(CheckboxListTileObjSt.subtitle(st)) {};
  }
  public Widget secondary() {
    return new Widget(CheckboxListTileObjSt.secondary(st)) {};
  }
  public boolean isThreeLine() {
    return intToBool(CheckboxListTileObjSt.isThreeLine(st));
  }
  public boolean dense() {
    return intToBool(CheckboxListTileObjSt.dense(st));
  }
  public boolean selected() {
    return intToBool(CheckboxListTileObjSt.selected(st));
  }
  public ListTileControlAffinity controlAffinity() {
    return ListTileControlAffinity.values()[CheckboxListTileObjSt.controlAffinity(st)];
  }
  public EdgeInsetsGeometry contentPadding() {
    return new EdgeInsetsGeometry(CheckboxListTileObjSt.contentPadding(st)) {};
  }
  public boolean tristate() {
    return intToBool(CheckboxListTileObjSt.tristate(st));
  }
  public OutlinedBorder checkboxShape() {
    return new OutlinedBorder(CheckboxListTileObjSt.checkboxShape(st)) {};
  }
  public Color selectedTileColor() {
    return new Color(CheckboxListTileObjSt.selectedTileColor(st));
  }
  public boolean enableFeedback() {
    return intToBool(CheckboxListTileObjSt.enableFeedback(st));
  }
  public boolean enabled() {
    return intToBool(CheckboxListTileObjSt.enabled(st));
  }
  public ListTileTitleAlignment titleAlignment() {
    return ListTileTitleAlignment.values()[CheckboxListTileObjSt.titleAlignment(st)];
  }
  public boolean internalAddSemanticForOnTap() {
    return intToBool(CheckboxListTileObjSt.internalAddSemanticForOnTap(st));
  }
  public double checkboxScaleFactor() {
    return CheckboxListTileObjSt.checkboxScaleFactor(st);
  }
  public String checkboxSemanticLabel() {
    return CheckboxListTileObjSt.checkboxSemanticLabel(st).getString(0);
  }
  @Override
  public CheckboxListTile build() {
    return this;
  }
}
