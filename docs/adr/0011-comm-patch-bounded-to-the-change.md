# A comm update is bounded to what changed: replace, splice, and a diff on every publish

On the comm transport the Java side captures the region's node tree and the browser retains the last one it decoded. Until now only a value-only change travelled as a patch: any change of shape anywhere — a widget swapped for another, a param set or cleared, a list with one row more or less — made the diff give up and the whole region went out again as a full snapshot. And `setWidget`, the way an app re-sends its page after a state change, always sent the full snapshot, diff or not. For a page of 75 rows (~70 KB) that meant 70 KB per click, and a filter or a search character re-sent the table it had just filtered.

We chose to keep the diff positional but make it local: a nested node that changed shape is replaced on its own (`ReplaceOp`, the subtree travels, nothing above it does), a list of nodes that changed length is aligned by node signature and the runs that differ become splices (`SpliceOp`: remove / insert at an index), and only a root that changed shape is still a full snapshot. `setWidget` on a region that already published diffs against the retained tree like a rebuild does. The browser applies the ops in order — splices, then param sets, then replacements — so the paths of the later ops index the lists as the splices left them, and asks for a full resend if any path fails to resolve, as before.

Node ids are renumbered on every capture and a callback is an int id in the same numbering, so a removed row shifts the ids of every node built after it. That is deliberate: the shifted ids are ordinary changed params and travel as setParams ops on the matched rows, which keeps the browser's callback ids equal to Java's without a stable-id scheme. The list alignment therefore keys on a node's type, strings, booleans and doubles (and the same of its children), never on an int.

- **Status**: accepted
- **Date**: 2026-10-06
- **Deciders**: Equo EWT team

## Considered Options

| Option | Outcome |
|--------|---------|
| Stable node ids across captures (keyed by Java object identity), diff by id | Rejected for now — ids are assigned inside the generated serializer in construction order, callbacks are numbered the same way, and both would have to change together; the positional diff with replace + splice reaches the same bytes for the pages measured |
| Replace the smallest node that changed shape, resend nothing above it | **Chosen** |
| Replace the list owner when a list changed length | Not enough — a filter on a 75-row table still re-sent 56 KB of the 58 KB; superseded by the splice |
| Align lists by signature and splice | **Chosen** — the same filter sends 5.8 KB, a search character 2.2 KB |
| Keep `setWidget` as a full snapshot | Rejected — it is how the measured customer page updates, so the diff would never have applied to it |

## Consequences

- Measured on a synthetic 75-row page (Java encode only): select a row 70,369 B → 118 B; a stat text 70,363 B → 131 B; filter 58,544 B → 5,802 B; search 14,523 B → 2,185 B; encode time stays under 1 ms (the alignment adds ~0.5 ms on 75 rows). Lists longer than 2,000 on both sides are spliced whole instead of aligned.
- A map-valued param (a `MaterialColor` swatch, a map of colour nodes) is walked by key, not compared by `equals`: nodes are never equal by `equals`, so a page re-sent unchanged carried every icon's swatch again (103 KB of a 147 KB page in a real view) until this was added.
- Measured on a customer view (75 UVM components, web, Java 17 so the comm path) against the shipped 0.1.8: a page re-sent unchanged 147 KB → 0 B; a role-filter toggle 38 KB → 21 KB (filter on) and 144 KB → 126 KB (filter off, the hierarchy tree is rebuilt); a section switch 688 KB → 685 KB, because the content really is replaced. The diff bounds what travels to what changed; it cannot shrink a change that is the whole page.
- `widgets_web/lib/patch.dart` understands the three op kinds; a browser running an older `widgets_web` against a newer Java would fail to resolve a `node`/`list` op and request a full resend, so the two sides degrade to today's behaviour rather than desync.
- The web region keeps re-decoding the whole retained map once per applied patch (then retains it, see [ADR-0010](0010-region-retains-built-subtree.md)); decoding only the nodes a patch touched is the next step if a measurement asks for it.
- `SubState.setState` rebuilds are now coalesced into one capture per turn of the display thread; animation commands issued while one is queued are held until the tree they may refer to has been published.
