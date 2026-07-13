package dev.equo.ewt.internal;

import dev.equo.ewt.BuildContext;
import dev.equo.ewt.State;
import dev.equo.ewt.SubState;
import dev.equo.ewt.SubStatefulWidget;
import dev.equo.ewt.Widget;

import java.util.concurrent.Callable;

/**
 * Internal wrapper around the user's root widget that enables hot-reload.
 * Instantiated exactly once from App.runApp; not intended for direct use by
 * user code.
 *
 * Whenever Flutter fires reassemble on the tree (for example when the
 * hot-reload signal arrives), this SubStatefulWidget is marked dirty and
 * build() is re-invoked, which calls the user's Callable<Widget> again. That
 * Callable instantiates widgets against the bytecode currently loaded in the
 * JVM, so any redefined method bodies take effect on the next frame.
 */
public final class HotReloadRoot extends SubStatefulWidget {
    private final Callable<Widget> userBuilder;

    public HotReloadRoot(Callable<Widget> userBuilder) {
        this.userBuilder = userBuilder;
    }

    @Override
    protected State<HotReloadRoot> createState() {
        return new HotReloadRootState(userBuilder);
    }

    static final class HotReloadRootState extends SubState<HotReloadRoot> {
        private final Callable<Widget> userBuilder;

        HotReloadRootState(Callable<Widget> userBuilder) {
            this.userBuilder = userBuilder;
        }

        @Override
        protected Widget build(BuildContext context) {
            try {
                return userBuilder.call();
            } catch (Exception e) {
                throw new RuntimeException("EWT hot-reload root builder threw", e);
            }
        }
    }
}
