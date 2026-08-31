// generator/lib/contextual_scaffolds.dart
//
// Hand-curated map of widget names → Java template strings that wrap a widget
// in the parent it needs in order to render correctly at the root of a test
// variant.
//
// Usage in the emitter (Task 4.3):
//
//   final wrap = scaffoldFor(widgetName);
//   if (wrap != null) {
//     code = wrap.replaceAll('{inner}', code);
//   }
//
// The `{inner}` placeholder is replaced with the widget-under-test expression.
// Templates are valid Java snippets — the emitter inserts them directly into
// the generated `build()` method body.
//
// This map is intentionally small and grows with observed layout failures.
// Do not attempt to be exhaustive; add entries when Task 4.3's emitter hits an
// actual rendering failure for a specific widget.

// ignore_for_file: unused_element

/// Maps a Flutter widget class name to a Java-template scaffold string with a
/// `{inner}` placeholder, or returns `null` when no scaffold is needed.
String? scaffoldFor(String widgetName) => _scaffolds[widgetName];

// ---------------------------------------------------------------------------
// Scaffold table (hand-curated — see file header)
// ---------------------------------------------------------------------------

const Map<String, String> _scaffolds = {
  // Widgets that must be inside a Stack
  'Positioned': 'dev.equo.ewt.Stack.stack().children(List.<WidgetI>of({inner})).build()',
  'Positioned_fill': 'dev.equo.ewt.Stack.stack().children(List.<WidgetI>of({inner})).build()',

  // Widgets that must be inside a flex container
  'Expanded': 'Row.row().children(List.<WidgetI>of({inner})).build()',
  'Flexible': 'Row.row().children(List.<WidgetI>of({inner})).build()',
  'Spacer': 'Row.row().children(List.<WidgetI>of({inner})).build()',

  // Tab system widgets
  'Tab': 'DefaultTabController.defaultTabController(1).child({inner}).build()',
  'TabBar':
      'DefaultTabController.defaultTabController(1).child({inner}).build()',
  'TabBarView':
      'DefaultTabController.defaultTabController(1).child({inner}).build()',

  // Widgets that use Ink / Material.of internally need an actual Material
  // ancestor — MaterialApp alone is not enough.
  'ListTile': 'Material.material().child({inner}).build()',
  'CheckboxListTile': 'Material.material().child({inner}).build()',
  'SwitchListTile': 'Material.material().child({inner}).build()',
  'CheckedPopupMenuItem': 'Material.material().child({inner}).build()',

  // Drawer must be placed inside a Scaffold
  'Drawer':
      'Scaffold.scaffold().drawer({inner}).build()',

  // PopupMenuItem must be inside a PopupMenuButton context; use a simple
  // Column wrapper so the item can render for snapshot purposes
  'PopupMenuItem':
      'Column.column().children(List.<WidgetI>of({inner})).build()',

  // NavigationDestination reads _NavigationDestinationInfo.of(context), which
  // is only provided by NavigationBar. NavigationBar asserts
  // destinations.length >= 2, so mount two copies of the variant.
  'NavigationDestination':
      'NavigationBar.navigationBar().addDestinations({inner}, {inner}).build()',

  // NavigationDrawerDestination reads _NavigationDrawerDestinationInfo.of(
  // context), only provided by NavigationDrawer.
  'NavigationDrawerDestination':
      'NavigationDrawer.navigationDrawer(List.<WidgetI>of({inner}, {inner})).build()',

};
