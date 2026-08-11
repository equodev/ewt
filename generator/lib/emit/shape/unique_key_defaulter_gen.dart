part of '../../gen.dart';

/// Pregeneration emitter that forces a `UniqueKey()` default in the
/// generated Dart subclass ctor — used for `StatefulWidget`-derived
/// wrappers so navigating between two instances (which all share
/// `runtimeType == SubStatefulWidget` and would otherwise share a null
/// key) does not make Flutter's reconciliation reuse the previous State,
/// whose `buildFn` is still bound to the previous Java widget.
///
/// Wired from [DartSubclassGen.forWidget]; today only Flutter's
/// `StatefulWidget` triggers it. The pattern (widget with shared
/// runtimeType across instances that needs a per-instance Key) is the
/// stable shape, not the specific class name — hence the behavior-based
/// name rather than a widget-specific one.
class UniqueKeyDefaulterGen extends DartSubclassGen {
  UniqueKeyDefaulterGen(super.generation, super.dartClass);

  @override
  String customizeCtor(List<String> params) {
    final keyIdx = params.indexOf('super.key');
    if (keyIdx >= 0) params[keyIdx] = 'Key? key';
    return ' : super(key: key ?? UniqueKey())';
  }
}
