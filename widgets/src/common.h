
#ifndef Common_h
#define Common_h

typedef int DartObj;
//typedef void (*VoidCallback)(void);
//typedef DartObj (*DartObjCallback)(void);
//typedef DartObj (*DartObjCallbackDartObj)(DartObj);
typedef struct {
    int size;
    DartObj* list;
} ArrayC;

typedef struct {
    int key;
    DartObj value;
} EntryC;
typedef struct {
    int size;
    EntryC* entries;
} MapC;

#include "typedefs.h"
#include "objects.h"
#include "factories.h"

// regionId threads a per-EwtWidget id through the build callback so N regions map
// to N Java builders. A single global builder let regions overwrite each other
// (last one wins); the id is the SWT widget id of the hosting EwtWidget.
typedef int (*buildWidgetTreeFn)(WidgetFactories*, int regionId);

// The `long` here is C long, which is 8 bytes on Linux/macOS (LP64) and 4 on
// Windows (LLP64). EWT targets Linux/macOS only; if Windows support ever lands,
// switch to int64_t (and regenerate FFM bindings) to keep the layout stable.
typedef void (*postFrameFn)(long frameId, const char* snapshotUtf8, int snapshotLen);
typedef void (*flutterErrorFn)(long frameId, const char* kind, const char* message, const char* stack);

typedef struct StarterOpts {
    buildWidgetTreeFn buildWidgetTree;
    postFrameFn       onPostFrame;
    flutterErrorFn    onFlutterError;
} StarterOpts;

#endif /* Common_h */
