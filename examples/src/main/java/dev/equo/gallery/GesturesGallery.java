package dev.equo.gallery;

import java.util.List;

import dev.equo.ewt.*;

import static dev.equo.ewt.EWT.*;
import static dev.equo.gallery.GalleryKit.*;

/**
 * Gestures + pointer input. One section per callback family; each reads its
 * details/event via the new *Methods companions so the printed values
 * exercise the round-trip end-to-end.
 *
 *   ./gradlew :examples:run -PuseLocal=true -PmainClass=dev.equo.gallery.GesturesGallery
 */
public class GesturesGallery {

  public static void main(String[] args) {
    App.runApp(MyApp::new);
  }

  static class MyApp extends SubStatelessWidget {
    @Override
    protected Widget build(BuildContext context) {
      return MaterialApp()
          .title("EWT — Gestures")
          .theme(ThemeData().colorScheme(ColorScheme_fromSeed(Colors.deepPurple())).useMaterial3(true))
          .home(new GesturesPage());
    }
  }

  static class GesturesPage extends SubStatefulWidget {
    @Override
    protected State<GesturesPage> createState() {
      return new GesturesState();
    }
  }

  static class GesturesState extends SubState<GesturesPage> {
    int _taps = 0;
    int _doubleTaps = 0;
    String _tapDown = "-";
    String _longPress = "-";
    String _panDelta = "-";
    boolean _hovering = false;
    String _hoverPos = "-";
    String _dropResult = "-";

    static String coord(Offset o) {
      return "(" + (int) o.dx() + "," + (int) o.dy() + ")";
    }

    Widget hit(ColorI color) {
      return rect(160.0, 40.0, color);
    }

    @Override
    public Widget build(BuildContext context) {

      // Draggable pill + DragTarget landing zone for the last section.
      Widget pill = Container()
          .width(100.0).height(36.0)
          .decoration(BoxDecoration()
              .color(Colors.deepPurple())
              .borderRadius(BorderRadius_circular(18.0)))
          .child(Center().child(Text("drag me")
              .style(TextStyle().color(Colors.white()))));

      // Draggable.data must be a NativeObj — reuse a Text as the payload id.
      Widget payload = Text("payload");
      Widget draggable = Draggable(pill, pill)
          .data(payload)
          .onDragEnd(d -> setState(() -> _dropResult =
              (d.wasAccepted() ? "accepted" : "rejected")
                  + " @ " + coord(d.offset())))
          .build();

      Widget dropTarget = DragTarget((ctx, candidateData, rejectedData) -> {
        boolean over = !candidateData.isEmpty();
        return Container()
            .width(140.0).height(60.0)
            .decoration(BoxDecoration()
                .color(over ? Colors.green() : Colors.grey())
                .borderRadius(BorderRadius_circular(8.0)))
            .child(Center().child(Text(over ? "release!" : "drop here")
                .style(TextStyle().color(Colors.white()))));
      })
      .onAccept(data -> System.out.println("DragTarget accepted id=" + data.getId()))
      .build();

      return page(context, "Gestures", Colors.deepPurple(), List.of(

          Text("Each row wires a callback and reads the details/event via the new companion methods."),
          Divider(),

          // --- onTap (Runnable — no details, baseline sanity check) ---
          Text("GestureDetector.onTap — Runnable"),
          GestureDetector().onTap(() -> setState(() -> _taps++))
              .child(hit(Colors.deepPurple())),
          Text("taps: " + _taps),
          Divider(),

          // --- onTapDown → TapDownDetails.globalPosition() ---
          Text("GestureDetector.onTapDown — TapDownDetails.globalPosition()"),
          GestureDetector()
              .onTapDown(d -> setState(() -> _tapDown = coord(d.globalPosition())))
              .child(hit(Colors.teal())),
          Text("last tap at: " + _tapDown),
          Divider(),

          // --- onDoubleTap ---
          Text("GestureDetector.onDoubleTap — Runnable"),
          GestureDetector().onDoubleTap(() -> setState(() -> _doubleTaps++))
              .child(hit(Colors.orange())),
          Text("double taps: " + _doubleTaps),
          Divider(),

          // --- onLongPressStart → LongPressStartDetails.globalPosition() ---
          Text("GestureDetector.onLongPressStart — LongPressStartDetails.globalPosition()"),
          GestureDetector()
              .onLongPressStart(d -> setState(() -> _longPress = coord(d.globalPosition())))
              .child(hit(Colors.indigo())),
          Text("long-press at: " + _longPress),
          Divider(),

          // --- onPanUpdate → DragUpdateDetails.delta() ---
          Text("GestureDetector.onPanUpdate — DragUpdateDetails.delta()"),
          GestureDetector()
              .onPanUpdate(d -> setState(() -> _panDelta = coord(d.delta())))
              .child(hit(Colors.blue())),
          Text("last pan delta: " + _panDelta + "   (drag inside the blue box)"),
          Divider(),

          // --- MouseRegion — onEnter/onExit color flip + onHover position ---
          Text("MouseRegion.onEnter/onExit/onHover — PointerHoverEvent.position()"),
          MouseRegion()
              .onEnter(e -> setState(() -> _hovering = true))
              .onExit(e -> setState(() -> _hovering = false))
              .onHover(e -> setState(() -> _hoverPos = coord(e.position())))
              .child(hit(_hovering ? Colors.red() : Colors.pink())),
          Text("hovering: " + _hovering + "   |   hover at: " + _hoverPos),
          Divider(),

          // --- Draggable + DragTarget → DraggableDetails.{wasAccepted, offset} ---
          Text("Draggable.onDragEnd — DraggableDetails.wasAccepted() / .offset()"),
          Padding(EdgeInsets_symmetric().vertical(8.0))
              .child(Row()
                  .mainAxisAlignment(MainAxisAlignment.spaceEvenly)
                  .crossAxisAlignment(CrossAxisAlignment.center)
                  .children(List.of(draggable, dropTarget))),
          Text("drop: " + _dropResult)
      ));
    }
  }
}
