#include "widgets.h"

int (*buildWidgetTree)(WidgetFactories*, int regionId);

// A very short-lived native function.
//
// For very short-lived functions, it is fine to call them on the main isolate.
// They will block the Dart execution while running the native function, so
// only do this for native functions which are guaranteed to be short-lived.
FFI_PLUGIN_EXPORT int sum(int a, int b) { return a + b; }

// A longer-lived native function, which occupies the thread calling it.
//
// Do not call these kind of native functions in the main isolate. They will
// block Dart execution. This will cause dropped frames in Flutter applications.
// Instead, call these native functions on a separate isolate.
FFI_PLUGIN_EXPORT int sum_long_running(int a, int b) {
  // Simulate work.
#if _WIN32
  Sleep(5000);
#else
  usleep(5000 * 1000);
#endif
  return a + b;
}

FFI_PLUGIN_EXPORT void setBuildWidgetTree(buildWidgetTreeFn fn) {
    buildWidgetTree = fn;
}

FFI_PLUGIN_EXPORT int callToBuildWidgetTree(WidgetFactories* factories, int regionId) {
    return buildWidgetTree(factories, regionId);
}

static postFrameFn    g_post_frame_cb    = NULL;
static flutterErrorFn g_flutter_error_cb = NULL;
static void (*g_rebuild_handler)(void)   = NULL;

FFI_PLUGIN_EXPORT void setPostFrameCallback(postFrameFn fn) {
    g_post_frame_cb = fn;
}

FFI_PLUGIN_EXPORT void setFlutterErrorCallback(flutterErrorFn fn) {
    g_flutter_error_cb = fn;
}

FFI_PLUGIN_EXPORT void setRebuildHandler(void (*fn)(void)) {
    g_rebuild_handler = fn;
}

FFI_PLUGIN_EXPORT void callPostFrameCallback(long frameId, const char* json, int len) {
    if (g_post_frame_cb) g_post_frame_cb(frameId, json, len);
}

FFI_PLUGIN_EXPORT void callFlutterErrorCallback(long frameId, const char* kind, const char* msg, const char* st) {
    if (g_flutter_error_cb) g_flutter_error_cb(frameId, kind, msg, st);
}

FFI_PLUGIN_EXPORT void requestRebuildFromNative(void) {
    if (g_rebuild_handler) g_rebuild_handler();
}
