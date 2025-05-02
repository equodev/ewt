package dev.equo;

import static dev.equo.ewt.EWT.*;

import dev.equo.ewt.*;
import java.util.List;

public class Hacka {
  public static void main(String[] args) {
    App.runApp(() -> new MyAppD());
  }

  public static Widget dialogBuilder(BuildContext context) {
    return AlertDialog()
        .title(Text("Hello!"))
        .content(Text("This is a simple Hello World Flutter application."))
        .actions(List.of(TextButton(() ->
                System.out.println("LALALA")
//            Navigator.of(context).pop()

        ).child(Text("OK"))));
  }
}

class MyAppD extends SubStatelessWidget {
  @Override
  protected Widget build(BuildContext context) {
    return MaterialApp()
        .title("Hello World")
        .theme(ThemeData().primarySwatch(Colors.blue()).visualDensity(VisualDensity.compact()))
        .home(new MyHomePage());
  }
}

class MyHomePage extends SubStatefulWidget {
  @Override
  protected MyHomePageState createState() {
    return new MyHomePageState();
  }
}

class MyHomePageState extends SubState<MyHomePage> {
  @Override
  protected Widget build(BuildContext context) {
    return Scaffold()
        .appBar(AppBar().title(Text("Hello World")))
        .body(Center()
            .child(Column()
                .mainAxisAlignment(MainAxisAlignment.center)
                .children(List.of(
                    Text("Hello World!")
                        .style(TextStyle()
                            .fontSize(24.0)
                            .fontWeight(FontWeight.bold())
                            .color(Colors.blue())),
                    Container().height(20.0),
                    Text("Welcome to my first Flutter application")
                        .style(TextStyle().fontSize(16.0))))))
        .floatingActionButton(FloatingActionButton()
            .onPressed(this::_showMessage)
            .tooltip("Show Message")
            .child(Icon(Icons.message())));
  }

  private void _showMessage() {
    showDialog(context(), Hacka::dialogBuilder);
  }
}
