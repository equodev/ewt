package dev.equo;

import java.util.concurrent.Callable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.EwtWidget;
import org.eclipse.swt.widgets.Shell;

import dev.equo.ewt.Widget;

/**
 * Web launcher for the EWT Web Showcase. Mounts the showcase page as a single EwtWidget web
 * region inside an Evolve window, demonstrating EWT's web path end-to-end.
 */
public class EvolveSamples {

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("EWT Web Showcase");
        shell.setSize(760, 820);
        shell.setLayout(new GridLayout(1, false));

        EwtWidget region = new EwtWidget(shell, SWT.NONE);
        region.setPreferredSize(SWT.DEFAULT, 820);
        region.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        region.setWidget(EwtWebShowcase.ShowcasePage::new);

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
        display.dispose();
    }
}
