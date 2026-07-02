package org.eclipse.swt.widgets;

import java.util.concurrent.Callable;

import dev.equo.ewt.App;
import dev.equo.ewt.Widget;

/**
 * Public SWT-Evolve widget that hosts an EWT (Flutter) subtree in the SAME surface.
 *
 * Lives on the EWT side (depends on Evolve's {@link Composite} + EWT's {@link App}):
 * dependency direction EWT -> Evolve. It is a split-package class in
 * {@code org.eclipse.swt.widgets} so it can subclass Evolve's {@code Composite}.
 *
 * Wiring: because this class is named "EwtWidget", Evolve's
 * {@code Config.getCompositeImpl} routes it to {@code DartEwtWidget}, which
 * serializes as an "EwtWidget" node. On the Dart side that node calls the
 * {@code ewtRegionBuilder} hook, which the EWT glue fills with a call to
 * {@code callToBuildWidgetTree}. {@link #setWidget} registers the Java builder that
 * {@code callToBuildWidgetTree} ultimately invokes (via {@code App.registerBuilder}).
 *
 * NOTE: does not build until the examples module depends on Evolve (swt_native) and
 * the combined EWT-root build is set up (spec §10 / Decision Log 2026-07-01, paso 4).
 */
public class EwtWidget extends Composite {

    public EwtWidget(Composite parent, int style) {
        super(parent, style);
    }

    /** Registers the EWT widget builder (via FFM) that fills this region. */
    public void setWidget(Callable<Widget> builder) {
        App.registerBuilder(builder);
    }
}
