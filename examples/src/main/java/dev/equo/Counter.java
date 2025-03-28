package dev.equo;

import dev.equo.ewt.*;

import static dev.equo.ewt.EWT.*;

import java.util.List;

public class Counter {

  public static void main(String[] args) {
    App.runApp(MyApp::new);
  }

  static class MyApp extends SubStatelessWidget {

    @Override
    protected Widget build(BuildContext context) {
      return MaterialApp()
          .title("EWT Demo")
          .theme(ThemeData()
              .colorScheme(ColorScheme_fromSeed(Color(0xFF311B92).build()).build())
              .useMaterial3(true)
              .build())
          .home(new MyHomePage("Flutter Demo Home Page"))
          .build();
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
      public Widget build(BuildContext context) {
        return Scaffold()
            .appBar(AppBar()
                .backgroundColor(Theme.of(context).colorScheme().inversePrimary())
                .title(Text(widget.title).build())
                .build()
            )
            .body(Center()
                .child(Column()
                    .mainAxisAlignment(MainAxisAlignment.center)
                    .children(List.of(
                        Text("You have pushed the button this many times:")
                            .build(),
                        Text("" + _counter)
                            .style(Theme.of(context).textTheme().headlineMedium())
                            .build()
                    ))
                    .build()
                )
                .build()
            )
            .floatingActionButton(FloatingActionButton()
                .onPressed(this::_incrementCounter)
                .tooltip("Increment")
                .child(Icon(Icons.add()).build())
                .build()
            )
            .build();
      }
    }
  }
}

