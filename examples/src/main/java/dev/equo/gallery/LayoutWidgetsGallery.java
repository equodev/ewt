package dev.equo.gallery;

import java.util.List;

import dev.equo.ewt.*;

import static dev.equo.ewt.EWT.*;
import static dev.equo.gallery.GalleryKit.*;

/**
 * Layout, sizing, clipping, painting and transform widgets.
 *
 *   ./gradlew :examples:run -PuseLocal=true -PmainClass=dev.equo.gallery.LayoutWidgetsGallery
 *
 * The Slider drives the size-dependent tiles.
 *
 * Not shown: LimitedBox only caps its child under UNbounded constraints (e.g.
 * inside a scroll view), so a fixed tile cannot demonstrate it; IntrinsicHeight
 * is IntrinsicWidth on the vertical axis. Both are generated and usable.
 */
public class LayoutWidgetsGallery {

  public static void main(String[] args) {
    App.runApp(MyApp::new);
  }

  static class MyApp extends SubStatelessWidget {
    @Override
    protected Widget build(BuildContext context) {
      return MaterialApp()
          .title("EWT — Layout Widgets")
          .theme(ThemeData().colorScheme(ColorScheme_fromSeed(Colors.teal())).useMaterial3(true))
          .home(new GalleryPage());
    }
  }

  static class GalleryPage extends SubStatefulWidget {
    @Override
    protected State<GalleryPage> createState() {
      return new GalleryState();
    }
  }

  static class GalleryState extends SubState<GalleryPage> {
    double _size = 60.0;
    boolean _visible = true;
    int _normalTaps = 0;
    String _lastTap = "-";
    boolean _expanded = false;

    @Override
    public Widget build(BuildContext context) {
      return page(context, "Layout Widgets", Colors.teal(), List.of(

          Text("Slider drives the sizing tiles"),
          Slider(_size).onChanged(v -> setState(() -> _size = v)).min(24.0).max(80.0),
          Divider(),

          // ---- Clipping ----
          tile("ClipOval", ClipOval().child(rect(40.0, 40.0, Colors.teal()))),
          tile("ClipRRect", ClipRRect().borderRadius(BorderRadius_circular(14.0))
              .child(rect(40.0, 40.0, Colors.indigo()))),
          tile("ClipRect", ClipRect().child(rect(40.0, 40.0, Colors.orange()))),
          tile("ClipRSuperellipse (squircle)", ClipRSuperellipse()
              .borderRadius(BorderRadius_circular(14.0))
              .child(rect(40.0, 40.0, Colors.deepPurple()))),

          // ---- Sizing ----
          tile("AspectRatio 2:1",
              SizedBox().width(80.0).child(AspectRatio(2.0).child(ColoredBox(Colors.purple())))),
          // min=max gives it a definite size, so the slider visibly drives the width.
          tile("ConstrainedBox (slider)", ConstrainedBox(
                  BoxConstraints().minWidth(_size).maxWidth(_size).minHeight(24.0).maxHeight(24.0))
              .child(ColoredBox(Colors.red()))),
          // Needs a bounded parent to compute the fraction — hence the stage.
          tile("FractionallySizedBox 60%", stage(80.0, 56.0,
              FractionallySizedBox().widthFactor(0.6).heightFactor(0.6)
                  .child(ColoredBox(Colors.green())))),
          tile("FittedBox", FittedBox().fit(BoxFit.contain)
              .child(Text("BIG").style(TextStyle().fontSize(40.0)))),
          // IntrinsicWidth forces the thin blue bar to match the wide red one.
          tile("IntrinsicWidth", IntrinsicWidth().child(Column()
              .crossAxisAlignment(CrossAxisAlignment.stretch)
              .children(List.of(
                  rect(60.0, 14.0, Colors.red()),
                  SizedBox().height(4.0),
                  SizedBox().height(14.0).child(ColoredBox(Colors.blue())))))),
          // The pink child (72x40) deliberately overflows the small 40x28 stage.
          tile("OverflowBox (overflows)", stage(40.0, 28.0,
              OverflowBox().maxWidth(72.0).maxHeight(40.0)
                  .child(rect(72.0, 40.0, Colors.pink())))),

          // ---- Alignment ----
          tile("Align (bottomRight)", stage(72.0, 56.0,
              Align().alignment(Alignment.bottomRight()).child(dot(Colors.cyan())))),
          tile("Baseline", Baseline(24.0, TextBaseline.alphabetic).child(Text("base"))),
          tile("Flex + Spacer", SizedBox().width(80.0).child(Flex(Axis.horizontal)
              .children(List.of(dot(Colors.teal()), Spacer(), dot(Colors.red()))))),

          // ---- Painting ----
          tile("ColoredBox", rect(48.0, 48.0, Colors.amber())),
          tile("DecoratedBox", DecoratedBox(BoxDecoration()
                  .color(Colors.pink())
                  .borderRadius(BorderRadius_circular(8.0)))
              .child(SizedBox().width(48.0).height(48.0))),
          tile("Placeholder", SizedBox().width(60.0).height(48.0).child(Placeholder())),

          // ---- Transform / visibility ----
          tile("RotatedBox (1 turn)", RotatedBox(1).child(Text("rot"))),
          tile("Visibility (toggle below)",
              Visibility(rect(40.0, 40.0, Colors.deepPurple())).visible(_visible)),
          SwitchListTile(_visible, v -> setState(() -> _visible = v))
              .title(Text("Visibility.visible")),
          Divider(),

          // ---- Pointer / hit-test ----
          // AbsorbPointer: left button counts taps; right is wrapped — clicks never fire
          Text("AbsorbPointer: left counts taps, right is absorbed"),
          Padding(EdgeInsets_symmetric().vertical(8.0)).child(
              Row().children(List.of(
                  Column().crossAxisAlignment(CrossAxisAlignment.center).children(List.of(
                      OutlinedButton(() -> setState(() -> _normalTaps++)).child(Text("tap me")),
                      Text("taps: " + _normalTaps)
                  )),
                  SizedBox().width(48.0),
                  Column().crossAxisAlignment(CrossAxisAlignment.center).children(List.of(
                      AbsorbPointer().child(
                          OutlinedButton(() -> setState(() -> _normalTaps++)).child(Text("absorbed"))
                      ),
                      Text("taps: 0 (blocked)")
                  ))
              ))
          ),
          // IgnorePointer: makes child invisible to hit-testing; events pass to widgets below
          tile("IgnorePointer",
              Stack().children(List.of(
                  GestureDetector().onTap(() -> setState(() -> _normalTaps++))
                      .child(rect(60.0, 40.0, Colors.green())),
                  IgnorePointer().child(rect(60.0, 40.0, Colors.red()))
              ))),
          // Smoke test: TapDownDetails.globalPosition() reads the Dart-side value
          tile("onTapDown coords",
              Column().children(List.of(
                  GestureDetector()
                      .onTapDown(d -> setState(() -> _lastTap =
                          "(" + (int) d.globalPosition().dx() + "," + (int) d.globalPosition().dy() + ")"))
                      .child(rect(80.0, 40.0, Colors.deepPurple())),
                  Text("last: " + _lastTap)
              ))),
          Divider(),

          // ---- Layout helpers ----
          // RepaintBoundary isolates repaint regions — no visual effect, it's a perf tool
          tile("RepaintBoundary", RepaintBoundary().child(rect(48.0, 48.0, Colors.teal()))),
          // UnconstrainedBox lets child ignore parent constraints — the 120px bar overflows 96px tile
          tile("UnconstrainedBox (overflow)",
              ClipRect().child(
                  UnconstrainedBox().child(
                      SizedBox().width(120.0).height(32.0).child(ColoredBox(Colors.orange()))
                  ))),
          tile("FractionalTranslation (+50% x)", stage(80.0, 56.0,
              FractionalTranslation(Offset(0.5, 0.0)).child(dot(Colors.indigo())))),
          Divider(),

          // ---- Visual ----
          tile("PhysicalModel (elev 8)", PhysicalModel()
              .color(Colors.white())
              .elevation(8.0)
              .child(SizedBox().width(56.0).height(40.0))),
          tile("Banner topEnd", SizedBox().width(72.0).height(56.0).child(
              Banner().message("NEW").location(BannerLocation.topEnd).child(
                  rect(72.0, 56.0, Colors.grey())))),
          Divider(),

          // ---- FlutterLogo ----
          tile("FlutterLogo 24", FlutterLogo().size(24.0)),
          tile("FlutterLogo 48", FlutterLogo().size(48.0)),
          tile("FlutterLogo 72", FlutterLogo().size(72.0)),
          Divider(),

          // ---- NavigationToolbar + ListBody laid over GridPaper ----
          tile("NavigationToolbar/ListBody/GridPaper",
              SizedBox().width(200.0).height(80.0).child(
                  GridPaper().interval(20.0).divisions(2).subdivisions(2).color(Colors.blueGrey())
                      .child(NavigationToolbar()
                          .leading(dot(Colors.red()))
                          .middle(ListBody().mainAxis(Axis.horizontal).children(List.of(
                              Text("A "), Text("B "), Text("C"))))
                          .trailing(dot(Colors.blue()))))),
          Divider(),

          // ---- Batch 4: Listener + OverflowBar + ChoiceChip + Ink + BottomAppBar ----
          tile("Listener + OverflowBar",
              SizedBox().width(220.0).height(50.0).child(
                  Listener().onPointerDown(e -> setState(() -> _normalTaps++))
                      .child(OverflowBar().spacing(6.0).children(List.of(
                          Chip().label(Text("Pointer taps: " + _normalTaps)),
                          ChoiceChip().label(Text("Choice"))
                              .selected(_visible)
                              .onSelected(v -> setState(() -> _visible = v)),
                          FilterChip().label(Text("Filter"))
                              .selected(_expanded)
                              .onSelected(v -> setState(() -> _expanded = v)),
                          ActionChip().label(Text("Action"))
                              .onPressed(() -> setState(() -> _lastTap = "action-chip"))
                      )).build()))),
          // ---- Batch 5: OutlinedBorder variants ----
          tile("Circle/Stadium/Beveled/Continuous/Star borders",
              Row().mainAxisAlignment(MainAxisAlignment.spaceBetween).children(List.of(
                  Container().width(28.0).height(28.0).decoration(BoxDecoration()
                      .color(Colors.red()).shape(BoxShape.circle)),
                  Material().color(Colors.orange()).shape(StadiumBorder().build())
                      .child(SizedBox().width(40.0).height(20.0).build()).build(),
                  Material().color(Colors.green())
                      .shape(BeveledRectangleBorder().borderRadius(BorderRadius_circular(6.0)).build())
                      .child(SizedBox().width(28.0).height(20.0).build()).build(),
                  Material().color(Colors.blue())
                      .shape(ContinuousRectangleBorder().borderRadius(BorderRadius_circular(8.0)).build())
                      .child(SizedBox().width(28.0).height(20.0).build()).build(),
                  Material().color(Colors.purple())
                      .shape(StarBorder().points(6).build())
                      .child(SizedBox().width(28.0).height(28.0).build()).build()
              ))),
          tile("LinearBorder + TabPageSelectorIndicator",
              Row().children(List.of(
                  Material().color(Colors.teal()).shape(LinearBorder_bottom().build())
                      .child(SizedBox().width(40.0).height(24.0).build()).build(),
                  SizedBox().width(12.0),
                  TabPageSelectorIndicator(Colors.blue(), Colors.blueGrey(), 14.0)
              ))),
          tile("MaterialBanner",
              SizedBox().width(280.0).child(MaterialBanner(Text("Something happened."))
                  .leading(Icon(Icons.info()))
                  .addActions(TextButton(() -> setState(() -> _lastTap = "banner")).child(Text("OK")).build())
                  .backgroundColor(Colors.amber()))),
          tile("Reorderable listeners",
              Row().children(List.of(
                  ReorderableDragStartListener(rect(28.0, 28.0, Colors.indigo()).build(), 0),
                  SizedBox().width(8.0),
                  ReorderableDelayedDragStartListener(rect(28.0, 28.0, Colors.deepPurple()).build(), 1)
              ))),
          tile("AboutListTile",
              SizedBox().width(240.0).child(AboutListTile()
                  .icon(Icon(Icons.info()))
                  .applicationName("EWT")
                  .applicationVersion("dev"))),
          Divider(),

          // ---- Batch 6: Dialog, GridTile, InputDecorator, chip variants ----
          tile("Dialog (inline preview)",
              SizedBox().width(220.0).height(70.0).child(
                  Dialog().backgroundColor(Colors.grey())
                      .child(Padding(EdgeInsets_all(12.0)).child(Text("Dialog body"))).build())),
          tile("GridTile + GridTileBar",
              SizedBox().width(160.0).height(80.0).child(
                  GridTile().child(rect(160.0, 80.0, Colors.blueGrey()).build())
                      .header(GridTileBar().leading(Icon(Icons.info()))
                          .title(Text("Header")).backgroundColor(Colors.black()).build())
                      .footer(GridTileBar().title(Text("Footer"))
                          .backgroundColor(Colors.black()).build()))),
          tile("RefreshProgressIndicator + InputChip",
              Row().children(List.of(
                  RefreshProgressIndicator(),
                  SizedBox().width(12.0),
                  InputChip().label(Text("input"))
                      .onDeleted(() -> setState(() -> _lastTap = "chip-deleted"))
              ))),
          tile("InputDecorator",
              SizedBox().width(200.0).child(InputDecorator(
                  InputDecoration().labelText("Label").border(OutlineInputBorder().build()).build())
                  .child(Text("value")))),
          tile("UserAccountsDrawerHeader",
              SizedBox().width(280.0).height(120.0).child(UserAccountsDrawerHeader()
                  .accountName(Text("Ada Lovelace"))
                  .accountEmail(Text("ada@example.com")))),
          Divider(),

          tile("Ink + BottomAppBar",
              SizedBox().width(220.0).height(60.0).child(
                  BottomAppBar().color(Colors.teal()).child(
                      Ink().width(80.0).height(40.0).color(Colors.orange())
                          .child(Center().child(Text("Ink"))).build()))),
          Divider(),

          // ---- Batch 2: VerticalDivider + ExpandIcon + PositionedDirectional ----
          // The other batch-2 widgets (CheckedModeBanner, IgnoreBaseline, TickerMode,
          // TapRegionSurface, LookupBoundary, SemanticsDebugger, ExcludeFocus,
          // ExcludeFocusTraversal, AutofillGroup) are invisible policy widgets — wrapping
          // this whole tile in them proves they compile & don't break the subtree.
          tile("VerticalDivider + ExpandIcon + PositionedDirectional",
              CheckedModeBanner(TickerMode(true,
                  ExcludeFocus().child(
                      SizedBox().width(220.0).height(56.0).child(IntrinsicHeight().child(
                          Row().children(List.of(
                              rect(48.0, 40.0, Colors.teal()),
                              VerticalDivider().width(20.0).thickness(2.0).color(Colors.grey()),
                              Stack().children(List.of(
                                  rect(80.0, 40.0, Colors.blueGrey()),
                                  PositionedDirectional().start(6.0).top(6.0)
                                      .child(dot(Colors.orange()).build()).build())),
                              VerticalDivider().width(20.0).thickness(2.0).color(Colors.grey()),
                              ExpandIcon().isExpanded(_expanded)
                                  .onPressed(v -> setState(() -> _expanded = !_expanded))
                          ))))).build()).build())),
          Divider(),

          // ---- Text / direction ----
          // DefaultTextStyle: sets the inherited text style for the whole subtree
          tile("DefaultTextStyle", DefaultTextStyle(
                  TextStyle().fontSize(18.0).color(Colors.indigo()).fontWeight(FontWeight.bold()))
              .child(Text("styled"))),
          // Directionality: forces RTL — "Hello" text appears right-to-left
          tile("Directionality RTL", Directionality(TextDirection.rtl,
              Row().children(List.of(
                  Text("A"), Text("B"), Text("C")))))
      ));
    }
  }
}
