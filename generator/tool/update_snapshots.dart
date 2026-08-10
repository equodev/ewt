import 'dart:io';

import 'package:path/path.dart' as p;

// Refresh the frozen snapshots under generator/test/snapshots/.
//
// Runs the generator against the real generation_index.dart, then copies the
// six gitignored monolithic outputs into test/snapshots/. Use this only after
// an intentional change to the emitter, and commit the resulting diff.
//
// The committed per-widget outputs (ewt.api/*.java, widgets_web/*.dart) are
// updated by running the generator itself — this tool doesn't touch them.

const _monolithicSnapshots = <List<String>>[
  ['../widgets/src/factories.h', 'factories.h'],
  ['../widgets/src/objects.h', 'objects.h'],
  ['../widgets/src/typedefs.h', 'typedefs.h'],
  ['../widgets/lib/factories_gen.dart', 'factories_gen.dart'],
  ['../widgets/lib/subwidgets.dart', 'subwidgets_widgets.dart'],
  ['./lib/subwidgets.dart', 'subwidgets_generator.dart'],
];

Future<void> main() async {
  final generatorDir = _findGeneratorDir();
  final cache = File(p.join(generatorDir, 'build', 'pregeneration_index.dart.ts'));
  if (cache.existsSync()) cache.deleteSync();

  stdout.writeln('Running generator...');
  final result = await Process.run(
    Platform.resolvedExecutable,
    ['run', 'bin/generator.dart'],
    workingDirectory: generatorDir,
  );
  if (result.exitCode != 0) {
    stderr.writeln('generator failed with exit ${result.exitCode}');
    stderr.writeln('STDOUT:\n${result.stdout}');
    stderr.writeln('STDERR:\n${result.stderr}');
    exit(result.exitCode);
  }

  final snapDir = Directory(p.join(generatorDir, 'test', 'snapshots'));
  snapDir.createSync(recursive: true);
  for (final entry in _monolithicSnapshots) {
    final src = File(p.join(generatorDir, entry[0]));
    final dst = File(p.join(snapDir.path, entry[1]));
    if (!src.existsSync()) {
      stderr.writeln('missing generated file ${src.path}; aborting.');
      exit(2);
    }
    src.copySync(dst.path);
    stdout.writeln('  updated test/snapshots/${entry[1]} (${src.lengthSync()} bytes)');
  }
  stdout.writeln('done.');
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
