package dev.equo.ewt;

import org.junit.jupiter.api.Test;
import java.util.concurrent.*;
import static org.junit.jupiter.api.Assertions.*;

class PostFrameNotifierTest {

    @Test
    void awaitFrameAfter_completesOnNextFrame() throws Exception {
        var n = new PostFrameNotifier();
        long pre = n.lastFrameId();
        CompletableFuture<PostFrame> fut = n.awaitFrameAfter(pre);
        n.onFrame(pre + 1, "[]");
        PostFrame pf = fut.get(1, TimeUnit.SECONDS);
        assertEquals(pre + 1, pf.frameId());
        assertEquals("[]", pf.snapshotJson());
    }

    @Test
    void awaitFrameAfter_ignoresStaleFrames() throws Exception {
        var n = new PostFrameNotifier();
        n.onFrame(10, "[]");                       // "old" frame
        CompletableFuture<PostFrame> fut = n.awaitFrameAfter(10);
        assertFalse(fut.isDone());
        n.onFrame(11, "[{}]");
        assertEquals(11, fut.get(1, TimeUnit.SECONDS).frameId());
    }

    @Test
    void awaitFrameAfter_completesImmediately_ifRaceFrameAlreadyArrived() throws Exception {
        // Closes the race window where a rebuild's post-frame notification lands
        // between the caller snapshotting lastFrameId() and enqueuing the waiter.
        var n = new PostFrameNotifier();
        n.onFrame(5, "[{\"t\":\"X\"}]");
        CompletableFuture<PostFrame> fut = n.awaitFrameAfter(4);
        PostFrame pf = fut.get(100, TimeUnit.MILLISECONDS);
        assertEquals(5, pf.frameId());
        assertEquals("[{\"t\":\"X\"}]", pf.snapshotJson());
    }

    @Test
    void lastFrameId_startsAtNegativeOne_beforeAnyFrame() {
        // Sentinel makes awaitFrameAfter(0) safe against the bootstrap frame id=0.
        var n = new PostFrameNotifier();
        assertEquals(-1L, n.lastFrameId());
    }
}
