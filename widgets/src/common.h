
#ifndef Common_h
#define Common_h

typedef int DartObj;

typedef struct {
    int size;
    DartObj* list;
} ArrayC;

#include "factories.h"

typedef int (*buildWidgetTreeFn)(WidgetFactories);

#endif /* Common_h */
