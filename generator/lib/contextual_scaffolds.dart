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
//     code = wrap.template.replaceAll('{inner}', code);
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

/// A contextual-scaffold entry. `template` is the Java expression with an
/// `{inner}` placeholder; `contaminatesGetters` marks wrappers whose outer
/// Widget class exposes public getters that collide with common widget-under-
/// test getter names (e.g. `Scaffold.restorationId`, `Material.child`) — for
/// those, the variant emitter drops the getter round-trip EXPECTATIONS so
/// `WidgetNativeRenderTest`'s `GetterRoundTrip.verify` never resolves the
/// inner-widget-under-test's getter name against the outer wrapper's class,
/// which would call an unset FFM getter and SIGSEGV.
class ScaffoldEntry {
  final String template;
  final bool contaminatesGetters;
  const ScaffoldEntry(this.template, {this.contaminatesGetters = false});
}

/// Maps a Flutter widget class name to a scaffold entry, or returns `null`
/// when no scaffold is needed.
ScaffoldEntry? scaffoldFor(String widgetName) => _scaffolds[widgetName];

// ---------------------------------------------------------------------------
// Scaffold table (hand-curated — see file header)
// ---------------------------------------------------------------------------

const _sliverScaffold =
    'CustomScrollView.customScrollView().slivers(List.<WidgetI>of({inner})).build()';

const _stackScaffold =
    'dev.equo.ewt.Stack.stack().children(List.<WidgetI>of({inner})).build()';

const _rowScaffold = 'Row.row().children(List.<WidgetI>of({inner})).build()';

const _materialScaffold = 'Material.material().child({inner}).build()';

const _defaultTabCtrlScaffold =
    'DefaultTabController.defaultTabController(1).child({inner}).build()';

const _singleChildScrollScaffold =
    'SingleChildScrollView.singleChildScrollView().child({inner}).build()';

const Map<String, ScaffoldEntry> _scaffolds = {
  // Widgets that must be inside a Stack — they carry StackParentData / read
  // Stack layout knobs from the ParentData their ancestor writes. Includes
  // implicit-animation and transition variants of the same shape. Stack does
  // not share getter names with these widgets, so expectations are safe.
  'Positioned': ScaffoldEntry(_stackScaffold),
  'PositionedDirectional': ScaffoldEntry(_stackScaffold),
  'AnimatedPositioned': ScaffoldEntry(_stackScaffold),
  'AnimatedPositionedDirectional': ScaffoldEntry(_stackScaffold),
  'PositionedTransition': ScaffoldEntry(_stackScaffold),
  'RelativePositionedTransition': ScaffoldEntry(_stackScaffold),

  // Widgets that must be inside a flex container (bounded main-axis)
  'Expanded': ScaffoldEntry(_rowScaffold),
  'Flexible': ScaffoldEntry(_rowScaffold),
  'Spacer': ScaffoldEntry(_rowScaffold),

  // Tab system widgets
  'Tab': ScaffoldEntry(_defaultTabCtrlScaffold),
  'TabBar': ScaffoldEntry(_defaultTabCtrlScaffold),
  'TabBarView': ScaffoldEntry(_defaultTabCtrlScaffold),
  'TabPageSelector': ScaffoldEntry(_defaultTabCtrlScaffold),

  // Widgets that use Ink / Material.of internally need an actual Material
  // ancestor — MaterialApp alone is not enough. Material's public getters
  // (child, color, clipBehavior, elevation, shape, shadowColor,
  // surfaceTintColor, textStyle, borderRadius, animationDuration) overlap
  // with many wrapped widgets' param names → contaminatesGetters.
  'ListTile':
      ScaffoldEntry(_materialScaffold, contaminatesGetters: true),
  'AboutListTile':
      ScaffoldEntry(_materialScaffold, contaminatesGetters: true),
  'CheckboxListTile':
      ScaffoldEntry(_materialScaffold, contaminatesGetters: true),
  'SwitchListTile':
      ScaffoldEntry(_materialScaffold, contaminatesGetters: true),
  'CheckedPopupMenuItem':
      ScaffoldEntry(_materialScaffold, contaminatesGetters: true),
  'PopupMenuItem':
      ScaffoldEntry(_materialScaffold, contaminatesGetters: true),
  'Ink':
      ScaffoldEntry(_materialScaffold, contaminatesGetters: true),
  'ElevatedButton':
      ScaffoldEntry(_materialScaffold, contaminatesGetters: true),
  'FilledButton':
      ScaffoldEntry(_materialScaffold, contaminatesGetters: true),
  'OutlinedButton':
      ScaffoldEntry(_materialScaffold, contaminatesGetters: true),
  'TextButton':
      ScaffoldEntry(_materialScaffold, contaminatesGetters: true),
  'TextField':
      ScaffoldEntry(_materialScaffold, contaminatesGetters: true),
  'Slider':
      ScaffoldEntry(_materialScaffold, contaminatesGetters: true),
  'Tooltip':
      ScaffoldEntry(_materialScaffold, contaminatesGetters: true),
  'ChoiceChip':
      ScaffoldEntry(_materialScaffold, contaminatesGetters: true),
  'ExpansionTile':
      ScaffoldEntry(_materialScaffold, contaminatesGetters: true),
  'InteractiveViewer':
      ScaffoldEntry(_materialScaffold, contaminatesGetters: true),
  'SafeArea':
      ScaffoldEntry(_materialScaffold, contaminatesGetters: true),
  // BottomAppBar's State calls Scaffold.geometryOf(context) in
  // didChangeDependencies, which throws unless there is an actual Scaffold
  // ancestor — a plain Material is not enough.
  'BottomAppBar': ScaffoldEntry(
      'Scaffold.scaffold().body({inner}).build()',
      contaminatesGetters: true),

  // Widgets that require an Overlay ancestor — must be inside a Scaffold.
  // Scaffold contaminates getters (restorationId, backgroundColor, primary,
  // body, drawer), so expectations are dropped for these variants.
  'Draggable': ScaffoldEntry(
      'Scaffold.scaffold().body({inner}).build()',
      contaminatesGetters: true),
  'FloatingActionButton': ScaffoldEntry(
      'Scaffold.scaffold().floatingActionButton({inner}).build()',
      contaminatesGetters: true),

  // Drawer normally lives in Scaffold.drawer, but that slot only mounts its
  // child when the drawer is *open* — a closed drawer produces a
  // DrawerController with the Drawer widget lazily built, so the harness never
  // finds `Drawer` in the element tree. Mount the Drawer inline inside a
  // Material instead: Drawer is itself a Material-styled panel and lays out
  // fine as a regular child, which is enough for the render-in-tree assertion.
  'Drawer': ScaffoldEntry(_materialScaffold, contaminatesGetters: true),

  // Widgets that need a bounded scroll axis
  'ListBody': ScaffoldEntry(
      _singleChildScrollScaffold,
      contaminatesGetters: true),
  'ExpansionPanelList': ScaffoldEntry(
      _singleChildScrollScaffold,
      contaminatesGetters: true),

  // PopupMenuDivider is a bare ListTile-like row that needs a Column parent
  // so it lays out (no size intrinsics of its own).
  'PopupMenuDivider': ScaffoldEntry(
      'Column.column().children(List.<WidgetI>of({inner})).build()'),

  // NavigationDestination reads _NavigationDestinationInfo.of(context), which
  // is only provided by NavigationBar. NavigationBar asserts
  // destinations.length >= 2, so mount two copies of the variant.
  'NavigationDestination': ScaffoldEntry(
      'NavigationBar.navigationBar().addDestinations({inner}, {inner}).build()'),

  // NavigationDrawerDestination reads _NavigationDrawerDestinationInfo.of(
  // context), only provided by NavigationDrawer.
  'NavigationDrawerDestination': ScaffoldEntry(
      'NavigationDrawer.navigationDrawer(List.<WidgetI>of({inner}, {inner})).build()'),

  // Sliver widgets carry SliverConstraints / SliverGeometry — they need to
  // be mounted as slivers inside a `CustomScrollView.slivers`. Without this
  // wrapper the harness's default MaterialApp scaffold treats them as
  // RenderBoxes and Flutter throws `RenderSliver* is not a subtype of
  // RenderBox?` at layout time.
  'SliverList': ScaffoldEntry(_sliverScaffold),
  'SliverGrid': ScaffoldEntry(_sliverScaffold),
  'SliverPadding': ScaffoldEntry(_sliverScaffold),
  'SliverToBoxAdapter': ScaffoldEntry(_sliverScaffold),
  'SliverAnimatedOpacity': ScaffoldEntry(_sliverScaffold),
  'SliverFadeTransition': ScaffoldEntry(_sliverScaffold),
  'SliverSemantics': ScaffoldEntry(_sliverScaffold),
  'SliverEnsureSemantics': ScaffoldEntry(_sliverScaffold),
  'SliverVisibility': ScaffoldEntry(_sliverScaffold),
  'SliverOpacity': ScaffoldEntry(_sliverScaffold),
  'SliverOffstage': ScaffoldEntry(_sliverScaffold),
  'SliverSafeArea': ScaffoldEntry(_sliverScaffold),
  'SliverIgnorePointer': ScaffoldEntry(_sliverScaffold),
  'SliverFillRemaining': ScaffoldEntry(_sliverScaffold),
  'SliverFixedExtentList': ScaffoldEntry(_sliverScaffold),
  'SliverPrototypeExtentList': ScaffoldEntry(_sliverScaffold),
  'SliverVariedExtentList': ScaffoldEntry(_sliverScaffold),
  'SliverResizingHeader': ScaffoldEntry(_sliverScaffold),
  'SliverFloatingHeader': ScaffoldEntry(_sliverScaffold),
  'SliverConstrainedCrossAxis': ScaffoldEntry(_sliverScaffold),
  'SliverMainAxisGroup': ScaffoldEntry(_sliverScaffold),
  'SliverCrossAxisGroup': ScaffoldEntry(_sliverScaffold),
  'PinnedHeaderSliver': ScaffoldEntry(_sliverScaffold),
  'DecoratedSliver': ScaffoldEntry(_sliverScaffold),
  // Cupertino version of a scroll-sliver navbar has the same host requirement.
  'CupertinoSliverNavigationBar': ScaffoldEntry(_sliverScaffold),
};
