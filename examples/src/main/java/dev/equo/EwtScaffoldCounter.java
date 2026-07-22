package dev.equo;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/** Phase 5 demo: a stateful counter with real app chrome (Scaffold + AppBar), title from widget(),
 *  explicit colors (no Theme.of). */
public class EwtScaffoldCounter extends SubStatefulWidget {
  private final String title;
  public EwtScaffoldCounter(String title) { this.title = title; }

  @Override
  protected State<EwtScaffoldCounter> createState() { return new S(); }

  static class S extends SubState<EwtScaffoldCounter> {
    int count = 0;
    void increment() { setState(() -> { count++; System.out.println("[EWT] scaffold counter -> " + count); }); }

    @Override
    public Widget build(BuildContext context) {
      return Scaffold()
          .appBar(AppBar()
              .backgroundColor(Color_fromRGBO(79, 70, 229, 1.0))
              .title(Text(widget().title).style(TextStyle().color(Colors.white()))))
          .body(Center().child(
              Text("Count: " + count).style(TextStyle().fontSize(28.0).fontWeight(FontWeight.bold()))))
          .floatingActionButton(FloatingActionButton()
              .onPressed(this::increment)
              .child(Icon(Icons.add())))
          .build();
    }
  }
}
