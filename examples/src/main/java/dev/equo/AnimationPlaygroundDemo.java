package dev.equo;

import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/**
 * Animation playground combining several techniques in one app:
 *  - Main card driven by one controller with three transitions (Scale + Rotation
 *    + Fade) each curved differently.
 *  - Action row with Reveal / Hide / Stop / Resume / Pulse. Resume remembers the
 *    last direction the user picked and continues from where Stop left off.
 *  - Speed row that swaps the controller duration on the fly (Slow / Normal /
 *    Fast) using setDuration.
 *  - Second independent animation: a "hold-to-spin" widget powered by
 *    GestureDetector. While you hold it, the controller plays forward; when you
 *    release, it reverses.
 */
public class AnimationPlaygroundDemo {

    public static void main(String[] args) {
        App.runApp(MyApp::new);
    }

    static class MyApp extends SubStatelessWidget {
        @Override
        protected Widget build(BuildContext context) {
            return MaterialApp()
                    .title("EWT Animation Playground")
                    .theme(ThemeData()
                            .colorScheme(ColorScheme_fromSeed(Colors.teal()))
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
        // Main controller (composed card)
        AnimationController mainCtrl;
        // Remembers the last direction so "Resume" continues toward the same bound
        boolean lastDirectionForward = true;

        // Second controller (hold-to-spin)
        AnimationController holdCtrl;

        @Override
        public Widget build(BuildContext context) {
            return Scaffold()
                    .appBar(AppBar()
                            .title(Text("Animation Playground"))
                            .backgroundColor(Theme.of(context).colorScheme().inversePrimary()))
                    .body(SingleChildScrollView().child(
                            Padding(EdgeInsets_all(24.0)).child(
                                    Column().mainAxisAlignment(MainAxisAlignment.center)
                                            .children(List.of(
                                                    composedCardSection(),
                                                    SizedBox().height(48.0),
                                                    Divider(),
                                                    SizedBox().height(24.0),
                                                    holdToSpinSection()
                                            )).build())));
        }

        private Widget composedCardSection() {
            return AnimatedWrapper(
                    ctrlId -> {
                        mainCtrl = AnimationController.byId(ctrlId);
                        AnimatedWrapper.setDuration(mainCtrl, Duration().milliseconds(900));
                    },
                    () -> Column().children(List.of(
                            Text("Composed transitions").style(TextStyle().fontSize(20.0).fontWeight(FontWeight.bold())),
                            SizedBox().height(16.0),
                            // The same controller drives three transitions each through a
                            // different curve.
                            ScaleTransition(CurvedAnimation(mainCtrl, Curves.elasticOut()))
                                    .child(RotationTransition(CurvedAnimation(mainCtrl, Curves.easeOut()))
                                            .child(FadeTransition(CurvedAnimation(mainCtrl, Curves.easeIn()))
                                                    .child(Card()
                                                            .elevation(8.0)
                                                            .child(Padding(EdgeInsets_all(32.0))
                                                                    .child(Icon(Icons.rocket())
                                                                            .size(96.0)
                                                                            .color(Colors.teal())))))),
                            SizedBox().height(32.0),
                            // Action row
                            Wrap()
                                    .spacing(8.0)
                                    .runSpacing(8.0)
                                    .alignment(WrapAlignment.center)
                                    .children(List.of(
                                            FilledButton(this::doForward).child(Text("Reveal")),
                                            FilledButton_tonal(this::doReverse).child(Text("Hide")),
                                            OutlinedButton(() -> AnimatedWrapper.stop(mainCtrl)).child(Text("Stop")),
                                            OutlinedButton(this::doResume).child(Text("Resume")),
                                            ElevatedButton(() -> AnimatedWrapper.repeat(mainCtrl)).child(Text("Pulse"))
                                    )),
                            SizedBox().height(16.0),
                            // Speed row — swaps controller duration on the fly
                            Text("Speed").style(TextStyle().fontSize(14.0).color(Colors.black54())),
                            SizedBox().height(8.0),
                            Wrap()
                                    .spacing(8.0)
                                    .alignment(WrapAlignment.center)
                                    .children(List.of(
                                            OutlinedButton(() -> AnimatedWrapper.setDuration(mainCtrl, Duration().milliseconds(1800)))
                                                    .child(Text("Slow")),
                                            OutlinedButton(() -> AnimatedWrapper.setDuration(mainCtrl, Duration().milliseconds(900)))
                                                    .child(Text("Normal")),
                                            OutlinedButton(() -> AnimatedWrapper.setDuration(mainCtrl, Duration().milliseconds(300)))
                                                    .child(Text("Fast"))
                                    ))
                    )).build());
        }

        private Widget holdToSpinSection() {
            return AnimatedWrapper(
                    ctrlId -> {
                        holdCtrl = AnimationController.byId(ctrlId);
                        AnimatedWrapper.setDuration(holdCtrl, Duration().milliseconds(700));
                    },
                    () -> Column().children(List.of(
                            Text("Hold to spin")
                                    .style(TextStyle().fontSize(20.0).fontWeight(FontWeight.bold())),
                            SizedBox().height(4.0),
                            Text("Long-press the badge to play it forward. Release to reverse it.")
                                    .style(TextStyle().fontSize(13.0).color(Colors.black54())),
                            SizedBox().height(24.0),
                            GestureDetector()
                                    .onLongPress(() -> AnimatedWrapper.forward(holdCtrl))
                                    .onLongPressUp(() -> AnimatedWrapper.reverse(holdCtrl))
                                    .child(RotationTransition(holdCtrl)
                                            .child(Container()
                                                    .width(140.0)
                                                    .height(140.0)
                                                    .decoration(BoxDecoration()
                                                            .color(Colors.teal())
                                                            .borderRadius(BorderRadius_circular(70.0)))
                                                    .child(Center().child(Icon(Icons.star())
                                                            .size(72.0)
                                                            .color(Colors.white())))))
                    )).build());
        }

        // --- Main controller actions with direction tracking for Resume ---

        private void doForward() {
            lastDirectionForward = true;
            AnimatedWrapper.forward(mainCtrl);
        }

        private void doReverse() {
            lastDirectionForward = false;
            AnimatedWrapper.reverse(mainCtrl);
        }

        private void doResume() {
            if (lastDirectionForward) AnimatedWrapper.forward(mainCtrl);
            else AnimatedWrapper.reverse(mainCtrl);
        }
    }
}
