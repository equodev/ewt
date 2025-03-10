typedef int DartObj;
typedef struct {
  struct {
    int (*of)(char* data, int* textAlign, int* textDirection, int* softWrap, int* overflow, double* textScaleFactor, int* maxLines, char** semanticsLabel, int* textWidthBasis);
    int (*rich)(DartObj textSpan, int* textAlign, int* textDirection, int* softWrap, int* overflow, double* textScaleFactor, int* maxLines, char** semanticsLabel, int* textWidthBasis);
  } text;

} WidgetFactories;
