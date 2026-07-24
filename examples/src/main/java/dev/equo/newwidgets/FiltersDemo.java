package dev.equo.newwidgets;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/** Fix #6 smoke demo: BackdropFilter + ImageFilter.blur + ColorFiltered + ColorFilter.mode. */
public class FiltersDemo {
    public static void main(String[] args) {
        App.runApp(() -> {
            Widget purple = Container()
                    .width(320.0).height(200.0)
                    .decoration(BoxDecoration()
                            .color(Color.fromARGB(255, 90, 60, 200))
                            .borderRadius(BorderRadius_circular(24.0)))
                    .child(Center().child(Icon(Icons.rocket_launch_rounded())
                            .color(Colors.white()).size(64.0)));

            // ColorFiltered wraps the child in a color filter.
            Widget filtered = ColorFiltered(ColorFilter_mode(Color.fromARGB(180, 255, 40, 120), BlendMode.modulate))
                    .child(purple)
                    .build();

            // ImageFiltered blurs a widget in-place (no ancestor needed).
            Widget blurred = ImageFiltered(ImageFilter_blur().sigmaX(4.0).sigmaY(4.0))
                    .child(Container()
                            .width(320.0).height(80.0)
                            .decoration(BoxDecoration()
                                    .color(Color.fromARGB(255, 40, 200, 130))
                                    .borderRadius(BorderRadius_circular(16.0))))
                    .build();

            Widget scaffold = Scaffold()
                    .backgroundColor(Color.fromARGB(255, 15, 15, 20))
                    .body(Center().child(Column()
                            .mainAxisSize(MainAxisSize.min)
                            .children(java.util.List.of(
                                    filtered,
                                    SizedBox().height(24.0),
                                    blurred
                            ))))
                    .build();

            return MaterialApp()
                    .theme(ThemeData_dark().useMaterial3(true).build())
                    .home(scaffold)
                    .build();
        });
    }
}
