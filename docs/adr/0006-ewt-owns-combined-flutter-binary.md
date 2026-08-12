# EWT owns the combined Flutter binary for the Evolve integration (EWT → Evolve dependency)

When integrating EWT into an SWT Evolve window on the same Flutter surface, both systems need to run inside one Flutter engine. That engine's compiled binary (`libapp.so`) must contain the Dart code of both projects. We chose EWT to own this binary (the `evolve-app/` Flutter project lives inside the EWT repo and depends on Evolve's `flutter-lib`) rather than Evolve owning it. The reason is size asymmetry: EWT's widget layer is large (hundreds of widget factories), so shipping EWT as a dependency inside Evolve would bloat every Evolve distribution regardless of whether EWT is used. The inverse direction (Evolve-in-EWT) adds negligible size because Evolve's Dart library is small relative to EWT's widget set.

- **Status**: accepted
- **Date**: 2026-07-02
- **Deciders**: Equo EWT team

## Considered Options

| Option | Outcome |
|--------|---------|
| Evolve owns the binary (Evolve → EWT dep) | Rejected — EWT is large; every Evolve distribution would carry EWT even when unused |
| EWT owns the binary (EWT → Evolve dep) | **Chosen** — Evolve's Dart library is small; `evolve-app/pubspec.yaml` depends on `swtflutter`; combined binary is ≈ EWT-only size |
| Separate engines per system (island mode) | Rejected — prevents same-surface composition; EWT regions can't share the SWT window chrome with Evolve widgets |

## Consequences

- `evolve-app/` must be rebuilt (`flutter build linux --release`) after any change to EWT's Dart layer or Evolve's `flutter-lib`.
- The Evolve version pinned in `evolve-app/pubspec.yaml` must be kept in sync with the Evolve runtime used by the consuming application.
- When Evolve publishes a breaking Dart API change, the combined binary breaks and EWT must update `evolve-app/` before shipping.
- See [ADR-0007](0007-single-engine-dual-transports.md) for how EWT and Evolve coexist inside the single engine without conflicts.
