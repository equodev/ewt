package dev.equo;

import dev.equo.ewt.*;

import java.util.List;

public class Counter {

  public static void main(String[] args) {
    App.runApp(() -> new MyApp().build());
  }

  static class MyApp {

    private final int counter = 1;

    public Widget build() {
      return MaterialApp.materialApp()
          .title("EWT Demo")
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
        return Scaffold.scaffold()
            .appBar(
                AppBar.appBar()
                    .title(Text.text(title).textDirection(TextDirection.ltr).build())
                    .build()
            )
            .body(
                Center.center()
                    .child(
                        Column.column()
                            .mainAxisAlignment(MainAxisAlignment.center)
                            .children(
                                List.of(
                                    Text.text("You have pushed the button this many times:")
                                        .textDirection(TextDirection.ltr)
                                        .build(),
                                    Text.text("" + counter)
                                        .textDirection(TextDirection.ltr)
//                                            .style(Theme.of(context).textTheme.headlineMedium)
                                        .build()
                                )
                            )
                            .build()
                    )
                    .build()
            )
            .build();
      }
    }
  }
}

