package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
public class Scaffold extends StatefulWidget {
  Scaffold() {}
  Scaffold(int id) {
    this.id = id;
  }
  @Builder.Factory
  static Scaffold scaffoldScaffold(Optional<PreferredSizeWidget> appBar, Optional<Widget> body, Optional<Widget> floatingActionButton, Optional<List<Widget>> persistentFooterButtons, Optional<Widget> drawer, Optional<Consumer<Boolean>> onDrawerChanged, Optional<Widget> endDrawer, Optional<Consumer<Boolean>> onEndDrawerChanged, Optional<Widget> bottomNavigationBar, Optional<Widget> bottomSheet, Optional<Color> backgroundColor, Optional<Boolean> resizeToAvoidBottomInset, Optional<Boolean> primary, Optional<DragStartBehavior> drawerDragStartBehavior, Optional<Boolean> extendBody, Optional<Boolean> extendBodyBehindAppBar, Optional<Color> drawerScrimColor, OptionalDouble drawerEdgeDragWidth, Optional<Boolean> drawerEnableOpenDragGesture, Optional<Boolean> endDrawerEnableOpenDragGesture, Optional<String> restorationId) {
    int id = factories.scaffoldScaffold(appBar,
      body,
      floatingActionButton,
      persistentFooterButtons,
      drawer,
      onDrawerChanged,
      endDrawer,
      onEndDrawerChanged,
      bottomNavigationBar,
      bottomSheet,
      backgroundColor,
      resizeToAvoidBottomInset,
      primary,
      drawerDragStartBehavior,
      extendBody,
      extendBodyBehindAppBar,
      drawerScrimColor,
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
