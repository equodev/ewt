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

  /**
   * True when the widgets_web / comm renderer is active — i.e. widgets are serialized over Evolve's
   * comm instead of built through the FFM native bridge. That is the case on Evolve's web surface
   * (mode unset), and also on any surface running a JVM below 22, where the FFM layer is absent
   * (it ships under META-INF/versions/22) so construction must go through the comm path.
   *
   * <p>The name is kept for the ~2900 generated guards that read it as "can this render without FFM";
   * override with {@code -Ddev.equo.ewt.transport=comm|ffm} to force a path (tests / diagnostics).
   */
  public static boolean isWebMode() {
    String forced = System.getProperty("dev.equo.ewt.transport");
    if ("comm".equalsIgnoreCase(forced)) return true;
    if ("ffm".equalsIgnoreCase(forced)) return false;
    String mode = System.getProperty("dev.equo.swt.mode");
    boolean webSurface = mode == null || mode.isBlank() || mode.equalsIgnoreCase("web");
    return webSurface || Runtime.version().feature() < 22;
  }

  /** The per-region channel carrying the serialized subtree (Java -> browser). */
  public static String subtreeEvent(int regionId) {
    return "EwtWidget/" + regionId + "/subtree";
  }

  /** The per-region channel on which the browser asks for a (re)send of its subtree. */
  public static String requestEvent(int regionId) {
    return subtreeEvent(regionId) + "/request";
  }

  /** The per-region channel carrying the render transport ("comm" or "ffm") so the native Dart region
   *  knows whether to build the comm-fed region or the FFM one. Sent by Java in both modes. */
  public static String transportEvent(int regionId) {
    return "EwtWidget/" + regionId + "/transport";
  }

  /** The per-region channel on which the Dart region asks Java to (re)send the transport. */
  public static String transportRequestEvent(int regionId) {
    return transportEvent(regionId) + "/request";
  }

  /** The per-region channel telling the Dart region its content changed on the Java side, so the
   *  subtree it retains must be built again (Java -> Dart). On FFM that is a new builder registered
   *  by {@code setWidget}; the comm path needs no such signal, since the subtree itself arrives on
   *  {@link #subtreeEvent}. The region otherwise keeps its built subtree across every Evolve rebuild. */
  public static String rebuildEvent(int regionId) {
    return "EwtWidget/" + regionId + "/rebuild";
  }

  /** The per-region channel on which the browser reports a callback invocation (browser -> Java). */
  public static String callbackEvent(int regionId) {
    return "EwtWidget/" + regionId + "/callback";
  }

  public static void publish(int regionId, String json, BiConsumer<String, byte[]> sink) {
    sink.accept(subtreeEvent(regionId), json.getBytes(StandardCharsets.UTF_8));
  }

  /** The per-region channel on which Java sends animation commands (forward/reverse/etc.) to the browser. */
  public static String animEvent(int regionId) {
    return "EwtWidget/" + regionId + "/anim";
  }

  public static void publishAnim(int regionId, String json, BiConsumer<String, byte[]> sink) {
    sink.accept(animEvent(regionId), json.getBytes(StandardCharsets.UTF_8));
  }
}
