#include <dlfcn.h>
#include <flutter_linux/flutter_linux.h>
#include <cstdlib>
#include <cstring>

#include "common.h"

// Runtime GTK/GLib loading — no compile-time GTK linkage.
// By the time libStarter.so is loaded, libflutter_linux_gtk.so is already
// in-process and has pulled in libgtk-3, libgobject-2.0 and libgio-2.0 as
// its own dependencies, so dlopen finds them immediately.
#define LIB_GTK3    "libgtk-3.so.0"
#define LIB_GOBJECT "libgobject-2.0.so.0"
#define LIB_GIO     "libgio-2.0.so.0"

#define LOAD_FUNCTION_LIB(var, libname, name) \
  static void* var = nullptr; \
  static void* lib_handle_##var = nullptr; \
  if (!var) { \
    if (!lib_handle_##var) lib_handle_##var = dlopen(libname, RTLD_LAZY); \
    if (lib_handle_##var) var = dlsym(lib_handle_##var, name); \
  }
#define LOAD_POINTER_FUNCTION_LIB(var, libname, name) \
  LOAD_FUNCTION_LIB(var, libname, #name)

// Provided by libwidgets.so
extern "C" void setBuildWidgetTree(buildWidgetTreeFn fn);

static char g_assets_path[4096];
static char g_icu_data_path[4096];
static char g_aot_library_path[4096];

// --- GTK wrappers (runtime-loaded, no link-time dependency) ---------------

static GtkApplication* ewt_gtk_application_new(const char* id,
                                                GApplicationFlags flags) {
  LOAD_POINTER_FUNCTION_LIB(fp, LIB_GTK3, gtk_application_new)
  return fp ? ((GtkApplication*(*)(const char*, GApplicationFlags))fp)(id, flags)
            : nullptr;
}

static GtkWidget* ewt_gtk_application_window_new(GtkApplication* app) {
  LOAD_POINTER_FUNCTION_LIB(fp, LIB_GTK3, gtk_application_window_new)
  return fp ? ((GtkWidget*(*)(GtkApplication*))fp)(app) : nullptr;
}

static void ewt_gtk_window_set_title(GtkWindow* window, const char* title) {
  LOAD_POINTER_FUNCTION_LIB(fp, LIB_GTK3, gtk_window_set_title)
  if (fp) ((void(*)(GtkWindow*, const char*))fp)(window, title);
}

static void ewt_gtk_window_set_default_size(GtkWindow* window, int w, int h) {
  LOAD_POINTER_FUNCTION_LIB(fp, LIB_GTK3, gtk_window_set_default_size)
  if (fp) ((void(*)(GtkWindow*, int, int))fp)(window, w, h);
}

static void ewt_gtk_widget_show(GtkWidget* widget) {
  LOAD_POINTER_FUNCTION_LIB(fp, LIB_GTK3, gtk_widget_show)
  if (fp) ((void(*)(GtkWidget*))fp)(widget);
}

static void ewt_gtk_container_add(GtkContainer* container, GtkWidget* widget) {
  LOAD_POINTER_FUNCTION_LIB(fp, LIB_GTK3, gtk_container_add)
  if (fp) ((void(*)(GtkContainer*, GtkWidget*))fp)(container, widget);
}

static void ewt_gtk_widget_grab_focus(GtkWidget* widget) {
  LOAD_POINTER_FUNCTION_LIB(fp, LIB_GTK3, gtk_widget_grab_focus)
  if (fp) ((void(*)(GtkWidget*))fp)(widget);
}

// --- GObject/GIO wrappers -------------------------------------------------

static gulong ewt_g_signal_connect_data(gpointer instance,
                                         const gchar* signal,
                                         GCallback handler,
                                         gpointer data,
                                         GClosureNotify destroy_data,
                                         GConnectFlags flags) {
  LOAD_POINTER_FUNCTION_LIB(fp, LIB_GOBJECT, g_signal_connect_data)
  return fp ? ((gulong(*)(gpointer, const gchar*, GCallback, gpointer,
                           GClosureNotify, GConnectFlags))fp)(
                   instance, signal, handler, data, destroy_data, flags)
            : 0;
}

static int ewt_g_application_run(GApplication* app, int argc, char** argv) {
  LOAD_POINTER_FUNCTION_LIB(fp, LIB_GIO, g_application_run)
  return fp ? ((int(*)(GApplication*, int, char**))fp)(app, argc, argv) : 1;
}

static void ewt_g_object_unref(gpointer obj) {
  LOAD_POINTER_FUNCTION_LIB(fp, LIB_GOBJECT, g_object_unref)
  if (fp) ((void(*)(gpointer))fp)(obj);
}

// --------------------------------------------------------------------------

static void on_activate(GtkApplication* app, gpointer /*user_data*/) {
  GtkWindow* window = GTK_WINDOW(ewt_gtk_application_window_new(app));
  ewt_gtk_window_set_title(window, "EWT App");
  ewt_gtk_window_set_default_size(window, 1280, 720);

  FlDartProject* project = fl_dart_project_new();

  if (g_assets_path[0] != '\0')
    fl_dart_project_set_assets_path(project, g_assets_path);
  if (g_icu_data_path[0] != '\0')
    fl_dart_project_set_icu_data_path(project, g_icu_data_path);
  if (g_aot_library_path[0] != '\0')
    fl_dart_project_set_aot_library_path(project, g_aot_library_path);

  FlView* view = fl_view_new(project);
  ewt_g_object_unref(project);  // view holds its own reference

  ewt_gtk_widget_show(GTK_WIDGET(view));
  ewt_gtk_container_add(GTK_CONTAINER(window), GTK_WIDGET(view));
  ewt_gtk_widget_show(GTK_WIDGET(window));
  ewt_gtk_widget_grab_focus(GTK_WIDGET(view));
}

extern "C" __attribute__((visibility("default")))
int startApp(buildWidgetTreeFn buildWidgetTree) {
  setBuildWidgetTree(buildWidgetTree);

  const char* ewt_home = getenv("EWT_HOME");
  if (ewt_home) {
    snprintf(g_assets_path, sizeof(g_assets_path),
      "%s/widgets/example/build/linux/x64/release/bundle/data/flutter_assets",
      ewt_home);
    snprintf(g_icu_data_path, sizeof(g_icu_data_path),
      "%s/widgets/example/build/linux/x64/release/bundle/data/icudtl.dat",
      ewt_home);
    snprintf(g_aot_library_path, sizeof(g_aot_library_path),
      "%s/widgets/example/build/linux/x64/release/bundle/lib/libapp.so",
      ewt_home);
  }

  GtkApplication* gtk_app = ewt_gtk_application_new("dev.equo.ewt",
                                                     G_APPLICATION_NON_UNIQUE);
  ewt_g_signal_connect_data(gtk_app, "activate", G_CALLBACK(on_activate),
                             nullptr, nullptr, (GConnectFlags)0);

  int argc = 0;
  int status = ewt_g_application_run(G_APPLICATION(gtk_app), argc, nullptr);
  ewt_g_object_unref(gtk_app);
  return status;
}
