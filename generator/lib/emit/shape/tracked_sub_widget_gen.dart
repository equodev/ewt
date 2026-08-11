part of '../../gen.dart';

/// Emitter for user-subclassable widgets whose Dart factory must instantiate
/// a private `_Tracked${Name}` variant instead of the plain class. The
/// tracked variant (hand-written in `factories.dart`) overrides
/// `createElement()` to hook Flutter's Element lifecycle — without it,
/// widgets never leave the identity registry after Flutter unmounts them.
///
/// Applies to `SubStatefulWidget` and `SubStatelessWidget` (EWT-internal
/// bases). Both shared the exact same `_Tracked${node.displayName}`
/// override; this single class replaces the pair.
class TrackedSubWidgetGen extends SubclassGen {
  TrackedSubWidgetGen(super.types, super.dartClass);

  @override
  String dartFactoryCtorClass(FunctionTypedElement node) => '_Tracked${node.displayName}';
}
