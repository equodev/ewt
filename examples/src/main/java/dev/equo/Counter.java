package dev.equo;

import static dev.equo.ewt.EWT.*;
import dev.equo.ewt.App;
import dev.equo.ewt.Icons;
import dev.equo.ewt.MainAxisAlignment;
import dev.equo.ewt.TextDirection;
import dev.equo.ewt.Widget;

import java.util.List;

public class Counter {

  public static void main(String[] args) {
    App.runApp(() -> new MyApp().build());
  }

  static class MyApp {

    private final int counter = 1;

    public Widget build() {
      return MaterialApp()
          .title("EWT Demo")
          .theme(ThemeData()
              .colorScheme(ColorScheme_fromSeed(Color(0xFF311B92).build()).build())
              .useMaterial3(true)
              .build())
//          .showPerformanceOverlay(true)
          .home(new MyHomePage("Flutter Demo Home Page").build())
          .build();
    }

    private class MyHomePage extends Widget {
      private final String title;

      public MyHomePage(String title) {
        super();
        this.title = title;
      }

      public Widget build() {
        return Scaffold()
            .appBar(
                AppBar()
                    .backgroundColor(Color(0xFFB39DDB).build())
                    .title(Text(title).textDirection(TextDirection.ltr).build())
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
                                    Text("" + counter)
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
                    .onPressed(() -> {
                      System.out.println(Thread.currentThread()+" on pressed in java");
                      Text("You have pushed t")
                          .textDirection(TextDirection.ltr)
                          .build();
                      System.out.println("on pressed in java2");
                    })
                    .tooltip("Increment")
                    .child(Icon(Icons.add()).build())
                    .build()
            )
            .build();
      }
    }
  }
}

