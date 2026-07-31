package dev.equo;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;
import java.util.List;

/**
 * EWT Web Showcase: a single-page demo covering the key EWT web capabilities:
 * state (counter), callbacks (buttons, switch, slider), layout (cards, wrap)
 * and text input. All logic lives in Java; Flutter renders the result in the
 * browser.
 *
 * <p>Desktop:
 * <pre>
 *   ./gradlew :examples:run -PuseLocal=true -PmainClass=dev.equo.EwtWebShowcase
 * </pre>
 *
 * <p>Web (via Evolve comm):
 * <pre>
 *   (cd evolve-app && flutter build web --no-tree-shake-icons)
 *   ./gradlew :examples:runShowcaseWeb -PuseLocal=true
 * </pre>
 */
public class EwtWebShowcase {

    public static void main(String[] args) {
        App.runApp(ShowcaseRoot::new);
    }

    static class ShowcaseRoot extends SubStatelessWidget {
        @Override
        protected Widget build(BuildContext ctx) {
            return MaterialApp()
                    .title("EWT Web Showcase")
                    .theme(ThemeData()
                            .colorScheme(ColorScheme_fromSeed(Colors.deepPurple()))
                            .useMaterial3(true))
                    .home(new ShowcasePage());
        }
    }

    // Public so EvolveSamples (different package) can reference it.
    public static class ShowcasePage extends SubStatefulWidget {
        @Override
        protected State<ShowcasePage> createState() {
            return new ShowcaseState();
        }
    }

    static class ShowcaseState extends SubState<ShowcasePage> {

        // --- state fields ---
        int count = 0;
        boolean switchOn = true;
        boolean checked = false;
        double sliderValue = 50.0;
        String typedText = "";
        int selectedTile = -1; // -1 = none selected

        // --- root ---

        @Override
        public Widget build(BuildContext ctx) {
            return Scaffold()
                    .backgroundColor(Color(0xFFF3EEF8))
                    .appBar(AppBar()
                            .backgroundColor(Colors.deepPurple().shade700())
                            .foregroundColor(Colors.white())
                            .title(Text("EWT Widget Showcase")))
                    .body(SingleChildScrollView()
                            .child(Padding(EdgeInsets_symmetric().horizontal(16.0).vertical(20.0))
                                    .child(Column()
                                            .crossAxisAlignment(CrossAxisAlignment.stretch)
                                            .children(List.of(
                                                    _introBanner(),
                                                    SizedBox().height(16.0),
                                                    _counterCard(),
                                                    SizedBox().height(16.0),
                                                    _controlsCard(),
                                                    SizedBox().height(16.0),
                                                    _tilesCard(),
                                                    SizedBox().height(16.0),
                                                    _textInputCard(),
                                                    SizedBox().height(40.0)
                                            )))));
        }

        // --- sections ---

        private Widget _introBanner() {
            return Container()
                    .padding(EdgeInsets_all(20.0))
                    .decoration(BoxDecoration()
                            .color(Colors.deepPurple().shade700())
                            .borderRadius(BorderRadius_circular(16.0)))
                    .child(Column()
                            .crossAxisAlignment(CrossAxisAlignment.start)
                            .children(List.of(
                                    Row()
                                            .children(List.of(
                                                    Icon(Icons.hub_rounded())
                                                            .color(Colors.white()).size(28.0),
                                                    SizedBox().width(10.0),
                                                    Text("EWT").style(TextStyle()
                                                            .fontSize(22.0)
                                                            .fontWeight(FontWeight.w800())
                                                            .color(Colors.white()))
                                            )),
                                    SizedBox().height(8.0),
                                    Text("Write your UI once in Java. "
                                            + "It runs on the desktop and in the browser — "
                                            + "same code, same behaviour.").style(TextStyle()
                                            .fontSize(14.0)
                                            .color(Colors.white70())
                                            .height(1.5))
                            )));
        }

        private Widget _sectionCard(String title, String subtitle, Widget body) {
            return Card()
                    .elevation(2.0)
                    .child(Padding(EdgeInsets_all(20.0))
                            .child(Column()
                                    .crossAxisAlignment(CrossAxisAlignment.stretch)
                                    .children(List.of(
                                            Text(title).style(TextStyle()
                                                    .fontSize(18.0)
                                                    .fontWeight(FontWeight.w700())
                                                    .color(Colors.white())),
                                            SizedBox().height(4.0),
                                            Text(subtitle).style(TextStyle()
                                                    .fontSize(13.0)
                                                    .color(Colors.white70())),
                                            SizedBox().height(16.0),
                                            body
                                    ))));
        }

        // --- counter ---

        private Widget _counterCard() {
            return _sectionCard(
                    "State & Callbacks",
                    "The counter lives in Java. Every tap fires a Java method and calls setState().",
                    Column()
                            .mainAxisSize(MainAxisSize.min)
                            .children(List.of(
                                    Center().child(
                                            AnimatedContainer()
                                                    .duration(Duration().milliseconds(350))
                                                    .width(120.0)
                                                    .height(120.0)
                                                    .decoration(BoxDecoration()
                                                            .color(count > 0 ? Colors.teal().shade50()
                                                                    : count < 0 ? Colors.red().shade50()
                                                                    : Colors.deepPurple().shade50())
                                                            .shape(BoxShape.circle)
                                                            .border(Border_all()
                                                                    .color(count > 0 ? Colors.teal().shade300()
                                                                            : count < 0 ? Colors.red().shade300()
                                                                            : Colors.deepPurple().shade200())
                                                                    .width(2.0)))
                                                    .child(Center().child(
                                                            Text(String.valueOf(count)).style(TextStyle()
                                                                    .fontSize(56.0)
                                                                    .fontWeight(FontWeight.w800())
                                                                    .color(count > 0 ? Colors.teal().shade700()
                                                                            : count < 0 ? Colors.red().shade700()
                                                                            : Colors.deepPurple().shade700()))))),
                                    SizedBox().height(20.0),
                                    Row()
                                            .mainAxisAlignment(MainAxisAlignment.center)
                                            .children(List.of(
                                                    FilledButton_tonal(() -> setState(() -> count--))
                                                            .child(Row()
                                                                    .mainAxisSize(MainAxisSize.min)
                                                                    .children(List.of(
                                                                            Icon(Icons.remove()),
                                                                            SizedBox().width(4.0),
                                                                            Text("Dec")
                                                                    ))),
                                                    SizedBox().width(10.0),
                                                    FilledButton(() -> setState(() -> count++))
                                                            .child(Row()
                                                                    .mainAxisSize(MainAxisSize.min)
                                                                    .children(List.of(
                                                                            Icon(Icons.add()),
                                                                            SizedBox().width(4.0),
                                                                            Text("Inc")
                                                                    ))),
                                                    SizedBox().width(10.0),
                                                    OutlinedButton(() -> setState(() -> count = 0))
                                                            .child(Text("Reset"))
                                            ))
                            ))
            );
        }

        // --- controls ---

        private Widget _controlsCard() {
            return _sectionCard(
                    "Material Controls",
                    "Switch, Checkbox and Slider values are Java fields updated on every callback.",
                    Column()
                            .crossAxisAlignment(CrossAxisAlignment.start)
                            .children(List.of(
                                    SwitchListTile(switchOn, v -> setState(() -> switchOn = v))
                                            .title(Text("Tile labels — " + (switchOn ? "shown" : "hidden"))),
                                    CheckboxListTile(checked, v -> setState(() -> checked = v))
                                            .title(Text("Notifications — " + (checked ? "enabled" : "disabled"))),
                                    SizedBox().height(4.0),
                                    Padding(EdgeInsets_symmetric().horizontal(16.0))
                                            .child(Text("Volume: " + (int) sliderValue + " %").style(TextStyle()
                                                    .fontSize(13.0)
                                                    .color(Colors.white70()))),
                                    Slider(sliderValue)
                                            .onChanged(v -> setState(() -> sliderValue = v))
                                            .min(0.0)
                                            .max(100.0)
                                            .divisions(10)
                                            .label((int) sliderValue + " %")
                            ))
            );
        }

        // --- color tiles ---

        private Widget _tilesCard() {
            return _sectionCard(
                    "Layout & Gestures",
                    "Six cards rendered by Java. Tap to select; use the switch above to show/hide labels.",
                    Wrap()
                            .spacing(12.0)
                            .runSpacing(12.0)
                            .alignment(WrapAlignment.center)
                            .children(List.of(
                                    _tile(0),
                                    _tile(1),
                                    _tile(2),
                                    _tile(3),
                                    _tile(4),
                                    _tile(5)
                            ))
            );
        }

        private Widget _tile(int idx) {
            boolean sel = (selectedTile == idx);
            Color c = _tileColor(idx);
            return GestureDetector()
                    .onTap(() -> setState(() -> selectedTile = sel ? -1 : idx))
                    .child(AnimatedContainer()
                            .duration(Duration().milliseconds(200))
                            .width(84.0)
                            .height(84.0)
                            .decoration(BoxDecoration()
                                    .color(sel ? c : Colors.white())
                                    .borderRadius(BorderRadius_circular(18.0))
                                    .border(Border_all()
                                            .color(sel ? c : Colors.grey().shade300())
                                            .width(sel ? 3.0 : 1.5))
                                    .boxShadow(sel
                                            ? List.of(BoxShadow()
                                            .color(Color_fromRGBO(0, 0, 0, 0.18))
                                            .blurRadius(12.0)
                                            .offset(Offset(0.0, 4.0)))
                                            : List.of()))
                            .child(Column()
                                    .mainAxisAlignment(MainAxisAlignment.center)
                                    .children(List.of(
                                            Icon(_tileIcon(idx))
                                                    .color(sel ? Colors.white() : c)
                                                    .size(32.0),
                                            SizedBox().height(4.0),
                                            AnimatedOpacity()
                                                    .duration(Duration().milliseconds(250))
                                                    .opacity(switchOn ? 1.0 : 0.0)
                                                    .child(Text(_tileLabel(idx)).style(TextStyle()
                                                            .fontSize(11.0)
                                                            .fontWeight(FontWeight.w600())
                                                            .color(sel ? Colors.white() : Colors.white70())))
                                    ))));
        }

        private Color _tileColor(int idx) {
            return switch (idx) {
                case 0 -> Colors.pink().shade500();
                case 1 -> Colors.orange().shade700();
                case 2 -> Colors.amber().shade700();
                case 3 -> Colors.teal().shade500();
                case 4 -> Colors.indigo().shade500();
                case 5 -> Colors.red().shade400();
                default -> Colors.grey();
            };
        }

        private IconDataI _tileIcon(int idx) {
            return switch (idx) {
                case 0 -> Icons.rocket_launch_rounded();
                case 1 -> Icons.auto_awesome_rounded();
                case 2 -> Icons.bolt_rounded();
                case 3 -> Icons.local_florist_rounded();
                case 4 -> Icons.brush_rounded();
                case 5 -> Icons.favorite_rounded();
                default -> Icons.star();
            };
        }

        private String _tileLabel(int idx) {
            return switch (idx) {
                case 0 -> "Rocket";
                case 1 -> "Spark";
                case 2 -> "Bolt";
                case 3 -> "Bloom";
                case 4 -> "Brush";
                case 5 -> "Heart";
                default -> "?";
            };
        }

        // --- text input ---

        private Widget _textInputCard() {
            return _sectionCard(
                    "Text Input",
                    "onChanged streams every keystroke to Java. setState() updates the echo below.",
                    Column()
                            .crossAxisAlignment(CrossAxisAlignment.stretch)
                            .children(List.of(
                                    TextField()
                                            .maxLines(1)
                                            .decoration(InputDecoration()
                                                    .labelText("Type something")
                                                    .hintText("Hello from Java!")
                                                    .border(OutlineInputBorder()))
                                            .onChanged(v -> setState(() -> typedText = v)),
                                    SizedBox().height(12.0),
                                    Container()
                                            .padding(EdgeInsets_all(14.0))
                                            .decoration(BoxDecoration()
                                                    .color(Color_fromRGBO(255, 255, 255, 0.08))
                                                    .borderRadius(BorderRadius_circular(10.0))
                                                    .border(Border_all()
                                                            .color(Color_fromRGBO(255, 255, 255, typedText.isEmpty() ? 0.15 : 0.4))
                                                            .width(1.0)))
                                            .child(Text(typedText.isEmpty()
                                                    ? "Java will echo your text here…"
                                                    : "“" + typedText + "”").style(TextStyle()
                                                    .fontSize(15.0)
                                                    .color(typedText.isEmpty()
                                                            ? Colors.white38()
                                                            : Colors.white())))
                            ))
            );
        }
    }
}
