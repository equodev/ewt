# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What This Project Is

EWT (Equo Widget Toolkit) is a framework that lets Java developers build Flutter UIs using Java. It bridges Java (via JDK 21+ Foreign Function & Memory API) and Flutter/Dart through a C native layer. Java code calls native C functions, which invoke the Flutter runtime to render widgets.

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

`jextract` must be installed at `~/bin/jextract-22/bin/jextract`.

## Architecture

The stack has four layers:

```
Java user code  (ewt.api + examples)
      ↓ JDK 21 FFM (Panama API)
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

### Native Library Loading

`App.java` currently hard-codes macOS paths in a `static {}` block. When targeting a different platform or workspace, those paths must be updated before the app can launch. This is a known rough edge.

## Key Technologies

- **JDK 21+** — required for the Foreign Function & Memory (Panama) API
- **Immutables** — generates immutable value types and fluent builders; the annotation processor patches the output
- **Flutter FFI plugin** (`widgets/`) — the Dart side receives widget-tree callbacks over C function pointers
- **Dart analyzer** — the generator introspects Flutter widget constructors to know which parameters to expose in Java
