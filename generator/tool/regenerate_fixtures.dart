// Regenerates test/fixtures/*.java from their .dart source using the current
// transpiler with skipFormat: true. Run whenever the transpiler's output
// intentionally changes.

import 'dart:io';
import '../bin/transpiler.dart';

Future<void> regen(String dartFile, String? classArg, String outFile,
    {String? overridePackage}) async {
  final code = await transpile(dartFile, classArg,
      skipFormat: true, overridePackage: overridePackage);
  File(outFile).writeAsStringSync(code);
  stdout.writeln('wrote $outFile (${code.length} chars)');
}

Future<void> main() async {
  await regen('test/fixtures/counter.dart', 'build/Counter',
      'test/fixtures/counter.java', overridePackage: '');
  await regen('test/fixtures/hello.dart', 'build/Hello',
      'test/fixtures/hello.java', overridePackage: '');
  await regen('test/fixtures/model.dart',
      '../examples/src/main/java/dev/equo/Model.java',
      'test/fixtures/model.java');
  await regen('test/fixtures/action_popup_v9.dart',
      '../examples/src/main/java/dev/equo/KnowledgeFloating.java',
      'test/fixtures/action_popup_v9.java');
  await regen('test/fixtures/knowledge_view_v57.dart',
      '../examples/src/main/java/dev/equo/KnowledgeView.java',
      'test/fixtures/knowledge_view_v57.java');
  await regen('test/fixtures/hacka.dart',
      '../examples/src/main/java/dev/equo/Hacka.java',
      'test/fixtures/Hacka.java');
  await regen('test/fixtures/temp_dart.dart',
      '../examples/src/main/java/dev/equo/Temp.java',
      'test/fixtures/temp_dart.java');
}
