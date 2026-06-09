cmake_minimum_required(VERSION 3.14)
project(Starter LANGUAGES CXX)

add_library(Starter SHARED Starter.cpp)
apply_standard_settings(Starter)

target_include_directories(Starter PRIVATE
  "${CMAKE_CURRENT_SOURCE_DIR}/../../../src"
  "${FLUTTER_MANAGED_DIR}"
)

# flutter         - Flutter engine import lib + headers
# flutter_wrapper_app - FlutterViewController / DartProject C++ wrappers
# widgets         - provides setBuildWidgetTree (built by the FFI plugin)
target_link_libraries(Starter PRIVATE flutter flutter_wrapper_app widgets)

set_target_properties(Starter PROPERTIES OUTPUT_NAME "Starter")

install(TARGETS Starter
  RUNTIME DESTINATION "${INSTALL_BUNDLE_LIB_DIR}"
  COMPONENT Runtime)
