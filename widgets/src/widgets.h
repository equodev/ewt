#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>

#if _WIN32
#include <windows.h>
// rpcndr.h (pulled in by windows.h) defines 'small' as 'char', which
// conflicts with the generated factory member name in factories.h.
#ifdef small
#undef small
#endif
#else
#include <pthread.h>
#include <unistd.h>
#endif

#if _WIN32
#define FFI_PLUGIN_EXPORT __declspec(dllexport)
#else
// Force default visibility (and keep the symbol) so it is exported even when
// the C sources are compiled with -fvisibility=hidden, as SwiftPM does.
#define FFI_PLUGIN_EXPORT __attribute__((visibility("default"))) __attribute__((used))
#endif

#include "./common.h"

// A very short-lived native function.
//
// For very short-lived functions, it is fine to call them on the main isolate.
// They will block the Dart execution while running the native function, so
// only do this for native functions which are guaranteed to be short-lived.
FFI_PLUGIN_EXPORT int sum(int a, int b);

// A longer lived native function, which occupies the thread calling it.
//
// Do not call these kind of native functions in the main isolate. They will
// block Dart execution. This will cause dropped frames in Flutter applications.
// Instead, call these native functions on a separate isolate.
FFI_PLUGIN_EXPORT int sum_long_running(int a, int b);

FFI_PLUGIN_EXPORT void setBuildWidgetTree(buildWidgetTreeFn fn);

FFI_PLUGIN_EXPORT int callToBuildWidgetTree(WidgetFactories* factories, int regionId);
