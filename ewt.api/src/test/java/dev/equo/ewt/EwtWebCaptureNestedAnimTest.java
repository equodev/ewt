package dev.equo.ewt;

import static org.junit.jupiter.api.Assertions.*;
import static dev.equo.ewt.EWT.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 * Regression for ewt#67 — a {@link SubAnimatedState} that is NOT the {@code setWidget} root
 * (the common "animated widget inside a page" shape) must still have its controller commands
 * routed to the region's anim sink on the web path. Before the fix the nested state got no
 * sink, so {@code forward()} in its {@code initState} was dropped silently and the animation
 * never ran. Also covers #68 — {@code setValue(v)} must ship its value on web.
 */
class EwtWebCaptureNestedAnimTest {

  /** An animated bar: initState creates a controller and forwards it, like a progress bar. */
  static class AnimatedBar extends SubStatefulWidget {
    @Override protected State<AnimatedBar> createState() { return new S(); }
    static class S extends SubAnimatedState<AnimatedBar> {
      AnimationController ctrl;
      @Override protected void initState() {
        ctrl = animationController(Duration().milliseconds(300));
        ctrl.forward();
      }
      @Override protected Widget build(BuildContext context) {
        return SizeTransition().sizeFactor(ctrl).child(Text("bar")).build();
      }
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
  void nestedSubAnimatedStateInitStateCommandReachesSink() throws Exception {
    String prev = forceWeb();
    List<String> sent = new ArrayList<>();
    AnimatedBar.S nested = null;
    try {
      // Root is a plain Center; the AnimatedBar is a deferred nested child, not the root.
      EwtCapture cap = EwtWebCapture.captureSubtree(
          () -> Center().child(new AnimatedBar()).build(), sent::add);
      assertEquals(1, cap.nestedStates.size(), "the nested SubAnimatedState was flattened");
      nested = (AnimatedBar.S) cap.nestedStates.get(0);
      assertTrue(
          sent.stream().anyMatch(s -> s.contains("\"action\":\"forward\"")),
          "nested initState forward() reached the anim sink; got " + sent);
    } finally {
      if (nested != null && nested.ctrl != null) {
        EwtWebState.unregisterAnimSinks(Set.of(nested.ctrl.getId()));
      }
      restore(prev);
    }
  }

  @Test
  void setValueCarriesItsValueOnWeb() throws Exception {
    String prev = forceWeb();
    List<String> sent = new ArrayList<>();
    AnimatedBar.S state = null;
    try {
      EwtCapture cap = EwtWebCapture.captureSubtree(AnimatedBar::new, sent::add);
      state = (AnimatedBar.S) cap.state;
      sent.clear(); // drop the initState forward; keep only what setValue emits
      state.ctrl.setValue(0.5);
      assertTrue(
          sent.stream().anyMatch(s -> s.contains("\"action\":\"setValue:0.5\"")),
          "setValue(0.5) shipped its value as setValue:0.5; got " + sent);
    } finally {
      if (state != null && state.ctrl != null) {
        EwtWebState.unregisterAnimSinks(Set.of(state.ctrl.getId()));
      }
      restore(prev);
    }
  }
}
