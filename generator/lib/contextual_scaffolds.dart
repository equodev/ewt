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

const _sliverScaffold =
    'CustomScrollView.customScrollView().slivers(List.<WidgetI>of({inner})).build()';

const _stackScaffold =
    'dev.equo.ewt.Stack.stack().children(List.<WidgetI>of({inner})).build()';

const _materialScaffold = 'Material.material().child({inner}).build()';

const _defaultTabCtrlScaffold =
    'DefaultTabController.defaultTabController(1).child({inner}).build()';

const Map<String, String> _scaffolds = {
  // Widgets that must be inside a Stack — they carry StackParentData / read
  // Stack layout knobs from the ParentData their ancestor writes. Includes
  // implicit-animation and transition variants of the same shape.
  'Positioned': _stackScaffold,
  'PositionedDirectional': _stackScaffold,
  'AnimatedPositioned': _stackScaffold,
  'AnimatedPositionedDirectional': _stackScaffold,
  'PositionedTransition': _stackScaffold,
  'RelativePositionedTransition': _stackScaffold,

  // Widgets that must be inside a flex container
  'Expanded': 'Row.row().children(List.<WidgetI>of({inner})).build()',
  'Flexible': 'Row.row().children(List.<WidgetI>of({inner})).build()',
  'Spacer': 'Row.row().children(List.<WidgetI>of({inner})).build()',

  // Tab system widgets
  'Tab': _defaultTabCtrlScaffold,
  'TabBar': _defaultTabCtrlScaffold,
  'TabBarView': _defaultTabCtrlScaffold,
  'TabPageSelector': _defaultTabCtrlScaffold,

  // Widgets that use Ink / Material.of internally need an actual Material
  // ancestor — MaterialApp alone is not enough. Includes the button family
  // (ElevatedButton / FilledButton / OutlinedButton / TextButton), the
  // ink-based visuals (Ink, InkWell), and Slider / Tooltip / ExpansionTile.
  'ListTile': _materialScaffold,
  'AboutListTile': _materialScaffold,
  'CheckboxListTile': _materialScaffold,
  'SwitchListTile': _materialScaffold,
  'CheckedPopupMenuItem': _materialScaffold,
  'PopupMenuItem': _materialScaffold,
  'Ink': _materialScaffold,
  'ElevatedButton': _materialScaffold,
  'FilledButton': _materialScaffold,
  'OutlinedButton': _materialScaffold,
  'TextButton': _materialScaffold,
  'Slider': _materialScaffold,
  'Tooltip': _materialScaffold,
  'ExpansionTile': _materialScaffold,
  'BottomAppBar': _materialScaffold,
  'Drawer': 'Scaffold.scaffold().drawer({inner}).build()',

  // NavigationDestination reads _NavigationDestinationInfo.of(context), which
  // is only provided by NavigationBar. NavigationBar asserts
  // destinations.length >= 2, so mount two copies of the variant.
  'NavigationDestination':
      'NavigationBar.navigationBar().addDestinations({inner}, {inner}).build()',

  // NavigationDrawerDestination reads _NavigationDrawerDestinationInfo.of(
  // context), only provided by NavigationDrawer.
  'NavigationDrawerDestination':
      'NavigationDrawer.navigationDrawer(List.<WidgetI>of({inner}, {inner})).build()',

  // Sliver widgets carry SliverConstraints / SliverGeometry — they need to
  // be mounted as slivers inside a `CustomScrollView.slivers`. Without this
  // wrapper the harness's default MaterialApp scaffold treats them as
  // RenderBoxes and Flutter throws `RenderSliver* is not a subtype of
  // RenderBox?` at layout time.
  'SliverList': _sliverScaffold,
  'SliverGrid': _sliverScaffold,
  'SliverPadding': _sliverScaffold,
  'SliverToBoxAdapter': _sliverScaffold,
  'SliverAnimatedOpacity': _sliverScaffold,
  'SliverFadeTransition': _sliverScaffold,
  'SliverSemantics': _sliverScaffold,
  'SliverEnsureSemantics': _sliverScaffold,
  'SliverVisibility': _sliverScaffold,
  'SliverOpacity': _sliverScaffold,
  'SliverOffstage': _sliverScaffold,
  'SliverSafeArea': _sliverScaffold,
  'SliverIgnorePointer': _sliverScaffold,
  'SliverFillRemaining': _sliverScaffold,
  'SliverFixedExtentList': _sliverScaffold,
  'SliverPrototypeExtentList': _sliverScaffold,
  'SliverVariedExtentList': _sliverScaffold,
  'SliverResizingHeader': _sliverScaffold,
  'SliverFloatingHeader': _sliverScaffold,
  'SliverConstrainedCrossAxis': _sliverScaffold,
  'SliverMainAxisGroup': _sliverScaffold,
  'SliverCrossAxisGroup': _sliverScaffold,
  'PinnedHeaderSliver': _sliverScaffold,
  'DecoratedSliver': _sliverScaffold,
  // Cupertino version of a scroll-sliver navbar has the same host requirement.
  'CupertinoSliverNavigationBar': _sliverScaffold,
};
