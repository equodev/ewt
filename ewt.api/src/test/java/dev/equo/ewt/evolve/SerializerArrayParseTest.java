package dev.equo.ewt.evolve;

import static org.junit.jupiter.api.Assertions.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import dev.equo.swt.Serializer;
import org.junit.jupiter.api.Test;

class SerializerArrayParseTest {
  @Test
  void dslJsonParsesCallbackArraysToList() throws Exception {
    Serializer s = new Serializer();

    Object one = s.from(Object.class, "[5]".getBytes(StandardCharsets.UTF_8));
    assertInstanceOf(List.class, one);
    assertEquals(5, ((Number) ((List<?>) one).get(0)).intValue());

    List<?> two = (List<?>) s.from(Object.class, "[7,true]".getBytes(StandardCharsets.UTF_8));
    assertEquals(7, ((Number) two.get(0)).intValue());
    assertEquals(Boolean.TRUE, two.get(1));

    List<?> str = (List<?>) s.from(Object.class, "[9,\"hi\"]".getBytes(StandardCharsets.UTF_8));
    assertEquals("hi", str.get(1));
  }
}
