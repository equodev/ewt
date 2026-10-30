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

  // Unique-value symbology by well status (like DecisionSpace's Symbology tab).
  static ColorI statusColor(String status) {
    switch (status) {
      case "Producing": return Colors.green();
      case "Shut-in":   return Colors.grey();
      case "Drilling":  return Colors.orange();
      default:          return Colors.lightBlue(); // Active / injection
    }
  }

  // A labelled well marker: a name pill above a status-coloured dot.
  static Widget wellPin(String name, ColorI color) {
    return Column().mainAxisSize(MainAxisSize.min).children(List.<WidgetI>of(
        Container().padding(EdgeInsets_all(3.0))
            .decoration(BoxDecoration()
                .color(Colors.black())
                .borderRadius(BorderRadius_circular(4.0)))
            .child(Text(name).style(TextStyle().color(Colors.white()).fontSize(10.0))),
        SizedBox().height(2.0),
        Container().width(14.0).height(14.0)
            .decoration(BoxDecoration()
                .color(color)
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
    // A large, deterministic well dataset over the Permian Basin — so the view can
    // be compared against DecisionSpace's real GIS map at scale.
    static final int N = 400;
    static final String[] NAMES = new String[N];
    static final String[] STATUS = new String[N];
    static final int[] DEPTH = new int[N];
    static final String WELLS;
    static {
      String[] st = {"Producing", "Producing", "Producing", "Shut-in", "Drilling", "Active"};
      StringBuilder sb = new StringBuilder();
      long s = 88172645463325252L;
      for (int i = 0; i < N; i++) {
        s ^= s << 13; s ^= s >>> 7; s ^= s << 17;
        double r1 = ((s >>> 12) & 0xFFFFF) / 1048576.0;
        s ^= s << 13; s ^= s >>> 7; s ^= s << 17;
        double r2 = ((s >>> 12) & 0xFFFFF) / 1048576.0;
        double lat = 31.55 + r1 * 0.85;
        double lng = -102.65 + r2 * 0.95;
        if (i > 0) sb.append(";");
        sb.append(String.format(java.util.Locale.US, "%.4f,%.4f", lat, lng));
        NAMES[i] = String.format("PB %04d", i + 1);
        STATUS[i] = st[(int) (((s >>> 20) % st.length + st.length) % st.length)];
        DEPTH[i] = 6000 + (int) (((s >>> 8) % 7000 + 7000) % 7000);
      }
      WELLS = sb.toString();
    }
    static final String FIELD =
        "31.85,-102.35 32.05,-102.35 32.05,-101.90 31.85,-101.90";
    // A gathering pipeline connecting several wells to a central tie-in.
    static final String PIPELINES =
        "31.98,-102.05 31.92,-102.10 31.95,-102.30 31.91,-102.33;"
        + "31.92,-102.10 32.00,-102.25 32.02,-101.95";

    // Full field extent (centre + zoom) for the "Full Extent" tool.
    static final String FULL_EXTENT = "31.97,-102.17,9.2";

    // A sample GeoJSON "imported" layer (a seismic survey outline, a flowline and
    // two observation points) — demonstrates handing a customer's GeoJSON to the map.
    static final String GEOJSON =
        "{\"type\":\"FeatureCollection\",\"features\":["
        + "{\"type\":\"Feature\",\"properties\":{\"name\":\"Seismic Survey 3D\"},\"geometry\":{\"type\":\"Polygon\",\"coordinates\":[[[-102.28,31.93],[-102.22,32.00],[-102.12,31.97],[-102.15,31.89],[-102.25,31.88],[-102.28,31.93]]]}},"
        + "{\"type\":\"Feature\",\"properties\":{\"name\":\"Flowline\"},\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[-102.30,31.86],[-102.20,31.90],[-102.10,31.96]]}},"
        + "{\"type\":\"Feature\",\"properties\":{\"name\":\"Obs 1\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-102.18,31.94]}},"
        + "{\"type\":\"Feature\",\"properties\":{\"name\":\"Obs 2\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-102.08,31.99]}}"
        + "]}";

    String _basemap = BASEMAPS[0][1];   // World_Imagery (DSG default)
    String _camera = FULL_EXTENT;         // Java-owned camera
    int _sel = -1;                        // selected well (identify)
    boolean _showWells = true;            // TOC layer toggles
    boolean _showField = true;
    boolean _showPipe = true;
    boolean _showGeo = true;              // imported GeoJSON layer
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
                  Text("Status: " + STATUS[_sel]),
                  Text("TD: " + String.format(java.util.Locale.US, "%,d", DEPTH[_sel]) + " ft"))));
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

    Widget dot(ColorI c) {
      return Container().width(12.0).height(12.0).decoration(BoxDecoration()
          .color(c).borderRadius(BorderRadius_circular(6.0))
          .border(Border_all().color(Colors.white()).width(2.0)));
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
          .child(Wrap().spacing(16.0).runSpacing(6.0).children(List.<WidgetI>of(
              legendItem(dot(Colors.green()), "Producing"),
              legendItem(dot(Colors.grey()), "Shut-in"),
              legendItem(dot(Colors.orange()), "Drilling"),
              legendItem(dot(Colors.lightBlue()), "Active / Inj."),
              legendItem(Container().width(14.0).height(14.0).decoration(BoxDecoration()
                  .color(Colors.cyan())), "Lease block"),
              legendItem(Container().width(20.0).height(3.0).decoration(BoxDecoration()
                  .color(Colors.amber())), "Pipeline"))));
    }

    void zoomBy(double d) {
      String[] c = _camera.split(",");
      double z = Math.max(3.0, Math.min(17.0, Double.parseDouble(c[2].trim()) + d));
      final String nc = c[0] + "," + c[1] + "," + String.format("%.1f", z);
      setState(() -> _camera = nc);
    }

    Widget toolBtn(String sym, boolean active, Runnable onTap) {
      return GestureDetector().onTap(onTap).child(Container().width(36.0).height(36.0)
          .decoration(BoxDecoration()
              .color(active ? Colors.teal() : Colors.white())
              .borderRadius(BorderRadius_circular(6.0))
              .border(Border_all().color(Colors.teal()).width(1.0)))
          .child(Center().child(Text(sym).style(TextStyle()
              .color(active ? Colors.white() : Colors.teal()).fontSize(16.0)))));
    }

    // A vertical tool strip, like DecisionSpace's GIS Map toolbar.
    Widget toolbar() {
      return Column().mainAxisSize(MainAxisSize.min).children(List.<WidgetI>of(
          toolBtn("+", false, () -> zoomBy(1.0)),
          SizedBox().height(4.0),
          toolBtn("−", false, () -> zoomBy(-1.0)),
          SizedBox().height(4.0),
          toolBtn("⤢", false, () -> setState(() -> _camera = FULL_EXTENT)),
          SizedBox().height(4.0),
          toolBtn("📏", _measure, () -> setState(() -> {
            _measure = !_measure;
            if (!_measure) { _mA = ""; _mB = ""; _dist = ""; }
          }))));
    }

    @Override
    public Widget build(BuildContext context) {
      java.util.List<WidgetI> basemaps = new java.util.ArrayList<>();
      for (String[] b : BASEMAPS) {
        final String url = b[1];
        basemaps.add(chip(b[0], url.equals(_basemap), () -> setState(() -> _basemap = url)));
      }
      java.util.List<WidgetI> pins = new java.util.ArrayList<>();
      for (int i = 0; i < NAMES.length; i++) pins.add(dot(statusColor(STATUS[i])));

      return page(context, "GIS map — Esri basemaps + wells", Colors.teal(), List.of(

          Text("An Esri-tiled basemap with 400 wells (coloured by status), a lease block, "
              + "pipelines and an imported GeoJSON layer, rendered by flutter_map inside EWT — "
              + "the 8 basemaps DecisionSpace ships, scale bar, overview, layer TOC, identify "
              + "and measure. Pan/zoom is owned by Java and persists (desktop and web/Evolve)."),
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
              chip("Imported (GeoJSON)", _showGeo, () -> setState(() -> _showGeo = !_showGeo)),
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

          Center().child(Row().mainAxisSize(MainAxisSize.min)
              .crossAxisAlignment(CrossAxisAlignment.start).children(List.<WidgetI>of(
              toolbar(),
              SizedBox().width(8.0),
              Container().width(720.0).height(460.0)
              .decoration(BoxDecoration()
                  .borderRadius(BorderRadius_circular(12.0))
                  .border(Border_all().color(Colors.grey()).width(1.0)))
              .child(ClipRRect().borderRadius(BorderRadius_circular(12.0)).child(
                  EwtMapView(pins)
                      .tileUrl(_basemap)
                      .camera(_camera)
                      .markerCoords(_showWells ? WELLS : "")
                      .polygons(_showField ? FIELD : "")
                      .polylines(polylinesStr())
                      .geojson(_showGeo ? GEOJSON : "")
                      .selected(_sel)
                      .minZoom(3.0).maxZoom(17.0)
                      .onCameraMoved(c -> setState(() -> _camera = c))
                      .onMarkerTap(i -> setState(() -> _sel = Integer.parseInt(i)))
                      .onMapTap(this::onMapTap)))))),
          crsFooter(),
          SizedBox().height(12.0),
          identifyCard()
      ));
    }
  }
}
