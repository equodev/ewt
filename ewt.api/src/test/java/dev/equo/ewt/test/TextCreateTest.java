package dev.equo.ewt.test;

import dev.equo.ewt.InlineSpan;
import dev.equo.ewt.Text;
import dev.equo.ewt.TextDirection;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("native")
public class TextCreateTest {

//    @Test
//    void build_rich_text() {
//        var t = Text.rich(new InlineSpan())
////                .softWrap(true)
////                .overflow(false)
//                ;
//        assertThat(t).isNotNull();
//        assertThat(t.build())
//                .isNotNull()
//                .isInstanceOf(Text.class);
//    }

    @Test
    void create_text() {
        var t = Text.text("hello")
                .textDirection(TextDirection.ltr).build();

    }
}
