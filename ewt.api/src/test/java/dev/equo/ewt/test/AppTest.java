package dev.equo.ewt.test;

import dev.equo.ewt.App;
import dev.equo.ewt.Text;
import dev.equo.ewt.TextDirection;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("native")
public class AppTest {

    @Test
    void run_app() {
        App.runApp(() -> Text.text("hello from java")
                    .textDirection(TextDirection.ltr).build());
    }
}
