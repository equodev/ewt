package dev.equo.ewt.evolve.demo;

import java.util.List;
import java.util.concurrent.Callable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.EwtWidget;
import org.eclipse.ui.part.ViewPart;

import dev.equo.ewt.*;                        // EWT widget classes (Colors, Icons, enums…)
import static dev.equo.ewt.EWT.*;             // EWT widget factories (Text, Container, …)

/**
 * Demo Eclipse view that mounts an EWT (Flutter) subtree inside a real RCP {@link ViewPart},
 * proving the {@code dev.equo.ewt.evolve.feature} works end-to-end after a p2 install.
 *
 * <p>This is the "demo plugin con la vista" the CLI feature bundles (see
 * ewt-evolve-p2-distribution-spec.md §1). The mount pattern mirrors the standalone sample
 * {@code EvolveEwtButtons}: an {@link EwtWidget} hosts a Flutter subtree built in Java, with a
 * preferred size declared so the childless region does not collapse.
 */
public class EwtShowcaseView extends ViewPart {

    @Override
    public void createPartControl(Composite parent) {
        EwtWidget region = new EwtWidget(parent, SWT.NONE);
        region.setPreferredSize(SWT.DEFAULT, 320);
        region.setWidget(card());
    }

    /** The EWT (Flutter) subtree shown in the view. */
    private static Callable<Widget> card() {
        return () -> Center().child(
            Container()
                .width(360.0)
                .padding(EdgeInsets_all(28.0))
                .decoration(BoxDecoration()
                    .color(Colors.white())
                    .borderRadius(BorderRadius_circular(24.0)))
                .child(Column()
                    .mainAxisSize(MainAxisSize.min)
                    .crossAxisAlignment(CrossAxisAlignment.center)
                    .children(List.of(
                        Icon(Icons.verified()).size(46.0).color(Colors.indigo()),
                        SizedBox().height(16.0),
                        Text("EWT running inside Evolve")
                            .style(TextStyle().fontSize(20.0).fontWeight(FontWeight.bold())),
                        SizedBox().height(6.0),
                        Text("Rendered from an Eclipse ViewPart via the ewt-evolve feature")
                            .style(TextStyle().fontSize(13.0).color(Colors.grey().shade600()))))));
    }

    @Override
    public void setFocus() {
        // Nothing to focus — the Flutter subtree owns its own focus.
    }
}
