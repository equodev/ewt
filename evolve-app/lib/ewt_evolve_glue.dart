// EWT ↔ Evolve glue (EWT side; dependency EWT → Evolve).
//
// Evolve exposes an `EwtWidget` region + an `ewtRegionBuilder` hook and knows nothing
// about EWT. This glue — the only place that imports BOTH Evolve's flutter-lib and EWT's
// widgets package — fills that hook so the region draws an EWT-built subtree. [main] calls
// [installEwtRegion] before Evolve's main(), and references this file so it survives
// tree-shaking.
import 'package:flutter/widgets.dart';
import 'package:swtflutter/src/custom/ewt_evolve.dart' as evolve;
import 'package:widgets/widgets.dart' as ewt;
import 'package:widgets/factories.dart' as ewtf;

/// Registers EWT as the provider for Evolve's EwtWidget region.
void installEwtRegion() {
  // id is the Evolve region's value.id; pass it to native so the Java side dispatches
  // to the builder that this region's EwtWidget registered (one builder per region).
  evolve.ewtRegionBuilder = (int id) {
    final int rootId = ewt.callToBuildWidgetTree(ewtf.factories, id);
    return ewtf.getWidget(rootId) as Widget;
  };
}
