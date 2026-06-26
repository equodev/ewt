package dev.equo;

import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/**
 * Showcases composing multiple transitions on the same widget driven by a
 * single AnimationController, each using a different curve via CurvedAnimation.
 *
 * The card scales in with an elastic bounce, rotates a full turn while fading
 * in. Buttons let you play it forward, reverse it, loop it back-and-forth
 * (pulse) or stop mid-animation.
 */
public class AnimatedCardDemo {

    public static void main(String[] args) {
        App.runApp(MyApp::new);
    }

    static class MyApp extends SubStatelessWidget {
        @Override
        protected Widget build(BuildContext context) {
            return MaterialApp()
                    .title("EWT Animation Demo")
                    .theme(ThemeData()
                            .colorScheme(ColorScheme_fromSeed(Colors.deepPurple()))
                            .useMaterial3(true))
                    .home(new HomePage());
        }
    }

    static class HomePage extends SubStatefulWidget {
        @Override
        protected State<HomePage> createState() {
            return new HomePageState();
        }
    }

    static class HomePageState extends SubState<HomePage> {
        AnimationController ctrl;

        @Override
        public Widget build(BuildContext context) {
            return Scaffold()
                    .appBar(AppBar()
                            .title(Text("Composed Transitions"))
                            .backgroundColor(Theme.of(context).colorScheme().inversePrimary()))
                    .body(Center().child(
                            AnimatedWrapper(
                                    ctrlId -> {
                                        ctrl = AnimationController.byId(ctrlId);
                                        AnimatedWrapper.setDuration(ctrl, Duration().milliseconds(900));
                                    },
                                    () -> Column()
                                            .mainAxisAlignment(MainAxisAlignment.center)
                                            .children(List.of(
                                                    // The same controller drives three transitions through
                                                    // different curves so each property has its own feel.
                                                    ScaleTransition(CurvedAnimation(ctrl, Curves.elasticOut()))
                                                            .child(RotationTransition(CurvedAnimation(ctrl, Curves.easeOut()))
                                                                    .child(FadeTransition(CurvedAnimation(ctrl, Curves.easeIn()))
                                                                            .child(Card()
                                                                                    .elevation(8.0)
                                                                                    .child(Padding(EdgeInsets_all(32.0))
                                                                                            .child(Icon(Icons.rocket())
                                                                                                    .size(96.0)
                                                                                                    .color(Colors.deepPurple())))))),
                                                    SizedBox().height(48.0),
                                                    Row().mainAxisAlignment(MainAxisAlignment.center)
                                                            .children(List.of(
                                                                    ElevatedButton(() -> AnimatedWrapper.forward(ctrl))
                                                                            .child(Text("Reveal")),
                                                                    SizedBox().width(12.0),
                                                                    ElevatedButton(() -> AnimatedWrapper.reverse(ctrl))
                                                                            .child(Text("Hide")),
                                                                    SizedBox().width(12.0),
                                                                    ElevatedButton(() -> AnimatedWrapper.repeat(ctrl))
                                                                            .child(Text("Pulse")),
                                                                    SizedBox().width(12.0),
                                                                    ElevatedButton(() -> AnimatedWrapper.stop(ctrl))
                                                                            .child(Text("Stop"))))))
                                            .build())));
        }
    }
}
