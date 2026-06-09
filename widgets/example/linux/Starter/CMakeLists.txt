cmake_minimum_required(VERSION 3.13)
project(Starter LANGUAGES CXX)

add_library(Starter SHARED Starter.cc)
apply_standard_settings(Starter)

# GTK include dirs are needed so that flutter_linux/flutter_linux.h can
# resolve its own transitive GTK type definitions at compile time.
# We do NOT link against GTK — it is loaded at runtime via dlopen.
find_package(PkgConfig REQUIRED)
pkg_check_modules(GTK REQUIRED gtk+-3.0)

target_include_directories(Starter PRIVATE
  "${CMAKE_CURRENT_SOURCE_DIR}/../../../src"
  "${FLUTTER_MANAGED_DIR}"
  ${GTK_INCLUDE_DIRS}
)

# ${CMAKE_DL_LIBS} = -ldl (provides dlopen/dlsym)
target_link_libraries(Starter PRIVATE flutter widgets ${CMAKE_DL_LIBS})

set_target_properties(Starter PROPERTIES OUTPUT_NAME "Starter")

install(TARGETS Starter
  LIBRARY DESTINATION "${INSTALL_BUNDLE_LIB_DIR}"
  COMPONENT Runtime)
