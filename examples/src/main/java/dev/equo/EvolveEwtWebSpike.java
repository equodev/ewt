package dev.equo;

import java.util.concurrent.Callable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.EwtWidget;
import org.eclipse.swt.widgets.Shell;

import dev.equo.ewt.Widget;
import static dev.equo.ewt.EWT.*;

/**
 * Minimal web-transport spike: an EWT region whose subtree uses ONLY the widgets the Phase 0
 * serializer supports (Text, SizedBox). Under Evolve's web surface the subtree travels over the
 * comm (not FFM) and paints in the browser. The richer {@code EvolveEwtButtons} sample needs the
 * full generated serializer (a later phase), so it cannot exercise the web path yet.
 */
public class EvolveEwtWebSpike {

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("EWT web spike");
        shell.setSize(480, 360);
        shell.setLayout(new GridLayout(1, false));

        Composite root = new Composite(shell, SWT.NONE);
        root.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        root.setLayout(new GridLayout(1, false));

        EwtWidget region = new EwtWidget(root, SWT.NONE);
        region.setPreferredSize(SWT.DEFAULT, 200);
        region.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        region.setWidget(spikeTree());

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
        display.dispose();
    }

    /** A tree limited to Phase 0 widgets: a sized box wrapping a text label. */
    private static Callable<Widget> spikeTree() {
        return () -> SizedBox()
            .width(300.0)
            .height(160.0)
            .child(Text("hello web via comm"))
            .build();
    }
}
