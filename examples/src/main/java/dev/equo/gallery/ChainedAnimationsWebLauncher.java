package dev.equo.gallery;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.EwtWidget;
import org.eclipse.swt.widgets.Shell;

/**
 * Web launcher for {@link ChainedAnimationsGallery}. Puts the same {@code ChainPage}
 * inside an {@link EwtWidget} region so the entire chain (opacity fade + scale + fling)
 * runs through the Evolve transport with the async-callback broker introduced by
 * issue #60.
 *
 * <pre>
 *   (cd evolve-app && flutter build web --no-tree-shake-icons)
 *   ./gradlew :examples:runChainedAnimationsWeb -PuseLocal=true
 * </pre>
 *
 * <p>Same Java code path as the desktop main in {@link ChainedAnimationsGallery} —
 * the mode is picked up by the launcher (via {@code EwtWebTransport.isWebMode()})
 * and every controller method is routed through the async transport.
 */
public class ChainedAnimationsWebLauncher {

  public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("EWT — Chained Animations (Web)");
    shell.setSize(560, 720);
    shell.setLayout(new FillLayout());

    EwtWidget region = new EwtWidget(shell, SWT.NONE);
    region.setWidget(ChainedAnimationsGallery.ChainPage::new);

    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) display.sleep();
    }
    display.dispose();
  }
}
