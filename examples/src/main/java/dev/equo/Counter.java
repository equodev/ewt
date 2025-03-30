package dev.equo;

//import dev.equo.ewt.*;

import dev.equo.ewt.App;
import dev.equo.ewt.BuildContext;
import dev.equo.ewt.MainAxisAlignment;
import dev.equo.ewt.SubStatelessWidget;
import dev.equo.ewt.SubStatefulWidget;
import dev.equo.ewt.SubState;
import dev.equo.ewt.State;
import dev.equo.ewt.Theme;
import dev.equo.ewt.Icons;
import dev.equo.ewt.WidgetI;

import static dev.equo.ewt.EWT.MaterialApp;
import static dev.equo.ewt.EWT.ThemeData;
import static dev.equo.ewt.EWT.Color;
import static dev.equo.ewt.EWT.ColorScheme_fromSeed;
import static dev.equo.ewt.EWT.Text;
import static dev.equo.ewt.EWT.Scaffold;
import static dev.equo.ewt.EWT.AppBar;
import static dev.equo.ewt.EWT.Theme;
import static dev.equo.ewt.EWT.Center;
import static dev.equo.ewt.EWT.Column;
import static dev.equo.ewt.EWT.FloatingActionButton;
import static dev.equo.ewt.EWT.Icon;

import java.util.List;

public class Counter {

  public static void main(String[] args) {
    App.runApp(MyApp::new);
  }

  static class MyApp extends SubStatelessWidget {

    @Override
    protected WidgetI build(BuildContext context) {
      return MaterialApp()
          .title("EWT Demo")
          .theme(ThemeData()
              .colorScheme(ColorScheme_fromSeed(Color(0xFF311B92)))
              .useMaterial3(true))
          .home(new MyHomePage("Flutter Demo Home Page"));
    }

    private class MyHomePage extends SubStatefulWidget {
      private final String title;

      public MyHomePage(String title) {
        this.title = title;
      }

      @Override
      protected State<MyHomePage> createState() {
        return new MyHomePageState(this);
      }
    }

    private class MyHomePageState extends SubState<MyHomePage> {
      private final MyHomePage widget;
      int _counter = 0;

      public MyHomePageState(MyHomePage myHomePage) {
        this.widget = myHomePage;
      }

      void _incrementCounter() {
        setState(() -> {
          System.out.println("on pressed in java inside setSate");
          // This call to setState tells the Flutter framework that something has
          // changed in this State, which causes it to rerun the build method below
          // so that the display can reflect the updated values. If we changed
          // _counter without calling setState(), then the build method would not be
          // called again, and so nothing would appear to happen.
          _counter++;
        });
      }

      @Override
      public WidgetI build(BuildContext context) {
        WidgetI text = Text(widget.title);
        return Scaffold()
            .appBar(AppBar()
                .backgroundColor(Theme.of(context).colorScheme().inversePrimary())
                .title(text))
            .body(Center()
                .child(Column()
                    .mainAxisAlignment(MainAxisAlignment.center)
                    .children(List.of(
                        Text("You have pushed the button this many times:"),
                        Text("" + _counter)
                            .style(Theme.of(context).textTheme().headlineMedium())
                    ))
                ))
            .floatingActionButton(FloatingActionButton()
                .onPressed(this::_incrementCounter)
                .tooltip("Increment")
                .child(Icon(Icons.add())));
      }
    }
  }
}

