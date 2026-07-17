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
}
