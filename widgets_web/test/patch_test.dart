import 'package:flutter_test/flutter_test.dart';
import 'package:widgets_web/widgets_web.dart';

Map<String, dynamic> _leaf(int id, String data) =>
    {'t': 'textText', 'id': id, 'p': {'data': data}, 'c': []};

void main() {
  test('setParams at root path merges into p', () {
    final root = _leaf(1, 'old');
    final out = applyPatch(root, [
      {'path': <dynamic>[], 'set': {'data': 'new'}}
    ]);
    expect(out['p']['data'], 'new');
  });

  test('setParams into a nested child param', () {
    final root = {'t': 'centerCenter', 'id': 1, 'p': {'child': _leaf(2, 'old')}, 'c': []};
    applyPatch(root, [
      {'path': ['child'], 'set': {'data': 'new'}}
    ]);
    expect(((root['p'] as Map)['child'] as Map)['p']['data'], 'new');
  });

  test('setParams into a list element by index', () {
    final root = {
      't': 'columnColumn', 'id': 1,
      'p': {'children': [_leaf(2, 'a'), _leaf(3, 'b')]}, 'c': []
    };
    applyPatch(root, [
      {'path': ['children', 1], 'set': {'data': 'B'}}
    ]);
    expect((((root['p'] as Map)['children'] as List)[1] as Map)['p']['data'], 'B');
    expect((((root['p'] as Map)['children'] as List)[0] as Map)['p']['data'], 'a');
  });

  test('unresolvable path throws', () {
    final root = _leaf(1, 'x');
    expect(() => applyPatch(root, [
      {'path': ['nope'], 'set': {'data': 'y'}}
    ]), throwsA(anything));
  });
}
