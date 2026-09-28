// EWT ↔ Evolve glue (EWT side; dependency EWT → Evolve).
// Fills Evolve's ewtRegionBuilder hook. The concrete builder is chosen at compile time:
// native uses FFM/FFI; web uses Evolve's comm. The conditional import guarantees the web
// build never pulls in the FFI plugin.
import 'package:swtflutter/src/custom/ewt_evolve.dart' as evolve;

// java-11 split: desktop (native) renders EWT over comm too (java<22 has no FFM), so both native and
// web use a comm-fed region. ewt_region_native.dart pulls no dart:ffi, so it loads on any JVM.
import 'ewt_region_native.dart' if (dart.library.js_interop) 'ewt_region_web.dart' as region;

/// Registers EWT as the provider for Evolve's EwtWidget region.
void installEwtRegion() {
  evolve.ewtRegionBuilder = (int id) => region.buildEwtRegion(id);
}
