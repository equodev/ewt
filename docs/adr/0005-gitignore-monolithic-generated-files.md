# Gitignore the monolithic generated files instead of committing per-widget files

The generator emits three large monolithic files (`factories_gen.dart`, `factories.h`, and the jextract Java FFM package) that change entirely whenever any widget is added or removed. We chose to gitignore them rather than committing them, even though generated files are typically committed. The core reason: because these are monolithic (not per-widget), every branch that adds a widget produces a complete replacement of the file — any two branches adding different widgets produce a merge conflict that requires fully re-running the generator to resolve, making parallel widget work impractical. Gitignoring them means the generator must be re-run after every checkout, but that is a `./gradlew :generator:generator` one-liner and is already required to verify the build.

- **Status**: accepted
- **Date**: 2024-01-01
- **Deciders**: Equo EWT team

## Considered Options

| Option | Outcome |
|--------|---------|
| Commit monolithic generated files | Rejected — every parallel branch produces an unreducible merge conflict on the same file |
| Split into per-widget files and commit | Rejected — would require the generator to emit N files and track deletions; adds significant generator complexity |
| Gitignore monolithic files (must run generator after checkout) | **Chosen** — no merge conflicts; one command (`./gradlew :generator:generator`) restores the artifacts |

## Consequences

- A fresh checkout will not compile until the generator is run; this is documented in `CLAUDE.md`.
- CI must run the generator as a build step before compiling `ewt.api`.
- The pregeneration cache (`generator/build/pregeneration_index.dart.ts`) is also gitignored and must be deleted when `generation_index.dart` changes.
