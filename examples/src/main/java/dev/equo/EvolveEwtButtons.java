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
        shell.setSize(780, 560);
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

        // ── Right: EWT profile card (a Flutter widget built in Java) ──
        EwtWidget card = new EwtWidget(shell, SWT.NONE);
        card.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        card.setWidget(profileCard());

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
