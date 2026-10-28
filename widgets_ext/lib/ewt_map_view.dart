import 'package:flutter/material.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:latlong2/latlong.dart';

/// A map viewer wrapping `package:flutter_map`, following the EWT "approach (a)"
/// pattern (see [EwtGraphView]): every interaction round-trips to the Java model,
/// so it works over the comm path the SWT-Evolve integration uses as well as the
/// native FFM path.
///
///  - The CAMERA is OWNED BY JAVA via [camera] (`"lat,lng,zoom"`). A pan/zoom
///    reports the new camera back through the single-arg String callback
///    [onCameraMoved] (`"lat,lng,zoom"`); Java persists it and re-sends [camera],
///    and [didUpdateWidget] resyncs the controller.
///  - Markers are a `List<Widget>` anchored by the index-aligned [markerCoords]
///    (`"lat,lng;lat,lng;..."`); tapping marker i fires [onMarkerTap] (`"i"`).
///  - [polygons] / [polylines] are encoded Strings; [tileUrl] is the XYZ/WMTS
///    tile template (defaults to Esri World Imagery — the DecisionSpace basemap).
///
/// Every param is comm-marshalable: a `List<Widget>`, Strings, primitives, and
/// SINGLE-arg String callbacks — multi-arg callbacks do NOT round-trip over comm,
/// so the (lat, lng, zoom) triple is packed into one String.
class EwtMapView extends StatefulWidget {
  final List<Widget> markers;

  /// Marker anchor points, index-aligned with [markers]: `"lat,lng;lat,lng;..."`.
  final String markerCoords;

  /// XYZ/WMTS tile template. Default: Esri World Imagery (same basemap as the
  /// DecisionSpace GIS map).
  final String tileUrl;

  /// Java-owned camera as `"lat,lng,zoom"`.
  final String camera;

  /// Fires `"lat,lng,zoom"` once the camera settles after a gesture.
  final void Function(String)? onCameraMoved;

  /// Fires the marker index `"i"` when marker i is tapped.
  final void Function(String)? onMarkerTap;

  /// Filled polygons; each `';'`-separated group is a ring of `"lat,lng"` points
  /// joined by spaces: `"lat,lng lat,lng ...;lat,lng ..."`.
  final String polygons;

  /// Polylines, same encoding as [polygons] (each `';'` group is one line).
  final String polylines;

  final double minZoom;
  final double maxZoom;

  const EwtMapView(
    this.markers, {
    super.key,
    this.markerCoords = '',
    this.tileUrl =
        'https://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}',
    this.camera = '0,0,2',
    this.onCameraMoved,
    this.onMarkerTap,
    this.polygons = '',
    this.polylines = '',
    this.minZoom = 2.0,
    this.maxZoom = 19.0,
  });

  @override
  State<EwtMapView> createState() => _EwtMapViewState();
}

class _EwtMapViewState extends State<EwtMapView> {
  final MapController _controller = MapController();
  late LatLng _center;
  late double _zoom;

  @override
  void initState() {
    super.initState();
    _applyCamera(widget.camera);
  }

  @override
  void didUpdateWidget(covariant EwtMapView old) {
    super.didUpdateWidget(old);
    // Java re-sent the camera (e.g. after an onCameraMoved round-trip) — resync.
    if (old.camera != widget.camera) {
      _applyCamera(widget.camera);
      _controller.move(_center, _zoom);
    }
  }

  void _applyCamera(String s) {
    final p = s.split(',');
    final lat = p.isNotEmpty ? double.tryParse(p[0].trim()) : null;
    final lng = p.length > 1 ? double.tryParse(p[1].trim()) : null;
    final z = p.length > 2 ? double.tryParse(p[2].trim()) : null;
    _center = LatLng(lat ?? 0, lng ?? 0);
    _zoom = z ?? 2.0;
  }

  /// Parses `"lat,lng lat,lng ..."` (space-separated) into a point list.
  List<LatLng> _coords(String s) {
    final out = <LatLng>[];
    for (final pair in s.trim().split(RegExp(r'\s+'))) {
      final xy = pair.split(',');
      if (xy.length == 2) {
        final a = double.tryParse(xy[0]);
        final b = double.tryParse(xy[1]);
        if (a != null && b != null) out.add(LatLng(a, b));
      }
    }
    return out;
  }

  /// Parses `"lat,lng;lat,lng;..."` into marker anchor points.
  List<LatLng> _markerPoints() {
    final out = <LatLng>[];
    for (final m in widget.markerCoords.split(';')) {
      final xy = m.split(',');
      if (xy.length == 2) {
        final a = double.tryParse(xy[0].trim());
        final b = double.tryParse(xy[1].trim());
        if (a != null && b != null) out.add(LatLng(a, b));
      }
    }
    return out;
  }

  @override
  Widget build(BuildContext context) {
    final pts = _markerPoints();
    final polys = widget.polygons
        .split(';')
        .where((s) => s.trim().isNotEmpty)
        .map(_coords)
        .toList();
    final lines = widget.polylines
        .split(';')
        .where((s) => s.trim().isNotEmpty)
        .map(_coords)
        .toList();

    return ClipRect(
      child: FlutterMap(
        mapController: _controller,
        options: MapOptions(
          initialCenter: _center,
          initialZoom: _zoom,
          minZoom: widget.minZoom,
          maxZoom: widget.maxZoom,
          onPositionChanged: (camera, hasGesture) {
            if (!hasGesture) return;
            final c = camera.center;
            widget.onCameraMoved?.call(
                '${c.latitude.toStringAsFixed(6)},${c.longitude.toStringAsFixed(6)},${camera.zoom.toStringAsFixed(2)}');
          },
        ),
        children: [
          TileLayer(
            urlTemplate: widget.tileUrl,
            // Plain network provider (no disk cache) so flutter_map's path_provider
            // dependency is never called — the embedded EWT engine does not register
            // platform plugins, so a disk-caching provider would throw.
            tileProvider: NetworkTileProvider(),
            userAgentPackageName: 'dev.equo.ewt',
          ),
          if (polys.isNotEmpty)
            PolygonLayer(
              polygons: [
                for (final ring in polys)
                  Polygon(
                    points: ring,
                    color: const Color(0x3300BCD4),
                    borderColor: const Color(0xFF00838F),
                    borderStrokeWidth: 2,
                  ),
              ],
            ),
          if (lines.isNotEmpty)
            PolylineLayer(
              polylines: [
                for (final l in lines)
                  Polyline(
                    points: l,
                    color: const Color(0xFFFFC107),
                    strokeWidth: 3,
                  ),
              ],
            ),
          if (widget.markers.isNotEmpty)
            MarkerLayer(
              markers: [
                for (var i = 0; i < widget.markers.length && i < pts.length; i++)
                  Marker(
                    point: pts[i],
                    width: 44,
                    height: 44,
                    alignment: Alignment.topCenter,
                    child: GestureDetector(
                      behavior: HitTestBehavior.opaque,
                      onTap: () => widget.onMarkerTap?.call('$i'),
                      child: widget.markers[i],
                    ),
                  ),
              ],
            ),
        ],
      ),
    );
  }
}
