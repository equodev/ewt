package dev.equo.ewt;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Thread-safe append buffer for Flutter framework errors captured during a native
 * render test run.
 *
 * <p>Writes arrive from the FFM upcall thread (Dart's {@code FlutterError.onError}
 * replacement calls {@code callFlutterErrorCallback} in widgets.c, which invokes the
 * Java upcall registered by {@link EngineHandle}); reads arrive from JUnit test threads.
 *
 * <p>Typical usage in a test:
 * <pre>{@code
 *   long pre = postFrames.lastFrameId();
 *   engine.requestRebuild();
 *   postFrames.awaitFrameAfter(pre).get(5, SECONDS);
 *   long post = postFrames.lastFrameId();
 *   assertTrue(errors.errorsBetween(pre, post).isEmpty());
 * }</pre>
 */
public final class FlutterErrorCollector {

    private final ConcurrentLinkedQueue<FlutterErrorRecord> records = new ConcurrentLinkedQueue<>();

    /**
     * Returns all errors whose {@code frameId} falls in the half-open interval
     * {@code (preId, postId]} — i.e. strictly greater than {@code preId} and less than
     * or equal to {@code postId}.
     *
     * @param preId  exclusive lower bound (typically the frame id snapped before a rebuild)
     * @param postId inclusive upper bound (typically the frame id snapped after the rebuild)
     * @return an unmodifiable snapshot; never {@code null}
     */
    public List<FlutterErrorRecord> errorsBetween(long preId, long postId) {
        return records.stream()
                .filter(r -> r.frameId() > preId && r.frameId() <= postId)
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * Appends one error record.  Called from the FFM upcall on a native thread;
     * {@link ConcurrentLinkedQueue} makes this wait-free.
     *
     * <p>Package-private: only {@link EngineHandle} should call this.
     */
    void onError(FlutterErrorRecord r) {
        records.add(r);
    }
}
