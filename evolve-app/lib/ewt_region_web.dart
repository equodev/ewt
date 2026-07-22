// Web builder for an EWT region: subscribes to Evolve's comm and rebuilds from the
// serialized node tree. No dart:ffi and no package:widgets here — this file is the
// one the conditional import in ewt_evolve_glue.dart selects on web.
import 'package:flutter/widgets.dart';

import 'ewt_web/ewt_web_region.dart';

Widget buildEwtRegion(int id) => EwtWebRegion(id: id);
