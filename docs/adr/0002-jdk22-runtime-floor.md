# Set JDK 22 as the minimum runtime floor

EWT's FFM-based native bridge (see [ADR-0001](0001-ffm-over-jni.md)) requires APIs that are only stable from JDK 22. We set `options.release = 22` in `ewt.api/build.gradle.kts` as a hard compile-time floor rather than configuring a JDK 22 toolchain, because CI runs JDK 23 and a toolchain declaration would require the CI image to carry a separate JDK 22 installation. The `options.release` flag enforces source/target compatibility without requiring an exact-version toolchain.

- **Status**: accepted
- **Date**: 2024-01-01
- **Deciders**: Equo EWT team

## Consequences

- `jextract 25` emits `findOrThrow()` (JDK 23+); the `:ewt.api:jextract` task auto-rewrites these calls to `find().get()` so the output compiles under `--release 22`.
- Any API added to EWT must be compatible with JDK 22 at the source level.
