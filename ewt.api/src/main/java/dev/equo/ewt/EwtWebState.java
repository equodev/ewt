package dev.equo.ewt;

import java.util.Map;
import java.util.function.Consumer;

/**
 * Web-mode state manager: links a SubState or SubAnimatedState to its owning region's rebuild
 * hook, so a web-mode setState can trigger a re-flatten + republish without the native engine.
 * Also routes animation commands (forward/reverse/etc.) from AnimationController to the region's
 * anim comm channel.
 */
public final class EwtWebState {
  private static final Map<Object, Runnable> REBUILD_HOOKS =
      java.util.Collections.synchronizedMap(new java.util.IdentityHashMap<>());

  /** Maps controller id → the anim command sink for the region that owns that controller. */
  private static final Map<Integer, Consumer<String>> ANIM_SINKS =
      java.util.Collections.synchronizedMap(new java.util.HashMap<>());

  private EwtWebState() {}

  public static void register(Object state, Runnable rebuildHook) {
    REBUILD_HOOKS.put(state, rebuildHook);
  }

  public static void unregister(Object state) {
    REBUILD_HOOKS.remove(state);
  }

  public static void requestRebuild(Object state) {
    Runnable hook = REBUILD_HOOKS.get(state);
    if (hook != null) hook.run();
    else System.out.println("EWT web: no rebuild hook for state " + state);
  }

  /** Registers a command sink for an AnimationController so forward/reverse/etc. reach Dart. */
  public static void registerAnimSink(int ctrlId, Consumer<String> sink) {
    ANIM_SINKS.put(ctrlId, sink);
  }

  /** Removes anim sinks for all controllers whose id is in the given set. */
  public static void unregisterAnimSinks(java.util.Set<Integer> ctrlIds) {
    ctrlIds.forEach(ANIM_SINKS::remove);
  }

  /** Sends an animation command for the given controller id to its registered Dart sink. */
  public static void sendAnimCommand(int ctrlId, String action) {
    Consumer<String> sink = ANIM_SINKS.get(ctrlId);
    if (sink != null) {
      sink.accept("{\"ctrlId\":" + ctrlId + ",\"action\":\"" + action + "\"}");
    } else {
      System.out.println("EWT web: no anim sink for controller " + ctrlId + " (action=" + action + ")");
    }
  }
}
