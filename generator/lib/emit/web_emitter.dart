part of '../gen.dart';

/// Web-side emitters: entries in [EmitContext.dartWebDecoders] mapping factory
/// names to pure-Dart reconstructors, plus the predicate that decides whether
/// a factory is web-decodable at all.
extension _WebEmit on WidgetGen {
  /// Emits one entry into [EmitContext.dartWebDecoders]:
  /// `'factoryName': (p) => WidgetClass[.factory](args)`, where each arg is
  /// decoded from the node's JSON params (mirrors writeDFactory's construction
  /// call with the paramValueJson strategy). Skips void factories (no value
  /// to build).
  void writeWebDecoder(String factory, String factoryName, FunctionTypedElement node) {
    if (node.returnType is VoidType) return;
    // Widgets with a bespoke web decoder (or that need to be skipped entirely
    // because they're eager-expanded at serialize time) opt in here.
    if (tryEmitCustomWebDecoder(factory, factoryName, node)) return;
    if (!_webDecodable(node)) return;
    final jsonParams = Params(types, node.parameters, Params.paramDef4D, paramValue: Params.paramValueJson);
    final ctor = '$widgetClass${node.name!.isEmpty ? '' : '.$factory'}';
    ctx.dartWebDecoders.writeln("  '$factoryName': (p) => $ctor(${jsonParams.names}),");
  }

  /// Web decoder for a companion instance method: `receiver.method(args)`. The
  /// receiver is the first companion param (a recorded node); remaining params
  /// decode from JSON. A method with no extra args is emitted as a getter access
  /// (matches Flutter getters like MaterialColor.shade600).
  void writeWebInstanceDecoder(String factory, String factoryName, FunctionTypedElement node) {
    if (node.returnType is VoidType) return;
    if (!_webDecodable(node)) return;
    final recv = node.parameters.first;
    final recvType = recv.type is InterfaceType ? (recv.type as InterfaceType).element.name : 'dynamic';
    final recvExpr = "decodeEwtNode(p['${recv.name}'] as Map<String,dynamic>) as $recvType";
    final rest = node.parameters.skip(1).toList();
    final call = rest.isEmpty
        ? '.$factory'
        : '.$factory(${Params(types, rest, Params.paramDef4D, paramValue: Params.paramValueJson).names})';
    ctx.dartWebDecoders.writeln("  '$factoryName': (p) => ($recvExpr)$call,");
  }

  /// Whether a factory can be rebuilt from a serialized JSON tree in pure Dart.
  /// Excludes out-of-scope constructions that need live runtime objects or
  /// non-inert callbacks: EWT state wrappers (Sub*), render-layer internals
  /// (*ParentData), Animation/CurvedAnimation params, Map params, and builder
  /// callbacks that return a value (an inert closure can't stand in for a
  /// widget-returning builder). These fall back to "no decoder" (logged) at
  /// runtime.
  bool _webDecodable(FunctionTypedElement node) {
    if (widgetClass.startsWith('Sub') || widgetClass.endsWith('ParentData')) return false;
    // Dialogs are shown imperatively (showDialog + BuildContext), not placed in a static tree.
    if (widgetClass.endsWith('Dialog')) return false;
    for (final p in node.parameters.where((p) => types.supportedType(p.type))) {
      // Optional params that can't cross the wire are omitted from the decoder (the widget uses
      // its default), so they don't disqualify the widget — see _webSkippable / _paramValueJsonRaw.
      if (_webSkippable(p)) continue;
      final t = p.type;
      if (t is InterfaceType) {
        final n = t.element.name;
        if (n == 'Animation' || n == 'CurvedAnimation' || t.isDartCoreMap) return false;
        // OverflowBoxFit lives in Flutter's private src/rendering and is not re-exported by any
        // public library, so the decoder file cannot import it. Only reachable here when it is a
        // required param (the optional case is omitted by _webSkippable, e.g. OverflowBox).
        if (n == 'OverflowBoxFit') return false;
        // BoxWidthStyle/BoxHeightStyle (TextField.selection*Style) are likewise not importable in
        // the pure-Dart decoder file; blocking them keeps TextField out of scope until the text-
        // input round-trip lands (a separate effort) rather than half-enabling an inert field.
        if (n == 'BoxWidthStyle' || n == 'BoxHeightStyle') return false;
      }
      // A value-returning callback can't be stood in for by an inert closure; only reachable when
      // required (optional ones are omitted by _webSkippable, e.g. Slider.semanticFormatterCallback).
      if (t is FunctionType && t.returnType is! VoidType) return false;
      final alias = t.alias;
      if (alias != null) {
        final at = alias.element.aliasedType;
        if (at is FunctionType && at.returnType is! VoidType) return false;
      }
    }
    return true;
  }
}

/// An optional param that cannot be represented in the pure-Dart web decoder,
/// so the decoder omits it and the widget falls back to its own default. Two
/// kinds of blocker qualify — both only ever optional in practice:
/// value-returning callbacks (inline or via a typedef alias, e.g.
/// `SemanticFormatterCallback = String Function(double)`), which an inert
/// closure can't stand in for; and private, non-importable enums
/// (OverflowBoxFit, BoxWidthStyle, BoxHeightStyle). Keeps a widget
/// web-decodable when such a param is its only blocker (Slider, OverflowBox).
///
/// Free function rather than a static method on WidgetGen — it has no
/// receiver and both [_WebEmit._webDecodable] and [Params] call it.
bool _webSkippable(ParameterElement p) {
  if (!p.isOptional) return false;
  final t = p.type;
  final ft = t is FunctionType
      ? t
      : (t.alias?.element.aliasedType is FunctionType
          ? t.alias!.element.aliasedType as FunctionType
          : null);
  if (ft != null && ft.returnType is! VoidType) return true;
  if (t is InterfaceType && t.element.name == 'OverflowBoxFit') return true;
  // TextField.selectionWidthStyle/selectionHeightStyle (BoxWidthStyle/BoxHeightStyle,
  // from dart:ui) are cosmetic and not importable in the pure-Dart decoder; omit the
  // optional param and let the field use its Flutter default.
  if (t is InterfaceType &&
      (t.element.name == 'BoxWidthStyle' || t.element.name == 'BoxHeightStyle')) return true;
  return false;
}
