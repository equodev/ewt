package dev.equo.showcase;

import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/**
 * Interactive playground:
 *   - "Hold to spin" badge driven by GestureDetector.onLongPress /
 *     onLongPressUp. The long press plays a rotation forward, releasing
 *     reverses it.
 *   - A pulsing heart that loops scale + fade when you tap it (and stops
 *     on a second tap).
 *   - A counter whose number pops with an elastic scale on every tap of
 *     the FloatingActionButton.
 */
public class InteractivePage extends SubStatefulWidget {
    private final Runnable goBack;

    public InteractivePage(Runnable goBack) {
        this.goBack = goBack;
    }

    @Override
    protected State<InteractivePage> createState() {
        return new InteractivePageState(goBack);
    }
}

class InteractivePageState extends SubAnimatedState<InteractivePage> {
    private final Runnable goBack;
    private AnimationController spinCtrl;

    InteractivePageState(Runnable goBack) {
        this.goBack = goBack;
    }
    private AnimationController pulseCtrl;
    private AnimationController popCtrl;
    private int count = 0;
    private boolean pulsing = false;

    @Override
    public void initState() {
        super.initState();
        spinCtrl  = animationController(Duration().milliseconds(700));
        pulseCtrl = animationController(Duration().milliseconds(600));
        popCtrl   = animationController(Duration().milliseconds(450));
    }

    @Override
    public Widget build(BuildContext context) {
        return Scaffold()
                .backgroundColor(Palette.bgInteract())
                .appBar(appBar())
                .floatingActionButton(FloatingActionButton_extended()
                        .onPressed(this::bumpCounter)
                        .backgroundColor(Palette.accentTeal())
                        .foregroundColor(Colors.white())
                        .icon(Icon(Icons.add_rounded()))
                        .label(Text("Bump")))
                .body(SafeArea().child(SingleChildScrollView().child(
                        Padding(EdgeInsets_all(24.0)).child(content())
                )));
    }

    private AppBarI appBar() {
        return AppBar()
                .title(Text("Interactive Lab"))
                .backgroundColor(Palette.accentTeal())
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
                        sectionCard("Hold to spin",
                                "Long-press the badge. Forward while held, reverse on release.",
                                Center().child(holdToSpin())),
                        SizedBox().height(20.0),
                        sectionCard("Tap to spin",
                                "Tap the heart to start a continuous rotation. Tap again to stop.",
                                Center().child(pulseHeart())),
                        SizedBox().height(20.0),
                        sectionCard("Pop counter",
                                "The number scales with an elastic pop on every press of the FAB.",
                                Center().child(counterDisplay())),
                        SizedBox().height(120.0)
                ));
    }

    private Widget sectionCard(String title, String subtitle, Widget body) {
        return Container()
                .padding(EdgeInsets_all(20.0))
                .decoration(BoxDecoration()
                        .color(Colors.white())
                        .borderRadius(BorderRadius_circular(22.0))
                        .boxShadow(List.of(Palette.softShadow())))
                .child(Column()
                        .crossAxisAlignment(CrossAxisAlignment.stretch)
                        .children(List.of(
                                Text(title).style(Palette.sectionTitle()),
                                SizedBox().height(4.0),
                                Text(subtitle).style(Palette.caption()),
                                SizedBox().height(20.0),
                                body
                        )));
    }

    // ---- Hold-to-spin ------------------------------------------------------

    private Widget holdToSpin() {
        return GestureDetector()
                .onLongPress(spinCtrl::forward)
                .onLongPressUp(spinCtrl::reverse)
                .child(RotationTransition(spinCtrl).child(spinBadge()));
    }

    private Widget spinBadge() {
        return Container()
                .width(140.0)
                .height(140.0)
                .decoration(BoxDecoration()
                        .color(Palette.accentIndigo())
                        .borderRadius(BorderRadius_circular(70.0))
                        .boxShadow(List.of(Palette.softShadow())))
                .child(Center().child(Icon(Icons.hub_rounded())
                        .color(Colors.white()).size(64.0)));
    }

    // ---- Pulse heart -------------------------------------------------------

    private Widget pulseHeart() {
        return GestureDetector()
                .onTap(this::togglePulse)
                .child(RotationTransition(pulseCtrl).child(heartBadge()));
    }

    private Widget heartBadge() {
        return Container()
                .width(140.0)
                .height(140.0)
                .decoration(BoxDecoration()
                        .color(Palette.accentPink())
                        .borderRadius(BorderRadius_circular(70.0))
                        .boxShadow(List.of(Palette.softShadow())))
                .child(Center().child(Icon(Icons.favorite_rounded())
                        .color(Colors.white()).size(72.0)));
    }

    private void togglePulse() {
        if (pulsing) {
            pulseCtrl.stop();
            pulsing = false;
        } else {
            pulseCtrl.repeat();
            pulsing = true;
        }
    }

    // ---- Counter -----------------------------------------------------------

    private Widget counterDisplay() {
        return ScaleTransition(CurvedAnimation(popCtrl, Curves.elasticOut()).build())
                .child(Container()
                        .padding(EdgeInsets_symmetric().horizontal(36.0).vertical(20.0))
                        .decoration(BoxDecoration()
                                .color(Palette.accentCyan())
                                .borderRadius(BorderRadius_circular(22.0))
                                .boxShadow(List.of(Palette.softShadow())))
                        .child(Text(String.valueOf(count))
                                .style(TextStyle()
                                        .fontSize(56.0)
                                        .fontWeight(FontWeight.w800())
                                        .color(Colors.white())
                                        .letterSpacing(1.0))));
    }

    private void bumpCounter() {
        setState(() -> count++);
        popCtrl.reset();
        popCtrl.forward();
    }
}
