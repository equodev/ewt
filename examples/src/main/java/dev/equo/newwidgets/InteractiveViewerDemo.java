package dev.equo.newwidgets;

import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/** Fix #1 smoke demo: InteractiveViewer + existing widgets. */
public class InteractiveViewerDemo {
    public static void main(String[] args) {
        App.runApp(() -> {
            Widget content = Container()
                    .width(320.0).height(320.0)
                    .decoration(BoxDecoration()
                            .color(Color.fromARGB(255, 90, 60, 200))
                            .borderRadius(BorderRadius_circular(24.0)))
                    .child(Center().child(Column()
                            .mainAxisSize(MainAxisSize.min)
                            .children(List.of(
                                    Icon(Icons.pan_tool_rounded()).color(Colors.white()).size(48.0),
                                    SizedBox().height(12.0),
                                    Text("pinch/drag to zoom").style(TextStyle()
                                            .color(Colors.white()).fontSize(16.0))
                            ))));

            Widget iv = InteractiveViewer().maxScale(4.0).minScale(0.5).child(content).build();

            Widget scaffold = Scaffold()
                    .backgroundColor(Color.fromARGB(255, 15, 15, 20))
                    .body(Center().child(iv))
                    .build();

            return MaterialApp()
                    .theme(ThemeData_dark().useMaterial3(true).build())
                    .home(scaffold)
                    .build();
        });
    }
}
