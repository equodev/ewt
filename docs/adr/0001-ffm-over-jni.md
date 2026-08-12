# Use JDK 22 Foreign Function & Memory API instead of JNI for native interop

EWT needs to call into Flutter's C layer (widget factories, `startApp`, upcall stubs) from Java. We chose the JDK 22 Panama Foreign Function & Memory (FFM) API over the traditional JNI bridge. FFM is type-safe at the boundary (no raw `long` handles), GC-friendly (no `GlobalRef` pinning for upcalls — `NativeCallable` handles lifecycle), requires no native `.c` glue code on the Java side, and its `jextract` tooling auto-generates the Java bindings directly from the C headers produced by the generator. JNI was ruled out because it requires hand-written JNI boilerplate or a secondary C wrapper, introduces GC pressure for upcall stubs, and provides no type safety at the interface boundary.

- **Status**: accepted
- **Date**: 2024-01-01
- **Deciders**: Equo EWT team

## Considered Options

| Option | Outcome |
|--------|---------|
| JNI with hand-written C glue | Rejected — boilerplate-heavy, unsafe types, GC pinning for callbacks |
| JNA (Java Native Access) | Rejected — reflection-based, slower, no upcall support without extra C |
| JDK 22 FFM (Panama) | **Chosen** — zero JNI boilerplate, type-safe, `jextract` auto-generates bindings from C headers |

## Consequences

- Minimum runtime is JDK 22 (FFM is stable only from Java 22). See also [ADR-0002](0002-jdk22-runtime-floor.md).
- `jextract` must be re-run whenever the C headers change (automated via the `:ewt.api:jextract` Gradle task).
- The `options.release = 22` compiler flag is set in `ewt.api/build.gradle.kts` to enforce the floor.
