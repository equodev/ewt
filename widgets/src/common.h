
#ifndef Common_h
#define Common_h

struct WidgetFactories {
    int (*text)(char* data, int textDirection);
};

typedef int (*buildWidgetTreeFn)(struct WidgetFactories);

#endif /* Common_h */
