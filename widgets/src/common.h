
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

#endif /* Common_h */
