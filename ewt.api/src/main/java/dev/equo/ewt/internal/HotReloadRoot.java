package dev.equo.ewt.internal;

import dev.equo.ewt.BuildContext;
import dev.equo.ewt.State;
import dev.equo.ewt.SubState;
import dev.equo.ewt.SubStatefulWidget;
import dev.equo.ewt.Widget;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Internal wrapper around the user's root widget that enables hot-reload.
 * Instantiated exactly once from App.runApp; not intended for direct use by
 * user code.
 *
 * Whenever Flutter fires reassemble on the tree (for example when the
 * hot-reload signal arrives), this SubStatefulWidget is marked dirty and
 * build() is re-invoked, which calls the current Callable&lt;Widget&gt; again.
 * That Callable instantiates widgets against the bytecode currently loaded
 * in the JVM, so any redefined method bodies take effect on the next frame.
 *
 * <p>The current builder lives in a single JVM-wide {@code AtomicReference}
 * so the native render test harness can swap it per-variant via
 * {@link #setUserBuilder(Callable)} without allocating a new HotReloadRoot
 * instance. Non-test callers (App.runApp) still pass a Callable through the
 * constructor and never call the setter; behavior is unchanged for them.
 */
public final class HotReloadRoot extends SubStatefulWidget {
    private static final AtomicReference<Callable<Widget>> CURRENT = new AtomicReference<>();

    /**
     * Optional test-only hook: when non-null, exceptions thrown by the current
     * builder are handed to this function which must return a fallback Widget.
     * Production callers leave this null and get the default rethrow, so the
     * dev-time hot-reload error stays visible.  The native render test harness
     * sets it to swallow variant-construction failures (broken Immutables
     * required-attribute checks etc.) into a sterile SizedBox, keeping the
     * shared Flutter engine alive across the remaining variants.
     */
    private static volatile java.util.function.Function<Throwable, Widget> ERROR_FALLBACK;

    public HotReloadRoot(Callable<Widget> userBuilder) {
        CURRENT.set(userBuilder);
    }

    /** Swap the current root builder. Next Flutter rebuild picks it up. */
    public static void setUserBuilder(Callable<Widget> next) {
        CURRENT.set(next);
    }

    /** Install an exception-recovery fallback for tests; pass {@code null} to restore rethrow. */
    public static void setErrorFallback(java.util.function.Function<Throwable, Widget> fallback) {
        ERROR_FALLBACK = fallback;
    }

    @Override
    protected State<HotReloadRoot> createState() {
        return new HotReloadRootState();
    }

    static final class HotReloadRootState extends SubState<HotReloadRoot> {
        @Override
        protected Widget build(BuildContext context) {
            try {
                Callable<Widget> b = CURRENT.get();
                if (b == null) throw new IllegalStateException("HotReloadRoot builder was never set");
                return b.call();
            } catch (Throwable e) {
                var fb = ERROR_FALLBACK;
                if (fb != null) return fb.apply(e);
                if (e instanceof RuntimeException re) throw re;
                throw new RuntimeException("EWT hot-reload root builder threw", e);
            }
        }
    }
}
