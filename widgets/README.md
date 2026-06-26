# widgets — EWT Flutter FFI plugin

The native layer of [EWT](../README.md). This is a Flutter
[FFI plugin](https://flutter.dev/to/ffi-package) that exposes the Flutter engine
to the Java side over a C boundary, so Java code can build and drive a real
Flutter widget tree.

## Role in the stack

```
ewt.api (Java)  →  FFM bridge  →  this plugin (C + Dart)  →  Flutter engine
```

The C side exports `startApp` and a set of widget factory functions; the Dart
side receives widget-tree callbacks through C function pointers and renders them
with Flutter.

## Layout

| Path        | Contents                                                            |
|-------------|---------------------------------------------------------------------|
| `src/`      | Native C sources and `CMakeLists.txt` (built into a shared library) |
| `lib/`      | Dart code defining the plugin API and the `dart:ffi` bindings       |
| `tool/`     | Generation helpers                                                  |
| `example/`  | Minimal Flutter host used to build and exercise the native library  |

## Regenerating the FFI bindings

The Dart FFI bindings are generated from the C headers with
[`ffigen`](https://pub.dev/packages/ffigen). From the repository root:

```bash
./gradlew :widgets:ffigen
```

Configuration lives in [`ffigen.yaml`](ffigen.yaml).

## License

Apache License 2.0 — see [LICENSE](LICENSE).
