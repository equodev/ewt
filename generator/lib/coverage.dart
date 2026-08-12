part of 'gen.dart';

/// Structured record of what the generator actually emitted, per widget and
/// per constructor.
///
/// `docs/coverage.md` used to tick a widget as "supported" whenever its name
/// appeared in `generation_index.dart`. That over-reports in three ways:
///
///  1. an *optional* param whose type can't be marshalled is silently skipped
///     ([Params]'s `supportedType` filter), so the Java setter never exists;
///  2. a param with an unresolvable private default is skipped the same way
///     ([hasPrivateDefault]);
///  3. if every constructor has at least one *required* unmarshalable param,
///     no factory is emitted at all — the `.java` file is still written (it is
///     needed as a parent type / parameter type) but `EWT.<Widget>(…)` does
///     not exist.
///
/// A fourth case is nastier: the setter exists and does nothing. Optional
/// params the pure-Dart web decoder cannot represent are omitted from the
/// decoded constructor call ([_webSkippable]), and arg-carrying callbacks that
/// are neither zero-arg nor single-value only reserve a callback id — they
/// never fire.
///
/// This class collects all four as the generator runs and serialises them to
/// `build/coverage_status.json`, which `tool/coverage_audit.dart` consumes to
/// build an honest `docs/coverage.md`.
///
/// Static, like [Diagnostics], because the generator is a one-shot script
/// with nothing to inject a collector into.
class CoverageReport {
  /// Sorted so the JSON is byte-stable across runs — CI only commits
  /// `docs/coverage.md` when the content actually changed, and a re-ordered
  /// map would produce a spurious diff.
  static final SplayTreeMap<String, WidgetCoverage> _widgets = SplayTreeMap();

  static void reset() => _widgets.clear();

  static WidgetCoverage _of(String widget) =>
      _widgets.putIfAbsent(widget, () => WidgetCoverage(widget));

  /// Records the class-level outcome for [dartClass]. [hasMembers] mirrors
  /// `WidgetGen.hasMembers`: false on a concrete class means nothing callable
  /// was emitted (case 3 above).
  static void recordWidget(ClassElement dartClass, {required bool hasMembers}) {
    _of(dartClass.name)
      ..isAbstract = dartClass.isAbstract
      ..hasMembers = hasMembers
      ..javaClassEmitted = true;
  }

  /// Records one constructor / static factory. Called for every candidate,
  /// including the ones [WidgetGen.writeFactory] bails out of, so a dropped
  /// constructor is visible rather than absent.
  static void recordFactory(
    String widget,
    FunctionTypedElement node,
    Types types, {
    required bool emitted,
  }) {
    final name = (node.name == null || node.name!.isEmpty) ? '' : node.name!;
    final cov = FactoryCoverage(
      name: name,
      kind: node is ConstructorElement ? 'ctor' : 'static',
      emitted: emitted,
      totalParams: node.parameters.length,
    );
    for (final p in node.parameters) {
      final issue = _classify(types, p);
      if (issue == null) continue;
      cov.bucketFor(issue).add(issue);
    }
    // A constructor is dropped as a whole because of its *required* params;
    // surface which ones so the report says why, not just that.
    if (!emitted) {
      for (final p in node.parameters.where((p) => p.isRequired && !types.supportedType(p.type))) {
        cov.blockedBy.add(ParamIssue(p.name, _typeName(p.type), 'unsupported-type', inert: false));
      }
      if (!types.supportedType(node.returnType)) {
        cov.blockedBy.add(ParamIssue('<return>', _typeName(node.returnType), 'unsupported-type', inert: false));
      }
    }
    _of(widget).factories.add(cov);
  }

  /// Params EWT deliberately does not model, so their absence is not a gap.
  ///
  /// `key` is on all ~180 widgets: Flutter identifies widgets across rebuilds
  /// with a `Key`, EWT with the integer id it assigns on the Java side. Counting
  /// it would mark every single widget partial and bury the real gaps.
  /// Still recorded in the JSON (under `excluded`) so the report is complete —
  /// the audit just doesn't score it.
  static bool _byDesign(ParameterElement p) =>
      p.name == 'key' && _typeName(p.type).startsWith('Key');

  /// Why [p] will not be usable from Java, or null when it round-trips fine.
  ///
  /// Order matters: a param dropped outright (no setter) is reported as
  /// dropped even if it would also have been web-skippable, because the
  /// stronger failure is the one the user hits first.
  static ParamIssue? _classify(Types types, ParameterElement p) {
    final type = _typeName(p.type);
    if (_byDesign(p)) {
      return ParamIssue(p.name, type, 'not-modelled', inert: false, excluded: true);
    }
    if (!types.supportedType(p.type)) {
      // Required unmarshalable params kill the whole constructor; they are
      // reported via blockedBy, not as a per-param drop.
      if (p.isRequired) return null;
      return ParamIssue(p.name, type, 'unsupported-type', inert: false);
    }
    if (hasPrivateDefault(p)) {
      return ParamIssue(p.name, type, 'private-default', inert: false);
    }
    if (_webSkippable(p)) {
      return ParamIssue(p.name, type, 'web-skipped', inert: true);
    }
    if (types.getHandler(p.type) != null &&
        !_isZeroArgCallback(p.type) &&
        _valueCallbackJavaType(p.type) == null) {
      return ParamIssue(p.name, type, 'callback-not-wired', inert: true);
    }
    return null;
  }

  static String _typeName(DartType t) => t.getDisplayString();

  /// Pretty-printed so the file reviews cleanly in a merge request diff.
  static String toJson() {
    final out = <String, dynamic>{};
    for (final e in _widgets.entries) {
      out[e.key] = e.value.toJson();
    }
    return '${const JsonEncoder.withIndent('  ').convert(out)}\n';
  }

  static void write() {
    const file = 'build/coverage_status.json';
    print('Generating $file');
    File(file)
      ..createSync(recursive: true)
      ..writeAsStringSync(toJson());
  }
}

/// One param that will not work from Java, and why.
class ParamIssue {
  final String name;
  final String type;

  /// One of `unsupported-type`, `private-default` (no setter emitted),
  /// `web-skipped`, `callback-not-wired` (setter emitted but inert), or
  /// `not-modelled` (deliberately out of scope — see [CoverageReport._byDesign]).
  final String reason;

  /// True when the setter exists but has no effect at runtime.
  final bool inert;

  /// True when this param is out of scope by design and must not be scored.
  final bool excluded;

  ParamIssue(this.name, this.type, this.reason, {required this.inert, this.excluded = false});

  Map<String, dynamic> toJson() => {'name': name, 'type': type, 'reason': reason};
}

class FactoryCoverage {
  final String name;
  final String kind;
  final bool emitted;
  final int totalParams;
  final List<ParamIssue> dropped = [];
  final List<ParamIssue> inert = [];
  final List<ParamIssue> excluded = [];
  final List<ParamIssue> blockedBy = [];

  FactoryCoverage({
    required this.name,
    required this.kind,
    required this.emitted,
    required this.totalParams,
  });

  /// Params counted against the widget: [totalParams] minus the ones EWT does
  /// not model at all, so a widget whose only "gap" is `key` reads as complete.
  int get scoredParams => totalParams - excluded.length;

  List<ParamIssue> bucketFor(ParamIssue i) =>
      i.excluded ? excluded : (i.inert ? inert : dropped);

  List<Map<String, dynamic>> _sorted(List<ParamIssue> l) =>
      (l.toList()..sort((a, b) => a.name.compareTo(b.name))).map((i) => i.toJson()).toList();

  Map<String, dynamic> toJson() => {
        'name': name,
        'kind': kind,
        'emitted': emitted,
        'params': scoredParams,
        if (dropped.isNotEmpty) 'dropped': _sorted(dropped),
        if (inert.isNotEmpty) 'inert': _sorted(inert),
        if (excluded.isNotEmpty) 'excluded': _sorted(excluded),
        if (blockedBy.isNotEmpty) 'blockedBy': _sorted(blockedBy),
      };
}

class WidgetCoverage {
  final String name;
  bool isAbstract = false;
  bool hasMembers = false;
  bool javaClassEmitted = false;
  final List<FactoryCoverage> factories = [];

  WidgetCoverage(this.name);

  Map<String, dynamic> toJson() => {
        'abstract': isAbstract,
        'javaClass': javaClassEmitted,
        'hasFactory': factories.any((f) => f.emitted),
        'factories': (factories.toList()
              ..sort((a, b) => a.name.compareTo(b.name)))
            .map((f) => f.toJson())
            .toList(),
      };
}
