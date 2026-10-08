import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:widgets_web/widgets_web.dart';

/// A parent that rebuilds on demand, the way Evolve's tree does around an EWT region.
class _Parent extends StatefulWidget {
  final Widget child;
  const _Parent({required this.child});

  @override
  State<_Parent> createState() => _ParentState();
}

class _ParentState extends State<_Parent> {
  int rebuilds = 0;

  void rebuild() => setState(() => rebuilds++);

  @override
  Widget build(BuildContext context) => Padding(
        // A parent rebuild hands the region a fresh (non-identical) widget below it, as
        // NoLayout does when it re-wraps every child.
        padding: EdgeInsets.all(rebuilds.toDouble()),
        child: widget.child,
      );
}

void main() {
  testWidgets('a parent rebuild does not rebuild the retained subtree', (tester) async {
    var builds = 0;
    await tester.pumpWidget(_Parent(
      child: EwtRetainedSubtree(
        generation: 0,
        builder: (_) {
          builds++;
          return const SizedBox();
        },
      ),
    ));
    expect(builds, 1);

    final parent = tester.state<_ParentState>(find.byType(_Parent));
    for (var i = 0; i < 5; i++) {
      parent.rebuild();
      await tester.pump();
    }
    expect(parent.rebuilds, 5);
    expect(builds, 1);
  });

  testWidgets('a new generation rebuilds the subtree once', (tester) async {
    var builds = 0;
    Widget region(int generation) => EwtRetainedSubtree(
          generation: generation,
          builder: (_) {
            builds++;
            return Text('gen $generation', textDirection: TextDirection.ltr);
          },
        );

    await tester.pumpWidget(region(0));
    expect(builds, 1);
    await tester.pumpWidget(region(0));
    expect(builds, 1);
    await tester.pumpWidget(region(1));
    expect(builds, 2);
    expect(find.text('gen 1'), findsOneWidget);
  });

  testWidgets('an inherited dependency change rebuilds the subtree', (tester) async {
    var builds = 0;
    Color? seen;
    Widget app(Color primary) => MaterialApp(
          theme: ThemeData(colorScheme: ColorScheme.light(primary: primary)),
          home: EwtRetainedSubtree(
            generation: 0,
            builder: (context) {
              builds++;
              seen = Theme.of(context).colorScheme.primary;
              return const SizedBox();
            },
          ),
        );

    await tester.pumpWidget(app(const Color(0xFF111111)));
    expect(builds, 1);
    expect(seen, const Color(0xFF111111));
    // MaterialApp animates between themes, so the subtree is rebuilt once per animated
    // step; what matters is that it was rebuilt at all and ends on the new theme.
    await tester.pumpWidget(app(const Color(0xFF222222)));
    await tester.pumpAndSettle();
    expect(builds, greaterThan(1));
    expect(seen, const Color(0xFF222222));
  });

  testWidgets('a hot reload rebuilds the subtree', (tester) async {
    var builds = 0;
    await tester.pumpWidget(EwtRetainedSubtree(
      generation: 0,
      builder: (_) {
        builds++;
        return const SizedBox();
      },
    ));
    expect(builds, 1);
    // What reassembleApplication does to the tree, without the frame it would wait for.
    tester.binding.buildOwner!.reassemble(tester.binding.rootElement!);
    await tester.pump();
    expect(builds, 2);
  });
}
