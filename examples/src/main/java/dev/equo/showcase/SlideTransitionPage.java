package dev.equo.showcase;

import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/**
 * Demonstrates SlideTransition driven by an OffsetTween (web-only Animation<Offset>).
 * The card slides in from below (Offset(0,1) → Offset(0,0)) and back out on reverse.
 */
public class SlideTransitionPage extends SubStatefulWidget {
    private final Runnable goBack;

    public SlideTransitionPage(Runnable goBack) {
        this.goBack = goBack;
    }

    @Override
    protected State<SlideTransitionPage> createState() {
        return new SlideTransitionPageState(goBack);
    }
}

class SlideTransitionPageState extends SubAnimatedState<SlideTransitionPage> {
    private final Runnable goBack;
    private AnimationController ctrl;

    SlideTransitionPageState(Runnable goBack) {
        this.goBack = goBack;
    }

    @Override
    public void initState() {
        super.initState();
        ctrl = animationController(Duration().milliseconds(600));
    }

    @Override
    public Widget build(BuildContext context) {
        var position = OffsetAnimation.create(Offset(0.0, 1.0).build(), Offset(0.0, 0.0).build(), ctrl);
        return Scaffold()
                .backgroundColor(Colors.white())
                .appBar(AppBar()
                        .title(Text("SlideTransition"))
                        .backgroundColor(Palette.accentPink())
                        .foregroundColor(Colors.white())
                        .leading(IconButton()
                                .icon(Icon(Icons.arrow_back_rounded()))
                                .color(Colors.white())
                                .onPressed(goBack)))
                .body(SafeArea().child(
                        Padding(EdgeInsets_all(24.0)).child(
                                Column()
                                        .crossAxisAlignment(CrossAxisAlignment.stretch)
                                        .children(List.of(
                                                Text("OffsetTween → Animation<Offset>").style(Palette.sectionTitle()),
                                                SizedBox().height(6.0),
                                                Text("Tween<Offset>(begin: Offset(0,1), end: Offset(0,0)).animate(ctrl) "
                                                        + "— the card slides in from below.")
                                                        .style(Palette.subtitle()),
                                                SizedBox().height(40.0),
                                                Center().child(
                                                        SlideTransition(position).child(slideCard())),
                                                SizedBox().height(40.0),
                                                Wrap()
                                                        .spacing(10.0).runSpacing(10.0)
                                                        .alignment(WrapAlignment.center)
                                                        .children(List.of(
                                                                FilledButton().onPressed(ctrl::forward).child(Text("Slide In")),
                                                                FilledButton_tonal().onPressed(ctrl::reverse).child(Text("Slide Out")),
                                                                OutlinedButton().onPressed(ctrl::repeat).child(Text("Bounce")),
                                                                OutlinedButton().onPressed(ctrl::reset).child(Text("Reset"))
                                                        )),
                                                SizedBox().height(24.0),
                                                Text("Speed").style(Palette.sectionTitle()),
                                                SizedBox().height(12.0),
                                                Wrap()
                                                        .spacing(10.0).alignment(WrapAlignment.center)
                                                        .children(List.of(
                                                                speedBtn("Slow", 1200),
                                                                speedBtn("Normal", 600),
                                                                speedBtn("Fast", 250)
                                                        ))
                                        )))));
    }

    private Widget speedBtn(String label, int millis) {
        return OutlinedButton().onPressed(() -> ctrl.setDuration(Duration().milliseconds(millis)))
                .child(Text(label));
    }

    private Widget slideCard() {
        return Container()
                .width(240.0)
                .decoration(BoxDecoration()
                        .color(Palette.accentPink())
                        .borderRadius(BorderRadius_circular(28.0))
                        .boxShadow(List.of(Palette.softShadow())))
                .child(Padding(EdgeInsets_all(28.0))
                        .child(Column()
                                .mainAxisSize(MainAxisSize.min)
                                .children(List.of(
                                        Center().child(Icon(Icons.swipe_up_rounded())
                                                .color(Colors.white()).size(56.0)),
                                        SizedBox().height(16.0),
                                        Center().child(Text("SlideTransition")
                                                .style(TextStyle()
                                                        .color(Colors.white())
                                                        .fontSize(18.0)
                                                        .fontWeight(FontWeight.w700()))),
                                        SizedBox().height(6.0),
                                        Center().child(Text("OffsetTween · web-only")
                                                .style(TextStyle()
                                                        .color(Colors.white70())
                                                        .fontSize(13.0)))
                                ))));
    }
}
