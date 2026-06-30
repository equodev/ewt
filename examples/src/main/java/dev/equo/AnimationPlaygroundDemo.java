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

    static class HomePageState extends SubAnimatedState<HomePage> {
        private AnimationController mainCtrl;
        private AnimationController holdCtrl;
        private boolean lastDirectionForward = true;

        @Override
        public void initState() {
            super.initState();
            mainCtrl = animationController(Duration().milliseconds(900));
            holdCtrl = animationController(Duration().milliseconds(700));
        }

        @Override
        public Widget build(BuildContext context) {
            return Scaffold()
                    .appBar(AppBar()
                            .title(Text("Animation Playground"))
                            .backgroundColor(Theme.of(context).colorScheme().inversePrimary()))
                    .body(SingleChildScrollView().child(
                            Padding(EdgeInsets_all(24.0)).child(body())));
        }

        private Widget body() {
            return Column().mainAxisAlignment(MainAxisAlignment.center)
                    .children(List.of(
                            composedCardSection(),
                            SizedBox().height(48.0),
                            Divider(),
                            SizedBox().height(24.0),
                            holdToSpinSection()
                    ));
        }

        // ----- Composed card section ------------------------------------------------

        private Widget composedCardSection() {
            return Column().children(List.of(
                    sectionTitle("Composed transitions"),
                    SizedBox().height(16.0),
                    revealableRocket(),
                    SizedBox().height(32.0),
                    actionButtons(),
                    SizedBox().height(16.0),
                    captionLabel("Speed"),
                    SizedBox().height(8.0),
                    speedButtons()
            ));
        }

        // Three transitions stacked over the same card, each driven by mainCtrl
        // through a different curve so scale/rotation/opacity feel distinct.
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
                                    .color(Colors.teal())));
        }

        private CurvedAnimation curved(Curve curve) {
            return CurvedAnimation(mainCtrl, curve).build();
        }

        private Widget actionButtons() {
            return Wrap()
                    .spacing(8.0)
                    .runSpacing(8.0)
                    .alignment(WrapAlignment.center)
                    .children(List.of(
                            FilledButton(this::doForward).child(Text("Reveal")),
                            FilledButton_tonal(this::doReverse).child(Text("Hide")),
                            OutlinedButton(mainCtrl::stop).child(Text("Stop")),
                            OutlinedButton(this::doResume).child(Text("Resume")),
                            ElevatedButton(mainCtrl::repeat).child(Text("Pulse"))
                    ));
        }

        private Widget speedButtons() {
            return Wrap()
                    .spacing(8.0)
                    .alignment(WrapAlignment.center)
                    .children(List.of(
                            speedButton("Slow", 1800),
                            speedButton("Normal", 900),
                            speedButton("Fast", 300)
                    ));
        }

        private Widget speedButton(String label, int millis) {
            return OutlinedButton(() -> mainCtrl.setDuration(Duration().milliseconds(millis)))
                    .child(Text(label));
        }

        private void doForward() {
            lastDirectionForward = true;
            mainCtrl.forward();
        }

        private void doReverse() {
            lastDirectionForward = false;
            mainCtrl.reverse();
        }

        private void doResume() {
            if (lastDirectionForward) mainCtrl.forward();
            else mainCtrl.reverse();
        }

        // ----- Hold-to-spin section -------------------------------------------------

        private Widget holdToSpinSection() {
            return Column().children(List.of(
                    sectionTitle("Hold to spin"),
                    SizedBox().height(4.0),
                    captionLabel("Long-press the badge to play it forward. Release to reverse it."),
                    SizedBox().height(24.0),
                    holdBadge()
            ));
        }

        private Widget holdBadge() {
            return GestureDetector()
                    .onLongPress(holdCtrl::forward)
                    .onLongPressUp(holdCtrl::reverse)
                    .child(RotationTransition(holdCtrl).child(badgeCircle()));
        }

        private Widget badgeCircle() {
            return Container()
                    .width(140.0)
                    .height(140.0)
                    .decoration(BoxDecoration()
                            .color(Colors.teal())
                            .borderRadius(BorderRadius_circular(70.0)))
                    .child(Center().child(Icon(Icons.star())
                            .size(72.0)
                            .color(Colors.white())));
        }

        // ----- Shared text helpers --------------------------------------------------

        private Widget sectionTitle(String text) {
            return Text(text).style(TextStyle().fontSize(20.0).fontWeight(FontWeight.bold()));
        }

        private Widget captionLabel(String text) {
            return Text(text).style(TextStyle().fontSize(13.0).color(Colors.black54()));
        }
    }
}
