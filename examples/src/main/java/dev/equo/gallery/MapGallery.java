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
 * Tier-1 chrome: basemap switcher (the 8 Esri basemaps DecisionSpace ships),
 * scale bar + overview mini-map (in the widget), identify panel, entrance anim.
 *
 *   ./gradlew :examples:run -PuseLocal=true -PmainClass=dev.equo.gallery.MapGallery
 */
public class MapGallery {

  public static void main(String[] args) {
    App.runApp(MyApp::new);
  }

  // The 8 basemaps DecisionSpace's GIS Map lists (GISWebServiceEnum), as Esri
  // MapServer tile endpoints; OpenStreetMap uses the standard OSM tile source.
  static final String AGS =
      "https://services.arcgisonline.com/ArcGIS/rest/services/";
  static final String[][] BASEMAPS = {
      {"Imagery",    AGS + "World_Imagery/MapServer/tile/{z}/{y}/{x}"},
      {"Streets",    AGS + "World_Street_Map/MapServer/tile/{z}/{y}/{x}"},
      {"Terrain",    AGS + "World_Terrain_Base/MapServer/tile/{z}/{y}/{x}"},
      {"Light Gray", AGS + "Canvas/World_Light_Gray_Base/MapServer/tile/{z}/{y}/{x}"},
      {"NatGeo",     AGS + "NatGeo_World_Map/MapServer/tile/{z}/{y}/{x}"},
      {"Ocean",      AGS + "Ocean/World_Ocean_Base/MapServer/tile/{z}/{y}/{x}"},
      {"Topo",       AGS + "World_Topo_Map/MapServer/tile/{z}/{y}/{x}"},
      {"OSM",        "https://tile.openstreetmap.org/{z}/{x}/{y}.png"},
  };

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
    // Sample wells (Permian Basin, West Texas) — attributes index-aligned.
    static final String[] NAMES =
        {"Spraberry 1H", "Wolfcamp 2H", "Midland A-4", "Loving 7", "Reeves 12"};
    static final String[] TYPES =
        {"Horizontal", "Horizontal", "Vertical", "Horizontal", "Injection"};
    static final String[] DEPTHS = {"9,850", "11,200", "7,400", "10,600", "8,100"};
    static final String[] STATUS = {"Producing", "Producing", "Shut-in", "Producing", "Active"};
    static final String WELLS =
        "31.98,-102.05;31.90,-102.20;32.02,-101.95;31.88,-102.02;31.95,-102.30";
    static final String FIELD =
        "31.85,-102.35 32.05,-102.35 32.05,-101.90 31.85,-101.90";

    String _basemap = BASEMAPS[0][1];           // World_Imagery (DSG default)
    String _camera = "31.95,-102.10,8";          // Java-owned camera
    int _sel = -1;                                // selected well (identify)

    Widget basemapChip(String label, String url) {
      boolean selected = url.equals(_basemap);
      return GestureDetector()
          .onTap(() -> setState(() -> _basemap = url))
          .child(Container().padding(EdgeInsets_all(8.0))
              .decoration(BoxDecoration()
                  .color(selected ? Colors.teal() : Colors.white())
                  .borderRadius(BorderRadius_circular(16.0))
                  .border(Border_all().color(Colors.teal()).width(1.0)))
              .child(Text(label).style(TextStyle()
                  .color(selected ? Colors.white() : Colors.teal())
                  .fontSize(12.0))));
    }

    Widget identifyCard() {
      if (_sel < 0) {
        return Text("Tap a well to identify it.").style(TextStyle().color(Colors.grey()));
      }
      return Container().padding(EdgeInsets_all(12.0))
          .decoration(BoxDecoration()
              .color(Colors.white())
              .borderRadius(BorderRadius_circular(8.0))
              .border(Border_all().color(Colors.teal()).width(1.0)))
          .child(Column().mainAxisSize(MainAxisSize.min)
              .crossAxisAlignment(CrossAxisAlignment.start)
              .children(List.<WidgetI>of(
                  Text(NAMES[_sel]).style(TextStyle().fontWeight(FontWeight.w700()).fontSize(14.0)),
                  SizedBox().height(4.0),
                  Text("Type: " + TYPES[_sel]),
                  Text("TD: " + DEPTHS[_sel] + " ft     Status: " + STATUS[_sel]))));
    }

    @Override
    public Widget build(BuildContext context) {
      java.util.List<WidgetI> chips = new java.util.ArrayList<>();
      for (String[] b : BASEMAPS) chips.add(basemapChip(b[0], b[1]));

      return page(context, "GIS map — Esri basemaps + wells", Colors.teal(), List.of(

          Text("An Esri-tiled basemap with wells and a lease block, rendered by flutter_map "
              + "inside EWT — the 8 basemaps DecisionSpace ships, a scale bar, overview and "
              + "identify. Pan/zoom is owned by Java and persists (desktop and web/Evolve)."),
          SizedBox().height(12.0),
          Wrap().spacing(8.0).runSpacing(8.0).children(chips),
          SizedBox().height(12.0),
          Center().child(Container().width(760.0).height(460.0)
              .decoration(BoxDecoration()
                  .borderRadius(BorderRadius_circular(12.0))
                  .border(Border_all().color(Colors.grey()).width(1.0)))
              .child(ClipRRect().borderRadius(BorderRadius_circular(12.0)).child(
                  EwtMapView(List.<WidgetI>of(wellPin(), wellPin(), wellPin(), wellPin(), wellPin()))
                      .tileUrl(_basemap)
                      .camera(_camera)
                      .markerCoords(WELLS)
                      .polygons(FIELD)
                      .minZoom(3.0).maxZoom(17.0)
                      .onCameraMoved(c -> setState(() -> _camera = c))
                      .onMarkerTap(i -> setState(() -> _sel = Integer.parseInt(i)))))),
          SizedBox().height(12.0),
          identifyCard()
      ));
    }
  }
}
