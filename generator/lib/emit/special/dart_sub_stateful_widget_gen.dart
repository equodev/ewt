part of '../../gen.dart';

/// Pregeneration emitter for `SubStatefulWidget` — the Dart-side subclass
/// forces a `UniqueKey()` default so that navigating between two instances
/// (which all share `runtimeType == SubStatefulWidget` and would otherwise
/// share a null key) does not make Flutter's reconciliation reuse the
/// previous State — whose `buildFn` is still bound to the previous Java
/// widget.
class DartSubStatefulWidgetGen extends DartSubclassGen {
  DartSubStatefulWidgetGen(super.generation, super.dartClass);

  @override
  String customizeCtor(List<String> params) {
    final keyIdx = params.indexOf('super.key');
    if (keyIdx >= 0) params[keyIdx] = 'Key? key';
    return ' : super(key: key ?? UniqueKey())';
  }
}
