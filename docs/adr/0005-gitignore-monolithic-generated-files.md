# Gitignore the monolithic generated files, but commit per-widget generated files

The generator emits generated code in two shapes, and each shape gets a different
policy. Files that aggregate all widgets in one blob (`factories_gen.dart`,
`factories.h`, `objects.h`, `typedefs.h`, the jextract Java FFM package,
`subwidgets.dart`, and the test-side `WidgetVariantsRegistry.java`) are
**gitignored** — they change entirely whenever any widget is added or removed,
so every parallel widget-adding branch produces a complete replacement of the
same file, which guarantees an unreducible merge conflict at MR time. Files
that are emitted per-widget (`ewt.api/src/test/java/dev/equo/ewt/support/variants/*Variants.java`
— one file per widget, ~40–100 LOC each, only reference that widget's schema)
are **committed** — they are per-widget stable, so parallel branches touch
disjoint files with no conflict, and the git history retains historical test
surface, working bisection, useful review diffs, and IDE autocomplete on
fresh checkout.

- **Status**: accepted
- **Date**: 2024-01-01 (initial) / 2026-09-07 (revised for per-widget split)
- **Deciders**: Equo EWT team

## Considered Options

| Option | Outcome |
|--------|---------|
| Commit every generated file, including monolithic aggregators | Rejected — every parallel branch produces an unreducible merge conflict on the same aggregator file |
| Gitignore every generated file, including per-widget ones | Rejected (2026-09-07) — over-inclusive: `*Variants.java` are per-widget stable and gitignoring them loses bisect, review UX, and fresh-checkout IDE tooling for no conflict-avoidance benefit |
| Gitignore only monolithic aggregators; commit per-widget files | **Chosen** — no merge conflicts on the aggregators, and the per-widget files behave like ordinary source in git |

## What is gitignored

Aggregators that any widget-adding branch rewrites in full:

- `widgets/src/factories.h`, `objects.h`, `typedefs.h`
- `widgets/lib/factories_gen.dart`
- `widgets/lib/subwidgets.dart`, `generator/lib/subwidgets.dart`
- `widgets/lib/widgets_bindings_generated.dart`
- `ewt.api/src/main/java/dev/equo/ewt/ffm/` (jextract output)
- `ewt.api/src/test/java/dev/equo/ewt/support/variants/WidgetVariantsRegistry.java`

## What is committed

Per-widget generated files. Currently:

- `ewt.api/src/test/java/dev/equo/ewt/support/variants/*Variants.java` — one
  file per widget, referenced by `WidgetVariantsRegistry.java` (still gitignored)
  via method references.

## Consequences

- A fresh checkout still requires running the generator before the build
  compiles (the aggregators are gone) — this is documented in `CLAUDE.md`.
- CI must run the generator as a build step before compiling `ewt.api`.
- The pregeneration cache (`generator/build/pregeneration_index.dart.ts`) is
  also gitignored and must be deleted when `generation_index.dart` changes.
- Per-widget generated files are diffable in MR review — reviewers see
  exactly which test variants a widget introduces.
- `git bisect` works across the per-widget test surface without needing to
  regenerate at each candidate commit.
- Follow-up: `WidgetVariantsRegistry.java` is the last remaining monolithic
  aggregator on the test side. Removing it entirely by switching to
  classpath discovery (`ServiceLoader`) is tracked in equo/ewt#55; once that
  lands, this section can drop the last bullet from "What is gitignored".
