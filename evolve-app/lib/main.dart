// EWT-owned entrypoint of the combined binary (EWT → Evolve).
//
// Installs EWT as the provider for Evolve's EwtWidget region, then delegates to Evolve's
// arg-driven main() (port/widgetId/widgetName come from Evolve's Java via the engine).
// The engine runs THIS main; there is no runApp here — EWT's subtree is grafted into
// Evolve's tree at the EwtWidget node via the FFM build callback.
import 'package:swtflutter/main.dart' as evolve;

import 'ewt_evolve_glue.dart';

void main(List<String> args) {
  installEwtRegion();
  evolve.main(args);
}
