package dev.equo.ewt.evolve;

/**
 * Bridge from EWT to Evolve's comm. Resolves the comm owned by the region's Display (per-Display
 * on web), so the subtree frame goes to the browser hosting this region rather than the desktop
 * comm. Kept in the evolve source set because it references Evolve's FlutterBridge.
 */
public final class EvolveComm {

  private EvolveComm() {}

  public static void send(Object regionImpl, String event, byte[] payload) {
    dev.equo.swt.FlutterBridge.commFor(regionImpl).send(event, payload);
  }

  /** Registers a no-payload handler on the region's comm (browser -> Java), e.g. a resend request. */
  public static void onEvent(Object regionImpl, String event, Runnable cb) {
    dev.equo.swt.FlutterBridge.commFor(regionImpl).on(event, byte[].class, p -> cb.run());
  }

  /** Registers a payload-carrying handler on the region's comm (browser -> Java). The raw frame
   *  bytes are delivered (byte[].class is a passthrough in CommService). */
  public static void onPayload(Object regionImpl, String event, java.util.function.Consumer<byte[]> cb) {
    dev.equo.swt.FlutterBridge.commFor(regionImpl).on(event, byte[].class, cb);
  }
}
