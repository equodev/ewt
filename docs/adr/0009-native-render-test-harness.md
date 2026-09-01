# Shared-engine harness for native widget rendering tests

Every EWT widget is exercised today only through a JSON serialization round-trip (`WidgetBuilderSerializationTest`), which catches builder-shape regressions but never verifies that Flutter actually renders the widget. This ADR adds a `@Tag("native")` opt-in suite that boots one Flutter engine per JVM under xvfb, drives every widget × variant through it via the existing `HotReloadRoot` swap path, and asserts on a snapshot of the resulting element/render tree — extending the code generator to emit the per-widget variant catalog into the test source tree so `mountableWidgets()` stops being hand-maintained.

- **Status**: accepted
- **Date**: 2026-08-26
- **Deciders**: mateorodon, Equo EWT team

## Considered Options

| Option | Outcome |
|--------|---------|
| One Flutter process per test (fork-per-widget) | Rejected — breaks the "sub-linear in widget count" budget; 1000+ variants × process boot ≫ 10min. |
| Shared engine, poll from Java with `Thread.sleep(16)` for post-frame | Rejected — flakes under CI load; can't correlate a frame to the variant that produced it. |
| Reflection over Immutables `*Builder` classes at test-time to infer variants (option B in the design discussion) | Rejected — re-invents optionality / default detection that the generator already resolves via the Dart analyzer, and hardcodes sample values twice (Java-side registry + Dart-side widget defaults drift apart). |
| Hand-maintain `mountableWidgets() × N variants` in `WidgetBuilderCatalog` | Rejected — ~1000 entries hand-maintained, unmaintainable and immediately stale on any widget change. |
| Emit variant metadata under `dev.equo.ewt.variants` in `src/main/java` | Rejected — pollutes EWT's public API surface with test-only classes. Emitter output goes to `src/test/java`. |
| Positional `startApp(buildFn, postFrameFn, errorFn)` C signature | Rejected — future hooks would keep breaking the ABI. Chose `startApp(const StarterOpts* opts)` with nullable pointer fields. |
| Golden-image / pixel-diff assertions | Deferred — out of scope for this ADR. Assertion here is "element is in tree, RenderBox size > 0, no captured FlutterError." |
| Preemptive shard into 2-3 parallel CI jobs | Deferred — added the shard hook (env-driven `EWT_SHARD_INDEX` / `EWT_SHARD_COUNT`) but ship with `COUNT=1`. Activate only if measured runtime exceeds ~8min of the 10min budget. |

## Consequences

### New C exports (`widgets/example/native/Starter.h/c`)

```c
typedef void (*postFrameFn)(long frameId, const char* snapshotUtf8, int snapshotLen);
typedef void (*flutterErrorFn)(long frameId, const char* kind, const char* message, const char* stack);

typedef struct StarterOpts {
    buildWidgetTreeFn buildWidgetTree;   // required
    postFrameFn       onPostFrame;        // nullable
    flutterErrorFn    onFlutterError;     // nullable
} StarterOpts;

int  startApp(const StarterOpts* opts);   // BREAKING change to existing signature
void Starter_requestRebuild(void);         // NEW — posts a job to the GTK loop
void Starter_requestShutdown(void);        // NEW — signals clean g_main_loop_quit
```

`App.runApp()` (the existing blocking entrypoint used by examples) is updated internally to build a `StarterOpts{buildWidgetTree: fn, onPostFrame: NULL, onFlutterError: NULL}` — examples and galleries do not change. Regenerate FFM bindings with `./gradlew :ewt.api:jextract`.

### New Dart hooks (`widgets/lib/engine_hooks.dart`, new file)

- `attachEngineHooks(StarterOpts opts)` registers, once at engine boot:
  - `WidgetsBinding.instance.addPersistentFrameCallback` guarded by a `_captureNextFrame` flag set from `Starter_requestRebuild` — captures a depth-first JSON snapshot of the element tree (`{t, d, k, r, s, w, h}` per node) and delivers it plus the current `frameId` up through `postFrameFn`.
  - `FlutterError.onError` — associates each error to the current `frameId` and delivers it through `flutterErrorFn`. Default handler is suppressed so CI logs stay clean.
  - Rebuild handler that, on `Starter_requestRebuild`, calls `setState` on `HotReloadRoot`'s state, causing Flutter to re-invoke `buildWidgetTreeFn` and receive the new tree.
- The plugin's `main.dart` invokes `attachEngineHooks` after `callToBuildWidgetTree`. Snapshot bytes are Dart-heap-allocated per frame and copied into Java on the upcall; no shared native buffer.

### New Java API (`dev.equo.ewt`)

Top-level classes (not nested inside `App`):

- `EngineHandle` — orchestrates lifecycle: `firstFrameReady()` (Future), `run()` (blocks the engine thread), `requestRebuild()`, `requestShutdown()`.
- `PostFrameNotifier` — thread-safe registry of `Runnable` listeners plus `awaitFrameAfter(long frameId)`; carries the snapshot JSON with the signal.
- `FlutterErrorCollector` — thread-safe append buffer of `FlutterErrorRecord(frameId, kind, messageFirstLine, stack)`; `errorsBetween(preId, postId)` for per-variant assertions.
- `HotReloadRoot` gains an `AtomicReference<Supplier<Widget>>` and a static `requestRebuild(Supplier<Widget> next)`. The existing `Callable<Widget>` field is preserved for backward compatibility with the current hot-reload path.

`App.runApp()` and `HotReloadRoot`'s existing reassemble flow are unchanged for non-test callers.

### New generator emitter (`generator/lib/emit/variants_gen.dart`, `generator/lib/type_samples.dart`, `generator/lib/contextual_scaffolds.dart`)

Runs at the end of the existing `:generator:generator` pipeline. For each widget in `generation_index.dart`:

- Iterates its `@Builder.Factory` constructors (reusing the `Params` model that `widget_gen.dart` already builds).
- Emits `<Widget>Variants.java` under `ewt.api/src/test/java/dev/equo/ewt/support/variants/`, with one static method per `(factory × variantLabel)` combination: `_required`, `_allSet`, `_boundary`, `_nullExplicit`, `_callbackWired`. Non-applicable variants are silently omitted (e.g. widgets with no callback opts skip `_callbackWired`).
- Sample and boundary values come from `type_samples.dart`, a `DartType → {sampleCode, boundaryCode}` table (`String → "hello" / ""`, `int → 1 / 0`, `Color`, `EdgeInsets`, enums, callbacks with correct arity, etc.).
- Widgets needing a parent context (`Positioned`, `Expanded`, `Flexible`, `Tab`, `TableCell`, `ListTile`, …) are wrapped per `contextual_scaffolds.dart` — a hand-maintained map of ~20 entries. `EXPECTATIONS` keys still refer to the inner widget so the snapshot walker finds the widget under test, not the scaffold.
- Emits `WidgetVariantsRegistry.java` in the same package: monolithic, gitignored, with a single `allVariants()` returning `Stream<Arguments>(widgetName, variantLabel, Callable<Widget>, List<PropExpectation>)`.
- If a required parameter has no entry in `type_samples.dart`, the emitter logs a warning and skips that widget's variants — the build does not fail. Same silent-defer discipline as the existing generator when a widget shape cannot be emitted; the widget is added to the deferred list in `docs/gen_structure.md` on the next update.

`ewt.api/src/test/java/dev/equo/ewt/support/variants/PropExpectation.java` is hand-written: a small record with `equalTo(name, value)` and `notNull(name)` factories.

### `WidgetBuilderCatalog` changes

The 400+ hand-maintained `w("name", () -> Widget.builder().build())` entries are deleted. `mountableWidgets()` becomes a two-column projection of `WidgetVariantsRegistry.allVariants()` (unchanged consumer contract for `WidgetBuilderSerializationTest`); `mountableVariants()` is added and returns the full four-column tuple. `nativeObjValues()` is untouched.

### New test classes (`ewt.api/src/test/java/dev/equo/ewt/`)

- `FlutterRenderTestBase` — abstract, `@Tag("native")`, owns the engine `@BeforeAll` / `@AfterAll` and exposes `mountAndCapture(Callable<Widget>)`.
- `WidgetNativeRenderTest` — one `@ParameterizedTest` over `mountableVariants()`. Per variant: asserts the widget is in the snapshot, its RenderBox has `width > 0 && height > 0`, no `FlutterError` was captured in the frame window, and the getter round-trip matches `PropExpectation`s.
- `GetterRoundTrip` — reflection-based helper invoking getters homonymous with the constructor params.

Cooldown between variants: set root to `SizedBox().build()` and wait one frame before the next variant, to give Dart tickers/animations a chance to dispose. If cross-test pollution surfaces despite this, escalate to `WidgetsBinding.instance.reassembleApplication()` per variant.

### Recovery policy

- Builder throw / captured FlutterError: test fails, engine survives, next test runs normally.
- 5-second per-variant timeout waiting for post-frame: test fails. After 3 consecutive timeouts the engine is considered wedged, remaining variants are marked `skipped`, and `@AfterAll` shuts down. No engine auto-restart — the evidence is structural.
- Native crash (SIGSEGV): JVM dies, job fails red, `hs_err_pid*.log` is uploaded as a CI artifact.

### CI (`.gitlab-ci.yml`)

New `ewt_native_render` job in the `test` stage, extending `.linux_base` (same image as `ewt_evolve_smoke`: xvfb + Flutter 3.35.7 + JDK 22 + jextract 25), depending on `generate`, `flutter:linux`, `ewt_api_tests:linux`. Runs:

```
JAVA_HOME=/opt/jdk-22 xvfb-run -a ./gradlew :ewt.api:test \
    -DrunNativeTests=1 --tests dev.equo.ewt.WidgetNativeRenderTest --info
```

Uploads JUnit XML, HTML report, and any `hs_err_pid*.log` as artifacts. Timeout 15min (budget 10min + 50% safety). Wired as a hard gate: `ewt_build.needs` gains `- job: ewt_native_render`.

Sharding hook is present but inactive by default: `EWT_SHARD_INDEX` / `EWT_SHARD_COUNT` env vars filter `mountableVariants()` by `Objects.hash(widgetName, variantLabel)` mod count. Activation is a CI-only edit: convert the job to `parallel: { matrix: [{EWT_SHARD_INDEX: 0..2, EWT_SHARD_COUNT: 3}] }`.

### Non-goals

- Golden-image / pixel-diff assertions — separate future ADR.
- Imperative-method testing (`TabController.animateTo`, `AnimationController.forward`) — the round-trip covers only value getters. Imperative testing is a separate suite.
- Widgets deferred by the generator today (`SubmenuButton`, `PopupMenuButton` and the `AnimationController` decoder-tuning tracked in issue #43) — skipped from the registry with an inline comment referencing that issue. Not resolved here.

### Local dev impact

`./gradlew test` continues to skip `@Tag("native")` via the existing `runNativeTests` gate in `ewt.api/build.gradle.kts`. Devs run the standard suite as today with no xvfb, no Flutter runtime. Opt-in with `-DrunNativeTests=1`.

### Gitignore additions

The monolithic generated files added by this ADR follow the pattern established in [ADR-0005](0005-gitignore-monolithic-generated-files.md):

- `ewt.api/src/test/java/dev/equo/ewt/support/variants/WidgetVariantsRegistry.java` (monolithic, changes per widget added).
- `ewt.api/src/test/java/dev/equo/ewt/support/variants/*Variants.java` (per-widget, gitignored for symmetry with the rest of the generated tree).

Devs regenerate them with the same `:generator:generator` command they already run.
