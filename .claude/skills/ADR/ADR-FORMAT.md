# ADR Format

Every Architecture Decision Record under `docs/adr/` follows the structure below.
File name: `docs/adr/NNNN-short-kebab-title.md` (4-digit zero-padded, sequential).

## Template

```md
# {Short title of the decision}

{1-3 sentences: what's the context, what did we decide, and why.}

- **Status**: `accepted | deprecated | superseded by [ADR-NNNN](NNNN-...md)`
- **Date**: YYYY-MM-DD
- **Deciders**: <who made the call, default to current user>
```

That's it. An ADR can be a single paragraph. The value is in recording *that* a decision was made and *why* — not in filling out sections.

## Optional sections

Only include these when they add genuine value. Most ADRs won't need them.

- **Considered Options** — only when the rejected alternatives are worth remembering
- **Consequences** — only when non-obvious downstream effects need to be called out
