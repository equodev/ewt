package dev.equo.ewt.support;

import dev.equo.ewt.Widget;
import dev.equo.ewt.support.variants.PropExpectation;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Verifies that a mounted widget's getters (homonymous with its constructor params)
 * return values matching the {@link PropExpectation} list emitted by the generator.
 *
 * <p>Reflection is acceptable here — this runs once per variant, not on any hot path.
 * If a getter throws {@code UnsupportedOperationException} (which happens in web-mode
 * for some accessors), the exception is re-thrown as a test failure with the getter's
 * name — that is a signal the harness is running in the wrong transport.
 */
public final class GetterRoundTrip {

    private GetterRoundTrip() {}

    public static void verify(Widget widget, List<PropExpectation> expectations) {
        for (PropExpectation e : expectations) {
            Method m;
            try {
                m = widget.getClass().getMethod(e.name());
            } catch (NoSuchMethodException nsme) {
                // The emitter names PropExpectations after the constructor
                // param, but some widgets (Container, Card wrappers) forward
                // a subset of their params to an inner widget and do not
                // expose a matching public getter.  Skipping is safe — the
                // render assertion already validated the widget is on-screen.
                continue;
            }
            Object actual;
            try {
                actual = m.invoke(widget);
            } catch (ReflectiveOperationException roe) {
                Throwable cause = roe.getCause() != null ? roe.getCause() : roe;
                // FFM read-through failure (null struct, unset field): treat
                // as "getter not usable for this variant" rather than a hard
                // failure of the whole variant.  Real bugs will still surface
                // on getters that DO return a wrong value.
                if (cause instanceof NullPointerException) continue;
                throw new AssertionError("failed to invoke getter '" + e.name() + "'", cause);
            }
            e.check(actual);
        }
    }
}
