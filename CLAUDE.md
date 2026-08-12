# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What This Project Is

EWT (Equo Widget Toolkit) is a framework that lets Java developers build Flutter UIs using Java. It bridges Java (via the JDK 22+ Foreign Function & Memory API) and Flutter/Dart through a C native layer. Java code calls native C functions, which invoke the Flutter runtime to render widgets.

## Commands

```bash
# Build all subprojects
./gradlew build

# Run tests (JUnit 5)
./gradlew test

# Run tests for a specific subproject
./gradlew :ewt.api:test

# Run the full code generation pipeline (generates Java widget builders from Flutter widgets)
./gradlew :generator:generator

# Generate Dart FFI bindings from C headers
./gradlew :widgets:ffigen

# Generate Java FFM bindings from Starter.h using jextract
./gradlew :ewt.api:jextract
```

### Toolchain

| Tool | Version | Notes |
|---|---|---|
| Flutter | 3.35.7 | |
| JDK | 23 | The build sets `options.release = 22`, but `./gradlew` itself needs 23. Set `JAVA_HOME` if your shell default is older. |
| jextract | 25 | Must be at `~/bin/jextract-25/bin/jextract` (see the `jextract` task in `ewt.api/build.gradle.kts`). Download from https://jdk.java.net/jextract/ and untar into `~/bin`. |

### First-time setup / fresh checkout

The monolithic generated files are gitignored. After cloning or switching to a branch that changes
`generation_index.dart`, regenerate everything before building:

```bash
rm -f generator/build/pregeneration_index.dart.ts   # force pregeneration of subwidgets.dart
JAVA_HOME=~/bin/jdk-22 ./gradlew :generator:generator  # also runs ffigen + jextract via finalizedBy
```

The pregeneration cache must be deleted because `generator/lib/subwidgets.dart` is gitignored but
is imported by `generation_index.dart`. Without this step, jextract skips the SubState-related
structs and the Java build fails with missing `*ObjSt` symbols.

### Adding a widget

Declare it in `generator/lib/generation_index.dart` (one line, e.g. `m.Drawer? drawer;`), then run:

```bash
rm -f generator/build/pregeneration_index.dart.ts
JAVA_HOME=~/bin/jdk-22 ./gradlew :generator:generator   # Java builders + C headers + Dart factories + ffigen + jextract
```

The generator does not delete output for widgets removed from the index; stale `*.java` left behind will break the build, so remove them by hand.

`docs/coverage.md` is the tracking list for the widget-coverage effort: one line
per widget in `widgets.dart`, `material.dart` and `cupertino.dart`, in four
states — ✅ complete, 🟡 partial, ❌ unusable, ⬜ not supported.

The distinction matters. A widget can be declared in `generation_index.dart`,
have its `.java` class emitted, and still be unusable: the generator silently
skips optional params whose Dart type it cannot marshal, and skips a constructor
entirely when a *required* param is unmarshalable. `docs/coverage.md` used to
tick those as supported. Now it doesn't:

```
generator  →  generator/build/coverage_status.json   (what got dropped, per widget/ctor)
                            ↓
           tool/coverage_audit.dart  +  Flutter libs via the analyzer
                            ↓
                     docs/coverage.md
```

`coverage_status.json` is gitignored (it lives under `build/`) but frozen as a
snapshot in `generator/test/snapshots/`, so a change in which params survive
marshalling shows up as a reviewable diff in the MR rather than silently moving
the numbers. Refresh it with `dart run tool/update_snapshots.dart`.

**Never edit or commit `docs/coverage.md` by hand.** The CI `coverage:commit` job
runs the generator and the audit on every pipeline, and on `main` commits the
result (with `[skip ci]`) *only when the content actually changed* — the report
carries no timestamp and every list in it is sorted, so a commit that doesn't
affect coverage produces a byte-identical file and no commit. To see the current
coverage locally:

```bash
cd generator && dart run bin/generator.dart && dart tool/coverage_audit.dart
```

The audit resolves the libraries with the Dart analyzer, so the widget list
always reflects the installed Flutter version.

The report counts the two backends separately (`Props (native)` / `Props (web)`).
They are not the same number: a param the pure-Dart web decoder cannot represent
still has a Java setter that works over the native FFI bridge, so averaging them
would hide which backend is short.

What the report does *not* claim: that a widget renders correctly. A property
counts as exposed when its Java setter is generated — an API-surface fact, not a
runtime one.

### The coverage gate

`tool/coverage_gate.dart` diffs the report against the snapshot as committed on
`main` and fails when coverage got *worse* — a property that lost its setter, a
constructor no longer generated, a widget no longer instantiable. New widgets
that land incomplete are reported but do not fail (`--strict-new` changes that).

```bash
git show origin/main:generator/test/snapshots/coverage_status.json > /tmp/base.json
cd generator && dart run bin/generator.dart && dart tool/coverage_gate.dart /tmp/base.json
```

The CI job is `allow_failure: true` by design — it is advisory and must never be
the reason an MR cannot merge. The tool is defensive to match: a missing, empty
or malformed baseline exits 0 with a warning rather than breaking the pipeline.
CI fetches the baseline over the API instead of reading the branch, so an MR
cannot move its own goalposts by refreshing the snapshot.

`test/coverage_gate_test.dart` covers the comparison logic directly — the gate's
failure modes are otherwise only reproducible by pushing commits.

**Companion doc — `docs/gen_structure.md`**: hand-maintained. Two sections:
(1) which Java classes are generated vs. hand-written across the ewt.api
source tree, and (2) the deferred-widgets list — for each widget the
generator can't emit yet, the specific gap and the concrete work needed to
close it. Read this BEFORE adding a widget to `generation_index.dart` that
looks similar to a deferred one, and UPDATE this doc (not
`generation_index.dart`) when deferring a new widget.

### Widget galleries

Runnable examples live in `examples/src/main/java/dev/equo/gallery/`, one gallery
per widget family, named `<Family>Gallery`:

| Gallery | Covers |
|---|---|
| `LayoutWidgetsGallery` | sizing, clipping, alignment, painting, transforms |
| `MaterialControlsGallery` | Switch, Checkbox, Slider, list tiles, Badge, Tooltip, Drawer |
| `ImplicitAnimationsGallery` | the `Animated*` widgets |
| `ScrollWidgetsGallery` | ListView, GridView, PageView |
| `TabsGallery` | DefaultTabController, TabBar, Tab, TabBarView |

```bash
./gradlew :ewt.api:jar -PuseLocal=true
./gradlew :examples:run -PuseLocal=true -PmainClass=dev.equo.gallery.LayoutWidgetsGallery
```

`GalleryKit` holds the shared presentation helpers so each gallery reads as a
list of the widgets it demonstrates.

### Generated files — do not edit

The following files are **gitignored** because they are monolithic artifacts that change entirely when any widget is added, causing unavoidable merge conflicts when multiple developers add widgets in parallel. They must be regenerated locally before building — the three-step pipeline above handles this.

| File | Generator step |
|---|---|
| `widgets/src/factories.h`, `objects.h`, `typedefs.h` | `:generator:generator` |
| `widgets/lib/factories_gen.dart` | `:generator:generator` |
| `widgets/lib/subwidgets.dart`, `generator/lib/subwidgets.dart` | `:generator:generator` |
| `widgets/lib/widgets_bindings_generated.dart` | `:widgets:ffigen` |
| `ewt.api/src/main/java/dev/equo/ewt/ffm/` | `:ewt.api:jextract` |

`widgets/lib/subwidgets.dart` **and** `generator/lib/subwidgets.dart` are written by `PreGeneration.write` in `generator/lib/gen.dart`. Editing either one is silently reverted the next time anyone runs the generator. Change the emitting code in `DartSubclassGen` instead.

`PreGeneration` is cached against the timestamp of `pregeneration_index.dart`, so edits to the generator's own code do not invalidate it. Delete `generator/build/pregeneration_index.dart.ts` to force a re-run.

## Architecture

The stack has four layers:

```
Java user code  (ewt.api + examples)
      ↓ JDK 22 FFM (Panama API)
C native bridge  (widgets/example/native/Starter.{h,c})
      ↓ function pointers / callbacks
Flutter/Dart runtime  (widgets plugin)
```

### Subprojects

| Subproject | Language | Role |
|---|---|---|
| `generator` | Dart | Reads Flutter widget definitions with the Dart analyzer; emits Java builder source files and C headers |
| `annotation-processor` | Java | Runs over Immutables-generated sources to make builder classes extend `Widget` |
| `ewt.api` | Java | Public API: widget base classes, generated builders, FFM bridge (`dev.equo.ewt.ffm`) |
| `widgets` | Dart + C | Flutter FFI plugin; the C side exports `startApp` and widget factory functions |
| `examples` | Java | Example apps (`HelloWorld`, `Counter`) |

### Code Generation Pipeline

```
Flutter Dart source  →  generator (Dart)  →  Java *Builder.java files
                                          →  C header additions to Starter.h
                                          ↓
                         jextract         →  dev/equo/ewt/ffm/*.java (FFM bindings)
                         ffigen           →  Dart FFI bindings in widgets/
```

Running `./gradlew :generator:generator` regenerates the Java builder classes in `ewt.api/src/main/java/dev/equo/ewt/`. The output of jextract goes into the same source tree but under `dev/equo/ewt/ffm/`.

### Annotation Processor Split Compilation

Because the annotation processor must modify Immutables-generated classes, `ewt.api/build.gradle.kts` compiles in two passes: first a `processCustom` task runs annotation processing only (`-proc:only`), then `compileJava` compiles everything without re-running processors (`-proc:none`). The generated sources land in `build/generated/sources/immutables/` and are added to the main source set.

### Writing Widgets

Stateless widgets extend `StatelessWidget` and override `build(BuildContext)`:

```java
public class MyWidget extends StatelessWidget {
    @Override
    public Widget build(BuildContext ctx) {
        return EWT.Text("Hello").build();
    }
}
```

Stateful widgets extend `SubStatefulWidget` and implement `createState()` returning a `SubState` subclass that holds mutable fields and overrides `build`.

## Key Technologies

- **JDK 21+** — required for the Foreign Function & Memory (Panama) API
- **Immutables** — generates immutable value types and fluent builders; the annotation processor patches the output
- **Flutter FFI plugin** (`widgets/`) — the Dart side receives widget-tree callbacks over C function pointers
- **Dart analyzer** — the generator introspects Flutter widget constructors to know which parameters to expose in Java
