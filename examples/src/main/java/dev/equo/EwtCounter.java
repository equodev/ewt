package dev.equo;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/** Minimal stateful EWT widget for the web re-render demo: a number and a + button. */
public class EwtCounter extends SubStatefulWidget {
  @Override
  protected State<EwtCounter> createState() { return new CounterState(); }

  static class CounterState extends SubState<EwtCounter> {
    int count = 0;

    void increment() {
      setState(() -> {
        count++;
        System.out.println("[EWT] counter -> " + count);
      });
    }

    @Override
    public Widget build(BuildContext context) {
      return Center().child(
          Container()
              .padding(EdgeInsets_all(24.0))
              .child(Column()
                  .mainAxisSize(MainAxisSize.min)
                  .children(java.util.List.of(
                      Text("Count: " + count).style(TextStyle().fontSize(28.0).fontWeight(FontWeight.bold())),
                      SizedBox().height(12.0),
                      FilledButton(this::increment).child(Text("+"))))))
          .build();
    }
  }
}
