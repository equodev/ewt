# Single shared Flutter engine with dual transports for EWT + Evolve same-surface composition

When an EWT widget is embedded inside an Evolve/SWT window, both systems drive the same Flutter surface. We chose to host both inside a single Flutter engine rather than running separate engines (the "island" model). Inside the single engine, the two systems keep their own transports: Evolve drives its widget tree via WebSocket + comm (serialized widgets), while EWT drives its subtree via FFM (direct C function calls). Each system writes to a different region of the shared widget tree, so they never conflict.

This decision was made on **2026-06-29**, reversing the original approach. The initial design (2026-06-27) chose to route EWT through Evolve's comm — serializing EWT widget trees as JSON (`VEwt*`) and sending them over the same WebSocket — so that EWT would work on both desktop and web from a single backend. When web support was parked as a current goal, the motivation for the comm path disappeared. Keeping FFM won: it is significantly faster (no serialization), reuses EWT's entire existing Dart widget layer as-is, and both transports can coexist in one engine because they mutate disjoint tree regions.

- **Status**: accepted
- **Date**: 2026-06-29
- **Deciders**: Equo EWT team

## Considered Options

| Option | Outcome |
|--------|---------|
| Island model — separate Flutter engine per EWT region | Rejected — no true same-surface composition; EWT would overlay rather than integrate |
| Single engine, declarative-over-comm — EWT serializes its tree as `VEwt*` JSON over Evolve's WebSocket | Not chosen for desktop — adds serialization overhead with no benefit when FFM is available. Used instead for the web case; see [ADR-0008](0008-ewt-web-transport-via-evolve-comm.md). |
| Single engine, dual transports — FFM for EWT, comm for Evolve | **Chosen** — each system keeps its own transport; they coexist by writing to disjoint tree regions; no serialization overhead on EWT's path |

## Consequences

- Each `EwtWidget` region registers its builder via `App.registerBuilder(regionId, builder)`; the single FFM upcall dispatcher routes by `regionId`.
- EWT widget sizes must be communicated to Evolve's layout via `setPreferredSize()` (Flutter cannot expose layout results synchronously to the SWT side).
- Oversized EWT content is clipped with `ClipRect` to prevent overlap with adjacent Evolve widgets.
- When running inside Evolve in **web mode**, FFM is not available; EWT switches to Evolve's comm transport instead. See [ADR-0008](0008-ewt-web-transport-via-evolve-comm.md).
- See [ADR-0006](0006-ewt-owns-combined-flutter-binary.md) for how both Dart codebases are compiled into one binary.
