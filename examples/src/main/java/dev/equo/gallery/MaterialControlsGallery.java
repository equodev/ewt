package dev.equo.gallery;

import java.util.List;

import dev.equo.ewt.*;

import static dev.equo.ewt.EWT.*;
import static dev.equo.gallery.GalleryKit.*;

/**
 * Interactive Material controls: Switch, Checkbox, Slider, their list-tile
 * variants, plus Badge, Tooltip and the app Drawer.
 *
 *   ./gradlew :examples:run -PuseLocal=true -PmainClass=dev.equo.gallery.MaterialControlsGallery
 *
 * Every control here is wired to state, so toggling one updates the labels —
 * that round trip (Flutter -> C -> Java -> setState -> rebuild) is the point.
 */
public class MaterialControlsGallery {

  public static void main(String[] args) {
    App.runApp(MyApp::new);
  }

  static class MyApp extends SubStatelessWidget {
    @Override
    protected Widget build(BuildContext context) {
      return MaterialApp()
          .title("EWT — Material Controls")
          .theme(ThemeData().colorScheme(ColorScheme_fromSeed(Colors.indigo())).useMaterial3(true))
          .home(new ControlsPage());
    }
  }

  static class ControlsPage extends SubStatefulWidget {
    @Override
    protected State<ControlsPage> createState() {
      return new ControlsState();
    }
  }

  static class ControlsState extends SubState<ControlsPage> {
    boolean _switchOn = true;
    boolean _checked = true;
    double _volume = 40.0;

    @Override
    public Widget build(BuildContext context) {
      return Scaffold()
          .appBar(AppBar()
              .backgroundColor(Theme.of(context).colorScheme().inversePrimary())
              .title(Text("Material Controls")))
          // Opens from the AppBar hamburger, which Scaffold adds automatically.
          .drawer(Drawer().child(Center().child(Text("This is a Drawer"))))
          .body(SingleChildScrollView().child(Padding(EdgeInsets_all(20.0))
              .child(Column()
                  .crossAxisAlignment(CrossAxisAlignment.start)
                  .children(List.of(

                      tile("Switch", Switch(_switchOn, v -> setState(() -> _switchOn = v))
                          .activeColor(Colors.indigo())),
                      Text("Switch is " + (_switchOn ? "ON" : "OFF")),
                      Divider(),

                      tile("Checkbox", Checkbox(_checked).onChanged(v -> setState(() -> _checked = v))),
                      Text("Checkbox is " + (_checked ? "checked" : "unchecked")),
                      Divider(),

                      Text("Slider — volume: " + (int) _volume),
                      Slider(_volume).onChanged(v -> setState(() -> _volume = v))
                          .min(0.0).max(100.0).divisions(20).label("" + (int) _volume),
                      Divider(),

                      tile("Tooltip (hover me)", Tooltip().message("A helpful hint")
                          .child(Icon(Icons.favorite()))),
                      tile("Badge", Badge().label(Text("9+")).child(Icon(Icons.notifications()))),
                      Divider(),

                      SwitchListTile(_switchOn, v -> setState(() -> _switchOn = v))
                          .title(Text("SwitchListTile")),
                      CheckboxListTile(_checked, v -> setState(() -> _checked = v))
                          .title(Text("CheckboxListTile"))
                  )))));
    }
  }
}
