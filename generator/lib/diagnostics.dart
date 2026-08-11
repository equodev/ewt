import 'dart:io';

/// Uniform reporter for non-fatal issues the generator encounters.
///
/// Before F6, "silent skips" — an unsupported type, a widget dropped
/// because no factory could be emitted — used bare `print(...)` to stdout,
/// where they mixed into the informational "Generating $file" stream and
/// were easy to miss. That made `docs/coverage.md` occasionally lie about
/// which widgets are actually generated.
///
/// Now those go through [warn] which writes to **stderr** with a "warn:"
/// prefix. CI logs surface them; a caller can also flip [strict] and each
/// warn escalates to a non-zero exit at the end of generation.
///
/// Kept as top-level functions rather than a class because the generator
/// is a one-shot script — there is nothing to inject a reporter into.
class Diagnostics {
  /// Non-zero exit at the end of a run if any warn fired. Callers flip this
  /// at startup (e.g. from a `--strict` CLI flag) BEFORE the generation
  /// begins. Default: false (warns are advisory).
  static bool strict = false;

  /// Whether any [warn] has fired during this generator run. Consulted by
  /// the entry point after generation completes so `--strict` can exit
  /// non-zero without disrupting mid-run state.
  static bool get warned => _warned;
  static bool _warned = false;

  /// Reset the fired-warnings flag. Useful for tests that re-run
  /// generation in-process.
  static void reset() {
    _warned = false;
  }
}

/// Report a non-fatal issue. Writes to stderr; sets [Diagnostics.warned].
void warn(String message) {
  Diagnostics._warned = true;
  stderr.writeln('warn: $message');
}

/// Report a fatal issue. Writes to stderr and returns; the caller decides
/// whether to `exit()`. Kept as a first-class helper so error reporting
/// looks structurally identical to [warn].
void error(String message) {
  stderr.writeln('error: $message');
}
