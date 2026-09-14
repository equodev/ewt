part of 'factories.dart';

/// Runtime side of `widgetTypeOf` — see generator-side spec in
/// `generator/lib/type_registry_helpers.dart` for the rationale.
///
/// Returns the widget's Dart `runtimeType.toString()`, or empty string
/// when the id doesn't map to anything (0 / -1 / already-freed).
String widgetTypeOf(int id) {
  final v = _widgetsMap[id];
  return v == null ? '' : v.runtimeType.toString();
}
