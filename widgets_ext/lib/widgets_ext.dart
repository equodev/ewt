import 'package:flutter/material.dart';

/// A draggable node-graph wrapper demonstrating the EWT "approach (a)" pattern
/// for interactions that must round-trip to the Java model (and therefore work
/// over the comm path the SWT-Evolve integration uses):
///
///  - Node positions are OWNED BY JAVA and flow in via [positions].
///  - Dragging a node reports its new position back to Java via [onNodeMoved]
///    as `"id,x,y"`, so Java stays the source of truth and the move persists
///    across rebuilds (Java updates its model and re-sends [positions]).
///
/// Every param is comm-marshalable: a `List<Widget>`, Strings, primitives, and
/// a SINGLE-arg `String` callback — multi-arg callbacks do NOT round-trip over
/// comm, so the (id, x, y) triple is encoded into one String.
class EwtGraphView extends StatefulWidget {
  final List<Widget> nodes;

  /// Directed edges as `"from-to"` index pairs, e.g. `"0-1,0-2"`.
  final String edges;

  /// Initial node positions as `"x,y;x,y;..."` (index = node id), from Java.
  final String positions;

  /// Fires `"id,x,y"` when a node is released after dragging.
  final void Function(String)? onNodeMoved;

  final double nodeWidth;
  final double nodeHeight;

  const EwtGraphView(
    this.nodes, {
    super.key,
    this.edges = '',
    this.positions = '',
    this.onNodeMoved,
    this.nodeWidth = 64.0,
    this.nodeHeight = 38.0,
  });

  @override
  State<EwtGraphView> createState() => _EwtGraphViewState();
}

class _EwtGraphViewState extends State<EwtGraphView> {
  late Map<int, Offset> _pos;

  @override
  void initState() {
    super.initState();
    _pos = _parsePositions(widget.positions, widget.nodes.length);
  }

  @override
  void didUpdateWidget(covariant EwtGraphView old) {
    super.didUpdateWidget(old);
    // Java re-sent the positions (e.g. after an onNodeMoved round-trip) — resync.
    if (old.positions != widget.positions ||
        old.nodes.length != widget.nodes.length) {
      _pos = _parsePositions(widget.positions, widget.nodes.length);
    }
  }

  Map<int, Offset> _parsePositions(String s, int count) {
    final map = <int, Offset>{};
    final parts = s.split(';');
    for (var i = 0; i < parts.length; i++) {
      final xy = parts[i].split(',');
      if (xy.length == 2) {
        final x = double.tryParse(xy[0].trim());
        final y = double.tryParse(xy[1].trim());
        if (x != null && y != null) map[i] = Offset(x, y);
      }
    }
    // Any node without a supplied position falls back to a simple grid.
    for (var i = 0; i < count; i++) {
      map.putIfAbsent(
          i, () => Offset(20.0 + (i % 3) * 110.0, 20.0 + (i ~/ 3) * 90.0));
    }
    return map;
  }

  List<List<int>> _parseEdges(String s) {
    final out = <List<int>>[];
    for (final e in s.split(',')) {
      if (e.trim().isEmpty) continue;
      final ft = e.split('-');
      if (ft.length == 2) {
        final a = int.tryParse(ft[0].trim());
        final b = int.tryParse(ft[1].trim());
        if (a != null && b != null) out.add([a, b]);
      }
    }
    return out;
  }

  @override
  Widget build(BuildContext context) {
    final nodeSize = Size(widget.nodeWidth, widget.nodeHeight);
    return ClipRect(
      child: Stack(
        children: [
          Positioned.fill(
            child: CustomPaint(
              painter: _EdgePainter(_parseEdges(widget.edges), _pos, nodeSize),
            ),
          ),
          for (var i = 0; i < widget.nodes.length; i++)
            Positioned(
              left: _pos[i]!.dx,
              top: _pos[i]!.dy,
              child: GestureDetector(
                behavior: HitTestBehavior.opaque,
                onPanUpdate: (d) =>
                    setState(() => _pos[i] = _pos[i]! + d.delta),
                onPanEnd: (_) {
                  final p = _pos[i]!;
                  widget.onNodeMoved?.call(
                      '$i,${p.dx.toStringAsFixed(1)},${p.dy.toStringAsFixed(1)}');
                },
                child: SizedBox(
                  width: widget.nodeWidth,
                  height: widget.nodeHeight,
                  child: widget.nodes[i],
                ),
              ),
            ),
        ],
      ),
    );
  }
}

class _EdgePainter extends CustomPainter {
  final List<List<int>> edges;
  final Map<int, Offset> pos;
  final Size nodeSize;

  _EdgePainter(this.edges, this.pos, this.nodeSize);

  @override
  void paint(Canvas canvas, Size size) {
    final paint = Paint()
      ..color = const Color(0xFF607D8B)
      ..strokeWidth = 2.0
      ..strokeCap = StrokeCap.round
      ..style = PaintingStyle.stroke;
    final half = Offset(nodeSize.width / 2, nodeSize.height / 2);
    for (final e in edges) {
      final pa = pos[e[0]];
      final pb = pos[e[1]];
      if (pa == null || pb == null) continue;
      final ca = pa + half;
      final cb = pb + half;
      // Connect at each node's box border (not its center), then draw a smooth
      // cubic connector whose tangents follow the dominant axis.
      final start = _borderPoint(ca, cb, half);
      final end = _borderPoint(cb, ca, half);
      final path = Path()..moveTo(start.dx, start.dy);
      if ((end.dx - start.dx).abs() >= (end.dy - start.dy).abs()) {
        final mx = (start.dx + end.dx) / 2;
        path.cubicTo(mx, start.dy, mx, end.dy, end.dx, end.dy);
      } else {
        final my = (start.dy + end.dy) / 2;
        path.cubicTo(start.dx, my, end.dx, my, end.dx, end.dy);
      }
      canvas.drawPath(path, paint);
    }
  }

  /// Point where the ray from [center] toward [other] exits [center]'s box.
  Offset _borderPoint(Offset center, Offset other, Offset half) {
    final dir = other - center;
    final adx = dir.dx.abs();
    final ady = dir.dy.abs();
    if (adx == 0 && ady == 0) return center;
    final tx = adx > 0 ? half.dx / adx : double.infinity;
    final ty = ady > 0 ? half.dy / ady : double.infinity;
    final t = tx < ty ? tx : ty;
    return center + dir * t;
  }

  @override
  bool shouldRepaint(covariant _EdgePainter old) =>
      old.pos != pos || old.edges != edges;
}
