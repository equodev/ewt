package dev.equo.ide.chrome;

import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.ide.IdePalette;

/**
 * Top-of-window menu strip. The "E" brand mark rotates slowly during the
 * app's entrance for a small dash of motion.
 */
public class MenuBar extends SubStatelessWidget {

    private static final List<String> ITEMS = List.of(
            "File", "Edit", "View", "Navigate", "Refactor", "Run", "Tools", "Help"
    );

    private final boolean dark;
    private final AnimationController entryCtrl;

    public MenuBar(boolean dark, AnimationController entryCtrl) {
        this.dark = dark;
        this.entryCtrl = entryCtrl;
    }

    @Override
    protected Widget build(BuildContext context) {
        return Container()
                .height(32.0)
                .color(IdePalette.bgMenuBar(dark))
                .padding(EdgeInsets_symmetric().horizontal(10.0).build())
                .child(Row().children(rowChildren()));
    }

    private List<WidgetI> rowChildren() {
        java.util.ArrayList<WidgetI> out = new java.util.ArrayList<>();
        out.add(brand());
        out.add(SizedBox().width(18.0));
        for (String item : ITEMS) {
            out.add(menuItem(item));
        }
        return out;
    }

    private Widget brand() {
        Widget logo = Container()
                .width(20.0)
                .height(20.0)
                .decoration(BoxDecoration()
                        .color(IdePalette.accent(dark))
                        .borderRadius(BorderRadius_circular(6.0))
                        .boxShadow(List.of(BoxShadow()
                                .color(IdePalette.glow(dark))
                                .blurRadius(10.0)
                                .offset(Offset(0.0, 2.0)))))
                .alignment(Alignment.center())
                .child(Text("E").style(TextStyle()
                        .fontSize(11.0)
                        .fontWeight(FontWeight.w800())
                        .color(Colors.white())));

        return Row().mainAxisSize(MainAxisSize.min).children(List.of(
                RotationTransition(CurvedAnimation(entryCtrl, Curves.easeOutBack()).build())
                        .child(logo),
                SizedBox().width(10.0),
                Text("EWT IDE").style(TextStyle()
                        .fontSize(13.0)
                        .fontWeight(FontWeight.w700())
                        .letterSpacing(0.3)
                        .color(IdePalette.textPrimary(dark))),
                SizedBox().width(6.0),
                Container()
                        .padding(EdgeInsets_symmetric().horizontal(6.0).vertical(1.0).build())
                        .decoration(BoxDecoration()
                                .color(IdePalette.accent2(dark))
                                .borderRadius(BorderRadius_circular(4.0)))
                        .child(Text("dev").style(TextStyle()
                                .fontSize(9.0)
                                .fontWeight(FontWeight.w700())
                                .color(Colors.white())))
        ));
    }

    private Widget menuItem(String label) {
        return Padding(EdgeInsets_symmetric().horizontal(8.0).build())
                .child(Center().child(Text(label).style(IdePalette.menuItem(dark))));
    }
}
