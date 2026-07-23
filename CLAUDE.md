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

### Adding a widget

Declare it in `generator/lib/generation_index.dart` (one line, e.g. `m.Drawer? drawer;`), then run the three generation steps in order — the last two are what turn the emitted C headers into callable bindings, so skipping them fails with missing `*ObjSt` symbols:

```bash
./gradlew :generator:generator   # Java builders + C headers + Dart factories
./gradlew :ewt.api:jextract      # C headers -> Java FFM bindings
./gradlew :widgets:ffigen        # C headers -> Dart FFI bindings
```

The generator does not delete output for widgets removed from the index; stale `*.java` left behind will break the build, so remove them by hand.

**Whenever `generation_index.dart` changes, regenerate the coverage checklist** so
`docs/coverage.md` keeps matching what is actually supported:

```bash
cd generator && dart tool/coverage_audit.dart   # writes docs/coverage.md
```

`docs/coverage.md` is the tracking list for the widget-coverage effort (one
checkbox per widget in `widgets.dart`, `material.dart` and `cupertino.dart`,
ticked for the ones already generated). It is generated — never edit it by hand.
The tool resolves the libraries with the Dart analyzer, so it always reflects the
installed Flutter version.

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
