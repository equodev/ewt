package dev.equo.gallery;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.EwtWidget;
import org.eclipse.swt.widgets.Shell;

/**
 * Web launcher for {@link MapGallery}. Mounts the same {@code GalleryPage} — the
 * flutter_map GIS viewer with DecisionSpace's dataset, the attribute table and the
 * shapefile/GeoJSON toggles — inside an {@link EwtWidget} region, so the entire map
 * runs through the Evolve web transport (serialized widget tree rendered in the
 * browser) rather than the native FFM path. Proves the GIS viewer runs on web,
 * which the JavaFX/Esri stack it replaces cannot.
 *
 * <pre>
 *   (cd evolve-app && flutter build web --no-tree-shake-icons)   # or: ./gradlew :examples:buildCombinedWebBundle
 *   ./gradlew :examples:runMapGalleryWeb -PuseLocal=true
 * </pre>
 *
 * <p>Same Java code path as the desktop main in {@link MapGallery} — the mode is
 * picked up via {@code EwtWebTransport.isWebMode()} and every camera/identify/tap
 * round-trips through the comm transport.
 */
public class MapGalleryWebLauncher {

  public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("EWT — GIS map (Web)");
    shell.setSize(1000, 820);
    shell.setLayout(new FillLayout());

    EwtWidget region = new EwtWidget(shell, SWT.NONE);
    region.setWidget(MapGallery.GalleryPage::new);

    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) display.sleep();
    }
    display.dispose();
  }
}
