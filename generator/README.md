# generator — EWT code generator

The Dart tool that generates [EWT](../README.md)'s Java widget API from Flutter's
own widget definitions. It uses the Dart [`analyzer`](https://pub.dev/packages/analyzer)
to introspect Flutter widget constructors and emits:

- fluent **Java builder classes** (into `ewt.api/src/main/java/dev/equo/ewt/`), and
- the matching **C header declarations** for the native bridge.

Because the API is generated rather than hand-written, it tracks Flutter closely
and grows by re-running the generator instead of writing boilerplate by hand.

## Entry points

| File                   | Role                                                          |
|------------------------|--------------------------------------------------------------|
| `bin/generator.dart`   | Main entry point: drives the full generation pipeline        |
| `bin/transpiler.dart`  | Transpiles Dart expressions/values to their Java equivalents |
| `lib/`                 | Generation logic (indexing, language writers, type mapping)  |

## Running

From the repository root:

```bash
./gradlew :generator:generator   # regenerate Java builders + C headers
```

## Tests

```bash
dart test
```

## License

Apache License 2.0 — see [../LICENSE](../LICENSE).
