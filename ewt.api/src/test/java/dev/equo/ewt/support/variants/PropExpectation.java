package dev.equo.ewt.support.variants;

import java.util.Objects;

/**
 * A single per-getter expectation used by {@code GetterRoundTrip} after a variant is mounted.
 *
 * <p>Two flavors:
 * <ul>
 *   <li>{@link #equalTo(String, Object)} — the getter must return a value equal to {@code expected}
 *       (used for primitives, strings, enums where equality is meaningful).</li>
 *   <li>{@link #notNull(String)} — the getter must merely return non-null (used for complex
 *       types like {@code TextStyle} where deep equality is impractical).</li>
 * </ul>
 */
public record PropExpectation(String name, Object expected, boolean checkEquality) {

    public static PropExpectation equalTo(String name, Object expected) {
        return new PropExpectation(name, expected, true);
    }

    public static PropExpectation notNull(String name) {
        return new PropExpectation(name, null, false);
    }

    /** Throws {@link AssertionError} if [actual] does not satisfy this expectation. */
    public void check(Object actual) {
        if (!checkEquality) {
            if (actual == null) {
                throw new AssertionError(name + " getter returned null");
            }
            return;
        }
        if (!Objects.equals(expected, actual)) {
            throw new AssertionError(name + " expected=" + expected + " actual=" + actual);
        }
    }
}
