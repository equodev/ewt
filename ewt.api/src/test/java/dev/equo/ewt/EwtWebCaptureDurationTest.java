package dev.equo.ewt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EwtWebCaptureDurationTest {

    @Test
    void secondsConvertedToMillis() {
        assertEquals(2_000L, EwtWebCapture.buildDurationMillis(EWT.Duration().seconds(2)));
    }

    @Test
    void millisecondsPassedThrough() {
        assertEquals(500L, EwtWebCapture.buildDurationMillis(EWT.Duration().milliseconds(500)));
    }

    @Test
    void minutesToMillis() {
        assertEquals(60_000L, EwtWebCapture.buildDurationMillis(EWT.Duration().minutes(1)));
    }

    @Test
    void hoursToMillis() {
        assertEquals(3_600_000L, EwtWebCapture.buildDurationMillis(EWT.Duration().hours(1)));
    }

    @Test
    void daysToMillis() {
        assertEquals(86_400_000L, EwtWebCapture.buildDurationMillis(EWT.Duration().days(1)));
    }

    @Test
    void microsecondsUsesIntegerDivision() {
        // 2000 µs / 1000 = 2 ms
        assertEquals(2L, EwtWebCapture.buildDurationMillis(EWT.Duration().microseconds(2000)));
        // 999 µs → 0 ms (integer division truncates)
        assertEquals(0L, EwtWebCapture.buildDurationMillis(EWT.Duration().microseconds(999)));
    }

    @Test
    void combinedComponentsSum() {
        // 1h + 30m + 10s + 500ms = 3 600 000 + 1 800 000 + 10 000 + 500 = 5 410 500
        assertEquals(5_410_500L, EwtWebCapture.buildDurationMillis(
                EWT.Duration().hours(1).minutes(30).seconds(10).milliseconds(500)));
    }

    @Test
    void emptyDurationIsZeroMillis() {
        assertEquals(0L, EwtWebCapture.buildDurationMillis(EWT.Duration()));
    }
}
