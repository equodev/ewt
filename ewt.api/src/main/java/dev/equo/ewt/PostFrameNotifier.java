package dev.equo.ewt;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Thread-safe registry of per-frame listeners for the native render test harness.
 *
 * <p>Writes arrive from the FFM upcall thread (Dart's persistent-frame callback via
 * {@code callPostFrameCallback} in widgets.c); reads arrive from JUnit test threads.
 * No {@code synchronized} block is used for waiter completion — completing a
 * {@code CompletableFuture} under lock can deadlock if the completion action itself
 * blocks.
 *
 * <p>Typical usage in a test:
 * <pre>{@code
 *   long before = postFrames.lastFrameId();
 *   engine.requestRebuild();
 *   PostFrame pf = postFrames.awaitFrameAfter(before).get(5, SECONDS);
 * }</pre>
 */
public final class PostFrameNotifier {

    // Sentinel used before any real frame has arrived.  Frame IDs from Dart are
    // >= 0, so a caller that snapshots lastFrameId() before boot and then calls
    // awaitFrameAfter(0) still races correctly with the bootstrap frame id 0.
    private static final PostFrame INITIAL = new PostFrame(-1L, "");

    private final AtomicReference<PostFrame> last = new AtomicReference<>(INITIAL);
    private final ConcurrentLinkedQueue<Pending> waiters = new ConcurrentLinkedQueue<>();

    private record Pending(long afterFrameId, CompletableFuture<PostFrame> fut) {}

    /** Returns the frame id of the most recently received post-frame notification, or {@code -1} if none yet. */
    public long lastFrameId() {
        return last.get().frameId();
    }

    /**
     * Returns a future that completes with the first {@link PostFrame} whose
     * {@code frameId} is strictly greater than {@code frameId}.
     *
     * <p>If a qualifying frame has already been received before this method is called,
     * the future completes immediately with that most recent frame — this closes the
     * race window where a rebuild's post-frame notification lands between the caller
     * snapshotting {@code lastFrameId()} and enqueuing the waiter.
     */
    public CompletableFuture<PostFrame> awaitFrameAfter(long frameId) {
        var fut = new CompletableFuture<PostFrame>();
        // Enqueue FIRST so onFrame() can never complete us AFTER we've decided not to
        // short-circuit — the completion race is one-way: either onFrame sees our
        // waiter and completes it, or we observe a qualifying last-frame ourselves.
        waiters.offer(new Pending(frameId, fut));
        PostFrame observed = last.get();
        if (observed.frameId() > frameId && !fut.isDone()) {
            // Complete with the already-observed frame; remove ourselves from the queue
            // if still present so onFrame() does not later re-complete redundantly.
            fut.complete(observed);
            waiters.removeIf(p -> p.fut() == fut);
        }
        return fut;
    }

    /**
     * Invoked from the FFM upcall on a native thread whenever Dart's post-frame
     * snapshot has been captured.  Updates the last-frame snapshot and completes
     * any registered waiters whose threshold is strictly less than {@code frameId}.
     *
     * <p>Package-private: only {@link EngineHandle} should call this.
     */
    void onFrame(long frameId, String snapshotJson) {
        var pf = new PostFrame(frameId, snapshotJson);
        last.set(pf);
        waiters.removeIf(p -> {
            if (frameId > p.afterFrameId()) {
                p.fut().complete(pf);
                return true;
            }
            return false;
        });
    }
}
