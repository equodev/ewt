package dev.equo;

import dev.equo.ewt.*;

import static dev.equo.ewt.EWT.*;

//import dev.equo.ewt.*;

import java.util.List;

public class Counter {

  public static void main(String[] args) {
    App.runApp(() -> new MyApp().build());
  }

  static class MyApp {

    public Widget build() {
      return MaterialApp()
          .title("EWT Demo")
          .theme(ThemeData()
              .colorScheme(ColorScheme_fromSeed(Color(0xFF311B92).build()).build())
              .useMaterial3(true)
              .build())
//          .showPerformanceOverlay(true)
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
//        setState(() -> {
          System.out.println("on pressed in java");
          // This call to setState tells the Flutter framework that something has
          // changed in this State, which causes it to rerun the build method below
          // so that the display can reflect the updated values. If we changed
          // _counter without calling setState(), then the build method would not be
          // called again, and so nothing would appear to happen.
          _counter++;
//        });
      }

      public Widget build() {
        return Scaffold()
            .appBar(
                AppBar()
                    .backgroundColor(Color(0xFFB39DDB).build())
                    .title(Text(widget.title).textDirection(TextDirection.ltr).build())
                    .build()
            )
            .body(
                Center()
                    .child(
                        Column()
                            .mainAxisAlignment(MainAxisAlignment.center)
                            .children(
                                List.of(
                                    Text("You have pushed the button this many times:")
                                        .textDirection(TextDirection.ltr)
                                        .build(),
                                    Text("" + _counter)
                                        .textDirection(TextDirection.ltr)
//                                            .style(Theme.of(context).textTheme.headlineMedium)
                                        .build()
                                )
                            )
                            .build()
                    )
                    .build()
            )
            .floatingActionButton(
                FloatingActionButton()
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

