# Native rendering tests

Automated suite that boots a real Flutter engine and mounts every widget
variant produced by the code generator through it. Verifies that each widget
actually renders — the element is in the tree, the RenderBox has a positive
size, and no captured `FlutterError` fired during the frame.

**Platform:** Linux only for now. macOS and Windows have symbol-parity stubs
but the harness itself targets the GTK/Flutter Linux embedding under `xvfb-run`
in CI. See "Non-goals" at the end.

**Design:** [ADR-0009](adr/0009-native-render-test-harness.md).

## Running it

Local (Linux desktop with any X server already running — Manjaro, Ubuntu,
Fedora etc.):

```bash
JAVA_HOME=~/bin/jdk-22 ./gradlew :ewt.api:test \
    -DrunNativeTests=1 \
    --tests dev.equo.ewt.WidgetNativeRenderTest \
    --tests dev.equo.ewt.NativeRenderSmokeTest
```

Runs against your real `$DISPLAY`, so a Flutter window flashes per variant.
Fine for iterating; for a headless silent run install `xorg-server-xvfb`
(`sudo pacman -S xorg-server-xvfb` on Manjaro / Arch, `apt install xvfb`
on Debian / Ubuntu) and prepend `xvfb-run -a` to the command above.

The `@Tag("native")` + `@EnabledIfSystemProperty(named="runNativeTests")`
gate keeps these out of a regular `./gradlew test` run, so day-to-day dev
work does not need xvfb or the Flutter runtime. In CI the same command runs
under `xvfb-run -a` in the `ewt_native_render` job, wired as a hard gate on
`ewt_build`.

## What the harness does — walked through `Text`

`Text` is a good example: two `@Builder.Factory` constructors on the Java
side (`Text.text(String)` and `Text.rich(InlineSpan)`), eleven optional
params (`style`, `textAlign`, `textDirection`, `softWrap`, `overflow`,
`textScaleFactor`, `maxLines`, `semanticsLabel`, `semanticsIdentifier`,
`textWidthBasis`, `selectionColor`), and a mix of primitive, enum, and
complex-value types among those opts. The generator lands on it and emits
`TextVariants.java` with three method-level entries (the `.rich` factory is
skipped because `InlineSpan` has no sample in `type_samples.dart` yet):

- `text_required()` — `Text.text("hello").build()`. Baseline: does the
  widget render with only its required argument set?
- `text_allSet()` — required + every optional set to its sample value
  (`style` = `TextStyle.builder()`, `textAlign` = `TextAlign.left`,
  `maxLines` = `1`, and so on).
- `text_boundary()` — required + every optional set to its boundary value
  (`""`, `0`, `0.0`, first/last enum, etc.).

The registry (`WidgetVariantsRegistry.java`, also generated) exposes one
row per emitted method as a JUnit `Arguments` tuple:

```java
Arguments.of("Text", "text_required", (Callable<Widget>) TextVariants::text_required,     null),
Arguments.of("Text", "text_allSet",   (Callable<Widget>) TextVariants::text_allSet,       EXPECTATIONS.get("text_allSet")),
Arguments.of("Text", "text_boundary", (Callable<Widget>) TextVariants::text_boundary,     EXPECTATIONS.get("text_boundary")),
```

`WidgetNativeRenderTest` is a single `@ParameterizedTest` over that stream.
For every row:

1. `HotReloadRoot.setUserBuilder(() -> variant.call())` atomically swaps
   the current widget-tree builder.
2. `engine.requestRebuild()` posts a job to the GTK main loop; Dart's
   rebuild handler bumps the frame id, arms the snapshot capture, and
   mutates the `ValueNotifier<Widget>` that feeds Flutter's root.
3. Flutter runs a rebuild + layout + paint cycle. The persistent-frame
   callback fires, walks the element tree depth-first, and pushes a JSON
   snapshot back to Java via an FFM upcall.
4. Java asserts:
   - the snapshot contains a `{"t":"Text",…}` node,
   - that node has `hasSize == true` with `width > 0` and `height > 0`,
   - the `FlutterErrorCollector` window `(preFrameId, postFrameId]` is
     empty (no captured `FlutterError.onError`),
   - for `_allSet` and `_boundary`, every param that was set is verified
     against a `PropExpectation` — primitives/enums via `equalTo`,
     complex values via `notNull`. Reflection invokes the getter
     homonymous with the constructor param.

After each variant the harness sets root to a sterile `SizedBox()` and
waits one frame — a cooldown so Dart tickers and animation controllers
from the previous variant get a chance to dispose before the next mount.

## Coverage today

- **145 widgets** get variant catalogs emitted.
- **647 variants** in the registry — a mix of `_required`, `_allSet`,
  `_boundary`, and `_callbackWired` entries depending on which apply to
  each widget.
- Each variant runs through the full mount+layout+paint+capture cycle.
- **~14 assertions per variant on average** (existence + size + errors
  + one per checked getter for `_allSet`/`_boundary`), so the suite
  executes on the order of 9k live rendering assertions.
- **Current pass rate: 451/647 (~70%).** The 196 failures split into
  two well-understood buckets that are follow-up work, not blockers:
  - **~100 `AssertionError: variant builder threw`** — the emitter's
    optionality detection (Dart analyzer's `isRequired`) does not match
    what Immutables marks `@Value.Required` on the Java builder. Same
    root cause as the deferred `mountableWidgets()` delegation.
    Tracked by [issue #44](https://gitlab.com/maketechnology/equo/ewt/-/work_items/44).
  - **~60 `_TypeError`** from widgets that need a more specific ancestor
    than the harness's default `MaterialApp` wrap: `Material` for
    buttons, `DefaultTabController` for tabs, `CupertinoApp` for
    Cupertino widgets, `Scaffold` for `SnackBar`. Extending
    `generator/lib/contextual_scaffolds.dart` (currently ~12 entries)
    to cover these families closes the gap. Not blocked on anything.

### What is not covered

- `_nullExplicit` (verifying that a builder tolerates explicit
  `Optional.empty()` on every optional setter) — the emitter cannot
  reliably determine which optionals are Optional-wrapped on the Java
  surface without a second compilation pass. Tracked with the analogous
  serialization gap; see the ledger's parked-findings list.
- Imperative methods on widgets (`TabController.animateTo`,
  `AnimationController.forward`, etc.) — the round-trip helper only
  verifies value getters. Imperative methods need per-widget setup and
  assertions and belong in a separate suite.
- Golden-image / pixel diffing — this suite verifies "the widget
  rendered", not "the widget rendered pixel-for-pixel like last week".
  A visual-regression suite is a separate future project.
- `SubmenuButton`, `PopupMenuButton`, `DragTarget` — deferred from the
  generator's registry with a stderr log (see issue #43).

## Adding a new widget to the catalog

Just add the widget's line to `generator/lib/generation_index.dart` as
usual and run the generation pipeline:

```bash
rm -f generator/build/pregeneration_index.dart.ts
JAVA_HOME=~/bin/jdk-22 ./gradlew :generator:generator
```

The variants emitter runs as part of that pipeline; the new widget picks
up `_required`/`_allSet`/`_boundary`/`_callbackWired` variants
automatically. If the widget has a required parameter whose type is not
yet in `generator/lib/type_samples.dart`, the emitter logs a warning to
stderr and skips it — extend the table when this happens.

If the new widget renders standalone but needs a specific parent (a
`Positioned` inside a `Stack`, a `Tab` inside a `DefaultTabController`),
add its wrapper template to `generator/lib/contextual_scaffolds.dart`.

## Non-goals

- **macOS / Windows.** The C entry points on both platforms accept the
  `StarterOpts` struct now and export no-op `Starter_requestRebuild` /
  `Starter_requestShutdown` stubs for symbol parity with Linux, so
  jextract'd Java bindings link on all three. But the Dart/GTK plumbing
  that drives per-variant rebuilds and captures the snapshot is
  Linux/GTK-specific. Rendering tests on other platforms would need a
  Win32-window-message or NSRunLoop equivalent for the rebuild trigger.
  Not scoped for this MR.
- **Multi-engine / per-test isolation.** One engine per JVM, per the
  ADR. If cross-test pollution ever forces isolation, the fallback is
  Gradle's `forkEvery=1` at the class level, but the shared-engine
  design is the primary path.
- **Serialization test unification.** `WidgetBuilderSerializationTest`
  keeps its hand-maintained catalog for now; delegation to the
  generator-emitted registry is deferred (see the parked-findings
  section of the ledger).
