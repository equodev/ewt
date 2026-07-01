package dev.equo;

import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

public class EquoLanding {

    // Built lazily every call: the FFM runtime isn't up during class init.
    static ColorI brandBlue() { return Color(0xFF1E3AF2); }

    public static void main(String[] args) {
        App.runApp(MyApp::new);
    }

    static class MyApp extends SubStatelessWidget {
        @Override
        protected Widget build(BuildContext context) {
            return MaterialApp()
                    .title("Equo")
                    .theme(ThemeData()
                            .colorScheme(ColorScheme_fromSeed(brandBlue()))
                            .scaffoldBackgroundColor(Colors.white())
                            .useMaterial3(true))
                    .home(new LandingShell());
        }
    }

    enum Page { HOME, JOIN }

    static class LandingShell extends SubStatefulWidget {
        @Override
        protected State<LandingShell> createState() {
            return new LandingShellState();
        }
    }

    static class LandingShellState extends SubState<LandingShell> {
        private Page current = Page.HOME;

        void goToJoin() { setState(() -> current = Page.JOIN); }
        void goHome()   { setState(() -> current = Page.HOME); }

        @Override
        public Widget build(BuildContext context) {
            return switch (current) {
                case HOME -> new HomePage(this::goToJoin);
                case JOIN -> new JoinPage(this::goHome);
            };
        }
    }

    // ---------- Home page ------------------------------------------------------

    static class HomePage extends SubStatefulWidget {
        private final Runnable goToJoin;
        HomePage(Runnable goToJoin) { this.goToJoin = goToJoin; }
        @Override
        protected State<HomePage> createState() {
            return new HomePageState(goToJoin);
        }
    }

    static class HomePageState extends SubAnimatedState<HomePage> {
        private final Runnable goToJoin;
        private AnimationController subtitleCtrl;
        private AnimationController rightIconCtrl;
        private AnimationController spinSlow;
        private AnimationController spinMid;
        private AnimationController spinFast;
        private AnimationController spinReverse;

        HomePageState(Runnable goToJoin) { this.goToJoin = goToJoin; }

        @Override
        public void initState() {
            super.initState();
            subtitleCtrl = animationController(Duration().milliseconds(350));
            rightIconCtrl = animationController(Duration().milliseconds(600));
            spinSlow    = animationController(Duration().milliseconds(6000));
            spinMid     = animationController(Duration().milliseconds(4000));
            spinFast    = animationController(Duration().milliseconds(2500));
            spinReverse = animationController(Duration().milliseconds(5000));
            spinSlow.repeat();
            spinMid.repeat();
            spinFast.repeat();
            spinReverse.repeat();
        }

        @Override
        public Widget build(BuildContext context) {
            return Scaffold()
                    .backgroundColor(Colors.white())
                    .body(Stack().children(List.of(
                            spinningDecorations(),
                            Center().child(Padding(EdgeInsets_all(32.0)).child(
                                    Column()
                                            .mainAxisAlignment(MainAxisAlignment.center)
                                            .mainAxisSize(MainAxisSize.min)
                                            .children(List.of(
                                                    titleWithHover(),
                                                    SizedBox().height(48.0),
                                                    buttonsRow()
                                            ))
                            ))
                    )));
        }

        // Four vibrant icons continuously rotating in the corners. They live
        // behind the main content thanks to being placed first in the Stack.
        private Widget spinningDecorations() {
            return Stack().children(List.of(
                    Align().alignment(Alignment.topLeft()).child(
                            Padding(EdgeInsets_all(28.0)).child(spin(spinSlow,
                                    Icons.settings_rounded(), 64.0, brandBlue()))),
                    Align().alignment(Alignment.topRight()).child(
                            Padding(EdgeInsets_all(28.0)).child(spin(spinMid,
                                    Icons.auto_awesome_rounded(), 56.0,
                                    Colors.blue().shade500()))),
                    Align().alignment(Alignment.bottomLeft()).child(
                            Padding(EdgeInsets_all(28.0)).child(spin(spinReverse,
                                    Icons.sync_rounded(), 60.0,
                                    Colors.indigo().shade400()))),
                    Align().alignment(Alignment.bottomRight()).child(
                            Padding(EdgeInsets_all(28.0)).child(spin(spinFast,
                                    Icons.rocket_launch_rounded(), 56.0,
                                    Colors.lightBlue().shade600())))
            ));
        }

        private Widget spin(AnimationController c, IconDataI icon, double size, ColorI color) {
            return RotationTransition(c).child(Icon(icon).size(size).color(color));
        }

        private Widget titleWithHover() {
            return Column().mainAxisSize(MainAxisSize.min).children(List.of(
                    hoverableTitle(),
                    SizedBox().height(12.0),
                    subtitleStack()
            ));
        }

        // Hover target is only the "Equo" word so the button's rounded overlay
        // stays tight around the title and doesn't cover the subtitle below.
        private Widget hoverableTitle() {
            return TextButton(() -> {})
                    .onHover(this::setSubtitleHover)
                    .child(Text("Equo").style(TextStyle()
                            .fontSize(88.0)
                            .fontWeight(FontWeight.w800())
                            .color(brandBlue())
                            .letterSpacing(-2.5)
                            .height(1.0)
                            .fontFamily("Poppins")));
        }

        // Base "tenue" text stays at 0.30 opacity; a second copy fades 0->1 on
        // hover so the effect reads as "tenue -> full" without needing tweens.
        private Widget subtitleStack() {
            var style = TextStyle()
                    .fontSize(19.0)
                    .fontWeight(FontWeight.w500())
                    .color(Colors.grey().shade800())
                    .letterSpacing(0.3)
                    .height(1.4)
                    .fontFamily("Inter");
            return Stack().alignment(Alignment.center()).children(List.of(
                    Opacity(0.30).child(Text(subtitleText()).style(style)),
                    FadeTransition(subtitleCtrl).child(Text(subtitleText()).style(style))
            ));
        }

        private String subtitleText() {
            return "EWT: Modernize your Java apps with Flutter UI";
        }

        private void setSubtitleHover(boolean hover) {
            if (hover) subtitleCtrl.forward();
            else       subtitleCtrl.reverse();
        }

        private Widget buttonsRow() {
            return Row().mainAxisAlignment(MainAxisAlignment.center).children(List.of(
                    knowMoreButton()
            ));
        }

        // Primary filled button (colored by Material 3 seed). On hover the icon
        // spins one full turn forward; on exit it rewinds.
        private Widget knowMoreButton() {
            var label = Text("I want to know more!").style(TextStyle()
                    .fontSize(16.0)
                    .fontWeight(FontWeight.w600()));
            var spinningIcon = RotationTransition(rightIconCtrl)
                    .child(Icon(Icons.sentiment_very_satisfied_rounded()).size(20.0));
            var content = Padding(EdgeInsets_symmetric().horizontal(16.0).vertical(6.0)).child(
                    Row().mainAxisSize(MainAxisSize.min).children(List.of(
                            label,
                            SizedBox().width(8.0),
                            spinningIcon
                    )));
            return FilledButton(goToJoin)
                    .onHover(this::setRightHover)
                    .child(content);
        }

        private void setRightHover(boolean hover) {
            if (hover) rightIconCtrl.forward();
            else       rightIconCtrl.reverse();
        }
    }

    // ---------- Join page -----------------------------------------------------

    static class JoinPage extends SubStatefulWidget {
        private final Runnable goBack;
        JoinPage(Runnable goBack) { this.goBack = goBack; }
        @Override
        protected State<JoinPage> createState() {
            return new JoinPageState(goBack);
        }
    }

    static class JoinPageState extends SubAnimatedState<JoinPage> {
        private final Runnable goBack;
        private AnimationController entryCtrl;
        private boolean emailHover = false;

        JoinPageState(Runnable goBack) { this.goBack = goBack; }

        @Override
        public void initState() {
            super.initState();
            entryCtrl = animationController(Duration().milliseconds(1200));
            entryCtrl.forward();
        }

        @Override
        public Widget build(BuildContext context) {
            return Scaffold()
                    .backgroundColor(Colors.white())
                    .appBar(AppBar()
                            .backgroundColor(Colors.white())
                            .foregroundColor(Colors.grey().shade900())
                            .elevation(0.0)
                            .leading(IconButton()
                                    .icon(Icon(Icons.arrow_back_rounded()))
                                    .color(Colors.grey().shade800())
                                    .onPressed(goBack))
                            .title(Text("Join us").style(TextStyle()
                                    .color(Colors.grey().shade900())
                                    .fontWeight(FontWeight.w500()))))
                    .body(Center().child(Padding(EdgeInsets_all(32.0)).child(
                            Column()
                                    .mainAxisAlignment(MainAxisAlignment.center)
                                    .mainAxisSize(MainAxisSize.min)
                                    .children(List.of(
                                            headingBlock(),
                                            SizedBox().height(48.0),
                                            emailCard()
                                    ))
                    )));
        }

        private Widget headingBlock() {
            var fadeIn      = CurvedAnimation(entryCtrl, Curves.easeIn()).build();
            var fadeInSlow  = CurvedAnimation(entryCtrl, Curves.easeInOutCubic()).build();
            var scaleIn     = CurvedAnimation(entryCtrl, Curves.easeOutBack()).build();
            var rotateIn    = CurvedAnimation(entryCtrl, Curves.easeOut()).build();
            var heading = Text("What are you waiting to try EWT?")
                    .textAlign(TextAlign.center)
                    .style(TextStyle()
                            .fontSize(36.0)
                            .fontWeight(FontWeight.bold())
                            .color(Colors.grey().shade900())
                            .letterSpacing(-0.5));
            var join = Text("Join us!").style(TextStyle()
                    .fontSize(32.0)
                    .fontWeight(FontWeight.bold())
                    .color(brandBlue()));
            return Column().mainAxisSize(MainAxisSize.min).children(List.of(
                    // Heading enters with fade + scale so it feels like it "arrives".
                    FadeTransition(fadeIn).child(
                            ScaleTransition(scaleIn).child(heading)),
                    SizedBox().height(16.0),
                    // "Join us!" spins in a full turn while fading.
                    FadeTransition(fadeInSlow).child(
                            RotationTransition(rotateIn).child(join))
            ));
        }

        private Widget emailCard() {
            var scaleIn = CurvedAnimation(entryCtrl, Curves.elasticOut()).build();
            ColorI iconColor = emailHover ? brandBlue() : Colors.grey().shade600();
            double elevation = emailHover ? 8.0 : 2.0;
            var inner = Card()
                    .elevation(elevation)
                    .color(Colors.white())
                    .shape(RoundedRectangleBorder()
                            .borderRadius(BorderRadius_circular(14.0)))
                    .child(Padding(EdgeInsets_symmetric().horizontal(24.0).vertical(18.0)).child(
                            Row().mainAxisSize(MainAxisSize.min).children(List.of(
                                    Icon(Icons.email_outlined()).size(22.0).color(iconColor),
                                    SizedBox().width(12.0),
                                    Text("contact@equo.dev").style(TextStyle()
                                            .fontSize(20.0)
                                            .fontWeight(FontWeight.w500())
                                            .color(Colors.grey().shade900()))
                            ))
                    ));
            var hoverable = TextButton(() -> {})
                    .onHover(this::setEmailHover)
                    .child(inner);
            return ScaleTransition(scaleIn).child(hoverable);
        }

        private void setEmailHover(boolean hover) {
            if (emailHover == hover) return;
            setState(() -> emailHover = hover);
        }
    }
}
