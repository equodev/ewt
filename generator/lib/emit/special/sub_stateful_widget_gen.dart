part of '../../gen.dart';

/// Emitter for `SubStatefulWidget<T>`.
///
/// The Dart-side factory calls the private `_TrackedSubStatefulWidget`
/// (hand-written in factories.dart) that overrides `createElement()` to
/// hook Flutter's Element lifecycle — without this, widgets never leave
/// the identity registry after Flutter unmounts them.
class SubStatefulWidgetGen extends SubclassGen {
  SubStatefulWidgetGen(super.types, super.dartClass);

  @override
  String dartFactoryCtorClass(FunctionTypedElement node) => '_Tracked${node.displayName}';
}
