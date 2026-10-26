package dev.equo.gallery;

import java.util.List;

import dev.equo.ewt.*;

import static dev.equo.ewt.EWT.*;
import static dev.equo.gallery.GalleryKit.*;

/**
 * Draggable node graph — each node is an EWT widget built in Java; node
 * positions are OWNED BY JAVA and a drag round-trips back ("id,x,y"), so the
 * move persists. Works on FFM (desktop) and comm (web / Evolve).
 *
 *   ./gradlew :examples:run -PuseLocal=true -PmainClass=dev.equo.gallery.GraphGallery
 */
public class GraphGallery {

  public static void main(String[] args) {
    App.runApp(MyApp::new);
  }

  // A graph node: a rounded colored box with a centered label. Any EWT widget
  // works here — this is just one style.
  static Widget gnode(String label, ColorI color) {
    return Container().width(78.0).height(42.0)
        .decoration(BoxDecoration().color(color).borderRadius(BorderRadius_circular(10.0)))
        .child(Align().alignment(Alignment.center())
            .child(Text(label).style(TextStyle().fontWeight(FontWeight.w600()))));
  }

  // Apply an onNodeMoved report ("id,x,y") to the Java-owned positions string.
  static String applyMove(String positions, String move) {
    String[] mv = move.split(",");
    int id = Integer.parseInt(mv[0].trim());
    String[] parts = positions.split(";");
    if (id >= 0 && id < parts.length) {
      parts[id] = mv[1].trim() + "," + mv[2].trim();
    }
    return String.join(";", parts);
  }

  static class MyApp extends SubStatelessWidget {
    @Override
    protected Widget build(BuildContext context) {
      return MaterialApp()
          .title("EWT — graph")
          .theme(ThemeData().colorScheme(ColorScheme_fromSeed(Colors.teal())).useMaterial3(true))
          .home(new GalleryPage());
    }
  }

  static class GalleryPage extends SubStatefulWidget {
    @Override
    protected State<GalleryPage> createState() {
      return new GalleryState();
    }
  }

  static class GalleryState extends SubState<GalleryPage> {
    // Java-owned node positions ("x,y;..." by id).
    String _pos = "300,24;130,150;470,150;40,280;220,280;390,280;540,280";

    @Override
    public Widget build(BuildContext context) {
      return page(context, "graph — draggable nodes", Colors.teal(), List.of(

          Text("Drag a node. Positions are owned by Java: on release the drag "
             + "reports back to Java and is persisted (same on desktop and on web/Evolve)."),
          SizedBox().height(14.0),
          Center().child(Container().width(640.0).height(420.0)
              .decoration(BoxDecoration()
                  .color(Colors.white())
                  .borderRadius(BorderRadius_circular(12.0))
                  .border(Border_all().color(Colors.grey()).width(1.0)))
              .child(EwtGraphView(List.of(
                      gnode("CEO", Colors.amber()),
                      gnode("CTO", Colors.cyan()),
                      gnode("COO", Colors.orange()),
                      gnode("Dev", Colors.lightGreen()),
                      gnode("QA", Colors.lightBlue()),
                      gnode("Ops", Colors.pink()),
                      gnode("Sales", Colors.purpleAccent())))
                  .edges("0-1,0-2,1-3,1-4,2-5,2-6")
                  .positions(_pos)
                  .nodeWidth(78.0).nodeHeight(42.0)
                  .onNodeMoved(m -> setState(() -> _pos = applyMove(_pos, m))))),
          SizedBox().height(14.0),
          Text("Java positions: " + _pos)
      ));
    }
  }
}
