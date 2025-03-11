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
      return Center.of()
          .child(Column.of()
                  .mainAxisAlignment(MainAxisAlignment.center)
                  .children(
                      List.of(
                          Text.of("You have pushed the button this many times:")
                              .textDirection(TextDirection.ltr)
                              .build(),
                          Text.of("" + counter)
                              .textDirection(TextDirection.ltr)
//                                            .style(Theme.of(context).textTheme.headlineMedium)
                              .build()
                      )
                  ).build()
          ).build();
    }
  }
}

