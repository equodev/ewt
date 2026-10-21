package dev.equo.ewt;

import dev.equo.ewt.web.WebAsyncCallbackBroker;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
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

  /**
   * Maps a status-listener id → the sink that receives AnimationStatus ordinals from the browser.
   * Ids are NEGATIVE (allocated by {@link #registerStatusListener}), which keeps them disjoint
   * from UI callback ids (small positives) and async callback ids (≥ {@code ASYNC_CALLBACK_ID_BASE}),
   * so a single callback payload can be routed by the sign/range of its first element.
   */
  private static final Map<Integer, java.util.function.IntConsumer> STATUS_LISTENERS =
      java.util.Collections.synchronizedMap(new java.util.HashMap<>());

  private static final java.util.concurrent.atomic.AtomicInteger NEXT_STATUS_LISTENER_ID =
      new java.util.concurrent.atomic.AtomicInteger(-1);

  /**
   * Process-wide broker for async web commands. Any AnimationController operation whose Dart
   * counterpart returns a {@code TickerFuture} (or generally a {@code Future<T>}) registers a
   * {@link CompletableFuture} here and encodes the assigned callback id in the outbound command.
   * The web side echoes the callback id back through the callback channel and
   * {@link #completeAsyncCallback(int, Object)} resolves the matching future.
   */
  private static final WebAsyncCallbackBroker ASYNC_BROKER = new WebAsyncCallbackBroker();

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

  /**
   * Removes anim sinks for the given controllers AND fails any in-flight async callbacks for
   * those controllers so downstream Java callers never wait forever after the region is torn down.
   */
  public static void unregisterAnimSinks(java.util.Set<Integer> ctrlIds) {
    ctrlIds.forEach(id -> {
      ANIM_SINKS.remove(id);
      ASYNC_BROKER.cancelAllForController(id);
    });
  }

  /** Registers a status-listener sink and returns its (negative) id to encode in the outbound
   *  {@code addStatusListener} command. The browser echoes the id with each AnimationStatus change. */
  public static int registerStatusListener(java.util.function.IntConsumer onStatus) {
    int id = NEXT_STATUS_LISTENER_ID.getAndDecrement();
    STATUS_LISTENERS.put(id, onStatus);
    return id;
  }

  /** True when {@code id} is in the status-listener range (negative). Lets the receive side route a
   *  callback payload to {@link #fireStatusListener} instead of the one-shot async broker. */
  public static boolean isStatusListenerId(int id) {
    return id < 0;
  }

  /** Delivers an AnimationStatus ordinal from the browser to the registered status-listener sink. */
  public static void fireStatusListener(int id, int statusOrdinal) {
    java.util.function.IntConsumer sink = STATUS_LISTENERS.get(id);
    if (sink != null) sink.accept(statusOrdinal);
  }

  /** Drops a status-listener sink (region torn down / controller disposed). */
  public static void unregisterStatusListener(int id) {
    STATUS_LISTENERS.remove(id);
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

  // --- Async callback bridge (Future-returning methods on AnimationController etc.) --------

  /** Allocates a fresh callback id for pairing an outbound command with its inbound response. */
  public static int nextAsyncCallbackId() {
    return ASYNC_BROKER.nextCallbackId();
  }

  /**
   * Registers a pending {@link CompletableFuture} for the given (callbackId, ctrlId) pair. Caller
   * must have obtained the id via {@link #nextAsyncCallbackId()} first, so it can encode the id
   * in the outbound command BEFORE waiting for the response (race-free ordering).
   */
  public static CompletableFuture<Object> registerAsyncCallback(int callbackId, int ctrlId) {
    return ASYNC_BROKER.register(callbackId, ctrlId);
  }

  /** Invoked from the transport when the web side reports completion for {@code callbackId}. */
  public static void completeAsyncCallback(int callbackId, Object value) {
    ASYNC_BROKER.complete(callbackId, value);
  }

  /** Invoked from the transport when the web side reports a failure for {@code callbackId}. */
  public static void failAsyncCallback(int callbackId, Throwable cause) {
    ASYNC_BROKER.completeExceptionally(callbackId, cause);
  }

  /**
   * Sends a Future-returning animation command with its callback id and args. The Dart side is
   * expected to invoke the operation, subscribe to the resulting Future, and echo the callback id
   * back through the region's callback channel so {@link #completeAsyncCallback(int, Object)}
   * resolves the matching future.
   *
   * <p>Args are encoded as a plain JSON array of primitives (numbers, strings, booleans) or nested
   * arrays. This is not a full JSON serializer — the arg list is only meant to carry the small
   * primitive payloads that the imperative controller methods take (target values, durations,
   * curve names). Complex objects are outside the scope of this channel.
   */
  public static void sendAsyncAnimCommand(int ctrlId, String action, int callbackId, List<Object> args) {
    Consumer<String> sink = ANIM_SINKS.get(ctrlId);
    if (sink == null) {
      System.out.println("EWT web: no anim sink for controller " + ctrlId + " (async action=" + action + ")");
      return;
    }
    StringBuilder sb = new StringBuilder(64);
    sb.append("{\"ctrlId\":").append(ctrlId)
      .append(",\"action\":\"").append(action)
      .append("\",\"callbackId\":").append(callbackId)
      .append(",\"args\":");
    encodeJsonArray(sb, args);
    sb.append('}');
    sink.accept(sb.toString());
  }

  private static void encodeJsonArray(StringBuilder sb, List<Object> args) {
    sb.append('[');
    for (int i = 0; i < args.size(); i++) {
      if (i > 0) sb.append(',');
      encodeJsonScalar(sb, args.get(i));
    }
    sb.append(']');
  }

  private static void encodeJsonScalar(StringBuilder sb, Object v) {
    if (v == null) sb.append("null");
    else if (v instanceof Boolean || v instanceof Number) sb.append(v);
    else if (v instanceof List) {
      @SuppressWarnings("unchecked")
      List<Object> nested = (List<Object>) v;
      encodeJsonArray(sb, nested);
    }
    else {
      // String or fallback — JSON-escape only the two characters that would break the payload
      // (quote + backslash) and control chars. Sufficient for the primitive arg surface this
      // channel carries; if it ever grows to arbitrary user text, swap for a real serializer.
      sb.append('"');
      String s = v.toString();
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '"' || c == '\\') sb.append('\\').append(c);
        else if (c < 0x20) sb.append("\\u").append(String.format("%04x", (int) c));
        else sb.append(c);
      }
      sb.append('"');
    }
  }
}
