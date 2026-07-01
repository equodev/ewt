package dev.equo.showcase;

import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/**
 * Three side-by-side animated tiles driven by a single AnimationController,
 * each composing a different stack of transitions (scale, rotation, fade)
 * with its own curve. Buttons play / reverse / loop / stop the controller;
 * a second row swaps duration on the fly to demonstrate setDuration.
 */
public class AnimationLabPage extends SubStatefulWidget {
    private final Runnable goBack;

    public AnimationLabPage(Runnable goBack) {
        this.goBack = goBack;
    }

    @Override
    protected State<AnimationLabPage> createState() {
        return new AnimationLabPageState(goBack);
    }
}

class AnimationLabPageState extends SubAnimatedState<AnimationLabPage> {
    private final Runnable goBack;
    private AnimationController ctrl;
    private boolean lastForward = true;

    AnimationLabPageState(Runnable goBack) {
        this.goBack = goBack;
    }

    @Override
    public void initState() {
        super.initState();
        ctrl = animationController(Duration().milliseconds(1100));
        ctrl.forward();
    }

    private CurvedAnimation curved(Curve c) {
        return CurvedAnimation(ctrl, c).build();
    }

    @Override
    public Widget build(BuildContext context) {
        return Scaffold()
                .backgroundColor(Palette.bgLab())
                .appBar(appBar(context))
                .body(SafeArea().child(SingleChildScrollView().child(
                        Padding(EdgeInsets_all(24.0)).child(content())
                )));
    }

    private AppBarI appBar(BuildContext context) {
        return AppBar()
                .title(Text("Animation Lab"))
                .backgroundColor(Palette.accentPink())
                .foregroundColor(Colors.white())
                .leading(IconButton()
                        .icon(Icon(Icons.arrow_back_rounded()))
                        .color(Colors.white())
                        .onPressed(goBack));
    }

    private Widget content() {
        return Column()
                .crossAxisAlignment(CrossAxisAlignment.stretch)
                .children(List.of(
                        Text("Composed transitions").style(Palette.sectionTitle()),
                        SizedBox().height(8.0),
                        Text("One controller drives scale, rotation and opacity on three tiles, each through a different curve.")
                                .style(Palette.subtitle()),
                        SizedBox().height(28.0),
                        animatedTilesRow(),
                        SizedBox().height(36.0),
                        Text("Controls").style(Palette.sectionTitle()),
                        SizedBox().height(12.0),
                        controlsRow(),
                        SizedBox().height(24.0),
                        Text("Speed").style(Palette.sectionTitle()),
                        SizedBox().height(12.0),
                        speedRow(),
                        SizedBox().height(40.0)
                ));
    }

    private Widget animatedTilesRow() {
        return Row()
                .mainAxisAlignment(MainAxisAlignment.spaceEvenly)
                .children(List.of(
                        tile(Icons.rocket_rounded(), Palette.accentPink(),
                                Curves.elasticOut(), Curves.easeOut(), Curves.easeIn()),
                        tile(Icons.bolt_rounded(), Palette.accentAmber(),
                                Curves.easeOutBack(), Curves.easeInOut(), Curves.easeIn()),
                        tile(Icons.favorite_rounded(), Palette.accentOrange(),
                                Curves.easeOutCubic(), Curves.easeInOut(), Curves.easeIn())
                ));
    }

    private Widget tile(IconDataI icon, Color tint, Curve scale, Curve rotate, Curve fade) {
        return ScaleTransition(curved(scale))
                .child(RotationTransition(curved(rotate))
                        .child(FadeTransition(curved(fade))
                                .child(tileCard(icon, tint))));
    }

    private Widget tileCard(IconDataI icon, Color tint) {
        return Container()
                .width(96.0)
                .height(96.0)
                .decoration(BoxDecoration()
                        .color(tint)
                        .borderRadius(BorderRadius_circular(24.0))
                        .boxShadow(List.of(Palette.softShadow())))
                .child(Center().child(Icon(icon).color(Colors.white()).size(40.0)));
    }

    private Widget controlsRow() {
        return Wrap()
                .spacing(10.0)
                .runSpacing(10.0)
                .alignment(WrapAlignment.center)
                .children(List.of(
                        FilledButton(this::playForward).child(Text("Reveal")),
                        FilledButton_tonal(this::playReverse).child(Text("Hide")),
                        OutlinedButton(ctrl::stop).child(Text("Stop")),
                        OutlinedButton(this::resume).child(Text("Resume")),
                        ElevatedButton(ctrl::repeat).child(Text("Pulse")),
                        ElevatedButton(ctrl::reset).child(Text("Reset"))
                ));
    }

    private Widget speedRow() {
        return Wrap()
                .spacing(10.0)
                .alignment(WrapAlignment.center)
                .children(List.of(
                        speedButton("Slow", 2000),
                        speedButton("Normal", 1100),
                        speedButton("Fast", 400)
                ));
    }

    private Widget speedButton(String label, int millis) {
        return OutlinedButton(() -> ctrl.setDuration(Duration().milliseconds(millis)))
                .child(Text(label));
    }

    private void playForward() {
        lastForward = true;
        ctrl.forward();
    }

    private void playReverse() {
        lastForward = false;
        ctrl.reverse();
    }

    private void resume() {
        if (lastForward) ctrl.forward();
        else ctrl.reverse();
    }
}
