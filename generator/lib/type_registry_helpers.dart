/// Top-level bridge picked up by the generator (via
/// `const widgetTypeOf = trh.widgetTypeOf;` in `generation_index.dart`) and
/// exposed on the Java side as `EWT.widgetTypeOf(id)` / internally as
/// `WidgetConstructors.type_registry_helpersWidgetTypeOf`.
///
/// Returns the Dart `runtimeType.toString()` of the value the Dart runtime
/// registered under [id] in `_widgetsMap` (see `widgets/lib/factories.dart`).
/// Used by the Java-side marshaller when a callback delivers an `Object?`
/// arg — the id alone doesn't tell us which concrete Java wrapper to
/// build, but pairing the id with the runtime type name lets
/// `NativeObj.byIdAndType(id, name)` look up the registered `byId`
/// constructor and return a properly-typed instance.
///
/// This is the runtime side of the type-registry facility described in
/// `NativeObj.java`; the generator emits per-class `NativeObj.register(...)`
/// static blocks that populate the lookup table.
String widgetTypeOf(int id) => '';
