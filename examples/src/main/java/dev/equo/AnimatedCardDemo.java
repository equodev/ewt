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

    static class HomePageState extends SubAnimatedState<HomePage> {
        private AnimationController ctrl;

        @Override
        public void initState() {
            super.initState();
            ctrl = animationController(Duration().milliseconds(900));
        }

        @Override
        public Widget build(BuildContext context) {
            return Scaffold()
                    .appBar(AppBar()
                            .title(Text("Composed Transitions"))
                            .backgroundColor(Theme.of(context).colorScheme().inversePrimary()))
                    .body(Center().child(body()));
        }

        private Widget body() {
            return Column()
                    .mainAxisAlignment(MainAxisAlignment.center)
                    .children(List.of(
                            revealableRocket(),
                            SizedBox().height(48.0),
                            controls()
                    ));
        }

        // The same controller drives three transitions through different curves
        // so each property (scale, rotation, opacity) has its own feel.
        private Widget revealableRocket() {
            return ScaleTransition(curved(Curves.elasticOut()))
                    .child(RotationTransition(curved(Curves.easeOut()))
                            .child(FadeTransition(curved(Curves.easeIn()))
                                    .child(rocketCard())));
        }

        private Widget rocketCard() {
            return Card()
                    .elevation(8.0)
                    .child(Padding(EdgeInsets_all(32.0))
                            .child(Icon(Icons.rocket())
                                    .size(96.0)
                                    .color(Colors.deepPurple())));
        }

        private CurvedAnimation curved(Curve curve) {
            return CurvedAnimation(ctrl, curve).build();
        }

        private Widget controls() {
            return Row().mainAxisAlignment(MainAxisAlignment.center)
                    .children(List.of(
                            button("Reveal", ctrl::forward),
                            SizedBox().width(12.0),
                            button("Hide", ctrl::reverse),
                            SizedBox().width(12.0),
                            button("Pulse", ctrl::repeat),
                            SizedBox().width(12.0),
                            button("Stop", ctrl::stop)
                    ));
        }

        private Widget button(String label, Runnable action) {
            return ElevatedButton(action).child(Text(label));
        }
    }
}
