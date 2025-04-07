package dev.equo;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

public class HelloWorld {
    public static void main(String[] args) {
        App.runApp(() ->
            Center()
                .child(Text("hello from Java").textDirection(TextDirection.ltr))
        );
    }
}