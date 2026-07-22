package dev.equo;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/** Phase 6 demo: a stateful counter using Theme.of(context) — AppBar color from the color scheme and
 *  the number styled from the text theme (colors come from Evolve's ambient theme). */
public class EwtThemedCounter extends SubStatefulWidget {
  private final String title;
  public EwtThemedCounter(String title) { this.title = title; }

  @Override
  protected State<EwtThemedCounter> createState() { return new S(); }

  static class S extends SubState<EwtThemedCounter> {
    int count = 0;
    void increment() { setState(() -> { count++; System.out.println("[EWT] themed counter -> " + count); }); }

    @Override
    public Widget build(BuildContext context) {
      return Scaffold()
          .appBar(AppBar()
              .backgroundColor(Theme.of(context).colorScheme().inversePrimary())
              .title(Text(widget().title)))
          .body(Center().child(
              Text("Count: " + count).style(Theme.of(context).textTheme().headlineMedium())))
          .floatingActionButton(FloatingActionButton()
              .onPressed(this::increment)
              .child(Icon(Icons.add())))
          .build();
    }
  }
}
