package dev.equo.gallery;

import java.util.ArrayList;
import java.util.List;

import dev.equo.ewt.*;

import static dev.equo.ewt.EWT.*;

/**
 * Scrolling containers — the scrolling containers added while expanding coverage:
 * ListView, GridView (count), PageView. Each needs a bounded box to live in,
 * so they are shown stacked inside fixed-height sections.
 *
 *   ./gradlew :examples:run -PuseLocal=true -PmainClass=dev.equo.gallery.ScrollWidgetsGallery
 */
public class ScrollWidgetsGallery {

  public static void main(String[] args) {
    App.runApp(MyApp::new);
  }

  static class MyApp extends SubStatelessWidget {
    @Override
    protected Widget build(BuildContext context) {
      return MaterialApp()
          .title("EWT — Scroll Widgets")
          .theme(ThemeData().colorScheme(ColorScheme_fromSeed(Colors.deepOrange())).useMaterial3(true))
          .home(new ScrollPage());
    }
  }

  static class ScrollPage extends SubStatefulWidget {
    @Override
    protected State<ScrollPage> createState() {
      return new ScrollState();
    }
  }

  static class ScrollState extends SubState<ScrollPage> {

    Widget box(String label, ColorI color) {
      return Container()
          .height(60.0)
          .color(color)
          .child(Center().child(Text(label)));
    }

    Widget section(String title, double height, Widget child) {
      return Padding(EdgeInsets_all(12.0)).child(Column()
          .crossAxisAlignment(CrossAxisAlignment.start)
          .children(List.of(
              Text(title).style(TextStyle().fontSize(18.0).fontWeight(FontWeight.bold())),
              SizedBox().height(8.0),
              SizedBox().height(height).child(child))));
    }

    @Override
    public Widget build(BuildContext context) {
      // --- ListView: 8 rows, vertical scroll ---
      List<WidgetI> rows = new ArrayList<>();
      for (int i = 1; i <= 8; i++) {
        rows.add(ListTile().title(Text("ListView item " + i)).leading(Icon(Icons.star())));
      }

      // --- GridView: 6 tiles, 3 columns ---
      List<WidgetI> cells = new ArrayList<>();
      ColorI[] palette = { Colors.red(), Colors.green(), Colors.blue(),
                           Colors.amber(), Colors.purple(), Colors.teal() };
      for (int i = 0; i < palette.length; i++) {
        cells.add(box("#" + (i + 1), palette[i]));
      }

      // --- PageView: 3 swipeable pages ---
      List<WidgetI> pages = List.of(
          box("Page 1  →swipe", Colors.deepOrange()),
          box("Page 2  →swipe", Colors.indigo()),
          box("Page 3", Colors.green()));

      return Scaffold()
          .appBar(AppBar()
              .backgroundColor(Theme.of(context).colorScheme().inversePrimary())
              .title(Text("Scroll Widgets")))
          .body(SingleChildScrollView().child(Column().children(List.of(

              section("ListView (vertical scroll)", 220.0,
                  ListView().children(rows)),

              section("GridView.count (3 columns)", 180.0,
                  GridView_count().crossAxisCount(3).mainAxisSpacing(8.0).crossAxisSpacing(8.0)
                      .children(cells)),

              section("PageView (swipe horizontally)", 80.0,
                  PageView().children(pages))
          ))));
    }
  }
}
