package dev.equo;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;
import java.util.List;

public class WidgetGallery {

  public static void main(String[] args) {
    App.runApp(GalleryApp::new);
  }

  static class GalleryApp extends SubStatelessWidget {
    @Override
    protected Widget build(BuildContext context) {
      return MaterialApp()
          .title("Widget Gallery")
          .theme(ThemeData()
              .colorScheme(ColorScheme_fromSeed(Colors.deepPurple()))
              .useMaterial3(true))
          .home(new GalleryPage());
    }
  }

  static class GalleryPage extends SubStatefulWidget {
    @Override
    protected GalleryState createState() {
      return new GalleryState();
    }
  }

  static class GalleryState extends SubState<GalleryPage> {
    private int _count = 0;
    private String _lastGesture = "none";

    private void _increment() {
      setState(() -> _count++);
    }

    private void _onTap() {
      setState(() -> { _count++; _lastGesture = "tap"; });
    }

    private void _onDoubleTap() {
      setState(() -> { _count += 2; _lastGesture = "double tap"; });
    }

    private void _onLongPress() {
      setState(() -> { _count = 0; _lastGesture = "long press (reset)"; });
    }

    @Override
    public Widget build(BuildContext context) {
      double progress = (_count % 11) / 10.0;

      return Scaffold()
          .appBar(AppBar()
              .title(Text("Widget Gallery"))
              .backgroundColor(Theme.of(context).colorScheme().primaryContainer()))
          .floatingActionButton(FloatingActionButton()
              .onPressed(this::_increment)
              .tooltip("Add")
              .child(Icon(Icons.add())))
          .body(SingleChildScrollView()
              .padding(EdgeInsets_all(16.0))
              .child(Column()
                  .crossAxisAlignment(CrossAxisAlignment.start)
                  .children(List.of(

                      // ── CircularProgressIndicator ─────────────────────────
                      _sectionTitle("CircularProgressIndicator"),
                      SizedBox().height(12.0),
                      Row()
                          .mainAxisAlignment(MainAxisAlignment.spaceEvenly)
                          .children(List.of(
                              Column()
                                  .mainAxisSize(MainAxisSize.min)
                                  .children(List.of(
                                      CircularProgressIndicator(),
                                      SizedBox().height(6.0),
                                      Text("indeterminate").style(TextStyle().fontSize(11.0))
                                  )),
                              Column()
                                  .mainAxisSize(MainAxisSize.min)
                                  .children(List.of(
                                      CircularProgressIndicator().value(progress).color(Colors.teal()),
                                      SizedBox().height(6.0),
                                      Text("value: " + (int)(progress * 100) + "%").style(TextStyle().fontSize(11.0))
                                  )),
                              Column()
                                  .mainAxisSize(MainAxisSize.min)
                                  .children(List.of(
                                      CircularProgressIndicator().value(1.0).color(Colors.green()),
                                      SizedBox().height(6.0),
                                      Text("100%").style(TextStyle().fontSize(11.0))
                                  ))
                          )),
                      SizedBox().height(8.0),
                      Center()
                          .child(Text("FAB increments progress (" + _count + " taps)")
                              .style(TextStyle().fontSize(12.0).color(Colors.grey().shade600()))),
                      SizedBox().height(24.0),

                      // ── Card + ListTile (with onTap) ──────────────────────
                      _sectionTitle("Card + ListTile"),
                      SizedBox().height(8.0),
                      Card().child(ListTile()
                          .leading(Icon(Icons.star()).color(Colors.amber()))
                          .title(Text("Tap me"))
                          .subtitle(Text("Tapped " + _count + " times"))
                          .onTap(this::_increment)),
                      Card().child(ListTile()
                          .leading(Icon(Icons.person()).color(Colors.blue()))
                          .title(Text("Second item"))
                          .subtitle(Text("Static subtitle"))),
                      Card().child(ListTile()
                          .leading(Icon(Icons.settings()).color(Colors.grey()))
                          .title(Text("Third item"))
                          .subtitle(Text("Another row"))),
                      SizedBox().height(24.0),

                      // ── GestureDetector ───────────────────────────────────
                      _sectionTitle("GestureDetector"),
                      SizedBox().height(8.0),
                      GestureDetector()
                          .onTap(this::_onTap)
                          .onDoubleTap(this::_onDoubleTap)
                          .onLongPress(this::_onLongPress)
                          .child(Container()
                              .width(Double.POSITIVE_INFINITY)
                              .padding(EdgeInsets_all(24.0))
                              .decoration(BoxDecoration()
                                  .color(Colors.deepPurple().shade100())
                                  .borderRadius(BorderRadius_circular(12.0)))
                              .child(Column()
                                  .mainAxisSize(MainAxisSize.min)
                                  .children(List.of(
                                      Text("count: " + _count)
                                          .style(TextStyle().fontSize(28.0).fontWeight(FontWeight.bold())),
                                      SizedBox().height(4.0),
                                      Text("last: " + _lastGesture)
                                          .style(TextStyle().fontSize(13.0).color(Colors.deepPurple().shade400()))
                                  )))),
                      SizedBox().height(8.0),
                      Center()
                          .child(Text("tap +1  ·  double tap +2  ·  long press reset")
                              .style(TextStyle().fontSize(12.0).color(Colors.grey().shade600()))),
                      SizedBox().height(24.0),

                      // ── Chip + Wrap ───────────────────────────────────────
                      _sectionTitle("Chip + Wrap"),
                      SizedBox().height(8.0),
                      Wrap()
                          .spacing(8.0)
                          .runSpacing(8.0)
                          .children(List.of(
                              Chip().label(Text("Flutter")),
                              Chip().label(Text("Java")).backgroundColor(Colors.blue().shade100()),
                              Chip().label(Text("EWT")).backgroundColor(Colors.teal().shade100()),
                              Chip().label(Text("Material 3")).backgroundColor(Colors.purple().shade100()),
                              Chip().label(Text("Desktop")).backgroundColor(Colors.orange().shade100()),
                              Chip().label(Text("Open Source")).backgroundColor(Colors.green().shade100())
                          )),
                      SizedBox().height(80.0)

                  ))
              )
          );
    }

    private Widget _sectionTitle(String title) {
      return Text(title)
          .style(TextStyle()
              .fontSize(18.0)
              .fontWeight(FontWeight.bold())
              .color(Colors.deepPurple()));
    }
  }
}
