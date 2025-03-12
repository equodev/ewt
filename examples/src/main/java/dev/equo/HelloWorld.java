package dev.equo;

import dev.equo.ewt.App;
import dev.equo.ewt.Center;
import dev.equo.ewt.Text;
import dev.equo.ewt.TextDirection;

public class HelloWorld {
    public static void main(String[] args) {
        App.runApp(() ->
            Center.center()
                .child(Text.text("hello from Java").textDirection(TextDirection.ltr).build()).build()
        );
    }
}