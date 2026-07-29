package dev.equo.ewt;

import java.util.IdentityHashMap;
import java.util.Map;

/** Web-mode state manager: links a SubState to its owning region's rebuild hook, so a web-mode
 *  setState can trigger a re-flatten + republish without the native engine. */
public final class EwtWebState {
  private static final Map<SubState<?>, Runnable> REBUILD_HOOKS =
      java.util.Collections.synchronizedMap(new java.util.IdentityHashMap<>());

  private EwtWebState() {}

  public static void register(SubState<?> state, Runnable rebuildHook) {
    REBUILD_HOOKS.put(state, rebuildHook);
  }

  public static void unregister(SubState<?> state) {
    REBUILD_HOOKS.remove(state);
  }

  public static void requestRebuild(SubState<?> state) {
    Runnable hook = REBUILD_HOOKS.get(state);
    if (hook != null) hook.run();
    else System.out.println("EWT web: no rebuild hook for state " + state);
  }
}
