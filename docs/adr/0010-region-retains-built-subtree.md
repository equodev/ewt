# An EWT region retains its built subtree; only Java invalidates it

An `EwtWidget` region is a node in Evolve's Flutter tree, and Evolve rebuilds that tree freely: a bounds-only diff on a control, a Sash drag relaying out a workbench, any ancestor Composite re-running `build()`. The region's `build()` used to reconstruct its whole EWT subtree on each of those rebuilds — on FFM by re-running the Java builder (one native call per widget, inside the upcall, on the Flutter thread), on comm by decoding the whole retained node map again. None of that changes what the subtree shows, and with many regions under a dragged Sash it made resizing crawl. The cost scaled with the size of the EWT content, not with what changed.

We chose to make the region retain the Widget it built and hand the identical instance back on every later build, so Flutter skips the subtree (`Element.updateChild` short-circuits on an identical widget). The subtree is rebuilt only when its content can actually have changed: Java registered a new builder (`setWidget`, announced on `EwtWidget/<id>/rebuild`), a new node tree arrived over comm, an inherited dependency the build read changed (a Theme swap), or the app reassembled (hot reload). `SubState.setState` needs no region rebuild on either transport: on FFM it reaches the Dart `State` directly, on comm it arrives as a new node tree.

- **Status**: accepted
- **Date**: 2026-10-06
- **Deciders**: Equo EWT team

## Considered Options

| Option | Outcome |
|--------|---------|
| Keep Evolve from rebuilding the region (skip `setState` on bounds-only diffs in Evolve) | Not sufficient on its own — a parent Composite's rebuild still re-creates the region's widget, and Evolve should not need to know what an EWT region costs to build |
| Make the FFM build cheap enough to re-run every time (drop the per-widget `print`, pool the arena) | Worth doing, but still linear in the subtree size on every Evolve rebuild; comm would still decode the whole map |
| Retain the built subtree in the region; Java drives invalidation | **Chosen** — a parent rebuild costs nothing in the region regardless of transport; content changes still flow from Java as before |

## Consequences

- `widgets_web/lib/retained_subtree.dart` holds the mechanism (`EwtRetainedSubtree`, keyed by a `generation` the region bumps); both the FFM region and the comm region wrap their subtree in it.
- On FFM, `EwtWidget.setWidget` now sends `EwtWidget/<id>/rebuild` after `App.registerBuilder`, so a second `setWidget` on a live region refreshes it (before, the repeated `"ffm"` transport announcement was ignored as unchanged and the region stayed stale until Evolve happened to rebuild it).
- A Java root that mutates its own fields without `setState` or a new `setWidget` is no longer refreshed as a side effect of Evolve's rebuilds. That refresh was accidental; content changes must go through `SubState.setState` or `setWidget`.
- The per-widget `print('Added widget ...')` in `factories.dart` is gone: it ran once per widget on every build.
- Still open on the Evolve side (tracked separately): Sash `Selection` is sent on every pan update without coalescing, and a bounds-only diff still triggers `setState` on the moved control.
