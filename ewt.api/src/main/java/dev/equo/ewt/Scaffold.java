package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
public class Scaffold extends StatefulWidget implements ScaffoldI {
  @Override
  public Scaffold build() {
    return this;
  }
  Scaffold() {}
  Scaffold(int id) {
    this.id = id;
  }
  @Builder.Factory
  static Scaffold scaffoldScaffold(Optional<PreferredSizeWidgetI> appBar, Optional<WidgetI> body, Optional<WidgetI> floatingActionButton, Optional<List<WidgetI>> persistentFooterButtons, Optional<WidgetI> drawer, Optional<Consumer<Boolean>> onDrawerChanged, Optional<WidgetI> endDrawer, Optional<Consumer<Boolean>> onEndDrawerChanged, Optional<WidgetI> bottomNavigationBar, Optional<WidgetI> bottomSheet, Optional<ColorI> backgroundColor, Optional<Boolean> resizeToAvoidBottomInset, Optional<Boolean> primary, Optional<DragStartBehavior> drawerDragStartBehavior, Optional<Boolean> extendBody, Optional<Boolean> extendBodyBehindAppBar, Optional<ColorI> drawerScrimColor, OptionalDouble drawerEdgeDragWidth, Optional<Boolean> drawerEnableOpenDragGesture, Optional<Boolean> endDrawerEnableOpenDragGesture, Optional<String> restorationId) {
    int id = factories.scaffoldScaffold(appBar.map(PreferredSizeWidgetI::build),
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
    if (id == -1) throw new RuntimeException("Failed to created widget Scaffold");
    System.out.println("New Scaffold id:"+id);
    return new Scaffold(id);
  }
  public static ScaffoldScaffoldBuilder scaffold() {
    return ScaffoldScaffoldBuilder.scaffoldScaffold();
  }
}
