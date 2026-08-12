// Audits Flutter library coverage and writes docs/coverage.md — a per-widget
// report of what EWT actually exposes.
//
// Two inputs:
//
//   * the Flutter libraries themselves, resolved with the same analyzer the
//     generator uses, so the widget list always reflects the installed SDK;
//   * build/coverage_status.json, written by the generator, which records for
//     every widget and constructor which params were dropped (no Java setter)
//     and which are inert (setter exists, runtime ignores it).
//
// Without the JSON the report degrades to the old declared/not-declared
// checklist and says so in a banner — a local `dart tool/coverage_audit.dart`
// still works, it just can't tell a complete widget from a partial one.
//
//   cd generator && dart run bin/generator.dart && dart tool/coverage_audit.dart
//
// The output is deterministic: no timestamps, every list sorted. CI compares it
// against the committed file and only commits when the content really changed.

import 'dart:convert';
import 'dart:io';

import 'package:analyzer/dart/analysis/analysis_context_collection.dart';
import 'package:analyzer/dart/analysis/results.dart';
import 'package:analyzer/dart/element/element.dart';
import 'package:path/path.dart' as path;

/// Libraries to audit, in the order they appear in the report.
const libraries = <String>[
  'package:flutter/widgets.dart',
  'package:flutter/material.dart',
  'package:flutter/cupertino.dart',
];

const titles = <String, List<String>>{
  'package:flutter/widgets.dart': [
    'Basic widgets',
    'package:flutter/widgets.dart — raw building blocks, no default styling',
  ],
  'package:flutter/material.dart': [
    'Material',
    'package:flutter/material.dart — Material Design components (Google)',
  ],
  'package:flutter/cupertino.dart': [
    'Cupertino',
    'package:flutter/cupertino.dart — iOS / macOS styled components (Apple)',
  ],
};

/// Emoji instead of `- [x]` task-list syntax: Markdown only renders `[ ]` and
/// `[x]`, so the three-state report ([~] partial, [!] unusable) printed as
/// literal text everywhere except GitLab. Emoji render identically in GitLab,
/// GitHub, IDE previews and plain text. The per-section counts below replace
/// GitLab's built-in checkbox progress indicator.
const emojiFull = '✅';
const emojiPartial = '🟡';
const emojiUnusable = '❌';
const emojiMissing = '⬜';

enum Status { full, partial, unusable, missing }

String emojiFor(Status s) => switch (s) {
      Status.full => emojiFull,
      Status.partial => emojiPartial,
      Status.unusable => emojiUnusable,
      Status.missing => emojiMissing,
    };

/// What the generator recorded for one widget.
class Coverage {
  final String name;
  final bool hasFactory;
  final List<Map<String, dynamic>> factories;

  Coverage(this.name, this.hasFactory, this.factories);

  /// The constructor a user reaches for: the unnamed one when it was emitted,
  /// otherwise the first emitted one. Its param tally is what the report
  /// quotes — the per-constructor detail stays in coverage_status.json.
  Map<String, dynamic>? get primary {
    final emitted = factories.where((f) => f['emitted'] == true).toList();
    if (emitted.isEmpty) return null;
    return emitted.firstWhere((f) => (f['name'] as String).isEmpty, orElse: () => emitted.first);
  }

  /// Constructors that exist in Flutter but produced no Java factory.
  List<Map<String, dynamic>> get droppedFactories =>
      factories.where((f) => f['emitted'] != true).toList();

  List<Map<String, dynamic>> _issues(String key) {
    final p = primary;
    if (p == null) return const [];
    return ((p[key] as List?) ?? const []).cast<Map<String, dynamic>>();
  }

  List<Map<String, dynamic>> get dropped => _issues('dropped');
  List<Map<String, dynamic>> get inert => _issues('inert');

  int get totalParams => (primary?['params'] as int?) ?? 0;

  /// Reachable over the native FFI bridge: everything except the params with
  /// no Java setter at all.
  int get nativeParams => totalParams - dropped.length;

  /// Reachable in the pure-Dart web backend: the native set minus the params
  /// whose setter exists but whose value the web decoder discards. The two
  /// numbers are not the same and averaging them hides which backend is short.
  int get webParams => nativeParams - inert.length;

  Status get status {
    if (!hasFactory) return Status.unusable;
    if (dropped.isNotEmpty || inert.isNotEmpty || droppedFactories.isNotEmpty) {
      return Status.partial;
    }
    return Status.full;
  }
}

Future<void> main() async {
  final probe = path.absolute(path.join('build', 'coverage_probe.dart'));
  File(probe)
    ..createSync(recursive: true)
    ..writeAsStringSync([
      for (final l in libraries) "import '$l';",
      'void main() {}',
    ].join('\n'));

  final collection = AnalysisContextCollection(
    includedPaths: [probe],
    sdkPath: getSdkPath(),
  );
  final session = collection.contextFor(probe).currentSession;
  final unit = await session.getResolvedUnit(probe);
  if (unit is! ResolvedUnitResult) {
    stderr.writeln('Could not resolve probe file');
    exit(1);
  }

  final indexed = indexedTypes();
  final status = loadStatus();
  final sections = <String, List<(String, Status, Coverage?)>>{};

  for (final lib in unit.libraryElement.importedLibraries) {
    final uri = lib.source.uri.toString();
    if (!libraries.contains(uri)) continue;

    final rows = <(String, Status, Coverage?)>[];
    for (final element in lib.exportNamespace.definedNames.values) {
      if (element is! ClassElement) continue;
      if (element.isPrivate || element.isAbstract) continue;
      if (!isWidget(element)) continue;
      if (!declaredIn(element, uri)) continue;

      final name = element.name;
      if (!indexed.contains(name)) {
        rows.add((name, Status.missing, null));
        continue;
      }
      final cov = status?[name];
      // Declared in the index but absent from the generator's report: the
      // generator never processed it. Without the JSON at all, fall back to
      // the old behaviour and call it covered.
      if (status == null) {
        rows.add((name, Status.full, null));
      } else if (cov == null) {
        rows.add((name, Status.unusable, null));
      } else {
        rows.add((name, cov.status, cov));
      }
    }
    // Grouped by state, alphabetical inside each group: the actionable entries
    // (partial, unusable) sit at the top instead of being scattered through
    // ~300 alphabetical lines, and the long not-supported block stays at the
    // bottom where it is skimmed rather than read.
    rows.sort((a, b) {
      final c = a.$2.index.compareTo(b.$2.index);
      return c != 0 ? c : a.$1.compareTo(b.$1);
    });
    sections[uri] = rows;
  }

  final out = StringBuffer();
  out.writeln('# EWT — Flutter widget coverage');
  out.writeln();
  out.writeln('Flutter ${detectFlutterVersion()}');
  out.writeln();
  if (status == null) {
    out.writeln('> ⚠️ `build/coverage_status.json` not found — this report only knows which '
        'widgets are declared in `generation_index.dart`, not how complete they are. '
        'Run `dart run bin/generator.dart` first.');
    out.writeln();
  }

  writeLegend(out, status != null);
  writeSummary(out, sections);
  for (final uri in libraries) {
    writeSection(out, uri, sections[uri]);
  }
  writeNotes(out, status != null);

  final target = File(path.join('..', 'docs', 'coverage.md'));
  target.createSync(recursive: true);
  target.writeAsStringSync(out.toString());

  stdout.writeln('Wrote ${path.normalize(target.absolute.path)}');
  for (final uri in libraries) {
    final rows = sections[uri];
    if (rows == null || rows.isEmpty) continue;
    final c = count(rows);
    stdout.writeln('  ${titles[uri]![0].padRight(18)} '
        '${c[Status.full]} full / ${c[Status.partial]} partial / '
        '${c[Status.unusable]} unusable / ${rows.length} total');
  }
}

Map<Status, int> count(List<(String, Status, Coverage?)> rows) {
  final c = {for (final s in Status.values) s: 0};
  for (final r in rows) {
    c[r.$2] = c[r.$2]! + 1;
  }
  return c;
}

void writeLegend(StringBuffer out, bool detailed) {
  out.writeln('## Legend');
  out.writeln();
  out.writeln('| | Meaning |');
  out.writeln('|---|---|');
  out.writeln('| $emojiFull | **Complete** — every constructor and every Flutter '
      'property is exposed in Java. |');
  if (detailed) {
    out.writeln('| $emojiPartial | **Partial** — `EWT.<Widget>(…)` works, but some properties '
        'have no setter (their Dart type cannot be marshalled), some are inert on the web '
        'backend, or a named constructor was dropped. They are listed inline. |');
    out.writeln('| $emojiUnusable | **Unusable** — the `.java` class is generated (it is needed '
        'as a parent / parameter type) but every constructor has a required '
        'param that cannot be marshalled, so there is no way to instantiate it. |');
  }
  out.writeln('| $emojiMissing | **Not supported** — not declared in `generation_index.dart`. |');
  out.writeln();
}

void writeSummary(StringBuffer out, Map<String, List<(String, Status, Coverage?)>> sections) {
  out.writeln('## Summary');
  out.writeln();
  out.writeln('| Library | $emojiFull Complete | $emojiPartial Partial | $emojiUnusable Unusable '
      '| Total | Coverage | Props (native) | Props (web) |');
  out.writeln('|---|---:|---:|---:|---:|---:|---:|---:|');
  var tf = 0, tp = 0, tu = 0, tt = 0, pn = 0, pw = 0, pt = 0;
  for (final uri in libraries) {
    final rows = sections[uri];
    if (rows == null || rows.isEmpty) continue;
    final c = count(rows);
    final (native, web, total) = propTally(rows);
    tf += c[Status.full]!;
    tp += c[Status.partial]!;
    tu += c[Status.unusable]!;
    tt += rows.length;
    pn += native;
    pw += web;
    pt += total;
    out.writeln('| ${titles[uri]![0]} | ${c[Status.full]} | ${c[Status.partial]} '
        '| ${c[Status.unusable]} | ${rows.length} '
        '| ${pct(c[Status.full]! + c[Status.partial]!, rows.length)} '
        '| ${props(native, total)} | ${props(web, total)} |');
  }
  out.writeln('| **Total** | **$tf** | **$tp** | **$tu** | **$tt** '
      '| **${pct(tf + tp, tt)}** '
      '| **${props(pn, pt)}** | **${props(pw, pt)}** |');
  out.writeln();
  out.writeln('**Coverage** counts complete + partial against every widget in the library: a '
      'partial widget is still usable. Unusable widgets are deliberately excluded — counting '
      'them is exactly the over-reporting this file exists to avoid.');
  out.writeln();
  out.writeln('**Props** is the honest figure: how many of the constructor parameters Flutter '
      'offers are actually reachable, across every supported widget. The two backends differ, '
      'so they are counted separately — *native* is the FFI bridge, *web* is the pure-Dart '
      'decoder. A property missing from *web* only has a Java setter that compiles and works '
      'natively, but whose value the web decoder discards.');
  out.writeln();
}

/// (native, web, total) constructor params across the supported widgets of a section.
(int, int, int) propTally(List<(String, Status, Coverage?)> rows) {
  var native = 0, web = 0, total = 0;
  for (final r in rows) {
    final cov = r.$3;
    if (cov == null || r.$2 == Status.missing) continue;
    native += cov.nativeParams;
    web += cov.webParams;
    total += cov.totalParams;
  }
  return (native, web, total);
}

String props(int n, int total) => total == 0 ? '—' : '$n/$total (${pct(n, total)})';

String pct(int n, int d) => d == 0 ? '0%' : '${n * 100 ~/ d}%';

/// Caps an inline list so a widget with 40 missing props stays one readable line;
/// the full set is always in coverage_status.json.
String names(List<Map<String, dynamic>> issues, {int max = 5}) {
  final all = issues.map((i) => '`${i['name']}`').toList();
  if (all.length <= max) return all.join(', ');
  return '${all.take(max).join(', ')}, +${all.length - max}';
}

void writeSection(StringBuffer out, String uri, List<(String, Status, Coverage?)>? rows) {
  if (rows == null || rows.isEmpty) return;
  final c = count(rows);
  out.writeln('## ${titles[uri]![0]}');
  out.writeln();
  out.writeln('_${titles[uri]![1]}_');
  out.writeln();
  out.writeln('**${c[Status.full]! + c[Status.partial]!} of ${rows.length} usable** '
      '— ${c[Status.full]} complete, ${c[Status.partial]} partial, ${c[Status.unusable]} unusable');
  out.writeln();
  for (final (name, st, cov) in rows) {
    out.writeln('- ${emojiFor(st)} $name${detail(st, cov)}');
  }
  out.writeln();
}

String detail(Status st, Coverage? cov) {
  if (cov == null) return '';
  switch (st) {
    case Status.unusable:
      final blockers = cov.factories
          .expand((f) => ((f['blockedBy'] as List?) ?? const []).cast<Map<String, dynamic>>())
          .map((b) => '`${b['type']}`')
          .toSet()
          .toList()
        ..sort();
      final why = blockers.isEmpty ? '' : ' (${blockers.join(', ')})';
      return ' — no factory: every constructor has an unmarshalable required param$why';
    case Status.partial:
      final bits = <String>[];
      bits.add(cov.webParams == cov.nativeParams
          ? '${cov.nativeParams}/${cov.totalParams} props'
          : '${cov.nativeParams}/${cov.totalParams} props native, ${cov.webParams}/${cov.totalParams} web');
      if (cov.dropped.isNotEmpty) bits.add('missing: ${names(cov.dropped)}');
      if (cov.inert.isNotEmpty) bits.add('inert on web: ${names(cov.inert)}');
      final dropped = cov.droppedFactories;
      if (dropped.isNotEmpty) {
        final n = dropped.map((f) => '`.${f['name']}`').toList()..sort();
        bits.add('dropped constructors: ${n.join(', ')}');
      }
      return ' — ${bits.join(' · ')}';
    default:
      return '';
  }
}

void writeNotes(StringBuffer out, bool detailed) {
  out.writeln('## Notes');
  out.writeln();
  out.writeln('- Only concrete classes extending `Widget` are listed. Abstract classes and '
      'supporting types (enums, themes, controllers) are excluded.');
  if (detailed) {
    out.writeln('- Property counts come from the constructor a caller actually reaches for '
        '(the unnamed one when it exists). Per-constructor detail lives in '
        '`generator/build/coverage_status.json`.');
    out.writeln('- A property is counted as exposed when its Java setter is generated. That is a '
        'statement about the API surface, not proof that the widget renders correctly.');
  }
  out.writeln('- Generated by `generator/tool/coverage_audit.dart` from '
      '`generator/build/coverage_status.json`. Never edit by hand: CI regenerates this file '
      'on `main` and commits it whenever the content changes.');
}

/// Reads the generator's report. Null when it has not been produced yet.
Map<String, Coverage>? loadStatus() {
  final f = File(path.join('build', 'coverage_status.json'));
  if (!f.existsSync()) return null;
  final raw = jsonDecode(f.readAsStringSync()) as Map<String, dynamic>;
  return {
    for (final e in raw.entries)
      e.key: Coverage(
        e.key,
        (e.value as Map<String, dynamic>)['hasFactory'] == true,
        ((e.value as Map<String, dynamic>)['factories'] as List).cast<Map<String, dynamic>>(),
      ),
  };
}

/// Names of the types already declared in the generation index.
Set<String> indexedTypes() {
  final src = File(path.join('lib', 'generation_index.dart')).readAsStringSync();
  final names = <String>{};
  // Matches declarations such as `w.FloatingActionButton? floatingActionButton;`
  // and skips commented-out lines.
  final re = RegExp(r'^\s*(?:\w+\.)?(\w+)\?\s+\w+;', multiLine: true);
  for (final m in re.allMatches(src)) {
    names.add(m.group(1)!);
  }
  return names;
}

bool isWidget(ClassElement element) {
  for (var t = element.supertype; t != null; t = t.element.supertype) {
    if (t.element.name == 'Widget') return true;
  }
  return false;
}

/// A class re-exported by several libraries is attributed to the one that
/// declares it (material re-exports much of widgets).
bool declaredIn(ClassElement c, String uri) {
  final src = c.library.source.uri.toString();
  return switch (uri) {
    'package:flutter/widgets.dart' => src.startsWith('package:flutter/src/widgets/'),
    'package:flutter/material.dart' => src.startsWith('package:flutter/src/material/'),
    'package:flutter/cupertino.dart' => src.startsWith('package:flutter/src/cupertino/'),
    _ => false,
  };
}

String detectFlutterVersion() {
  try {
    final r = Process.runSync('flutter', ['--version']);
    final m = RegExp(r'Flutter (\S+)').firstMatch(r.stdout.toString());
    if (m != null) return m.group(1)!;
  } catch (_) {}
  return 'unknown';
}

String getSdkPath() {
  final executable = path.split(Platform.resolvedExecutable);
  final cache = executable.indexOf('cache');
  return path.join(path.joinAll(executable.sublist(0, cache + 1)), 'dart-sdk');
}
