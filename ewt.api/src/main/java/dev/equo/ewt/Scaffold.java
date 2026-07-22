package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ScaffoldObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Scaffold extends StatefulWidget implements ScaffoldI {
  private MemorySegment st;
  protected Scaffold() {}
  Scaffold(MemorySegment st) {
    this.id = ScaffoldObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Scaffold");
    System.out.println("New Scaffold id:"+id);
  }
  @Builder.Factory
  static Scaffold scaffoldScaffold(Optional<PreferredSizeWidgetI> appBar, Optional<WidgetI> body, Optional<WidgetI> floatingActionButton, Optional<List<WidgetI>> persistentFooterButtons, Optional<AlignmentDirectionalI> persistentFooterAlignment, Optional<BoxDecorationI> persistentFooterDecoration, Optional<WidgetI> drawer, Optional<Consumer<Boolean>> onDrawerChanged, Optional<WidgetI> endDrawer, Optional<Consumer<Boolean>> onEndDrawerChanged, Optional<WidgetI> bottomNavigationBar, Optional<WidgetI> bottomSheet, Optional<ColorI> backgroundColor, Optional<Boolean> resizeToAvoidBottomInset, Optional<Boolean> primary, Optional<DragStartBehavior> drawerDragStartBehavior, Optional<Boolean> extendBody, Optional<Boolean> drawerBarrierDismissible, Optional<Boolean> extendBodyBehindAppBar, Optional<ColorI> drawerScrimColor, Optional<BiFunction<BuildContext, Animation, Widget>> bottomSheetScrimBuilder, OptionalDouble drawerEdgeDragWidth, Optional<Boolean> drawerEnableOpenDragGesture, Optional<Boolean> endDrawerEnableOpenDragGesture, Optional<String> restorationId) {
    var st = factories.scaffoldScaffold(appBar.map(PreferredSizeWidgetI::build),
      body.map(WidgetI::build),
      floatingActionButton.map(WidgetI::build),
      persistentFooterButtons.map(i -> i.stream().map(WidgetI::build).toList()),
      persistentFooterAlignment.map(AlignmentDirectionalI::build),
      persistentFooterDecoration.map(BoxDecorationI::build),
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
      drawerBarrierDismissible,
      extendBodyBehindAppBar,
      drawerScrimColor.map(ColorI::build),
      bottomSheetScrimBuilder,
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
  public static ValueListenable geometryOf(BuildContextI context) {
    int id = factories.scaffoldGeometryOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ValueListenable<ScaffoldGeometry>");
    System.out.println("New ValueListenable<ScaffoldGeometry> id:"+id);
    return new ValueListenable() { public int getId() { return id; } };
  }
  public static boolean hasDrawer(BuildContextI context) {
    int id = factories.scaffoldHasDrawer(context.build(),
      Optional.empty());
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    System.out.println("New bool id:"+id);
    return intToBool(id);
  }
  public boolean extendBody() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldExtendBody not supported on web");
    return intToBool(ScaffoldObjSt.extendBody(st));
  }
  public boolean drawerBarrierDismissible() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldDrawerBarrierDismissible not supported on web");
    return intToBool(ScaffoldObjSt.drawerBarrierDismissible(st));
  }
  public boolean extendBodyBehindAppBar() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldExtendBodyBehindAppBar not supported on web");
    return intToBool(ScaffoldObjSt.extendBodyBehindAppBar(st));
  }
  public PreferredSizeWidget appBar() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldAppBar not supported on web");
    return new PreferredSizeWidget() { public int getId() { return ScaffoldObjSt.appBar(st); } };
  }
  public Widget body() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldBody not supported on web");
    return new Widget(ScaffoldObjSt.body(st)) {};
  }
  public Widget floatingActionButton() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldFloatingActionButton not supported on web");
    return new Widget(ScaffoldObjSt.floatingActionButton(st)) {};
  }
  public AlignmentDirectional persistentFooterAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("scaffoldPersistentFooterAlignment", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.AlignmentDirectionalObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.AlignmentDirectionalObjSt.id(__st, __nid);
      return new AlignmentDirectional(__st);
    }
    return new AlignmentDirectional(ScaffoldObjSt.persistentFooterAlignment(st));
  }
  public BoxDecoration persistentFooterDecoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("scaffoldPersistentFooterDecoration", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxDecorationObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxDecorationObjSt.id(__st, __nid);
      return new BoxDecoration(__st);
    }
    return new BoxDecoration(ScaffoldObjSt.persistentFooterDecoration(st));
  }
  public Widget drawer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldDrawer not supported on web");
    return new Widget(ScaffoldObjSt.drawer(st)) {};
  }
  public Widget endDrawer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldEndDrawer not supported on web");
    return new Widget(ScaffoldObjSt.endDrawer(st)) {};
  }
  public Color drawerScrimColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("scaffoldDrawerScrimColor", getId());
      return new Color(__nid);
    }
    return new Color(ScaffoldObjSt.drawerScrimColor(st));
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("scaffoldBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(ScaffoldObjSt.backgroundColor(st));
  }
  public Widget bottomNavigationBar() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldBottomNavigationBar not supported on web");
    return new Widget(ScaffoldObjSt.bottomNavigationBar(st)) {};
  }
  public Widget bottomSheet() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldBottomSheet not supported on web");
    return new Widget(ScaffoldObjSt.bottomSheet(st)) {};
  }
  public boolean resizeToAvoidBottomInset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldResizeToAvoidBottomInset not supported on web");
    return intToBool(ScaffoldObjSt.resizeToAvoidBottomInset(st));
  }
  public boolean primary() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldPrimary not supported on web");
    return intToBool(ScaffoldObjSt.primary(st));
  }
  public DragStartBehavior drawerDragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldDrawerDragStartBehavior not supported on web");
    return DragStartBehavior.values()[ScaffoldObjSt.drawerDragStartBehavior(st)];
  }
  public double drawerEdgeDragWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldDrawerEdgeDragWidth not supported on web");
    return ScaffoldObjSt.drawerEdgeDragWidth(st);
  }
  public boolean drawerEnableOpenDragGesture() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldDrawerEnableOpenDragGesture not supported on web");
    return intToBool(ScaffoldObjSt.drawerEnableOpenDragGesture(st));
  }
  public boolean endDrawerEnableOpenDragGesture() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldEndDrawerEnableOpenDragGesture not supported on web");
    return intToBool(ScaffoldObjSt.endDrawerEnableOpenDragGesture(st));
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldRestorationId not supported on web");
    return ScaffoldObjSt.restorationId(st).getString(0);
  }
  @Override
  public Scaffold build() {
    return this;
  }
}
