package dev.equo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.EwtWidget;
import org.eclipse.swt.widgets.Shell;

import dev.equo.ide2.IdeShell2;
import dev.equo.showcase.AnimationPlaygroundPage;
import dev.equo.showcase.SlideTransitionPage;

/**
 * Web launcher for EWT web-path demos.
 *
 * <p>Two stacked EwtWidget regions:
 * <ul>
 *   <li>{@code navBar} — Flutter-rendered tab strip (always visible, never replaced)
 *   <li>{@code content} — the active demo; switched via {@code setWidget()} when a tab is tapped
 * </ul>
 *
 * <pre>
 *   (cd evolve-app && flutter build web --no-tree-shake-icons)
 *   ./gradlew :examples:runShowcaseWeb -PuseLocal=true
 * </pre>
 */
public class EvolveSamples {

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("EWT Web Demos");
        shell.setSize(760, 900);
        shell.setLayout(new GridLayout(1, false));

        // ---- nav strip (60 px tall, never replaced) ----
        EwtWidget navBar = new EwtWidget(shell, SWT.NONE);
        navBar.setPreferredSize(SWT.DEFAULT, 60);
        GridData navData = new GridData(SWT.FILL, SWT.FILL, true, false);
        navBar.setLayoutData(navData);

        // ---- demo content (fills remaining space, switched on tab tap) ----
        EwtWidget content = new EwtWidget(shell, SWT.NONE);
        content.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        content.setWidget(EwtWebShowcase.ShowcasePage::new);

        // ---- wire the nav callbacks ----
        navBar.setWidget(() -> new EvolveSamplesNav(idx ->
                display.asyncExec(() -> content.setWidget(switch (idx) {
                    case 0 -> EwtWebShowcase.ShowcasePage::new;
                    case 1 -> () -> new AnimationPlaygroundPage(() -> {});
                    case 2 -> () -> new SlideTransitionPage(() -> {});
                    case 3 -> CupertinoMixPage.Page::new;
                    case 4 -> IdeShell2::new;
                    default -> EwtWebShowcase.ShowcasePage::new;
                }))
        ));

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
        display.dispose();
    }
}
