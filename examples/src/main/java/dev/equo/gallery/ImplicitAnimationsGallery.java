package dev.equo.gallery;

import java.util.List;

import dev.equo.ewt.*;

import static dev.equo.ewt.EWT.*;
import static dev.equo.gallery.GalleryKit.*;

/**
 * Implicitly animated widgets: give them a new value and a duration, and they
 * tween to it on their own — no AnimationController needed.
 *
 *   ./gradlew :examples:run -PuseLocal=true -PmainClass=dev.equo.gallery.ImplicitAnimationsGallery
 *
 * Press the button (or the Switch) to flip the target state and watch all four
 * animate at once.
 */
public class ImplicitAnimationsGallery {

  public static void main(String[] args) {
    App.runApp(MyApp::new);
  }

  static class MyApp extends SubStatelessWidget {
    @Override
    protected Widget build(BuildContext context) {
      return MaterialApp()
          .title("EWT — Implicit Animations")
          .theme(ThemeData().colorScheme(ColorScheme_fromSeed(Colors.deepOrange())).useMaterial3(true))
          .home(new AnimationsPage());
    }
  }

  static class AnimationsPage extends SubStatefulWidget {
    @Override
    protected State<AnimationsPage> createState() {
      return new AnimationsState();
    }
  }

  static class AnimationsState extends SubState<AnimationsPage> {
    boolean _on = true;

    DurationI _dur() {
      return Duration().milliseconds(400);
    }

    void _flip() {
      setState(() -> _on = !_on);
    }

    @Override
    public Widget build(BuildContext context) {
      return Scaffold()
          .appBar(AppBar()
              .backgroundColor(Theme.of(context).colorScheme().inversePrimary())
              .title(Text("Implicit Animations")))
          .floatingActionButton(FloatingActionButton()
              .onPressed(this::_flip)
              .tooltip("Flip state")
              .child(Icon(Icons.play_arrow())))
          .body(SingleChildScrollView().child(Padding(EdgeInsets_all(20.0))
              .child(Column()
                  .crossAxisAlignment(CrossAxisAlignment.start)
                  .children(List.of(

                      Text("State: " + (_on ? "A" : "B") + " — press the button to flip"),
                      Divider(),

                      tile("AnimatedContainer", AnimatedContainer().duration(_dur())
                          .width(_on ? 60.0 : 24.0).height(40.0)
                          .color(_on ? Colors.deepOrange() : Colors.grey())),

                      tile("AnimatedOpacity", AnimatedOpacity().duration(_dur())
                          .opacity(_on ? 1.0 : 0.2)
                          .child(rect(40.0, 40.0, Colors.deepPurple()))),

                      // Blue fills the framed box minus the padding.
                      tile("AnimatedPadding", stage(72.0, 56.0,
                          AnimatedPadding(EdgeInsets_all(_on ? 4.0 : 18.0))
                              .duration(_dur()).child(ColoredBox(Colors.blue())))),

                      tile("AnimatedAlign", stage(72.0, 48.0,
                          AnimatedAlign(_on ? Alignment.centerLeft() : Alignment.centerRight())
                              .duration(_dur()).child(dot(Colors.orange())))),

                      Divider(),
                      SwitchListTile(_on, v -> setState(() -> _on = v))
                          .title(Text("Same state, as a switch"))
                  )))));
    }
  }
}
