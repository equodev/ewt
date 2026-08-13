# Use Immutables + custom annotation processor to make generated builders extend Widget

EWT's Java API needs fluent, type-safe, null-safe widget builders where every builder is a subtype of `Widget` (so `child(myWidget)` accepts any builder without an explicit `.build()` call). We chose Immutables to generate the immutable value types and fluent setters, combined with a custom annotation processor (`annotation-processor/`) that post-processes Immutables output to make each generated builder class extend `Widget`. Alternatives — hand-written builders, Java records, or plain data classes — were rejected: hand-written builders are prohibitively expensive for ~175 widgets, records lack the fluent setter style, and plain classes provide no null-safety guarantees at compile time.

- **Status**: accepted
- **Date**: 2024-01-01
- **Deciders**: Equo EWT team

## Considered Options

| Option | Outcome |
|--------|---------|
| Hand-written fluent builders | Rejected — ~175 widgets × full builder impl = high maintenance cost |
| Java records | Rejected — records are immutable by construction (no fluent setters); wither-style chains are verbose |
| Plain Immutables (no custom processor) | Rejected — generated classes don't extend `Widget`; forces explicit `.build()` everywhere |
| Immutables + custom annotation processor | **Chosen** — fluent setters, null-safety, and `Widget` subtyping with no hand-written code |

## Consequences

- `ewt.api` uses a two-pass Gradle compilation: `processCustom` (Immutables + processor) then `compileJava -proc:none`.
- Adding a new widget parameter type requires extending both the generator and possibly the annotation processor.
- Immutables version bumps must be verified against the custom processor's assumptions about generated class shape.
