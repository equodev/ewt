import 'dart:io';

import 'package:path/path.dart' as p;
import 'package:test/test.dart';

// Byte-a-byte snapshot regression for the generator.
//
// Runs `dart run bin/generator.dart` from the generator/ CWD, then verifies
// that the outputs match the frozen references. There are two kinds of
// outputs:
//
//   1. Monolithic files that are gitignored (they change entirely when any
//      widget is added). References for these live under test/snapshots/.
//   2. Per-widget files that are committed under ewt.api/src/main/java and
//      widgets_web/lib. The working tree itself is the reference; we compare
//      via `git status --porcelain`.
//
// A refactor that preserves emitter behavior byte-for-byte will pass this
// test unchanged. When output is intentionally changed, run
// `dart run tool/update_snapshots.dart` to refresh test/snapshots/ (and
// commit the resulting diff in the per-widget files separately).

const _monolithicSnapshots = <_SnapshotFile>[
  _SnapshotFile('../widgets/src/factories.h', 'factories.h'),
  _SnapshotFile('../widgets/src/objects.h', 'objects.h'),
  _SnapshotFile('../widgets/src/typedefs.h', 'typedefs.h'),
  _SnapshotFile('../widgets/lib/factories_gen.dart', 'factories_gen.dart'),
  _SnapshotFile('../widgets/lib/subwidgets.dart', 'subwidgets_widgets.dart'),
  _SnapshotFile('./lib/subwidgets.dart', 'subwidgets_generator.dart'),
];

// Paths relative to the project root (generator/..).
const _committedOutputPaths = <String>[
  'ewt.api/src/main/java/dev/equo/ewt',
  'widgets_web/lib/factories_web_gen.dart',
];

void main() {
  final generatorDir = _findGeneratorDir();

  test('generator output is byte-identical to snapshots', () {
    _forcePregen(generatorDir);
    final result = Process.runSync(
      Platform.resolvedExecutable,
      ['run', 'bin/generator.dart'],
      workingDirectory: generatorDir,
    );
    expect(
      result.exitCode,
      0,
      reason: 'generator exited non-zero.\n'
          'STDOUT:\n${result.stdout}\n'
          'STDERR:\n${result.stderr}',
    );

    for (final snap in _monolithicSnapshots) {
      final actual = File(p.join(generatorDir, snap.outputPath));
      final expected = File(p.join(generatorDir, 'test/snapshots', snap.snapshotName));
      expect(actual.existsSync(), isTrue, reason: '${snap.outputPath} not emitted');
      expect(expected.existsSync(), isTrue, reason: 'missing snapshot ${snap.snapshotName}');
      final actualBytes = actual.readAsBytesSync();
      final expectedBytes = expected.readAsBytesSync();
      expect(
        actualBytes,
        orderedEquals(expectedBytes),
        reason: '${snap.outputPath} diverged from test/snapshots/${snap.snapshotName}. '
            'Run `dart run tool/update_snapshots.dart` if the change is intentional.',
      );
    }

    // Diagnostics smoke check: the generator must surface "silent skip"
    // widgets (unsupported types, dropped widgets) via `warn:` on stderr.
    // If this ever stops firing, either lib/diagnostics.dart got unwired
    // or every widget in the index became supportable — in the second
    // case, update this expectation.
    expect(
      result.stderr.toString(),
      contains('warn:'),
      reason: 'expected stderr to carry warn: lines from lib/diagnostics.dart',
    );
  });

  test('committed generator outputs are unchanged (git diff)', () {
    final projectRoot = p.normalize(p.join(generatorDir, '..'));
    // `-c safe.directory=*` bypasses git's ownership guard, which fires in
    // the GitLab k8s runner because the checkout is done by the init
    // container (one UID) while the job runs as another — every git
    // invocation would otherwise exit 128 with `fatal: detected dubious
    // ownership in repository`. On earlier attempts the same error surfaced
    // as `error: Could not access '<dirPath>/<basename(filePath)>'` because
    // git aborted mid-way through `diff -- <dir> <file>`, which also
    // motivated switching to per-path `status --porcelain`: quirk-free and
    // it pinpoints which output diverged.
    final divergences = <String>[];
    for (final path in _committedOutputPaths) {
      final args = ['-c', 'safe.directory=*', 'status', '--porcelain', '--', path];
      final result = Process.runSync('git', args, workingDirectory: projectRoot);
      if (result.exitCode != 0) {
        divergences.add('git ${args.join(' ')} exited ${result.exitCode}\n'
            'STDOUT:\n${result.stdout}\nSTDERR:\n${result.stderr}');
        continue;
      }
      final out = (result.stdout as String).trim();
      if (out.isNotEmpty) divergences.add('$path:\n$out');
    }
    expect(
      divergences,
      isEmpty,
      reason: 'committed generator outputs diverged '
          '(run `dart run tool/update_snapshots.dart` if intentional):\n\n'
          '${divergences.join('\n\n')}',
    );
  });
}

class _SnapshotFile {
  final String outputPath;
  final String snapshotName;
  const _SnapshotFile(this.outputPath, this.snapshotName);
}

String _findGeneratorDir() {
  var dir = Directory.current;
  while (dir.path != dir.parent.path) {
    if (File(p.join(dir.path, 'bin', 'generator.dart')).existsSync() &&
        File(p.join(dir.path, 'lib', 'gen.dart')).existsSync()) {
      return dir.path;
    }
    dir = dir.parent;
  }
  throw StateError('could not locate generator/ from ${Directory.current.path}');
}

void _forcePregen(String generatorDir) {
  final cache = File(p.join(generatorDir, 'build', 'pregeneration_index.dart.ts'));
  if (cache.existsSync()) cache.deleteSync();
}
