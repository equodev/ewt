package dev.equo.ewt.support;

import static dev.equo.ewt.EWT.*;

import dev.equo.ewt.*;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

/**
 * Shared catalog of every builder we want to exercise across the test suite.
 *
 * <p>Two @MethodSource streams:
 * <ul>
 *   <li>{@link #mountableWidgets()} — {@code (name, Callable<Widget>)} entries for every
 *       widget that can be mounted as a root and thus rendered by the Flutter engine.
 *       Consumed by both {@code WidgetBuilderSerializationTest} (fast serialization pre-check)
 *       and {@code WidgetNativeRenderTest} (real engine under xvfb).</li>
 *   <li>{@link #nativeObjValues()} — {@code (name, Callable<NativeObj>)} entries for
 *       non-Widget NativeObj factories (Color, Duration, IconData, DataCell, ...). These
 *       are serialization-only; they cannot be mounted.</li>
 * </ul>
 *
 * <p>Entries mirror the section layout of the original {@code WidgetCaptureSmokeTest}.
 * When exposing a new builder, add its entry here — both test layers pick it up
 * automatically.
 */
public final class WidgetBuilderCatalog {

  private WidgetBuilderCatalog() {}

  /**
   * Full four-column stream (widgetName, variantLabel, callable, expectations) from the
   * generator-emitted {@link dev.equo.ewt.support.variants.WidgetVariantsRegistry}.
   * Consumed by {@code WidgetNativeRenderTest}.  Expectations is null when the variant
   * has no round-trip assertions (e.g. {@code _required}, {@code _nullExplicit}).
   *
   * <p>{@link #mountableWidgets()} below is intentionally NOT delegated to the registry
   * yet — the generator's optionality detection (via Dart analyzer's {@code isRequired})
   * does not always match what Immutables' generated Java builder marks as required
   * (Cupertino widgets in particular), which produces {@code IllegalStateException}
   * for some emitted {@code _required} / {@code _nullExplicit} variants when
   * {@code WidgetBuilderSerializationTest} tries to build them.  Delegation lands in a
   * follow-up MR once the emitter closes that gap.
   */
  public static Stream<Arguments> mountableVariants() {
    Stream<Arguments> all = dev.equo.ewt.support.variants.WidgetVariantsRegistry.allVariants();
    int count = envInt("EWT_SHARD_COUNT", 1);
    int index = envInt("EWT_SHARD_INDEX", 0);
    if (count <= 1) return all;
    return all.filter(a -> {
      Object[] arr = a.get();
      int h = java.util.Objects.hash(arr[0], arr[1]);
      return Math.floorMod(h, count) == index;
    });
  }

  private static int envInt(String name, int fallback) {
    String v = System.getenv(name);
    try { return v == null || v.isEmpty() ? fallback : Integer.parseInt(v); }
    catch (NumberFormatException e) { return fallback; }
  }

  public static Stream<Arguments> mountableWidgets() {
    return Stream.of(
        // ── Layout / sizing ──────────────────────────────────────────────────
        w("sizedBox", () -> SizedBox().build()),
        w("sizedBox_shrink", () -> SizedBox_shrink().build()),
        w("sizedBox_expand", () -> SizedBox_expand().build()),
        w("center", () -> Center().build()),
        w("column", () -> Column().build()),
        w("row", () -> Row().build()),
        w("flex", () -> Flex(Axis.horizontal).build()),
        w("stack", () -> Stack().build()),
        w("align", () -> Align().build()),
        w("positioned", () -> Positioned().child(SizedBox().build()).build()),
        w("positioned_fill", () -> Positioned_fill().child(SizedBox().build()).build()),
        w("container", () -> Container().build()),
        w("constrainedBox", () -> ConstrainedBox(BoxConstraints().build()).build()),
        w("expanded", () -> Expanded().child(SizedBox().build()).build()),
        w("flexible", () -> Flexible().child(SizedBox().build()).build()),
        w("spacer", () -> Spacer().build()),
        w("wrap", () -> Wrap().build()),
        w("intrinsicHeight", () -> IntrinsicHeight().build()),
        w("intrinsicWidth", () -> IntrinsicWidth().build()),
        w("fractionallySizedBox", () -> FractionallySizedBox().build()),
        w("limitedBox", () -> LimitedBox().build()),
        w("overflowBox", () -> OverflowBox().build()),
        w("aspectRatio", () -> AspectRatio(1.0).build()),
        w("padding", () -> Padding(EdgeInsets_all(8.0).build()).build()),
        w("directionality", () -> Directionality(TextDirection.ltr, SizedBox().build()).build()),
        w("indexedStack", () -> IndexedStack().build()),
        w("singleChildScrollView", () -> SingleChildScrollView().build()),
        w("fittedBox", () -> FittedBox().build()),
        w("rotatedBox", () -> RotatedBox(0).build()),
        w("fractionalTranslation", () -> FractionalTranslation(Offset.zero()).build()),
        w("unconstrainedBox", () -> UnconstrainedBox().build()),
        w("baseline", () -> Baseline(0.0, TextBaseline.alphabetic).build()),

        // ── Clip ─────────────────────────────────────────────────────────────
        w("clipOval", () -> ClipOval().build()),
        w("clipRect", () -> ClipRect().build()),
        w("clipRRect", () -> ClipRRect().build()),
        w("clipRSuperellipse", () -> ClipRSuperellipse().build()),

        // ── Visual / decoration ──────────────────────────────────────────────
        w("decoratedBox", () -> DecoratedBox(BoxDecoration().build()).build()),
        w("coloredBox", () -> ColoredBox(Color(0xff000000).build()).build()),
        w("colorFiltered", () -> ColorFiltered(ColorFilter.linearToSrgbGamma().build()).build()),
        w("imageFiltered", () -> ImageFiltered(ImageFilter.blur().build()).build()),
        w("backdropFilter", () -> BackdropFilter(ImageFilter.blur().build()).build()),
        w("opacity", () -> Opacity(1.0).build()),
        w("physicalModel", () -> PhysicalModel().color(Color(0xff000000).build()).build()),
        w("repaintBoundary", () -> RepaintBoundary().build()),
        w("absorbPointer", () -> AbsorbPointer().build()),
        w("ignorePointer", () -> IgnorePointer().build()),
        w("placeholder", () -> Placeholder().build()),
        w("flutterLogo", () -> FlutterLogo().build()),
        w("banner", () -> Banner().message("NEW").location(BannerLocation.topStart).build()),

        // ── Transform ────────────────────────────────────────────────────────
        w("transform_rotate", () -> Transform_rotate(0.0).build()),
        w("transform_translate", () -> Transform_translate(Offset.zero()).build()),
        w("transform_scale", () -> Transform_scale().build()),
        w("transform_flip", () -> Transform_flip().build()),

        // ── Visibility ───────────────────────────────────────────────────────
        w("visibility", () -> Visibility(SizedBox().build()).build()),
        w("visibility_maintain", () -> Visibility_maintain(SizedBox().build()).build()),

        // ── Text ─────────────────────────────────────────────────────────────
        w("text", () -> Text("hello").build()),
        w("text_rich", () -> Text_rich(TextSpan().text("hi").build()).build()),
        w("richText", () -> RichText(TextSpan().text("x").build()).build()),
        w("selectableText", () -> SelectableText("x").build()),
        w("defaultTextStyle",
            () -> DefaultTextStyle(TextStyle().build()).child(Text("x").build()).build()),
        w("defaultTextStyle_fallback", () -> DefaultTextStyle_fallback().build()),

        // ── Icon ─────────────────────────────────────────────────────────────
        w("icon", () -> Icon(IconData(0xe000).build()).build()),

        // ── Gesture / pointer ────────────────────────────────────────────────
        w("gestureDetector", () -> GestureDetector().build()),
        w("inkWell", () -> InkWell().build()),
        w("inkResponse", () -> InkResponse().build()),
        w("mouseRegion", () -> MouseRegion().build()),

        // ── Implicit animations ──────────────────────────────────────────────
        w("animatedContainer",
            () -> AnimatedContainer().duration(Duration().milliseconds(300).build()).build()),
        w("animatedOpacity",
            () -> AnimatedOpacity().opacity(0.5)
                .duration(Duration().milliseconds(300).build()).build()),
        w("animatedPadding",
            () -> AnimatedPadding(EdgeInsets_all(0.0).build())
                .duration(Duration().milliseconds(300).build()).build()),
        w("animatedAlign",
            () -> AnimatedAlign(Alignment.alignment(0.0, 0.0).build())
                .duration(Duration().milliseconds(300).build()).build()),
        w("animatedRotation",
            () -> AnimatedRotation().turns(0.0)
                .duration(Duration().milliseconds(300).build()).build()),
        w("animatedScale",
            () -> AnimatedScale().scale(1.0)
                .duration(Duration().milliseconds(300).build()).build()),
        w("animatedSize",
            () -> AnimatedSize().duration(Duration().milliseconds(300).build()).build()),
        w("animatedSlide",
            () -> AnimatedSlide().offset(Offset(0.0, 0.0).build())
                .duration(Duration().milliseconds(300).build()).build()),
        w("animatedSwitcher",
            () -> AnimatedSwitcher().duration(Duration().milliseconds(300).build()).build()),
        w("animatedCrossFade",
            () -> AnimatedCrossFade(SizedBox().build(), SizedBox().build())
                .crossFadeState(CrossFadeState.showFirst)
                .duration(Duration().milliseconds(300).build()).build()),
        w("sizeTransition",
            () -> SizeTransition().sizeFactor(AnimationController.byId(0)).build()),

        // ── Scroll ───────────────────────────────────────────────────────────
        w("listView", () -> ListView().build()),
        w("gridView_count", () -> GridView_count().crossAxisCount(2).build()),
        w("gridView_extent", () -> GridView_extent().maxCrossAxisExtent(100.0).build()),
        w("pageView", () -> PageView().build()),
        w("listWheelScrollView", () -> ListWheelScrollView().itemExtent(50.0).build()),
        w("interactiveViewer",
            () -> InteractiveViewer().child(SizedBox().build()).build()),
        w("scrollbar", () -> Scrollbar(SizedBox().build()).build()),

        // ── Material app shell ───────────────────────────────────────────────
        w("materialApp", () -> MaterialApp().build()),
        w("scaffold", () -> Scaffold().build()),
        w("appBar", () -> AppBar().build()),
        w("material", () -> Material().build()),
        w("theme", () -> Theme(ThemeData().build(), SizedBox().build()).build()),
        w("scaffoldMessenger", () -> ScaffoldMessenger(SizedBox().build()).build()),
        w("navigator", () -> Navigator().build()),

        // ── Buttons ──────────────────────────────────────────────────────────
        w("elevatedButton",
            () -> ElevatedButton().onPressed(() -> {}).child(Text("ok").build()).build()),
        w("outlinedButton",
            () -> OutlinedButton().onPressed(() -> {}).child(Text("ok").build()).build()),
        w("textButton",
            () -> TextButton().onPressed(() -> {}).child(Text("ok").build()).build()),
        w("filledButton",
            () -> FilledButton().onPressed(() -> {}).child(Text("ok").build()).build()),
        w("filledButton_tonal",
            () -> FilledButton_tonal().onPressed(() -> {}).child(Text("ok").build()).build()),
        w("floatingActionButton",
            () -> FloatingActionButton().onPressed(() -> {}).build()),
        w("iconButton",
            () -> IconButton().onPressed(() -> {})
                .icon(Icon(IconData(0xe000).build()).build()).build()),

        // ── Form controls ────────────────────────────────────────────────────
        w("checkbox", () -> Checkbox().value(false).onChanged(b -> {}).build()),
        w("checkbox_adaptive", () -> Checkbox_adaptive().value(false).onChanged(b -> {}).build()),
        w("switch_", () -> Switch(false).onChanged(b -> {}).build()),
        w("slider", () -> Slider(0.5).onChanged(d -> {}).build()),
        w("slider_adaptive", () -> Slider_adaptive(0.5).onChanged(d -> {}).build()),
        w("circularProgressIndicator", () -> CircularProgressIndicator().build()),
        w("linearProgressIndicator", () -> LinearProgressIndicator().build()),
        w("textField", () -> TextField().build()),
        w("searchBar", () -> SearchBar().build()),

        // ── List and selection ───────────────────────────────────────────────
        w("listTile", () -> ListTile().build()),
        w("checkboxListTile", () -> CheckboxListTile().value(false).onChanged(b -> {}).build()),
        w("switchListTile", () -> SwitchListTile(false).onChanged(b -> {}).build()),
        w("radioListTile", () -> RadioListTile(SizedBox.sizedBox().build()).build()),
        w("radio", () -> Radio(SizedBox.sizedBox().build()).build()),
        w("divider", () -> Divider().build()),
        w("drawer", () -> Drawer().build()),

        // ── Card / chip / badge ──────────────────────────────────────────────
        w("card", () -> Card().build()),
        w("card_filled", () -> Card_filled().build()),
        w("card_outlined", () -> Card_outlined().build()),
        w("chip", () -> Chip().label(Text("x").build()).build()),
        w("circleAvatar", () -> CircleAvatar().build()),
        w("badge", () -> Badge().build()),
        w("badge_count", () -> Badge_count().count(3).build()),

        // ── Feedback / overlay ───────────────────────────────────────────────
        w("tooltip", () -> Tooltip().build()),
        w("snackBar", () -> SnackBar(Text("msg").build()).build()),
        w("snackBarAction",
            () -> SnackBarAction().label("Undo").onPressed(() -> {}).build()),
        w("alertDialog", () -> AlertDialog().build()),

        // ── Tabs ─────────────────────────────────────────────────────────────
        w("tab", () -> Tab().build()),
        w("tabBar", () -> TabBar(List.of(Tab().text("A").build())).build()),
        w("tabBarView", () -> TabBarView(List.of(SizedBox().build())).build()),
        w("defaultTabController",
            () -> DefaultTabController(3)
                .child(TabBarView(List.of(SizedBox().build())).build()).build()),

        // ── Expansion ────────────────────────────────────────────────────────
        w("expansionTile",
            () -> ExpansionTile().title(Text("t").build()).build()),
        w("expansionPanelList", () -> ExpansionPanelList().build()),
        w("expansionPanelList_radio", () -> ExpansionPanelList_radio().build()),

        // ── Navigation ───────────────────────────────────────────────────────
        w("navigationRail", () -> NavigationRail().selectedIndex(0).build()),
        w("navigationBar", () -> NavigationBar().build()),
        w("navigationDestination",
            () -> NavigationDestination(Icon(IconData(0xe000).build()).build())
                .label("Home").build()),
        w("navigationDrawer", () -> {
          var dest = NavigationDrawerDestination()
              .icon(Icon(IconData(0xe000).build()).build())
              .label(Text("home").build()).build();
          return NavigationDrawer(List.of(dest)).build();
        }),
        w("navigationDrawerDestination",
            () -> NavigationDrawerDestination()
                .icon(Icon(IconData(0xe000).build()).build())
                .label(Text("home").build()).build()),

        // ── Data table ───────────────────────────────────────────────────────
        w("dataTable",
            () -> DataTable(List.of(DataColumn(Text("h").build()).build())).build()),

        // ── Menu / popup ─────────────────────────────────────────────────────
        w("menuBar", () -> MenuBar().build()),
        w("menuAnchor", () -> MenuAnchor().build()),
        w("submenuButton",
            () -> SubmenuButton().child(Text("menu").build()).build()),
        w("menuItemButton", () -> MenuItemButton().build()),
        w("checkboxMenuButton",
            () -> CheckboxMenuButton().value(false).onChanged(b -> {})
                .child(Text("x").build()).build()),
        w("radioMenuButton", () -> {
          var val = SizedBox.sizedBox().build();
          return RadioMenuButton(val).groupValue(val).onChanged(o -> {}).child(Text("opt").build()).build();
        }),
        w("popupMenuDivider", () -> PopupMenuDivider().build()),
        w("popupMenuItem",
            () -> PopupMenuItem().child(Text("x").build()).build()),
        w("checkedPopupMenuItem", () -> CheckedPopupMenuItem().build()),

        // ── Hero / draggable ─────────────────────────────────────────────────
        w("hero",
            () -> Hero(SizedBox.sizedBox().build()).child(SizedBox().build()).build()),
        w("draggable",
            () -> Draggable(SizedBox().build(), SizedBox().build()).build()),

        // ── Date / time ──────────────────────────────────────────────────────
        w("datePickerDialog",
            () -> DatePickerDialog()
                .firstDate(DateTime(2020).build())
                .lastDate(DateTime(2030).build()).build()),
        w("calendarDatePicker",
            () -> CalendarDatePicker()
                .initialDate(DateTime(2024).build())
                .firstDate(DateTime(2020).build())
                .lastDate(DateTime(2030).build())
                .onDateChanged(dt -> {}).build()),
        w("timePickerDialog",
            () -> TimePickerDialog(TimeOfDay(12, 0).build()).build()),
        w("dateRangePickerDialog",
            () -> DateRangePickerDialog(
                DateTime(2020).build(),
                DateTime(2030).build()).build()),
        w("yearPicker",
            () -> YearPicker()
                .firstDate(DateTime(2020).build())
                .lastDate(DateTime(2030).build())
                .selectedDate(DateTime(2024).build())
                .onChanged(dt -> {}).build()),
        w("inputDatePickerFormField",
            () -> InputDatePickerFormField()
                .firstDate(DateTime(2020).build())
                .lastDate(DateTime(2030).build()).build()),

        // ── Safe area / misc ─────────────────────────────────────────────────
        w("safeArea", () -> SafeArea().child(SizedBox().build()).build()),

        // ── Cupertino ────────────────────────────────────────────────────────
        w("cupertinoApp", () -> CupertinoApp().build()),
        w("cupertinoPageScaffold",
            () -> CupertinoPageScaffold().child(SizedBox().build()).build()),
        w("cupertinoNavigationBar", () -> CupertinoNavigationBar().build()),
        w("cupertinoNavigationBar_large", () -> CupertinoNavigationBar_large().build()),
        w("cupertinoSliverNavigationBar", () -> CupertinoSliverNavigationBar().build()),
        w("cupertinoTabView", () -> CupertinoTabView().build()),
        w("cupertinoButton",
            () -> CupertinoButton(Text("ok").build()).onPressed(() -> {}).build()),
        w("cupertinoButton_filled",
            () -> CupertinoButton_filled(Text("ok").build()).onPressed(() -> {}).build()),
        w("cupertinoButton_tinted",
            () -> CupertinoButton_tinted(Text("ok").build()).onPressed(() -> {}).build()),
        w("cupertinoSwitch", () -> CupertinoSwitch(false).onChanged(b -> {}).build()),
        w("cupertinoSlider", () -> CupertinoSlider(0.5).onChanged(d -> {}).build()),
        w("cupertinoCheckbox",
            () -> CupertinoCheckbox().value(false).onChanged(b -> {}).build()),
        w("cupertinoTextField", () -> CupertinoTextField().build()),
        w("cupertinoTextField_borderless", () -> CupertinoTextField_borderless().build()),
        w("cupertinoSearchTextField", () -> CupertinoSearchTextField().build()),
        w("cupertinoActivityIndicator", () -> CupertinoActivityIndicator().build()),
        w("cupertinoActivityIndicator_partiallyRevealed",
            () -> CupertinoActivityIndicator_partiallyRevealed().build()),
        w("cupertinoListSection", () -> CupertinoListSection().build()),
        w("cupertinoListSection_insetGrouped",
            () -> CupertinoListSection_insetGrouped().build()),
        w("cupertinoListTile",
            () -> CupertinoListTile(Text("title").build()).build()),
        w("cupertinoListTile_notched",
            () -> CupertinoListTile_notched(Text("title").build()).build()),
        w("cupertinoListTileChevron", () -> CupertinoListTileChevron().build()),
        w("cupertinoFormSection",
            () -> CupertinoFormSection(
                List.of(CupertinoFormRow(SizedBox().build()).build())).build()),
        w("cupertinoFormSection_insetGrouped",
            () -> CupertinoFormSection_insetGrouped(
                List.of(CupertinoFormRow(SizedBox().build()).build())).build()),
        w("cupertinoFormRow",
            () -> CupertinoFormRow(SizedBox().build()).build()),
        w("cupertinoPicker",
            () -> CupertinoPicker().itemExtent(40.0)
                .onSelectedItemChanged(i -> {}).build()),
        w("cupertinoAlertDialog", () -> CupertinoAlertDialog().build()),
        w("cupertinoActionSheet", () -> CupertinoActionSheet().build()),
        w("cupertinoDialogAction",
            () -> CupertinoDialogAction().child(Text("ok").build()).build()),
        w("cupertinoActionSheetAction",
            () -> CupertinoActionSheetAction(() -> {})
                .child(Text("Cancel").build()).build()),
        w("cupertinoNavigationBarBackButton",
            () -> CupertinoNavigationBarBackButton().build()),
        w("cupertinoTimerPicker",
            () -> CupertinoTimerPicker().onTimerDurationChanged(d -> {}).build()),
        w("cupertinoTabBar", () -> {
          var item = BottomNavigationBarItem(Icon(IconData(0xe000).build()).build()).build();
          return CupertinoTabBar(List.of(item)).build();
        }),
        w("cupertinoTabScaffold", () -> {
          var item = BottomNavigationBarItem(Icon(IconData(0xe000).build()).build()).build();
          return CupertinoTabScaffold(
              CupertinoTabBar(List.of(item)).build(),
              (ctx, i) -> Text(String.valueOf(i)).build()).build();
        }),
        w("cupertinoContextMenu",
            () -> CupertinoContextMenu(
                List.of(CupertinoContextMenuAction(Text("a").build()).build()),
                SizedBox().build()).build()),
        w("cupertinoContextMenuAction",
            () -> CupertinoContextMenuAction(Text("x").build()).build()),
        w("cupertinoExpansionTile",
            () -> CupertinoExpansionTile(Text("title").build(), SizedBox().build()).build())
    );
  }

  public static Stream<Arguments> nativeObjValues() {
    return Stream.of(
        v("iconData", () -> IconData(0xe000).build()),
        v("inputDecoration", () -> InputDecoration().build()),
        v("outlineInputBorder", () -> OutlineInputBorder().build()),
        v("expansionPanel",
            () -> ExpansionPanel((ctx, b) -> Text("h").build(), SizedBox().build()).build()),
        v("navigationRailDestination",
            () -> NavigationRailDestination(Icon(IconData(0xe000).build()).build())
                .label(Text("home").build()).build()),
        v("bottomNavigationBarItem",
            () -> BottomNavigationBarItem(Icon(IconData(0xe000).build()).build()).build()),
        v("dataCell", () -> DataCell(Text("v").build()).build()),
        v("dataColumn", () -> DataColumn(Text("col").build()).build()),
        v("dataRow", () -> DataRow().build()),
        v("dropdownMenuEntry", () -> {
          var val = SizedBox.sizedBox().build();
          return DropdownMenuEntry(val, "label").build();
        }),
        v("color", () -> Color(0xffaabbcc).build()),
        v("color_fromARGB", () -> Color_fromARGB(255, 0, 0, 0).build()),
        v("color_fromRGBO", () -> Color_fromRGBO(0, 0, 0, 1.0).build()),
        v("alignment", () -> Alignment(0.0, 0.0).build()),
        v("alignmentDirectional", () -> AlignmentDirectional(0.0, 0.0).build()),
        v("offset", () -> Offset(0.0, 0.0).build()),
        v("edgeInsets_all", () -> EdgeInsets_all(8.0).build()),
        v("edgeInsets_symmetric", () -> EdgeInsets_symmetric().build()),
        v("edgeInsets_only", () -> EdgeInsets_only().build()),
        v("boxConstraints", () -> BoxConstraints().build()),
        v("boxDecoration", () -> BoxDecoration().build()),
        v("boxShadow", () -> BoxShadow().build()),
        v("borderSide", () -> BorderSide().build()),
        v("border", () -> Border().build()),
        v("roundedRectangleBorder", () -> RoundedRectangleBorder().build()),
        v("borderRadius_circular", () -> BorderRadius_circular(4.0).build()),
        v("borderRadius_vertical", () -> BorderRadius_vertical().build()),
        v("borderRadius_only", () -> BorderRadius_only().build()),
        v("radius_circular", () -> Radius.circular(4.0).build()),
        v("radius_zero", () -> Radius.zero().build()),
        v("colorFilter_linearToSrgbGamma",
            () -> ColorFilter.linearToSrgbGamma().build()),
        v("colorFilter_srgbToLinearGamma",
            () -> ColorFilter.srgbToLinearGamma().build()),
        v("colorFilter_mode",
            () -> ColorFilter.mode(Color(0xff000000).build(), BlendMode.srcOver).build()),
        v("imageFilter_blur", () -> ImageFilter.blur().build()),
        v("imageFilter_dilate", () -> ImageFilter.dilate().build()),
        v("cubic", () -> Cubic.cubic(0, 0, 1, 1).build()),
        v("elasticInCurve", () -> ElasticInCurve().build()),
        v("elasticOutCurve", () -> ElasticOutCurve().build()),
        v("elasticInOutCurve", () -> ElasticInOutCurve().build()),
        v("duration", () -> Duration().build()),
        v("dateTime", () -> DateTime(2024).build()),
        v("timeOfDay", () -> TimeOfDay(9, 30).build())
    );
  }

  private static Arguments w(String name, Callable<Widget> builder) {
    return Arguments.of(name, builder);
  }

  private static Arguments v(String name, Callable<? extends NativeObj> builder) {
    return Arguments.of(name, builder);
  }
}
