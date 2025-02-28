package dev.equo.ewt.test;

import dev.equo.ewt.InlineSpan;
import dev.equo.ewt.Text;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextBuilderTest {

    @Test
    void widget_class_is_public() {
        assertThat(Text.class).isPublic();
    }

    @Test
    void build_rich_text() {
        var t = Text.rich(new InlineSpan())
//                .softWrap(true)
//                .overflow(false)
                ;
        assertThat(t).isNotNull();
        assertThat(t.build())
                .isNotNull()
                .isInstanceOf(Text.class);
    }

    @Test
    void build_text() {
        var t = Text.of("hello")
//            .softWrap(true)
//            .overflow(false)
                ;
        assertThat(t).isNotNull();
        assertThat(t.build())
                .isNotNull()
                .isInstanceOf(Text.class);
    }
}
