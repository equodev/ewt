package dev.equo.showcase;

import java.util.List;
import java.util.function.Consumer;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/**
 * Landing page. Hero logo enters with elastic scale + rotation, then three
 * vivid NavCards fade and scale in with different curves to feel staggered.
 * Tapping a card asks the shell to swap pages via the {@code navigate}
 * callback passed in from {@link ShowcaseShell}.
 */
public class HomePage extends SubStatefulWidget {
    private final Consumer<PageId> navigate;

    public HomePage(Consumer<PageId> navigate) {
        this.navigate = navigate;
    }

    @Override
    protected State<HomePage> createState() {
        // SubAnimatedState.widget() returns null at build time in this build,
        // so we pass dependencies directly to the State via the constructor.
        return new HomePageState(navigate);
    }
}

class HomePageState extends SubAnimatedState<HomePage> {
    private final Consumer<PageId> navigate;
    private AnimationController entryCtrl;

    HomePageState(Consumer<PageId> navigate) {
        this.navigate = navigate;
    }

    @Override
    public void initState() {
        super.initState();
        entryCtrl = animationController(Duration().milliseconds(1100));
        entryCtrl.forward();
    }

    private CurvedAnimation curved(Curve c) {
        return CurvedAnimation(entryCtrl, c).build();
    }

    @Override
    public Widget build(BuildContext context) {
        return Scaffold()
                .backgroundColor(Palette.bgHome())
                .body(SafeArea().child(SingleChildScrollView().child(
                        Padding(EdgeInsets_all(24.0)).child(content())
                )));
    }

    private Widget content() {
        return Column()
                .crossAxisAlignment(CrossAxisAlignment.stretch)
                .children(List.of(
                        SizedBox().height(24.0),
                        heroLogo(),
                        SizedBox().height(28.0),
                        FadeTransition(curved(Curves.easeIn()))
                                .child(Center().child(Text("EWT Showcase").style(Palette.display()))),
                        SizedBox().height(8.0),
                        FadeTransition(curved(Curves.easeIn()))
                                .child(Center().child(Text("Modern Flutter UIs, written in Java.")
                                        .style(Palette.subtitle()))),
                        SizedBox().height(36.0),
                        navCardEntry(Curves.elasticOut(),
                                new NavCard("Animation Lab",
                                        "Composed transitions & curves",
                                        Icons::animation_rounded, Palette::accentPink,
                                        () -> navigate.accept(PageId.ANIMATION_LAB))),
                        SizedBox().height(16.0),
                        navCardEntry(Curves.easeOutBack(),
                                new NavCard("Interactive Lab",
                                        "Gestures, pulses & live counter",
                                        Icons::touch_app_rounded, Palette::accentTeal,
                                        () -> navigate.accept(PageId.INTERACTIVE))),
                        SizedBox().height(16.0),
                        navCardEntry(Curves.easeOutCubic(),
                                new NavCard("Color Gallery",
                                        "Vivid Material cards & shadows",
                                        Icons::palette_rounded, Palette::accentAmber,
                                        () -> navigate.accept(PageId.GALLERY))),
                        SizedBox().height(40.0),
                        FadeTransition(curved(Curves.easeIn())).child(footer())
                ));
    }

    private Widget navCardEntry(Curve scaleCurve, Widget card) {
        return FadeTransition(curved(Curves.easeOut()))
                .child(ScaleTransition(curved(scaleCurve)).child(card));
    }

    private Widget heroLogo() {
        return Center().child(
                ScaleTransition(curved(Curves.elasticOut())).child(
                        RotationTransition(curved(Curves.easeOut())).child(
                                Container()
                                        .width(120.0)
                                        .height(120.0)
                                        .decoration(BoxDecoration()
                                                .color(Palette.accentPurple())
                                                .borderRadius(BorderRadius_circular(60.0))
                                                .boxShadow(List.of(BoxShadow()
                                                        .color(Color_fromRGBO(103, 58, 183, 0.45))
                                                        .blurRadius(28.0)
                                                        .offset(Offset(0.0, 12.0)))))
                                        .child(Center().child(Icon(Icons.auto_awesome())
                                                .color(Colors.white()).size(60.0))))));
    }

    private Widget footer() {
        return Center().child(Text("Powered by AnimationController · Java 21 FFM")
                .style(Palette.caption()));
    }
}
