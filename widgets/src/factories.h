typedef struct {
  struct TextSt {
    int (*text)(char* data, int* textAlign, int* textDirection, int* softWrap, int* overflow, double* textScaleFactor, int* maxLines, char* semanticsLabel, int* textWidthBasis);
    int (*rich)(DartObj textSpan, int* textAlign, int* textDirection, int* softWrap, int* overflow, double* textScaleFactor, int* maxLines, char* semanticsLabel, int* textWidthBasis);
  } text;

  struct CenterSt {
    int (*center)(double* widthFactor, double* heightFactor, DartObj* child);
  } center;

  struct AlignSt {
    int (*align)(double* widthFactor, double* heightFactor, DartObj* child);
  } align;

  struct ColumnSt {
    int (*column)(int* mainAxisAlignment, int* mainAxisSize, int* crossAxisAlignment, int* textDirection, int* verticalDirection, int* textBaseline, double* spacing, ArrayC* children);
  } column;

  struct FlexSt {
    int (*flex)(int direction, int* mainAxisAlignment, int* mainAxisSize, int* crossAxisAlignment, int* textDirection, int* verticalDirection, int* textBaseline, int* clipBehavior, double* spacing, ArrayC* children);
  } flex;

  struct AppBarSt {
    int (*appBar)(DartObj* leading, int* automaticallyImplyLeading, DartObj* title, ArrayC* actions, DartObj* flexibleSpace, DartObj* bottom, double* elevation, double* scrolledUnderElevation, int* primary, int* centerTitle, int* excludeHeaderSemantics, double* titleSpacing, double* toolbarOpacity, double* bottomOpacity, double* toolbarHeight, double* leadingWidth, int* forceMaterialTransparency, int* clipBehavior);
  } appBar;

  struct ScaffoldSt {
    int (*scaffold)(DartObj* appBar, DartObj* body, DartObj* floatingActionButton, ArrayC* persistentFooterButtons, DartObj* drawer, DartObj* endDrawer, DartObj* bottomNavigationBar, DartObj* bottomSheet, int* resizeToAvoidBottomInset, int* primary, int* drawerDragStartBehavior, int* extendBody, int* extendBodyBehindAppBar, double* drawerEdgeDragWidth, int* drawerEnableOpenDragGesture, int* endDrawerEnableOpenDragGesture, char* restorationId);
  } scaffold;

  struct MaterialAppSt {
    int (*materialApp)(DartObj* home, char* initialRoute, char* title, int* themeMode, int* debugShowMaterialGrid, int* showPerformanceOverlay, int* checkerboardRasterCacheImages, int* checkerboardOffscreenLayers, int* showSemanticsDebugger, int* debugShowCheckedModeBanner, char* restorationScopeId, int* useInheritedMediaQuery);
    int (*router)(char* title, int* themeMode, int* debugShowMaterialGrid, int* showPerformanceOverlay, int* checkerboardRasterCacheImages, int* checkerboardOffscreenLayers, int* showSemanticsDebugger, int* debugShowCheckedModeBanner, char* restorationScopeId, int* useInheritedMediaQuery);
  } materialApp;

} WidgetFactories;
