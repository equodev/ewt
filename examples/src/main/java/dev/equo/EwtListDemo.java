package dev.equo;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/** Phase 7 demo: a stateful ListView.builder whose item count grows on a button press.
 *  On web the finite builder is eager-expanded into a plain ListView during capture. */
public class EwtListDemo extends SubStatefulWidget {
  @Override
  protected State<EwtListDemo> createState() { return new S(); }

  static class S extends SubState<EwtListDemo> {
    int n = 3;
    void add() { setState(() -> { n++; System.out.println("[EWT] list -> " + n + " items"); }); }

    @Override
    public Widget build(BuildContext context) {
      return Scaffold()
          .appBar(AppBar().title(Text("List (" + n + ")")))
          .body(ListView_builder()
              .itemCount(n)
              .itemBuilder((ctx, i) -> Text("Item " + i).build()))
          .floatingActionButton(FloatingActionButton()
              .onPressed(this::add)
              .child(Icon(Icons.add())))
          .build();
    }
  }
}
