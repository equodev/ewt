package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AppBarObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AppBar extends StatefulWidget implements PreferredSizeWidget, AppBarI {
  private MemorySegment st;
  protected AppBar() {}
  AppBar(MemorySegment st) {
    this.id = AppBarObjSt.id(st);
    this.st = st;
    System.out.println("New AppBar id:"+id);
  }
  @Builder.Factory
  static AppBar appBarAppBar(Optional<WidgetI> leading, Optional<Boolean> automaticallyImplyLeading, Optional<WidgetI> title, Optional<List<WidgetI>> actions, Optional<WidgetI> flexibleSpace, Optional<PreferredSizeWidgetI> bottom, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ColorI> backgroundColor, Optional<ColorI> foregroundColor, Optional<Boolean> primary, Optional<Boolean> centerTitle, Optional<Boolean> excludeHeaderSemantics, OptionalDouble titleSpacing, OptionalDouble toolbarOpacity, OptionalDouble bottomOpacity, OptionalDouble toolbarHeight, OptionalDouble leadingWidth, Optional<TextStyleI> toolbarTextStyle, Optional<TextStyleI> titleTextStyle, Optional<Boolean> forceMaterialTransparency, Optional<Clip> clipBehavior) {
    var st = factories.appBarAppBar(leading.map(WidgetI::build),
      automaticallyImplyLeading,
      title.map(WidgetI::build),
      actions.map(i -> i.stream().map(WidgetI::build).toList()),
      flexibleSpace.map(WidgetI::build),
      bottom.map(PreferredSizeWidgetI::build),
      elevation,
      scrolledUnderElevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      foregroundColor.map(ColorI::build),
      primary,
      centerTitle,
      excludeHeaderSemantics,
      titleSpacing,
      toolbarOpacity,
      bottomOpacity,
      toolbarHeight,
      leadingWidth,
      toolbarTextStyle.map(TextStyleI::build),
      titleTextStyle.map(TextStyleI::build),
      forceMaterialTransparency,
      clipBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget AppBar");
    return new AppBar(st);
  }
  public static AppBarAppBarBuilder appBar() {
    return AppBarAppBarBuilder.appBarAppBar();
  }
  public Widget leading() {
    return new Widget(AppBarObjSt.leading(st)) {};
  }
  public boolean automaticallyImplyLeading() {
    return intToBool(AppBarObjSt.automaticallyImplyLeading(st));
  }
  public Widget title() {
    return new Widget(AppBarObjSt.title(st)) {};
  }
  public Widget flexibleSpace() {
    return new Widget(AppBarObjSt.flexibleSpace(st)) {};
  }
  public double elevation() {
    return AppBarObjSt.elevation(st);
  }
  public double scrolledUnderElevation() {
    return AppBarObjSt.scrolledUnderElevation(st);
  }
  public Color shadowColor() {
    return new Color(AppBarObjSt.shadowColor(st)) {};
  }
  public Color surfaceTintColor() {
    return new Color(AppBarObjSt.surfaceTintColor(st)) {};
  }
  public Color backgroundColor() {
    return new Color(AppBarObjSt.backgroundColor(st)) {};
  }
  public Color foregroundColor() {
    return new Color(AppBarObjSt.foregroundColor(st)) {};
  }
  public boolean primary() {
    return intToBool(AppBarObjSt.primary(st));
  }
  public boolean centerTitle() {
    return intToBool(AppBarObjSt.centerTitle(st));
  }
  public boolean excludeHeaderSemantics() {
    return intToBool(AppBarObjSt.excludeHeaderSemantics(st));
  }
  public double titleSpacing() {
    return AppBarObjSt.titleSpacing(st);
  }
  public double toolbarOpacity() {
    return AppBarObjSt.toolbarOpacity(st);
  }
  public double bottomOpacity() {
    return AppBarObjSt.bottomOpacity(st);
  }
  public double toolbarHeight() {
    return AppBarObjSt.toolbarHeight(st);
  }
  public double leadingWidth() {
    return AppBarObjSt.leadingWidth(st);
  }
  public TextStyle toolbarTextStyle() {
    return new TextStyle(AppBarObjSt.toolbarTextStyle(st)) {};
  }
  public TextStyle titleTextStyle() {
    return new TextStyle(AppBarObjSt.titleTextStyle(st)) {};
  }
  public boolean forceMaterialTransparency() {
    return intToBool(AppBarObjSt.forceMaterialTransparency(st));
  }
  public Clip clipBehavior() {
    return Clip.values()[AppBarObjSt.clipBehavior(st)];
  }
  @Override
  public AppBar build() {
    return this;
  }
}
