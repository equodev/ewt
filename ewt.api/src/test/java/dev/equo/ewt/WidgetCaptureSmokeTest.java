package dev.equo.ewt;

import static dev.equo.ewt.EWT.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.*;
import org.junit.jupiter.api.Test;

/**
 * Smoke tests for every widget builder via EwtWebCapture.captureSubtree().
 * Verifies each widget serializes without exception on the web/serializing path.
 * No native engine required — runs in CI.
 */
class WidgetCaptureSmokeTest {

  /** Runs a non-Widget NativeObj factory under SerializingWidgetConstructors. */
  private static <T extends NativeObj> T buildValue(Callable<T> fn) throws Exception {
    SerializingWidgetConstructors ser = new SerializingWidgetConstructors();
    WidgetConstructors prev = NativeObj.Base.factories;
    NativeObj.Base.factories = ser;
    try {
      T result = fn.call();
      assertNotNull(result);
      return result;
    } finally {
      NativeObj.Base.factories = prev;
      ser.close();
    }
  }

  // ── Layout / sizing ──────────────────────────────────────────────────────────

  @Test void sizedBox() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> SizedBox().build()).root);
  }

  @Test void sizedBox_shrink() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> SizedBox_shrink().build()).root);
  }

  @Test void sizedBox_expand() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> SizedBox_expand().build()).root);
  }

  @Test void center() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Center().build()).root);
  }

  @Test void column() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Column().build()).root);
  }

  @Test void row() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Row().build()).root);
  }

  @Test void flex() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Flex(Axis.horizontal).build()).root);
  }

  @Test void stack() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Stack().build()).root);
  }

  @Test void align() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Align().build()).root);
  }

  @Test void positioned() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Positioned().child(SizedBox().build()).build()).root);
  }

  @Test void positioned_fill() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Positioned_fill().child(SizedBox().build()).build()).root);
  }

  @Test void container() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Container().build()).root);
  }

  @Test void constrainedBox() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> ConstrainedBox(BoxConstraints().build()).build()).root);
  }

  @Test void expanded() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Expanded().child(SizedBox().build()).build()).root);
  }

  @Test void flexible() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Flexible().child(SizedBox().build()).build()).root);
  }

  @Test void spacer() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Spacer().build()).root);
  }

  @Test void wrap() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Wrap().build()).root);
  }

  @Test void intrinsicHeight() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> IntrinsicHeight().build()).root);
  }

  @Test void intrinsicWidth() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> IntrinsicWidth().build()).root);
  }

  @Test void fractionallySizedBox() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> FractionallySizedBox().build()).root);
  }

  @Test void limitedBox() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> LimitedBox().build()).root);
  }

  @Test void overflowBox() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> OverflowBox().build()).root);
  }

  @Test void aspectRatio() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> AspectRatio(1.0).build()).root);
  }

  @Test void padding() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Padding(EdgeInsets_all(8.0).build()).build()).root);
  }

  @Test void directionality() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Directionality(TextDirection.ltr, SizedBox().build()).build()).root);
  }

  @Test void indexedStack() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> IndexedStack().build()).root);
  }

  @Test void singleChildScrollView() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> SingleChildScrollView().build()).root);
  }

  @Test void fittedBox() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> FittedBox().build()).root);
  }

  @Test void rotatedBox() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> RotatedBox(0).build()).root);
  }

  @Test void fractionalTranslation() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> FractionalTranslation(Offset.zero()).build()).root);
  }

  @Test void unconstrainedBox() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> UnconstrainedBox().build()).root);
  }

  @Test void baseline() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Baseline(0.0, TextBaseline.alphabetic).build()).root);
  }

  // ── Clip ─────────────────────────────────────────────────────────────────────

  @Test void clipOval() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> ClipOval().build()).root);
  }

  @Test void clipRect() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> ClipRect().build()).root);
  }

  @Test void clipRRect() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> ClipRRect().build()).root);
  }

  @Test void clipRSuperellipse() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> ClipRSuperellipse().build()).root);
  }

  // ── Visual / decoration ───────────────────────────────────────────────────────

  @Test void decoratedBox() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> DecoratedBox(BoxDecoration().build()).build()).root);
  }

  @Test void coloredBox() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> ColoredBox(Color(0xff000000).build()).build()).root);
  }

  @Test void colorFiltered() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> ColorFiltered(ColorFilter.linearToSrgbGamma().build()).build()).root);
  }

  @Test void imageFiltered() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> ImageFiltered(ImageFilter.blur().build()).build()).root);
  }

  @Test void backdropFilter() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> BackdropFilter(ImageFilter.blur().build()).build()).root);
  }

  @Test void opacity() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Opacity(1.0).build()).root);
  }

  @Test void physicalModel() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> PhysicalModel().color(Color(0xff000000).build()).build()).root);
  }

  @Test void repaintBoundary() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> RepaintBoundary().build()).root);
  }

  @Test void absorbPointer() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> AbsorbPointer().build()).root);
  }

  @Test void ignorePointer() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> IgnorePointer().build()).root);
  }

  @Test void placeholder() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Placeholder().build()).root);
  }

  @Test void flutterLogo() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> FlutterLogo().build()).root);
  }

  @Test void banner() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Banner().message("NEW").location(BannerLocation.topStart).build()).root);
  }

  // ── Transform ─────────────────────────────────────────────────────────────────

  @Test void transform_rotate() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Transform_rotate(0.0).build()).root);
  }

  @Test void transform_translate() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Transform_translate(Offset.zero()).build()).root);
  }

  @Test void transform_scale() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Transform_scale().build()).root);
  }

  @Test void transform_flip() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Transform_flip().build()).root);
  }

  // ── Visibility ────────────────────────────────────────────────────────────────

  @Test void visibility() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Visibility(SizedBox().build()).build()).root);
  }

  @Test void visibility_maintain() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Visibility_maintain(SizedBox().build()).build()).root);
  }

  // ── Text ─────────────────────────────────────────────────────────────────────

  @Test void text() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Text("hello").build()).root);
  }

  @Test void text_rich() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Text_rich(TextSpan().text("hi").build()).build()).root);
  }

  @Test void richText() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> RichText(TextSpan().text("x").build()).build()).root);
  }

  @Test void selectableText() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> SelectableText("x").build()).root);
  }

  @Test void defaultTextStyle() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> DefaultTextStyle(TextStyle().build()).child(Text("x").build()).build()).root);
  }

  @Test void defaultTextStyle_fallback() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> DefaultTextStyle_fallback().build()).root);
  }

  // ── Icon ─────────────────────────────────────────────────────────────────────

  @Test void icon() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Icon(IconData(0xe000).build()).build()).root);
  }

  @Test void iconData() throws Exception {
    buildValue(() -> IconData(0xe000).build());
  }

  // ── Gesture / pointer ────────────────────────────────────────────────────────

  @Test void gestureDetector() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> GestureDetector().build()).root);
  }

  @Test void inkWell() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> InkWell().build()).root);
  }

  @Test void inkResponse() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> InkResponse().build()).root);
  }

  @Test void mouseRegion() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> MouseRegion().build()).root);
  }

  // ── Implicit animations ───────────────────────────────────────────────────────

  @Test void animatedContainer() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> AnimatedContainer().duration(Duration().milliseconds(300).build()).build()).root);
  }

  @Test void animatedOpacity() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> AnimatedOpacity().opacity(0.5).duration(Duration().milliseconds(300).build()).build()).root);
  }

  @Test void animatedPadding() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> AnimatedPadding(EdgeInsets_all(0.0).build())
            .duration(Duration().milliseconds(300).build()).build()).root);
  }

  @Test void animatedAlign() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> AnimatedAlign(Alignment.alignment(0.0, 0.0).build())
            .duration(Duration().milliseconds(300).build()).build()).root);
  }

  @Test void animatedRotation() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> AnimatedRotation().turns(0.0).duration(Duration().milliseconds(300).build()).build()).root);
  }

  @Test void animatedScale() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> AnimatedScale().scale(1.0).duration(Duration().milliseconds(300).build()).build()).root);
  }

  @Test void animatedSize() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> AnimatedSize().duration(Duration().milliseconds(300).build()).build()).root);
  }

  @Test void animatedSlide() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> AnimatedSlide().offset(Offset(0.0, 0.0).build())
            .duration(Duration().milliseconds(300).build()).build()).root);
  }

  @Test void animatedSwitcher() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> AnimatedSwitcher().duration(Duration().milliseconds(300).build()).build()).root);
  }

  @Test void animatedCrossFade() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> AnimatedCrossFade(SizedBox().build(), SizedBox().build())
            .crossFadeState(CrossFadeState.showFirst)
            .duration(Duration().milliseconds(300).build()).build()).root);
  }

  @Test void sizeTransition() throws Exception {
    // sizeFactor requires an AnimationI; use a stub id to exercise the web-serialization path
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> SizeTransition().sizeFactor(AnimationController.byId(0)).build()).root);
  }

  // ── Scroll ────────────────────────────────────────────────────────────────────

  @Test void listView() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> ListView().build()).root);
  }

  @Test void gridView_count() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> GridView_count().crossAxisCount(2).build()).root);
  }

  @Test void gridView_extent() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> GridView_extent().maxCrossAxisExtent(100.0).build()).root);
  }

  @Test void pageView() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> PageView().build()).root);
  }

  @Test void listWheelScrollView() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> ListWheelScrollView().itemExtent(50.0).build()).root);
  }

  @Test void interactiveViewer() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> InteractiveViewer().child(SizedBox().build()).build()).root);
  }

  @Test void scrollbar() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Scrollbar(SizedBox().build()).build()).root);
  }

  // ── Material app shell ────────────────────────────────────────────────────────

  @Test void materialApp() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> MaterialApp().build()).root);
  }

  @Test void scaffold() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Scaffold().build()).root);
  }

  @Test void appBar() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> AppBar().build()).root);
  }

  @Test void material() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Material().build()).root);
  }

  @Test void theme() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Theme(ThemeData().build(), SizedBox().build()).build()).root);
  }

  @Test void scaffoldMessenger() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> ScaffoldMessenger(SizedBox().build()).build()).root);
  }

  @Test void navigator() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Navigator().build()).root);
  }

  // ── Buttons ───────────────────────────────────────────────────────────────────

  @Test void elevatedButton() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> ElevatedButton(() -> {}).child(Text("ok").build()).build()).root);
  }

  @Test void outlinedButton() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> OutlinedButton(() -> {}).child(Text("ok").build()).build()).root);
  }

  @Test void textButton() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> TextButton(() -> {}).child(Text("ok").build()).build()).root);
  }

  @Test void filledButton() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> FilledButton(() -> {}).child(Text("ok").build()).build()).root);
  }

  @Test void filledButton_tonal() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> FilledButton_tonal(() -> {}).child(Text("ok").build()).build()).root);
  }

  @Test void floatingActionButton() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> FloatingActionButton().onPressed(() -> {}).build()).root);
  }

  @Test void iconButton() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> IconButton().onPressed(() -> {}).icon(Icon(IconData(0xe000).build()).build()).build()).root);
  }

  // ── Form controls ─────────────────────────────────────────────────────────────

  @Test void checkbox() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Checkbox(false).onChanged(b -> {}).build()).root);
  }

  @Test void checkbox_adaptive() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Checkbox_adaptive(false).onChanged(b -> {}).build()).root);
  }

  @Test void switch_() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Switch(false, b -> {}).build()).root);
  }

  @Test void slider() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Slider(0.5).onChanged(d -> {}).build()).root);
  }

  @Test void slider_adaptive() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Slider_adaptive(0.5).onChanged(d -> {}).build()).root);
  }

  @Test void circularProgressIndicator() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> CircularProgressIndicator().build()).root);
  }

  @Test void linearProgressIndicator() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> LinearProgressIndicator().build()).root);
  }

  @Test void textField() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> TextField().build()).root);
  }

  @Test void inputDecoration() throws Exception {
    buildValue(() -> InputDecoration().build());
  }

  @Test void outlineInputBorder() throws Exception {
    buildValue(() -> OutlineInputBorder().build());
  }

  @Test void searchBar() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> SearchBar().build()).root);
  }

  // ── List and selection ────────────────────────────────────────────────────────

  @Test void listTile() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> ListTile().build()).root);
  }

  @Test void checkboxListTile() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CheckboxListTile(false, b -> {}).build()).root);
  }

  @Test void switchListTile() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> SwitchListTile(false, b -> {}).build()).root);
  }

  @Test void radioListTile() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> RadioListTile(SizedBox.sizedBox().build()).build()).root);
  }

  @Test void radio() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Radio(SizedBox.sizedBox().build()).build()).root);
  }

  @Test void divider() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Divider().build()).root);
  }

  @Test void drawer() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Drawer().build()).root);
  }

  // ── Card / chip / badge ───────────────────────────────────────────────────────

  @Test void card() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Card().build()).root);
  }

  @Test void card_filled() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Card_filled().build()).root);
  }

  @Test void card_outlined() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Card_outlined().build()).root);
  }

  @Test void chip() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Chip().label(Text("x").build()).build()).root);
  }

  @Test void circleAvatar() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> CircleAvatar().build()).root);
  }

  @Test void badge() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Badge().build()).root);
  }

  @Test void badge_count() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Badge_count().count(3).build()).root);
  }

  // ── Feedback / overlay ────────────────────────────────────────────────────────

  @Test void tooltip() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Tooltip().build()).root);
  }

  @Test void snackBar() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> SnackBar(Text("msg").build()).build()).root);
  }

  @Test void snackBarAction() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> SnackBarAction().label("Undo").onPressed(() -> {}).build()).root);
  }

  @Test void alertDialog() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> AlertDialog().build()).root);
  }

  // ── Tabs ─────────────────────────────────────────────────────────────────────

  @Test void tab() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> Tab().build()).root);
  }

  @Test void tabBar() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> TabBar(List.of(Tab().text("A").build())).build()).root);
  }

  @Test void tabBarView() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> TabBarView(List.of(SizedBox().build())).build()).root);
  }

  @Test void defaultTabController() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> DefaultTabController(3).child(TabBarView(List.of(SizedBox().build())).build()).build()).root);
  }

  // ── Expansion ─────────────────────────────────────────────────────────────────

  @Test void expansionTile() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> ExpansionTile().title(Text("t").build()).build()).root);
  }

  @Test void expansionPanel() throws Exception {
    buildValue(() -> ExpansionPanel((ctx, b) -> Text("h").build(), SizedBox().build()).build());
  }

  @Test void expansionPanelList() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> ExpansionPanelList().build()).root);
  }

  @Test void expansionPanelList_radio() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> ExpansionPanelList_radio().build()).root);
  }

  // ── Navigation ────────────────────────────────────────────────────────────────

  @Test void navigationRail() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> NavigationRail().selectedIndex(0).build()).root);
  }

  @Test void navigationRailDestination() throws Exception {
    buildValue(() -> NavigationRailDestination(Icon(IconData(0xe000).build()).build())
        .label(Text("home").build()).build());
  }

  @Test void navigationBar() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> NavigationBar().build()).root);
  }

  @Test void navigationDestination() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> NavigationDestination(Icon(IconData(0xe000).build()).build())
            .label("Home").build()).root);
  }

  @Test void navigationDrawer() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> {
      var dest = NavigationDrawerDestination()
          .icon(Icon(IconData(0xe000).build()).build())
          .label(Text("home").build()).build();
      return NavigationDrawer(List.of(dest)).build();
    }).root);
  }

  @Test void navigationDrawerDestination() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> NavigationDrawerDestination()
            .icon(Icon(IconData(0xe000).build()).build())
            .label(Text("home").build()).build()).root);
  }

  @Test void bottomNavigationBarItem() throws Exception {
    buildValue(() -> BottomNavigationBarItem(Icon(IconData(0xe000).build()).build()).build());
  }

  // ── Data table ────────────────────────────────────────────────────────────────

  @Test void dataCell() throws Exception {
    buildValue(() -> DataCell(Text("v").build()).build());
  }

  @Test void dataColumn() throws Exception {
    buildValue(() -> DataColumn(Text("col").build()).build());
  }

  @Test void dataRow() throws Exception {
    buildValue(() -> DataRow().build());
  }

  @Test void dataTable() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> DataTable(List.of(DataColumn(Text("h").build()).build())).build()).root);
  }

  // ── Menu / popup ──────────────────────────────────────────────────────────────

  @Test void menuBar() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> MenuBar().build()).root);
  }

  @Test void menuAnchor() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> MenuAnchor().build()).root);
  }

  @Test void submenuButton() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> SubmenuButton().child(Text("menu").build()).build()).root);
  }

  @Test void menuItemButton() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> MenuItemButton().build()).root);
  }

  @Test void checkboxMenuButton() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CheckboxMenuButton(false).onChanged(b -> {}).child(Text("x").build()).build()).root);
  }

  @Test void radioMenuButton() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> {
      var val = SizedBox.sizedBox().build();
      return RadioMenuButton(val, val, o -> {}).child(Text("opt").build()).build();
    }).root);
  }

  @Test void popupMenuDivider() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> PopupMenuDivider().build()).root);
  }

  @Test void popupMenuItem() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> PopupMenuItem().child(Text("x").build()).build()).root);
  }

  @Test void checkedPopupMenuItem() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> CheckedPopupMenuItem().build()).root);
  }

  @Test void dropdownMenuEntry() throws Exception {
    buildValue(() -> {
      var val = SizedBox.sizedBox().build();
      return DropdownMenuEntry(val, "label").build();
    });
  }

  // ── Hero / draggable ──────────────────────────────────────────────────────────

  @Test void hero() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Hero(SizedBox.sizedBox().build()).child(SizedBox().build()).build()).root);
  }

  @Test void draggable() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> Draggable(SizedBox().build(), SizedBox().build()).build()).root);
  }

  // ── Date / time ───────────────────────────────────────────────────────────────

  @Test void datePickerDialog() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> DatePickerDialog()
        .firstDate(DateTime(2020).build())
        .lastDate(DateTime(2030).build()).build()).root);
  }

  @Test void calendarDatePicker() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> CalendarDatePicker(
        DateTime(2024).build(),
        DateTime(2020).build(),
        DateTime(2030).build()).onDateChanged(dt -> {}).build()).root);
  }

  @Test void timePickerDialog() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> TimePickerDialog(TimeOfDay(12, 0).build()).build()).root);
  }

  @Test void dateRangePickerDialog() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> DateRangePickerDialog(
        DateTime(2020).build(),
        DateTime(2030).build()).build()).root);
  }

  @Test void yearPicker() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> YearPicker()
        .firstDate(DateTime(2020).build())
        .lastDate(DateTime(2030).build())
        .selectedDate(DateTime(2024).build())
        .onChanged(dt -> {}).build()).root);
  }

  @Test void inputDatePickerFormField() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> InputDatePickerFormField()
        .firstDate(DateTime(2020).build())
        .lastDate(DateTime(2030).build()).build()).root);
  }

  // ── Value types ───────────────────────────────────────────────────────────────

  @Test void color() throws Exception {
    buildValue(() -> Color(0xffaabbcc).build());
  }

  @Test void color_fromARGB() throws Exception {
    buildValue(() -> Color_fromARGB(255, 0, 0, 0).build());
  }

  @Test void color_fromRGBO() throws Exception {
    buildValue(() -> Color_fromRGBO(0, 0, 0, 1.0).build());
  }

  @Test void alignment() throws Exception {
    buildValue(() -> Alignment(0.0, 0.0).build());
  }

  @Test void alignmentDirectional() throws Exception {
    buildValue(() -> AlignmentDirectional(0.0, 0.0).build());
  }

  @Test void offset() throws Exception {
    buildValue(() -> Offset(0.0, 0.0).build());
  }

  @Test void edgeInsets_all() throws Exception {
    buildValue(() -> EdgeInsets_all(8.0).build());
  }

  @Test void edgeInsets_symmetric() throws Exception {
    buildValue(() -> EdgeInsets_symmetric().build());
  }

  @Test void edgeInsets_only() throws Exception {
    buildValue(() -> EdgeInsets_only().build());
  }

  @Test void boxConstraints() throws Exception {
    buildValue(() -> BoxConstraints().build());
  }

  @Test void boxDecoration() throws Exception {
    buildValue(() -> BoxDecoration().build());
  }

  @Test void boxShadow() throws Exception {
    buildValue(() -> BoxShadow().build());
  }

  @Test void borderSide() throws Exception {
    buildValue(() -> BorderSide().build());
  }

  @Test void border() throws Exception {
    buildValue(() -> Border().build());
  }

  @Test void roundedRectangleBorder() throws Exception {
    buildValue(() -> RoundedRectangleBorder().build());
  }

  @Test void borderRadius_circular() throws Exception {
    buildValue(() -> BorderRadius_circular(4.0).build());
  }

  @Test void borderRadius_vertical() throws Exception {
    buildValue(() -> BorderRadius_vertical().build());
  }

  @Test void borderRadius_only() throws Exception {
    buildValue(() -> BorderRadius_only().build());
  }

  @Test void radius_circular() throws Exception {
    buildValue(() -> Radius.circular(4.0).build());
  }

  @Test void radius_zero() throws Exception {
    buildValue(() -> Radius.zero().build());
  }

  @Test void colorFilter_linearToSrgbGamma() throws Exception {
    buildValue(() -> ColorFilter.linearToSrgbGamma().build());
  }

  @Test void colorFilter_srgbToLinearGamma() throws Exception {
    buildValue(() -> ColorFilter.srgbToLinearGamma().build());
  }

  @Test void colorFilter_mode() throws Exception {
    buildValue(() -> ColorFilter.mode(Color(0xff000000).build(), BlendMode.srcOver).build());
  }

  @Test void imageFilter_blur() throws Exception {
    buildValue(() -> ImageFilter.blur().build());
  }

  @Test void imageFilter_dilate() throws Exception {
    buildValue(() -> ImageFilter.dilate().build());
  }

  @Test void cubic() throws Exception {
    buildValue(() -> Cubic.cubic(0, 0, 1, 1).build());
  }

  @Test void elasticInCurve() throws Exception {
    buildValue(() -> ElasticInCurve().build());
  }

  @Test void elasticOutCurve() throws Exception {
    buildValue(() -> ElasticOutCurve().build());
  }

  @Test void elasticInOutCurve() throws Exception {
    buildValue(() -> ElasticInOutCurve().build());
  }

  @Test void duration() throws Exception {
    buildValue(() -> Duration().build());
  }

  @Test void dateTime() throws Exception {
    buildValue(() -> DateTime(2024).build());
  }

  @Test void timeOfDay() throws Exception {
    buildValue(() -> TimeOfDay(9, 30).build());
  }

  // ── Safe area / misc ──────────────────────────────────────────────────────────

  @Test void safeArea() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> SafeArea().child(SizedBox().build()).build()).root);
  }

  // ── Cupertino ─────────────────────────────────────────────────────────────────

  @Test void cupertinoApp() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> CupertinoApp().build()).root);
  }

  @Test void cupertinoPageScaffold() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoPageScaffold().child(SizedBox().build()).build()).root);
  }

  @Test void cupertinoNavigationBar() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> CupertinoNavigationBar().build()).root);
  }

  @Test void cupertinoNavigationBar_large() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> CupertinoNavigationBar_large().build()).root);
  }

  @Test void cupertinoSliverNavigationBar() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoSliverNavigationBar().build()).root);
  }

  @Test void cupertinoTabView() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> CupertinoTabView().build()).root);
  }

  @Test void cupertinoButton() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoButton(Text("ok").build()).onPressed(() -> {}).build()).root);
  }

  @Test void cupertinoButton_filled() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoButton_filled(Text("ok").build()).onPressed(() -> {}).build()).root);
  }

  @Test void cupertinoButton_tinted() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoButton_tinted(Text("ok").build()).onPressed(() -> {}).build()).root);
  }

  @Test void cupertinoSwitch() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoSwitch(false, b -> {}).build()).root);
  }

  @Test void cupertinoSlider() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoSlider(0.5, d -> {}).build()).root);
  }

  @Test void cupertinoCheckbox() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoCheckbox(false).onChanged(b -> {}).build()).root);
  }

  @Test void cupertinoTextField() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> CupertinoTextField().build()).root);
  }

  @Test void cupertinoTextField_borderless() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoTextField_borderless().build()).root);
  }

  @Test void cupertinoSearchTextField() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> CupertinoSearchTextField().build()).root);
  }

  @Test void cupertinoActivityIndicator() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> CupertinoActivityIndicator().build()).root);
  }

  @Test void cupertinoActivityIndicator_partiallyRevealed() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoActivityIndicator_partiallyRevealed().build()).root);
  }

  @Test void cupertinoListSection() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> CupertinoListSection().build()).root);
  }

  @Test void cupertinoListSection_insetGrouped() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoListSection_insetGrouped().build()).root);
  }

  @Test void cupertinoListTile() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoListTile(Text("title").build()).build()).root);
  }

  @Test void cupertinoListTile_notched() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoListTile_notched(Text("title").build()).build()).root);
  }

  @Test void cupertinoListTileChevron() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> CupertinoListTileChevron().build()).root);
  }

  @Test void cupertinoFormSection() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoFormSection(List.of(CupertinoFormRow(SizedBox().build()).build())).build()).root);
  }

  @Test void cupertinoFormSection_insetGrouped() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoFormSection_insetGrouped(
            List.of(CupertinoFormRow(SizedBox().build()).build())).build()).root);
  }

  @Test void cupertinoFormRow() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoFormRow(SizedBox().build()).build()).root);
  }

  @Test void cupertinoPicker() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoPicker().itemExtent(40.0).onSelectedItemChanged(i -> {}).build()).root);
  }

  @Test void cupertinoAlertDialog() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> CupertinoAlertDialog().build()).root);
  }

  @Test void cupertinoActionSheet() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> CupertinoActionSheet().build()).root);
  }

  @Test void cupertinoDialogAction() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoDialogAction().child(Text("ok").build()).build()).root);
  }

  @Test void cupertinoActionSheetAction() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoActionSheetAction(() -> {}).child(Text("Cancel").build()).build()).root);
  }

  @Test void cupertinoNavigationBarBackButton() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoNavigationBarBackButton().build()).root);
  }

  @Test void cupertinoTimerPicker() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoTimerPicker().onTimerDurationChanged(d -> {}).build()).root);
  }

  @Test void cupertinoTabBar() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> {
      var item = BottomNavigationBarItem(Icon(IconData(0xe000).build()).build()).build();
      return CupertinoTabBar(List.of(item)).build();
    }).root);
  }

  @Test void cupertinoTabScaffold() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(() -> {
      var item = BottomNavigationBarItem(Icon(IconData(0xe000).build()).build()).build();
      return CupertinoTabScaffold(
          CupertinoTabBar(List.of(item)).build(),
          (ctx, i) -> Text(String.valueOf(i)).build()).build();
    }).root);
  }

  @Test void cupertinoContextMenu() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoContextMenu(
            List.of(CupertinoContextMenuAction(Text("a").build()).build()),
            SizedBox().build()).build()).root);
  }

  @Test void cupertinoContextMenuAction() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoContextMenuAction(Text("x").build()).build()).root);
  }

  @Test void cupertinoExpansionTile() throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(
        () -> CupertinoExpansionTile(Text("title").build(), SizedBox().build()).build()).root);
  }
}
