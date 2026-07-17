package dev.equo.ewt.web;

import java.nio.charset.StandardCharsets;
import java.util.function.BiConsumer;

/**
 * Web-mode transport for the EWT region: publishes a region's serialized subtree over Evolve's
 * comm on the per-region event {@code EwtWidget/<id>/subtree}. Evolve relays the bytes without
 * parsing them, keeping it EWT-agnostic. The {@code sink} decouples this from Evolve's concrete
 * comm type so it stays unit-testable.
 */
public final class EwtWebTransport {

  private EwtWebTransport() {}

  /** True when running under Evolve's web surface (mode unset); false for desktop/chromium. */
  public static boolean isWebMode() {
    String mode = System.getProperty("dev.equo.swt.mode");
    return mode == null || mode.isBlank();
  }

  public static void publish(int regionId, String json, BiConsumer<String, byte[]> sink) {
    sink.accept("EwtWidget/" + regionId + "/subtree", json.getBytes(StandardCharsets.UTF_8));
  }
}
