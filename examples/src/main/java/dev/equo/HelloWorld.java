package dev.equo;

import dev.equo.ewt.App;
import dev.equo.ewt.ImmutableText;
import dev.equo.ewt.RichBuilder;
import dev.equo.ewt.Text;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class HelloWorld {
    public static void main(String[] args) {
        App.runApp(
                Text.of()
            new Center(new Text("Hello, world!", new Key("title"), TextDirection.LTR))
        );
    }
}