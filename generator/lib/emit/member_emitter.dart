part of '../gen.dart';

/// Strategy for the widget's `writeMembers()` pass — the per-widget block
/// that runs between constructors and the synthetic `build()`. Different
/// widget shapes emit wildly different bodies here, so replacing the
/// override-3-times pattern (WidgetGen empty, ImmutableGen, SubclassGen)
/// with a strategy makes each variant self-contained:
///
///   * [NoneMemberEmitter]      — the default for plain widgets, emits
///                                nothing.
///   * [ImmutableMemberEmitter] — struct header + callable-field
///                                accessors + `_create*ObjSt` factory
///                                body. Used by ImmutableGen and its
///                                subclasses (MaterialColorGen, ListViewGen).
///   * [SubclassMemberEmitter]  — abstract-method scaffolding for
///                                user-subclassable state (Sub*Gen),
///                                the widget() accessor for State<T>,
///                                extra Java members. Delegates to
///                                SubclassGen's emit* hooks.
///
/// WidgetGen exposes `MemberEmitter get memberEmitter` (default
/// [NoneMemberEmitter]); ImmutableGen and SubclassGen override the getter.
/// Their subclasses (SubStateGen, MaterialColorGen, etc.) inherit the
/// override unchanged — the strategy captures the *shape* of the block,
/// not the widget identity.
abstract class MemberEmitter {
  const MemberEmitter();
  void emit(WidgetGen wg);
}

class NoneMemberEmitter implements MemberEmitter {
  const NoneMemberEmitter();
  @override
  void emit(WidgetGen wg) {}
}

/// The @Immutable widget shape: struct header, per-field Java accessor +
/// C struct entry, then a Dart `_create*ObjSt(w)` factory function that
/// materializes the id-only struct and populates each field via
/// [Params.paramValueDtoC].
class ImmutableMemberEmitter implements MemberEmitter {
  const ImmutableMemberEmitter();

  @override
  void emit(WidgetGen wg) {
    final gen = wg as ImmutableGen;
    gen.writeStructHeader();

    for (final field in gen.callableFields()) {
      gen.ctx.objectsHFile.writeln('  ${CLang(gen.types).field(field.name, gen.types.type4C(field.type))}');
      gen.writeJavaFieldAccessor(field);
    }

    gen.writeStructFooter();

    if (!gen.hasMembers) return;

    gen.ctx.dartFns
      ..writeln('${gen.widgetSt} _create${gen.widgetSt}(${gen.widgetClass}? w) {');

    gen.writeDartStructCreation('w');
    gen.ctx.dartFns.writeln('  if (w == null) return stObj;');

    for (var m in gen.callableFields()) {
      gen.ctx.dartFns
          .writeln('  stObj.${m.name} = ${Params.paramValueDtoC(gen.types, paramElement('w.${m.name}', m.type))};');
    }

    gen.writeDartStructReturn();
  }
}

/// The user-subclass shape (SubState / SubAnimatedState /
/// SubStatefulWidget / SubStatelessWidget): protected-abstract Java hooks
/// for each overridable Flutter method + `Fn` shims that adapt the
/// Java-side signature to the FFM Consumer, followed by the ObjSt struct
/// pass and any strategy-specific extras (widget() accessor,
/// webWidget field, anim sink).
class SubclassMemberEmitter implements MemberEmitter {
  const SubclassMemberEmitter();

  @override
  void emit(WidgetGen wg) {
    final gen = wg as SubclassGen;
    for (final method in gen.dartClass.supertype!.element.methods.where(canBeImplInJava)) {
      var returnType = method.returnType;
      var ret = '${method.returnType}';
      var retBuilder = ret;
      if (returnType is InterfaceType && returnType.typeArguments.isNotEmpty) {
        ret = '<${returnType.typeArguments.map((p) => '${p.getDisplayString()[0]} extends ${p.getDisplayString()}').join(', ')}> ${returnType.element.name}<${returnType.typeArguments.map((p) => p.element?.name.toString()[0]).join(', ')}>';
        retBuilder = '<${returnType.typeArguments.map((p) => '${p.getDisplayString()[0]} extends ${p.getDisplayString()}').join(', ')}> ${returnType.element.name}<${returnType.typeArguments.map((p) => p.element?.name.toString()[0]).join(', ')}>';
      }
      final jParams = Params(gen.types, method.parameters, Params.paramDef4J, paramValue: Params.paramValue4JBuilder, escape: Params.escape4J);
      // Preserve `T` on the *public* hook so `didUpdateWidget(T oldWidget)` gives user code
      // the concrete widget type (needed for widget().<prop> access). Keep `NativeObj` on the
      // `Fn` shim so its method reference matches the Consumer<NativeObj> parameter that
      // WidgetConstructors emits (type4J widens TypeParameterType → NativeObj globally, and
      // the shim must honor that contract — the cast is unchecked but safe under generic
      // erasure since T extends StatefulWidget and NativeObj carries the id).
      final publicDecl = method.parameters
          .where((p) => gen.types.supportedType(p.type) && !hasPrivateDefault(p))
          .map((p) {
            final typeStr = p.type is TypeParameterType && !p.isOptional
                ? (p.type as TypeParameterType).element.name
                : Params.paramDef4J(gen.types, p, wrap: p.isOptional);
            return '$typeStr ${Params.escape4J(gen.types, p)}';
          }).join(', ');
      final callArgs = method.parameters
          .where((p) => gen.types.supportedType(p.type) && !hasPrivateDefault(p))
          .map((p) => p.type is TypeParameterType && !p.isOptional
              ? '(${(p.type as TypeParameterType).element.name}) ${Params.escape4J(gen.types, p)}'
              : Params.paramValue4JBuilder(gen.types, p))
          .where((v) => v.isNotEmpty)
          .join(', ');
      final hasTpParam = method.parameters.any((p) => p.type is TypeParameterType && !p.isOptional);
      gen.ctx.javaFile.writeln('  protected ${method.isAbstract ? 'abstract ' : ''}$retBuilder ${method.name}($publicDecl)${method.isAbstract ? ';' : ' {}'}');
      if (hasTpParam) {
        gen.ctx.javaFile.writeln('  @SuppressWarnings("unchecked")');
      }
      gen.ctx.javaFile.writeln('  ${ret} ${method.name}Fn(${jParams.decl}) {');
      if (returnType is VoidType) {
        gen.ctx.javaFile.writeln('    ${method.name}($callArgs);');
      } else {
        gen.ctx.javaFile.writeln('    return ${method.name}($callArgs).build();');
      }
      gen.ctx.javaFile.writeln('  }');
    }

    gen.writeStructHeader();

    for (final field in gen.callableFields()) {
      gen.ctx.objectsHFile.writeln('  ${CLang(gen.types).field(field.name, gen.types.type4C(field.type), params: [])}');
      gen.writeJavaFieldAccessor(field, useInvoke: true);
    }

    for (final method in gen.callableMethods()) {
      gen.ctx.objectsHFile.writeln('  ${CLang(gen.types).field(method.name, '${method.returnType}', params: method.parameters)}');
      final jParams = Params(gen.types, method.parameters, Params.paramDef4J, paramValue: gen.types.paramValue4FFM, escape: Params.escape4J);
      gen.ctx.javaFile
        ..writeln('  protected ${method.returnType} ${method.name}(${jParams.decl}) {');
      if (method.name == 'setState') gen.emitSetStateWebPrelude();
      gen.ctx.javaFile
        ..writeln('    MemorySegment funcPtr = ${gen.widgetSt}.${method.name}(st);')
        ..writeln('    ${gen.widgetSt}.${method.name}.invoke(funcPtr, factories.${jParams.names});')
        ..writeln('  }');
    }

    gen.emitStateWidgetAccessor();

    gen.writeStructFooter();

    gen.emitExtraStateJavaMembers();
  }
}
