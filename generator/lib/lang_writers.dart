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
    List<DartType> tp = [];
    void collect(DartType t) {
      if (t is TypeParameterType) {
        tp.add(t);
      } else if (t is InterfaceType) {
        for (final ta in t.typeArguments) {
          collect(ta);
        }
      } else if (t is FunctionType) {
        for (final p in t.parameters) {
          collect(p.type);
        }
        collect(t.returnType);
      }
    }
    for (var p in fnType.parameters) {
      collect(p.type);
    }
    collect(fnType.returnType);
    // A `T` referenced in multiple params (e.g. `DragTarget<T>.builder` +
    // `.onAccept`) collects as duplicates — de-dup by TypeParameterElement so we
    // don't emit `<T extends NativeObj, T extends NativeObj>`.
    final seen = <Element>{};
    tp = tp.where((t) => seen.add((t as TypeParameterType).element)).toList();
    // A bare `T` or `T extends Object[?]` widens to `T extends NativeObj` so
    // marshaling via `ptrObj(Optional<T>)` (which requires NativeObj) compiles.
    // Also strip Dart variance markers (`in`, `out`) — Java has no equivalent.
    return tp.isEmpty ? '' : '<${tp.map((t) => t.element.toString()
        .replaceAll('Object?', 'NativeObj')
        .replaceAll(RegExp(r'\bextends Object\b'), 'extends NativeObj')
        .replaceAll(RegExp(r'^\s*(in|out|inout)\s+'), '')).join(', ')}> ';
  }
}
