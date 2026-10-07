// Not a pass/fail test: a measurement of what an Evolve rebuild around an EWT region costs on
// the comm path, before and after the region started retaining its decoded subtree.
//
// Before: the region decoded its whole retained node map in every build() (what
// ewt_web_region.dart did until EwtRetainedSubtree). After: it decodes once per node tree and
// hands the identical Widget back. A Sash drag rebuilds the region's ancestors on every pan
// update, so the "parent rebuilds" below stand for drag steps.
//
// The tree is synthetic but shaped like a real customer page: a component inspector with search,
// role chips and stat cards, plus 75 component rows of ~10 nodes each.
//
// Run: cd widgets_web && flutter test test/bench/region_rebuild_bench_test.dart
import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:widgets_web/widgets_web.dart';

int _id = 1;
Map<String, dynamic> _n(String t, Map<String, dynamic> p) => {'t': t, 'id': _id++, 'p': p, 'c': []};
Map<String, dynamic> _text(String s) => _n('textText', {'data': s});
Map<String, dynamic> _icon(int cp) => _n('iconIcon', {
      'icon': _n('iconDataIconData', {'codePoint': cp, 'fontFamily': 'MaterialIcons'}),
      'size': 18.0,
    });
Map<String, dynamic> _pad(double v, Map<String, dynamic> child) =>
    _n('paddingPadding', {'padding': _n('edgeInsetsAll', {'value': v}), 'child': child});

Map<String, dynamic> _row(int i) {
  const roles = ['agent', 'driver', 'monitor', 'sequencer', 'scoreboard', 'env'];
  final role = roles[i % roles.length];
  return _n('containerContainer', {
    'child': _pad(4, _n('rowRow', {
      'children': [
        _icon(0xe3a7),
        _pad(8, _text('uvm_${role}_$i')),
        _n('chipChip', {'label': _text(role)}),
        _n('expandedExpanded', {'child': _text('${2 + i % 7} ports')}),
      ]
    })),
  });
}

Map<String, dynamic> _card(String label, int value) => _n('cardCard', {
      'child': _pad(12, _n('columnColumn', {'children': [_text('$value'), _text(label)]})),
    });

Map<String, dynamic> _page(int components) {
  _id = 1;
  return _n('columnColumn', {
    'children': [
      _text('Components'),
      _n('rowRow', {
        'children': [
          for (final r in ['agent', 'driver', 'monitor', 'sequencer', 'scoreboard', 'env'])
            _n('chipChip', {'label': _text(r)}),
        ]
      }),
      _n('rowRow', {
        'children': [
          _card('components', components),
          _card('shown', components),
          _card('connections', 184),
          _card('ports', 362),
        ]
      }),
      _n('expandedExpanded', {
        'child': _n('listViewListView', {'children': [for (var i = 0; i < components; i++) _row(i)]})
      }),
    ]
  });
}

/// The parent that Evolve rebuilds around the region. Like NoLayout._buildChild, it makes a
/// new widget instance for the region on every build, so Flutter cannot skip the region by
/// identity at this level; only what the region itself returns can be identical.
class _Parent extends StatefulWidget {
  final Widget Function() child;
  const _Parent({required this.child});
  @override
  State<_Parent> createState() => _ParentState();
}

class _ParentState extends State<_Parent> {
  int n = 0;
  void rebuild() => setState(() => n++);
  @override
  Widget build(BuildContext context) =>
      Padding(padding: EdgeInsets.only(left: (n % 2).toDouble()), child: widget.child());
}

/// The region as it was: decodes in every build.
class _DecodingRegion extends StatelessWidget {
  final Map<String, dynamic> root;
  final void Function() onDecode;
  const _DecodingRegion(this.root, this.onDecode);
  @override
  Widget build(BuildContext context) {
    onDecode();
    return ClipRect(child: decodeEwtWidget(root));
  }
}

void main() {
  const components = 75;
  const steps = 60; // pan updates in a one-second drag

  Future<void> run(WidgetTester tester, String label, Widget Function(void Function()) region) async {
    var decodes = 0;
    await tester.pumpWidget(MaterialApp(
      home: Scaffold(body: SizedBox(width: 1800, height: 1000, child: _Parent(child: () => region(() => decodes++)))),
    ));
    final parent = tester.state<_ParentState>(find.byType(_Parent));
    // The synthetic page overflows a Row by a few pixels; that is a cosmetic layout report,
    // not what is measured, so it is consumed instead of failing the run.
    tester.takeException();
    // Warm up (JIT, first layout) before the measured steps.
    for (var i = 0; i < 10; i++) {
      parent.rebuild();
      await tester.pump();
      tester.takeException();
    }
    final firstDecodes = decodes;
    final sw = Stopwatch()..start();
    for (var i = 0; i < steps; i++) {
      parent.rebuild();
      await tester.pump();
      tester.takeException();
    }
    sw.stop();
    // ignore: avoid_print
    print('$label: $steps parent rebuilds -> ${decodes - firstDecodes} subtree decodes, '
        '${sw.elapsedMilliseconds} ms total, ${(sw.elapsedMicroseconds / steps / 1000).toStringAsFixed(2)} ms per rebuild');
  }

  testWidgets('region rebuild cost: decode-every-build vs retained', (tester) async {
    final page = _page(components);
    // ignore: avoid_print
    print('page: $components components, ${_id - 1} nodes');
    Widget before(void Function() count) => _DecodingRegion(page, count);
    Widget after(void Function() count) => EwtRetainedSubtree(
          generation: 0,
          builder: (_) {
            count();
            return ClipRect(child: decodeEwtWidget(page));
          },
        );
    // A/B/A/B so an ordering or warm-up effect would show as a drift between the repeats.
    await run(tester, 'before (decode in every build)', before);
    await run(tester, 'after  (EwtRetainedSubtree)    ', after);
    await run(tester, 'before (decode in every build)', before);
    await run(tester, 'after  (EwtRetainedSubtree)    ', after);
  });
}
