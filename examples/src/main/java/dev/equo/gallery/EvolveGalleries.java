package dev.equo.gallery;

import java.util.concurrent.Callable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.EwtWidget;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import dev.equo.ewt.Widget;

/**
 * WEB GAP-ANALYSIS harness. Mounts ONE gallery family's page (a Scaffold subtree,
 * NOT its MaterialApp root) as a single EwtWidget web region, so each family can be
 * eyeballed on the web path in a clean single-mount run — the proven EvolveEwtButtons
 * pattern, which avoids the "frame buffered before the region subscribes" risk that
 * hidden/swapped regions would hit.
 *
 * Pick the family with {@code -Ddev.equo.gallery.family=Layout|Material|Animations|Scroll|Tabs}
 * (the {@code runGalleriesWeb -Pgallery=...} task wires this through). Diagnostic only —
 * not part of the shipped examples.
 */
public class EvolveGalleries {

    public static void main(String[] args) {
        String family = System.getProperty("dev.equo.gallery.family", "Layout");

        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("EWT web gap-analysis — " + family);
        shell.setSize(760, 820);
        shell.setLayout(new GridLayout(1, false));

        Label heading = new Label(shell, SWT.WRAP);
        heading.setText("Family: " + family + "  (web region below)");
        heading.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

        EwtWidget region = new EwtWidget(shell, SWT.NONE);
        region.setPreferredSize(SWT.DEFAULT, 720);
        region.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        region.setWidget(pageFor(family));

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
        display.dispose();
    }

    /** The gallery family's page (its own Scaffold), mounted as the region's EWT subtree. */
    private static Callable<Widget> pageFor(String family) {
        switch (family) {
            case "Layout":     return () -> new LayoutWidgetsGallery.GalleryPage();
            case "Material":   return () -> new MaterialControlsGallery.ControlsPage();
            case "Animations": return () -> new ImplicitAnimationsGallery.AnimationsPage();
            case "Scroll":     return () -> new ScrollWidgetsGallery.ScrollPage();
            case "Tabs":       return () -> new TabsGallery.TabsPage();
            default:
                throw new IllegalArgumentException(
                    "Unknown gallery family '" + family + "'. "
                        + "Use one of: Layout, Material, Animations, Scroll, Tabs.");
        }
    }
}
