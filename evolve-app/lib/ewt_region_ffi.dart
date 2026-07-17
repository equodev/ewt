// Desktop/native builder for an EWT region: builds the subtree via FFM/FFI.
// This file is selected by the conditional import in ewt_evolve_glue.dart on
// native platforms; it must never be reached on web (it pulls in dart:ffi).
import 'package:flutter/widgets.dart';
import 'package:widgets/widgets.dart' as ewt;
import 'package:widgets/factories.dart' as ewtf;

Widget buildEwtRegion(int id) {
  final int rootId = ewt.callToBuildWidgetTree(ewtf.factories, id);
  return ewtf.getWidget(rootId) as Widget;
}
