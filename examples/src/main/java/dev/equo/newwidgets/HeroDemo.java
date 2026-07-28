package dev.equo.newwidgets;

import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/**
 * Fix #4 smoke demo: Hero (5-arg flightShuttleBuilder now supported).
 *
 * <p>NOTE — a Hero on its own just renders its child. The shared-element
 * transition only fires when Navigator pushes/pops a second route with a
 * matching tag; the current EWT API does not expose {@code MaterialPageRoute}
 * or {@code Navigator.of(ctx).push(...)}, so this demo can only confirm that
 * Hero constructs without crashing. Once routing is wired up, a two-route
 * gallery around this widget will show the tag transition visibly.
 */
public class HeroDemo {
    public static void main(String[] args) {
        App.runApp(() -> {
            // The tag is any NativeObj — use a Text widget as the tag id.
            Widget tag = Text("hero-tag");
            Widget avatar = Container()
                    .width(120.0).height(120.0)
                    .decoration(BoxDecoration()
                            .color(Color.fromARGB(255, 90, 60, 200))
                            .borderRadius(BorderRadius_circular(60.0)))
                    .child(Center().child(Icon(Icons.rocket_launch_rounded())
                            .color(Colors.white()).size(48.0)));

            Widget hero = Hero(tag).child(avatar).build();

            Widget scaffold = Scaffold()
                    .backgroundColor(Color.fromARGB(255, 15, 15, 20))
                    .body(Center().child(hero))
                    .build();

            return MaterialApp()
                    .theme(ThemeData_dark().useMaterial3(true).build())
                    .home(scaffold)
                    .build();
        });
    }
}
