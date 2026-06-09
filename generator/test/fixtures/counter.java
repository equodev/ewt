import static dev.equo.ewt.EWT.*;

import dev.equo.ewt.*;
import java.util.List;

public class Counter {
  public static void main(String[] args) {
    App.runApp(() -> new MyApp());
  }
}

class MyApp extends SubStatelessWidget {
  public MyApp() {}

  @Override
  protected Widget build(BuildContext context) {
    return MaterialApp()
        .title("EWT Demo")
        .theme(
            ThemeData().colorScheme(ColorScheme_fromSeed(Colors.deepPurple())).useMaterial3(true))
        .home(new MyHomePage("Flutter Demo Home Page"));
  }
}

class MyHomePage extends SubStatefulWidget {
  public MyHomePage(String title) {
    this.title = title;
  }

  final String title;

  @Override
  protected State<MyHomePage> createState() {
    return new MyHomePageState();
  }
}

class MyHomePageState extends SubState<MyHomePage> {
  private int _counter = 0;

  private void _incrementCounter() {
    setState(() -> {
      _counter++;
    });
  }

  @Override
  protected Widget build(BuildContext context) {
    return Scaffold()
        .appBar(AppBar()
            .backgroundColor(Theme.of(context).colorScheme().inversePrimary())
            .title(Text(widget().title)))
        .body(Center()
            .child(Column()
                .mainAxisAlignment(MainAxisAlignment.center)
                .children(List.of(
                    Text("You have pushed the button this many times:"),
                    Text("" + _counter + "")
                        .style(Theme.of(context).textTheme().headlineMedium())))))
        .floatingActionButton(FloatingActionButton()
            .onPressed(this::_incrementCounter)
            .tooltip("Increment")
            .child(Icon(Icons.add())));
  }
}
