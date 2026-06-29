// swift-tools-version: 5.9
import PackageDescription

// FFI plugin: a single C-only dynamic library target. The Dart side loads the
// resulting widgets.framework via DynamicLibrary.open, so no Swift plugin class
// or FlutterFramework dependency is required here.
let package = Package(
    name: "widgets",
    platforms: [.macOS("10.15")],
    products: [
        .library(name: "widgets", type: .dynamic, targets: ["widgets"])
    ],
    targets: [
        .target(
            name: "widgets",
            path: "Sources/widgets",
            sources: ["widgets.c"]
        )
    ]
)
