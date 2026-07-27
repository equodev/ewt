package dev.equo;

import java.util.ArrayList;
import java.util.List;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/**
 * Uncontrolled TextField live-echo fixture. Typing streams via onChanged -> setState,
 * which re-renders only the echo Text below (a {kind:patch} that leaves the field node
 * untouched), so the browser field keeps its own buffer + cursor. onSubmitted (Enter)
 * prints to the Java console. Proves the text-input round-trip and cursor preservation.
 */
public class EwtTextInput extends SubStatefulWidget {
  @Override
  protected State<EwtTextInput> createState() { return new InputState(); }

  static class InputState extends SubState<EwtTextInput> {
    String value = "";

    @Override
    public Widget build(BuildContext context) {
      List<WidgetI> children = new ArrayList<>();
      // maxLines(1) is required on web: an unset maxLines serializes as absent, and the
      // decoder passes maxLines:null, which Flutter treats as UNLIMITED lines (multiline) —
      // so Enter inserts a newline instead of firing onSubmitted. Flutter's own constructor
      // default is 1; a single-line input must set it explicitly until the decoder learns to
      // omit absent optionals whose Flutter default is non-null.
      children.add(TextField()
          .maxLines(1)
          .decoration(InputDecoration().labelText("Type here"))
          .onChanged(v -> setState(() -> value = v))
          .onSubmitted(v -> System.out.println("[EWT] submitted: " + v)));
      children.add(SizedBox().height(16.0));
      children.add(Text("You typed: " + value)
          .style(TextStyle().fontSize(20.0)));
      return Center().child(
          Container()
              .padding(EdgeInsets_all(24.0))
              .child(Column().mainAxisSize(MainAxisSize.min).children(children)))
          .build();
    }
  }
}
