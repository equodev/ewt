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

EXPORT int  startApp(const StarterOpts* opts);
EXPORT void Starter_requestRebuild(void);
EXPORT void Starter_requestShutdown(void);

#endif /* Starter_h */
