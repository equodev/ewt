package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CheckboxObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Checkbox extends StatefulWidget implements CheckboxI {
  private MemorySegment st;
  protected Checkbox() {}
  Checkbox(MemorySegment st) {
    this.id = CheckboxObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Checkbox");
    System.out.println("New Checkbox id:"+id);
  }
  @Builder.Factory
  static Checkbox checkboxCheckbox(@Builder.Parameter boolean value, Optional<Boolean> tristate, Consumer<Boolean> onChanged, Optional<ColorI> activeColor, Optional<ColorI> checkColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensityI> visualDensity, Optional<Boolean> autofocus, Optional<OutlinedBorderI> shape, Optional<BorderSideI> side, Optional<Boolean> isError, Optional<String> semanticLabel) {
    var st = factories.checkboxCheckbox(value,
      tristate,
      onChanged,
      activeColor.map(ColorI::build),
      checkColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      splashRadius,
      materialTapTargetSize,
      visualDensity.map(VisualDensityI::build),
      autofocus,
      shape.map(OutlinedBorderI::build),
      side.map(BorderSideI::build),
      isError,
      semanticLabel);
    if (st == null) throw new RuntimeException("Failed to created widget Checkbox");
    return new Checkbox(st);
  }
  public static CheckboxCheckboxBuilder checkbox(boolean value) {
    return CheckboxCheckboxBuilder.checkboxCheckbox(value);
  }
  @Builder.Factory
  static Checkbox checkboxAdaptive(@Builder.Parameter boolean value, Optional<Boolean> tristate, Consumer<Boolean> onChanged, Optional<ColorI> activeColor, Optional<ColorI> checkColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensityI> visualDensity, Optional<Boolean> autofocus, Optional<OutlinedBorderI> shape, Optional<BorderSideI> side, Optional<Boolean> isError, Optional<String> semanticLabel) {
    var st = factories.checkboxAdaptive(value,
      tristate,
      onChanged,
      activeColor.map(ColorI::build),
      checkColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      splashRadius,
      materialTapTargetSize,
      visualDensity.map(VisualDensityI::build),
      autofocus,
      shape.map(OutlinedBorderI::build),
      side.map(BorderSideI::build),
      isError,
      semanticLabel);
    if (st == null) throw new RuntimeException("Failed to created widget Checkbox");
    return new Checkbox(st);
  }
  public static CheckboxAdaptiveBuilder adaptive(boolean value) {
    return CheckboxAdaptiveBuilder.checkboxAdaptive(value);
  }
  public boolean value() {
    return intToBool(CheckboxObjSt.value(st));
  }
  public Color activeColor() {
    return new Color(CheckboxObjSt.activeColor(st));
  }
  public Color checkColor() {
    return new Color(CheckboxObjSt.checkColor(st));
  }
  public boolean tristate() {
    return intToBool(CheckboxObjSt.tristate(st));
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    return MaterialTapTargetSize.values()[CheckboxObjSt.materialTapTargetSize(st)];
  }
  public VisualDensity visualDensity() {
    return new VisualDensity(CheckboxObjSt.visualDensity(st));
  }
  public Color focusColor() {
    return new Color(CheckboxObjSt.focusColor(st));
  }
  public Color hoverColor() {
    return new Color(CheckboxObjSt.hoverColor(st));
  }
  public double splashRadius() {
    return CheckboxObjSt.splashRadius(st);
  }
  public boolean autofocus() {
    return intToBool(CheckboxObjSt.autofocus(st));
  }
  public OutlinedBorder shape() {
    return new OutlinedBorder(CheckboxObjSt.shape(st)) {};
  }
  public BorderSide side() {
    return new BorderSide(CheckboxObjSt.side(st));
  }
  public boolean isError() {
    return intToBool(CheckboxObjSt.isError(st));
  }
  public String semanticLabel() {
    return CheckboxObjSt.semanticLabel(st).getString(0);
  }
  public static double width() {
    return 18.0;
  }
  @Override
  public Checkbox build() {
    return this;
  }
}
