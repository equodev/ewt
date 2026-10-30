import 'dart:convert';

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
///
/// Tier-1 viewer chrome is internal (no extra params): a scale bar, an overview
/// mini-map, and an entrance animation on the markers.
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

  /// Fires the index `"i"` of the tapped GeoJSON Point feature (counted in file
  /// order over Point/MultiPoint features) — lets Java identify an imported
  /// feature and drive the same highlight via [selected].
  final void Function(String)? onFeatureTap;

  /// Filled polygons; each `';'`-separated group is a ring of `"lat,lng"` points
  /// joined by spaces: `"lat,lng lat,lng ...;lat,lng ..."`.
  final String polygons;

  /// Polylines, same encoding as [polygons] (each `';'` group is one line).
  final String polylines;

  /// Fires `"lat,lng"` when the map (not a marker) is tapped — enables measure /
  /// add-point tools driven from Java.
  final void Function(String)? onMapTap;

  /// Index of the marker to highlight (e.g. the identified well), or -1 for none.
  final int selected;

  /// A GeoJSON FeatureCollection/Feature string to render as an imported data
  /// layer — Point/LineString/Polygon (and Multi* variants). Lets Java hand a
  /// customer's GeoJSON straight to the map.
  final String geojson;

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
    this.onFeatureTap,
    this.polygons = '',
    this.polylines = '',
    this.onMapTap,
    this.selected = -1,
    this.geojson = '',
    this.minZoom = 2.0,
    this.maxZoom = 19.0,
  });

  @override
  State<EwtMapView> createState() => _EwtMapViewState();
}

class _EwtMapViewState extends State<EwtMapView>
    with SingleTickerProviderStateMixin {
  final MapController _controller = MapController();
  late LatLng _center;
  late double _zoom;

  // Overview mini-map: a fixed wider frame captured at first build; a live dot
  // tracks the main camera's centre over it.
  late final LatLng _ovCenter;
  late final double _ovZoom;

  // Entrance animation for the markers (plays once on open).
  late final AnimationController _entrance;
  late final Animation<double> _pop;

  @override
  void initState() {
    super.initState();
    _applyCamera(widget.camera);
    _ovCenter = _center;
    _ovZoom = (_zoom - 4).clamp(1.0, 18.0);
    _entrance = AnimationController(
        vsync: this, duration: const Duration(milliseconds: 900))
      ..forward();
    _pop = CurvedAnimation(parent: _entrance, curve: Curves.easeOutBack);
  }

  @override
  void dispose() {
    _entrance.dispose();
    super.dispose();
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

  // --- GeoJSON ingest (an imported customer-data layer) ----------------------

  LatLng? _ll(dynamic c) {
    if (c is List && c.length >= 2) {
      final lng = (c[0] as num?)?.toDouble();
      final lat = (c[1] as num?)?.toDouble();
      if (lat != null && lng != null) return LatLng(lat, lng);
    }
    return null;
  }

  List<LatLng> _lls(dynamic c) {
    final out = <LatLng>[];
    if (c is List) {
      for (final p in c) {
        final ll = _ll(p);
        if (ll != null) out.add(ll);
      }
    }
    return out;
  }

  /// Parses [EwtMapView.geojson] into flutter_map layers. GeoJSON is [lng,lat].
  List<Widget> _geojsonLayers() {
    if (widget.geojson.trim().isEmpty) return const [];
    dynamic gj;
    try {
      gj = jsonDecode(widget.geojson);
    } catch (_) {
      return const [];
    }
    final feats = <Map<String, dynamic>>[];
    if (gj is Map && gj['type'] == 'FeatureCollection') {
      for (final f in (gj['features'] as List? ?? const [])) {
        if (f is Map) feats.add(f.cast<String, dynamic>());
      }
    } else if (gj is Map && gj['type'] == 'Feature') {
      feats.add(gj.cast<String, dynamic>());
    }

    final points = <Marker>[];
    final lines = <Polyline>[];
    final polys = <Polygon>[];
    var pIdx = 0; // index over Point features, aligned with Java's feature list
    for (final f in feats) {
      final geom = f['geometry'];
      if (geom is! Map) continue;
      final coords = geom['coordinates'];
      switch (geom['type']) {
        case 'Point':
          final ll = _ll(coords);
          if (ll != null) points.add(_gjPoint(ll, f['properties'], pIdx++));
          break;
        case 'MultiPoint':
          if (coords is List) {
            for (final c in coords) {
              final ll = _ll(c);
              if (ll != null) points.add(_gjPoint(ll, f['properties'], pIdx++));
            }
          }
          break;
        case 'LineString':
          lines.add(_gjLine(_lls(coords)));
          break;
        case 'MultiLineString':
          if (coords is List) for (final l in coords) lines.add(_gjLine(_lls(l)));
          break;
        case 'Polygon':
          if (coords is List && coords.isNotEmpty) polys.add(_gjPoly(_lls(coords[0])));
          break;
        case 'MultiPolygon':
          if (coords is List) {
            for (final pg in coords) {
              if (pg is List && pg.isNotEmpty) polys.add(_gjPoly(_lls(pg[0])));
            }
          }
          break;
      }
    }
    return [
      if (polys.isNotEmpty) PolygonLayer(polygons: polys),
      if (lines.isNotEmpty) PolylineLayer(polylines: lines),
      if (points.isNotEmpty) MarkerLayer(markers: points),
    ];
  }

  // Colour a GeoJSON point by a 'status' property (well status), falling back to
  // a neutral colour — matches the native well symbology + DecisionSpace.
  Color _statusColor(dynamic props) {
    final s = (props is Map) ? props['status'] : null;
    switch (s) {
      case 'Producing': return const Color(0xFF22C55E);
      case 'Shut-in':   return const Color(0xFF9CA3AF);
      case 'Drilling':  return const Color(0xFFF97316);
      case 'Active':    return const Color(0xFF38BDF8);
      default:          return const Color(0xFF7E57C2);
    }
  }

  Widget _dotCore(dynamic props) => DecoratedBox(
        decoration: BoxDecoration(
          color: _statusColor(props),
          shape: BoxShape.circle,
          border: const Border.fromBorderSide(BorderSide(color: Colors.white, width: 2)),
        ),
        child: const SizedBox(width: 14, height: 14),
      );

  Marker _gjPoint(LatLng p, dynamic props, int idx) => Marker(
        point: p,
        width: 34,
        height: 34,
        child: ScaleTransition(
          scale: _pop,
          child: FadeTransition(
            opacity: _entrance,
            child: GestureDetector(
              behavior: HitTestBehavior.opaque,
              onTap: () => widget.onFeatureTap?.call('$idx'),
              child: idx == widget.selected
                  ? Stack(
                      alignment: Alignment.center,
                      clipBehavior: Clip.none,
                      children: [
                        Container(
                          width: 30,
                          height: 30,
                          decoration: const BoxDecoration(
                            color: Color(0x5500E5FF),
                            shape: BoxShape.circle,
                          ),
                        ),
                        _dotCore(props),
                      ],
                    )
                  : _dotCore(props),
            ),
          ),
        ),
      );

  // Match DecisionSpace: pipelines white, lease outline-only in yellow.
  Polyline _gjLine(List<LatLng> pts) =>
      Polyline(points: pts, color: const Color(0xFFFFFFFF), strokeWidth: 3);

  Polygon _gjPoly(List<LatLng> pts) => Polygon(
        points: pts,
        color: const Color(0x00000000),
        borderColor: const Color(0xFFFFC107),
        borderStrokeWidth: 2,
      );

  TileLayer _tiles() => TileLayer(
        urlTemplate: widget.tileUrl,
        // Plain network provider (no disk cache) so flutter_map's path_provider
        // dependency is never called — the embedded EWT engine does not register
        // platform plugins, so a disk-caching provider would throw.
        tileProvider: NetworkTileProvider(),
        userAgentPackageName: 'dev.equo.ewt',
      );

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
      child: Stack(
        children: [
          FlutterMap(
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
              onTap: (tapPos, latlng) => widget.onMapTap?.call(
                  '${latlng.latitude.toStringAsFixed(6)},${latlng.longitude.toStringAsFixed(6)}'),
            ),
            children: [
              _tiles(),
              ..._geojsonLayers(),
              if (polys.isNotEmpty)
                PolygonLayer(
                  polygons: [
                    for (final ring in polys)
                      Polygon(
                        points: ring,
                        // Outline only (no fill) so it never hides the wells, like
                        // DecisionSpace's lease layer.
                        color: const Color(0x00000000),
                        borderColor: const Color(0xFFFFC107),
                        borderStrokeWidth: 2.5,
                      ),
                  ],
                ),
              if (lines.isNotEmpty)
                PolylineLayer(
                  polylines: [
                    for (final l in lines)
                      Polyline(
                        points: l,
                        color: const Color(0xFFFFFFFF),
                        strokeWidth: 3,
                      ),
                  ],
                ),
              if (widget.markers.isNotEmpty)
                MarkerLayer(
                  markers: [
                    for (var i = 0;
                        i < widget.markers.length && i < pts.length;
                        i++)
                      Marker(
                        point: pts[i],
                        width: 120,
                        height: 50,
                        alignment: Alignment.bottomCenter,
                        child: ScaleTransition(
                          scale: _pop,
                          child: FadeTransition(
                            opacity: _entrance,
                            child: GestureDetector(
                              behavior: HitTestBehavior.opaque,
                              onTap: () => widget.onMarkerTap?.call('$i'),
                              child: i == widget.selected
                                  // Highlight the identified well with a cyan halo.
                                  ? Stack(
                                      alignment: Alignment.bottomCenter,
                                      clipBehavior: Clip.none,
                                      children: [
                                        Container(
                                          width: 34,
                                          height: 34,
                                          decoration: const BoxDecoration(
                                            color: Color(0x5500E5FF),
                                            shape: BoxShape.circle,
                                          ),
                                        ),
                                        widget.markers[i],
                                      ],
                                    )
                                  : widget.markers[i],
                            ),
                          ),
                        ),
                      ),
                  ],
                ),
              const Scalebar(
                alignment: Alignment.bottomLeft,
                padding: EdgeInsets.all(8),
              ),
            ],
          ),
          // Overview mini-map (bottom-right): a fixed wider frame with a live dot
          // marking the main camera's centre.
          Positioned(
            right: 8,
            bottom: 8,
            width: 150,
            height: 110,
            child: IgnorePointer(
              child: Container(
                decoration: BoxDecoration(
                  border: Border.all(color: Colors.white, width: 2),
                  boxShadow: const [
                    BoxShadow(color: Color(0x55000000), blurRadius: 4)
                  ],
                ),
                child: FlutterMap(
                  options: MapOptions(
                    initialCenter: _ovCenter,
                    initialZoom: _ovZoom,
                    interactionOptions:
                        const InteractionOptions(flags: InteractiveFlag.none),
                  ),
                  children: [
                    _tiles(),
                    MarkerLayer(markers: [
                      Marker(
                        point: _center,
                        width: 14,
                        height: 14,
                        child: const DecoratedBox(
                          decoration: BoxDecoration(
                            color: Color(0xFFFF5252),
                            shape: BoxShape.circle,
                            border: Border.fromBorderSide(
                                BorderSide(color: Colors.white, width: 2)),
                          ),
                        ),
                      ),
                    ]),
                  ],
                ),
              ),
            ),
          ),
        ],
      ),
    );
  }
}
