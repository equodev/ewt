// Compares the coverage the generator just produced against a baseline and
// fails when it got *worse*.
//
//   dart tool/coverage_gate.dart <baseline.json> [current.json]
//
// `current` defaults to build/coverage_status.json — the file the generator
// writes. `baseline` is the same file as it exists on the default branch; CI
// downloads it from the API so a branch cannot move its own goalposts.
//
// Locally:
//
//   git show origin/main:generator/test/snapshots/coverage_status.json > /tmp/base.json
//   dart run bin/generator.dart && dart tool/coverage_gate.dart /tmp/base.json
//
// ## What counts as a regression (exit 1)
//
//   * a widget that could be instantiated no longer can;
//   * a constructor that was emitted no longer is;
//   * a property that had a Java setter no longer has one;
//   * a property that worked on the web backend is now inert there.
//
// ## What does not (exit 0)
//
//   * anything that improved;
//   * a *new* widget that lands incomplete. It is reported prominently, but a
//     partially-exposed widget is still net progress, and failing on it would
//     make the job noise that everyone learns to ignore. Pass --strict-new to
//     turn those into failures too.
//   * a widget that disappeared — removing one from generation_index.dart is a
//     deliberate act, not a regression.
//
// ## Infrastructure problems never fail the gate
//
// A missing, empty or malformed baseline exits 0 with a warning. The gate is
// there to catch coverage regressions, not to break pipelines when the API call
// that fetches the baseline hiccups. Only a missing *current* file is fatal,
// and that means the generator itself did not run.

import 'dart:convert';
import 'dart:io';

Future<void> main(List<String> args) async {
  final strictNew = args.contains('--strict-new');
  final positional = args.where((a) => !a.startsWith('--')).toList();
  if (positional.isEmpty) {
    stderr.writeln('usage: dart tool/coverage_gate.dart <baseline.json> [current.json] '
        '[--strict-new]');
    exit(2);
  }
  final baselinePath = positional[0];
  final currentPath = positional.length > 1 ? positional[1] : 'build/coverage_status.json';

  final current = _read(currentPath);
  if (current == null) {
    stderr.writeln('error: $currentPath not found or unreadable — did the generator run?');
    exit(1);
  }
  final baseline = _read(baselinePath);
  if (baseline == null) {
    stdout.writeln('coverage gate: no usable baseline at $baselinePath — skipping.');
    stdout.writeln('  (expected the first time, or when the API call that fetches it fails)');
    exit(0);
  }

  final result = compare(baseline, current);
  stdout.write(result.report(strictNew: strictNew));
  exit(result.failed(strictNew: strictNew) ? 1 : 0);
}

/// One thing that changed between the two reports.
class Change {
  final String widget;
  final String detail;

  Change(this.widget, this.detail);

  @override
  String toString() => '$widget — $detail';
}

class GateResult {
  final List<Change> regressions = [];
  final List<Change> newIncomplete = [];
  final List<Change> improvements = [];

  bool failed({required bool strictNew}) =>
      regressions.isNotEmpty || (strictNew && newIncomplete.isNotEmpty);

  String report({required bool strictNew}) {
    final b = StringBuffer();
    void section(String title, List<Change> items) {
      if (items.isEmpty) return;
      b.writeln(title);
      for (final c in items) {
        b.writeln('  $c');
      }
      b.writeln();
    }

    section('REGRESSIONS (${regressions.length}) — coverage got worse:', regressions);
    section(
        'NEW WIDGETS LANDING INCOMPLETE (${newIncomplete.length})'
        '${strictNew ? ' — failing because of --strict-new:' : ' — not a failure, but worth a look:'}',
        newIncomplete);
    section('IMPROVEMENTS (${improvements.length}):', improvements);
    if (regressions.isEmpty && newIncomplete.isEmpty && improvements.isEmpty) {
      b.writeln('coverage gate: no change.');
    } else if (regressions.isEmpty) {
      b.writeln('coverage gate: no regressions.');
    } else {
      b.writeln('coverage gate: ${regressions.length} regression(s).');
    }
    return b.toString();
  }
}

/// Diffs two `coverage_status.json` documents.
///
/// Both are `{widget: {hasFactory, factories: [...]}}`. Every lookup is
/// defensive: a field missing from either side is treated as absent rather
/// than throwing, so an older baseline written by a previous version of the
/// generator degrades to fewer findings instead of crashing the job.
GateResult compare(Map<String, dynamic> baseline, Map<String, dynamic> current) {
  final r = GateResult();

  for (final name in current.keys.toList()..sort()) {
    final now = _widget(current[name]);
    final before = baseline.containsKey(name) ? _widget(baseline[name]) : null;

    if (before == null) {
      final gaps = _gaps(now);
      if (!now.hasFactory) {
        r.newIncomplete.add(Change(name, 'new, but unusable: no constructor could be emitted'));
      } else if (gaps.isNotEmpty) {
        r.newIncomplete.add(Change(name, 'new, incomplete: ${_summarise(gaps)}'));
      }
      continue;
    }

    if (before.hasFactory && !now.hasFactory) {
      r.regressions.add(Change(name, 'was instantiable, now has no constructor at all'));
    } else if (!before.hasFactory && now.hasFactory) {
      r.improvements.add(Change(name, 'is now instantiable'));
    }

    for (final ctor in {...before.factories.keys, ...now.factories.keys}.toList()..sort()) {
      final b = before.factories[ctor];
      final n = now.factories[ctor];
      final label = ctor.isEmpty ? 'the default constructor' : 'constructor `.$ctor`';
      if (b == null || n == null) continue; // added/removed by Flutter itself
      if (b.emitted && !n.emitted) {
        r.regressions.add(Change(name, '$label is no longer generated'));
        continue;
      }
      if (!b.emitted && n.emitted) {
        r.improvements.add(Change(name, '$label is now generated'));
        continue;
      }
      if (!n.emitted) continue;

      for (final p in n.dropped.difference(b.dropped).toList()..sort()) {
        r.regressions.add(Change(name, '`$p` lost its Java setter on $label'));
      }
      for (final p in b.dropped.difference(n.dropped).toList()..sort()) {
        r.improvements.add(Change(name, '`$p` gained a Java setter on $label'));
      }
      for (final p in n.inert.difference(b.inert).difference(n.dropped).toList()..sort()) {
        r.regressions.add(Change(name, '`$p` became inert on the web backend on $label'));
      }
      for (final p in b.inert.difference(n.inert).difference(n.dropped).toList()..sort()) {
        r.improvements.add(Change(name, '`$p` now works on the web backend on $label'));
      }
    }
  }
  return r;
}

/// Widget names ordered for a compact one-line summary.
String _summarise(List<String> gaps) =>
    gaps.length <= 6 ? gaps.join(', ') : '${gaps.take(6).join(', ')}, +${gaps.length - 6} more';

List<String> _gaps(_Widget w) {
  final out = <String>{};
  for (final f in w.factories.values) {
    if (!f.emitted) {
      out.add(f.name.isEmpty ? 'default constructor dropped' : '.${f.name} dropped');
      continue;
    }
    out.addAll(f.dropped);
    out.addAll(f.inert.difference(f.dropped));
  }
  return out.toList()..sort();
}

class _Widget {
  final bool hasFactory;
  final Map<String, _Factory> factories;

  _Widget(this.hasFactory, this.factories);
}

class _Factory {
  final String name;
  final bool emitted;
  final Set<String> dropped;
  final Set<String> inert;

  _Factory(this.name, this.emitted, this.dropped, this.inert);
}

_Widget _widget(dynamic raw) {
  final m = raw is Map<String, dynamic> ? raw : const <String, dynamic>{};
  final factories = <String, _Factory>{};
  final raw2 = m['factories'];
  for (final f in raw2 is List ? raw2 : const []) {
    if (f is! Map) continue;
    final name = (f['name'] as String?) ?? '';
    factories[name] = _Factory(
      name,
      f['emitted'] == true,
      _paramNames(f['dropped']),
      _paramNames(f['inert']),
    );
  }
  return _Widget(m['hasFactory'] == true, factories);
}

Set<String> _paramNames(dynamic raw) => {
      for (final e in raw is List ? raw : const [])
        if (e is Map && e['name'] is String) e['name'] as String,
    };

/// Returns null for anything that is not a readable JSON object, so a truncated
/// download or an HTML error page from the API is a skip, not a crash.
Map<String, dynamic>? _read(String path) {
  try {
    final f = File(path);
    if (!f.existsSync()) return null;
    final text = f.readAsStringSync().trim();
    if (text.isEmpty) return null;
    final decoded = jsonDecode(text);
    return decoded is Map<String, dynamic> ? decoded : null;
  } catch (_) {
    return null;
  }
}
