package org.eclipse.swt.widgets;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import dev.equo.ewt.App;
import dev.equo.ewt.EwtCapture;
import dev.equo.ewt.EwtWebCapture;
import dev.equo.ewt.EwtWebState;
import dev.equo.ewt.SubAnimatedState;
import dev.equo.ewt.SubState;
import dev.equo.ewt.Widget;
import dev.equo.ewt.evolve.EvolveComm;
import dev.equo.ewt.web.EwtDiff;
import dev.equo.ewt.web.EwtNode;
import dev.equo.ewt.web.EwtPatchJson;
import dev.equo.ewt.web.EwtWebTransport;
import dev.equo.ewt.web.Patch;

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
        addDisposeListener(e -> {
            App.unregisterBuilder(hashCode());
            clearWebState();
            // Reset handler guard so a hypothetical future reuse of this instance doesn't skip registration.
            webHandlersRegistered = false;
        });
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

    private volatile EwtNode lastTree;
    private volatile java.util.Map<Integer, Object> webCallbacks;
    /** Either a SubState<?> or a SubAnimatedState<?>, or null for stateless roots. */
    private volatile Object webState;
    /** SubState/SubAnimatedState instances from nested SubStatefulWidget children; same rebuild hook as root. */
    private volatile java.util.List<Object> webNestedStates = java.util.List.of();
    /** Guards against registering the same EvolveComm handlers more than once across repeated setWidget calls. */
    private boolean webHandlersRegistered = false;

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
            // Buffer initial anim commands (e.g. ctrl.forward() in initState) so they are
            // replayed AFTER the subtree is published. The browser must decode the tree and
            // create AnimationControllers before receiving forward/reverse/etc commands —
            // if commands arrive first, _controllers[id] is null and they are silently dropped.
            List<String> bufferedAnims = new ArrayList<>();
            EwtCapture capture = EwtWebCapture.captureSubtree(builder, bufferedAnims::add);
            webCallbacks = capture.callbacks;
            clearWebState();
            webState = capture.state;
            webNestedStates = capture.nestedStates;
            if (capture.state instanceof SubState<?> ss) {
                EwtWebState.register(ss, this::rebuild);
            } else if (capture.state instanceof SubAnimatedState<?> as) {
                EwtWebState.register(as, this::rebuild);
                as.setWebAnimCommandSink(this::sendAnimCommand);
            }
            for (Object ns : capture.nestedStates) {
                if (ns instanceof SubState<?> ss) EwtWebState.register(ss, this::rebuild);
                else if (ns instanceof SubAnimatedState<?> as) EwtWebState.register(as, this::rebuild);
            }
            if (!webHandlersRegistered) {
                EvolveComm.onEvent(getImpl(), EwtWebTransport.requestEvent(hashCode()), this::sendFull);
                EvolveComm.onPayload(getImpl(), EwtWebTransport.callbackEvent(hashCode()), this::fireCallback);
                EvolveComm.onPayload(getImpl(), EwtWebTransport.animEvent(hashCode()), this::handleAnimCommand);
                webHandlersRegistered = true;
            }
            lastTree = capture.root;
            publish(EwtPatchJson.encodeFull(capture.root));
            // Replay initial anim commands after publishing the subtree: the browser will
            // decode the tree (creating AnimationControllers) before these arrive.
            for (String cmd : bufferedAnims) sendAnimCommand(cmd);
        } catch (Exception e) {
            System.out.println("EWT web subtree publish failed: " + e);
            e.printStackTrace();
            // Reset to clean state so the next rebuild does a fresh capture rather than
            // diffing against a partially-constructed baseline.
            lastTree = null;
            webCallbacks = null;
        }
    }

    /** Unregisters the current web state (root + nested) from EwtWebState and clears anim sinks. */
    private void clearWebState() {
        Object prev = webState;
        if (prev instanceof SubState<?> ss) EwtWebState.unregister(ss);
        else if (prev instanceof SubAnimatedState<?> as) {
            EwtWebState.unregister(as);
            as.setWebAnimCommandSink(null);
        }
        webState = null;
        for (Object ns : webNestedStates) {
            if (ns instanceof SubState<?> ss) EwtWebState.unregister(ss);
            else if (ns instanceof SubAnimatedState<?> as) EwtWebState.unregister(as);
        }
        webNestedStates = java.util.List.of();
    }

    /** Web-mode rebuild: re-flatten the retained state, refresh callbacks, publish a diff (or a full
     *  snapshot on a structural change / first frame). */
    private void rebuild() {
        Object s = webState;
        if (s == null) return;
        try {
            EwtCapture capture;
            if (s instanceof SubState<?> ss) {
                capture = EwtWebCapture.rebuild(ss);
            } else if (s instanceof SubAnimatedState<?> as) {
                capture = EwtWebCapture.rebuildAnimated(as);
            } else return;
            webCallbacks = capture.callbacks;
            for (Object ns : webNestedStates) {
                if (ns instanceof SubState<?> ss) EwtWebState.unregister(ss);
                else if (ns instanceof SubAnimatedState<?> as) EwtWebState.unregister(as);
            }
            webNestedStates = capture.nestedStates;
            for (Object ns : webNestedStates) {
                if (ns instanceof SubState<?> ss) EwtWebState.register(ss, this::rebuild);
                else if (ns instanceof SubAnimatedState<?> as) EwtWebState.register(as, this::rebuild);
            }
            EwtNode prev = lastTree;
            lastTree = capture.root;
            String json = encodeUpdate(prev, capture.root);
            if (json != null) publish(json);
        } catch (Exception e) {
            System.out.println("EWT web rebuild failed: " + e);
            e.printStackTrace();
            lastTree = null;
            webCallbacks = null;
        }
    }

    /** Decide what to publish for a rebuild: full on first frame / structural change, a patch for a
     *  value-only change, or null (nothing) when nothing changed. Static + SWT-free for unit testing. */
    static String encodeUpdate(EwtNode prev, EwtNode next) {
        if (prev == null) return EwtPatchJson.encodeFull(next);
        Patch patch = EwtDiff.diff(prev, next);
        if (patch.structural()) return EwtPatchJson.encodeFull(next);
        if (patch.ops().isEmpty()) return null;
        return EwtPatchJson.encodePatch(patch);
    }

    /** The /request handler: the browser (re)subscribed, so resend a full snapshot of current state. */
    private void sendFull() {
        if (isDisposed()) return;
        EwtNode tree = lastTree;
        if (tree != null) publish(EwtPatchJson.encodeFull(tree));
    }

    private void publish(String json) {
        EwtWebTransport.publish(hashCode(), json,
            (event, payload) -> EvolveComm.send(getImpl(), event, payload));
    }

    /** Forwards an animation command JSON string to the browser via the anim channel. */
    private void sendAnimCommand(String json) {
        EwtWebTransport.publishAnim(hashCode(), json,
            (event, payload) -> EvolveComm.send(getImpl(), event, payload));
    }

    /**
     * The /anim handler: the browser should never send on this channel (it's Java→browser only),
     * but the registration is a no-op guard against mis-wiring.
     */
    private void handleAnimCommand(Object payload) {
        // Java→browser only; no-op on the receive side.
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
        if (isDisposed()) return;
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
