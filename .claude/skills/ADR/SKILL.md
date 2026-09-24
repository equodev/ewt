---
name: ADR
description: >-
  Capture an Architecture Decision Record from the current session into
  docs/adr/. Invoke when the user types /ADR, and proactively (without being
  asked) the moment a genuine architectural or design decision is made during
  the session — a choice that is hard to reverse, surprising without context,
  and the result of a real trade-off between alternatives.
---

# ADR — Architecture Decision Record logger

Record durable architectural/design decisions made during a session as Markdown
files under `docs/adr/`.

## When this skill runs

- **Explicitly**: the user types `/ADR` (optionally naming which decision).
- **Proactively**: you (Claude) notice a qualifying decision was just made in
  the session and offer to log it — even if the user did not ask. Do not write
  the file silently in the proactive case: state the decision you detected, why
  it qualifies, and ask the user to confirm before creating the file. The user
  is always free to say no.

## The 3-condition test (ALL must hold)

Only write an ADR if the decision satisfies **every** one of these. If even one
is missing, do **not** create a file — explain which condition failed.

1. **Hard to reverse** — the cost of changing your mind later is meaningful
   (data migrations, public API/contract changes, framework/library lock-in,
   wire/serialization formats, build-pipeline shape, generator architecture).
2. **Surprising without context** — a future reader will wonder "why did they
   do it this way?" The choice is non-obvious or goes against the default.
3. **Result of a real trade-off** — there were genuine alternatives and one was
   picked for specific reasons. A forced move with no alternative is not an ADR.

Things that are NOT ADRs (skip them): routine bug fixes, renames, formatting,
obvious/only-option choices, reversible local refactors, dependency version
bumps, and anything fully explained by the code or git history.

## Procedure

1. **Scan the session context** for decisions made (not hypotheticals, not
   things merely discussed and rejected). A single session may contain zero,
   one, or several qualifying decisions.

2. **Apply the 3-condition test** to each candidate.
   - If **no** candidate passes: write nothing. Tell the user no qualifying
     architectural decision was found, and for the closest candidate name which
     of the 3 conditions it fails. Stop here.
   - If one or more pass: continue.

3. **Read the format**: read [ADR-FORMAT.md](ADR-FORMAT.md) and follow
   its structure exactly for the file body.

4. **Choose the folder**: all EWT decisions go under `docs/adr/` in the ewt
   subproject. Create the folder if needed.

5. **Determine the next number**: the next number is the highest existing
   `NNNN-` prefix + 1, using 4-digit zero-padding (e.g. `0001`, `0002`).
   Start at `0001` if the folder is empty.

6. **Name the file**: `docs/adr/NNNN-short-kebab-title.md`, where the title is
   a concise slug of the decision (e.g. `docs/adr/0001-ffm-over-jni.md`).

7. **Write one file per qualifying decision.** If several decisions qualify,
   number them sequentially and create each file.

8. **Report back**: list the file(s) created with their full path and a
   one-line summary each. If you skipped any near-miss candidate, say so and why.

## Notes

- Keep ADRs factual and grounded in what actually happened in the session —
  quote the real alternatives that were weighed and the specific reasons the
  chosen option won. Do not invent trade-offs that were not discussed.
- ADRs are immutable history. To revise a past decision, write a new ADR that
  supersedes the old one (reference it) rather than editing the old file.
- This is a documentation action, not a code change — but creating files is
  outward-facing, so in the proactive (unprompted) path always confirm first.
