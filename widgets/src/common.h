
#ifndef Common_h
#define Common_h

typedef int DartObj;
//typedef void (*VoidCallback)(void);
typedef DartObj (*DartObjCallback)(void);
typedef DartObj (*DartObjCallbackDartObj)(DartObj);
typedef struct {
    int size;
    DartObj* list;
} ArrayC;

#include "typedefs.h"
#include "objects.h"
#include "factories.h"

typedef int (*buildWidgetTreeFn)(WidgetFactories*);

#endif /* Common_h */
