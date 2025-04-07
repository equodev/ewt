import 'dart:io';
// import 'package:_fe_analyzer_shared/src/type_inference/nullability_suffix.dart';
// import 'package:analyzer/dart/ast/ast.dart';
// import 'package:analyzer/src/dart/element/element.dart';
// import 'package:analyzer/src/generated/utilities_dart.dart';
// import 'package:analyzer/src/utilities/extensions/string.dart';
// import 'package:collection/collection.dart';
import 'package:generator/gen.dart';
import 'package:path/path.dart' as path;
import 'package:analyzer/dart/analysis/analysis_context_collection.dart';
import 'package:analyzer/dart/analysis/results.dart';
import 'package:analyzer/dart/element/element.dart';
// import 'package:analyzer/dart/element/type.dart';

Future<void> main() async {
  var sw = Stopwatch()..start();
  var subclasses_widgets = await widgetsToGenerate('pregeneration_index.dart');
  print('-- Parse pregeneration_index.dart ${sw.elapsedReset}');
  PreGeneration(subclasses_widgets)
    ..gen()
    ..write();
  print('-- PreGeneration ${sw.elapsedReset}');

  var widgets = await widgetsToGenerate('generation_index.dart');
  print('-- Parse generation_index.dart ${sw.elapsedReset}');
  Generation(widgets)
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

Future<Iterable<ClassElement>> widgetsToGenerate(String index_file) async {
  var index = path.absolute(path.join('lib', index_file));
  var collection = AnalysisContextCollection (includedPaths: [index], sdkPath: getSdkPath());
  var ctx = collection.contextFor(index);
  var session = ctx.currentSession;
  var unitResult = await session.getResolvedUnit(index);
  if (unitResult is ResolvedUnitResult) {
    var widgetsToGenerate = unitResult.unit.declaredElement!.topLevelVariables;
    var dartClasses = widgetsToGenerate.map((w) => w.type.element as ClassElement);
    return dartClasses;
  }
  return [];
}

String getSdkPath() {
  final executable = path.split(Platform.resolvedExecutable);
  final cache = executable.indexOf('cache');
  return path.join(path.joinAll(executable.sublist(0, cache+1)), 'dart-sdk');
}
