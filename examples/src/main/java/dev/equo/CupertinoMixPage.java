package dev.equo;

import dev.equo.ewt.*;

import java.util.List;

import static dev.equo.ewt.EWT.*;

/**
 * Cupertino + Material mix showcase: demonstrates the same UI patterns
 * implemented with both widget families side-by-side.
 *
 * <p>Desktop:
 * <pre>
 *   ./gradlew :examples:run -PuseLocal=true -PmainClass=dev.equo.CupertinoMixPage
 * </pre>
 *
 * <p>Web (via Evolve): select "Cupertino Mix" in the EvolveSamples combo.
 */
public class CupertinoMixPage {

    public static void main(String[] args) {
        App.runApp(Root::new);
    }

    static class Root extends SubStatelessWidget {
        @Override
        protected Widget build(BuildContext ctx) {
            return MaterialApp()
                    .title("Cupertino Mix")
                    .theme(ThemeData()
                            .colorScheme(ColorScheme_fromSeed(Colors.blueGrey()))
                            .useMaterial3(true))
                    .home(new Page());
        }
    }

    // Public so EvolveSamples can reference it.
    public static class Page extends SubStatefulWidget {
        @Override
        protected State<Page> createState() {
            return new PageState();
        }
    }

    static class PageState extends SubState<Page> {

        boolean materialSwitch = true;
        boolean cupertinoSwitch = true;
        double materialSlider = 40.0;
        double cupertinoSlider = 40.0;
        String materialText = "";
        String cupertinoText = "";
        boolean loading = false;

        @Override
        public Widget build(BuildContext ctx) {
            return Scaffold()
                    .backgroundColor(Color(0xFFF0F4F8))
                    .appBar(AppBar()
                            .backgroundColor(Colors.blueGrey().shade700())
                            .foregroundColor(Colors.white())
                            .title(Text("Cupertino + Material")))
                    .body(SingleChildScrollView()
                            .child(Padding(EdgeInsets_symmetric().horizontal(16.0).vertical(20.0))
                                    .child(Column()
                                            .crossAxisAlignment(CrossAxisAlignment.stretch)
                                            .children(List.of(
                                                    _headerBanner(),
                                                    SizedBox().height(16.0),
                                                    _switchCard(),
                                                    SizedBox().height(16.0),
                                                    _sliderCard(),
                                                    SizedBox().height(16.0),
                                                    _textInputCard(),
                                                    SizedBox().height(16.0),
                                                    _loadingCard(),
                                                    SizedBox().height(16.0),
                                                    _cupertinoListCard(),
                                                    SizedBox().height(40.0)
                                            )))));
        }

        // ---- layout helpers ----

        private Widget _card(String title, String subtitle, Widget body) {
            return Card()
                    .elevation(2.0)
                    .child(Padding(EdgeInsets_all(20.0))
                            .child(Column()
                                    .crossAxisAlignment(CrossAxisAlignment.stretch)
                                    .children(List.of(
                                            Text(title).style(TextStyle()
                                                    .fontSize(17.0)
                                                    .fontWeight(FontWeight.w700())),
                                            SizedBox().height(4.0),
                                            Text(subtitle).style(TextStyle()
                                                    .fontSize(12.0)
                                                    .color(Colors.grey().shade600())),
                                            SizedBox().height(16.0),
                                            body
                                    ))));
        }

        private Widget _colLabel(String label) {
            return Center().child(Text(label).style(TextStyle()
                    .fontSize(11.0)
                    .fontWeight(FontWeight.w600())
                    .color(Colors.blueGrey().shade400())));
        }

        private Widget _sideBySide(Widget left, Widget right) {
            return Row()
                    .mainAxisAlignment(MainAxisAlignment.spaceEvenly)
                    .children(List.of(
                            Expanded().child(Column()
                                    .crossAxisAlignment(CrossAxisAlignment.center)
                                    .children(List.of(
                                            _colLabel("Material"),
                                            SizedBox().height(10.0),
                                            left
                                    ))),
                            Container()
                                    .width(1.0)
                                    .height(64.0)
                                    .color(Colors.grey().shade300()),
                            Expanded().child(Column()
                                    .crossAxisAlignment(CrossAxisAlignment.center)
                                    .children(List.of(
                                            _colLabel("Cupertino"),
                                            SizedBox().height(10.0),
                                            right
                                    )))
                    ));
        }

        // ---- header ----

        private Widget _headerBanner() {
            return Container()
                    .padding(EdgeInsets_all(20.0))
                    .decoration(BoxDecoration()
                            .color(Colors.blueGrey().shade700())
                            .borderRadius(BorderRadius_circular(16.0)))
                    .child(Column()
                            .crossAxisAlignment(CrossAxisAlignment.start)
                            .children(List.of(
                                    Row().children(List.of(
                                            Icon(Icons.compare_arrows_rounded())
                                                    .color(Colors.white()).size(26.0),
                                            SizedBox().width(10.0),
                                            Text("Cupertino + Material Mix").style(TextStyle()
                                                    .fontSize(18.0)
                                                    .fontWeight(FontWeight.w800())
                                                    .color(Colors.white()))
                                    )),
                                    SizedBox().height(8.0),
                                    Text("Same behavior, two widget families. "
                                            + "Each card shows the Material and Cupertino "
                                            + "implementations side-by-side — both controlled from Java.")
                                            .style(TextStyle()
                                                    .fontSize(13.0)
                                                    .color(Colors.white70())
                                                    .height(1.5))
                            )));
        }

        // ---- switch ----

        private Widget _switchCard() {
            return _card(
                    "Toggle",
                    "Switch.value and CupertinoSwitch.value are separate Java booleans.",
                    _sideBySide(
                            Column().crossAxisAlignment(CrossAxisAlignment.center).children(List.of(
                                    Switch(materialSwitch).onChanged(v -> setState(() -> materialSwitch = v)),
                                    Text(materialSwitch ? "ON" : "OFF").style(TextStyle().fontSize(12.0))
                            )),
                            Column().crossAxisAlignment(CrossAxisAlignment.center).children(List.of(
                                    CupertinoSwitch(cupertinoSwitch).onChanged(v -> setState(() -> cupertinoSwitch = v)),
                                    Text(cupertinoSwitch ? "ON" : "OFF").style(TextStyle().fontSize(12.0))
                            ))
                    ));
        }

        // ---- slider ----

        private Widget _sliderCard() {
            return _card(
                    "Slider",
                    "Both onChanged callbacks update independent Java doubles.",
                    _sideBySide(
                            Column().crossAxisAlignment(CrossAxisAlignment.center).children(List.of(
                                    Slider(materialSlider)
                                            .onChanged(v -> setState(() -> materialSlider = v))
                                            .min(0.0).max(100.0),
                                    Text((int) materialSlider + " %").style(TextStyle().fontSize(12.0))
                            )),
                            Column().crossAxisAlignment(CrossAxisAlignment.center).children(List.of(
                                    CupertinoSlider(cupertinoSlider).onChanged(v -> setState(() -> cupertinoSlider = v))
                                            .min(0.0).max(100.0),
                                    Text((int) cupertinoSlider + " %").style(TextStyle().fontSize(12.0))
                            ))
                    ));
        }

        // ---- text input ----

        private Widget _textInputCard() {
            return _card(
                    "Text Input",
                    "onChanged streams every keystroke to Java for both field types.",
                    _sideBySide(
                            Column().crossAxisAlignment(CrossAxisAlignment.stretch).children(List.of(
                                    TextField()
                                            .maxLines(1)
                                            .decoration(InputDecoration()
                                                    .hintText("Material…")
                                                    .border(OutlineInputBorder())
                                                    .isDense(true))
                                            .onChanged(v -> setState(() -> materialText = v)),
                                    SizedBox().height(6.0),
                                    Text(materialText.isEmpty() ? "—" : "'" + materialText + "'")
                                            .style(TextStyle().fontSize(12.0).color(Colors.grey().shade600()))
                            )),
                            Column().crossAxisAlignment(CrossAxisAlignment.stretch).children(List.of(
                                    CupertinoTextField()
                                            .placeholder("Cupertino…")
                                            .onChanged(v -> setState(() -> cupertinoText = v)),
                                    SizedBox().height(6.0),
                                    Text(cupertinoText.isEmpty() ? "—" : "'" + cupertinoText + "'")
                                            .style(TextStyle().fontSize(12.0).color(Colors.grey().shade600()))
                            ))
                    ));
        }

        // ---- loading indicators ----

        private Widget _loadingCard() {
            return _card(
                    "Activity Indicator",
                    "Toggle the Java boolean to animate both indicators simultaneously.",
                    Column().crossAxisAlignment(CrossAxisAlignment.stretch).children(List.of(
                            _sideBySide(
                                    loading
                                            ? SizedBox().width(36.0).height(36.0).child(CircularProgressIndicator())
                                            : Icon(Icons.check_circle_outline_rounded())
                                                    .color(Colors.green()).size(36.0),
                                    loading
                                            ? SizedBox().width(36.0).height(36.0).child(CupertinoActivityIndicator())
                                            : Icon(Icons.check_circle_outline_rounded())
                                                    .color(Colors.green()).size(36.0)
                            ),
                            SizedBox().height(12.0),
                            Center().child(
                                    OutlinedButton().onPressed(() -> setState(() -> loading = !loading))
                                            .child(Text(loading ? "Stop loading" : "Start loading"))
                            )
                    )));
        }

        // ---- cupertino list ----

        private Widget _cupertinoListCard() {
            return _card(
                    "Cupertino List",
                    "CupertinoListSection gives the iOS grouped-settings look.",
                    CupertinoListSection_insetGrouped()
                            .children(List.of(
                                    CupertinoListTile(Text("Notifications"))
                                            .leading(Icon(Icons.notifications_outlined())
                                                    .color(Colors.red()))
                                            .trailing(CupertinoSwitch(materialSwitch).onChanged(v -> setState(() -> materialSwitch = v))),
                                    CupertinoListTile(Text("Appearance"))
                                            .leading(Icon(Icons.palette_outlined())
                                                    .color(Colors.purple()))
                                            .trailing(CupertinoListTileChevron()),
                                    CupertinoListTile(Text("Privacy"))
                                            .leading(Icon(Icons.lock_outline_rounded())
                                                    .color(Colors.blue()))
                                            .trailing(CupertinoListTileChevron())
                            ))
            );
        }
    }
}
