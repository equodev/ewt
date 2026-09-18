---
name: modify-generator
description: Use when modifying the EWT generator itself — adding a new widget shape, refactoring emitters, changing type mappings, or debugging why a widget won't generate. Not for the common case of exposing a new Flutter widget (use `add-widget` for that).
---

# Modify the EWT Generator

## Overview

The generator (`ewt/generator/lib/`) is behavior-organized: divergent
widget shapes live in `emit/shape/`, the three FFI-bridge directions
share a `SerializeStrategy` template, and `Types.getGen` is the single
dispatch site that maps a Dart class to a generator. Any modification
must preserve those invariants and, more concretely, must keep the
snapshot test green — the generator's output IS the contract with
downstream `.java` / `.h` / `.dart` files.

Before starting, skim `docs/gen_structure.md` — §2 (generator internals:
emission pipeline, shape catalog, hooks) and §3 (testing & invariants)
are the prerequisites for this skill.

---

## When to invoke

Use this skill when you're doing any of these:

- Adding a new **widget shape** because an incoming widget has
  divergence no existing shape captures (e.g. a controller with
  imperative methods, a `.builder` factory that eager-expands, an
  abstract with public factory ctors, …).
- Refactoring one of the emitters (`emit/java_emitter.dart`,
  `emit/c_emitter.dart`, `emit/dart_emitter.dart`, `emit/web_emitter.dart`).
- Changing type resolution (`type_mapping.dart`, `types.dart`).
- Adding or reworking one of the serialize strategies
  (`emit/serialize/to_dart.dart`, `to_c.dart`, `to_json.dart`).
- Adding a new hook on `WidgetGen` that other shapes will override.
- Chasing a widget that WON'T generate — debugging silent skips,
  dropped widgets, or unsupported-type warnings.

**If you're just exposing a new Flutter widget that fits an existing
shape**, use `add-widget` instead. The line is: if you're editing
`generation_index.dart` you want `add-widget`; if you're editing
anything under `generator/lib/` you want this skill.

---

## Step 1 — Make sure the snapshot test is green

Before any change:

```bash
cd ewt/generator && dart test test/snapshot_test.dart
```

If it's red at the starting point, stop and figure out why. The whole
point of this skill is that snapshot tells you when your change did
something unexpected — if the baseline is already broken, that signal
is lost.

---

## Step 2 — Decide: existing shape, new hook, or new shape?

Walk the decision tree in this order:

**a) Does an existing shape (or a fallback) already cover it?**
See `docs/gen_structure.md` §2b for the catalog. Nine shapes today —
eight Java-side dispatched via `Types.getGen` (`SubStateGen`,
`SubAnimatedStateGen`, `TrackedSubWidgetGen`, `ImperativeControllerGen`,
`ColorSwatchGen`, `BuilderExpansionGen`, `DragTargetGen`,
`AbstractFactoryHostGen`) and one Dart-side pregeneration shape
(`UniqueKeyDefaulterGen`). Plus the fallbacks in `getGen`: any class
annotated `@Immutable` (directly or transitively) and non-abstract
routes to `ImmutableGen` — this handles most value types (`EdgeInsets`,
`BorderRadius`, `Duration`) with zero code changes. If your widget hits
an existing shape or the `ImmutableGen` fallback → add a case in
`Types.getGen` (or just let the fallback fire) and follow `add-widget`
from here.

**b) Can the shape be handled by an existing hook + new override?**
Look at the hook list in `docs/gen_structure.md` §2c. If a shape needs
one new hook (e.g. "widget needs to emit extra Java members before
`build()`" → `writeExtraJavaClassBody`), and no existing shape uses
that hook, consider whether adding the hook to `WidgetGen` (with a
no-op default) plus overriding it in a small new shape class is
enough.

**c) Genuinely new shape?**
Create a new file `emit/shape/<shape_name>_gen.dart` that extends the
appropriate base (`WidgetGen`, `ImmutableGen`, `SubclassGen`, or —
for Dart-side pregeneration shapes — `DartSubclassGen`) and overrides
the relevant hooks.

**Anti-pattern:** adding `if (widgetClass == 'X')` inside an emitter
file. The refactor removed all of those. Grep the codebase before
committing:

```bash
grep -rn "widgetClass\s*==\|factoryName\s*==" ewt/generator/lib/
```

Should return **zero** hits in code (docstrings that document the
pattern don't count).

---

## Step 3 — Wire it into `Types.getGen`

Single dispatch site (`generator/lib/types.dart:36`). It is a `switch`
grouped by behavior, followed by fallbacks:

```dart
AGen getGen(Element dartClass) {
  if (dartClass is ClassElement) {
    switch (dartClass.name) {
      // ... existing cases (SubState, AnimationController, ListView, …) ...
      case 'YourNewWidget':
        return YourNewShapeGen(this, dartClass);
    }
    // Fallback 1: @Immutable value types → ImmutableGen.
    if ((dartClass.hasImmutable || dartClass.allSupertypes.any((s) => s.element.hasImmutable))
        && !dartClass.isAbstract) {
      return ImmutableGen(this, dartClass);
    }
    // Fallback 2: everything else.
    return WidgetGen(this, dartClass);
  }
  // Enum / TypeParameter branches below …
}
```

The switch is deliberately grouped by shape, not by widget name — one
shape can absorb many widgets. If a shape class fits several widget
names, list them together in the switch (see how `SubStatefulWidget` /
`SubStatelessWidget` both route to `TrackedSubWidgetGen`).

For most value types you do **not** need to add a switch case at all —
the `ImmutableGen` fallback catches any `@Immutable`-annotated,
non-abstract class. Only add a case when a widget needs a different
shape than that default.

Do NOT add structural predicates (like `if (c.allSupertypes.any(...))`)
to `getGen` without an explicit review of every widget in
`generation_index.dart` that would newly match — see the "structural
predicates" anti-pattern in `docs/gen_structure.md` §3c
(`MaterialAccentColor` was silently rerouted into `ColorSwatchGen` by
exactly this pattern).

The `UniqueKeyDefaulterGen` shape is NOT reached via `getGen` — it's a
Dart-side pregeneration shape wired from `DartSubclassGen.forWidget`.
If your new shape lives on the Dart pregeneration side, you're wiring
it there instead.

---

## Step 4 — Add the `part` directive

New shape file must be registered in `gen.dart` as a part:

```dart
part 'emit/shape/your_new_shape_gen.dart';
```

Alphabetical order with the other `part 'emit/shape/...'` lines.

---

## Step 5 — Run the snapshot test

```bash
cd ewt/generator && dart test test/snapshot_test.dart
```

Three outcomes:

**Green.** Your change preserves byte-for-byte output. Good — commit.

**Red on files related to your change.** Expected if the change
intentionally alters emitted code for widgets that route through the
new shape. Refresh snapshots:

```bash
cd ewt/generator && dart run tool/update_snapshots.dart
```

Then re-run the test to confirm green. Commit the snapshot diff and
the tracked `.java` diffs together — reviewers see the byte-level
consequence.

**Red on files unrelated to your change.** Something else regressed.
STOP. Do not update snapshots — figure out what's wrong. Common
causes:

- Your predicate matched a widget you didn't expect (see F7.5
  precedent).
- A hook default changed and a widget that used it drifted.
- Types.getGen dispatch order matters — you moved a case above/below
  where it needed to be.

---

## Step 6 — Full pipeline check

```bash
cd ewt
rm -f generator/build/pregeneration_index.dart.ts
JAVA_HOME=~/bin/jdk-22 ./gradlew :generator:generator
JAVA_HOME=~/bin/jdk-22 ./gradlew :ewt.api:jar -PuseLocal=true
```

Both must pass. If the Java build fails but the snapshot passes, the
issue is downstream (annotation processor, jextract) — usually because
`ImmutableGen.writeJavaConstructors` shape changed and
`BuilderModifierProcessor` no longer recognizes the pattern. Check
`annotation-processor/src/main/java/dev/equo/ewt/processor/BuilderModifierProcessor.java`.

---

## Step 7 — Strict-mode audit

```bash
cd ewt/generator && rm -f build/pregeneration_index.dart.ts && \
  dart run bin/generator.dart --strict
```

Exit code 1 means at least one `warn:` fired. If a widget dropped
because of your change, that's a regression — the shape should either
absorb it or you should be conscious about a widget dropping.

---

## Anti-patterns

- **`widgetClass == 'X'`** inside an emitter. Push it to `Types.getGen`
  + a shape override.
- **`factoryName == 'X'`** inside an emitter. Same fix.
- **Duplicating kind dispatch across serialize strategies.** All three
  (`FfiToDart`, `DartToC`, `JsonToDart`) share the `dispatchInterface`
  template method in `SerializeStrategy`. If you find yourself writing
  `if (t.isDartCoreString) ... if (t.isDartCoreBool) ...` in a strategy
  file, you're in the wrong layer.
- **Adding an unused parameter "for future".** `_inlinePrivateRefs` in
  `Params` deliberately does NOT take a `visited` set today because
  it's not recursive. Add the parameter when you make it recursive,
  not before — dead code muddles the invariant.
- **`print()` for warnings.** Use `warn(...)` from `lib/diagnostics.dart`
  so `--strict` catches them and CI can surface them.
- **Editing generated files.** `ewt.api/src/main/java/dev/equo/ewt/*.java`
  are committed (per-widget baselines for the snapshot test) but they
  are outputs, not sources. Edit the generator that produced them.
- **Hardcoding widget names in helpers.** If a helper needs to know
  something about a widget, expose it via a hook on `WidgetGen` and let
  the shape override.

---

## Debugging a widget that won't generate

Symptoms: after adding to `generation_index.dart`, the widget doesn't
appear in `EWT.java`, its `.java` file is stub-only, or the build fails
with a missing symbol.

1. **Run `--strict`.** The `warn:` line names the specific gap
   (unsupported type, dropped widget).
2. **Find the type in `docs/gen_structure.md` §4** (deferred widgets).
   If it's listed, follow the "To enable" note.
3. **Grep `warn: unsupported type: <T>`** — if `<T>` isn't in §4, add
   it. Understanding a new gap is part of closing it.
4. **Check whether the widget's shape matches one of the nine.** If
   it looks like an existing shape but isn't routed, the `getGen` case
   may be missing — or the `@Immutable` fallback isn't firing because
   the widget is `abstract` or lacks the annotation.
5. **Set breakpoints in `Types.getGen` and `WidgetGen.gen`** if a
   widget is silently going down the WidgetGen fallback but shouldn't.

---

## Commit hygiene

Commits that touch the generator should include:

- The generator change itself (`generator/lib/**/*.dart`).
- The updated snapshot references (`generator/test/snapshots/*`) — if
  the change was intentional. Same commit.
- The tracked outputs (`ewt.api/src/main/java/dev/equo/ewt/*.java`,
  `widgets_web/lib/factories_web_gen.dart`) — same commit.
- A commit message explaining the SHAPE (why the change) not just the
  file diff.

Do NOT split the generator change and the snapshot refresh into
separate commits. The reviewer needs to see the code change and the
byte-level output side-by-side.
