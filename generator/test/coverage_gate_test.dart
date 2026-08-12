import 'dart:convert';
import 'dart:io';

import 'package:path/path.dart' as p;
import 'package:test/test.dart';

import '../tool/coverage_gate.dart';

// Unit tests for the coverage gate.
//
// The gate runs in CI against a baseline downloaded from the default branch, so
// its failure modes are hard to reproduce by pushing commits. These tests
// exercise the comparison directly with hand-built reports, plus an end-to-end
// pass over the real snapshot, so a bug in the gate shows up here rather than
// as a red pipeline nobody can explain.

/// Minimal coverage_status.json entry.
Map<String, dynamic> widget({
  bool hasFactory = true,
  List<Map<String, dynamic>> factories = const [],
}) =>
    {'abstract': false, 'javaClass': true, 'hasFactory': hasFactory, 'factories': factories};

Map<String, dynamic> ctor({
  String name = '',
  bool emitted = true,
  int params = 3,
  List<String> dropped = const [],
  List<String> inert = const [],
}) =>
    {
      'name': name,
      'kind': 'ctor',
      'emitted': emitted,
      'params': params,
      if (dropped.isNotEmpty)
        'dropped': [for (final d in dropped) {'name': d, 'type': 'T', 'reason': 'unsupported-type'}],
      if (inert.isNotEmpty)
        'inert': [for (final i in inert) {'name': i, 'type': 'T', 'reason': 'web-skipped'}],
    };

void main() {
  group('regressions (must fail the gate)', () {
    test('a property loses its Java setter', () {
      final r = compare(
        {'Slider': widget(factories: [ctor()])},
        {
          'Slider': widget(factories: [ctor(dropped: ['focusNode'])])
        },
      );
      expect(r.failed(strictNew: false), isTrue);
      expect(r.regressions.single.toString(), contains('`focusNode` lost its Java setter'));
    });

    test('a widget stops being instantiable', () {
      final r = compare(
        {'Radio': widget(factories: [ctor()])},
        {
          'Radio': widget(hasFactory: false, factories: [ctor(emitted: false)])
        },
      );
      expect(r.failed(strictNew: false), isTrue);
      expect(r.regressions.map((c) => c.detail).join(),
          contains('was instantiable, now has no constructor'));
    });

    test('a named constructor stops being generated', () {
      final r = compare(
        {
          'Slider': widget(factories: [ctor(), ctor(name: 'adaptive')])
        },
        {
          'Slider': widget(factories: [ctor(), ctor(name: 'adaptive', emitted: false)])
        },
      );
      expect(r.failed(strictNew: false), isTrue);
      expect(r.regressions.single.toString(), contains('`.adaptive` is no longer generated'));
    });

    test('a property becomes inert on the web backend', () {
      final r = compare(
        {'Switch': widget(factories: [ctor()])},
        {
          'Switch': widget(factories: [ctor(inert: ['onChanged'])])
        },
      );
      expect(r.failed(strictNew: false), isTrue);
      expect(r.regressions.single.toString(), contains('became inert on the web backend'));
    });
  });

  group('not regressions (must pass)', () {
    test('identical reports', () {
      final same = {'Text': widget(factories: [ctor()])};
      final r = compare(same, jsonDecode(jsonEncode(same)) as Map<String, dynamic>);
      expect(r.failed(strictNew: true), isFalse);
      expect(r.regressions, isEmpty);
      expect(r.improvements, isEmpty);
      expect(r.report(strictNew: false), contains('no change'));
    });

    test('a property gains a setter', () {
      final r = compare(
        {
          'Slider': widget(factories: [ctor(dropped: ['focusNode'])])
        },
        {'Slider': widget(factories: [ctor()])},
      );
      expect(r.failed(strictNew: false), isFalse);
      expect(r.improvements.single.toString(), contains('gained a Java setter'));
    });

    test('a widget removed from the index is not a regression', () {
      final r = compare({'Gone': widget(factories: [ctor()])}, {});
      expect(r.failed(strictNew: true), isFalse);
      expect(r.regressions, isEmpty);
    });

    test('a new complete widget is silent', () {
      final r = compare({}, {'Card': widget(factories: [ctor()])});
      expect(r.failed(strictNew: true), isFalse);
      expect(r.newIncomplete, isEmpty);
    });

    // A partial widget is still net progress; failing on it would make the job
    // noise. Reported loudly, but green unless --strict-new.
    test('a new incomplete widget is reported but does not fail by default', () {
      final r = compare({}, {
        'TextField': widget(factories: [ctor(dropped: ['controller', 'focusNode'])])
      });
      expect(r.failed(strictNew: false), isFalse);
      expect(r.failed(strictNew: true), isTrue);
      expect(r.newIncomplete.single.toString(), contains('new, incomplete'));
      expect(r.report(strictNew: false), contains('not a failure'));
    });

    test('a new unusable widget is reported as such', () {
      final r = compare({}, {
        'MatrixTransition': widget(hasFactory: false, factories: [ctor(emitted: false)])
      });
      expect(r.newIncomplete.single.toString(), contains('unusable'));
      expect(r.failed(strictNew: false), isFalse);
    });
  });

  group('malformed input degrades instead of crashing', () {
    test('missing keys on either side', () {
      expect(() => compare({'A': <String, dynamic>{}}, {'A': <String, dynamic>{}}), returnsNormally);
      expect(() => compare({'A': 'not a map'}, {'A': 42}), returnsNormally);
    });

    test('factories field absent or wrong type', () {
      final r = compare(
        {'A': {'hasFactory': true, 'factories': 'nope'}},
        {'A': {'hasFactory': true}},
      );
      expect(r.failed(strictNew: true), isFalse);
    });

    test('constructors added or removed by Flutter itself are ignored', () {
      final r = compare(
        {'A': widget(factories: [ctor(), ctor(name: 'old')])},
        {'A': widget(factories: [ctor(), ctor(name: 'brandNew', dropped: ['x'])])},
      );
      expect(r.regressions, isEmpty);
    });
  });

  group('end to end against the real snapshot', () {
    final snapshot = File(p.join(_generatorDir(), 'test', 'snapshots', 'coverage_status.json'));

    test('the committed snapshot compared with itself is clean', () {
      final json = jsonDecode(snapshot.readAsStringSync()) as Map<String, dynamic>;
      final r = compare(json, jsonDecode(jsonEncode(json)) as Map<String, dynamic>);
      expect(r.regressions, isEmpty);
      expect(r.newIncomplete, isEmpty);
      expect(r.improvements, isEmpty);
    });

    // Proves the gate catches a real regression in real data, not just in
    // hand-built fixtures: drop one param from one widget and expect a hit.
    test('injecting a dropped param into real data trips the gate', () {
      final base = jsonDecode(snapshot.readAsStringSync()) as Map<String, dynamic>;
      final broken = jsonDecode(jsonEncode(base)) as Map<String, dynamic>;
      final victim = broken.entries.firstWhere((e) {
        final f = ((e.value as Map)['factories'] as List?) ?? const [];
        return f.isNotEmpty && (f.first as Map)['emitted'] == true;
      });
      final factory = (((victim.value as Map)['factories'] as List).first as Map);
      factory['dropped'] = [
        ...((factory['dropped'] as List?) ?? const []),
        {'name': '__injected__', 'type': 'T', 'reason': 'unsupported-type'},
      ];

      final r = compare(base, broken);
      expect(r.failed(strictNew: false), isTrue);
      expect(r.regressions.single.toString(),
          allOf(contains(victim.key), contains('__injected__')));
    });
  });
}

String _generatorDir() {
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
