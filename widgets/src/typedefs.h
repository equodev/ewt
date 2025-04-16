typedef DartObj (*TransitionBuilderFFI)(DartObj context, DartObj child);
typedef void (*VoidCallbackFFI)(void);
typedef void (*ValueChangedForBoolFFI)(int value);
typedef void (*DrawerCallbackFFI)(int isOpened);
typedef char* (*GenerateAppTitleFFI)(DartObj context);
typedef void (*VoidCallbackDartObjFFI)(DartObj );
typedef DartObj (*DartObjCallbackDartObjFFI)(DartObj );
typedef DartObj (*DartObjCallbackFFI)(void);
