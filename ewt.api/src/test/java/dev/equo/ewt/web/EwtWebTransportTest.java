package dev.equo.ewt.web;

import org.junit.jupiter.api.Test;
import java.util.concurrent.atomic.AtomicReference;
import static org.junit.jupiter.api.Assertions.*;

class EwtWebTransportTest {

  @Test
  void publishesOnPerRegionChannel() {
    AtomicReference<String> event = new AtomicReference<>();
    AtomicReference<byte[]> payload = new AtomicReference<>();
    EwtWebTransport.publish(42, "{\"t\":\"Text\"}", (e, p) -> { event.set(e); payload.set(p); });
    assertEquals("EwtWidget/42/subtree", event.get());
    assertEquals("{\"t\":\"Text\"}", new String(payload.get(), java.nio.charset.StandardCharsets.UTF_8));
  }

  @Test
  void webModeReadsSystemProperty() {
    String prev = System.getProperty("dev.equo.swt.mode");
    try {
      System.setProperty("dev.equo.swt.mode", "desktop");
      assertFalse(EwtWebTransport.isWebMode());
      System.clearProperty("dev.equo.swt.mode");
      assertTrue(EwtWebTransport.isWebMode());
    } finally {
      if (prev != null) System.setProperty("dev.equo.swt.mode", prev);
      else System.clearProperty("dev.equo.swt.mode");
    }
  }
}
