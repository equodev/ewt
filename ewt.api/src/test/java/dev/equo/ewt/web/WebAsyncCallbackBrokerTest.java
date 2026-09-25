package dev.equo.ewt.web;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

class WebAsyncCallbackBrokerTest {

    @Test
    void nextCallbackIdReturnsUniqueIncrementingIds() {
        WebAsyncCallbackBroker broker = new WebAsyncCallbackBroker();
        int a = broker.nextCallbackId();
        int b = broker.nextCallbackId();
        int c = broker.nextCallbackId();
        assertTrue(b > a && c > b, "ids must be strictly increasing (got " + a + ", " + b + ", " + c + ")");
    }

    @Test
    void registerReturnsUncompletedFuture() {
        WebAsyncCallbackBroker broker = new WebAsyncCallbackBroker();
        int cbId = broker.nextCallbackId();
        CompletableFuture<Object> f = broker.register(cbId, 100);
        assertFalse(f.isDone(), "future must not resolve until complete() is called");
    }

    @Test
    void completeResolvesTheMatchingFuture() throws Exception {
        WebAsyncCallbackBroker broker = new WebAsyncCallbackBroker();
        int cbId = broker.nextCallbackId();
        CompletableFuture<Object> f = broker.register(cbId, 100);
        broker.complete(cbId, "ok");
        assertEquals("ok", f.get(1, TimeUnit.SECONDS));
    }

    @Test
    void completeWithUnknownIdIsANoOp() {
        WebAsyncCallbackBroker broker = new WebAsyncCallbackBroker();
        // No register — this must not throw.
        assertDoesNotThrow(() -> broker.complete(9999, "irrelevant"));
    }

    @Test
    void completeExceptionallyPropagatesTheThrowable() {
        WebAsyncCallbackBroker broker = new WebAsyncCallbackBroker();
        int cbId = broker.nextCallbackId();
        CompletableFuture<Object> f = broker.register(cbId, 100);
        RuntimeException boom = new RuntimeException("boom");
        broker.completeExceptionally(cbId, boom);
        ExecutionException thrown = assertThrows(ExecutionException.class, () -> f.get(1, TimeUnit.SECONDS));
        assertSame(boom, thrown.getCause());
    }

    @Test
    void cancelAllForControllerFailsPendingFuturesForThatController() {
        WebAsyncCallbackBroker broker = new WebAsyncCallbackBroker();
        int cb1 = broker.nextCallbackId();
        int cb2 = broker.nextCallbackId();
        int cb3 = broker.nextCallbackId();
        CompletableFuture<Object> f1 = broker.register(cb1, /* ctrlId */ 100);
        CompletableFuture<Object> f2 = broker.register(cb2, /* ctrlId */ 100);
        CompletableFuture<Object> f3 = broker.register(cb3, /* ctrlId */ 200);

        broker.cancelAllForController(100);

        assertTrue(f1.isCompletedExceptionally(), "f1 (ctrl 100) must be failed");
        assertTrue(f2.isCompletedExceptionally(), "f2 (ctrl 100) must be failed");
        assertFalse(f3.isDone(), "f3 (ctrl 200) must remain untouched");
    }

    @Test
    void completeAfterCancelAllIsANoOp() {
        WebAsyncCallbackBroker broker = new WebAsyncCallbackBroker();
        int cbId = broker.nextCallbackId();
        broker.register(cbId, 100);
        broker.cancelAllForController(100);
        // The pending entry is gone; a late complete() from the transport must not throw.
        assertDoesNotThrow(() -> broker.complete(cbId, "late"));
    }

    @Test
    void concurrentRegisterFromMultipleThreadsProducesUniqueIds() throws Exception {
        WebAsyncCallbackBroker broker = new WebAsyncCallbackBroker();
        int threads = 16;
        int perThread = 100;
        int[][] ids = new int[threads][perThread];
        Thread[] ts = new Thread[threads];
        for (int t = 0; t < threads; t++) {
            final int tid = t;
            ts[t] = new Thread(() -> {
                for (int i = 0; i < perThread; i++) ids[tid][i] = broker.nextCallbackId();
            });
        }
        for (Thread t : ts) t.start();
        for (Thread t : ts) t.join(5000);
        java.util.Set<Integer> seen = new java.util.HashSet<>();
        for (int[] row : ids) for (int id : row) {
            assertTrue(seen.add(id), "duplicate id " + id);
        }
        assertEquals(threads * perThread, seen.size());
    }
}
