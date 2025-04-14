typedef void (*DrawerCallbackFFI)(int isOpened);
typedef DartObj (*TransitionBuilderFFI)(DartObj context, DartObj child);
typedef char* (*GenerateAppTitleFFI)(DartObj context);
typedef void (*VoidCallbackFFI)(void);
typedef void (*VoidCallbackDartObjFFI)(DartObj );
typedef DartObj (*DartObjCallbackDartObjFFI)(DartObj );
typedef DartObj (*DartObjCallbackFFI)(void);
