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

# Copy Starter.dll alongside the runner binary after each build.
# Using POST_BUILD instead of install() because CMAKE_INSTALL_PREFIX contains
# a generator expression ($<TARGET_FILE_DIR:widgets_example>) that MSBuild does
# not evaluate when running cmake_install.cmake as a custom command.
add_custom_command(TARGET Starter POST_BUILD
  COMMAND ${CMAKE_COMMAND} -E copy $<TARGET_FILE:Starter>
          "$<TARGET_FILE_DIR:widgets_example>"
  COMMENT "Copying Starter.dll to runner output directory"
)
