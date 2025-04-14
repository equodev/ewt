import 'package:analyzer/dart/ast/ast.dart';
import 'package:analyzer/dart/element/element.dart';
import 'package:analyzer/dart/element/type.dart';
import 'package:analyzer/dart/element/type_visitor.dart';
import 'package:analyzer/dart/element/visitor.dart';
import 'package:analyzer/src/utilities/extensions/string.dart';
import 'package:generator/types.dart';

import 'gen.dart';

class CLang {
  Types generation;

  CLang(this.generation);

  field(String name, String ret, {List<ParameterElement>? params}) {
    if (params != null) {
      final cParams = Params(generation, params, Params.paramDef4C);
      return '$ret (*$name)(${cParams.decl.ifNotEmptyOrElse('void')});';
    } else {
      return '$ret $name;';
    }
  }

}

class JLang {

  String methodTypeParameters(FunctionType fnType) {
    List<DartType> tp = fnType.parameters.map((p) => p.type).whereType<TypeParameterType>().toList();
    for (var param in fnType.parameters) {
      if (param.type is FunctionType) {
        tp.addAll((param.type as FunctionType).parameters.map((p) => p.type).whereType<TypeParameterType>());
      }
    }
    return tp.isEmpty ? '' : '<${tp.map((t) => t.element).join(', ')}> ';
  }
}
