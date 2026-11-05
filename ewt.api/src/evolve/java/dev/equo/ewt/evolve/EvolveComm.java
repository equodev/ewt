package dev.equo.ewt.evolve;

import dev.equo.swt.comm.ChannelHeader;

/**
 * Bridge from EWT to Evolve's comm. Resolves the comm owned by the region's Display (per-Display
 * on web), so the subtree frame goes to the browser hosting this region rather than the desktop
 * comm. Kept in the evolve source set because it references Evolve's FlutterBridge.
 *
 * <p>EWT addresses its per-region channels by the name {@code EwtWidget/<id>/<name>}, which is
 * exactly Evolve's {@code Type/id/name} wire addressing. Evolve's comm numbers channels and types
 * ({@link ChannelHeader}, generated into {@code dev.equo.swt.WireTable}), so this translates the
 * name to the numbers the wire carries: the type is always {@code EwtWidget} (numbered once), the
 * id is the region's, and the channel name — the part after the id, which may itself contain a
 * slash ({@code subtree/request}) — is numbered per call. EWT's channel names are registered in the
 * generator's hand-written channel list, so they resolve here instead of throwing.
 */
public final class EvolveComm {

  private EvolveComm() {}

  /** The wire number of the {@code EwtWidget} record type; every EWT channel is one of its. */
  private static final int EWT_TYPE = ChannelHeader.requireType("EwtWidget");

  public static void send(Object regionImpl, String event, byte[] payload) {
    Addr a = Addr.of(event);
    dev.equo.swt.FlutterBridge.commFor(regionImpl).send(EWT_TYPE, a.id, a.channel, payload);
  }

  /** Registers a no-payload handler on the region's comm (browser -> Java), e.g. a resend request. */
  public static void onEvent(Object regionImpl, String event, Runnable cb) {
    Addr a = Addr.of(event);
    dev.equo.swt.FlutterBridge.commFor(regionImpl).on(EWT_TYPE, a.id, a.channel, byte[].class, p -> cb.run());
  }

  /** Registers a payload-carrying handler on the region's comm (browser -> Java). The JSON body is
   *  deserialized to an Object (a List for the callback arrays [id] / [id, arg]). */
  public static void onPayload(Object regionImpl, String event, java.util.function.Consumer<Object> cb) {
    Addr a = Addr.of(event);
    dev.equo.swt.FlutterBridge.commFor(regionImpl).on(EWT_TYPE, a.id, a.channel, Object.class, cb);
  }

  /** A parsed {@code EwtWidget/<id>/<name>} address, as the numbers the wire carries. */
  private static final class Addr {
    final long id;
    final int channel;

    private Addr(long id, int channel) {
      this.id = id;
      this.channel = channel;
    }

    static Addr of(String event) {
      int firstSlash = event.indexOf('/');
      int secondSlash = event.indexOf('/', firstSlash + 1);
      if (firstSlash < 0 || secondSlash < 0) {
        throw new IllegalArgumentException("not an EwtWidget/<id>/<name> address: " + event);
      }
      long id = Long.parseLong(event.substring(firstSlash + 1, secondSlash));
      int channel = ChannelHeader.requireChannel(event.substring(secondSlash + 1));
      return new Addr(id, channel);
    }
  }
}
