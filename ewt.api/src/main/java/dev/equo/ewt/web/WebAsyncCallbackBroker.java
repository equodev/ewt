package dev.equo.ewt.web;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Correlates Java-side {@link CompletableFuture} instances with async web commands issued
 * to the Dart side of the transport. The caller allocates an id via {@link #nextCallbackId()},
 * encodes it in the outbound command, then {@link #register(int, int)}s the future. When the
 * Dart side reports completion for that id via {@link #complete(int, Object)}, the future
 * resolves.
 *
 * <p>The controller id kept alongside each pending future lets
 * {@link #cancelAllForController(int)} fail every in-flight future for a controller whose
 * transport is going away (e.g., its owning {@code SubAnimatedState} is disposing).
 *
 * <p>Thread-safe: uses a {@link ConcurrentHashMap} for the pending table and
 * {@link AtomicInteger} for the id counter, so multiple threads may issue commands
 * concurrently without external locking.
 */
public final class WebAsyncCallbackBroker {
    /**
     * Base offset for async callback ids so they never collide with the UI-callback
     * ids that {@code SerializingWidgetConstructors} allocates from 1 upward per
     * region. A region emitting a million user-facing callbacks (button taps, text
     * changes) would take decades of continuous interaction, so this gives us a
     * clean disjoint space without threading a shared counter across two very
     * different lifecycles.
     */
    public static final int ASYNC_CALLBACK_ID_BASE = 1_000_000;

    private final Map<Integer, PendingCallback> pending = new ConcurrentHashMap<>();
    private final AtomicInteger nextId = new AtomicInteger(ASYNC_CALLBACK_ID_BASE);

    /** Returns the next unique async callback id (always {@code >= ASYNC_CALLBACK_ID_BASE}). */
    public int nextCallbackId() {
        return nextId.getAndIncrement();
    }

    /**
     * Registers a callback id previously obtained via {@link #nextCallbackId()} against
     * a controller and returns the future that will resolve when
     * {@link #complete(int, Object)} is invoked for that id.
     */
    public CompletableFuture<Object> register(int callbackId, int ctrlId) {
        CompletableFuture<Object> future = new CompletableFuture<>();
        pending.put(callbackId, new PendingCallback(ctrlId, future));
        return future;
    }

    /** Resolves the future registered under {@code callbackId}. No-op if unknown. */
    public void complete(int callbackId, Object value) {
        PendingCallback pc = pending.remove(callbackId);
        if (pc != null) pc.future.complete(value);
    }

    /** Fails the future registered under {@code callbackId}. No-op if unknown. */
    public void completeExceptionally(int callbackId, Throwable cause) {
        PendingCallback pc = pending.remove(callbackId);
        if (pc != null) pc.future.completeExceptionally(cause);
    }

    /**
     * Fails every in-flight future belonging to the given controller. Called when the
     * controller's transport is torn down so downstream Java callers never wait forever.
     */
    public void cancelAllForController(int ctrlId) {
        pending.entrySet().removeIf(entry -> {
            if (entry.getValue().ctrlId == ctrlId) {
                entry.getValue().future.completeExceptionally(
                    new IllegalStateException("Controller " + ctrlId + " disposed before web callback resolved"));
                return true;
            }
            return false;
        });
    }

    // Plain class (not a record) to keep bytecode --release 11-compatible per the
    // java-11 split (MR !98 / ewt#58) — this file does not touch java.lang.foreign.
    private static final class PendingCallback {
        final int ctrlId;
        final CompletableFuture<Object> future;

        PendingCallback(int ctrlId, CompletableFuture<Object> future) {
            this.ctrlId = ctrlId;
            this.future = future;
        }
    }
}
