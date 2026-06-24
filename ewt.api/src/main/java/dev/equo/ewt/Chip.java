package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ChipObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Chip extends StatelessWidget implements ChipI {
  private MemorySegment st;
  protected Chip() {}
  Chip(MemorySegment st) {
    this.id = ChipObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Chip");
    System.out.println("New Chip id:"+id);
  }
  @Builder.Factory
  static Chip chipChip(Optional<WidgetI> avatar, WidgetI label, Optional<TextStyleI> labelStyle, Optional<EdgeInsetsGeometryI> labelPadding, Optional<WidgetI> deleteIcon, Optional<Runnable> onDeleted, Optional<ColorI> deleteIconColor, Optional<String> deleteButtonTooltipMessage, Optional<BorderSideI> side, Optional<OutlinedBorderI> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<ColorI> backgroundColor, Optional<EdgeInsetsGeometryI> padding, Optional<VisualDensityI> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<BoxConstraintsI> avatarBoxConstraints, Optional<BoxConstraintsI> deleteIconBoxConstraints) {
    var st = factories.chipChip(avatar.map(WidgetI::build),
      label.build(),
      labelStyle.map(TextStyleI::build),
      labelPadding.map(EdgeInsetsGeometryI::build),
      deleteIcon.map(WidgetI::build),
      onDeleted,
      deleteIconColor.map(ColorI::build),
      deleteButtonTooltipMessage,
      side.map(BorderSideI::build),
      shape.map(OutlinedBorderI::build),
      clipBehavior,
      autofocus,
      backgroundColor.map(ColorI::build),
      padding.map(EdgeInsetsGeometryI::build),
      visualDensity.map(VisualDensityI::build),
      materialTapTargetSize,
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      avatarBoxConstraints.map(BoxConstraintsI::build),
      deleteIconBoxConstraints.map(BoxConstraintsI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Chip");
    return new Chip(st);
  }
  public static ChipChipBuilder chip() {
    return ChipChipBuilder.chipChip();
  }
  public Widget avatar() {
    return new Widget(ChipObjSt.avatar(st)) {};
  }
  public Widget label() {
    return new Widget(ChipObjSt.label(st)) {};
  }
  public TextStyle labelStyle() {
    return new TextStyle(ChipObjSt.labelStyle(st));
  }
  public EdgeInsetsGeometry labelPadding() {
    return new EdgeInsetsGeometry(ChipObjSt.labelPadding(st)) {};
  }
  public BorderSide side() {
    return new BorderSide(ChipObjSt.side(st));
  }
  public OutlinedBorder shape() {
    return new OutlinedBorder(ChipObjSt.shape(st)) {};
  }
  public Clip clipBehavior() {
    return Clip.values()[ChipObjSt.clipBehavior(st)];
  }
  public boolean autofocus() {
    return intToBool(ChipObjSt.autofocus(st));
  }
  public Color backgroundColor() {
    return new Color(ChipObjSt.backgroundColor(st));
  }
  public EdgeInsetsGeometry padding() {
    return new EdgeInsetsGeometry(ChipObjSt.padding(st)) {};
  }
  public VisualDensity visualDensity() {
    return new VisualDensity(ChipObjSt.visualDensity(st));
  }
  public Widget deleteIcon() {
    return new Widget(ChipObjSt.deleteIcon(st)) {};
  }
  public Color deleteIconColor() {
    return new Color(ChipObjSt.deleteIconColor(st));
  }
  public String deleteButtonTooltipMessage() {
    return ChipObjSt.deleteButtonTooltipMessage(st).getString(0);
  }
  public MaterialTapTargetSize materialTapTargetSize() {
    return MaterialTapTargetSize.values()[ChipObjSt.materialTapTargetSize(st)];
  }
  public double elevation() {
    return ChipObjSt.elevation(st);
  }
  public Color shadowColor() {
    return new Color(ChipObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    return new Color(ChipObjSt.surfaceTintColor(st));
  }
  public BoxConstraints avatarBoxConstraints() {
    return new BoxConstraints(ChipObjSt.avatarBoxConstraints(st));
  }
  public BoxConstraints deleteIconBoxConstraints() {
    return new BoxConstraints(ChipObjSt.deleteIconBoxConstraints(st));
  }
  @Override
  public Chip build() {
    return this;
  }
}
