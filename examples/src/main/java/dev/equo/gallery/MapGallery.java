package dev.equo.gallery;

import java.util.List;

import dev.equo.ewt.*;

import static dev.equo.ewt.EWT.*;
import static dev.equo.gallery.GalleryKit.*;

/**
 * GIS map viewer — an Esri-tiled satellite basemap with labelled wells and a
 * lease block, wrapping the third-party flutter_map through {@link EwtMapView}.
 * The camera is OWNED BY JAVA and a pan/zoom round-trips back ("lat,lng,zoom"),
 * so it works on FFM (desktop) and comm (web / Evolve) alike — a modern,
 * pure-Flutter stand-in for an embedded Esri GIS component.
 *
 * Chrome modelled on DecisionSpace's GIS Map: basemap switcher (the 8 Esri
 * basemaps it ships), scale bar + overview mini-map, a Table-of-Contents with
 * layer toggles, an identify panel, a CRS/coordinate footer, and entrance anim.
 *
 *   ./gradlew :examples:run -PuseLocal=true -PmainClass=dev.equo.gallery.MapGallery
 */
public class MapGallery {

  public static void main(String[] args) {
    App.runApp(MyApp::new);
  }

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

  // A labelled well marker: a name pill above an amber dot with a white ring.
  static Widget wellPin(String name) {
    return Column().mainAxisSize(MainAxisSize.min).children(List.<WidgetI>of(
        Container().padding(EdgeInsets_all(3.0))
            .decoration(BoxDecoration()
                .color(Colors.black())
                .borderRadius(BorderRadius_circular(4.0)))
            .child(Text(name).style(TextStyle().color(Colors.white()).fontSize(10.0))),
        SizedBox().height(2.0),
        Container().width(14.0).height(14.0)
            .decoration(BoxDecoration()
                .color(Colors.amber())
                .borderRadius(BorderRadius_circular(7.0))
                .border(Border_all().color(Colors.white()).width(2.0)))));
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
    static final String[] NAMES = {
        "Spraberry 1H", "Wolfcamp 2H", "Midland A-4", "Loving 7", "Reeves 12",
        "Spraberry 3H", "Wolfcamp 5H", "Howard 9", "Martin B-2", "Glasscock 4"};
    static final String[] TYPES = {
        "Horizontal", "Horizontal", "Vertical", "Horizontal", "Injection",
        "Horizontal", "Horizontal", "Vertical", "Injection", "Horizontal"};
    static final String[] DEPTHS = {
        "9,850", "11,200", "7,400", "10,600", "8,100",
        "10,050", "11,480", "6,900", "7,750", "10,900"};
    static final String[] STATUS = {
        "Producing", "Producing", "Shut-in", "Producing", "Active",
        "Producing", "Drilling", "Shut-in", "Active", "Producing"};
    static final String WELLS =
        "31.98,-102.05;31.90,-102.20;32.02,-101.95;31.88,-102.02;31.95,-102.30;"
        + "31.92,-102.10;32.00,-102.25;31.87,-102.15;31.97,-101.98;31.91,-102.33";
    static final String FIELD =
        "31.85,-102.35 32.05,-102.35 32.05,-101.90 31.85,-101.90";
    // A gathering pipeline connecting several wells to a central tie-in.
    static final String PIPELINES =
        "31.98,-102.05 31.92,-102.10 31.95,-102.30 31.91,-102.33;"
        + "31.92,-102.10 32.00,-102.25 32.02,-101.95";

    // Full field extent (centre + zoom) for the "Full Extent" tool.
    static final String FULL_EXTENT = "31.945,-102.14,10.2";

    String _basemap = BASEMAPS[0][1];   // World_Imagery (DSG default)
    String _camera = FULL_EXTENT;         // Java-owned camera
    int _sel = -1;                        // selected well (identify)
    boolean _showWells = true;            // TOC layer toggles
    boolean _showField = true;
    boolean _showPipe = true;
    boolean _measure = false;             // measure tool
    String _mA = "", _mB = "", _dist = "";

    // Great-circle distance between two "lat,lng" points, as km + mi.
    static String haversine(String a, String b) {
      String[] pa = a.split(","), pb = b.split(",");
      double la1 = Math.toRadians(Double.parseDouble(pa[0])), lo1 = Math.toRadians(Double.parseDouble(pa[1]));
      double la2 = Math.toRadians(Double.parseDouble(pb[0])), lo2 = Math.toRadians(Double.parseDouble(pb[1]));
      double dla = la2 - la1, dlo = lo2 - lo1;
      double h = Math.sin(dla / 2) * Math.sin(dla / 2)
          + Math.cos(la1) * Math.cos(la2) * Math.sin(dlo / 2) * Math.sin(dlo / 2);
      double km = 2 * 6371 * Math.asin(Math.sqrt(h));
      return String.format("%.1f km  (%.1f mi)", km, km * 0.621371);
    }

    // Pipelines (if shown) + the live measure segment.
    String polylinesStr() {
      StringBuilder sb = new StringBuilder();
      if (_showPipe) sb.append(PIPELINES);
      if (!_mA.isEmpty() && !_mB.isEmpty()) {
        if (sb.length() > 0) sb.append(";");
        sb.append(_mA).append(" ").append(_mB);
      }
      return sb.toString();
    }

    void onMapTap(String latlng) {
      if (!_measure) return;
      setState(() -> {
        if (_mA.isEmpty() || !_mB.isEmpty()) { _mA = latlng; _mB = ""; _dist = ""; }
        else { _mB = latlng; _dist = haversine(_mA, _mB); }
      });
    }

    Widget chip(String label, boolean selected, Runnable onTap) {
      return GestureDetector()
          .onTap(onTap)
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

    // CRS + live coordinate footer, like DecisionSpace's status bar.
    Widget crsFooter() {
      String[] c = _camera.split(",");
      String lat = c.length > 0 ? c[0] : "?";
      String lng = c.length > 1 ? c[1] : "?";
      String zoom = c.length > 2 ? c[2] : "?";
      return Container().padding(EdgeInsets_all(6.0))
          .decoration(BoxDecoration().color(Colors.white()))
          .child(Row().children(List.<WidgetI>of(
              Text("WGS_1984_Web_Mercator_Auxiliary_Sphere")
                  .style(TextStyle().fontSize(11.0).color(Colors.grey())),
              SizedBox().width(18.0),
              Text("Lat " + lat + "   Lng " + lng).style(TextStyle().fontSize(11.0)),
              SizedBox().width(18.0),
              Text("Zoom " + zoom).style(TextStyle().fontSize(11.0)))));
    }

    Widget legendItem(WidgetI swatch, String label) {
      return Row().mainAxisSize(MainAxisSize.min).children(List.<WidgetI>of(
          swatch, SizedBox().width(6.0),
          Text(label).style(TextStyle().fontSize(11.0))));
    }

    Widget legend() {
      return Container().padding(EdgeInsets_all(8.0))
          .decoration(BoxDecoration()
              .color(Colors.white())
              .borderRadius(BorderRadius_circular(8.0))
              .border(Border_all().color(Colors.grey()).width(1.0)))
          .child(Wrap().spacing(18.0).runSpacing(6.0).children(List.<WidgetI>of(
              legendItem(Container().width(12.0).height(12.0).decoration(BoxDecoration()
                  .color(Colors.amber()).borderRadius(BorderRadius_circular(6.0))
                  .border(Border_all().color(Colors.white()).width(2.0))), "Well"),
              legendItem(Container().width(14.0).height(14.0).decoration(BoxDecoration()
                  .color(Colors.cyan())), "Lease block"),
              legendItem(Container().width(20.0).height(3.0).decoration(BoxDecoration()
                  .color(Colors.amber())), "Pipeline"))));
    }

    @Override
    public Widget build(BuildContext context) {
      java.util.List<WidgetI> basemaps = new java.util.ArrayList<>();
      for (String[] b : BASEMAPS) {
        final String url = b[1];
        basemaps.add(chip(b[0], url.equals(_basemap), () -> setState(() -> _basemap = url)));
      }

      return page(context, "GIS map — Esri basemaps + wells", Colors.teal(), List.of(

          Text("An Esri-tiled basemap with labelled wells and a lease block, rendered by "
              + "flutter_map inside EWT — the 8 basemaps DecisionSpace ships, a scale bar, "
              + "overview, a layer TOC and identify. Pan/zoom is owned by Java and persists "
              + "(desktop and web/Evolve)."),
          SizedBox().height(12.0),

          Text("Basemap").style(TextStyle().fontWeight(FontWeight.w700()).fontSize(12.0)),
          SizedBox().height(6.0),
          Wrap().spacing(8.0).runSpacing(8.0).children(basemaps),
          SizedBox().height(12.0),

          Text("Layers").style(TextStyle().fontWeight(FontWeight.w700()).fontSize(12.0)),
          SizedBox().height(6.0),
          Wrap().spacing(8.0).children(List.<WidgetI>of(
              chip("Wells", _showWells, () -> setState(() -> _showWells = !_showWells)),
              chip("Lease block", _showField, () -> setState(() -> _showField = !_showField)),
              chip("Pipelines", _showPipe, () -> setState(() -> _showPipe = !_showPipe)),
              chip("⤢ Full Extent", false, () -> setState(() -> _camera = FULL_EXTENT)),
              chip("📏 Measure", _measure, () -> setState(() -> {
                _measure = !_measure;
                if (!_measure) { _mA = ""; _mB = ""; _dist = ""; }
              })))),
          SizedBox().height(6.0),
          Text(_measure
                  ? (_dist.isEmpty() ? "Measure: tap two points on the map." : "Distance: " + _dist)
                  : "")
              .style(TextStyle().fontSize(12.0).color(Colors.teal())),
          SizedBox().height(8.0),
          legend(),
          SizedBox().height(12.0),

          Center().child(Container().width(760.0).height(460.0)
              .decoration(BoxDecoration()
                  .borderRadius(BorderRadius_circular(12.0))
                  .border(Border_all().color(Colors.grey()).width(1.0)))
              .child(ClipRRect().borderRadius(BorderRadius_circular(12.0)).child(
                  EwtMapView(List.<WidgetI>of(
                          wellPin(NAMES[0]), wellPin(NAMES[1]), wellPin(NAMES[2]),
                          wellPin(NAMES[3]), wellPin(NAMES[4])))
                      .tileUrl(_basemap)
                      .camera(_camera)
                      .markerCoords(_showWells ? WELLS : "")
                      .polygons(_showField ? FIELD : "")
                      .polylines(polylinesStr())
                      .selected(_sel)
                      .minZoom(3.0).maxZoom(17.0)
                      .onCameraMoved(c -> setState(() -> _camera = c))
                      .onMarkerTap(i -> setState(() -> _sel = Integer.parseInt(i)))
                      .onMapTap(this::onMapTap)))),
          crsFooter(),
          SizedBox().height(12.0),
          identifyCard()
      ));
    }
  }
}
