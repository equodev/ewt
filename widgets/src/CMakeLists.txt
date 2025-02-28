# The Flutter tooling requires that developers have CMake 3.10 or later
# installed. You should not increase this version, as doing so will cause
# the plugin to fail to compile for some customers of the plugin.
cmake_minimum_required(VERSION 3.10)

project(widgets_library VERSION 0.0.1 LANGUAGES C)

add_library(widgets SHARED
  "widgets.c"
)

set_target_properties(widgets PROPERTIES
  PUBLIC_HEADER widgets.h
  OUTPUT_NAME "widgets"
)

target_compile_definitions(widgets PUBLIC DART_SHARED_LIB)

if (ANDROID)
  # Support Android 15 16k page size
  target_link_options(widgets PRIVATE "-Wl,-z,max-page-size=16384")
endif()
