package dev.equo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.EwtWidget;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import dev.equo.showcase.AnimationPlaygroundPage;
import dev.equo.showcase.SlideTransitionPage;

/**
 * Web launcher for EWT web-path demos. Mounts a single EwtWidget region inside an Evolve window;
 * a native SWT combo lets you switch between available demos without restarting.
 *
 * <pre>
 *   (cd evolve-app && flutter build web --no-tree-shake-icons)
 *   ./gradlew :examples:runShowcaseWeb -PuseLocal=true
 * </pre>
 */
public class EvolveSamples {

    private static final String[] DEMO_NAMES = {
        "EWT Web Showcase",
        "Animation Playground",
        "Slide Transition",
        "Cupertino Widgets",
    };

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("EWT Web Demos");
        shell.setSize(760, 880);
        shell.setLayout(new GridLayout(2, false));

        Label label = new Label(shell, SWT.NONE);
        label.setText("Demo:");

        Combo combo = new Combo(shell, SWT.DROP_DOWN | SWT.READ_ONLY);
        combo.setItems(DEMO_NAMES);
        combo.select(0);
        combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        EwtWidget region = new EwtWidget(shell, SWT.NONE);
        region.setPreferredSize(SWT.DEFAULT, 820);
        GridData rd = new GridData(SWT.FILL, SWT.FILL, true, true);
        rd.horizontalSpan = 2;
        region.setLayoutData(rd);
        region.setWidget(EwtWebShowcase.ShowcasePage::new);

        combo.addListener(SWT.Selection, e -> {
            switch (combo.getSelectionIndex()) {
                case 0 -> region.setWidget(EwtWebShowcase.ShowcasePage::new);
                case 1 -> region.setWidget(() -> new AnimationPlaygroundPage(() -> {}));
                case 2 -> region.setWidget(() -> new SlideTransitionPage(() -> {}));
                case 3 -> region.setWidget(CupertinoShowcase.ShowcasePage::new);
            }
        });

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
        display.dispose();
    }
}
