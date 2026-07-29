import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:widgets_web/widgets_web.dart';

/// Node map helper: mirrors the EwtNodeJson format produced by SerializingWidgetConstructors.
Map<String, dynamic> n(String type, Map<String, dynamic> params) =>
    {'t': type, 'id': 0, 'p': params, 'c': []};

void main() {
  // offsetTween requires an AnimationController, which needs a TickerProvider.
  // We drive it via testWidgets so the tester acts as TickerProvider.
  testWidgets('offsetTween decodes to Animation<Offset>', (tester) async {
    late Animation<Offset> anim;
    await tester.pumpWidget(
      MaterialApp(
        home: Scaffold(
          body: Builder(builder: (ctx) {
            // Set up the registry so subAnimatedStateAnimationController works.
            ewtActiveControllerRegistry = {};
            ewtActiveTickerProvider = tester;

            // Build the node tree:
            //   offsetTween(begin: Offset(0,1), end: Offset(0,0), parent: ctrl)
            final ctrlNode = n('subAnimatedStateAnimationController', {
              'ctrlId': 42,
              'self': n('subAnimatedStateSubAnimatedState', {}),
              'duration': n('durationDuration', {'milliseconds': 400}),
            });
            final result = decodeEwtNode(n('offsetTween', {
              'begin': n('offsetOffset', {'dx': 0.0, 'dy': 1.0}),
              'end': n('offsetOffset', {'dx': 0.0, 'dy': 0.0}),
              'parent': ctrlNode,
            }));
            anim = result as Animation<Offset>;
            return const SizedBox.shrink();
          }),
        ),
      ),
    );
    expect(anim, isA<Animation<Offset>>());
    // At t=0 the controller value is 0.0, so begin=Offset(0,1) is returned.
    expect(anim.value, const Offset(0.0, 1.0));
  });

  testWidgets('slideTransitionSlideTransition decodes to SlideTransition widget',
      (tester) async {
    ewtActiveControllerRegistry = {};
    ewtActiveTickerProvider = tester;

    final ctrlNode = n('subAnimatedStateAnimationController', {
      'ctrlId': 7,
      'self': n('subAnimatedStateSubAnimatedState', {}),
      'duration': n('durationDuration', {'milliseconds': 300}),
    });

    final node = n('slideTransitionSlideTransition', {
      'position': n('offsetTween', {
        'begin': n('offsetOffset', {'dx': 0.0, 'dy': 1.0}),
        'end': n('offsetOffset', {'dx': 0.0, 'dy': 0.0}),
        'parent': ctrlNode,
      }),
      'child': n('textText', {'data': 'hi'}),
    });

    await tester.pumpWidget(
      Directionality(
        textDirection: TextDirection.ltr,
        child: decodeEwtWidget(node),
      ),
    );
    expect(find.byType(SlideTransition), findsOneWidget);
    expect(find.text('hi'), findsOneWidget);
  });
}
