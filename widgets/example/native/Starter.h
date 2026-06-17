//
//  Starter.h
//  Starter
//
//  Created by Guillermo Zunino on 04/03/2025.
//

#ifndef Starter_h
#define Starter_h

#include "../../src/common.h"

// Export macro for macOS
#define EXPORT __attribute__((visibility("default")))

EXPORT int startApp(buildWidgetTreeFn buildWidgetTree);

EXPORT void setFlutterPaths(const char* assets_path,
                             const char* icu_path,
                             const char* aot_path);


#endif /* Starter_h */
