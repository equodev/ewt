---
name: add-widget
description: Use when adding a new Flutter widget to EWT — covers generation_index entry, running the generator, verifying the build, adding a web-mode smoke test, running the auto-generated native render variants for the new widget, adding a gallery demo, and filing a GitLab issue if the widget fails.
---

# Add a Widget to EWT

## Overview

Adding a widget means: (1) declaring it in the generation index, (2) running the code generator, (3) verifying the Java build compiles, (4) adding a web-mode smoke test, (5) running the auto-generated native render variants for the widget, (6) adding a demo to the gallery. The generator handles everything in between — C headers, Dart factories, Java builders, FFM bindings, **and** per-widget native render variant catalogs (`<Widget>Variants.java`).

---

## Step 1 — Declare the widget in `generation_index.dart`

File: `ewt/generator/lib/generation_index.dart`

Add one nullable field declaration. The field name becomes the Java factory method name.

**Import aliases:**
- `w.` → `package:flutter/widgets.dart`
- `m.` → `package:flutter/material.dart`
- `c.` → `package:flutter/cupertino.dart`

**Examples:**
```dart
m.Card? card;                          // EWT.Card(...)
m.ExpansionTile? expansionTile;        // EWT.ExpansionTile(...)
c.CupertinoSwitch? cupertinoSwitch;    // EWT.CupertinoSwitch(...)
w.FittedBox? fittedBox;               // EWT.FittedBox(...)
```

**If skipping a widget** (unsupported reason), comment it out with the reason, matching the style of existing comments in the file. Do NOT leave it uncommented if the generator can't handle it.

Do not touch `docs/coverage.md` — CI regenerates it automatically.

---

## Step 2 — Delete the pregeneration cache

```bash
rm -f ewt/generator/build/pregeneration_index.dart.ts
```

Always required when `generation_index.dart` changes. Without it, `subwidgets.dart` won't be regenerated and the Java build fails with missing `*ObjSt` symbols.

---

## Step 3 — Run the generator

```bash
cd ewt
JAVA_HOME=~/bin/jdk-22 ./gradlew :generator:generator
```

This regenerates everything via `finalizedBy`:
- `ewt.api/src/main/java/dev/equo/ewt/*.java` — Java builders
- `widgets/src/factories.h`, `objects.h`, `typedefs.h` — C headers
- `widgets/lib/factories_gen.dart` — Dart FFI factories
- `ewt.api/src/main/java/dev/equo/ewt/ffm/` — Java FFM bindings (via jextract)
- `widgets/lib/widgets_bindings_generated.dart` — Dart FFI bindings (via ffigen)

If the task prints a warning that a widget was skipped (unsupported param type), comment it out in `generation_index.dart`. See `docs/gen_structure.md` §4 for the known deferred widgets and generator gaps.

---

## Step 4 — Verify the Java build

```bash
JAVA_HOME=~/bin/jdk-22 ./gradlew :ewt.api:jar -PuseLocal=true
```

If this fails, common causes:
- **Private enum** — Flutter widget uses an enum whose name starts with `_`. The generator can't emit the Java constant. Comment the widget out.
- **Required `Key` param** — generator has no `Key` marshaling. Comment it out.
- **Stale `.java` from a removed entry** — delete the orphaned file by hand; the generator never removes files.

**Silent-skip audit (recommended).** After the build passes, run the
generator with `--strict` to make sure no widget dropped silently:

```bash
cd generator && rm -f build/pregeneration_index.dart.ts && \
  dart run bin/generator.dart --strict
```

Exit code 1 means at least one `warn: ...` fired (unsupported type or
dropped widget). Read the stderr lines to see which; either close the
gap (see `docs/gen_structure.md` §2b for the shape catalog and §4 for
known deferrals) or comment the widget out with a reason.

### Step 4b — Snapshot test

```bash
cd generator && dart test test/snapshot_test.dart
```

Adding a supported widget INTENTIONALLY changes the generator output —
new `.java` files, new lines in `factories.h` / `factories_gen.dart` /
etc. That's expected. If the snapshot test fails only in files
proportional to your new widget, refresh the frozen references:

```bash
cd generator && dart run tool/update_snapshots.dart
```

Commit the resulting snapshot diff **alongside** the new `.java` files.
Reviewers see the exact bytes the new widget adds.

If the snapshot fails in files unrelated to your widget, something else
regressed — investigate before updating snapshots.

---

## Step 5 — Add a web-mode smoke test to `WidgetCaptureSmokeTest`

File: `ewt/ewt.api/src/test/java/dev/equo/ewt/WidgetCaptureSmokeTest.java`

Every widget has one test method in this class that verifies the widget serializes without exception using the web/serializing path (`EwtWebCapture.captureSubtree()`). These tests run headlessly in CI — no Flutter engine required.

**Two patterns depending on the type:**

### Pattern A — Widget types (most widgets)

Use `EwtWebCapture.captureSubtree()`. Supply all Immutables-required attributes (non-Optional primitives and objects); the Immutables builder throws `IllegalStateException` at `build()` if any are missing.

```java
@Test
void card() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Card().build()
    ).root);
}

@Test
void padding() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Padding(EdgeInsets_all(8.0).build()).build()
    ).root);
}
```

### Pattern B — Non-Widget `NativeObj` types (Color, EdgeInsets, IconData, DataCell, etc.)

Use the `buildValue()` helper defined at the top of the class. It installs `SerializingWidgetConstructors` manually, which is what `captureSubtree` does internally for Widgets.

```java
@Test
void color() throws Exception {
    buildValue(() -> Color(0xffaabbcc).build());
}

@Test
void edgeInsets_all() throws Exception {
    buildValue(() -> EdgeInsets_all(8.0).build());
}
```

### Pattern C — Widget that needs intermediate NativeObj values inside

When you need to create a non-Widget NativeObj to pass into the Widget, use a block lambda so all construction happens inside the `captureSubtree` call (factories is null outside):

```java
@Test
void navigationDrawer() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> {
        var dest = NavigationDrawerDestination()
            .icon(Icon(IconData(0xe000).build()).build())
            .label(Text("home").build()).build();
        return NavigationDrawer(List.of(dest)).build();
    }).root);
}
```

### Pattern D — Animated widgets

Animated widgets with required `duration` or `sizeFactor`:

```java
// duration is required (non-Optional Duration field)
@Test
void animatedOpacity() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> AnimatedOpacity().opacity(0.5)
            .duration(Duration().milliseconds(300).build()).build()
    ).root);
}

// AnimationI required: use AnimationController.byId(0) as a stub
@Test
void sizeTransition() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> SizeTransition().sizeFactor(AnimationController.byId(0)).build()
    ).root);
}
```

**Required params quick reference** (same Immutables rules apply):

| Required type | Minimal value |
|---|---|
| `String` | `""` |
| `WidgetI` | `SizedBox().build()` or `Text("x").build()` |
| `IconDataI` | `IconData(0xe000).build()` |
| `ColorI` | `Color(0xFF000000).build()` |
| `EdgeInsetsGeometryI` | `EdgeInsets_all(0.0).build()` |
| `DurationI` | `Duration().milliseconds(300).build()` |
| `AnimationI` | `AnimationController.byId(0)` |
| `double` | `0.0` |
| `int` | `0` |
| `boolean` | `false` |
| List of widgets | `List.of(SizedBox().build())` |

**Note on EWT factory names:** Named Dart constructors become underscore variants in `EWT.java`, e.g. `EdgeInsets_all()`, `GridView_count()`, `BorderRadius_circular()`. `GridView` has no default constructor — only `GridView_count(crossAxisCount)` and `GridView_extent(maxCrossAxisExtent)`.

**After adding the test, verify it passes:**

```bash
cd ewt
JAVA_HOME=~/bin/jdk-22 ./gradlew :ewt.api:test --tests "dev.equo.ewt.WidgetCaptureSmokeTest.<yourMethodName>"
```

The `WidgetCaptureSmokeTest` covers the **serializing / web** path only. It runs headlessly in `./gradlew test` and does NOT need a Flutter engine. The native rendering path is exercised separately in Step 6 below.

---

## Step 6 — Run the auto-generated native render variants for the widget

The `:generator:generator` step (Step 3) also emits per-widget variant catalogs into `ewt.api/src/test/java/dev/equo/ewt/support/variants/`:

- `<Widget>Variants.java` — one file per widget, with static methods `<factory>_required()`, `<factory>_allSet()`, `<factory>_boundary()`, and (when applicable) `<factory>_callbackWired()`.
- `WidgetVariantsRegistry.java` (gitignored) — enumerates every variant as a JUnit `Arguments` tuple `(widgetName, variantLabel, Callable<Widget>, expectations)`.

`WidgetNativeRenderTest` is a single `@ParameterizedTest` over that registry: for every variant it mounts the widget in a real Flutter engine, waits for a frame, and asserts (i) the widget is in the element tree, (ii) `RenderBox` has positive width/height, (iii) no `FlutterError.onError` fired, and (iv) for `_allSet`/`_boundary`, every set param round-trips via its getter.

See `docs/native-tests.md` and [ADR-0009](../../../docs/adr/0009-native-render-test-harness.md) for the design.

### 6a — Confirm the emitter wrote the variants file

```bash
ls ewt.api/src/test/java/dev/equo/ewt/support/variants/<Widget>Variants.java
```

If missing, the emitter skipped the widget. Check the generator stderr for `warn: <Widget>:` — usually a required param type has no sample in `generator/lib/type_samples.dart`. Extend `type_samples.dart` (that's a `modify-generator` task) or add the widget to the `_deferred` deny-list at the top of `generator/lib/emit/variants_gen.dart` with a comment explaining why.

If the widget renders standalone but needs a specific parent (e.g. a `Positioned` inside a `Stack`, a `Tab` inside a `DefaultTabController`), add a wrapper template to `generator/lib/contextual_scaffolds.dart` and re-run the generator.

### 6b — Run the native render suite

```bash
cd ewt
JAVA_HOME=~/bin/jdk-22 ./gradlew :ewt.api:test \
    -DrunNativeTests=1 \
    --tests dev.equo.ewt.WidgetNativeRenderTest \
    --tests dev.equo.ewt.NativeRenderSmokeTest
```

**Linux runtime requirement:** needs an X display. If you have a desktop session, the command works as-is (a Flutter window flashes per variant). For a headless run, install `xorg-server-xvfb` (`sudo pacman -S xorg-server-xvfb` on Manjaro/Arch, `apt install xvfb` on Debian/Ubuntu) and prepend `xvfb-run -a` to the Gradle command.

macOS / Windows: not supported yet — the harness is Linux/GTK-only. Run this step on Linux (or skip it and rely on CI, which runs the same suite under `xvfb-run -a` in the `ewt_native_render` job — soft-gated with `allow_failure: true`).

### 6c — Confirm the new widget's variants pass

Gradle's `--tests` filter does NOT reliably scope parameterized display names, so the practical flow is:

1. Run the full suite in 6b.
2. Open the HTML report at `ewt.api/build/reports/tests/test/classes/dev.equo.ewt.WidgetNativeRenderTest.html`.
3. Grep or scroll to lines starting with `<Widget>/` — one row per variant emitted for your widget (typically 3–4: `_required`, `_allSet`, `_boundary`, sometimes `_callbackWired`).
4. **All variants for your widget must pass.** Pre-existing failures in *other* widgets are known and tracked (see below); they are not a signal about your change.

Alternatively, grep the console output:

```bash
JAVA_HOME=~/bin/jdk-22 ./gradlew :ewt.api:test -DrunNativeTests=1 \
    --tests dev.equo.ewt.WidgetNativeRenderTest --info 2>&1 \
    | grep -E "(PASSED|FAILED).*<Widget>/"
```

### 6d — Known pre-existing failure buckets (ignore, unless they involve your widget)

The suite currently passes ~70% (roughly 451/647 variants). The 196 failures split into two well-understood buckets — both are follow-up work, not blockers for adding a widget:

- **`AssertionError: variant builder threw`** (~100) — the emitter's optionality detection via Dart analyzer's `isRequired` does not match what Immutables marks `@Value.Required` on the Java builder. Tracked by [issue #44](https://gitlab.com/maketechnology/equo/ewt/-/work_items/44).
- **`_TypeError`** (~60) — widgets that need a more specific ancestor than the harness's default `MaterialApp` wrap (`Material` for buttons, `DefaultTabController` for tabs, `CupertinoApp` for Cupertino widgets, `Scaffold` for `SnackBar`). Fix by extending `generator/lib/contextual_scaffolds.dart`.

If your new widget's failure fits one of these buckets, the right move is to extend the generator (add the contextual scaffold, or fix the `isRequired`/`@Value.Required` mismatch) rather than to route around it — see `modify-generator`. Only fall back to commenting the widget out of `generation_index.dart` if the generator gap is too large to close in the same MR.

### 6e — Legacy `@Tag("native")` tests

Three hand-written `@Tag("native")` tests remain in `ewt.api/src/test/java/dev/equo/ewt/test/` (`AppTest`, `TextBuilderTest`, `TextCreateTest`). They run under the same `-DrunNativeTests=1` gate and pass, but they cover `Text` only. New widgets do NOT need a hand-written companion here — the auto-generated variants supersede them.

---

## Step 7 — Add a gallery demo

File: `ewt/examples/src/main/java/dev/equo/gallery/<Family>Gallery.java`

Pick the gallery that matches the widget family:

| Gallery | Covers |
|---|---|
| `LayoutWidgetsGallery` | sizing, clipping, alignment, painting, transforms |
| `MaterialControlsGallery` | buttons, inputs, sliders, list tiles, overlays |
| `ImplicitAnimationsGallery` | `Animated*` widgets |
| `ScrollWidgetsGallery` | ListView, GridView, PageView |
| `TabsGallery` | tab navigation |
| `CupertinoGallery` | iOS-style components |

Use `GalleryKit.tile(label, widget)` for static demos, or add state fields to the page's `SubState` if the widget needs interaction:

```java
// Static demo (no state needed)
tile("Card", Card().child(Padding(EdgeInsets_all(16.0)).child(Text("A card"))).build()),

// Interactive demo (add fields to the State class)
boolean _expanded = false;
// ...
tile("ExpansionTile", ExpansionTile(Text("Header"))
    .children(List.of(Text("Body text")))
    .build()),
```

---

## Step 8 — Run the gallery to verify

```bash
cd ewt
JAVA_HOME=~/bin/jdk-22 ./gradlew :ewt.api:jar -PuseLocal=true
./gradlew :examples:run -PuseLocal=true -PmainClass=dev.equo.gallery.MaterialControlsGallery
```

Replace the gallery class with whichever one you added the demo to.

Confirm: widget renders, callbacks fire, no regressions in other demos.

---

## When a widget fails — open a GitLab issue

If a widget cannot be added (generator skips it permanently, Java build fails for an unresolvable reason, or the builder test throws at runtime), **comment it out** in `generation_index.dart` and open a tracking issue in the EWT repo so it stays on the roadmap.

The GitLab project is `maketechnology/equo/ewt`.

```bash
glab issue create \
  --repo maketechnology/equo/ewt \
  --title "Add widget: <WidgetName> (<brief reason it's blocked>)" \
  --description "$(cat <<'EOF'
## Widget
`<flutter package>.<WidgetName>` (e.g. `m.ExpansionTile`)

## Blocker
<One sentence: why the widget can't be added now — unsupported param type, private enum, Key required, runtime crash, etc.>

## Generator output / error
\`\`\`
<paste the relevant warn: line or stack trace>
\`\`\`

## Suggested fix
<What would need to change in the generator or EWT to unblock this widget>
EOF
)"
```

Label guidelines (add with `--label`):
- `widget-blocked` — generator or compile-time failure
- `widget-test-fail` — widget adds successfully but builder test fails at runtime
- `needs-generator-work` — blocked because a new generator shape is required

---

## Common pitfalls

| Symptom | Cause | Fix |
|---|---|---|
| `*ObjSt` symbol not found | Stale pregeneration cache | `rm -f generator/build/pregeneration_index.dart.ts` then re-run |
| Java compile error on `_kPrivate()` | Private const field in Dart widget | Generator inlines literal at source; see memory `bug-private-dart-const-in-java` |
| SIGSEGV on optional callback | Double-pointer wrapping issue | Fixed at source (commit 416223b); a new callback pattern may need the same treatment |
| Generator drops widget silently | Unsupported required param type | Run with `--strict` to surface it as an exit-1 failure; then read the `warn:` stderr line to know which type is unsupported |
| Java "method already defined" on the widget class | A field shares the exact name with the widget (e.g. `Offstage.offstage`) — both resolve to `offstage()` with no params | Comment the widget out; note the collision in the comment |
| Web region renders grey | Stale evolve-app bundle | `cd evolve-app && flutter build web` — see memory `gotcha-runsamplesweb-stale-bundle` |
| Snapshot test fails in unexpected files | The new widget triggered a shape route you didn't expect (e.g. it hit `ColorSwatchGen` because it extends `ColorSwatch`) | Check `Types.getGen` — if the new shape is appropriate, refresh snapshots and commit the diff; if not, the widget needs a different shape (see `docs/gen_structure.md` §2b) |
| Builder test compiles but crashes at runtime | The widget constructor throws (usually `RuntimeException: Failed to created widget`) | Check if Flutter is running and the app is initialized — native tests require the Flutter engine to be live |
| `<Widget>Variants.java` not emitted by generator | Required param type missing from `type_samples.dart`, or widget is in `_deferred` in `variants_gen.dart` | Extend `generator/lib/type_samples.dart` with a sample for the missing type (a `modify-generator` task), or explicitly defer with a comment — do NOT silently ignore |
| Native variant fails with `variant builder threw` | Immutables marks a param `@Value.Required` but the Dart analyzer sees it as optional — `_required`/`_nullExplicit` variants build with a missing field | Known bucket, [issue #44](https://gitlab.com/maketechnology/equo/ewt/-/work_items/44). If it blocks your widget, closing the `isRequired` gap in the emitter is a `modify-generator` task |
| Native variant fails with `_TypeError: MediaQuery`/`Material`/etc. | Widget needs a specific ancestor (`Material`, `DefaultTabController`, `CupertinoApp`, `Scaffold`) not provided by the harness's default `MaterialApp` wrap | Add a wrapper template to `generator/lib/contextual_scaffolds.dart` and re-run the generator |
| Native suite skipped entirely (0 tests ran) | `-DrunNativeTests=1` not propagated, or no `$DISPLAY` on Linux | Verify the flag is on the `./gradlew` line (not just exported), and either start an X session or prefix `xvfb-run -a` |

---

## Widget doesn't fit any shape

If the widget you're adding needs behavior that no shape in
`emit/shape/` covers — e.g. it's a controller with imperative methods,
or it has a `.builder` factory that eager-expands children — **you're
not adding a widget, you're modifying the generator**. Use the
`modify-generator` skill instead: it walks through creating a new shape
class, wiring it into `Types.getGen`, and keeping the snapshot test
honest.
