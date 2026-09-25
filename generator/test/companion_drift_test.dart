// Kills landmine #9: every `<Target>Methods` companion class lives in TWO files
// that must be kept in lockstep:
//
//   * `generator/lib/<target>_methods.dart` — the SPEC read by the generator.
//   * `widgets/lib/<target>_methods.dart`   — the RUNTIME forwarder Flutter compiles.
//
// The generator emits calls into `factories_gen.dart` that resolve to the runtime
// forwarder at Flutter build time. Adding a static method to the spec without
// mirroring it into the runtime silently passes the snapshot test (which compares
// against the spec) and passes an incremental `:ewt.api:jar` (buildFlutter reuses
// its cache), yet blows up on a clean build with `Member not found`. This test
// enforces the mirror at CI time.

import 'dart:io';
import 'package:path/path.dart' as p;
import 'package:test/test.dart';

void main() {
  final generatorDir = _generatorDir();
  final specDir = Directory(p.join(generatorDir, 'lib'));
  final runtimeDir = Directory(p.join(generatorDir, '..', 'widgets', 'lib'));

  final specs = specDir
      .listSync()
      .whereType<File>()
      .where((f) => f.path.endsWith('_methods.dart'))
      .toList()
    ..sort((a, b) => a.path.compareTo(b.path));

  test('every generator/lib/*_methods.dart has a widgets/lib peer', () {
    for (final specFile in specs) {
      final name = p.basename(specFile.path);
      final peer = File(p.join(runtimeDir.path, name));
      expect(
        peer.existsSync(),
        isTrue,
        reason:
            'spec ${specFile.path} has no runtime peer at ${peer.path}. '
            'Both files must exist and mirror the same public static methods.',
      );
    }
  });

  for (final specFile in specs) {
    final name = p.basename(specFile.path);
    final peer = File(p.join(runtimeDir.path, name));
    if (!peer.existsSync()) continue; // covered by the peer-existence test above.

    test('spec and runtime mirror same public statics: $name', () {
      final specSigs = _extractPublicStaticSignatures(specFile.readAsStringSync());
      final peerSigs = _extractPublicStaticSignatures(peer.readAsStringSync());

      final onlyInSpec = specSigs.difference(peerSigs);
      final onlyInPeer = peerSigs.difference(specSigs);

      expect(
        onlyInSpec.isEmpty && onlyInPeer.isEmpty,
        isTrue,
        reason:
            'Signature drift in $name — the generator will emit calls into '
            '`factories_gen.dart` that fail at Flutter build time with '
            '"Member not found" when caches are clean.\n'
            '  Only in spec  (${specFile.path}): ${onlyInSpec.isEmpty ? "(none)" : onlyInSpec}\n'
            '  Only in peer  (${peer.path}): ${onlyInPeer.isEmpty ? "(none)" : onlyInPeer}\n'
            'Mirror the missing statics into the file that lacks them.',
      );
    });
  }
}

// Extracts the set of `<returnType> <name>(<param-types>)` signatures for every
// public static method declared at the top level of a companion class body.
//
// Deliberately regex-based — a full Dart parser is overkill and would add a
// dependency; the companion files are tiny and follow a rigid `static <ret>
// <name>(<params>) => ...;` pattern. Comments and typedefs above the class are
// ignored; only lines inside the first `class ...Methods { ... }` block match.
Set<String> _extractPublicStaticSignatures(String source) {
  final classBody = _extractMethodsClassBody(source);
  final sigs = <String>{};

  // Matches `static <returnType> <name>(<params>)` — returnType and params may
  // contain generics with balanced angle brackets. Captured groups are trimmed
  // so incidental whitespace does not cause false drift.
  final re = RegExp(
    r'static\s+([\w<>?, \.]+?)\s+(\w+)\s*\(([^)]*)\)',
    multiLine: true,
  );

  for (final match in re.allMatches(classBody)) {
    final returnType = match.group(1)!.trim();
    final methodName = match.group(2)!.trim();
    // Skip private (leading `_`) — the generator only cares about public statics.
    if (methodName.startsWith('_')) continue;
    // Normalise params: strip parameter names, keep types only. The signature the
    // generator cares about (and that the runtime forwarder must match) is
    // (returnType, name, paramTypes).
    final paramTypes = _extractParamTypes(match.group(3)!);
    sigs.add('$returnType $methodName(${paramTypes.join(", ")})');
  }
  return sigs;
}

// Extracts the body between the first `class <X>Methods {` and its matching
// closing brace. Uses a simple depth counter — companion files never have
// non-class braces before the class declaration.
String _extractMethodsClassBody(String source) {
  final classDecl = RegExp(r'class\s+\w+Methods\s*(?:<[^>]*>)?\s*\{');
  final match = classDecl.firstMatch(source);
  if (match == null) return '';
  int depth = 1;
  int i = match.end;
  while (i < source.length && depth > 0) {
    final c = source[i];
    if (c == '{') depth++;
    else if (c == '}') depth--;
    i++;
  }
  return source.substring(match.end, i - 1);
}

// Splits a param list on top-level commas (i.e. respecting generic angle
// brackets) and drops the parameter names, keeping only the type portion.
List<String> _extractParamTypes(String params) {
  final trimmed = params.trim();
  if (trimmed.isEmpty) return const [];
  final result = <String>[];
  final buf = StringBuffer();
  int depth = 0;
  for (int i = 0; i < trimmed.length; i++) {
    final c = trimmed[i];
    if (c == '<') depth++;
    if (c == '>') depth--;
    if (c == ',' && depth == 0) {
      result.add(_paramTypeOnly(buf.toString()));
      buf.clear();
    } else {
      buf.write(c);
    }
  }
  if (buf.isNotEmpty) result.add(_paramTypeOnly(buf.toString()));
  return result;
}

// Given `Duration duration` or `AnimationController self`, returns `Duration` /
// `AnimationController`. Handles generic types and `Function`-typed params by
// looking at the last identifier as the param name.
String _paramTypeOnly(String param) {
  final trimmed = param.trim();
  // Find the last identifier in the string — that's the param name.
  final lastSpace = trimmed.lastIndexOf(RegExp(r'\s'));
  if (lastSpace < 0) return trimmed;
  return trimmed.substring(0, lastSpace).trim();
}

// Locate the generator/ directory whether the test is run from generator/ or from
// the repo root.
String _generatorDir() {
  final cwd = Directory.current.path;
  if (p.basename(cwd) == 'generator') return cwd;
  final maybe = p.join(cwd, 'generator');
  if (Directory(maybe).existsSync()) return maybe;
  throw StateError('cannot locate generator/ from cwd=$cwd');
}
