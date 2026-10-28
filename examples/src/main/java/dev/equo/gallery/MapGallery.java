package dev.equo.gallery;

import java.util.List;

import dev.equo.ewt.*;

import static dev.equo.ewt.EWT.*;
import static dev.equo.gallery.GalleryKit.*;

/**
 * GIS map viewer — an Esri-tiled satellite basemap with wells and a lease block,
 * wrapping the third-party flutter_map through {@link EwtMapView}. The camera is
 * OWNED BY JAVA and a pan/zoom round-trips back ("lat,lng,zoom"), so it works on
 * FFM (desktop) and comm (web / Evolve) alike — a modern, pure-Flutter stand-in
 * for an embedded Esri GIS component.
 *
 *   ./gradlew :examples:run -PuseLocal=true -PmainClass=dev.equo.gallery.MapGallery
 */
public class MapGallery {

  public static void main(String[] args) {
    App.runApp(MyApp::new);
  }

  // Esri World Imagery — the same satellite basemap the DecisionSpace GIS map uses.
  static final String ESRI_IMAGERY =
      "https://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}";

  // A well marker: an amber dot with a white ring. Any EWT widget works as a pin.
  static Widget wellPin() {
    return Container().width(16.0).height(16.0)
        .decoration(BoxDecoration()
            .color(Colors.amber())
            .borderRadius(BorderRadius_circular(8.0))
            .border(Border_all().color(Colors.white()).width(2.0)));
  }

  static class MyApp extends SubStatelessWidget {
    @Override
    protected Widget build(BuildContext context) {
      return MaterialApp()
          .title("EWT — GIS map")
          .theme(ThemeData().colorScheme(ColorScheme_fromSeed(Colors.teal())).useMaterial3(true))
          .home(new GalleryPage());
    }
  }

  static class GalleryPage extends SubStatefulWidget {
    @Override
    protected State<GalleryPage> createState() {
      return new GalleryState();
    }
  }

  static class GalleryState extends SubState<GalleryPage> {
    // Sample wells (Permian Basin, West Texas) — names index-aligned with coords.
    static final String[] NAMES =
        {"Spraberry 1H", "Wolfcamp 2H", "Midland A-4", "Loving 7", "Reeves 12"};
    static final String WELLS =
        "31.98,-102.05;31.90,-102.20;32.02,-101.95;31.88,-102.02;31.95,-102.30";
    // A rough lease/field block as a polygon ring ("lat,lng lat,lng ...").
    static final String FIELD =
        "31.85,-102.35 32.05,-102.35 32.05,-101.90 31.85,-101.90";

    // Java-owned camera ("lat,lng,zoom") — the source of truth across rebuilds.
    String _camera = "31.95,-102.10,8";
    String _tapped = "—";

    @Override
    public Widget build(BuildContext context) {
      return page(context, "GIS map — Esri basemap + wells", Colors.teal(), List.of(

          Text("An Esri-tiled satellite basemap with wells and a lease block, rendered by "
              + "flutter_map inside EWT. Pan/zoom is owned by Java and persists — same on "
              + "desktop (FFM) and web/Evolve (comm)."),
          SizedBox().height(14.0),
          Center().child(Container().width(720.0).height(460.0)
              .decoration(BoxDecoration()
                  .borderRadius(BorderRadius_circular(12.0))
                  .border(Border_all().color(Colors.grey()).width(1.0)))
              .child(ClipRRect().borderRadius(BorderRadius_circular(12.0)).child(
                  EwtMapView(List.<WidgetI>of(wellPin(), wellPin(), wellPin(), wellPin(), wellPin()))
                      .tileUrl(ESRI_IMAGERY)
                      .camera(_camera)
                      .markerCoords(WELLS)
                      .polygons(FIELD)
                      .minZoom(3.0).maxZoom(17.0)
                      .onCameraMoved(c -> setState(() -> _camera = c))
                      .onMarkerTap(i -> setState(() -> _tapped = NAMES[Integer.parseInt(i)]))))),
          SizedBox().height(10.0),
          Text("Camera: " + _camera + "     |     Selected well: " + _tapped)
      ));
    }
  }
}
