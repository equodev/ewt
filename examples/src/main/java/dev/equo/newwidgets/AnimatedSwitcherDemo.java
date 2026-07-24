package dev.equo.newwidgets;

import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/**
 * Fix #5 smoke demo: AnimatedSwitcher — the {@code layoutBuilder} + Flutter's
 * default transition (cross-fade) both fire when the {@code child} identity
 * changes.
 *
 * <p>Press the floating "Swap" button; the widget on screen alternates between
 * a rocket icon and a text label. AnimatedSwitcher detects the child's
 * runtimeType change and cross-fades over 500 ms. Each swap also invokes the
 * layoutBuilder (Flutter's default in this demo, since we don't supply one) —
 * that path used to crash with {@code Bad state: unreachable} in this branch's
 * fix #5 regression window.
 */
public class AnimatedSwitcherDemo {
    public static void main(String[] args) {
        App.runApp(() -> MaterialApp()
                .theme(ThemeData_dark().useMaterial3(true).build())
                .home(new SwitcherPage())
                .build());
    }

    static class SwitcherPage extends SubStatefulWidget {
        @Override
        protected State<SwitcherPage> createState() { return new SwitcherState(); }
    }

    static class SwitcherState extends SubState<SwitcherPage> {
        private boolean showRocket = true;

        private void toggle() { setState(() -> showRocket = !showRocket); }

        @Override
        public Widget build(BuildContext context) {
            // The two children have DIFFERENT runtimeTypes (Icon vs Text) so
            // AnimatedSwitcher's default diff sees them as distinct — that's
            // what triggers the cross-fade animation without needing a Key API.
            Widget current = showRocket
                    ? Icon(Icons.rocket_launch_rounded())
                            .color(Color.fromARGB(255, 90, 60, 200))
                            .size(96.0)
                    : Text("hello from AnimatedSwitcher").style(TextStyle()
                            .color(Color.fromARGB(255, 40, 200, 130))
                            .fontSize(22.0)
                            .fontWeight(FontWeight.w700()));

            return Scaffold()
                    .backgroundColor(Color.fromARGB(255, 15, 15, 20))
                    .body(Center().child(AnimatedSwitcher()
                            .duration(Duration().milliseconds(500).build())
                            .child(current)))
                    .floatingActionButton(FloatingActionButton()
                            .onPressed(this::toggle)
                            .tooltip("swap")
                            .child(Icon(Icons.swap_horiz_rounded())))
                    .build();
        }
    }
}
