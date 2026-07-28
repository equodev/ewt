package dev.equo.newwidgets;

import java.util.List;
import java.util.function.Function;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/**
 * Fix #3 smoke demo: Draggable + DragTarget.
 *
 * <p>Drag the purple pill and drop it on the dashed box. On drop, the box
 * prints "ACCEPTED id={n}" to stdout — proof the DragTarget received the
 * Draggable's data via the callback pipeline. On drop outside the box, the
 * pill snaps back and nothing is logged.
 */
public class DraggableDemo {
    public static void main(String[] args) {
        App.runApp(() -> {
            Widget pill = Container()
                    .width(120.0).height(48.0)
                    .decoration(BoxDecoration()
                            .color(Color.fromARGB(255, 90, 60, 200))
                            .borderRadius(BorderRadius_circular(24.0)))
                    .child(Center().child(Text("drag me").style(TextStyle()
                            .color(Colors.white()).fontSize(14.0))));

            // Draggable.data must be a NativeObj — use a Text as the payload id.
            Widget payload = Text("payload");
            Widget draggable = Draggable(pill, pill).data(payload).build();

            // Real DragTarget. Its builder receives the candidateData list —
            // when non-empty, a Draggable is currently hovering; recolor to
            // provide visual feedback.
            Widget dropTarget = DragTarget(
                (ctx, candidateData, rejectedData) -> {
                    boolean hovering = !candidateData.isEmpty();
                    return Container()
                            .width(220.0).height(220.0)
                            .decoration(BoxDecoration()
                                    .color(hovering
                                            ? Color.fromARGB(255, 40, 200, 130)
                                            : Color.fromARGB(255, 40, 40, 60))
                                    .border(Border_all().color(Colors.white()).width(2.0).build())
                                    .borderRadius(BorderRadius_circular(16.0)))
                            .child(Center().child(Text(hovering ? "release!" : "drop here")
                                    .style(TextStyle().color(Colors.white()).fontSize(16.0))));
                })
                .onAccept(data -> System.out.println("ACCEPTED id=" + data.getId()))
                .onLeave(data -> System.out.println("LEFT id=" + (data == null ? "null" : data.getId())))
                .build();

            Widget row = Row()
                    .mainAxisAlignment(MainAxisAlignment.spaceEvenly)
                    .crossAxisAlignment(CrossAxisAlignment.center)
                    .children(List.of(draggable, dropTarget));

            Widget scaffold = Scaffold()
                    .backgroundColor(Color.fromARGB(255, 15, 15, 20))
                    .body(Center().child(row))
                    .build();

            return MaterialApp()
                    .theme(ThemeData_dark().useMaterial3(true).build())
                    .home(scaffold)
                    .build();
        });
    }
}
