package dev.equo.ewt;

import static org.junit.jupiter.api.Assertions.*;
import static dev.equo.ewt.EWT.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;

/**
 * Web-path {@code AnimationController.addStatusListener} (ewt#70, web half): a Java listener is
 * registered under a negative id, an {@code addStatusListener} command carrying that id is shipped
 * to the browser, and each AnimationStatus the browser echoes back is mapped to the Java enum and
 * delivered to the listener. The Dart half (registering on the live controller) needs a running
 * web app to verify.
 */
class EwtWebStateStatusListenerTest {

  static class Thing extends SubStatefulWidget {
    @Override protected State<Thing> createState() { return new S(); }
    static class S extends SubAnimatedState<Thing> {
      AnimationController ctrl;
      @Override protected void initState() { ctrl = animationController(Duration().milliseconds(100)); }
      @Override protected Widget build(BuildContext context) { return Text("x").build(); }
    }
  }

  private static String forceWeb() {
    String prev = System.getProperty("dev.equo.ewt.transport");
    System.setProperty("dev.equo.ewt.transport", "comm");
    return prev;
  }

  private static void restore(String prev) {
    if (prev == null) System.clearProperty("dev.equo.ewt.transport");
    else System.setProperty("dev.equo.ewt.transport", prev);
  }

  @Test
  void statusListenerIdsAreNegativeAndDisjoint() {
    int id = EwtWebState.registerStatusListener(v -> {});
    try {
      assertTrue(id < 0, "status-listener ids are negative");
      assertTrue(EwtWebState.isStatusListenerId(id));
      assertFalse(EwtWebState.isStatusListenerId(5), "UI callback id is not a status id");
      assertFalse(EwtWebState.isStatusListenerId(1_000_000), "async broker id is not a status id");
    } finally {
      EwtWebState.unregisterStatusListener(id);
    }
  }

  @Test
  void fireStatusListenerDeliversOrdinal() {
    int[] got = {-1};
    int id = EwtWebState.registerStatusListener(v -> got[0] = v);
    try {
      EwtWebState.fireStatusListener(id, 2);
      assertEquals(2, got[0]);
      EwtWebState.unregisterStatusListener(id);
      EwtWebState.fireStatusListener(id, 0); // dropped after unregister
      assertEquals(2, got[0], "no delivery after unregister");
    } finally {
      EwtWebState.unregisterStatusListener(id);
    }
  }

  @Test
  void addStatusListenerShipsCommandAndMapsStatusBack() throws Exception {
    String prev = forceWeb();
    List<String> sent = new ArrayList<>();
    Thing.S state = null;
    int listenerId = 0;
    AtomicReference<AnimationStatus> seen = new AtomicReference<>();
    try {
      EwtCapture cap = EwtWebCapture.captureSubtree(Thing::new, sent::add);
      state = (Thing.S) cap.state;
      sent.clear();
      state.ctrl.addStatusListener(seen::set);

      String cmd = sent.stream().filter(s -> s.contains("addStatusListener:")).findFirst().orElse(null);
      assertNotNull(cmd, "addStatusListener command was shipped to the sink; got " + sent);
      listenerId = parseListenerId(cmd);
      assertTrue(listenerId < 0, "command carried a negative listener id");

      // Simulate the browser echoing a 'completed' status (ordinal 3) back.
      EwtWebState.fireStatusListener(listenerId, AnimationStatus.completed.ordinal());
      assertEquals(AnimationStatus.completed, seen.get(), "ordinal mapped back to the Java enum");
    } finally {
      restore(prev);
      if (listenerId < 0) EwtWebState.unregisterStatusListener(listenerId);
      if (state != null && state.ctrl != null) EwtWebState.unregisterAnimSinks(Set.of(state.ctrl.getId()));
    }
  }

  @Test
  void statusListenerIsReclaimedWhenStateClears() throws Exception {
    String prev = forceWeb();
    List<String> sent = new ArrayList<>();
    Thing.S state = null;
    int[] fired = {0};
    try {
      EwtCapture cap = EwtWebCapture.captureSubtree(Thing::new, sent::add);
      state = (Thing.S) cap.state;
      state.ctrl.addStatusListener(s -> fired[0]++);
      int listenerId = parseListenerId(
          sent.stream().filter(s -> s.contains("addStatusListener:")).findFirst().orElseThrow());

      EwtWebState.fireStatusListener(listenerId, 3);
      assertEquals(1, fired[0], "listener fires before teardown");

      // What EwtWidget.clearWebState does on a full re-publish / dispose: reclaim the state's sinks.
      state.clearWebStatusListeners();
      EwtWebState.fireStatusListener(listenerId, 3);
      assertEquals(1, fired[0], "no delivery after the owning state reclaims its listeners");
    } finally {
      restore(prev);
      if (state != null) {
        state.clearWebStatusListeners();
        if (state.ctrl != null) EwtWebState.unregisterAnimSinks(Set.of(state.ctrl.getId()));
      }
    }
  }

  // Parses the int after "addStatusListener:" in {"ctrlId":N,"action":"addStatusListener:-1"}.
  private static int parseListenerId(String cmd) {
    int i = cmd.indexOf("addStatusListener:") + "addStatusListener:".length();
    int j = i;
    while (j < cmd.length() && (cmd.charAt(j) == '-' || Character.isDigit(cmd.charAt(j)))) j++;
    return Integer.parseInt(cmd.substring(i, j));
  }
}
