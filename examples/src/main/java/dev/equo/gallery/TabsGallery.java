package dev.equo.gallery;

import java.util.List;

import dev.equo.ewt.*;

import static dev.equo.ewt.EWT.*;

/**
 * Tabs: DefaultTabController + TabBar + Tab + TabBarView.
 *
 *   ./gradlew :examples:run -PuseLocal=true -PmainClass=dev.equo.gallery.TabsGallery
 *
 * TabBar and TabBarView both need a TabController to stay in sync. Rather than
 * exposing TabController directly (it needs a TickerProvider), DefaultTabController
 * creates one and hands it to every descendant — so it has to wrap the Scaffold,
 * not sit inside it.
 *
 * TabBar implements PreferredSizeWidget, which is why it can go in AppBar.bottom.
 */
public class TabsGallery {

  public static void main(String[] args) {
    App.runApp(MyApp::new);
  }

  static class MyApp extends SubStatelessWidget {
    @Override
    protected Widget build(BuildContext context) {
      return MaterialApp()
          .title("EWT — Tabs")
          .theme(ThemeData().colorScheme(ColorScheme_fromSeed(Colors.green())).useMaterial3(true))
          .home(new TabsPage());
    }
  }

  static class TabsPage extends SubStatelessWidget {
    @Override
    protected Widget build(BuildContext context) {
      // length must match the number of Tabs and of TabBarView children.
      return DefaultTabController(3)
          .child(Scaffold()
              .appBar(AppBar()
                  .backgroundColor(Theme.of(context).colorScheme().inversePrimary())
                  .title(Text("Tabs"))
                  .bottom(TabBar(List.of(
                      Tab().text("Home").icon(Icon(Icons.home())),
                      Tab().text("Starred").icon(Icon(Icons.star())),
                      Tab().text("Settings").icon(Icon(Icons.settings()))))))
              .body(TabBarView(List.of(
                  tabPage("Home tab", Icons.home(), Colors.green()),
                  tabPage("Starred tab", Icons.star(), Colors.amber()),
                  tabPage("Settings tab", Icons.settings(), Colors.blueGrey())))));
    }

    private Widget tabPage(String label, IconDataI icon, ColorI color) {
      return Center().child(Column()
          .mainAxisAlignment(MainAxisAlignment.center)
          .children(List.of(
              Icon(icon).size(48.0).color(color),
              SizedBox().height(12.0),
              Text(label).style(TextStyle().fontSize(20.0)))));
    }
  }
}
