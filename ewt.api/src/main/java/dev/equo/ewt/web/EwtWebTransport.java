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

  /** The per-region channel carrying the serialized subtree (Java -> browser). */
  public static String subtreeEvent(int regionId) {
    return "EwtWidget/" + regionId + "/subtree";
  }

  /** The per-region channel on which the browser asks for a (re)send of its subtree. */
  public static String requestEvent(int regionId) {
    return subtreeEvent(regionId) + "/request";
  }

  public static void publish(int regionId, String json, BiConsumer<String, byte[]> sink) {
    sink.accept(subtreeEvent(regionId), json.getBytes(StandardCharsets.UTF_8));
  }
}
