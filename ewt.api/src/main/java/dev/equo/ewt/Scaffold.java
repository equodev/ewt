package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;
public class Scaffold extends StatefulWidget {
  static final WidgetConstructors factories = WidgetConstructors.instance;
  Scaffold() {}
  @Builder.Constructor
  Scaffold(Optional<PreferredSizeWidget> appBar, Optional<Widget> body, Optional<Widget> floatingActionButton, Optional<List<Widget>> persistentFooterButtons, Optional<Widget> drawer, Optional<Widget> endDrawer, Optional<Widget> bottomNavigationBar, Optional<Widget> bottomSheet, Optional<Boolean> resizeToAvoidBottomInset, Optional<Boolean> primary, Optional<DragStartBehavior> drawerDragStartBehavior, Optional<Boolean> extendBody, Optional<Boolean> extendBodyBehindAppBar, OptionalDouble drawerEdgeDragWidth, Optional<Boolean> drawerEnableOpenDragGesture, Optional<Boolean> endDrawerEnableOpenDragGesture, Optional<String> restorationId) {
    id = factories.scaffoldScaffold(appBar, body, floatingActionButton, persistentFooterButtons, drawer, endDrawer, bottomNavigationBar, bottomSheet, resizeToAvoidBottomInset, primary, drawerDragStartBehavior, extendBody, extendBodyBehindAppBar, drawerEdgeDragWidth, drawerEnableOpenDragGesture, endDrawerEnableOpenDragGesture, restorationId);
    if (id == -1) throw new RuntimeException("Failed to created widget "+this);
    System.out.println("New "+this+" id:"+id);
  }
  public static ScaffoldBuilder scaffold() {
    return ScaffoldBuilder.Scaffold();
  }
}
