package dev.equo;

import dev.equo.ewt.App;
//import dev.equo.ewt.ImmutableText;
//import dev.equo.ewt.RichBuilder;
import dev.equo.ewt.Center;
import dev.equo.ewt.Text;
import dev.equo.ewt.TextDirection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class HelloWorld {
    public static void main(String[] args) {
//            App.runApp(() -> Text.of("hello from Java")
//                    .textDirection(TextDirection.ltr).build());
        App.runApp(() ->
            Center.of()
                .child(Text.of("hello from Java").textDirection(TextDirection.ltr).build()).build()
        );
    }
}