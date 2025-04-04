package dev.equo;

//import dev.equo.ewt.*;

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
          .theme( ThemeData()
              .colorScheme( ColorScheme_fromSeed(Colors.deepPurple()) )
              .useMaterial3(true))
          .home( new MyHomePage("Flutter Demo Home Page") );
    }

    private class MyHomePage extends SubStatefulWidget {
      private final String title;

      public MyHomePage(String title) {
        this.title = title;
      }

      @Override
      protected State<MyHomePage> createState() {
        return new MyHomePageState();
      }
    }

    private class MyHomePageState extends SubState<MyHomePage> {
      int _counter = 0;

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
            .appBar( AppBar()
                .backgroundColor( Theme.of(context).colorScheme().inversePrimary() )
                .title( Text(widget().title)) )
            .body( Center()
                .child( Column()
                    .mainAxisAlignment( MainAxisAlignment.center )
                    .children( List.of(
                        Text("You have pushed the button this many times:"),
                        Text("" + _counter)
                            .style( Theme.of(context).textTheme().headlineMedium() )
                    ))
                ))
            .floatingActionButton( FloatingActionButton()
                .onPressed(this::_incrementCounter)
                .tooltip("Increment")
                .child( Icon(Icons.add()) ));
      }
    }
  }
}

