// EWT ↔ Evolve glue (EWT side; dependency EWT → Evolve).
// Fills Evolve's ewtRegionBuilder hook. The concrete builder is chosen at compile time:
// native uses FFM/FFI; web uses Evolve's comm. The conditional import guarantees the web
// build never pulls in the FFI plugin.
import 'package:swtflutter/src/custom/ewt_evolve.dart' as evolve;

import 'ewt_region_ffi.dart' if (dart.library.js_interop) 'ewt_region_web.dart' as region;

/// Registers EWT as the provider for Evolve's EwtWidget region.
void installEwtRegion() {
  evolve.ewtRegionBuilder = (int id) => region.buildEwtRegion(id);
}
