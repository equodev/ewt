package dev.equo.showcase;

import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

/**
 * Grid of vivid Material 3 cards. Tapping a card plays a 360-degree
 * rotation with an elastic curve, then the next tap reverses it.
 * Showcases shadows, rounded corners and dense Material colors that
 * SWT can't render natively.
 */
public class GalleryPage extends SubStatefulWidget {
    private final Runnable goBack;

    public GalleryPage(Runnable goBack) {
        this.goBack = goBack;
    }

    @Override
    protected State<GalleryPage> createState() {
        return new GalleryPageState(goBack);
    }
}

class GalleryPageState extends SubAnimatedState<GalleryPage> {
    private static final int TILE_COUNT = 6;
    private static final double TILE_SIZE = 96.0;

    private final Runnable goBack;
    private AnimationController[] tileCtrls;
    private AnimationController gridFade;
    private boolean[] tileForward;
    private boolean[] tileHovered;

    GalleryPageState(Runnable goBack) {
        this.goBack = goBack;
    }

    @Override
    public void initState() {
        super.initState();
        tileCtrls = new AnimationController[TILE_COUNT];
        tileForward = new boolean[TILE_COUNT];
        tileHovered = new boolean[TILE_COUNT];
        for (int i = 0; i < TILE_COUNT; i++) {
            tileCtrls[i] = animationController(Duration().milliseconds(1800));
        }
        gridFade = animationController(Duration().milliseconds(750));
        gridFade.forward();
    }

    @Override
    public Widget build(BuildContext context) {
        return Scaffold()
                .backgroundColor(Palette.bgGallery())
                .appBar(appBar())
                .body(SafeArea().child(SingleChildScrollView().child(
                        Padding(EdgeInsets_all(20.0)).child(content())
                )));
    }

    private AppBarI appBar() {
        return AppBar()
                .title(Text("Color Gallery"))
                .backgroundColor(Palette.accentAmber())
                .foregroundColor(Colors.white())
                .leading(IconButton()
                        .icon(Icon(Icons.arrow_back_rounded()))
                        .color(Colors.white())
                        .onPressed(goBack));
    }

    private Widget content() {
        return Column()
                .crossAxisAlignment(CrossAxisAlignment.stretch)
                .children(List.of(
                        Text("Tap a card to spin").style(Palette.sectionTitle()),
                        SizedBox().height(6.0),
                        Text("Hover a card to brighten it; tap to toggle a 360-degree spin.")
                                .style(Palette.subtitle()),
                        SizedBox().height(24.0),
                        FadeTransition(CurvedAnimation(gridFade, Curves.easeIn()).build())
                                .child(tilesGrid()),
                        SizedBox().height(28.0),
                        chipRow()
                ));
    }

    private Widget tilesGrid() {
        return Wrap()
                .spacing(22.0)
                .runSpacing(22.0)
                .alignment(WrapAlignment.center)
                .children(List.of(
                        tile(0), tile(1), tile(2),
                        tile(3), tile(4), tile(5)
                ));
    }

    private Widget tile(int idx) {
        AnimationController c = tileCtrls[idx];
        return Column()
                .mainAxisSize(MainAxisSize.min)
                .children(List.of(
                        SizedBox().width(TILE_SIZE).height(TILE_SIZE).child(
                                TextButton(() -> toggleTile(idx))
                                        .onHover(hover -> setHover(idx, hover))
                                        .child(RotationTransition(
                                                CurvedAnimation(c, Curves.elasticOut()).build())
                                                .child(tileCard(idx)))),
                        SizedBox().height(8.0),
                        Text(tileLabel(idx)).style(TextStyle()
                                .fontSize(13.0)
                                .fontWeight(FontWeight.w600())
                                .color(Colors.black87()))
                ));
    }

    private String tileLabel(int idx) {
        return switch (idx) {
            case 0 -> "Rocket";
            case 1 -> "Spark";
            case 2 -> "Bolt";
            case 3 -> "Bloom";
            case 4 -> "Brush";
            case 5 -> "Heart";
            default -> throw new IllegalStateException("Unknown tile idx: " + idx);
        };
    }

    private Widget tileCard(int idx) {
        boolean h = tileHovered[idx];
        return switch (idx) {
            case 0 -> circleTile(Icons.rocket_rounded(),
                    h ? Colors.pinkAccent().shade400()        : Colors.pink().shade700());
            case 1 -> circleTile(Icons.auto_awesome_rounded(),
                    h ? Colors.amberAccent().shade700()       : Colors.orange().shade800());
            case 2 -> circleTile(Icons.bolt_rounded(),
                    h ? Colors.deepOrangeAccent().shade400()  : Colors.deepOrange().shade700());
            case 3 -> circleTile(Icons.local_florist_rounded(),
                    h ? Colors.greenAccent().shade700()       : Colors.teal().shade700());
            case 4 -> circleTile(Icons.brush_rounded(),
                    h ? Colors.blueAccent().shade400()        : Colors.indigo().shade600());
            case 5 -> circleTile(Icons.favorite_rounded(),
                    h ? Colors.deepPurpleAccent().shade400()  : Colors.deepPurple().shade700());
            default -> throw new IllegalStateException("Unknown tile idx: " + idx);
        };
    }

    private Widget circleTile(IconDataI icon, Color tint) {
        return Container()
                .width(TILE_SIZE)
                .height(TILE_SIZE)
                .decoration(BoxDecoration()
                        .color(tint)
                        .shape(BoxShape.circle)
                        .boxShadow(List.of(Palette.softShadow())))
                .child(Center().child(Icon(icon).color(Colors.white()).size(34.0)));
    }

    private void toggleTile(int idx) {
        if (tileForward[idx]) {
            tileCtrls[idx].reverse();
        } else {
            tileCtrls[idx].forward();
        }
        tileForward[idx] = !tileForward[idx];
    }

    private void setHover(int idx, boolean hover) {
        if (tileHovered[idx] == hover) return;
        setState(() -> tileHovered[idx] = hover);
    }

    private Widget chipRow() {
        return Wrap()
                .spacing(8.0)
                .runSpacing(8.0)
                .alignment(WrapAlignment.center)
                .children(List.of(
                        Chip().label(Text("Shadows")).backgroundColor(Colors.amber().shade100()),
                        Chip().label(Text("Rounded")).backgroundColor(Colors.pink().shade100()),
                        Chip().label(Text("Elastic")).backgroundColor(Colors.teal().shade100()),
                        Chip().label(Text("Material 3")).backgroundColor(Colors.deepPurple().shade100()),
                        Chip().label(Text("Animated")).backgroundColor(Colors.cyan().shade100())
                ));
    }

}
