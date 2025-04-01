package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ScaffoldObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Scaffold extends StatefulWidget implements ScaffoldI {
  @Override
  public Scaffold build() {
    return this;
  }
  private MemorySegment st;
  protected Scaffold() {}
  Scaffold(MemorySegment st) {
    this.id = ScaffoldObjSt.id(st);
    this.st = st;
    System.out.println("New Scaffold id:"+id);
  }
  @Builder.Factory
  static Scaffold scaffoldScaffold(Optional<PreferredSizeWidgetI> appBar, Optional<WidgetI> body, Optional<WidgetI> floatingActionButton, Optional<List<WidgetI>> persistentFooterButtons, Optional<WidgetI> drawer, Optional<Consumer<Boolean>> onDrawerChanged, Optional<WidgetI> endDrawer, Optional<Consumer<Boolean>> onEndDrawerChanged, Optional<WidgetI> bottomNavigationBar, Optional<WidgetI> bottomSheet, Optional<ColorI> backgroundColor, Optional<Boolean> resizeToAvoidBottomInset, Optional<Boolean> primary, Optional<DragStartBehavior> drawerDragStartBehavior, Optional<Boolean> extendBody, Optional<Boolean> extendBodyBehindAppBar, Optional<ColorI> drawerScrimColor, OptionalDouble drawerEdgeDragWidth, Optional<Boolean> drawerEnableOpenDragGesture, Optional<Boolean> endDrawerEnableOpenDragGesture, Optional<String> restorationId) {
    var st = factories.scaffoldScaffold(appBar.map(PreferredSizeWidgetI::build),
      body.map(WidgetI::build),
      floatingActionButton.map(WidgetI::build),
      persistentFooterButtons.map(i -> i.stream().map(WidgetI::build).toList()),
      drawer.map(WidgetI::build),
      onDrawerChanged,
      endDrawer.map(WidgetI::build),
      onEndDrawerChanged,
      bottomNavigationBar.map(WidgetI::build),
      bottomSheet.map(WidgetI::build),
      backgroundColor.map(ColorI::build),
      resizeToAvoidBottomInset,
      primary,
      drawerDragStartBehavior,
      extendBody,
      extendBodyBehindAppBar,
      drawerScrimColor.map(ColorI::build),
      drawerEdgeDragWidth,
      drawerEnableOpenDragGesture,
      endDrawerEnableOpenDragGesture,
      restorationId);
    if (st == null) throw new RuntimeException("Failed to created widget Scaffold");
    return new Scaffold(st);
  }
  public static ScaffoldScaffoldBuilder scaffold() {
    return ScaffoldScaffoldBuilder.scaffoldScaffold();
  }
  public boolean extendBody() {
    return intToBool(ScaffoldObjSt.extendBody(st));
  }
  public boolean extendBodyBehindAppBar() {
    return intToBool(ScaffoldObjSt.extendBodyBehindAppBar(st));
  }
  public Widget body() {
    return new Widget(ScaffoldObjSt.body(st)) {};
  }
  public Widget floatingActionButton() {
    return new Widget(ScaffoldObjSt.floatingActionButton(st)) {};
  }
  public Widget drawer() {
    return new Widget(ScaffoldObjSt.drawer(st)) {};
  }
  public Widget endDrawer() {
    return new Widget(ScaffoldObjSt.endDrawer(st)) {};
  }
  public Color drawerScrimColor() {
    return new Color(ScaffoldObjSt.drawerScrimColor(st)) {};
  }
  public Color backgroundColor() {
    return new Color(ScaffoldObjSt.backgroundColor(st)) {};
  }
  public Widget bottomNavigationBar() {
    return new Widget(ScaffoldObjSt.bottomNavigationBar(st)) {};
  }
  public Widget bottomSheet() {
    return new Widget(ScaffoldObjSt.bottomSheet(st)) {};
  }
  public boolean resizeToAvoidBottomInset() {
    return intToBool(ScaffoldObjSt.resizeToAvoidBottomInset(st));
  }
  public boolean primary() {
    return intToBool(ScaffoldObjSt.primary(st));
  }
  public DragStartBehavior drawerDragStartBehavior() {
    return DragStartBehavior.values()[ScaffoldObjSt.drawerDragStartBehavior(st)];
  }
  public double drawerEdgeDragWidth() {
    return ScaffoldObjSt.drawerEdgeDragWidth(st);
  }
  public boolean drawerEnableOpenDragGesture() {
    return intToBool(ScaffoldObjSt.drawerEnableOpenDragGesture(st));
  }
  public boolean endDrawerEnableOpenDragGesture() {
    return intToBool(ScaffoldObjSt.endDrawerEnableOpenDragGesture(st));
  }
}
