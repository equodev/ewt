package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Scaffold extends StatefulWidget implements ScaffoldI {
  protected Scaffold() {}
  Scaffold(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Scaffold");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Scaffold scaffoldScaffold(Optional<PreferredSizeWidgetI> appBar, Optional<WidgetI> body, Optional<WidgetI> floatingActionButton, Optional<List<WidgetI>> persistentFooterButtons, Optional<AlignmentDirectionalI> persistentFooterAlignment, Optional<BoxDecorationI> persistentFooterDecoration, Optional<WidgetI> drawer, Optional<Consumer<Boolean>> onDrawerChanged, Optional<WidgetI> endDrawer, Optional<Consumer<Boolean>> onEndDrawerChanged, Optional<WidgetI> bottomNavigationBar, Optional<WidgetI> bottomSheet, Optional<ColorI> backgroundColor, Optional<Boolean> resizeToAvoidBottomInset, Optional<Boolean> primary, Optional<DragStartBehavior> drawerDragStartBehavior, Optional<Boolean> extendBody, Optional<Boolean> drawerBarrierDismissible, Optional<Boolean> extendBodyBehindAppBar, Optional<ColorI> drawerScrimColor, Optional<BiFunction<BuildContext, Animation, Widget>> bottomSheetScrimBuilder, OptionalDouble drawerEdgeDragWidth, Optional<Boolean> drawerEnableOpenDragGesture, Optional<Boolean> endDrawerEnableOpenDragGesture, Optional<String> restorationId) {
    int id = factories.scaffoldScaffold(appBar.map(PreferredSizeWidgetI::build),
      body.map(WidgetI::build),
      floatingActionButton.map(WidgetI::build),
      persistentFooterButtons.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())),
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
    if (id <= 0) throw new RuntimeException("Failed to created widget Scaffold");
    return new Scaffold(id);
  }
  public static ScaffoldScaffoldBuilder scaffold() {
    return ScaffoldScaffoldBuilder.scaffoldScaffold();
  }
  public static ValueListenable geometryOf(BuildContextI context) {
    var id = factories.scaffoldGeometryOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ValueListenable<ScaffoldGeometry>");
    System.out.println("New ValueListenable<ScaffoldGeometry> id:"+id);
    return new ValueListenable() { public int getId() { return id; } };
  }
  public static boolean hasDrawer(BuildContextI context) {
    var id = factories.scaffoldHasDrawer(context.build(),
      Optional.empty());
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    System.out.println("New bool id:"+id);
    return intToBool(id);
  }
  public boolean extendBody() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldExtendBody not supported on web");
    return factories.Scaffold_readBack_extendBody(nativeStruct);
  }
  public boolean drawerBarrierDismissible() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldDrawerBarrierDismissible not supported on web");
    return factories.Scaffold_readBack_drawerBarrierDismissible(nativeStruct);
  }
  public boolean extendBodyBehindAppBar() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldExtendBodyBehindAppBar not supported on web");
    return factories.Scaffold_readBack_extendBodyBehindAppBar(nativeStruct);
  }
  public PreferredSizeWidget appBar() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldAppBar not supported on web");
    return factories.Scaffold_readBack_appBar(nativeStruct);
  }
  public Widget body() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldBody not supported on web");
    return factories.Scaffold_readBack_body(nativeStruct);
  }
  public Widget floatingActionButton() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldFloatingActionButton not supported on web");
    return factories.Scaffold_readBack_floatingActionButton(nativeStruct);
  }
  public AlignmentDirectional persistentFooterAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("scaffoldPersistentFooterAlignment", getId());
      return new AlignmentDirectional(__nid);
    }
    return factories.Scaffold_readBack_persistentFooterAlignment(nativeStruct);
  }
  public BoxDecoration persistentFooterDecoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("scaffoldPersistentFooterDecoration", getId());
      return new BoxDecoration(__nid);
    }
    return factories.Scaffold_readBack_persistentFooterDecoration(nativeStruct);
  }
  public Widget drawer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldDrawer not supported on web");
    return factories.Scaffold_readBack_drawer(nativeStruct);
  }
  public Widget endDrawer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldEndDrawer not supported on web");
    return factories.Scaffold_readBack_endDrawer(nativeStruct);
  }
  public Color drawerScrimColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("scaffoldDrawerScrimColor", getId());
      return new Color(__nid);
    }
    return factories.Scaffold_readBack_drawerScrimColor(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("scaffoldBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.Scaffold_readBack_backgroundColor(nativeStruct);
  }
  public Widget bottomNavigationBar() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldBottomNavigationBar not supported on web");
    return factories.Scaffold_readBack_bottomNavigationBar(nativeStruct);
  }
  public Widget bottomSheet() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldBottomSheet not supported on web");
    return factories.Scaffold_readBack_bottomSheet(nativeStruct);
  }
  public boolean resizeToAvoidBottomInset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldResizeToAvoidBottomInset not supported on web");
    return factories.Scaffold_readBack_resizeToAvoidBottomInset(nativeStruct);
  }
  public boolean primary() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldPrimary not supported on web");
    return factories.Scaffold_readBack_primary(nativeStruct);
  }
  public DragStartBehavior drawerDragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldDrawerDragStartBehavior not supported on web");
    return factories.Scaffold_readBack_drawerDragStartBehavior(nativeStruct);
  }
  public double drawerEdgeDragWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldDrawerEdgeDragWidth not supported on web");
    return factories.Scaffold_readBack_drawerEdgeDragWidth(nativeStruct);
  }
  public boolean drawerEnableOpenDragGesture() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldDrawerEnableOpenDragGesture not supported on web");
    return factories.Scaffold_readBack_drawerEnableOpenDragGesture(nativeStruct);
  }
  public boolean endDrawerEnableOpenDragGesture() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldEndDrawerEnableOpenDragGesture not supported on web");
    return factories.Scaffold_readBack_endDrawerEnableOpenDragGesture(nativeStruct);
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldRestorationId not supported on web");
    return factories.Scaffold_readBack_restorationId(nativeStruct);
  }
  @Override
  public Scaffold build() {
    return this;
  }
}
