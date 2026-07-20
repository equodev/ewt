package dev.equo;

import java.util.List;
import java.util.concurrent.Callable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.EwtWidget;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import dev.equo.ewt.*;                        // EWT widget classes (Colors, Icons, enums…)
import static dev.equo.ewt.EWT.*;             // EWT widget factories (Text, Container, …)

/**
 * NORTH-STAR sample for the EWT ↔ SWT Evolve same-surface integration.
 *
 * A native Evolve column (SWT {@code Label} + {@code Button}s) sits next to a polished
 * EWT profile card (a Flutter widget tree built in Java) — composing in the SAME Flutter
 * surface, one shared engine. The EWT subtree is mounted through {@link EwtWidget}.
 */
public class EvolveEwtButtons {

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Evolve + EWT — same surface");
        shell.setSize(780, 760);
        shell.setLayout(new GridLayout(2, false));

        // ── Left: native Evolve controls (plain SWT, rendered by Evolve) ──
        Composite left = new Composite(shell, SWT.NONE);
        left.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
        left.setLayout(new GridLayout(1, false));

        Label heading = new Label(left, SWT.WRAP);
        heading.setText("Evolve (native SWT)");

        makeButton(left, "Like", () -> System.out.println("[Evolve] Like"));
        makeButton(left, "Message", () -> System.out.println("[Evolve] Message"));
        makeButton(left, "Reset", () -> System.out.println("[Evolve] Reset"));

        // ── Right: THREE distinct EWT regions stacked (multi-region check) ──
        // Each EwtWidget registers its own builder keyed by its widget id. Because the
        // three regions render different content, per-id dispatch works; if they showed
        // the SAME subtree, the builder registry would have collapsed to a global singleton.
        //
        // Sizing note: an EwtWidget mounts a Flutter subtree whose height SWT cannot know,
        // so each region declares its natural size via setPreferredSize (fed into
        // computeSize). The profile card GRABS the extra vertical space and keeps its
        // content centered, so it follows the window on resize; the region also clips, so
        // if the window shrinks below the card it is trimmed, never overlapping neighbours.
        // The stats + actions bars keep their natural height, pinned to the top.
        Composite right = new Composite(shell, SWT.NONE);
        right.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        right.setLayout(new GridLayout(1, false));

        EwtWidget card = new EwtWidget(right, SWT.NONE);
        card.setPreferredSize(SWT.DEFAULT, 430);
        card.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        card.setWidget(profileCard());

        EwtWidget stats = new EwtWidget(right, SWT.NONE);
        stats.setPreferredSize(SWT.DEFAULT, 130);
        stats.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        stats.setWidget(statsCard());

        EwtWidget actions = new EwtWidget(right, SWT.NONE);
        actions.setPreferredSize(SWT.DEFAULT, 130);
        actions.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        actions.setWidget(quickActions());

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
        display.dispose();
    }

    private static void makeButton(Composite parent, String text, Runnable onClick) {
        Button b = new Button(parent, SWT.PUSH);
        b.setText(text);
        b.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        b.addListener(SWT.Selection, e -> onClick.run());
    }

    /** The EWT (Flutter) subtree mounted inside the Evolve window. */
    private static Callable<Widget> profileCard() {
        return () -> Center().child(
            Container()
                .width(360.0)
                .padding(EdgeInsets_all(28.0))
                .decoration(BoxDecoration()
                    .color(Colors.white())
                    .borderRadius(BorderRadius_circular(24.0))
                    .boxShadow(List.of(BoxShadow()
                        .color(Color_fromRGBO(79, 70, 229, 0.22))
                        .blurRadius(32.0)
                        .offset(Offset(0.0, 14.0)))))
                .child(Column()
                    .mainAxisSize(MainAxisSize.min)
                    .crossAxisAlignment(CrossAxisAlignment.center)
                    .children(List.of(
                        // Avatar
                        Container()
                            .width(84.0)
                            .height(84.0)
                            .alignment(Alignment.center())
                            .decoration(BoxDecoration()
                                .shape(BoxShape.circle)
                                .color(Colors.indigo()))
                            .child(Icon(Icons.person())
                                .size(46.0)
                                .color(Colors.white())),
                        SizedBox().height(16.0),
                        // Name + verified badge
                        Row()
                            .mainAxisSize(MainAxisSize.min)
                            .crossAxisAlignment(CrossAxisAlignment.center)
                            .children(List.of(
                                Text("Ada Lovelace")
                                    .style(TextStyle().fontSize(22.0).fontWeight(FontWeight.bold())),
                                SizedBox().width(6.0),
                                Icon(Icons.verified()).size(20.0).color(Colors.indigo()))),
                        SizedBox().height(4.0),
                        Text("Flutter Engineer · Equo")
                            .style(TextStyle().fontSize(13.0).color(Colors.grey().shade600())),
                        SizedBox().height(14.0),
                        // Rating (4 / 5 stars)
                        Row()
                            .mainAxisSize(MainAxisSize.min)
                            .children(List.of(
                                star(true), star(true), star(true), star(true), star(false))),
                        SizedBox().height(18.0),
                        // Skill chips
                        Wrap()
                            .spacing(8.0)
                            .runSpacing(8.0)
                            .alignment(WrapAlignment.center)
                            .children(List.of(
                                chip("Dart"), chip("Flutter"), chip("UI"), chip("Animation"))),
                        SizedBox().height(22.0),
                        Divider(),
                        SizedBox().height(16.0),
                        // Actions
                        Row()
                            .mainAxisAlignment(MainAxisAlignment.center)
                            .crossAxisAlignment(CrossAxisAlignment.center)
                            .children(List.of(
                                FilledButton(() -> System.out.println("[EWT] Follow"))
                                    .child(Text("Follow")),
                                SizedBox().width(8.0),
                                IconButton()
                                    .onPressed(() -> System.out.println("[EWT] favorite"))
                                    .icon(Icon(Icons.favorite()).color(Colors.pink())),
                                IconButton()
                                    .onPressed(() -> System.out.println("[EWT] share"))
                                    .icon(Icon(Icons.share()).color(Colors.grey().shade600())),
                                IconButton()
                                    .onPressed(() -> System.out.println("[EWT] more"))
                                    .icon(Icon(Icons.more_horiz()).color(Colors.grey().shade600()))))))));
    }

    /**
     * A SECOND, deliberately different EWT subtree for the multi-region check: a dark
     * stats banner. It must render its own content in its own region — not a copy of
     * {@link #profileCard()}.
     */
    private static Callable<Widget> statsCard() {
        return () -> Center().child(
            Container()
                .width(360.0)
                .padding(EdgeInsets_all(24.0))
                .decoration(BoxDecoration()
                    .color(Color_fromRGBO(17, 24, 39, 1.0))
                    .borderRadius(BorderRadius_circular(24.0)))
                .child(Row()
                    .mainAxisAlignment(MainAxisAlignment.spaceAround)
                    .crossAxisAlignment(CrossAxisAlignment.center)
                    .children(List.of(
                        stat("128", "Repos"),
                        stat("4.9k", "Followers"),
                        stat("312", "Stars")))));
    }

    private static Widget stat(String value, String label) {
        return Column()
            .mainAxisSize(MainAxisSize.min)
            .children(List.of(
                Text(value)
                    .style(TextStyle().fontSize(24.0).fontWeight(FontWeight.bold()).color(Colors.white())),
                SizedBox().height(4.0),
                Text(label)
                    .style(TextStyle().fontSize(12.0).color(Colors.grey().shade400()))));
    }

    /**
     * A THIRD, distinct EWT subtree for the multi-region check: a teal quick-actions
     * bar (rounded tiles with an icon + label). It shares no distinctive widget with
     * {@link #profileCard()} or {@link #statsCard()}, so seeing all three at once
     * confirms each region builds its own tree.
     */
    private static Callable<Widget> quickActions() {
        return () -> Center().child(
            Container()
                .width(360.0)
                .padding(EdgeInsets_all(20.0))
                .decoration(BoxDecoration()
                    .color(Color_fromRGBO(13, 148, 136, 1.0))
                    .borderRadius(BorderRadius_circular(24.0)))
                .child(Row()
                    .mainAxisAlignment(MainAxisAlignment.spaceAround)
                    .children(List.of(
                        action(Icons.call(), "Call"),
                        action(Icons.mail(), "Mail"),
                        action(Icons.event(), "Meet"),
                        action(Icons.more_horiz(), "More")))));
    }

    private static Widget action(IconData icon, String label) {
        return Column()
            .mainAxisSize(MainAxisSize.min)
            .children(List.of(
                Container()
                    .width(48.0)
                    .height(48.0)
                    .alignment(Alignment.center())
                    .decoration(BoxDecoration()
                        .shape(BoxShape.circle)
                        .color(Color_fromRGBO(255, 255, 255, 0.18)))
                    .child(Icon(icon).size(22.0).color(Colors.white())),
                SizedBox().height(8.0),
                Text(label)
                    .style(TextStyle().fontSize(12.0).color(Colors.white()))));
    }

    private static Widget star(boolean filled) {
        return Icon(filled ? Icons.star() : Icons.star_border())
            .size(20.0)
            .color(Colors.amber());
    }

    private static Widget chip(String text) {
        return Chip()
            .label(Text(text).style(TextStyle().fontSize(12.0).color(Colors.indigo().shade700())))
            .backgroundColor(Colors.indigo().shade50());
    }
}
