package org.eclipse.swt.widgets;

import java.util.concurrent.Callable;

import dev.equo.ewt.App;
import dev.equo.ewt.EwtCapture;
import dev.equo.ewt.EwtWebCapture;
import dev.equo.ewt.EwtWebState;
import dev.equo.ewt.SubState;
import dev.equo.ewt.Widget;
import dev.equo.ewt.evolve.EvolveComm;
import dev.equo.ewt.web.EwtNodeJson;
import dev.equo.ewt.web.EwtWebTransport;

/**
 * Public SWT-Evolve widget that hosts an EWT (Flutter) subtree in the SAME surface.
 *
 * Lives on the EWT side (depends on Evolve's {@link Composite} + EWT's {@link App}):
 * dependency direction EWT -> Evolve. It is a split-package class in
 * {@code org.eclipse.swt.widgets} so it can subclass Evolve's {@code Composite}.
 *
 * Ships in the self-contained EWT↔Evolve integration jar ({@code dev.equo:ewt-evolve})
 * alongside the SPI provider and the combined bundle, so an integrator consumes it as a
 * plain library class.
 *
 * Wiring: because this class is named "EwtWidget", Evolve's
 * {@code Config.getCompositeImpl} routes it to {@code DartEwtWidget}, which
 * serializes as an "EwtWidget" node. On the Dart side that node calls the
 * {@code ewtRegionBuilder} hook, which the EWT glue fills with a call to
 * {@code callToBuildWidgetTree}. {@link #setWidget} registers the Java builder that
 * {@code callToBuildWidgetTree} ultimately invokes (via {@code App.registerBuilder}).
 */
public class EwtWidget extends Composite {

    public EwtWidget(Composite parent, int style) {
        super(parent, style);
        // Drop this region's builder when the widget goes away, so a disposed region
        // leaves no stale entry in App's builder registry (keyed by this same id).
        addDisposeListener(e -> { App.unregisterBuilder(hashCode()); if (webState != null) EwtWebState.unregister(webState); });
    }

    /**
     * Registers the EWT widget builder (via FFM) that fills this region.
     *
     * Keyed by this widget's id so multiple EwtWidget regions coexist without
     * overwriting each other. The key must equal the Dart region's {@code value.id};
     * Evolve serializes that id as {@code getApi().hashCode()}, and this EwtWidget IS
     * the api Composite, so {@code hashCode()} is exactly that id.
     */
    public void setWidget(Callable<Widget> builder) {
        if (EwtWebTransport.isWebMode()) {
            publishWebSubtree(builder);
        } else {
            App.registerBuilder(hashCode(), builder);
        }
    }

    private volatile String webSubtreeJson;
    private volatile java.util.Map<Integer, Object> webCallbacks;
    private volatile SubState<?> webState;

    /**
     * Web path: build the subtree eagerly, serialize it, and publish it over Evolve's comm keyed
     * by this region's id. Desktop keeps using FFM via App's dispatcher (the branch above). The
     * FFM/native path is deliberately not touched here, since no native engine runs on web.
     *
     * The subtree is also resent on request: the browser region asks for it once its handler is
     * registered, so a first frame flushed (from the comm buffer) before the region subscribed is
     * not lost.
     */
    private void publishWebSubtree(Callable<Widget> builder) {
        try {
            EwtCapture capture = EwtWebCapture.captureSubtree(builder);
            webSubtreeJson = EwtNodeJson.encode(capture.root);
            webCallbacks = capture.callbacks;
            if (webState != null) EwtWebState.unregister(webState);
            webState = capture.state;
            if (webState != null) EwtWebState.register(webState, this::rebuild);
            EvolveComm.onEvent(getImpl(), EwtWebTransport.requestEvent(hashCode()), this::sendWebSubtree);
            EvolveComm.onPayload(getImpl(), EwtWebTransport.callbackEvent(hashCode()), this::fireCallback);
            sendWebSubtree();
        } catch (Exception e) {
            System.err.println("EWT web subtree publish failed: " + e);
        }
    }

    /** Web-mode rebuild: re-flatten the retained state (new field values), refresh callbacks, republish. */
    private void rebuild() {
        SubState<?> s = webState;
        if (s == null) return;
        try {
            EwtCapture capture = EwtWebCapture.rebuild(s);
            webSubtreeJson = EwtNodeJson.encode(capture.root);
            webCallbacks = capture.callbacks;
            sendWebSubtree();
        } catch (Exception e) {
            System.err.println("EWT web rebuild failed: " + e);
        }
    }

    private void sendWebSubtree() {
        String json = webSubtreeJson;
        if (json == null) return;
        EwtWebTransport.publish(hashCode(), json,
            (event, payload) -> EvolveComm.send(getImpl(), event, payload));
    }

    /** Resolves a callback payload (a JSON array [id] or [id, arg]) to the work to run, or null
     *  (unknown/stale id, wrong shape, non-list payload). Static so it can be tested without a live
     *  Display or parent Composite. Zero-arg -> the stored Runnable; value -> a Runnable that calls
     *  the stored Consumer with the arg. */
    @SuppressWarnings("unchecked")
    static Runnable resolveCallback(java.util.Map<Integer, Object> cbs, Object payload) {
        if (cbs == null || !(payload instanceof java.util.List<?> list) || list.isEmpty()) return null;
        if (!(list.get(0) instanceof Number n)) return null;
        Object cb = cbs.get(n.intValue());
        if (list.size() == 1) {
            return cb instanceof Runnable ? (Runnable) cb : null;
        }
        if (cb instanceof java.util.function.Consumer) {
            Object arg = list.get(1);
            return () -> ((java.util.function.Consumer<Object>) cb).accept(arg);
        }
        return null;
    }

    private void fireCallback(Object payload) {
        Runnable r = resolveCallback(webCallbacks, payload);
        if (r != null) getDisplay().asyncExec(r);
    }

    /**
     * Declares the region's natural size for SWT layout. An EWT region hosts a Flutter
     * subtree whose size is not knowable in Java, so without this a plain composite
     * collapses to the default 64x64. Either dimension may be {@code SWT.DEFAULT}.
     */
    public void setPreferredSize(int width, int height) {
        ((DartEwtWidget) getImpl()).setPreferredSize(width, height);
    }
}
