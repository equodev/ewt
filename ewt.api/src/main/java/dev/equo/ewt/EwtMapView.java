package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class EwtMapView extends StatefulWidget implements EwtMapViewI {
  protected EwtMapView() {}
  EwtMapView(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget EwtMapView");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static EwtMapView ewtMapViewEwtMapView(@Builder.Parameter List<WidgetI> markers, Optional<String> markerCoords, Optional<String> tileUrl, Optional<String> camera, Optional<Consumer<String>> onCameraMoved, Optional<Consumer<String>> onMarkerTap, Optional<Consumer<String>> onFeatureTap, Optional<String> polygons, Optional<String> polylines, Optional<Consumer<String>> onMapTap, OptionalInt selected, Optional<String> geojson, OptionalDouble minZoom, OptionalDouble maxZoom) {
    int id = factories.ewtMapViewEwtMapView(markers.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()),
      markerCoords,
      tileUrl,
      camera,
      onCameraMoved,
      onMarkerTap,
      onFeatureTap,
      polygons,
      polylines,
      onMapTap,
      selected,
      geojson,
      minZoom,
      maxZoom);
    if (id <= 0) throw new RuntimeException("Failed to created widget EwtMapView");
    return new EwtMapView(id);
  }
  public static EwtMapViewEwtMapViewBuilder ewtMapView(List<WidgetI> markers) {
    return EwtMapViewEwtMapViewBuilder.ewtMapViewEwtMapView(markers);
  }
  public String markerCoords() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("ewtMapViewMarkerCoords not supported on web");
    return factories.EwtMapView_readBack_markerCoords(nativeStruct);
  }
  public String tileUrl() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("ewtMapViewTileUrl not supported on web");
    return factories.EwtMapView_readBack_tileUrl(nativeStruct);
  }
  public String camera() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("ewtMapViewCamera not supported on web");
    return factories.EwtMapView_readBack_camera(nativeStruct);
  }
  public String polygons() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("ewtMapViewPolygons not supported on web");
    return factories.EwtMapView_readBack_polygons(nativeStruct);
  }
  public String polylines() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("ewtMapViewPolylines not supported on web");
    return factories.EwtMapView_readBack_polylines(nativeStruct);
  }
  public int selected() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("ewtMapViewSelected not supported on web");
    return factories.EwtMapView_readBack_selected(nativeStruct);
  }
  public String geojson() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("ewtMapViewGeojson not supported on web");
    return factories.EwtMapView_readBack_geojson(nativeStruct);
  }
  public double minZoom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("ewtMapViewMinZoom not supported on web");
    return factories.EwtMapView_readBack_minZoom(nativeStruct);
  }
  public double maxZoom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("ewtMapViewMaxZoom not supported on web");
    return factories.EwtMapView_readBack_maxZoom(nativeStruct);
  }
  @Override
  public EwtMapView build() {
    return this;
  }
}
