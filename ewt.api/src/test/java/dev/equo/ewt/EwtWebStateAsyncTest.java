package dev.equo.ewt;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class EwtWebStateAsyncTest {

    @Test
    void sendAsyncAnimCommandEmitsJsonWithCallbackIdAndArgs() {
        AtomicReference<String> received = new AtomicReference<>();
        EwtWebState.registerAnimSink(50, received::set);
        try {
            int cbId = EwtWebState.nextAsyncCallbackId();
            CompletableFuture<Object> future = EwtWebState.registerAsyncCallback(cbId, 50);
            EwtWebState.sendAsyncAnimCommand(50, "animateTo", cbId, java.util.List.of(0.5, 300, "linear"));

            assertFalse(future.isDone());
            assertNotNull(received.get(), "sink must receive the command");
            assertTrue(received.get().contains("\"ctrlId\":50"), "must carry ctrlId; got " + received.get());
            assertTrue(received.get().contains("\"action\":\"animateTo\""), "must carry action; got " + received.get());
            assertTrue(received.get().contains("\"callbackId\":" + cbId), "must carry callbackId; got " + received.get());
            assertTrue(received.get().contains("\"args\""), "must carry args key; got " + received.get());
        } finally {
            EwtWebState.unregisterAnimSinks(Set.of(50));
        }
    }

    @Test
    void completeAsyncCallbackResolvesTheFuture() throws Exception {
        int cbId = EwtWebState.nextAsyncCallbackId();
        CompletableFuture<Object> future = EwtWebState.registerAsyncCallback(cbId, 60);
        EwtWebState.completeAsyncCallback(cbId, "done");
        assertEquals("done", future.get(1, TimeUnit.SECONDS));
    }

    @Test
    void unregisterAnimSinksFailsPendingAsyncCallbacksForThoseControllers() {
        int cb1 = EwtWebState.nextAsyncCallbackId();
        int cb2 = EwtWebState.nextAsyncCallbackId();
        CompletableFuture<Object> f1 = EwtWebState.registerAsyncCallback(cb1, 70);
        CompletableFuture<Object> f2 = EwtWebState.registerAsyncCallback(cb2, 71);

        EwtWebState.registerAnimSink(70, s -> {});
        EwtWebState.registerAnimSink(71, s -> {});
        EwtWebState.unregisterAnimSinks(Set.of(70));

        assertTrue(f1.isCompletedExceptionally(), "controller 70's future must fail on unregister");
        assertFalse(f2.isDone(), "controller 71 must be untouched");

        // Cleanup
        EwtWebState.unregisterAnimSinks(Set.of(71));
    }

    @Test
    void asyncCallbackIdsAreUniqueAcrossCalls() {
        int a = EwtWebState.nextAsyncCallbackId();
        int b = EwtWebState.nextAsyncCallbackId();
        int c = EwtWebState.nextAsyncCallbackId();
        assertTrue(a < b && b < c, "ids strictly increasing (got " + a + "," + b + "," + c + ")");
    }

    @Test
    void sendAsyncAnimCommandToUnknownSinkDoesNotThrow() {
        int cbId = EwtWebState.nextAsyncCallbackId();
        EwtWebState.registerAsyncCallback(cbId, 9999);
        assertDoesNotThrow(() ->
            EwtWebState.sendAsyncAnimCommand(9999, "forward", cbId, java.util.List.of()));
    }
}
