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
              .title(Text("Visibility.visible"))
      ));
    }
  }
}
