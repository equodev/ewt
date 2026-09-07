package dev.equo.engagements;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.EwtWidget;
import org.eclipse.swt.widgets.Shell;

/**
 * Web launcher for the Engagements Console POC.
 *
 * <p>Single-region host: one EwtWidget fills the shell and hosts the POC via
 * {@link EngagementsAttachPage}. The SWT event loop is Evolve's — its Java-side
 * WebSocket server drives the browser-side Flutter engine that renders our
 * subtree.
 *
 * <pre>
 *   # 1. Build swt-evolve native jar (Linux example):
 *   (cd ../swt-evolve && ./gradlew :swt_native:linux-x86_64Jar)
 *
 *   # 2. Generate EWT bindings (once, or after generator changes):
 *   rm -f generator/build/pregeneration_index.dart.ts
 *   ./gradlew :generator:generator
 *
 *   # 3. Build the combined web bundle (once, or after Dart changes):
 *   (cd evolve-app && flutter pub get && flutter build web --no-tree-shake-icons)
 *
 *   # 4. Run — opens the browser automatically:
 *   ./gradlew :examples:runEngagementsWeb -PuseLocal=true
 * </pre>
 */
public class EngagementsWebSamples {

  public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("Engagements Console — Web");
    shell.setSize(1400, 900);
    shell.setLayout(new FillLayout());

    EwtWidget region = new EwtWidget(shell, SWT.NONE);
    region.setWidget(EngagementsAttachPage::new);

    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) display.sleep();
    }
    display.dispose();
  }
}
