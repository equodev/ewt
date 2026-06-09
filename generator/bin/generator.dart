import 'dart:io';
// import 'package:_fe_analyzer_shared/src/type_inference/nullability_suffix.dart';
// import 'package:analyzer/dart/ast/ast.dart';
import 'package:analyzer/dart/ast/ast.dart';
import 'package:analyzer/src/dart/element/element.dart';
// import 'package:analyzer/src/generated/utilities_dart.dart';
// import 'package:analyzer/src/utilities/extensions/string.dart';
// import 'package:collection/collection.dart';
import 'package:analyzer/dart/element/element2.dart';
import 'package:analyzer/dart/element/type.dart';
import 'package:generator/gen.dart';
import 'package:path/path.dart' as path;
import 'package:analyzer/dart/analysis/analysis_context_collection.dart';
import 'package:analyzer/dart/analysis/results.dart';
import 'package:analyzer/dart/element/element.dart';
// import 'package:analyzer/dart/element/type.dart';

Future<void> main() async {
  var sw = Stopwatch()..start();
  var preindexName = 'pregeneration_index.dart';
  var preindexCache = File(path.join('build', '$preindexName.ts'));
  var preindexFile = path.join('lib', preindexName);
  var lastModified = File(preindexFile).lastModifiedSync();
  if (!preindexCache.existsSync() || preindexCache.lastModifiedSync().isBefore(lastModified)) {
    var subclasses_widgets = await widgetsToGenerate(preindexFile);
    print('-- Parse $preindexName ${sw.elapsedReset}');
    PreGeneration(subclasses_widgets.$1)
      ..gen()
      ..write();
    print('-- PreGeneration ${sw.elapsedReset}');
    await preindexCache.create(recursive: true);
    await preindexCache.setLastModified(lastModified);
  } else {
    print('-- Skipped PreGeneration');
  }

  var widgets = await widgetsToGenerate(path.join('lib', 'generation_index.dart'));
  print('-- Parse generation_index.dart ${sw.elapsedReset}');
  Generation(widgets.$1, widgets.$2)
    ..gen()
    ..write();
  print('-- Generation ${sw.elapsedReset}');
}

extension on Stopwatch {
  get elapsedReset {
    final e = elapsed;
    reset();
    return e;
  }
}

Future<(Iterable<ClassElement>, Iterable<PrefixedIdentifier>)> widgetsToGenerate(String indexFile) async {
  var index = path.absolute(indexFile);
  var collection = AnalysisContextCollection (includedPaths: [index], sdkPath: getSdkPath());
  var ctx = collection.contextFor(index);
  var session = ctx.currentSession;
  var unitResult = await session.getResolvedUnit(index);
  if (unitResult is ResolvedUnitResult) {
    var widgetsToGenerate = unitResult.unit.declaredElement!.topLevelVariables;
    var dartClasses = widgetsToGenerate.where((w) => w.type.element is ClassElement).map((w) => w.type.element as ClassElement);
    var dartTopFunctions = widgetsToGenerate.whereType<ConstVariableElement>().map((e) => e.constantInitializer as PrefixedIdentifier);
    return (dartClasses, dartTopFunctions);
  }
  return (<ClassElement>[], <PrefixedIdentifier>[]);
}

String getSdkPath() {
  final executable = path.split(Platform.resolvedExecutable);
  final cache = executable.indexOf('cache');
  return path.join(path.joinAll(executable.sublist(0, cache+1)), 'dart-sdk');
}
