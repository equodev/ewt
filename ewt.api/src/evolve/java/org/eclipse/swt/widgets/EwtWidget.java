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
import dev.equo.ewt.web.EwtTrace;
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
            // App (FFM) is only touched on the desktop FFM path. On the comm path (web, or desktop
            // on a JVM < 22) no native builder was registered, and App lives under META-INF/versions/22,
            // so loading it on a pre-22 JVM would fail. Mirror setWidget's transport guard.
            if (!EwtWebTransport.isWebMode()) {
                App.unregisterBuilder(hashCode());
            }
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
        boolean comm = EwtWebTransport.isWebMode();
        // Tell the native Dart region which transport to render with: comm (java<22 / web) publishes
        // the subtree, FFM (java>=22 desktop) registers a native builder. The desktop engine's region
        // defaults to comm; this signal flips it to the FFM region when needed. Sent over the comm
        // Evolve already runs on desktop (the Java<->engine channel).
        announceTransport(comm);
        if (comm) {
            publishWebSubtree(builder);
        } else {
            App.registerBuilder(hashCode(), builder);
            // The Dart region retains what it built and only rebuilds when told: a new builder is
            // the one FFM-side change it cannot see on its own. Sent after the registration so
            // the rebuild it triggers runs the new builder.
            EvolveComm.send(getImpl(), EwtWebTransport.rebuildEvent(hashCode()), null);
        }
    }

    /** Whether this region has registered the transport-resend handler yet. */
    private boolean transportHandlerRegistered = false;

    /** Publishes the render transport for this region and (once) answers resend requests from the
     *  Dart region — which may subscribe after the first announcement was flushed. */
    private void announceTransport(boolean comm) {
        byte[] value = (comm ? "comm" : "ffm").getBytes(java.nio.charset.StandardCharsets.UTF_8);
        if (!transportHandlerRegistered) {
            EvolveComm.onEvent(getImpl(), EwtWebTransport.transportRequestEvent(hashCode()),
                () -> EvolveComm.send(getImpl(), EwtWebTransport.transportEvent(hashCode()), value));
            transportHandlerRegistered = true;
        }
        EvolveComm.send(getImpl(), EwtWebTransport.transportEvent(hashCode()), value);
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
     * A region that already published goes out as a diff against what the browser holds, the
     * same as a rebuild: an app that re-sends its whole page through {@code setWidget} on every
     * state change pays for what changed, not for the page.
     *
     * The subtree is also resent on request: the browser region asks for it once its handler is
     * registered, so a first frame flushed (from the comm buffer) before the region subscribed is
     * not lost.
     */
    private void publishWebSubtree(Callable<Widget> builder) {
        // Whatever rebuild was queued is for the state this replaces.
        rebuildQueued.set(false);
        try {
            // Buffer initial anim commands (e.g. ctrl.forward() in initState) so they are
            // replayed AFTER the subtree is published. The browser must decode the tree and
            // create AnimationControllers before receiving forward/reverse/etc commands —
            // if commands arrive first, _controllers[id] is null and they are silently dropped.
            List<String> bufferedAnims = new ArrayList<>();
            long captureStart = System.nanoTime();
            EwtCapture capture = EwtWebCapture.captureSubtree(builder, bufferedAnims::add);
            long captureNanos = System.nanoTime() - captureStart;
            webCallbacks = capture.callbacks;
            clearWebState();
            webState = capture.state;
            webNestedStates = capture.nestedStates;
            if (capture.state instanceof SubState<?>) {
                EwtWebState.register((SubState<?>) capture.state, this::rebuild);
            } else if (capture.state instanceof SubAnimatedState<?>) {
                SubAnimatedState<?> as = (SubAnimatedState<?>) capture.state;
                EwtWebState.register(as, this::rebuild);
                as.setWebAnimCommandSink(this::sendAnimCommand);
            }
            for (Object ns : capture.nestedStates) {
                if (ns instanceof SubState<?>) EwtWebState.register((SubState<?>) ns, this::rebuild);
                else if (ns instanceof SubAnimatedState<?>) {
                    SubAnimatedState<?> nas = (SubAnimatedState<?>) ns;
                    EwtWebState.register(nas, this::rebuild);
                    // Replace the buffering sink used during capture with the real one, so commands
                    // issued after this first publish reach the browser. initState commands were
                    // buffered into bufferedAnims and are replayed below through this same sink.
                    nas.setWebAnimCommandSink(this::sendAnimCommand);
                }
            }
            if (!webHandlersRegistered) {
                EvolveComm.onEvent(getImpl(), EwtWebTransport.requestEvent(hashCode()), this::sendFull);
                EvolveComm.onPayload(getImpl(), EwtWebTransport.callbackEvent(hashCode()), this::fireCallback);
                EvolveComm.onPayload(getImpl(), EwtWebTransport.animEvent(hashCode()), this::handleAnimCommand);
                webHandlersRegistered = true;
            }
            EwtNode prev = lastTree;
            lastTree = capture.root;
            long encodeStart = System.nanoTime();
            String json = encodeUpdate(prev, capture.root);
            long encodeNanos = System.nanoTime() - encodeStart;
            if (json != null) publish(json);
            if (EwtTrace.ENABLED) EwtTrace.log(EwtTrace.publishLine(hashCode(), "setWidget", prev, capture.root, json, captureNanos, encodeNanos));
            // Replay initial anim commands after publishing the subtree: the browser will
            // decode the tree (creating AnimationControllers) before these arrive.
            for (String cmd : bufferedAnims) sendAnimCommand(cmd);
            replayAnimsHeldForRebuild();
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
        if (prev instanceof SubState<?>) EwtWebState.unregister((SubState<?>) prev);
        else if (prev instanceof SubAnimatedState<?>) {
            SubAnimatedState<?> as = (SubAnimatedState<?>) prev;
            EwtWebState.unregister(as);
            as.setWebAnimCommandSink(null);
            as.clearWebStatusListeners();
        }
        webState = null;
        for (Object ns : webNestedStates) {
            if (ns instanceof SubState<?>) EwtWebState.unregister((SubState<?>) ns);
            else if (ns instanceof SubAnimatedState<?>) {
                SubAnimatedState<?> nas = (SubAnimatedState<?>) ns;
                EwtWebState.unregister(nas);
                nas.clearWebStatusListeners();
            }
        }
        webNestedStates = java.util.List.of();
    }

    /** Set while a rebuild is queued on the display thread and not yet run. */
    private final java.util.concurrent.atomic.AtomicBoolean rebuildQueued =
        new java.util.concurrent.atomic.AtomicBoolean();
    /** Anim commands issued while a rebuild is queued; sent once the tree they may refer to is. */
    private final List<String> animsHeldForRebuild = new ArrayList<>();

    /**
     * Web-mode rebuild hook, run by {@code setState}. The capture is deferred to the next turn of
     * the display thread and every {@code setState} until then folds into it, so a handler that
     * touches several states — or one state several times — re-flattens and publishes once, the
     * way Flutter coalesces its own setState calls into one frame.
     */
    private void rebuild() {
        if (webState == null || isDisposed()) return;
        if (!rebuildQueued.compareAndSet(false, true)) return;
        getDisplay().asyncExec(() -> {
            // A setWidget in between published fresh and cleared the flag: nothing left to do.
            if (!rebuildQueued.getAndSet(false) || isDisposed()) return;
            rebuildNow();
            replayAnimsHeldForRebuild();
        });
    }

    private void replayAnimsHeldForRebuild() {
        List<String> held;
        synchronized (animsHeldForRebuild) {
            if (animsHeldForRebuild.isEmpty()) return;
            held = new ArrayList<>(animsHeldForRebuild);
            animsHeldForRebuild.clear();
        }
        for (String cmd : held) sendAnimCommand(cmd);
    }

    /** Re-flatten the retained state, refresh callbacks, publish a diff (or a full snapshot on a
     *  structural change / first frame). */
    private void rebuildNow() {
        Object s = webState;
        if (s == null) return;
        try {
            EwtCapture capture;
            long captureStart = System.nanoTime();
            if (s instanceof SubState<?>) {
                capture = EwtWebCapture.rebuild((SubState<?>) s);
            } else if (s instanceof SubAnimatedState<?>) {
                capture = EwtWebCapture.rebuildAnimated((SubAnimatedState<?>) s);
            } else return;
            long captureNanos = System.nanoTime() - captureStart;
            webCallbacks = capture.callbacks;
            for (Object ns : webNestedStates) {
                if (ns instanceof SubState<?>) EwtWebState.unregister((SubState<?>) ns);
                else if (ns instanceof SubAnimatedState<?>) EwtWebState.unregister((SubAnimatedState<?>) ns);
            }
            webNestedStates = capture.nestedStates;
            for (Object ns : webNestedStates) {
                if (ns instanceof SubState<?>) EwtWebState.register((SubState<?>) ns, this::rebuild);
                else if (ns instanceof SubAnimatedState<?>) {
                    SubAnimatedState<?> nas = (SubAnimatedState<?>) ns;
                    EwtWebState.register(nas, this::rebuild);
                    nas.setWebAnimCommandSink(this::sendAnimCommand);
                }
            }
            EwtNode prev = lastTree;
            lastTree = capture.root;
            long encodeStart = System.nanoTime();
            String json = encodeUpdate(prev, capture.root);
            long encodeNanos = System.nanoTime() - encodeStart;
            if (json != null) publish(json);
            if (EwtTrace.ENABLED) EwtTrace.log(EwtTrace.publishLine(hashCode(), "setState", prev, capture.root, json, captureNanos, encodeNanos));
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
        if (patch.isEmpty()) return null;
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

    /** Forwards an animation command JSON string to the browser via the anim channel. While a
     *  rebuild is queued it is held instead: the controller it names may only exist in the tree
     *  that rebuild publishes, and a command reaching the browser first is dropped there. */
    private void sendAnimCommand(String json) {
        if (rebuildQueued.get()) {
            synchronized (animsHeldForRebuild) {
                if (rebuildQueued.get()) {
                    animsHeldForRebuild.add(json);
                    return;
                }
            }
        }
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
        if (cbs == null || !(payload instanceof java.util.List<?>)) return null;
        java.util.List<?> list = (java.util.List<?>) payload;
        if (list.isEmpty() || !(list.get(0) instanceof Number)) return null;
        Object cb = cbs.get(((Number) list.get(0)).intValue());
        if (list.size() == 1) {
            return cb instanceof Runnable ? (Runnable) cb : null;
        }
        if (cb instanceof java.util.function.Consumer) {
            Object arg = list.get(1);
            return () -> ((java.util.function.Consumer<Object>) cb).accept(arg);
        }
        return null;
    }

    /** Resolves a status-listener payload ([negative id, statusOrdinal]) to the work that fires the
     *  registered AnimationStatus sink, or null if the payload isn't a status event. Static + SWT-free
     *  for unit testing. Status events are repeatable (every status change), unlike the one-shot
     *  async broker, and their ids are negative so they can't mask a UI or async callback id. */
    static Runnable resolveStatusListener(Object payload) {
        if (!(payload instanceof java.util.List<?>)) return null;
        java.util.List<?> list = (java.util.List<?>) payload;
        if (list.size() < 2 || !(list.get(0) instanceof Number) || !(list.get(1) instanceof Number)) return null;
        int id = ((Number) list.get(0)).intValue();
        if (!dev.equo.ewt.EwtWebState.isStatusListenerId(id)) return null;
        int ordinal = ((Number) list.get(1)).intValue();
        return () -> dev.equo.ewt.EwtWebState.fireStatusListener(id, ordinal);
    }

    private void fireCallback(Object payload) {
        if (isDisposed()) return;
        Runnable r = resolveCallback(webCallbacks, payload);
        if (r != null) {
            getDisplay().asyncExec(r);
            return;
        }
        // Status-listener events (negative id) fire a registered AnimationStatus sink repeatedly;
        // run on the Display thread like a UI callback.
        Runnable s = resolveStatusListener(payload);
        if (s != null) {
            getDisplay().asyncExec(s);
            return;
        }
        // Fall through to the async-callback broker (Future-returning method
        // completions from AnimationController etc.). Async ids come from a
        // disjoint range (>= WebAsyncCallbackBroker.ASYNC_CALLBACK_ID_BASE) so
        // they cannot mask a UI callback id. Runs immediately on the transport
        // thread — CompletableFuture handlers are not required to be on the
        // Display thread, and any UI work in them will re-post via asyncExec.
        tryCompleteAsyncCallback(payload);
    }

    private static void tryCompleteAsyncCallback(Object payload) {
        if (!(payload instanceof java.util.List<?>)) return;
        java.util.List<?> list = (java.util.List<?>) payload;
        if (list.isEmpty()) return;
        Object firstArg = list.get(0);
        if (!(firstArg instanceof Number)) return;
        int cbId = ((Number) firstArg).intValue();
        if (cbId < dev.equo.ewt.web.WebAsyncCallbackBroker.ASYNC_CALLBACK_ID_BASE) return;
        Object value = list.size() > 1 ? list.get(1) : null;
        dev.equo.ewt.EwtWebState.completeAsyncCallback(cbId, value);
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
