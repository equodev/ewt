import 'dart:convert';
import 'dart:io';
import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:widgets_web/widgets_web.dart';

void main() {
  test('profile card decodes without throwing', () {
    final jsonStr = File('test/profilecard.json').readAsStringSync();
    final root = json.decode(jsonStr) as Map<String, dynamic>;
    final w = decodeEwtWidget(root);
    expect(w, isA<Widget>());
  });
}
