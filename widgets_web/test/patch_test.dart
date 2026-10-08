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
    final patched = applyPatch(root, [
      {'path': ['child'], 'set': {'data': 'new'}}
    ]);
    expect(((patched['p'] as Map)['child'] as Map)['p']['data'], 'new');
    expect(((root['p'] as Map)['child'] as Map)['p']['data'], 'old');
  });

  test('setParams into a list element by index', () {
    final root = {
      't': 'columnColumn', 'id': 1,
      'p': {'children': [_leaf(2, 'a'), _leaf(3, 'b')]}, 'c': []
    };
    final patched = applyPatch(root, [
      {'path': ['children', 1], 'set': {'data': 'B'}}
    ]);
    expect((((patched['p'] as Map)['children'] as List)[1] as Map)['p']['data'], 'B');
    expect((((patched['p'] as Map)['children'] as List)[0] as Map)['p']['data'], 'a');
    expect((((root['p'] as Map)['children'] as List)[1] as Map)['p']['data'], 'b');
  });

  test('replace puts a node in place of a child param, subtree included', () {
    final root = {'t': 'centerCenter', 'id': 1, 'p': {'child': _leaf(2, 'old')}, 'c': []};
    final column = {
      't': 'columnColumn', 'id': 2,
      'p': {'children': [_leaf(3, 'a'), _leaf(4, 'b')]}, 'c': []
    };
    final patched = applyPatch(root, [
      {'path': ['child'], 'node': column}
    ]);
    final child = (patched['p'] as Map)['child'] as Map;
    expect(child['t'], 'columnColumn');
    expect(((child['p'] as Map)['children'] as List).length, 2);
    expect(((root['p'] as Map)['child'] as Map)['t'], 'textText');
  });

  test('replace puts a node in place of a list element', () {
    final root = {
      't': 'columnColumn', 'id': 1,
      'p': {'children': [_leaf(2, 'a'), _leaf(3, 'b')]}, 'c': []
    };
    final patched = applyPatch(root, [
      {'path': ['children', 1], 'node': {'t': 'iconIcon', 'id': 9, 'p': {}, 'c': []}}
    ]);
    final children = (patched['p'] as Map)['children'] as List;
    expect((children[1] as Map)['t'], 'iconIcon');
    expect((children[0] as Map)['p']['data'], 'a');
  });

  test('set and replace in one patch apply independently', () {
    final root = {
      't': 'columnColumn', 'id': 1,
      'p': {'children': [_leaf(2, 'a'), _leaf(3, 'b')], 'spacing': 1.0}, 'c': []
    };
    final patched = applyPatch(root, [
      {'path': <dynamic>[], 'set': {'spacing': 4.0}},
      {'path': ['children', 0], 'node': _leaf(7, 'A')},
    ]);
    expect((patched['p'] as Map)['spacing'], 4.0);
    expect((((patched['p'] as Map)['children'] as List)[0] as Map)['p']['data'], 'A');
  });

  test('a splice removes and inserts list elements in place', () {
    final root = {
      't': 'listViewListView', 'id': 1,
      'p': {'children': [_leaf(2, 'x'), _leaf(3, 'y'), _leaf(4, 'z')]}, 'c': []
    };
    final patched = applyPatch(root, [
      {'path': <dynamic>[], 'list': 'children', 'at': 1, 'remove': 1, 'insert': [_leaf(9, 'Y1'), _leaf(10, 'Y2')]},
    ]);
    final children = (patched['p'] as Map)['children'] as List;
    expect(children.map((c) => (c as Map)['p']['data']).toList(), ['x', 'Y1', 'Y2', 'z']);
    expect(((root['p'] as Map)['children'] as List).length, 3);
  });

  test('ops after a splice index the list as the splice left it', () {
    final root = {
      't': 'listViewListView', 'id': 1,
      'p': {'children': [_leaf(2, 'x'), _leaf(3, 'y'), _leaf(4, 'z')]}, 'c': []
    };
    final patched = applyPatch(root, [
      {'path': <dynamic>[], 'list': 'children', 'at': 1, 'remove': 1, 'insert': <dynamic>[]},
      {'path': ['children', 1], 'set': {'data': 'Z'}},
    ]);
    final children = (patched['p'] as Map)['children'] as List;
    expect(children.map((c) => (c as Map)['p']['data']).toList(), ['x', 'Z']);
  });

  test('a splice past the end throws', () {
    final root = {'t': 'columnColumn', 'id': 1, 'p': {'children': [_leaf(2, 'x')]}, 'c': []};
    expect(() => applyPatch(root, [
      {'path': <dynamic>[], 'list': 'children', 'at': 1, 'remove': 1, 'insert': <dynamic>[]}
    ]), throwsA(anything));
  });

  test('replace at the root or at an unknown place throws', () {
    final root = {'t': 'centerCenter', 'id': 1, 'p': {'child': _leaf(2, 'x')}, 'c': []};
    expect(() => applyPatch(root, [{'path': <dynamic>[], 'node': _leaf(3, 'y')}]),
        throwsA(anything));
    expect(() => applyPatch(root, [{'path': ['nope'], 'node': _leaf(3, 'y')}]),
        throwsA(anything));
    expect(() => applyPatch(root, [{'path': ['child', 0], 'node': _leaf(3, 'y')}]),
        throwsA(anything));
  });

  test('a set op can target a node inside a map-valued param', () {
    final root = {
      't': 'materialColor', 'id': 1,
      'p': {'swatch': {'100': {'t': 'colorColor', 'id': 2, 'p': {'value': 1}, 'c': []}}}, 'c': []
    };
    final patched = applyPatch(root, [
      {'path': ['swatch', '100'], 'set': {'value': 2}},
    ]);
    expect((((patched['p'] as Map)['swatch'] as Map)['100'] as Map)['p']['value'], 2);
    expect((((root['p'] as Map)['swatch'] as Map)['100'] as Map)['p']['value'], 1);
  });

  test('a replace op can target a node inside a map-valued param', () {
    final root = {
      't': 'materialColor', 'id': 1,
      'p': {'swatch': {'100': {'t': 'colorColor', 'id': 2, 'p': {'value': 1}, 'c': []}}}, 'c': []
    };
    final patched = applyPatch(root, [
      {'path': ['swatch', '100'], 'node': {'t': 'colorFromARGB', 'id': 9, 'p': {}, 'c': []}},
    ]);
    expect((((patched['p'] as Map)['swatch'] as Map)['100'] as Map)['t'], 'colorFromARGB');
  });

  test('unresolvable path throws', () {
    final root = _leaf(1, 'x');
    expect(() => applyPatch(root, [
      {'path': ['nope'], 'set': {'data': 'y'}}
    ]), throwsA(anything));
  });
}
