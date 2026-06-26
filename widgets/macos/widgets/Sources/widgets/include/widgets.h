// Intentionally minimal public header.
//
// SwiftPM requires every C target to have a public headers ("include")
// directory. The widgets plugin is an FFI plugin: its symbols are resolved at
// runtime through DynamicLibrary, not imported as a Clang module, so this
// header only needs to exist to satisfy the SwiftPM C-target layout.
#ifndef WIDGETS_H_
#define WIDGETS_H_
#endif // WIDGETS_H_
