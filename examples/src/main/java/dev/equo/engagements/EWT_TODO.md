# EWT gaps hit while building the Engagements Console POC

These are widgets or behaviors the sample would use idiomatically but the current
`ewt.api` catalog does not expose in a usable form. Each gap has a note on what
had to be substituted so the demo could ship.

## Missing widgets / APIs

- **`CallbackShortcuts` / `Shortcuts` / `Actions`** — not generated. Ctrl+K
  (open command palette) and Ctrl+W (close active engagement tab) had to be
  reduced to AppBar buttons. `KeyboardListener` is emitted but its `onKeyEvent`
  callback is not, so it can't drive shortcuts either.
- **`DropdownMenu`** (top-level Material 3) — only `DropdownMenuEntry` is
  generated. The Log-Time dialog and wizard use `MenuAnchor` + `MenuItemButton`
  as a substitute.
- **`SharedAppData`** — not generated. AppState is threaded through by
  constructor instead. This works but every screen has to remember to register
  / unregister on `AppState.addDataListener`.
- **`showDatePicker`** — the wizard's date fields fall back to a
  parse-on-change `TextField(LocalDate)` because there's no exposed pattern
  for the standard Material date picker.
- **`TabBar.onTap`** — not generated on `TabBar` nor on
  `DefaultTabController`. Programmatic switches work via `initialIndex`, but
  user tab clicks don't propagate to Java, so `AppState.activeTabIndex` is
  a "programmatic-set" hint only.

## Small friction points (not blockers)

- `IconButton` inside a `Tab.child` is expected to catch its own tap before
  the tab-select gesture; if it doesn't, the tab-close X will race with tab
  selection. Verify visually.
- `Card.outlined()` renders with a subtle default shadow even at
  `elevation(0.0)` — the editorial look required also setting a hairline
  container border in most places.
- `Chip` doesn't expose `.side(null)`; the default border shape is close
  enough to be acceptable, but we can't force a truly borderless chip.
- `ExpansionTile` doesn't take a Java-side `onExpansionChanged` callback in
  the generated builder, so app state can't track "which weeks are open".
