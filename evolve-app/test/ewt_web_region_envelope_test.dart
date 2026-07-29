import 'package:flutter_test/flutter_test.dart';
import 'package:ewt_evolve_app/ewt_web/ewt_web_region.dart';

Map<String, dynamic> _leaf(String data) =>
    {'t': 'textText', 'id': 1, 'p': {'data': data}, 'c': []};

void main() {
  test('full envelope sets root', () {
    final out = applyEnvelope(null, {'kind': 'full', 'node': _leaf('hi')});
    expect(out.requestFull, false);
    expect(out.root!['p']['data'], 'hi');
  });

  test('patch envelope applies to existing root', () {
    final out = applyEnvelope(_leaf('old'), {
      'kind': 'patch',
      'ops': [
        {'path': <dynamic>[], 'set': {'data': 'new'}}
      ]
    });
    expect(out.requestFull, false);
    expect(out.root!['p']['data'], 'new');
  });

  test('patch with no root requests a full resend', () {
    final out = applyEnvelope(null, {'kind': 'patch', 'ops': []});
    expect(out.requestFull, true);
    expect(out.root, isNull);
  });

  test('unknown kind requests a full resend', () {
    final out = applyEnvelope({'t': 'textText', 'id': 1, 'p': {'data': 'x'}, 'c': []},
        {'kind': 'bogus'});
    expect(out.requestFull, true);
  });
}
