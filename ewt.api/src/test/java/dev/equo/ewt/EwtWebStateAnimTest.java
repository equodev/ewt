package dev.equo.ewt;

import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import static org.junit.jupiter.api.Assertions.*;

class EwtWebStateAnimTest {

    @Test
    void sendAnimCommandDeliversJsonToRegisteredSink() {
        AtomicReference<String> received = new AtomicReference<>();
        EwtWebState.registerAnimSink(42, received::set);
        try {
            EwtWebState.sendAnimCommand(42, "forward");
            assertEquals("{\"ctrlId\":42,\"action\":\"forward\"}", received.get());
        } finally {
            EwtWebState.unregisterAnimSinks(Set.of(42));
        }
    }

    @Test
    void unregisterAnimSinksRemovesSink() {
        AtomicReference<String> received = new AtomicReference<>();
        EwtWebState.registerAnimSink(10, received::set);
        EwtWebState.unregisterAnimSinks(Set.of(10));
        EwtWebState.sendAnimCommand(10, "reverse");
        assertNull(received.get(), "no delivery after unregister");
    }

    @Test
    void sendAnimCommandToUnknownIdDoesNotThrow() {
        assertDoesNotThrow(() -> EwtWebState.sendAnimCommand(9999, "forward"));
    }

    @Test
    void unregisterMultipleSinksAtOnce() {
        AtomicReference<String> r1 = new AtomicReference<>();
        AtomicReference<String> r2 = new AtomicReference<>();
        EwtWebState.registerAnimSink(20, r1::set);
        EwtWebState.registerAnimSink(21, r2::set);
        EwtWebState.unregisterAnimSinks(Set.of(20, 21));
        EwtWebState.sendAnimCommand(20, "forward");
        EwtWebState.sendAnimCommand(21, "reverse");
        assertNull(r1.get());
        assertNull(r2.get());
    }
}
