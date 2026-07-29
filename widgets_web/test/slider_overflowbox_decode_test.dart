import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:widgets_web/widgets_web.dart';

// P1: Slider and OverflowBox each had a single un-crossable optional param blocking their whole
// web decoder (Slider's SemanticFormatterCallback typedef; OverflowBox's private OverflowBoxFit
// enum). The decoder now omits that param and the widget uses its default.
void main() {
  tearDown(() => ewtActiveCallbackSink = null);

  test('Slider onChanged (a numeric value callback) is wired to the sink', () {
    final calls = <List<Object?>>[];
    ewtActiveCallbackSink = (id, args) => calls.add([id, args]);
    final node = {
      't': 'sliderSlider', 'id': 1,
      'p': {'value': 0.5, 'onChanged': 7},
    };
    final w = decodeEwtNode(node) as Slider;
    expect(w.onChanged, isNotNull);
    w.onChanged!(0.75); // a drag would call this with the new value
    expect(calls, [
      [7, [0.75]]
    ]);
  });

  test('Slider decodes (semanticFormatterCallback omitted)', () {
    final node = {
      't': 'sliderSlider', 'id': 1,
      'p': {'value': 0.5, 'onChanged': 5},
    };
    final w = decodeEwtNode(node);
    expect(w, isA<Slider>());
    expect((w as Slider).value, 0.5);
    expect(w.onChanged, isNotNull);
  });

  test('OverflowBox decodes (OverflowBoxFit omitted)', () {
    final node = {
      't': 'overflowBoxOverflowBox', 'id': 1,
      'p': {'maxWidth': 72.0, 'maxHeight': 40.0},
    };
    final w = decodeEwtNode(node);
    expect(w, isA<OverflowBox>());
    expect((w as OverflowBox).maxWidth, 72.0);
    expect(w.maxHeight, 40.0);
  });
}
