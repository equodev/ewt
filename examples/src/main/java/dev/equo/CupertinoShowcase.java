package dev.equo;

import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/**
 * Standalone Cupertino showcase: CupertinoApp, CupertinoPageScaffold,
 * CupertinoNavigationBar, CupertinoButton (3 variants), CupertinoSwitch,
 * CupertinoSlider, CupertinoActivityIndicator and CupertinoListSection.
 *
 * <p>Desktop:
 * <pre>
 *   ./gradlew :examples:run -PuseLocal=true -PmainClass=dev.equo.CupertinoShowcase
 * </pre>
 *
 * <p>Web (via Evolve comm):
 * <pre>
 *   (cd evolve-app && flutter build web --no-tree-shake-icons)
 *   ./gradlew :examples:runShowcaseWeb -PuseLocal=true
 *   # then pick "Cupertino Showcase" in the dropdown
 * </pre>
 */
public class CupertinoShowcase {

    public static void main(String[] args) {
        App.runApp(Root::new);
    }

    static class Root extends SubStatelessWidget {
        @Override
        protected Widget build(BuildContext ctx) {
            return new ShowcasePage();
        }
    }

    /** Root widget for the Cupertino showcase. Wraps in CupertinoApp so
     *  CupertinoPageScaffold and friends get the proper theme context. */
    public static class ShowcasePage extends SubStatelessWidget {
        private final Runnable goBack;

        public ShowcasePage() { this(() -> {}); }
        public ShowcasePage(Runnable goBack) { this.goBack = goBack; }

        @Override
        protected Widget build(BuildContext ctx) {
            return CupertinoApp()
                    .title("Cupertino Showcase")
                    .home(new Content(goBack));
        }
    }

    static class Content extends SubStatefulWidget {
        private final Runnable goBack;

        Content(Runnable goBack) { this.goBack = goBack; }

        @Override
        protected State<Content> createState() {
            return new ContentState(goBack);
        }
    }

    static class ContentState extends SubState<Content> {
        private final Runnable goBack;
        boolean darkMode     = true;
        boolean notifications = false;
        double  volume       = 0.6;
        int     pressCount   = 0;

        ContentState(Runnable goBack) { this.goBack = goBack; }

        // iOS system colors — each method returns a fresh instance (Color handles are consumed on first use)
        private static ColorColorBuilder kBlue()     { return Color(0xFF007AFF); }
        private static ColorColorBuilder kGreen()    { return Color(0xFF34C759); }
        private static ColorColorBuilder kOrange()   { return Color(0xFFFF9500); }
        private static ColorColorBuilder kRed()      { return Color(0xFFFF3B30); }
        private static ColorColorBuilder kBg()       { return Color(0xFFF2F2F7); }
        private static ColorColorBuilder kCard()     { return Color(0xFFFFFFFF); }
        private static ColorColorBuilder kLabel()    { return Color(0xFF1C1C1E); }
        private static ColorColorBuilder kSecLabel() { return Color(0xFF8E8E93); }
        private static ColorColorBuilder kGray()     { return Color(0xFF636366); }

        @Override
        public Widget build(BuildContext ctx) {
            return CupertinoPageScaffold()
                    .backgroundColor(kBg())
                    .navigationBar(CupertinoNavigationBar()
                            .backgroundColor(kCard())
                            .leading(CupertinoButton(Icon(Icons.arrow_back_ios_new_rounded()))
                                    .padding(EdgeInsets_all(0.0))
                                    .onPressed(goBack))
                            .middle(Text("Cupertino Showcase")))
                    .child(SafeArea().child(
                            SingleChildScrollView().child(
                                    Padding(EdgeInsets_symmetric().horizontal(16.0).vertical(20.0))
                                            .child(Column()
                                                    .crossAxisAlignment(CrossAxisAlignment.stretch)
                                                    .children(List.of(
                                                            _hero(),
                                                            SizedBox().height(24.0),
                                                            _buttonsCard(),
                                                            SizedBox().height(24.0),
                                                            _controlsSection(),
                                                            SizedBox().height(24.0),
                                                            _sliderCard(),
                                                            SizedBox().height(24.0),
                                                            _settingsList(),
                                                            SizedBox().height(40.0)
                                                    ))))));
        }

        // ── Hero ─────────────────────────────────────────────────────────────

        private Widget _hero() {
            return Container()
                    .padding(EdgeInsets_all(24.0))
                    .decoration(BoxDecoration()
                            .color(kBlue())
                            .borderRadius(BorderRadius_circular(24.0))
                            .boxShadow(List.of(BoxShadow()
                                    .color(Color_fromRGBO(0, 122, 255, 0.35))
                                    .blurRadius(28.0)
                                    .offset(Offset(0.0, 10.0)))))
                    .child(Column()
                            .crossAxisAlignment(CrossAxisAlignment.start)
                            .children(List.of(
                                    Row()
                                            .crossAxisAlignment(CrossAxisAlignment.center)
                                            .children(List.of(
                                                    Container()
                                                            .width(62.0).height(62.0)
                                                            .decoration(BoxDecoration()
                                                                    .color(Color_fromRGBO(255, 255, 255, 0.2))
                                                                    .borderRadius(BorderRadius_circular(18.0)))
                                                            .child(Center().child(
                                                                    Icon(Icons.phone_iphone_rounded())
                                                                            .color(Colors.white())
                                                                            .size(38.0))),
                                                    SizedBox().width(16.0),
                                                    Column()
                                                            .crossAxisAlignment(CrossAxisAlignment.start)
                                                            .children(List.of(
                                                                    Text("Cupertino").style(TextStyle()
                                                                            .color(Colors.white())
                                                                            .fontSize(26.0)
                                                                            .fontWeight(FontWeight.w800())
                                                                            .letterSpacing(-0.5)),
                                                                    SizedBox().height(3.0),
                                                                    Text("Flutter's iOS-native widget set").style(TextStyle()
                                                                            .color(Color_fromRGBO(255, 255, 255, 0.75))
                                                                            .fontSize(13.0)
                                                                            .height(1.4))
                                                            ))
                                            )),
                                    SizedBox().height(20.0),
                                    Row()
                                            .children(List.of(
                                                    _heroBadge("Buttons"),
                                                    SizedBox().width(8.0),
                                                    _heroBadge("Controls"),
                                                    SizedBox().width(8.0),
                                                    _heroBadge("List")
                                            ))
                            )));
        }

        private Widget _heroBadge(String label) {
            return Container()
                    .padding(EdgeInsets_symmetric().horizontal(12.0).vertical(5.0))
                    .decoration(BoxDecoration()
                            .color(Color_fromRGBO(255, 255, 255, 0.22))
                            .borderRadius(BorderRadius_circular(20.0)))
                    .child(Text(label).style(TextStyle()
                            .color(Colors.white())
                            .fontSize(12.0)
                            .fontWeight(FontWeight.w600())));
        }

        // ── Buttons ───────────────────────────────────────────────────────────

        private Widget _buttonsCard() {
            return _card(Column()
                    .crossAxisAlignment(CrossAxisAlignment.start)
                    .children(List.of(
                            _cardTitle("Buttons"),
                            SizedBox().height(2.0),
                            Text("CupertinoButton — plain · tinted · filled").style(TextStyle()
                                    .fontSize(13.0)
                                    .color(kSecLabel())),
                            SizedBox().height(24.0),
                            Center().child(
                                    AnimatedContainer()
                                            .duration(Duration().milliseconds(350))
                                            .width(112.0)
                                            .height(112.0)
                                            .decoration(BoxDecoration()
                                                    .color(pressCount > 0 ? kGreen()
                                                            : pressCount < 0 ? kRed()
                                                            : kBlue())
                                                    .shape(BoxShape.circle)
                                                    .boxShadow(List.of(BoxShadow()
                                                            .color(Color_fromRGBO(0, 0, 0, 0.12))
                                                            .blurRadius(20.0)
                                                            .offset(Offset(0.0, 6.0)))))
                                            .child(Center().child(
                                                    Column()
                                                            .mainAxisSize(MainAxisSize.min)
                                                            .children(List.of(
                                                                    Text(pressCount > 0 ? "+" + pressCount
                                                                            : String.valueOf(pressCount))
                                                                            .style(TextStyle()
                                                                                    .fontSize(36.0)
                                                                                    .fontWeight(FontWeight.w800())
                                                                                    .color(Colors.white())
                                                                                    .height(1.0)),
                                                                    Text("taps").style(TextStyle()
                                                                            .fontSize(11.0)
                                                                            .color(Color_fromRGBO(255, 255, 255, 0.75)))
                                                            ))))),
                            SizedBox().height(24.0),
                            Row()
                                    .mainAxisAlignment(MainAxisAlignment.spaceEvenly)
                                    .children(List.of(
                                            CupertinoButton_filled(Row()
                                                    .mainAxisSize(MainAxisSize.min)
                                                    .children(List.of(
                                                            Icon(Icons.add_rounded()).size(18.0).color(Colors.white()),
                                                            SizedBox().width(4.0),
                                                            Text("Inc"))))
                                                    .onPressed(() -> setState(() -> pressCount++)),
                                            CupertinoButton_tinted(Text("Reset"))
                                                    .onPressed(() -> setState(() -> pressCount = 0)),
                                            CupertinoButton(Row()
                                                    .mainAxisSize(MainAxisSize.min)
                                                    .children(List.of(
                                                            Icon(Icons.remove_rounded()).size(18.0),
                                                            SizedBox().width(4.0),
                                                            Text("Dec"))))
                                                    .onPressed(() -> setState(() -> pressCount--))
                                    ))
                    )));
        }

        // ── Controls ──────────────────────────────────────────────────────────

        private Widget _controlsSection() {
            return Column()
                    .crossAxisAlignment(CrossAxisAlignment.start)
                    .children(List.of(
                            _sectionLabel("PREFERENCES"),
                            CupertinoListSection_insetGrouped()
                                    .children(List.of(
                                            _controlRow(kBlue(), Icons.dark_mode_rounded(), "Dark Mode",
                                                    CupertinoSwitch(darkMode, v -> setState(() -> darkMode = v)),
                                                    darkMode ? "On" : "Off"),
                                            _controlRow(kOrange(), Icons.notifications_rounded(), "Notifications",
                                                    CupertinoSwitch(notifications, v -> setState(() -> notifications = v)),
                                                    notifications ? "On" : "Off"),
                                            _controlRow(kGreen(), Icons.sync_rounded(), "Syncing",
                                                    CupertinoActivityIndicator(),
                                                    "Active")
                                    ))
                    ));
        }

        private Widget _controlRow(ColorI iconBg, IconDataI icon, String label, WidgetI trailing, String detail) {
            return CupertinoListTile(
                    Row().crossAxisAlignment(CrossAxisAlignment.center).children(List.of(
                            _iconBadge(iconBg, icon),
                            SizedBox().width(12.0),
                            Text(label)
                    )))
                    .additionalInfo(Text(detail).style(TextStyle().color(kSecLabel())))
                    .trailing(trailing);
        }

        // ── Slider ────────────────────────────────────────────────────────────

        private Widget _sliderCard() {
            IconDataI volIcon = volume < 0.01 ? Icons.volume_mute_rounded()
                    : volume < 0.5 ? Icons.volume_down_rounded()
                    : Icons.volume_up_rounded();
            return _card(Column()
                    .crossAxisAlignment(CrossAxisAlignment.start)
                    .children(List.of(
                            _cardTitle("Slider"),
                            SizedBox().height(2.0),
                            Text("CupertinoSlider").style(TextStyle()
                                    .fontSize(13.0)
                                    .color(kSecLabel())),
                            SizedBox().height(20.0),
                            Row()
                                    .crossAxisAlignment(CrossAxisAlignment.center)
                                    .children(List.of(
                                            Container()
                                                    .width(38.0).height(38.0)
                                                    .decoration(BoxDecoration()
                                                            .color(Color(0xFFF2F2F7))
                                                            .borderRadius(BorderRadius_circular(10.0)))
                                                    .child(Center().child(
                                                            Icon(volIcon).color(kBlue()).size(20.0))),
                                            SizedBox().width(12.0),
                                            Expanded().child(
                                                    CupertinoSlider(volume, v -> setState(() -> volume = v))
                                                            .min(0.0)
                                                            .max(1.0)
                                                            .divisions(20)
                                                            .activeColor(kBlue())),
                                            SizedBox().width(12.0),
                                            Text(String.format("%.0f%%", volume * 100)).style(TextStyle()
                                                    .fontSize(14.0)
                                                    .fontWeight(FontWeight.w600())
                                                    .color(kLabel()))
                                    ))
                    )));
        }

        // ── Settings list ─────────────────────────────────────────────────────

        private Widget _settingsList() {
            return Column()
                    .crossAxisAlignment(CrossAxisAlignment.start)
                    .children(List.of(
                            _sectionLabel("APP SETTINGS"),
                            CupertinoListSection_insetGrouped()
                                    .children(List.of(
                                            _navRow(kBlue(), Icons.palette_rounded(), "Appearance"),
                                            _navRow(kGreen(), Icons.lock_rounded(), "Privacy & Security"),
                                            _navRow(kGray(), Icons.settings_rounded(), "General"),
                                            _navRow(kGray(), Icons.info_rounded(), "About")
                                    ))
                    ));
        }

        private Widget _navRow(ColorI iconBg, IconDataI icon, String label) {
            return CupertinoListTile(
                    Row().crossAxisAlignment(CrossAxisAlignment.center).children(List.of(
                            _iconBadge(iconBg, icon),
                            SizedBox().width(12.0),
                            Text(label)
                    )))
                    .trailing(CupertinoListTileChevron());
        }

        // ── Shared helpers ────────────────────────────────────────────────────

        private Widget _iconBadge(ColorI bg, IconDataI icon) {
            return Container()
                    .width(30.0).height(30.0)
                    .decoration(BoxDecoration()
                            .color(bg)
                            .borderRadius(BorderRadius_circular(7.0)))
                    .child(Center().child(
                            Icon(icon).color(Colors.white()).size(17.0)));
        }

        private Widget _card(WidgetI content) {
            return Container()
                    .padding(EdgeInsets_all(20.0))
                    .decoration(BoxDecoration()
                            .color(kCard())
                            .borderRadius(BorderRadius_circular(16.0))
                            .boxShadow(List.of(BoxShadow()
                                    .color(Color_fromRGBO(0, 0, 0, 0.05))
                                    .blurRadius(12.0)
                                    .offset(Offset(0.0, 2.0)))))
                    .child(content);
        }

        private Widget _cardTitle(String title) {
            return Text(title).style(TextStyle()
                    .fontSize(17.0)
                    .fontWeight(FontWeight.w700())
                    .color(kLabel()));
        }

        private Widget _sectionLabel(String label) {
            return Padding(EdgeInsets_only().left(4.0).bottom(8.0))
                    .child(Text(label).style(TextStyle()
                            .fontSize(12.0)
                            .fontWeight(FontWeight.w600())
                            .color(kSecLabel())
                            .letterSpacing(0.5)));
        }
    }
}
