import static dev.equo.ewt.EWT.*;

import dev.equo.ewt.*;

public class Hello {
  public static void main(String[] args) {
    App.runApp(() -> Center()
        .child(Text("hello from Java!").key(Key("title")).textDirection(TextDirection.ltr)));
  }
}
