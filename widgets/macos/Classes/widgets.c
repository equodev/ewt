// Relative import to be able to reuse the shared C sources across platforms.
// CocoaPods does not support relative paths in `source_files`, so this Classes/
// forwarder is what the podspec globs; it in turn pulls in ../../src/widgets.c.
// See the comment in ../widgets.podspec for more information.
#include "../../src/widgets.c"
