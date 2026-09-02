package dev.equo.gallery;

import java.util.List;

import dev.equo.ewt.*;

import static dev.equo.ewt.EWT.*;
import static dev.equo.gallery.GalleryKit.page;

/**
 * Gesture-focused mini demo: a 2x3 table of bordered cells under a
 * NavigationToolbar header. Each cell reacts to a different GestureDetector
 * callback (opaque hit-test, so the whole cell is the receptor) and shows its
 * state via an AnimatedContainer + Chip + Tooltip stack.
 *
 *   ./gradlew :examples:run -PuseLocal=true -PmainClass=dev.equo.gallery.GestureTableGallery
 */
public class GestureTableGallery {

  public static void main(String[] args) {
    App.runApp(MyApp::new);
  }

  static class MyApp extends SubStatelessWidget {
    @Override
    protected Widget build(BuildContext context) {
      return MaterialApp()
          .title("EWT — Gesture Table")
          .theme(ThemeData().colorScheme(ColorScheme_fromSeed(Colors.teal())).useMaterial3(true))
          .home(new BoardPage());
    }
  }

  static class BoardPage extends SubStatefulWidget {
    @Override
    protected State<BoardPage> createState() { return new BoardState(); }
  }

  static class BoardState extends SubState<BoardPage> {
    int _taps = 0;
    boolean _doubleToggled = false;
    boolean _selected = false;
    int _secondary = 0;
    String _panDelta = "-";
    String _tapCoords = "-";

    static final double CELL_W = 160.0;
    static final double CELL_H = 100.0;

    @Override
    public Widget build(BuildContext ctx) {
      return page(ctx, "Gesture Table", Colors.teal(), List.of(

          // Header: NavigationToolbar needs a bounded height (CustomMultiChildLayout).
          Card().child(SizedBox().height(56.0).child(
              Padding(EdgeInsets_symmetric().horizontal(12.0)).child(
                  NavigationToolbar()
                      .leading(Icon(Icons.grid_on()))
                      .middle(Text("Gesture Board")
                          .style(TextStyle().fontSize(16.0).fontWeight(FontWeight.w600())))
                      .trailing(TextButton().onPressed(() -> setState(() -> reset())).child(Text("Reset"))).build()))),

          SizedBox().height(16.0),

          // 2x3 grid of cells laid out with Rows + Columns.
          Column().children(List.of(
              row(List.of(
                  cell("Tap", "taps: " + _taps, Icons.touch_app(), Colors.teal(),
                      "Single tap anywhere in this cell",
                      _taps > 0,
                      GestureDetector().behavior(HitTestBehavior.opaque)
                          .onTap(() -> setState(() -> _taps++))),
                  cell("Double-tap", _doubleToggled ? "ON" : "off",
                      Icons.check_circle(),
                      _doubleToggled ? Colors.orange() : Colors.blueGrey(),
                      "Double-tap to toggle",
                      _doubleToggled,
                      GestureDetector().behavior(HitTestBehavior.opaque)
                          .onDoubleTap(() -> setState(() -> _doubleToggled = !_doubleToggled))),
                  cell("Long press", _selected ? "selected" : "idle",
                      Icons.timer(),
                      _selected ? Colors.green() : Colors.blueGrey(),
                      "Hold for ~0.5s",
                      _selected,
                      GestureDetector().behavior(HitTestBehavior.opaque)
                          .onLongPress(() -> setState(() -> _selected = !_selected))))),
              SizedBox().height(12.0),
              row(List.of(
                  cell("Right-click", "count: " + _secondary,
                      Icons.mouse(), Colors.deepPurple(),
                      "Secondary (right) button tap",
                      _secondary > 0,
                      GestureDetector().behavior(HitTestBehavior.opaque)
                          .onSecondaryTap(() -> setState(() -> _secondary++))),
                  cell("Drag (pan)", _panDelta,
                      Icons.pan_tool(), Colors.indigo(),
                      "Drag inside the cell",
                      !"-".equals(_panDelta),
                      GestureDetector().behavior(HitTestBehavior.opaque)
                          .onPanUpdate(d -> setState(() -> _panDelta =
                              "d=(" + (int) d.delta().dx() + "," + (int) d.delta().dy() + ")"))),
                  cell("Tap coords", _tapCoords,
                      Icons.gps_fixed(), Colors.red(),
                      "Reports the tap-down position in cell coords",
                      !"-".equals(_tapCoords),
                      GestureDetector().behavior(HitTestBehavior.opaque)
                          .onTapDown(d -> setState(() -> _tapCoords =
                              "(" + (int) d.localPosition().dx() + "," + (int) d.localPosition().dy() + ")")))))
          )),

          SizedBox().height(16.0),
          Row().children(List.of(
              Icon(Icons.info_outline()).size(16.0).color(Colors.grey()),
              SizedBox().width(6.0),
              Text("Hover a cell for the gesture description; the whole cell is the hit target.")
                  .style(TextStyle().fontSize(12.0).color(Colors.grey()))))
      ));
    }

    void reset() {
      _taps = 0; _doubleToggled = false; _selected = false;
      _secondary = 0; _panDelta = "-"; _tapCoords = "-";
    }

    static Widget row(List<WidgetI> cells) {
      return Row().mainAxisAlignment(MainAxisAlignment.start).children(intersperse(cells, 12.0)).build();
    }

    /** Interleaves widgets with SizedBox spacers so Row layout is deterministic. */
    static List<WidgetI> intersperse(List<WidgetI> items, double gap) {
      java.util.ArrayList<WidgetI> out = new java.util.ArrayList<>();
      for (int i = 0; i < items.size(); i++) {
        if (i > 0) out.add(SizedBox().width(gap).build());
        out.add(items.get(i));
      }
      return out;
    }

    /**
     * One clickable cell. AnimatedContainer smoothly transitions the border/fill
     * when `active` flips; Tooltip explains the gesture on hover; GestureDetector
     * is set to `HitTestBehavior.opaque` so the entire 160x100 surface is the
     * receptor (not just where the text sits).
     */
    static Widget cell(String label, String status, IconDataI icon, ColorI accent,
                       String tip, boolean active, GestureDetectorGestureDetectorBuilder gd) {
      Widget body = AnimatedContainer()
          .duration(Duration().milliseconds(180).build())
          .width(CELL_W).height(CELL_H)
          .padding(EdgeInsets_all(10.0))
          .decoration(BoxDecoration()
              .color(active ? Colors.grey() : Colors.white())
              .border(Border_all().color(accent).width(active ? 2.0 : 1.0))
              .borderRadius(BorderRadius_circular(8.0)))
          .child(Column().crossAxisAlignment(CrossAxisAlignment.start)
              .mainAxisAlignment(MainAxisAlignment.spaceBetween).children(List.of(
                  Row().children(List.of(
                      Icon(icon).size(18.0).color(accent),
                      SizedBox().width(6.0),
                      Text(label).style(TextStyle().fontWeight(FontWeight.w600()).color(accent)))),
                  Chip().label(Text(status).style(TextStyle().fontSize(12.0)))
                      .backgroundColor(Colors.white()).build())).build());
      return Tooltip().message(tip).child(gd.child(body).build()).build();
    }
  }
}
