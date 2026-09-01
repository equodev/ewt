package dev.equo.ewt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FlutterErrorCollectorTest {

    @Test
    void errorsBetween_returnsWindow() {
        var c = new FlutterErrorCollector();
        c.onError(new FlutterErrorRecord(1, "K", "M", "S"));
        c.onError(new FlutterErrorRecord(2, "K", "M", "S"));
        c.onError(new FlutterErrorRecord(3, "K", "M", "S"));
        var got = c.errorsBetween(1, 3);
        assertEquals(2, got.size()); // frames 2 and 3 — exclusive lower bound
    }

    @Test
    void errorsBetween_emptyWhenNoErrors() {
        var c = new FlutterErrorCollector();
        assertTrue(c.errorsBetween(0, 100).isEmpty());
    }

    @Test
    void errorsBetween_exclusiveLowerBound() {
        var c = new FlutterErrorCollector();
        c.onError(new FlutterErrorRecord(5, "K", "M", "S"));
        // pre=5 is the lower boundary — frame 5 itself must NOT be included
        var got = c.errorsBetween(5, 10);
        assertTrue(got.isEmpty());
    }

    @Test
    void errorsBetween_inclusiveUpperBound() {
        var c = new FlutterErrorCollector();
        c.onError(new FlutterErrorRecord(7, "K", "M", "S"));
        // post=7 is the upper boundary — frame 7 must be included
        var got = c.errorsBetween(5, 7);
        assertEquals(1, got.size());
        assertEquals(7, got.get(0).frameId());
    }
}
