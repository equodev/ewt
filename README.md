# EWT — Equo Widget Toolkit

![License](https://img.shields.io/badge/license-Apache%202.0-blue)
![JDK](https://img.shields.io/badge/JDK-21%2B-orange)
![macOS](https://img.shields.io/badge/macOS-Supported-green) ![Windows](https://img.shields.io/badge/Windows-Supported-green) ![Linux](https://img.shields.io/badge/Linux-Supported-green)

**Build Flutter UIs in pure Java.**

EWT lets Java developers create native, cross-platform Flutter user interfaces
without writing a line of Dart. It bridges the JVM and the Flutter engine through
the JDK 21 [Foreign Function & Memory API](https://openjdk.org/jeps/454), so your
Java code drives a real Flutter render pipeline.

<p align="center">
  <img src="docs/demo.gif" alt="EWT demo — a Flutter UI driven from Java" width="800">
</p>

```java
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

public class HelloWorld {
    public static void main(String[] args) {
        App.runApp(() ->
            Center().child(Text("hello from Java"))
        );
    }
}
```

---

## Why EWT

- **One UI codebase, every desktop platform** — Linux, macOS, and Windows from the
  same Java sources, rendered by Flutter.
- **Java-native API** — fluent, type-safe builders generated directly from the
  Flutter widget catalog. `Center`, `Column`, `Container`, `Scaffold`,
  `MaterialApp`, and many more map one-to-one to their Flutter counterparts.
- **Stateful widgets you already know** — the familiar `StatefulWidget` /
  `setState` model, expressed in Java.
- **No FFI boilerplate** — the C and FFM bindings are generated; you write
  application code, not glue.

## A stateful example

```java
class Counter extends SubStatefulWidget {
    @Override
    protected State<Counter> createState() { return new CounterState(); }
}

class CounterState extends SubState<Counter> {
    int count = 0;

    @Override
    public Widget build(BuildContext ctx) {
        return Scaffold()
            .body(Center().child(Text("Count: " + count)))
            .floatingActionButton(
                FloatingActionButton()
                    .onPressed(() -> setState(() -> count++))
                    .child(Icon(Icons.add()))
            );
    }
}
```

See [`examples/`](examples/src/main/java/dev/equo) for full, runnable apps:
`HelloWorld`, `Counter`, `LoginForm`, `ProfileCard`, and a `WidgetGallery`.

## How it works

EWT is a four-layer stack. Java widget calls are translated into a widget tree
that the Flutter engine renders; events flow back through C function pointers.

```
Java user code        (ewt.api + examples)
      │  JDK 21 FFM (Project Panama)
C native bridge       (widgets/ — exports startApp + widget factories)
      │  function pointers / callbacks
Flutter / Dart        (widgets FFI plugin)
```

| Module                 | Language | Role                                                                   |
|------------------------|----------|------------------------------------------------------------------------|
| `ewt.api`              | Java     | Public API: widget base classes, generated builders, the FFM bridge    |
| `examples`             | Java     | Runnable example applications                                          |
| `generator`            | Dart     | Reads the Flutter widget catalog, emits Java builders and C headers     |
| `annotation-processor` | Java     | Patches Immutables-generated builders to extend `Widget`               |
| `widgets`              | Dart + C | Flutter FFI plugin; the native side the Java layer calls into          |

The Java builders are **generated** from Flutter's own widget definitions, so the
API tracks Flutter closely and grows by regenerating rather than hand-writing.

## Requirements

- **JDK 21+** (required for the Foreign Function & Memory API)
- **Flutter SDK** (to build the native `widgets` plugin)
- Gradle (via the bundled wrapper, `./gradlew`)

## Quick start

```bash
# Build the API: compiles Java, builds the Flutter native libraries
# (runs `flutter build`) and packages them into the jar.
./gradlew :ewt.api:build

# Run the test suite
./gradlew :ewt.api:test
```

The generated Java builders and FFM bindings are committed, so a fresh checkout
builds without regenerating. A plain `./gradlew build` builds every module but
does **not** run the code generator, so it will not pick up changes to the
Flutter widget set — regenerate first (see below) when you change them.

Point EWT at the built native libraries with the `EWT_HOME` environment variable
(or the `ewt.home` system property) before launching an example; loading falls
back to a bundled loader when unset.

## Project tooling

When you change the widget set, regenerate everything in one step:

```bash
./gradlew :generator:generator   # regenerate Java builders + C headers,
                                 # then ffigen (Dart FFI) and jextract (Java FFM)
```

`:generator:generator` also runs `:widgets:ffigen` and `:ewt.api:jextract`
automatically. Then rebuild the API to compile the regenerated sources:

```bash
./gradlew :ewt.api:build
```

`jextract` (v25) must be installed at `~/bin/jextract-25/bin/jextract`, and
Flutter must be available for the native build.

## Status

EWT is under active development. The widget catalog and platform packaging are
expanding; APIs may still change.

## License

EWT is licensed under the [Apache License 2.0](LICENSE). It is permissive and
patent-protective, and integrates cleanly with Eclipse RCP (EPL 2.0) and other
commercial or open-source software.

## Enterprise & Commercial Support

EWT is an open-source project, and we are committed to its growth and success.

For organizations building production applications, **Equo** offers commercial
products and professional services to accelerate your work and ensure project
success. Our offerings include:

- **Custom Widget Development** — bespoke UI components tailored to your specific
  business needs.
- **Theming & Custom Branding** — full visual customization to align the UI with
  your company's style guidelines.
- **Application Development Services** — let our team help you design and build
  your Java UI on EWT.
- **Equo SDK** — middleware and developer tools to build secure, efficient, and
  scalable Java applications.
- **Equo Chromium** — integrate a high-performance, modern Chromium-based browser
  directly into your Java app.
- **Signed & Notarized Binaries** — deploy with confidence using production-ready,
  signed binaries for all major platforms, including macOS notarization.
- **Dedicated Enterprise Support** — priority support channels, expert training,
  and defined SLAs for your mission-critical applications.

Ready to take your project to the next level? Contact our team at
**support@equo.dev** to learn more about Equo Enterprise.
