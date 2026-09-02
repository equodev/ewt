package dev.equo.showcase;

import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/**
 * Two independent AnimationControllers in one page:
 *  - mainCtrl drives a composed card (Scale + Rotation + Fade, each with its
 *    own curve). Full control row: Reveal / Hide / Stop / Resume / Pulse / Reset,
 *    plus speed toggle (Slow / Normal / Fast).
 *  - holdCtrl drives a "hold-to-spin" badge via GestureDetector: long-press
 *    spins it forward, releasing reverses it.
 */
public class AnimationPlaygroundPage extends SubStatefulWidget {
    private final Runnable goBack;

    public AnimationPlaygroundPage(Runnable goBack) {
        this.goBack = goBack;
    }

    @Override
    protected State<AnimationPlaygroundPage> createState() {
        return new AnimationPlaygroundPageState(goBack);
    }
}

class AnimationPlaygroundPageState extends SubAnimatedState<AnimationPlaygroundPage> {
    private final Runnable goBack;
    private AnimationController mainCtrl;
    private AnimationController holdCtrl;
    private boolean lastForward = true;

    AnimationPlaygroundPageState(Runnable goBack) {
        this.goBack = goBack;
    }

    @Override
    public void initState() {
        super.initState();
        mainCtrl = animationController(Duration().milliseconds(900));
        holdCtrl = animationController(Duration().milliseconds(700));
        mainCtrl.forward();
    }

    @Override
    public Widget build(BuildContext context) {
        return Scaffold()
                .backgroundColor(Colors.white())
                .appBar(AppBar()
                        .title(Text("Animation Playground"))
                        .backgroundColor(Palette.accentTeal())
                        .foregroundColor(Colors.white())
                        .leading(IconButton()
                                .icon(Icon(Icons.arrow_back_rounded()))
                                .color(Colors.white())
                                .onPressed(goBack)))
                .body(SafeArea().child(SingleChildScrollView().child(
                        Padding(EdgeInsets_all(24.0)).child(body()))));
    }

    private Widget body() {
        return Column()
                .crossAxisAlignment(CrossAxisAlignment.stretch)
                .children(List.of(
                        Text("Composed transitions").style(Palette.sectionTitle()),
                        SizedBox().height(6.0),
                        Text("Scale · Rotation · Fade driven by one controller, each through its own curve.")
                                .style(Palette.subtitle()),
                        SizedBox().height(28.0),
                        composedCard(),
                        SizedBox().height(28.0),
                        Text("Controls").style(Palette.sectionTitle()),
                        SizedBox().height(12.0),
                        controlsRow(),
                        SizedBox().height(16.0),
                        Text("Speed").style(Palette.sectionTitle()),
                        SizedBox().height(12.0),
                        speedRow(),
                        SizedBox().height(40.0),
                        Divider(),
                        SizedBox().height(32.0),
                        Text("Hold to spin").style(Palette.sectionTitle()),
                        SizedBox().height(6.0),
                        Text("Long-press the badge and hold to spin it forward. Release to reverse.")
                                .style(Palette.subtitle()),
                        SizedBox().height(24.0),
                        holdBadgeRow(),
                        SizedBox().height(40.0)
                ));
    }

    // ── Composed card ──────────────────────────────────────────────────────────

    private CurvedAnimation curved(Curve c) {
        return CurvedAnimation(mainCtrl, c).build();
    }

    private Widget composedCard() {
        return Center().child(
                ScaleTransition(curved(Curves.elasticOut()))
                        .child(RotationTransition(curved(Curves.easeOut()))
                                .child(FadeTransition(curved(Curves.easeIn()))
                                        .child(heroCard()))));
    }

    private Widget heroCard() {
        return Container()
                .width(148.0).height(148.0)
                .decoration(BoxDecoration()
                        .color(Palette.accentTeal())
                        .borderRadius(BorderRadius_circular(32.0))
                        .boxShadow(List.of(Palette.softShadow())))
                .child(Center().child(
                        Icon(Icons.rocket_rounded()).color(Colors.white()).size(72.0)));
    }

    private Widget controlsRow() {
        return Wrap()
                .spacing(10.0).runSpacing(10.0)
                .alignment(WrapAlignment.center)
                .children(List.of(
                        FilledButton().onPressed(this::playForward).child(Text("Reveal")),
                        FilledButton_tonal().onPressed(this::playReverse).child(Text("Hide")),
                        OutlinedButton().onPressed(mainCtrl::stop).child(Text("Stop")),
                        OutlinedButton().onPressed(this::resume).child(Text("Resume")),
                        ElevatedButton().onPressed(mainCtrl::repeat).child(Text("Pulse")),
                        ElevatedButton().onPressed(mainCtrl::reset).child(Text("Reset"))
                ));
    }

    private Widget speedRow() {
        return Wrap()
                .spacing(10.0).alignment(WrapAlignment.center)
                .children(List.of(
                        speedBtn("Slow",   1800),
                        speedBtn("Normal",  900),
                        speedBtn("Fast",    300)
                ));
    }

    private Widget speedBtn(String label, int millis) {
        return OutlinedButton().onPressed(() -> mainCtrl.setDuration(Duration().milliseconds(millis)))
                .child(Text(label));
    }

    private void playForward() { lastForward = true; mainCtrl.forward(); }
    private void playReverse() { lastForward = false; mainCtrl.reverse(); }
    private void resume()      { if (lastForward) mainCtrl.forward(); else mainCtrl.reverse(); }

    // ── Hold-to-spin ───────────────────────────────────────────────────────────

    private Widget holdBadgeRow() {
        return Center().child(
                GestureDetector()
                        .onLongPress(holdCtrl::forward)
                        .onLongPressUp(holdCtrl::reverse)
                        .child(RotationTransition(holdCtrl).child(starBadge())));
    }

    private Widget starBadge() {
        return Container()
                .width(148.0).height(148.0)
                .decoration(BoxDecoration()
                        .color(Palette.accentAmber())
                        .borderRadius(BorderRadius_circular(74.0))
                        .boxShadow(List.of(Palette.softShadow())))
                .child(Center().child(
                        Icon(Icons.star()).color(Colors.white()).size(72.0)));
    }

}
