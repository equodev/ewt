/// Central opt-in for the `.of(context)` affordance.
///
/// For each widget name listed here, the generator locates the widget's
/// `static Widget.of(BuildContext)` static, takes its return type as the
/// ambient state/data class, then introspects *that* class's class-declared
/// public instance methods. For each method whose signature type-checks it
/// emits
///
///   public static <ret> <method>(BuildContext ctx, <args>)
///
/// on the widget's Java class, with a runtime body that dispatches through
/// `Widget.of(context).method(args)`. This is the equivalent of writing a
/// `<Widget>Methods` companion file whose statics all say
/// `Widget.of(context).X(...)`, but without the per-widget boilerplate.
///
/// Add one line here per widget instead of writing a `_methods.dart` file.
const Set<String> contextBoundWidgets = <String>{
  'ScaffoldMessenger',
};
