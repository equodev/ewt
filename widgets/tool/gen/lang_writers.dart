import 'package:analyzer/dart/ast/ast.dart';
import 'package:analyzer/dart/element/element.dart';
import 'package:analyzer/src/utilities/extensions/string.dart';

import '../generator.dart';

class CLang {
  Generation generation;

  CLang(this.generation);

  // writeField(StringBuffer buff, String name, String ret, {List<ParameterElement>? params}) {
  //   if (params != null) {
  //     final cParams = Params(generation, params, Params.paramDef4C);
  //     buff.writeln('  $ret (*$name)(${cParams.decl});');
  //   } else {
  //     buff.writeln('  $ret $name;');
  //   }
  // }

  field(String name, String ret, {List<ParameterElement>? params}) {
    if (params != null) {
      final cParams = Params(generation, params, Params.paramDef4C);
      return '$ret (*$name)(${cParams.decl.ifNotEmptyOrElse('void')});';
    } else {
      return '$ret $name;';
    }
  }

}
