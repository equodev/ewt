package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ListTileObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ListTile extends StatelessWidget implements ListTileI {
  private MemorySegment st;
  protected ListTile() {}
  ListTile(MemorySegment st) {
    this.id = ListTileObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ListTile");
    System.out.println("New ListTile id:"+id);
  }
  @Builder.Factory
  static ListTile listTileListTile(Optional<WidgetI> leading, Optional<WidgetI> title, Optional<WidgetI> subtitle, Optional<WidgetI> trailing, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<VisualDensityI> visualDensity, Optional<ShapeBorderI> shape, Optional<ListTileStyle> style, Optional<ColorI> selectedColor, Optional<ColorI> iconColor, Optional<ColorI> textColor, Optional<TextStyleI> titleTextStyle, Optional<TextStyleI> subtitleTextStyle, Optional<TextStyleI> leadingAndTrailingTextStyle, Optional<EdgeInsetsGeometryI> contentPadding, Optional<Boolean> enabled, Optional<Runnable> onTap, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> selected, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> splashColor, Optional<Boolean> autofocus, Optional<ColorI> tileColor, Optional<ColorI> selectedTileColor, Optional<Boolean> enableFeedback, OptionalDouble horizontalTitleGap, OptionalDouble minVerticalPadding, OptionalDouble minLeadingWidth, OptionalDouble minTileHeight, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> internalAddSemanticForOnTap) {
    var st = factories.listTileListTile(leading.map(WidgetI::build),
      title.map(WidgetI::build),
      subtitle.map(WidgetI::build),
      trailing.map(WidgetI::build),
      isThreeLine,
      dense,
      visualDensity.map(VisualDensityI::build),
      shape.map(ShapeBorderI::build),
      style,
      selectedColor.map(ColorI::build),
      iconColor.map(ColorI::build),
      textColor.map(ColorI::build),
      titleTextStyle.map(TextStyleI::build),
      subtitleTextStyle.map(TextStyleI::build),
      leadingAndTrailingTextStyle.map(TextStyleI::build),
      contentPadding.map(EdgeInsetsGeometryI::build),
      enabled,
      onTap,
      onLongPress,
      onFocusChange,
      selected,
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      autofocus,
      tileColor.map(ColorI::build),
      selectedTileColor.map(ColorI::build),
      enableFeedback,
      horizontalTitleGap,
      minVerticalPadding,
      minLeadingWidth,
      minTileHeight,
      titleAlignment,
      internalAddSemanticForOnTap);
    if (st == null) throw new RuntimeException("Failed to created widget ListTile");
    return new ListTile(st);
  }
  public static ListTileListTileBuilder listTile() {
    return ListTileListTileBuilder.listTileListTile();
  }
  public Widget leading() {
    return new Widget(ListTileObjSt.leading(st)) {};
  }
  public Widget title() {
    return new Widget(ListTileObjSt.title(st)) {};
  }
  public Widget subtitle() {
    return new Widget(ListTileObjSt.subtitle(st)) {};
  }
  public Widget trailing() {
    return new Widget(ListTileObjSt.trailing(st)) {};
  }
  public boolean isThreeLine() {
    return intToBool(ListTileObjSt.isThreeLine(st));
  }
  public boolean dense() {
    return intToBool(ListTileObjSt.dense(st));
  }
  public VisualDensity visualDensity() {
    return new VisualDensity(ListTileObjSt.visualDensity(st));
  }
  public ShapeBorder shape() {
    return new ShapeBorder(ListTileObjSt.shape(st)) {};
  }
  public Color selectedColor() {
    return new Color(ListTileObjSt.selectedColor(st));
  }
  public Color iconColor() {
    return new Color(ListTileObjSt.iconColor(st));
  }
  public Color textColor() {
    return new Color(ListTileObjSt.textColor(st));
  }
  public TextStyle titleTextStyle() {
    return new TextStyle(ListTileObjSt.titleTextStyle(st));
  }
  public TextStyle subtitleTextStyle() {
    return new TextStyle(ListTileObjSt.subtitleTextStyle(st));
  }
  public TextStyle leadingAndTrailingTextStyle() {
    return new TextStyle(ListTileObjSt.leadingAndTrailingTextStyle(st));
  }
  public ListTileStyle style() {
    return ListTileStyle.values()[ListTileObjSt.style(st)];
  }
  public EdgeInsetsGeometry contentPadding() {
    return new EdgeInsetsGeometry(ListTileObjSt.contentPadding(st)) {};
  }
  public boolean enabled() {
    return intToBool(ListTileObjSt.enabled(st));
  }
  public boolean selected() {
    return intToBool(ListTileObjSt.selected(st));
  }
  public Color focusColor() {
    return new Color(ListTileObjSt.focusColor(st));
  }
  public Color hoverColor() {
    return new Color(ListTileObjSt.hoverColor(st));
  }
  public Color splashColor() {
    return new Color(ListTileObjSt.splashColor(st));
  }
  public boolean autofocus() {
    return intToBool(ListTileObjSt.autofocus(st));
  }
  public Color tileColor() {
    return new Color(ListTileObjSt.tileColor(st));
  }
  public Color selectedTileColor() {
    return new Color(ListTileObjSt.selectedTileColor(st));
  }
  public boolean enableFeedback() {
    return intToBool(ListTileObjSt.enableFeedback(st));
  }
  public double horizontalTitleGap() {
    return ListTileObjSt.horizontalTitleGap(st);
  }
  public double minVerticalPadding() {
    return ListTileObjSt.minVerticalPadding(st);
  }
  public double minLeadingWidth() {
    return ListTileObjSt.minLeadingWidth(st);
  }
  public double minTileHeight() {
    return ListTileObjSt.minTileHeight(st);
  }
  public ListTileTitleAlignment titleAlignment() {
    return ListTileTitleAlignment.values()[ListTileObjSt.titleAlignment(st)];
  }
  public boolean internalAddSemanticForOnTap() {
    return intToBool(ListTileObjSt.internalAddSemanticForOnTap(st));
  }
  @Override
  public ListTile build() {
    return this;
  }
}
