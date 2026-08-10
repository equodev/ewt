part of '../../gen.dart';

/// Emitter for `SubStatelessWidget`. Same pattern as SubStatefulWidgetGen:
/// the factory instantiates the tracked variant so createElement() cleanup
/// runs on unmount.
class SubStatelessWidgetGen extends SubclassGen {
  SubStatelessWidgetGen(super.types, super.dartClass);

  @override
  String dartFactoryCtorClass(FunctionTypedElement node) => '_Tracked${node.displayName}';
}
